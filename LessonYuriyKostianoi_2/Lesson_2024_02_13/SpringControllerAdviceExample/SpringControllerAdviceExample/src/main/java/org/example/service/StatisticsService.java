package org.example.service;

import jakarta.validation.constraints.NotBlank;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@Validated
public class StatisticsService {
    private final Map<String, Long> clientAppToCount;

    public StatisticsService() {
        clientAppToCount = new HashMap<>();
    }

    public void addUserClientApp(@NotBlank String clientApp) {
        Optional.ofNullable(clientAppToCount.putIfAbsent(clientApp, 1L))
                .ifPresent(n -> clientAppToCount.put(clientApp, n + 1L));
    }

    public Map<String, Long> getStatistics() {
        return new HashMap<>(clientAppToCount);
    }
}
