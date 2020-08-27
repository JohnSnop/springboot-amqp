package com.wf.amqp;

import com.wf.amqp.dto.Book;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class SpringbootAmqpApplicationTests {

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private AmqpAdmin amqpAdmin;

    @Test
    public void test1() {
        // amqpAdmin.declareExchange(new DirectExchange("mofeiwanli.test.hello"));

        // amqpAdmin.declareQueue(new Queue(""));

        // amqpAdmin.declareBinding(new Binding("", Binding.DestinationType.QUEUE, "", ""));
    }

    @Test
    public void test2() {
        amqpAdmin.deleteExchange("mofeiwanli.test.hello");
    }

    @Test
    void contextLoads() {

        // rabbitTemplate.send(exchenge);
        Map<String, Object> msgMap = new HashMap<>();
        msgMap.put("msg", "哈哈哈哈");
        msgMap.put("data", Arrays.asList("HH", 12L, true));
        // rabbitTemplate.convertAndSend(exchange, routingKey, object);
        rabbitTemplate.convertAndSend("amqp.test", "study.msg", msgMap);
    }

    @Test
    public void receive() {
        // rabbitTemplate.receive();

        Object quenename = rabbitTemplate.receiveAndConvert("study.msg");
        System.out.println(quenename.getClass());
        System.out.println(quenename);

    }

    @Test
    public void topic() {
        rabbitTemplate.convertAndSend("mofeiwanli.news", "mofeiwanli.msg", new Book("自由基","hh"));
    }
}
