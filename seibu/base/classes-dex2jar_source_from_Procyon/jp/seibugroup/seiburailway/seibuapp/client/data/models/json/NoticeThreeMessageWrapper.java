// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.data.models.json;

import java.io.Serializable;

public class NoticeThreeMessageWrapper implements Serializable
{
    private NoticeMessageWrapper headlines;
    private NoticeMessageWrapper home;
    private long homeUnreadCount;
    private NoticeMessageWrapper wallpapers;
    
    public NoticeMessageWrapper getHeadlines() {
        return this.headlines;
    }
    
    public NoticeMessageWrapper getHome() {
        return this.home;
    }
    
    public long getHomeUnreadCount() {
        return this.homeUnreadCount;
    }
    
    public NoticeMessageWrapper getWallpapers() {
        return this.wallpapers;
    }
    
    public void setHeadlines(final NoticeMessageWrapper headlines) {
        this.headlines = headlines;
    }
    
    public void setHome(final NoticeMessageWrapper home) {
        this.home = home;
    }
    
    public void setHomeUnreadCount(final long homeUnreadCount) {
        this.homeUnreadCount = homeUnreadCount;
    }
    
    public void setWallpapers(final NoticeMessageWrapper wallpapers) {
        this.wallpapers = wallpapers;
    }
}
