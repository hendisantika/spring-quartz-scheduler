package com.hendisantika.springquartzscheduler.job;

import lombok.RequiredArgsConstructor;
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
}
