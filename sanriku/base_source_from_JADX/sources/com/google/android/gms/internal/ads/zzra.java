package com.google.android.gms.internal.ads;

import android.util.Base64OutputStream;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@VisibleForTesting
final class zzra {
    @VisibleForTesting
    private ByteArrayOutputStream zzbrn = new ByteArrayOutputStream(4096);
    @VisibleForTesting
    private Base64OutputStream zzbro = new Base64OutputStream(this.zzbrn, 10);

    public final String toString() {
        String str;
        try {
            this.zzbro.close();
        } catch (IOException e) {
            zzazw.zzc("HashManager: Unable to convert to Base64.", e);
        }
        try {
            this.zzbrn.close();
            str = this.zzbrn.toString();
        } catch (IOException e2) {
            zzazw.zzc("HashManager: Unable to convert to Base64.", e2);
            str = "";
        } catch (Throwable th) {
            this.zzbrn = null;
            this.zzbro = null;
            throw th;
        }
        this.zzbrn = null;
        this.zzbro = null;
        return str;
    }

    public final void write(byte[] bArr) throws IOException {
        this.zzbro.write(bArr);
    }
}
