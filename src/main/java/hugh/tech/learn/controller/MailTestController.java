package hugh.tech.learn.controller;

import hugh.tech.learn.service.impl.MailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author: hugh
 * Created on 2019/2/7
 * func:
 * params:
 * link:
 */

@RestController
@RequestMapping("/test")
public class MailTestController {

    @Autowired
    private MailServiceImpl mailService;


    @RequestMapping("/mail")
    public boolean mail() {
        boolean res = mailService.sendSimpleMail();
        return res;
    }

    @RequestMapping("/attachentsMail")
    public boolean attachentsMail() {
        boolean res = mailService.sendAttachmentsMail();
        return res;
    }

    @RequestMapping("/inlineMail")
    public boolean inlineMail() {
        boolean res = mailService.sendInlineMail();
        return res;
    }

}
