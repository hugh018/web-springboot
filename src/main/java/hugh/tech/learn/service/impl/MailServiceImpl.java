package hugh.tech.learn.service.impl;

import hugh.tech.learn.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * @author: hugh
 * Created on 2019/2/12
 * func:
 * params:
 * link: http://blog.didispace.com/springbootmailsender/
 */
@Service
public class MailServiceImpl implements MailService {

    @Autowired
    private JavaMailSender javaMailSender;

//    @Autowired
//    private VelocityEngine velocityEngine;

    /**
     * 发送简单邮件
     *
     * @return
     */
    @Override
    public boolean sendSimpleMail() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("hughhhusong@163.com");
        message.setTo("hugh_cs@qq.com");
        message.setSubject("主题：简单邮件");
        message.setText("测试邮件内容");

        try {
            javaMailSender.send(message);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 发送带附件的邮件
     *
     * @return
     */
    @Override
    public boolean sendAttachmentsMail() {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom("hughhhusong@163.com");
            helper.setTo("hugh_cs@qq.com");
            helper.setSubject("主题：有附件");
            helper.setText("带附件的邮件");

            FileSystemResource file = new FileSystemResource(new File("/Users/husong/Downloads/weixin.jpg"));
            helper.addAttachment("附件-1.jpg", file);
            helper.addAttachment("附件-2.jpg", file);
            javaMailSender.send(mimeMessage);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 嵌入静态资源的附件
     *
     * @return
     */
    @Override
    public boolean sendInlineMail() {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();

            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom("hughhhusong@163.com");
            helper.setTo("hugh_cs@qq.com");
            helper.setSubject("主题：嵌入静态资源");
            helper.setText("<html><body><img src=\"cid:weixin\" ></body></html>", true);

            FileSystemResource file = new FileSystemResource(new File("/Users/husong/Downloads/weixin.jpg"));
            helper.addInline("weixin", file);

            javaMailSender.send(mimeMessage);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 使用模板邮件(目前2.0的版本依赖不支持)
     *
     * @return
     */
    @Override
    public boolean sendTemplateMail() {

//        MimeMessage mimeMessage = mailSender.createMimeMessage();
//        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
//        helper.setFrom("hughhhusong@163.com");
//        helper.setTo("hugh_cs@qq.com");
//        helper.setSubject("主题：模板邮件");
//        Map<String, Object> model = new HashedMap(); // html页面中传进去参数的问题
//        model.put("username", "hugh");
//        String text = VelocityEngineUtils.mergeTemplateIntoString(
//                velocityEngine, "template.vm", "UTF-8", model);
//        helper.setText(text, true);
//        mailSender.send(mimeMessage);

        return false;
    }

}
