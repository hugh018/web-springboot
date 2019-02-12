package hugh.tech.learn.service;

/**
 * @author: hugh
 * Created on 2019/2/12
 * func:
 * params:
 * link:
 */
public interface MailService {

    boolean sendSimpleMail();

    boolean sendAttachmentsMail();

    boolean sendInlineMail();

    boolean sendTemplateMail();
}
