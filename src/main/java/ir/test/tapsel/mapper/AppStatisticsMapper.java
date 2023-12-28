package ir.test.tapsel.mapper;

import com.ibm.icu.util.Calendar;
import com.ibm.icu.util.ULocale;
import ir.test.tapsel.data.AppStatistics;
import ir.test.tapsel.domain.AppStatisticsModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Date;

import static org.mapstruct.MappingConstants.ComponentModel.*;


@Mapper(componentModel = SPRING)
public interface AppStatisticsMapper {

    @Mapping(target = "weekNum", source = "reportTime", qualifiedByName = "weekNum")
    @Mapping(target = "year", source = "reportTime", qualifiedByName = "year")
    @Mapping(target = "requests", expression = "java(requests(appStatistics.getVideoRequests(),appStatistics.getWebViewRequests()))")
    @Mapping(target = "clicks",expression = "java(clicks(appStatistics.getWebViewClicks(),appStatistics.getVideClicks()))")
    @Mapping(target = "installs" ,expression = "java(installs(appStatistics.getVideoInstalls(),appStatistics.getWebviewInstalls()))")
    AppStatisticsModel toDTO(AppStatistics appStatistics);

    @Named("year")
    default Integer getYear(Date reportTime) {
        ULocale locale = new ULocale("@calendar=persian");
        Calendar calendar = Calendar.getInstance(locale);
        calendar.setFirstDayOfWeek(7);
        calendar.setTime(reportTime);
        return calendar.get(Calendar.YEAR);
    }

    default Integer requests(Integer videoRequests, Integer webViewRequests) {
        return videoRequests + webViewRequests;
    }

    default Integer clicks(Integer webViewClicks, Integer videClicks) {
        return webViewClicks + videClicks;
    }

    default Integer installs(Integer videoInstalls, Integer webviewInstalls) {
        return videoInstalls + webviewInstalls;
    }

    @Named("weekNum")
    default Integer getWeekNum(Date reportTime) {
        ULocale locale = new ULocale("@calendar=persian");
        Calendar calendar = Calendar.getInstance(locale);
        calendar.setFirstDayOfWeek(7);
        calendar.setTime(reportTime);
        return calendar.get(Calendar.WEEK_OF_YEAR);
    }
}
