package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import p009e.p010a.p011a.p012a.C0681a;

public final class zzaqm implements zzaqq {
    private static final Object lock = new Object();
    @VisibleForTesting
    private static zzaqq zzdlo;
    @VisibleForTesting
    private static zzaqq zzdlp;
    private final Context zzciq;
    private final Object zzdlq;
    private final WeakHashMap<Thread, Boolean> zzdlr;
    private final zzazz zzdls;
    private final ExecutorService zzyj;

    private zzaqm(Context context) {
        this(context, zzazz.zzyi());
    }

    private zzaqm(Context context, zzazz zzazz) {
        this.zzdlq = new Object();
        this.zzdlr = new WeakHashMap<>();
        this.zzyj = zzdno.zzavn().zzed(zzdnp.zzhdn);
        this.zzciq = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.zzdls = zzazz;
    }

    @VisibleForTesting
    private final Uri.Builder zza(String str, String str2, String str3, int i) {
        boolean z;
        String str4;
        try {
            z = Wrappers.packageManager(this.zzciq).isCallerInstantApp();
        } catch (Throwable th) {
            zzazw.zzc("Error fetching instant app info", th);
            z = false;
        }
        try {
            str4 = this.zzciq.getPackageName();
        } catch (Throwable unused) {
            zzazw.zzfc("Cannot obtain package name, proceeding.");
            str4 = "unknown";
        }
        Uri.Builder appendQueryParameter = new Uri.Builder().scheme("https").path("//pagead2.googlesyndication.com/pagead/gen_204").appendQueryParameter("is_aia", Boolean.toString(z)).appendQueryParameter("id", "gmob-apps-report-exception").appendQueryParameter("os", Build.VERSION.RELEASE).appendQueryParameter("api", String.valueOf(Build.VERSION.SDK_INT));
        String str5 = Build.MANUFACTURER;
        String str6 = Build.MODEL;
        if (!str6.startsWith(str5)) {
            str6 = C0681a.m313a(str6.length() + C0681a.m336b(str5, 1), str5, " ", str6);
        }
        return appendQueryParameter.appendQueryParameter("device", str6).appendQueryParameter("js", this.zzdls.zzbnd).appendQueryParameter("appid", str4).appendQueryParameter("exceptiontype", str).appendQueryParameter("stacktrace", str2).appendQueryParameter("eids", TextUtils.join(",", zzzz.zzra())).appendQueryParameter("exceptionkey", str3).appendQueryParameter("cl", "305933803").appendQueryParameter("rc", "dev").appendQueryParameter("session_id", zzvj.zzpw()).appendQueryParameter("sampling_rate", Integer.toString(i)).appendQueryParameter("pb_tm", String.valueOf(zzabt.zzcxp.get()));
    }

    public static zzaqq zzc(Context context, zzazz zzazz) {
        synchronized (lock) {
            if (zzdlp == null) {
                if (zzabt.zzcxr.get().booleanValue()) {
                    zzaqm zzaqm = new zzaqm(context, zzazz);
                    Thread thread = Looper.getMainLooper().getThread();
                    if (thread != null) {
                        synchronized (zzaqm.zzdlq) {
                            zzaqm.zzdlr.put(thread, true);
                        }
                        thread.setUncaughtExceptionHandler(new zzaqn(zzaqm, thread.getUncaughtExceptionHandler()));
                    }
                    Thread.setDefaultUncaughtExceptionHandler(new zzaqo(zzaqm, Thread.getDefaultUncaughtExceptionHandler()));
                    zzdlp = zzaqm;
                } else {
                    zzdlp = new zzaqp();
                }
            }
        }
        return zzdlp;
    }

    public static zzaqq zzs(Context context) {
        synchronized (lock) {
            if (zzdlo == null) {
                if (zzabt.zzcxr.get().booleanValue()) {
                    zzdlo = new zzaqm(context);
                } else {
                    zzdlo = new zzaqp();
                }
            }
        }
        return zzdlo;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0039, code lost:
        if (r3 == false) goto L_0x003d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(java.lang.Thread r10, java.lang.Throwable r11) {
        /*
            r9 = this;
            r10 = 1
            r0 = 0
            if (r11 == 0) goto L_0x003c
            r1 = r11
            r2 = 0
            r3 = 0
        L_0x0007:
            if (r1 == 0) goto L_0x0037
            java.lang.StackTraceElement[] r4 = r1.getStackTrace()
            int r5 = r4.length
            r6 = 0
        L_0x000f:
            if (r6 >= r5) goto L_0x0032
            r7 = r4[r6]
            java.lang.String r8 = r7.getClassName()
            boolean r8 = com.google.android.gms.internal.ads.zzazm.zzew(r8)
            if (r8 == 0) goto L_0x001e
            r2 = 1
        L_0x001e:
            java.lang.Class<com.google.android.gms.internal.ads.zzaqm> r8 = com.google.android.gms.internal.ads.zzaqm.class
            java.lang.String r8 = r8.getName()
            java.lang.String r7 = r7.getClassName()
            boolean r7 = r8.equals(r7)
            if (r7 == 0) goto L_0x002f
            r3 = 1
        L_0x002f:
            int r6 = r6 + 1
            goto L_0x000f
        L_0x0032:
            java.lang.Throwable r1 = r1.getCause()
            goto L_0x0007
        L_0x0037:
            if (r2 == 0) goto L_0x003c
            if (r3 != 0) goto L_0x003c
            goto L_0x003d
        L_0x003c:
            r10 = 0
        L_0x003d:
            if (r10 == 0) goto L_0x0046
            r10 = 1065353216(0x3f800000, float:1.0)
            java.lang.String r0 = ""
            r9.zza(r11, r0, r10)
        L_0x0046:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaqm.zza(java.lang.Thread, java.lang.Throwable):void");
    }

    public final void zza(Throwable th, String str) {
        zza(th, str, 1.0f);
    }

    public final void zza(Throwable th, String str, float f) {
        if (zzazm.zzc(th) != null) {
            String name = th.getClass().getName();
            StringWriter stringWriter = new StringWriter();
            zzdzz.zza(th, new PrintWriter(stringWriter));
            String stringWriter2 = stringWriter.toString();
            int i = 0;
            int i2 = 1;
            boolean z = Math.random() < ((double) f);
            if (f > 0.0f) {
                i2 = (int) (1.0f / f);
            }
            if (z) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(zza(name, stringWriter2, str, i2).toString());
                int size = arrayList.size();
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    this.zzyj.execute(new zzaql(new zzbaa(), (String) obj));
                }
            }
        }
    }
}
