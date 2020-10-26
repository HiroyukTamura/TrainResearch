// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.data.models.json;

import java.io.Serializable;

public class Weather implements Serializable
{
    private String highestTemperature;
    private String lowestTemperature;
    private String precipitation;
    private String temperature;
    private String weatherCode;
    private String windDirection;
    private String windSpeed;
    
    public String getHighestTemperature() {
        return this.highestTemperature;
    }
    
    public String getLowestTemperature() {
        return this.lowestTemperature;
    }
    
    public String getPrecipitation() {
        return this.precipitation;
    }
    
    public String getTemperature() {
        return this.temperature;
    }
    
    public String getWeatherCode() {
        return this.weatherCode;
    }
    
    public String getWindDirection() {
        return this.windDirection;
    }
    
    public String getWindSpeed() {
        return this.windSpeed;
    }
    
    public void setHighestTemperature(final String highestTemperature) {
        this.highestTemperature = highestTemperature;
    }
    
    public void setLowestTemperature(final String lowestTemperature) {
        this.lowestTemperature = lowestTemperature;
    }
    
    public void setPrecipitation(final String precipitation) {
        this.precipitation = precipitation;
    }
    
    public void setTemperature(final String temperature) {
        this.temperature = temperature;
    }
    
    public void setWeatherCode(final String weatherCode) {
        this.weatherCode = weatherCode;
    }
    
    public void setWindDirection(final String windDirection) {
        this.windDirection = windDirection;
    }
    
    public void setWindSpeed(final String windSpeed) {
        this.windSpeed = windSpeed;
    }
}
