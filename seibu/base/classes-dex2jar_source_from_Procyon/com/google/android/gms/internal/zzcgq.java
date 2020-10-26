// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import java.util.concurrent.Future;
import java.util.Iterator;
import java.util.concurrent.ExecutionException;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.List;
import com.google.android.gms.common.zzo;
import com.google.android.gms.common.zzp;
import com.google.android.gms.common.util.zzw;
import android.os.Binder;
import android.text.TextUtils;
import android.support.annotation.BinderThread;
import com.google.android.gms.common.internal.zzbo;
import android.support.annotation.Nullable;

public final class zzcgq extends zzcfe
{
    private final zzcgl zzboe;
    private Boolean zzbtc;
    @Nullable
    private String zzbtd;
    
    public zzcgq(final zzcgl zzcgl) {
        this(zzcgl, null);
    }
    
    private zzcgq(final zzcgl zzboe, @Nullable final String s) {
        zzbo.zzu(zzboe);
        this.zzboe = zzboe;
        this.zzbtd = null;
    }
    
    @BinderThread
    private final void zzb(final zzceh zzceh, final boolean b) {
        zzbo.zzu(zzceh);
        this.zzh(zzceh.packageName, false);
        this.zzboe.zzwB().zzev(zzceh.zzboQ);
    }
    
    @BinderThread
    private final void zzh(final String zzbtd, final boolean b) {
        final boolean b2 = false;
        if (TextUtils.isEmpty((CharSequence)zzbtd)) {
            this.zzboe.zzwF().zzyx().log("Measurement Service called without app package");
            throw new SecurityException("Measurement Service called without app package");
        }
        while (true) {
            if (b) {
                while (true) {
                    while (true) {
                        Label_0211: {
                            try {
                                if (this.zzbtc == null) {
                                    if ("com.google.android.gms".equals(this.zzbtd) || zzw.zzf(this.zzboe.getContext(), Binder.getCallingUid())) {
                                        break Label_0211;
                                    }
                                    final boolean b3 = b2;
                                    if (zzp.zzax(this.zzboe.getContext()).zza(this.zzboe.getContext().getPackageManager(), Binder.getCallingUid())) {
                                        break Label_0211;
                                    }
                                    this.zzbtc = b3;
                                }
                                if (!this.zzbtc) {
                                    if (this.zzbtd == null && zzo.zzb(this.zzboe.getContext(), Binder.getCallingUid(), zzbtd)) {
                                        this.zzbtd = zzbtd;
                                    }
                                    if (!zzbtd.equals(this.zzbtd)) {
                                        throw new SecurityException(String.format("Unknown calling package name '%s'.", zzbtd));
                                    }
                                }
                            }
                            catch (SecurityException ex) {
                                this.zzboe.zzwF().zzyx().zzj("Measurement Service called with invalid calling package. appId", zzcfl.zzdZ(zzbtd));
                                throw ex;
                            }
                            break;
                        }
                        final boolean b3 = true;
                        continue;
                    }
                }
                return;
            }
            continue;
        }
    }
    
    @BinderThread
    @Override
    public final List<zzcji> zza(final zzceh zzceh, final boolean b) {
        this.zzb(zzceh, false);
        Object zze = this.zzboe.zzwE().zze((Callable<List<zzcjk>>)new zzchf(this, zzceh));
        try {
            final List<zzcjk> list = ((Future<List<zzcjk>>)zze).get();
            zze = new ArrayList<zzcji>(list.size());
            for (final zzcjk zzcjk : list) {
                if (b || !zzcjl.zzex(zzcjk.mName)) {
                    ((List<zzcji>)zze).add(new zzcji(zzcjk));
                }
            }
            goto Label_0143;
        }
        catch (InterruptedException ex) {}
        catch (ExecutionException zze) {
            goto Label_0118;
        }
    }
    
    @BinderThread
    @Override
    public final List<zzcek> zza(String zze, final String s, final zzceh zzceh) {
        this.zzb(zzceh, false);
        zze = (ExecutionException)this.zzboe.zzwE().zze((Callable<Object>)new zzcgy(this, zzceh, (String)zze, s));
        try {
            zze = (ExecutionException)((Future<List<?>>)zze).get();
            return (List<zzcek>)zze;
        }
        catch (InterruptedException ex) {}
        catch (ExecutionException zze) {
            goto Label_0041;
        }
    }
    
    @BinderThread
    @Override
    public final List<zzcji> zza(final String s, String zze, final String s2, final boolean b) {
        this.zzh(s, true);
        zze = (ExecutionException)this.zzboe.zzwE().zze((Callable<Object>)new zzcgx(this, s, (String)zze, s2));
        try {
            final List<zzcjk> list = ((Future<List<zzcjk>>)zze).get();
            zze = (ExecutionException)new ArrayList(list.size());
            for (final zzcjk zzcjk : list) {
                if (b || !zzcjl.zzex(zzcjk.mName)) {
                    ((List<zzcji>)zze).add(new zzcji(zzcjk));
                }
            }
            goto Label_0139;
        }
        catch (InterruptedException ex) {}
        catch (ExecutionException zze) {
            goto Label_0115;
        }
    }
    
    @BinderThread
    @Override
    public final List<zzcji> zza(String zze, final String s, final boolean b, final zzceh zzceh) {
        this.zzb(zzceh, false);
        zze = (ExecutionException)this.zzboe.zzwE().zze((Callable<Object>)new zzcgw(this, zzceh, (String)zze, s));
        try {
            final List<zzcjk> list = ((Future<List<zzcjk>>)zze).get();
            zze = (ExecutionException)new ArrayList(list.size());
            for (final zzcjk zzcjk : list) {
                if (b || !zzcjl.zzex(zzcjk.mName)) {
                    ((List<zzcji>)zze).add(new zzcji(zzcjk));
                }
            }
            goto Label_0144;
        }
        catch (InterruptedException ex) {}
        catch (ExecutionException zze) {
            goto Label_0116;
        }
    }
    
    @BinderThread
    @Override
    public final void zza(final long n, final String s, final String s2, final String s3) {
        this.zzboe.zzwE().zzj(new zzchh(this, s2, s3, s, n));
    }
    
    @BinderThread
    @Override
    public final void zza(final zzceh zzceh) {
        this.zzb(zzceh, false);
        final zzchg zzchg = new zzchg(this, zzceh);
        if (this.zzboe.zzwE().zzyM()) {
            zzchg.run();
            return;
        }
        this.zzboe.zzwE().zzj(zzchg);
    }
    
    @BinderThread
    @Override
    public final void zza(final zzcek zzcek, final zzceh zzceh) {
        zzbo.zzu(zzcek);
        zzbo.zzu(zzcek.zzbpd);
        this.zzb(zzceh, false);
        final zzcek zzcek2 = new zzcek(zzcek);
        zzcek2.packageName = zzceh.packageName;
        if (zzcek.zzbpd.getValue() == null) {
            this.zzboe.zzwE().zzj(new zzcgs(this, zzcek2, zzceh));
            return;
        }
        this.zzboe.zzwE().zzj(new zzcgt(this, zzcek2, zzceh));
    }
    
    @BinderThread
    @Override
    public final void zza(final zzcez zzcez, final zzceh zzceh) {
        zzbo.zzu(zzcez);
        this.zzb(zzceh, false);
        this.zzboe.zzwE().zzj(new zzcha(this, zzcez, zzceh));
    }
    
    @BinderThread
    @Override
    public final void zza(final zzcez zzcez, final String s, final String s2) {
        zzbo.zzu(zzcez);
        zzbo.zzcF(s);
        this.zzh(s, true);
        this.zzboe.zzwE().zzj(new zzchb(this, zzcez, s));
    }
    
    @BinderThread
    @Override
    public final void zza(final zzcji zzcji, final zzceh zzceh) {
        zzbo.zzu(zzcji);
        this.zzb(zzceh, false);
        if (zzcji.getValue() == null) {
            this.zzboe.zzwE().zzj(new zzchd(this, zzcji, zzceh));
            return;
        }
        this.zzboe.zzwE().zzj(new zzche(this, zzcji, zzceh));
    }
    
    @BinderThread
    @Override
    public final byte[] zza(final zzcez zzcez, final String s) {
        zzbo.zzcF(s);
        zzbo.zzu(zzcez);
        this.zzh(s, true);
        this.zzboe.zzwF().zzyC().zzj("Log and bundle. event", this.zzboe.zzwA().zzdW(zzcez.name));
        final long n = this.zzboe.zzkq().nanoTime() / 1000000L;
        Object zzf = this.zzboe.zzwE().zzf((Callable<byte[]>)new zzchc(this, zzcez, s));
        try {
            if ((zzf = ((Future<byte[]>)zzf).get()) == null) {
                this.zzboe.zzwF().zzyx().zzj("Log and bundle returned null. appId", zzcfl.zzdZ(s));
                zzf = new byte[0];
            }
            this.zzboe.zzwF().zzyC().zzd("Log and bundle processed. event, size, time_ms", this.zzboe.zzwA().zzdW(zzcez.name), ((Future<byte[]>)zzf).length, this.zzboe.zzkq().nanoTime() / 1000000L - n);
            return (byte[])zzf;
        }
        catch (InterruptedException ex) {}
        catch (ExecutionException zzf) {
            goto Label_0197;
        }
    }
    
    @BinderThread
    @Override
    public final void zzb(final zzceh zzceh) {
        this.zzb(zzceh, false);
        this.zzboe.zzwE().zzj(new zzcgr(this, zzceh));
    }
    
    @BinderThread
    @Override
    public final void zzb(final zzcek zzcek) {
        zzbo.zzu(zzcek);
        zzbo.zzu(zzcek.zzbpd);
        this.zzh(zzcek.packageName, true);
        final zzcek zzcek2 = new zzcek(zzcek);
        if (zzcek.zzbpd.getValue() == null) {
            this.zzboe.zzwE().zzj(new zzcgu(this, zzcek2));
            return;
        }
        this.zzboe.zzwE().zzj(new zzcgv(this, zzcek2));
    }
    
    @BinderThread
    @Override
    public final String zzc(final zzceh zzceh) {
        this.zzb(zzceh, false);
        return this.zzboe.zzem(zzceh.packageName);
    }
    
    @BinderThread
    @Override
    public final List<zzcek> zzk(String zze, final String s, final String s2) {
        this.zzh((String)zze, true);
        zze = (ExecutionException)this.zzboe.zzwE().zze((Callable<Object>)new zzcgz(this, (String)zze, s, s2));
        try {
            zze = (ExecutionException)((Future<List<?>>)zze).get();
            return (List<zzcek>)zze;
        }
        catch (InterruptedException ex) {}
        catch (ExecutionException zze) {
            goto Label_0041;
        }
    }
}
