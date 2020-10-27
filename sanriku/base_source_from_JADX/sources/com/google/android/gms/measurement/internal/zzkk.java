package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzae;
import com.google.android.gms.internal.measurement.zzca;
import com.google.android.gms.internal.measurement.zzcc;
import com.google.android.gms.internal.measurement.zzib;
import com.google.android.gms.internal.measurement.zznn;
import com.google.android.gms.internal.measurement.zzoe;
import com.google.android.gms.internal.measurement.zzof;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import kotlin.jvm.internal.LongCompanionObject;
import p009e.p010a.p011a.p012a.C0681a;

public class zzkk implements zzgz {
    private static volatile zzkk zza;
    private zzfx zzb;
    private zzfc zzc;
    private zzad zzd;
    private zzfj zze;
    private zzkg zzf;
    private zzo zzg;
    private final zzks zzh;
    private zzii zzi;
    private final zzgd zzj;
    private boolean zzk;
    private boolean zzl;
    @VisibleForTesting
    private long zzm;
    private List<Runnable> zzn;
    private int zzo;
    private int zzp;
    private boolean zzq;
    private boolean zzr;
    private boolean zzs;
    private FileLock zzt;
    private FileChannel zzu;
    private List<Long> zzv;
    private List<Long> zzw;
    private long zzx;

    class zza implements zzaf {
        zzcc.zzg zza;
        List<Long> zzb;
        List<zzcc.zzc> zzc;
        private long zzd;

        private zza() {
        }

        /* synthetic */ zza(zzkk zzkk, zzkn zzkn) {
            this();
        }

        private static long zza(zzcc.zzc zzc2) {
            return ((zzc2.zze() / 1000) / 60) / 60;
        }

        public final void zza(zzcc.zzg zzg) {
            Preconditions.checkNotNull(zzg);
            this.zza = zzg;
        }

        public final boolean zza(long j, zzcc.zzc zzc2) {
            Preconditions.checkNotNull(zzc2);
            if (this.zzc == null) {
                this.zzc = new ArrayList();
            }
            if (this.zzb == null) {
                this.zzb = new ArrayList();
            }
            if (this.zzc.size() > 0 && zza(this.zzc.get(0)) != zza(zzc2)) {
                return false;
            }
            long zzbm = this.zzd + ((long) zzc2.zzbm());
            if (zzbm >= ((long) Math.max(0, zzaq.zzh.zza(null).intValue()))) {
                return false;
            }
            this.zzd = zzbm;
            this.zzc.add(zzc2);
            this.zzb.add(Long.valueOf(j));
            return this.zzc.size() < Math.max(1, zzaq.zzi.zza(null).intValue());
        }
    }

    private zzkk(zzkq zzkq) {
        this(zzkq, (zzgd) null);
    }

    private zzkk(zzkq zzkq, zzgd zzgd) {
        this.zzk = false;
        Preconditions.checkNotNull(zzkq);
        this.zzj = zzgd.zza(zzkq.zza, (zzae) null, (Long) null);
        this.zzx = -1;
        zzks zzks = new zzks(this);
        zzks.zzal();
        this.zzh = zzks;
        zzfc zzfc = new zzfc(this);
        zzfc.zzal();
        this.zzc = zzfc;
        zzfx zzfx = new zzfx(this);
        zzfx.zzal();
        this.zzb = zzfx;
        this.zzj.zzq().zza((Runnable) new zzkn(this, zzkq));
    }

    @WorkerThread
    @VisibleForTesting
    private final int zza(FileChannel fileChannel) {
        zzw();
        if (fileChannel == null || !fileChannel.isOpen()) {
            this.zzj.zzr().zzf().zza("Bad channel to read from");
            return 0;
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        try {
            fileChannel.position(0);
            int read = fileChannel.read(allocate);
            if (read != 4) {
                if (read != -1) {
                    this.zzj.zzr().zzi().zza("Unexpected data length. Bytes read", Integer.valueOf(read));
                }
                return 0;
            }
            allocate.flip();
            return allocate.getInt();
        } catch (IOException e) {
            this.zzj.zzr().zzf().zza("Failed to read from channel", e);
            return 0;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0100  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x010e  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0154  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0162  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0170  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0184  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x018a  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x018d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.android.gms.measurement.internal.zzf zza(com.google.android.gms.measurement.internal.zzn r9, com.google.android.gms.measurement.internal.zzf r10, java.lang.String r11) {
        /*
            r8 = this;
            r0 = 1
            if (r10 != 0) goto L_0x001e
            com.google.android.gms.measurement.internal.zzf r10 = new com.google.android.gms.measurement.internal.zzf
            com.google.android.gms.measurement.internal.zzgd r1 = r8.zzj
            java.lang.String r2 = r9.zza
            r10.<init>(r1, r2)
            com.google.android.gms.measurement.internal.zzgd r1 = r8.zzj
            com.google.android.gms.measurement.internal.zzkw r1 = r1.zzi()
            java.lang.String r1 = r1.zzk()
            r10.zza((java.lang.String) r1)
            r10.zze((java.lang.String) r11)
        L_0x001c:
            r11 = 1
            goto L_0x003a
        L_0x001e:
            java.lang.String r1 = r10.zzh()
            boolean r1 = r11.equals(r1)
            if (r1 != 0) goto L_0x0039
            r10.zze((java.lang.String) r11)
            com.google.android.gms.measurement.internal.zzgd r11 = r8.zzj
            com.google.android.gms.measurement.internal.zzkw r11 = r11.zzi()
            java.lang.String r11 = r11.zzk()
            r10.zza((java.lang.String) r11)
            goto L_0x001c
        L_0x0039:
            r11 = 0
        L_0x003a:
            java.lang.String r1 = r9.zzb
            java.lang.String r2 = r10.zze()
            boolean r1 = android.text.TextUtils.equals(r1, r2)
            if (r1 != 0) goto L_0x004c
            java.lang.String r11 = r9.zzb
            r10.zzb((java.lang.String) r11)
            r11 = 1
        L_0x004c:
            java.lang.String r1 = r9.zzr
            java.lang.String r2 = r10.zzf()
            boolean r1 = android.text.TextUtils.equals(r1, r2)
            if (r1 != 0) goto L_0x005e
            java.lang.String r11 = r9.zzr
            r10.zzc((java.lang.String) r11)
            r11 = 1
        L_0x005e:
            boolean r1 = com.google.android.gms.internal.measurement.zzoe.zzb()
            if (r1 == 0) goto L_0x0088
            com.google.android.gms.measurement.internal.zzgd r1 = r8.zzj
            com.google.android.gms.measurement.internal.zzy r1 = r1.zzb()
            java.lang.String r2 = r10.zzc()
            com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzaq.zzbn
            boolean r1 = r1.zze(r2, r3)
            if (r1 == 0) goto L_0x0088
            java.lang.String r1 = r9.zzv
            java.lang.String r2 = r10.zzg()
            boolean r1 = android.text.TextUtils.equals(r1, r2)
            if (r1 != 0) goto L_0x0088
            java.lang.String r11 = r9.zzv
            r10.zzd((java.lang.String) r11)
            r11 = 1
        L_0x0088:
            java.lang.String r1 = r9.zzk
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x00a2
            java.lang.String r1 = r9.zzk
            java.lang.String r2 = r10.zzi()
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x00a2
            java.lang.String r11 = r9.zzk
            r10.zzf((java.lang.String) r11)
            r11 = 1
        L_0x00a2:
            long r1 = r9.zze
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x00b8
            long r5 = r10.zzo()
            int r7 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x00b8
            long r1 = r9.zze
            r10.zzd((long) r1)
            r11 = 1
        L_0x00b8:
            java.lang.String r1 = r9.zzc
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x00d2
            java.lang.String r1 = r9.zzc
            java.lang.String r2 = r10.zzl()
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x00d2
            java.lang.String r11 = r9.zzc
            r10.zzg((java.lang.String) r11)
            r11 = 1
        L_0x00d2:
            long r1 = r9.zzj
            long r5 = r10.zzm()
            int r7 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x00e2
            long r1 = r9.zzj
            r10.zzc((long) r1)
            r11 = 1
        L_0x00e2:
            java.lang.String r1 = r9.zzd
            if (r1 == 0) goto L_0x00f6
            java.lang.String r2 = r10.zzn()
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x00f6
            java.lang.String r11 = r9.zzd
            r10.zzh((java.lang.String) r11)
            r11 = 1
        L_0x00f6:
            long r1 = r9.zzf
            long r5 = r10.zzp()
            int r7 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x0106
            long r1 = r9.zzf
            r10.zze((long) r1)
            r11 = 1
        L_0x0106:
            boolean r1 = r9.zzh
            boolean r2 = r10.zzr()
            if (r1 == r2) goto L_0x0114
            boolean r11 = r9.zzh
            r10.zza((boolean) r11)
            r11 = 1
        L_0x0114:
            java.lang.String r1 = r9.zzg
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x012e
            java.lang.String r1 = r9.zzg
            java.lang.String r2 = r10.zzac()
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x012e
            java.lang.String r11 = r9.zzg
            r10.zzi((java.lang.String) r11)
            r11 = 1
        L_0x012e:
            com.google.android.gms.measurement.internal.zzgd r1 = r8.zzj
            com.google.android.gms.measurement.internal.zzy r1 = r1.zzb()
            com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean> r2 = com.google.android.gms.measurement.internal.zzaq.zzcl
            boolean r1 = r1.zza((com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean>) r2)
            if (r1 != 0) goto L_0x014c
            long r1 = r9.zzl
            long r5 = r10.zzae()
            int r7 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x014c
            long r1 = r9.zzl
            r10.zzp(r1)
            r11 = 1
        L_0x014c:
            boolean r1 = r9.zzo
            boolean r2 = r10.zzaf()
            if (r1 == r2) goto L_0x015a
            boolean r11 = r9.zzo
            r10.zzb((boolean) r11)
            r11 = 1
        L_0x015a:
            boolean r1 = r9.zzp
            boolean r2 = r10.zzag()
            if (r1 == r2) goto L_0x0168
            boolean r11 = r9.zzp
            r10.zzc((boolean) r11)
            r11 = 1
        L_0x0168:
            java.lang.Boolean r1 = r9.zzs
            java.lang.Boolean r2 = r10.zzah()
            if (r1 == r2) goto L_0x0176
            java.lang.Boolean r11 = r9.zzs
            r10.zza((java.lang.Boolean) r11)
            r11 = 1
        L_0x0176:
            long r1 = r9.zzt
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x018a
            long r3 = r10.zzq()
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x018a
            long r1 = r9.zzt
            r10.zzf((long) r1)
            goto L_0x018b
        L_0x018a:
            r0 = r11
        L_0x018b:
            if (r0 == 0) goto L_0x0194
            com.google.android.gms.measurement.internal.zzad r9 = r8.zze()
            r9.zza((com.google.android.gms.measurement.internal.zzf) r10)
        L_0x0194:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkk.zza(com.google.android.gms.measurement.internal.zzn, com.google.android.gms.measurement.internal.zzf, java.lang.String):com.google.android.gms.measurement.internal.zzf");
    }

    public static zzkk zza(Context context) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (zza == null) {
            synchronized (zzkk.class) {
                if (zza == null) {
                    zza = new zzkk(new zzkq(context));
                }
            }
        }
        return zza;
    }

    @WorkerThread
    private final zzn zza(String str) {
        String str2 = str;
        zzf zzb2 = zze().zzb(str2);
        if (zzb2 == null || TextUtils.isEmpty(zzb2.zzl())) {
            this.zzj.zzr().zzw().zza("No app data available; dropping", str2);
            return null;
        }
        Boolean zzb3 = zzb(zzb2);
        if (zzb3 == null || zzb3.booleanValue()) {
            return new zzn(str, zzb2.zze(), zzb2.zzl(), zzb2.zzm(), zzb2.zzn(), zzb2.zzo(), zzb2.zzp(), (String) null, zzb2.zzr(), false, zzb2.zzi(), zzb2.zzae(), 0, 0, zzb2.zzaf(), zzb2.zzag(), false, zzb2.zzf(), zzb2.zzah(), zzb2.zzq(), zzb2.zzai(), (!zzoe.zzb() || !this.zzj.zzb().zze(str2, zzaq.zzbn)) ? null : zzb2.zzg());
        }
        this.zzj.zzr().zzf().zza("App version does not match; dropping. appId", zzez.zza(str));
        return null;
    }

    @VisibleForTesting
    private static void zza(zzcc.zzc.zza zza2, int i, String str) {
        List<zzcc.zze> zza3 = zza2.zza();
        int i2 = 0;
        while (i2 < zza3.size()) {
            if (!"_err".equals(zza3.get(i2).zzb())) {
                i2++;
            } else {
                return;
            }
        }
        zza2.zza((zzcc.zze) ((zzib) zzcc.zze.zzm().zza("_err").zza(Long.valueOf((long) i).longValue()).zzv())).zza((zzcc.zze) ((zzib) zzcc.zze.zzm().zza("_ev").zzb(str).zzv()));
    }

    @VisibleForTesting
    private static void zza(zzcc.zzc.zza zza2, @NonNull String str) {
        List<zzcc.zze> zza3 = zza2.zza();
        for (int i = 0; i < zza3.size(); i++) {
            if (str.equals(zza3.get(i).zzb())) {
                zza2.zzb(i);
                return;
            }
        }
    }

    private static void zza(zzcc.zzg.zza zza2) {
        zza2.zzb((long) LongCompanionObject.MAX_VALUE).zzc(Long.MIN_VALUE);
        for (int i = 0; i < zza2.zzb(); i++) {
            zzcc.zzc zzb2 = zza2.zzb(i);
            if (zzb2.zze() < zza2.zzf()) {
                zza2.zzb(zzb2.zze());
            }
            if (zzb2.zze() > zza2.zzg()) {
                zza2.zzc(zzb2.zze());
            }
        }
    }

    @VisibleForTesting
    private final void zza(zzcc.zzg.zza zza2, long j, boolean z) {
        String str = z ? "_se" : "_lte";
        zzkt zzc2 = zze().zzc(zza2.zzj(), str);
        zzkt zzkt = (zzc2 == null || zzc2.zze == null) ? new zzkt(zza2.zzj(), "auto", str, this.zzj.zzm().currentTimeMillis(), Long.valueOf(j)) : new zzkt(zza2.zzj(), "auto", str, this.zzj.zzm().currentTimeMillis(), Long.valueOf(((Long) zzc2.zze).longValue() + j));
        zzcc.zzk zzk2 = (zzcc.zzk) ((zzib) zzcc.zzk.zzj().zza(str).zza(this.zzj.zzm().currentTimeMillis()).zzb(((Long) zzkt.zze).longValue()).zzv());
        boolean z2 = false;
        int zza3 = zzks.zza(zza2, str);
        if (zza3 >= 0) {
            zza2.zza(zza3, zzk2);
            z2 = true;
        }
        if (!z2) {
            zza2.zza(zzk2);
        }
        if (j > 0) {
            zze().zza(zzkt);
            this.zzj.zzr().zzx().zza("Updated engagement user property. scope, value", z ? "session-scoped" : "lifetime", zzkt.zze);
        }
    }

    @WorkerThread
    private final void zza(zzf zzf2) {
        ArrayMap arrayMap;
        zzw();
        if (!zzoe.zzb() || !this.zzj.zzb().zze(zzf2.zzc(), zzaq.zzbn)) {
            if (TextUtils.isEmpty(zzf2.zze()) && TextUtils.isEmpty(zzf2.zzf())) {
                zza(zzf2.zzc(), 204, (Throwable) null, (byte[]) null, (Map<String, List<String>>) null);
                return;
            }
        } else if (TextUtils.isEmpty(zzf2.zze()) && TextUtils.isEmpty(zzf2.zzg()) && TextUtils.isEmpty(zzf2.zzf())) {
            zza(zzf2.zzc(), 204, (Throwable) null, (byte[]) null, (Map<String, List<String>>) null);
            return;
        }
        String zza2 = this.zzj.zzb().zza(zzf2);
        try {
            URL url = new URL(zza2);
            this.zzj.zzr().zzx().zza("Fetching remote configuration", zzf2.zzc());
            zzca.zzb zza3 = zzc().zza(zzf2.zzc());
            String zzb2 = zzc().zzb(zzf2.zzc());
            if (zza3 == null || TextUtils.isEmpty(zzb2)) {
                arrayMap = null;
            } else {
                ArrayMap arrayMap2 = new ArrayMap();
                arrayMap2.put("If-Modified-Since", zzb2);
                arrayMap = arrayMap2;
            }
            this.zzq = true;
            zzfc zzd2 = zzd();
            String zzc2 = zzf2.zzc();
            zzkp zzkp = new zzkp(this);
            zzd2.zzd();
            zzd2.zzak();
            Preconditions.checkNotNull(url);
            Preconditions.checkNotNull(zzkp);
            zzd2.zzq().zzb((Runnable) new zzfg(zzd2, zzc2, url, (byte[]) null, arrayMap, zzkp));
        } catch (MalformedURLException unused) {
            this.zzj.zzr().zzf().zza("Failed to parse config URL. Not fetching. appId", zzez.zza(zzf2.zzc()), zza2);
        }
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zza(zzkq zzkq) {
        this.zzj.zzq().zzd();
        zzad zzad = new zzad(this);
        zzad.zzal();
        this.zzd = zzad;
        this.zzj.zzb().zza((zzaa) this.zzb);
        zzo zzo2 = new zzo(this);
        zzo2.zzal();
        this.zzg = zzo2;
        zzii zzii = new zzii(this);
        zzii.zzal();
        this.zzi = zzii;
        zzkg zzkg = new zzkg(this);
        zzkg.zzal();
        this.zzf = zzkg;
        this.zze = new zzfj(this);
        if (this.zzo != this.zzp) {
            this.zzj.zzr().zzf().zza("Not all upload components initialized", Integer.valueOf(this.zzo), Integer.valueOf(this.zzp));
        }
        this.zzk = true;
    }

    @WorkerThread
    @VisibleForTesting
    private final boolean zza(int i, FileChannel fileChannel) {
        zzw();
        if (fileChannel == null || !fileChannel.isOpen()) {
            this.zzj.zzr().zzf().zza("Bad channel to read from");
            return false;
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt(i);
        allocate.flip();
        try {
            fileChannel.truncate(0);
            if (this.zzj.zzb().zza(zzaq.zzby) && Build.VERSION.SDK_INT <= 19) {
                fileChannel.position(0);
            }
            fileChannel.write(allocate);
            fileChannel.force(true);
            if (fileChannel.size() != 4) {
                this.zzj.zzr().zzf().zza("Error writing to channel. Bytes written", Long.valueOf(fileChannel.size()));
            }
            return true;
        } catch (IOException e) {
            this.zzj.zzr().zzf().zza("Failed to write to channel", e);
            return false;
        }
    }

    private final boolean zza(zzcc.zzc.zza zza2, zzcc.zzc.zza zza3) {
        Preconditions.checkArgument("_e".equals(zza2.zzd()));
        zzh();
        zzcc.zze zza4 = zzks.zza((zzcc.zzc) ((zzib) zza2.zzv()), "_sc");
        String str = null;
        String zzd2 = zza4 == null ? null : zza4.zzd();
        zzh();
        zzcc.zze zza5 = zzks.zza((zzcc.zzc) ((zzib) zza3.zzv()), "_pc");
        if (zza5 != null) {
            str = zza5.zzd();
        }
        if (str == null || !str.equals(zzd2)) {
            return false;
        }
        zzb(zza2, zza3);
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0235, code lost:
        if (r5 != null) goto L_0x0084;
     */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x024b A[Catch:{ all -> 0x0f2c }] */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x038e A[Catch:{ all -> 0x0f2c }] */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x0390 A[Catch:{ all -> 0x0f2c }] */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x0393 A[Catch:{ all -> 0x0f2c }] */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x0394 A[Catch:{ all -> 0x0f2c }] */
    /* JADX WARNING: Removed duplicated region for block: B:203:0x058a A[Catch:{ all -> 0x0f2c }] */
    /* JADX WARNING: Removed duplicated region for block: B:242:0x0661 A[Catch:{ all -> 0x0f2c }] */
    /* JADX WARNING: Removed duplicated region for block: B:293:0x07fc A[Catch:{ all -> 0x0f2c }] */
    /* JADX WARNING: Removed duplicated region for block: B:300:0x0818 A[Catch:{ all -> 0x0f2c }] */
    /* JADX WARNING: Removed duplicated region for block: B:302:0x0832 A[Catch:{ all -> 0x0f2c }] */
    /* JADX WARNING: Removed duplicated region for block: B:422:0x0b6c A[Catch:{ all -> 0x0f2c }] */
    /* JADX WARNING: Removed duplicated region for block: B:423:0x0b7f A[Catch:{ all -> 0x0f2c }] */
    /* JADX WARNING: Removed duplicated region for block: B:425:0x0b82 A[Catch:{ all -> 0x0f2c }] */
    /* JADX WARNING: Removed duplicated region for block: B:426:0x0ba6 A[SYNTHETIC, Splitter:B:426:0x0ba6] */
    /* JADX WARNING: Removed duplicated region for block: B:540:0x0f0f  */
    /* JADX WARNING: Removed duplicated region for block: B:548:0x0f26 A[SYNTHETIC, Splitter:B:548:0x0f26] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x023d A[Catch:{ all -> 0x0f2c }] */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zza(java.lang.String r44, long r45) {
        /*
            r43 = this;
            r1 = r43
            java.lang.String r2 = "_npa"
            java.lang.String r3 = ""
            com.google.android.gms.measurement.internal.zzad r4 = r43.zze()
            r4.zzf()
            com.google.android.gms.measurement.internal.zzkk$zza r4 = new com.google.android.gms.measurement.internal.zzkk$zza     // Catch:{ all -> 0x0f2c }
            r5 = 0
            r4.<init>(r1, r5)     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.measurement.internal.zzad r6 = r43.zze()     // Catch:{ all -> 0x0f2c }
            long r7 = r1.zzx     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r4)     // Catch:{ all -> 0x0f2c }
            r6.zzd()     // Catch:{ all -> 0x0f2c }
            r6.zzak()     // Catch:{ all -> 0x0f2c }
            r10 = -1
            r12 = 2
            r13 = 0
            r14 = 1
            android.database.sqlite.SQLiteDatabase r15 = r6.mo24209c_()     // Catch:{ SQLiteException -> 0x0220, all -> 0x021a }
            boolean r16 = android.text.TextUtils.isEmpty(r5)     // Catch:{ SQLiteException -> 0x0220, all -> 0x021a }
            if (r16 == 0) goto L_0x0095
            int r16 = (r7 > r10 ? 1 : (r7 == r10 ? 0 : -1))
            if (r16 == 0) goto L_0x0049
            java.lang.String[] r9 = new java.lang.String[r12]     // Catch:{ SQLiteException -> 0x0044 }
            java.lang.String r16 = java.lang.String.valueOf(r7)     // Catch:{ SQLiteException -> 0x0044 }
            r9[r13] = r16     // Catch:{ SQLiteException -> 0x0044 }
            java.lang.String r16 = java.lang.String.valueOf(r45)     // Catch:{ SQLiteException -> 0x0044 }
            r9[r14] = r16     // Catch:{ SQLiteException -> 0x0044 }
            goto L_0x0051
        L_0x0044:
            r0 = move-exception
            r7 = r0
            r9 = r5
            goto L_0x0224
        L_0x0049:
            java.lang.String[] r9 = new java.lang.String[r14]     // Catch:{ SQLiteException -> 0x0220, all -> 0x021a }
            java.lang.String r16 = java.lang.String.valueOf(r45)     // Catch:{ SQLiteException -> 0x0220, all -> 0x021a }
            r9[r13] = r16     // Catch:{ SQLiteException -> 0x0220, all -> 0x021a }
        L_0x0051:
            int r16 = (r7 > r10 ? 1 : (r7 == r10 ? 0 : -1))
            if (r16 == 0) goto L_0x005a
            java.lang.String r16 = "rowid <= ? and "
            r45 = r16
            goto L_0x005c
        L_0x005a:
            r45 = r3
        L_0x005c:
            int r5 = r45.length()     // Catch:{ SQLiteException -> 0x0220, all -> 0x021a }
            int r5 = r5 + 148
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x0220, all -> 0x021a }
            r12.<init>(r5)     // Catch:{ SQLiteException -> 0x0220, all -> 0x021a }
            java.lang.String r5 = "select app_id, metadata_fingerprint from raw_events where "
            r12.append(r5)     // Catch:{ SQLiteException -> 0x0220, all -> 0x021a }
            r5 = r45
            r12.append(r5)     // Catch:{ SQLiteException -> 0x0220, all -> 0x021a }
            java.lang.String r5 = "app_id in (select app_id from apps where config_fetched_time >= ?) order by rowid limit 1;"
            r12.append(r5)     // Catch:{ SQLiteException -> 0x0220, all -> 0x021a }
            java.lang.String r5 = r12.toString()     // Catch:{ SQLiteException -> 0x0220, all -> 0x021a }
            android.database.Cursor r5 = r15.rawQuery(r5, r9)     // Catch:{ SQLiteException -> 0x0220, all -> 0x021a }
            boolean r9 = r5.moveToFirst()     // Catch:{ SQLiteException -> 0x0217 }
            if (r9 != 0) goto L_0x0089
        L_0x0084:
            r5.close()     // Catch:{ all -> 0x0f2c }
            goto L_0x0239
        L_0x0089:
            java.lang.String r9 = r5.getString(r13)     // Catch:{ SQLiteException -> 0x0217 }
            java.lang.String r12 = r5.getString(r14)     // Catch:{ SQLiteException -> 0x0214 }
            r5.close()     // Catch:{ SQLiteException -> 0x0214 }
            goto L_0x00e2
        L_0x0095:
            int r5 = (r7 > r10 ? 1 : (r7 == r10 ? 0 : -1))
            if (r5 == 0) goto L_0x00a6
            r5 = 2
            java.lang.String[] r9 = new java.lang.String[r5]     // Catch:{ SQLiteException -> 0x0220, all -> 0x021a }
            r5 = 0
            r9[r13] = r5     // Catch:{ SQLiteException -> 0x0220, all -> 0x021a }
            java.lang.String r5 = java.lang.String.valueOf(r7)     // Catch:{ SQLiteException -> 0x0220, all -> 0x021a }
            r9[r14] = r5     // Catch:{ SQLiteException -> 0x0220, all -> 0x021a }
            goto L_0x00ab
        L_0x00a6:
            r5 = 0
            java.lang.String[] r9 = new java.lang.String[]{r5}     // Catch:{ SQLiteException -> 0x0220, all -> 0x021a }
        L_0x00ab:
            int r5 = (r7 > r10 ? 1 : (r7 == r10 ? 0 : -1))
            if (r5 == 0) goto L_0x00b2
            java.lang.String r5 = " and rowid <= ?"
            goto L_0x00b3
        L_0x00b2:
            r5 = r3
        L_0x00b3:
            int r12 = r5.length()     // Catch:{ SQLiteException -> 0x0220, all -> 0x021a }
            int r12 = r12 + 84
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x0220, all -> 0x021a }
            r10.<init>(r12)     // Catch:{ SQLiteException -> 0x0220, all -> 0x021a }
            java.lang.String r11 = "select metadata_fingerprint from raw_events where app_id = ?"
            r10.append(r11)     // Catch:{ SQLiteException -> 0x0220, all -> 0x021a }
            r10.append(r5)     // Catch:{ SQLiteException -> 0x0220, all -> 0x021a }
            java.lang.String r5 = " order by rowid limit 1;"
            r10.append(r5)     // Catch:{ SQLiteException -> 0x0220, all -> 0x021a }
            java.lang.String r5 = r10.toString()     // Catch:{ SQLiteException -> 0x0220, all -> 0x021a }
            android.database.Cursor r5 = r15.rawQuery(r5, r9)     // Catch:{ SQLiteException -> 0x0220, all -> 0x021a }
            boolean r9 = r5.moveToFirst()     // Catch:{ SQLiteException -> 0x0217 }
            if (r9 != 0) goto L_0x00da
            goto L_0x0084
        L_0x00da:
            java.lang.String r12 = r5.getString(r13)     // Catch:{ SQLiteException -> 0x0217 }
            r5.close()     // Catch:{ SQLiteException -> 0x0217 }
            r9 = 0
        L_0x00e2:
            java.lang.String r16 = "raw_events_metadata"
            java.lang.String r10 = "metadata"
            java.lang.String[] r17 = new java.lang.String[]{r10}     // Catch:{ SQLiteException -> 0x0214 }
            java.lang.String r18 = "app_id = ? and metadata_fingerprint = ?"
            r10 = 2
            java.lang.String[] r11 = new java.lang.String[r10]     // Catch:{ SQLiteException -> 0x0214 }
            r11[r13] = r9     // Catch:{ SQLiteException -> 0x0214 }
            r11[r14] = r12     // Catch:{ SQLiteException -> 0x0214 }
            r20 = 0
            r21 = 0
            java.lang.String r22 = "rowid"
            java.lang.String r23 = "2"
            r10 = r15
            r15 = r10
            r19 = r11
            android.database.Cursor r5 = r15.query(r16, r17, r18, r19, r20, r21, r22, r23)     // Catch:{ SQLiteException -> 0x0214 }
            boolean r11 = r5.moveToFirst()     // Catch:{ SQLiteException -> 0x0214 }
            if (r11 != 0) goto L_0x011c
            com.google.android.gms.measurement.internal.zzez r7 = r6.zzr()     // Catch:{ SQLiteException -> 0x0214 }
            com.google.android.gms.measurement.internal.zzfb r7 = r7.zzf()     // Catch:{ SQLiteException -> 0x0214 }
            java.lang.String r8 = "Raw event metadata record is missing. appId"
            java.lang.Object r10 = com.google.android.gms.measurement.internal.zzez.zza((java.lang.String) r9)     // Catch:{ SQLiteException -> 0x0214 }
            r7.zza(r8, r10)     // Catch:{ SQLiteException -> 0x0214 }
            goto L_0x0084
        L_0x011c:
            byte[] r11 = r5.getBlob(r13)     // Catch:{ SQLiteException -> 0x0214 }
            com.google.android.gms.internal.measurement.zzcc$zzg$zza r15 = com.google.android.gms.internal.measurement.zzcc.zzg.zzbf()     // Catch:{ IOException -> 0x01ff }
            com.google.android.gms.internal.measurement.zzjm r11 = com.google.android.gms.measurement.internal.zzks.zza(r15, (byte[]) r11)     // Catch:{ IOException -> 0x01ff }
            com.google.android.gms.internal.measurement.zzcc$zzg$zza r11 = (com.google.android.gms.internal.measurement.zzcc.zzg.zza) r11     // Catch:{ IOException -> 0x01ff }
            com.google.android.gms.internal.measurement.zzjj r11 = r11.zzv()     // Catch:{ IOException -> 0x01ff }
            com.google.android.gms.internal.measurement.zzib r11 = (com.google.android.gms.internal.measurement.zzib) r11     // Catch:{ IOException -> 0x01ff }
            com.google.android.gms.internal.measurement.zzcc$zzg r11 = (com.google.android.gms.internal.measurement.zzcc.zzg) r11     // Catch:{ IOException -> 0x01ff }
            boolean r15 = r5.moveToNext()     // Catch:{ SQLiteException -> 0x0214 }
            if (r15 == 0) goto L_0x0149
            com.google.android.gms.measurement.internal.zzez r15 = r6.zzr()     // Catch:{ SQLiteException -> 0x0214 }
            com.google.android.gms.measurement.internal.zzfb r15 = r15.zzi()     // Catch:{ SQLiteException -> 0x0214 }
            java.lang.String r14 = "Get multiple raw event metadata records, expected one. appId"
            java.lang.Object r13 = com.google.android.gms.measurement.internal.zzez.zza((java.lang.String) r9)     // Catch:{ SQLiteException -> 0x0214 }
            r15.zza(r14, r13)     // Catch:{ SQLiteException -> 0x0214 }
        L_0x0149:
            r5.close()     // Catch:{ SQLiteException -> 0x0214 }
            r4.zza(r11)     // Catch:{ SQLiteException -> 0x0214 }
            r13 = -1
            int r11 = (r7 > r13 ? 1 : (r7 == r13 ? 0 : -1))
            if (r11 == 0) goto L_0x016c
            java.lang.String r11 = "app_id = ? and metadata_fingerprint = ? and rowid <= ?"
            r13 = 3
            java.lang.String[] r14 = new java.lang.String[r13]     // Catch:{ SQLiteException -> 0x0214 }
            r13 = 0
            r14[r13] = r9     // Catch:{ SQLiteException -> 0x0214 }
            r13 = 1
            r14[r13] = r12     // Catch:{ SQLiteException -> 0x0214 }
            java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch:{ SQLiteException -> 0x0214 }
            r8 = 2
            r14[r8] = r7     // Catch:{ SQLiteException -> 0x0214 }
            r18 = r11
            r19 = r14
            goto L_0x017b
        L_0x016c:
            java.lang.String r7 = "app_id = ? and metadata_fingerprint = ?"
            r8 = 2
            java.lang.String[] r11 = new java.lang.String[r8]     // Catch:{ SQLiteException -> 0x0214 }
            r8 = 0
            r11[r8] = r9     // Catch:{ SQLiteException -> 0x0214 }
            r8 = 1
            r11[r8] = r12     // Catch:{ SQLiteException -> 0x0214 }
            r18 = r7
            r19 = r11
        L_0x017b:
            java.lang.String r16 = "raw_events"
            java.lang.String r7 = "rowid"
            java.lang.String r8 = "name"
            java.lang.String r11 = "timestamp"
            java.lang.String r12 = "data"
            java.lang.String[] r17 = new java.lang.String[]{r7, r8, r11, r12}     // Catch:{ SQLiteException -> 0x0214 }
            r20 = 0
            r21 = 0
            java.lang.String r22 = "rowid"
            r23 = 0
            r15 = r10
            android.database.Cursor r5 = r15.query(r16, r17, r18, r19, r20, r21, r22, r23)     // Catch:{ SQLiteException -> 0x0214 }
            boolean r7 = r5.moveToFirst()     // Catch:{ SQLiteException -> 0x0214 }
            if (r7 != 0) goto L_0x01af
            com.google.android.gms.measurement.internal.zzez r7 = r6.zzr()     // Catch:{ SQLiteException -> 0x0214 }
            com.google.android.gms.measurement.internal.zzfb r7 = r7.zzi()     // Catch:{ SQLiteException -> 0x0214 }
            java.lang.String r8 = "Raw event data disappeared while in transaction. appId"
            java.lang.Object r10 = com.google.android.gms.measurement.internal.zzez.zza((java.lang.String) r9)     // Catch:{ SQLiteException -> 0x0214 }
            r7.zza(r8, r10)     // Catch:{ SQLiteException -> 0x0214 }
            goto L_0x0084
        L_0x01af:
            r7 = 0
            long r10 = r5.getLong(r7)     // Catch:{ SQLiteException -> 0x0214 }
            r7 = 3
            byte[] r8 = r5.getBlob(r7)     // Catch:{ SQLiteException -> 0x0214 }
            com.google.android.gms.internal.measurement.zzcc$zzc$zza r7 = com.google.android.gms.internal.measurement.zzcc.zzc.zzj()     // Catch:{ IOException -> 0x01e4 }
            com.google.android.gms.internal.measurement.zzjm r7 = com.google.android.gms.measurement.internal.zzks.zza(r7, (byte[]) r8)     // Catch:{ IOException -> 0x01e4 }
            com.google.android.gms.internal.measurement.zzcc$zzc$zza r7 = (com.google.android.gms.internal.measurement.zzcc.zzc.zza) r7     // Catch:{ IOException -> 0x01e4 }
            r8 = 1
            java.lang.String r12 = r5.getString(r8)     // Catch:{ SQLiteException -> 0x0214 }
            com.google.android.gms.internal.measurement.zzcc$zzc$zza r8 = r7.zza((java.lang.String) r12)     // Catch:{ SQLiteException -> 0x0214 }
            r12 = 2
            long r13 = r5.getLong(r12)     // Catch:{ SQLiteException -> 0x0214 }
            r8.zza((long) r13)     // Catch:{ SQLiteException -> 0x0214 }
            com.google.android.gms.internal.measurement.zzjj r7 = r7.zzv()     // Catch:{ SQLiteException -> 0x0214 }
            com.google.android.gms.internal.measurement.zzib r7 = (com.google.android.gms.internal.measurement.zzib) r7     // Catch:{ SQLiteException -> 0x0214 }
            com.google.android.gms.internal.measurement.zzcc$zzc r7 = (com.google.android.gms.internal.measurement.zzcc.zzc) r7     // Catch:{ SQLiteException -> 0x0214 }
            boolean r7 = r4.zza(r10, r7)     // Catch:{ SQLiteException -> 0x0214 }
            if (r7 != 0) goto L_0x01f7
            goto L_0x0084
        L_0x01e4:
            r0 = move-exception
            r7 = r0
            com.google.android.gms.measurement.internal.zzez r8 = r6.zzr()     // Catch:{ SQLiteException -> 0x0214 }
            com.google.android.gms.measurement.internal.zzfb r8 = r8.zzf()     // Catch:{ SQLiteException -> 0x0214 }
            java.lang.String r10 = "Data loss. Failed to merge raw event. appId"
            java.lang.Object r11 = com.google.android.gms.measurement.internal.zzez.zza((java.lang.String) r9)     // Catch:{ SQLiteException -> 0x0214 }
            r8.zza(r10, r11, r7)     // Catch:{ SQLiteException -> 0x0214 }
        L_0x01f7:
            boolean r7 = r5.moveToNext()     // Catch:{ SQLiteException -> 0x0214 }
            if (r7 != 0) goto L_0x01af
            goto L_0x0084
        L_0x01ff:
            r0 = move-exception
            r7 = r0
            com.google.android.gms.measurement.internal.zzez r8 = r6.zzr()     // Catch:{ SQLiteException -> 0x0214 }
            com.google.android.gms.measurement.internal.zzfb r8 = r8.zzf()     // Catch:{ SQLiteException -> 0x0214 }
            java.lang.String r10 = "Data loss. Failed to merge raw event metadata. appId"
            java.lang.Object r11 = com.google.android.gms.measurement.internal.zzez.zza((java.lang.String) r9)     // Catch:{ SQLiteException -> 0x0214 }
            r8.zza(r10, r11, r7)     // Catch:{ SQLiteException -> 0x0214 }
            goto L_0x0084
        L_0x0214:
            r0 = move-exception
            r7 = r0
            goto L_0x0224
        L_0x0217:
            r0 = move-exception
            r7 = r0
            goto L_0x0223
        L_0x021a:
            r0 = move-exception
            r2 = r1
            r5 = 0
        L_0x021d:
            r1 = r0
            goto L_0x0f24
        L_0x0220:
            r0 = move-exception
            r7 = r0
            r5 = 0
        L_0x0223:
            r9 = 0
        L_0x0224:
            com.google.android.gms.measurement.internal.zzez r6 = r6.zzr()     // Catch:{ all -> 0x0f20 }
            com.google.android.gms.measurement.internal.zzfb r6 = r6.zzf()     // Catch:{ all -> 0x0f20 }
            java.lang.String r8 = "Data loss. Error selecting raw event. appId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzez.zza((java.lang.String) r9)     // Catch:{ all -> 0x0f20 }
            r6.zza(r8, r9, r7)     // Catch:{ all -> 0x0f20 }
            if (r5 == 0) goto L_0x0239
            goto L_0x0084
        L_0x0239:
            java.util.List<com.google.android.gms.internal.measurement.zzcc$zzc> r5 = r4.zzc     // Catch:{ all -> 0x0f2c }
            if (r5 == 0) goto L_0x0248
            java.util.List<com.google.android.gms.internal.measurement.zzcc$zzc> r5 = r4.zzc     // Catch:{ all -> 0x0f2c }
            boolean r5 = r5.isEmpty()     // Catch:{ all -> 0x0f2c }
            if (r5 == 0) goto L_0x0246
            goto L_0x0248
        L_0x0246:
            r5 = 0
            goto L_0x0249
        L_0x0248:
            r5 = 1
        L_0x0249:
            if (r5 != 0) goto L_0x0f0f
            com.google.android.gms.internal.measurement.zzcc$zzg r5 = r4.zza     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.internal.measurement.zzib$zza r5 = r5.zzbl()     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.internal.measurement.zzcc$zzg$zza r5 = (com.google.android.gms.internal.measurement.zzcc.zzg.zza) r5     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.internal.measurement.zzcc$zzg$zza r5 = r5.zzc()     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.measurement.internal.zzgd r6 = r1.zzj     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.measurement.internal.zzy r6 = r6.zzb()     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.internal.measurement.zzcc$zzg r7 = r4.zza     // Catch:{ all -> 0x0f2c }
            java.lang.String r7 = r7.zzx()     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean> r8 = com.google.android.gms.measurement.internal.zzaq.zzau     // Catch:{ all -> 0x0f2c }
            boolean r6 = r6.zze(r7, r8)     // Catch:{ all -> 0x0f2c }
            r7 = -1
            r8 = -1
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
        L_0x0272:
            java.util.List<com.google.android.gms.internal.measurement.zzcc$zzc> r9 = r4.zzc     // Catch:{ all -> 0x0f2c }
            int r9 = r9.size()     // Catch:{ all -> 0x0f2c }
            r18 = r3
            java.lang.String r3 = "_fr"
            r19 = r13
            java.lang.String r13 = "_et"
            r20 = r2
            java.lang.String r2 = "_e"
            r21 = r14
            r22 = r15
            if (r12 >= r9) goto L_0x088b
            java.util.List<com.google.android.gms.internal.measurement.zzcc$zzc> r9 = r4.zzc     // Catch:{ all -> 0x0f2c }
            java.lang.Object r9 = r9.get(r12)     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.internal.measurement.zzcc$zzc r9 = (com.google.android.gms.internal.measurement.zzcc.zzc) r9     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.internal.measurement.zzib$zza r9 = r9.zzbl()     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.internal.measurement.zzcc$zzc$zza r9 = (com.google.android.gms.internal.measurement.zzcc.zzc.zza) r9     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.measurement.internal.zzfx r14 = r43.zzc()     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.internal.measurement.zzcc$zzg r15 = r4.zza     // Catch:{ all -> 0x0f2c }
            java.lang.String r15 = r15.zzx()     // Catch:{ all -> 0x0f2c }
            r16 = r12
            java.lang.String r12 = r9.zzd()     // Catch:{ all -> 0x0f2c }
            boolean r12 = r14.zzb(r15, r12)     // Catch:{ all -> 0x0f2c }
            java.lang.String r14 = "_err"
            if (r12 == 0) goto L_0x032d
            com.google.android.gms.measurement.internal.zzgd r2 = r1.zzj     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.measurement.internal.zzez r2 = r2.zzr()     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.measurement.internal.zzfb r2 = r2.zzi()     // Catch:{ all -> 0x0f2c }
            java.lang.String r3 = "Dropping blacklisted raw event. appId"
            com.google.android.gms.internal.measurement.zzcc$zzg r12 = r4.zza     // Catch:{ all -> 0x0f2c }
            java.lang.String r12 = r12.zzx()     // Catch:{ all -> 0x0f2c }
            java.lang.Object r12 = com.google.android.gms.measurement.internal.zzez.zza((java.lang.String) r12)     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.measurement.internal.zzgd r13 = r1.zzj     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.measurement.internal.zzex r13 = r13.zzj()     // Catch:{ all -> 0x0f2c }
            java.lang.String r15 = r9.zzd()     // Catch:{ all -> 0x0f2c }
            java.lang.String r13 = r13.zza((java.lang.String) r15)     // Catch:{ all -> 0x0f2c }
            r2.zza(r3, r12, r13)     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.measurement.internal.zzfx r2 = r43.zzc()     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.internal.measurement.zzcc$zzg r3 = r4.zza     // Catch:{ all -> 0x0f2c }
            java.lang.String r3 = r3.zzx()     // Catch:{ all -> 0x0f2c }
            boolean r2 = r2.zzg(r3)     // Catch:{ all -> 0x0f2c }
            if (r2 != 0) goto L_0x02fa
            com.google.android.gms.measurement.internal.zzfx r2 = r43.zzc()     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.internal.measurement.zzcc$zzg r3 = r4.zza     // Catch:{ all -> 0x0f2c }
            java.lang.String r3 = r3.zzx()     // Catch:{ all -> 0x0f2c }
            boolean r2 = r2.zzh(r3)     // Catch:{ all -> 0x0f2c }
            if (r2 == 0) goto L_0x02f8
            goto L_0x02fa
        L_0x02f8:
            r2 = 0
            goto L_0x02fb
        L_0x02fa:
            r2 = 1
        L_0x02fb:
            if (r2 != 0) goto L_0x0320
            java.lang.String r2 = r9.zzd()     // Catch:{ all -> 0x0f2c }
            boolean r2 = r14.equals(r2)     // Catch:{ all -> 0x0f2c }
            if (r2 != 0) goto L_0x0320
            com.google.android.gms.measurement.internal.zzgd r2 = r1.zzj     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.measurement.internal.zzkw r24 = r2.zzi()     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.internal.measurement.zzcc$zzg r2 = r4.zza     // Catch:{ all -> 0x0f2c }
            java.lang.String r25 = r2.zzx()     // Catch:{ all -> 0x0f2c }
            r26 = 11
            java.lang.String r27 = "_ev"
            java.lang.String r28 = r9.zzd()     // Catch:{ all -> 0x0f2c }
            r29 = 0
            r24.zza((java.lang.String) r25, (int) r26, (java.lang.String) r27, (java.lang.String) r28, (int) r29)     // Catch:{ all -> 0x0f2c }
        L_0x0320:
            r26 = r6
            r12 = r16
            r13 = r19
            r14 = r21
            r15 = r22
            r6 = r5
            goto L_0x0880
        L_0x032d:
            com.google.android.gms.measurement.internal.zzfx r12 = r43.zzc()     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.internal.measurement.zzcc$zzg r15 = r4.zza     // Catch:{ all -> 0x0f2c }
            java.lang.String r15 = r15.zzx()     // Catch:{ all -> 0x0f2c }
            r26 = r6
            java.lang.String r6 = r9.zzd()     // Catch:{ all -> 0x0f2c }
            boolean r6 = r12.zzc(r15, r6)     // Catch:{ all -> 0x0f2c }
            java.lang.String r12 = "_c"
            if (r6 != 0) goto L_0x039f
            r43.zzh()     // Catch:{ all -> 0x0f2c }
            java.lang.String r15 = r9.zzd()     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r15)     // Catch:{ all -> 0x0f2c }
            r27 = r7
            int r7 = r15.hashCode()     // Catch:{ all -> 0x0f2c }
            r28 = r10
            r10 = 94660(0x171c4, float:1.32647E-40)
            if (r7 == r10) goto L_0x037b
            r10 = 95025(0x17331, float:1.33158E-40)
            if (r7 == r10) goto L_0x0371
            r10 = 95027(0x17333, float:1.33161E-40)
            if (r7 == r10) goto L_0x0367
            goto L_0x0385
        L_0x0367:
            java.lang.String r7 = "_ui"
            boolean r7 = r15.equals(r7)     // Catch:{ all -> 0x0f2c }
            if (r7 == 0) goto L_0x0385
            r7 = 1
            goto L_0x0386
        L_0x0371:
            java.lang.String r7 = "_ug"
            boolean r7 = r15.equals(r7)     // Catch:{ all -> 0x0f2c }
            if (r7 == 0) goto L_0x0385
            r7 = 2
            goto L_0x0386
        L_0x037b:
            java.lang.String r7 = "_in"
            boolean r7 = r15.equals(r7)     // Catch:{ all -> 0x0f2c }
            if (r7 == 0) goto L_0x0385
            r7 = 0
            goto L_0x0386
        L_0x0385:
            r7 = -1
        L_0x0386:
            if (r7 == 0) goto L_0x0390
            r10 = 1
            if (r7 == r10) goto L_0x0390
            r10 = 2
            if (r7 == r10) goto L_0x0390
            r7 = 0
            goto L_0x0391
        L_0x0390:
            r7 = 1
        L_0x0391:
            if (r7 == 0) goto L_0x0394
            goto L_0x03a3
        L_0x0394:
            r30 = r5
            r31 = r8
            r10 = r11
            r29 = r13
            r13 = r2
            r11 = r3
            goto L_0x0588
        L_0x039f:
            r27 = r7
            r28 = r10
        L_0x03a3:
            r29 = r13
            r7 = 0
            r10 = 0
            r15 = 0
        L_0x03a8:
            int r13 = r9.zzb()     // Catch:{ all -> 0x0f2c }
            r30 = r5
            java.lang.String r5 = "_r"
            if (r15 >= r13) goto L_0x0414
            com.google.android.gms.internal.measurement.zzcc$zze r13 = r9.zza((int) r15)     // Catch:{ all -> 0x0f2c }
            java.lang.String r13 = r13.zzb()     // Catch:{ all -> 0x0f2c }
            boolean r13 = r12.equals(r13)     // Catch:{ all -> 0x0f2c }
            if (r13 == 0) goto L_0x03df
            com.google.android.gms.internal.measurement.zzcc$zze r5 = r9.zza((int) r15)     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.internal.measurement.zzib$zza r5 = r5.zzbl()     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.internal.measurement.zzcc$zze$zza r5 = (com.google.android.gms.internal.measurement.zzcc.zze.zza) r5     // Catch:{ all -> 0x0f2c }
            r13 = r8
            r7 = 1
            com.google.android.gms.internal.measurement.zzcc$zze$zza r5 = r5.zza((long) r7)     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.internal.measurement.zzjj r5 = r5.zzv()     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.internal.measurement.zzib r5 = (com.google.android.gms.internal.measurement.zzib) r5     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.internal.measurement.zzcc$zze r5 = (com.google.android.gms.internal.measurement.zzcc.zze) r5     // Catch:{ all -> 0x0f2c }
            r9.zza((int) r15, (com.google.android.gms.internal.measurement.zzcc.zze) r5)     // Catch:{ all -> 0x0f2c }
            r8 = r11
            r7 = 1
            goto L_0x040d
        L_0x03df:
            r13 = r8
            com.google.android.gms.internal.measurement.zzcc$zze r8 = r9.zza((int) r15)     // Catch:{ all -> 0x0f2c }
            java.lang.String r8 = r8.zzb()     // Catch:{ all -> 0x0f2c }
            boolean r5 = r5.equals(r8)     // Catch:{ all -> 0x0f2c }
            if (r5 == 0) goto L_0x040c
            com.google.android.gms.internal.measurement.zzcc$zze r5 = r9.zza((int) r15)     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.internal.measurement.zzib$zza r5 = r5.zzbl()     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.internal.measurement.zzcc$zze$zza r5 = (com.google.android.gms.internal.measurement.zzcc.zze.zza) r5     // Catch:{ all -> 0x0f2c }
            r8 = r11
            r10 = 1
            com.google.android.gms.internal.measurement.zzcc$zze$zza r5 = r5.zza((long) r10)     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.internal.measurement.zzjj r5 = r5.zzv()     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.internal.measurement.zzib r5 = (com.google.android.gms.internal.measurement.zzib) r5     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.internal.measurement.zzcc$zze r5 = (com.google.android.gms.internal.measurement.zzcc.zze) r5     // Catch:{ all -> 0x0f2c }
            r9.zza((int) r15, (com.google.android.gms.internal.measurement.zzcc.zze) r5)     // Catch:{ all -> 0x0f2c }
            r10 = 1
            goto L_0x040d
        L_0x040c:
            r8 = r11
        L_0x040d:
            int r15 = r15 + 1
            r11 = r8
            r8 = r13
            r5 = r30
            goto L_0x03a8
        L_0x0414:
            r13 = r8
            r8 = r11
            if (r7 != 0) goto L_0x044d
            if (r6 == 0) goto L_0x044d
            com.google.android.gms.measurement.internal.zzgd r7 = r1.zzj     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.measurement.internal.zzez r7 = r7.zzr()     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.measurement.internal.zzfb r7 = r7.zzx()     // Catch:{ all -> 0x0f2c }
            java.lang.String r11 = "Marking event as conversion"
            com.google.android.gms.measurement.internal.zzgd r15 = r1.zzj     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.measurement.internal.zzex r15 = r15.zzj()     // Catch:{ all -> 0x0f2c }
            r31 = r13
            java.lang.String r13 = r9.zzd()     // Catch:{ all -> 0x0f2c }
            java.lang.String r13 = r15.zza((java.lang.String) r13)     // Catch:{ all -> 0x0f2c }
            r7.zza(r11, r13)     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.internal.measurement.zzcc$zze$zza r7 = com.google.android.gms.internal.measurement.zzcc.zze.zzm()     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.internal.measurement.zzcc$zze$zza r7 = r7.zza((java.lang.String) r12)     // Catch:{ all -> 0x0f2c }
            r13 = r2
            r11 = r3
            r2 = 1
            com.google.android.gms.internal.measurement.zzcc$zze$zza r7 = r7.zza((long) r2)     // Catch:{ all -> 0x0f2c }
            r9.zza((com.google.android.gms.internal.measurement.zzcc.zze.zza) r7)     // Catch:{ all -> 0x0f2c }
            goto L_0x0451
        L_0x044d:
            r11 = r3
            r31 = r13
            r13 = r2
        L_0x0451:
            if (r10 != 0) goto L_0x0483
            com.google.android.gms.measurement.internal.zzgd r2 = r1.zzj     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.measurement.internal.zzez r2 = r2.zzr()     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.measurement.internal.zzfb r2 = r2.zzx()     // Catch:{ all -> 0x0f2c }
            java.lang.String r3 = "Marking event as real-time"
            com.google.android.gms.measurement.internal.zzgd r7 = r1.zzj     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.measurement.internal.zzex r7 = r7.zzj()     // Catch:{ all -> 0x0f2c }
            java.lang.String r10 = r9.zzd()     // Catch:{ all -> 0x0f2c }
            java.lang.String r7 = r7.zza((java.lang.String) r10)     // Catch:{ all -> 0x0f2c }
            r2.zza(r3, r7)     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.internal.measurement.zzcc$zze$zza r2 = com.google.android.gms.internal.measurement.zzcc.zze.zzm()     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.internal.measurement.zzcc$zze$zza r2 = r2.zza((java.lang.String) r5)     // Catch:{ all -> 0x0f2c }
            r3 = r8
            r7 = 1
            com.google.android.gms.internal.measurement.zzcc$zze$zza r2 = r2.zza((long) r7)     // Catch:{ all -> 0x0f2c }
            r9.zza((com.google.android.gms.internal.measurement.zzcc.zze.zza) r2)     // Catch:{ all -> 0x0f2c }
            goto L_0x0484
        L_0x0483:
            r3 = r8
        L_0x0484:
            com.google.android.gms.measurement.internal.zzad r32 = r43.zze()     // Catch:{ all -> 0x0f2c }
            long r33 = r43.zzx()     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.internal.measurement.zzcc$zzg r2 = r4.zza     // Catch:{ all -> 0x0f2c }
            java.lang.String r35 = r2.zzx()     // Catch:{ all -> 0x0f2c }
            r36 = 0
            r37 = 0
            r38 = 0
            r39 = 0
            r40 = 1
            com.google.android.gms.measurement.internal.zzac r2 = r32.zza(r33, r35, r36, r37, r38, r39, r40)     // Catch:{ all -> 0x0f2c }
            long r7 = r2.zze     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.measurement.internal.zzgd r2 = r1.zzj     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.measurement.internal.zzy r2 = r2.zzb()     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.internal.measurement.zzcc$zzg r10 = r4.zza     // Catch:{ all -> 0x0f2c }
            java.lang.String r10 = r10.zzx()     // Catch:{ all -> 0x0f2c }
            int r2 = r2.zzc(r10)     // Catch:{ all -> 0x0f2c }
            r10 = r3
            long r2 = (long) r2     // Catch:{ all -> 0x0f2c }
            int r15 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r15 <= 0) goto L_0x04bc
            zza((com.google.android.gms.internal.measurement.zzcc.zzc.zza) r9, (java.lang.String) r5)     // Catch:{ all -> 0x0f2c }
            goto L_0x04be
        L_0x04bc:
            r19 = 1
        L_0x04be:
            java.lang.String r2 = r9.zzd()     // Catch:{ all -> 0x0f2c }
            boolean r2 = com.google.android.gms.measurement.internal.zzkw.zza((java.lang.String) r2)     // Catch:{ all -> 0x0f2c }
            if (r2 == 0) goto L_0x0588
            if (r6 == 0) goto L_0x0588
            com.google.android.gms.measurement.internal.zzad r32 = r43.zze()     // Catch:{ all -> 0x0f2c }
            long r33 = r43.zzx()     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.internal.measurement.zzcc$zzg r2 = r4.zza     // Catch:{ all -> 0x0f2c }
            java.lang.String r35 = r2.zzx()     // Catch:{ all -> 0x0f2c }
            r36 = 0
            r37 = 0
            r38 = 1
            r39 = 0
            r40 = 0
            com.google.android.gms.measurement.internal.zzac r2 = r32.zza(r33, r35, r36, r37, r38, r39, r40)     // Catch:{ all -> 0x0f2c }
            long r2 = r2.zzc     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.measurement.internal.zzgd r5 = r1.zzj     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.measurement.internal.zzy r5 = r5.zzb()     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.internal.measurement.zzcc$zzg r7 = r4.zza     // Catch:{ all -> 0x0f2c }
            java.lang.String r7 = r7.zzx()     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.measurement.internal.zzeo<java.lang.Integer> r8 = com.google.android.gms.measurement.internal.zzaq.zzm     // Catch:{ all -> 0x0f2c }
            int r5 = r5.zzb(r7, r8)     // Catch:{ all -> 0x0f2c }
            long r7 = (long) r5     // Catch:{ all -> 0x0f2c }
            int r5 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r5 <= 0) goto L_0x0588
            com.google.android.gms.measurement.internal.zzgd r2 = r1.zzj     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.measurement.internal.zzez r2 = r2.zzr()     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.measurement.internal.zzfb r2 = r2.zzi()     // Catch:{ all -> 0x0f2c }
            java.lang.String r3 = "Too many conversions. Not logging as conversion. appId"
            com.google.android.gms.internal.measurement.zzcc$zzg r5 = r4.zza     // Catch:{ all -> 0x0f2c }
            java.lang.String r5 = r5.zzx()     // Catch:{ all -> 0x0f2c }
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzez.zza((java.lang.String) r5)     // Catch:{ all -> 0x0f2c }
            r2.zza(r3, r5)     // Catch:{ all -> 0x0f2c }
            r2 = -1
            r3 = 0
            r5 = 0
            r7 = 0
        L_0x051c:
            int r8 = r9.zzb()     // Catch:{ all -> 0x0f2c }
            if (r7 >= r8) goto L_0x0547
            com.google.android.gms.internal.measurement.zzcc$zze r8 = r9.zza((int) r7)     // Catch:{ all -> 0x0f2c }
            java.lang.String r15 = r8.zzb()     // Catch:{ all -> 0x0f2c }
            boolean r15 = r12.equals(r15)     // Catch:{ all -> 0x0f2c }
            if (r15 == 0) goto L_0x0539
            com.google.android.gms.internal.measurement.zzib$zza r2 = r8.zzbl()     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.internal.measurement.zzcc$zze$zza r2 = (com.google.android.gms.internal.measurement.zzcc.zze.zza) r2     // Catch:{ all -> 0x0f2c }
            r3 = r2
            r2 = r7
            goto L_0x0544
        L_0x0539:
            java.lang.String r8 = r8.zzb()     // Catch:{ all -> 0x0f2c }
            boolean r8 = r14.equals(r8)     // Catch:{ all -> 0x0f2c }
            if (r8 == 0) goto L_0x0544
            r5 = 1
        L_0x0544:
            int r7 = r7 + 1
            goto L_0x051c
        L_0x0547:
            if (r5 == 0) goto L_0x054f
            if (r3 == 0) goto L_0x054f
            r9.zzb((int) r2)     // Catch:{ all -> 0x0f2c }
            goto L_0x0588
        L_0x054f:
            if (r3 == 0) goto L_0x056f
            java.lang.Object r3 = r3.clone()     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.internal.measurement.zzib$zza r3 = (com.google.android.gms.internal.measurement.zzib.zza) r3     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.internal.measurement.zzcc$zze$zza r3 = (com.google.android.gms.internal.measurement.zzcc.zze.zza) r3     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.internal.measurement.zzcc$zze$zza r3 = r3.zza((java.lang.String) r14)     // Catch:{ all -> 0x0f2c }
            r7 = 10
            com.google.android.gms.internal.measurement.zzcc$zze$zza r3 = r3.zza((long) r7)     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.internal.measurement.zzjj r3 = r3.zzv()     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.internal.measurement.zzib r3 = (com.google.android.gms.internal.measurement.zzib) r3     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.internal.measurement.zzcc$zze r3 = (com.google.android.gms.internal.measurement.zzcc.zze) r3     // Catch:{ all -> 0x0f2c }
            r9.zza((int) r2, (com.google.android.gms.internal.measurement.zzcc.zze) r3)     // Catch:{ all -> 0x0f2c }
            goto L_0x0588
        L_0x056f:
            com.google.android.gms.measurement.internal.zzgd r2 = r1.zzj     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.measurement.internal.zzez r2 = r2.zzr()     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.measurement.internal.zzfb r2 = r2.zzf()     // Catch:{ all -> 0x0f2c }
            java.lang.String r3 = "Did not find conversion parameter. appId"
            com.google.android.gms.internal.measurement.zzcc$zzg r5 = r4.zza     // Catch:{ all -> 0x0f2c }
            java.lang.String r5 = r5.zzx()     // Catch:{ all -> 0x0f2c }
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzez.zza((java.lang.String) r5)     // Catch:{ all -> 0x0f2c }
            r2.zza(r3, r5)     // Catch:{ all -> 0x0f2c }
        L_0x0588:
            if (r6 == 0) goto L_0x064b
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x0f2c }
            java.util.List r3 = r9.zza()     // Catch:{ all -> 0x0f2c }
            r2.<init>(r3)     // Catch:{ all -> 0x0f2c }
            r3 = 0
            r5 = -1
            r6 = -1
        L_0x0596:
            int r7 = r2.size()     // Catch:{ all -> 0x0f2c }
            java.lang.String r8 = "currency"
            java.lang.String r14 = "value"
            if (r3 >= r7) goto L_0x05c6
            java.lang.Object r7 = r2.get(r3)     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.internal.measurement.zzcc$zze r7 = (com.google.android.gms.internal.measurement.zzcc.zze) r7     // Catch:{ all -> 0x0f2c }
            java.lang.String r7 = r7.zzb()     // Catch:{ all -> 0x0f2c }
            boolean r7 = r14.equals(r7)     // Catch:{ all -> 0x0f2c }
            if (r7 == 0) goto L_0x05b2
            r5 = r3
            goto L_0x05c3
        L_0x05b2:
            java.lang.Object r7 = r2.get(r3)     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.internal.measurement.zzcc$zze r7 = (com.google.android.gms.internal.measurement.zzcc.zze) r7     // Catch:{ all -> 0x0f2c }
            java.lang.String r7 = r7.zzb()     // Catch:{ all -> 0x0f2c }
            boolean r7 = r8.equals(r7)     // Catch:{ all -> 0x0f2c }
            if (r7 == 0) goto L_0x05c3
            r6 = r3
        L_0x05c3:
            int r3 = r3 + 1
            goto L_0x0596
        L_0x05c6:
            r3 = -1
            if (r5 == r3) goto L_0x064c
            java.lang.Object r3 = r2.get(r5)     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.internal.measurement.zzcc$zze r3 = (com.google.android.gms.internal.measurement.zzcc.zze) r3     // Catch:{ all -> 0x0f2c }
            boolean r3 = r3.zze()     // Catch:{ all -> 0x0f2c }
            if (r3 != 0) goto L_0x05fc
            java.lang.Object r3 = r2.get(r5)     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.internal.measurement.zzcc$zze r3 = (com.google.android.gms.internal.measurement.zzcc.zze) r3     // Catch:{ all -> 0x0f2c }
            boolean r3 = r3.zzi()     // Catch:{ all -> 0x0f2c }
            if (r3 != 0) goto L_0x05fc
            com.google.android.gms.measurement.internal.zzgd r2 = r1.zzj     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.measurement.internal.zzez r2 = r2.zzr()     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.measurement.internal.zzfb r2 = r2.zzk()     // Catch:{ all -> 0x0f2c }
            java.lang.String r3 = "Value must be specified with a numeric type."
            r2.zza(r3)     // Catch:{ all -> 0x0f2c }
            r9.zzb((int) r5)     // Catch:{ all -> 0x0f2c }
            zza((com.google.android.gms.internal.measurement.zzcc.zzc.zza) r9, (java.lang.String) r12)     // Catch:{ all -> 0x0f2c }
            r2 = 18
            zza((com.google.android.gms.internal.measurement.zzcc.zzc.zza) r9, (int) r2, (java.lang.String) r14)     // Catch:{ all -> 0x0f2c }
            goto L_0x064b
        L_0x05fc:
            r3 = -1
            if (r6 != r3) goto L_0x0602
            r2 = 1
            r7 = 3
            goto L_0x062e
        L_0x0602:
            java.lang.Object r2 = r2.get(r6)     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.internal.measurement.zzcc$zze r2 = (com.google.android.gms.internal.measurement.zzcc.zze) r2     // Catch:{ all -> 0x0f2c }
            java.lang.String r2 = r2.zzd()     // Catch:{ all -> 0x0f2c }
            int r6 = r2.length()     // Catch:{ all -> 0x0f2c }
            r7 = 3
            if (r6 == r7) goto L_0x0615
        L_0x0613:
            r2 = 1
            goto L_0x062e
        L_0x0615:
            r6 = 0
        L_0x0616:
            int r14 = r2.length()     // Catch:{ all -> 0x0f2c }
            if (r6 >= r14) goto L_0x062d
            int r14 = r2.codePointAt(r6)     // Catch:{ all -> 0x0f2c }
            boolean r15 = java.lang.Character.isLetter(r14)     // Catch:{ all -> 0x0f2c }
            if (r15 != 0) goto L_0x0627
            goto L_0x0613
        L_0x0627:
            int r14 = java.lang.Character.charCount(r14)     // Catch:{ all -> 0x0f2c }
            int r6 = r6 + r14
            goto L_0x0616
        L_0x062d:
            r2 = 0
        L_0x062e:
            if (r2 == 0) goto L_0x064d
            com.google.android.gms.measurement.internal.zzgd r2 = r1.zzj     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.measurement.internal.zzez r2 = r2.zzr()     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.measurement.internal.zzfb r2 = r2.zzk()     // Catch:{ all -> 0x0f2c }
            java.lang.String r6 = "Value parameter discarded. You must also supply a 3-letter ISO_4217 currency code in the currency parameter."
            r2.zza(r6)     // Catch:{ all -> 0x0f2c }
            r9.zzb((int) r5)     // Catch:{ all -> 0x0f2c }
            zza((com.google.android.gms.internal.measurement.zzcc.zzc.zza) r9, (java.lang.String) r12)     // Catch:{ all -> 0x0f2c }
            r2 = 19
            zza((com.google.android.gms.internal.measurement.zzcc.zzc.zza) r9, (int) r2, (java.lang.String) r8)     // Catch:{ all -> 0x0f2c }
            goto L_0x064d
        L_0x064b:
            r3 = -1
        L_0x064c:
            r7 = 3
        L_0x064d:
            com.google.android.gms.measurement.internal.zzgd r2 = r1.zzj     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.measurement.internal.zzy r2 = r2.zzb()     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.internal.measurement.zzcc$zzg r5 = r4.zza     // Catch:{ all -> 0x0f2c }
            java.lang.String r5 = r5.zzx()     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean> r6 = com.google.android.gms.measurement.internal.zzaq.zzat     // Catch:{ all -> 0x0f2c }
            boolean r2 = r2.zze(r5, r6)     // Catch:{ all -> 0x0f2c }
            if (r2 == 0) goto L_0x07fc
            java.lang.String r2 = r9.zzd()     // Catch:{ all -> 0x0f2c }
            r5 = r13
            boolean r2 = r5.equals(r2)     // Catch:{ all -> 0x0f2c }
            r12 = 1000(0x3e8, double:4.94E-321)
            if (r2 == 0) goto L_0x06c7
            r43.zzh()     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.internal.measurement.zzjj r2 = r9.zzv()     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.internal.measurement.zzib r2 = (com.google.android.gms.internal.measurement.zzib) r2     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.internal.measurement.zzcc$zzc r2 = (com.google.android.gms.internal.measurement.zzcc.zzc) r2     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.internal.measurement.zzcc$zze r2 = com.google.android.gms.measurement.internal.zzks.zza((com.google.android.gms.internal.measurement.zzcc.zzc) r2, (java.lang.String) r11)     // Catch:{ all -> 0x0f2c }
            if (r2 != 0) goto L_0x06bd
            if (r10 == 0) goto L_0x06b1
            long r14 = r10.zzf()     // Catch:{ all -> 0x0f2c }
            long r24 = r9.zzf()     // Catch:{ all -> 0x0f2c }
            long r14 = r14 - r24
            long r14 = java.lang.Math.abs(r14)     // Catch:{ all -> 0x0f2c }
            int r2 = (r14 > r12 ? 1 : (r14 == r12 ? 0 : -1))
            if (r2 > 0) goto L_0x06b1
            java.lang.Object r2 = r10.clone()     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.internal.measurement.zzib$zza r2 = (com.google.android.gms.internal.measurement.zzib.zza) r2     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.internal.measurement.zzcc$zzc$zza r2 = (com.google.android.gms.internal.measurement.zzcc.zzc.zza) r2     // Catch:{ all -> 0x0f2c }
            boolean r6 = r1.zza((com.google.android.gms.internal.measurement.zzcc.zzc.zza) r9, (com.google.android.gms.internal.measurement.zzcc.zzc.zza) r2)     // Catch:{ all -> 0x0f2c }
            if (r6 == 0) goto L_0x06b1
            r6 = r30
            r8 = r31
            r6.zza((int) r8, (com.google.android.gms.internal.measurement.zzcc.zzc.zza) r2)     // Catch:{ all -> 0x0f2c }
            r7 = r27
            r14 = r29
        L_0x06ac:
            r10 = 0
        L_0x06ad:
            r28 = 0
            goto L_0x0806
        L_0x06b1:
            r6 = r30
            r8 = r31
            r28 = r9
            r7 = r21
            r14 = r29
            goto L_0x0806
        L_0x06bd:
            r6 = r30
            r8 = r31
            r11 = r27
            r14 = r29
            goto L_0x0805
        L_0x06c7:
            r6 = r30
            r8 = r31
            java.lang.String r2 = "_vs"
            java.lang.String r11 = r9.zzd()     // Catch:{ all -> 0x0f2c }
            boolean r2 = r2.equals(r11)     // Catch:{ all -> 0x0f2c }
            if (r2 == 0) goto L_0x071f
            r43.zzh()     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.internal.measurement.zzjj r2 = r9.zzv()     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.internal.measurement.zzib r2 = (com.google.android.gms.internal.measurement.zzib) r2     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.internal.measurement.zzcc$zzc r2 = (com.google.android.gms.internal.measurement.zzcc.zzc) r2     // Catch:{ all -> 0x0f2c }
            r14 = r29
            com.google.android.gms.internal.measurement.zzcc$zze r2 = com.google.android.gms.measurement.internal.zzks.zza((com.google.android.gms.internal.measurement.zzcc.zzc) r2, (java.lang.String) r14)     // Catch:{ all -> 0x0f2c }
            if (r2 != 0) goto L_0x071b
            if (r28 == 0) goto L_0x0713
            long r10 = r28.zzf()     // Catch:{ all -> 0x0f2c }
            long r24 = r9.zzf()     // Catch:{ all -> 0x0f2c }
            long r10 = r10 - r24
            long r10 = java.lang.Math.abs(r10)     // Catch:{ all -> 0x0f2c }
            int r2 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r2 > 0) goto L_0x0713
            java.lang.Object r2 = r28.clone()     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.internal.measurement.zzib$zza r2 = (com.google.android.gms.internal.measurement.zzib.zza) r2     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.internal.measurement.zzcc$zzc$zza r2 = (com.google.android.gms.internal.measurement.zzcc.zzc.zza) r2     // Catch:{ all -> 0x0f2c }
            boolean r10 = r1.zza((com.google.android.gms.internal.measurement.zzcc.zzc.zza) r2, (com.google.android.gms.internal.measurement.zzcc.zzc.zza) r9)     // Catch:{ all -> 0x0f2c }
            if (r10 == 0) goto L_0x0713
            r11 = r27
            r6.zza((int) r11, (com.google.android.gms.internal.measurement.zzcc.zzc.zza) r2)     // Catch:{ all -> 0x0f2c }
            r7 = r11
            goto L_0x06ac
        L_0x0713:
            r11 = r27
            r10 = r9
            r7 = r11
            r8 = r21
            goto L_0x0806
        L_0x071b:
            r11 = r27
            goto L_0x0805
        L_0x071f:
            r11 = r27
            r14 = r29
            com.google.android.gms.measurement.internal.zzgd r2 = r1.zzj     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.measurement.internal.zzy r2 = r2.zzb()     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.internal.measurement.zzcc$zzg r12 = r4.zza     // Catch:{ all -> 0x0f2c }
            java.lang.String r12 = r12.zzx()     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean> r13 = com.google.android.gms.measurement.internal.zzaq.zzbr     // Catch:{ all -> 0x0f2c }
            boolean r2 = r2.zze(r12, r13)     // Catch:{ all -> 0x0f2c }
            if (r2 == 0) goto L_0x0805
            java.lang.String r2 = "_ab"
            java.lang.String r12 = r9.zzd()     // Catch:{ all -> 0x0f2c }
            boolean r2 = r2.equals(r12)     // Catch:{ all -> 0x0f2c }
            if (r2 == 0) goto L_0x0805
            r43.zzh()     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.internal.measurement.zzjj r2 = r9.zzv()     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.internal.measurement.zzib r2 = (com.google.android.gms.internal.measurement.zzib) r2     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.internal.measurement.zzcc$zzc r2 = (com.google.android.gms.internal.measurement.zzcc.zzc) r2     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.internal.measurement.zzcc$zze r2 = com.google.android.gms.measurement.internal.zzks.zza((com.google.android.gms.internal.measurement.zzcc.zzc) r2, (java.lang.String) r14)     // Catch:{ all -> 0x0f2c }
            if (r2 != 0) goto L_0x0805
            if (r28 == 0) goto L_0x0805
            long r12 = r28.zzf()     // Catch:{ all -> 0x0f2c }
            long r24 = r9.zzf()     // Catch:{ all -> 0x0f2c }
            long r12 = r12 - r24
            long r12 = java.lang.Math.abs(r12)     // Catch:{ all -> 0x0f2c }
            r24 = 4000(0xfa0, double:1.9763E-320)
            int r2 = (r12 > r24 ? 1 : (r12 == r24 ? 0 : -1))
            if (r2 > 0) goto L_0x0805
            java.lang.Object r2 = r28.clone()     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.internal.measurement.zzib$zza r2 = (com.google.android.gms.internal.measurement.zzib.zza) r2     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.internal.measurement.zzcc$zzc$zza r2 = (com.google.android.gms.internal.measurement.zzcc.zzc.zza) r2     // Catch:{ all -> 0x0f2c }
            r1.zzb((com.google.android.gms.internal.measurement.zzcc.zzc.zza) r2, (com.google.android.gms.internal.measurement.zzcc.zzc.zza) r9)     // Catch:{ all -> 0x0f2c }
            java.lang.String r12 = r2.zzd()     // Catch:{ all -> 0x0f2c }
            boolean r12 = r5.equals(r12)     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.common.internal.Preconditions.checkArgument(r12)     // Catch:{ all -> 0x0f2c }
            r43.zzh()     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.internal.measurement.zzjj r12 = r2.zzv()     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.internal.measurement.zzib r12 = (com.google.android.gms.internal.measurement.zzib) r12     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.internal.measurement.zzcc$zzc r12 = (com.google.android.gms.internal.measurement.zzcc.zzc) r12     // Catch:{ all -> 0x0f2c }
            java.lang.String r13 = "_sn"
            com.google.android.gms.internal.measurement.zzcc$zze r12 = com.google.android.gms.measurement.internal.zzks.zza((com.google.android.gms.internal.measurement.zzcc.zzc) r12, (java.lang.String) r13)     // Catch:{ all -> 0x0f2c }
            r43.zzh()     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.internal.measurement.zzjj r13 = r2.zzv()     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.internal.measurement.zzib r13 = (com.google.android.gms.internal.measurement.zzib) r13     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.internal.measurement.zzcc$zzc r13 = (com.google.android.gms.internal.measurement.zzcc.zzc) r13     // Catch:{ all -> 0x0f2c }
            java.lang.String r15 = "_sc"
            com.google.android.gms.internal.measurement.zzcc$zze r13 = com.google.android.gms.measurement.internal.zzks.zza((com.google.android.gms.internal.measurement.zzcc.zzc) r13, (java.lang.String) r15)     // Catch:{ all -> 0x0f2c }
            r43.zzh()     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.internal.measurement.zzjj r15 = r2.zzv()     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.internal.measurement.zzib r15 = (com.google.android.gms.internal.measurement.zzib) r15     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.internal.measurement.zzcc$zzc r15 = (com.google.android.gms.internal.measurement.zzcc.zzc) r15     // Catch:{ all -> 0x0f2c }
            java.lang.String r3 = "_si"
            com.google.android.gms.internal.measurement.zzcc$zze r3 = com.google.android.gms.measurement.internal.zzks.zza((com.google.android.gms.internal.measurement.zzcc.zzc) r15, (java.lang.String) r3)     // Catch:{ all -> 0x0f2c }
            if (r12 == 0) goto L_0x07ba
            java.lang.String r12 = r12.zzd()     // Catch:{ all -> 0x0f2c }
            goto L_0x07bc
        L_0x07ba:
            r12 = r18
        L_0x07bc:
            boolean r15 = android.text.TextUtils.isEmpty(r12)     // Catch:{ all -> 0x0f2c }
            if (r15 != 0) goto L_0x07cb
            com.google.android.gms.measurement.internal.zzks r15 = r43.zzh()     // Catch:{ all -> 0x0f2c }
            java.lang.String r7 = "_sn"
            r15.zza((com.google.android.gms.internal.measurement.zzcc.zzc.zza) r9, (java.lang.String) r7, (java.lang.Object) r12)     // Catch:{ all -> 0x0f2c }
        L_0x07cb:
            if (r13 == 0) goto L_0x07d2
            java.lang.String r7 = r13.zzd()     // Catch:{ all -> 0x0f2c }
            goto L_0x07d4
        L_0x07d2:
            r7 = r18
        L_0x07d4:
            boolean r12 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0f2c }
            if (r12 != 0) goto L_0x07e3
            com.google.android.gms.measurement.internal.zzks r12 = r43.zzh()     // Catch:{ all -> 0x0f2c }
            java.lang.String r13 = "_sc"
            r12.zza((com.google.android.gms.internal.measurement.zzcc.zzc.zza) r9, (java.lang.String) r13, (java.lang.Object) r7)     // Catch:{ all -> 0x0f2c }
        L_0x07e3:
            if (r3 == 0) goto L_0x07f6
            com.google.android.gms.measurement.internal.zzks r7 = r43.zzh()     // Catch:{ all -> 0x0f2c }
            java.lang.String r12 = "_si"
            long r24 = r3.zzf()     // Catch:{ all -> 0x0f2c }
            java.lang.Long r3 = java.lang.Long.valueOf(r24)     // Catch:{ all -> 0x0f2c }
            r7.zza((com.google.android.gms.internal.measurement.zzcc.zzc.zza) r9, (java.lang.String) r12, (java.lang.Object) r3)     // Catch:{ all -> 0x0f2c }
        L_0x07f6:
            r6.zza((int) r11, (com.google.android.gms.internal.measurement.zzcc.zzc.zza) r2)     // Catch:{ all -> 0x0f2c }
            r7 = r11
            goto L_0x06ad
        L_0x07fc:
            r5 = r13
            r11 = r27
            r14 = r29
            r6 = r30
            r8 = r31
        L_0x0805:
            r7 = r11
        L_0x0806:
            if (r26 != 0) goto L_0x0864
            java.lang.String r2 = r9.zzd()     // Catch:{ all -> 0x0f2c }
            boolean r2 = r5.equals(r2)     // Catch:{ all -> 0x0f2c }
            if (r2 == 0) goto L_0x0864
            int r2 = r9.zzb()     // Catch:{ all -> 0x0f2c }
            if (r2 != 0) goto L_0x0832
            com.google.android.gms.measurement.internal.zzgd r2 = r1.zzj     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.measurement.internal.zzez r2 = r2.zzr()     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.measurement.internal.zzfb r2 = r2.zzi()     // Catch:{ all -> 0x0f2c }
            java.lang.String r3 = "Engagement event does not contain any parameters. appId"
            com.google.android.gms.internal.measurement.zzcc$zzg r5 = r4.zza     // Catch:{ all -> 0x0f2c }
            java.lang.String r5 = r5.zzx()     // Catch:{ all -> 0x0f2c }
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzez.zza((java.lang.String) r5)     // Catch:{ all -> 0x0f2c }
        L_0x082e:
            r2.zza(r3, r5)     // Catch:{ all -> 0x0f2c }
            goto L_0x0864
        L_0x0832:
            com.google.android.gms.measurement.internal.zzks r2 = r43.zzh()     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.internal.measurement.zzjj r3 = r9.zzv()     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.internal.measurement.zzib r3 = (com.google.android.gms.internal.measurement.zzib) r3     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.internal.measurement.zzcc$zzc r3 = (com.google.android.gms.internal.measurement.zzcc.zzc) r3     // Catch:{ all -> 0x0f2c }
            java.lang.Object r2 = r2.zzb(r3, r14)     // Catch:{ all -> 0x0f2c }
            java.lang.Long r2 = (java.lang.Long) r2     // Catch:{ all -> 0x0f2c }
            if (r2 != 0) goto L_0x085d
            com.google.android.gms.measurement.internal.zzgd r2 = r1.zzj     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.measurement.internal.zzez r2 = r2.zzr()     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.measurement.internal.zzfb r2 = r2.zzi()     // Catch:{ all -> 0x0f2c }
            java.lang.String r3 = "Engagement event does not include duration. appId"
            com.google.android.gms.internal.measurement.zzcc$zzg r5 = r4.zza     // Catch:{ all -> 0x0f2c }
            java.lang.String r5 = r5.zzx()     // Catch:{ all -> 0x0f2c }
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzez.zza((java.lang.String) r5)     // Catch:{ all -> 0x0f2c }
            goto L_0x082e
        L_0x085d:
            long r2 = r2.longValue()     // Catch:{ all -> 0x0f2c }
            long r2 = r22 + r2
            goto L_0x0866
        L_0x0864:
            r2 = r22
        L_0x0866:
            java.util.List<com.google.android.gms.internal.measurement.zzcc$zzc> r5 = r4.zzc     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.internal.measurement.zzjj r11 = r9.zzv()     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.internal.measurement.zzib r11 = (com.google.android.gms.internal.measurement.zzib) r11     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.internal.measurement.zzcc$zzc r11 = (com.google.android.gms.internal.measurement.zzcc.zzc) r11     // Catch:{ all -> 0x0f2c }
            r12 = r16
            r5.set(r12, r11)     // Catch:{ all -> 0x0f2c }
            int r14 = r21 + 1
            r6.zza((com.google.android.gms.internal.measurement.zzcc.zzc.zza) r9)     // Catch:{ all -> 0x0f2c }
            r15 = r2
            r11 = r10
            r13 = r19
            r10 = r28
        L_0x0880:
            int r12 = r12 + 1
            r5 = r6
            r3 = r18
            r2 = r20
            r6 = r26
            goto L_0x0272
        L_0x088b:
            r11 = r3
            r26 = r6
            r14 = r13
            r6 = r5
            r5 = r2
            if (r26 == 0) goto L_0x08e8
            r2 = r21
            r15 = r22
            r3 = 0
        L_0x0898:
            if (r3 >= r2) goto L_0x08e6
            com.google.android.gms.internal.measurement.zzcc$zzc r7 = r6.zzb((int) r3)     // Catch:{ all -> 0x0f2c }
            java.lang.String r8 = r7.zzc()     // Catch:{ all -> 0x0f2c }
            boolean r8 = r5.equals(r8)     // Catch:{ all -> 0x0f2c }
            if (r8 == 0) goto L_0x08b9
            r43.zzh()     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.internal.measurement.zzcc$zze r8 = com.google.android.gms.measurement.internal.zzks.zza((com.google.android.gms.internal.measurement.zzcc.zzc) r7, (java.lang.String) r11)     // Catch:{ all -> 0x0f2c }
            if (r8 == 0) goto L_0x08b9
            r6.zzc((int) r3)     // Catch:{ all -> 0x0f2c }
            int r2 = r2 + -1
            int r3 = r3 + -1
            goto L_0x08e3
        L_0x08b9:
            r43.zzh()     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.internal.measurement.zzcc$zze r7 = com.google.android.gms.measurement.internal.zzks.zza((com.google.android.gms.internal.measurement.zzcc.zzc) r7, (java.lang.String) r14)     // Catch:{ all -> 0x0f2c }
            if (r7 == 0) goto L_0x08e3
            boolean r8 = r7.zze()     // Catch:{ all -> 0x0f2c }
            if (r8 == 0) goto L_0x08d1
            long r7 = r7.zzf()     // Catch:{ all -> 0x0f2c }
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x0f2c }
            goto L_0x08d2
        L_0x08d1:
            r7 = 0
        L_0x08d2:
            if (r7 == 0) goto L_0x08e3
            long r8 = r7.longValue()     // Catch:{ all -> 0x0f2c }
            r12 = 0
            int r10 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r10 <= 0) goto L_0x08e3
            long r7 = r7.longValue()     // Catch:{ all -> 0x0f2c }
            long r15 = r15 + r7
        L_0x08e3:
            r7 = 1
            int r3 = r3 + r7
            goto L_0x0898
        L_0x08e6:
            r2 = r15
            goto L_0x08ea
        L_0x08e8:
            r2 = r22
        L_0x08ea:
            r5 = 0
            r1.zza((com.google.android.gms.internal.measurement.zzcc.zzg.zza) r6, (long) r2, (boolean) r5)     // Catch:{ all -> 0x0f2c }
            java.util.List r5 = r6.zza()     // Catch:{ all -> 0x0f2c }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ all -> 0x0f2c }
        L_0x08f6:
            boolean r7 = r5.hasNext()     // Catch:{ all -> 0x0f2c }
            if (r7 == 0) goto L_0x0910
            java.lang.Object r7 = r5.next()     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.internal.measurement.zzcc$zzc r7 = (com.google.android.gms.internal.measurement.zzcc.zzc) r7     // Catch:{ all -> 0x0f2c }
            java.lang.String r8 = "_s"
            java.lang.String r7 = r7.zzc()     // Catch:{ all -> 0x0f2c }
            boolean r7 = r8.equals(r7)     // Catch:{ all -> 0x0f2c }
            if (r7 == 0) goto L_0x08f6
            r5 = 1
            goto L_0x0911
        L_0x0910:
            r5 = 0
        L_0x0911:
            java.lang.String r7 = "_se"
            if (r5 == 0) goto L_0x0920
            com.google.android.gms.measurement.internal.zzad r5 = r43.zze()     // Catch:{ all -> 0x0f2c }
            java.lang.String r8 = r6.zzj()     // Catch:{ all -> 0x0f2c }
            r5.zzb((java.lang.String) r8, (java.lang.String) r7)     // Catch:{ all -> 0x0f2c }
        L_0x0920:
            java.lang.String r5 = "_sid"
            int r5 = com.google.android.gms.measurement.internal.zzks.zza((com.google.android.gms.internal.measurement.zzcc.zzg.zza) r6, (java.lang.String) r5)     // Catch:{ all -> 0x0f2c }
            if (r5 < 0) goto L_0x092a
            r5 = 1
            goto L_0x092b
        L_0x092a:
            r5 = 0
        L_0x092b:
            if (r5 == 0) goto L_0x0932
            r5 = 1
            r1.zza((com.google.android.gms.internal.measurement.zzcc.zzg.zza) r6, (long) r2, (boolean) r5)     // Catch:{ all -> 0x0f2c }
            goto L_0x0954
        L_0x0932:
            int r2 = com.google.android.gms.measurement.internal.zzks.zza((com.google.android.gms.internal.measurement.zzcc.zzg.zza) r6, (java.lang.String) r7)     // Catch:{ all -> 0x0f2c }
            if (r2 < 0) goto L_0x0954
            r6.zze((int) r2)     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.measurement.internal.zzgd r2 = r1.zzj     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.measurement.internal.zzez r2 = r2.zzr()     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.measurement.internal.zzfb r2 = r2.zzf()     // Catch:{ all -> 0x0f2c }
            java.lang.String r3 = "Session engagement user property is in the bundle without session ID. appId"
            com.google.android.gms.internal.measurement.zzcc$zzg r5 = r4.zza     // Catch:{ all -> 0x0f2c }
            java.lang.String r5 = r5.zzx()     // Catch:{ all -> 0x0f2c }
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzez.zza((java.lang.String) r5)     // Catch:{ all -> 0x0f2c }
            r2.zza(r3, r5)     // Catch:{ all -> 0x0f2c }
        L_0x0954:
            com.google.android.gms.measurement.internal.zzks r2 = r43.zzh()     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.measurement.internal.zzez r3 = r2.zzr()     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.measurement.internal.zzfb r3 = r3.zzx()     // Catch:{ all -> 0x0f2c }
            java.lang.String r5 = "Checking account type status for ad personalization signals"
            r3.zza(r5)     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.measurement.internal.zzfx r3 = r2.zzj()     // Catch:{ all -> 0x0f2c }
            java.lang.String r5 = r6.zzj()     // Catch:{ all -> 0x0f2c }
            boolean r3 = r3.zze(r5)     // Catch:{ all -> 0x0f2c }
            if (r3 == 0) goto L_0x09e5
            com.google.android.gms.measurement.internal.zzad r3 = r2.zzi()     // Catch:{ all -> 0x0f2c }
            java.lang.String r5 = r6.zzj()     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.measurement.internal.zzf r3 = r3.zzb(r5)     // Catch:{ all -> 0x0f2c }
            if (r3 == 0) goto L_0x09e5
            boolean r3 = r3.zzaf()     // Catch:{ all -> 0x0f2c }
            if (r3 == 0) goto L_0x09e5
            com.google.android.gms.measurement.internal.zzai r3 = r2.zzl()     // Catch:{ all -> 0x0f2c }
            boolean r3 = r3.zzj()     // Catch:{ all -> 0x0f2c }
            if (r3 == 0) goto L_0x09e5
            com.google.android.gms.measurement.internal.zzez r3 = r2.zzr()     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.measurement.internal.zzfb r3 = r3.zzw()     // Catch:{ all -> 0x0f2c }
            java.lang.String r5 = "Turning off ad personalization due to account type"
            r3.zza(r5)     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.internal.measurement.zzcc$zzk$zza r3 = com.google.android.gms.internal.measurement.zzcc.zzk.zzj()     // Catch:{ all -> 0x0f2c }
            r5 = r20
            com.google.android.gms.internal.measurement.zzcc$zzk$zza r3 = r3.zza((java.lang.String) r5)     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.measurement.internal.zzai r2 = r2.zzl()     // Catch:{ all -> 0x0f2c }
            long r7 = r2.zzh()     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.internal.measurement.zzcc$zzk$zza r2 = r3.zza((long) r7)     // Catch:{ all -> 0x0f2c }
            r7 = 1
            com.google.android.gms.internal.measurement.zzcc$zzk$zza r2 = r2.zzb((long) r7)     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.internal.measurement.zzjj r2 = r2.zzv()     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.internal.measurement.zzib r2 = (com.google.android.gms.internal.measurement.zzib) r2     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.internal.measurement.zzcc$zzk r2 = (com.google.android.gms.internal.measurement.zzcc.zzk) r2     // Catch:{ all -> 0x0f2c }
            r3 = 0
        L_0x09c3:
            int r7 = r6.zze()     // Catch:{ all -> 0x0f2c }
            if (r3 >= r7) goto L_0x09df
            com.google.android.gms.internal.measurement.zzcc$zzk r7 = r6.zzd((int) r3)     // Catch:{ all -> 0x0f2c }
            java.lang.String r7 = r7.zzc()     // Catch:{ all -> 0x0f2c }
            boolean r7 = r5.equals(r7)     // Catch:{ all -> 0x0f2c }
            if (r7 == 0) goto L_0x09dc
            r6.zza((int) r3, (com.google.android.gms.internal.measurement.zzcc.zzk) r2)     // Catch:{ all -> 0x0f2c }
            r3 = 1
            goto L_0x09e0
        L_0x09dc:
            int r3 = r3 + 1
            goto L_0x09c3
        L_0x09df:
            r3 = 0
        L_0x09e0:
            if (r3 != 0) goto L_0x09e5
            r6.zza((com.google.android.gms.internal.measurement.zzcc.zzk) r2)     // Catch:{ all -> 0x0f2c }
        L_0x09e5:
            com.google.android.gms.measurement.internal.zzgd r2 = r1.zzj     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.measurement.internal.zzy r2 = r2.zzb()     // Catch:{ all -> 0x0f2c }
            java.lang.String r3 = r6.zzj()     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean> r5 = com.google.android.gms.measurement.internal.zzaq.zzbm     // Catch:{ all -> 0x0f2c }
            boolean r2 = r2.zze(r3, r5)     // Catch:{ all -> 0x0f2c }
            if (r2 == 0) goto L_0x09fa
            zza((com.google.android.gms.internal.measurement.zzcc.zzg.zza) r6)     // Catch:{ all -> 0x0f2c }
        L_0x09fa:
            com.google.android.gms.internal.measurement.zzcc$zzg$zza r2 = r6.zzm()     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.measurement.internal.zzo r7 = r43.zzf()     // Catch:{ all -> 0x0f2c }
            java.lang.String r8 = r6.zzj()     // Catch:{ all -> 0x0f2c }
            java.util.List r9 = r6.zza()     // Catch:{ all -> 0x0f2c }
            java.util.List r10 = r6.zzd()     // Catch:{ all -> 0x0f2c }
            long r11 = r6.zzf()     // Catch:{ all -> 0x0f2c }
            java.lang.Long r11 = java.lang.Long.valueOf(r11)     // Catch:{ all -> 0x0f2c }
            long r12 = r6.zzg()     // Catch:{ all -> 0x0f2c }
            java.lang.Long r12 = java.lang.Long.valueOf(r12)     // Catch:{ all -> 0x0f2c }
            java.util.List r3 = r7.zza(r8, r9, r10, r11, r12)     // Catch:{ all -> 0x0f2c }
            r2.zzc((java.lang.Iterable<? extends com.google.android.gms.internal.measurement.zzcc.zza>) r3)     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.measurement.internal.zzgd r2 = r1.zzj     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.measurement.internal.zzy r2 = r2.zzb()     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.internal.measurement.zzcc$zzg r3 = r4.zza     // Catch:{ all -> 0x0f2c }
            java.lang.String r3 = r3.zzx()     // Catch:{ all -> 0x0f2c }
            boolean r2 = r2.zzh(r3)     // Catch:{ all -> 0x0f2c }
            if (r2 == 0) goto L_0x0d67
            java.util.HashMap r2 = new java.util.HashMap     // Catch:{ all -> 0x0d62 }
            r2.<init>()     // Catch:{ all -> 0x0d62 }
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ all -> 0x0d62 }
            r3.<init>()     // Catch:{ all -> 0x0d62 }
            com.google.android.gms.measurement.internal.zzgd r5 = r1.zzj     // Catch:{ all -> 0x0d62 }
            com.google.android.gms.measurement.internal.zzkw r5 = r5.zzi()     // Catch:{ all -> 0x0d62 }
            java.security.SecureRandom r5 = r5.zzh()     // Catch:{ all -> 0x0d62 }
            r7 = 0
        L_0x0a4c:
            int r8 = r6.zzb()     // Catch:{ all -> 0x0d62 }
            if (r7 >= r8) goto L_0x0d2c
            com.google.android.gms.internal.measurement.zzcc$zzc r8 = r6.zzb((int) r7)     // Catch:{ all -> 0x0d62 }
            com.google.android.gms.internal.measurement.zzib$zza r8 = r8.zzbl()     // Catch:{ all -> 0x0d62 }
            com.google.android.gms.internal.measurement.zzcc$zzc$zza r8 = (com.google.android.gms.internal.measurement.zzcc.zzc.zza) r8     // Catch:{ all -> 0x0d62 }
            java.lang.String r9 = r8.zzd()     // Catch:{ all -> 0x0d62 }
            java.lang.String r10 = "_ep"
            boolean r9 = r9.equals(r10)     // Catch:{ all -> 0x0d62 }
            java.lang.String r10 = "_sr"
            if (r9 == 0) goto L_0x0ae0
            com.google.android.gms.measurement.internal.zzks r9 = r43.zzh()     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.internal.measurement.zzjj r11 = r8.zzv()     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.internal.measurement.zzib r11 = (com.google.android.gms.internal.measurement.zzib) r11     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.internal.measurement.zzcc$zzc r11 = (com.google.android.gms.internal.measurement.zzcc.zzc) r11     // Catch:{ all -> 0x0f2c }
            java.lang.String r12 = "_en"
            java.lang.Object r9 = r9.zzb(r11, r12)     // Catch:{ all -> 0x0f2c }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ all -> 0x0f2c }
            java.lang.Object r11 = r2.get(r9)     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.measurement.internal.zzak r11 = (com.google.android.gms.measurement.internal.zzak) r11     // Catch:{ all -> 0x0f2c }
            if (r11 != 0) goto L_0x0a97
            com.google.android.gms.measurement.internal.zzad r11 = r43.zze()     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.internal.measurement.zzcc$zzg r12 = r4.zza     // Catch:{ all -> 0x0f2c }
            java.lang.String r12 = r12.zzx()     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.measurement.internal.zzak r11 = r11.zza((java.lang.String) r12, (java.lang.String) r9)     // Catch:{ all -> 0x0f2c }
            r2.put(r9, r11)     // Catch:{ all -> 0x0f2c }
        L_0x0a97:
            java.lang.Long r9 = r11.zzi     // Catch:{ all -> 0x0f2c }
            if (r9 != 0) goto L_0x0ad6
            java.lang.Long r9 = r11.zzj     // Catch:{ all -> 0x0f2c }
            long r12 = r9.longValue()     // Catch:{ all -> 0x0f2c }
            r14 = 1
            int r9 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r9 <= 0) goto L_0x0ab0
            com.google.android.gms.measurement.internal.zzks r9 = r43.zzh()     // Catch:{ all -> 0x0f2c }
            java.lang.Long r12 = r11.zzj     // Catch:{ all -> 0x0f2c }
            r9.zza((com.google.android.gms.internal.measurement.zzcc.zzc.zza) r8, (java.lang.String) r10, (java.lang.Object) r12)     // Catch:{ all -> 0x0f2c }
        L_0x0ab0:
            java.lang.Boolean r9 = r11.zzk     // Catch:{ all -> 0x0f2c }
            if (r9 == 0) goto L_0x0acb
            java.lang.Boolean r9 = r11.zzk     // Catch:{ all -> 0x0f2c }
            boolean r9 = r9.booleanValue()     // Catch:{ all -> 0x0f2c }
            if (r9 == 0) goto L_0x0acb
            com.google.android.gms.measurement.internal.zzks r9 = r43.zzh()     // Catch:{ all -> 0x0f2c }
            java.lang.String r10 = "_efs"
            r11 = 1
            java.lang.Long r13 = java.lang.Long.valueOf(r11)     // Catch:{ all -> 0x0f2c }
            r9.zza((com.google.android.gms.internal.measurement.zzcc.zzc.zza) r8, (java.lang.String) r10, (java.lang.Object) r13)     // Catch:{ all -> 0x0f2c }
        L_0x0acb:
            com.google.android.gms.internal.measurement.zzjj r9 = r8.zzv()     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.internal.measurement.zzib r9 = (com.google.android.gms.internal.measurement.zzib) r9     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.internal.measurement.zzcc$zzc r9 = (com.google.android.gms.internal.measurement.zzcc.zzc) r9     // Catch:{ all -> 0x0f2c }
            r3.add(r9)     // Catch:{ all -> 0x0f2c }
        L_0x0ad6:
            r6.zza((int) r7, (com.google.android.gms.internal.measurement.zzcc.zzc.zza) r8)     // Catch:{ all -> 0x0f2c }
        L_0x0ad9:
            r44 = r4
            r15 = r5
            r1 = r6
            r4 = r7
            goto L_0x0d22
        L_0x0ae0:
            com.google.android.gms.measurement.internal.zzfx r9 = r43.zzc()     // Catch:{ all -> 0x0d62 }
            com.google.android.gms.internal.measurement.zzcc$zzg r11 = r4.zza     // Catch:{ all -> 0x0d62 }
            java.lang.String r11 = r11.zzx()     // Catch:{ all -> 0x0d62 }
            long r11 = r9.zzf(r11)     // Catch:{ all -> 0x0d62 }
            com.google.android.gms.measurement.internal.zzgd r9 = r1.zzj     // Catch:{ all -> 0x0d62 }
            r9.zzi()     // Catch:{ all -> 0x0d62 }
            long r13 = r8.zzf()     // Catch:{ all -> 0x0d62 }
            long r13 = com.google.android.gms.measurement.internal.zzkw.zza((long) r13, (long) r11)     // Catch:{ all -> 0x0d62 }
            com.google.android.gms.internal.measurement.zzjj r9 = r8.zzv()     // Catch:{ all -> 0x0d62 }
            com.google.android.gms.internal.measurement.zzib r9 = (com.google.android.gms.internal.measurement.zzib) r9     // Catch:{ all -> 0x0d62 }
            com.google.android.gms.internal.measurement.zzcc$zzc r9 = (com.google.android.gms.internal.measurement.zzcc.zzc) r9     // Catch:{ all -> 0x0d62 }
            java.lang.String r15 = "_dbg"
            r20 = r11
            r16 = 1
            java.lang.Long r11 = java.lang.Long.valueOf(r16)     // Catch:{ all -> 0x0d62 }
            boolean r12 = android.text.TextUtils.isEmpty(r15)     // Catch:{ all -> 0x0d62 }
            if (r12 != 0) goto L_0x0b69
            if (r11 != 0) goto L_0x0b16
            goto L_0x0b69
        L_0x0b16:
            java.util.List r9 = r9.zza()     // Catch:{ all -> 0x0f2c }
            java.util.Iterator r9 = r9.iterator()     // Catch:{ all -> 0x0f2c }
        L_0x0b1e:
            boolean r12 = r9.hasNext()     // Catch:{ all -> 0x0f2c }
            if (r12 == 0) goto L_0x0b69
            java.lang.Object r12 = r9.next()     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.internal.measurement.zzcc$zze r12 = (com.google.android.gms.internal.measurement.zzcc.zze) r12     // Catch:{ all -> 0x0f2c }
            r44 = r9
            java.lang.String r9 = r12.zzb()     // Catch:{ all -> 0x0f2c }
            boolean r9 = r15.equals(r9)     // Catch:{ all -> 0x0f2c }
            if (r9 == 0) goto L_0x0b66
            long r15 = r12.zzf()     // Catch:{ all -> 0x0f2c }
            java.lang.Long r9 = java.lang.Long.valueOf(r15)     // Catch:{ all -> 0x0f2c }
            boolean r9 = r11.equals(r9)     // Catch:{ all -> 0x0f2c }
            if (r9 != 0) goto L_0x0b64
            boolean r9 = r11 instanceof java.lang.String     // Catch:{ all -> 0x0f2c }
            if (r9 == 0) goto L_0x0b52
            java.lang.String r9 = r12.zzd()     // Catch:{ all -> 0x0f2c }
            boolean r9 = r11.equals(r9)     // Catch:{ all -> 0x0f2c }
            if (r9 != 0) goto L_0x0b64
        L_0x0b52:
            boolean r9 = r11 instanceof java.lang.Double     // Catch:{ all -> 0x0f2c }
            if (r9 == 0) goto L_0x0b69
            double r15 = r12.zzj()     // Catch:{ all -> 0x0f2c }
            java.lang.Double r9 = java.lang.Double.valueOf(r15)     // Catch:{ all -> 0x0f2c }
            boolean r9 = r11.equals(r9)     // Catch:{ all -> 0x0f2c }
            if (r9 == 0) goto L_0x0b69
        L_0x0b64:
            r9 = 1
            goto L_0x0b6a
        L_0x0b66:
            r9 = r44
            goto L_0x0b1e
        L_0x0b69:
            r9 = 0
        L_0x0b6a:
            if (r9 != 0) goto L_0x0b7f
            com.google.android.gms.measurement.internal.zzfx r9 = r43.zzc()     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.internal.measurement.zzcc$zzg r11 = r4.zza     // Catch:{ all -> 0x0f2c }
            java.lang.String r11 = r11.zzx()     // Catch:{ all -> 0x0f2c }
            java.lang.String r12 = r8.zzd()     // Catch:{ all -> 0x0f2c }
            int r9 = r9.zzd(r11, r12)     // Catch:{ all -> 0x0f2c }
            goto L_0x0b80
        L_0x0b7f:
            r9 = 1
        L_0x0b80:
            if (r9 > 0) goto L_0x0ba6
            com.google.android.gms.measurement.internal.zzgd r10 = r1.zzj     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.measurement.internal.zzez r10 = r10.zzr()     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.measurement.internal.zzfb r10 = r10.zzi()     // Catch:{ all -> 0x0f2c }
            java.lang.String r11 = "Sample rate must be positive. event, rate"
            java.lang.String r12 = r8.zzd()     // Catch:{ all -> 0x0f2c }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x0f2c }
            r10.zza(r11, r12, r9)     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.internal.measurement.zzjj r9 = r8.zzv()     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.internal.measurement.zzib r9 = (com.google.android.gms.internal.measurement.zzib) r9     // Catch:{ all -> 0x0f2c }
            com.google.android.gms.internal.measurement.zzcc$zzc r9 = (com.google.android.gms.internal.measurement.zzcc.zzc) r9     // Catch:{ all -> 0x0f2c }
            r3.add(r9)     // Catch:{ all -> 0x0f2c }
            goto L_0x0ad6
        L_0x0ba6:
            java.lang.String r11 = r8.zzd()     // Catch:{ all -> 0x0d62 }
            java.lang.Object r11 = r2.get(r11)     // Catch:{ all -> 0x0d62 }
            com.google.android.gms.measurement.internal.zzak r11 = (com.google.android.gms.measurement.internal.zzak) r11     // Catch:{ all -> 0x0d62 }
            if (r11 != 0) goto L_0x0c04
            com.google.android.gms.measurement.internal.zzad r11 = r43.zze()     // Catch:{ all -> 0x0d62 }
            com.google.android.gms.internal.measurement.zzcc$zzg r12 = r4.zza     // Catch:{ all -> 0x0d62 }
            java.lang.String r12 = r12.zzx()     // Catch:{ all -> 0x0d62 }
            java.lang.String r15 = r8.zzd()     // Catch:{ all -> 0x0d62 }
            com.google.android.gms.measurement.internal.zzak r11 = r11.zza((java.lang.String) r12, (java.lang.String) r15)     // Catch:{ all -> 0x0d62 }
            if (r11 != 0) goto L_0x0c04
            com.google.android.gms.measurement.internal.zzgd r11 = r1.zzj     // Catch:{ all -> 0x0d62 }
            com.google.android.gms.measurement.internal.zzez r11 = r11.zzr()     // Catch:{ all -> 0x0d62 }
            com.google.android.gms.measurement.internal.zzfb r11 = r11.zzi()     // Catch:{ all -> 0x0d62 }
            java.lang.String r12 = "Event being bundled has no eventAggregate. appId, eventName"
            com.google.android.gms.internal.measurement.zzcc$zzg r15 = r4.zza     // Catch:{ all -> 0x0d62 }
            java.lang.String r15 = r15.zzx()     // Catch:{ all -> 0x0d62 }
            java.lang.String r1 = r8.zzd()     // Catch:{ all -> 0x0d62 }
            r11.zza(r12, r15, r1)     // Catch:{ all -> 0x0d62 }
            com.google.android.gms.measurement.internal.zzak r11 = new com.google.android.gms.measurement.internal.zzak     // Catch:{ all -> 0x0d62 }
            com.google.android.gms.internal.measurement.zzcc$zzg r1 = r4.zza     // Catch:{ all -> 0x0d62 }
            java.lang.String r27 = r1.zzx()     // Catch:{ all -> 0x0d62 }
            java.lang.String r28 = r8.zzd()     // Catch:{ all -> 0x0d62 }
            r29 = 1
            r31 = 1
            r33 = 1
            long r35 = r8.zzf()     // Catch:{ all -> 0x0d62 }
            r37 = 0
            r39 = 0
            r40 = 0
            r41 = 0
            r42 = 0
            r26 = r11
            r26.<init>(r27, r28, r29, r31, r33, r35, r37, r39, r40, r41, r42)     // Catch:{ all -> 0x0d62 }
        L_0x0c04:
            com.google.android.gms.measurement.internal.zzks r1 = r43.zzh()     // Catch:{ all -> 0x0d62 }
            com.google.android.gms.internal.measurement.zzjj r12 = r8.zzv()     // Catch:{ all -> 0x0d62 }
            com.google.android.gms.internal.measurement.zzib r12 = (com.google.android.gms.internal.measurement.zzib) r12     // Catch:{ all -> 0x0d62 }
            com.google.android.gms.internal.measurement.zzcc$zzc r12 = (com.google.android.gms.internal.measurement.zzcc.zzc) r12     // Catch:{ all -> 0x0d62 }
            java.lang.String r15 = "_eid"
            java.lang.Object r1 = r1.zzb(r12, r15)     // Catch:{ all -> 0x0d62 }
            java.lang.Long r1 = (java.lang.Long) r1     // Catch:{ all -> 0x0d62 }
            if (r1 == 0) goto L_0x0c1c
            r12 = 1
            goto L_0x0c1d
        L_0x0c1c:
            r12 = 0
        L_0x0c1d:
            java.lang.Boolean r12 = java.lang.Boolean.valueOf(r12)     // Catch:{ all -> 0x0d62 }
            r15 = 1
            if (r9 != r15) goto L_0x0c52
            com.google.android.gms.internal.measurement.zzjj r1 = r8.zzv()     // Catch:{ all -> 0x0d62 }
            com.google.android.gms.internal.measurement.zzib r1 = (com.google.android.gms.internal.measurement.zzib) r1     // Catch:{ all -> 0x0d62 }
            com.google.android.gms.internal.measurement.zzcc$zzc r1 = (com.google.android.gms.internal.measurement.zzcc.zzc) r1     // Catch:{ all -> 0x0d62 }
            r3.add(r1)     // Catch:{ all -> 0x0d62 }
            boolean r1 = r12.booleanValue()     // Catch:{ all -> 0x0d62 }
            if (r1 == 0) goto L_0x0c4d
            java.lang.Long r1 = r11.zzi     // Catch:{ all -> 0x0d62 }
            if (r1 != 0) goto L_0x0c41
            java.lang.Long r1 = r11.zzj     // Catch:{ all -> 0x0d62 }
            if (r1 != 0) goto L_0x0c41
            java.lang.Boolean r1 = r11.zzk     // Catch:{ all -> 0x0d62 }
            if (r1 == 0) goto L_0x0c4d
        L_0x0c41:
            r1 = 0
            com.google.android.gms.measurement.internal.zzak r9 = r11.zza(r1, r1, r1)     // Catch:{ all -> 0x0d62 }
            java.lang.String r1 = r8.zzd()     // Catch:{ all -> 0x0d62 }
            r2.put(r1, r9)     // Catch:{ all -> 0x0d62 }
        L_0x0c4d:
            r6.zza((int) r7, (com.google.android.gms.internal.measurement.zzcc.zzc.zza) r8)     // Catch:{ all -> 0x0d62 }
            goto L_0x0ad9
        L_0x0c52:
            int r15 = r5.nextInt(r9)     // Catch:{ all -> 0x0d62 }
            if (r15 != 0) goto L_0x0c94
            com.google.android.gms.measurement.internal.zzks r1 = r43.zzh()     // Catch:{ all -> 0x0d62 }
            r44 = r4
            r15 = r5
            long r4 = (long) r9     // Catch:{ all -> 0x0d62 }
            java.lang.Long r9 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x0d62 }
            r1.zza((com.google.android.gms.internal.measurement.zzcc.zzc.zza) r8, (java.lang.String) r10, (java.lang.Object) r9)     // Catch:{ all -> 0x0d62 }
            com.google.android.gms.internal.measurement.zzjj r1 = r8.zzv()     // Catch:{ all -> 0x0d62 }
            com.google.android.gms.internal.measurement.zzib r1 = (com.google.android.gms.internal.measurement.zzib) r1     // Catch:{ all -> 0x0d62 }
            com.google.android.gms.internal.measurement.zzcc$zzc r1 = (com.google.android.gms.internal.measurement.zzcc.zzc) r1     // Catch:{ all -> 0x0d62 }
            r3.add(r1)     // Catch:{ all -> 0x0d62 }
            boolean r1 = r12.booleanValue()     // Catch:{ all -> 0x0d62 }
            if (r1 == 0) goto L_0x0c81
            java.lang.Long r1 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x0d62 }
            r4 = 0
            com.google.android.gms.measurement.internal.zzak r11 = r11.zza(r4, r1, r4)     // Catch:{ all -> 0x0d62 }
        L_0x0c81:
            java.lang.String r1 = r8.zzd()     // Catch:{ all -> 0x0d62 }
            long r4 = r8.zzf()     // Catch:{ all -> 0x0d62 }
            com.google.android.gms.measurement.internal.zzak r4 = r11.zza(r4, r13)     // Catch:{ all -> 0x0d62 }
            r2.put(r1, r4)     // Catch:{ all -> 0x0d62 }
            r1 = r6
            r4 = r7
            goto L_0x0d1f
        L_0x0c94:
            r44 = r4
            r15 = r5
            java.lang.Long r4 = r11.zzh     // Catch:{ all -> 0x0d62 }
            if (r4 == 0) goto L_0x0ca6
            java.lang.Long r4 = r11.zzh     // Catch:{ all -> 0x0d62 }
            long r4 = r4.longValue()     // Catch:{ all -> 0x0d62 }
            r30 = r6
            r16 = r7
            goto L_0x0cbb
        L_0x0ca6:
            r4 = r43
            com.google.android.gms.measurement.internal.zzgd r5 = r4.zzj     // Catch:{ all -> 0x0d62 }
            r5.zzi()     // Catch:{ all -> 0x0d62 }
            long r4 = r8.zzg()     // Catch:{ all -> 0x0d62 }
            r30 = r6
            r16 = r7
            r6 = r20
            long r4 = com.google.android.gms.measurement.internal.zzkw.zza((long) r4, (long) r6)     // Catch:{ all -> 0x0d62 }
        L_0x0cbb:
            int r6 = (r4 > r13 ? 1 : (r4 == r13 ? 0 : -1))
            if (r6 == 0) goto L_0x0d09
            com.google.android.gms.measurement.internal.zzks r1 = r43.zzh()     // Catch:{ all -> 0x0d62 }
            java.lang.String r4 = "_efs"
            r5 = 1
            java.lang.Long r7 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0d62 }
            r1.zza((com.google.android.gms.internal.measurement.zzcc.zzc.zza) r8, (java.lang.String) r4, (java.lang.Object) r7)     // Catch:{ all -> 0x0d62 }
            com.google.android.gms.measurement.internal.zzks r1 = r43.zzh()     // Catch:{ all -> 0x0d62 }
            long r5 = (long) r9     // Catch:{ all -> 0x0d62 }
            java.lang.Long r4 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0d62 }
            r1.zza((com.google.android.gms.internal.measurement.zzcc.zzc.zza) r8, (java.lang.String) r10, (java.lang.Object) r4)     // Catch:{ all -> 0x0d62 }
            com.google.android.gms.internal.measurement.zzjj r1 = r8.zzv()     // Catch:{ all -> 0x0d62 }
            com.google.android.gms.internal.measurement.zzib r1 = (com.google.android.gms.internal.measurement.zzib) r1     // Catch:{ all -> 0x0d62 }
            com.google.android.gms.internal.measurement.zzcc$zzc r1 = (com.google.android.gms.internal.measurement.zzcc.zzc) r1     // Catch:{ all -> 0x0d62 }
            r3.add(r1)     // Catch:{ all -> 0x0d62 }
            boolean r1 = r12.booleanValue()     // Catch:{ all -> 0x0d62 }
            if (r1 == 0) goto L_0x0cf9
            java.lang.Long r1 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0d62 }
            r4 = 1
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r4)     // Catch:{ all -> 0x0d62 }
            r4 = 0
            com.google.android.gms.measurement.internal.zzak r11 = r11.zza(r4, r1, r5)     // Catch:{ all -> 0x0d62 }
        L_0x0cf9:
            java.lang.String r1 = r8.zzd()     // Catch:{ all -> 0x0d62 }
            long r4 = r8.zzf()     // Catch:{ all -> 0x0d62 }
            com.google.android.gms.measurement.internal.zzak r4 = r11.zza(r4, r13)     // Catch:{ all -> 0x0d62 }
            r2.put(r1, r4)     // Catch:{ all -> 0x0d62 }
            goto L_0x0d1b
        L_0x0d09:
            boolean r4 = r12.booleanValue()     // Catch:{ all -> 0x0d62 }
            if (r4 == 0) goto L_0x0d1b
            java.lang.String r4 = r8.zzd()     // Catch:{ all -> 0x0d62 }
            r5 = 0
            com.google.android.gms.measurement.internal.zzak r1 = r11.zza(r1, r5, r5)     // Catch:{ all -> 0x0d62 }
            r2.put(r4, r1)     // Catch:{ all -> 0x0d62 }
        L_0x0d1b:
            r4 = r16
            r1 = r30
        L_0x0d1f:
            r1.zza((int) r4, (com.google.android.gms.internal.measurement.zzcc.zzc.zza) r8)     // Catch:{ all -> 0x0d62 }
        L_0x0d22:
            int r7 = r4 + 1
            r4 = r44
            r6 = r1
            r5 = r15
            r1 = r43
            goto L_0x0a4c
        L_0x0d2c:
            r44 = r4
            r1 = r6
            int r4 = r3.size()     // Catch:{ all -> 0x0d62 }
            int r5 = r1.zzb()     // Catch:{ all -> 0x0d62 }
            if (r4 >= r5) goto L_0x0d40
            com.google.android.gms.internal.measurement.zzcc$zzg$zza r4 = r1.zzc()     // Catch:{ all -> 0x0d62 }
            r4.zza((java.lang.Iterable<? extends com.google.android.gms.internal.measurement.zzcc.zzc>) r3)     // Catch:{ all -> 0x0d62 }
        L_0x0d40:
            java.util.Set r2 = r2.entrySet()     // Catch:{ all -> 0x0d62 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x0d62 }
        L_0x0d48:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x0d62 }
            if (r3 == 0) goto L_0x0d6a
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x0d62 }
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3     // Catch:{ all -> 0x0d62 }
            com.google.android.gms.measurement.internal.zzad r4 = r43.zze()     // Catch:{ all -> 0x0d62 }
            java.lang.Object r3 = r3.getValue()     // Catch:{ all -> 0x0d62 }
            com.google.android.gms.measurement.internal.zzak r3 = (com.google.android.gms.measurement.internal.zzak) r3     // Catch:{ all -> 0x0d62 }
            r4.zza((com.google.android.gms.measurement.internal.zzak) r3)     // Catch:{ all -> 0x0d62 }
            goto L_0x0d48
        L_0x0d62:
            r0 = move-exception
            r2 = r43
            goto L_0x0f2e
        L_0x0d67:
            r44 = r4
            r1 = r6
        L_0x0d6a:
            r2 = r43
            com.google.android.gms.measurement.internal.zzgd r3 = r2.zzj     // Catch:{ all -> 0x0f2a }
            com.google.android.gms.measurement.internal.zzy r3 = r3.zzb()     // Catch:{ all -> 0x0f2a }
            java.lang.String r4 = r1.zzj()     // Catch:{ all -> 0x0f2a }
            com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean> r5 = com.google.android.gms.measurement.internal.zzaq.zzbm     // Catch:{ all -> 0x0f2a }
            boolean r3 = r3.zze(r4, r5)     // Catch:{ all -> 0x0f2a }
            if (r3 != 0) goto L_0x0d81
            zza((com.google.android.gms.internal.measurement.zzcc.zzg.zza) r1)     // Catch:{ all -> 0x0f2a }
        L_0x0d81:
            r3 = r44
            com.google.android.gms.internal.measurement.zzcc$zzg r4 = r3.zza     // Catch:{ all -> 0x0f2a }
            java.lang.String r4 = r4.zzx()     // Catch:{ all -> 0x0f2a }
            com.google.android.gms.measurement.internal.zzad r5 = r43.zze()     // Catch:{ all -> 0x0f2a }
            com.google.android.gms.measurement.internal.zzf r5 = r5.zzb(r4)     // Catch:{ all -> 0x0f2a }
            if (r5 != 0) goto L_0x0dad
            com.google.android.gms.measurement.internal.zzgd r5 = r2.zzj     // Catch:{ all -> 0x0f2a }
            com.google.android.gms.measurement.internal.zzez r5 = r5.zzr()     // Catch:{ all -> 0x0f2a }
            com.google.android.gms.measurement.internal.zzfb r5 = r5.zzf()     // Catch:{ all -> 0x0f2a }
            java.lang.String r6 = "Bundling raw events w/o app info. appId"
            com.google.android.gms.internal.measurement.zzcc$zzg r7 = r3.zza     // Catch:{ all -> 0x0f2a }
            java.lang.String r7 = r7.zzx()     // Catch:{ all -> 0x0f2a }
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzez.zza((java.lang.String) r7)     // Catch:{ all -> 0x0f2a }
            r5.zza(r6, r7)     // Catch:{ all -> 0x0f2a }
            goto L_0x0e08
        L_0x0dad:
            int r6 = r1.zzb()     // Catch:{ all -> 0x0f2a }
            if (r6 <= 0) goto L_0x0e08
            long r6 = r5.zzk()     // Catch:{ all -> 0x0f2a }
            r8 = 0
            int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r10 == 0) goto L_0x0dc1
            r1.zze((long) r6)     // Catch:{ all -> 0x0f2a }
            goto L_0x0dc4
        L_0x0dc1:
            r1.zzi()     // Catch:{ all -> 0x0f2a }
        L_0x0dc4:
            long r8 = r5.zzj()     // Catch:{ all -> 0x0f2a }
            r10 = 0
            int r12 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r12 != 0) goto L_0x0dcf
            goto L_0x0dd0
        L_0x0dcf:
            r6 = r8
        L_0x0dd0:
            int r8 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r8 == 0) goto L_0x0dd8
            r1.zzd((long) r6)     // Catch:{ all -> 0x0f2a }
            goto L_0x0ddb
        L_0x0dd8:
            r1.zzh()     // Catch:{ all -> 0x0f2a }
        L_0x0ddb:
            r5.zzv()     // Catch:{ all -> 0x0f2a }
            long r6 = r5.zzs()     // Catch:{ all -> 0x0f2a }
            int r7 = (int) r6     // Catch:{ all -> 0x0f2a }
            r1.zzg((int) r7)     // Catch:{ all -> 0x0f2a }
            long r6 = r1.zzf()     // Catch:{ all -> 0x0f2a }
            r5.zza((long) r6)     // Catch:{ all -> 0x0f2a }
            long r6 = r1.zzg()     // Catch:{ all -> 0x0f2a }
            r5.zzb((long) r6)     // Catch:{ all -> 0x0f2a }
            java.lang.String r6 = r5.zzad()     // Catch:{ all -> 0x0f2a }
            if (r6 == 0) goto L_0x0dfe
            r1.zzj((java.lang.String) r6)     // Catch:{ all -> 0x0f2a }
            goto L_0x0e01
        L_0x0dfe:
            r1.zzk()     // Catch:{ all -> 0x0f2a }
        L_0x0e01:
            com.google.android.gms.measurement.internal.zzad r6 = r43.zze()     // Catch:{ all -> 0x0f2a }
            r6.zza((com.google.android.gms.measurement.internal.zzf) r5)     // Catch:{ all -> 0x0f2a }
        L_0x0e08:
            int r5 = r1.zzb()     // Catch:{ all -> 0x0f2a }
            if (r5 <= 0) goto L_0x0e6e
            com.google.android.gms.measurement.internal.zzgd r5 = r2.zzj     // Catch:{ all -> 0x0f2a }
            r5.zzu()     // Catch:{ all -> 0x0f2a }
            com.google.android.gms.measurement.internal.zzfx r5 = r43.zzc()     // Catch:{ all -> 0x0f2a }
            com.google.android.gms.internal.measurement.zzcc$zzg r6 = r3.zza     // Catch:{ all -> 0x0f2a }
            java.lang.String r6 = r6.zzx()     // Catch:{ all -> 0x0f2a }
            com.google.android.gms.internal.measurement.zzca$zzb r5 = r5.zza((java.lang.String) r6)     // Catch:{ all -> 0x0f2a }
            if (r5 == 0) goto L_0x0e32
            boolean r6 = r5.zza()     // Catch:{ all -> 0x0f2a }
            if (r6 != 0) goto L_0x0e2a
            goto L_0x0e32
        L_0x0e2a:
            long r5 = r5.zzb()     // Catch:{ all -> 0x0f2a }
            r1.zzi((long) r5)     // Catch:{ all -> 0x0f2a }
            goto L_0x0e5d
        L_0x0e32:
            com.google.android.gms.internal.measurement.zzcc$zzg r5 = r3.zza     // Catch:{ all -> 0x0f2a }
            java.lang.String r5 = r5.zzam()     // Catch:{ all -> 0x0f2a }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x0f2a }
            if (r5 == 0) goto L_0x0e44
            r5 = -1
            r1.zzi((long) r5)     // Catch:{ all -> 0x0f2a }
            goto L_0x0e5d
        L_0x0e44:
            com.google.android.gms.measurement.internal.zzgd r5 = r2.zzj     // Catch:{ all -> 0x0f2a }
            com.google.android.gms.measurement.internal.zzez r5 = r5.zzr()     // Catch:{ all -> 0x0f2a }
            com.google.android.gms.measurement.internal.zzfb r5 = r5.zzi()     // Catch:{ all -> 0x0f2a }
            java.lang.String r6 = "Did not find measurement config or missing version info. appId"
            com.google.android.gms.internal.measurement.zzcc$zzg r7 = r3.zza     // Catch:{ all -> 0x0f2a }
            java.lang.String r7 = r7.zzx()     // Catch:{ all -> 0x0f2a }
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzez.zza((java.lang.String) r7)     // Catch:{ all -> 0x0f2a }
            r5.zza(r6, r7)     // Catch:{ all -> 0x0f2a }
        L_0x0e5d:
            com.google.android.gms.measurement.internal.zzad r5 = r43.zze()     // Catch:{ all -> 0x0f2a }
            com.google.android.gms.internal.measurement.zzjj r1 = r1.zzv()     // Catch:{ all -> 0x0f2a }
            com.google.android.gms.internal.measurement.zzib r1 = (com.google.android.gms.internal.measurement.zzib) r1     // Catch:{ all -> 0x0f2a }
            com.google.android.gms.internal.measurement.zzcc$zzg r1 = (com.google.android.gms.internal.measurement.zzcc.zzg) r1     // Catch:{ all -> 0x0f2a }
            r13 = r19
            r5.zza((com.google.android.gms.internal.measurement.zzcc.zzg) r1, (boolean) r13)     // Catch:{ all -> 0x0f2a }
        L_0x0e6e:
            com.google.android.gms.measurement.internal.zzad r1 = r43.zze()     // Catch:{ all -> 0x0f2a }
            java.util.List<java.lang.Long> r3 = r3.zzb     // Catch:{ all -> 0x0f2a }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r3)     // Catch:{ all -> 0x0f2a }
            r1.zzd()     // Catch:{ all -> 0x0f2a }
            r1.zzak()     // Catch:{ all -> 0x0f2a }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0f2a }
            java.lang.String r6 = "rowid in ("
            r5.<init>(r6)     // Catch:{ all -> 0x0f2a }
            r6 = 0
        L_0x0e85:
            int r7 = r3.size()     // Catch:{ all -> 0x0f2a }
            if (r6 >= r7) goto L_0x0ea2
            if (r6 == 0) goto L_0x0e92
            java.lang.String r7 = ","
            r5.append(r7)     // Catch:{ all -> 0x0f2a }
        L_0x0e92:
            java.lang.Object r7 = r3.get(r6)     // Catch:{ all -> 0x0f2a }
            java.lang.Long r7 = (java.lang.Long) r7     // Catch:{ all -> 0x0f2a }
            long r7 = r7.longValue()     // Catch:{ all -> 0x0f2a }
            r5.append(r7)     // Catch:{ all -> 0x0f2a }
            int r6 = r6 + 1
            goto L_0x0e85
        L_0x0ea2:
            java.lang.String r6 = ")"
            r5.append(r6)     // Catch:{ all -> 0x0f2a }
            android.database.sqlite.SQLiteDatabase r6 = r1.mo24209c_()     // Catch:{ all -> 0x0f2a }
            java.lang.String r7 = "raw_events"
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0f2a }
            r8 = 0
            int r5 = r6.delete(r7, r5, r8)     // Catch:{ all -> 0x0f2a }
            int r6 = r3.size()     // Catch:{ all -> 0x0f2a }
            if (r5 == r6) goto L_0x0ed5
            com.google.android.gms.measurement.internal.zzez r1 = r1.zzr()     // Catch:{ all -> 0x0f2a }
            com.google.android.gms.measurement.internal.zzfb r1 = r1.zzf()     // Catch:{ all -> 0x0f2a }
            java.lang.String r6 = "Deleted fewer rows from raw events table than expected"
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0f2a }
            int r3 = r3.size()     // Catch:{ all -> 0x0f2a }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0f2a }
            r1.zza(r6, r5, r3)     // Catch:{ all -> 0x0f2a }
        L_0x0ed5:
            com.google.android.gms.measurement.internal.zzad r1 = r43.zze()     // Catch:{ all -> 0x0f2a }
            android.database.sqlite.SQLiteDatabase r3 = r1.mo24209c_()     // Catch:{ all -> 0x0f2a }
            java.lang.String r5 = "delete from raw_events_metadata where app_id=? and metadata_fingerprint not in (select distinct metadata_fingerprint from raw_events where app_id=?)"
            r6 = 2
            java.lang.String[] r6 = new java.lang.String[r6]     // Catch:{ SQLiteException -> 0x0eec }
            r7 = 0
            r6[r7] = r4     // Catch:{ SQLiteException -> 0x0eec }
            r7 = 1
            r6[r7] = r4     // Catch:{ SQLiteException -> 0x0eec }
            r3.execSQL(r5, r6)     // Catch:{ SQLiteException -> 0x0eec }
            goto L_0x0eff
        L_0x0eec:
            r0 = move-exception
            r3 = r0
            com.google.android.gms.measurement.internal.zzez r1 = r1.zzr()     // Catch:{ all -> 0x0f2a }
            com.google.android.gms.measurement.internal.zzfb r1 = r1.zzf()     // Catch:{ all -> 0x0f2a }
            java.lang.String r5 = "Failed to remove unused event metadata. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzez.zza((java.lang.String) r4)     // Catch:{ all -> 0x0f2a }
            r1.zza(r5, r4, r3)     // Catch:{ all -> 0x0f2a }
        L_0x0eff:
            com.google.android.gms.measurement.internal.zzad r1 = r43.zze()     // Catch:{ all -> 0x0f2a }
            r1.mo24208b_()     // Catch:{ all -> 0x0f2a }
            com.google.android.gms.measurement.internal.zzad r1 = r43.zze()
            r1.zzh()
            r1 = 1
            return r1
        L_0x0f0f:
            r2 = r1
            com.google.android.gms.measurement.internal.zzad r1 = r43.zze()     // Catch:{ all -> 0x0f2a }
            r1.mo24208b_()     // Catch:{ all -> 0x0f2a }
            com.google.android.gms.measurement.internal.zzad r1 = r43.zze()
            r1.zzh()
            r1 = 0
            return r1
        L_0x0f20:
            r0 = move-exception
            r2 = r1
            goto L_0x021d
        L_0x0f24:
            if (r5 == 0) goto L_0x0f29
            r5.close()     // Catch:{ all -> 0x0f2a }
        L_0x0f29:
            throw r1     // Catch:{ all -> 0x0f2a }
        L_0x0f2a:
            r0 = move-exception
            goto L_0x0f2e
        L_0x0f2c:
            r0 = move-exception
            r2 = r1
        L_0x0f2e:
            r1 = r0
            com.google.android.gms.measurement.internal.zzad r3 = r43.zze()
            r3.zzh()
            goto L_0x0f38
        L_0x0f37:
            throw r1
        L_0x0f38:
            goto L_0x0f37
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkk.zza(java.lang.String, long):boolean");
    }

    @WorkerThread
    private final void zzaa() {
        zzw();
        if (this.zzq || this.zzr || this.zzs) {
            this.zzj.zzr().zzx().zza("Not stopping services. fetch, network, upload", Boolean.valueOf(this.zzq), Boolean.valueOf(this.zzr), Boolean.valueOf(this.zzs));
            return;
        }
        this.zzj.zzr().zzx().zza("Stopping uploading service(s)");
        List<Runnable> list = this.zzn;
        if (list != null) {
            for (Runnable run : list) {
                run.run();
            }
            this.zzn.clear();
        }
    }

    @WorkerThread
    @VisibleForTesting
    private final boolean zzab() {
        String str;
        zzfb zzfb;
        FileLock fileLock;
        zzw();
        if (!this.zzj.zzb().zza(zzaq.zzbl) || (fileLock = this.zzt) == null || !fileLock.isValid()) {
            try {
                FileChannel channel = new RandomAccessFile(new File(this.zzj.zzn().getFilesDir(), "google_app_measurement.db"), "rw").getChannel();
                this.zzu = channel;
                FileLock tryLock = channel.tryLock();
                this.zzt = tryLock;
                if (tryLock != null) {
                    this.zzj.zzr().zzx().zza("Storage concurrent access okay");
                    return true;
                }
                this.zzj.zzr().zzf().zza("Storage concurrent data access panic");
                return false;
            } catch (FileNotFoundException e) {
                e = e;
                zzfb = this.zzj.zzr().zzf();
                str = "Failed to acquire storage lock";
                zzfb.zza(str, e);
                return false;
            } catch (IOException e2) {
                e = e2;
                zzfb = this.zzj.zzr().zzf();
                str = "Failed to access storage lock file";
                zzfb.zza(str, e);
                return false;
            } catch (OverlappingFileLockException e3) {
                e = e3;
                zzfb = this.zzj.zzr().zzi();
                str = "Storage lock already acquired";
                zzfb.zza(str, e);
                return false;
            }
        } else {
            this.zzj.zzr().zzx().zza("Storage concurrent access okay");
            return true;
        }
    }

    @WorkerThread
    private final Boolean zzb(zzf zzf2) {
        try {
            if (zzf2.zzm() != -2147483648L) {
                if (zzf2.zzm() == ((long) Wrappers.packageManager(this.zzj.zzn()).getPackageInfo(zzf2.zzc(), 0).versionCode)) {
                    return true;
                }
            } else {
                String str = Wrappers.packageManager(this.zzj.zzn()).getPackageInfo(zzf2.zzc(), 0).versionName;
                if (zzf2.zzl() != null && zzf2.zzl().equals(str)) {
                    return true;
                }
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    private final void zzb(zzcc.zzc.zza zza2, zzcc.zzc.zza zza3) {
        Preconditions.checkArgument("_e".equals(zza2.zzd()));
        zzh();
        zzcc.zze zza4 = zzks.zza((zzcc.zzc) ((zzib) zza2.zzv()), "_et");
        if (zza4.zze() && zza4.zzf() > 0) {
            long zzf2 = zza4.zzf();
            zzh();
            zzcc.zze zza5 = zzks.zza((zzcc.zzc) ((zzib) zza3.zzv()), "_et");
            if (zza5 != null && zza5.zzf() > 0) {
                zzf2 += zza5.zzf();
            }
            zzh().zza(zza3, "_et", (Object) Long.valueOf(zzf2));
            zzh().zza(zza2, "_fr", (Object) 1L);
        }
    }

    @WorkerThread
    private final void zzb(zzao zzao, zzn zzn2) {
        if (zzof.zzb() && this.zzj.zzb().zza(zzaq.zzcn)) {
            zzfd zza2 = zzfd.zza(zzao);
            this.zzj.zzi().zza(zza2.zzb, zze().zzi(zzn2.zza));
            this.zzj.zzi().zza(zza2, this.zzj.zzb().zza(zzn2.zza));
            zzao = zza2.zza();
        }
        zza(zzao, zzn2);
    }

    private static void zzb(zzkl zzkl) {
        if (zzkl == null) {
            throw new IllegalStateException("Upload Component not created");
        } else if (!zzkl.zzaj()) {
            String valueOf = String.valueOf(zzkl.getClass());
            throw new IllegalStateException(C0681a.m312a(valueOf.length() + 27, "Component not initialized: ", valueOf));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:108:0x02e0 A[Catch:{ SQLiteException -> 0x02a8, all -> 0x0941 }] */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x0317 A[Catch:{ SQLiteException -> 0x02a8, all -> 0x0941 }] */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x0326  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x034d A[Catch:{ SQLiteException -> 0x02a8, all -> 0x0941 }] */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x035c A[Catch:{ SQLiteException -> 0x02a8, all -> 0x0941 }] */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x0390 A[Catch:{ SQLiteException -> 0x02a8, all -> 0x0941 }] */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x03bd  */
    /* JADX WARNING: Removed duplicated region for block: B:217:0x067c A[Catch:{ SQLiteException -> 0x02a8, all -> 0x0941 }] */
    /* JADX WARNING: Removed duplicated region for block: B:227:0x06bb A[Catch:{ SQLiteException -> 0x02a8, all -> 0x0941 }] */
    /* JADX WARNING: Removed duplicated region for block: B:232:0x06d6 A[Catch:{ SQLiteException -> 0x02a8, all -> 0x0941 }] */
    /* JADX WARNING: Removed duplicated region for block: B:245:0x0780 A[Catch:{ SQLiteException -> 0x02a8, all -> 0x0941 }] */
    /* JADX WARNING: Removed duplicated region for block: B:248:0x078d A[Catch:{ SQLiteException -> 0x02a8, all -> 0x0941 }] */
    /* JADX WARNING: Removed duplicated region for block: B:253:0x07a7 A[Catch:{ SQLiteException -> 0x02a8, all -> 0x0941 }] */
    /* JADX WARNING: Removed duplicated region for block: B:259:0x0826 A[Catch:{ SQLiteException -> 0x02a8, all -> 0x0941 }] */
    /* JADX WARNING: Removed duplicated region for block: B:262:0x0837 A[Catch:{ SQLiteException -> 0x02a8, all -> 0x0941 }] */
    /* JADX WARNING: Removed duplicated region for block: B:266:0x084f A[Catch:{ SQLiteException -> 0x02a8, all -> 0x0941 }] */
    /* JADX WARNING: Removed duplicated region for block: B:273:0x0898 A[Catch:{ SQLiteException -> 0x02a8, all -> 0x0941 }] */
    /* JADX WARNING: Removed duplicated region for block: B:287:0x08f2 A[Catch:{ SQLiteException -> 0x02a8, all -> 0x0941 }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x017d A[Catch:{ SQLiteException -> 0x02a8, all -> 0x0941 }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0185 A[Catch:{ SQLiteException -> 0x02a8, all -> 0x0941 }] */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzc(com.google.android.gms.measurement.internal.zzao r27, com.google.android.gms.measurement.internal.zzn r28) {
        /*
            r26 = this;
            r1 = r26
            r2 = r27
            r3 = r28
            java.lang.String r4 = "_sno"
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r28)
            java.lang.String r5 = r3.zza
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r5)
            long r5 = java.lang.System.nanoTime()
            r26.zzw()
            r26.zzk()
            java.lang.String r15 = r3.zza
            r26.zzh()
            boolean r7 = com.google.android.gms.measurement.internal.zzks.zza((com.google.android.gms.measurement.internal.zzao) r27, (com.google.android.gms.measurement.internal.zzn) r28)
            if (r7 != 0) goto L_0x0026
            return
        L_0x0026:
            boolean r7 = r3.zzh
            if (r7 != 0) goto L_0x002e
            r1.zzc(r3)
            return
        L_0x002e:
            com.google.android.gms.measurement.internal.zzfx r7 = r26.zzc()
            java.lang.String r8 = r2.zza
            boolean r7 = r7.zzb(r15, r8)
            java.lang.String r14 = "_err"
            r13 = 0
            if (r7 == 0) goto L_0x00d9
            com.google.android.gms.measurement.internal.zzgd r3 = r1.zzj
            com.google.android.gms.measurement.internal.zzez r3 = r3.zzr()
            com.google.android.gms.measurement.internal.zzfb r3 = r3.zzi()
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzez.zza((java.lang.String) r15)
            com.google.android.gms.measurement.internal.zzgd r5 = r1.zzj
            com.google.android.gms.measurement.internal.zzex r5 = r5.zzj()
            java.lang.String r6 = r2.zza
            java.lang.String r5 = r5.zza((java.lang.String) r6)
            java.lang.String r6 = "Dropping blacklisted event. appId"
            r3.zza(r6, r4, r5)
            com.google.android.gms.measurement.internal.zzfx r3 = r26.zzc()
            boolean r3 = r3.zzg(r15)
            if (r3 != 0) goto L_0x0073
            com.google.android.gms.measurement.internal.zzfx r3 = r26.zzc()
            boolean r3 = r3.zzh(r15)
            if (r3 == 0) goto L_0x0071
            goto L_0x0073
        L_0x0071:
            r3 = 0
            goto L_0x0074
        L_0x0073:
            r3 = 1
        L_0x0074:
            if (r3 != 0) goto L_0x008f
            java.lang.String r4 = r2.zza
            boolean r4 = r14.equals(r4)
            if (r4 != 0) goto L_0x008f
            com.google.android.gms.measurement.internal.zzgd r4 = r1.zzj
            com.google.android.gms.measurement.internal.zzkw r7 = r4.zzi()
            r9 = 11
            java.lang.String r11 = r2.zza
            r12 = 0
            java.lang.String r10 = "_ev"
            r8 = r15
            r7.zza((java.lang.String) r8, (int) r9, (java.lang.String) r10, (java.lang.String) r11, (int) r12)
        L_0x008f:
            if (r3 == 0) goto L_0x00d8
            com.google.android.gms.measurement.internal.zzad r2 = r26.zze()
            com.google.android.gms.measurement.internal.zzf r2 = r2.zzb(r15)
            if (r2 == 0) goto L_0x00d8
            long r3 = r2.zzu()
            long r5 = r2.zzt()
            long r3 = java.lang.Math.max(r3, r5)
            com.google.android.gms.measurement.internal.zzgd r5 = r1.zzj
            com.google.android.gms.common.util.Clock r5 = r5.zzm()
            long r5 = r5.currentTimeMillis()
            long r5 = r5 - r3
            long r3 = java.lang.Math.abs(r5)
            com.google.android.gms.measurement.internal.zzeo<java.lang.Long> r5 = com.google.android.gms.measurement.internal.zzaq.zzy
            java.lang.Object r5 = r5.zza(r13)
            java.lang.Long r5 = (java.lang.Long) r5
            long r5 = r5.longValue()
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x00d8
            com.google.android.gms.measurement.internal.zzgd r3 = r1.zzj
            com.google.android.gms.measurement.internal.zzez r3 = r3.zzr()
            com.google.android.gms.measurement.internal.zzfb r3 = r3.zzw()
            java.lang.String r4 = "Fetching config for blacklisted app"
            r3.zza(r4)
            r1.zza((com.google.android.gms.measurement.internal.zzf) r2)
        L_0x00d8:
            return
        L_0x00d9:
            boolean r7 = com.google.android.gms.internal.measurement.zzmd.zzb()
            if (r7 == 0) goto L_0x0108
            com.google.android.gms.measurement.internal.zzgd r7 = r1.zzj
            com.google.android.gms.measurement.internal.zzy r7 = r7.zzb()
            com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean> r8 = com.google.android.gms.measurement.internal.zzaq.zzcj
            boolean r7 = r7.zza((com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean>) r8)
            if (r7 == 0) goto L_0x0108
            com.google.android.gms.measurement.internal.zzfd r2 = com.google.android.gms.measurement.internal.zzfd.zza(r27)
            com.google.android.gms.measurement.internal.zzgd r7 = r1.zzj
            com.google.android.gms.measurement.internal.zzkw r7 = r7.zzi()
            com.google.android.gms.measurement.internal.zzgd r8 = r1.zzj
            com.google.android.gms.measurement.internal.zzy r8 = r8.zzb()
            int r8 = r8.zza((java.lang.String) r15)
            r7.zza((com.google.android.gms.measurement.internal.zzfd) r2, (int) r8)
            com.google.android.gms.measurement.internal.zzao r2 = r2.zza()
        L_0x0108:
            com.google.android.gms.measurement.internal.zzgd r7 = r1.zzj
            com.google.android.gms.measurement.internal.zzez r7 = r7.zzr()
            r8 = 2
            boolean r7 = r7.zza((int) r8)
            if (r7 == 0) goto L_0x012e
            com.google.android.gms.measurement.internal.zzgd r7 = r1.zzj
            com.google.android.gms.measurement.internal.zzez r7 = r7.zzr()
            com.google.android.gms.measurement.internal.zzfb r7 = r7.zzx()
            com.google.android.gms.measurement.internal.zzgd r9 = r1.zzj
            com.google.android.gms.measurement.internal.zzex r9 = r9.zzj()
            java.lang.String r9 = r9.zza((com.google.android.gms.measurement.internal.zzao) r2)
            java.lang.String r10 = "Logging event"
            r7.zza(r10, r9)
        L_0x012e:
            com.google.android.gms.measurement.internal.zzad r7 = r26.zze()
            r7.zzf()
            r1.zzc(r3)     // Catch:{ all -> 0x0941 }
            boolean r7 = com.google.android.gms.internal.measurement.zzmo.zzb()     // Catch:{ all -> 0x0941 }
            if (r7 == 0) goto L_0x014e
            com.google.android.gms.measurement.internal.zzgd r7 = r1.zzj     // Catch:{ all -> 0x0941 }
            com.google.android.gms.measurement.internal.zzy r7 = r7.zzb()     // Catch:{ all -> 0x0941 }
            com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean> r9 = com.google.android.gms.measurement.internal.zzaq.zzci     // Catch:{ all -> 0x0941 }
            boolean r7 = r7.zza((com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean>) r9)     // Catch:{ all -> 0x0941 }
            if (r7 == 0) goto L_0x014e
            r7 = 1
            goto L_0x014f
        L_0x014e:
            r7 = 0
        L_0x014f:
            java.lang.String r9 = "ecommerce_purchase"
            java.lang.String r10 = r2.zza     // Catch:{ all -> 0x0941 }
            boolean r9 = r9.equals(r10)     // Catch:{ all -> 0x0941 }
            java.lang.String r10 = "refund"
            if (r9 != 0) goto L_0x0172
            if (r7 == 0) goto L_0x0170
            java.lang.String r7 = "purchase"
            java.lang.String r9 = r2.zza     // Catch:{ all -> 0x0941 }
            boolean r7 = r7.equals(r9)     // Catch:{ all -> 0x0941 }
            if (r7 != 0) goto L_0x0172
            java.lang.String r7 = r2.zza     // Catch:{ all -> 0x0941 }
            boolean r7 = r10.equals(r7)     // Catch:{ all -> 0x0941 }
            if (r7 == 0) goto L_0x0170
            goto L_0x0172
        L_0x0170:
            r7 = 0
            goto L_0x0173
        L_0x0172:
            r7 = 1
        L_0x0173:
            java.lang.String r9 = "_iap"
            java.lang.String r11 = r2.zza     // Catch:{ all -> 0x0941 }
            boolean r9 = r9.equals(r11)     // Catch:{ all -> 0x0941 }
            if (r9 != 0) goto L_0x0182
            if (r7 == 0) goto L_0x0180
            goto L_0x0182
        L_0x0180:
            r9 = 0
            goto L_0x0183
        L_0x0182:
            r9 = 1
        L_0x0183:
            if (r9 == 0) goto L_0x0326
            com.google.android.gms.measurement.internal.zzan r9 = r2.zzb     // Catch:{ all -> 0x0941 }
            java.lang.String r11 = "currency"
            java.lang.String r9 = r9.zzd(r11)     // Catch:{ all -> 0x0941 }
            java.lang.String r11 = "value"
            if (r7 == 0) goto L_0x0203
            com.google.android.gms.measurement.internal.zzan r7 = r2.zzb     // Catch:{ all -> 0x0941 }
            java.lang.Double r7 = r7.zzc(r11)     // Catch:{ all -> 0x0941 }
            double r17 = r7.doubleValue()     // Catch:{ all -> 0x0941 }
            r19 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            double r17 = r17 * r19
            r21 = 0
            int r7 = (r17 > r21 ? 1 : (r17 == r21 ? 0 : -1))
            if (r7 != 0) goto L_0x01b8
            com.google.android.gms.measurement.internal.zzan r7 = r2.zzb     // Catch:{ all -> 0x0941 }
            java.lang.Long r7 = r7.zzb(r11)     // Catch:{ all -> 0x0941 }
            long r12 = r7.longValue()     // Catch:{ all -> 0x0941 }
            double r11 = (double) r12
            java.lang.Double.isNaN(r11)
            double r17 = r11 * r19
        L_0x01b8:
            r11 = 4890909195324358656(0x43e0000000000000, double:9.223372036854776E18)
            int r7 = (r17 > r11 ? 1 : (r17 == r11 ? 0 : -1))
            if (r7 > 0) goto L_0x01e6
            r11 = -4332462841530417152(0xc3e0000000000000, double:-9.223372036854776E18)
            int r7 = (r17 > r11 ? 1 : (r17 == r11 ? 0 : -1))
            if (r7 < 0) goto L_0x01e6
            long r11 = java.lang.Math.round(r17)     // Catch:{ all -> 0x0941 }
            boolean r7 = com.google.android.gms.internal.measurement.zzmo.zzb()     // Catch:{ all -> 0x0941 }
            if (r7 == 0) goto L_0x020d
            com.google.android.gms.measurement.internal.zzgd r7 = r1.zzj     // Catch:{ all -> 0x0941 }
            com.google.android.gms.measurement.internal.zzy r7 = r7.zzb()     // Catch:{ all -> 0x0941 }
            com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean> r13 = com.google.android.gms.measurement.internal.zzaq.zzci     // Catch:{ all -> 0x0941 }
            boolean r7 = r7.zza((com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean>) r13)     // Catch:{ all -> 0x0941 }
            if (r7 == 0) goto L_0x020d
            java.lang.String r7 = r2.zza     // Catch:{ all -> 0x0941 }
            boolean r7 = r10.equals(r7)     // Catch:{ all -> 0x0941 }
            if (r7 == 0) goto L_0x020d
            long r11 = -r11
            goto L_0x020d
        L_0x01e6:
            com.google.android.gms.measurement.internal.zzgd r7 = r1.zzj     // Catch:{ all -> 0x0941 }
            com.google.android.gms.measurement.internal.zzez r7 = r7.zzr()     // Catch:{ all -> 0x0941 }
            com.google.android.gms.measurement.internal.zzfb r7 = r7.zzi()     // Catch:{ all -> 0x0941 }
            java.lang.String r8 = "Data lost. Currency value is too big. appId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzez.zza((java.lang.String) r15)     // Catch:{ all -> 0x0941 }
            java.lang.Double r10 = java.lang.Double.valueOf(r17)     // Catch:{ all -> 0x0941 }
            r7.zza(r8, r9, r10)     // Catch:{ all -> 0x0941 }
            r23 = r5
            r5 = 0
            r11 = 0
            goto L_0x0315
        L_0x0203:
            com.google.android.gms.measurement.internal.zzan r7 = r2.zzb     // Catch:{ all -> 0x0941 }
            java.lang.Long r7 = r7.zzb(r11)     // Catch:{ all -> 0x0941 }
            long r11 = r7.longValue()     // Catch:{ all -> 0x0941 }
        L_0x020d:
            boolean r7 = android.text.TextUtils.isEmpty(r9)     // Catch:{ all -> 0x0941 }
            if (r7 != 0) goto L_0x0311
            java.util.Locale r7 = java.util.Locale.US     // Catch:{ all -> 0x0941 }
            java.lang.String r7 = r9.toUpperCase(r7)     // Catch:{ all -> 0x0941 }
            java.lang.String r9 = "[A-Z]{3}"
            boolean r9 = r7.matches(r9)     // Catch:{ all -> 0x0941 }
            if (r9 == 0) goto L_0x0311
            java.lang.String r9 = "_ltv_"
            int r10 = r7.length()     // Catch:{ all -> 0x0941 }
            if (r10 == 0) goto L_0x022e
            java.lang.String r7 = r9.concat(r7)     // Catch:{ all -> 0x0941 }
            goto L_0x0233
        L_0x022e:
            java.lang.String r7 = new java.lang.String     // Catch:{ all -> 0x0941 }
            r7.<init>(r9)     // Catch:{ all -> 0x0941 }
        L_0x0233:
            r10 = r7
            com.google.android.gms.measurement.internal.zzad r7 = r26.zze()     // Catch:{ all -> 0x0941 }
            com.google.android.gms.measurement.internal.zzkt r7 = r7.zzc(r15, r10)     // Catch:{ all -> 0x0941 }
            if (r7 == 0) goto L_0x026f
            java.lang.Object r9 = r7.zze     // Catch:{ all -> 0x0941 }
            boolean r9 = r9 instanceof java.lang.Long     // Catch:{ all -> 0x0941 }
            if (r9 != 0) goto L_0x0245
            goto L_0x026f
        L_0x0245:
            java.lang.Object r7 = r7.zze     // Catch:{ all -> 0x0941 }
            java.lang.Long r7 = (java.lang.Long) r7     // Catch:{ all -> 0x0941 }
            long r7 = r7.longValue()     // Catch:{ all -> 0x0941 }
            com.google.android.gms.measurement.internal.zzkt r17 = new com.google.android.gms.measurement.internal.zzkt     // Catch:{ all -> 0x0941 }
            java.lang.String r9 = r2.zzc     // Catch:{ all -> 0x0941 }
            com.google.android.gms.measurement.internal.zzgd r13 = r1.zzj     // Catch:{ all -> 0x0941 }
            com.google.android.gms.common.util.Clock r13 = r13.zzm()     // Catch:{ all -> 0x0941 }
            long r18 = r13.currentTimeMillis()     // Catch:{ all -> 0x0941 }
            long r7 = r7 + r11
            java.lang.Long r13 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x0941 }
            r7 = r17
            r8 = r15
            r23 = r5
            r5 = 0
            r6 = 1
            r11 = r18
            r7.<init>(r8, r9, r10, r11, r13)     // Catch:{ all -> 0x0941 }
        L_0x026c:
            r6 = r17
            goto L_0x02d6
        L_0x026f:
            r23 = r5
            r5 = 0
            r6 = 1
            com.google.android.gms.measurement.internal.zzad r7 = r26.zze()     // Catch:{ all -> 0x0941 }
            com.google.android.gms.measurement.internal.zzgd r9 = r1.zzj     // Catch:{ all -> 0x0941 }
            com.google.android.gms.measurement.internal.zzy r9 = r9.zzb()     // Catch:{ all -> 0x0941 }
            com.google.android.gms.measurement.internal.zzeo<java.lang.Integer> r13 = com.google.android.gms.measurement.internal.zzaq.zzad     // Catch:{ all -> 0x0941 }
            int r9 = r9.zzb(r15, r13)     // Catch:{ all -> 0x0941 }
            int r9 = r9 - r6
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r15)     // Catch:{ all -> 0x0941 }
            r7.zzd()     // Catch:{ all -> 0x0941 }
            r7.zzak()     // Catch:{ all -> 0x0941 }
            android.database.sqlite.SQLiteDatabase r13 = r7.mo24209c_()     // Catch:{ SQLiteException -> 0x02a8 }
            java.lang.String r8 = "delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like '_ltv_%' order by set_timestamp desc limit ?,10);"
            r6 = 3
            java.lang.String[] r6 = new java.lang.String[r6]     // Catch:{ SQLiteException -> 0x02a8 }
            r6[r5] = r15     // Catch:{ SQLiteException -> 0x02a8 }
            r16 = 1
            r6[r16] = r15     // Catch:{ SQLiteException -> 0x02a8 }
            java.lang.String r9 = java.lang.String.valueOf(r9)     // Catch:{ SQLiteException -> 0x02a8 }
            r16 = 2
            r6[r16] = r9     // Catch:{ SQLiteException -> 0x02a8 }
            r13.execSQL(r8, r6)     // Catch:{ SQLiteException -> 0x02a8 }
            goto L_0x02bb
        L_0x02a8:
            r0 = move-exception
            r6 = r0
            com.google.android.gms.measurement.internal.zzez r7 = r7.zzr()     // Catch:{ all -> 0x0941 }
            com.google.android.gms.measurement.internal.zzfb r7 = r7.zzf()     // Catch:{ all -> 0x0941 }
            java.lang.String r8 = "Error pruning currencies. appId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzez.zza((java.lang.String) r15)     // Catch:{ all -> 0x0941 }
            r7.zza(r8, r9, r6)     // Catch:{ all -> 0x0941 }
        L_0x02bb:
            com.google.android.gms.measurement.internal.zzkt r17 = new com.google.android.gms.measurement.internal.zzkt     // Catch:{ all -> 0x0941 }
            java.lang.String r9 = r2.zzc     // Catch:{ all -> 0x0941 }
            com.google.android.gms.measurement.internal.zzgd r6 = r1.zzj     // Catch:{ all -> 0x0941 }
            com.google.android.gms.common.util.Clock r6 = r6.zzm()     // Catch:{ all -> 0x0941 }
            long r18 = r6.currentTimeMillis()     // Catch:{ all -> 0x0941 }
            java.lang.Long r13 = java.lang.Long.valueOf(r11)     // Catch:{ all -> 0x0941 }
            r7 = r17
            r8 = r15
            r11 = r18
            r7.<init>(r8, r9, r10, r11, r13)     // Catch:{ all -> 0x0941 }
            goto L_0x026c
        L_0x02d6:
            com.google.android.gms.measurement.internal.zzad r7 = r26.zze()     // Catch:{ all -> 0x0941 }
            boolean r7 = r7.zza((com.google.android.gms.measurement.internal.zzkt) r6)     // Catch:{ all -> 0x0941 }
            if (r7 != 0) goto L_0x0314
            com.google.android.gms.measurement.internal.zzgd r7 = r1.zzj     // Catch:{ all -> 0x0941 }
            com.google.android.gms.measurement.internal.zzez r7 = r7.zzr()     // Catch:{ all -> 0x0941 }
            com.google.android.gms.measurement.internal.zzfb r7 = r7.zzf()     // Catch:{ all -> 0x0941 }
            java.lang.String r8 = "Too many unique user properties are set. Ignoring user property. appId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzez.zza((java.lang.String) r15)     // Catch:{ all -> 0x0941 }
            com.google.android.gms.measurement.internal.zzgd r10 = r1.zzj     // Catch:{ all -> 0x0941 }
            com.google.android.gms.measurement.internal.zzex r10 = r10.zzj()     // Catch:{ all -> 0x0941 }
            java.lang.String r11 = r6.zzc     // Catch:{ all -> 0x0941 }
            java.lang.String r10 = r10.zzc(r11)     // Catch:{ all -> 0x0941 }
            java.lang.Object r6 = r6.zze     // Catch:{ all -> 0x0941 }
            r7.zza(r8, r9, r10, r6)     // Catch:{ all -> 0x0941 }
            com.google.android.gms.measurement.internal.zzgd r6 = r1.zzj     // Catch:{ all -> 0x0941 }
            com.google.android.gms.measurement.internal.zzkw r7 = r6.zzi()     // Catch:{ all -> 0x0941 }
            r9 = 9
            r10 = 0
            r11 = 0
            r12 = 0
            r8 = r15
            r7.zza((java.lang.String) r8, (int) r9, (java.lang.String) r10, (java.lang.String) r11, (int) r12)     // Catch:{ all -> 0x0941 }
            goto L_0x0314
        L_0x0311:
            r23 = r5
            r5 = 0
        L_0x0314:
            r11 = 1
        L_0x0315:
            if (r11 != 0) goto L_0x0329
            com.google.android.gms.measurement.internal.zzad r2 = r26.zze()     // Catch:{ all -> 0x0941 }
            r2.mo24208b_()     // Catch:{ all -> 0x0941 }
            com.google.android.gms.measurement.internal.zzad r2 = r26.zze()
            r2.zzh()
            return
        L_0x0326:
            r23 = r5
            r5 = 0
        L_0x0329:
            java.lang.String r6 = r2.zza     // Catch:{ all -> 0x0941 }
            boolean r6 = com.google.android.gms.measurement.internal.zzkw.zza((java.lang.String) r6)     // Catch:{ all -> 0x0941 }
            java.lang.String r7 = r2.zza     // Catch:{ all -> 0x0941 }
            boolean r18 = r14.equals(r7)     // Catch:{ all -> 0x0941 }
            boolean r7 = com.google.android.gms.internal.measurement.zzmo.zzb()     // Catch:{ all -> 0x0941 }
            r19 = 1
            if (r7 == 0) goto L_0x035c
            com.google.android.gms.measurement.internal.zzgd r7 = r1.zzj     // Catch:{ all -> 0x0941 }
            com.google.android.gms.measurement.internal.zzy r7 = r7.zzb()     // Catch:{ all -> 0x0941 }
            java.lang.String r8 = r3.zza     // Catch:{ all -> 0x0941 }
            com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean> r9 = com.google.android.gms.measurement.internal.zzaq.zzce     // Catch:{ all -> 0x0941 }
            boolean r7 = r7.zze(r8, r9)     // Catch:{ all -> 0x0941 }
            if (r7 == 0) goto L_0x035c
            com.google.android.gms.measurement.internal.zzgd r7 = r1.zzj     // Catch:{ all -> 0x0941 }
            r7.zzi()     // Catch:{ all -> 0x0941 }
            com.google.android.gms.measurement.internal.zzan r7 = r2.zzb     // Catch:{ all -> 0x0941 }
            long r7 = com.google.android.gms.measurement.internal.zzkw.zza((com.google.android.gms.measurement.internal.zzan) r7)     // Catch:{ all -> 0x0941 }
            long r7 = r7 + r19
            r11 = r7
            goto L_0x035e
        L_0x035c:
            r11 = r19
        L_0x035e:
            com.google.android.gms.measurement.internal.zzad r7 = r26.zze()     // Catch:{ all -> 0x0941 }
            long r8 = r26.zzx()     // Catch:{ all -> 0x0941 }
            r13 = 1
            r16 = 0
            r17 = 0
            r10 = r15
            r14 = r6
            r27 = r15
            r15 = r16
            r16 = r18
            com.google.android.gms.measurement.internal.zzac r7 = r7.zza(r8, r10, r11, r13, r14, r15, r16, r17)     // Catch:{ all -> 0x0941 }
            long r8 = r7.zzb     // Catch:{ all -> 0x0941 }
            com.google.android.gms.measurement.internal.zzeo<java.lang.Integer> r10 = com.google.android.gms.measurement.internal.zzaq.zzj     // Catch:{ all -> 0x0941 }
            r14 = 0
            java.lang.Object r10 = r10.zza(r14)     // Catch:{ all -> 0x0941 }
            java.lang.Integer r10 = (java.lang.Integer) r10     // Catch:{ all -> 0x0941 }
            int r10 = r10.intValue()     // Catch:{ all -> 0x0941 }
            long r10 = (long) r10     // Catch:{ all -> 0x0941 }
            long r8 = r8 - r10
            r10 = 1000(0x3e8, double:4.94E-321)
            r12 = 0
            int r15 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r15 <= 0) goto L_0x03bd
            long r8 = r8 % r10
            int r2 = (r8 > r19 ? 1 : (r8 == r19 ? 0 : -1))
            if (r2 != 0) goto L_0x03ae
            com.google.android.gms.measurement.internal.zzgd r2 = r1.zzj     // Catch:{ all -> 0x0941 }
            com.google.android.gms.measurement.internal.zzez r2 = r2.zzr()     // Catch:{ all -> 0x0941 }
            com.google.android.gms.measurement.internal.zzfb r2 = r2.zzf()     // Catch:{ all -> 0x0941 }
            java.lang.String r3 = "Data loss. Too many events logged. appId, count"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzez.zza((java.lang.String) r27)     // Catch:{ all -> 0x0941 }
            long r5 = r7.zzb     // Catch:{ all -> 0x0941 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0941 }
            r2.zza(r3, r4, r5)     // Catch:{ all -> 0x0941 }
        L_0x03ae:
            com.google.android.gms.measurement.internal.zzad r2 = r26.zze()     // Catch:{ all -> 0x0941 }
            r2.mo24208b_()     // Catch:{ all -> 0x0941 }
            com.google.android.gms.measurement.internal.zzad r2 = r26.zze()
            r2.zzh()
            return
        L_0x03bd:
            if (r6 == 0) goto L_0x0412
            long r8 = r7.zza     // Catch:{ all -> 0x0941 }
            com.google.android.gms.measurement.internal.zzeo<java.lang.Integer> r15 = com.google.android.gms.measurement.internal.zzaq.zzl     // Catch:{ all -> 0x0941 }
            java.lang.Object r15 = r15.zza(r14)     // Catch:{ all -> 0x0941 }
            java.lang.Integer r15 = (java.lang.Integer) r15     // Catch:{ all -> 0x0941 }
            int r15 = r15.intValue()     // Catch:{ all -> 0x0941 }
            long r14 = (long) r15     // Catch:{ all -> 0x0941 }
            long r8 = r8 - r14
            int r14 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r14 <= 0) goto L_0x0412
            long r8 = r8 % r10
            int r3 = (r8 > r19 ? 1 : (r8 == r19 ? 0 : -1))
            if (r3 != 0) goto L_0x03f1
            com.google.android.gms.measurement.internal.zzgd r3 = r1.zzj     // Catch:{ all -> 0x0941 }
            com.google.android.gms.measurement.internal.zzez r3 = r3.zzr()     // Catch:{ all -> 0x0941 }
            com.google.android.gms.measurement.internal.zzfb r3 = r3.zzf()     // Catch:{ all -> 0x0941 }
            java.lang.String r4 = "Data loss. Too many public events logged. appId, count"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzez.zza((java.lang.String) r27)     // Catch:{ all -> 0x0941 }
            long r6 = r7.zza     // Catch:{ all -> 0x0941 }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x0941 }
            r3.zza(r4, r5, r6)     // Catch:{ all -> 0x0941 }
        L_0x03f1:
            com.google.android.gms.measurement.internal.zzgd r3 = r1.zzj     // Catch:{ all -> 0x0941 }
            com.google.android.gms.measurement.internal.zzkw r7 = r3.zzi()     // Catch:{ all -> 0x0941 }
            r9 = 16
            java.lang.String r10 = "_ev"
            java.lang.String r11 = r2.zza     // Catch:{ all -> 0x0941 }
            r12 = 0
            r8 = r27
            r7.zza((java.lang.String) r8, (int) r9, (java.lang.String) r10, (java.lang.String) r11, (int) r12)     // Catch:{ all -> 0x0941 }
            com.google.android.gms.measurement.internal.zzad r2 = r26.zze()     // Catch:{ all -> 0x0941 }
            r2.mo24208b_()     // Catch:{ all -> 0x0941 }
            com.google.android.gms.measurement.internal.zzad r2 = r26.zze()
            r2.zzh()
            return
        L_0x0412:
            if (r18 == 0) goto L_0x0461
            long r8 = r7.zzd     // Catch:{ all -> 0x0941 }
            com.google.android.gms.measurement.internal.zzgd r10 = r1.zzj     // Catch:{ all -> 0x0941 }
            com.google.android.gms.measurement.internal.zzy r10 = r10.zzb()     // Catch:{ all -> 0x0941 }
            java.lang.String r11 = r3.zza     // Catch:{ all -> 0x0941 }
            com.google.android.gms.measurement.internal.zzeo<java.lang.Integer> r14 = com.google.android.gms.measurement.internal.zzaq.zzk     // Catch:{ all -> 0x0941 }
            int r10 = r10.zzb(r11, r14)     // Catch:{ all -> 0x0941 }
            r11 = 1000000(0xf4240, float:1.401298E-39)
            int r10 = java.lang.Math.min(r11, r10)     // Catch:{ all -> 0x0941 }
            int r10 = java.lang.Math.max(r5, r10)     // Catch:{ all -> 0x0941 }
            long r10 = (long) r10     // Catch:{ all -> 0x0941 }
            long r8 = r8 - r10
            int r10 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r10 <= 0) goto L_0x0461
            int r2 = (r8 > r19 ? 1 : (r8 == r19 ? 0 : -1))
            if (r2 != 0) goto L_0x0452
            com.google.android.gms.measurement.internal.zzgd r2 = r1.zzj     // Catch:{ all -> 0x0941 }
            com.google.android.gms.measurement.internal.zzez r2 = r2.zzr()     // Catch:{ all -> 0x0941 }
            com.google.android.gms.measurement.internal.zzfb r2 = r2.zzf()     // Catch:{ all -> 0x0941 }
            java.lang.String r3 = "Too many error events logged. appId, count"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzez.zza((java.lang.String) r27)     // Catch:{ all -> 0x0941 }
            long r5 = r7.zzd     // Catch:{ all -> 0x0941 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0941 }
            r2.zza(r3, r4, r5)     // Catch:{ all -> 0x0941 }
        L_0x0452:
            com.google.android.gms.measurement.internal.zzad r2 = r26.zze()     // Catch:{ all -> 0x0941 }
            r2.mo24208b_()     // Catch:{ all -> 0x0941 }
            com.google.android.gms.measurement.internal.zzad r2 = r26.zze()
            r2.zzh()
            return
        L_0x0461:
            com.google.android.gms.measurement.internal.zzan r7 = r2.zzb     // Catch:{ all -> 0x0941 }
            android.os.Bundle r14 = r7.zzb()     // Catch:{ all -> 0x0941 }
            com.google.android.gms.measurement.internal.zzgd r7 = r1.zzj     // Catch:{ all -> 0x0941 }
            com.google.android.gms.measurement.internal.zzkw r7 = r7.zzi()     // Catch:{ all -> 0x0941 }
            java.lang.String r8 = "_o"
            java.lang.String r9 = r2.zzc     // Catch:{ all -> 0x0941 }
            r7.zza((android.os.Bundle) r14, (java.lang.String) r8, (java.lang.Object) r9)     // Catch:{ all -> 0x0941 }
            com.google.android.gms.measurement.internal.zzgd r7 = r1.zzj     // Catch:{ all -> 0x0941 }
            com.google.android.gms.measurement.internal.zzkw r7 = r7.zzi()     // Catch:{ all -> 0x0941 }
            r15 = r27
            boolean r7 = r7.zzf(r15)     // Catch:{ all -> 0x0941 }
            java.lang.String r11 = "_r"
            if (r7 == 0) goto L_0x04a0
            com.google.android.gms.measurement.internal.zzgd r7 = r1.zzj     // Catch:{ all -> 0x0941 }
            com.google.android.gms.measurement.internal.zzkw r7 = r7.zzi()     // Catch:{ all -> 0x0941 }
            java.lang.String r8 = "_dbg"
            java.lang.Long r9 = java.lang.Long.valueOf(r19)     // Catch:{ all -> 0x0941 }
            r7.zza((android.os.Bundle) r14, (java.lang.String) r8, (java.lang.Object) r9)     // Catch:{ all -> 0x0941 }
            com.google.android.gms.measurement.internal.zzgd r7 = r1.zzj     // Catch:{ all -> 0x0941 }
            com.google.android.gms.measurement.internal.zzkw r7 = r7.zzi()     // Catch:{ all -> 0x0941 }
            java.lang.Long r8 = java.lang.Long.valueOf(r19)     // Catch:{ all -> 0x0941 }
            r7.zza((android.os.Bundle) r14, (java.lang.String) r11, (java.lang.Object) r8)     // Catch:{ all -> 0x0941 }
        L_0x04a0:
            java.lang.String r7 = "_s"
            java.lang.String r8 = r2.zza     // Catch:{ all -> 0x0941 }
            boolean r7 = r7.equals(r8)     // Catch:{ all -> 0x0941 }
            if (r7 == 0) goto L_0x04c7
            com.google.android.gms.measurement.internal.zzad r7 = r26.zze()     // Catch:{ all -> 0x0941 }
            java.lang.String r8 = r3.zza     // Catch:{ all -> 0x0941 }
            com.google.android.gms.measurement.internal.zzkt r7 = r7.zzc(r8, r4)     // Catch:{ all -> 0x0941 }
            if (r7 == 0) goto L_0x04c7
            java.lang.Object r8 = r7.zze     // Catch:{ all -> 0x0941 }
            boolean r8 = r8 instanceof java.lang.Long     // Catch:{ all -> 0x0941 }
            if (r8 == 0) goto L_0x04c7
            com.google.android.gms.measurement.internal.zzgd r8 = r1.zzj     // Catch:{ all -> 0x0941 }
            com.google.android.gms.measurement.internal.zzkw r8 = r8.zzi()     // Catch:{ all -> 0x0941 }
            java.lang.Object r7 = r7.zze     // Catch:{ all -> 0x0941 }
            r8.zza((android.os.Bundle) r14, (java.lang.String) r4, (java.lang.Object) r7)     // Catch:{ all -> 0x0941 }
        L_0x04c7:
            com.google.android.gms.measurement.internal.zzad r4 = r26.zze()     // Catch:{ all -> 0x0941 }
            long r7 = r4.zzc(r15)     // Catch:{ all -> 0x0941 }
            int r4 = (r7 > r12 ? 1 : (r7 == r12 ? 0 : -1))
            if (r4 <= 0) goto L_0x04ea
            com.google.android.gms.measurement.internal.zzgd r4 = r1.zzj     // Catch:{ all -> 0x0941 }
            com.google.android.gms.measurement.internal.zzez r4 = r4.zzr()     // Catch:{ all -> 0x0941 }
            com.google.android.gms.measurement.internal.zzfb r4 = r4.zzi()     // Catch:{ all -> 0x0941 }
            java.lang.String r9 = "Data lost. Too many events stored on disk, deleted. appId"
            java.lang.Object r10 = com.google.android.gms.measurement.internal.zzez.zza((java.lang.String) r15)     // Catch:{ all -> 0x0941 }
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x0941 }
            r4.zza(r9, r10, r7)     // Catch:{ all -> 0x0941 }
        L_0x04ea:
            com.google.android.gms.measurement.internal.zzal r4 = new com.google.android.gms.measurement.internal.zzal     // Catch:{ all -> 0x0941 }
            com.google.android.gms.measurement.internal.zzgd r8 = r1.zzj     // Catch:{ all -> 0x0941 }
            java.lang.String r9 = r2.zzc     // Catch:{ all -> 0x0941 }
            java.lang.String r10 = r2.zza     // Catch:{ all -> 0x0941 }
            long r12 = r2.zzd     // Catch:{ all -> 0x0941 }
            r18 = 0
            r7 = r4
            r2 = r10
            r10 = r15
            r5 = r11
            r11 = r2
            r16 = r14
            r2 = r15
            r25 = 0
            r14 = r18
            r7.<init>((com.google.android.gms.measurement.internal.zzgd) r8, (java.lang.String) r9, (java.lang.String) r10, (java.lang.String) r11, (long) r12, (long) r14, (android.os.Bundle) r16)     // Catch:{ all -> 0x0941 }
            com.google.android.gms.measurement.internal.zzad r7 = r26.zze()     // Catch:{ all -> 0x0941 }
            java.lang.String r8 = r4.zzb     // Catch:{ all -> 0x0941 }
            com.google.android.gms.measurement.internal.zzak r7 = r7.zza((java.lang.String) r2, (java.lang.String) r8)     // Catch:{ all -> 0x0941 }
            if (r7 != 0) goto L_0x0588
            com.google.android.gms.measurement.internal.zzad r7 = r26.zze()     // Catch:{ all -> 0x0941 }
            long r7 = r7.zzh(r2)     // Catch:{ all -> 0x0941 }
            com.google.android.gms.measurement.internal.zzgd r9 = r1.zzj     // Catch:{ all -> 0x0941 }
            com.google.android.gms.measurement.internal.zzy r9 = r9.zzb()     // Catch:{ all -> 0x0941 }
            int r9 = r9.zzb(r2)     // Catch:{ all -> 0x0941 }
            long r9 = (long) r9     // Catch:{ all -> 0x0941 }
            int r11 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r11 < 0) goto L_0x056e
            if (r6 == 0) goto L_0x056e
            com.google.android.gms.measurement.internal.zzgd r3 = r1.zzj     // Catch:{ all -> 0x0941 }
            com.google.android.gms.measurement.internal.zzez r3 = r3.zzr()     // Catch:{ all -> 0x0941 }
            com.google.android.gms.measurement.internal.zzfb r3 = r3.zzf()     // Catch:{ all -> 0x0941 }
            java.lang.String r5 = "Too many event names used, ignoring event. appId, name, supported count"
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzez.zza((java.lang.String) r2)     // Catch:{ all -> 0x0941 }
            com.google.android.gms.measurement.internal.zzgd r7 = r1.zzj     // Catch:{ all -> 0x0941 }
            com.google.android.gms.measurement.internal.zzex r7 = r7.zzj()     // Catch:{ all -> 0x0941 }
            java.lang.String r4 = r4.zzb     // Catch:{ all -> 0x0941 }
            java.lang.String r4 = r7.zza((java.lang.String) r4)     // Catch:{ all -> 0x0941 }
            com.google.android.gms.measurement.internal.zzgd r7 = r1.zzj     // Catch:{ all -> 0x0941 }
            com.google.android.gms.measurement.internal.zzy r7 = r7.zzb()     // Catch:{ all -> 0x0941 }
            int r7 = r7.zzb(r2)     // Catch:{ all -> 0x0941 }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ all -> 0x0941 }
            r3.zza(r5, r6, r4, r7)     // Catch:{ all -> 0x0941 }
            com.google.android.gms.measurement.internal.zzgd r3 = r1.zzj     // Catch:{ all -> 0x0941 }
            com.google.android.gms.measurement.internal.zzkw r7 = r3.zzi()     // Catch:{ all -> 0x0941 }
            r9 = 8
            r10 = 0
            r11 = 0
            r12 = 0
            r8 = r2
            r7.zza((java.lang.String) r8, (int) r9, (java.lang.String) r10, (java.lang.String) r11, (int) r12)     // Catch:{ all -> 0x0941 }
            com.google.android.gms.measurement.internal.zzad r2 = r26.zze()
            r2.zzh()
            return
        L_0x056e:
            com.google.android.gms.measurement.internal.zzak r6 = new com.google.android.gms.measurement.internal.zzak     // Catch:{ all -> 0x0941 }
            java.lang.String r9 = r4.zzb     // Catch:{ all -> 0x0941 }
            r10 = 0
            r12 = 0
            long r14 = r4.zzc     // Catch:{ all -> 0x0941 }
            r16 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r7 = r6
            r8 = r2
            r7.<init>(r8, r9, r10, r12, r14, r16, r18, r19, r20, r21)     // Catch:{ all -> 0x0941 }
            goto L_0x0596
        L_0x0588:
            com.google.android.gms.measurement.internal.zzgd r2 = r1.zzj     // Catch:{ all -> 0x0941 }
            long r8 = r7.zzf     // Catch:{ all -> 0x0941 }
            com.google.android.gms.measurement.internal.zzal r4 = r4.zza(r2, r8)     // Catch:{ all -> 0x0941 }
            long r8 = r4.zzc     // Catch:{ all -> 0x0941 }
            com.google.android.gms.measurement.internal.zzak r6 = r7.zza(r8)     // Catch:{ all -> 0x0941 }
        L_0x0596:
            com.google.android.gms.measurement.internal.zzad r2 = r26.zze()     // Catch:{ all -> 0x0941 }
            r2.zza((com.google.android.gms.measurement.internal.zzak) r6)     // Catch:{ all -> 0x0941 }
            r26.zzw()     // Catch:{ all -> 0x0941 }
            r26.zzk()     // Catch:{ all -> 0x0941 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r4)     // Catch:{ all -> 0x0941 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r28)     // Catch:{ all -> 0x0941 }
            java.lang.String r2 = r4.zza     // Catch:{ all -> 0x0941 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r2)     // Catch:{ all -> 0x0941 }
            java.lang.String r2 = r4.zza     // Catch:{ all -> 0x0941 }
            java.lang.String r6 = r3.zza     // Catch:{ all -> 0x0941 }
            boolean r2 = r2.equals(r6)     // Catch:{ all -> 0x0941 }
            com.google.android.gms.common.internal.Preconditions.checkArgument(r2)     // Catch:{ all -> 0x0941 }
            com.google.android.gms.internal.measurement.zzcc$zzg$zza r2 = com.google.android.gms.internal.measurement.zzcc.zzg.zzbf()     // Catch:{ all -> 0x0941 }
            r6 = 1
            com.google.android.gms.internal.measurement.zzcc$zzg$zza r2 = r2.zza((int) r6)     // Catch:{ all -> 0x0941 }
            java.lang.String r7 = "android"
            com.google.android.gms.internal.measurement.zzcc$zzg$zza r2 = r2.zza((java.lang.String) r7)     // Catch:{ all -> 0x0941 }
            java.lang.String r7 = r3.zza     // Catch:{ all -> 0x0941 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0941 }
            if (r7 != 0) goto L_0x05d5
            java.lang.String r7 = r3.zza     // Catch:{ all -> 0x0941 }
            r2.zzf((java.lang.String) r7)     // Catch:{ all -> 0x0941 }
        L_0x05d5:
            java.lang.String r7 = r3.zzd     // Catch:{ all -> 0x0941 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0941 }
            if (r7 != 0) goto L_0x05e2
            java.lang.String r7 = r3.zzd     // Catch:{ all -> 0x0941 }
            r2.zze((java.lang.String) r7)     // Catch:{ all -> 0x0941 }
        L_0x05e2:
            java.lang.String r7 = r3.zzc     // Catch:{ all -> 0x0941 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0941 }
            if (r7 != 0) goto L_0x05ef
            java.lang.String r7 = r3.zzc     // Catch:{ all -> 0x0941 }
            r2.zzg((java.lang.String) r7)     // Catch:{ all -> 0x0941 }
        L_0x05ef:
            long r7 = r3.zzj     // Catch:{ all -> 0x0941 }
            r9 = -2147483648(0xffffffff80000000, double:NaN)
            int r11 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r11 == 0) goto L_0x05fe
            long r7 = r3.zzj     // Catch:{ all -> 0x0941 }
            int r8 = (int) r7     // Catch:{ all -> 0x0941 }
            r2.zzh((int) r8)     // Catch:{ all -> 0x0941 }
        L_0x05fe:
            long r7 = r3.zze     // Catch:{ all -> 0x0941 }
            r2.zzf((long) r7)     // Catch:{ all -> 0x0941 }
            java.lang.String r7 = r3.zzb     // Catch:{ all -> 0x0941 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0941 }
            if (r7 != 0) goto L_0x0610
            java.lang.String r7 = r3.zzb     // Catch:{ all -> 0x0941 }
            r2.zzk((java.lang.String) r7)     // Catch:{ all -> 0x0941 }
        L_0x0610:
            boolean r7 = com.google.android.gms.internal.measurement.zzoe.zzb()     // Catch:{ all -> 0x0941 }
            if (r7 == 0) goto L_0x065f
            com.google.android.gms.measurement.internal.zzgd r7 = r1.zzj     // Catch:{ all -> 0x0941 }
            com.google.android.gms.measurement.internal.zzy r7 = r7.zzb()     // Catch:{ all -> 0x0941 }
            java.lang.String r8 = r3.zza     // Catch:{ all -> 0x0941 }
            com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean> r9 = com.google.android.gms.measurement.internal.zzaq.zzbn     // Catch:{ all -> 0x0941 }
            boolean r7 = r7.zze(r8, r9)     // Catch:{ all -> 0x0941 }
            if (r7 == 0) goto L_0x065f
            java.lang.String r7 = r2.zzl()     // Catch:{ all -> 0x0941 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0941 }
            if (r7 == 0) goto L_0x063d
            java.lang.String r7 = r3.zzv     // Catch:{ all -> 0x0941 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0941 }
            if (r7 != 0) goto L_0x063d
            java.lang.String r7 = r3.zzv     // Catch:{ all -> 0x0941 }
            r2.zzp(r7)     // Catch:{ all -> 0x0941 }
        L_0x063d:
            java.lang.String r7 = r2.zzl()     // Catch:{ all -> 0x0941 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0941 }
            if (r7 == 0) goto L_0x0674
            java.lang.String r7 = r2.zzo()     // Catch:{ all -> 0x0941 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0941 }
            if (r7 == 0) goto L_0x0674
            java.lang.String r7 = r3.zzr     // Catch:{ all -> 0x0941 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0941 }
            if (r7 != 0) goto L_0x0674
            java.lang.String r7 = r3.zzr     // Catch:{ all -> 0x0941 }
        L_0x065b:
            r2.zzo(r7)     // Catch:{ all -> 0x0941 }
            goto L_0x0674
        L_0x065f:
            java.lang.String r7 = r2.zzl()     // Catch:{ all -> 0x0941 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0941 }
            if (r7 == 0) goto L_0x0674
            java.lang.String r7 = r3.zzr     // Catch:{ all -> 0x0941 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0941 }
            if (r7 != 0) goto L_0x0674
            java.lang.String r7 = r3.zzr     // Catch:{ all -> 0x0941 }
            goto L_0x065b
        L_0x0674:
            long r7 = r3.zzf     // Catch:{ all -> 0x0941 }
            r9 = 0
            int r11 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r11 == 0) goto L_0x0681
            long r7 = r3.zzf     // Catch:{ all -> 0x0941 }
            r2.zzh((long) r7)     // Catch:{ all -> 0x0941 }
        L_0x0681:
            long r7 = r3.zzt     // Catch:{ all -> 0x0941 }
            r2.zzk((long) r7)     // Catch:{ all -> 0x0941 }
            com.google.android.gms.measurement.internal.zzgd r7 = r1.zzj     // Catch:{ all -> 0x0941 }
            com.google.android.gms.measurement.internal.zzy r7 = r7.zzb()     // Catch:{ all -> 0x0941 }
            java.lang.String r8 = r3.zza     // Catch:{ all -> 0x0941 }
            com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean> r11 = com.google.android.gms.measurement.internal.zzaq.zzaw     // Catch:{ all -> 0x0941 }
            boolean r7 = r7.zze(r8, r11)     // Catch:{ all -> 0x0941 }
            if (r7 == 0) goto L_0x06a3
            com.google.android.gms.measurement.internal.zzks r7 = r26.zzh()     // Catch:{ all -> 0x0941 }
            java.util.List r7 = r7.zzf()     // Catch:{ all -> 0x0941 }
            if (r7 == 0) goto L_0x06a3
            r2.zzd((java.lang.Iterable<? extends java.lang.Integer>) r7)     // Catch:{ all -> 0x0941 }
        L_0x06a3:
            com.google.android.gms.measurement.internal.zzgd r7 = r1.zzj     // Catch:{ all -> 0x0941 }
            com.google.android.gms.measurement.internal.zzfl r7 = r7.zzc()     // Catch:{ all -> 0x0941 }
            java.lang.String r8 = r3.zza     // Catch:{ all -> 0x0941 }
            android.util.Pair r7 = r7.zza((java.lang.String) r8)     // Catch:{ all -> 0x0941 }
            if (r7 == 0) goto L_0x06d6
            java.lang.Object r8 = r7.first     // Catch:{ all -> 0x0941 }
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8     // Catch:{ all -> 0x0941 }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0941 }
            if (r8 != 0) goto L_0x06d6
            boolean r8 = r3.zzo     // Catch:{ all -> 0x0941 }
            if (r8 == 0) goto L_0x0738
            java.lang.Object r8 = r7.first     // Catch:{ all -> 0x0941 }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x0941 }
            r2.zzh((java.lang.String) r8)     // Catch:{ all -> 0x0941 }
            java.lang.Object r8 = r7.second     // Catch:{ all -> 0x0941 }
            if (r8 == 0) goto L_0x0738
            java.lang.Object r7 = r7.second     // Catch:{ all -> 0x0941 }
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch:{ all -> 0x0941 }
            boolean r7 = r7.booleanValue()     // Catch:{ all -> 0x0941 }
            r2.zza((boolean) r7)     // Catch:{ all -> 0x0941 }
            goto L_0x0738
        L_0x06d6:
            com.google.android.gms.measurement.internal.zzgd r7 = r1.zzj     // Catch:{ all -> 0x0941 }
            com.google.android.gms.measurement.internal.zzai r7 = r7.zzx()     // Catch:{ all -> 0x0941 }
            com.google.android.gms.measurement.internal.zzgd r8 = r1.zzj     // Catch:{ all -> 0x0941 }
            android.content.Context r8 = r8.zzn()     // Catch:{ all -> 0x0941 }
            boolean r7 = r7.zza(r8)     // Catch:{ all -> 0x0941 }
            if (r7 != 0) goto L_0x0738
            boolean r7 = r3.zzp     // Catch:{ all -> 0x0941 }
            if (r7 == 0) goto L_0x0738
            com.google.android.gms.measurement.internal.zzgd r7 = r1.zzj     // Catch:{ all -> 0x0941 }
            android.content.Context r7 = r7.zzn()     // Catch:{ all -> 0x0941 }
            android.content.ContentResolver r7 = r7.getContentResolver()     // Catch:{ all -> 0x0941 }
            java.lang.String r8 = "android_id"
            java.lang.String r7 = android.provider.Settings.Secure.getString(r7, r8)     // Catch:{ all -> 0x0941 }
            if (r7 != 0) goto L_0x0718
            com.google.android.gms.measurement.internal.zzgd r7 = r1.zzj     // Catch:{ all -> 0x0941 }
            com.google.android.gms.measurement.internal.zzez r7 = r7.zzr()     // Catch:{ all -> 0x0941 }
            com.google.android.gms.measurement.internal.zzfb r7 = r7.zzi()     // Catch:{ all -> 0x0941 }
            java.lang.String r8 = "null secure ID. appId"
            java.lang.String r11 = r2.zzj()     // Catch:{ all -> 0x0941 }
            java.lang.Object r11 = com.google.android.gms.measurement.internal.zzez.zza((java.lang.String) r11)     // Catch:{ all -> 0x0941 }
            r7.zza(r8, r11)     // Catch:{ all -> 0x0941 }
            java.lang.String r7 = "null"
            goto L_0x0735
        L_0x0718:
            boolean r8 = r7.isEmpty()     // Catch:{ all -> 0x0941 }
            if (r8 == 0) goto L_0x0735
            com.google.android.gms.measurement.internal.zzgd r8 = r1.zzj     // Catch:{ all -> 0x0941 }
            com.google.android.gms.measurement.internal.zzez r8 = r8.zzr()     // Catch:{ all -> 0x0941 }
            com.google.android.gms.measurement.internal.zzfb r8 = r8.zzi()     // Catch:{ all -> 0x0941 }
            java.lang.String r11 = "empty secure ID. appId"
            java.lang.String r12 = r2.zzj()     // Catch:{ all -> 0x0941 }
            java.lang.Object r12 = com.google.android.gms.measurement.internal.zzez.zza((java.lang.String) r12)     // Catch:{ all -> 0x0941 }
            r8.zza(r11, r12)     // Catch:{ all -> 0x0941 }
        L_0x0735:
            r2.zzm(r7)     // Catch:{ all -> 0x0941 }
        L_0x0738:
            com.google.android.gms.measurement.internal.zzgd r7 = r1.zzj     // Catch:{ all -> 0x0941 }
            com.google.android.gms.measurement.internal.zzai r7 = r7.zzx()     // Catch:{ all -> 0x0941 }
            r7.zzaa()     // Catch:{ all -> 0x0941 }
            java.lang.String r7 = android.os.Build.MODEL     // Catch:{ all -> 0x0941 }
            com.google.android.gms.internal.measurement.zzcc$zzg$zza r7 = r2.zzc((java.lang.String) r7)     // Catch:{ all -> 0x0941 }
            com.google.android.gms.measurement.internal.zzgd r8 = r1.zzj     // Catch:{ all -> 0x0941 }
            com.google.android.gms.measurement.internal.zzai r8 = r8.zzx()     // Catch:{ all -> 0x0941 }
            r8.zzaa()     // Catch:{ all -> 0x0941 }
            java.lang.String r8 = android.os.Build.VERSION.RELEASE     // Catch:{ all -> 0x0941 }
            com.google.android.gms.internal.measurement.zzcc$zzg$zza r7 = r7.zzb((java.lang.String) r8)     // Catch:{ all -> 0x0941 }
            com.google.android.gms.measurement.internal.zzgd r8 = r1.zzj     // Catch:{ all -> 0x0941 }
            com.google.android.gms.measurement.internal.zzai r8 = r8.zzx()     // Catch:{ all -> 0x0941 }
            long r11 = r8.zzf()     // Catch:{ all -> 0x0941 }
            int r8 = (int) r11     // Catch:{ all -> 0x0941 }
            com.google.android.gms.internal.measurement.zzcc$zzg$zza r7 = r7.zzf((int) r8)     // Catch:{ all -> 0x0941 }
            com.google.android.gms.measurement.internal.zzgd r8 = r1.zzj     // Catch:{ all -> 0x0941 }
            com.google.android.gms.measurement.internal.zzai r8 = r8.zzx()     // Catch:{ all -> 0x0941 }
            java.lang.String r8 = r8.zzg()     // Catch:{ all -> 0x0941 }
            r7.zzd((java.lang.String) r8)     // Catch:{ all -> 0x0941 }
            com.google.android.gms.measurement.internal.zzgd r7 = r1.zzj     // Catch:{ all -> 0x0941 }
            com.google.android.gms.measurement.internal.zzy r7 = r7.zzb()     // Catch:{ all -> 0x0941 }
            com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean> r8 = com.google.android.gms.measurement.internal.zzaq.zzcl     // Catch:{ all -> 0x0941 }
            boolean r7 = r7.zza((com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean>) r8)     // Catch:{ all -> 0x0941 }
            if (r7 != 0) goto L_0x0785
            long r7 = r3.zzl     // Catch:{ all -> 0x0941 }
            r2.zzj((long) r7)     // Catch:{ all -> 0x0941 }
        L_0x0785:
            com.google.android.gms.measurement.internal.zzgd r7 = r1.zzj     // Catch:{ all -> 0x0941 }
            boolean r7 = r7.zzab()     // Catch:{ all -> 0x0941 }
            if (r7 == 0) goto L_0x079b
            r2.zzj()     // Catch:{ all -> 0x0941 }
            boolean r7 = android.text.TextUtils.isEmpty(r25)     // Catch:{ all -> 0x0941 }
            if (r7 != 0) goto L_0x079b
            r7 = r25
            r2.zzn(r7)     // Catch:{ all -> 0x0941 }
        L_0x079b:
            com.google.android.gms.measurement.internal.zzad r7 = r26.zze()     // Catch:{ all -> 0x0941 }
            java.lang.String r8 = r3.zza     // Catch:{ all -> 0x0941 }
            com.google.android.gms.measurement.internal.zzf r7 = r7.zzb(r8)     // Catch:{ all -> 0x0941 }
            if (r7 != 0) goto L_0x081c
            com.google.android.gms.measurement.internal.zzf r7 = new com.google.android.gms.measurement.internal.zzf     // Catch:{ all -> 0x0941 }
            com.google.android.gms.measurement.internal.zzgd r8 = r1.zzj     // Catch:{ all -> 0x0941 }
            java.lang.String r11 = r3.zza     // Catch:{ all -> 0x0941 }
            r7.<init>(r8, r11)     // Catch:{ all -> 0x0941 }
            com.google.android.gms.measurement.internal.zzgd r8 = r1.zzj     // Catch:{ all -> 0x0941 }
            com.google.android.gms.measurement.internal.zzkw r8 = r8.zzi()     // Catch:{ all -> 0x0941 }
            java.lang.String r8 = r8.zzk()     // Catch:{ all -> 0x0941 }
            r7.zza((java.lang.String) r8)     // Catch:{ all -> 0x0941 }
            java.lang.String r8 = r3.zzk     // Catch:{ all -> 0x0941 }
            r7.zzf((java.lang.String) r8)     // Catch:{ all -> 0x0941 }
            java.lang.String r8 = r3.zzb     // Catch:{ all -> 0x0941 }
            r7.zzb((java.lang.String) r8)     // Catch:{ all -> 0x0941 }
            com.google.android.gms.measurement.internal.zzgd r8 = r1.zzj     // Catch:{ all -> 0x0941 }
            com.google.android.gms.measurement.internal.zzfl r8 = r8.zzc()     // Catch:{ all -> 0x0941 }
            java.lang.String r11 = r3.zza     // Catch:{ all -> 0x0941 }
            java.lang.String r8 = r8.zzb((java.lang.String) r11)     // Catch:{ all -> 0x0941 }
            r7.zze((java.lang.String) r8)     // Catch:{ all -> 0x0941 }
            r7.zzg((long) r9)     // Catch:{ all -> 0x0941 }
            r7.zza((long) r9)     // Catch:{ all -> 0x0941 }
            r7.zzb((long) r9)     // Catch:{ all -> 0x0941 }
            java.lang.String r8 = r3.zzc     // Catch:{ all -> 0x0941 }
            r7.zzg((java.lang.String) r8)     // Catch:{ all -> 0x0941 }
            long r11 = r3.zzj     // Catch:{ all -> 0x0941 }
            r7.zzc((long) r11)     // Catch:{ all -> 0x0941 }
            java.lang.String r8 = r3.zzd     // Catch:{ all -> 0x0941 }
            r7.zzh((java.lang.String) r8)     // Catch:{ all -> 0x0941 }
            long r11 = r3.zze     // Catch:{ all -> 0x0941 }
            r7.zzd((long) r11)     // Catch:{ all -> 0x0941 }
            long r11 = r3.zzf     // Catch:{ all -> 0x0941 }
            r7.zze((long) r11)     // Catch:{ all -> 0x0941 }
            boolean r8 = r3.zzh     // Catch:{ all -> 0x0941 }
            r7.zza((boolean) r8)     // Catch:{ all -> 0x0941 }
            com.google.android.gms.measurement.internal.zzgd r8 = r1.zzj     // Catch:{ all -> 0x0941 }
            com.google.android.gms.measurement.internal.zzy r8 = r8.zzb()     // Catch:{ all -> 0x0941 }
            com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean> r11 = com.google.android.gms.measurement.internal.zzaq.zzcl     // Catch:{ all -> 0x0941 }
            boolean r8 = r8.zza((com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean>) r11)     // Catch:{ all -> 0x0941 }
            if (r8 != 0) goto L_0x0810
            long r11 = r3.zzl     // Catch:{ all -> 0x0941 }
            r7.zzp(r11)     // Catch:{ all -> 0x0941 }
        L_0x0810:
            long r11 = r3.zzt     // Catch:{ all -> 0x0941 }
            r7.zzf((long) r11)     // Catch:{ all -> 0x0941 }
            com.google.android.gms.measurement.internal.zzad r8 = r26.zze()     // Catch:{ all -> 0x0941 }
            r8.zza((com.google.android.gms.measurement.internal.zzf) r7)     // Catch:{ all -> 0x0941 }
        L_0x081c:
            java.lang.String r8 = r7.zzd()     // Catch:{ all -> 0x0941 }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0941 }
            if (r8 != 0) goto L_0x082d
            java.lang.String r8 = r7.zzd()     // Catch:{ all -> 0x0941 }
            r2.zzi((java.lang.String) r8)     // Catch:{ all -> 0x0941 }
        L_0x082d:
            java.lang.String r8 = r7.zzi()     // Catch:{ all -> 0x0941 }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0941 }
            if (r8 != 0) goto L_0x083e
            java.lang.String r7 = r7.zzi()     // Catch:{ all -> 0x0941 }
            r2.zzl((java.lang.String) r7)     // Catch:{ all -> 0x0941 }
        L_0x083e:
            com.google.android.gms.measurement.internal.zzad r7 = r26.zze()     // Catch:{ all -> 0x0941 }
            java.lang.String r3 = r3.zza     // Catch:{ all -> 0x0941 }
            java.util.List r3 = r7.zza((java.lang.String) r3)     // Catch:{ all -> 0x0941 }
            r11 = 0
        L_0x0849:
            int r7 = r3.size()     // Catch:{ all -> 0x0941 }
            if (r11 >= r7) goto L_0x0880
            com.google.android.gms.internal.measurement.zzcc$zzk$zza r7 = com.google.android.gms.internal.measurement.zzcc.zzk.zzj()     // Catch:{ all -> 0x0941 }
            java.lang.Object r8 = r3.get(r11)     // Catch:{ all -> 0x0941 }
            com.google.android.gms.measurement.internal.zzkt r8 = (com.google.android.gms.measurement.internal.zzkt) r8     // Catch:{ all -> 0x0941 }
            java.lang.String r8 = r8.zzc     // Catch:{ all -> 0x0941 }
            com.google.android.gms.internal.measurement.zzcc$zzk$zza r7 = r7.zza((java.lang.String) r8)     // Catch:{ all -> 0x0941 }
            java.lang.Object r8 = r3.get(r11)     // Catch:{ all -> 0x0941 }
            com.google.android.gms.measurement.internal.zzkt r8 = (com.google.android.gms.measurement.internal.zzkt) r8     // Catch:{ all -> 0x0941 }
            long r12 = r8.zzd     // Catch:{ all -> 0x0941 }
            com.google.android.gms.internal.measurement.zzcc$zzk$zza r7 = r7.zza((long) r12)     // Catch:{ all -> 0x0941 }
            com.google.android.gms.measurement.internal.zzks r8 = r26.zzh()     // Catch:{ all -> 0x0941 }
            java.lang.Object r12 = r3.get(r11)     // Catch:{ all -> 0x0941 }
            com.google.android.gms.measurement.internal.zzkt r12 = (com.google.android.gms.measurement.internal.zzkt) r12     // Catch:{ all -> 0x0941 }
            java.lang.Object r12 = r12.zze     // Catch:{ all -> 0x0941 }
            r8.zza((com.google.android.gms.internal.measurement.zzcc.zzk.zza) r7, (java.lang.Object) r12)     // Catch:{ all -> 0x0941 }
            r2.zza((com.google.android.gms.internal.measurement.zzcc.zzk.zza) r7)     // Catch:{ all -> 0x0941 }
            int r11 = r11 + 1
            goto L_0x0849
        L_0x0880:
            com.google.android.gms.measurement.internal.zzad r3 = r26.zze()     // Catch:{ IOException -> 0x08f5 }
            com.google.android.gms.internal.measurement.zzjj r7 = r2.zzv()     // Catch:{ IOException -> 0x08f5 }
            com.google.android.gms.internal.measurement.zzib r7 = (com.google.android.gms.internal.measurement.zzib) r7     // Catch:{ IOException -> 0x08f5 }
            com.google.android.gms.internal.measurement.zzcc$zzg r7 = (com.google.android.gms.internal.measurement.zzcc.zzg) r7     // Catch:{ IOException -> 0x08f5 }
            long r2 = r3.zza((com.google.android.gms.internal.measurement.zzcc.zzg) r7)     // Catch:{ IOException -> 0x08f5 }
            com.google.android.gms.measurement.internal.zzad r7 = r26.zze()     // Catch:{ all -> 0x0941 }
            com.google.android.gms.measurement.internal.zzan r8 = r4.zze     // Catch:{ all -> 0x0941 }
            if (r8 == 0) goto L_0x08eb
            com.google.android.gms.measurement.internal.zzan r8 = r4.zze     // Catch:{ all -> 0x0941 }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ all -> 0x0941 }
        L_0x089e:
            boolean r11 = r8.hasNext()     // Catch:{ all -> 0x0941 }
            if (r11 == 0) goto L_0x08b2
            java.lang.Object r11 = r8.next()     // Catch:{ all -> 0x0941 }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ all -> 0x0941 }
            boolean r11 = r5.equals(r11)     // Catch:{ all -> 0x0941 }
            if (r11 == 0) goto L_0x089e
        L_0x08b0:
            r11 = 1
            goto L_0x08ec
        L_0x08b2:
            com.google.android.gms.measurement.internal.zzfx r5 = r26.zzc()     // Catch:{ all -> 0x0941 }
            java.lang.String r8 = r4.zza     // Catch:{ all -> 0x0941 }
            java.lang.String r11 = r4.zzb     // Catch:{ all -> 0x0941 }
            boolean r5 = r5.zzc(r8, r11)     // Catch:{ all -> 0x0941 }
            com.google.android.gms.measurement.internal.zzad r11 = r26.zze()     // Catch:{ all -> 0x0941 }
            long r12 = r26.zzx()     // Catch:{ all -> 0x0941 }
            java.lang.String r14 = r4.zza     // Catch:{ all -> 0x0941 }
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            com.google.android.gms.measurement.internal.zzac r8 = r11.zza(r12, r14, r15, r16, r17, r18, r19)     // Catch:{ all -> 0x0941 }
            if (r5 == 0) goto L_0x08eb
            long r11 = r8.zze     // Catch:{ all -> 0x0941 }
            com.google.android.gms.measurement.internal.zzgd r5 = r1.zzj     // Catch:{ all -> 0x0941 }
            com.google.android.gms.measurement.internal.zzy r5 = r5.zzb()     // Catch:{ all -> 0x0941 }
            java.lang.String r8 = r4.zza     // Catch:{ all -> 0x0941 }
            int r5 = r5.zzc(r8)     // Catch:{ all -> 0x0941 }
            long r13 = (long) r5     // Catch:{ all -> 0x0941 }
            int r5 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r5 >= 0) goto L_0x08eb
            goto L_0x08b0
        L_0x08eb:
            r11 = 0
        L_0x08ec:
            boolean r2 = r7.zza((com.google.android.gms.measurement.internal.zzal) r4, (long) r2, (boolean) r11)     // Catch:{ all -> 0x0941 }
            if (r2 == 0) goto L_0x090e
            r1.zzm = r9     // Catch:{ all -> 0x0941 }
            goto L_0x090e
        L_0x08f5:
            r0 = move-exception
            r3 = r0
            com.google.android.gms.measurement.internal.zzgd r4 = r1.zzj     // Catch:{ all -> 0x0941 }
            com.google.android.gms.measurement.internal.zzez r4 = r4.zzr()     // Catch:{ all -> 0x0941 }
            com.google.android.gms.measurement.internal.zzfb r4 = r4.zzf()     // Catch:{ all -> 0x0941 }
            java.lang.String r5 = "Data loss. Failed to insert raw event metadata. appId"
            java.lang.String r2 = r2.zzj()     // Catch:{ all -> 0x0941 }
            java.lang.Object r2 = com.google.android.gms.measurement.internal.zzez.zza((java.lang.String) r2)     // Catch:{ all -> 0x0941 }
            r4.zza(r5, r2, r3)     // Catch:{ all -> 0x0941 }
        L_0x090e:
            com.google.android.gms.measurement.internal.zzad r2 = r26.zze()     // Catch:{ all -> 0x0941 }
            r2.mo24208b_()     // Catch:{ all -> 0x0941 }
            com.google.android.gms.measurement.internal.zzad r2 = r26.zze()
            r2.zzh()
            r26.zzz()
            com.google.android.gms.measurement.internal.zzgd r2 = r1.zzj
            com.google.android.gms.measurement.internal.zzez r2 = r2.zzr()
            com.google.android.gms.measurement.internal.zzfb r2 = r2.zzx()
            long r3 = java.lang.System.nanoTime()
            long r3 = r3 - r23
            r5 = 500000(0x7a120, double:2.47033E-318)
            long r3 = r3 + r5
            r5 = 1000000(0xf4240, double:4.940656E-318)
            long r3 = r3 / r5
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            java.lang.String r4 = "Background event processing time, ms"
            r2.zza(r4, r3)
            return
        L_0x0941:
            r0 = move-exception
            r2 = r0
            com.google.android.gms.measurement.internal.zzad r3 = r26.zze()
            r3.zzh()
            goto L_0x094c
        L_0x094b:
            throw r2
        L_0x094c:
            goto L_0x094b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkk.zzc(com.google.android.gms.measurement.internal.zzao, com.google.android.gms.measurement.internal.zzn):void");
    }

    private final boolean zze(zzn zzn2) {
        return (!zzoe.zzb() || !this.zzj.zzb().zze(zzn2.zza, zzaq.zzbn)) ? !TextUtils.isEmpty(zzn2.zzb) || !TextUtils.isEmpty(zzn2.zzr) : !TextUtils.isEmpty(zzn2.zzb) || !TextUtils.isEmpty(zzn2.zzv) || !TextUtils.isEmpty(zzn2.zzr);
    }

    private final zzfj zzt() {
        zzfj zzfj = this.zze;
        if (zzfj != null) {
            return zzfj;
        }
        throw new IllegalStateException("Network broadcast receiver not created");
    }

    private final zzkg zzv() {
        zzb((zzkl) this.zzf);
        return this.zzf;
    }

    @WorkerThread
    private final void zzw() {
        this.zzj.zzq().zzd();
    }

    private final long zzx() {
        long currentTimeMillis = this.zzj.zzm().currentTimeMillis();
        zzfl zzc2 = this.zzj.zzc();
        zzc2.zzaa();
        zzc2.zzd();
        long zza2 = zzc2.zzg.zza();
        if (zza2 == 0) {
            zza2 = 1 + ((long) zzc2.zzp().zzh().nextInt(86400000));
            zzc2.zzg.zza(zza2);
        }
        return ((((currentTimeMillis + zza2) / 1000) / 60) / 60) / 24;
    }

    private final boolean zzy() {
        zzw();
        zzk();
        return zze().zzy() || !TextUtils.isEmpty(zze().mo24210d_());
    }

    /* JADX WARNING: Removed duplicated region for block: B:48:0x0170  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x018e  */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzz() {
        /*
            r21 = this;
            r0 = r21
            r21.zzw()
            r21.zzk()
            long r1 = r0.zzm
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 <= 0) goto L_0x004d
            com.google.android.gms.measurement.internal.zzgd r1 = r0.zzj
            com.google.android.gms.common.util.Clock r1 = r1.zzm()
            long r1 = r1.elapsedRealtime()
            r5 = 3600000(0x36ee80, double:1.7786363E-317)
            long r7 = r0.zzm
            long r1 = r1 - r7
            long r1 = java.lang.Math.abs(r1)
            long r5 = r5 - r1
            int r1 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r1 <= 0) goto L_0x004b
            com.google.android.gms.measurement.internal.zzgd r1 = r0.zzj
            com.google.android.gms.measurement.internal.zzez r1 = r1.zzr()
            com.google.android.gms.measurement.internal.zzfb r1 = r1.zzx()
            java.lang.Long r2 = java.lang.Long.valueOf(r5)
            java.lang.String r3 = "Upload has been suspended. Will update scheduling later in approximately ms"
            r1.zza(r3, r2)
            com.google.android.gms.measurement.internal.zzfj r1 = r21.zzt()
            r1.zzb()
            com.google.android.gms.measurement.internal.zzkg r1 = r21.zzv()
            r1.zzf()
            return
        L_0x004b:
            r0.zzm = r3
        L_0x004d:
            com.google.android.gms.measurement.internal.zzgd r1 = r0.zzj
            boolean r1 = r1.zzag()
            if (r1 == 0) goto L_0x0239
            boolean r1 = r21.zzy()
            if (r1 != 0) goto L_0x005d
            goto L_0x0239
        L_0x005d:
            com.google.android.gms.measurement.internal.zzgd r1 = r0.zzj
            com.google.android.gms.common.util.Clock r1 = r1.zzm()
            long r1 = r1.currentTimeMillis()
            com.google.android.gms.measurement.internal.zzeo<java.lang.Long> r5 = com.google.android.gms.measurement.internal.zzaq.zzz
            r6 = 0
            java.lang.Object r5 = r5.zza(r6)
            java.lang.Long r5 = (java.lang.Long) r5
            long r7 = r5.longValue()
            long r7 = java.lang.Math.max(r3, r7)
            com.google.android.gms.measurement.internal.zzad r5 = r21.zze()
            boolean r5 = r5.zzz()
            if (r5 != 0) goto L_0x008f
            com.google.android.gms.measurement.internal.zzad r5 = r21.zze()
            boolean r5 = r5.zzk()
            if (r5 == 0) goto L_0x008d
            goto L_0x008f
        L_0x008d:
            r5 = 0
            goto L_0x0090
        L_0x008f:
            r5 = 1
        L_0x0090:
            if (r5 == 0) goto L_0x00b0
            com.google.android.gms.measurement.internal.zzgd r10 = r0.zzj
            com.google.android.gms.measurement.internal.zzy r10 = r10.zzb()
            java.lang.String r10 = r10.zzw()
            boolean r11 = android.text.TextUtils.isEmpty(r10)
            if (r11 != 0) goto L_0x00ad
            java.lang.String r11 = ".none."
            boolean r10 = r11.equals(r10)
            if (r10 != 0) goto L_0x00ad
            com.google.android.gms.measurement.internal.zzeo<java.lang.Long> r10 = com.google.android.gms.measurement.internal.zzaq.zzu
            goto L_0x00b2
        L_0x00ad:
            com.google.android.gms.measurement.internal.zzeo<java.lang.Long> r10 = com.google.android.gms.measurement.internal.zzaq.zzt
            goto L_0x00b2
        L_0x00b0:
            com.google.android.gms.measurement.internal.zzeo<java.lang.Long> r10 = com.google.android.gms.measurement.internal.zzaq.zzs
        L_0x00b2:
            java.lang.Object r10 = r10.zza(r6)
            java.lang.Long r10 = (java.lang.Long) r10
            long r10 = r10.longValue()
            long r10 = java.lang.Math.max(r3, r10)
            com.google.android.gms.measurement.internal.zzgd r12 = r0.zzj
            com.google.android.gms.measurement.internal.zzfl r12 = r12.zzc()
            com.google.android.gms.measurement.internal.zzfp r12 = r12.zzc
            long r12 = r12.zza()
            com.google.android.gms.measurement.internal.zzgd r14 = r0.zzj
            com.google.android.gms.measurement.internal.zzfl r14 = r14.zzc()
            com.google.android.gms.measurement.internal.zzfp r14 = r14.zzd
            long r14 = r14.zza()
            com.google.android.gms.measurement.internal.zzad r16 = r21.zze()
            r17 = r10
            long r9 = r16.zzw()
            com.google.android.gms.measurement.internal.zzad r11 = r21.zze()
            r19 = r7
            long r6 = r11.zzx()
            long r6 = java.lang.Math.max(r9, r6)
            int r8 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r8 != 0) goto L_0x00f7
        L_0x00f4:
            r10 = r3
            goto L_0x016c
        L_0x00f7:
            long r6 = r6 - r1
            long r6 = java.lang.Math.abs(r6)
            long r6 = r1 - r6
            long r12 = r12 - r1
            long r8 = java.lang.Math.abs(r12)
            long r8 = r1 - r8
            long r14 = r14 - r1
            long r10 = java.lang.Math.abs(r14)
            long r1 = r1 - r10
            long r8 = java.lang.Math.max(r8, r1)
            long r10 = r6 + r19
            if (r5 == 0) goto L_0x011d
            int r5 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r5 <= 0) goto L_0x011d
            long r10 = java.lang.Math.min(r6, r8)
            long r10 = r10 + r17
        L_0x011d:
            com.google.android.gms.measurement.internal.zzks r5 = r21.zzh()
            r12 = r17
            boolean r5 = r5.zza((long) r8, (long) r12)
            if (r5 != 0) goto L_0x012b
            long r10 = r8 + r12
        L_0x012b:
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x016c
            int r5 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r5 < 0) goto L_0x016c
            r5 = 0
        L_0x0134:
            r6 = 20
            com.google.android.gms.measurement.internal.zzeo<java.lang.Integer> r7 = com.google.android.gms.measurement.internal.zzaq.zzab
            r8 = 0
            java.lang.Object r7 = r7.zza(r8)
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            r9 = 0
            int r7 = java.lang.Math.max(r9, r7)
            int r6 = java.lang.Math.min(r6, r7)
            if (r5 >= r6) goto L_0x00f4
            r6 = 1
            long r6 = r6 << r5
            com.google.android.gms.measurement.internal.zzeo<java.lang.Long> r12 = com.google.android.gms.measurement.internal.zzaq.zzaa
            java.lang.Object r12 = r12.zza(r8)
            java.lang.Long r12 = (java.lang.Long) r12
            long r12 = r12.longValue()
            long r12 = java.lang.Math.max(r3, r12)
            long r12 = r12 * r6
            long r10 = r10 + r12
            int r6 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r6 <= 0) goto L_0x0169
            goto L_0x016c
        L_0x0169:
            int r5 = r5 + 1
            goto L_0x0134
        L_0x016c:
            int r1 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
            if (r1 != 0) goto L_0x018e
            com.google.android.gms.measurement.internal.zzgd r1 = r0.zzj
            com.google.android.gms.measurement.internal.zzez r1 = r1.zzr()
            com.google.android.gms.measurement.internal.zzfb r1 = r1.zzx()
            java.lang.String r2 = "Next upload time is 0"
            r1.zza(r2)
            com.google.android.gms.measurement.internal.zzfj r1 = r21.zzt()
            r1.zzb()
            com.google.android.gms.measurement.internal.zzkg r1 = r21.zzv()
            r1.zzf()
            return
        L_0x018e:
            com.google.android.gms.measurement.internal.zzfc r1 = r21.zzd()
            boolean r1 = r1.zzf()
            if (r1 != 0) goto L_0x01b6
            com.google.android.gms.measurement.internal.zzgd r1 = r0.zzj
            com.google.android.gms.measurement.internal.zzez r1 = r1.zzr()
            com.google.android.gms.measurement.internal.zzfb r1 = r1.zzx()
            java.lang.String r2 = "No network"
            r1.zza(r2)
            com.google.android.gms.measurement.internal.zzfj r1 = r21.zzt()
            r1.zza()
            com.google.android.gms.measurement.internal.zzkg r1 = r21.zzv()
            r1.zzf()
            return
        L_0x01b6:
            com.google.android.gms.measurement.internal.zzgd r1 = r0.zzj
            com.google.android.gms.measurement.internal.zzfl r1 = r1.zzc()
            com.google.android.gms.measurement.internal.zzfp r1 = r1.zze
            long r1 = r1.zza()
            com.google.android.gms.measurement.internal.zzeo<java.lang.Long> r5 = com.google.android.gms.measurement.internal.zzaq.zzq
            r6 = 0
            java.lang.Object r5 = r5.zza(r6)
            java.lang.Long r5 = (java.lang.Long) r5
            long r5 = r5.longValue()
            long r5 = java.lang.Math.max(r3, r5)
            com.google.android.gms.measurement.internal.zzks r7 = r21.zzh()
            boolean r7 = r7.zza((long) r1, (long) r5)
            if (r7 != 0) goto L_0x01e2
            long r1 = r1 + r5
            long r10 = java.lang.Math.max(r10, r1)
        L_0x01e2:
            com.google.android.gms.measurement.internal.zzfj r1 = r21.zzt()
            r1.zzb()
            com.google.android.gms.measurement.internal.zzgd r1 = r0.zzj
            com.google.android.gms.common.util.Clock r1 = r1.zzm()
            long r1 = r1.currentTimeMillis()
            long r10 = r10 - r1
            int r1 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
            if (r1 > 0) goto L_0x021e
            com.google.android.gms.measurement.internal.zzeo<java.lang.Long> r1 = com.google.android.gms.measurement.internal.zzaq.zzv
            r2 = 0
            java.lang.Object r1 = r1.zza(r2)
            java.lang.Long r1 = (java.lang.Long) r1
            long r1 = r1.longValue()
            long r10 = java.lang.Math.max(r3, r1)
            com.google.android.gms.measurement.internal.zzgd r1 = r0.zzj
            com.google.android.gms.measurement.internal.zzfl r1 = r1.zzc()
            com.google.android.gms.measurement.internal.zzfp r1 = r1.zzc
            com.google.android.gms.measurement.internal.zzgd r2 = r0.zzj
            com.google.android.gms.common.util.Clock r2 = r2.zzm()
            long r2 = r2.currentTimeMillis()
            r1.zza(r2)
        L_0x021e:
            com.google.android.gms.measurement.internal.zzgd r1 = r0.zzj
            com.google.android.gms.measurement.internal.zzez r1 = r1.zzr()
            com.google.android.gms.measurement.internal.zzfb r1 = r1.zzx()
            java.lang.Long r2 = java.lang.Long.valueOf(r10)
            java.lang.String r3 = "Upload scheduled in approximately ms"
            r1.zza(r3, r2)
            com.google.android.gms.measurement.internal.zzkg r1 = r21.zzv()
            r1.zza(r10)
            return
        L_0x0239:
            com.google.android.gms.measurement.internal.zzgd r1 = r0.zzj
            com.google.android.gms.measurement.internal.zzez r1 = r1.zzr()
            com.google.android.gms.measurement.internal.zzfb r1 = r1.zzx()
            java.lang.String r2 = "Nothing to upload or uploading impossible"
            r1.zza(r2)
            com.google.android.gms.measurement.internal.zzfj r1 = r21.zzt()
            r1.zzb()
            com.google.android.gms.measurement.internal.zzkg r1 = r21.zzv()
            r1.zzf()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkk.zzz():void");
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zza() {
        this.zzj.zzq().zzd();
        zze().zzv();
        if (this.zzj.zzc().zzc.zza() == 0) {
            this.zzj.zzc().zzc.zza(this.zzj.zzm().currentTimeMillis());
        }
        zzz();
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: package-private */
    @WorkerThread
    @VisibleForTesting
    public final void zza(int i, Throwable th, byte[] bArr, String str) {
        zzad zze2;
        zzw();
        zzk();
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } catch (Throwable th2) {
                this.zzr = false;
                zzaa();
                throw th2;
            }
        }
        List<Long> list = this.zzv;
        this.zzv = null;
        boolean z = true;
        if ((i == 200 || i == 204) && th == null) {
            try {
                this.zzj.zzc().zzc.zza(this.zzj.zzm().currentTimeMillis());
                this.zzj.zzc().zzd.zza(0);
                zzz();
                this.zzj.zzr().zzx().zza("Successful upload. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr.length));
                zze().zzf();
                try {
                    for (Long next : list) {
                        try {
                            zze2 = zze();
                            long longValue = next.longValue();
                            zze2.zzd();
                            zze2.zzak();
                            if (zze2.mo24209c_().delete("queue", "rowid=?", new String[]{String.valueOf(longValue)}) != 1) {
                                throw new SQLiteException("Deleted fewer rows from queue than expected");
                            }
                        } catch (SQLiteException e) {
                            zze2.zzr().zzf().zza("Failed to delete a bundle in a queue table", e);
                            throw e;
                        } catch (SQLiteException e2) {
                            if (this.zzw == null || !this.zzw.contains(next)) {
                                throw e2;
                            }
                        }
                    }
                    zze().mo24208b_();
                    zze().zzh();
                    this.zzw = null;
                    if (!zzd().zzf() || !zzy()) {
                        this.zzx = -1;
                        zzz();
                    } else {
                        zzl();
                    }
                    this.zzm = 0;
                } catch (Throwable th3) {
                    zze().zzh();
                    throw th3;
                }
            } catch (SQLiteException e3) {
                this.zzj.zzr().zzf().zza("Database error while trying to delete uploaded bundles", e3);
                this.zzm = this.zzj.zzm().elapsedRealtime();
                this.zzj.zzr().zzx().zza("Disable upload, time", Long.valueOf(this.zzm));
            }
        } else {
            this.zzj.zzr().zzx().zza("Network upload failed. Will retry later. code, error", Integer.valueOf(i), th);
            this.zzj.zzc().zzd.zza(this.zzj.zzm().currentTimeMillis());
            if (i != 503) {
                if (i != 429) {
                    z = false;
                }
            }
            if (z) {
                this.zzj.zzc().zze.zza(this.zzj.zzm().currentTimeMillis());
            }
            zze().zza(list);
            zzz();
        }
        this.zzr = false;
        zzaa();
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zza(zzao zzao, zzn zzn2) {
        List<zzw> list;
        List<zzw> list2;
        List<zzw> list3;
        zzfb zzf2;
        String str;
        Object zza2;
        String zzc2;
        Object obj;
        List<String> list4;
        zzao zzao2 = zzao;
        zzn zzn3 = zzn2;
        Preconditions.checkNotNull(zzn2);
        Preconditions.checkNotEmpty(zzn3.zza);
        zzw();
        zzk();
        String str2 = zzn3.zza;
        long j = zzao2.zzd;
        zzh();
        if (zzks.zza(zzao, zzn2)) {
            if (!zzn3.zzh) {
                zzc(zzn3);
                return;
            }
            if (this.zzj.zzb().zze(str2, zzaq.zzbb) && (list4 = zzn3.zzu) != null) {
                if (list4.contains(zzao2.zza)) {
                    Bundle zzb2 = zzao2.zzb.zzb();
                    zzb2.putLong("ga_safelisted", 1);
                    zzao2 = new zzao(zzao2.zza, new zzan(zzb2), zzao2.zzc, zzao2.zzd);
                } else {
                    this.zzj.zzr().zzw().zza("Dropping non-safelisted event. appId, event name, origin", str2, zzao2.zza, zzao2.zzc);
                    return;
                }
            }
            zze().zzf();
            try {
                zzad zze2 = zze();
                Preconditions.checkNotEmpty(str2);
                zze2.zzd();
                zze2.zzak();
                if (j < 0) {
                    zze2.zzr().zzi().zza("Invalid time querying timed out conditional properties", zzez.zza(str2), Long.valueOf(j));
                    list = Collections.emptyList();
                } else {
                    list = zze2.zza("active=0 and app_id=? and abs(? - creation_timestamp) > trigger_timeout", new String[]{str2, String.valueOf(j)});
                }
                for (zzw next : list) {
                    if (next != null) {
                        this.zzj.zzr().zzx().zza("User property timed out", next.zza, this.zzj.zzj().zzc(next.zzc.zza), next.zzc.zza());
                        if (next.zzg != null) {
                            zzc(new zzao(next.zzg, j), zzn3);
                        }
                        zze().zze(str2, next.zzc.zza);
                    }
                }
                zzad zze3 = zze();
                Preconditions.checkNotEmpty(str2);
                zze3.zzd();
                zze3.zzak();
                if (j < 0) {
                    zze3.zzr().zzi().zza("Invalid time querying expired conditional properties", zzez.zza(str2), Long.valueOf(j));
                    list2 = Collections.emptyList();
                } else {
                    list2 = zze3.zza("active<>0 and app_id=? and abs(? - triggered_timestamp) > time_to_live", new String[]{str2, String.valueOf(j)});
                }
                ArrayList arrayList = new ArrayList(list2.size());
                for (zzw next2 : list2) {
                    if (next2 != null) {
                        this.zzj.zzr().zzx().zza("User property expired", next2.zza, this.zzj.zzj().zzc(next2.zzc.zza), next2.zzc.zza());
                        zze().zzb(str2, next2.zzc.zza);
                        if (next2.zzk != null) {
                            arrayList.add(next2.zzk);
                        }
                        zze().zze(str2, next2.zzc.zza);
                    }
                }
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj2 = arrayList.get(i);
                    i++;
                    zzc(new zzao((zzao) obj2, j), zzn3);
                }
                zzad zze4 = zze();
                String str3 = zzao2.zza;
                Preconditions.checkNotEmpty(str2);
                Preconditions.checkNotEmpty(str3);
                zze4.zzd();
                zze4.zzak();
                if (j < 0) {
                    zze4.zzr().zzi().zza("Invalid time querying triggered conditional properties", zzez.zza(str2), zze4.zzo().zza(str3), Long.valueOf(j));
                    list3 = Collections.emptyList();
                } else {
                    list3 = zze4.zza("active=0 and app_id=? and trigger_event_name=? and abs(? - creation_timestamp) <= trigger_timeout", new String[]{str2, str3, String.valueOf(j)});
                }
                ArrayList arrayList2 = new ArrayList(list3.size());
                for (zzw next3 : list3) {
                    if (next3 != null) {
                        zzkr zzkr = next3.zzc;
                        zzkt zzkt = r4;
                        zzkt zzkt2 = new zzkt(next3.zza, next3.zzb, zzkr.zza, j, zzkr.zza());
                        if (zze().zza(zzkt)) {
                            zzf2 = this.zzj.zzr().zzx();
                            str = "User property triggered";
                            zza2 = next3.zza;
                            zzc2 = this.zzj.zzj().zzc(zzkt.zzc);
                            obj = zzkt.zze;
                        } else {
                            zzf2 = this.zzj.zzr().zzf();
                            str = "Too many active user properties, ignoring";
                            zza2 = zzez.zza(next3.zza);
                            zzc2 = this.zzj.zzj().zzc(zzkt.zzc);
                            obj = zzkt.zze;
                        }
                        zzf2.zza(str, zza2, zzc2, obj);
                        if (next3.zzi != null) {
                            arrayList2.add(next3.zzi);
                        }
                        next3.zzc = new zzkr(zzkt);
                        next3.zze = true;
                        zze().zza(next3);
                    }
                }
                zzc(zzao2, zzn3);
                int size2 = arrayList2.size();
                int i2 = 0;
                while (i2 < size2) {
                    Object obj3 = arrayList2.get(i2);
                    i2++;
                    zzc(new zzao((zzao) obj3, j), zzn3);
                }
                zze().mo24208b_();
            } finally {
                zze().zzh();
            }
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zza(zzao zzao, String str) {
        zzao zzao2 = zzao;
        zzf zzb2 = zze().zzb(str);
        if (zzb2 == null || TextUtils.isEmpty(zzb2.zzl())) {
            this.zzj.zzr().zzw().zza("No app data available; dropping event", str);
            return;
        }
        Boolean zzb3 = zzb(zzb2);
        if (zzb3 == null) {
            if (!"_ui".equals(zzao2.zza)) {
                this.zzj.zzr().zzi().zza("Could not find package. appId", zzez.zza(str));
            }
        } else if (!zzb3.booleanValue()) {
            this.zzj.zzr().zzf().zza("App version does not match; dropping event. appId", zzez.zza(str));
            return;
        }
        zzn zzn2 = r2;
        zzn zzn3 = new zzn(str, zzb2.zze(), zzb2.zzl(), zzb2.zzm(), zzb2.zzn(), zzb2.zzo(), zzb2.zzp(), (String) null, zzb2.zzr(), false, zzb2.zzi(), zzb2.zzae(), 0, 0, zzb2.zzaf(), zzb2.zzag(), false, zzb2.zzf(), zzb2.zzah(), zzb2.zzq(), zzb2.zzai(), (!zzoe.zzb() || !this.zzj.zzb().zze(zzb2.zzc(), zzaq.zzbn)) ? null : zzb2.zzg());
        zzb(zzao2, zzn2);
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzkl zzkl) {
        this.zzo++;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zza(zzkr zzkr, zzn zzn2) {
        zzw();
        zzk();
        if (zze(zzn2)) {
            if (!zzn2.zzh) {
                zzc(zzn2);
                return;
            }
            int zzc2 = this.zzj.zzi().zzc(zzkr.zza);
            zzgd zzgd = this.zzj;
            if (zzc2 != 0) {
                zzgd.zzi();
                String zza2 = zzkw.zza(zzkr.zza, 24, true);
                String str = zzkr.zza;
                this.zzj.zzi().zza(zzn2.zza, zzc2, "_ev", zza2, str != null ? str.length() : 0);
                return;
            }
            int zzb2 = zzgd.zzi().zzb(zzkr.zza, zzkr.zza());
            if (zzb2 != 0) {
                this.zzj.zzi();
                String zza3 = zzkw.zza(zzkr.zza, 24, true);
                Object zza4 = zzkr.zza();
                this.zzj.zzi().zza(zzn2.zza, zzb2, "_ev", zza3, (zza4 == null || (!(zza4 instanceof String) && !(zza4 instanceof CharSequence))) ? 0 : String.valueOf(zza4).length());
                return;
            }
            Object zzc3 = this.zzj.zzi().zzc(zzkr.zza, zzkr.zza());
            if (zzc3 != null) {
                if ("_sid".equals(zzkr.zza)) {
                    long j = zzkr.zzb;
                    String str2 = zzkr.zze;
                    long j2 = 0;
                    zzkt zzc4 = zze().zzc(zzn2.zza, "_sno");
                    if (zzc4 != null) {
                        Object obj = zzc4.zze;
                        if (obj instanceof Long) {
                            j2 = ((Long) obj).longValue();
                            zza(new zzkr("_sno", j, Long.valueOf(j2 + 1), str2), zzn2);
                        }
                    }
                    if (zzc4 != null) {
                        this.zzj.zzr().zzi().zza("Retrieved last session number from database does not contain a valid (long) value", zzc4.zze);
                    }
                    zzak zza5 = zze().zza(zzn2.zza, "_s");
                    if (zza5 != null) {
                        j2 = zza5.zzc;
                        this.zzj.zzr().zzx().zza("Backfill the session number. Last used session number", Long.valueOf(j2));
                    }
                    zza(new zzkr("_sno", j, Long.valueOf(j2 + 1), str2), zzn2);
                }
                zzkt zzkt = new zzkt(zzn2.zza, zzkr.zze, zzkr.zza, zzkr.zzb, zzc3);
                this.zzj.zzr().zzx().zza("Setting user property", this.zzj.zzj().zzc(zzkt.zzc), zzc3);
                zze().zzf();
                try {
                    zzc(zzn2);
                    boolean zza6 = zze().zza(zzkt);
                    zze().mo24208b_();
                    if (!zza6) {
                        this.zzj.zzr().zzf().zza("Too many unique user properties are set. Ignoring user property", this.zzj.zzj().zzc(zzkt.zzc), zzkt.zze);
                        this.zzj.zzi().zza(zzn2.zza, 9, (String) null, (String) null, 0);
                    }
                } finally {
                    zze().zzh();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    @VisibleForTesting
    public final void zza(zzn zzn2) {
        if (this.zzv != null) {
            ArrayList arrayList = new ArrayList();
            this.zzw = arrayList;
            arrayList.addAll(this.zzv);
        }
        zzad zze2 = zze();
        String str = zzn2.zza;
        Preconditions.checkNotEmpty(str);
        zze2.zzd();
        zze2.zzak();
        try {
            SQLiteDatabase c_ = zze2.mo24209c_();
            String[] strArr = {str};
            int delete = c_.delete("apps", "app_id=?", strArr) + 0 + c_.delete("events", "app_id=?", strArr) + c_.delete("user_attributes", "app_id=?", strArr) + c_.delete("conditional_properties", "app_id=?", strArr) + c_.delete("raw_events", "app_id=?", strArr) + c_.delete("raw_events_metadata", "app_id=?", strArr) + c_.delete("queue", "app_id=?", strArr) + c_.delete("audience_filter_values", "app_id=?", strArr) + c_.delete("main_event_params", "app_id=?", strArr) + c_.delete("default_event_params", "app_id=?", strArr);
            if (delete > 0) {
                zze2.zzr().zzx().zza("Reset analytics data. app, records", str, Integer.valueOf(delete));
            }
        } catch (SQLiteException e) {
            zze2.zzr().zzf().zza("Error resetting analytics data. appId, error", zzez.zza(str), e);
        }
        if (zzn2.zzh) {
            zzb(zzn2);
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zza(zzw zzw2) {
        zzn zza2 = zza(zzw2.zza);
        if (zza2 != null) {
            zza(zzw2, zza2);
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zza(zzw zzw2, zzn zzn2) {
        zzfb zzf2;
        String str;
        Object zza2;
        String zzc2;
        Object zza3;
        zzfb zzf3;
        String str2;
        Object zza4;
        String zzc3;
        Object obj;
        Preconditions.checkNotNull(zzw2);
        Preconditions.checkNotEmpty(zzw2.zza);
        Preconditions.checkNotNull(zzw2.zzb);
        Preconditions.checkNotNull(zzw2.zzc);
        Preconditions.checkNotEmpty(zzw2.zzc.zza);
        zzw();
        zzk();
        if (zze(zzn2)) {
            if (!zzn2.zzh) {
                zzc(zzn2);
                return;
            }
            zzw zzw3 = new zzw(zzw2);
            boolean z = false;
            zzw3.zze = false;
            zze().zzf();
            try {
                zzw zzd2 = zze().zzd(zzw3.zza, zzw3.zzc.zza);
                if (zzd2 != null && !zzd2.zzb.equals(zzw3.zzb)) {
                    this.zzj.zzr().zzi().zza("Updating a conditional user property with different origin. name, origin, origin (from DB)", this.zzj.zzj().zzc(zzw3.zzc.zza), zzw3.zzb, zzd2.zzb);
                }
                if (zzd2 != null && zzd2.zze) {
                    zzw3.zzb = zzd2.zzb;
                    zzw3.zzd = zzd2.zzd;
                    zzw3.zzh = zzd2.zzh;
                    zzw3.zzf = zzd2.zzf;
                    zzw3.zzi = zzd2.zzi;
                    zzw3.zze = zzd2.zze;
                    zzw3.zzc = new zzkr(zzw3.zzc.zza, zzd2.zzc.zzb, zzw3.zzc.zza(), zzd2.zzc.zze);
                } else if (TextUtils.isEmpty(zzw3.zzf)) {
                    zzw3.zzc = new zzkr(zzw3.zzc.zza, zzw3.zzd, zzw3.zzc.zza(), zzw3.zzc.zze);
                    zzw3.zze = true;
                    z = true;
                }
                if (zzw3.zze) {
                    zzkr zzkr = zzw3.zzc;
                    zzkt zzkt = new zzkt(zzw3.zza, zzw3.zzb, zzkr.zza, zzkr.zzb, zzkr.zza());
                    if (zze().zza(zzkt)) {
                        zzf3 = this.zzj.zzr().zzw();
                        str2 = "User property updated immediately";
                        zza4 = zzw3.zza;
                        zzc3 = this.zzj.zzj().zzc(zzkt.zzc);
                        obj = zzkt.zze;
                    } else {
                        zzf3 = this.zzj.zzr().zzf();
                        str2 = "(2)Too many active user properties, ignoring";
                        zza4 = zzez.zza(zzw3.zza);
                        zzc3 = this.zzj.zzj().zzc(zzkt.zzc);
                        obj = zzkt.zze;
                    }
                    zzf3.zza(str2, zza4, zzc3, obj);
                    if (z && zzw3.zzi != null) {
                        zzc(new zzao(zzw3.zzi, zzw3.zzd), zzn2);
                    }
                }
                if (zze().zza(zzw3)) {
                    zzf2 = this.zzj.zzr().zzw();
                    str = "Conditional property added";
                    zza2 = zzw3.zza;
                    zzc2 = this.zzj.zzj().zzc(zzw3.zzc.zza);
                    zza3 = zzw3.zzc.zza();
                } else {
                    zzf2 = this.zzj.zzr().zzf();
                    str = "Too many conditional properties, ignoring";
                    zza2 = zzez.zza(zzw3.zza);
                    zzc2 = this.zzj.zzj().zzc(zzw3.zzc.zza);
                    zza3 = zzw3.zzc.zza();
                }
                zzf2.zza(str, zza2, zzc2, zza3);
                zze().mo24208b_();
            } finally {
                zze().zzh();
            }
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zza(Runnable runnable) {
        zzw();
        if (this.zzn == null) {
            this.zzn = new ArrayList();
        }
        this.zzn.add(runnable);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0132 A[Catch:{ all -> 0x0179, all -> 0x0182 }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0142 A[Catch:{ all -> 0x0179, all -> 0x0182 }] */
    @androidx.annotation.WorkerThread
    @com.google.android.gms.common.util.VisibleForTesting
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(java.lang.String r7, int r8, java.lang.Throwable r9, byte[] r10, java.util.Map<java.lang.String, java.util.List<java.lang.String>> r11) {
        /*
            r6 = this;
            r6.zzw()
            r6.zzk()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r7)
            r0 = 0
            if (r10 != 0) goto L_0x000e
            byte[] r10 = new byte[r0]     // Catch:{ all -> 0x0182 }
        L_0x000e:
            com.google.android.gms.measurement.internal.zzgd r1 = r6.zzj     // Catch:{ all -> 0x0182 }
            com.google.android.gms.measurement.internal.zzez r1 = r1.zzr()     // Catch:{ all -> 0x0182 }
            com.google.android.gms.measurement.internal.zzfb r1 = r1.zzx()     // Catch:{ all -> 0x0182 }
            java.lang.String r2 = "onConfigFetched. Response size"
            int r3 = r10.length     // Catch:{ all -> 0x0182 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0182 }
            r1.zza(r2, r3)     // Catch:{ all -> 0x0182 }
            com.google.android.gms.measurement.internal.zzad r1 = r6.zze()     // Catch:{ all -> 0x0182 }
            r1.zzf()     // Catch:{ all -> 0x0182 }
            com.google.android.gms.measurement.internal.zzad r1 = r6.zze()     // Catch:{ all -> 0x0179 }
            com.google.android.gms.measurement.internal.zzf r1 = r1.zzb(r7)     // Catch:{ all -> 0x0179 }
            r2 = 200(0xc8, float:2.8E-43)
            r3 = 304(0x130, float:4.26E-43)
            r4 = 1
            if (r8 == r2) goto L_0x003e
            r2 = 204(0xcc, float:2.86E-43)
            if (r8 == r2) goto L_0x003e
            if (r8 != r3) goto L_0x0042
        L_0x003e:
            if (r9 != 0) goto L_0x0042
            r2 = 1
            goto L_0x0043
        L_0x0042:
            r2 = 0
        L_0x0043:
            if (r1 != 0) goto L_0x005a
            com.google.android.gms.measurement.internal.zzgd r8 = r6.zzj     // Catch:{ all -> 0x0179 }
            com.google.android.gms.measurement.internal.zzez r8 = r8.zzr()     // Catch:{ all -> 0x0179 }
            com.google.android.gms.measurement.internal.zzfb r8 = r8.zzi()     // Catch:{ all -> 0x0179 }
            java.lang.String r9 = "App does not exist in onConfigFetched. appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzez.zza((java.lang.String) r7)     // Catch:{ all -> 0x0179 }
            r8.zza(r9, r7)     // Catch:{ all -> 0x0179 }
            goto L_0x016d
        L_0x005a:
            r5 = 404(0x194, float:5.66E-43)
            if (r2 != 0) goto L_0x00ca
            if (r8 != r5) goto L_0x0061
            goto L_0x00ca
        L_0x0061:
            com.google.android.gms.measurement.internal.zzgd r10 = r6.zzj     // Catch:{ all -> 0x0179 }
            com.google.android.gms.common.util.Clock r10 = r10.zzm()     // Catch:{ all -> 0x0179 }
            long r10 = r10.currentTimeMillis()     // Catch:{ all -> 0x0179 }
            r1.zzi((long) r10)     // Catch:{ all -> 0x0179 }
            com.google.android.gms.measurement.internal.zzad r10 = r6.zze()     // Catch:{ all -> 0x0179 }
            r10.zza((com.google.android.gms.measurement.internal.zzf) r1)     // Catch:{ all -> 0x0179 }
            com.google.android.gms.measurement.internal.zzgd r10 = r6.zzj     // Catch:{ all -> 0x0179 }
            com.google.android.gms.measurement.internal.zzez r10 = r10.zzr()     // Catch:{ all -> 0x0179 }
            com.google.android.gms.measurement.internal.zzfb r10 = r10.zzx()     // Catch:{ all -> 0x0179 }
            java.lang.String r11 = "Fetching config failed. code, error"
            java.lang.Integer r1 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x0179 }
            r10.zza(r11, r1, r9)     // Catch:{ all -> 0x0179 }
            com.google.android.gms.measurement.internal.zzfx r9 = r6.zzc()     // Catch:{ all -> 0x0179 }
            r9.zzc(r7)     // Catch:{ all -> 0x0179 }
            com.google.android.gms.measurement.internal.zzgd r7 = r6.zzj     // Catch:{ all -> 0x0179 }
            com.google.android.gms.measurement.internal.zzfl r7 = r7.zzc()     // Catch:{ all -> 0x0179 }
            com.google.android.gms.measurement.internal.zzfp r7 = r7.zzd     // Catch:{ all -> 0x0179 }
            com.google.android.gms.measurement.internal.zzgd r9 = r6.zzj     // Catch:{ all -> 0x0179 }
            com.google.android.gms.common.util.Clock r9 = r9.zzm()     // Catch:{ all -> 0x0179 }
            long r9 = r9.currentTimeMillis()     // Catch:{ all -> 0x0179 }
            r7.zza(r9)     // Catch:{ all -> 0x0179 }
            r7 = 503(0x1f7, float:7.05E-43)
            if (r8 == r7) goto L_0x00ae
            r7 = 429(0x1ad, float:6.01E-43)
            if (r8 != r7) goto L_0x00ad
            goto L_0x00ae
        L_0x00ad:
            r4 = 0
        L_0x00ae:
            if (r4 == 0) goto L_0x00c5
            com.google.android.gms.measurement.internal.zzgd r7 = r6.zzj     // Catch:{ all -> 0x0179 }
            com.google.android.gms.measurement.internal.zzfl r7 = r7.zzc()     // Catch:{ all -> 0x0179 }
            com.google.android.gms.measurement.internal.zzfp r7 = r7.zze     // Catch:{ all -> 0x0179 }
            com.google.android.gms.measurement.internal.zzgd r8 = r6.zzj     // Catch:{ all -> 0x0179 }
            com.google.android.gms.common.util.Clock r8 = r8.zzm()     // Catch:{ all -> 0x0179 }
            long r8 = r8.currentTimeMillis()     // Catch:{ all -> 0x0179 }
            r7.zza(r8)     // Catch:{ all -> 0x0179 }
        L_0x00c5:
            r6.zzz()     // Catch:{ all -> 0x0179 }
            goto L_0x016d
        L_0x00ca:
            r9 = 0
            if (r11 == 0) goto L_0x00d6
            java.lang.String r2 = "Last-Modified"
            java.lang.Object r11 = r11.get(r2)     // Catch:{ all -> 0x0179 }
            java.util.List r11 = (java.util.List) r11     // Catch:{ all -> 0x0179 }
            goto L_0x00d7
        L_0x00d6:
            r11 = r9
        L_0x00d7:
            if (r11 == 0) goto L_0x00e6
            int r2 = r11.size()     // Catch:{ all -> 0x0179 }
            if (r2 <= 0) goto L_0x00e6
            java.lang.Object r11 = r11.get(r0)     // Catch:{ all -> 0x0179 }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ all -> 0x0179 }
            goto L_0x00e7
        L_0x00e6:
            r11 = r9
        L_0x00e7:
            if (r8 == r5) goto L_0x0103
            if (r8 != r3) goto L_0x00ec
            goto L_0x0103
        L_0x00ec:
            com.google.android.gms.measurement.internal.zzfx r9 = r6.zzc()     // Catch:{ all -> 0x0179 }
            boolean r9 = r9.zza(r7, r10, r11)     // Catch:{ all -> 0x0179 }
            if (r9 != 0) goto L_0x011c
            com.google.android.gms.measurement.internal.zzad r7 = r6.zze()     // Catch:{ all -> 0x0182 }
        L_0x00fa:
            r7.zzh()     // Catch:{ all -> 0x0182 }
            r6.zzq = r0
            r6.zzaa()
            return
        L_0x0103:
            com.google.android.gms.measurement.internal.zzfx r11 = r6.zzc()     // Catch:{ all -> 0x0179 }
            com.google.android.gms.internal.measurement.zzca$zzb r11 = r11.zza((java.lang.String) r7)     // Catch:{ all -> 0x0179 }
            if (r11 != 0) goto L_0x011c
            com.google.android.gms.measurement.internal.zzfx r11 = r6.zzc()     // Catch:{ all -> 0x0179 }
            boolean r9 = r11.zza(r7, r9, r9)     // Catch:{ all -> 0x0179 }
            if (r9 != 0) goto L_0x011c
            com.google.android.gms.measurement.internal.zzad r7 = r6.zze()     // Catch:{ all -> 0x0182 }
            goto L_0x00fa
        L_0x011c:
            com.google.android.gms.measurement.internal.zzgd r9 = r6.zzj     // Catch:{ all -> 0x0179 }
            com.google.android.gms.common.util.Clock r9 = r9.zzm()     // Catch:{ all -> 0x0179 }
            long r2 = r9.currentTimeMillis()     // Catch:{ all -> 0x0179 }
            r1.zzh((long) r2)     // Catch:{ all -> 0x0179 }
            com.google.android.gms.measurement.internal.zzad r9 = r6.zze()     // Catch:{ all -> 0x0179 }
            r9.zza((com.google.android.gms.measurement.internal.zzf) r1)     // Catch:{ all -> 0x0179 }
            if (r8 != r5) goto L_0x0142
            com.google.android.gms.measurement.internal.zzgd r8 = r6.zzj     // Catch:{ all -> 0x0179 }
            com.google.android.gms.measurement.internal.zzez r8 = r8.zzr()     // Catch:{ all -> 0x0179 }
            com.google.android.gms.measurement.internal.zzfb r8 = r8.zzk()     // Catch:{ all -> 0x0179 }
            java.lang.String r9 = "Config not found. Using empty config. appId"
            r8.zza(r9, r7)     // Catch:{ all -> 0x0179 }
            goto L_0x015a
        L_0x0142:
            com.google.android.gms.measurement.internal.zzgd r7 = r6.zzj     // Catch:{ all -> 0x0179 }
            com.google.android.gms.measurement.internal.zzez r7 = r7.zzr()     // Catch:{ all -> 0x0179 }
            com.google.android.gms.measurement.internal.zzfb r7 = r7.zzx()     // Catch:{ all -> 0x0179 }
            java.lang.String r9 = "Successfully fetched config. Got network response. code, size"
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x0179 }
            int r10 = r10.length     // Catch:{ all -> 0x0179 }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x0179 }
            r7.zza(r9, r8, r10)     // Catch:{ all -> 0x0179 }
        L_0x015a:
            com.google.android.gms.measurement.internal.zzfc r7 = r6.zzd()     // Catch:{ all -> 0x0179 }
            boolean r7 = r7.zzf()     // Catch:{ all -> 0x0179 }
            if (r7 == 0) goto L_0x00c5
            boolean r7 = r6.zzy()     // Catch:{ all -> 0x0179 }
            if (r7 == 0) goto L_0x00c5
            r6.zzl()     // Catch:{ all -> 0x0179 }
        L_0x016d:
            com.google.android.gms.measurement.internal.zzad r7 = r6.zze()     // Catch:{ all -> 0x0179 }
            r7.mo24208b_()     // Catch:{ all -> 0x0179 }
            com.google.android.gms.measurement.internal.zzad r7 = r6.zze()     // Catch:{ all -> 0x0182 }
            goto L_0x00fa
        L_0x0179:
            r7 = move-exception
            com.google.android.gms.measurement.internal.zzad r8 = r6.zze()     // Catch:{ all -> 0x0182 }
            r8.zzh()     // Catch:{ all -> 0x0182 }
            throw r7     // Catch:{ all -> 0x0182 }
        L_0x0182:
            r7 = move-exception
            r6.zzq = r0
            r6.zzaa()
            goto L_0x018a
        L_0x0189:
            throw r7
        L_0x018a:
            goto L_0x0189
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkk.zza(java.lang.String, int, java.lang.Throwable, byte[], java.util.Map):void");
    }

    /* access modifiers changed from: package-private */
    public final void zza(boolean z) {
        zzz();
    }

    public final zzy zzb() {
        return this.zzj.zzb();
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zzb(zzkr zzkr, zzn zzn2) {
        zzw();
        zzk();
        if (zze(zzn2)) {
            if (!zzn2.zzh) {
                zzc(zzn2);
            } else if (!"_npa".equals(zzkr.zza) || zzn2.zzs == null) {
                this.zzj.zzr().zzw().zza("Removing user property", this.zzj.zzj().zzc(zzkr.zza));
                zze().zzf();
                try {
                    zzc(zzn2);
                    zze().zzb(zzn2.zza, zzkr.zza);
                    zze().mo24208b_();
                    this.zzj.zzr().zzw().zza("User property removed", this.zzj.zzj().zzc(zzkr.zza));
                } finally {
                    zze().zzh();
                }
            } else {
                this.zzj.zzr().zzw().zza("Falling back to manifest metadata value for ad personalization");
                zza(new zzkr("_npa", this.zzj.zzm().currentTimeMillis(), Long.valueOf(zzn2.zzs.booleanValue() ? 1 : 0), "auto"), zzn2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x044e A[Catch:{ SQLiteException -> 0x01b6, all -> 0x04ae }] */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x0484 A[Catch:{ SQLiteException -> 0x01b6, all -> 0x04ae }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x011b A[Catch:{ SQLiteException -> 0x01b6, all -> 0x04ae }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x01cb A[Catch:{ SQLiteException -> 0x01b6, all -> 0x04ae }] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x01ff A[Catch:{ SQLiteException -> 0x01b6, all -> 0x04ae }] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0201 A[Catch:{ SQLiteException -> 0x01b6, all -> 0x04ae }] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0205 A[Catch:{ SQLiteException -> 0x01b6, all -> 0x04ae }] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0228 A[Catch:{ SQLiteException -> 0x01b6, all -> 0x04ae }] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x022e A[Catch:{ SQLiteException -> 0x01b6, all -> 0x04ae }] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x023b A[Catch:{ SQLiteException -> 0x01b6, all -> 0x04ae }] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x024a A[Catch:{ SQLiteException -> 0x01b6, all -> 0x04ae }] */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzb(com.google.android.gms.measurement.internal.zzn r22) {
        /*
            r21 = this;
            r1 = r21
            r2 = r22
            java.lang.String r3 = "_sysu"
            java.lang.String r4 = "_sys"
            java.lang.String r5 = "_pfo"
            java.lang.String r6 = "_uwa"
            java.lang.String r0 = "app_id=?"
            r21.zzw()
            r21.zzk()
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r22)
            java.lang.String r7 = r2.zza
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r7)
            boolean r7 = r21.zze(r22)
            if (r7 != 0) goto L_0x0023
            return
        L_0x0023:
            com.google.android.gms.measurement.internal.zzad r7 = r21.zze()
            java.lang.String r8 = r2.zza
            com.google.android.gms.measurement.internal.zzf r7 = r7.zzb(r8)
            r8 = 0
            if (r7 == 0) goto L_0x0056
            java.lang.String r10 = r7.zze()
            boolean r10 = android.text.TextUtils.isEmpty(r10)
            if (r10 == 0) goto L_0x0056
            java.lang.String r10 = r2.zzb
            boolean r10 = android.text.TextUtils.isEmpty(r10)
            if (r10 != 0) goto L_0x0056
            r7.zzh((long) r8)
            com.google.android.gms.measurement.internal.zzad r10 = r21.zze()
            r10.zza((com.google.android.gms.measurement.internal.zzf) r7)
            com.google.android.gms.measurement.internal.zzfx r7 = r21.zzc()
            java.lang.String r10 = r2.zza
            r7.zzd(r10)
        L_0x0056:
            boolean r7 = r2.zzh
            if (r7 != 0) goto L_0x005e
            r21.zzc(r22)
            return
        L_0x005e:
            long r10 = r2.zzm
            int r7 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            if (r7 != 0) goto L_0x006e
            com.google.android.gms.measurement.internal.zzgd r7 = r1.zzj
            com.google.android.gms.common.util.Clock r7 = r7.zzm()
            long r10 = r7.currentTimeMillis()
        L_0x006e:
            com.google.android.gms.measurement.internal.zzgd r7 = r1.zzj
            com.google.android.gms.measurement.internal.zzai r7 = r7.zzx()
            r7.zzi()
            int r7 = r2.zzn
            r15 = 1
            if (r7 == 0) goto L_0x0098
            if (r7 == r15) goto L_0x0098
            com.google.android.gms.measurement.internal.zzgd r12 = r1.zzj
            com.google.android.gms.measurement.internal.zzez r12 = r12.zzr()
            com.google.android.gms.measurement.internal.zzfb r12 = r12.zzi()
            java.lang.String r13 = r2.zza
            java.lang.Object r13 = com.google.android.gms.measurement.internal.zzez.zza((java.lang.String) r13)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            java.lang.String r14 = "Incorrect app type, assuming installed app. appId, appType"
            r12.zza(r14, r13, r7)
            r7 = 0
        L_0x0098:
            com.google.android.gms.measurement.internal.zzad r12 = r21.zze()
            r12.zzf()
            com.google.android.gms.measurement.internal.zzad r12 = r21.zze()     // Catch:{ all -> 0x04ae }
            java.lang.String r13 = r2.zza     // Catch:{ all -> 0x04ae }
            java.lang.String r14 = "_npa"
            com.google.android.gms.measurement.internal.zzkt r14 = r12.zzc(r13, r14)     // Catch:{ all -> 0x04ae }
            if (r14 == 0) goto L_0x00bc
            java.lang.String r12 = "auto"
            java.lang.String r13 = r14.zzb     // Catch:{ all -> 0x04ae }
            boolean r12 = r12.equals(r13)     // Catch:{ all -> 0x04ae }
            if (r12 == 0) goto L_0x00b8
            goto L_0x00bc
        L_0x00b8:
            r18 = r3
            r3 = 1
            goto L_0x010f
        L_0x00bc:
            java.lang.Boolean r12 = r2.zzs     // Catch:{ all -> 0x04ae }
            if (r12 == 0) goto L_0x00f9
            com.google.android.gms.measurement.internal.zzkr r13 = new com.google.android.gms.measurement.internal.zzkr     // Catch:{ all -> 0x04ae }
            java.lang.String r18 = "_npa"
            java.lang.Boolean r12 = r2.zzs     // Catch:{ all -> 0x04ae }
            boolean r12 = r12.booleanValue()     // Catch:{ all -> 0x04ae }
            if (r12 == 0) goto L_0x00cf
            r19 = 1
            goto L_0x00d1
        L_0x00cf:
            r19 = r8
        L_0x00d1:
            java.lang.Long r19 = java.lang.Long.valueOf(r19)     // Catch:{ all -> 0x04ae }
            java.lang.String r20 = "auto"
            r8 = 1
            r12 = r13
            r8 = r13
            r13 = r18
            r18 = r3
            r9 = r14
            r3 = 1
            r14 = r10
            r16 = r19
            r17 = r20
            r12.<init>(r13, r14, r16, r17)     // Catch:{ all -> 0x04ae }
            if (r9 == 0) goto L_0x00f5
            java.lang.Object r9 = r9.zze     // Catch:{ all -> 0x04ae }
            java.lang.Long r12 = r8.zzc     // Catch:{ all -> 0x04ae }
            boolean r9 = r9.equals(r12)     // Catch:{ all -> 0x04ae }
            if (r9 != 0) goto L_0x010f
        L_0x00f5:
            r1.zza((com.google.android.gms.measurement.internal.zzkr) r8, (com.google.android.gms.measurement.internal.zzn) r2)     // Catch:{ all -> 0x04ae }
            goto L_0x010f
        L_0x00f9:
            r18 = r3
            r9 = r14
            r3 = 1
            if (r9 == 0) goto L_0x010f
            com.google.android.gms.measurement.internal.zzkr r8 = new com.google.android.gms.measurement.internal.zzkr     // Catch:{ all -> 0x04ae }
            java.lang.String r13 = "_npa"
            r16 = 0
            java.lang.String r17 = "auto"
            r12 = r8
            r14 = r10
            r12.<init>(r13, r14, r16, r17)     // Catch:{ all -> 0x04ae }
            r1.zzb((com.google.android.gms.measurement.internal.zzkr) r8, (com.google.android.gms.measurement.internal.zzn) r2)     // Catch:{ all -> 0x04ae }
        L_0x010f:
            com.google.android.gms.measurement.internal.zzad r8 = r21.zze()     // Catch:{ all -> 0x04ae }
            java.lang.String r9 = r2.zza     // Catch:{ all -> 0x04ae }
            com.google.android.gms.measurement.internal.zzf r8 = r8.zzb(r9)     // Catch:{ all -> 0x04ae }
            if (r8 == 0) goto L_0x01c9
            com.google.android.gms.measurement.internal.zzgd r12 = r1.zzj     // Catch:{ all -> 0x04ae }
            r12.zzi()     // Catch:{ all -> 0x04ae }
            java.lang.String r12 = r2.zzb     // Catch:{ all -> 0x04ae }
            java.lang.String r13 = r8.zze()     // Catch:{ all -> 0x04ae }
            java.lang.String r14 = r2.zzr     // Catch:{ all -> 0x04ae }
            java.lang.String r15 = r8.zzf()     // Catch:{ all -> 0x04ae }
            boolean r12 = com.google.android.gms.measurement.internal.zzkw.zza((java.lang.String) r12, (java.lang.String) r13, (java.lang.String) r14, (java.lang.String) r15)     // Catch:{ all -> 0x04ae }
            if (r12 == 0) goto L_0x01c9
            com.google.android.gms.measurement.internal.zzgd r12 = r1.zzj     // Catch:{ all -> 0x04ae }
            com.google.android.gms.measurement.internal.zzez r12 = r12.zzr()     // Catch:{ all -> 0x04ae }
            com.google.android.gms.measurement.internal.zzfb r12 = r12.zzi()     // Catch:{ all -> 0x04ae }
            java.lang.String r13 = "New GMP App Id passed in. Removing cached database data. appId"
            java.lang.String r14 = r8.zzc()     // Catch:{ all -> 0x04ae }
            java.lang.Object r14 = com.google.android.gms.measurement.internal.zzez.zza((java.lang.String) r14)     // Catch:{ all -> 0x04ae }
            r12.zza(r13, r14)     // Catch:{ all -> 0x04ae }
            com.google.android.gms.measurement.internal.zzad r12 = r21.zze()     // Catch:{ all -> 0x04ae }
            java.lang.String r8 = r8.zzc()     // Catch:{ all -> 0x04ae }
            r12.zzak()     // Catch:{ all -> 0x04ae }
            r12.zzd()     // Catch:{ all -> 0x04ae }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r8)     // Catch:{ all -> 0x04ae }
            android.database.sqlite.SQLiteDatabase r13 = r12.mo24209c_()     // Catch:{ SQLiteException -> 0x01b6 }
            java.lang.String[] r14 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x01b6 }
            r15 = 0
            r14[r15] = r8     // Catch:{ SQLiteException -> 0x01b6 }
            java.lang.String r9 = "events"
            int r9 = r13.delete(r9, r0, r14)     // Catch:{ SQLiteException -> 0x01b6 }
            int r9 = r9 + r15
            java.lang.String r15 = "user_attributes"
            int r15 = r13.delete(r15, r0, r14)     // Catch:{ SQLiteException -> 0x01b6 }
            int r9 = r9 + r15
            java.lang.String r15 = "conditional_properties"
            int r15 = r13.delete(r15, r0, r14)     // Catch:{ SQLiteException -> 0x01b6 }
            int r9 = r9 + r15
            java.lang.String r15 = "apps"
            int r15 = r13.delete(r15, r0, r14)     // Catch:{ SQLiteException -> 0x01b6 }
            int r9 = r9 + r15
            java.lang.String r15 = "raw_events"
            int r15 = r13.delete(r15, r0, r14)     // Catch:{ SQLiteException -> 0x01b6 }
            int r9 = r9 + r15
            java.lang.String r15 = "raw_events_metadata"
            int r15 = r13.delete(r15, r0, r14)     // Catch:{ SQLiteException -> 0x01b6 }
            int r9 = r9 + r15
            java.lang.String r15 = "event_filters"
            int r15 = r13.delete(r15, r0, r14)     // Catch:{ SQLiteException -> 0x01b6 }
            int r9 = r9 + r15
            java.lang.String r15 = "property_filters"
            int r15 = r13.delete(r15, r0, r14)     // Catch:{ SQLiteException -> 0x01b6 }
            int r9 = r9 + r15
            java.lang.String r15 = "audience_filter_values"
            int r0 = r13.delete(r15, r0, r14)     // Catch:{ SQLiteException -> 0x01b6 }
            int r9 = r9 + r0
            if (r9 <= 0) goto L_0x01c8
            com.google.android.gms.measurement.internal.zzez r0 = r12.zzr()     // Catch:{ SQLiteException -> 0x01b6 }
            com.google.android.gms.measurement.internal.zzfb r0 = r0.zzx()     // Catch:{ SQLiteException -> 0x01b6 }
            java.lang.String r13 = "Deleted application data. app, records"
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ SQLiteException -> 0x01b6 }
            r0.zza(r13, r8, r9)     // Catch:{ SQLiteException -> 0x01b6 }
            goto L_0x01c8
        L_0x01b6:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzez r9 = r12.zzr()     // Catch:{ all -> 0x04ae }
            com.google.android.gms.measurement.internal.zzfb r9 = r9.zzf()     // Catch:{ all -> 0x04ae }
            java.lang.String r12 = "Error deleting application data. appId, error"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzez.zza((java.lang.String) r8)     // Catch:{ all -> 0x04ae }
            r9.zza(r12, r8, r0)     // Catch:{ all -> 0x04ae }
        L_0x01c8:
            r8 = 0
        L_0x01c9:
            if (r8 == 0) goto L_0x0228
            long r12 = r8.zzm()     // Catch:{ all -> 0x04ae }
            r14 = -2147483648(0xffffffff80000000, double:NaN)
            int r0 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r0 == 0) goto L_0x01e3
            long r12 = r8.zzm()     // Catch:{ all -> 0x04ae }
            r9 = r4
            long r3 = r2.zzj     // Catch:{ all -> 0x04ae }
            int r0 = (r12 > r3 ? 1 : (r12 == r3 ? 0 : -1))
            if (r0 == 0) goto L_0x01e4
            r0 = 1
            goto L_0x01e5
        L_0x01e3:
            r9 = r4
        L_0x01e4:
            r0 = 0
        L_0x01e5:
            long r3 = r8.zzm()     // Catch:{ all -> 0x04ae }
            int r12 = (r3 > r14 ? 1 : (r3 == r14 ? 0 : -1))
            if (r12 != 0) goto L_0x0201
            java.lang.String r3 = r8.zzl()     // Catch:{ all -> 0x04ae }
            if (r3 == 0) goto L_0x0201
            java.lang.String r3 = r8.zzl()     // Catch:{ all -> 0x04ae }
            java.lang.String r4 = r2.zzc     // Catch:{ all -> 0x04ae }
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x04ae }
            if (r3 != 0) goto L_0x0201
            r14 = 1
            goto L_0x0202
        L_0x0201:
            r14 = 0
        L_0x0202:
            r0 = r0 | r14
            if (r0 == 0) goto L_0x0229
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ all -> 0x04ae }
            r0.<init>()     // Catch:{ all -> 0x04ae }
            java.lang.String r3 = "_pv"
            java.lang.String r4 = r8.zzl()     // Catch:{ all -> 0x04ae }
            r0.putString(r3, r4)     // Catch:{ all -> 0x04ae }
            com.google.android.gms.measurement.internal.zzao r3 = new com.google.android.gms.measurement.internal.zzao     // Catch:{ all -> 0x04ae }
            java.lang.String r13 = "_au"
            com.google.android.gms.measurement.internal.zzan r14 = new com.google.android.gms.measurement.internal.zzan     // Catch:{ all -> 0x04ae }
            r14.<init>(r0)     // Catch:{ all -> 0x04ae }
            java.lang.String r15 = "auto"
            r12 = r3
            r16 = r10
            r12.<init>(r13, r14, r15, r16)     // Catch:{ all -> 0x04ae }
            r1.zza((com.google.android.gms.measurement.internal.zzao) r3, (com.google.android.gms.measurement.internal.zzn) r2)     // Catch:{ all -> 0x04ae }
            goto L_0x0229
        L_0x0228:
            r9 = r4
        L_0x0229:
            r21.zzc(r22)     // Catch:{ all -> 0x04ae }
            if (r7 != 0) goto L_0x023b
            com.google.android.gms.measurement.internal.zzad r0 = r21.zze()     // Catch:{ all -> 0x04ae }
            java.lang.String r3 = r2.zza     // Catch:{ all -> 0x04ae }
            java.lang.String r4 = "_f"
        L_0x0236:
            com.google.android.gms.measurement.internal.zzak r0 = r0.zza((java.lang.String) r3, (java.lang.String) r4)     // Catch:{ all -> 0x04ae }
            goto L_0x0248
        L_0x023b:
            r3 = 1
            if (r7 != r3) goto L_0x0247
            com.google.android.gms.measurement.internal.zzad r0 = r21.zze()     // Catch:{ all -> 0x04ae }
            java.lang.String r3 = r2.zza     // Catch:{ all -> 0x04ae }
            java.lang.String r4 = "_v"
            goto L_0x0236
        L_0x0247:
            r0 = 0
        L_0x0248:
            if (r0 != 0) goto L_0x0484
            r3 = 3600000(0x36ee80, double:1.7786363E-317)
            long r12 = r10 / r3
            r14 = 1
            long r12 = r12 + r14
            long r12 = r12 * r3
            java.lang.String r0 = "_dac"
            java.lang.String r3 = "_r"
            java.lang.String r4 = "_c"
            java.lang.String r8 = "_et"
            if (r7 != 0) goto L_0x03e4
            com.google.android.gms.measurement.internal.zzkr r7 = new com.google.android.gms.measurement.internal.zzkr     // Catch:{ all -> 0x04ae }
            java.lang.String r14 = "_fot"
            java.lang.Long r16 = java.lang.Long.valueOf(r12)     // Catch:{ all -> 0x04ae }
            java.lang.String r17 = "auto"
            r12 = r7
            r13 = r14
            r14 = r10
            r12.<init>(r13, r14, r16, r17)     // Catch:{ all -> 0x04ae }
            r1.zza((com.google.android.gms.measurement.internal.zzkr) r7, (com.google.android.gms.measurement.internal.zzn) r2)     // Catch:{ all -> 0x04ae }
            com.google.android.gms.measurement.internal.zzgd r7 = r1.zzj     // Catch:{ all -> 0x04ae }
            com.google.android.gms.measurement.internal.zzy r7 = r7.zzb()     // Catch:{ all -> 0x04ae }
            java.lang.String r12 = r2.zzb     // Catch:{ all -> 0x04ae }
            com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean> r13 = com.google.android.gms.measurement.internal.zzaq.zzar     // Catch:{ all -> 0x04ae }
            boolean r7 = r7.zze(r12, r13)     // Catch:{ all -> 0x04ae }
            if (r7 == 0) goto L_0x028f
            r21.zzw()     // Catch:{ all -> 0x04ae }
            com.google.android.gms.measurement.internal.zzgd r7 = r1.zzj     // Catch:{ all -> 0x04ae }
            com.google.android.gms.measurement.internal.zzfq r7 = r7.zzf()     // Catch:{ all -> 0x04ae }
            java.lang.String r12 = r2.zza     // Catch:{ all -> 0x04ae }
            r7.zza(r12)     // Catch:{ all -> 0x04ae }
        L_0x028f:
            r21.zzw()     // Catch:{ all -> 0x04ae }
            r21.zzk()     // Catch:{ all -> 0x04ae }
            android.os.Bundle r7 = new android.os.Bundle     // Catch:{ all -> 0x04ae }
            r7.<init>()     // Catch:{ all -> 0x04ae }
            r12 = 1
            r7.putLong(r4, r12)     // Catch:{ all -> 0x04ae }
            r7.putLong(r3, r12)     // Catch:{ all -> 0x04ae }
            r3 = 0
            r7.putLong(r6, r3)     // Catch:{ all -> 0x04ae }
            r7.putLong(r5, r3)     // Catch:{ all -> 0x04ae }
            r7.putLong(r9, r3)     // Catch:{ all -> 0x04ae }
            r14 = r18
            r7.putLong(r14, r3)     // Catch:{ all -> 0x04ae }
            com.google.android.gms.measurement.internal.zzgd r3 = r1.zzj     // Catch:{ all -> 0x04ae }
            com.google.android.gms.measurement.internal.zzy r3 = r3.zzb()     // Catch:{ all -> 0x04ae }
            java.lang.String r4 = r2.zza     // Catch:{ all -> 0x04ae }
            com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean> r12 = com.google.android.gms.measurement.internal.zzaq.zzat     // Catch:{ all -> 0x04ae }
            boolean r3 = r3.zze(r4, r12)     // Catch:{ all -> 0x04ae }
            if (r3 == 0) goto L_0x02c8
            r3 = 1
            r7.putLong(r8, r3)     // Catch:{ all -> 0x04ae }
            goto L_0x02ca
        L_0x02c8:
            r3 = 1
        L_0x02ca:
            boolean r12 = r2.zzq     // Catch:{ all -> 0x04ae }
            if (r12 == 0) goto L_0x02d1
            r7.putLong(r0, r3)     // Catch:{ all -> 0x04ae }
        L_0x02d1:
            com.google.android.gms.measurement.internal.zzad r0 = r21.zze()     // Catch:{ all -> 0x04ae }
            java.lang.String r3 = r2.zza     // Catch:{ all -> 0x04ae }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r3)     // Catch:{ all -> 0x04ae }
            r0.zzd()     // Catch:{ all -> 0x04ae }
            r0.zzak()     // Catch:{ all -> 0x04ae }
            java.lang.String r4 = "first_open_count"
            long r3 = r0.zzh(r3, r4)     // Catch:{ all -> 0x04ae }
            com.google.android.gms.measurement.internal.zzgd r0 = r1.zzj     // Catch:{ all -> 0x04ae }
            android.content.Context r0 = r0.zzn()     // Catch:{ all -> 0x04ae }
            android.content.pm.PackageManager r0 = r0.getPackageManager()     // Catch:{ all -> 0x04ae }
            if (r0 != 0) goto L_0x030b
            com.google.android.gms.measurement.internal.zzgd r0 = r1.zzj     // Catch:{ all -> 0x04ae }
            com.google.android.gms.measurement.internal.zzez r0 = r0.zzr()     // Catch:{ all -> 0x04ae }
            com.google.android.gms.measurement.internal.zzfb r0 = r0.zzf()     // Catch:{ all -> 0x04ae }
            java.lang.String r6 = "PackageManager is null, first open report might be inaccurate. appId"
            java.lang.String r9 = r2.zza     // Catch:{ all -> 0x04ae }
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzez.zza((java.lang.String) r9)     // Catch:{ all -> 0x04ae }
            r0.zza(r6, r9)     // Catch:{ all -> 0x04ae }
        L_0x0307:
            r12 = 0
            goto L_0x03c8
        L_0x030b:
            com.google.android.gms.measurement.internal.zzgd r0 = r1.zzj     // Catch:{ NameNotFoundException -> 0x031d }
            android.content.Context r0 = r0.zzn()     // Catch:{ NameNotFoundException -> 0x031d }
            com.google.android.gms.common.wrappers.PackageManagerWrapper r0 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r0)     // Catch:{ NameNotFoundException -> 0x031d }
            java.lang.String r12 = r2.zza     // Catch:{ NameNotFoundException -> 0x031d }
            r13 = 0
            android.content.pm.PackageInfo r0 = r0.getPackageInfo(r12, r13)     // Catch:{ NameNotFoundException -> 0x031d }
            goto L_0x0334
        L_0x031d:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzgd r12 = r1.zzj     // Catch:{ all -> 0x04ae }
            com.google.android.gms.measurement.internal.zzez r12 = r12.zzr()     // Catch:{ all -> 0x04ae }
            com.google.android.gms.measurement.internal.zzfb r12 = r12.zzf()     // Catch:{ all -> 0x04ae }
            java.lang.String r13 = "Package info is null, first open report might be inaccurate. appId"
            java.lang.String r15 = r2.zza     // Catch:{ all -> 0x04ae }
            java.lang.Object r15 = com.google.android.gms.measurement.internal.zzez.zza((java.lang.String) r15)     // Catch:{ all -> 0x04ae }
            r12.zza(r13, r15, r0)     // Catch:{ all -> 0x04ae }
            r0 = 0
        L_0x0334:
            if (r0 == 0) goto L_0x0384
            long r12 = r0.firstInstallTime     // Catch:{ all -> 0x04ae }
            r15 = 0
            int r17 = (r12 > r15 ? 1 : (r12 == r15 ? 0 : -1))
            if (r17 == 0) goto L_0x0384
            long r12 = r0.firstInstallTime     // Catch:{ all -> 0x04ae }
            r18 = r14
            long r14 = r0.lastUpdateTime     // Catch:{ all -> 0x04ae }
            int r0 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r0 == 0) goto L_0x0367
            com.google.android.gms.measurement.internal.zzgd r0 = r1.zzj     // Catch:{ all -> 0x04ae }
            com.google.android.gms.measurement.internal.zzy r0 = r0.zzb()     // Catch:{ all -> 0x04ae }
            com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean> r12 = com.google.android.gms.measurement.internal.zzaq.zzbs     // Catch:{ all -> 0x04ae }
            boolean r0 = r0.zza((com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean>) r12)     // Catch:{ all -> 0x04ae }
            if (r0 == 0) goto L_0x0362
            r12 = 0
            int r0 = (r3 > r12 ? 1 : (r3 == r12 ? 0 : -1))
            if (r0 != 0) goto L_0x0365
            r12 = 1
        L_0x035e:
            r7.putLong(r6, r12)     // Catch:{ all -> 0x04ae }
            goto L_0x0365
        L_0x0362:
            r12 = 1
            goto L_0x035e
        L_0x0365:
            r14 = 0
            goto L_0x0368
        L_0x0367:
            r14 = 1
        L_0x0368:
            com.google.android.gms.measurement.internal.zzkr r0 = new com.google.android.gms.measurement.internal.zzkr     // Catch:{ all -> 0x04ae }
            java.lang.String r13 = "_fi"
            if (r14 == 0) goto L_0x0371
            r14 = 1
            goto L_0x0373
        L_0x0371:
            r14 = 0
        L_0x0373:
            java.lang.Long r16 = java.lang.Long.valueOf(r14)     // Catch:{ all -> 0x04ae }
            java.lang.String r17 = "auto"
            r12 = r0
            r6 = r18
            r14 = r10
            r12.<init>(r13, r14, r16, r17)     // Catch:{ all -> 0x04ae }
            r1.zza((com.google.android.gms.measurement.internal.zzkr) r0, (com.google.android.gms.measurement.internal.zzn) r2)     // Catch:{ all -> 0x04ae }
            goto L_0x0385
        L_0x0384:
            r6 = r14
        L_0x0385:
            com.google.android.gms.measurement.internal.zzgd r0 = r1.zzj     // Catch:{ NameNotFoundException -> 0x0397 }
            android.content.Context r0 = r0.zzn()     // Catch:{ NameNotFoundException -> 0x0397 }
            com.google.android.gms.common.wrappers.PackageManagerWrapper r0 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r0)     // Catch:{ NameNotFoundException -> 0x0397 }
            java.lang.String r12 = r2.zza     // Catch:{ NameNotFoundException -> 0x0397 }
            r13 = 0
            android.content.pm.ApplicationInfo r0 = r0.getApplicationInfo(r12, r13)     // Catch:{ NameNotFoundException -> 0x0397 }
            goto L_0x03ae
        L_0x0397:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzgd r12 = r1.zzj     // Catch:{ all -> 0x04ae }
            com.google.android.gms.measurement.internal.zzez r12 = r12.zzr()     // Catch:{ all -> 0x04ae }
            com.google.android.gms.measurement.internal.zzfb r12 = r12.zzf()     // Catch:{ all -> 0x04ae }
            java.lang.String r13 = "Application info is null, first open report might be inaccurate. appId"
            java.lang.String r14 = r2.zza     // Catch:{ all -> 0x04ae }
            java.lang.Object r14 = com.google.android.gms.measurement.internal.zzez.zza((java.lang.String) r14)     // Catch:{ all -> 0x04ae }
            r12.zza(r13, r14, r0)     // Catch:{ all -> 0x04ae }
            r0 = 0
        L_0x03ae:
            if (r0 == 0) goto L_0x0307
            int r12 = r0.flags     // Catch:{ all -> 0x04ae }
            r13 = 1
            r12 = r12 & r13
            if (r12 == 0) goto L_0x03bb
            r12 = 1
            r7.putLong(r9, r12)     // Catch:{ all -> 0x04ae }
        L_0x03bb:
            int r0 = r0.flags     // Catch:{ all -> 0x04ae }
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0307
            r12 = 1
            r7.putLong(r6, r12)     // Catch:{ all -> 0x04ae }
            goto L_0x0307
        L_0x03c8:
            int r0 = (r3 > r12 ? 1 : (r3 == r12 ? 0 : -1))
            if (r0 < 0) goto L_0x03cf
            r7.putLong(r5, r3)     // Catch:{ all -> 0x04ae }
        L_0x03cf:
            com.google.android.gms.measurement.internal.zzao r0 = new com.google.android.gms.measurement.internal.zzao     // Catch:{ all -> 0x04ae }
            java.lang.String r13 = "_f"
            com.google.android.gms.measurement.internal.zzan r14 = new com.google.android.gms.measurement.internal.zzan     // Catch:{ all -> 0x04ae }
            r14.<init>(r7)     // Catch:{ all -> 0x04ae }
            java.lang.String r15 = "auto"
            r12 = r0
            r16 = r10
            r12.<init>(r13, r14, r15, r16)     // Catch:{ all -> 0x04ae }
        L_0x03e0:
            r1.zzb((com.google.android.gms.measurement.internal.zzao) r0, (com.google.android.gms.measurement.internal.zzn) r2)     // Catch:{ all -> 0x04ae }
            goto L_0x043e
        L_0x03e4:
            r5 = 1
            if (r7 != r5) goto L_0x043e
            com.google.android.gms.measurement.internal.zzkr r5 = new com.google.android.gms.measurement.internal.zzkr     // Catch:{ all -> 0x04ae }
            java.lang.String r6 = "_fvt"
            java.lang.Long r16 = java.lang.Long.valueOf(r12)     // Catch:{ all -> 0x04ae }
            java.lang.String r17 = "auto"
            r12 = r5
            r13 = r6
            r14 = r10
            r12.<init>(r13, r14, r16, r17)     // Catch:{ all -> 0x04ae }
            r1.zza((com.google.android.gms.measurement.internal.zzkr) r5, (com.google.android.gms.measurement.internal.zzn) r2)     // Catch:{ all -> 0x04ae }
            r21.zzw()     // Catch:{ all -> 0x04ae }
            r21.zzk()     // Catch:{ all -> 0x04ae }
            android.os.Bundle r5 = new android.os.Bundle     // Catch:{ all -> 0x04ae }
            r5.<init>()     // Catch:{ all -> 0x04ae }
            r6 = 1
            r5.putLong(r4, r6)     // Catch:{ all -> 0x04ae }
            r5.putLong(r3, r6)     // Catch:{ all -> 0x04ae }
            com.google.android.gms.measurement.internal.zzgd r3 = r1.zzj     // Catch:{ all -> 0x04ae }
            com.google.android.gms.measurement.internal.zzy r3 = r3.zzb()     // Catch:{ all -> 0x04ae }
            java.lang.String r4 = r2.zza     // Catch:{ all -> 0x04ae }
            com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean> r6 = com.google.android.gms.measurement.internal.zzaq.zzat     // Catch:{ all -> 0x04ae }
            boolean r3 = r3.zze(r4, r6)     // Catch:{ all -> 0x04ae }
            if (r3 == 0) goto L_0x0423
            r3 = 1
            r5.putLong(r8, r3)     // Catch:{ all -> 0x04ae }
            goto L_0x0425
        L_0x0423:
            r3 = 1
        L_0x0425:
            boolean r6 = r2.zzq     // Catch:{ all -> 0x04ae }
            if (r6 == 0) goto L_0x042c
            r5.putLong(r0, r3)     // Catch:{ all -> 0x04ae }
        L_0x042c:
            com.google.android.gms.measurement.internal.zzao r0 = new com.google.android.gms.measurement.internal.zzao     // Catch:{ all -> 0x04ae }
            java.lang.String r13 = "_v"
            com.google.android.gms.measurement.internal.zzan r14 = new com.google.android.gms.measurement.internal.zzan     // Catch:{ all -> 0x04ae }
            r14.<init>(r5)     // Catch:{ all -> 0x04ae }
            java.lang.String r15 = "auto"
            r12 = r0
            r16 = r10
            r12.<init>(r13, r14, r15, r16)     // Catch:{ all -> 0x04ae }
            goto L_0x03e0
        L_0x043e:
            com.google.android.gms.measurement.internal.zzgd r0 = r1.zzj     // Catch:{ all -> 0x04ae }
            com.google.android.gms.measurement.internal.zzy r0 = r0.zzb()     // Catch:{ all -> 0x04ae }
            java.lang.String r3 = r2.zza     // Catch:{ all -> 0x04ae }
            com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean> r4 = com.google.android.gms.measurement.internal.zzaq.zzau     // Catch:{ all -> 0x04ae }
            boolean r0 = r0.zze(r3, r4)     // Catch:{ all -> 0x04ae }
            if (r0 != 0) goto L_0x049f
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ all -> 0x04ae }
            r0.<init>()     // Catch:{ all -> 0x04ae }
            r3 = 1
            r0.putLong(r8, r3)     // Catch:{ all -> 0x04ae }
            com.google.android.gms.measurement.internal.zzgd r3 = r1.zzj     // Catch:{ all -> 0x04ae }
            com.google.android.gms.measurement.internal.zzy r3 = r3.zzb()     // Catch:{ all -> 0x04ae }
            java.lang.String r4 = r2.zza     // Catch:{ all -> 0x04ae }
            com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean> r5 = com.google.android.gms.measurement.internal.zzaq.zzat     // Catch:{ all -> 0x04ae }
            boolean r3 = r3.zze(r4, r5)     // Catch:{ all -> 0x04ae }
            if (r3 == 0) goto L_0x046f
            java.lang.String r3 = "_fr"
            r4 = 1
            r0.putLong(r3, r4)     // Catch:{ all -> 0x04ae }
        L_0x046f:
            com.google.android.gms.measurement.internal.zzao r3 = new com.google.android.gms.measurement.internal.zzao     // Catch:{ all -> 0x04ae }
            java.lang.String r13 = "_e"
            com.google.android.gms.measurement.internal.zzan r14 = new com.google.android.gms.measurement.internal.zzan     // Catch:{ all -> 0x04ae }
            r14.<init>(r0)     // Catch:{ all -> 0x04ae }
            java.lang.String r15 = "auto"
            r12 = r3
            r16 = r10
            r12.<init>(r13, r14, r15, r16)     // Catch:{ all -> 0x04ae }
        L_0x0480:
            r1.zzb((com.google.android.gms.measurement.internal.zzao) r3, (com.google.android.gms.measurement.internal.zzn) r2)     // Catch:{ all -> 0x04ae }
            goto L_0x049f
        L_0x0484:
            boolean r0 = r2.zzi     // Catch:{ all -> 0x04ae }
            if (r0 == 0) goto L_0x049f
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ all -> 0x04ae }
            r0.<init>()     // Catch:{ all -> 0x04ae }
            com.google.android.gms.measurement.internal.zzao r3 = new com.google.android.gms.measurement.internal.zzao     // Catch:{ all -> 0x04ae }
            java.lang.String r13 = "_cd"
            com.google.android.gms.measurement.internal.zzan r14 = new com.google.android.gms.measurement.internal.zzan     // Catch:{ all -> 0x04ae }
            r14.<init>(r0)     // Catch:{ all -> 0x04ae }
            java.lang.String r15 = "auto"
            r12 = r3
            r16 = r10
            r12.<init>(r13, r14, r15, r16)     // Catch:{ all -> 0x04ae }
            goto L_0x0480
        L_0x049f:
            com.google.android.gms.measurement.internal.zzad r0 = r21.zze()     // Catch:{ all -> 0x04ae }
            r0.mo24208b_()     // Catch:{ all -> 0x04ae }
            com.google.android.gms.measurement.internal.zzad r0 = r21.zze()
            r0.zzh()
            return
        L_0x04ae:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzad r2 = r21.zze()
            r2.zzh()
            goto L_0x04b8
        L_0x04b7:
            throw r0
        L_0x04b8:
            goto L_0x04b7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkk.zzb(com.google.android.gms.measurement.internal.zzn):void");
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zzb(zzw zzw2) {
        zzn zza2 = zza(zzw2.zza);
        if (zza2 != null) {
            zzb(zzw2, zza2);
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zzb(zzw zzw2, zzn zzn2) {
        Preconditions.checkNotNull(zzw2);
        Preconditions.checkNotEmpty(zzw2.zza);
        Preconditions.checkNotNull(zzw2.zzc);
        Preconditions.checkNotEmpty(zzw2.zzc.zza);
        zzw();
        zzk();
        if (zze(zzn2)) {
            if (!zzn2.zzh) {
                zzc(zzn2);
                return;
            }
            zze().zzf();
            try {
                zzc(zzn2);
                zzw zzd2 = zze().zzd(zzw2.zza, zzw2.zzc.zza);
                if (zzd2 != null) {
                    this.zzj.zzr().zzw().zza("Removing conditional user property", zzw2.zza, this.zzj.zzj().zzc(zzw2.zzc.zza));
                    zze().zze(zzw2.zza, zzw2.zzc.zza);
                    if (zzd2.zze) {
                        zze().zzb(zzw2.zza, zzw2.zzc.zza);
                    }
                    if (zzw2.zzk != null) {
                        Bundle bundle = null;
                        if (zzw2.zzk.zzb != null) {
                            bundle = zzw2.zzk.zzb.zzb();
                        }
                        Bundle bundle2 = bundle;
                        zzc(this.zzj.zzi().zza(zzw2.zza, zzw2.zzk.zza, bundle2, zzd2.zzb, zzw2.zzk.zzd, true, false), zzn2);
                    }
                } else {
                    this.zzj.zzr().zzi().zza("Conditional user property doesn't exist", zzez.zza(zzw2.zza), this.zzj.zzj().zzc(zzw2.zzc.zza));
                }
                zze().mo24208b_();
            } finally {
                zze().zzh();
            }
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final zzf zzc(zzn zzn2) {
        zzw();
        zzk();
        Preconditions.checkNotNull(zzn2);
        Preconditions.checkNotEmpty(zzn2.zza);
        zzf zzb2 = zze().zzb(zzn2.zza);
        String zzb3 = this.zzj.zzc().zzb(zzn2.zza);
        if (!zznn.zzb() || !this.zzj.zzb().zza(zzaq.zzbt)) {
            return zza(zzn2, zzb2, zzb3);
        }
        if (zzb2 == null) {
            zzb2 = new zzf(this.zzj, zzn2.zza);
            zzb2.zza(this.zzj.zzi().zzk());
            zzb2.zze(zzb3);
        } else if (!zzb3.equals(zzb2.zzh())) {
            zzb2.zze(zzb3);
            zzb2.zza(this.zzj.zzi().zzk());
        }
        zzb2.zzb(zzn2.zzb);
        zzb2.zzc(zzn2.zzr);
        if (zzoe.zzb() && this.zzj.zzb().zze(zzb2.zzc(), zzaq.zzbn)) {
            zzb2.zzd(zzn2.zzv);
        }
        if (!TextUtils.isEmpty(zzn2.zzk)) {
            zzb2.zzf(zzn2.zzk);
        }
        long j = zzn2.zze;
        if (j != 0) {
            zzb2.zzd(j);
        }
        if (!TextUtils.isEmpty(zzn2.zzc)) {
            zzb2.zzg(zzn2.zzc);
        }
        zzb2.zzc(zzn2.zzj);
        String str = zzn2.zzd;
        if (str != null) {
            zzb2.zzh(str);
        }
        zzb2.zze(zzn2.zzf);
        zzb2.zza(zzn2.zzh);
        if (!TextUtils.isEmpty(zzn2.zzg)) {
            zzb2.zzi(zzn2.zzg);
        }
        if (!this.zzj.zzb().zza(zzaq.zzcl)) {
            zzb2.zzp(zzn2.zzl);
        }
        zzb2.zzb(zzn2.zzo);
        zzb2.zzc(zzn2.zzp);
        zzb2.zza(zzn2.zzs);
        zzb2.zzf(zzn2.zzt);
        if (zzb2.zza()) {
            zze().zza(zzb2);
        }
        return zzb2;
    }

    public final zzfx zzc() {
        zzb((zzkl) this.zzb);
        return this.zzb;
    }

    public final zzfc zzd() {
        zzb((zzkl) this.zzc);
        return this.zzc;
    }

    /* access modifiers changed from: package-private */
    public final String zzd(zzn zzn2) {
        try {
            return (String) this.zzj.zzq().zza(new zzko(this, zzn2)).get(30000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            this.zzj.zzr().zzf().zza("Failed to get app instance id. appId", zzez.zza(zzn2.zza), e);
            return null;
        }
    }

    public final zzad zze() {
        zzb((zzkl) this.zzd);
        return this.zzd;
    }

    public final zzo zzf() {
        zzb((zzkl) this.zzg);
        return this.zzg;
    }

    public final zzii zzg() {
        zzb((zzkl) this.zzi);
        return this.zzi;
    }

    public final zzks zzh() {
        zzb((zzkl) this.zzh);
        return this.zzh;
    }

    public final zzex zzi() {
        return this.zzj.zzj();
    }

    public final zzkw zzj() {
        return this.zzj.zzi();
    }

    /* access modifiers changed from: package-private */
    public final void zzk() {
        if (!this.zzk) {
            throw new IllegalStateException("UploadController is not initialized");
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:83|84) */
    /* JADX WARNING: Code restructure failed: missing block: B:84:?, code lost:
        r1.zzj.zzr().zzf().zza("Failed to parse upload URL. Not uploading. appId", com.google.android.gms.measurement.internal.zzez.zza(r5), r9);
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:83:0x02b2 */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzl() {
        /*
            r17 = this;
            r1 = r17
            r17.zzw()
            r17.zzk()
            r0 = 1
            r1.zzs = r0
            r2 = 0
            com.google.android.gms.measurement.internal.zzgd r3 = r1.zzj     // Catch:{ all -> 0x02eb }
            r3.zzu()     // Catch:{ all -> 0x02eb }
            com.google.android.gms.measurement.internal.zzgd r3 = r1.zzj     // Catch:{ all -> 0x02eb }
            com.google.android.gms.measurement.internal.zzis r3 = r3.zzw()     // Catch:{ all -> 0x02eb }
            java.lang.Boolean r3 = r3.zzag()     // Catch:{ all -> 0x02eb }
            if (r3 != 0) goto L_0x0032
            com.google.android.gms.measurement.internal.zzgd r0 = r1.zzj     // Catch:{ all -> 0x02eb }
            com.google.android.gms.measurement.internal.zzez r0 = r0.zzr()     // Catch:{ all -> 0x02eb }
            com.google.android.gms.measurement.internal.zzfb r0 = r0.zzi()     // Catch:{ all -> 0x02eb }
            java.lang.String r3 = "Upload data called on the client side before use of service was decided"
        L_0x0029:
            r0.zza(r3)     // Catch:{ all -> 0x02eb }
        L_0x002c:
            r1.zzs = r2
            r17.zzaa()
            return
        L_0x0032:
            boolean r3 = r3.booleanValue()     // Catch:{ all -> 0x02eb }
            if (r3 == 0) goto L_0x0045
            com.google.android.gms.measurement.internal.zzgd r0 = r1.zzj     // Catch:{ all -> 0x02eb }
            com.google.android.gms.measurement.internal.zzez r0 = r0.zzr()     // Catch:{ all -> 0x02eb }
            com.google.android.gms.measurement.internal.zzfb r0 = r0.zzf()     // Catch:{ all -> 0x02eb }
            java.lang.String r3 = "Upload called in the client side when service should be used"
            goto L_0x0029
        L_0x0045:
            long r3 = r1.zzm     // Catch:{ all -> 0x02eb }
            r5 = 0
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x0051
        L_0x004d:
            r17.zzz()     // Catch:{ all -> 0x02eb }
            goto L_0x002c
        L_0x0051:
            r17.zzw()     // Catch:{ all -> 0x02eb }
            java.util.List<java.lang.Long> r3 = r1.zzv     // Catch:{ all -> 0x02eb }
            if (r3 == 0) goto L_0x005a
            r3 = 1
            goto L_0x005b
        L_0x005a:
            r3 = 0
        L_0x005b:
            if (r3 == 0) goto L_0x006a
            com.google.android.gms.measurement.internal.zzgd r0 = r1.zzj     // Catch:{ all -> 0x02eb }
            com.google.android.gms.measurement.internal.zzez r0 = r0.zzr()     // Catch:{ all -> 0x02eb }
            com.google.android.gms.measurement.internal.zzfb r0 = r0.zzx()     // Catch:{ all -> 0x02eb }
            java.lang.String r3 = "Uploading requested multiple times"
            goto L_0x0029
        L_0x006a:
            com.google.android.gms.measurement.internal.zzfc r3 = r17.zzd()     // Catch:{ all -> 0x02eb }
            boolean r3 = r3.zzf()     // Catch:{ all -> 0x02eb }
            if (r3 != 0) goto L_0x0084
            com.google.android.gms.measurement.internal.zzgd r0 = r1.zzj     // Catch:{ all -> 0x02eb }
            com.google.android.gms.measurement.internal.zzez r0 = r0.zzr()     // Catch:{ all -> 0x02eb }
            com.google.android.gms.measurement.internal.zzfb r0 = r0.zzx()     // Catch:{ all -> 0x02eb }
            java.lang.String r3 = "Network not connected, ignoring upload request"
            r0.zza(r3)     // Catch:{ all -> 0x02eb }
            goto L_0x004d
        L_0x0084:
            com.google.android.gms.measurement.internal.zzgd r3 = r1.zzj     // Catch:{ all -> 0x02eb }
            com.google.android.gms.common.util.Clock r3 = r3.zzm()     // Catch:{ all -> 0x02eb }
            long r3 = r3.currentTimeMillis()     // Catch:{ all -> 0x02eb }
            com.google.android.gms.measurement.internal.zzgd r7 = r1.zzj     // Catch:{ all -> 0x02eb }
            com.google.android.gms.measurement.internal.zzy r7 = r7.zzb()     // Catch:{ all -> 0x02eb }
            com.google.android.gms.measurement.internal.zzeo<java.lang.Integer> r8 = com.google.android.gms.measurement.internal.zzaq.zzap     // Catch:{ all -> 0x02eb }
            r9 = 0
            int r7 = r7.zzb(r9, r8)     // Catch:{ all -> 0x02eb }
            long r10 = com.google.android.gms.measurement.internal.zzy.zzv()     // Catch:{ all -> 0x02eb }
            long r10 = r3 - r10
            r8 = 0
        L_0x00a2:
            if (r8 >= r7) goto L_0x00ad
            boolean r12 = r1.zza((java.lang.String) r9, (long) r10)     // Catch:{ all -> 0x02eb }
            if (r12 == 0) goto L_0x00ad
            int r8 = r8 + 1
            goto L_0x00a2
        L_0x00ad:
            com.google.android.gms.measurement.internal.zzgd r7 = r1.zzj     // Catch:{ all -> 0x02eb }
            com.google.android.gms.measurement.internal.zzfl r7 = r7.zzc()     // Catch:{ all -> 0x02eb }
            com.google.android.gms.measurement.internal.zzfp r7 = r7.zzc     // Catch:{ all -> 0x02eb }
            long r7 = r7.zza()     // Catch:{ all -> 0x02eb }
            int r10 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r10 == 0) goto L_0x00d6
            com.google.android.gms.measurement.internal.zzgd r5 = r1.zzj     // Catch:{ all -> 0x02eb }
            com.google.android.gms.measurement.internal.zzez r5 = r5.zzr()     // Catch:{ all -> 0x02eb }
            com.google.android.gms.measurement.internal.zzfb r5 = r5.zzw()     // Catch:{ all -> 0x02eb }
            java.lang.String r6 = "Uploading events. Elapsed time since last upload attempt (ms)"
            long r7 = r3 - r7
            long r7 = java.lang.Math.abs(r7)     // Catch:{ all -> 0x02eb }
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x02eb }
            r5.zza(r6, r7)     // Catch:{ all -> 0x02eb }
        L_0x00d6:
            com.google.android.gms.measurement.internal.zzad r5 = r17.zze()     // Catch:{ all -> 0x02eb }
            java.lang.String r5 = r5.mo24210d_()     // Catch:{ all -> 0x02eb }
            boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x02eb }
            r7 = -1
            if (r6 != 0) goto L_0x02c7
            long r10 = r1.zzx     // Catch:{ all -> 0x02eb }
            int r6 = (r10 > r7 ? 1 : (r10 == r7 ? 0 : -1))
            if (r6 != 0) goto L_0x00f6
            com.google.android.gms.measurement.internal.zzad r6 = r17.zze()     // Catch:{ all -> 0x02eb }
            long r6 = r6.zzaa()     // Catch:{ all -> 0x02eb }
            r1.zzx = r6     // Catch:{ all -> 0x02eb }
        L_0x00f6:
            com.google.android.gms.measurement.internal.zzgd r6 = r1.zzj     // Catch:{ all -> 0x02eb }
            com.google.android.gms.measurement.internal.zzy r6 = r6.zzb()     // Catch:{ all -> 0x02eb }
            com.google.android.gms.measurement.internal.zzeo<java.lang.Integer> r7 = com.google.android.gms.measurement.internal.zzaq.zzf     // Catch:{ all -> 0x02eb }
            int r6 = r6.zzb(r5, r7)     // Catch:{ all -> 0x02eb }
            com.google.android.gms.measurement.internal.zzgd r7 = r1.zzj     // Catch:{ all -> 0x02eb }
            com.google.android.gms.measurement.internal.zzy r7 = r7.zzb()     // Catch:{ all -> 0x02eb }
            com.google.android.gms.measurement.internal.zzeo<java.lang.Integer> r8 = com.google.android.gms.measurement.internal.zzaq.zzg     // Catch:{ all -> 0x02eb }
            int r7 = r7.zzb(r5, r8)     // Catch:{ all -> 0x02eb }
            int r7 = java.lang.Math.max(r2, r7)     // Catch:{ all -> 0x02eb }
            com.google.android.gms.measurement.internal.zzad r8 = r17.zze()     // Catch:{ all -> 0x02eb }
            java.util.List r6 = r8.zza((java.lang.String) r5, (int) r6, (int) r7)     // Catch:{ all -> 0x02eb }
            boolean r7 = r6.isEmpty()     // Catch:{ all -> 0x02eb }
            if (r7 != 0) goto L_0x002c
            java.util.Iterator r7 = r6.iterator()     // Catch:{ all -> 0x02eb }
        L_0x0124:
            boolean r8 = r7.hasNext()     // Catch:{ all -> 0x02eb }
            if (r8 == 0) goto L_0x0143
            java.lang.Object r8 = r7.next()     // Catch:{ all -> 0x02eb }
            android.util.Pair r8 = (android.util.Pair) r8     // Catch:{ all -> 0x02eb }
            java.lang.Object r8 = r8.first     // Catch:{ all -> 0x02eb }
            com.google.android.gms.internal.measurement.zzcc$zzg r8 = (com.google.android.gms.internal.measurement.zzcc.zzg) r8     // Catch:{ all -> 0x02eb }
            java.lang.String r10 = r8.zzad()     // Catch:{ all -> 0x02eb }
            boolean r10 = android.text.TextUtils.isEmpty(r10)     // Catch:{ all -> 0x02eb }
            if (r10 != 0) goto L_0x0124
            java.lang.String r7 = r8.zzad()     // Catch:{ all -> 0x02eb }
            goto L_0x0144
        L_0x0143:
            r7 = r9
        L_0x0144:
            if (r7 == 0) goto L_0x0173
            r8 = 0
        L_0x0147:
            int r10 = r6.size()     // Catch:{ all -> 0x02eb }
            if (r8 >= r10) goto L_0x0173
            java.lang.Object r10 = r6.get(r8)     // Catch:{ all -> 0x02eb }
            android.util.Pair r10 = (android.util.Pair) r10     // Catch:{ all -> 0x02eb }
            java.lang.Object r10 = r10.first     // Catch:{ all -> 0x02eb }
            com.google.android.gms.internal.measurement.zzcc$zzg r10 = (com.google.android.gms.internal.measurement.zzcc.zzg) r10     // Catch:{ all -> 0x02eb }
            java.lang.String r11 = r10.zzad()     // Catch:{ all -> 0x02eb }
            boolean r11 = android.text.TextUtils.isEmpty(r11)     // Catch:{ all -> 0x02eb }
            if (r11 != 0) goto L_0x0170
            java.lang.String r10 = r10.zzad()     // Catch:{ all -> 0x02eb }
            boolean r10 = r10.equals(r7)     // Catch:{ all -> 0x02eb }
            if (r10 != 0) goto L_0x0170
            java.util.List r6 = r6.subList(r2, r8)     // Catch:{ all -> 0x02eb }
            goto L_0x0173
        L_0x0170:
            int r8 = r8 + 1
            goto L_0x0147
        L_0x0173:
            com.google.android.gms.internal.measurement.zzcc$zzf$zza r7 = com.google.android.gms.internal.measurement.zzcc.zzf.zzb()     // Catch:{ all -> 0x02eb }
            int r8 = r6.size()     // Catch:{ all -> 0x02eb }
            java.util.ArrayList r10 = new java.util.ArrayList     // Catch:{ all -> 0x02eb }
            int r11 = r6.size()     // Catch:{ all -> 0x02eb }
            r10.<init>(r11)     // Catch:{ all -> 0x02eb }
            com.google.android.gms.measurement.internal.zzgd r11 = r1.zzj     // Catch:{ all -> 0x02eb }
            com.google.android.gms.measurement.internal.zzy r11 = r11.zzb()     // Catch:{ all -> 0x02eb }
            boolean r11 = r11.zzg(r5)     // Catch:{ all -> 0x02eb }
            r12 = 0
        L_0x018f:
            if (r12 >= r8) goto L_0x01f8
            java.lang.Object r13 = r6.get(r12)     // Catch:{ all -> 0x02eb }
            android.util.Pair r13 = (android.util.Pair) r13     // Catch:{ all -> 0x02eb }
            java.lang.Object r13 = r13.first     // Catch:{ all -> 0x02eb }
            com.google.android.gms.internal.measurement.zzcc$zzg r13 = (com.google.android.gms.internal.measurement.zzcc.zzg) r13     // Catch:{ all -> 0x02eb }
            com.google.android.gms.internal.measurement.zzib$zza r13 = r13.zzbl()     // Catch:{ all -> 0x02eb }
            com.google.android.gms.internal.measurement.zzcc$zzg$zza r13 = (com.google.android.gms.internal.measurement.zzcc.zzg.zza) r13     // Catch:{ all -> 0x02eb }
            java.lang.Object r14 = r6.get(r12)     // Catch:{ all -> 0x02eb }
            android.util.Pair r14 = (android.util.Pair) r14     // Catch:{ all -> 0x02eb }
            java.lang.Object r14 = r14.second     // Catch:{ all -> 0x02eb }
            java.lang.Long r14 = (java.lang.Long) r14     // Catch:{ all -> 0x02eb }
            r10.add(r14)     // Catch:{ all -> 0x02eb }
            com.google.android.gms.measurement.internal.zzgd r14 = r1.zzj     // Catch:{ all -> 0x02eb }
            com.google.android.gms.measurement.internal.zzy r14 = r14.zzb()     // Catch:{ all -> 0x02eb }
            long r14 = r14.zzf()     // Catch:{ all -> 0x02eb }
            com.google.android.gms.internal.measurement.zzcc$zzg$zza r14 = r13.zzg((long) r14)     // Catch:{ all -> 0x02eb }
            com.google.android.gms.internal.measurement.zzcc$zzg$zza r14 = r14.zza((long) r3)     // Catch:{ all -> 0x02eb }
            com.google.android.gms.measurement.internal.zzgd r15 = r1.zzj     // Catch:{ all -> 0x02eb }
            r15.zzu()     // Catch:{ all -> 0x02eb }
            r14.zzb((boolean) r2)     // Catch:{ all -> 0x02eb }
            if (r11 != 0) goto L_0x01cd
            r13.zzn()     // Catch:{ all -> 0x02eb }
        L_0x01cd:
            com.google.android.gms.measurement.internal.zzgd r14 = r1.zzj     // Catch:{ all -> 0x02eb }
            com.google.android.gms.measurement.internal.zzy r14 = r14.zzb()     // Catch:{ all -> 0x02eb }
            com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean> r15 = com.google.android.gms.measurement.internal.zzaq.zzay     // Catch:{ all -> 0x02eb }
            boolean r14 = r14.zze(r5, r15)     // Catch:{ all -> 0x02eb }
            if (r14 == 0) goto L_0x01f2
            com.google.android.gms.internal.measurement.zzjj r14 = r13.zzv()     // Catch:{ all -> 0x02eb }
            com.google.android.gms.internal.measurement.zzib r14 = (com.google.android.gms.internal.measurement.zzib) r14     // Catch:{ all -> 0x02eb }
            com.google.android.gms.internal.measurement.zzcc$zzg r14 = (com.google.android.gms.internal.measurement.zzcc.zzg) r14     // Catch:{ all -> 0x02eb }
            byte[] r14 = r14.zzbi()     // Catch:{ all -> 0x02eb }
            com.google.android.gms.measurement.internal.zzks r15 = r17.zzh()     // Catch:{ all -> 0x02eb }
            long r14 = r15.zza((byte[]) r14)     // Catch:{ all -> 0x02eb }
            r13.zzl((long) r14)     // Catch:{ all -> 0x02eb }
        L_0x01f2:
            r7.zza((com.google.android.gms.internal.measurement.zzcc.zzg.zza) r13)     // Catch:{ all -> 0x02eb }
            int r12 = r12 + 1
            goto L_0x018f
        L_0x01f8:
            com.google.android.gms.measurement.internal.zzgd r6 = r1.zzj     // Catch:{ all -> 0x02eb }
            com.google.android.gms.measurement.internal.zzez r6 = r6.zzr()     // Catch:{ all -> 0x02eb }
            r11 = 2
            boolean r6 = r6.zza((int) r11)     // Catch:{ all -> 0x02eb }
            if (r6 == 0) goto L_0x0216
            com.google.android.gms.measurement.internal.zzks r6 = r17.zzh()     // Catch:{ all -> 0x02eb }
            com.google.android.gms.internal.measurement.zzjj r11 = r7.zzv()     // Catch:{ all -> 0x02eb }
            com.google.android.gms.internal.measurement.zzib r11 = (com.google.android.gms.internal.measurement.zzib) r11     // Catch:{ all -> 0x02eb }
            com.google.android.gms.internal.measurement.zzcc$zzf r11 = (com.google.android.gms.internal.measurement.zzcc.zzf) r11     // Catch:{ all -> 0x02eb }
            java.lang.String r6 = r6.zza((com.google.android.gms.internal.measurement.zzcc.zzf) r11)     // Catch:{ all -> 0x02eb }
            goto L_0x0217
        L_0x0216:
            r6 = r9
        L_0x0217:
            r17.zzh()     // Catch:{ all -> 0x02eb }
            com.google.android.gms.internal.measurement.zzjj r11 = r7.zzv()     // Catch:{ all -> 0x02eb }
            com.google.android.gms.internal.measurement.zzib r11 = (com.google.android.gms.internal.measurement.zzib) r11     // Catch:{ all -> 0x02eb }
            com.google.android.gms.internal.measurement.zzcc$zzf r11 = (com.google.android.gms.internal.measurement.zzcc.zzf) r11     // Catch:{ all -> 0x02eb }
            byte[] r14 = r11.zzbi()     // Catch:{ all -> 0x02eb }
            com.google.android.gms.measurement.internal.zzeo<java.lang.String> r11 = com.google.android.gms.measurement.internal.zzaq.zzp     // Catch:{ all -> 0x02eb }
            java.lang.Object r9 = r11.zza(r9)     // Catch:{ all -> 0x02eb }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ all -> 0x02eb }
            java.net.URL r13 = new java.net.URL     // Catch:{ MalformedURLException -> 0x02b2 }
            r13.<init>(r9)     // Catch:{ MalformedURLException -> 0x02b2 }
            boolean r11 = r10.isEmpty()     // Catch:{ MalformedURLException -> 0x02b2 }
            if (r11 != 0) goto L_0x023b
            r11 = 1
            goto L_0x023c
        L_0x023b:
            r11 = 0
        L_0x023c:
            com.google.android.gms.common.internal.Preconditions.checkArgument(r11)     // Catch:{ MalformedURLException -> 0x02b2 }
            java.util.List<java.lang.Long> r11 = r1.zzv     // Catch:{ MalformedURLException -> 0x02b2 }
            if (r11 == 0) goto L_0x0253
            com.google.android.gms.measurement.internal.zzgd r10 = r1.zzj     // Catch:{ MalformedURLException -> 0x02b2 }
            com.google.android.gms.measurement.internal.zzez r10 = r10.zzr()     // Catch:{ MalformedURLException -> 0x02b2 }
            com.google.android.gms.measurement.internal.zzfb r10 = r10.zzf()     // Catch:{ MalformedURLException -> 0x02b2 }
            java.lang.String r11 = "Set uploading progress before finishing the previous upload"
            r10.zza(r11)     // Catch:{ MalformedURLException -> 0x02b2 }
            goto L_0x025a
        L_0x0253:
            java.util.ArrayList r11 = new java.util.ArrayList     // Catch:{ MalformedURLException -> 0x02b2 }
            r11.<init>(r10)     // Catch:{ MalformedURLException -> 0x02b2 }
            r1.zzv = r11     // Catch:{ MalformedURLException -> 0x02b2 }
        L_0x025a:
            com.google.android.gms.measurement.internal.zzgd r10 = r1.zzj     // Catch:{ MalformedURLException -> 0x02b2 }
            com.google.android.gms.measurement.internal.zzfl r10 = r10.zzc()     // Catch:{ MalformedURLException -> 0x02b2 }
            com.google.android.gms.measurement.internal.zzfp r10 = r10.zzd     // Catch:{ MalformedURLException -> 0x02b2 }
            r10.zza(r3)     // Catch:{ MalformedURLException -> 0x02b2 }
            java.lang.String r3 = "?"
            if (r8 <= 0) goto L_0x0271
            com.google.android.gms.internal.measurement.zzcc$zzg r3 = r7.zza((int) r2)     // Catch:{ MalformedURLException -> 0x02b2 }
            java.lang.String r3 = r3.zzx()     // Catch:{ MalformedURLException -> 0x02b2 }
        L_0x0271:
            com.google.android.gms.measurement.internal.zzgd r4 = r1.zzj     // Catch:{ MalformedURLException -> 0x02b2 }
            com.google.android.gms.measurement.internal.zzez r4 = r4.zzr()     // Catch:{ MalformedURLException -> 0x02b2 }
            com.google.android.gms.measurement.internal.zzfb r4 = r4.zzx()     // Catch:{ MalformedURLException -> 0x02b2 }
            java.lang.String r7 = "Uploading data. app, uncompressed size, data"
            int r8 = r14.length     // Catch:{ MalformedURLException -> 0x02b2 }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ MalformedURLException -> 0x02b2 }
            r4.zza(r7, r3, r8, r6)     // Catch:{ MalformedURLException -> 0x02b2 }
            r1.zzr = r0     // Catch:{ MalformedURLException -> 0x02b2 }
            com.google.android.gms.measurement.internal.zzfc r11 = r17.zzd()     // Catch:{ MalformedURLException -> 0x02b2 }
            com.google.android.gms.measurement.internal.zzkm r0 = new com.google.android.gms.measurement.internal.zzkm     // Catch:{ MalformedURLException -> 0x02b2 }
            r0.<init>(r1, r5)     // Catch:{ MalformedURLException -> 0x02b2 }
            r11.zzd()     // Catch:{ MalformedURLException -> 0x02b2 }
            r11.zzak()     // Catch:{ MalformedURLException -> 0x02b2 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r13)     // Catch:{ MalformedURLException -> 0x02b2 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r14)     // Catch:{ MalformedURLException -> 0x02b2 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)     // Catch:{ MalformedURLException -> 0x02b2 }
            com.google.android.gms.measurement.internal.zzfw r3 = r11.zzq()     // Catch:{ MalformedURLException -> 0x02b2 }
            com.google.android.gms.measurement.internal.zzfg r4 = new com.google.android.gms.measurement.internal.zzfg     // Catch:{ MalformedURLException -> 0x02b2 }
            r15 = 0
            r10 = r4
            r12 = r5
            r16 = r0
            r10.<init>(r11, r12, r13, r14, r15, r16)     // Catch:{ MalformedURLException -> 0x02b2 }
            r3.zzb((java.lang.Runnable) r4)     // Catch:{ MalformedURLException -> 0x02b2 }
            goto L_0x002c
        L_0x02b2:
            com.google.android.gms.measurement.internal.zzgd r0 = r1.zzj     // Catch:{ all -> 0x02eb }
            com.google.android.gms.measurement.internal.zzez r0 = r0.zzr()     // Catch:{ all -> 0x02eb }
            com.google.android.gms.measurement.internal.zzfb r0 = r0.zzf()     // Catch:{ all -> 0x02eb }
            java.lang.String r3 = "Failed to parse upload URL. Not uploading. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzez.zza((java.lang.String) r5)     // Catch:{ all -> 0x02eb }
            r0.zza(r3, r4, r9)     // Catch:{ all -> 0x02eb }
            goto L_0x002c
        L_0x02c7:
            r1.zzx = r7     // Catch:{ all -> 0x02eb }
            com.google.android.gms.measurement.internal.zzad r0 = r17.zze()     // Catch:{ all -> 0x02eb }
            long r5 = com.google.android.gms.measurement.internal.zzy.zzv()     // Catch:{ all -> 0x02eb }
            long r3 = r3 - r5
            java.lang.String r0 = r0.zza((long) r3)     // Catch:{ all -> 0x02eb }
            boolean r3 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x02eb }
            if (r3 != 0) goto L_0x002c
            com.google.android.gms.measurement.internal.zzad r3 = r17.zze()     // Catch:{ all -> 0x02eb }
            com.google.android.gms.measurement.internal.zzf r0 = r3.zzb(r0)     // Catch:{ all -> 0x02eb }
            if (r0 == 0) goto L_0x002c
            r1.zza((com.google.android.gms.measurement.internal.zzf) r0)     // Catch:{ all -> 0x02eb }
            goto L_0x002c
        L_0x02eb:
            r0 = move-exception
            r1.zzs = r2
            r17.zzaa()
            goto L_0x02f3
        L_0x02f2:
            throw r0
        L_0x02f3:
            goto L_0x02f2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkk.zzl():void");
    }

    public final Clock zzm() {
        return this.zzj.zzm();
    }

    public final Context zzn() {
        return this.zzj.zzn();
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    @VisibleForTesting
    public final void zzo() {
        String str;
        zzfb zzfb;
        Integer num;
        Integer num2;
        zzw();
        zzk();
        if (!this.zzl) {
            this.zzl = true;
            if (zzab()) {
                int zza2 = zza(this.zzu);
                int zzaf = this.zzj.zzy().zzaf();
                zzw();
                if (zza2 > zzaf) {
                    zzfb = this.zzj.zzr().zzf();
                    num2 = Integer.valueOf(zza2);
                    num = Integer.valueOf(zzaf);
                    str = "Panic: can't downgrade version. Previous, current version";
                } else if (zza2 >= zzaf) {
                    return;
                } else {
                    if (zza(zzaf, this.zzu)) {
                        zzfb = this.zzj.zzr().zzx();
                        num2 = Integer.valueOf(zza2);
                        num = Integer.valueOf(zzaf);
                        str = "Storage version upgraded. Previous, current version";
                    } else {
                        zzfb = this.zzj.zzr().zzf();
                        num2 = Integer.valueOf(zza2);
                        num = Integer.valueOf(zzaf);
                        str = "Storage version upgrade failed. Previous, current version";
                    }
                }
                zzfb.zza(str, num2, num);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzp() {
        this.zzp++;
    }

    public final zzfw zzq() {
        return this.zzj.zzq();
    }

    public final zzez zzr() {
        return this.zzj.zzr();
    }

    /* access modifiers changed from: package-private */
    public final zzgd zzs() {
        return this.zzj;
    }

    public final zzx zzu() {
        return this.zzj.zzu();
    }
}
