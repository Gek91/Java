package main.java.trying.googleAPI.simpleDriveAccess;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;

public class DriveBasic {
	
	 /** Directory to store user credentials for this application. */
    private static final java.io.File DATA_STORE_DIR = new java.io.File(System.getProperty("user.home"), ".credentials/drive-java-quickstart");
	
	/** Global instance of the {@link FileDataStoreFactory}. */
    private static FileDataStoreFactory DATA_STORE_FACTORY;
	
	/** Application name. */
    private static final String APPLICATION_NAME = "prova-api-gek";
	
    private static HttpTransport HTTP_TRANSPORT;
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
		    
    /** Global instance of the scopes required by this quickstart.
    *
    * If modifying these scopes, delete your previously saved credentials
    * at ~/.credentials/drive-java-quickstart
    */
   private static final List<String> SCOPES = Arrays.asList(DriveScopes.DRIVE_METADATA_READONLY);
    
    static {
        try {
            HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
            DATA_STORE_FACTORY = new FileDataStoreFactory(DATA_STORE_DIR);
        } catch (Throwable t) {
            t.printStackTrace();
            System.exit(1);
        }
    }
    
    public static Credential authorize() throws Exception {
    	
    	 InputStream in = null; //= DriveBasic.class.getResourceAsStream("/resources/client_secret.json");
    	 
    	 try {
    		 in = new FileInputStream("Solving/resources/client_secret.json");

    		  
    		} catch (FileNotFoundException e) {
    		    // TODO Auto-generated catch block
    		    e.printStackTrace();
    		} catch (IOException e) {
    		    // TODO Auto-generated catch block
    		    e.printStackTrace();
    		}
    	 
    	 GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

        // Build flow and trigger user authorization request.
        GoogleAuthorizationCodeFlow flow = 
        		new GoogleAuthorizationCodeFlow.Builder(HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
    	                .setDataStoreFactory(DATA_STORE_FACTORY)
    	                .setAccessType("offline") //installed application. online or webapplication
    	                .build();
        
        Credential credential = new AuthorizationCodeInstalledApp ( flow, new LocalServerReceiver()).authorize("user");
        
        System.out.println("Credentials saved to " + DATA_STORE_DIR.getAbsolutePath());
        
        in.close();
        
        return credential;
    	
    }
    
	public static Drive buildDriveService() throws Exception {
		
		Drive driveService = null;
			
//		InputStream in = new FileInputStream("Solving/resources/client_secret.json");
		
//		GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY,  new InputStreamReader(in)) ;
		
//		Credential googleCredeintal = new GoogleCredential.Builder()
//											.setTransport(HTTP_TRANSPORT)
//											.setJsonFactory(JSON_FACTORY)
//											.setClientSecrets(clientSecrets)
//											.build();
													
		
		//Incremental BackOff
		HttpRequestInitializer httpRequestInitialaizer = new RetryHttpInitializerWrapper(authorize());
		
		driveService = new Drive.Builder(HTTP_TRANSPORT, JSON_FACTORY, httpRequestInitialaizer).setApplicationName(APPLICATION_NAME).build();
		
		return driveService;
	}
	
	public static Drive buildDriveServiceWithServiceAccount() throws Exception {
		
		Drive driveService = null;
			
		java.io.File in = new java.io.File("Solving/resources/service-account-key.p12");
				
		Credential googleCredeintal = new GoogleCredential.Builder()
											.setTransport(HTTP_TRANSPORT)
											.setJsonFactory(JSON_FACTORY)
											.setServiceAccountId("prova-api@prova-api-gek.iam.gserviceaccount.com")
											.setServiceAccountUser("gek.pandini@gmail.com")
											.setServiceAccountScopes(SCOPES)
											.setServiceAccountPrivateKeyFromP12File(in)
											.build();
													
		
		//Incremental BackOff
		HttpRequestInitializer httpRequestInitialaizer = new RetryHttpInitializerWrapper(googleCredeintal);
		
		driveService = new Drive.Builder(HTTP_TRANSPORT, JSON_FACTORY, httpRequestInitialaizer).setApplicationName(APPLICATION_NAME).build();
		
		return driveService;
	}
	
	public static void main(String[] args) throws Exception {
				
		Drive service = buildDriveService();
		
		FileList result = service.files().list()
					.setPageSize(10)
					.setFields("nextPageToken, files(id, name)")
					.execute();
		
		List<File> files = result.getFiles();
		
		if(files == null || files.size() == 0) {
			System.out.println("No files found.");
		} else {
			System.out.println("Files:");
			for(File file : files) {
				System.out.printf("%s (%s)\n", file.getName(), file.getId());
			}
		}
	}
}
