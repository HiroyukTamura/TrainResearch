// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.data.models.view;

import com.annimon.stream.Optional;
import com.annimon.stream.function.Predicate;
import com.annimon.stream.Stream;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.StationInfo;
import jp.seibugroup.seiburailway.seibuapp.client.view.home.mystation.MyStationCardFragment$Model;
import java.util.Map;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.Departure;
import java.util.List;
import java.io.Serializable;

public class StationDeparture implements Serializable
{
    private List<Departure> mDepartures;
    private List<String> mDirectionNames;
    private Map<String, String> mLineMap;
    private MyStationCardFragment$Model mModelType;
    private String mSelectedDirectionName;
    private String mStationId;
    private StationInfo mStationInfo;
    
    public StationDeparture() {
        this.mModelType = MyStationCardFragment$Model.NORMAL;
    }
    
    public StationInfo.FloorMap get() {
        return this.mStationInfo.getFloorMap();
    }
    
    public String getAreaInfoUrl() {
        return this.mStationInfo.getAreaInfoUrl();
    }
    
    public String getBusSiteUrl() {
        return this.mStationInfo.getBusSiteUrl();
    }
    
    public Departure getDepartureData(final String s) {
        if (this.mDepartures != null && s != null) {
            final Optional<Departure> first = Stream.of((Iterable<? extends Departure>)this.mDepartures).filter(StationDeparture$$Lambda$1.lambdaFactory$(s)).findFirst();
            if (first.isPresent()) {
                return first.get();
            }
        }
        return null;
    }
    
    public List<String> getDirectionNames() {
        return this.mDirectionNames;
    }
    
    public String getLineId() {
        if (this.mSelectedDirectionName == null) {
            return null;
        }
        return this.mLineMap.get(this.mSelectedDirectionName);
    }
    
    public String getLineId(final String s) {
        if (s == null) {
            return null;
        }
        return this.mLineMap.get(s);
    }
    
    public MyStationCardFragment$Model getModelType() {
        return this.mModelType;
    }
    
    public String getSelectedDirectionName() {
        if (this.mSelectedDirectionName == null) {
            this.mSelectedDirectionName = this.mDirectionNames.get(0);
        }
        return this.mSelectedDirectionName;
    }
    
    public String getStationId() {
        return this.mStationId;
    }
    
    public StationInfo getStationInfo() {
        return this.mStationInfo;
    }
    
    public String getStationName() {
        return this.mStationInfo.getStationName();
    }
    
    public String getStationNameRoma() {
        return this.mStationInfo.getStationNameRomaji();
    }
    
    public boolean isFloorMapEmpty() {
        return this.mStationInfo.getFloorMap().isEmpty();
    }
    
    public void setDepartures(final List<Departure> mDepartures) {
        this.mDepartures = mDepartures;
    }
    
    public void setDirectionNames(final List<String> mDirectionNames) {
        this.mDirectionNames = mDirectionNames;
    }
    
    public void setLineMap(final Map<String, String> mLineMap) {
        this.mLineMap = mLineMap;
    }
    
    public void setModelType(final MyStationCardFragment$Model mModelType) {
        this.mModelType = mModelType;
    }
    
    public void setSelectedDirectionName(final String mSelectedDirectionName) {
        this.mSelectedDirectionName = mSelectedDirectionName;
    }
    
    public void setStationId(final String mStationId) {
        this.mStationId = mStationId;
    }
    
    public void setStationInfo(final StationInfo mStationInfo) {
        this.mStationInfo = mStationInfo;
    }
}
