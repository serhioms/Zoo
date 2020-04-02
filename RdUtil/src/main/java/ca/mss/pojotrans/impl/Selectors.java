package ca.mss.pojotrans.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * Parsing selector like expressions
 *  
 * phoneList[?(com.td.cts.eso.ae.core.canadian.fraud.FraudDSTransformer.phoneType(type)==C;true:false)]
 *  
 */
public class Selectors {

	private static final boolean IS_INDEX = true;
	private static final boolean IS_BOOLEAN = false;
	
	public final String list;
	public final String expression;
	public final boolean isIndex;

	private Selectors(String list, String expression, boolean isIndex) {
		this.list = list;
		this.expression = expression;
		this.isIndex = isIndex;
	}

	private static Pattern select1 = Pattern.compile("(.*?)\\[(.*)\\]");
	private static Pattern select2 = Pattern.compile("(.*?)\\{(.*)\\}");
	
	public static Selectors getSelector(String str) {
		Matcher fmatcher = select1.matcher(str);
	    if( fmatcher.find() && fmatcher.groupCount() == 2 ){
    		return new Selectors(fmatcher.group(1), fmatcher.group(2), IS_INDEX);
	    }
		fmatcher = select2.matcher(str);
	    if( fmatcher.find() && fmatcher.groupCount() == 2 ){
    		return new Selectors(fmatcher.group(1), fmatcher.group(2), IS_BOOLEAN);
	    }
		return null;
	}

}
