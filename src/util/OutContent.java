package util;

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
		if(list==null||list.size()==0){
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
	public static  <T> void container(Map<String,Object>list) throws Exception{
		PrintWriter out = JsonUtil.getHeader();
		Map<String,Object> map = new HashMap<String,Object>();
		JSONObject message=null;
		if(list==null||list.size()==0){
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
public static void successCotent(Map<String,Object> map,String msg) throws Exception{
	PrintWriter out = JsonUtil.getHeader();
	JSONObject message=null;
		map.put("code",0);
		map.put("msg",msg);
		message=JSONObject.fromObject(map);
		out.print(message);
	}
public static void failCotent(Map<String,Object> map,String msg) throws Exception{
	PrintWriter out = JsonUtil.getHeader();
	JSONObject message=null;
		map.put("code",3);
		map.put("msg",msg);
		message=JSONObject.fromObject(map);
		out.print(message);
	}
public static void active(Map<String,Object> map,String msg) throws Exception{
	PrintWriter out = JsonUtil.getHeader();
	JSONObject message=null;
		map.put("code",5);
		map.put("msg",msg);
		message=JSONObject.fromObject(map);
		out.print(message);
	}

}
