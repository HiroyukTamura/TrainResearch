package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.provider.CalendarContract;
import android.text.TextUtils;
import com.google.android.gms.ads.impl.C0655R;
import com.google.android.gms.ads.internal.zzq;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crashlytics.internal.common.AbstractSpiCall;
import java.util.Map;

public final class zzaom extends zzapb {
    private final Map<String, String> zzcux;
    private String zzdic = zzdt("description");
    private long zzdid = zzdu("start_ticks");
    private long zzdie = zzdu("end_ticks");
    private String zzdif = zzdt("summary");
    private String zzdig = zzdt(FirebaseAnalytics.Param.LOCATION);
    /* access modifiers changed from: private */
    public final Context zzvf;

    public zzaom(zzbek zzbek, Map<String, String> map) {
        super(zzbek, "createCalendarEvent");
        this.zzcux = map;
        this.zzvf = zzbek.zzzh();
    }

    private final String zzdt(String str) {
        return TextUtils.isEmpty(this.zzcux.get(str)) ? "" : this.zzcux.get(str);
    }

    private final long zzdu(String str) {
        String str2 = this.zzcux.get(str);
        if (str2 == null) {
            return -1;
        }
        try {
            return Long.parseLong(str2);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    /* access modifiers changed from: package-private */
    @TargetApi(14)
    public final Intent createIntent() {
        Intent data = new Intent("android.intent.action.EDIT").setData(CalendarContract.Events.CONTENT_URI);
        data.putExtra("title", this.zzdic);
        data.putExtra("eventLocation", this.zzdig);
        data.putExtra("description", this.zzdif);
        long j = this.zzdid;
        if (j > -1) {
            data.putExtra("beginTime", j);
        }
        long j2 = this.zzdie;
        if (j2 > -1) {
            data.putExtra("endTime", j2);
        }
        data.setFlags(268435456);
        return data;
    }

    public final void execute() {
        if (this.zzvf == null) {
            zzdv("Activity context is not available.");
            return;
        }
        zzq.zzkw();
        if (!zzaxa.zzas(this.zzvf).zzqy()) {
            zzdv("This feature is not available on the device.");
            return;
        }
        zzq.zzkw();
        AlertDialog.Builder zzar = zzaxa.zzar(this.zzvf);
        Resources resources = zzq.zzla().getResources();
        zzar.setTitle(resources != null ? resources.getString(C0655R.string.f350s5) : "Create calendar event");
        zzar.setMessage(resources != null ? resources.getString(C0655R.string.f351s6) : "Allow Ad to create a calendar event?");
        zzar.setPositiveButton(resources != null ? resources.getString(C0655R.string.f348s3) : AbstractSpiCall.HEADER_ACCEPT, new zzaop(this));
        zzar.setNegativeButton(resources != null ? resources.getString(C0655R.string.f349s4) : "Decline", new zzaoo(this));
        zzar.create().show();
    }
}
