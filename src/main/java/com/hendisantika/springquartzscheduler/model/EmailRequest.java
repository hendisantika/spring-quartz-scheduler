package com.hendisantika.springquartzscheduler.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.ZoneId;

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
public class EmailRequest {

    @Email
    @NotEmpty
    private String email;

    @NotEmpty
    private String subject;

    @NotEmpty
    private String body;

    @NotNull
    private LocalDateTime dateTime;

    @NotNull
    private ZoneId timeZone;
}
