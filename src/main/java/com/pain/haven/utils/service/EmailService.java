package com.pain.haven.utils.service;

import io.github.cdimascio.dotenv.Dotenv;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.util.Random;

@Service
public class EmailService {

    private final JavaMailSender mailSender;

    @Autowired  // 생성자 주입을 명시적으로 설정
    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    // 인증 코드 생성
    public String generateVerificationCode() {
        Random random = new Random();
        int code = 100000 + random.nextInt(900000); // 6자리 숫자 생성
        return String.valueOf(code);
    }

    // 이메일 전송
    public void sendVerificationEmail(String toEmail) throws MessagingException, javax.mail.MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
        String serverHost = Dotenv.load().get("SERVER_HOST");
        String serverPort = Dotenv.load().get("SERVER_PORT");
        String verificationCode = generateVerificationCode();

        String verificationUrl = "http://"+ serverHost +":"+ serverPort +"/mail/verify-email?email=" + toEmail + "&token=" + verificationCode;
        helper.setTo(toEmail);
        helper.setSubject("회원가입 이메일 인증");
        helper.setText("Click the following link to verify your email: " + verificationUrl);

        mailSender.send(message);
    }
}
