package com.google.android.gms.ads.query;

import android.net.Uri;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.ads.zzaqd;
import com.google.android.gms.internal.ads.zzaqi;
import java.util.List;
import java.util.Map;

@KeepForSdk
public final class ReportingInfo {
    private final zzaqd zzhav;

    @KeepForSdk
    public static final class Builder {
        /* access modifiers changed from: private */
        public final zzaqi zzhaw;

        @KeepForSdk
        public Builder(View view) {
            zzaqi zzaqi = new zzaqi();
            this.zzhaw = zzaqi;
            zzaqi.zzk(view);
        }

        @KeepForSdk
        public final ReportingInfo build() {
            return new ReportingInfo(this);
        }

        @KeepForSdk
        public final Builder setAssetViews(Map<String, View> map) {
            this.zzhaw.zzh(map);
            return this;
        }
    }

    private ReportingInfo(Builder builder) {
        this.zzhav = new zzaqd(builder.zzhaw);
    }

    @KeepForSdk
    public final void reportTouchEvent(MotionEvent motionEvent) {
        this.zzhav.reportTouchEvent(motionEvent);
    }

    @KeepForSdk
    public final void updateClickUrl(Uri uri, UpdateClickUrlCallback updateClickUrlCallback) {
        this.zzhav.updateClickUrl(uri, updateClickUrlCallback);
    }

    @KeepForSdk
    public final void updateImpressionUrls(List<Uri> list, UpdateImpressionUrlsCallback updateImpressionUrlsCallback) {
        this.zzhav.updateImpressionUrls(list, updateImpressionUrlsCallback);
    }
}
