package ca.mss.utilms;

import java.util.HashMap;
import java.util.Map;

public class MapUtil {

	private MapUtil() {
	}
	
	@SafeVarargs
	public static <T> Map<String,T> toMap(T... args){
		Map<String,T> result = new HashMap<>();
		if( args != null ){
			for(int i=0,max=args.length; i<max; i+=2) {
				if( args[i] != null ){
					result.put(args[i].toString(), args[i+1]);
				}
			}
		}
		return result;
	}

	public static <T> Map<String, T> toMap(Map<?,T> map) {
		Map<String, T> result = new HashMap<>();
		if( map != null ){
			map.entrySet().forEach(entry->{
				if( entry != null ){
					T value = entry.getValue();
					if( value != null ){
						if( value instanceof Map){
							result.putAll(toMap(value));
						} else if( entry.getKey() != null ) {
							result.put(entry.getKey().toString(), value);
						}
					}
				}
			});
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	public static <T> Map<String,T>[] toMaps(){
		return new HashMap[]{new HashMap<String,T>()};
	}

}
