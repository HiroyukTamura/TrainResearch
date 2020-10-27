package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbv;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

final class zzcn {
    private static boolean zznf = false;
    /* access modifiers changed from: private */
    public static MessageDigest zzng;
    private static final Object zznh = new Object();
    private static final Object zzni = new Object();
    static CountDownLatch zznj = new CountDownLatch(1);

    private static zzbv.zza zza(zzbv.zza.zzd zzd) {
        zzbv.zza.C2654zza zzar = zzbv.zza.zzar();
        zzar.zzn((long) zzd.zzw());
        return (zzbv.zza) ((zzecd) zzar.zzbet());
    }

    private static Vector<byte[]> zza(byte[] bArr, int i) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        int length = ((bArr.length + 255) - 1) / 255;
        Vector<byte[]> vector = new Vector<>();
        int i2 = 0;
        while (i2 < length) {
            int i3 = i2 * 255;
            try {
                vector.add(Arrays.copyOfRange(bArr, i3, bArr.length - i3 > 255 ? i3 + 255 : bArr.length));
                i2++;
            } catch (IndexOutOfBoundsException unused) {
                return null;
            }
        }
        return vector;
    }

    private static byte[] zza(byte[] bArr, String str, boolean z) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        ByteBuffer byteBuffer;
        int i = z ? 239 : 255;
        if (bArr.length > i) {
            bArr = zza(zzbv.zza.zzd.PSN_ENCODE_SIZE_FAIL).toByteArray();
        }
        if (bArr.length < i) {
            byte[] bArr2 = new byte[(i - bArr.length)];
            new SecureRandom().nextBytes(bArr2);
            byteBuffer = ByteBuffer.allocate(i + 1).put((byte) bArr.length).put(bArr).put(bArr2);
        } else {
            byteBuffer = ByteBuffer.allocate(i + 1).put((byte) bArr.length).put(bArr);
        }
        byte[] array = byteBuffer.array();
        if (z) {
            array = ByteBuffer.allocate(256).put(zzb(array)).put(array).array();
        }
        byte[] bArr3 = new byte[256];
        for (zzcu zza : new zzcs().zzvc) {
            zza.zza(array, bArr3);
        }
        if (str != null && str.length() > 0) {
            if (str.length() > 32) {
                str = str.substring(0, 32);
            }
            new zzeah(str.getBytes("UTF-8")).zzt(bArr3);
        }
        return bArr3;
    }

    public static byte[] zzb(byte[] bArr) throws NoSuchAlgorithmException {
        byte[] digest;
        synchronized (zznh) {
            MessageDigest zzbq = zzbq();
            if (zzbq != null) {
                zzbq.reset();
                zzbq.update(bArr);
                digest = zzng.digest();
            } else {
                throw new NoSuchAlgorithmException("Cannot compute hash");
            }
        }
        return digest;
    }

    static void zzbp() {
        synchronized (zzni) {
            if (!zznf) {
                zznf = true;
                new Thread(new zzcp()).start();
            }
        }
    }

    private static MessageDigest zzbq() {
        boolean z;
        MessageDigest messageDigest;
        zzbp();
        try {
            z = zznj.await(2, TimeUnit.SECONDS);
        } catch (InterruptedException unused) {
            z = false;
        }
        if (z && (messageDigest = zzng) != null) {
            return messageDigest;
        }
        return null;
    }

    static String zzj(zzbv.zza zza, String str) throws GeneralSecurityException, UnsupportedEncodingException {
        byte[] bArr;
        zzedo zzbet;
        byte[] byteArray = zza.toByteArray();
        if (((Boolean) zzvj.zzpv().zzd(zzzz.zzcoa)).booleanValue()) {
            Vector<byte[]> zza2 = zza(byteArray, 255);
            if (zza2 == null || zza2.size() == 0) {
                bArr = zza(zza(zzbv.zza.zzd.PSN_ENCODE_SIZE_FAIL).toByteArray(), str, true);
                return zzcl.zza(bArr, true);
            }
            zzbv.zzf.zza zzbm = zzbv.zzf.zzbm();
            Iterator<byte[]> it = zza2.iterator();
            while (it.hasNext()) {
                zzbm.zzj(zzeaq.zzu(zza(it.next(), str, false)));
            }
            zzbm.zzk(zzeaq.zzu(zzb(byteArray)));
            zzbet = zzbm.zzbet();
        } else if (zzer.zzza != null) {
            zzbet = zzbv.zzf.zzbm().zzj(zzeaq.zzu(zzer.zzza.zzc(byteArray, str != null ? str.getBytes() : new byte[0]))).zzb(zzcc.TINK_HYBRID).zzbet();
        } else {
            throw new GeneralSecurityException();
        }
        bArr = ((zzbv.zzf) ((zzecd) zzbet)).toByteArray();
        return zzcl.zza(bArr, true);
    }
}
