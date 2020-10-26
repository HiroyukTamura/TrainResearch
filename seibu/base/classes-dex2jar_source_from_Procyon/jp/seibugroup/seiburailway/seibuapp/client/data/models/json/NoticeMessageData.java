// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.data.models.json;

import android.support.annotation.NonNull;
import java.util.List;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class NoticeMessageData implements Serializable, Comparable<NoticeMessageData>
{
    @SerializedName("areaCode")
    private String mAreaCode;
    @SerializedName("blockable")
    private String mBlockable;
    @SerializedName("closeDateTime")
    private String mCloseDateTime;
    @SerializedName("content")
    private List<String> mContentList;
    @SerializedName("couponCode")
    private String mCouponCode;
    @SerializedName("date")
    private String mDate;
    @SerializedName("eventCode")
    private String mEventCode;
    @SerializedName("imageUrl")
    private List<String> mImageUrlList;
    @SerializedName("label")
    private List<String> mLabelList;
    @SerializedName("noticeId")
    private String mNoticeId;
    @SerializedName("noticeType")
    private String mNoticeType;
    @SerializedName("openDateTime")
    private String mOpenDateTime;
    @SerializedName("priority")
    private int mPriority;
    @SerializedName("title")
    private String mTitle;
    @SerializedName("toUrl")
    private List<String> mToUrlList;
    @SerializedName("viaBrowser")
    private List<Boolean> mViaBrowserList;
    
    @Override
    public int compareTo(@NonNull final NoticeMessageData noticeMessageData) {
        return noticeMessageData.getPriority() - this.getPriority();
    }
    
    public String getAreaCode() {
        return this.mAreaCode;
    }
    
    public String getBlockable() {
        return this.mBlockable;
    }
    
    public String getCloseDateTime() {
        return this.mCloseDateTime;
    }
    
    public List<String> getContentList() {
        return this.mContentList;
    }
    
    public String getCouponCode() {
        return this.mCouponCode;
    }
    
    public String getDate() {
        return this.mDate;
    }
    
    public String getEventCode() {
        return this.mEventCode;
    }
    
    public List<String> getImageUrlList() {
        return this.mImageUrlList;
    }
    
    public List<String> getLabelList() {
        return this.mLabelList;
    }
    
    public String getNoticeId() {
        return this.mNoticeId;
    }
    
    public String getNoticeType() {
        return this.mNoticeType;
    }
    
    public String getOpenDateTime() {
        return this.mOpenDateTime;
    }
    
    public int getPriority() {
        return this.mPriority;
    }
    
    public String getTitle() {
        return this.mTitle;
    }
    
    public List<String> getToUrlList() {
        return this.mToUrlList;
    }
    
    public List<Boolean> getViaBrowserList() {
        return this.mViaBrowserList;
    }
    
    public void setAreaCode(final String mAreaCode) {
        this.mAreaCode = mAreaCode;
    }
    
    public void setBlockable(final String mBlockable) {
        this.mBlockable = mBlockable;
    }
    
    public void setCloseDateTime(final String mCloseDateTime) {
        this.mCloseDateTime = mCloseDateTime;
    }
    
    public void setCouponCode(final String mCouponCode) {
        this.mCouponCode = mCouponCode;
    }
    
    public void setDate(final String mDate) {
        this.mDate = mDate;
    }
    
    public void setEventCode(final String mEventCode) {
        this.mEventCode = mEventCode;
    }
    
    public void setNoticeId(final String mNoticeId) {
        this.mNoticeId = mNoticeId;
    }
    
    public void setNoticeType(final String mNoticeType) {
        this.mNoticeType = mNoticeType;
    }
    
    public void setOpenDateTime(final String mOpenDateTime) {
        this.mOpenDateTime = mOpenDateTime;
    }
    
    public void setPriority(final int mPriority) {
        this.mPriority = mPriority;
    }
    
    public void setTitle(final String mTitle) {
        this.mTitle = mTitle;
    }
}
