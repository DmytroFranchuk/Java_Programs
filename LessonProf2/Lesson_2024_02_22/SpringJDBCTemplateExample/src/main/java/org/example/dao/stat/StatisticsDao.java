package org.example.dao.stat;

import org.example.entity.StatisticsItem;

import java.util.List;
import java.util.Map;

public interface StatisticsDao {
    List<StatisticsItem> getStatistics();
    void addStatistics(String agent);
}
