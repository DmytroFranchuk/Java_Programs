package org.example.service;

import jakarta.validation.constraints.NotBlank;
import org.example.entity.statistics.ClientAppStatistic;
import org.example.repository.StatisticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
public class StatisticsService {
    private final StatisticsRepository statisticsRepository;

    @Autowired
    public StatisticsService(StatisticsRepository statisticsRepository) {
        this.statisticsRepository = statisticsRepository;
    }

    public void addUserClientApp(@NotBlank String clientApp) {
        statisticsRepository.findByClientAppName(clientApp).ifPresentOrElse(
                v -> {
                    v.setClientAppCount(v.getClientAppCount() + 1);
                    statisticsRepository.save(v);
                },
                () -> statisticsRepository.save(new ClientAppStatistic(null, clientApp, 1))
        );
    }

    public List<ClientAppStatistic> getStatistics() {
        return statisticsRepository.findAll();
    }
}
