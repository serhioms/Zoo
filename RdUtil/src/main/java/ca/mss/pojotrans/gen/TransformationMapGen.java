package ca.mss.pojotrans.gen;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Properties;

public class TransformationMapGen {

	static Properties dictionary = new Properties();
	static Map<String,List<String>> sourceleafs = new HashMap<>();
	
	public static void main(String[] args){
		
		String destFileName =	Optional.of(args).flatMap(a->a.length>0?Optional.of(a[0]):Optional.empty()).orElse("MapperComplexTarget.gen.json");
		String destClazzName =	Optional.of(args).flatMap(a->a.length>1?Optional.of(a[1]):Optional.empty()).orElse("ca.mss.test.pojo.dest.complex.ComplexTarget");
		String dictionaryFile =	Optional.of(args).flatMap(a->a.length>2?Optional.of(a[2]):Optional.empty()).orElse("TransformerDictionary.properties");
		String srcClazzName =	Optional.of(args).flatMap(a->a.length>3?Optional.of(a[3]):Optional.empty()).orElse("ca.mss.test.pojo.src.complex.ComplexSource");

		readDictionary(dictionary, dictionaryFile);
		
		if( !dictionary.isEmpty() ){
			readLeafs(srcClazzName);
		}
		
		generate(destFileName, destClazzName);
	}
	
	private static void readLeafs(String srcClazzName) {
		try {
			Class<?> clazz = Class.forName(srcClazzName);
			
			List<String> stack = new ArrayList<>(100);
			readLeafs(stack, clazz);
		} catch (ClassNotFoundException e) {
			System.out.printf("Can not find source class %s\n", srcClazzName);
		}
	}

	private static void readLeafs(List<String> stack, Class<?> clazz) {
		ClassTreeTraversal.travers(clazz,
				(what, level, name, isFirst, isList, expr, type)->{
					switch( what ){
					case ListEnd:
						stack.remove(stack.size()-1);
						break;
					case ListStart:
						String leaf1 = stack.isEmpty()?prop2(name): ": {\n"+"EXTRATABS"+tab(level) + prop2(name);
						stack.add(leaf1);
						//System.out.println(leaf1);
						break;
					case PrimitiveType:
						leaf1 = tab(level) + prop2(name);
						stack.add(leaf1);
						//System.out.println(leaf1);
						String leaf2 = makeLeaf(stack);
						if( leaf2 != null ){
							//System.out.println(name+"|"+leaf2);
							addleaf(name, leaf2);
							stack.remove(stack.size()-1);
						}
						break;
					}
				}
			);
	}

	private static void addleaf(String name, String leaf2) {
		List<String> list = sourceleafs.get(name);
		if( list == null ){
			list = new ArrayList<>();
			sourceleafs.put(name, list);
		}
		list.add(leaf2);
	}

	private static String makeLeaf(List<String> stack) {
		if( stack.size() > 1){
			String strleaf = "";
			int max=stack.size()-1;
			for(int i=0; i<max; i++){
				strleaf += stack.get(i);
			}
			strleaf += ": "+"\"${"+clean2(stack.get(max).trim())+"}\"";
			for(int i=max-1; i>0; i--){
				strleaf += "\nEXTRATABS"+tab(i)+"}";
			}
			return strleaf;
		}
		return null;
	}

	private static void readDictionary(Properties prop, String propFile) {
		InputStream input = null;

		try {

			input = new FileInputStream(propFile);
			prop.load(input);

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private static String getSynonym(int level, String name, String def){
		String synonym = dictionary.getProperty(name);
		if( synonym != null ){
			List<String> list = sourceleafs.get(synonym);
			if( list != null ){
				String str = " {";
				for(int i=0,max=list.size(); i<max; i++){
					String sourceStr = list.get(i);
					sourceStr = sourceStr.replaceAll("EXTRATABS", tab(level));
					if( i>0 ){
						str += ",";
					}
					str += "\n"+tab(level+1)+sourceStr;
				}
				str += "\n"+tab(level)+"}";
				return str;
			} else {
				return "\"{"+synonym+"}\"";
			}
		}
		return def == null? "\"${"+name+"}\"": def;
	}
	
	public static void generate(String destFileName, String destClazzName){
		
		System.out.printf("Start template generator for class:\n\t%s\n", destClazzName);

		PrintStream writeto = null;
		try {
			File file = new File (destFileName);
			writeto = new PrintStream(file);
			Class<?> clazz = Class.forName(destClazzName);
			
			generate(writeto, clazz);
			
			System.out.printf("Template succeffully generated to:\n\t%s\n", file.getAbsolutePath());
		} catch (ClassNotFoundException e) {
			System.out.printf("Can not find destination class %s\n", destClazzName);
		} catch (FileNotFoundException e) {
			System.out.printf("Can not write to template file %s\n", destFileName);
		} finally {
			System.out.println("BY!");
			if( writeto != null ){
				writeto.flush();
				writeto.close();
			}
		}
	}
	
	public static void generate(PrintStream out, Class<?> clazz) {
		ClassTreeTraversal.travers(clazz,
			(what, level, name, isFirst, isList, expr, type)->{
				switch( what ){
				case Start:
			 		tab(out, level); out.println("{");
			 		tab(out, level+1); out.println(prop(clazz.getSimpleName())+" {");
					break;
				case End:
					out.print("\n");
			 		tab(out, level+1); out.println("}");
			 		tab(out, level); out.print("}");
					break;
				case PrimitiveType:
					out.print(isFirst?"":",\n");
					if( isList ){
						tab(out, level+1);	out.print(prop(name)+" [\""+(expr.contains(name)?name:"")+"\"]");
					} else if( expr.contains(name) ){
						tab(out, level+1);	out.print(prop(name)+" \""+name+"\"");
					} else {
						switch(type){
						case "java.lang.String":
							tab(out, level+1);	out.print(prop(name)+getSynonym(level+1, name, null));
							break;
						case "java.util.HashMap":
							tab(out, level+1);	out.print(prop(name)+" {\n");
							tab(out, level+1);	out.print("}");
							break;
						case "java.lang.Boolean":
						case "boolean":
							tab(out, level+1);	out.print(prop(name)+getSynonym(level+1, name, " false"));
							break;
						case "java.lang.Integer":
						case "java.lang.Long":
						case "int":
						case "long":
							tab(out, level+1);	out.print(prop(name)+getSynonym(level+1, name, " 0"));
							break;
						case "java.lang.Double":
						case "double":
							tab(out, level+1);	out.print(prop(name)+getSynonym(level+1, name, " 0.0"));
							break;
						case "java.util.GregorianCalendar":
						case "java.math.BigInteger":
						case "java.util.Date":
							tab(out, level+1);	out.print(prop(name)+getSynonym(level+1, name, null));
							break;
						default:
							tab(out, level+1);	out.print(prop(name)+getSynonym(level+1, name, null));
							break;
						}
					}
					break;
				case ListStart:
					out.print(isFirst?"":",\n");
			 		tab(out, level+1);	out.println(prop(name)+(isList?" [{":" {"));
					break;
				case ListEnd:
					out.print("\n");
			 		tab(out, level+1); out.print(isList?"}]":"}");
					break;
				}
			}
		);
	}

	private static void tab(PrintStream out, int tab) {
		out.print(tab(tab));
	}

	private static String tab(int tab) {
		String t = "";
		for(int i=0; i<tab; i++){
			t += "\t";
		}
		return t;
	}

	private static String prop(String name) {
		return "\""+name+"\""+":";
	}

	private static String prop2(String name) {
		return "\""+name+"\"";
	}

	private static String clean2(String name) {
		return name.substring(1, name.length()-1);
	}
}