package util;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

public class OutContent {
public static  <T> void content(List<T>list) throws Exception{
	PrintWriter out = JsonUtil.getHeader();
	Map<String,Object> map = new HashMap<String,Object>();
	JSONObject message=null;
	if(list==null){
		map.put("code",3);
		map.put("msg","暂没有值!");
		message=JSONObject.fromObject(map);
	}else{
		map.put("code",0);
		map.put("content",list);
		map.put("msg","查找成功!");
		message=JSONObject.fromObject(map);
	}
	out.print(message);
}
public static void successCotent(Map<String,Object> map) throws Exception{
	PrintWriter out = JsonUtil.getHeader();
	JSONObject message=null;
		map.put("code",0);
		map.put("msg","成功!");
		message=JSONObject.fromObject(map);
		out.print(message);
	}
public static void failCotent(Map<String,Object> map) throws Exception{
	PrintWriter out = JsonUtil.getHeader();
	JSONObject message=null;
		map.put("code",3);
		map.put("msg","失败!");
		message=JSONObject.fromObject(map);
		out.print(message);
	}

}
