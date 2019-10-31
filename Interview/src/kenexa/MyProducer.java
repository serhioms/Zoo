package kenexa;

public class MyProducer {

	// javax.enterprise.inject.spi.Producer<> producer;
	
	/*
	 *  void				dispose				(T instance)
	 * 	Set<InjectionPoint>	getInjectionPoints	()
	 * 	T					produce				(CreationalContext<T> ctx)
	 */
	
	java.util.function.Supplier<Integer> supplier;
	java.util.function.Consumer<Integer> consumer;
	java.util.function.Predicate<Integer> predicate;
	java.util.function.UnaryOperator<Integer> operator;
	java.util.function.LongFunction<Integer> function;
}
