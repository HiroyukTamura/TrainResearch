// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.dynamite;

import com.google.android.gms.common.util.DynamiteApi;
import android.net.Uri;
import com.google.android.gms.dynamic.IObjectWrapper;
import android.os.RemoteException;
import android.os.IInterface;
import java.lang.reflect.InvocationTargetException;
import android.os.IBinder;
import com.google.android.gms.dynamic.zzn;
import android.database.Cursor;
import java.lang.reflect.Field;
import android.util.Log;
import com.google.android.gms.common.internal.zzbo;
import android.content.Context;

public final class DynamiteModule
{
    private static Boolean zzaSF;
    private static zzj zzaSG;
    private static zzl zzaSH;
    private static String zzaSI;
    private static final ThreadLocal<zza> zzaSJ;
    private static final zzh zzaSK;
    public static final zzd zzaSL;
    private static zzd zzaSM;
    public static final zzd zzaSN;
    public static final zzd zzaSO;
    public static final zzd zzaSP;
    private final Context zzaSQ;
    
    static {
        zzaSJ = new ThreadLocal<zza>();
        zzaSK = new com.google.android.gms.dynamite.zza();
        zzaSL = (zzd)new com.google.android.gms.dynamite.zzb();
        DynamiteModule.zzaSM = (zzd)new com.google.android.gms.dynamite.zzc();
        zzaSN = (zzd)new com.google.android.gms.dynamite.zzd();
        zzaSO = (zzd)new zze();
        zzaSP = (zzd)new zzf();
    }
    
    private DynamiteModule(final Context context) {
        this.zzaSQ = zzbo.zzu(context);
    }
    
    public static int zzE(final Context context, final String obj) {
        try {
            final ClassLoader classLoader = context.getApplicationContext().getClassLoader();
            final String value = String.valueOf("com.google.android.gms.dynamite.descriptors.");
            final String value2 = String.valueOf("ModuleDescriptor");
            final Class<?> loadClass = classLoader.loadClass(new StringBuilder(String.valueOf(value).length() + 1 + String.valueOf(obj).length() + String.valueOf(value2).length()).append(value).append(obj).append(".").append(value2).toString());
            final Field declaredField = loadClass.getDeclaredField("MODULE_ID");
            final Field declaredField2 = loadClass.getDeclaredField("MODULE_VERSION");
            if (!declaredField.get(null).equals(obj)) {
                final String value3 = String.valueOf(declaredField.get(null));
                Log.e("DynamiteModule", new StringBuilder(String.valueOf(value3).length() + 51 + String.valueOf(obj).length()).append("Module descriptor id '").append(value3).append("' didn't match expected id '").append(obj).append("'").toString());
                return 0;
            }
            return declaredField2.getInt(null);
        }
        catch (ClassNotFoundException ex2) {
            Log.w("DynamiteModule", new StringBuilder(String.valueOf(obj).length() + 45).append("Local module descriptor class for ").append(obj).append(" not found.").toString());
        }
        catch (Exception ex) {
            final String value4 = String.valueOf(ex.getMessage());
            String concat;
            if (value4.length() != 0) {
                concat = "Failed to load module descriptor class: ".concat(value4);
            }
            else {
                concat = new String("Failed to load module descriptor class: ");
            }
            Log.e("DynamiteModule", concat);
            goto Label_0223;
        }
    }
    
    public static int zzF(final Context context, final String s) {
        return zzb(context, s, false);
    }
    
    private static DynamiteModule zzG(final Context context, String s) {
        s = String.valueOf(s);
        if (s.length() != 0) {
            s = "Selected local version of ".concat(s);
        }
        else {
            s = new String("Selected local version of ");
        }
        Log.i("DynamiteModule", s);
        return new DynamiteModule(context.getApplicationContext());
    }
    
    private static Context zza(Context context, final String s, final int n, final Cursor cursor, final zzl zzl) {
        try {
            context = zzn.zzE(zzl.zza(zzn.zzw(context), s, n, zzn.zzw(cursor)));
            return context;
        }
        catch (Exception ex) {
            final String value = String.valueOf(ex.toString());
            String concat;
            if (value.length() != 0) {
                concat = "Failed to load DynamiteLoader: ".concat(value);
            }
            else {
                concat = new String("Failed to load DynamiteLoader: ");
            }
            Log.e("DynamiteModule", concat);
            return null;
        }
    }
    
    public static DynamiteModule zza(final Context context, final zzd zzd, final String s) throws zzc {
        final zza zza = DynamiteModule.zzaSJ.get();
        final zza value = new zza(null);
        DynamiteModule.zzaSJ.set(value);
        zzi zza2;
        try {
            zza2 = zzd.zza(context, s, DynamiteModule.zzaSK);
            Log.i("DynamiteModule", new StringBuilder(String.valueOf(s).length() + 68 + String.valueOf(s).length()).append("Considering local module ").append(s).append(":").append(zza2.zzaSU).append(" and remote module ").append(s).append(":").append(zza2.zzaSV).toString());
            if (zza2.zzaSW == 0 || (zza2.zzaSW == -1 && zza2.zzaSU == 0) || (zza2.zzaSW == 1 && zza2.zzaSV == 0)) {
                throw new zzc(new StringBuilder(91).append("No acceptable module found. Local version is ").append(zza2.zzaSU).append(" and remote version is ").append(zza2.zzaSV).append(".").toString(), (com.google.android.gms.dynamite.zza)null);
            }
        }
        finally {
            if (value.zzaSR != null) {
                value.zzaSR.close();
            }
            DynamiteModule.zzaSJ.set(zza);
        }
        if (zza2.zzaSW == -1) {
            final DynamiteModule zzG = zzG(context, s);
            if (value.zzaSR != null) {
                value.zzaSR.close();
            }
            DynamiteModule.zzaSJ.set(zza);
            return zzG;
        }
        if (zza2.zzaSW == 1) {
            try {
                final DynamiteModule zza3 = zza(context, s, zza2.zzaSV);
                if (value.zzaSR != null) {
                    value.zzaSR.close();
                }
                DynamiteModule.zzaSJ.set(zza);
                return zza3;
            }
            catch (zzc zzc) {
                final String value2 = String.valueOf(zzc.getMessage());
                String concat;
                if (value2.length() != 0) {
                    concat = "Failed to load remote module: ".concat(value2);
                }
                else {
                    concat = new String("Failed to load remote module: ");
                }
                Log.w("DynamiteModule", concat);
                if (zza2.zzaSU != 0 && zzd.zza(context, s, new zzb(zza2.zzaSU, 0)).zzaSW == -1) {
                    final DynamiteModule zzG2 = zzG(context, s);
                    if (value.zzaSR != null) {
                        value.zzaSR.close();
                    }
                    DynamiteModule.zzaSJ.set(zza);
                    return zzG2;
                }
                throw new zzc("Remote load failed. No local fallback found.", zzc, null);
            }
        }
        throw new zzc(new StringBuilder(47).append("VersionPolicy returned invalid code:").append(zza2.zzaSW).toString(), (com.google.android.gms.dynamite.zza)null);
    }
    
    private static DynamiteModule zza(final Context context, final String s, final int n) throws zzc {
        final Boolean zzaSF;
        synchronized (DynamiteModule.class) {
            zzaSF = DynamiteModule.zzaSF;
            // monitorexit(DynamiteModule.class)
            if (zzaSF == null) {
                throw new zzc("Failed to determine which loading route to use.", (com.google.android.gms.dynamite.zza)null);
            }
        }
        final Context context2;
        if (zzaSF) {
            return zzc(context2, s, n);
        }
        return zzb(context2, s, n);
    }
    
    private static void zza(ClassLoader zzaSH) throws zzc {
        try {
            zzaSH = (InstantiationException)((ClassLoader)zzaSH).loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor((Class<?>[])new Class[0]).newInstance(new Object[0]);
            if (zzaSH == null) {
                zzaSH = null;
            }
            else {
                final IInterface queryLocalInterface = ((IBinder)zzaSH).queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
                if (queryLocalInterface instanceof zzl) {
                    zzaSH = (InstantiationException)queryLocalInterface;
                }
                else {
                    zzaSH = (InstantiationException)new zzm((IBinder)zzaSH);
                }
            }
            DynamiteModule.zzaSH = (zzl)zzaSH;
        }
        catch (ClassNotFoundException ex) {}
        catch (InstantiationException zzaSH) {
            goto Label_0074;
        }
        catch (IllegalAccessException zzaSH) {
            goto Label_0074;
        }
        catch (NoSuchMethodException zzaSH) {
            goto Label_0074;
        }
        catch (InvocationTargetException zzaSH) {
            goto Label_0074;
        }
    }
    
    private static zzj zzaT(final Context p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     2: monitorenter   
        //     3: getstatic       com/google/android/gms/dynamite/DynamiteModule.zzaSG:Lcom/google/android/gms/dynamite/zzj;
        //     6: ifnull          18
        //     9: getstatic       com/google/android/gms/dynamite/DynamiteModule.zzaSG:Lcom/google/android/gms/dynamite/zzj;
        //    12: astore_0       
        //    13: ldc             Lcom/google/android/gms/dynamite/DynamiteModule;.class
        //    15: monitorexit    
        //    16: aload_0        
        //    17: areturn        
        //    18: invokestatic    com/google/android/gms/common/zze.zzoW:()Lcom/google/android/gms/common/zze;
        //    21: aload_0        
        //    22: invokevirtual   com/google/android/gms/common/zze.isGooglePlayServicesAvailable:(Landroid/content/Context;)I
        //    25: ifeq            33
        //    28: ldc             Lcom/google/android/gms/dynamite/DynamiteModule;.class
        //    30: monitorexit    
        //    31: aconst_null    
        //    32: areturn        
        //    33: aload_0        
        //    34: ldc_w           "com.google.android.gms"
        //    37: iconst_3       
        //    38: invokevirtual   android/content/Context.createPackageContext:(Ljava/lang/String;I)Landroid/content/Context;
        //    41: invokevirtual   android/content/Context.getClassLoader:()Ljava/lang/ClassLoader;
        //    44: ldc_w           "com.google.android.gms.chimera.container.DynamiteLoaderImpl"
        //    47: invokevirtual   java/lang/ClassLoader.loadClass:(Ljava/lang/String;)Ljava/lang/Class;
        //    50: invokevirtual   java/lang/Class.newInstance:()Ljava/lang/Object;
        //    53: checkcast       Landroid/os/IBinder;
        //    56: astore_0       
        //    57: aload_0        
        //    58: ifnonnull       82
        //    61: aconst_null    
        //    62: astore_0       
        //    63: aload_0        
        //    64: ifnull          150
        //    67: aload_0        
        //    68: putstatic       com/google/android/gms/dynamite/DynamiteModule.zzaSG:Lcom/google/android/gms/dynamite/zzj;
        //    71: ldc             Lcom/google/android/gms/dynamite/DynamiteModule;.class
        //    73: monitorexit    
        //    74: aload_0        
        //    75: areturn        
        //    76: astore_0       
        //    77: ldc             Lcom/google/android/gms/dynamite/DynamiteModule;.class
        //    79: monitorexit    
        //    80: aload_0        
        //    81: athrow         
        //    82: aload_0        
        //    83: ldc_w           "com.google.android.gms.dynamite.IDynamiteLoader"
        //    86: invokeinterface android/os/IBinder.queryLocalInterface:(Ljava/lang/String;)Landroid/os/IInterface;
        //    91: astore_1       
        //    92: aload_1        
        //    93: instanceof      Lcom/google/android/gms/dynamite/zzj;
        //    96: ifeq            107
        //    99: aload_1        
        //   100: checkcast       Lcom/google/android/gms/dynamite/zzj;
        //   103: astore_0       
        //   104: goto            63
        //   107: new             Lcom/google/android/gms/dynamite/zzk;
        //   110: dup            
        //   111: aload_0        
        //   112: invokespecial   com/google/android/gms/dynamite/zzk.<init>:(Landroid/os/IBinder;)V
        //   115: astore_0       
        //   116: goto            63
        //   119: astore_0       
        //   120: aload_0        
        //   121: invokevirtual   java/lang/Exception.getMessage:()Ljava/lang/String;
        //   124: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //   127: astore_0       
        //   128: aload_0        
        //   129: invokevirtual   java/lang/String.length:()I
        //   132: ifeq            155
        //   135: ldc_w           "Failed to load IDynamiteLoader from GmsCore: "
        //   138: aload_0        
        //   139: invokevirtual   java/lang/String.concat:(Ljava/lang/String;)Ljava/lang/String;
        //   142: astore_0       
        //   143: ldc             "DynamiteModule"
        //   145: aload_0        
        //   146: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;)I
        //   149: pop            
        //   150: ldc             Lcom/google/android/gms/dynamite/DynamiteModule;.class
        //   152: monitorexit    
        //   153: aconst_null    
        //   154: areturn        
        //   155: new             Ljava/lang/String;
        //   158: dup            
        //   159: ldc_w           "Failed to load IDynamiteLoader from GmsCore: "
        //   162: invokespecial   java/lang/String.<init>:(Ljava/lang/String;)V
        //   165: astore_0       
        //   166: goto            143
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  3      16     76     82     Any
        //  18     31     76     82     Any
        //  33     57     119    169    Ljava/lang/Exception;
        //  33     57     76     82     Any
        //  67     71     119    169    Ljava/lang/Exception;
        //  67     71     76     82     Any
        //  71     74     76     82     Any
        //  77     80     76     82     Any
        //  82     104    119    169    Ljava/lang/Exception;
        //  82     104    76     82     Any
        //  107    116    119    169    Ljava/lang/Exception;
        //  107    116    76     82     Any
        //  120    143    76     82     Any
        //  143    150    76     82     Any
        //  150    153    76     82     Any
        //  155    166    76     82     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0033:
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
    
    public static int zzb(final Context p0, final String p1, final boolean p2) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     2: monitorenter   
        //     3: getstatic       com/google/android/gms/dynamite/DynamiteModule.zzaSF:Ljava/lang/Boolean;
        //     6: astore          6
        //     8: aload           6
        //    10: astore          5
        //    12: aload           6
        //    14: ifnonnull       84
        //    17: aload_0        
        //    18: invokevirtual   android/content/Context.getApplicationContext:()Landroid/content/Context;
        //    21: invokevirtual   android/content/Context.getClassLoader:()Ljava/lang/ClassLoader;
        //    24: ldc             Lcom/google/android/gms/dynamite/DynamiteModule$DynamiteLoaderClassLoader;.class
        //    26: invokevirtual   java/lang/Class.getName:()Ljava/lang/String;
        //    29: invokevirtual   java/lang/ClassLoader.loadClass:(Ljava/lang/String;)Ljava/lang/Class;
        //    32: astore          6
        //    34: aload           6
        //    36: ldc_w           "sClassLoader"
        //    39: invokevirtual   java/lang/Class.getDeclaredField:(Ljava/lang/String;)Ljava/lang/reflect/Field;
        //    42: astore          5
        //    44: aload           6
        //    46: monitorenter   
        //    47: aload           5
        //    49: aconst_null    
        //    50: invokevirtual   java/lang/reflect/Field.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //    53: checkcast       Ljava/lang/ClassLoader;
        //    56: astore          7
        //    58: aload           7
        //    60: ifnull          117
        //    63: aload           7
        //    65: invokestatic    java/lang/ClassLoader.getSystemClassLoader:()Ljava/lang/ClassLoader;
        //    68: if_acmpne       104
        //    71: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //    74: astore          5
        //    76: aload           6
        //    78: monitorexit    
        //    79: aload           5
        //    81: putstatic       com/google/android/gms/dynamite/DynamiteModule.zzaSF:Ljava/lang/Boolean;
        //    84: ldc             Lcom/google/android/gms/dynamite/DynamiteModule;.class
        //    86: monitorexit    
        //    87: aload           5
        //    89: invokevirtual   java/lang/Boolean.booleanValue:()Z
        //    92: ifeq            361
        //    95: aload_0        
        //    96: aload_1        
        //    97: iload_2        
        //    98: invokestatic    com/google/android/gms/dynamite/DynamiteModule.zzd:(Landroid/content/Context;Ljava/lang/String;Z)I
        //   101: istore_3       
        //   102: iload_3        
        //   103: ireturn        
        //   104: aload           7
        //   106: invokestatic    com/google/android/gms/dynamite/DynamiteModule.zza:(Ljava/lang/ClassLoader;)V
        //   109: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   112: astore          5
        //   114: goto            76
        //   117: ldc_w           "com.google.android.gms"
        //   120: aload_0        
        //   121: invokevirtual   android/content/Context.getApplicationContext:()Landroid/content/Context;
        //   124: invokevirtual   android/content/Context.getPackageName:()Ljava/lang/String;
        //   127: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   130: ifeq            150
        //   133: aload           5
        //   135: aconst_null    
        //   136: invokestatic    java/lang/ClassLoader.getSystemClassLoader:()Ljava/lang/ClassLoader;
        //   139: invokevirtual   java/lang/reflect/Field.set:(Ljava/lang/Object;Ljava/lang/Object;)V
        //   142: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   145: astore          5
        //   147: goto            76
        //   150: aload_0        
        //   151: aload_1        
        //   152: iload_2        
        //   153: invokestatic    com/google/android/gms/dynamite/DynamiteModule.zzd:(Landroid/content/Context;Ljava/lang/String;Z)I
        //   156: istore_3       
        //   157: getstatic       com/google/android/gms/dynamite/DynamiteModule.zzaSI:Ljava/lang/String;
        //   160: ifnull          176
        //   163: getstatic       com/google/android/gms/dynamite/DynamiteModule.zzaSI:Ljava/lang/String;
        //   166: invokevirtual   java/lang/String.isEmpty:()Z
        //   169: istore          4
        //   171: iload           4
        //   173: ifeq            190
        //   176: aload           6
        //   178: monitorexit    
        //   179: ldc             Lcom/google/android/gms/dynamite/DynamiteModule;.class
        //   181: monitorexit    
        //   182: iload_3        
        //   183: ireturn        
        //   184: astore_0       
        //   185: ldc             Lcom/google/android/gms/dynamite/DynamiteModule;.class
        //   187: monitorexit    
        //   188: aload_0        
        //   189: athrow         
        //   190: new             Lcom/google/android/gms/dynamite/zzg;
        //   193: dup            
        //   194: getstatic       com/google/android/gms/dynamite/DynamiteModule.zzaSI:Ljava/lang/String;
        //   197: invokestatic    java/lang/ClassLoader.getSystemClassLoader:()Ljava/lang/ClassLoader;
        //   200: invokespecial   com/google/android/gms/dynamite/zzg.<init>:(Ljava/lang/String;Ljava/lang/ClassLoader;)V
        //   203: astore          7
        //   205: aload           7
        //   207: invokestatic    com/google/android/gms/dynamite/DynamiteModule.zza:(Ljava/lang/ClassLoader;)V
        //   210: aload           5
        //   212: aconst_null    
        //   213: aload           7
        //   215: invokevirtual   java/lang/reflect/Field.set:(Ljava/lang/Object;Ljava/lang/Object;)V
        //   218: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   221: putstatic       com/google/android/gms/dynamite/DynamiteModule.zzaSF:Ljava/lang/Boolean;
        //   224: aload           6
        //   226: monitorexit    
        //   227: ldc             Lcom/google/android/gms/dynamite/DynamiteModule;.class
        //   229: monitorexit    
        //   230: iload_3        
        //   231: ireturn        
        //   232: astore          7
        //   234: aload           5
        //   236: aconst_null    
        //   237: invokestatic    java/lang/ClassLoader.getSystemClassLoader:()Ljava/lang/ClassLoader;
        //   240: invokevirtual   java/lang/reflect/Field.set:(Ljava/lang/Object;Ljava/lang/Object;)V
        //   243: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   246: astore          5
        //   248: goto            76
        //   251: astore          5
        //   253: aload           6
        //   255: monitorexit    
        //   256: aload           5
        //   258: athrow         
        //   259: astore          5
        //   261: aload           5
        //   263: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //   266: astore          5
        //   268: ldc             "DynamiteModule"
        //   270: new             Ljava/lang/StringBuilder;
        //   273: dup            
        //   274: aload           5
        //   276: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //   279: invokevirtual   java/lang/String.length:()I
        //   282: bipush          30
        //   284: iadd           
        //   285: invokespecial   java/lang/StringBuilder.<init>:(I)V
        //   288: ldc_w           "Failed to load module via V2: "
        //   291: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   294: aload           5
        //   296: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   299: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   302: invokestatic    android/util/Log.w:(Ljava/lang/String;Ljava/lang/String;)I
        //   305: pop            
        //   306: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   309: astore          5
        //   311: goto            79
        //   314: astore_0       
        //   315: aload_0        
        //   316: invokevirtual   com/google/android/gms/dynamite/DynamiteModule$zzc.getMessage:()Ljava/lang/String;
        //   319: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //   322: astore_0       
        //   323: aload_0        
        //   324: invokevirtual   java/lang/String.length:()I
        //   327: ifeq            347
        //   330: ldc_w           "Failed to retrieve remote module version: "
        //   333: aload_0        
        //   334: invokevirtual   java/lang/String.concat:(Ljava/lang/String;)Ljava/lang/String;
        //   337: astore_0       
        //   338: ldc             "DynamiteModule"
        //   340: aload_0        
        //   341: invokestatic    android/util/Log.w:(Ljava/lang/String;Ljava/lang/String;)I
        //   344: pop            
        //   345: iconst_0       
        //   346: ireturn        
        //   347: new             Ljava/lang/String;
        //   350: dup            
        //   351: ldc_w           "Failed to retrieve remote module version: "
        //   354: invokespecial   java/lang/String.<init>:(Ljava/lang/String;)V
        //   357: astore_0       
        //   358: goto            338
        //   361: aload_0        
        //   362: aload_1        
        //   363: iload_2        
        //   364: invokestatic    com/google/android/gms/dynamite/DynamiteModule.zzc:(Landroid/content/Context;Ljava/lang/String;Z)I
        //   367: ireturn        
        //   368: astore          5
        //   370: goto            109
        //   373: astore          5
        //   375: goto            261
        //   378: astore          5
        //   380: goto            261
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                                
        //  -----  -----  -----  -----  ----------------------------------------------------
        //  3      8      184    190    Any
        //  17     47     259    261    Ljava/lang/ClassNotFoundException;
        //  17     47     378    383    Ljava/lang/IllegalAccessException;
        //  17     47     373    378    Ljava/lang/NoSuchFieldException;
        //  17     47     184    190    Any
        //  47     58     251    259    Any
        //  63     76     251    259    Any
        //  76     79     251    259    Any
        //  79     84     184    190    Any
        //  84     87     184    190    Any
        //  95     102    314    361    Lcom/google/android/gms/dynamite/DynamiteModule$zzc;
        //  104    109    368    373    Lcom/google/android/gms/dynamite/DynamiteModule$zzc;
        //  104    109    251    259    Any
        //  109    114    251    259    Any
        //  117    147    251    259    Any
        //  150    171    232    251    Lcom/google/android/gms/dynamite/DynamiteModule$zzc;
        //  150    171    251    259    Any
        //  176    179    251    259    Any
        //  179    182    184    190    Any
        //  185    188    184    190    Any
        //  190    224    232    251    Lcom/google/android/gms/dynamite/DynamiteModule$zzc;
        //  190    224    251    259    Any
        //  224    227    251    259    Any
        //  227    230    184    190    Any
        //  234    248    251    259    Any
        //  253    256    251    259    Any
        //  256    259    259    261    Ljava/lang/ClassNotFoundException;
        //  256    259    378    383    Ljava/lang/IllegalAccessException;
        //  256    259    373    378    Ljava/lang/NoSuchFieldException;
        //  256    259    184    190    Any
        //  261    311    184    190    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 181 out of bounds for length 181
        //     at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        //     at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        //     at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
        //     at java.base/java.util.Objects.checkIndex(Objects.java:372)
        //     at java.base/java.util.ArrayList.get(ArrayList.java:458)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3321)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:113)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:211)
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
    
    private static DynamiteModule zzb(final Context context, final String s, final int i) throws zzc {
        Log.i("DynamiteModule", new StringBuilder(String.valueOf(s).length() + 51).append("Selected remote version of ").append(s).append(", version >= ").append(i).toString());
        final zzj zzaT = zzaT(context);
        if (zzaT == null) {
            throw new zzc("Failed to create IDynamiteLoader.", (com.google.android.gms.dynamite.zza)null);
        }
        IObjectWrapper zza;
        try {
            zza = zzaT.zza(zzn.zzw(context), s, i);
            if (zzn.zzE(zza) == null) {
                throw new zzc("Failed to load remote module.", (com.google.android.gms.dynamite.zza)null);
            }
        }
        catch (RemoteException ex) {
            throw new zzc("Failed to load remote module.", (Throwable)ex, null);
        }
        return new DynamiteModule((Context)zzn.zzE(zza));
    }
    
    private static int zzc(final Context context, final String s, final boolean b) {
        final zzj zzaT = zzaT(context);
        if (zzaT == null) {
            return 0;
        }
        try {
            return zzaT.zza(zzn.zzw(context), s, b);
        }
        catch (RemoteException ex) {
            final String value = String.valueOf(ex.getMessage());
            String concat;
            if (value.length() != 0) {
                concat = "Failed to retrieve remote module version: ".concat(value);
            }
            else {
                concat = new String("Failed to retrieve remote module version: ");
            }
            Log.w("DynamiteModule", concat);
            return 0;
        }
    }
    
    private static DynamiteModule zzc(Context zza, final String s, final int i) throws zzc {
        Log.i("DynamiteModule", new StringBuilder(String.valueOf(s).length() + 51).append("Selected remote version of ").append(s).append(", version >= ").append(i).toString());
        final zzl zzaSH;
        synchronized (DynamiteModule.class) {
            zzaSH = DynamiteModule.zzaSH;
            // monitorexit(DynamiteModule.class)
            if (zzaSH == null) {
                throw new zzc("DynamiteLoaderV2 was not cached.", (com.google.android.gms.dynamite.zza)null);
            }
        }
        final zza zza2 = DynamiteModule.zzaSJ.get();
        if (zza2 == null || zza2.zzaSR == null) {
            throw new zzc("No result cursor", (com.google.android.gms.dynamite.zza)null);
        }
        final Context context;
        zza = zza(context.getApplicationContext(), s, i, zza2.zzaSR, zzaSH);
        if (zza == null) {
            throw new zzc("Failed to get module context", (com.google.android.gms.dynamite.zza)null);
        }
        return new DynamiteModule(zza);
    }
    
    private static int zzd(Context query, String parse, final boolean b) throws zzc {
        Label_0161: {
            if (!b) {
                break Label_0161;
            }
            Object o = "api_force_staging";
            while (true) {
                try {
                Label_0106_Outer:
                    while (true) {
                        final String value = String.valueOf("content://com.google.android.gms.chimera/");
                        parse = (String)Uri.parse(new StringBuilder(String.valueOf(value).length() + 1 + String.valueOf(o).length() + String.valueOf(parse).length()).append(value).append((String)o).append("/").append(parse).toString());
                        query = (Context)query.getContentResolver().query((Uri)parse, (String[])null, (String)null, (String[])null, (String)null);
                        while (true) {
                            if (query != null) {
                                parse = (String)query;
                                Label_0169: {
                                    try {
                                        try {
                                            if (!((Cursor)query).moveToFirst()) {
                                                parse = (String)query;
                                                Log.w("DynamiteModule", "Failed to retrieve remote module version.");
                                                parse = (String)query;
                                                throw new zzc("Failed to connect to dynamite module ContentResolver.", (com.google.android.gms.dynamite.zza)null);
                                            }
                                            break Label_0169;
                                        }
                                        catch (Exception ex) {}
                                        parse = (String)query;
                                        if (o instanceof zzc) {
                                            parse = (String)query;
                                            throw o;
                                        }
                                        throw new zzc("V2 version check failed", (Throwable)o, null);
                                    }
                                    finally {}
                                    if (parse != null) {
                                        ((Cursor)parse).close();
                                    }
                                    throw query;
                                }
                                final int int1 = ((Cursor)query).getInt(0);
                                o = query;
                                Label_0249: {
                                    if (int1 <= 0) {
                                        break Label_0249;
                                    }
                                    synchronized (DynamiteModule.class) {
                                        DynamiteModule.zzaSI = ((Cursor)query).getString(2);
                                        // monitorexit(DynamiteModule.class)
                                        final zza zza = DynamiteModule.zzaSJ.get();
                                        o = query;
                                        if (zza != null) {
                                            o = query;
                                            if (zza.zzaSR == null) {
                                                zza.zzaSR = (Cursor)query;
                                                o = null;
                                            }
                                        }
                                        if (o != null) {
                                            ((Cursor)o).close();
                                        }
                                        return int1;
                                    }
                                }
                                throw new zzc("V2 version check failed", (Throwable)o, null);
                            }
                            continue;
                        }
                        o = "api";
                        continue Label_0106_Outer;
                    }
                }
                catch (Exception o) {}
                finally {
                    parse = null;
                    continue;
                }
                break;
            }
        }
    }
    
    public final IBinder zzcV(final String name) throws zzc {
        try {
            return (IBinder)this.zzaSQ.getClassLoader().loadClass((String)name).newInstance();
        }
        catch (ClassNotFoundException ex) {}
        catch (InstantiationException binder) {
            goto Label_0021;
        }
        catch (IllegalAccessException binder) {
            goto Label_0021;
        }
    }
    
    public final Context zztC() {
        return this.zzaSQ;
    }
    
    @DynamiteApi
    public static class DynamiteLoaderClassLoader
    {
        public static ClassLoader sClassLoader;
    }
    
    static final class zza
    {
        public Cursor zzaSR;
        
        private zza() {
        }
    }
    
    static final class zzb implements zzh
    {
        private final int zzaSS;
        private final int zzaST;
        
        public zzb(final int zzaSS, final int n) {
            this.zzaSS = zzaSS;
            this.zzaST = 0;
        }
        
        @Override
        public final int zzE(final Context context, final String s) {
            return this.zzaSS;
        }
        
        @Override
        public final int zzb(final Context context, final String s, final boolean b) {
            return 0;
        }
    }
    
    public static final class zzc extends Exception
    {
        private zzc(final String message) {
            super(message);
        }
        
        private zzc(final String message, final Throwable cause) {
            super(message, cause);
        }
    }
    
    public interface zzd
    {
        zzi zza(final Context p0, final String p1, final zzh p2) throws zzc;
    }
}
