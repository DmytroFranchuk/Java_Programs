package service;

import jakarta.validation.constraints.NotBlank;
import org.example.dao.stat.StatisticsDao;
import org.example.entity.statistics.ClientAppStatistic;
import org.example.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@SpringBootTest
public class StatisticsServiceTest {
    @MockBean
    private StatisticsDao statisticsDao;

    private final StatisticsService statisticsService;

    @Autowired
    public StatisticsServiceTest(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    public void addUserClientApp(@NotBlank String clientApp) {
        statisticsDao.addStatistics(clientApp);
    }

    public List<ClientAppStatistic> getStatistics() {
        return statisticsDao.getStatistics();
    }
}
