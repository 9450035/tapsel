package ir.test.tapsel.service.impl;

import ir.test.tapsel.dto.AppStatisticsListResponse;
import ir.test.tapsel.repository.CriteriaRepository;
import ir.test.tapsel.service.AppStatisticsService;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class AppStatisticsServiceImpl implements AppStatisticsService {

    private final CriteriaRepository criteriaRepository;

    public AppStatisticsServiceImpl(CriteriaRepository criteriaRepository) {
        this.criteriaRepository = criteriaRepository;
    }

    @Override
    public AppStatisticsListResponse getStats(Date startDate, Date endDate, Integer type) {
        return new AppStatisticsListResponse(criteriaRepository.getStatistics(startDate, endDate, type));
    }
}
