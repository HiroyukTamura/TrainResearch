package com.google.android.gms.internal.ads;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class zzfx {
    private static final String TAG = "zzfx";
    private final String className;
    private final String zzaau;
    private final int zzaav = 2;
    private volatile Method zzaaw = null;
    private final Class<?>[] zzaax;
    private CountDownLatch zzaay = new CountDownLatch(1);
    private final zzeo zzvp;

    public zzfx(zzeo zzeo, String str, String str2, Class<?>... clsArr) {
        this.zzvp = zzeo;
        this.className = str;
        this.zzaau = str2;
        this.zzaax = clsArr;
        zzeo.zzch().submit(new zzga(this));
    }

    private final String zzb(byte[] bArr, String str) throws zzdy, UnsupportedEncodingException {
        return new String(this.zzvp.zzcj().zza(bArr, str), "UTF-8");
    }

    /* access modifiers changed from: private */
    public final void zzdb() {
        try {
            Class loadClass = this.zzvp.zzci().loadClass(zzb(this.zzvp.zzck(), this.className));
            if (loadClass != null) {
                this.zzaaw = loadClass.getMethod(zzb(this.zzvp.zzck(), this.zzaau), this.zzaax);
                Method method = this.zzaaw;
            }
        } catch (zzdy | UnsupportedEncodingException | ClassNotFoundException | NoSuchMethodException | NullPointerException unused) {
        } catch (Throwable th) {
            this.zzaay.countDown();
            throw th;
        }
        this.zzaay.countDown();
    }

    public final Method zzdc() {
        if (this.zzaaw != null) {
            return this.zzaaw;
        }
        try {
            if (!this.zzaay.await(2, TimeUnit.SECONDS)) {
                return null;
            }
            return this.zzaaw;
        } catch (InterruptedException unused) {
            return null;
        }
    }
}
