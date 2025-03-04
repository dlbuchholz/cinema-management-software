package com.cinemamanagementsoftware.applicationservice.api;

import org.eclipse.emfcloud.jackson.module.EMFModule;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class APIUtils {
	public static String ensureEClassField(String json, String eClassType) throws Exception {
	    ObjectMapper objectMapper = new ObjectMapper();
	    objectMapper.registerModule(new EMFModule());
	    JsonNode jsonNode = objectMapper.readTree(json);

	    // ✅ Ensure the "eClass" field exists
	    if (!jsonNode.has("eClass")) {
	        ((ObjectNode) jsonNode).put("eClass", eClassType);
	    }

	    return objectMapper.writeValueAsString(jsonNode);
	}
}
