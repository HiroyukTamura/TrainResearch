// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.data.models.xml;

import android.text.TextUtils;

public class TimeTableKeyModel
{
    private String directionCode;
    private String lineId;
    private String stationId;
    
    public TimeTableKeyModel(final String lineId, final String stationId, final String directionCode) {
        this.lineId = lineId;
        this.stationId = stationId;
        this.directionCode = directionCode;
    }
    
    @Override
    public boolean equals(final Object obj) {
        if (obj instanceof TimeTableKeyModel) {
            final TimeTableKeyModel timeTableKeyModel = (TimeTableKeyModel)obj;
            return TextUtils.equals((CharSequence)timeTableKeyModel.getDirectionCode(), (CharSequence)this.directionCode) && TextUtils.equals((CharSequence)timeTableKeyModel.getLineId(), (CharSequence)this.lineId) && TextUtils.equals((CharSequence)timeTableKeyModel.getStationId(), (CharSequence)this.stationId);
        }
        return super.equals(obj);
    }
    
    public String getDirectionCode() {
        return this.directionCode;
    }
    
    public String getLineId() {
        return this.lineId;
    }
    
    public String getStationId() {
        return this.stationId;
    }
    
    @Override
    public int hashCode() {
        return (this.directionCode + this.lineId + this.stationId).hashCode();
    }
    
    public void setDirectionCode(final String directionCode) {
        this.directionCode = directionCode;
    }
    
    public void setLineId(final String lineId) {
        this.lineId = lineId;
    }
    
    public void setStationId(final String stationId) {
        this.stationId = stationId;
    }
}
