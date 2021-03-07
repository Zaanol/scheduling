package com.zanol.scheduling.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONException;
import org.json.JSONObject;

public class SchedulingUtils {

    public static Object jsonToObject(JSONObject jsonObject, Class<?> clazz) {
        return jsonToObject(jsonObject.toString(), clazz);
    }

    public static Object jsonToObject(String jsonString, Class<?> clazz) {
        try {
            return new ObjectMapper().readValue(jsonString, clazz);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static JSONObject objectToJson(Object object) {
        try {
            String jsonString = new ObjectMapper().writeValueAsString(object);
            return new JSONObject(jsonString);
        } catch (JsonProcessingException | JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String objectToJsonString(Object object) {
        return objectToJson(object).toString();
    }
}