package ir.test.tapsel.service;

import ir.test.tapsel.dto.AppStatisticsListResponse;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public interface AppStatisticsService {

    AppStatisticsListResponse getStats(Date startDate, Date endDate, Integer type);
}
