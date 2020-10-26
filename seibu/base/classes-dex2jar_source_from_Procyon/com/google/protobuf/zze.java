// 
// Decompiled by Procyon v0.5.36
// 

package com.google.protobuf;

import java.util.logging.Level;
import java.security.PrivilegedExceptionAction;
import java.security.AccessController;
import java.lang.reflect.Field;
import java.nio.ByteOrder;
import java.nio.Buffer;
import sun.misc.Unsafe;
import java.util.logging.Logger;

final class zze
{
    private static final Logger logger;
    private static final boolean zzcrM;
    private static final long zzcrN;
    private static final Unsafe zzcrT;
    private static final Class<?> zzcrU;
    private static final boolean zzcrV;
    private static final boolean zzcrW;
    private static final boolean zzcrX;
    private static final zzd zzcrY;
    private static final boolean zzcrZ;
    private static final boolean zzcsa;
    private static final long zzcsb;
    private static final boolean zzcsc;
    
    static {
        final boolean b = true;
        logger = Logger.getLogger(zze.class.getName());
        zzcrT = zzLv();
        zzcrU = zzhP("libcore.io.Memory");
        zzcrV = (zzhP("org.robolectric.Robolectric") != null);
        zzcrW = zzg(Long.TYPE);
        zzcrX = zzg(Integer.TYPE);
        Object zzcrY2;
        if (zze.zzcrT == null) {
            zzcrY2 = null;
        }
        else if (zzLz()) {
            if (zze.zzcrW) {
                zzcrY2 = new zzb(zze.zzcrT);
            }
            else if (zze.zzcrX) {
                zzcrY2 = new zza(zze.zzcrT);
            }
            else {
                zzcrY2 = null;
            }
        }
        else {
            zzcrY2 = new zzc(zze.zzcrT);
        }
        zzcrY = (zzd)zzcrY2;
        zzcrZ = zzLy();
        zzcrM = zzLw();
        zzcsa = zzLx();
        int arrayBaseOffset;
        if (zze.zzcrM) {
            arrayBaseOffset = zze.zzcrY.zzcsd.arrayBaseOffset(byte[].class);
        }
        else {
            arrayBaseOffset = -1;
        }
        zzcrN = arrayBaseOffset;
        while (true) {
            Label_0248: {
                if (!zzLz()) {
                    break Label_0248;
                }
                final Field f = zza(Buffer.class, "effectiveDirectAddress");
                if (f == null) {
                    break Label_0248;
                }
                long objectFieldOffset;
                if (f == null || zze.zzcrY == null) {
                    objectFieldOffset = -1L;
                }
                else {
                    objectFieldOffset = zze.zzcrY.zzcsd.objectFieldOffset(f);
                }
                zzcsb = objectFieldOffset;
                zzcsc = (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN && b);
                return;
            }
            final Field f = zza(Buffer.class, "address");
            continue;
        }
    }
    
    private zze() {
    }
    
    static boolean zzLt() {
        return zze.zzcrM;
    }
    
    static long zzLu() {
        return zze.zzcrN;
    }
    
    private static Unsafe zzLv() {
        try {
            return AccessController.doPrivileged((PrivilegedExceptionAction<Unsafe>)new zzf());
        }
        catch (Throwable t) {
            return null;
        }
    }
    
    private static boolean zzLw() {
        if (zze.zzcrT == null) {
            return false;
        }
        try {
            final Class<? extends Unsafe> class1 = zze.zzcrT.getClass();
            class1.getMethod("objectFieldOffset", Field.class);
            class1.getMethod("arrayBaseOffset", Class.class);
            class1.getMethod("getInt", Object.class, Long.TYPE);
            class1.getMethod("putInt", Object.class, Long.TYPE, Integer.TYPE);
            class1.getMethod("getLong", Object.class, Long.TYPE);
            class1.getMethod("putLong", Object.class, Long.TYPE, Long.TYPE);
            class1.getMethod("getObject", Object.class, Long.TYPE);
            class1.getMethod("putObject", Object.class, Long.TYPE, Object.class);
            if (zzLz()) {
                return true;
            }
            class1.getMethod("getByte", Object.class, Long.TYPE);
            class1.getMethod("putByte", Object.class, Long.TYPE, Byte.TYPE);
            class1.getMethod("getBoolean", Object.class, Long.TYPE);
            class1.getMethod("putBoolean", Object.class, Long.TYPE, Boolean.TYPE);
            class1.getMethod("getFloat", Object.class, Long.TYPE);
            class1.getMethod("putFloat", Object.class, Long.TYPE, Float.TYPE);
            class1.getMethod("getDouble", Object.class, Long.TYPE);
            class1.getMethod("putDouble", Object.class, Long.TYPE, Double.TYPE);
            return true;
        }
        catch (Throwable obj) {
            final Logger logger = zze.logger;
            final Level warning = Level.WARNING;
            final String value = String.valueOf(obj);
            logger.logp(warning, "com.google.protobuf.UnsafeUtil", "supportsUnsafeArrayOperations", new StringBuilder(String.valueOf(value).length() + 71).append("platform method missing - proto runtime falling back to safer methods: ").append(value).toString());
            return false;
        }
    }
    
    private static boolean zzLx() {
        if (zze.zzcrT == null) {
            return false;
        }
        try {
            zze.zzcrT.getClass().getMethod("copyMemory", Object.class, Long.TYPE, Object.class, Long.TYPE, Long.TYPE);
            return true;
        }
        catch (Throwable t) {
            zze.logger.logp(Level.WARNING, "com.google.protobuf.UnsafeUtil", "supportsUnsafeCopyMemory", "copyMemory is missing from platform - proto runtime falling back to safer methods.");
            return false;
        }
    }
    
    private static boolean zzLy() {
        if (zze.zzcrT == null) {
            return false;
        }
        try {
            final Class<? extends Unsafe> class1 = zze.zzcrT.getClass();
            class1.getMethod("objectFieldOffset", Field.class);
            class1.getMethod("getLong", Object.class, Long.TYPE);
            if (zzLz()) {
                return true;
            }
            class1.getMethod("getByte", Long.TYPE);
            class1.getMethod("putByte", Long.TYPE, Byte.TYPE);
            class1.getMethod("getInt", Long.TYPE);
            class1.getMethod("putInt", Long.TYPE, Integer.TYPE);
            class1.getMethod("getLong", Long.TYPE);
            class1.getMethod("putLong", Long.TYPE, Long.TYPE);
            class1.getMethod("copyMemory", Long.TYPE, Long.TYPE, Long.TYPE);
            return true;
        }
        catch (Throwable obj) {
            final Logger logger = zze.logger;
            final Level warning = Level.WARNING;
            final String value = String.valueOf(obj);
            logger.logp(warning, "com.google.protobuf.UnsafeUtil", "supportsUnsafeByteBufferOperations", new StringBuilder(String.valueOf(value).length() + 71).append("platform method missing - proto runtime falling back to safer methods: ").append(value).toString());
            return false;
        }
    }
    
    private static boolean zzLz() {
        return zze.zzcrU != null && !zze.zzcrV;
    }
    
    private static Field zza(final Class<?> clazz, final String name) {
        try {
            final Field declaredField = clazz.getDeclaredField(name);
            declaredField.setAccessible(true);
            return declaredField;
        }
        catch (Throwable t) {
            return null;
        }
    }
    
    private static boolean zzg(final Class<?> clazz) {
        if (!zzLz()) {
            return false;
        }
        try {
            final Class<?> zzcrU = zze.zzcrU;
            zzcrU.getMethod("peekLong", clazz, Boolean.TYPE);
            zzcrU.getMethod("pokeLong", clazz, Long.TYPE, Boolean.TYPE);
            zzcrU.getMethod("pokeInt", clazz, Integer.TYPE, Boolean.TYPE);
            zzcrU.getMethod("peekInt", clazz, Boolean.TYPE);
            zzcrU.getMethod("pokeByte", clazz, Byte.TYPE);
            zzcrU.getMethod("peekByte", clazz);
            zzcrU.getMethod("pokeByteArray", clazz, byte[].class, Integer.TYPE, Integer.TYPE);
            zzcrU.getMethod("peekByteArray", clazz, byte[].class, Integer.TYPE, Integer.TYPE);
            return true;
        }
        catch (Throwable t) {
            return false;
        }
    }
    
    private static <T> Class<T> zzhP(final String className) {
        try {
            return (Class<T>)Class.forName(className);
        }
        catch (Throwable t) {
            return null;
        }
    }
    
    static final class zza extends zzd
    {
        zza(final Unsafe unsafe) {
            super(unsafe);
        }
    }
    
    static final class zzb extends zzd
    {
        zzb(final Unsafe unsafe) {
            super(unsafe);
        }
    }
    
    static final class zzc extends zzd
    {
        zzc(final Unsafe unsafe) {
            super(unsafe);
        }
    }
    
    static class zzd
    {
        Unsafe zzcsd;
        
        zzd(final Unsafe zzcsd) {
            this.zzcsd = zzcsd;
        }
    }
}
