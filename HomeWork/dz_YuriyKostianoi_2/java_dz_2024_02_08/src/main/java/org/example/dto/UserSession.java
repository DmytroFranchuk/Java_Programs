package org.example.dto;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserSession {
    private boolean isNewUser = true;
    private int visitCount = 0;

    public boolean isNewUser() {
        return isNewUser;
    }

    public void setNewUser(boolean newUser) {
        isNewUser = newUser;
    }

    public int getVisitCount() {
        return visitCount;
    }

    public void incrementVisitCount() {
        visitCount++;
    }

    public void resetVisitCount() {
        visitCount = 0;
    }
}
