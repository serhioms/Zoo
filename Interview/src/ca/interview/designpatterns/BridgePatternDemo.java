package ca.interview.designpatterns;

public class BridgePatternDemo {

	// Step 1
	// Create bridge implementer interface.

	static public interface DrawAPI {
		public void drawCircle(int radius, int x, int y);
	}

	// Step 2
	// Create concrete bridge implementer classes implementing the DrawAPI
	// interface.

	static public class RedCircle implements DrawAPI {
		@Override
		public void drawCircle(int radius, int x, int y) {
			System.out.println("Drawing Circle[ color: red, radius: " + radius + ", x: " + x + ", " + y + "]");
		}
	}

	static public class GreenCircle implements DrawAPI {
		@Override
		public void drawCircle(int radius, int x, int y) {
			System.out.println("Drawing Circle[ color: green, radius: " + radius + ", x: " + x + ", " + y + "]");
		}
	}

	// Step 3
	// Create an abstract class Shape using the DrawAPI interface.

	static public abstract class Shape {
		protected DrawAPI drawAPI;

		protected Shape(DrawAPI drawAPI) {
			this.drawAPI = drawAPI;
		}

		public abstract void draw();
	}

	// Step 4
	// Create concrete class implementing the Shape interface.

	static public class Circle extends Shape {
		private int x, y, radius;

		public Circle(int x, int y, int radius, DrawAPI drawAPI) {
			super(drawAPI);
			this.x = x;
			this.y = y;
			this.radius = radius;
		}

		public void draw() {
			drawAPI.drawCircle(radius, x, y);
		}
	}

	// Step 5
	// Use the Shape and DrawAPI classes to draw different colored circles.

	public static void main(String[] args) {
		Shape redCircle = new Circle(100, 100, 10, new RedCircle());
		Shape greenCircle = new Circle(100, 100, 10, new GreenCircle());

		redCircle.draw();
		greenCircle.draw();
	}
}
