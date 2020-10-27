package com.google.android.gms.internal.ads;

import android.os.Environment;
import android.util.Base64;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.internal.ads.zzsv;
import com.google.android.gms.internal.ads.zztf;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class zzst {
    private final zzsy zzbte;
    private final zztf.zzi.zza zzbtf;
    private final boolean zzbtg;

    private zzst() {
        this.zzbtf = zztf.zzi.zznz();
        this.zzbtg = false;
        this.zzbte = new zzsy();
    }

    public zzst(zzsy zzsy) {
        this.zzbtf = zztf.zzi.zznz();
        this.zzbte = zzsy;
        this.zzbtg = ((Boolean) zzvj.zzpv().zzd(zzzz.zzcqq)).booleanValue();
    }

    private final synchronized void zzb(zzsv.zza.C2668zza zza) {
        this.zzbtf.zzoc().zzb((Iterable<? extends Long>) zzna());
        this.zzbte.zzf(((zztf.zzi) ((zzecd) this.zzbtf.zzbet())).toByteArray()).zzbs(zza.zzw()).zzdx();
        String valueOf = String.valueOf(Integer.toString(zza.zzw(), 10));
        zzawr.zzeg(valueOf.length() != 0 ? "Logging Event with event code : ".concat(valueOf) : new String("Logging Event with event code : "));
    }

    private final synchronized void zzc(zzsv.zza.C2668zza zza) {
        FileOutputStream fileOutputStream;
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (externalStorageDirectory != null) {
            try {
                fileOutputStream = new FileOutputStream(new File(externalStorageDirectory, "clearcut_events.txt"), true);
                try {
                    fileOutputStream.write(zzd(zza).getBytes());
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused) {
                        zzawr.zzeg("Could not close Clearcut output stream.");
                    }
                } catch (IOException unused2) {
                    zzawr.zzeg("Could not write Clearcut to file.");
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused3) {
                        zzawr.zzeg("Could not close Clearcut output stream.");
                    }
                }
            } catch (FileNotFoundException unused4) {
                zzawr.zzeg("Could not find file for Clearcut");
            } catch (Throwable th) {
                try {
                    fileOutputStream.close();
                } catch (IOException unused5) {
                    zzawr.zzeg("Could not close Clearcut output stream.");
                }
                throw th;
            }
        }
    }

    private final synchronized String zzd(zzsv.zza.C2668zza zza) {
        return String.format("id=%s,timestamp=%s,event=%s,data=%s\n", new Object[]{this.zzbtf.zznv(), Long.valueOf(zzq.zzld().elapsedRealtime()), Integer.valueOf(zza.zzw()), Base64.encodeToString(((zztf.zzi) ((zzecd) this.zzbtf.zzbet())).toByteArray(), 3)});
    }

    public static zzst zzmz() {
        return new zzst();
    }

    private static List<Long> zzna() {
        List<String> zzrb = zzzz.zzrb();
        ArrayList arrayList = new ArrayList();
        for (String split : zzrb) {
            for (String valueOf : split.split(",")) {
                try {
                    arrayList.add(Long.valueOf(valueOf));
                } catch (NumberFormatException unused) {
                    zzawr.zzeg("Experiment ID is not a number");
                }
            }
        }
        return arrayList;
    }

    public final synchronized void zza(zzsv.zza.C2668zza zza) {
        if (this.zzbtg) {
            if (((Boolean) zzvj.zzpv().zzd(zzzz.zzcqr)).booleanValue()) {
                zzc(zza);
            } else {
                zzb(zza);
            }
        }
    }

    public final synchronized void zza(zzsw zzsw) {
        if (this.zzbtg) {
            try {
                zzsw.zza(this.zzbtf);
            } catch (NullPointerException e) {
                zzq.zzla().zza(e, "AdMobClearcutLogger.modify");
            }
        }
    }
}
