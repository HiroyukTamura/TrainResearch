// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.data.models.master;

import com.annimon.stream.function.Predicate;
import com.annimon.stream.Stream;
import android.support.v4.util.Pair;
import java.util.List;

public class RouteConfig
{
    private String routeId;
    private String routeName;
    private List<StationConfig> stations;
    private Integer[] stopXoffset;
    
    public RouteConfig(final String routeId, final String routeName) {
        this.routeId = routeId;
        this.routeName = routeName;
    }
    
    public int getMainLineXoffset(final String anObject, final boolean b) {
        if ("up".equals(anObject)) {
            Integer n;
            if (b) {
                n = this.stopXoffset[1];
            }
            else {
                n = this.stopXoffset[0];
            }
            return n;
        }
        Integer n2;
        if (b) {
            n2 = this.stopXoffset[2];
        }
        else {
            n2 = this.stopXoffset[3];
        }
        return n2;
    }
    
    public String getRouteId() {
        return this.routeId;
    }
    
    public String getRouteName() {
        return this.routeName;
    }
    
    public List<StationConfig> getStations() {
        return this.stations;
    }
    
    public Integer[] getStopXoffset() {
        return this.stopXoffset;
    }
    
    public int getSubLineXoffset(final String s, final String s2, final String s3) {
        if (Stream.of((Pair[])BaseConfig.SUBLINE_LEFT).filter(RouteConfig$$Lambda$1.lambdaFactory$(s2, s3)).findFirst().isPresent()) {
            Integer n;
            if ("up".equals(s)) {
                n = this.stopXoffset[4];
            }
            else {
                n = this.stopXoffset[5];
            }
            return n;
        }
        if (Stream.of((Pair[])BaseConfig.SUBLINE_RIGHT).filter(RouteConfig$$Lambda$2.lambdaFactory$(s2, s3)).findFirst().isPresent()) {
            Integer n2;
            if ("up".equals(s)) {
                n2 = this.stopXoffset[6];
            }
            else {
                n2 = this.stopXoffset[7];
            }
            return n2;
        }
        return -1;
    }
    
    public void setRouteId(final String routeId) {
        this.routeId = routeId;
    }
    
    public void setRoutenName(final String routeName) {
        this.routeName = routeName;
    }
    
    public void setStations(final List<StationConfig> stations) {
        this.stations = stations;
    }
    
    public void setStopXoffset(final Integer[] stopXoffset) {
        this.stopXoffset = stopXoffset;
    }
}
