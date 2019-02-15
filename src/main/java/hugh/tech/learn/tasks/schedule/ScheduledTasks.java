package hugh.tech.learn.tasks.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: hugh
 * Created on 2019/2/16
 * func: every 5s report time
 * params:
 * link: http://blog.didispace.com/springbootscheduled/
 */
@Component
public class ScheduledTasks {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    //    @Scheduled(fixedRate = 5000) ：上一次开始执行时间点之后5秒再执行
//    @Scheduled(fixedDelay = 5000) ：上一次执行完毕时间点之后5秒再执行
//    @Scheduled(initialDelay=1000, fixedRate=5000) ：第一次延迟1秒后执行，之后按fixedRate的规则每5秒执行一次
//    @Scheduled(cron="*/5*****") ：通过cron表达式定义规则


    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        System.out.println("current system time： " + sdf.format(new Date()));
    }

}
