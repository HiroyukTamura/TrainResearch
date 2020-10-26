// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.data.models.json;

import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import android.text.TextUtils;

public class MaintenanceInfo
{
    private String endDateTime;
    private String message;
    private String startDateTime;
    
    public String getEndDateTime() {
        return this.endDateTime;
    }
    
    public String getMessage() {
        return this.message;
    }
    
    public String getStartDateTime() {
        return this.startDateTime;
    }
    
    public boolean isMaintenancing() {
        if (!TextUtils.isEmpty((CharSequence)this.startDateTime) && !TextUtils.isEmpty((CharSequence)this.endDateTime)) {
            final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
            try {
                final Date parse = simpleDateFormat.parse(this.startDateTime);
                final Date parse2 = simpleDateFormat.parse(this.endDateTime);
                final Date date = new Date();
                if (date.getTime() >= parse.getTime() && date.getTime() <= parse2.getTime() && !TextUtils.isEmpty((CharSequence)this.message)) {
                    return true;
                }
            }
            catch (ParseException ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }
    
    public void setEndDateTime(final String endDateTime) {
        this.endDateTime = endDateTime;
    }
    
    public void setMessage(final String message) {
        this.message = message;
    }
    
    public void setStartDateTime(final String startDateTime) {
        this.startDateTime = startDateTime;
    }
}
