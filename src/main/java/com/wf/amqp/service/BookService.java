package com.wf.amqp.service;

import com.wf.amqp.dto.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @author wf
 * @create 2020-08-27 21:53
 * @desc
 **/
@Service
@Slf4j
public class BookService {

    // @RabbitListener(queues = {"mofeiwanli.msg"})
    public void receive(Book book) {
        log.info("=================" + book);
    }

    @RabbitListener(queues = {"mofeiwanli.msg"})
    public void receiveProp(Message message) {
        log.info("=================" + message.getBody());
        log.info("=================" + message.getMessageProperties());
    }
}
