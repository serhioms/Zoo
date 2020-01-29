import java.lang.reflect.Array;


public class Generics {

	public static <T,U> T[] copyOf(U[] original, int newLength, Class<? extends T[]> newType) {

		 T[] copy = ((Object)newType == (Object)Object[].class)
				 ? (T[]) new Object[newLength]
				 : (T[]) Array.newInstance(newType.getComponentType(), newLength);

		   Math.min(original.length, newLength);

		   System.arraycopy(original, 0, copy, 0, 0);

		 return copy;

		}

}
