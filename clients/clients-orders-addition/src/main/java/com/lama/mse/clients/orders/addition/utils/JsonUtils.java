package com.lama.mse.clients.orders.addition.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public final class JsonUtils {

	private JsonUtils() {}
	
	private final static Gson GSON = new GsonBuilder().create();
	
	public static <T> String toJson(T o) {
		return GSON.toJson(o);
	}
	
	public static <T> T fromJson(String json, Class<T> clazz) {
		return GSON.fromJson(json, clazz);
	}
}
