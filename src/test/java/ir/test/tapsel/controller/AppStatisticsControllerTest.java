package ir.test.tapsel.controller;

import ir.test.tapsel.domain.AppStatisticsModel;
import ir.test.tapsel.dto.AppStatisticsListResponse;
import ir.test.tapsel.service.AppStatisticsService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class AppStatisticsControllerTest {


    private final int CLICKS = 100;
    private final Integer WEEK_NUM = 50;
    private final int REQUESTS = 100;
    private final int INSTALLS = 100;
    @Mock
    private AppStatisticsService appStatisticsService;

    private AppStatisticsController appStatisticsController;

    @BeforeEach
    void setup() {
        this.appStatisticsController = new AppStatisticsController(appStatisticsService);
    }

    @Test
    void search() {
        Integer year = 1400;
        AppStatisticsModel model = new AppStatisticsModel(WEEK_NUM, year, REQUESTS, CLICKS, INSTALLS);
        var response = new AppStatisticsListResponse(List.of(model));
        var responseEntity = ResponseEntity.ok(new AppStatisticsListResponse(List.of(model)));
        Mockito.when(appStatisticsService.getStats(null, null, 1)).thenReturn(response);
        Assertions.assertEquals(responseEntity, appStatisticsController.getStats(null, null, 1));

    }
}
