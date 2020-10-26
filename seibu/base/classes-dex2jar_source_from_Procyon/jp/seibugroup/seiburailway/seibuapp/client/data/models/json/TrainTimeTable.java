// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.data.models.json;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class TrainTimeTable implements Serializable
{
    @SerializedName("scheduledTime")
    String arriveTime;
    String estimatedTime;
    boolean isPast;
    String lineId;
    String stationId;
    String stationName;
    String stationNo;
    @SerializedName("timeRequired")
    String stopMinutes;
    TrainTimeTableWeather weather;
    
    public String getArriveTime() {
        return this.arriveTime;
    }
    
    public String getEstimatedTime() {
        return this.estimatedTime;
    }
    
    public String getLineId() {
        return this.lineId;
    }
    
    public String getStationId() {
        return this.stationId;
    }
    
    public String getStationName() {
        return this.stationName;
    }
    
    public String getStationNo() {
        return this.stationNo;
    }
    
    public String getStopMinutes() {
        return this.stopMinutes;
    }
    
    public TrainTimeTableWeather getWeather() {
        return this.weather;
    }
    
    public boolean isPast() {
        return this.isPast;
    }
    
    public void setArriveTime(final String arriveTime) {
        this.arriveTime = arriveTime;
    }
    
    public void setEstimatedTime(final String estimatedTime) {
        this.estimatedTime = estimatedTime;
    }
    
    public void setLineId(final String lineId) {
        this.lineId = lineId;
    }
    
    public void setPast(final boolean isPast) {
        this.isPast = isPast;
    }
    
    public void setStationId(final String stationId) {
        this.stationId = stationId;
    }
    
    public void setStationName(final String stationName) {
        this.stationName = stationName;
    }
    
    public void setStationNo(final String stationNo) {
        this.stationNo = stationNo;
    }
    
    public void setStopMinutes(final String stopMinutes) {
        this.stopMinutes = stopMinutes;
    }
    
    public void setWeather(final TrainTimeTableWeather weather) {
        this.weather = weather;
    }
    
    public class TrainTimeTableWeather implements Serializable
    {
        String temperature;
        String weatherCode;
        
        public String getTemperature() {
            return this.temperature;
        }
        
        public String getWeatherCode() {
            return this.weatherCode;
        }
        
        public void setTemperature(final String temperature) {
            this.temperature = temperature;
        }
        
        public void setWeatherCode(final String weatherCode) {
            this.weatherCode = weatherCode;
        }
    }
}
