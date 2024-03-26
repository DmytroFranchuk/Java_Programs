package org.example.repository;

import org.example.entity.statistics.ClientAppStatistic;
import org.example.repository.StatisticsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class StatisticsRepositoryTest {

    private static final String TEST_APP_NAME1 = "testAppName1";
    private static final String TEST_APP_NAME2 = "testAppName2";
    private static final List<String> TEST_APP_NAMES = List.of(TEST_APP_NAME1, TEST_APP_NAME2);
    @Autowired
    private StatisticsRepository statisticsRepository;

    @BeforeEach
    void setUp() {
        statisticsRepository.deleteAll();
        List<ClientAppStatistic> beforeTest = statisticsRepository.findAll();
        assertTrue(beforeTest.isEmpty());
        TEST_APP_NAMES.forEach(n -> statisticsRepository.save(new ClientAppStatistic(null, n, 1)));
    }

    @Test
    void save() {
        ClientAppStatistic candidate = new ClientAppStatistic(null, "anotherApp", 1);
        ClientAppStatistic actual = statisticsRepository.save(candidate);
        assertNotNull(actual);
        assertNotNull(actual.getId());
        assertTrue(actual.getId() > 0);
    }

    @Test
    void findAll() {
        List<ClientAppStatistic> actual = statisticsRepository.findAll();
        assertNotNull(actual);
        assertEquals(TEST_APP_NAMES.size(), actual.size());
    }

    private static Stream<Arguments> provideFindByClientAppNameTestData() {
        return Stream.of(
                Arguments.of(null, false),
                Arguments.of("", false),
                Arguments.of("not_exist", false),
                Arguments.of(TEST_APP_NAME1, true)
        );
    }

    @ParameterizedTest
    @MethodSource("provideFindByClientAppNameTestData")
    void findByClientAppName(String appName, boolean isAppNamePresentedInDatabase) {
        Optional<ClientAppStatistic> actual = statisticsRepository.findByClientAppName(appName);
        assertEquals(isAppNamePresentedInDatabase, actual.isPresent());
    }
}

