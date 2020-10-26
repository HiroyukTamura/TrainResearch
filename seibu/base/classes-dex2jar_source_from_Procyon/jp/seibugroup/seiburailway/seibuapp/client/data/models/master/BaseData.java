// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.data.models.master;

import com.annimon.stream.Optional;
import com.annimon.stream.function.Predicate;
import com.annimon.stream.Stream;
import java.util.Date;
import jp.seibugroup.seiburailway.seibuapp.client.util.TimeUtils;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class BaseData
{
    private static final String DATE_FORMAT = "yyyyMMddHHmmss";
    @SerializedName("company")
    private List<BaseCompany> companys;
    private List<ExternalLinkUrl> externalLinkUrl;
    private List<BaseRouteGroup> lineGroup;
    @SerializedName("created")
    private String releaseDate;
    @SerializedName("line")
    private List<BaseRoute> routes;
    @SerializedName("stationLine")
    private List<BaseStationLine> stationLines;
    @SerializedName("station")
    private List<BaseStation> stations;
    @SerializedName("trainType")
    private List<BaseTrain> trains;
    @SerializedName("ttl")
    private long validPeriod;
    @JsonAdapter(IntStringAdapter.class)
    private int version;
    
    public List<BaseCompany> getCompanys() {
        return this.companys;
    }
    
    public long getExpiredTime() {
        final Date dateFromString = TimeUtils.dateFromString(this.releaseDate, "yyyyMMddHHmmss");
        if (dateFromString != null) {
            return dateFromString.getTime() + this.validPeriod * 1000L;
        }
        return 0L;
    }
    
    public List<ExternalLinkUrl> getExternalLinkUrl() {
        return this.externalLinkUrl;
    }
    
    public List<BaseRouteGroup> getLineGroup() {
        return this.lineGroup;
    }
    
    public String getReleaseDate() {
        return this.releaseDate;
    }
    
    public BaseRoute getRoute(final String s) {
        final Optional<BaseRoute> first = Stream.of((Iterable<? extends BaseRoute>)this.routes).filter(BaseData$$Lambda$2.lambdaFactory$(s)).findFirst();
        if (first.isPresent()) {
            return first.get();
        }
        return null;
    }
    
    public BaseRoute getRouteById(final String s) {
        final Optional<BaseRoute> first = Stream.of((Iterable<? extends BaseRoute>)this.routes).filter(BaseData$$Lambda$4.lambdaFactory$(s)).findFirst();
        if (first.isPresent()) {
            return first.get();
        }
        return null;
    }
    
    public List<BaseRoute> getRoutes() {
        return this.routes;
    }
    
    public BaseStation getStation(final String s) {
        final Optional<BaseStation> first = Stream.of((Iterable<? extends BaseStation>)this.stations).filter(BaseData$$Lambda$1.lambdaFactory$(s)).findFirst();
        if (first.isPresent()) {
            return first.get();
        }
        return null;
    }
    
    public BaseStation getStationById(final String s) {
        final Optional<BaseStation> first = Stream.of((Iterable<? extends BaseStation>)this.stations).filter(BaseData$$Lambda$3.lambdaFactory$(s)).findFirst();
        if (first.isPresent()) {
            return first.get();
        }
        return null;
    }
    
    public List<BaseStationLine> getStationLines() {
        return this.stationLines;
    }
    
    public List<BaseStation> getStations() {
        return this.stations;
    }
    
    public BaseTrain getTrainTypeById(final String s) {
        final Optional<BaseTrain> first = Stream.of((Iterable<? extends BaseTrain>)this.trains).filter(BaseData$$Lambda$5.lambdaFactory$(s)).findFirst();
        if (first.isPresent()) {
            return first.get();
        }
        return null;
    }
    
    public List<BaseTrain> getTrains() {
        return this.trains;
    }
    
    public String getUrl(final String s) {
        final Optional<ExternalLinkUrl> first = Stream.of((Iterable<? extends ExternalLinkUrl>)this.externalLinkUrl).filter(BaseData$$Lambda$6.lambdaFactory$(s)).findFirst();
        if (first.isPresent()) {
            return first.get().getUrl();
        }
        return "";
    }
    
    public long getValidPeriod() {
        return this.validPeriod;
    }
    
    public int getVersion() {
        return this.version;
    }
    
    public void setCompanys(final List<BaseCompany> companys) {
        this.companys = companys;
    }
    
    public void setExternalLinkUrl(final List<ExternalLinkUrl> externalLinkUrl) {
        this.externalLinkUrl = externalLinkUrl;
    }
    
    public void setLineGroup(final List<BaseRouteGroup> lineGroup) {
        this.lineGroup = lineGroup;
    }
    
    public void setReleaseDate(final String releaseDate) {
        this.releaseDate = releaseDate;
    }
    
    public void setRoutes(final List<BaseRoute> routes) {
        this.routes = routes;
    }
    
    public void setStationLines(final List<BaseStationLine> stationLines) {
        this.stationLines = stationLines;
    }
    
    public void setStations(final List<BaseStation> stations) {
        this.stations = stations;
    }
    
    public void setTrains(final List<BaseTrain> trains) {
        this.trains = trains;
    }
    
    public void setValidPeriod(final long validPeriod) {
        this.validPeriod = validPeriod;
    }
    
    public void setVersion(final int version) {
        this.version = version;
    }
}
