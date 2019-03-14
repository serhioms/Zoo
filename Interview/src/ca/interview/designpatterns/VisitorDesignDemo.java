package ca.interview.designpatterns;

public class VisitorDesignDemo {

	static public interface ComputerPart {
		public void accept(ComputerPartVisitor computerPartVisitor);
	}

	static public class Keyboard implements ComputerPart {

		@Override
		public void accept(ComputerPartVisitor computerPartVisitor) {
			computerPartVisitor.visit(this);
		}
	}

	static public class Monitor implements ComputerPart {

		@Override
		public void accept(ComputerPartVisitor computerPartVisitor) {
			computerPartVisitor.visit(this);
		}
	}

	static public class Mouse implements ComputerPart {

		@Override
		public void accept(ComputerPartVisitor computerPartVisitor) {
			computerPartVisitor.visit(this);
		}
	}

	static public class Computer implements ComputerPart {

		ComputerPart[] parts;

		public Computer() {
			parts = new ComputerPart[] { new Mouse(), new Keyboard(), new Monitor() };
		}

		@Override
		public void accept(ComputerPartVisitor computerPartVisitor) {
			for (int i = 0; i < parts.length; i++) {
				parts[i].accept(computerPartVisitor);
			}
			computerPartVisitor.visit(this);
		}
	}

	static public interface ComputerPartVisitor {
		public void visit(Computer computer);

		public void visit(Mouse mouse);

		public void visit(Keyboard keyboard);

		public void visit(Monitor monitor);
	}

	static public class ComputerPartDisplayVisitor implements ComputerPartVisitor {

		@Override
		public void visit(Computer computer) {
			System.out.println("Displaying Computer.");
		}

		@Override
		public void visit(Mouse mouse) {
			System.out.println("Displaying Mouse.");
		}

		@Override
		public void visit(Keyboard keyboard) {
			System.out.println("Displaying Keyboard.");
		}

		@Override
		public void visit(Monitor monitor) {
			System.out.println("Displaying Monitor.");
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ComputerPart computer = new Computer();
		computer.accept(new ComputerPartDisplayVisitor());
	}
}
