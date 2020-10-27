package com.google.android.gms.common.logging;

import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.GmsLogger;
import java.util.Locale;

@KeepForSdk
public class Logger {
    private final String mTag;
    private final String zzey;
    private final GmsLogger zzfk;
    private final int zzfl;

    private Logger(String str, String str2) {
        this.zzey = str2;
        this.mTag = str;
        this.zzfk = new GmsLogger(str);
        int i = 2;
        while (7 >= i && !Log.isLoggable(this.mTag, i)) {
            i++;
        }
        this.zzfl = i;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @com.google.android.gms.common.annotation.KeepForSdk
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Logger(java.lang.String r7, java.lang.String... r8) {
        /*
            r6 = this;
            int r0 = r8.length
            if (r0 != 0) goto L_0x0006
            java.lang.String r8 = ""
            goto L_0x0032
        L_0x0006:
            r0 = 91
            java.lang.StringBuilder r0 = p009e.p010a.p011a.p012a.C0681a.m329a((char) r0)
            int r1 = r8.length
            r2 = 0
        L_0x000e:
            if (r2 >= r1) goto L_0x0024
            r3 = r8[r2]
            int r4 = r0.length()
            r5 = 1
            if (r4 <= r5) goto L_0x001e
            java.lang.String r4 = ","
            r0.append(r4)
        L_0x001e:
            r0.append(r3)
            int r2 = r2 + 1
            goto L_0x000e
        L_0x0024:
            r8 = 93
            r0.append(r8)
            r8 = 32
            r0.append(r8)
            java.lang.String r8 = r0.toString()
        L_0x0032:
            r6.<init>((java.lang.String) r7, (java.lang.String) r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.logging.Logger.<init>(java.lang.String, java.lang.String[]):void");
    }

    @KeepForSdk
    /* renamed from: d */
    public void mo12020d(String str, Throwable th, @Nullable Object... objArr) {
        if (isLoggable(3)) {
            Log.d(this.mTag, format(str, objArr), th);
        }
    }

    @KeepForSdk
    /* renamed from: d */
    public void mo12021d(String str, @Nullable Object... objArr) {
        if (isLoggable(3)) {
            Log.d(this.mTag, format(str, objArr));
        }
    }

    @KeepForSdk
    /* renamed from: e */
    public void mo12022e(String str, Throwable th, @Nullable Object... objArr) {
        Log.e(this.mTag, format(str, objArr), th);
    }

    @KeepForSdk
    /* renamed from: e */
    public void mo12023e(String str, @Nullable Object... objArr) {
        Log.e(this.mTag, format(str, objArr));
    }

    /* access modifiers changed from: protected */
    @KeepForSdk
    public String format(String str, @Nullable Object... objArr) {
        if (objArr != null && objArr.length > 0) {
            str = String.format(Locale.US, str, objArr);
        }
        return this.zzey.concat(str);
    }

    @KeepForSdk
    public String getTag() {
        return this.mTag;
    }

    @KeepForSdk
    /* renamed from: i */
    public void mo12026i(String str, @Nullable Object... objArr) {
        Log.i(this.mTag, format(str, objArr));
    }

    @KeepForSdk
    public boolean isLoggable(int i) {
        return this.zzfl <= i;
    }

    @KeepForSdk
    /* renamed from: v */
    public void mo12028v(String str, Throwable th, @Nullable Object... objArr) {
        if (isLoggable(2)) {
            Log.v(this.mTag, format(str, objArr), th);
        }
    }

    @KeepForSdk
    /* renamed from: v */
    public void mo12029v(String str, @Nullable Object... objArr) {
        if (isLoggable(2)) {
            Log.v(this.mTag, format(str, objArr));
        }
    }

    @KeepForSdk
    /* renamed from: w */
    public void mo12030w(String str, @Nullable Object... objArr) {
        Log.w(this.mTag, format(str, objArr));
    }

    @KeepForSdk
    public void wtf(String str, Throwable th, @Nullable Object... objArr) {
        Log.wtf(this.mTag, format(str, objArr), th);
    }

    @KeepForSdk
    public void wtf(Throwable th) {
        Log.wtf(this.mTag, th);
    }
}
