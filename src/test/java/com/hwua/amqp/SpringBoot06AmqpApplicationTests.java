package com.hwua.amqp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot06AmqpApplicationTests {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /*
    发送消息
     */
    @Test
    public void send() {
        Map<String,Object> map = new HashMap<>();
        map.put("id",1);
        map.put("name","Java开发");
        map.put("price",9.9);
        rabbitTemplate.convertAndSend("hwua.direct","world",map);
    }

    @Test
    public void receive(){
        Object o = rabbitTemplate.receiveAndConvert("jining");
        System.out.println(o.getClass());
        System.out.println(o);
    }

}

