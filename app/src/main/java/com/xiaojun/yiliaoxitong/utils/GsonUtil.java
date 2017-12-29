package com.xiaojun.yiliaoxitong.utils;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


/**
 * @author yangnanxin
 *
 * 2015-8-12
 */
public class GsonUtil {



    public static JsonElement parse(String json) {

        JsonParser mJsonParser = new JsonParser();
        return mJsonParser.parse(json);
    }

    public static JsonObject optJsonObject(JsonElement e) {
        return optJsonObject(e, null);
    }

    public static JsonObject optJsonObject(JsonElement e, JsonObject defaultOne) {
        if (null == e || e.isJsonNull()) {
            return defaultOne;
        }

        return e.getAsJsonObject();
    }

    public static JsonArray optJsonArray(JsonElement e) {
        return optJsonArray(e, null);
    }

    public static JsonArray optJsonArray(JsonElement e, JsonArray defaultOne) {
        if (null == e || e.isJsonNull()) {
            return defaultOne;
        }

        return e.getAsJsonArray();
    }

    public static String optString(JsonElement e) {
        return optString(e, null);
    }

    public static String optString(JsonElement e, String defaultOne) {
        if (null == e || e.isJsonNull()) {
            return defaultOne;
        }

        return e.getAsString();
    }

    public static int optInt(JsonElement e) {
        return optInt(e, -1);
    }

    public static int optInt(JsonElement e, int defaultOne) {
        if (null == e || e.isJsonNull()) {
            return defaultOne;
        }

        return e.getAsInt();
    }

}
