package org.example.dao.stat;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
public class StatisticsDaoImpl implements StatisticsDao{
    private final Map<String, Long> clientAppToCount;

    public StatisticsDaoImpl() {
        clientAppToCount = new HashMap<>();
    }

    @Override
    public Map<String, Long> getStatistics() {
        return new HashMap<>(clientAppToCount);
    }

    @Override
    public void addStatistics(String agent) {
        Optional.ofNullable(clientAppToCount.putIfAbsent(agent, 1L))
                .ifPresent(n -> clientAppToCount.put(agent, n + 1L));    }
}
