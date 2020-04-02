package ca.mss.pojotrans.gen;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Set;

public class ClassTreeTraversal {

	private ClassTreeTraversal() {
	}

	public static void travers(Class<?> clazz, ClassVisitor visitor){
		travers(clazz, 0, visitor);
	}
	
	public static interface ClassVisitor {
		public void visit(ClassThing what, int level, String name, boolean isFirst, boolean isList, Set<String> expr, String type);
	}
	
	public enum ClassThing {
		Start, End, PrimitiveType, ListStart, ListEnd
		;
	}

	private static void travers(Class<?> clazz, int tab, ClassVisitor visitor){
 		visitor.visit(ClassThing.Start, tab, null, false, false, null, null);
 		{
 			Field[] fields = clazz.getDeclaredFields();
 			int count = 0;
			for (Field field : fields) {
				try {
					traversField(field, tab+1, ++count == 1, new HashSet<String>(), visitor);
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			}
 		}
 		visitor.visit(ClassThing.End, tab, null, false, false, null, null);
	}
	
	private static void extractLeafs(Field field, Set<String> expr) throws ClassNotFoundException {
		extractLeafs(field.getName(), field.getType(), field.getGenericType(), expr);
	}

	private static void extractLeafs(String name, Class<?> clazz, Type genType, Set<String> expr) throws ClassNotFoundException {
		switch(clazz.getTypeName()){
		case "java.lang.String":
		case "java.lang.Boolean":
		case "java.lang.Integer":
		case "java.lang.Long":
		case "java.lang.Double":
		case "java.util.Date":
			expr.add(name);
	 		break;
		case "java.util.List":
			if (genType instanceof ParameterizedType){
				ParameterizedType pType = (ParameterizedType )genType;
				Type type = (pType.getActualTypeArguments())[0];
				clazz = TransformationMapGen.class.getClassLoader().loadClass(type.getTypeName());
				extractLeafs(name, clazz, clazz.getGenericSuperclass(), expr);
			} else {
				throw new RuntimeException("Unexpected generic type: "+genType);
			}
			break;
		default: 
			for (Field field : clazz.getDeclaredFields()) {
				extractLeafs(field, expr);
			}
	 		break;
		}
	}

	private static void traversField(Field fieldClass, int tab, boolean isFirst, Set<String> expr, ClassVisitor visitor) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
 		traversField(fieldClass.getName(), fieldClass.getType(), fieldClass.getGenericType(), tab, isFirst, expr, false, visitor);
	}

	private static void traversField(String name, Class<?> clazz, Type genType, int tab, boolean isFirst, Set<String> expr, boolean isList, ClassVisitor visitor) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		switch(clazz.getTypeName()){
		case "java.util.HashMap":
		case "java.util.GregorianCalendar":
		case "java.math.BigInteger":
		case "boolean":
		case "int":
		case "long":
		case "double":
		case "java.lang.String":
		case "java.lang.Boolean":
		case "java.lang.Integer":
		case "java.lang.Long":
		case "java.lang.Double":
		case "java.util.Date":
	 		visitor.visit(ClassThing.PrimitiveType, tab, name, isFirst, isList, expr, clazz.getTypeName());
	 		break;
		case "java.util.Map":
			if (genType instanceof ParameterizedType){
				ParameterizedType pType = (ParameterizedType )genType;
				Type type = (pType.getActualTypeArguments())[0];
				clazz = TransformationMapGen.class.getClassLoader().loadClass(type.getTypeName());
				traversField(name, clazz, clazz.getGenericSuperclass(), tab, isFirst, expr, true, visitor);
			} else {
		 		visitor.visit(ClassThing.PrimitiveType, tab, name, isFirst, isList, expr, "java.util.HashMap");
			}
	 		break;
		case "java.util.List":
			if (genType instanceof ParameterizedType){
				ParameterizedType pType = (ParameterizedType )genType;
				Type type = (pType.getActualTypeArguments())[0];
				clazz = TransformationMapGen.class.getClassLoader().loadClass(type.getTypeName());
				traversField(name, clazz, clazz.getGenericSuperclass(), tab, isFirst, expr, true, visitor);
			} else {
				throw new RuntimeException("Expected parametrized List: "+genType);
			}
			break;
		default:
	 		visitor.visit(ClassThing.ListStart, tab, name, isFirst, isList, expr, clazz.getTypeName());
			{	 		
	 			int count = 0;
				for (Field field : clazz.getDeclaredFields()) {
					traversField(field, tab+1, ++count == 1, expr, visitor);
				}
			}
			visitor.visit(ClassThing.ListEnd, tab, name, isFirst, isList, expr, clazz.getTypeName());
	 		break;
		}
	}
}