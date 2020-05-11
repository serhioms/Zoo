package ca.mss.utilms;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

public class JacksonUtil {

 	public static final ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

	private JacksonUtil() {
	}

	public static JsonNode readFile2Node(File jsonFile) throws UtilException {
		try {
			return mapper.readTree(jsonFile);
		} catch (Exception e) {
			throw new UtilException("Can't read json node tree from file "+jsonFile.getAbsolutePath(), e);
		}
	}

	public static JsonNode readJson2NodeTree(String json) throws UtilException {
		try {
			return mapper.readTree(json);
		} catch (Exception e) {
			throw new UtilException("Can't read json node tree from json: "+json, e);
		}
	}

	public static Map<String, Object> readStream2Map(InputStream in) throws UtilException {
		try {
	    	return convertNode(readStream2Class(in, JsonNode.class), new TypeReference<Map<String, Object>>() {});
		} catch (Exception e) {
			throw new UtilException("Can't read Map<String,Object> from stream", e);
		}
	}

	public static Map<String, Object> readJson2MapRef(String json) throws UtilException {
		try {
	    	return convertNode(readJson2Node(json), new TypeReference<Map<String, Object>>() {});
		} catch (Exception e) {
			throw new UtilException("Can't read Map<String,Object> from stream", e);
		}
	}

	@SuppressWarnings("unchecked")
	public static Map<String, Object> readJson2Map(String json) throws UtilException {
		try {
	    	return convertObject(readJson2Node(json), Map.class);
		} catch (Exception e) {
			throw new UtilException("Can't read Map<String,Object> from stream", e);
		}
	}

	public static JsonNode readJson2Node(String json) throws UtilException {
		try {
	    	return readClass(json, JsonNode.class);
		} catch (Exception e) {
			throw new UtilException("Can't read json node from string", e);
		}
	}

	public static <O> O readStream2Class(InputStream in, Class<O> clazz) throws UtilException {
		try {
			return mapper.readValue(in, clazz);
		} catch (Exception e) {
			throw new UtilException("Can't read value "+clazz.getSimpleName()+" from stream", e);
		}
	}

	public static <O> O readFile2Class(Path path, Class<O> clazz) throws UtilException {
		try {
			return convertMap(readStream2Map(FileNioUtil.read2Stream(path)), clazz);
		} catch(IllegalArgumentException e){
			throw new UtilException("Can't read value "+clazz.getSimpleName()+" from file "+path, e);
		}
	}

	public static <O> O convertObject(Object o, Class<O> clazz) {
		return mapper.convertValue(o, clazz);
	}
	
	public static <O> O convertMap(Map<String, Object> map, Class<O> clazz) {
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
	
	public static <O> O convertNode(JsonNode jsonNode, TypeReference<O> typeReference) {
		return mapper.convertValue(jsonNode, typeReference);
	}

	public static <O> O readClass(String json, Class<O> clazz) throws JsonParseException, JsonMappingException, IOException {
		return mapper.readValue(json, clazz);
	}
	
	public static String writeJson(Object object) throws JsonProcessingException{
    	return mapper.writeValueAsString(object);
    }

}
