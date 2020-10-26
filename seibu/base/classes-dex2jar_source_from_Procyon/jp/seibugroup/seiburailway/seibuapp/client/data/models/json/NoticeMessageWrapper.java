// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.data.models.json;

import java.util.Iterator;
import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class NoticeMessageWrapper
{
    private boolean mHasNewNotices;
    @SerializedName("notice")
    private ArrayList<NoticeMessageData> mNotice;
    @SerializedName("offset")
    private int mOffset;
    @SerializedName("total")
    private int mTotal;
    
    public String getAllNoticeId() {
        final ArrayList<String> list = new ArrayList<String>();
        final Iterator<NoticeMessageData> iterator = this.mNotice.iterator();
        while (iterator.hasNext()) {
            list.add(iterator.next().getNoticeId());
        }
        return TextUtils.join((CharSequence)",", (Iterable)list);
    }
    
    public ArrayList<NoticeMessageData> getNotice() {
        return this.mNotice;
    }
    
    public int getOffset() {
        return this.mOffset;
    }
    
    public int getTotal() {
        return this.mTotal;
    }
    
    public boolean isHasNewNotices() {
        return this.mHasNewNotices;
    }
    
    public void setHasNewNotices(final boolean mHasNewNotices) {
        this.mHasNewNotices = mHasNewNotices;
    }
    
    public void setNotice(final ArrayList<NoticeMessageData> mNotice) {
        this.mNotice = mNotice;
    }
    
    public void setOffset(final int mOffset) {
        this.mOffset = mOffset;
    }
    
    public void setTotal(final int mTotal) {
        this.mTotal = mTotal;
    }
}
