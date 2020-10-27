package com.google.android.gms.internal.ads;

import android.app.AlertDialog;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.google.android.gms.ads.impl.C0655R;
import com.google.android.gms.ads.internal.zzq;
import com.google.firebase.crashlytics.internal.common.AbstractSpiCall;
import java.util.Map;

public final class zzaos extends zzapb {
    private final Map<String, String> zzcux;
    /* access modifiers changed from: private */
    public final Context zzvf;

    public zzaos(zzbek zzbek, Map<String, String> map) {
        super(zzbek, "storePicture");
        this.zzcux = map;
        this.zzvf = zzbek.zzzh();
    }

    public final void execute() {
        if (this.zzvf == null) {
            zzdv("Activity context is not available");
            return;
        }
        zzq.zzkw();
        if (!zzaxa.zzas(this.zzvf).zzqx()) {
            zzdv("Feature is not supported by the device.");
            return;
        }
        String str = this.zzcux.get("iurl");
        if (TextUtils.isEmpty(str)) {
            zzdv("Image url cannot be empty.");
        } else if (!URLUtil.isValidUrl(str)) {
            String valueOf = String.valueOf(str);
            zzdv(valueOf.length() != 0 ? "Invalid image url: ".concat(valueOf) : new String("Invalid image url: "));
        } else {
            String lastPathSegment = Uri.parse(str).getLastPathSegment();
            zzq.zzkw();
            if (!zzaxa.zzem(lastPathSegment)) {
                String valueOf2 = String.valueOf(lastPathSegment);
                zzdv(valueOf2.length() != 0 ? "Image type not recognized: ".concat(valueOf2) : new String("Image type not recognized: "));
                return;
            }
            Resources resources = zzq.zzla().getResources();
            zzq.zzkw();
            AlertDialog.Builder zzar = zzaxa.zzar(this.zzvf);
            zzar.setTitle(resources != null ? resources.getString(C0655R.string.f346s1) : "Save image");
            zzar.setMessage(resources != null ? resources.getString(C0655R.string.f347s2) : "Allow Ad to store image in Picture gallery?");
            zzar.setPositiveButton(resources != null ? resources.getString(C0655R.string.f348s3) : AbstractSpiCall.HEADER_ACCEPT, new zzaov(this, str, lastPathSegment));
            zzar.setNegativeButton(resources != null ? resources.getString(C0655R.string.f349s4) : "Decline", new zzaou(this));
            zzar.create().show();
        }
    }
}
