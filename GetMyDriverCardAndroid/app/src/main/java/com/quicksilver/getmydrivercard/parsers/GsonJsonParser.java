package com.quicksilver.getmydrivercard.parsers;

import android.util.Base64;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

public class GsonJsonParser<T> implements JsonParser<T> {

    private final Class<T> mClazz;
    private final Class<T[]> mClazzArray;
    private final Gson mGson;

    public GsonJsonParser(Class<T> clazz, Class<T[]> clazzArray) {
        mClazz = clazz;
        mClazzArray = clazzArray;
        mGson = initGson();
    }

    private Gson initGson() {
        Gson gson = new GsonBuilder()
                .registerTypeHierarchyAdapter(byte[].class,
                        new ByteArrayToBase64TypeAdapter())
                .setDateFormat("yyyy-MM-dd")
                .serializeNulls()
                .create();

        return gson;
    }

    @Override
    public List<T> fromJsonArray(String json) {
        T[] items = mGson.fromJson(json, mClazzArray);
        return Arrays.asList(items);
    }

    @Override
    public T fromJson(String json) {
        return mGson.fromJson(json, mClazz);
    }

    @Override
    public String toJson(T object) {
        return mGson.toJson(object);
    }

    // Need this because default Gson don't work with array fields (byte[] for image)
    public static class ByteArrayToBase64TypeAdapter implements
            JsonDeserializer<byte[]> {
        public byte[] deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            return Base64.decode(json.getAsString(), Base64.NO_WRAP);
        }

//        public JsonElement serialize(byte[] src, Type typeOfSrc, JsonSerializationContext context) {
//            return new JsonPrimitive(Base64.encodeToString(src, Base64.NO_WRAP));
//        }
    }
}
