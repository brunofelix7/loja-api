package br.com.alura.loja.util;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

public class Serializer {

	private static Gson gson;
	private static String json;
	private static String xml;
	private static XStream xStream;
	
	public static <T> String toJSON(T t){
		gson = new Gson();
		json = gson.toJson(t);
		return json;
	}
	
	public static <T> String toXML(T t){
		xStream = new XStream();
		xml = xStream.toXML(t);
		return xml;
	}
	
}
