// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.data.models.json;

import android.text.TextUtils;
import jp.seibugroup.seiburailway.seibuapp.client.util.ChangeRomajiNameUtils;
import jp.seibugroup.seiburailway.seibuapp.client.util.FirstKanaLetterFromRomaji;
import java.util.List;
import java.io.Serializable;
import me.yokeyword.indexablerv.IndexableEntity;

public class StationInfo implements IndexableEntity, Serializable
{
    private String areaInfoUrl;
    private String busSiteUrl;
    private FloorMap floorMap;
    private boolean hasBeacons;
    private boolean hasPointChecker;
    private List<LineInfo> line;
    private String notice;
    private List<PlatformImages> platformImages;
    private PointCheckerDescription pointCheckerDescription;
    private String restaurantInfoUrl;
    private String shopInfoUrl;
    private String stationId;
    private String stationName;
    private String stationNameRomaji;
    private List<String> stationNo;
    private String stationSignImageUrl;
    private List<String> trainType;
    private String trainTypeDescription;
    private List<TransferData> transfer;
    private String transitUrl;
    private Weather weather;
    
    public String getAreaInfoUrl() {
        return this.areaInfoUrl;
    }
    
    public String getBusSiteUrl() {
        return this.busSiteUrl;
    }
    
    public String getFieldIndexBy() {
        return FirstKanaLetterFromRomaji.getFirstKanaLetter(this.stationNameRomaji);
    }
    
    public FloorMap getFloorMap() {
        return this.floorMap;
    }
    
    public boolean getHasBeacons() {
        return this.hasBeacons;
    }
    
    public boolean getHasPointChecker() {
        return this.hasPointChecker;
    }
    
    public List<LineInfo> getLine() {
        return this.line;
    }
    
    public String getNotice() {
        return this.notice;
    }
    
    public List<PlatformImages> getPlatformImages() {
        return this.platformImages;
    }
    
    public PointCheckerDescription getPointCheckerDescription() {
        return this.pointCheckerDescription;
    }
    
    public String getRestaurantInfoUrl() {
        return this.restaurantInfoUrl;
    }
    
    public String getShopInfoUrl() {
        return this.shopInfoUrl;
    }
    
    public String getStationId() {
        return this.stationId;
    }
    
    public String getStationName() {
        return this.stationName;
    }
    
    public String getStationNameRomaji() {
        return ChangeRomajiNameUtils.changeRomajiName(this.stationNameRomaji);
    }
    
    public List<String> getStationNo() {
        return this.stationNo;
    }
    
    public String getStationSignImageUrl() {
        return this.stationSignImageUrl;
    }
    
    public List<String> getTrainType() {
        return this.trainType;
    }
    
    public String getTrainTypeDescription() {
        return this.trainTypeDescription;
    }
    
    public List<TransferData> getTransfer() {
        return this.transfer;
    }
    
    public String getTransitUrl() {
        return this.transitUrl;
    }
    
    public Weather getWeather() {
        return this.weather;
    }
    
    public void setAreaInfoUrl(final String areaInfoUrl) {
        this.areaInfoUrl = areaInfoUrl;
    }
    
    public void setBusSiteUrl(final String busSiteUrl) {
        this.busSiteUrl = busSiteUrl;
    }
    
    public void setFieldIndexBy(final String s) {
    }
    
    public void setFieldPinyinIndexBy(final String s) {
    }
    
    public void setFloorMap(final FloorMap floorMap) {
        this.floorMap = floorMap;
    }
    
    public void setHasBeacons(final boolean hasBeacons) {
        this.hasBeacons = hasBeacons;
    }
    
    public void setHasPointChecker(final boolean hasPointChecker) {
        this.hasPointChecker = hasPointChecker;
    }
    
    public void setLine(final List<LineInfo> line) {
        this.line = line;
    }
    
    public void setNotice(final String notice) {
        this.notice = notice;
    }
    
    public void setPlatformImages(final List<PlatformImages> platformImages) {
        this.platformImages = platformImages;
    }
    
    public void setPointCheckerDescription(final PointCheckerDescription pointCheckerDescription) {
        this.pointCheckerDescription = pointCheckerDescription;
    }
    
    public void setRestaurantInfoUrl(final String restaurantInfoUrl) {
        this.restaurantInfoUrl = restaurantInfoUrl;
    }
    
    public void setShopInfoUrl(final String shopInfoUrl) {
        this.shopInfoUrl = shopInfoUrl;
    }
    
    public void setStationId(final String stationId) {
        this.stationId = stationId;
    }
    
    public void setStationName(final String stationName) {
        this.stationName = stationName;
    }
    
    public void setStationNameRomaji(final String stationNameRomaji) {
        this.stationNameRomaji = stationNameRomaji;
    }
    
    public void setStationNo(final List<String> stationNo) {
        this.stationNo = stationNo;
    }
    
    public void setStationSignImageUrl(final String stationSignImageUrl) {
        this.stationSignImageUrl = stationSignImageUrl;
    }
    
    public void setTrainType(final List<String> trainType) {
        this.trainType = trainType;
    }
    
    public void setTrainTypeDescription(final String trainTypeDescription) {
        this.trainTypeDescription = trainTypeDescription;
    }
    
    public void setTransfer(final List<TransferData> transfer) {
        this.transfer = transfer;
    }
    
    public void setTransitUrl(final String transitUrl) {
        this.transitUrl = transitUrl;
    }
    
    public void setWeather(final Weather weather) {
        this.weather = weather;
    }
    
    public static class FloorMap implements Serializable
    {
        private String birdseyeViewUrl;
        private String flatViewUrl;
        private String mapKeyUrl;
        
        public String getBirdseyeViewUrl() {
            return this.birdseyeViewUrl;
        }
        
        public String getFlatViewUrl() {
            return this.flatViewUrl;
        }
        
        public String getMapKeyUrl() {
            return this.mapKeyUrl;
        }
        
        public boolean isEmpty() {
            return TextUtils.isEmpty((CharSequence)this.birdseyeViewUrl) && TextUtils.isEmpty((CharSequence)this.flatViewUrl) && TextUtils.isEmpty((CharSequence)this.mapKeyUrl);
        }
        
        public void setBirdseyeViewUrl(final String birdseyeViewUrl) {
            this.birdseyeViewUrl = birdseyeViewUrl;
        }
        
        public void setFlatViewUrl(final String flatViewUrl) {
            this.flatViewUrl = flatViewUrl;
        }
        
        public void setMapKeyUrl(final String mapKeyUrl) {
            this.mapKeyUrl = mapKeyUrl;
        }
    }
    
    public static class PlatformImages implements Serializable
    {
        private String imageUrl;
        private int numberOfCars;
        
        public String getImageUrl() {
            return this.imageUrl;
        }
        
        public int getNumberOfCars() {
            return this.numberOfCars;
        }
        
        public void setImageUrl(final String imageUrl) {
            this.imageUrl = imageUrl;
        }
        
        public void setNumberOfCars(final int numberOfCars) {
            this.numberOfCars = numberOfCars;
        }
    }
}
