/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  android.location.Location
 *  android.location.LocationManager
 *  android.util.Log
 */
package androidx.appcompat.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;
import androidx.appcompat.app.j;
import androidx.core.a.b;
import java.util.Calendar;

class k {
    private static k a;
    private final Context b;
    private final LocationManager c;
    private final a d = new a();

    k(Context context, LocationManager locationManager) {
        this.b = context;
        this.c = locationManager;
    }

    private Location a(String string2) {
        try {
            if (this.c.isProviderEnabled(string2)) {
                string2 = this.c.getLastKnownLocation(string2);
                return string2;
            }
        }
        catch (Exception exception) {
            Log.d((String)"TwilightManager", (String)"Failed to get last known location", (Throwable)exception);
        }
        return null;
    }

    static k a(Context context) {
        if (a == null) {
            context = context.getApplicationContext();
            a = new k(context, (LocationManager)context.getSystemService("location"));
        }
        return a;
    }

    private void a(Location location) {
        a a2 = this.d;
        long l2 = System.currentTimeMillis();
        j j2 = j.a();
        j2.a(l2 - 86400000L, location.getLatitude(), location.getLongitude());
        long l3 = j2.a;
        j2.a(l2, location.getLatitude(), location.getLongitude());
        boolean bl2 = j2.c == 1;
        long l4 = j2.b;
        long l5 = j2.a;
        j2.a(86400000L + l2, location.getLatitude(), location.getLongitude());
        long l6 = j2.b;
        if (l4 != -1L && l5 != -1L) {
            l2 = l2 > l5 ? 0L + l6 : (l2 > l4 ? 0L + l5 : 0L + l4);
            l2 += 60000L;
        } else {
            l2 = 43200000L + l2;
        }
        a2.a = bl2;
        a2.b = l3;
        a2.c = l4;
        a2.d = l5;
        a2.e = l6;
        a2.f = l2;
    }

    @SuppressLint(value={"MissingPermission"})
    private Location b() {
        int n2 = b.a(this.b, "android.permission.ACCESS_COARSE_LOCATION");
        Location location = null;
        Location location2 = n2 == 0 ? this.a("network") : null;
        if (b.a(this.b, "android.permission.ACCESS_FINE_LOCATION") == 0) {
            location = this.a("gps");
        }
        if (location != null && location2 != null) {
            Location location3 = location2;
            if (location.getTime() > location2.getTime()) {
                location3 = location;
            }
            return location3;
        }
        if (location != null) {
            location2 = location;
        }
        return location2;
    }

    private boolean c() {
        return this.d.f > System.currentTimeMillis();
    }

    boolean a() {
        a a2 = this.d;
        if (this.c()) {
            return a2.a;
        }
        Location location = this.b();
        if (location != null) {
            this.a(location);
            return a2.a;
        }
        Log.i((String)"TwilightManager", (String)"Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
        int n2 = Calendar.getInstance().get(11);
        return n2 < 6 || n2 >= 22;
        {
        }
    }

    private static class a {
        boolean a;
        long b;
        long c;
        long d;
        long e;
        long f;

        a() {
        }
    }

}

