package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public abstract class zzqv {
    @Nullable
    private static MessageDigest zzbrh;
    protected Object mLock = new Object();

    /* access modifiers changed from: package-private */
    public abstract byte[] zzbr(String str);

    /* access modifiers changed from: protected */
    @Nullable
    public final MessageDigest zzmm() {
        synchronized (this.mLock) {
            if (zzbrh != null) {
                MessageDigest messageDigest = zzbrh;
                return messageDigest;
            }
            for (int i = 0; i < 2; i++) {
                try {
                    zzbrh = MessageDigest.getInstance("MD5");
                } catch (NoSuchAlgorithmException unused) {
                }
            }
            MessageDigest messageDigest2 = zzbrh;
            return messageDigest2;
        }
    }
}
