// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.data.models.json;

import android.text.TextUtils;
import jp.seibugroup.seiburailway.seibuapp.client.util.Constants;
import jp.seibugroup.seiburailway.seibuapp.client.CTCApplication_;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class PushInfo implements Serializable
{
    @SerializedName("m")
    private String content;
    @SerializedName("c")
    private String contentTitle;
    private String eventType;
    @SerializedName("i2")
    private String imageUrl;
    @SerializedName("l")
    private String lineId;
    private String noticeID;
    @SerializedName("i1")
    private String thumbnailImageUrl;
    private String title;
    @SerializedName("u")
    private String toUrl;
    @SerializedName("t")
    private String trainId;
    @SerializedName("k")
    private String type;
    @SerializedName("w")
    private String viaBrowser;
    
    public String getContent() {
        return this.content;
    }
    
    public String getContentTitle() {
        return this.contentTitle;
    }
    
    public String getEventTitle() {
        switch (this.getEventType()) {
            default: {
                return "";
            }
            case NEWS: {
                return CTCApplication_.getInstance().getString(2131231031);
            }
            case STATIONS: {
                return CTCApplication_.getInstance().getString(2131231033);
            }
            case TICKET: {
                return CTCApplication_.getInstance().getString(2131231034);
            }
            case WAYSIDE: {
                return CTCApplication_.getInstance().getString(2131231035);
            }
            case ACTIVITY: {
                return CTCApplication_.getInstance().getString(2131231027);
            }
            case COMPANY: {
                return CTCApplication_.getInstance().getString(2131231028);
            }
            case EVENTS: {
                return CTCApplication_.getInstance().getString(2131231030);
            }
            case COUPONS: {
                return CTCApplication_.getInstance().getString(2131231029);
            }
            case OTHER: {
                return CTCApplication_.getInstance().getString(2131231032);
            }
        }
    }
    
    public Constants.PushType getEventType() {
        final String eventType = this.eventType;
        switch (eventType) {
            default: {
                return Constants.PushType.NULL;
            }
            case "1": {
                return Constants.PushType.NEWS;
            }
            case "2": {
                return Constants.PushType.STATIONS;
            }
            case "3": {
                return Constants.PushType.TICKET;
            }
            case "4": {
                return Constants.PushType.WAYSIDE;
            }
            case "5": {
                return Constants.PushType.ACTIVITY;
            }
            case "6": {
                return Constants.PushType.COMPANY;
            }
            case "7": {
                return Constants.PushType.EVENTS;
            }
            case "8": {
                return Constants.PushType.COUPONS;
            }
            case "9": {
                return Constants.PushType.OTHER;
            }
        }
    }
    
    public String getImageUrl() {
        return this.imageUrl;
    }
    
    public String getLineId() {
        return this.lineId;
    }
    
    public String getNoticeID() {
        return this.noticeID;
    }
    
    public String getThumbnailImageUrl() {
        return this.thumbnailImageUrl;
    }
    
    public String getTitle() {
        switch (this.getType()) {
            default: {
                return "";
            }
            case EVENT: {
                return this.getEventTitle();
            }
            case NOTIFICATION: {
                return CTCApplication_.getInstance().getString(2131231037);
            }
            case RUN: {
                return CTCApplication_.getInstance().getString(2131231040);
            }
            case ARRIVAL:
            case STATION: {
                return CTCApplication_.getInstance().getString(2131231024);
            }
            case POSTMARK: {
                return CTCApplication_.getInstance().getString(2131231039);
            }
            case COUPON: {
                return CTCApplication_.getInstance().getString(2131231025);
            }
        }
    }
    
    public String getToUrl() {
        return this.toUrl;
    }
    
    public String getTrainId() {
        return this.trainId;
    }
    
    public Constants.PushType getType() {
        if (TextUtils.isEmpty((CharSequence)this.type)) {
            return Constants.PushType.NULL;
        }
        final String type = this.type;
        switch (type) {
            default: {
                return Constants.PushType.NULL;
            }
            case "0": {
                return Constants.PushType.EVENT;
            }
            case "1": {
                return Constants.PushType.NOTIFICATION;
            }
            case "2": {
                return Constants.PushType.RUN;
            }
            case "3": {
                return Constants.PushType.ARRIVAL;
            }
            case "4": {
                return Constants.PushType.STATION;
            }
            case "5": {
                return Constants.PushType.POSTMARK;
            }
            case "6": {
                return Constants.PushType.COUPON;
            }
        }
    }
    
    public String isViaBrowser() {
        return this.viaBrowser;
    }
    
    public void setContent(final String content) {
        this.content = content;
    }
    
    public void setContentTitle(final String contentTitle) {
        this.contentTitle = contentTitle;
    }
    
    public void setEventType(final String eventType) {
        this.eventType = eventType;
    }
    
    public void setImageUrl(final String imageUrl) {
        this.imageUrl = imageUrl;
    }
    
    public void setLineId(final String lineId) {
        this.lineId = lineId;
    }
    
    public void setNoticeID(final String noticeID) {
        this.noticeID = noticeID;
    }
    
    public void setThumbnailImageUrl(final String thumbnailImageUrl) {
        this.thumbnailImageUrl = thumbnailImageUrl;
    }
    
    public void setTitle(final String title) {
        this.title = title;
    }
    
    public void setToUrl(final String toUrl) {
        this.toUrl = toUrl;
    }
    
    public void setTrainId(final String trainId) {
        this.trainId = trainId;
    }
    
    public void setType(final String type) {
        this.type = type;
    }
    
    public void setViaBrowser(final String viaBrowser) {
        this.viaBrowser = viaBrowser;
    }
}
