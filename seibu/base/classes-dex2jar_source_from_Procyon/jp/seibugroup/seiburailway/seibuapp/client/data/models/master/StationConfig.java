// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.data.models.master;

import android.text.TextUtils;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.TrainInfo;
import android.graphics.Rect;

public class StationConfig
{
    public static final int LOCATION_ERR = -9999;
    private String changeLineName1;
    private String changeLineName2;
    private Rect changeLineRect1;
    private Rect changeLineRect2;
    private String changeStationId1;
    private String changeStationId2;
    private int height;
    private String id;
    private String name;
    private Rect nameRect;
    private int offset;
    private Rect otherLineRect;
    
    int getCenterOffset() {
        return this.offset + this.height / 2;
    }
    
    public String getChangeLineName1() {
        return this.changeLineName1;
    }
    
    public String getChangeLineName2() {
        return this.changeLineName2;
    }
    
    public Rect getChangeLineRect1() {
        return this.changeLineRect1;
    }
    
    public Rect getChangeLineRect2() {
        return this.changeLineRect2;
    }
    
    public String getChangeStationId1() {
        return this.changeStationId1;
    }
    
    public String getChangeStationId2() {
        return this.changeStationId2;
    }
    
    public int getHeight() {
        return this.height;
    }
    
    public String getId() {
        return this.id;
    }
    
    public int getMarginTop(final TrainInfo trainInfo) {
        if (!TextUtils.isEmpty((CharSequence)trainInfo.getToStationId())) {
            if (!TextUtils.equals((CharSequence)trainInfo.getToStationId(), (CharSequence)"S0200TO") && !TextUtils.equals((CharSequence)trainInfo.getFromStationId(), (CharSequence)"S0200TO")) {
                if (TextUtils.equals((CharSequence)trainInfo.getFromStationId(), (CharSequence)"S1500SB")) {
                    return -this.height / 2;
                }
                return this.height / 2;
            }
        }
        else {
            if (TextUtils.isEmpty((CharSequence)trainInfo.getFromStationId())) {
                return -9999;
            }
            if (TextUtils.equals((CharSequence)trainInfo.getFromStationId(), (CharSequence)"S0200TO")) {
                return this.height / 3;
            }
        }
        return 0;
    }
    
    public String getName() {
        return this.name;
    }
    
    public Rect getNameRect() {
        return this.nameRect;
    }
    
    public int getOffset() {
        return this.offset;
    }
    
    public Rect getOtherLineRect() {
        return this.otherLineRect;
    }
    
    public void setChangeLineName1(final String changeLineName1) {
        this.changeLineName1 = changeLineName1;
    }
    
    public void setChangeLineName2(final String changeLineName2) {
        this.changeLineName2 = changeLineName2;
    }
    
    public void setChangeLineRect1(final Rect changeLineRect1) {
        this.changeLineRect1 = changeLineRect1;
    }
    
    public void setChangeLineRect2(final Rect changeLineRect2) {
        this.changeLineRect2 = changeLineRect2;
    }
    
    public void setChangeStationId1(final String changeStationId1) {
        this.changeStationId1 = changeStationId1;
    }
    
    public void setChangeStationId2(final String changeStationId2) {
        this.changeStationId2 = changeStationId2;
    }
    
    public void setHeight(final int height) {
        this.height = height;
    }
    
    public void setId(final String id) {
        this.id = id;
    }
    
    public void setName(final String name) {
        this.name = name;
    }
    
    public void setNameRect(final Rect nameRect) {
        this.nameRect = nameRect;
    }
    
    public void setOffset(final int offset) {
        this.offset = offset;
    }
    
    public void setOtherLineRect(final Rect otherLineRect) {
        this.otherLineRect = otherLineRect;
    }
}
