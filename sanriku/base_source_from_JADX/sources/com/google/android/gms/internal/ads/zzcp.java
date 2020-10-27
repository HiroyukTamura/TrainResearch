package com.google.android.gms.internal.ads;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

final class zzcp implements Runnable {
    private zzcp() {
    }

    public final void run() {
        try {
            MessageDigest unused = zzcn.zzng = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException unused2) {
        } catch (Throwable th) {
            zzcn.zznj.countDown();
            throw th;
        }
        zzcn.zznj.countDown();
    }
}
