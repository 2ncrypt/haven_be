package com.pain.haven.config;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class MailConfig {

    @Value("${spring.mail.username}")
    private String username;

    @Value("${spring.mail.host}")
    private String host;

    @Value("${spring.mail.port}")
    private int port;

    @Value("${spring.mail.protocol}")
    private String protocol;

    @Value("${spring.mail.smtp.auth}")
    private boolean smtpAuth;

    @Value("${spring.mail.smtp.starttls.enable}")
    private boolean startTlsEnable;

    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        String mailPassword = Dotenv.load().get("MAIL_PW");
        mailSender.setHost(host);
        mailSender.setPort(port);
        mailSender.setUsername(username);
        mailSender.setPassword(mailPassword);  // application.properties에서 읽어온 패스워드

        Properties properties = mailSender.getJavaMailProperties();
        properties.put("mail.smtp.auth", smtpAuth);
        properties.put("mail.smtp.starttls.enable", startTlsEnable);
        properties.put("mail.smtp.ssl.trust", host);

        return mailSender;
    }
}