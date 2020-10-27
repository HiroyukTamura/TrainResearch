package com.google.android.gms.internal.ads;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import p009e.p010a.p011a.p012a.C0681a;
import sun.misc.Unsafe;

final class zzefi {
    private static final Logger logger = Logger.getLogger(zzefi.class.getName());
    private static final Unsafe zzhgt = zzbhj();
    private static final Class<?> zzhsx = zzean.zzbcm();
    private static final boolean zzhui = zzbhk();
    private static final boolean zzicp = zzm(Long.TYPE);
    private static final boolean zzicq = zzm(Integer.TYPE);
    private static final zzc zzicr;
    private static final boolean zzics = zzbhl();
    private static final long zzict = ((long) zzk(byte[].class));
    private static final long zzicu;
    private static final long zzicv;
    private static final long zzicw;
    private static final long zzicx;
    private static final long zzicy;
    private static final long zzicz;
    private static final long zzida;
    private static final long zzidb;
    private static final long zzidc;
    private static final long zzidd;
    private static final long zzide;
    private static final long zzidf;
    private static final long zzidg;
    private static final int zzidh = ((int) (zzict & 7));
    static final boolean zzidi = (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN);

    static final class zza extends zzc {
        zza(Unsafe unsafe) {
            super(unsafe);
        }

        public final void zza(Object obj, long j, double d) {
            zza(obj, j, Double.doubleToLongBits(d));
        }

        public final void zza(Object obj, long j, float f) {
            zzb(obj, j, Float.floatToIntBits(f));
        }

        public final void zza(Object obj, long j, boolean z) {
            if (zzefi.zzidi) {
                zzefi.zzb(obj, j, z);
            } else {
                zzefi.zzc(obj, j, z);
            }
        }

        public final void zze(Object obj, long j, byte b) {
            if (zzefi.zzidi) {
                zzefi.zza(obj, j, b);
            } else {
                zzefi.zzb(obj, j, b);
            }
        }

        public final boolean zzm(Object obj, long j) {
            return zzefi.zzidi ? zzefi.zzs(obj, j) : zzefi.zzt(obj, j);
        }

        public final float zzn(Object obj, long j) {
            return Float.intBitsToFloat(zzk(obj, j));
        }

        public final double zzo(Object obj, long j) {
            return Double.longBitsToDouble(zzl(obj, j));
        }

        public final byte zzy(Object obj, long j) {
            return zzefi.zzidi ? zzefi.zzq(obj, j) : zzefi.zzr(obj, j);
        }
    }

    static final class zzb extends zzc {
        zzb(Unsafe unsafe) {
            super(unsafe);
        }

        public final void zza(Object obj, long j, double d) {
            zza(obj, j, Double.doubleToLongBits(d));
        }

        public final void zza(Object obj, long j, float f) {
            zzb(obj, j, Float.floatToIntBits(f));
        }

        public final void zza(Object obj, long j, boolean z) {
            if (zzefi.zzidi) {
                zzefi.zzb(obj, j, z);
            } else {
                zzefi.zzc(obj, j, z);
            }
        }

        public final void zze(Object obj, long j, byte b) {
            if (zzefi.zzidi) {
                zzefi.zza(obj, j, b);
            } else {
                zzefi.zzb(obj, j, b);
            }
        }

        public final boolean zzm(Object obj, long j) {
            return zzefi.zzidi ? zzefi.zzs(obj, j) : zzefi.zzt(obj, j);
        }

        public final float zzn(Object obj, long j) {
            return Float.intBitsToFloat(zzk(obj, j));
        }

        public final double zzo(Object obj, long j) {
            return Double.longBitsToDouble(zzl(obj, j));
        }

        public final byte zzy(Object obj, long j) {
            return zzefi.zzidi ? zzefi.zzq(obj, j) : zzefi.zzr(obj, j);
        }
    }

    static abstract class zzc {
        Unsafe zzidj;

        zzc(Unsafe unsafe) {
            this.zzidj = unsafe;
        }

        public abstract void zza(Object obj, long j, double d);

        public abstract void zza(Object obj, long j, float f);

        public final void zza(Object obj, long j, long j2) {
            this.zzidj.putLong(obj, j, j2);
        }

        public abstract void zza(Object obj, long j, boolean z);

        public final void zzb(Object obj, long j, int i) {
            this.zzidj.putInt(obj, j, i);
        }

        public abstract void zze(Object obj, long j, byte b);

        public final int zzk(Object obj, long j) {
            return this.zzidj.getInt(obj, j);
        }

        public final long zzl(Object obj, long j) {
            return this.zzidj.getLong(obj, j);
        }

        public abstract boolean zzm(Object obj, long j);

        public abstract float zzn(Object obj, long j);

        public abstract double zzo(Object obj, long j);

        public abstract byte zzy(Object obj, long j);
    }

    static final class zzd extends zzc {
        zzd(Unsafe unsafe) {
            super(unsafe);
        }

        public final void zza(Object obj, long j, double d) {
            this.zzidj.putDouble(obj, j, d);
        }

        public final void zza(Object obj, long j, float f) {
            this.zzidj.putFloat(obj, j, f);
        }

        public final void zza(Object obj, long j, boolean z) {
            this.zzidj.putBoolean(obj, j, z);
        }

        public final void zze(Object obj, long j, byte b) {
            this.zzidj.putByte(obj, j, b);
        }

        public final boolean zzm(Object obj, long j) {
            return this.zzidj.getBoolean(obj, j);
        }

        public final float zzn(Object obj, long j) {
            return this.zzidj.getFloat(obj, j);
        }

        public final double zzo(Object obj, long j) {
            return this.zzidj.getDouble(obj, j);
        }

        public final byte zzy(Object obj, long j) {
            return this.zzidj.getByte(obj, j);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x00d0, code lost:
        r1 = zzicr;
     */
    static {
        /*
            java.lang.Class<java.lang.Object[]> r0 = java.lang.Object[].class
            java.lang.Class<double[]> r1 = double[].class
            java.lang.Class<float[]> r2 = float[].class
            java.lang.Class<long[]> r3 = long[].class
            java.lang.Class<int[]> r4 = int[].class
            java.lang.Class<boolean[]> r5 = boolean[].class
            java.lang.Class<com.google.android.gms.internal.ads.zzefi> r6 = com.google.android.gms.internal.ads.zzefi.class
            java.lang.String r6 = r6.getName()
            java.util.logging.Logger r6 = java.util.logging.Logger.getLogger(r6)
            logger = r6
            sun.misc.Unsafe r6 = zzbhj()
            zzhgt = r6
            java.lang.Class r6 = com.google.android.gms.internal.ads.zzean.zzbcm()
            zzhsx = r6
            java.lang.Class r6 = java.lang.Long.TYPE
            boolean r6 = zzm(r6)
            zzicp = r6
            java.lang.Class r6 = java.lang.Integer.TYPE
            boolean r6 = zzm(r6)
            zzicq = r6
            sun.misc.Unsafe r6 = zzhgt
            r7 = 0
            if (r6 != 0) goto L_0x003a
            goto L_0x005f
        L_0x003a:
            boolean r6 = com.google.android.gms.internal.ads.zzean.zzbcl()
            if (r6 == 0) goto L_0x0058
            boolean r6 = zzicp
            if (r6 == 0) goto L_0x004c
            com.google.android.gms.internal.ads.zzefi$zza r7 = new com.google.android.gms.internal.ads.zzefi$zza
            sun.misc.Unsafe r6 = zzhgt
            r7.<init>(r6)
            goto L_0x005f
        L_0x004c:
            boolean r6 = zzicq
            if (r6 == 0) goto L_0x005f
            com.google.android.gms.internal.ads.zzefi$zzb r7 = new com.google.android.gms.internal.ads.zzefi$zzb
            sun.misc.Unsafe r6 = zzhgt
            r7.<init>(r6)
            goto L_0x005f
        L_0x0058:
            com.google.android.gms.internal.ads.zzefi$zzd r7 = new com.google.android.gms.internal.ads.zzefi$zzd
            sun.misc.Unsafe r6 = zzhgt
            r7.<init>(r6)
        L_0x005f:
            zzicr = r7
            boolean r6 = zzbhl()
            zzics = r6
            boolean r6 = zzbhk()
            zzhui = r6
            java.lang.Class<byte[]> r6 = byte[].class
            int r6 = zzk(r6)
            long r6 = (long) r6
            zzict = r6
            int r6 = zzk(r5)
            long r6 = (long) r6
            zzicu = r6
            int r5 = zzl(r5)
            long r5 = (long) r5
            zzicv = r5
            int r5 = zzk(r4)
            long r5 = (long) r5
            zzicw = r5
            int r4 = zzl(r4)
            long r4 = (long) r4
            zzicx = r4
            int r4 = zzk(r3)
            long r4 = (long) r4
            zzicy = r4
            int r3 = zzl(r3)
            long r3 = (long) r3
            zzicz = r3
            int r3 = zzk(r2)
            long r3 = (long) r3
            zzida = r3
            int r2 = zzl(r2)
            long r2 = (long) r2
            zzidb = r2
            int r2 = zzk(r1)
            long r2 = (long) r2
            zzidc = r2
            int r1 = zzl(r1)
            long r1 = (long) r1
            zzidd = r1
            int r1 = zzk(r0)
            long r1 = (long) r1
            zzide = r1
            int r0 = zzl(r0)
            long r0 = (long) r0
            zzidf = r0
            java.lang.reflect.Field r0 = zzbhm()
            if (r0 == 0) goto L_0x00dc
            com.google.android.gms.internal.ads.zzefi$zzc r1 = zzicr
            if (r1 != 0) goto L_0x00d5
            goto L_0x00dc
        L_0x00d5:
            sun.misc.Unsafe r1 = r1.zzidj
            long r0 = r1.objectFieldOffset(r0)
            goto L_0x00de
        L_0x00dc:
            r0 = -1
        L_0x00de:
            zzidg = r0
            long r0 = zzict
            r2 = 7
            long r0 = r0 & r2
            int r1 = (int) r0
            zzidh = r1
            java.nio.ByteOrder r0 = java.nio.ByteOrder.nativeOrder()
            java.nio.ByteOrder r1 = java.nio.ByteOrder.BIG_ENDIAN
            if (r0 != r1) goto L_0x00f2
            r0 = 1
            goto L_0x00f3
        L_0x00f2:
            r0 = 0
        L_0x00f3:
            zzidi = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzefi.<clinit>():void");
    }

    private zzefi() {
    }

    static byte zza(byte[] bArr, long j) {
        return zzicr.zzy(bArr, zzict + j);
    }

    /* access modifiers changed from: private */
    public static void zza(Object obj, long j, byte b) {
        long j2 = -4 & j;
        int i = ((((int) j) ^ -1) & 3) << 3;
        zzb(obj, j2, ((255 & b) << i) | (zzk(obj, j2) & ((255 << i) ^ -1)));
    }

    static void zza(Object obj, long j, double d) {
        zzicr.zza(obj, j, d);
    }

    static void zza(Object obj, long j, float f) {
        zzicr.zza(obj, j, f);
    }

    static void zza(Object obj, long j, long j2) {
        zzicr.zza(obj, j, j2);
    }

    static void zza(Object obj, long j, Object obj2) {
        zzicr.zzidj.putObject(obj, j, obj2);
    }

    static void zza(Object obj, long j, boolean z) {
        zzicr.zza(obj, j, z);
    }

    static void zza(byte[] bArr, long j, byte b) {
        zzicr.zze(bArr, zzict + j, b);
    }

    private static Field zzb(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    public static void zzb(Object obj, long j, byte b) {
        long j2 = -4 & j;
        int i = (((int) j) & 3) << 3;
        zzb(obj, j2, ((255 & b) << i) | (zzk(obj, j2) & ((255 << i) ^ -1)));
    }

    static void zzb(Object obj, long j, int i) {
        zzicr.zzb(obj, j, i);
    }

    /* access modifiers changed from: private */
    public static void zzb(Object obj, long j, boolean z) {
        zza(obj, j, z ? (byte) 1 : 0);
    }

    static boolean zzbhh() {
        return zzhui;
    }

    static boolean zzbhi() {
        return zzics;
    }

    static Unsafe zzbhj() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzefh());
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean zzbhk() {
        Class<Object> cls = Object.class;
        Unsafe unsafe = zzhgt;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls2 = unsafe.getClass();
            cls2.getMethod("objectFieldOffset", new Class[]{Field.class});
            cls2.getMethod("arrayBaseOffset", new Class[]{Class.class});
            cls2.getMethod("arrayIndexScale", new Class[]{Class.class});
            cls2.getMethod("getInt", new Class[]{cls, Long.TYPE});
            cls2.getMethod("putInt", new Class[]{cls, Long.TYPE, Integer.TYPE});
            cls2.getMethod("getLong", new Class[]{cls, Long.TYPE});
            cls2.getMethod("putLong", new Class[]{cls, Long.TYPE, Long.TYPE});
            cls2.getMethod("getObject", new Class[]{cls, Long.TYPE});
            cls2.getMethod("putObject", new Class[]{cls, Long.TYPE, cls});
            if (zzean.zzbcl()) {
                return true;
            }
            cls2.getMethod("getByte", new Class[]{cls, Long.TYPE});
            cls2.getMethod("putByte", new Class[]{cls, Long.TYPE, Byte.TYPE});
            cls2.getMethod("getBoolean", new Class[]{cls, Long.TYPE});
            cls2.getMethod("putBoolean", new Class[]{cls, Long.TYPE, Boolean.TYPE});
            cls2.getMethod("getFloat", new Class[]{cls, Long.TYPE});
            cls2.getMethod("putFloat", new Class[]{cls, Long.TYPE, Float.TYPE});
            cls2.getMethod("getDouble", new Class[]{cls, Long.TYPE});
            cls2.getMethod("putDouble", new Class[]{cls, Long.TYPE, Double.TYPE});
            return true;
        } catch (Throwable th) {
            Logger logger2 = logger;
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            logger2.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeArrayOperations", C0681a.m312a(valueOf.length() + 71, "platform method missing - proto runtime falling back to safer methods: ", valueOf));
            return false;
        }
    }

    private static boolean zzbhl() {
        Class<Object> cls = Object.class;
        Unsafe unsafe = zzhgt;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls2 = unsafe.getClass();
            cls2.getMethod("objectFieldOffset", new Class[]{Field.class});
            cls2.getMethod("getLong", new Class[]{cls, Long.TYPE});
            if (zzbhm() == null) {
                return false;
            }
            if (zzean.zzbcl()) {
                return true;
            }
            cls2.getMethod("getByte", new Class[]{Long.TYPE});
            cls2.getMethod("putByte", new Class[]{Long.TYPE, Byte.TYPE});
            cls2.getMethod("getInt", new Class[]{Long.TYPE});
            cls2.getMethod("putInt", new Class[]{Long.TYPE, Integer.TYPE});
            cls2.getMethod("getLong", new Class[]{Long.TYPE});
            cls2.getMethod("putLong", new Class[]{Long.TYPE, Long.TYPE});
            cls2.getMethod("copyMemory", new Class[]{Long.TYPE, Long.TYPE, Long.TYPE});
            cls2.getMethod("copyMemory", new Class[]{cls, Long.TYPE, cls, Long.TYPE, Long.TYPE});
            return true;
        } catch (Throwable th) {
            Logger logger2 = logger;
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            logger2.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeByteBufferOperations", C0681a.m312a(valueOf.length() + 71, "platform method missing - proto runtime falling back to safer methods: ", valueOf));
            return false;
        }
    }

    private static Field zzbhm() {
        Field zzb2;
        if (zzean.zzbcl() && (zzb2 = zzb(Buffer.class, "effectiveDirectAddress")) != null) {
            return zzb2;
        }
        Field zzb3 = zzb(Buffer.class, "address");
        if (zzb3 == null || zzb3.getType() != Long.TYPE) {
            return null;
        }
        return zzb3;
    }

    /* access modifiers changed from: private */
    public static void zzc(Object obj, long j, boolean z) {
        zzb(obj, j, z ? (byte) 1 : 0);
    }

    static <T> T zzj(Class<T> cls) {
        try {
            return zzhgt.allocateInstance(cls);
        } catch (InstantiationException e) {
            throw new IllegalStateException(e);
        }
    }

    private static int zzk(Class<?> cls) {
        if (zzhui) {
            return zzicr.zzidj.arrayBaseOffset(cls);
        }
        return -1;
    }

    static int zzk(Object obj, long j) {
        return zzicr.zzk(obj, j);
    }

    private static int zzl(Class<?> cls) {
        if (zzhui) {
            return zzicr.zzidj.arrayIndexScale(cls);
        }
        return -1;
    }

    static long zzl(Object obj, long j) {
        return zzicr.zzl(obj, j);
    }

    private static boolean zzm(Class<?> cls) {
        Class<byte[]> cls2 = byte[].class;
        if (!zzean.zzbcl()) {
            return false;
        }
        try {
            Class<?> cls3 = zzhsx;
            cls3.getMethod("peekLong", new Class[]{cls, Boolean.TYPE});
            cls3.getMethod("pokeLong", new Class[]{cls, Long.TYPE, Boolean.TYPE});
            cls3.getMethod("pokeInt", new Class[]{cls, Integer.TYPE, Boolean.TYPE});
            cls3.getMethod("peekInt", new Class[]{cls, Boolean.TYPE});
            cls3.getMethod("pokeByte", new Class[]{cls, Byte.TYPE});
            cls3.getMethod("peekByte", new Class[]{cls});
            cls3.getMethod("pokeByteArray", new Class[]{cls, cls2, Integer.TYPE, Integer.TYPE});
            cls3.getMethod("peekByteArray", new Class[]{cls, cls2, Integer.TYPE, Integer.TYPE});
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    static boolean zzm(Object obj, long j) {
        return zzicr.zzm(obj, j);
    }

    static float zzn(Object obj, long j) {
        return zzicr.zzn(obj, j);
    }

    static double zzo(Object obj, long j) {
        return zzicr.zzo(obj, j);
    }

    static Object zzp(Object obj, long j) {
        return zzicr.zzidj.getObject(obj, j);
    }

    /* access modifiers changed from: private */
    public static byte zzq(Object obj, long j) {
        return (byte) (zzk(obj, -4 & j) >>> ((int) (((j ^ -1) & 3) << 3)));
    }

    /* access modifiers changed from: private */
    public static byte zzr(Object obj, long j) {
        return (byte) (zzk(obj, -4 & j) >>> ((int) ((j & 3) << 3)));
    }

    /* access modifiers changed from: private */
    public static boolean zzs(Object obj, long j) {
        return zzq(obj, j) != 0;
    }

    /* access modifiers changed from: private */
    public static boolean zzt(Object obj, long j) {
        return zzr(obj, j) != 0;
    }
}
