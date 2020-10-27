package com.google.ads.mediation;

import com.google.android.gms.ads.reward.AdMetadataListener;

/* renamed from: com.google.ads.mediation.g */
final class C0567g extends AdMetadataListener {

    /* renamed from: a */
    private final /* synthetic */ AbstractAdViewAdapter f120a;

    C0567g(AbstractAdViewAdapter abstractAdViewAdapter) {
        this.f120a = abstractAdViewAdapter;
    }

    public final void onAdMetadataChanged() {
        if (this.f120a.zzma != null && this.f120a.zzmb != null) {
            this.f120a.zzmb.zzb(this.f120a.zzma.getAdMetadata());
        }
    }
}
