// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.data.models.json;

import com.google.gson.annotations.SerializedName;

public class BeaconLocationInfo
{
    @SerializedName("detectedId")
    private String mDetectedId;
    @SerializedName("location")
    private Location mLocation;
    
    public String getDetectedId() {
        return this.mDetectedId;
    }
    
    public Location getLocation() {
        return this.mLocation;
    }
    
    public static class Location
    {
        @SerializedName("carNo")
        private String mCarNo;
        @SerializedName("couponCode")
        private String mCouponCode;
        @SerializedName("eventCode")
        private String mEventCode;
        @SerializedName("fixedOrMobile")
        private String mFixedOrMobile;
        @SerializedName("headCarNo")
        private String mHeadCarNo;
        @SerializedName("lineId")
        private String mLineId;
        @SerializedName("locationId")
        private String mLocationId;
        @SerializedName("locationName")
        private String mLocationName;
        @SerializedName("locationType")
        private String mLocationType;
        @SerializedName("status")
        private String mStatus;
        @SerializedName("stampCode")
        private String mTampCode;
        @SerializedName("trainNo")
        private String mTrainNo;
        
        public String getCarNo() {
            return this.mCarNo;
        }
        
        public String getCouponCode() {
            return this.mCouponCode;
        }
        
        public String getEventCode() {
            return this.mEventCode;
        }
        
        public String getFixedOrMobile() {
            return this.mFixedOrMobile;
        }
        
        public String getHeadCarNo() {
            return this.mHeadCarNo;
        }
        
        public String getLineId() {
            return this.mLineId;
        }
        
        public String getLocationId() {
            return this.mLocationId;
        }
        
        public String getLocationName() {
            return this.mLocationName;
        }
        
        public String getLocationType() {
            return this.mLocationType;
        }
        
        public String getStatus() {
            return this.mStatus;
        }
        
        public String getTampCode() {
            return this.mTampCode;
        }
        
        public String getTrainNo() {
            return this.mTrainNo;
        }
    }
}
