package com.yasic.tvlist.Bean;

/**
 * Created by ESIR on 2016/3/17.
 */
public class TVShowBean {
    private String showName;
    private String showTime;
    private String showDuration;
    public TVShowBean(String showName, String showTime, String showDuration){
        this.showName = showName;
        this.showTime = showTime;
        this.showDuration = showDuration;
    }

    public String getShowName() {
        return showName;
    }

    public String getShowTime() {
        return showTime;
    }

    public String getShowDuration() {
        return showDuration;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }

    public void setShowDuration(String showDuration) {
        this.showDuration = showDuration;
    }
}
