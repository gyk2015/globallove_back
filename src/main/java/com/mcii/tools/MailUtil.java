package com.mcii.tools;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

/**
 * 邮件发送工具类
 * @author 逸坤
 *
 */
public class MailUtil {
	// 发件人的 邮箱 和 密码（替换为自己的邮箱和密码）
    // PS: 某些邮箱服务器为了增加邮箱本身密码的安全性，给 SMTP 客户端设置了独立密码（有的邮箱称为“授权码”）, 
    //     对于开启了独立密码的邮箱, 这里的邮箱密码必需使用这个独立密码（授权码）。
    public static String myEmailAccount = "gykyk2011@163.com";
    public static String myEmailPassword = "woshigyk2011";

    // 发件人邮箱的 SMTP 服务器地址, 必须准确, 不同邮件服务器地址不同, 一般(只是一般, 绝非绝对)格式为: smtp.xxx.com
    // 网易163邮箱的 SMTP 服务器地址为: smtp.163.com
    public static String myEmailSMTPHost = "smtp.163.com";
    
    private static Session session; // 邮件会话对象 
    private static MimeMessage mimeMsg; // MIME邮件对象 
    private static Multipart mp;   // Multipart对象,邮件内容,标题,附件等内容均添加到其中后再生成MimeMessage对象 
	
    /**
	 * 发送邮件
	 * @param to发送对象
	 * @param code激活码
	 * @throws MessagingException 
	 */
	public static void sendMail(String[] to,String subject,String content, String[] fileList) throws MessagingException {
		
		// 1. 创建一封邮件
        Properties props = new Properties();                // 用于连接邮件服务器的参数配置（发送邮件时才需要用到）
        props.setProperty("mail.transport.protocol", "smtp");   // 使用的协议（JavaMail规范要求）
        props.setProperty("mail.smtp.host", myEmailSMTPHost);   // 发件人的邮箱的 SMTP 服务器地址
        props.setProperty("mail.smtp.auth", "true");            // 需要请求认证
        
        session = Session.getInstance(props, new Authenticator() {
        	@Override
        	protected PasswordAuthentication getPasswordAuthentication() {
        		return new PasswordAuthentication(myEmailAccount,myEmailPassword);
        	}
        });
        
        mimeMsg = new MimeMessage(session);
        
        try {
        	mimeMsg.setFrom(new InternetAddress(myEmailAccount));
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
        
        mp = new MimeMultipart(); 
        
        try {
        	if (to != null && to.length > 0) {
                String toListStr = getMailList(to);
                mimeMsg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toListStr));
            }
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
        mimeMsg.setSubject(subject);

        // 5. Content: 邮件正文（可以使用html标签）（内容有广告嫌疑，避免被邮件服务器误认为是滥发广告以至返回失败，请修改发送内容）
//        message.setContent("<h1>尊敬的用户您好，欢迎注册globallove，激活请点击:</h1><h3><a href='http://localhost:8080/#/regist?code="+code+"'>http://localhost:8080/#/regist?code="+code+"</a></h3>", "text/html;charset=UTF-8");
        // 设置主题
        mimeMsg.setSubject(subject);
        // 设置正文
        BodyPart bp = new MimeBodyPart(); 
        bp.setContent(content, "text/html;charset=utf-8");
        mp.addBodyPart(bp);
        // 设置附件
        if (fileList != null && fileList.length > 0) {
            for (int i = 0; i < fileList.length; i++) {
                bp = new MimeBodyPart();
                FileDataSource fds = new FileDataSource(fileList[i]); 
                bp.setDataHandler(new DataHandler(fds)); 
                try {
					bp.setFileName(MimeUtility.encodeText(fds.getName(), "UTF-8", "B"));
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                mp.addBodyPart(bp); 
            }
        }
        mimeMsg.setContent(mp); 
        Transport.send(mimeMsg);
	}
	
	public static String getMailList(String[] mailArray) {
        StringBuffer toList = new StringBuffer();
        int length = mailArray.length;
        if (mailArray != null && length < 2) {
            toList.append(mailArray[0]);
        } else {
            for (int i = 0; i < length; i++) {
                toList.append(mailArray[i]);
                if (i != (length - 1)) {
                    toList.append(",");
                }
            }
        }
        return toList.toString();
    }
}
