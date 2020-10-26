// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.data.models.master;

import jp.seibugroup.seiburailway.seibuapp.client.util.ChangeRomajiNameUtils;
import com.google.gson.annotations.SerializedName;

public class BaseRoute
{
    @SerializedName("outboundDirectionName")
    private String downName;
    @SerializedName("startStationId")
    private String fromId;
    @SerializedName("lineId")
    private String id;
    private String lineGroupId;
    private String lineNumber;
    @SerializedName("lineNameKanji")
    private String name;
    @SerializedName("lineNameRoma")
    private String romajiName;
    @SerializedName("terminalStationId")
    private String toId;
    @SerializedName("inboundDirectionName")
    private String upName;
    
    public BaseRoute() {
    }
    
    public BaseRoute(final String id, final String lineGroupId, final String lineNumber, final String name, final String romajiName, final String fromId, final String toId, final String upName, final String downName) {
        this.id = id;
        this.lineGroupId = lineGroupId;
        this.lineNumber = lineNumber;
        this.name = name;
        this.romajiName = romajiName;
        this.fromId = fromId;
        this.toId = toId;
        this.upName = upName;
        this.downName = downName;
    }
    
    public String getDownName() {
        return this.downName;
    }
    
    public String getFromId() {
        return this.fromId;
    }
    
    public String getId() {
        return this.id;
    }
    
    public String getLineGroupId() {
        return this.lineGroupId;
    }
    
    public String getLineNumber() {
        return this.lineNumber;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getRomajiName() {
        return ChangeRomajiNameUtils.changeRomajiName(this.romajiName);
    }
    
    public String getToId() {
        return this.toId;
    }
    
    public String getUpName() {
        return this.upName;
    }
    
    public void setDownName(final String downName) {
        this.downName = downName;
    }
    
    public void setFromId(final String fromId) {
        this.fromId = fromId;
    }
    
    public void setId(final String id) {
        this.id = id;
    }
    
    public void setLineGroupId(final String lineGroupId) {
        this.lineGroupId = lineGroupId;
    }
    
    public void setLineNumber(final String lineNumber) {
        this.lineNumber = lineNumber;
    }
    
    public void setName(final String name) {
        this.name = name;
    }
    
    public void setRomajiName(final String romajiName) {
        this.romajiName = romajiName;
    }
    
    public void setToId(final String toId) {
        this.toId = toId;
    }
    
    public void setUpName(final String upName) {
        this.upName = upName;
    }
}
