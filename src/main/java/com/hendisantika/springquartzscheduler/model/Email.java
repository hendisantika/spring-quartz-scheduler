package com.hendisantika.springquartzscheduler.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-quartz-scheduler
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 12/26/23
 * Time: 05:29
 * To change this template use File | Settings | File Templates.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Email {
    String to;
    String from;
    String subject;
    String text;
}
