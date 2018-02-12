package com.hxkj.xhupubmed.core.utils;

import java.io.FileOutputStream;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
/** 
 * ClassName:MailUtils
 * Function:   
 * @author   huzhihui_c@qq.com
 * Date:     2016年4月8日 下午9:54:36 
 * @version  1.0 
 * @since    JDK 1.8      
 */
public class MailUtils {

	/**
	 * 
	* @Function: 验证码发送方法
	* @Title: sendVerCodeMail 
	* @param @param toAddress 接收方的邮件地址
	* @param @param verVode 验证码
	* @param @return     
	* @return boolean    
	* @author huzhihui_c@qq.com   
	* @date 2016年4月8日 下午10:13:15
	* @Since JDK 1.8
	 */
	public static boolean sendVerCodeMail(String toAddress,String verCode){
		String body = "<center><h3>西华考研验密码找回验证码请在2分钟内完成操作</h3>"+verCode+"</center>";
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				sendSimpleMail("huzhihui@boco.com.cn",toAddress,"西华考研伙伴",body);
			}
		});
		thread.start();
		return true;
	}
	
	public static boolean sendSimpleMail(String fromAddress, String toAddress, String head, String body) {
		try {
			Properties prop = new Properties();
			prop.setProperty("mail.host", "smtp.boco.com.cn");
			prop.setProperty("mail.transport.protocol", "smtp");
			prop.setProperty("mail.smtp.auth", "true");
			// 使用JavaMail发送邮件的5个步骤
			// 1、创建session
			Session session = Session.getInstance(prop);
			// 开启Session的debug模式，这样就可以查看到程序发送Email的运行状态
			session.setDebug(true);
			// 2、通过session得到transport对象
			Transport ts = session.getTransport();
			// 3、连上邮件服务器，需要发件人提供邮箱的用户名和密码进行验证
			ts.connect("smtp.boco.com.cn", "huzhihui@boco.com.cn", "hzh941012");
			// 4、创建邮件
			Message message = createSimpleMail(session, fromAddress, toAddress, head, body);
			// 5、发送邮件
			ts.sendMessage(message, message.getAllRecipients());
			ts.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean sendImgMail(String fromAddress, String toAddress, String head, String body){
		try {
			Properties prop = new Properties();
			prop.setProperty("mail.host", "smtp.boco.com.cn");
			prop.setProperty("mail.transport.protocol", "smtp");
			prop.setProperty("mail.smtp.auth", "true");
			// 使用JavaMail发送邮件的5个步骤
			// 1、创建session
			Session session = Session.getInstance(prop);
			// 开启Session的debug模式，这样就可以查看到程序发送Email的运行状态
			session.setDebug(true);
			// 2、通过session得到transport对象
			Transport ts = session.getTransport();
			// 3、连上邮件服务器，需要发件人提供邮箱的用户名和密码进行验证
			ts.connect("smtp.boco.com.cn", "huzhihui@boco.com.cn", "hzh941012");
			// 4、创建邮件
			Message message = createImageMail(session);
			// 5、发送邮件
			ts.sendMessage(message, message.getAllRecipients());
			ts.close();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	public static MimeMessage createSimpleMail(Session session, String fromAddress, String toAddress, String head,
			String body) throws Exception {
		// 创建邮件对象
		MimeMessage message = new MimeMessage(session);
		// 指明邮件的发件人
		message.setFrom(new InternetAddress(fromAddress));
		// 指明邮件的收件人，现在发件人和收件人是一样的，那就是自己给自己发
		message.setRecipient(Message.RecipientType.TO, new InternetAddress(toAddress));
		// 邮件的标题
		message.setSubject(head);
		// 邮件的文本内容
		String bodyContent = "<html><center>"+body+"</center></html>";
		message.setContent(bodyContent, "text/html;charset=UTF-8");
		// 返回创建好的邮件对象
		return message;
	}

	public static MimeMessage createImageMail(Session session) throws Exception {
		// 创建邮件
		MimeMessage message = new MimeMessage(session);
		// 设置邮件的基本信息
		// 发件人
		message.setFrom(new InternetAddress("gacl@sohu.com"));
		// 收件人
		message.setRecipient(Message.RecipientType.TO, new InternetAddress("xdp_gacl@sina.cn"));
		// 邮件标题
		message.setSubject("带图片的邮件");

		// 准备邮件数据
		// 准备邮件正文数据
		MimeBodyPart text = new MimeBodyPart();
		text.setContent("这是一封邮件正文带图片<img src='cid:xxx.jpg'>的邮件", "text/html;charset=UTF-8");
		// 准备图片数据
		MimeBodyPart image = new MimeBodyPart();
		DataHandler dh = new DataHandler(new FileDataSource("src\\1.jpg"));
		image.setDataHandler(dh);
		image.setContentID("xxx.jpg");
		// 描述数据关系
		MimeMultipart mm = new MimeMultipart();
		mm.addBodyPart(text);
		mm.addBodyPart(image);
		mm.setSubType("related");

		message.setContent(mm);
		message.saveChanges();
		// 将创建好的邮件写入到E盘以文件的形式进行保存
		message.writeTo(new FileOutputStream("E:\\ImageMail.eml"));
		// 返回创建好的邮件
		return message;
	}

	public static void main(String[] args) {
		sendVerCodeMail("huzhihui_c@qq.com","1234");
	}
}
