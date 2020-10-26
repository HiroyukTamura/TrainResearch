// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import java.util.Random;
import android.support.annotation.NonNull;
import android.net.Uri;
import java.util.zip.GZIPInputStream;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;
import java.io.ByteArrayOutputStream;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.measurement.AppMeasurement;
import java.io.IOException;
import com.google.android.gms.common.internal.safeparcel.zzc;
import android.os.Parcelable$Creator;
import java.util.Collections;
import java.util.List;
import java.util.Iterator;
import android.content.pm.ServiceInfo;
import android.content.Intent;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import java.security.NoSuchAlgorithmException;
import java.security.MessageDigest;
import java.util.BitSet;
import android.os.Parcel;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.ComponentName;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.zzbo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager$NameNotFoundException;
import java.security.cert.CertificateException;
import java.io.InputStream;
import java.io.ByteArrayInputStream;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import javax.security.auth.x500.X500Principal;
import android.content.Context;
import java.util.ArrayList;
import java.util.Arrays;
import android.os.Parcelable;
import android.os.Bundle;
import java.util.concurrent.atomic.AtomicLong;
import java.security.SecureRandom;

public final class zzcjl extends zzchj
{
    private static String[] zzbuD;
    private SecureRandom zzbuE;
    private final AtomicLong zzbuF;
    private int zzbuG;
    
    static {
        zzcjl.zzbuD = new String[] { "firebase_" };
    }
    
    zzcjl(final zzcgl zzcgl) {
        super(zzcgl);
        this.zzbuF = new AtomicLong(0L);
    }
    
    public static Bundle[] zzC(final Object o) {
        if (o instanceof Bundle) {
            return new Bundle[] { (Bundle)o };
        }
        if (o instanceof Parcelable[]) {
            return Arrays.copyOf((Parcelable[])o, ((Parcelable[])o).length, (Class<? extends Bundle[]>)Bundle[].class);
        }
        if (o instanceof ArrayList) {
            final ArrayList list = (ArrayList)o;
            return list.toArray(new Bundle[list.size()]);
        }
        return null;
    }
    
    public static Object zzD(final Object p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ifnonnull       6
        //     4: aconst_null    
        //     5: areturn        
        //     6: new             Ljava/io/ByteArrayOutputStream;
        //     9: dup            
        //    10: invokespecial   java/io/ByteArrayOutputStream.<init>:()V
        //    13: astore_1       
        //    14: new             Ljava/io/ObjectOutputStream;
        //    17: dup            
        //    18: aload_1        
        //    19: invokespecial   java/io/ObjectOutputStream.<init>:(Ljava/io/OutputStream;)V
        //    22: astore_2       
        //    23: aload_2        
        //    24: aload_0        
        //    25: invokevirtual   java/io/ObjectOutputStream.writeObject:(Ljava/lang/Object;)V
        //    28: aload_2        
        //    29: invokevirtual   java/io/ObjectOutputStream.flush:()V
        //    32: new             Ljava/io/ObjectInputStream;
        //    35: dup            
        //    36: new             Ljava/io/ByteArrayInputStream;
        //    39: dup            
        //    40: aload_1        
        //    41: invokevirtual   java/io/ByteArrayOutputStream.toByteArray:()[B
        //    44: invokespecial   java/io/ByteArrayInputStream.<init>:([B)V
        //    47: invokespecial   java/io/ObjectInputStream.<init>:(Ljava/io/InputStream;)V
        //    50: astore_1       
        //    51: aload_1        
        //    52: invokevirtual   java/io/ObjectInputStream.readObject:()Ljava/lang/Object;
        //    55: astore_0       
        //    56: aload_2        
        //    57: invokevirtual   java/io/ObjectOutputStream.close:()V
        //    60: aload_1        
        //    61: invokevirtual   java/io/ObjectInputStream.close:()V
        //    64: aload_0        
        //    65: areturn        
        //    66: aload_2        
        //    67: ifnull          74
        //    70: aload_2        
        //    71: invokevirtual   java/io/ObjectOutputStream.close:()V
        //    74: aload_1        
        //    75: ifnull          82
        //    78: aload_1        
        //    79: invokevirtual   java/io/ObjectInputStream.close:()V
        //    82: aload_0        
        //    83: athrow         
        //    84: astore_0       
        //    85: aconst_null    
        //    86: areturn        
        //    87: astore_0       
        //    88: aconst_null    
        //    89: areturn        
        //    90: astore_0       
        //    91: aconst_null    
        //    92: astore_1       
        //    93: goto            66
        //    96: astore_0       
        //    97: goto            66
        //   100: astore_0       
        //   101: aconst_null    
        //   102: astore_1       
        //   103: aconst_null    
        //   104: astore_2       
        //   105: goto            66
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                              
        //  -----  -----  -----  -----  ----------------------------------
        //  6      23     100    108    Any
        //  23     51     90     96     Any
        //  51     56     96     100    Any
        //  56     64     84     87     Ljava/io/IOException;
        //  56     64     87     90     Ljava/lang/ClassNotFoundException;
        //  70     74     84     87     Ljava/io/IOException;
        //  70     74     87     90     Ljava/lang/ClassNotFoundException;
        //  78     82     84     87     Ljava/io/IOException;
        //  78     82     87     90     Ljava/lang/ClassNotFoundException;
        //  82     84     84     87     Ljava/io/IOException;
        //  82     84     87     90     Ljava/lang/ClassNotFoundException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0066:
        //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
        //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2596)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    private final boolean zzJ(final Context context, final String s) {
        final X500Principal o = new X500Principal("CN=Android Debug,O=Android,C=US");
        try {
            final PackageInfo packageInfo = zzbha.zzaP(context).getPackageInfo(s, 64);
            if (packageInfo != null && packageInfo.signatures != null && packageInfo.signatures.length > 0) {
                return ((X509Certificate)CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(packageInfo.signatures[0].toByteArray()))).getSubjectX500Principal().equals(o);
            }
            goto Label_0095;
        }
        catch (CertificateException ex) {
            super.zzwF().zzyx().zzj("Error obtaining certificate", ex);
        }
        catch (PackageManager$NameNotFoundException ex2) {
            super.zzwF().zzyx().zzj("Package name not found", ex2);
            goto Label_0095;
        }
    }
    
    private final boolean zzP(final String s, final String s2) {
        if (s2 == null) {
            super.zzwF().zzyx().zzj("Name is required and can't be null. Type", s);
            return false;
        }
        if (s2.length() == 0) {
            super.zzwF().zzyx().zzj("Name is required and can't be empty. Type", s);
            return false;
        }
        final int codePoint = s2.codePointAt(0);
        if (!Character.isLetter(codePoint)) {
            super.zzwF().zzyx().zze("Name must start with a letter. Type, name", s, s2);
            return false;
        }
        int codePoint2;
        for (int length = s2.length(), i = Character.charCount(codePoint); i < length; i += Character.charCount(codePoint2)) {
            codePoint2 = s2.codePointAt(i);
            if (codePoint2 != 95 && !Character.isLetterOrDigit(codePoint2)) {
                super.zzwF().zzyx().zze("Name must consist of letters, digits or _ (underscores). Type, name", s, s2);
                return false;
            }
        }
        return true;
    }
    
    private final boolean zzQ(final String s, final String s2) {
        if (s2 == null) {
            super.zzwF().zzyx().zzj("Name is required and can't be null. Type", s);
            return false;
        }
        if (s2.length() == 0) {
            super.zzwF().zzyx().zzj("Name is required and can't be empty. Type", s);
            return false;
        }
        final int codePoint = s2.codePointAt(0);
        if (!Character.isLetter(codePoint) && codePoint != 95) {
            super.zzwF().zzyx().zze("Name must start with a letter or _ (underscore). Type, name", s, s2);
            return false;
        }
        int codePoint2;
        for (int length = s2.length(), i = Character.charCount(codePoint); i < length; i += Character.charCount(codePoint2)) {
            codePoint2 = s2.codePointAt(i);
            if (codePoint2 != 95 && !Character.isLetterOrDigit(codePoint2)) {
                super.zzwF().zzyx().zze("Name must consist of letters, digits or _ (underscores). Type, name", s, s2);
                return false;
            }
        }
        return true;
    }
    
    public static boolean zzR(final String s, final String anObject) {
        return (s == null && anObject == null) || (s != null && s.equals(anObject));
    }
    
    private final int zza(final String s, final Object o, final boolean b) {
        if (b) {
            zzcem.zzxm();
            int n = 0;
            Label_0053: {
                int i;
                if (o instanceof Parcelable[]) {
                    i = ((Parcelable[])o).length;
                }
                else {
                    if (!(o instanceof ArrayList)) {
                        n = 1;
                        break Label_0053;
                    }
                    i = ((ArrayList)o).size();
                }
                if (i > 1000) {
                    super.zzwF().zzyz().zzd("Parameter array is too long; discarded. Value kind, name, array length", "param", s, i);
                    n = 0;
                }
                else {
                    n = 1;
                }
            }
            if (n == 0) {
                return 17;
            }
        }
        boolean b2;
        if (zzex(s)) {
            b2 = this.zza("param", s, zzcem.zzxl(), o, b);
        }
        else {
            b2 = this.zza("param", s, zzcem.zzxk(), o, b);
        }
        if (b2) {
            return 0;
        }
        return 4;
    }
    
    private static Object zza(final int n, final Object obj, final boolean b) {
        Object o;
        if (obj == null) {
            o = null;
        }
        else {
            o = obj;
            if (!(obj instanceof Long)) {
                o = obj;
                if (!(obj instanceof Double)) {
                    if (obj instanceof Integer) {
                        return obj;
                    }
                    if (obj instanceof Byte) {
                        return obj;
                    }
                    if (obj instanceof Short) {
                        return obj;
                    }
                    if (obj instanceof Boolean) {
                        long l;
                        if (obj) {
                            l = 1L;
                        }
                        else {
                            l = 0L;
                        }
                        return l;
                    }
                    if (obj instanceof Float) {
                        return obj;
                    }
                    if (obj instanceof String || obj instanceof Character || obj instanceof CharSequence) {
                        return zza(String.valueOf(obj), n, b);
                    }
                    return null;
                }
            }
        }
        return o;
    }
    
    public static String zza(final String s, final int codePointOffset, final boolean b) {
        String concat = s;
        if (s.codePointCount(0, s.length()) > codePointOffset) {
            if (!b) {
                return null;
            }
            concat = String.valueOf(s.substring(0, s.offsetByCodePoints(0, codePointOffset))).concat("...");
        }
        return concat;
    }
    
    @Nullable
    public static String zza(final String s, final String[] array, final String[] array2) {
        zzbo.zzu(array);
        zzbo.zzu(array2);
        for (int min = Math.min(array.length, array2.length), i = 0; i < min; ++i) {
            if (zzR(s, array[i])) {
                return array2[i];
            }
        }
        return null;
    }
    
    public static boolean zza(final Context context, final String s, final boolean b) {
        try {
            final PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return false;
            }
            final ActivityInfo receiverInfo = packageManager.getReceiverInfo(new ComponentName(context, s), 2);
            if (receiverInfo != null && receiverInfo.enabled) {
                return true;
            }
        }
        catch (PackageManager$NameNotFoundException ex) {}
        return false;
    }
    
    private final boolean zza(final String s, final String s2, int i, Object value, final boolean b) {
        if (value != null && !(value instanceof Long) && !(value instanceof Float) && !(value instanceof Integer) && !(value instanceof Byte) && !(value instanceof Short) && !(value instanceof Boolean) && !(value instanceof Double)) {
            if (value instanceof String || value instanceof Character || value instanceof CharSequence) {
                final String value2 = String.valueOf(value);
                if (value2.codePointCount(0, value2.length()) > i) {
                    super.zzwF().zzyz().zzd("Value is too long; discarded. Value kind, name, value length", s, s2, value2.length());
                    return false;
                }
            }
            else if (!(value instanceof Bundle) || !b) {
                if (value instanceof Parcelable[] && b) {
                    final Parcelable[] array = (Parcelable[])value;
                    int length;
                    Parcelable parcelable;
                    for (length = array.length, i = 0; i < length; ++i) {
                        parcelable = array[i];
                        if (!(parcelable instanceof Bundle)) {
                            super.zzwF().zzyz().zze("All Parcelable[] elements must be of type Bundle. Value type, name", parcelable.getClass(), s2);
                            return false;
                        }
                    }
                }
                else {
                    if (!(value instanceof ArrayList) || !b) {
                        return false;
                    }
                    final ArrayList list = (ArrayList)value;
                    final int size = list.size();
                    i = 0;
                    while (i < size) {
                        value = list.get(i);
                        ++i;
                        if (!(value instanceof Bundle)) {
                            super.zzwF().zzyz().zze("All ArrayList elements must be of type Bundle. Value type, name", value.getClass(), s2);
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
    
    private final boolean zza(final String s, final String[] array, final String s2) {
        if (s2 == null) {
            super.zzwF().zzyx().zzj("Name is required and can't be null. Type", s);
            return false;
        }
        zzbo.zzu(s2);
        int i = 0;
        while (true) {
            while (i < zzcjl.zzbuD.length) {
                if (s2.startsWith(zzcjl.zzbuD[i])) {
                    final int n = 1;
                    if (n != 0) {
                        super.zzwF().zzyx().zze("Name starts with reserved prefix. Type, name", s, s2);
                        return false;
                    }
                    if (array != null) {
                        zzbo.zzu(array);
                        int j = 0;
                        while (true) {
                            while (j < array.length) {
                                if (zzR(s2, array[j])) {
                                    final int n2 = 1;
                                    if (n2 != 0) {
                                        super.zzwF().zzyx().zze("Name is reserved. Type, name", s, s2);
                                        return false;
                                    }
                                    return true;
                                }
                                else {
                                    ++j;
                                }
                            }
                            final int n2 = 0;
                            continue;
                        }
                    }
                    return true;
                }
                else {
                    ++i;
                }
            }
            final int n = 0;
            continue;
        }
    }
    
    public static boolean zza(final long[] array, final int n) {
        return n < array.length << 6 && (array[n / 64] & 1L << n % 64) != 0x0L;
    }
    
    static byte[] zza(final Parcelable parcelable) {
        if (parcelable == null) {
            return null;
        }
        final Parcel obtain = Parcel.obtain();
        try {
            parcelable.writeToParcel(obtain, 0);
            return obtain.marshall();
        }
        finally {
            obtain.recycle();
        }
    }
    
    public static long[] zza(final BitSet set) {
        final int n = (set.length() + 63) / 64;
        final long[] array = new long[n];
        for (int i = 0; i < n; ++i) {
            array[i] = 0L;
            for (int n2 = 0; n2 < 64 && (i << 6) + n2 < set.length(); ++n2) {
                if (set.get((i << 6) + n2)) {
                    array[i] |= 1L << n2;
                }
            }
        }
        return array;
    }
    
    private static void zzb(final Bundle bundle, final Object obj) {
        zzbo.zzu(bundle);
        if (obj != null && (obj instanceof String || obj instanceof CharSequence)) {
            bundle.putLong("_el", (long)String.valueOf(obj).length());
        }
    }
    
    private final boolean zzb(final String s, final int i, final String s2) {
        if (s2 == null) {
            super.zzwF().zzyx().zzj("Name is required and can't be null. Type", s);
            return false;
        }
        if (s2.codePointCount(0, s2.length()) > i) {
            super.zzwF().zzyx().zzd("Name is too long. Type, maximum supported length, name", s, i, s2);
            return false;
        }
        return true;
    }
    
    static MessageDigest zzbE(final String algorithm) {
        for (int i = 0; i < 2; ++i) {
            try {
                final MessageDigest instance = MessageDigest.getInstance(algorithm);
                if (instance != null) {
                    return instance;
                }
            }
            catch (NoSuchAlgorithmException ex) {}
        }
        return null;
    }
    
    private static boolean zzd(final Bundle bundle, final int n) {
        if (bundle.getLong("_err") == 0L) {
            bundle.putLong("_err", (long)n);
            return true;
        }
        return false;
    }
    
    @WorkerThread
    static boolean zzd(final zzcez zzcez, final zzceh zzceh) {
        zzbo.zzu(zzcez);
        zzbo.zzu(zzceh);
        if (TextUtils.isEmpty((CharSequence)zzceh.zzboQ)) {
            zzcem.zzxE();
            return false;
        }
        return true;
    }
    
    @WorkerThread
    static boolean zzeC(final String s) {
        boolean b = true;
        zzbo.zzcF(s);
        switch (s) {
            default: {
                b = false;
                return b;
            }
            case "_in":
            case "_ui":
            case "_ug": {
                return b;
            }
        }
    }
    
    static boolean zzeo(final String s) {
        boolean b = false;
        zzbo.zzcF(s);
        if (s.charAt(0) != '_' || s.equals("_ep")) {
            b = true;
        }
        return b;
    }
    
    private final int zzet(final String s) {
        if (this.zzP("event param", s)) {
            if (!this.zza("event param", null, s)) {
                return 14;
            }
            if (this.zzb("event param", zzcem.zzxj(), s)) {
                return 0;
            }
        }
        return 3;
    }
    
    private final int zzeu(final String s) {
        if (this.zzQ("event param", s)) {
            if (!this.zza("event param", null, s)) {
                return 14;
            }
            if (this.zzb("event param", zzcem.zzxj(), s)) {
                return 0;
            }
        }
        return 3;
    }
    
    private static int zzew(final String anObject) {
        if ("_ldl".equals(anObject)) {
            return zzcem.zzxo();
        }
        return zzcem.zzxn();
    }
    
    public static boolean zzex(final String s) {
        return !TextUtils.isEmpty((CharSequence)s) && s.startsWith("_");
    }
    
    static boolean zzez(final String s) {
        return s != null && s.matches("(\\+|-)?([0-9]+\\.?[0-9]*|[0-9]*\\.?[0-9]+)") && s.length() <= 310;
    }
    
    public static boolean zzl(final Intent intent) {
        final String stringExtra = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
        return "android-app://com.google.android.googlequicksearchbox/https/www.google.com".equals(stringExtra) || "https://www.google.com".equals(stringExtra) || "android-app://com.google.appcrawler".equals(stringExtra);
    }
    
    static long zzn(final byte[] array) {
        int n = 0;
        zzbo.zzu(array);
        zzbo.zzae(array.length > 0);
        long n2 = 0L;
        for (int n3 = array.length - 1; n3 >= 0 && n3 >= array.length - 8; --n3) {
            n2 += ((long)array[n3] & 0xFFL) << n;
            n += 8;
        }
        return n2;
    }
    
    public static boolean zzw(final Context context, final String s) {
        try {
            final PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return false;
            }
            final ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(context, s), 4);
            if (serviceInfo != null && serviceInfo.enabled) {
                return true;
            }
        }
        catch (PackageManager$NameNotFoundException ex) {}
        return false;
    }
    
    final Bundle zzB(final Bundle bundle) {
        final Bundle bundle2 = new Bundle();
        if (bundle != null) {
            for (final String s : bundle.keySet()) {
                final Object zzk = this.zzk(s, bundle.get(s));
                if (zzk == null) {
                    super.zzwF().zzyz().zzj("Param value can't be null", super.zzwA().zzdX(s));
                }
                else {
                    this.zza(bundle2, s, zzk);
                }
            }
        }
        return bundle2;
    }
    
    @WorkerThread
    final long zzI(final Context context, final String s) {
        super.zzjC();
        zzbo.zzu(context);
        zzbo.zzcF(s);
        final PackageManager packageManager = context.getPackageManager();
        final MessageDigest zzbE = zzbE("MD5");
        if (zzbE == null) {
            super.zzwF().zzyx().log("Could not get MD5 instance");
            return -1L;
        }
        if (packageManager != null) {
            try {
                if (!this.zzJ(context, s)) {
                    final PackageInfo packageInfo = zzbha.zzaP(context).getPackageInfo(super.getContext().getPackageName(), 64);
                    if (packageInfo.signatures != null && packageInfo.signatures.length > 0) {
                        return zzn(zzbE.digest(packageInfo.signatures[0].toByteArray()));
                    }
                    super.zzwF().zzyz().log("Could not get signatures");
                    return -1L;
                }
            }
            catch (PackageManager$NameNotFoundException ex) {
                super.zzwF().zzyx().zzj("Package name not found", ex);
            }
        }
        return 0L;
    }
    
    public final Bundle zza(final String s, final Bundle bundle, @Nullable final List<String> list, final boolean b, final boolean b2) {
        Bundle bundle2 = null;
        if (bundle != null) {
            bundle2 = new Bundle(bundle);
            zzcem.zzxg();
            final Iterator<String> iterator = bundle.keySet().iterator();
            int n = 0;
            while (iterator.hasNext()) {
                final String anObject = iterator.next();
                int zzeu;
                if (list == null || !list.contains(anObject)) {
                    int zzet;
                    if (b) {
                        zzet = this.zzet(anObject);
                    }
                    else {
                        zzet = 0;
                    }
                    zzeu = zzet;
                    if (zzet == 0) {
                        zzeu = this.zzeu(anObject);
                    }
                }
                else {
                    zzeu = 0;
                }
                if (zzeu != 0) {
                    if (zzd(bundle2, zzeu)) {
                        bundle2.putString("_ev", zza(anObject, zzcem.zzxj(), true));
                        if (zzeu == 3) {
                            zzb(bundle2, anObject);
                        }
                    }
                    bundle2.remove(anObject);
                }
                else {
                    final int zza = this.zza(anObject, bundle.get(anObject), b2);
                    if (zza != 0 && !"_ev".equals(anObject)) {
                        if (zzd(bundle2, zza)) {
                            bundle2.putString("_ev", zza(anObject, zzcem.zzxj(), true));
                            zzb(bundle2, bundle.get(anObject));
                        }
                        bundle2.remove(anObject);
                    }
                    else {
                        int n2 = n;
                        if (zzeo(anObject)) {
                            ++n;
                            if ((n2 = n) > 25) {
                                super.zzwF().zzyx().zze(new StringBuilder(48).append("Event can't contain more then 25 params").toString(), super.zzwA().zzdW(s), super.zzwA().zzA(bundle));
                                zzd(bundle2, 5);
                                bundle2.remove(anObject);
                                continue;
                            }
                        }
                        n = n2;
                    }
                }
            }
        }
        return bundle2;
    }
    
    final zzcez zza(final String s, Bundle bundle, final String s2, final long n, final boolean b, final boolean b2) {
        if (TextUtils.isEmpty((CharSequence)s)) {
            return null;
        }
        if (this.zzeq(s) != 0) {
            super.zzwF().zzyx().zzj("Invalid conditional property event name", super.zzwA().zzdY(s));
            throw new IllegalArgumentException();
        }
        if (bundle != null) {
            bundle = new Bundle(bundle);
        }
        else {
            bundle = new Bundle();
        }
        bundle.putString("_o", s2);
        return new zzcez(s, new zzcew(this.zzB(this.zza(s, bundle, Collections.singletonList("_o"), false, false))), s2, n);
    }
    
    public final void zza(final int n, final String s, final String s2, final int n2) {
        this.zza(null, n, s, s2, n2);
    }
    
    public final void zza(final Bundle bundle, final String s, final Object obj) {
        if (bundle != null) {
            if (obj instanceof Long) {
                bundle.putLong(s, (long)obj);
                return;
            }
            if (obj instanceof String) {
                bundle.putString(s, String.valueOf(obj));
                return;
            }
            if (obj instanceof Double) {
                bundle.putDouble(s, (double)obj);
                return;
            }
            if (s != null) {
                String simpleName;
                if (obj != null) {
                    simpleName = obj.getClass().getSimpleName();
                }
                else {
                    simpleName = null;
                }
                super.zzwF().zzyA().zze("Not putting event parameter. Invalid value type. name, type", super.zzwA().zzdX(s), simpleName);
            }
        }
    }
    
    public final void zza(final zzcjx zzcjx, final Object o) {
        zzbo.zzu(o);
        zzcjx.zzaIF = null;
        zzcjx.zzbvA = null;
        zzcjx.zzbuB = null;
        if (o instanceof String) {
            zzcjx.zzaIF = (String)o;
            return;
        }
        if (o instanceof Long) {
            zzcjx.zzbvA = (Long)o;
            return;
        }
        if (o instanceof Double) {
            zzcjx.zzbuB = (Double)o;
            return;
        }
        super.zzwF().zzyx().zzj("Ignoring invalid (type) event param value", o);
    }
    
    public final void zza(final zzckb zzckb, final Object o) {
        zzbo.zzu(o);
        zzckb.zzaIF = null;
        zzckb.zzbvA = null;
        zzckb.zzbuB = null;
        if (o instanceof String) {
            zzckb.zzaIF = (String)o;
            return;
        }
        if (o instanceof Long) {
            zzckb.zzbvA = (Long)o;
            return;
        }
        if (o instanceof Double) {
            zzckb.zzbuB = (Double)o;
            return;
        }
        super.zzwF().zzyx().zzj("Ignoring invalid (type) user attribute value", o);
    }
    
    public final void zza(final String s, final int n, final String s2, final String s3, final int n2) {
        final Bundle bundle = new Bundle();
        zzd(bundle, n);
        if (!TextUtils.isEmpty((CharSequence)s2)) {
            bundle.putString(s2, s3);
        }
        if (n == 6 || n == 7 || n == 2) {
            bundle.putLong("_el", (long)n2);
        }
        zzcem.zzxE();
        this.zzboe.zzwt().zzd("auto", "_err", bundle);
    }
    
    final <T extends Parcelable> T zzb(final byte[] array, final Parcelable$Creator<T> parcelable$Creator) {
        if (array == null) {
            return null;
        }
        final Parcel obtain = Parcel.obtain();
        try {
            obtain.unmarshall(array, 0, array.length);
            obtain.setDataPosition(0);
            return (T)parcelable$Creator.createFromParcel(obtain);
        }
        catch (zzc zzc) {
            super.zzwF().zzyx().log("Failed to load parcelable from buffer");
            return null;
        }
        finally {
            obtain.recycle();
        }
    }
    
    public final byte[] zzb(final zzcjy zzcjy) {
        try {
            final byte[] array = new byte[zzcjy.zzLV()];
            final adh zzc = adh.zzc(array, 0, array.length);
            zzcjy.zza(zzc);
            zzc.zzLM();
            return array;
        }
        catch (IOException ex) {
            super.zzwF().zzyx().zzj("Data loss. Failed to serialize batch", ex);
            return null;
        }
    }
    
    @WorkerThread
    public final boolean zzbv(final String s) {
        super.zzjC();
        if (zzbha.zzaP(super.getContext()).checkCallingOrSelfPermission(s) == 0) {
            return true;
        }
        super.zzwF().zzyC().zzj("Permission not granted", s);
        return false;
    }
    
    final boolean zzeA(final String s) {
        return "1".equals(super.zzwC().zzM(s, "measurement.upload.blacklist_internal"));
    }
    
    final boolean zzeB(final String s) {
        return "1".equals(super.zzwC().zzM(s, "measurement.upload.blacklist_public"));
    }
    
    public final int zzep(final String s) {
        if (this.zzP("event", s)) {
            if (!this.zza("event", AppMeasurement.Event.zzbof, s)) {
                return 13;
            }
            if (this.zzb("event", zzcem.zzxh(), s)) {
                return 0;
            }
        }
        return 2;
    }
    
    public final int zzeq(final String s) {
        if (this.zzQ("event", s)) {
            if (!this.zza("event", AppMeasurement.Event.zzbof, s)) {
                return 13;
            }
            if (this.zzb("event", zzcem.zzxh(), s)) {
                return 0;
            }
        }
        return 2;
    }
    
    public final int zzer(final String s) {
        if (this.zzP("user property", s)) {
            if (!this.zza("user property", AppMeasurement.UserProperty.zzbom, s)) {
                return 15;
            }
            if (this.zzb("user property", zzcem.zzxi(), s)) {
                return 0;
            }
        }
        return 6;
    }
    
    public final int zzes(final String s) {
        if (this.zzQ("user property", s)) {
            if (!this.zza("user property", AppMeasurement.UserProperty.zzbom, s)) {
                return 15;
            }
            if (this.zzb("user property", zzcem.zzxi(), s)) {
                return 0;
            }
        }
        return 6;
    }
    
    public final boolean zzev(final String s) {
        if (TextUtils.isEmpty((CharSequence)s)) {
            super.zzwF().zzyx().log("Missing google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI");
            return false;
        }
        zzbo.zzu(s);
        if (!s.matches("^1:\\d+:android:[a-f0-9]+$")) {
            super.zzwF().zzyx().zzj("Invalid google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI. provided id", s);
            return false;
        }
        return true;
    }
    
    public final boolean zzey(final String anObject) {
        if (TextUtils.isEmpty((CharSequence)anObject)) {
            return false;
        }
        final String zzya = super.zzwH().zzya();
        zzcem.zzxE();
        return zzya.equals(anObject);
    }
    
    public final boolean zzf(final long n, final long n2) {
        return n == 0L || n2 <= 0L || Math.abs(super.zzkq().currentTimeMillis() - n) > n2;
    }
    
    @Override
    protected final void zzjD() {
        final SecureRandom secureRandom = new SecureRandom();
        long newValue;
        if ((newValue = secureRandom.nextLong()) == 0L) {
            final long n = newValue = secureRandom.nextLong();
            if (n == 0L) {
                super.zzwF().zzyz().log("Utils falling back to Random for random id");
                newValue = n;
            }
        }
        this.zzbuF.set(newValue);
    }
    
    public final Object zzk(final String anObject, final Object o) {
        if ("_ev".equals(anObject)) {
            return zza(zzcem.zzxl(), o, true);
        }
        int n;
        if (zzex(anObject)) {
            n = zzcem.zzxl();
        }
        else {
            n = zzcem.zzxk();
        }
        return zza(n, o, false);
    }
    
    public final int zzl(final String anObject, final Object o) {
        boolean b;
        if ("_ldl".equals(anObject)) {
            b = this.zza("user property referrer", anObject, zzew(anObject), o, false);
        }
        else {
            b = this.zza("user property", anObject, zzew(anObject), o, false);
        }
        if (b) {
            return 0;
        }
        return 7;
    }
    
    public final byte[] zzl(byte[] byteArray) throws IOException {
        try {
            final ByteArrayOutputStream out = new ByteArrayOutputStream();
            final GZIPOutputStream gzipOutputStream = new GZIPOutputStream(out);
            gzipOutputStream.write(byteArray);
            gzipOutputStream.close();
            out.close();
            byteArray = out.toByteArray();
            return byteArray;
        }
        catch (IOException ex) {
            super.zzwF().zzyx().zzj("Failed to gzip content", ex);
            throw ex;
        }
    }
    
    public final Object zzm(final String anObject, final Object o) {
        if ("_ldl".equals(anObject)) {
            return zza(zzew(anObject), o, true);
        }
        return zza(zzew(anObject), o, false);
    }
    
    public final byte[] zzm(byte[] byteArray) throws IOException {
        ByteArrayInputStream in;
        GZIPInputStream gzipInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            in = new ByteArrayInputStream(byteArray);
            gzipInputStream = new GZIPInputStream(in);
            byteArrayOutputStream = new ByteArrayOutputStream();
            final byte[] array = new byte[1024];
            while (true) {
                final int read = gzipInputStream.read(array);
                if (read <= 0) {
                    break;
                }
                byteArrayOutputStream.write(array, 0, read);
            }
        }
        catch (IOException ex) {
            super.zzwF().zzyx().zzj("Failed to ungzip content", ex);
            throw ex;
        }
        gzipInputStream.close();
        in.close();
        byteArray = byteArrayOutputStream.toByteArray();
        return byteArray;
    }
    
    public final Bundle zzq(@NonNull final Uri uri) {
        Bundle bundle = null;
        if (uri != null) {
            while (true) {
                while (true) {
                    try {
                        if (uri.isHierarchical()) {
                            final String queryParameter = uri.getQueryParameter("utm_campaign");
                            final String queryParameter2 = uri.getQueryParameter("utm_source");
                            final String queryParameter3 = uri.getQueryParameter("utm_medium");
                            final String queryParameter4 = uri.getQueryParameter("gclid");
                            if (TextUtils.isEmpty((CharSequence)queryParameter) && TextUtils.isEmpty((CharSequence)queryParameter2) && TextUtils.isEmpty((CharSequence)queryParameter3) && TextUtils.isEmpty((CharSequence)queryParameter4)) {
                                break;
                            }
                            final Bundle bundle2 = new Bundle();
                            if (!TextUtils.isEmpty((CharSequence)queryParameter)) {
                                bundle2.putString("campaign", queryParameter);
                            }
                            if (!TextUtils.isEmpty((CharSequence)queryParameter2)) {
                                bundle2.putString("source", queryParameter2);
                            }
                            if (!TextUtils.isEmpty((CharSequence)queryParameter3)) {
                                bundle2.putString("medium", queryParameter3);
                            }
                            if (!TextUtils.isEmpty((CharSequence)queryParameter4)) {
                                bundle2.putString("gclid", queryParameter4);
                            }
                            final String queryParameter5 = uri.getQueryParameter("utm_term");
                            if (!TextUtils.isEmpty((CharSequence)queryParameter5)) {
                                bundle2.putString("term", queryParameter5);
                            }
                            final String queryParameter6 = uri.getQueryParameter("utm_content");
                            if (!TextUtils.isEmpty((CharSequence)queryParameter6)) {
                                bundle2.putString("content", queryParameter6);
                            }
                            final String queryParameter7 = uri.getQueryParameter("aclid");
                            if (!TextUtils.isEmpty((CharSequence)queryParameter7)) {
                                bundle2.putString("aclid", queryParameter7);
                            }
                            final String queryParameter8 = uri.getQueryParameter("cp1");
                            if (!TextUtils.isEmpty((CharSequence)queryParameter8)) {
                                bundle2.putString("cp1", queryParameter8);
                            }
                            final String queryParameter9 = uri.getQueryParameter("anid");
                            bundle = bundle2;
                            if (!TextUtils.isEmpty((CharSequence)queryParameter9)) {
                                bundle2.putString("anid", queryParameter9);
                                return bundle2;
                            }
                            break;
                        }
                    }
                    catch (UnsupportedOperationException ex) {
                        super.zzwF().zzyz().zzj("Install referrer url isn't a hierarchical URI", ex);
                        return null;
                    }
                    final String queryParameter4 = null;
                    final String queryParameter3 = null;
                    final String queryParameter2 = null;
                    final String queryParameter = null;
                    continue;
                }
            }
        }
        return bundle;
    }
    
    public final long zzzs() {
        if (this.zzbuF.get() == 0L) {
            synchronized (this.zzbuF) {
                final long nextLong = new Random(System.nanoTime() ^ super.zzkq().currentTimeMillis()).nextLong();
                final int zzbuG = this.zzbuG + 1;
                this.zzbuG = zzbuG;
                final long n = zzbuG;
                // monitorexit(this.zzbuF)
                return nextLong + n;
            }
        }
        synchronized (this.zzbuF) {
            this.zzbuF.compareAndSet(-1L, 1L);
            return this.zzbuF.getAndIncrement();
        }
    }
    
    @WorkerThread
    final SecureRandom zzzt() {
        super.zzjC();
        if (this.zzbuE == null) {
            this.zzbuE = new SecureRandom();
        }
        return this.zzbuE;
    }
}
