package com.hendisantika.springquartzscheduler.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-quartz-scheduler
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 12/26/23
 * Time: 05:30
 * To change this template use File | Settings | File Templates.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)  // Include non-null values in JSON
@Getter
@Setter
@AllArgsConstructor
public class EmailResponse {
    private boolean success;
    private String jobId;
    private String jobGroup;
    private String message;

    public EmailResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
}
