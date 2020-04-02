package ca.mss.pojotrans.impl;

import java.util.Iterator;
import java.util.Map;
import java.util.function.Consumer;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.TextNode;

import ca.mss.pojotrans.TransformerException;
import ca.mss.streval.EvalException;
import ca.mss.streval.EvalUtil;

abstract public class AbstractTargetField implements TargetField {

	private static final String SPECIAL_CASES = "<expression>|<default>";

	protected JsonNode findObject(JsonNode target, JsonNode valueNode, 
			Map<String,Object> cache, Map<String,Object>[] maps,
			Consumer<Exception> exceptionHandler){
		if( valueNode == null ){
			return null;
		}		
		if (target.isObject()) {
			for (Iterator<String> iterator = target.fieldNames() ;iterator.hasNext();) {
				String node = iterator.next();
				if( node == null ){
					continue;
				}
				Selectors selector = Selectors.getSelector(node);
				if( selector != null ){
					JsonNode valueNodeFindValueFromSelector = valueNodeFindValueFromSelector(selector, node, target, valueNode, cache, maps, exceptionHandler);
					if( valueNodeFindValueFromSelector != null ){
						return valueNodeFindValueFromSelector;
					} else {
						continue;
					}
				}
				JsonNode field = valueNode.findValue(node);
				JsonNode findValue = findValue(target, node, field, cache, maps, exceptionHandler);
				if( findValue != null ){
					return findValue; 
				}
				if( SPECIAL_CASES.contains(node.toString()) ){
					field = target.findValue(node.toString());
					String evaluateExpr = evaluateExpr(field.asText(), cache, maps, exceptionHandler);
					if( evaluateExpr != null && !evaluateExpr.isEmpty()){
						return new TextNode(evaluateExpr);
					}
				}
			}
			return null;
		} else if( EvalUtil.isExpression(target.asText()) ){
			return valueNodeFindValueFromExpression(target.asText(), valueNode, cache, maps, exceptionHandler);
		} else {
			return valueNode.findValue(target.asText());
		}
	}

	protected JsonNode valueNodeFindValueFromExpression(String expr, JsonNode valueNode, 
			Map<String,Object> cache, Map<String,Object>[] maps,
			Consumer<Exception> exceptionHandler) {
		try {
			String eval = EvalUtil.eval(cache, expr, var->{
										if( valueNode == null || valueNode.isNull()){
											return null;
										}
										JsonNode jnode = valueNode.get(var);
										if( jnode != null && !jnode.isNull()){
											return jnode;
										}
										return null;
									}, maps);
			return (eval==null || eval.isEmpty())? null: new TextNode(eval);
		} catch(EvalException e){
			exceptionHandler.accept(new TransformerException("Fail to evaluate ["+expr+"]", e));
			return null;
		}
	}

	protected String evaluateExpr(String expr, Map<String,Object> cache, Map<String,Object>[] maps,
			Consumer<Exception> exceptionHandler) {
		try {
			return EvalUtil.isExpression(expr)? EvalUtil.eval(cache, expr, maps): expr;	
		} catch (IllegalArgumentException | EvalException e) {
			exceptionHandler.accept(new TransformerException("Fail to evaluate ["+expr+"]", e));
		}
		return expr;
	}
	
	private JsonNode valueNodeFindValueFromSelector(Selectors selector, String node, JsonNode target, JsonNode valueNode, 
			Map<String,Object> cache, Map<String,Object>[] maps,
			Consumer<Exception> exceptionHandler) {

		if (valueNode == null) {
			return null;
		}
		
		JsonNode listField = valueNode.findValue(selector.list);
		
		if (listField == null) {
			return null;
		}

		/*
		 * Simple selector case [] -  by index [0] or from external function:
		 * existingAlertList[0]
		 * employment[$com.td.cts.eso.ae.core.canadian.transformer.FraudDSTransformer.employmentSelector(this.list)]
		 */
		if( selector.isIndex ){
			cache.put("this.list", listField);
			
			String eval = null;
			
			try {
				eval = EvalUtil.eval(cache, selector.expression, maps);
			} catch(EvalException e){
				exceptionHandler.accept(new TransformerException("Fail to evaluate ["+selector.expression+"]", e));
				return null;
			}

			if( eval == null || eval.isEmpty()){
				return null;
			}
			
			int index = Integer.parseInt(eval);
			
			if( index >= listField.size() || index < 0 || listField.get(index) == null ){
				return null;
			}
			
			// Add list field to the cache for feature transformation expression resolving 
			JsonNode field = listField.get(index);
			JsonNode findValue = findValue(target, node, field, cache, maps, exceptionHandler);

			if( findValue != null ){
				cache.put(selector.list+"_"+index, findValue.asText());
				return findValue;
			} else {
				cache.put(selector.list+"_"+index, field.asText());
				return field;
			}
		} else {
			/*
			 *  Advance selector case {} - find by condition vie list iterator:  
			 *  {com.td.cts.eso.ae.core.canadian.fraud.FraudDSTransformer.phoneType(${type})==C?true;false}
			 */
			for(int i=0,max=listField.size(); i<max; i++){
				JsonNode field = listField.get(i);
				String eval = null;
				try {
					eval = EvalUtil.eval(selector.expression, var->field.get(var), maps);
				} catch(EvalException e){
					exceptionHandler.accept(new TransformerException("Fail to evaluate ["+selector.expression+"]", e));
					return null;
				}
				if( eval == null || eval.isEmpty()){
					return null;
				} else if( Boolean.parseBoolean(eval) ){
					return findValue(target, node, field, cache, maps, exceptionHandler);
				}
			}
			return null;
		}
	}
	
	private JsonNode findValue(JsonNode target, String node, JsonNode field, 
			Map<String,Object> cache, Map<String,Object>[] maps,
			Consumer<Exception> exceptionHandler) {
		return findObject(target.findValue(node), field, cache, maps, exceptionHandler);
	}
}
