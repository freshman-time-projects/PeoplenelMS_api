package util;


import java.net.UnknownHostException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailUtils {
	/**
	 * 发送邮件的方法
	 * @param to ：给谁发邮件
	 * @param code ：邮件的激活码
	 * @throws UnknownHostException 
	 */
	public static void sendMail(String to,String code) throws UnknownHostException{
		String fromEmail="572220216@qq.com";//你的QQ邮箱

        String eMailType="ssl://smtp.qq.com";

        String eMailAuthPassword="eeorlwjaijrxbcdb";
		//1.创建连接对象，连接到服务器
        Properties props = new Properties();

        props.put("mail.smtp.host",eMailType);
		//props.setProperty("host",value);
        props.put("mail.password",eMailAuthPassword);  

        props.put("mail.transport.protocol", "smtp");

        props.setProperty("mail.debug", "true");

        props.put("mail.smtp.auth","true");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); 

        props.put("mail.smtp.port", "465"); 

        props.put("mail.smtp.socketFactory.port", "465"); 
		Session session = Session.getInstance(props);
		session.setDebug(true);
		//2.创建邮件对象
		Message message = new MimeMessage(session);
	
		try {
			//2.1设置发件人
			message.setFrom(new InternetAddress(fromEmail));
			//2.2设置收件人
			message.setRecipient(RecipientType.TO, new InternetAddress(to));
			//2.3设置邮件的主题
			  message.setSubject("欢迎来到蚂蚁金服");
			 /* message.setContent("<font color='red'><a href='http://localhost/Blog/user?method=register&acode="
	                    + code + "target='_blank'>"+"http://localhost/Blog/user?method=register&acode="+code+"</a></font>", "text/html;charset=utf-8");*/
	            /*// StringBuilder是线程不安全的
			  String localhost =  InetAddress.getLocalHost().getHostAddress();*/
			  String localhost = "127.0.0.1:8888";
	            StringBuilder sbd = new StringBuilder();
	            sbd.append("<br/><h1>欢迎！请确认此邮件地址以激活您的账号。</h1><br/>");
	            sbd.append("<font color='red'><a href='http://"+localhost+"/PersonnelMS/user_active?code="
	                    + code + "' target='_blank'");
	            sbd.append(">立即激活</a></font><br/>");
	            sbd.append("或者点击下面链接:<br/>");
	            sbd.append("<a href='http://"+localhost+"/PersonnelMS/user_active?code="
	                    + code + "' target='_blank'>http://"+localhost+"/PersonnelMS/user_active?code="
	                    + code + "</a><br/>");
	            sbd.append("这是一封自动发送的邮件；如果您从未有过请求单收到这封信件，您不需要进行任何操作。");
	            message.setContent(sbd.toString(), "text/html;charset=utf-8");// 发html格式的文本

	            // 发送动作
	            Transport transport=session.getTransport("smtp");
	            transport.connect(eMailType,fromEmail,eMailAuthPassword);
	            transport.sendMessage(message,message.getAllRecipients());
	            transport.close();

		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//3.发送一封激活邮件
	}
}
