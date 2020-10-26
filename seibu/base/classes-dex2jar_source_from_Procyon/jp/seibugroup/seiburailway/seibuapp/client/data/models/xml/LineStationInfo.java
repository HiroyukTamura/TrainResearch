// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.data.models.xml;

import com.annimon.stream.Optional;
import com.annimon.stream.function.Predicate;
import com.annimon.stream.Stream;
import java.util.List;
import java.io.Serializable;

public class LineStationInfo implements Serializable
{
    private List<DirectionCode> direction;
    private LineCode line;
    private StationCode station;
    
    public DirectionCode getDirecitonStart() {
        final Optional<DirectionCode> first = Stream.of((Iterable<? extends DirectionCode>)this.direction).filter(LineStationInfo$$Lambda$2.lambdaFactory$()).findFirst();
        if (first.isPresent()) {
            return first.get();
        }
        return new DirectionCode();
    }
    
    public List<DirectionCode> getDirection() {
        return this.direction;
    }
    
    public DirectionCode getDirectionEnd() {
        final Optional<DirectionCode> first = Stream.of((Iterable<? extends DirectionCode>)this.direction).filter(LineStationInfo$$Lambda$1.lambdaFactory$()).findFirst();
        if (first.isPresent()) {
            return first.get();
        }
        return new DirectionCode();
    }
    
    public LineCode getLine() {
        return this.line;
    }
    
    public StationCode getStation() {
        return this.station;
    }
    
    public void setDirection(final List<DirectionCode> direction) {
        this.direction = direction;
    }
    
    public void setLine(final LineCode line) {
        this.line = line;
    }
    
    public void setStation(final StationCode station) {
        this.station = station;
    }
}
