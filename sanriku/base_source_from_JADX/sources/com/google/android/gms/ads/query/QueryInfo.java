package com.google.android.gms.ads.query;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.ads.zzaqc;
import com.google.android.gms.internal.ads.zzyh;

@KeepForSdk
public class QueryInfo {
    private final zzyh zzhau;

    public QueryInfo(zzyh zzyh) {
        this.zzhau = zzyh;
    }

    @KeepForSdk
    public static void generate(Context context, AdFormat adFormat, @Nullable AdRequest adRequest, QueryInfoGenerationCallback queryInfoGenerationCallback) {
        new zzaqc(context, adFormat, adRequest == null ? null : adRequest.zzdq()).zza(queryInfoGenerationCallback);
    }

    @KeepForSdk
    public String getQuery() {
        return this.zzhau.getQuery();
    }

    @KeepForSdk
    public Bundle getQueryBundle() {
        return this.zzhau.getQueryBundle();
    }

    @KeepForSdk
    public String getRequestId() {
        return zzyh.zza(this);
    }
}
