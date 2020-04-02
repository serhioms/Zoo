package ca.mss.utilms;

import java.util.Optional;

public class StrUtil {

	private StrUtil() {
	}

	public static String split(String str, String regex, int index){
		return Optional.of(str.split(regex)).map(a->a.length>index? a[index]: "").orElse("");
	}
	
	public static String extract(String str, String... expr){
		String result = str;
		for(int i=0, max=expr.length; i<max; i+=2){
			result = split(result, expr[i+0], Integer.parseInt(expr[i+1]));
		}
		return result;
	}

	public static String removeAll(String orig, String... substrs) {
		if( substrs == null || orig == null ){
			return orig;
		}
		
		String str = orig;
		
		for(String substr: substrs){
			if( !substr.isEmpty() ) {
				int index = str.indexOf(substr);
				while( index != -1 ) {
					int sublen = substr.length();
					if( index == 0 ) {
						str = str.substring(sublen);
					} else {
						str = str.substring(0, index)+str.substring(index+sublen);
					}
					index = str.indexOf(substr);
				}
			}
		}
		return str;
	}

}
