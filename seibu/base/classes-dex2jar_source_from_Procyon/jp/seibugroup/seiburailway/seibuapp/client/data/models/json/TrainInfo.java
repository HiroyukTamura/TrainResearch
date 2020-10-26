// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.data.models.json;

import android.text.TextUtils;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.master.BaseConfig;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.io.Serializable;

public class TrainInfo implements Serializable
{
    private String carIconUrl;
    private String carNickname;
    private String carType;
    private int delay;
    private String destination;
    private String direction;
    private String endStationName;
    private String endStationNo;
    private String fromStationId;
    private String fromStationName;
    private boolean hasBeacons;
    private int iconResId;
    private boolean isOnRail;
    private boolean isPassing;
    private boolean isValidCheckin;
    private String lineId;
    private String lineName;
    private String note;
    private String numberOfCars;
    private float offset;
    private int sectionNo;
    private String startStationName;
    private String starting;
    private int stationOrder;
    private String status;
    private List<TrainTimeTable> timetable;
    private String toStationId;
    private String toStationName;
    @SerializedName("trainNo")
    private String trainId;
    private String trainType;
    private boolean upDirection;
    private float x;
    private float y;
    
    public static String getDelayString(final int a) {
        final int abs = Math.abs(a);
        String s;
        if (a >= 0) {
            s = "+";
        }
        else {
            s = "-";
        }
        return getDelayString(abs, s);
    }
    
    private static String getDelayString(final int i, final String str) {
        return str + i;
    }
    
    public String getCarIconUrl() {
        return this.carIconUrl;
    }
    
    public String getCarNickname() {
        return this.carNickname;
    }
    
    public String getCarType() {
        return this.carType;
    }
    
    public int getDelay() {
        return this.delay;
    }
    
    public int getDelayMinutes() {
        return this.delay;
    }
    
    public String getDelayString() {
        return getDelayString(this.getDelayMinutes());
    }
    
    public String getDestination() {
        return this.destination;
    }
    
    public String getDirection() {
        return this.direction;
    }
    
    public String getEndStationName() {
        return this.endStationName;
    }
    
    public String getEndStationNo() {
        return this.endStationNo;
    }
    
    public String getFromStationId() {
        return this.fromStationId;
    }
    
    public String getFromStationName() {
        return this.fromStationName;
    }
    
    public int getIconResId() {
        return this.iconResId;
    }
    
    public String getLineId() {
        return this.lineId;
    }
    
    public String getLineName() {
        return this.lineName;
    }
    
    public String getNote() {
        return this.note;
    }
    
    public String getNumberOfCars() {
        return this.numberOfCars;
    }
    
    public float getOffset() {
        return this.offset;
    }
    
    public int getSectionNo() {
        return this.sectionNo;
    }
    
    public String getStartStationName() {
        return this.startStationName;
    }
    
    public String getStarting() {
        return this.starting;
    }
    
    public int getStationOrder() {
        return this.stationOrder;
    }
    
    public String getStatus() {
        return this.status;
    }
    
    public List<TrainTimeTable> getTimetable() {
        return this.timetable;
    }
    
    public String getToStationId() {
        return this.toStationId;
    }
    
    public String getToStationName() {
        return this.toStationName;
    }
    
    public String getTrainId() {
        return this.trainId;
    }
    
    public String getTrainType() {
        return this.trainType;
    }
    
    public float getX() {
        return this.x;
    }
    
    public float getY() {
        return this.y;
    }
    
    public boolean isHasBeacons() {
        return this.hasBeacons;
    }
    
    public boolean isOnRail() {
        return this.isOnRail;
    }
    
    public boolean isPassing() {
        return this.isPassing;
    }
    
    public boolean isSamePosition(final TrainInfo trainInfo) {
        final boolean b = true;
        if (BaseConfig.ALL_STOP_CODE.contains(this.trainType) != !BaseConfig.ALL_STOP_CODE.contains(trainInfo.trainType) && this.direction.equals(trainInfo.direction)) {
            if (TextUtils.isEmpty((CharSequence)this.toStationId) && TextUtils.isEmpty((CharSequence)trainInfo.toStationId)) {
                return this.fromStationId.equals(trainInfo.fromStationId);
            }
            if (!TextUtils.isEmpty((CharSequence)this.toStationId)) {
                return this.toStationId.equals(trainInfo.toStationId) && this.fromStationId.equals(trainInfo.fromStationId) && b;
            }
        }
        return false;
    }
    
    public boolean isUpDirection() {
        return this.direction.equals("up");
    }
    
    public boolean isValidCheckin() {
        return this.isValidCheckin;
    }
    
    public void setCarIconUrl(final String carIconUrl) {
        this.carIconUrl = carIconUrl;
    }
    
    public void setCarNickname(final String carNickname) {
        this.carNickname = carNickname;
    }
    
    public void setCarType(final String carType) {
        this.carType = carType;
    }
    
    public void setDelay(final int delay) {
        this.delay = delay;
    }
    
    public void setDestination(final String destination) {
        this.destination = destination;
    }
    
    public void setDirection(final String direction) {
        this.direction = direction;
    }
    
    public void setEndStationName(final String endStationName) {
        this.endStationName = endStationName;
    }
    
    public void setEndStationNo(final String endStationNo) {
        this.endStationNo = endStationNo;
    }
    
    public void setFromStationId(final String fromStationId) {
        this.fromStationId = fromStationId;
    }
    
    public void setFromStationName(final String fromStationName) {
        this.fromStationName = fromStationName;
    }
    
    public void setHasBeacons(final boolean hasBeacons) {
        this.hasBeacons = hasBeacons;
    }
    
    public void setIconResId(final int iconResId) {
        this.iconResId = iconResId;
    }
    
    public void setLineId(final String lineId) {
        this.lineId = lineId;
    }
    
    public void setLineName(final String lineName) {
        this.lineName = lineName;
    }
    
    public void setNote(final String note) {
        this.note = note;
    }
    
    public void setNumberOfCars(final String numberOfCars) {
        this.numberOfCars = numberOfCars;
    }
    
    public void setOffset(final float offset) {
        this.offset = offset;
    }
    
    public void setOnRail(final boolean isOnRail) {
        this.isOnRail = isOnRail;
    }
    
    public void setPassing(final boolean isPassing) {
        this.isPassing = isPassing;
    }
    
    public void setSectionNo(final int sectionNo) {
        this.sectionNo = sectionNo;
    }
    
    public void setStartStationName(final String startStationName) {
        this.startStationName = startStationName;
    }
    
    public void setStarting(final String starting) {
        this.starting = starting;
    }
    
    public void setStationOrder(final int stationOrder) {
        this.stationOrder = stationOrder;
    }
    
    public void setStatus(final String status) {
        this.status = status;
    }
    
    public void setTimetable(final List<TrainTimeTable> timetable) {
        this.timetable = timetable;
    }
    
    public void setToStationId(final String toStationId) {
        this.toStationId = toStationId;
    }
    
    public void setToStationName(final String toStationName) {
        this.toStationName = toStationName;
    }
    
    public void setTrainId(final String trainId) {
        this.trainId = trainId;
    }
    
    public void setTrainType(final String trainType) {
        this.trainType = trainType;
    }
    
    public void setUpDirection(final boolean upDirection) {
        this.upDirection = upDirection;
    }
    
    public void setValidCheckin(final boolean isValidCheckin) {
        this.isValidCheckin = isValidCheckin;
    }
    
    public void setX(final float x) {
        this.x = x;
    }
    
    public void setY(final float y) {
        this.y = y;
    }
}
