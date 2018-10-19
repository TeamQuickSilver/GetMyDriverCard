package com.quicksilver.getmydrivercard.parsers;

import java.util.List;

public interface JsonParser<T> {

    List<T> fromJsonArray(String json);

    T fromJson(String json);

    String toJson(T object);
}
