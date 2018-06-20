package util;

import java.util.HashMap;
import java.util.Map;

public class MeineException extends Exception{

	public MeineException() throws Exception {
		super();
		Map<String,Object> res = new HashMap<String,Object>();
		OutContent.failCotent(res, "操作异常，请删除低版本的测试数据！");
	}

	public MeineException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public MeineException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public MeineException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public MeineException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
}
