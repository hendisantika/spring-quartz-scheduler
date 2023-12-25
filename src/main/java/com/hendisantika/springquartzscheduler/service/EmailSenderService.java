package com.hendisantika.springquartzscheduler.service;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-quartz-scheduler
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 12/26/23
 * Time: 05:32
 * To change this template use File | Settings | File Templates.
 */
@Service
@RequiredArgsConstructor
public class EmailSenderService {
    private final JavaMailSender mailSender;
}
