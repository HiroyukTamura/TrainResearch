package com.google.android.gms.dynamite;

import android.content.Context;
import android.database.Cursor;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.CrashUtils;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import p009e.p010a.p011a.p012a.C0681a;

@KeepForSdk
public final class DynamiteModule {
    @KeepForSdk
    public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION = new zze();
    @KeepForSdk
    public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING = new zzd();
    @KeepForSdk
    public static final VersionPolicy PREFER_HIGHEST_OR_REMOTE_VERSION = new zzg();
    @KeepForSdk
    public static final VersionPolicy PREFER_LOCAL = new zzb();
    @KeepForSdk
    public static final VersionPolicy PREFER_REMOTE = new zzc();
    private static Boolean zziu = null;
    private static zzj zziv = null;
    private static zzl zziw = null;
    private static String zzix = null;
    private static int zziy = -1;
    private static final ThreadLocal<zza> zziz = new ThreadLocal<>();
    private static final VersionPolicy.zzb zzja = new zza();
    private static final VersionPolicy zzjb = new zzf();
    private final Context zzjc;

    @DynamiteApi
    public static class DynamiteLoaderClassLoader {
        public static ClassLoader sClassLoader;
    }

    @KeepForSdk
    public static class LoadingException extends Exception {
        private LoadingException(String str) {
            super(str);
        }

        /* synthetic */ LoadingException(String str, zza zza) {
            this(str);
        }

        private LoadingException(String str, Throwable th) {
            super(str, th);
        }

        /* synthetic */ LoadingException(String str, Throwable th, zza zza) {
            this(str, th);
        }
    }

    public interface VersionPolicy {

        public static class zza {
            public int zzjg = 0;
            public int zzjh = 0;
            public int zzji = 0;
        }

        public interface zzb {
            int getLocalVersion(Context context, String str);

            int zza(Context context, String str, boolean z) throws LoadingException;
        }

        zza zza(Context context, String str, zzb zzb2) throws LoadingException;
    }

    private static class zza {
        public Cursor zzjd;

        private zza() {
        }

        /* synthetic */ zza(zza zza) {
            this();
        }
    }

    private static class zzb implements VersionPolicy.zzb {
        private final int zzje;
        private final int zzjf = 0;

        public zzb(int i, int i2) {
            this.zzje = i;
        }

        public final int getLocalVersion(Context context, String str) {
            return this.zzje;
        }

        public final int zza(Context context, String str, boolean z) {
            return 0;
        }
    }

    private DynamiteModule(Context context) {
        this.zzjc = (Context) Preconditions.checkNotNull(context);
    }

    @KeepForSdk
    public static int getLocalVersion(Context context, String str) {
        try {
            ClassLoader classLoader = context.getApplicationContext().getClassLoader();
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 61);
            sb.append("com.google.android.gms.dynamite.descriptors.");
            sb.append(str);
            sb.append(".ModuleDescriptor");
            Class<?> loadClass = classLoader.loadClass(sb.toString());
            Field declaredField = loadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = loadClass.getDeclaredField("MODULE_VERSION");
            if (declaredField.get((Object) null).equals(str)) {
                return declaredField2.getInt((Object) null);
            }
            String valueOf = String.valueOf(declaredField.get((Object) null));
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 51 + String.valueOf(str).length());
            sb2.append("Module descriptor id '");
            sb2.append(valueOf);
            sb2.append("' didn't match expected id '");
            sb2.append(str);
            sb2.append("'");
            Log.e("DynamiteModule", sb2.toString());
            return 0;
        } catch (ClassNotFoundException unused) {
            StringBuilder sb3 = new StringBuilder(C0681a.m336b(str, 45));
            sb3.append("Local module descriptor class for ");
            sb3.append(str);
            sb3.append(" not found.");
            Log.w("DynamiteModule", sb3.toString());
            return 0;
        } catch (Exception e) {
            String valueOf2 = String.valueOf(e.getMessage());
            Log.e("DynamiteModule", valueOf2.length() != 0 ? "Failed to load module descriptor class: ".concat(valueOf2) : new String("Failed to load module descriptor class: "));
            return 0;
        }
    }

    @KeepForSdk
    public static int getRemoteVersion(Context context, String str) {
        return zza(context, str, false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x007c, code lost:
        if (r11 != null) goto L_0x007e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0093, code lost:
        if (r11 != null) goto L_0x007e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00cf, code lost:
        if (r11 != null) goto L_0x007e;
     */
    @com.google.android.gms.common.annotation.KeepForSdk
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.dynamite.DynamiteModule load(android.content.Context r10, com.google.android.gms.dynamite.DynamiteModule.VersionPolicy r11, java.lang.String r12) throws com.google.android.gms.dynamite.DynamiteModule.LoadingException {
        /*
            java.lang.String r0 = ":"
            java.lang.String r1 = "DynamiteModule"
            java.lang.ThreadLocal<com.google.android.gms.dynamite.DynamiteModule$zza> r2 = zziz
            java.lang.Object r2 = r2.get()
            com.google.android.gms.dynamite.DynamiteModule$zza r2 = (com.google.android.gms.dynamite.DynamiteModule.zza) r2
            com.google.android.gms.dynamite.DynamiteModule$zza r3 = new com.google.android.gms.dynamite.DynamiteModule$zza
            r4 = 0
            r3.<init>(r4)
            java.lang.ThreadLocal<com.google.android.gms.dynamite.DynamiteModule$zza> r5 = zziz
            r5.set(r3)
            com.google.android.gms.dynamite.DynamiteModule$VersionPolicy$zzb r5 = zzja     // Catch:{ all -> 0x011f }
            com.google.android.gms.dynamite.DynamiteModule$VersionPolicy$zza r5 = r11.zza(r10, r12, r5)     // Catch:{ all -> 0x011f }
            int r6 = r5.zzjg     // Catch:{ all -> 0x011f }
            int r7 = r5.zzjh     // Catch:{ all -> 0x011f }
            java.lang.String r8 = java.lang.String.valueOf(r12)     // Catch:{ all -> 0x011f }
            int r8 = r8.length()     // Catch:{ all -> 0x011f }
            int r8 = r8 + 68
            java.lang.String r9 = java.lang.String.valueOf(r12)     // Catch:{ all -> 0x011f }
            int r9 = r9.length()     // Catch:{ all -> 0x011f }
            int r8 = r8 + r9
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x011f }
            r9.<init>(r8)     // Catch:{ all -> 0x011f }
            java.lang.String r8 = "Considering local module "
            r9.append(r8)     // Catch:{ all -> 0x011f }
            r9.append(r12)     // Catch:{ all -> 0x011f }
            r9.append(r0)     // Catch:{ all -> 0x011f }
            r9.append(r6)     // Catch:{ all -> 0x011f }
            java.lang.String r6 = " and remote module "
            r9.append(r6)     // Catch:{ all -> 0x011f }
            r9.append(r12)     // Catch:{ all -> 0x011f }
            r9.append(r0)     // Catch:{ all -> 0x011f }
            r9.append(r7)     // Catch:{ all -> 0x011f }
            java.lang.String r0 = r9.toString()     // Catch:{ all -> 0x011f }
            android.util.Log.i(r1, r0)     // Catch:{ all -> 0x011f }
            int r0 = r5.zzji     // Catch:{ all -> 0x011f }
            if (r0 == 0) goto L_0x00f5
            int r0 = r5.zzji     // Catch:{ all -> 0x011f }
            r6 = -1
            if (r0 != r6) goto L_0x0069
            int r0 = r5.zzjg     // Catch:{ all -> 0x011f }
            if (r0 == 0) goto L_0x00f5
        L_0x0069:
            int r0 = r5.zzji     // Catch:{ all -> 0x011f }
            r7 = 1
            if (r0 != r7) goto L_0x0072
            int r0 = r5.zzjh     // Catch:{ all -> 0x011f }
            if (r0 == 0) goto L_0x00f5
        L_0x0072:
            int r0 = r5.zzji     // Catch:{ all -> 0x011f }
            if (r0 != r6) goto L_0x0087
            com.google.android.gms.dynamite.DynamiteModule r10 = zze(r10, r12)     // Catch:{ all -> 0x011f }
            android.database.Cursor r11 = r3.zzjd
            if (r11 == 0) goto L_0x0081
        L_0x007e:
            r11.close()
        L_0x0081:
            java.lang.ThreadLocal<com.google.android.gms.dynamite.DynamiteModule$zza> r11 = zziz
            r11.set(r2)
            return r10
        L_0x0087:
            int r0 = r5.zzji     // Catch:{ all -> 0x011f }
            if (r0 != r7) goto L_0x00da
            int r0 = r5.zzjh     // Catch:{ LoadingException -> 0x0096 }
            com.google.android.gms.dynamite.DynamiteModule r10 = zza((android.content.Context) r10, (java.lang.String) r12, (int) r0)     // Catch:{ LoadingException -> 0x0096 }
            android.database.Cursor r11 = r3.zzjd
            if (r11 == 0) goto L_0x0081
            goto L_0x007e
        L_0x0096:
            r0 = move-exception
            java.lang.String r7 = "Failed to load remote module: "
            java.lang.String r8 = r0.getMessage()     // Catch:{ all -> 0x011f }
            java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch:{ all -> 0x011f }
            int r9 = r8.length()     // Catch:{ all -> 0x011f }
            if (r9 == 0) goto L_0x00ac
            java.lang.String r7 = r7.concat(r8)     // Catch:{ all -> 0x011f }
            goto L_0x00b2
        L_0x00ac:
            java.lang.String r8 = new java.lang.String     // Catch:{ all -> 0x011f }
            r8.<init>(r7)     // Catch:{ all -> 0x011f }
            r7 = r8
        L_0x00b2:
            android.util.Log.w(r1, r7)     // Catch:{ all -> 0x011f }
            int r1 = r5.zzjg     // Catch:{ all -> 0x011f }
            if (r1 == 0) goto L_0x00d2
            com.google.android.gms.dynamite.DynamiteModule$zzb r1 = new com.google.android.gms.dynamite.DynamiteModule$zzb     // Catch:{ all -> 0x011f }
            int r5 = r5.zzjg     // Catch:{ all -> 0x011f }
            r7 = 0
            r1.<init>(r5, r7)     // Catch:{ all -> 0x011f }
            com.google.android.gms.dynamite.DynamiteModule$VersionPolicy$zza r11 = r11.zza(r10, r12, r1)     // Catch:{ all -> 0x011f }
            int r11 = r11.zzji     // Catch:{ all -> 0x011f }
            if (r11 != r6) goto L_0x00d2
            com.google.android.gms.dynamite.DynamiteModule r10 = zze(r10, r12)     // Catch:{ all -> 0x011f }
            android.database.Cursor r11 = r3.zzjd
            if (r11 == 0) goto L_0x0081
            goto L_0x007e
        L_0x00d2:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r10 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ all -> 0x011f }
            java.lang.String r11 = "Remote load failed. No local fallback found."
            r10.<init>(r11, r0, r4)     // Catch:{ all -> 0x011f }
            throw r10     // Catch:{ all -> 0x011f }
        L_0x00da:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r10 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ all -> 0x011f }
            int r11 = r5.zzji     // Catch:{ all -> 0x011f }
            r12 = 47
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x011f }
            r0.<init>(r12)     // Catch:{ all -> 0x011f }
            java.lang.String r12 = "VersionPolicy returned invalid code:"
            r0.append(r12)     // Catch:{ all -> 0x011f }
            r0.append(r11)     // Catch:{ all -> 0x011f }
            java.lang.String r11 = r0.toString()     // Catch:{ all -> 0x011f }
            r10.<init>((java.lang.String) r11, (com.google.android.gms.dynamite.zza) r4)     // Catch:{ all -> 0x011f }
            throw r10     // Catch:{ all -> 0x011f }
        L_0x00f5:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r10 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ all -> 0x011f }
            int r11 = r5.zzjg     // Catch:{ all -> 0x011f }
            int r12 = r5.zzjh     // Catch:{ all -> 0x011f }
            r0 = 91
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x011f }
            r1.<init>(r0)     // Catch:{ all -> 0x011f }
            java.lang.String r0 = "No acceptable module found. Local version is "
            r1.append(r0)     // Catch:{ all -> 0x011f }
            r1.append(r11)     // Catch:{ all -> 0x011f }
            java.lang.String r11 = " and remote version is "
            r1.append(r11)     // Catch:{ all -> 0x011f }
            r1.append(r12)     // Catch:{ all -> 0x011f }
            java.lang.String r11 = "."
            r1.append(r11)     // Catch:{ all -> 0x011f }
            java.lang.String r11 = r1.toString()     // Catch:{ all -> 0x011f }
            r10.<init>((java.lang.String) r11, (com.google.android.gms.dynamite.zza) r4)     // Catch:{ all -> 0x011f }
            throw r10     // Catch:{ all -> 0x011f }
        L_0x011f:
            r10 = move-exception
            android.database.Cursor r11 = r3.zzjd
            if (r11 == 0) goto L_0x0127
            r11.close()
        L_0x0127:
            java.lang.ThreadLocal<com.google.android.gms.dynamite.DynamiteModule$zza> r11 = zziz
            r11.set(r2)
            goto L_0x012e
        L_0x012d:
            throw r10
        L_0x012e:
            goto L_0x012d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.load(android.content.Context, com.google.android.gms.dynamite.DynamiteModule$VersionPolicy, java.lang.String):com.google.android.gms.dynamite.DynamiteModule");
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
        	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
        	at java.base/java.util.Objects.checkIndex(Objects.java:372)
        	at java.base/java.util.ArrayList.get(ArrayList.java:458)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:23:0x0050=Splitter:B:23:0x0050, B:18:0x0035=Splitter:B:18:0x0035, B:39:0x008b=Splitter:B:39:0x008b} */
    public static int zza(android.content.Context r8, java.lang.String r9, boolean r10) {
        /*
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule> r0 = com.google.android.gms.dynamite.DynamiteModule.class
            monitor-enter(r0)     // Catch:{ all -> 0x00fb }
            java.lang.Boolean r1 = zziu     // Catch:{ all -> 0x00f8 }
            if (r1 != 0) goto L_0x00c5
            android.content.Context r1 = r8.getApplicationContext()     // Catch:{ ClassNotFoundException -> 0x00a0, IllegalAccessException -> 0x009e, NoSuchFieldException -> 0x009c }
            java.lang.ClassLoader r1 = r1.getClassLoader()     // Catch:{ ClassNotFoundException -> 0x00a0, IllegalAccessException -> 0x009e, NoSuchFieldException -> 0x009c }
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule$DynamiteLoaderClassLoader> r2 = com.google.android.gms.dynamite.DynamiteModule.DynamiteLoaderClassLoader.class
            java.lang.String r2 = r2.getName()     // Catch:{ ClassNotFoundException -> 0x00a0, IllegalAccessException -> 0x009e, NoSuchFieldException -> 0x009c }
            java.lang.Class r1 = r1.loadClass(r2)     // Catch:{ ClassNotFoundException -> 0x00a0, IllegalAccessException -> 0x009e, NoSuchFieldException -> 0x009c }
            java.lang.String r2 = "sClassLoader"
            java.lang.reflect.Field r2 = r1.getDeclaredField(r2)     // Catch:{ ClassNotFoundException -> 0x00a0, IllegalAccessException -> 0x009e, NoSuchFieldException -> 0x009c }
            monitor-enter(r1)     // Catch:{ ClassNotFoundException -> 0x00a0, IllegalAccessException -> 0x009e, NoSuchFieldException -> 0x009c }
            r3 = 0
            java.lang.Object r4 = r2.get(r3)     // Catch:{ all -> 0x0099 }
            java.lang.ClassLoader r4 = (java.lang.ClassLoader) r4     // Catch:{ all -> 0x0099 }
            if (r4 == 0) goto L_0x0038
            java.lang.ClassLoader r2 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ all -> 0x0099 }
            if (r4 != r2) goto L_0x0032
        L_0x002f:
            java.lang.Boolean r2 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x0099 }
            goto L_0x0096
        L_0x0032:
            zza(r4)     // Catch:{ LoadingException -> 0x0035 }
        L_0x0035:
            java.lang.Boolean r2 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x0099 }
            goto L_0x0096
        L_0x0038:
            java.lang.String r4 = "com.google.android.gms"
            android.content.Context r5 = r8.getApplicationContext()     // Catch:{ all -> 0x0099 }
            java.lang.String r5 = r5.getPackageName()     // Catch:{ all -> 0x0099 }
            boolean r4 = r4.equals(r5)     // Catch:{ all -> 0x0099 }
            if (r4 == 0) goto L_0x0050
            java.lang.ClassLoader r4 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ all -> 0x0099 }
            r2.set(r3, r4)     // Catch:{ all -> 0x0099 }
            goto L_0x002f
        L_0x0050:
            int r4 = zzc(r8, r9, r10)     // Catch:{ LoadingException -> 0x008e }
            java.lang.String r5 = zzix     // Catch:{ LoadingException -> 0x008e }
            if (r5 == 0) goto L_0x008b
            java.lang.String r5 = zzix     // Catch:{ LoadingException -> 0x008e }
            boolean r5 = r5.isEmpty()     // Catch:{ LoadingException -> 0x008e }
            if (r5 == 0) goto L_0x0061
            goto L_0x008b
        L_0x0061:
            int r5 = android.os.Build.VERSION.SDK_INT     // Catch:{ LoadingException -> 0x008e }
            r6 = 29
            if (r5 < r6) goto L_0x0073
            dalvik.system.DelegateLastClassLoader r5 = new dalvik.system.DelegateLastClassLoader     // Catch:{ LoadingException -> 0x008e }
            java.lang.String r6 = zzix     // Catch:{ LoadingException -> 0x008e }
            java.lang.ClassLoader r7 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ LoadingException -> 0x008e }
            r5.<init>(r6, r7)     // Catch:{ LoadingException -> 0x008e }
            goto L_0x007e
        L_0x0073:
            com.google.android.gms.dynamite.zzh r5 = new com.google.android.gms.dynamite.zzh     // Catch:{ LoadingException -> 0x008e }
            java.lang.String r6 = zzix     // Catch:{ LoadingException -> 0x008e }
            java.lang.ClassLoader r7 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ LoadingException -> 0x008e }
            r5.<init>(r6, r7)     // Catch:{ LoadingException -> 0x008e }
        L_0x007e:
            zza(r5)     // Catch:{ LoadingException -> 0x008e }
            r2.set(r3, r5)     // Catch:{ LoadingException -> 0x008e }
            java.lang.Boolean r5 = java.lang.Boolean.TRUE     // Catch:{ LoadingException -> 0x008e }
            zziu = r5     // Catch:{ LoadingException -> 0x008e }
            monitor-exit(r1)     // Catch:{ all -> 0x0099 }
            monitor-exit(r0)     // Catch:{ all -> 0x00f8 }
            return r4
        L_0x008b:
            monitor-exit(r1)     // Catch:{ all -> 0x0099 }
            monitor-exit(r0)     // Catch:{ all -> 0x00f8 }
            return r4
        L_0x008e:
            java.lang.ClassLoader r4 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ all -> 0x0099 }
            r2.set(r3, r4)     // Catch:{ all -> 0x0099 }
            goto L_0x002f
        L_0x0096:
            monitor-exit(r1)     // Catch:{ all -> 0x0099 }
            r1 = r2
            goto L_0x00c3
        L_0x0099:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0099 }
            throw r2     // Catch:{ ClassNotFoundException -> 0x00a0, IllegalAccessException -> 0x009e, NoSuchFieldException -> 0x009c }
        L_0x009c:
            r1 = move-exception
            goto L_0x00a1
        L_0x009e:
            r1 = move-exception
            goto L_0x00a1
        L_0x00a0:
            r1 = move-exception
        L_0x00a1:
            java.lang.String r2 = "DynamiteModule"
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ all -> 0x00f8 }
            int r3 = r1.length()     // Catch:{ all -> 0x00f8 }
            int r3 = r3 + 30
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f8 }
            r4.<init>(r3)     // Catch:{ all -> 0x00f8 }
            java.lang.String r3 = "Failed to load module via V2: "
            r4.append(r3)     // Catch:{ all -> 0x00f8 }
            r4.append(r1)     // Catch:{ all -> 0x00f8 }
            java.lang.String r1 = r4.toString()     // Catch:{ all -> 0x00f8 }
            android.util.Log.w(r2, r1)     // Catch:{ all -> 0x00f8 }
            java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x00f8 }
        L_0x00c3:
            zziu = r1     // Catch:{ all -> 0x00f8 }
        L_0x00c5:
            monitor-exit(r0)     // Catch:{ all -> 0x00f8 }
            boolean r0 = r1.booleanValue()     // Catch:{ all -> 0x00fb }
            if (r0 == 0) goto L_0x00f3
            int r8 = zzc(r8, r9, r10)     // Catch:{ LoadingException -> 0x00d1 }
            return r8
        L_0x00d1:
            r9 = move-exception
            java.lang.String r10 = "DynamiteModule"
            java.lang.String r0 = "Failed to retrieve remote module version: "
            java.lang.String r9 = r9.getMessage()     // Catch:{ all -> 0x00fb }
            java.lang.String r9 = java.lang.String.valueOf(r9)     // Catch:{ all -> 0x00fb }
            int r1 = r9.length()     // Catch:{ all -> 0x00fb }
            if (r1 == 0) goto L_0x00e9
            java.lang.String r9 = r0.concat(r9)     // Catch:{ all -> 0x00fb }
            goto L_0x00ee
        L_0x00e9:
            java.lang.String r9 = new java.lang.String     // Catch:{ all -> 0x00fb }
            r9.<init>(r0)     // Catch:{ all -> 0x00fb }
        L_0x00ee:
            android.util.Log.w(r10, r9)     // Catch:{ all -> 0x00fb }
            r8 = 0
            return r8
        L_0x00f3:
            int r8 = zzb((android.content.Context) r8, (java.lang.String) r9, (boolean) r10)     // Catch:{ all -> 0x00fb }
            return r8
        L_0x00f8:
            r9 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00f8 }
            throw r9     // Catch:{ all -> 0x00fb }
        L_0x00fb:
            r9 = move-exception
            com.google.android.gms.common.util.CrashUtils.addDynamiteErrorToDropBox(r8, r9)
            goto L_0x0101
        L_0x0100:
            throw r9
        L_0x0101:
            goto L_0x0100
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.zza(android.content.Context, java.lang.String, boolean):int");
    }

    private static DynamiteModule zza(Context context, String str, int i) throws LoadingException {
        Boolean bool;
        IObjectWrapper iObjectWrapper;
        try {
            synchronized (DynamiteModule.class) {
                bool = zziu;
            }
            if (bool == null) {
                throw new LoadingException("Failed to determine which loading route to use.", (zza) null);
            } else if (bool.booleanValue()) {
                return zzb(context, str, i);
            } else {
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 51);
                sb.append("Selected remote version of ");
                sb.append(str);
                sb.append(", version >= ");
                sb.append(i);
                Log.i("DynamiteModule", sb.toString());
                zzj zzk = zzk(context);
                if (zzk != null) {
                    if (zzk.zzak() >= 2) {
                        iObjectWrapper = zzk.zzb(ObjectWrapper.wrap(context), str, i);
                    } else {
                        Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to createModuleContext");
                        iObjectWrapper = zzk.zza(ObjectWrapper.wrap(context), str, i);
                    }
                    if (ObjectWrapper.unwrap(iObjectWrapper) != null) {
                        return new DynamiteModule((Context) ObjectWrapper.unwrap(iObjectWrapper));
                    }
                    throw new LoadingException("Failed to load remote module.", (zza) null);
                }
                throw new LoadingException("Failed to create IDynamiteLoader.", (zza) null);
            }
        } catch (RemoteException e) {
            throw new LoadingException("Failed to load remote module.", e, (zza) null);
        } catch (LoadingException e2) {
            throw e2;
        } catch (Throwable th) {
            CrashUtils.addDynamiteErrorToDropBox(context, th);
            throw new LoadingException("Failed to load remote module.", th, (zza) null);
        }
    }

    private static void zza(ClassLoader classLoader) throws LoadingException {
        zzl zzl;
        try {
            IBinder iBinder = (IBinder) classLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(new Class[0]).newInstance(new Object[0]);
            if (iBinder == null) {
                zzl = null;
            } else {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
                zzl = queryLocalInterface instanceof zzl ? (zzl) queryLocalInterface : new zzk(iBinder);
            }
            zziw = zzl;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            throw new LoadingException("Failed to instantiate dynamite loader", e, (zza) null);
        }
    }

    private static Boolean zzaj() {
        Boolean valueOf;
        synchronized (DynamiteModule.class) {
            valueOf = Boolean.valueOf(zziy >= 2);
        }
        return valueOf;
    }

    private static int zzb(Context context, String str, boolean z) {
        zzj zzk = zzk(context);
        if (zzk == null) {
            return 0;
        }
        try {
            if (zzk.zzak() >= 2) {
                return zzk.zzb(ObjectWrapper.wrap(context), str, z);
            }
            Log.w("DynamiteModule", "IDynamite loader version < 2, falling back to getModuleVersion2");
            return zzk.zza(ObjectWrapper.wrap(context), str, z);
        } catch (RemoteException e) {
            String valueOf = String.valueOf(e.getMessage());
            Log.w("DynamiteModule", valueOf.length() != 0 ? "Failed to retrieve remote module version: ".concat(valueOf) : new String("Failed to retrieve remote module version: "));
            return 0;
        }
    }

    private static DynamiteModule zzb(Context context, String str, int i) throws LoadingException, RemoteException {
        zzl zzl;
        IObjectWrapper iObjectWrapper;
        StringBuilder sb = new StringBuilder(C0681a.m336b(str, 51));
        sb.append("Selected remote version of ");
        sb.append(str);
        sb.append(", version >= ");
        sb.append(i);
        Log.i("DynamiteModule", sb.toString());
        synchronized (DynamiteModule.class) {
            zzl = zziw;
        }
        if (zzl != null) {
            zza zza2 = zziz.get();
            if (zza2 == null || zza2.zzjd == null) {
                throw new LoadingException("No result cursor", (zza) null);
            }
            Context applicationContext = context.getApplicationContext();
            Cursor cursor = zza2.zzjd;
            ObjectWrapper.wrap(null);
            if (zzaj().booleanValue()) {
                Log.v("DynamiteModule", "Dynamite loader version >= 2, using loadModule2NoCrashUtils");
                iObjectWrapper = zzl.zzb(ObjectWrapper.wrap(applicationContext), str, i, ObjectWrapper.wrap(cursor));
            } else {
                Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to loadModule2");
                iObjectWrapper = zzl.zza(ObjectWrapper.wrap(applicationContext), str, i, ObjectWrapper.wrap(cursor));
            }
            Context context2 = (Context) ObjectWrapper.unwrap(iObjectWrapper);
            if (context2 != null) {
                return new DynamiteModule(context2);
            }
            throw new LoadingException("Failed to get module context", (zza) null);
        }
        throw new LoadingException("DynamiteLoaderV2 was not cached.", (zza) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00b0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int zzc(android.content.Context r8, java.lang.String r9, boolean r10) throws com.google.android.gms.dynamite.DynamiteModule.LoadingException {
        /*
            r0 = 0
            android.content.ContentResolver r1 = r8.getContentResolver()     // Catch:{ Exception -> 0x009d, all -> 0x009b }
            if (r10 == 0) goto L_0x000a
            java.lang.String r8 = "api_force_staging"
            goto L_0x000c
        L_0x000a:
            java.lang.String r8 = "api"
        L_0x000c:
            int r10 = r8.length()     // Catch:{ Exception -> 0x009d, all -> 0x009b }
            int r10 = r10 + 42
            java.lang.String r2 = java.lang.String.valueOf(r9)     // Catch:{ Exception -> 0x009d, all -> 0x009b }
            int r2 = r2.length()     // Catch:{ Exception -> 0x009d, all -> 0x009b }
            int r10 = r10 + r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x009d, all -> 0x009b }
            r2.<init>(r10)     // Catch:{ Exception -> 0x009d, all -> 0x009b }
            java.lang.String r10 = "content://com.google.android.gms.chimera/"
            r2.append(r10)     // Catch:{ Exception -> 0x009d, all -> 0x009b }
            r2.append(r8)     // Catch:{ Exception -> 0x009d, all -> 0x009b }
            java.lang.String r8 = "/"
            r2.append(r8)     // Catch:{ Exception -> 0x009d, all -> 0x009b }
            r2.append(r9)     // Catch:{ Exception -> 0x009d, all -> 0x009b }
            java.lang.String r8 = r2.toString()     // Catch:{ Exception -> 0x009d, all -> 0x009b }
            android.net.Uri r2 = android.net.Uri.parse(r8)     // Catch:{ Exception -> 0x009d, all -> 0x009b }
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            android.database.Cursor r8 = r1.query(r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x009d, all -> 0x009b }
            if (r8 == 0) goto L_0x0083
            boolean r9 = r8.moveToFirst()     // Catch:{ Exception -> 0x0096, all -> 0x0092 }
            if (r9 == 0) goto L_0x0083
            r9 = 0
            int r9 = r8.getInt(r9)     // Catch:{ Exception -> 0x0096, all -> 0x0092 }
            if (r9 <= 0) goto L_0x007c
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule> r10 = com.google.android.gms.dynamite.DynamiteModule.class
            monitor-enter(r10)     // Catch:{ Exception -> 0x0096, all -> 0x0092 }
            r1 = 2
            java.lang.String r1 = r8.getString(r1)     // Catch:{ all -> 0x0079 }
            zzix = r1     // Catch:{ all -> 0x0079 }
            java.lang.String r1 = "loaderVersion"
            int r1 = r8.getColumnIndex(r1)     // Catch:{ all -> 0x0079 }
            if (r1 < 0) goto L_0x0067
            int r1 = r8.getInt(r1)     // Catch:{ all -> 0x0079 }
            zziy = r1     // Catch:{ all -> 0x0079 }
        L_0x0067:
            monitor-exit(r10)     // Catch:{ all -> 0x0079 }
            java.lang.ThreadLocal<com.google.android.gms.dynamite.DynamiteModule$zza> r10 = zziz     // Catch:{ Exception -> 0x0096, all -> 0x0092 }
            java.lang.Object r10 = r10.get()     // Catch:{ Exception -> 0x0096, all -> 0x0092 }
            com.google.android.gms.dynamite.DynamiteModule$zza r10 = (com.google.android.gms.dynamite.DynamiteModule.zza) r10     // Catch:{ Exception -> 0x0096, all -> 0x0092 }
            if (r10 == 0) goto L_0x007c
            android.database.Cursor r1 = r10.zzjd     // Catch:{ Exception -> 0x0096, all -> 0x0092 }
            if (r1 != 0) goto L_0x007c
            r10.zzjd = r8     // Catch:{ Exception -> 0x0096, all -> 0x0092 }
            goto L_0x007d
        L_0x0079:
            r9 = move-exception
            monitor-exit(r10)     // Catch:{ all -> 0x0079 }
            throw r9     // Catch:{ Exception -> 0x0096, all -> 0x0092 }
        L_0x007c:
            r0 = r8
        L_0x007d:
            if (r0 == 0) goto L_0x0082
            r0.close()
        L_0x0082:
            return r9
        L_0x0083:
            java.lang.String r9 = "DynamiteModule"
            java.lang.String r10 = "Failed to retrieve remote module version."
            android.util.Log.w(r9, r10)     // Catch:{ Exception -> 0x0096, all -> 0x0092 }
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r9 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ Exception -> 0x0096, all -> 0x0092 }
            java.lang.String r10 = "Failed to connect to dynamite module ContentResolver."
            r9.<init>((java.lang.String) r10, (com.google.android.gms.dynamite.zza) r0)     // Catch:{ Exception -> 0x0096, all -> 0x0092 }
            throw r9     // Catch:{ Exception -> 0x0096, all -> 0x0092 }
        L_0x0092:
            r9 = move-exception
            r0 = r8
            r8 = r9
            goto L_0x00ae
        L_0x0096:
            r9 = move-exception
            r7 = r9
            r9 = r8
            r8 = r7
            goto L_0x009f
        L_0x009b:
            r8 = move-exception
            goto L_0x00ae
        L_0x009d:
            r8 = move-exception
            r9 = r0
        L_0x009f:
            boolean r10 = r8 instanceof com.google.android.gms.dynamite.DynamiteModule.LoadingException     // Catch:{ all -> 0x00ac }
            if (r10 == 0) goto L_0x00a4
            throw r8     // Catch:{ all -> 0x00ac }
        L_0x00a4:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r10 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ all -> 0x00ac }
            java.lang.String r1 = "V2 version check failed"
            r10.<init>(r1, r8, r0)     // Catch:{ all -> 0x00ac }
            throw r10     // Catch:{ all -> 0x00ac }
        L_0x00ac:
            r8 = move-exception
            r0 = r9
        L_0x00ae:
            if (r0 == 0) goto L_0x00b3
            r0.close()
        L_0x00b3:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.zzc(android.content.Context, java.lang.String, boolean):int");
    }

    private static DynamiteModule zze(Context context, String str) {
        String valueOf = String.valueOf(str);
        Log.i("DynamiteModule", valueOf.length() != 0 ? "Selected local version of ".concat(valueOf) : new String("Selected local version of "));
        return new DynamiteModule(context.getApplicationContext());
    }

    private static zzj zzk(Context context) {
        zzj zzj;
        synchronized (DynamiteModule.class) {
            if (zziv != null) {
                zzj zzj2 = zziv;
                return zzj2;
            }
            try {
                IBinder iBinder = (IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance();
                if (iBinder == null) {
                    zzj = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoader");
                    zzj = queryLocalInterface instanceof zzj ? (zzj) queryLocalInterface : new zzi(iBinder);
                }
                if (zzj != null) {
                    zziv = zzj;
                    return zzj;
                }
            } catch (Exception e) {
                String valueOf = String.valueOf(e.getMessage());
                Log.e("DynamiteModule", valueOf.length() != 0 ? "Failed to load IDynamiteLoader from GmsCore: ".concat(valueOf) : new String("Failed to load IDynamiteLoader from GmsCore: "));
            }
        }
        return null;
    }

    @KeepForSdk
    public final Context getModuleContext() {
        return this.zzjc;
    }

    @KeepForSdk
    public final IBinder instantiate(String str) throws LoadingException {
        try {
            return (IBinder) this.zzjc.getClassLoader().loadClass(str).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            String valueOf = String.valueOf(str);
            throw new LoadingException(valueOf.length() != 0 ? "Failed to instantiate module class: ".concat(valueOf) : new String("Failed to instantiate module class: "), e, (zza) null);
        }
    }
}
