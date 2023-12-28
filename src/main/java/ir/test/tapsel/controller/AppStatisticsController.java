package ir.test.tapsel.controller;

import ir.test.tapsel.dto.AppStatisticsListResponse;
import ir.test.tapsel.service.AppStatisticsService;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/app-statistics")
@Validated
public class AppStatisticsController {

    private final AppStatisticsService appStatisticsService;

    public AppStatisticsController(AppStatisticsService appStatisticsService) {
        this.appStatisticsService = appStatisticsService;
    }

    @GetMapping
    public ResponseEntity<AppStatisticsListResponse> getStats(@Min(1L)@Max(2147483648000L) @RequestParam(required = false) Long startDate,
                                                              @Min(1L)@Max(2147483648000L) @RequestParam(required = false) Long endDate,
                                                              @RequestParam(required = false) Integer type) {
        return ResponseEntity.ok(appStatisticsService.getStats(startDate != null ? new Date(startDate) : null,
                endDate != null ? new Date(endDate) : null, type));
    }
}
