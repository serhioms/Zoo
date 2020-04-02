package ca.mss.test;
import ca.mss.pojotrans.gen.ClassTreeTraversal;
import ca.mss.test.pojo.src.complex.ComplexSource;
public class TraversExample {
	public static void main(String[] args){
		System.out.printf("%15s\t%5s\t%40s\t%7s\t%7s\t%5s\t%s\n","what", "level", "name", "isFirst", "isList", "expr", "type");
		ClassTreeTraversal.travers(ComplexSource.class,
				(what, level, name, isFirst, isList, expr, type)->{
					switch( what ){
					case Start:
					case End:
					case ListEnd:
					case ListStart:
					case PrimitiveType:
						System.out.printf("%15s\t%5s\t%40s\t%7s\t%7s\t%5s\t%s\n",what, level, name, isFirst, isList, expr, type);
					}
				}
			);
	}
}