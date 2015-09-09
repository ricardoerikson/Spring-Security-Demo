package com.trit.security.utils;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestUtils {

    public static byte[] convertObjectToJsonBytes(Object object) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return mapper.writeValueAsBytes(object);
    }

    public static String uriByReplacingPathVariables(String templateUri, Map<String, String> variables) {
        String finalUri = templateUri;
        for (Map.Entry<String, String> variable : variables.entrySet()) {
            String key = "{" + variable.getKey() + "}";
            finalUri = finalUri.replace(key, variable.getValue());
        }
        return finalUri;
    }

}
