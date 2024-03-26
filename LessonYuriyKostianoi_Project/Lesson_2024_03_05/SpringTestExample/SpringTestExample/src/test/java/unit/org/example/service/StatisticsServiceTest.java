package unit.org.example.service;

import org.example.entity.statistics.ClientAppStatistic;
import org.example.repository.StatisticsRepository;
import org.example.service.StatisticsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;

@ExtendWith(MockitoExtension.class)
public class StatisticsServiceTest {

    private static final String APP_NAME1 = "appName1";
    private static final String APP_NAME2 = "appName2";
    private static final String APP_NAME3 = "appName3";
    private static final ClientAppStatistic APP_NAME1_STATISTICS = new ClientAppStatistic(1L, APP_NAME1, 1);
    private static final ClientAppStatistic APP_NAME2_STATISTICS = new ClientAppStatistic(2L, APP_NAME2, 2);
    private static final ClientAppStatistic APP_NAME3_STATISTICS = new ClientAppStatistic(3L, APP_NAME3, 1);
    private static final List<ClientAppStatistic> STATISTICS = List.of(APP_NAME1_STATISTICS, APP_NAME2_STATISTICS);

    private List<ClientAppStatistic> currentStat;

    @Mock
    private StatisticsRepository statisticsRepository;

    @InjectMocks
    private StatisticsService statisticsService;

    @BeforeEach
    void setUp() {
        currentStat = new ArrayList<>(STATISTICS);
        Mockito.reset(statisticsRepository);

        Mockito.when(statisticsRepository.findAll()).thenReturn(currentStat);
    }

    @Test
    void getStatistics() {
        List<ClientAppStatistic> actual = statisticsService.getStatistics();
        assertEquals(STATISTICS, actual);
    }

    @Test
    void addUserClientApp_presentedInDb_incrementStatistics() {
        ClientAppStatistic beforeAdding = new ClientAppStatistic(
                null,
                APP_NAME3_STATISTICS.getClientAppName(),
                APP_NAME3_STATISTICS.getClientAppCount()
        );
        ClientAppStatistic afterAdding = APP_NAME3_STATISTICS;
        Mockito.when(statisticsRepository.findByClientAppName(anyString())).thenReturn(Optional.empty());
        Mockito.when(statisticsRepository.save(eq(beforeAdding))).thenAnswer(invocation -> {
            currentStat.add(afterAdding);
            return afterAdding;
        });


        statisticsService.addUserClientApp(beforeAdding.getClientAppName());
        List<ClientAppStatistic> actualList = statisticsService.getStatistics();
        assertTrue(actualList.contains(afterAdding));
    }

    @Test
    void addUserClientApp_presentedInDb_addedNewStatistics() {
        ClientAppStatistic beforeAdding = APP_NAME1_STATISTICS;
        ClientAppStatistic afterAdding = new ClientAppStatistic(
                APP_NAME1_STATISTICS.getId(),
                APP_NAME1_STATISTICS.getClientAppName(),
                APP_NAME1_STATISTICS.getClientAppCount() + 1
        );

        Mockito.when(statisticsRepository.findByClientAppName(anyString())).thenReturn(Optional.of(beforeAdding));
        Mockito.when(statisticsRepository.save(eq(beforeAdding))).thenReturn(afterAdding);

        statisticsService.addUserClientApp(beforeAdding.getClientAppName());
        List<ClientAppStatistic> actualList = statisticsService.getStatistics();
        assertTrue(actualList.contains(afterAdding));
    }
}

