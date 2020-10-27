package com.google.android.gms.internal.fitness;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import p009e.p010a.p011a.p012a.C0681a;
import sun.misc.Unsafe;

final class zzja {
    private static final Logger logger = Logger.getLogger(zzja.class.getName());
    private static final long zzaaa;
    private static final int zzaab = ((int) (zzzn & 7));
    static final boolean zzaac = (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN);
    private static final Class<?> zzrf = zzfd.zzao();
    private static final boolean zzrt = zzdi();
    private static final Unsafe zzxr = zzdh();
    private static final boolean zzzj = zzj(Long.TYPE);
    private static final boolean zzzk = zzj(Integer.TYPE);
    private static final zzc zzzl;
    private static final boolean zzzm = zzdj();
    private static final long zzzn = ((long) zzh(byte[].class));
    private static final long zzzo;
    private static final long zzzp;
    private static final long zzzq;
    private static final long zzzr;
    private static final long zzzs;
    private static final long zzzt;
    private static final long zzzu;
    private static final long zzzv;
    private static final long zzzw;
    private static final long zzzx;
    private static final long zzzy;
    private static final long zzzz;

    static final class zza extends zzc {
        zza(Unsafe unsafe) {
            super(unsafe);
        }

        public final void zza(Object obj, long j, double d) {
            zza(obj, j, Double.doubleToLongBits(d));
        }

        public final void zza(Object obj, long j, float f) {
            zza(obj, j, Float.floatToIntBits(f));
        }

        public final void zza(Object obj, long j, boolean z) {
            if (zzja.zzaac) {
                zzja.zzb(obj, j, z);
            } else {
                zzja.zzc(obj, j, z);
            }
        }

        public final void zze(Object obj, long j, byte b) {
            if (zzja.zzaac) {
                zzja.zza(obj, j, b);
            } else {
                zzja.zzb(obj, j, b);
            }
        }

        public final boolean zzl(Object obj, long j) {
            return zzja.zzaac ? zzja.zzr(obj, j) : zzja.zzs(obj, j);
        }

        public final float zzm(Object obj, long j) {
            return Float.intBitsToFloat(zzj(obj, j));
        }

        public final double zzn(Object obj, long j) {
            return Double.longBitsToDouble(zzk(obj, j));
        }

        public final byte zzx(Object obj, long j) {
            return zzja.zzaac ? zzja.zzp(obj, j) : zzja.zzq(obj, j);
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
            zza(obj, j, Float.floatToIntBits(f));
        }

        public final void zza(Object obj, long j, boolean z) {
            if (zzja.zzaac) {
                zzja.zzb(obj, j, z);
            } else {
                zzja.zzc(obj, j, z);
            }
        }

        public final void zze(Object obj, long j, byte b) {
            if (zzja.zzaac) {
                zzja.zza(obj, j, b);
            } else {
                zzja.zzb(obj, j, b);
            }
        }

        public final boolean zzl(Object obj, long j) {
            return zzja.zzaac ? zzja.zzr(obj, j) : zzja.zzs(obj, j);
        }

        public final float zzm(Object obj, long j) {
            return Float.intBitsToFloat(zzj(obj, j));
        }

        public final double zzn(Object obj, long j) {
            return Double.longBitsToDouble(zzk(obj, j));
        }

        public final byte zzx(Object obj, long j) {
            return zzja.zzaac ? zzja.zzp(obj, j) : zzja.zzq(obj, j);
        }
    }

    static abstract class zzc {
        Unsafe zzaad;

        zzc(Unsafe unsafe) {
            this.zzaad = unsafe;
        }

        public abstract void zza(Object obj, long j, double d);

        public abstract void zza(Object obj, long j, float f);

        public final void zza(Object obj, long j, int i) {
            this.zzaad.putInt(obj, j, i);
        }

        public final void zza(Object obj, long j, long j2) {
            this.zzaad.putLong(obj, j, j2);
        }

        public abstract void zza(Object obj, long j, boolean z);

        public abstract void zze(Object obj, long j, byte b);

        public final int zzj(Object obj, long j) {
            return this.zzaad.getInt(obj, j);
        }

        public final long zzk(Object obj, long j) {
            return this.zzaad.getLong(obj, j);
        }

        public abstract boolean zzl(Object obj, long j);

        public abstract float zzm(Object obj, long j);

        public abstract double zzn(Object obj, long j);

        public abstract byte zzx(Object obj, long j);
    }

    static final class zzd extends zzc {
        zzd(Unsafe unsafe) {
            super(unsafe);
        }

        public final void zza(Object obj, long j, double d) {
            this.zzaad.putDouble(obj, j, d);
        }

        public final void zza(Object obj, long j, float f) {
            this.zzaad.putFloat(obj, j, f);
        }

        public final void zza(Object obj, long j, boolean z) {
            this.zzaad.putBoolean(obj, j, z);
        }

        public final void zze(Object obj, long j, byte b) {
            this.zzaad.putByte(obj, j, b);
        }

        public final boolean zzl(Object obj, long j) {
            return this.zzaad.getBoolean(obj, j);
        }

        public final float zzm(Object obj, long j) {
            return this.zzaad.getFloat(obj, j);
        }

        public final double zzn(Object obj, long j) {
            return this.zzaad.getDouble(obj, j);
        }

        public final byte zzx(Object obj, long j) {
            return this.zzaad.getByte(obj, j);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x00d0, code lost:
        r1 = zzzl;
     */
    static {
        /*
            java.lang.Class<java.lang.Object[]> r0 = java.lang.Object[].class
            java.lang.Class<double[]> r1 = double[].class
            java.lang.Class<float[]> r2 = float[].class
            java.lang.Class<long[]> r3 = long[].class
            java.lang.Class<int[]> r4 = int[].class
            java.lang.Class<boolean[]> r5 = boolean[].class
            java.lang.Class<com.google.android.gms.internal.fitness.zzja> r6 = com.google.android.gms.internal.fitness.zzja.class
            java.lang.String r6 = r6.getName()
            java.util.logging.Logger r6 = java.util.logging.Logger.getLogger(r6)
            logger = r6
            sun.misc.Unsafe r6 = zzdh()
            zzxr = r6
            java.lang.Class r6 = com.google.android.gms.internal.fitness.zzfd.zzao()
            zzrf = r6
            java.lang.Class r6 = java.lang.Long.TYPE
            boolean r6 = zzj(r6)
            zzzj = r6
            java.lang.Class r6 = java.lang.Integer.TYPE
            boolean r6 = zzj(r6)
            zzzk = r6
            sun.misc.Unsafe r6 = zzxr
            r7 = 0
            if (r6 != 0) goto L_0x003a
            goto L_0x005f
        L_0x003a:
            boolean r6 = com.google.android.gms.internal.fitness.zzfd.zzan()
            if (r6 == 0) goto L_0x0058
            boolean r6 = zzzj
            if (r6 == 0) goto L_0x004c
            com.google.android.gms.internal.fitness.zzja$zza r7 = new com.google.android.gms.internal.fitness.zzja$zza
            sun.misc.Unsafe r6 = zzxr
            r7.<init>(r6)
            goto L_0x005f
        L_0x004c:
            boolean r6 = zzzk
            if (r6 == 0) goto L_0x005f
            com.google.android.gms.internal.fitness.zzja$zzb r7 = new com.google.android.gms.internal.fitness.zzja$zzb
            sun.misc.Unsafe r6 = zzxr
            r7.<init>(r6)
            goto L_0x005f
        L_0x0058:
            com.google.android.gms.internal.fitness.zzja$zzd r7 = new com.google.android.gms.internal.fitness.zzja$zzd
            sun.misc.Unsafe r6 = zzxr
            r7.<init>(r6)
        L_0x005f:
            zzzl = r7
            boolean r6 = zzdj()
            zzzm = r6
            boolean r6 = zzdi()
            zzrt = r6
            java.lang.Class<byte[]> r6 = byte[].class
            int r6 = zzh(r6)
            long r6 = (long) r6
            zzzn = r6
            int r6 = zzh(r5)
            long r6 = (long) r6
            zzzo = r6
            int r5 = zzi(r5)
            long r5 = (long) r5
            zzzp = r5
            int r5 = zzh(r4)
            long r5 = (long) r5
            zzzq = r5
            int r4 = zzi(r4)
            long r4 = (long) r4
            zzzr = r4
            int r4 = zzh(r3)
            long r4 = (long) r4
            zzzs = r4
            int r3 = zzi(r3)
            long r3 = (long) r3
            zzzt = r3
            int r3 = zzh(r2)
            long r3 = (long) r3
            zzzu = r3
            int r2 = zzi(r2)
            long r2 = (long) r2
            zzzv = r2
            int r2 = zzh(r1)
            long r2 = (long) r2
            zzzw = r2
            int r1 = zzi(r1)
            long r1 = (long) r1
            zzzx = r1
            int r1 = zzh(r0)
            long r1 = (long) r1
            zzzy = r1
            int r0 = zzi(r0)
            long r0 = (long) r0
            zzzz = r0
            java.lang.reflect.Field r0 = zzdk()
            if (r0 == 0) goto L_0x00dc
            com.google.android.gms.internal.fitness.zzja$zzc r1 = zzzl
            if (r1 != 0) goto L_0x00d5
            goto L_0x00dc
        L_0x00d5:
            sun.misc.Unsafe r1 = r1.zzaad
            long r0 = r1.objectFieldOffset(r0)
            goto L_0x00de
        L_0x00dc:
            r0 = -1
        L_0x00de:
            zzaaa = r0
            long r0 = zzzn
            r2 = 7
            long r0 = r0 & r2
            int r1 = (int) r0
            zzaab = r1
            java.nio.ByteOrder r0 = java.nio.ByteOrder.nativeOrder()
            java.nio.ByteOrder r1 = java.nio.ByteOrder.BIG_ENDIAN
            if (r0 != r1) goto L_0x00f2
            r0 = 1
            goto L_0x00f3
        L_0x00f2:
            r0 = 0
        L_0x00f3:
            zzaac = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.fitness.zzja.<clinit>():void");
    }

    private zzja() {
    }

    static byte zza(byte[] bArr, long j) {
        return zzzl.zzx(bArr, zzzn + j);
    }

    /* access modifiers changed from: private */
    public static void zza(Object obj, long j, byte b) {
        long j2 = -4 & j;
        int i = ((((int) j) ^ -1) & 3) << 3;
        zza(obj, j2, ((255 & b) << i) | (zzj(obj, j2) & ((255 << i) ^ -1)));
    }

    static void zza(Object obj, long j, double d) {
        zzzl.zza(obj, j, d);
    }

    static void zza(Object obj, long j, float f) {
        zzzl.zza(obj, j, f);
    }

    static void zza(Object obj, long j, int i) {
        zzzl.zza(obj, j, i);
    }

    static void zza(Object obj, long j, long j2) {
        zzzl.zza(obj, j, j2);
    }

    static void zza(Object obj, long j, Object obj2) {
        zzzl.zzaad.putObject(obj, j, obj2);
    }

    static void zza(Object obj, long j, boolean z) {
        zzzl.zza(obj, j, z);
    }

    static void zza(byte[] bArr, long j, byte b) {
        zzzl.zze(bArr, zzzn + j, b);
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
        zza(obj, j2, ((255 & b) << i) | (zzj(obj, j2) & ((255 << i) ^ -1)));
    }

    /* access modifiers changed from: private */
    public static void zzb(Object obj, long j, boolean z) {
        zza(obj, j, z ? (byte) 1 : 0);
    }

    /* access modifiers changed from: private */
    public static void zzc(Object obj, long j, boolean z) {
        zzb(obj, j, z ? (byte) 1 : 0);
    }

    static boolean zzdf() {
        return zzrt;
    }

    static boolean zzdg() {
        return zzzm;
    }

    static Unsafe zzdh() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zziz());
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean zzdi() {
        Class<Object> cls = Object.class;
        Unsafe unsafe = zzxr;
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
            if (zzfd.zzan()) {
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

    private static boolean zzdj() {
        Class<Object> cls = Object.class;
        Unsafe unsafe = zzxr;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls2 = unsafe.getClass();
            cls2.getMethod("objectFieldOffset", new Class[]{Field.class});
            cls2.getMethod("getLong", new Class[]{cls, Long.TYPE});
            if (zzdk() == null) {
                return false;
            }
            if (zzfd.zzan()) {
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

    private static Field zzdk() {
        Field zzb2;
        if (zzfd.zzan() && (zzb2 = zzb(Buffer.class, "effectiveDirectAddress")) != null) {
            return zzb2;
        }
        Field zzb3 = zzb(Buffer.class, "address");
        if (zzb3 == null || zzb3.getType() != Long.TYPE) {
            return null;
        }
        return zzb3;
    }

    static <T> T zzg(Class<T> cls) {
        try {
            return zzxr.allocateInstance(cls);
        } catch (InstantiationException e) {
            throw new IllegalStateException(e);
        }
    }

    private static int zzh(Class<?> cls) {
        if (zzrt) {
            return zzzl.zzaad.arrayBaseOffset(cls);
        }
        return -1;
    }

    private static int zzi(Class<?> cls) {
        if (zzrt) {
            return zzzl.zzaad.arrayIndexScale(cls);
        }
        return -1;
    }

    static int zzj(Object obj, long j) {
        return zzzl.zzj(obj, j);
    }

    private static boolean zzj(Class<?> cls) {
        Class<byte[]> cls2 = byte[].class;
        if (!zzfd.zzan()) {
            return false;
        }
        try {
            Class<?> cls3 = zzrf;
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

    static long zzk(Object obj, long j) {
        return zzzl.zzk(obj, j);
    }

    static boolean zzl(Object obj, long j) {
        return zzzl.zzl(obj, j);
    }

    static float zzm(Object obj, long j) {
        return zzzl.zzm(obj, j);
    }

    static double zzn(Object obj, long j) {
        return zzzl.zzn(obj, j);
    }

    static Object zzo(Object obj, long j) {
        return zzzl.zzaad.getObject(obj, j);
    }

    /* access modifiers changed from: private */
    public static byte zzp(Object obj, long j) {
        return (byte) (zzj(obj, -4 & j) >>> ((int) (((j ^ -1) & 3) << 3)));
    }

    /* access modifiers changed from: private */
    public static byte zzq(Object obj, long j) {
        return (byte) (zzj(obj, -4 & j) >>> ((int) ((j & 3) << 3)));
    }

    /* access modifiers changed from: private */
    public static boolean zzr(Object obj, long j) {
        return zzp(obj, j) != 0;
    }

    /* access modifiers changed from: private */
    public static boolean zzs(Object obj, long j) {
        return zzq(obj, j) != 0;
    }
}
