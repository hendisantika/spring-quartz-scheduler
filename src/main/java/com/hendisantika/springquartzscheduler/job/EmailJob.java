package com.hendisantika.springquartzscheduler.job;

import com.hendisantika.springquartzscheduler.model.Email;
import com.hendisantika.springquartzscheduler.service.EmailSenderService;
import lombok.RequiredArgsConstructor;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-quartz-scheduler
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 12/26/23
 * Time: 05:31
 * To change this template use File | Settings | File Templates.
 */
@Component
@RequiredArgsConstructor
public class EmailJob extends QuartzJobBean {

    private final EmailSenderService emailSenderService;

    private final MailProperties mailProperties;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        JobDataMap jobDataMap = context.getMergedJobDataMap();
        String subject = jobDataMap.getString("subject");
        String emailId = jobDataMap.getString("email");
        String body = jobDataMap.getString("body");

        Email email = new Email(emailId, "ashishbg.g@gmail.com", subject, body);
        emailSenderService.sendSimpleEmail(email);
    }
}
