package com.google.android.gms.internal.gtm;

import android.text.TextUtils;
import com.google.android.gms.analytics.zzi;
import com.google.android.gms.common.internal.ShowFirstParty;
import java.util.HashMap;
import p043jp.reifrontier.gym.p044ui.dialog.RFGAddMemberDialog;

@ShowFirstParty
public final class zzx extends zzi<zzx> {
    private String category;
    private String label;
    private long value;
    private String zzup;

    public final String getAction() {
        return this.zzup;
    }

    public final String getLabel() {
        return this.label;
    }

    public final long getValue() {
        return this.value;
    }

    public final String toString() {
        HashMap hashMap = new HashMap();
        hashMap.put("category", this.category);
        hashMap.put("action", this.zzup);
        hashMap.put(RFGAddMemberDialog.ARG_LABEL, this.label);
        hashMap.put("value", Long.valueOf(this.value));
        return zzi.zza((Object) hashMap);
    }

    public final /* synthetic */ void zzb(zzi zzi) {
        zzx zzx = (zzx) zzi;
        if (!TextUtils.isEmpty(this.category)) {
            zzx.category = this.category;
        }
        if (!TextUtils.isEmpty(this.zzup)) {
            zzx.zzup = this.zzup;
        }
        if (!TextUtils.isEmpty(this.label)) {
            zzx.label = this.label;
        }
        long j = this.value;
        if (j != 0) {
            zzx.value = j;
        }
    }

    public final String zzbr() {
        return this.category;
    }
}
