package org.example.dao.stat;

import java.util.Map;

public interface StatisticsDao {
    Map<String, Long> getStatistics();
    void addStatistics(String agent);
}
