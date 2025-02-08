package com.pain.haven.utils.service;

import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
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
    public void sendVerificationEmail(String toEmail, String verificationCode) throws MessagingException, javax.mail.MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

        helper.setTo(toEmail);
        helper.setSubject("회원가입 이메일 인증 코드");
        helper.setText("인증 코드: " + verificationCode + "\n회원가입을 완료하려면 이 코드를 입력하세요.", false);

        mailSender.send(message);
    }
}
