package com.google.android.gms.internal.ads;

import android.view.View;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public final class zzaqi {
    /* access modifiers changed from: private */
    public View zzaae;
    /* access modifiers changed from: private */
    public final Map<String, WeakReference<View>> zzdli = new HashMap();

    public final zzaqi zzh(Map<String, View> map) {
        this.zzdli.clear();
        for (Map.Entry next : map.entrySet()) {
            View view = (View) next.getValue();
            if (view != null) {
                this.zzdli.put((String) next.getKey(), new WeakReference(view));
            }
        }
        return this;
    }

    public final zzaqi zzk(View view) {
        this.zzaae = view;
        return this;
    }
}
