package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdxp;
import java.security.GeneralSecurityException;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import p009e.p010a.p011a.p012a.C0681a;

public final class zzdsx {
    private static final Logger logger = Logger.getLogger(zzdsx.class.getName());
    private static final ConcurrentMap<String, zza> zzhjm = new ConcurrentHashMap();
    private static final ConcurrentMap<String, zzb> zzhjn = new ConcurrentHashMap();
    private static final ConcurrentMap<String, Boolean> zzhjo = new ConcurrentHashMap();
    private static final ConcurrentMap<String, zzdse<?>> zzhjp = new ConcurrentHashMap();
    private static final ConcurrentMap<Class<?>, zzdsw<?>> zzhjq = new ConcurrentHashMap();

    interface zza {
        Set<Class<?>> zzawz();

        zzdsh<?> zzaxi();

        Class<?> zzaxj();

        Class<?> zzaxk();

        <P> zzdsh<P> zzb(Class<P> cls) throws GeneralSecurityException;
    }

    interface zzb {
    }

    private static <T> T checkNotNull(T t) {
        if (t != null) {
            return t;
        }
        throw null;
    }

    private static <P> zzdsh<P> zza(String str, Class<P> cls) throws GeneralSecurityException {
        zza zzhi = zzhi(str);
        if (cls == null) {
            return zzhi.zzaxi();
        }
        if (zzhi.zzawz().contains(cls)) {
            return zzhi.zzb(cls);
        }
        String name = cls.getName();
        String valueOf = String.valueOf(zzhi.zzaxj());
        Set<Class<?>> zzawz = zzhi.zzawz();
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (Class next : zzawz) {
            if (!z) {
                sb.append(", ");
            }
            sb.append(next.getCanonicalName());
            z = false;
        }
        String sb2 = sb.toString();
        throw new GeneralSecurityException(C0681a.m324a(C0681a.m337b(C0681a.m336b(sb2, valueOf.length() + name.length() + 77), "Primitive type ", name, " not supported by key manager of type ", valueOf), ", supported primitives: ", sb2));
    }

    public static <P> zzdsu<P> zza(zzdsn zzdsn, zzdsh<P> zzdsh, Class<P> cls) throws GeneralSecurityException {
        Class cls2 = (Class) checkNotNull(cls);
        zzdte.zzc(zzdsn.zzaxc());
        zzdsu<P> zza2 = zzdsu.zza(cls2);
        for (zzdxp.zza next : zzdsn.zzaxc().zzbar()) {
            if (next.zzaxe() == zzdxj.ENABLED) {
                zzdst<P> zza3 = zza2.zza(zza(next.zzbav().zzbad(), next.zzbav().zzbae(), cls2), next);
                if (next.zzbaw() == zzdsn.zzaxc().zzbaq()) {
                    zza2.zza(zza3);
                }
            }
        }
        return zza2;
    }

    private static <KeyProtoT extends zzedo> zza zza(zzdsm<KeyProtoT> zzdsm) {
        return new zzdsz(zzdsm);
    }

    public static synchronized zzdxf zza(zzdxl zzdxl) throws GeneralSecurityException {
        zzdxf zzo;
        synchronized (zzdsx.class) {
            zzdsh<?> zzhk = zzhk(zzdxl.zzbad());
            if (((Boolean) zzhjo.get(zzdxl.zzbad())).booleanValue()) {
                zzo = zzhk.zzo(zzdxl.zzbae());
            } else {
                String valueOf = String.valueOf(zzdxl.zzbad());
                throw new GeneralSecurityException(valueOf.length() != 0 ? "newKey-operation not permitted for key type ".concat(valueOf) : new String("newKey-operation not permitted for key type "));
            }
        }
        return zzo;
    }

    public static <P> P zza(zzdsu<P> zzdsu) throws GeneralSecurityException {
        zzdsw zzdsw = (zzdsw) zzhjq.get(zzdsu.zzawu());
        if (zzdsw != null) {
            return zzdsw.zza(zzdsu);
        }
        String name = zzdsu.zzawu().getName();
        throw new GeneralSecurityException(name.length() != 0 ? "No wrapper found for ".concat(name) : new String("No wrapper found for "));
    }

    private static <P> P zza(String str, zzeaq zzeaq, Class<P> cls) throws GeneralSecurityException {
        return zza(str, cls).zzm(zzeaq);
    }

    public static <P> P zza(String str, zzedo zzedo, Class<P> cls) throws GeneralSecurityException {
        return zza(str, (Class) checkNotNull(cls)).zza(zzedo);
    }

    public static <P> P zza(String str, byte[] bArr, Class<P> cls) throws GeneralSecurityException {
        return zza(str, zzeaq.zzu(bArr), (Class) checkNotNull(cls));
    }

    public static synchronized <P> void zza(zzdsh<P> zzdsh, boolean z) throws GeneralSecurityException {
        synchronized (zzdsx.class) {
            if (zzdsh != null) {
                String keyType = zzdsh.getKeyType();
                zza(keyType, zzdsh.getClass(), z);
                if (!zzhjm.containsKey(keyType)) {
                    zzhjm.put(keyType, new zzdta(zzdsh));
                }
                zzhjo.put(keyType, Boolean.valueOf(z));
            } else {
                throw new IllegalArgumentException("key manager must be non-null.");
            }
        }
    }

    public static synchronized <KeyProtoT extends zzedo> void zza(zzdsm<KeyProtoT> zzdsm, boolean z) throws GeneralSecurityException {
        synchronized (zzdsx.class) {
            String keyType = zzdsm.getKeyType();
            zza(keyType, zzdsm.getClass(), true);
            if (!zzhjm.containsKey(keyType)) {
                zzhjm.put(keyType, zza(zzdsm));
                zzhjn.put(keyType, zzb(zzdsm));
            }
            zzhjo.put(keyType, true);
        }
    }

    public static synchronized <P> void zza(zzdsw<P> zzdsw) throws GeneralSecurityException {
        synchronized (zzdsx.class) {
            if (zzdsw != null) {
                Class<P> zzawu = zzdsw.zzawu();
                if (zzhjq.containsKey(zzawu)) {
                    zzdsw zzdsw2 = (zzdsw) zzhjq.get(zzawu);
                    if (!zzdsw.getClass().equals(zzdsw2.getClass())) {
                        Logger logger2 = logger;
                        Level level = Level.WARNING;
                        String valueOf = String.valueOf(zzawu.toString());
                        logger2.logp(level, "com.google.crypto.tink.Registry", "registerPrimitiveWrapper", valueOf.length() != 0 ? "Attempted overwrite of a registered SetWrapper for type ".concat(valueOf) : new String("Attempted overwrite of a registered SetWrapper for type "));
                        throw new GeneralSecurityException(String.format("SetWrapper for primitive (%s) is already registered to be %s, cannot be re-registered with %s", new Object[]{zzawu.getName(), zzdsw2.getClass().getName(), zzdsw.getClass().getName()}));
                    }
                }
                zzhjq.put(zzawu, zzdsw);
            } else {
                throw new IllegalArgumentException("wrapper must be non-null");
            }
        }
    }

    public static synchronized <KeyProtoT extends zzedo, PublicKeyProtoT extends zzedo> void zza(zzdsy<KeyProtoT, PublicKeyProtoT> zzdsy, zzdsm<PublicKeyProtoT> zzdsm, boolean z) throws GeneralSecurityException {
        Class<?> zzaxk;
        synchronized (zzdsx.class) {
            String keyType = zzdsy.getKeyType();
            String keyType2 = zzdsm.getKeyType();
            zza(keyType, zzdsy.getClass(), true);
            zza(keyType2, zzdsm.getClass(), false);
            if (!keyType.equals(keyType2)) {
                if (zzhjm.containsKey(keyType) && (zzaxk = ((zza) zzhjm.get(keyType)).zzaxk()) != null) {
                    if (!zzaxk.equals(zzdsm.getClass())) {
                        Logger logger2 = logger;
                        Level level = Level.WARNING;
                        StringBuilder sb = new StringBuilder(keyType.length() + 96 + String.valueOf(keyType2).length());
                        sb.append("Attempted overwrite of a registered key manager for key type ");
                        sb.append(keyType);
                        sb.append(" with inconsistent public key type ");
                        sb.append(keyType2);
                        logger2.logp(level, "com.google.crypto.tink.Registry", "registerAsymmetricKeyManagers", sb.toString());
                        throw new GeneralSecurityException(String.format("public key manager corresponding to %s is already registered with %s, cannot be re-registered with %s", new Object[]{zzdsy.getClass().getName(), zzaxk.getName(), zzdsm.getClass().getName()}));
                    }
                }
                if (!zzhjm.containsKey(keyType) || ((zza) zzhjm.get(keyType)).zzaxk() == null) {
                    zzhjm.put(keyType, new zzdtc(zzdsy, zzdsm));
                    zzhjn.put(keyType, zzb(zzdsy));
                }
                zzhjo.put(keyType, true);
                if (!zzhjm.containsKey(keyType2)) {
                    zzhjm.put(keyType2, zza(zzdsm));
                }
                zzhjo.put(keyType2, false);
            } else {
                throw new GeneralSecurityException("Private and public key type must be different.");
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0092, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static synchronized <P> void zza(java.lang.String r8, java.lang.Class<?> r9, boolean r10) throws java.security.GeneralSecurityException {
        /*
            java.lang.Class<com.google.android.gms.internal.ads.zzdsx> r0 = com.google.android.gms.internal.ads.zzdsx.class
            monitor-enter(r0)
            java.util.concurrent.ConcurrentMap<java.lang.String, com.google.android.gms.internal.ads.zzdsx$zza> r1 = zzhjm     // Catch:{ all -> 0x0093 }
            boolean r1 = r1.containsKey(r8)     // Catch:{ all -> 0x0093 }
            if (r1 != 0) goto L_0x000d
            monitor-exit(r0)
            return
        L_0x000d:
            java.util.concurrent.ConcurrentMap<java.lang.String, com.google.android.gms.internal.ads.zzdsx$zza> r1 = zzhjm     // Catch:{ all -> 0x0093 }
            java.lang.Object r1 = r1.get(r8)     // Catch:{ all -> 0x0093 }
            com.google.android.gms.internal.ads.zzdsx$zza r1 = (com.google.android.gms.internal.ads.zzdsx.zza) r1     // Catch:{ all -> 0x0093 }
            java.lang.Class r2 = r1.zzaxj()     // Catch:{ all -> 0x0093 }
            boolean r2 = r2.equals(r9)     // Catch:{ all -> 0x0093 }
            if (r2 != 0) goto L_0x0065
            java.util.logging.Logger r10 = logger     // Catch:{ all -> 0x0093 }
            java.util.logging.Level r2 = java.util.logging.Level.WARNING     // Catch:{ all -> 0x0093 }
            java.lang.String r3 = "com.google.crypto.tink.Registry"
            java.lang.String r4 = "ensureKeyManagerInsertable"
            java.lang.String r5 = "Attempted overwrite of a registered key manager for key type "
            java.lang.String r6 = java.lang.String.valueOf(r8)     // Catch:{ all -> 0x0093 }
            int r7 = r6.length()     // Catch:{ all -> 0x0093 }
            if (r7 == 0) goto L_0x0038
            java.lang.String r5 = r5.concat(r6)     // Catch:{ all -> 0x0093 }
            goto L_0x003e
        L_0x0038:
            java.lang.String r6 = new java.lang.String     // Catch:{ all -> 0x0093 }
            r6.<init>(r5)     // Catch:{ all -> 0x0093 }
            r5 = r6
        L_0x003e:
            r10.logp(r2, r3, r4, r5)     // Catch:{ all -> 0x0093 }
            java.security.GeneralSecurityException r10 = new java.security.GeneralSecurityException     // Catch:{ all -> 0x0093 }
            java.lang.String r2 = "typeUrl (%s) is already registered with %s, cannot be re-registered with %s"
            r3 = 3
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ all -> 0x0093 }
            r4 = 0
            r3[r4] = r8     // Catch:{ all -> 0x0093 }
            r8 = 1
            java.lang.Class r1 = r1.zzaxj()     // Catch:{ all -> 0x0093 }
            java.lang.String r1 = r1.getName()     // Catch:{ all -> 0x0093 }
            r3[r8] = r1     // Catch:{ all -> 0x0093 }
            r8 = 2
            java.lang.String r9 = r9.getName()     // Catch:{ all -> 0x0093 }
            r3[r8] = r9     // Catch:{ all -> 0x0093 }
            java.lang.String r8 = java.lang.String.format(r2, r3)     // Catch:{ all -> 0x0093 }
            r10.<init>(r8)     // Catch:{ all -> 0x0093 }
            throw r10     // Catch:{ all -> 0x0093 }
        L_0x0065:
            if (r10 == 0) goto L_0x0091
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.Boolean> r9 = zzhjo     // Catch:{ all -> 0x0093 }
            java.lang.Object r9 = r9.get(r8)     // Catch:{ all -> 0x0093 }
            java.lang.Boolean r9 = (java.lang.Boolean) r9     // Catch:{ all -> 0x0093 }
            boolean r9 = r9.booleanValue()     // Catch:{ all -> 0x0093 }
            if (r9 != 0) goto L_0x0091
            java.security.GeneralSecurityException r9 = new java.security.GeneralSecurityException     // Catch:{ all -> 0x0093 }
            java.lang.String r10 = "New keys are already disallowed for key type "
            java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch:{ all -> 0x0093 }
            int r1 = r8.length()     // Catch:{ all -> 0x0093 }
            if (r1 == 0) goto L_0x0088
            java.lang.String r8 = r10.concat(r8)     // Catch:{ all -> 0x0093 }
            goto L_0x008d
        L_0x0088:
            java.lang.String r8 = new java.lang.String     // Catch:{ all -> 0x0093 }
            r8.<init>(r10)     // Catch:{ all -> 0x0093 }
        L_0x008d:
            r9.<init>(r8)     // Catch:{ all -> 0x0093 }
            throw r9     // Catch:{ all -> 0x0093 }
        L_0x0091:
            monitor-exit(r0)
            return
        L_0x0093:
            r8 = move-exception
            monitor-exit(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdsx.zza(java.lang.String, java.lang.Class, boolean):void");
    }

    private static <KeyProtoT extends zzedo> zzb zzb(zzdsm<KeyProtoT> zzdsm) {
        return new zzdtb(zzdsm);
    }

    public static synchronized zzedo zzb(zzdxl zzdxl) throws GeneralSecurityException {
        zzedo zzn;
        synchronized (zzdsx.class) {
            zzdsh<?> zzhk = zzhk(zzdxl.zzbad());
            if (((Boolean) zzhjo.get(zzdxl.zzbad())).booleanValue()) {
                zzn = zzhk.zzn(zzdxl.zzbae());
            } else {
                String valueOf = String.valueOf(zzdxl.zzbad());
                throw new GeneralSecurityException(valueOf.length() != 0 ? "newKey-operation not permitted for key type ".concat(valueOf) : new String("newKey-operation not permitted for key type "));
            }
        }
        return zzn;
    }

    private static synchronized zza zzhi(String str) throws GeneralSecurityException {
        zza zza2;
        synchronized (zzdsx.class) {
            if (!zzhjm.containsKey(str)) {
                String valueOf = String.valueOf(str);
                throw new GeneralSecurityException(valueOf.length() != 0 ? "No key manager found for key type ".concat(valueOf) : new String("No key manager found for key type "));
            }
            zza2 = (zza) zzhjm.get(str);
        }
        return zza2;
    }

    @Deprecated
    public static zzdse<?> zzhj(String str) throws GeneralSecurityException {
        String str2;
        String str3;
        if (str != null) {
            zzdse<?> zzdse = (zzdse) zzhjp.get(str.toLowerCase());
            if (zzdse != null) {
                return zzdse;
            }
            String format = String.format("no catalogue found for %s. ", new Object[]{str});
            if (str.toLowerCase().startsWith("tinkaead")) {
                format = String.valueOf(format).concat("Maybe call AeadConfig.register().");
            }
            if (str.toLowerCase().startsWith("tinkdeterministicaead")) {
                str2 = String.valueOf(format);
                str3 = "Maybe call DeterministicAeadConfig.register().";
            } else if (str.toLowerCase().startsWith("tinkstreamingaead")) {
                str2 = String.valueOf(format);
                str3 = "Maybe call StreamingAeadConfig.register().";
            } else if (str.toLowerCase().startsWith("tinkhybriddecrypt") || str.toLowerCase().startsWith("tinkhybridencrypt")) {
                str2 = String.valueOf(format);
                str3 = "Maybe call HybridConfig.register().";
            } else if (str.toLowerCase().startsWith("tinkmac")) {
                str2 = String.valueOf(format);
                str3 = "Maybe call MacConfig.register().";
            } else if (str.toLowerCase().startsWith("tinkpublickeysign") || str.toLowerCase().startsWith("tinkpublickeyverify")) {
                str2 = String.valueOf(format);
                str3 = "Maybe call SignatureConfig.register().";
            } else {
                if (str.toLowerCase().startsWith("tink")) {
                    str2 = String.valueOf(format);
                    str3 = "Maybe call TinkConfig.register().";
                }
                throw new GeneralSecurityException(format);
            }
            format = str2.concat(str3);
            throw new GeneralSecurityException(format);
        }
        throw new IllegalArgumentException("catalogueName must be non-null.");
    }

    private static zzdsh<?> zzhk(String str) throws GeneralSecurityException {
        return zzhi(str).zzaxi();
    }
}
