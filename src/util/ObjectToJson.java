package util;

import java.util.List;

import com.google.gson.Gson;

public class ObjectToJson {
public static String listToJson(List list){
	Gson gson = new Gson();
	String msg = gson.toJson(list);
	return msg;
}
 
public static String stringToJson(){
	Gson gson = new Gson();
	String msg = gson.toJson("{'code':'3'}");
	return msg;
}

}
