package com.google.android.gms.ads;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdkWithMembers;
import com.google.android.gms.internal.ads.zzyc;

@KeepForSdkWithMembers
public class MobileAdsInitProvider extends ContentProvider {
    private final zzyc zzacp = new zzyc();

    public void attachInfo(Context context, ProviderInfo providerInfo) {
        this.zzacp.attachInfo(context, providerInfo);
    }

    public int delete(@NonNull Uri uri, String str, String[] strArr) {
        return this.zzacp.delete(uri, str, strArr);
    }

    @Nullable
    public String getType(@NonNull Uri uri) {
        return this.zzacp.getType(uri);
    }

    @Nullable
    public Uri insert(@NonNull Uri uri, ContentValues contentValues) {
        return this.zzacp.insert(uri, contentValues);
    }

    public boolean onCreate() {
        return this.zzacp.onCreate();
    }

    @Nullable
    public Cursor query(@NonNull Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return this.zzacp.query(uri, strArr, str, strArr2, str2);
    }

    public int update(@NonNull Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return this.zzacp.update(uri, contentValues, str, strArr);
    }
}
