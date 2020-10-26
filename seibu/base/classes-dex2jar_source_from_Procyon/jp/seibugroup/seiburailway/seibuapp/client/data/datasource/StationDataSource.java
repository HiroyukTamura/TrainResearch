// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.data.datasource;

import android.location.Location;
import com.feilang.mvpproject.data.datasource.DataSource;

public interface StationDataSource extends DataSource
{
    void addMyStation(final Object p0, final String p1, final String p2);
    
    void getNearbyStations(final Object p0, final Location p1, final String p2);
    
    void getStationDepartures(final Object p0, final String p1, final String p2);
    
    void getTrainMessage(final Object p0);
    
    void updateMyStation(final Object p0, final String p1, final String p2);
}
