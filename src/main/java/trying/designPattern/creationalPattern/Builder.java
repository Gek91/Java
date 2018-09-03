package main.java.trying.designPattern.creationalPattern;

//Main
public class Builder {

	public static void main(String[] args) {
		
		Cook cook = new Cook();
		
		Pizza pizza = cook.constructPizza(new HawaiianPizzaBuilder());
		pizza.myPizza();
		
		pizza = cook.constructPizza(new SpicyPizzaBuilder());
		pizza.myPizza();
	}
}


//Product
class Pizza {
	private String dough;
	private String sauce;
	private String topping;
	
	public void myPizza() { 
		System.out.println("My pizza: Dough "+ this.getDough() + " sauce " + this.getSauce() + " topping " + this.getTopping());
	}
	
	public String getDough() {
		return dough;
	}
	public String getSauce() {
		return sauce;
	}
	public String getTopping() {
		return topping;
	}
	public void setDough(String dough) {
		this.dough = dough;
	}
	public void setSauce(String sauce) {
		this.sauce = sauce;
	}
	public void setTopping(String topping) {
		this.topping = topping;
	}
	
}


//Abstract builder
abstract class PizzaBuilder {
	
	public Pizza createNewPizza() {
		
		Pizza pizza = new Pizza();
				
		return pizza;
	}
	
	protected abstract void buildDough(Pizza pizza);
	protected abstract void buildSauce(Pizza pizza);
	protected abstract void buildTopping(Pizza pizza);
}


//Concrete builder
class HawaiianPizzaBuilder extends PizzaBuilder {
	
	protected void buildDough(Pizza pizza) { pizza.setDough("cross"); }
	protected void buildSauce(Pizza pizza) { pizza.setSauce("mild"); }
	protected void buildTopping(Pizza pizza) { pizza.setTopping("pineapple"); }
	
}

class SpicyPizzaBuilder extends PizzaBuilder {
	
	protected void buildDough(Pizza pizza) { pizza.setDough("pan baked"); }
	protected void buildSauce(Pizza pizza) { pizza.setSauce("hot"); }
	protected void buildTopping(Pizza pizza) { pizza.setTopping("salami"); }
}


//Director
class Cook {
	
	public Pizza constructPizza(PizzaBuilder builder) {
		
		Pizza pizza = builder.createNewPizza();
		builder.buildDough(pizza);
		builder.buildSauce(pizza);
		builder.buildTopping(pizza);
		
		return pizza;
	}
}