package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.ads.query.UpdateClickUrlCallback;
import java.util.List;

final class zzaqf extends zzaqa {
    private final /* synthetic */ UpdateClickUrlCallback zzdll;

    zzaqf(zzaqd zzaqd, UpdateClickUrlCallback updateClickUrlCallback) {
        this.zzdll = updateClickUrlCallback;
    }

    public final void onError(String str) {
        this.zzdll.onFailure(str);
    }

    public final void onSuccess(List<Uri> list) {
        this.zzdll.onSuccess(list.get(0));
    }
}
