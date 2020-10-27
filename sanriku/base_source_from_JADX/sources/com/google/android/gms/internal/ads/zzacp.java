package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.NativeAd;
import java.util.ArrayList;
import java.util.List;

public final class zzacp extends NativeAd.AdChoicesInfo {
    private String text;
    private final List<NativeAd.Image> zzcym = new ArrayList();
    private final zzack zzcyw;

    public zzacp(zzack zzack) {
        zzacs zzacs;
        IBinder iBinder;
        this.zzcyw = zzack;
        try {
            this.text = zzack.getText();
        } catch (RemoteException e) {
            zzazw.zzc("", e);
            this.text = "";
        }
        try {
            for (zzacs next : zzack.zzrr()) {
                if (!(next instanceof IBinder) || (iBinder = (IBinder) next) == null) {
                    zzacs = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
                    zzacs = queryLocalInterface instanceof zzacs ? (zzacs) queryLocalInterface : new zzacu(iBinder);
                }
                if (zzacs != null) {
                    this.zzcym.add(new zzacx(zzacs));
                }
            }
        } catch (RemoteException e2) {
            zzazw.zzc("", e2);
        }
    }

    public final List<NativeAd.Image> getImages() {
        return this.zzcym;
    }

    public final CharSequence getText() {
        return this.text;
    }
}
