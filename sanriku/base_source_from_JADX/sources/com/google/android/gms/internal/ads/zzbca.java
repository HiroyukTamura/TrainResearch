package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzq;
import java.util.concurrent.TimeUnit;

public final class zzbca {
    private final zzazz zzdls;
    private final String zzdmh;
    @Nullable
    private final zzaam zzebl;
    private boolean zzebp;
    @Nullable
    private final zzaak zzeec;
    private final zzayi zzeed = new zzayj().zza("min_1", Double.MIN_VALUE, 1.0d).zza("1_5", 1.0d, 5.0d).zza("5_10", 5.0d, 10.0d).zza("10_20", 10.0d, 20.0d).zza("20_30", 20.0d, 30.0d).zza("30_max", 30.0d, Double.MAX_VALUE).zzxw();
    private final long[] zzeee;
    private final String[] zzeef;
    private boolean zzeeg = false;
    private boolean zzeeh = false;
    private boolean zzeei = false;
    private boolean zzeej = false;
    private zzbbi zzeek;
    private boolean zzeel;
    private boolean zzeem;
    private long zzeen = -1;
    private final Context zzvf;

    public zzbca(Context context, zzazz zzazz, String str, @Nullable zzaam zzaam, @Nullable zzaak zzaak) {
        this.zzvf = context;
        this.zzdls = zzazz;
        this.zzdmh = str;
        this.zzebl = zzaam;
        this.zzeec = zzaak;
        String str2 = (String) zzvj.zzpv().zzd(zzzz.zzcjn);
        if (str2 == null) {
            this.zzeef = new String[0];
            this.zzeee = new long[0];
            return;
        }
        String[] split = TextUtils.split(str2, ",");
        this.zzeef = new String[split.length];
        this.zzeee = new long[split.length];
        for (int i = 0; i < split.length; i++) {
            try {
                this.zzeee[i] = Long.parseLong(split[i]);
            } catch (NumberFormatException e) {
                zzazw.zzd("Unable to parse frame hash target time number.", e);
                this.zzeee[i] = -1;
            }
        }
    }

    public final void onStop() {
        if (zzabw.zzcxw.get().booleanValue() && !this.zzeel) {
            Bundle bundle = new Bundle();
            bundle.putString("type", "native-player-metrics");
            bundle.putString("request", this.zzdmh);
            bundle.putString("player", this.zzeek.zzyk());
            for (zzayk next : this.zzeed.zzxv()) {
                String valueOf = String.valueOf(next.name);
                bundle.putString(valueOf.length() != 0 ? "fps_c_".concat(valueOf) : new String("fps_c_"), Integer.toString(next.count));
                String valueOf2 = String.valueOf(next.name);
                bundle.putString(valueOf2.length() != 0 ? "fps_p_".concat(valueOf2) : new String("fps_p_"), Double.toString(next.zzdxq));
            }
            int i = 0;
            while (true) {
                long[] jArr = this.zzeee;
                if (i < jArr.length) {
                    String str = this.zzeef[i];
                    if (str != null) {
                        String valueOf3 = String.valueOf(Long.valueOf(jArr[i]));
                        StringBuilder sb = new StringBuilder(valueOf3.length() + 3);
                        sb.append("fh_");
                        sb.append(valueOf3);
                        bundle.putString(sb.toString(), str);
                    }
                    i++;
                } else {
                    zzq.zzkw().zza(this.zzvf, this.zzdls.zzbnd, "gmob-apps", bundle, true);
                    this.zzeel = true;
                    return;
                }
            }
        }
    }

    public final void zzb(zzbbi zzbbi) {
        zzaah.zza(this.zzebl, this.zzeec, "vpc2");
        this.zzeeg = true;
        zzaam zzaam = this.zzebl;
        if (zzaam != null) {
            zzaam.zzh("vpn", zzbbi.zzyk());
        }
        this.zzeek = zzbbi;
    }

    public final void zzc(zzbbi zzbbi) {
        if (this.zzeei && !this.zzeej) {
            if (zzawr.zzwo() && !this.zzeej) {
                zzawr.zzeg("VideoMetricsMixin first frame");
            }
            zzaah.zza(this.zzebl, this.zzeec, "vff2");
            this.zzeej = true;
        }
        long nanoTime = zzq.zzld().nanoTime();
        if (this.zzebp && this.zzeem && this.zzeen != -1) {
            double nanos = (double) TimeUnit.SECONDS.toNanos(1);
            double d = (double) (nanoTime - this.zzeen);
            Double.isNaN(nanos);
            Double.isNaN(d);
            this.zzeed.zza(nanos / d);
        }
        this.zzeem = this.zzebp;
        this.zzeen = nanoTime;
        long longValue = ((Long) zzvj.zzpv().zzd(zzzz.zzcjo)).longValue();
        long currentPosition = (long) zzbbi.getCurrentPosition();
        int i = 0;
        while (true) {
            String[] strArr = this.zzeef;
            if (i >= strArr.length) {
                return;
            }
            if (strArr[i] != null || longValue <= Math.abs(currentPosition - this.zzeee[i])) {
                zzbbi zzbbi2 = zzbbi;
                i++;
            } else {
                String[] strArr2 = this.zzeef;
                int i2 = 8;
                Bitmap bitmap = zzbbi.getBitmap(8, 8);
                long j = 63;
                int i3 = 0;
                long j2 = 0;
                while (i3 < i2) {
                    int i4 = 0;
                    while (i4 < i2) {
                        int pixel = bitmap.getPixel(i4, i3);
                        j2 |= (Color.green(pixel) + (Color.red(pixel) + Color.blue(pixel)) > 128 ? 1 : 0) << ((int) j);
                        i4++;
                        j--;
                        i2 = 8;
                    }
                    i3++;
                    i2 = 8;
                }
                strArr2[i] = String.format("%016X", new Object[]{Long.valueOf(j2)});
                return;
            }
        }
    }

    public final void zzfa() {
        if (this.zzeeg && !this.zzeeh) {
            zzaah.zza(this.zzebl, this.zzeec, "vfr2");
            this.zzeeh = true;
        }
    }

    public final void zzzp() {
        this.zzebp = true;
        if (this.zzeeh && !this.zzeei) {
            zzaah.zza(this.zzebl, this.zzeec, "vfp2");
            this.zzeei = true;
        }
    }

    public final void zzzq() {
        this.zzebp = false;
    }
}
