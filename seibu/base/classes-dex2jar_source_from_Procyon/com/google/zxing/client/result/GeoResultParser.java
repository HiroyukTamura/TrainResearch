// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.client.result;

import java.util.regex.Matcher;
import com.google.zxing.Result;
import java.util.regex.Pattern;

public final class GeoResultParser extends ResultParser
{
    private static final Pattern GEO_URL_PATTERN;
    
    static {
        GEO_URL_PATTERN = Pattern.compile("geo:([\\-0-9.]+),([\\-0-9.]+)(?:,([\\-0-9.]+))?(?:\\?(.*))?", 2);
    }
    
    @Override
    public GeoParsedResult parse(final Result result) {
        final Matcher matcher = GeoResultParser.GEO_URL_PATTERN.matcher(ResultParser.getMassagedText(result));
        if (matcher.matches()) {
            final String group = matcher.group(4);
            try {
                final double double1 = Double.parseDouble(matcher.group(1));
                if (double1 <= 90.0 && double1 >= -90.0) {
                    final double double2 = Double.parseDouble(matcher.group(2));
                    if (double2 <= 180.0 && double2 >= -180.0) {
                        double double3;
                        if (matcher.group(3) == null) {
                            double3 = 0.0;
                        }
                        else if ((double3 = Double.parseDouble(matcher.group(3))) < 0.0) {
                            return null;
                        }
                        return new GeoParsedResult(double1, double2, double3, group);
                    }
                }
            }
            catch (NumberFormatException ex) {
                return null;
            }
        }
        return null;
    }
}
