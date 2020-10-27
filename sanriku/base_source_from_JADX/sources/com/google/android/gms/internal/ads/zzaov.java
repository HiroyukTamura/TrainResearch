package com.google.android.gms.internal.ads;

import android.app.DownloadManager;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Environment;
import com.google.android.gms.ads.internal.zzq;

final class zzaov implements DialogInterface.OnClickListener {
    private final /* synthetic */ zzaos zzdiz;
    private final /* synthetic */ String zzdja;
    private final /* synthetic */ String zzdjb;

    zzaov(zzaos zzaos, String str, String str2) {
        this.zzdiz = zzaos;
        this.zzdja = str;
        this.zzdjb = str2;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        DownloadManager downloadManager = (DownloadManager) this.zzdiz.zzvf.getSystemService("download");
        try {
            String str = this.zzdja;
            String str2 = this.zzdjb;
            DownloadManager.Request request = new DownloadManager.Request(Uri.parse(str));
            request.setDestinationInExternalPublicDir(Environment.DIRECTORY_PICTURES, str2);
            zzq.zzky();
            request.allowScanningByMediaScanner();
            request.setNotificationVisibility(1);
            downloadManager.enqueue(request);
        } catch (IllegalStateException unused) {
            this.zzdiz.zzdv("Could not store picture.");
        }
    }
}
