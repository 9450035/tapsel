package ir.test.tapsel.dto;

import ir.test.tapsel.domain.AppStatisticsModel;
import java.util.List;

public record AppStatisticsListResponse(List<AppStatisticsModel> stats) {
}
