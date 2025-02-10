package com.pain.haven.utils.controller;

import com.pain.haven.utils.service.EmailService;
import jakarta.mail.MessagingException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/mail")
public class MailController {
    private final EmailService emailService;

    public MailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping("/verification-send/{email}")
    public Map<String, Object> emailVerificationSend(@PathVariable String email) {
        Map<String, Object> result = new HashMap<String, Object>();

        try {
            emailService.sendVerificationEmail(email);
        } catch (MessagingException | javax.mail.MessagingException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
    @GetMapping("/verify-email")
    public Map<String, Object> emailVerification(@RequestParam String email, @RequestParam String token) {
        Map<String, Object> result = new HashMap<>();
        System.out.println("TEST");
        return result;
    }
}
