package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdzh;
import com.google.android.gms.security.ProviderInstaller;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.Provider;
import java.security.Security;
import java.security.Signature;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.Mac;

public final class zzdzi<T_WRAPPER extends zzdzh<T_ENGINE>, T_ENGINE> {
    private static final Logger logger = Logger.getLogger(zzdzi.class.getName());
    private static final List<Provider> zzhrr;
    public static final zzdzi<zzdzk, Cipher> zzhrs = new zzdzi<>(new zzdzk());
    public static final zzdzi<zzdzo, Mac> zzhrt = new zzdzi<>(new zzdzo());
    private static final zzdzi<zzdzq, Signature> zzhru = new zzdzi<>(new zzdzq());
    private static final zzdzi<zzdzn, MessageDigest> zzhrv = new zzdzi<>(new zzdzn());
    public static final zzdzi<zzdzj, KeyAgreement> zzhrw = new zzdzi<>(new zzdzj());
    public static final zzdzi<zzdzl, KeyPairGenerator> zzhrx = new zzdzi<>(new zzdzl());
    public static final zzdzi<zzdzm, KeyFactory> zzhry = new zzdzi<>(new zzdzm());
    private T_WRAPPER zzhrz;
    private List<Provider> zzhsa = zzhrr;
    private boolean zzhsb = true;

    static {
        if (zzdzv.zzbcc()) {
            String[] strArr = {ProviderInstaller.PROVIDER_NAME, "AndroidOpenSSL"};
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 2; i++) {
                String str = strArr[i];
                Provider provider = Security.getProvider(str);
                if (provider != null) {
                    arrayList.add(provider);
                } else {
                    logger.logp(Level.INFO, "com.google.crypto.tink.subtle.EngineFactory", "toProviderList", String.format("Provider %s not available", new Object[]{str}));
                }
            }
            zzhrr = arrayList;
        } else {
            zzhrr = new ArrayList();
        }
    }

    private zzdzi(T_WRAPPER t_wrapper) {
        this.zzhrz = t_wrapper;
    }

    public final T_ENGINE zzho(String str) throws GeneralSecurityException {
        Exception exc = null;
        for (Provider zza : this.zzhsa) {
            try {
                return this.zzhrz.zza(str, zza);
            } catch (Exception e) {
                if (exc == null) {
                    exc = e;
                }
            }
        }
        if (this.zzhsb) {
            return this.zzhrz.zza(str, (Provider) null);
        }
        throw new GeneralSecurityException("No good Provider found.", exc);
    }
}
