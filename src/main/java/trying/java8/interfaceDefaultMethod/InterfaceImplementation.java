package trying.java8.interfaceDefaultMethod;

public class InterfaceImplementation implements InterfaceWithMethod{

	@Override
	public Long interfaceMethod() {
		return 3L;
	}
	
	public static void main(String[] args) {
		
		InterfaceImplementation obj = new InterfaceImplementation();
		
		obj.interfaceMethod();
		
		obj.defaultMethod();
		
		InterfaceWithMethod.staticMethod();
	}
	
}
