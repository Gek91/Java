package trying.designPattern.creationalPattern;

public class FactoryMethod {

	public static void main(String[] args){
		AbstractLoggerCreator creator = new XMLLoggerCreator();
		Client client = new Client();
		client.someMethodThatLogs(creator);
	}
}


//Abstract Product
interface Logger {
	public void log(String message);
}


//Concrete product
class XMLLogger implements Logger {
	public void log(String message) {
		System.out.println("XMLLogger :" + message);
	}
}


//Abstract Creator
abstract class AbstractLoggerCreator { 
	
	public abstract Logger createLogger();
	
	public Logger getLogger() {
		Logger logger = createLogger();
		
		return logger;
	}
	
}


//Concrete Creator
class XMLLoggerCreator extends AbstractLoggerCreator {
	
	public Logger createLogger() {
		return new XMLLogger();
	}
}


//Client
class Client {
	
	public void someMethodThatLogs(AbstractLoggerCreator logCreator){
		Logger logger = logCreator.createLogger();
		logger.log("message");
	}
	
}