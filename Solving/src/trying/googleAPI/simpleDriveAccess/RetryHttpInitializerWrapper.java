package trying.googleAPI.simpleDriveAccess;

import java.io.IOException;
import java.util.logging.Logger;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.http.HttpBackOffIOExceptionHandler;
import com.google.api.client.http.HttpBackOffUnsuccessfulResponseHandler;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpUnsuccessfulResponseHandler;
import com.google.api.client.util.ExponentialBackOff;
import com.google.api.client.util.Sleeper;
import com.google.common.base.Preconditions;

/*
 * Taken here : https://cloud.google.com/storage/transfer/create-client
 * 
 * @author Gek
 *
 */

public class RetryHttpInitializerWrapper implements HttpRequestInitializer{
	
	 private static final Logger LOG = Logger.getLogger(RetryHttpInitializerWrapper.class.getName());
	  private final Credential wrappedCredential;
	  private final Sleeper sleeper;
	  private static final int MILLIS_PER_MINUTE = 60 * 1000;
	
	  /**
	   * A constructor using the default Sleeper.
	   *
	   * @param wrappedCredential
	   *          the credential used to authenticate with a Google Cloud Platform project
	   */
	  public RetryHttpInitializerWrapper(Credential wrappedCredential) {
	    this(wrappedCredential, Sleeper.DEFAULT);
	  }

	  /**
	   * A constructor used only for testing.
	   *
	   * @param wrappedCredential
	   *          the credential used to authenticate with a Google Cloud Platform project
	   * @param sleeper
	   *          a user-supplied Sleeper
	   */
	  RetryHttpInitializerWrapper(Credential wrappedCredential, Sleeper sleeper) {
	    this.wrappedCredential = Preconditions.checkNotNull(wrappedCredential);
	    this.sleeper = sleeper;
	  }
	  
	 /*
	   * Initialize an HttpRequest.
	   *
	   * @param request
	   *          an HttpRequest that should be initialized
	   */
	@Override
	public void initialize(HttpRequest request) {
		
		request.setReadTimeout(2 * MILLIS_PER_MINUTE); // 2 minutes read timeout
		
	    final HttpUnsuccessfulResponseHandler backoffHandler = new HttpBackOffUnsuccessfulResponseHandler(new ExponentialBackOff()).setSleeper(sleeper);
	    
	    request.setInterceptor(wrappedCredential);
	    
	    request.setUnsuccessfulResponseHandler(new HttpUnsuccessfulResponseHandler() {
	    	
	    	@Override
	        public boolean handleResponse(final HttpRequest request, final HttpResponse response, final boolean supportsRetry) throws IOException {
	        	  
	    		if (wrappedCredential.handleResponse(request, response, supportsRetry)) {
	            	
	    			// If credential decides it can handle it, the return code or message indicated
	    			// something specific to authentication, and no backoff is desired.
	    			return true;
	              
	    		} else if (backoffHandler.handleResponse(request, response, supportsRetry)) {
	            	
	    			// Otherwise, we defer to the judgement of our internal backoff handler.
	    			LOG.info("Retrying " + request.getUrl().toString());
	    			return true;
	              
	            } else {
	            	return false;
	            }
	            
	    	}
	          
	    });
	    
	    request.setIOExceptionHandler(new HttpBackOffIOExceptionHandler(new ExponentialBackOff()).setSleeper(sleeper));
	    
	  }
}
