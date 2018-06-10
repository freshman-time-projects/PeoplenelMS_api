package util;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.basic.BasicSliderUI.ActionScroller;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
public class JsonUtil extends ActionSupport{
	public static String getStrResponse() throws IOException{ 
		//得到跨域
		getHeader();
        ActionContext ctx = ActionContext.getContext();  
        HttpServletRequest request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST);   
        InputStream inputStream;  
        String strResponse = "";  
        try {  
        inputStream = request.getInputStream();  
        String strMessage = "";  
        BufferedReader reader;  
        reader = new BufferedReader(new InputStreamReader(inputStream,"utf-8"));  
        while ((strMessage = reader.readLine()) != null) {  
        strResponse += strMessage;  
        }  
        reader.close();  
        inputStream.close();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        return strResponse;
	}
	public static PrintWriter getHeader() throws IOException{
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		//允许跨域
		response.setHeader("Access-Control-Allow-Origin", "*"); 
		return response.getWriter();
		
	}
	
	
	
	
}
