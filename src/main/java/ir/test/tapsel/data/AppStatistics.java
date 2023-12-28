package ir.test.tapsel.data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
public class AppStatistics {
    @Id
    private String id;
    private Date reportTime;
    private Integer type;
    private Integer videoRequests;
    private Integer webViewRequests;
    private Integer webViewClicks;
    private Integer videClicks;
    private Integer videoInstalls;
    private Integer webviewInstalls;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getReportTime() {
        return reportTime;
    }

    public void setReportTime(Date reportTime) {
        this.reportTime = reportTime;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getVideoRequests() {
        return videoRequests;
    }

    public Integer getWebViewRequests() {
        return webViewRequests;
    }

    public Integer getWebViewClicks() {
        return webViewClicks;
    }

    public Integer getVideClicks() {
        return videClicks;
    }

    public Integer getVideoInstalls() {
        return videoInstalls;
    }

    public Integer getWebviewInstalls() {
        return webviewInstalls;
    }

    public void setVideoRequests(Integer videoRequests) {
        this.videoRequests = videoRequests != null ? videoRequests : 0;
    }

    public void setWebViewRequests(Integer webViewRequests) {
        this.webViewRequests = webViewRequests != null ? webViewRequests : 0;
    }

    public void setWebViewClicks(Integer webViewClicks) {
        this.webViewClicks = webViewClicks != null ? webViewClicks : 0;
    }

    public void setVideClicks(Integer videClicks) {
        this.videClicks = videClicks != null ? videClicks : 0;
    }

    public void setVideoInstalls(Integer videoInstalls) {
        this.videoInstalls = videoInstalls != null ? webviewInstalls : 0;
    }

    public void setWebviewInstalls(Integer webviewInstalls) {
        this.webviewInstalls = webviewInstalls != null ? webviewInstalls : 0;
    }
}

