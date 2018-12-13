package com.hwua.amqp.service;

import com.hwua.amqp.po.Member;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    @RabbitListener(queues = "email")
    public void sendEmail(Member member){
        String name = member.getName();
        String email = member.getEmail();
        System.out.println("给"+name+":"+email+"发送邮件");
    }

    @RabbitListener(queues = "sms")
    public void sendSms(Member member){
        String name = member.getName();
        String tel = member.getTel();
        System.out.println("给"+name+":"+tel+"发送短信");
    }
}
