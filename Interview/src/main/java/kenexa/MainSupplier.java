package kenexa;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class MainSupplier {

	public static void main(String[] args) {
		
		List<String> users = Arrays.asList("1","2","3");
		
		users.stream().forEach((name)->{
			showSupplier(()->name);
		});
		
	}

	
	public static void showSupplier(Supplier<String> name) {
		System.out.println(name.get());
	}
}
