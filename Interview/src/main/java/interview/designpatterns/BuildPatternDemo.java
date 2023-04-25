package interview.designpatterns;

import java.util.ArrayList;
import java.util.List;

public class BuildPatternDemo {

	// Step 1
	// Create an interface Item representing food item and packing.

	static public interface Item {
		public String name();

		public Packing packing();

		public float price();
	}

	static public interface Packing {
		public String pack();
	}

	// Step 2
	// Create concreate classes implementing the Packing interface.

	static public class Wrapper implements Packing {

		@Override
		public String pack() {
			return "Wrapper";
		}
	}

	static public class Bottle implements Packing {

		@Override
		public String pack() {
			return "Bottle";
		}
	}

	// Step 3
	// Create abstract classes implementing the item interface providing default
	// functionalities.

	static public abstract class Burger implements Item {

		@Override
		public Packing packing() {
			return new Wrapper();
		}

		@Override
		public abstract float price();
	}

	static public abstract class ColdDrink implements Item {

		@Override
		public Packing packing() {
			return new Bottle();
		}

		@Override
		public abstract float price();
	}

	// Step 4
	// Create concrete classes extending Burger and ColdDrink classes

	static public class VegBurger extends Burger {

		@Override
		public float price() {
			return 25.0f;
		}

		@Override
		public String name() {
			return "Veg Burger";
		}
	}

	static public class ChickenBurger extends Burger {

		@Override
		public float price() {
			return 50.5f;
		}

		@Override
		public String name() {
			return "Chicken Burger";
		}
	}

	static public class Coke extends ColdDrink {

		@Override
		public float price() {
			return 30.0f;
		}

		@Override
		public String name() {
			return "Coke";
		}
	}

	static public class Pepsi extends ColdDrink {

		@Override
		public float price() {
			return 35.0f;
		}

		@Override
		public String name() {
			return "Pepsi";
		}
	}

	// Step 5
	// Create a Meal class having Item objects defined above.

	static public class Meal {
		private List<Item> items = new ArrayList<Item>();

		public void addItem(Item item) {
			items.add(item);
		}

		public float getCost() {
			float cost = 0.0f;
			for (Item item : items) {
				cost += item.price();
			}
			return cost;
		}

		public void showItems() {
			for (Item item : items) {
				System.out.print("Item : " + item.name());
				System.out.print(", Packing : " + item.packing().pack());
				System.out.println(", Price : " + item.price());
			}
		}
	}

	// Step 6
	// Create a MealBuilder class, the actual builder class responsible to
	// create Meal objects.

	static public class MealBuilder {

		public Meal prepareVegMeal() {
			Meal meal = new Meal();
			meal.addItem(new VegBurger());
			meal.addItem(new Coke());
			return meal;
		}

		public Meal prepareNonVegMeal() {
			Meal meal = new Meal();
			meal.addItem(new ChickenBurger());
			meal.addItem(new Pepsi());
			return meal;
		}
	}

	// Step 7
	// BuiderPatternDemo uses MealBuider to demonstrate builder pattern.

	public static void main(String[] args) {
		MealBuilder mealBuilder = new MealBuilder();

		Meal vegMeal = mealBuilder.prepareVegMeal();
		System.out.println("Veg Meal");
		vegMeal.showItems();
		System.out.println("Total Cost: " + vegMeal.getCost());

		Meal nonVegMeal = mealBuilder.prepareNonVegMeal();
		System.out.println("\n\nNon-Veg Meal");
		nonVegMeal.showItems();
		System.out.println("Total Cost: " + nonVegMeal.getCost());
	}
}
