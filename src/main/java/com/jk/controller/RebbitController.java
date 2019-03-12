/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: RebbitController
 * Author:   SWORD
 * Date:     2019/3/12 11:24
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.controller;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author SWORD
 * @create 2019/3/12
 * @since 1.0.0
 */
@RestController
public class RebbitController {


    @Value("${spring.mail.username}")
    private String from;

    @Resource
    private JavaMailSender sender;

    @RabbitListener(queues = "queue-email")
    public void receiveMethod(String to, String title,String content){

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(title); //发送标题
        message.setText(content);
        sender.send(message);
        System.out.println("邮件发送成功");


    }

}