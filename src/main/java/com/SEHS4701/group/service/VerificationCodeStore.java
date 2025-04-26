package com.SEHS4701.group.service;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class VerificationCodeStore {
    private static class CodeEntry {
        String code;
        LocalDateTime expiresAt;
        boolean used;

        CodeEntry(String code, LocalDateTime expiresAt) {
            this.code = code;
            this.expiresAt = expiresAt;
            this.used = false;
        }
    }

    private final ConcurrentHashMap<String, CodeEntry> codeStore = new ConcurrentHashMap<>();
    private static final long EXPIRY_MINUTES = 60; // 1 hour

    public String generateCode(String email) {
        String code = UUID.randomUUID().toString();
        LocalDateTime expiresAt = LocalDateTime.now().plusMinutes(EXPIRY_MINUTES);
        codeStore.put(email, new CodeEntry(code, expiresAt));
        return code;
    }

    public boolean validateCode(String email, String code) {
        CodeEntry entry = codeStore.get(email);
        if (entry == null || entry.used || entry.expiresAt.isBefore(LocalDateTime.now())) {
            return false;
        }
        return entry.code.equals(code);
    }

    public void markCodeAsUsed(String email) {
        CodeEntry entry = codeStore.get(email);
        if (entry != null) {
            entry.used = true;
        }
    }

    public void clearExpiredCodes() {
        codeStore.entrySet().removeIf(entry -> entry.getValue().expiresAt.isBefore(LocalDateTime.now()) || entry.getValue().used);
    }
}