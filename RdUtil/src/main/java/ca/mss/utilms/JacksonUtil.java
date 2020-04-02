package ca.mss.utilms;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

public class JacksonUtil {

 	public static final ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

	private JacksonUtil() {
	}

	public static JsonNode readTree(File jsonFile) throws UtilException {
		try {
			return mapper.readTree(jsonFile);
		} catch (Exception e) {
			throw new UtilException("Can't read json node tree from file "+jsonFile.getAbsolutePath(), e);
		}
	}

	public static JsonNode readTree(String jsonStr) throws UtilException {
		try {
			return mapper.readTree(jsonStr);
		} catch (Exception e) {
			throw new UtilException("Can't read json node tree from json: "+jsonStr, e);
		}
	}

	public static Map<String, Object> readMap(InputStream in) throws UtilException {
		try {
	    	return convertValue(readValue(in, JsonNode.class), new TypeReference<Map<String, Object>>() {});
		} catch (Exception e) {
			throw new UtilException("Can't read Map<String,Object> from stream", e);
		}
	}

	public static Map<String, Object> readMap2(String json) throws UtilException {
		try {
	    	return convertValue(readValue(json, JsonNode.class), new TypeReference<Map<String, Object>>() {});
		} catch (Exception e) {
			throw new UtilException("Can't read Map<String,Object> from stream", e);
		}
	}

	public static Map<String, Object> readMap(String json) throws UtilException {
		try {
	    	return convertValue(readValue(json, JsonNode.class), Map.class);
		} catch (Exception e) {
			throw new UtilException("Can't read Map<String,Object> from stream", e);
		}
	}

	public static <O> O readValue(InputStream in, Class<O> clazz) throws UtilException {
		try {
			return mapper.readValue(in, clazz);
		} catch (Exception e) {
			throw new UtilException("Can't read value "+clazz.getSimpleName()+" from stream", e);
		}
	}

	public static <O> O readValue(Path path, Class<O> clazz) throws UtilException {
		try {
			return convertValue(readMap(FileNioUtil.read2Stream(path)), clazz);
		} catch(IllegalArgumentException e){
			throw new UtilException("Can't read value "+clazz.getSimpleName()+" from file "+path, e);
		}
	}

	public static <O> O convertValue(Object o, Class<O> clazz) {
		return mapper.convertValue(o, clazz);
	}
	
	public static <O> O convertValue(Map<String, Object> map, Class<O> clazz) {
		return mapper.convertValue(map, clazz);
	}

	public static List<String> describe(JsonNode jsonNode) {
        return describe(jsonNode, "");
    }
	
	public static List<String> describe(JsonNode jsonNode, String prefix) {
        List<String> accomulatedFields = new ArrayList<>();
        StreamUtil.asStream(jsonNode.fields()).forEach(p -> {
            JsonNode jsonNodeSub = jsonNode.get(p.getKey());
            if (jsonNodeSub.isObject()) {
                accomulatedFields.addAll(describe(jsonNodeSub, prefix + ((StringUtils.isEmpty(prefix)) ? "" : ".") + p.getKey()));
            } else if (jsonNodeSub.isArray()) {
                ArrayNode arrayNode = (ArrayNode) jsonNodeSub;
                accomulatedFields.addAll(describe(arrayNode.get(0), prefix + ((StringUtils.isEmpty(prefix)) ? "" : ".") + p.getKey()));
            } else {
                accomulatedFields.add(prefix + ((StringUtils.isEmpty(prefix)) ? "" : ".") + p.getKey());
            }
        });
        return accomulatedFields;
    }
	
	public static <O> O readValue(String json, Class<O> clazz) throws Exception {
		try {
			return mapper.readValue(json, clazz);
		} catch (Exception e) {
			throw new UtilException("Can't read value "+clazz.getSimpleName()+" from string "+json, e);
		}
	}

	public static <O> O convertValue(JsonNode jsonNode, TypeReference<O> typeReference) {
		return mapper.convertValue(jsonNode, typeReference);
	}

	public static <O> O deserialize(String json, Class<O> clazz) throws Exception {
		return mapper.readValue(json, clazz);
	}
	
	public static String serialize(Object object) throws Exception {
    	return mapper.writeValueAsString(object);
    }

}
