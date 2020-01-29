package kenexa;

import java.util.function.Consumer;

public class MainConsumer {

	public static void main(String[] args) {
		Consumer<String> consumer = MainConsumer::showConsumer;
		
		consumer.accept("1");
		consumer.accept("2");
		consumer.accept("3");
	}

	
	public static void showConsumer(String name) {
		System.out.println(name);
	}
}
