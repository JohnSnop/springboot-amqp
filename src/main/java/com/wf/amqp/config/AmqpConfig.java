package com.wf.amqp.config;

import org.springframework.amqp.support.converter.AbstractJackson2MessageConverter;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wf
 * @create 2020-08-27 21:39
 * @desc
 **/
@Configuration
public class AmqpConfig {
    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
