// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.measurement;

import android.database.Cursor;
import com.google.android.gms.internal.zzcgl;
import android.content.ContentValues;
import android.net.Uri;
import android.content.pm.ProviderInfo;
import android.content.Context;
import android.content.ContentProvider;

@Deprecated
public class AppMeasurementContentProvider extends ContentProvider
{
    public void attachInfo(final Context context, final ProviderInfo providerInfo) {
        super.attachInfo(context, providerInfo);
        if ("com.google.android.gms.measurement.google_measurement_service".equals(providerInfo.authority)) {
            throw new IllegalStateException("Incorrect provider authority in manifest. Most likely due to a missing applicationId variable in application's build.gradle.");
        }
    }
    
    public int delete(final Uri uri, final String s, final String[] array) {
        return 0;
    }
    
    public String getType(final Uri uri) {
        return null;
    }
    
    public Uri insert(final Uri uri, final ContentValues contentValues) {
        return null;
    }
    
    public boolean onCreate() {
        zzcgl.zzbj(this.getContext());
        return false;
    }
    
    public Cursor query(final Uri uri, final String[] array, final String s, final String[] array2, final String s2) {
        return null;
    }
    
    public int update(final Uri uri, final ContentValues contentValues, final String s, final String[] array) {
        return 0;
    }
}
