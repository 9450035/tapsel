package ir.test.tapsel.service;

import ir.test.tapsel.domain.AppStatisticsModel;
import ir.test.tapsel.dto.AppStatisticsListResponse;
import ir.test.tapsel.repository.CriteriaRepository;
import ir.test.tapsel.service.impl.AppStatisticsServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class AppStatisticsServiceTest {


    private final int clicks = 100;
    private final Integer year = 1400;
    private final Integer weekNum = 50;
    private final int requests = 100;
    private final int installs = 100;
    @Mock
    CriteriaRepository criteriaRepository;
    private AppStatisticsService appStatisticsService;


    @BeforeEach
    void setup() {
        appStatisticsService = new AppStatisticsServiceImpl(criteriaRepository);
    }

    @Test
    void searchWithoutTime() {
        final int type = 1;
        Mockito.when(criteriaRepository.getStatistics(null, null, type)).thenReturn(dummyRepoResponse());
        Assertions.assertEquals(dummyResponse(), appStatisticsService.getStats(null, null, type));
    }

    @Test
    void searchWithTime() {
        final int type = 1;
        var startDate=new Date();
        var endDate=new Date();
        Mockito.when(criteriaRepository.getStatistics(startDate, endDate, type)).thenReturn(dummyRepoResponse());
        Assertions.assertEquals(dummyResponse(), appStatisticsService.getStats(startDate, endDate, type));
    }

    List<AppStatisticsModel> dummyRepoResponse() {
        return List.of(new AppStatisticsModel(weekNum, year, requests, clicks, installs));
    }

    AppStatisticsListResponse dummyResponse() {
        return new AppStatisticsListResponse(List.of(new AppStatisticsModel(weekNum, year, requests, clicks, installs)));
    }

}
