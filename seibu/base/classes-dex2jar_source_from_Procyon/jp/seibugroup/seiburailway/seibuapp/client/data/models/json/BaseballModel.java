// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.data.models.json;

public class BaseballModel
{
    private String date;
    private String inning;
    private boolean isHomeGame;
    private boolean isPlaying;
    private String opposingTeam;
    private String score;
    private String startTime;
    private String status;
    private String url;
    
    public String getDate() {
        return this.date;
    }
    
    public String getInning() {
        return this.inning;
    }
    
    public String getOpposingTeam() {
        return this.opposingTeam;
    }
    
    public String getScore() {
        return this.score;
    }
    
    public String getStartTime() {
        return this.startTime;
    }
    
    public String getStatus() {
        return this.status;
    }
    
    public String getUrl() {
        return this.url;
    }
    
    public boolean isHomeGame() {
        return this.isHomeGame;
    }
    
    public boolean isPlaying() {
        return this.isPlaying;
    }
    
    public void setDate(final String date) {
        this.date = date;
    }
    
    public void setHomeGame(final boolean isHomeGame) {
        this.isHomeGame = isHomeGame;
    }
    
    public void setInning(final String inning) {
        this.inning = inning;
    }
    
    public void setOpposingTeam(final String opposingTeam) {
        this.opposingTeam = opposingTeam;
    }
    
    public void setPlaying(final boolean isPlaying) {
        this.isPlaying = isPlaying;
    }
    
    public void setScore(final String score) {
        this.score = score;
    }
    
    public void setStartTime(final String startTime) {
        this.startTime = startTime;
    }
    
    public void setStatus(final String status) {
        this.status = status;
    }
    
    public void setUrl(final String url) {
        this.url = url;
    }
}
