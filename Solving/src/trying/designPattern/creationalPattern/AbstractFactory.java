package trying.designPattern.creationalPattern;

//Main
public class AbstractFactory {

	public static void main(String[] args) {
		String platform = "ciao";
		
		GUIBuilder builder = new GUIBuilder();
		AbstractWidgetFactory widgetFactory = null;
		
		if(platform =="MACOSX") {
			widgetFactory = new MacWindowWidgetFactory();
		} else {
			widgetFactory = new MSWindowWidgetFactory();
		}
		
		builder.buildWindow(widgetFactory);
	}
	
}


//Abstract Product
interface Window {
	public void setTitle(String text);
	public void repaint();
}


//Concrete Products
class MSWindow implements Window {
	public void setTitle(String text) {  System.out.println("MSWindow setTitle() : " + text); }
	public void repaint() { System.out.println("MSWindow repaint()");}
}

class MacWindow implements Window {
	public void setTitle(String text) { System.out.println("MacWindow setTitle() : " + text); }
	public void repaint() { System.out.println("MacWindow repaint()"); }
}


//Abstract Factory
interface AbstractWidgetFactory {
	public Window createWindow();
}


//Concrete Factory
class MSWindowWidgetFactory implements AbstractWidgetFactory {
	public Window createWindow() { return new MSWindow(); }
}

class MacWindowWidgetFactory implements AbstractWidgetFactory {
	public Window createWindow() { return new MacWindow(); }
}


//Client
class GUIBuilder {
	public void buildWindow(AbstractWidgetFactory widgetFactory) {
		Window window = widgetFactory.createWindow();
		window.setTitle("New Window");
	}
}