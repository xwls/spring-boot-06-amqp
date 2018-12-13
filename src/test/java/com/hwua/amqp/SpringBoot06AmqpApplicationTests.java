package com.hwua.amqp;

import com.hwua.amqp.po.Member;
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
        Member member = new Member();
        member.setId(1001);
        member.setName("张三");
        member.setAge(18);
        member.setEmail("zs@zs.com");
        member.setTel("18666666666");
        rabbitTemplate.convertAndSend("member.fanout", "", member);
    }

    @Test
    public void receive() {
        Object o = rabbitTemplate.receiveAndConvert("jining");
        System.out.println(o.getClass());
        System.out.println(o);
    }

}

