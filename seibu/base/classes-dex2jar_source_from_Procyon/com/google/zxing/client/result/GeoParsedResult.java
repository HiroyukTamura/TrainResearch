// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.client.result;

public final class GeoParsedResult extends ParsedResult
{
    private final double altitude;
    private final double latitude;
    private final double longitude;
    private final String query;
    
    GeoParsedResult(final double latitude, final double longitude, final double altitude, final String query) {
        super(ParsedResultType.GEO);
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
        this.query = query;
    }
    
    public double getAltitude() {
        return this.altitude;
    }
    
    @Override
    public String getDisplayResult() {
        final StringBuilder sb = new StringBuilder(20);
        sb.append(this.latitude);
        sb.append(", ");
        sb.append(this.longitude);
        if (this.altitude > 0.0) {
            sb.append(", ");
            sb.append(this.altitude);
            sb.append('m');
        }
        if (this.query != null) {
            sb.append(" (");
            sb.append(this.query);
            sb.append(')');
        }
        return sb.toString();
    }
    
    public String getGeoURI() {
        final StringBuilder sb = new StringBuilder();
        sb.append("geo:");
        sb.append(this.latitude);
        sb.append(',');
        sb.append(this.longitude);
        if (this.altitude > 0.0) {
            sb.append(',');
            sb.append(this.altitude);
        }
        if (this.query != null) {
            sb.append('?');
            sb.append(this.query);
        }
        return sb.toString();
    }
    
    public double getLatitude() {
        return this.latitude;
    }
    
    public double getLongitude() {
        return this.longitude;
    }
    
    public String getQuery() {
        return this.query;
    }
}
