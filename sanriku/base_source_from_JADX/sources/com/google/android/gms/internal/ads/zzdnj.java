package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.util.HashMap;

public final class zzdnj {
    private static final HashMap<String, Class<?>> zzhdg = new HashMap<>();
    private final zzdnm zzhcx;
    @Nullable
    private zzdna zzhdh;
    private final Object zzhdi = new Object();
    private final Context zzvf;
    private final zzdlk zzvj;

    public zzdnj(@NonNull Context context, @NonNull zzdnm zzdnm, @NonNull zzdlk zzdlk) {
        this.zzvf = context;
        this.zzhcx = zzdnm;
        this.zzvj = zzdlk;
    }

    private final synchronized Class<?> zza(@NonNull zzdmz zzdmz) throws zzdnk {
        if (zzdmz.zzava() != null) {
            String zzdh = zzdmz.zzava().zzdh();
            Class<?> cls = zzhdg.get(zzdh);
            if (cls != null) {
                return cls;
            }
            try {
                File zzavc = zzdmz.zzavc();
                if (!zzavc.exists()) {
                    zzavc.mkdirs();
                }
                Class<?> loadClass = new DexClassLoader(zzdmz.zzavb().getAbsolutePath(), zzavc.getAbsolutePath(), (String) null, this.zzvf.getClassLoader()).loadClass("com.google.ccc.abuse.droidguard.DroidGuard");
                zzhdg.put(zzdh, loadClass);
                return loadClass;
            } catch (ClassNotFoundException | IllegalArgumentException | SecurityException e) {
                throw new zzdnk(2008, e);
            }
        } else {
            throw new zzdnk(4010, "mc");
        }
    }

    private final Object zza(@NonNull Class<?> cls, @NonNull zzdmz zzdmz) throws zzdnk {
        try {
            return cls.getDeclaredConstructor(new Class[]{Context.class, String.class, byte[].class, Object.class, Bundle.class, Integer.TYPE}).newInstance(new Object[]{this.zzvf, "msa-r", zzdmz.zzavd(), null, new Bundle(), 2});
        } catch (Exception e) {
            throw new zzdnk(2004, (Throwable) e);
        }
    }

    @Nullable
    public final zzdlq zzavk() {
        zzdna zzdna;
        synchronized (this.zzhdi) {
            zzdna = this.zzhdh;
        }
        return zzdna;
    }

    @Nullable
    public final zzdmz zzavl() {
        synchronized (this.zzhdi) {
            if (this.zzhdh == null) {
                return null;
            }
            zzdmz zzave = this.zzhdh.zzave();
            return zzave;
        }
    }

    public final void zzb(@NonNull zzdmz zzdmz) {
        zzdlk zzdlk;
        int zzavm;
        Exception exc;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            zzdna zzdna = new zzdna(zza(zza(zzdmz), zzdmz), zzdmz, this.zzhcx, this.zzvj);
            if (zzdna.zzavf()) {
                int zzavg = zzdna.zzavg();
                if (zzavg == 0) {
                    synchronized (this.zzhdi) {
                        if (this.zzhdh != null) {
                            try {
                                this.zzhdh.close();
                            } catch (zzdnk e) {
                                this.zzvj.zza(e.zzavm(), -1, (Exception) e);
                            }
                        }
                        this.zzhdh = zzdna;
                    }
                    this.zzvj.zzg(3000, System.currentTimeMillis() - currentTimeMillis);
                    return;
                }
                StringBuilder sb = new StringBuilder(15);
                sb.append("ci: ");
                sb.append(zzavg);
                throw new zzdnk(4001, sb.toString());
            }
            throw new zzdnk(4000, "init failed");
        } catch (zzdnk e2) {
            zzdlk = this.zzvj;
            zzavm = e2.zzavm();
            exc = e2;
            zzdlk.zza(zzavm, System.currentTimeMillis() - currentTimeMillis, exc);
        } catch (Exception e3) {
            zzdlk = this.zzvj;
            zzavm = 4010;
            exc = e3;
            zzdlk.zza(zzavm, System.currentTimeMillis() - currentTimeMillis, exc);
        }
    }
}
