// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.data.models.greendao;

public class NoticeMessageReadHistory
{
    private String noticeId;
    
    public NoticeMessageReadHistory() {
    }
    
    public NoticeMessageReadHistory(final String noticeId) {
        this.noticeId = noticeId;
    }
    
    public String getNoticeId() {
        return this.noticeId;
    }
    
    public void setNoticeId(final String noticeId) {
        this.noticeId = noticeId;
    }
}
