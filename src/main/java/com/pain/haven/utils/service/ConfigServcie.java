package com.pain.haven.utils.service;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.stereotype.Component;

@Component
public class ConfigServcie {
    private final Dotenv dotenv = Dotenv.load();

    public String getDbUsername() {
        return dotenv.get("DB_USERNAME");
    }

    public String getDbPassword() {
        return dotenv.get("DB_PASSWORD");
    }
}
