package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;

public final class zzdzr implements zzdss {
    private final Mac zzhsc;
    private final int zzhsd;
    private final String zzhse;
    private final Key zzhsf;

    public zzdzr(String str, Key key, int i) throws GeneralSecurityException {
        if (i < 10) {
            throw new InvalidAlgorithmParameterException("tag size too small, need at least 10 bytes");
        } else if (key.getEncoded().length >= 16) {
            char c = 65535;
            int hashCode = str.hashCode();
            if (hashCode != -1823053428) {
                if (hashCode != 392315118) {
                    if (hashCode == 392317873 && str.equals("HMACSHA512")) {
                        c = 2;
                    }
                } else if (str.equals("HMACSHA256")) {
                    c = 1;
                }
            } else if (str.equals("HMACSHA1")) {
                c = 0;
            }
            if (c != 0) {
                if (c != 1) {
                    if (c != 2) {
                        throw new NoSuchAlgorithmException(str.length() != 0 ? "unknown Hmac algorithm: ".concat(str) : new String("unknown Hmac algorithm: "));
                    } else if (i > 64) {
                        throw new InvalidAlgorithmParameterException("tag size too big");
                    }
                } else if (i > 32) {
                    throw new InvalidAlgorithmParameterException("tag size too big");
                }
            } else if (i > 20) {
                throw new InvalidAlgorithmParameterException("tag size too big");
            }
            this.zzhse = str;
            this.zzhsd = i;
            this.zzhsf = key;
            Mac zzho = zzdzi.zzhrt.zzho(str);
            this.zzhsc = zzho;
            zzho.init(key);
        } else {
            throw new InvalidAlgorithmParameterException("key size too small, need at least 16 bytes");
        }
    }

    public final byte[] zzm(byte[] bArr) throws GeneralSecurityException {
        Mac mac;
        try {
            mac = (Mac) this.zzhsc.clone();
        } catch (CloneNotSupportedException unused) {
            mac = zzdzi.zzhrt.zzho(this.zzhse);
            mac.init(this.zzhsf);
        }
        mac.update(bArr);
        byte[] bArr2 = new byte[this.zzhsd];
        System.arraycopy(mac.doFinal(), 0, bArr2, 0, this.zzhsd);
        return bArr2;
    }
}
