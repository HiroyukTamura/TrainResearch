// 
// Decompiled by Procyon v0.5.36
// 

package com.google.firebase.messaging;

import com.google.android.gms.internal.aem;
import java.util.Iterator;
import android.content.Context;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import com.google.android.gms.measurement.AppMeasurement;
import android.text.TextUtils;
import android.os.Bundle;
import android.support.annotation.Nullable;
import com.google.android.gms.internal.ado;
import com.google.android.gms.internal.aen;
import android.support.annotation.NonNull;

public final class zzc
{
    @Nullable
    private static aen zzA(@NonNull final byte[] array) {
        try {
            return aen.zzL(array);
        }
        catch (ado ado) {
            return null;
        }
    }
    
    private static String zzS(@NonNull final Object obj) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        return (String)Class.forName("com.google.android.gms.measurement.AppMeasurement$ConditionalUserProperty").getField("mName").get(obj);
    }
    
    private static String zzT(@NonNull final Object obj) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        return (String)Class.forName("com.google.android.gms.measurement.AppMeasurement$ConditionalUserProperty").getField("mValue").get(obj);
    }
    
    private static Bundle zzX(@NonNull final String s, @NonNull final String s2) {
        final Bundle bundle = new Bundle();
        bundle.putString(s, s2);
        return bundle;
    }
    
    private static Bundle zza(@NonNull final aen aen) {
        return zzX(aen.zzcun, aen.zzcuo);
    }
    
    @Nullable
    private static Object zza(@NonNull final aen p0, @NonNull final String p1, @NonNull final zzb p2) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: astore          4
        //     3: ldc             "com.google.android.gms.measurement.AppMeasurement$ConditionalUserProperty"
        //     5: invokestatic    java/lang/Class.forName:(Ljava/lang/String;)Ljava/lang/Class;
        //     8: astore          5
        //    10: aload_0        
        //    11: invokestatic    com/google/firebase/messaging/zzc.zza:(Lcom/google/android/gms/internal/aen;)Landroid/os/Bundle;
        //    14: astore          6
        //    16: aload           5
        //    18: iconst_0       
        //    19: anewarray       Ljava/lang/Class;
        //    22: invokevirtual   java/lang/Class.getConstructor:([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
        //    25: iconst_0       
        //    26: anewarray       Ljava/lang/Object;
        //    29: invokevirtual   java/lang/reflect/Constructor.newInstance:([Ljava/lang/Object;)Ljava/lang/Object;
        //    32: astore_3       
        //    33: aload           5
        //    35: ldc             "mOrigin"
        //    37: invokevirtual   java/lang/Class.getField:(Ljava/lang/String;)Ljava/lang/reflect/Field;
        //    40: aload_3        
        //    41: aload_1        
        //    42: invokevirtual   java/lang/reflect/Field.set:(Ljava/lang/Object;Ljava/lang/Object;)V
        //    45: aload           5
        //    47: ldc             "mCreationTimestamp"
        //    49: invokevirtual   java/lang/Class.getField:(Ljava/lang/String;)Ljava/lang/reflect/Field;
        //    52: aload_3        
        //    53: aload_0        
        //    54: getfield        com/google/android/gms/internal/aen.zzcup:J
        //    57: invokestatic    java/lang/Long.valueOf:(J)Ljava/lang/Long;
        //    60: invokevirtual   java/lang/reflect/Field.set:(Ljava/lang/Object;Ljava/lang/Object;)V
        //    63: aload           5
        //    65: ldc             "mName"
        //    67: invokevirtual   java/lang/Class.getField:(Ljava/lang/String;)Ljava/lang/reflect/Field;
        //    70: aload_3        
        //    71: aload_0        
        //    72: getfield        com/google/android/gms/internal/aen.zzcun:Ljava/lang/String;
        //    75: invokevirtual   java/lang/reflect/Field.set:(Ljava/lang/Object;Ljava/lang/Object;)V
        //    78: aload           5
        //    80: ldc             "mValue"
        //    82: invokevirtual   java/lang/Class.getField:(Ljava/lang/String;)Ljava/lang/reflect/Field;
        //    85: aload_3        
        //    86: aload_0        
        //    87: getfield        com/google/android/gms/internal/aen.zzcuo:Ljava/lang/String;
        //    90: invokevirtual   java/lang/reflect/Field.set:(Ljava/lang/Object;Ljava/lang/Object;)V
        //    93: aload_0        
        //    94: getfield        com/google/android/gms/internal/aen.zzcuq:Ljava/lang/String;
        //    97: invokestatic    android/text/TextUtils.isEmpty:(Ljava/lang/CharSequence;)Z
        //   100: ifeq            286
        //   103: aload           4
        //   105: astore_1       
        //   106: aload           5
        //   108: ldc             "mTriggerEventName"
        //   110: invokevirtual   java/lang/Class.getField:(Ljava/lang/String;)Ljava/lang/reflect/Field;
        //   113: aload_3        
        //   114: aload_1        
        //   115: invokevirtual   java/lang/reflect/Field.set:(Ljava/lang/Object;Ljava/lang/Object;)V
        //   118: aload           5
        //   120: ldc             "mTimedOutEventName"
        //   122: invokevirtual   java/lang/Class.getField:(Ljava/lang/String;)Ljava/lang/reflect/Field;
        //   125: astore          4
        //   127: aload_0        
        //   128: getfield        com/google/android/gms/internal/aen.zzcuv:Ljava/lang/String;
        //   131: invokestatic    android/text/TextUtils.isEmpty:(Ljava/lang/CharSequence;)Z
        //   134: ifne            294
        //   137: aload_0        
        //   138: getfield        com/google/android/gms/internal/aen.zzcuv:Ljava/lang/String;
        //   141: astore_1       
        //   142: aload           4
        //   144: aload_3        
        //   145: aload_1        
        //   146: invokevirtual   java/lang/reflect/Field.set:(Ljava/lang/Object;Ljava/lang/Object;)V
        //   149: aload           5
        //   151: ldc             "mTimedOutEventParams"
        //   153: invokevirtual   java/lang/Class.getField:(Ljava/lang/String;)Ljava/lang/reflect/Field;
        //   156: aload_3        
        //   157: aload           6
        //   159: invokevirtual   java/lang/reflect/Field.set:(Ljava/lang/Object;Ljava/lang/Object;)V
        //   162: aload           5
        //   164: ldc             "mTriggerTimeout"
        //   166: invokevirtual   java/lang/Class.getField:(Ljava/lang/String;)Ljava/lang/reflect/Field;
        //   169: aload_3        
        //   170: aload_0        
        //   171: getfield        com/google/android/gms/internal/aen.zzcur:J
        //   174: invokestatic    java/lang/Long.valueOf:(J)Ljava/lang/Long;
        //   177: invokevirtual   java/lang/reflect/Field.set:(Ljava/lang/Object;Ljava/lang/Object;)V
        //   180: aload           5
        //   182: ldc             "mTriggeredEventName"
        //   184: invokevirtual   java/lang/Class.getField:(Ljava/lang/String;)Ljava/lang/reflect/Field;
        //   187: astore          4
        //   189: aload_0        
        //   190: getfield        com/google/android/gms/internal/aen.zzcut:Ljava/lang/String;
        //   193: invokestatic    android/text/TextUtils.isEmpty:(Ljava/lang/CharSequence;)Z
        //   196: ifne            302
        //   199: aload_0        
        //   200: getfield        com/google/android/gms/internal/aen.zzcut:Ljava/lang/String;
        //   203: astore_1       
        //   204: aload           4
        //   206: aload_3        
        //   207: aload_1        
        //   208: invokevirtual   java/lang/reflect/Field.set:(Ljava/lang/Object;Ljava/lang/Object;)V
        //   211: aload           5
        //   213: ldc             "mTriggeredEventParams"
        //   215: invokevirtual   java/lang/Class.getField:(Ljava/lang/String;)Ljava/lang/reflect/Field;
        //   218: aload_3        
        //   219: aload           6
        //   221: invokevirtual   java/lang/reflect/Field.set:(Ljava/lang/Object;Ljava/lang/Object;)V
        //   224: aload           5
        //   226: ldc             "mTimeToLive"
        //   228: invokevirtual   java/lang/Class.getField:(Ljava/lang/String;)Ljava/lang/reflect/Field;
        //   231: aload_3        
        //   232: aload_0        
        //   233: getfield        com/google/android/gms/internal/aen.zzaLt:J
        //   236: invokestatic    java/lang/Long.valueOf:(J)Ljava/lang/Long;
        //   239: invokevirtual   java/lang/reflect/Field.set:(Ljava/lang/Object;Ljava/lang/Object;)V
        //   242: aload           5
        //   244: ldc             "mExpiredEventName"
        //   246: invokevirtual   java/lang/Class.getField:(Ljava/lang/String;)Ljava/lang/reflect/Field;
        //   249: astore_1       
        //   250: aload_0        
        //   251: getfield        com/google/android/gms/internal/aen.zzcuw:Ljava/lang/String;
        //   254: invokestatic    android/text/TextUtils.isEmpty:(Ljava/lang/CharSequence;)Z
        //   257: ifne            310
        //   260: aload_0        
        //   261: getfield        com/google/android/gms/internal/aen.zzcuw:Ljava/lang/String;
        //   264: astore_0       
        //   265: aload_1        
        //   266: aload_3        
        //   267: aload_0        
        //   268: invokevirtual   java/lang/reflect/Field.set:(Ljava/lang/Object;Ljava/lang/Object;)V
        //   271: aload           5
        //   273: ldc             "mExpiredEventParams"
        //   275: invokevirtual   java/lang/Class.getField:(Ljava/lang/String;)Ljava/lang/reflect/Field;
        //   278: aload_3        
        //   279: aload           6
        //   281: invokevirtual   java/lang/reflect/Field.set:(Ljava/lang/Object;Ljava/lang/Object;)V
        //   284: aload_3        
        //   285: areturn        
        //   286: aload_0        
        //   287: getfield        com/google/android/gms/internal/aen.zzcuq:Ljava/lang/String;
        //   290: astore_1       
        //   291: goto            106
        //   294: aload_2        
        //   295: invokevirtual   com/google/firebase/messaging/zzb.zzEw:()Ljava/lang/String;
        //   298: astore_1       
        //   299: goto            142
        //   302: aload_2        
        //   303: invokevirtual   com/google/firebase/messaging/zzb.zzEv:()Ljava/lang/String;
        //   306: astore_1       
        //   307: goto            204
        //   310: aload_2        
        //   311: invokevirtual   com/google/firebase/messaging/zzb.zzEx:()Ljava/lang/String;
        //   314: astore_0       
        //   315: goto            265
        //   318: astore_0       
        //   319: aconst_null    
        //   320: astore_1       
        //   321: ldc             "FirebaseAbtUtil"
        //   323: ldc             "Could not complete the operation due to an internal error."
        //   325: aload_0        
        //   326: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
        //   329: pop            
        //   330: aload_1        
        //   331: areturn        
        //   332: astore_0       
        //   333: aload_3        
        //   334: astore_1       
        //   335: goto            321
        //   338: astore_0       
        //   339: aconst_null    
        //   340: astore_1       
        //   341: goto            321
        //   344: astore_0       
        //   345: aload_3        
        //   346: astore_1       
        //   347: goto            321
        //   350: astore_0       
        //   351: aconst_null    
        //   352: astore_1       
        //   353: goto            321
        //   356: astore_0       
        //   357: aload_3        
        //   358: astore_1       
        //   359: goto            321
        //   362: astore_0       
        //   363: aconst_null    
        //   364: astore_1       
        //   365: goto            321
        //   368: astore_0       
        //   369: aload_3        
        //   370: astore_1       
        //   371: goto            321
        //   374: astore_0       
        //   375: aconst_null    
        //   376: astore_1       
        //   377: goto            321
        //   380: astore_0       
        //   381: aload_3        
        //   382: astore_1       
        //   383: goto            321
        //   386: astore_0       
        //   387: aconst_null    
        //   388: astore_1       
        //   389: goto            321
        //   392: astore_0       
        //   393: aload_3        
        //   394: astore_1       
        //   395: goto            321
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                         
        //  -----  -----  -----  -----  ---------------------------------------------
        //  3      33     318    321    Ljava/lang/ClassNotFoundException;
        //  3      33     374    380    Ljava/lang/NoSuchMethodException;
        //  3      33     362    368    Ljava/lang/IllegalAccessException;
        //  3      33     386    392    Ljava/lang/reflect/InvocationTargetException;
        //  3      33     350    356    Ljava/lang/NoSuchFieldException;
        //  3      33     338    344    Ljava/lang/InstantiationException;
        //  33     103    332    338    Ljava/lang/ClassNotFoundException;
        //  33     103    380    386    Ljava/lang/NoSuchMethodException;
        //  33     103    368    374    Ljava/lang/IllegalAccessException;
        //  33     103    392    398    Ljava/lang/reflect/InvocationTargetException;
        //  33     103    356    362    Ljava/lang/NoSuchFieldException;
        //  33     103    344    350    Ljava/lang/InstantiationException;
        //  106    142    332    338    Ljava/lang/ClassNotFoundException;
        //  106    142    380    386    Ljava/lang/NoSuchMethodException;
        //  106    142    368    374    Ljava/lang/IllegalAccessException;
        //  106    142    392    398    Ljava/lang/reflect/InvocationTargetException;
        //  106    142    356    362    Ljava/lang/NoSuchFieldException;
        //  106    142    344    350    Ljava/lang/InstantiationException;
        //  142    204    332    338    Ljava/lang/ClassNotFoundException;
        //  142    204    380    386    Ljava/lang/NoSuchMethodException;
        //  142    204    368    374    Ljava/lang/IllegalAccessException;
        //  142    204    392    398    Ljava/lang/reflect/InvocationTargetException;
        //  142    204    356    362    Ljava/lang/NoSuchFieldException;
        //  142    204    344    350    Ljava/lang/InstantiationException;
        //  204    265    332    338    Ljava/lang/ClassNotFoundException;
        //  204    265    380    386    Ljava/lang/NoSuchMethodException;
        //  204    265    368    374    Ljava/lang/IllegalAccessException;
        //  204    265    392    398    Ljava/lang/reflect/InvocationTargetException;
        //  204    265    356    362    Ljava/lang/NoSuchFieldException;
        //  204    265    344    350    Ljava/lang/InstantiationException;
        //  265    284    332    338    Ljava/lang/ClassNotFoundException;
        //  265    284    380    386    Ljava/lang/NoSuchMethodException;
        //  265    284    368    374    Ljava/lang/IllegalAccessException;
        //  265    284    392    398    Ljava/lang/reflect/InvocationTargetException;
        //  265    284    356    362    Ljava/lang/NoSuchFieldException;
        //  265    284    344    350    Ljava/lang/InstantiationException;
        //  286    291    332    338    Ljava/lang/ClassNotFoundException;
        //  286    291    380    386    Ljava/lang/NoSuchMethodException;
        //  286    291    368    374    Ljava/lang/IllegalAccessException;
        //  286    291    392    398    Ljava/lang/reflect/InvocationTargetException;
        //  286    291    356    362    Ljava/lang/NoSuchFieldException;
        //  286    291    344    350    Ljava/lang/InstantiationException;
        //  294    299    332    338    Ljava/lang/ClassNotFoundException;
        //  294    299    380    386    Ljava/lang/NoSuchMethodException;
        //  294    299    368    374    Ljava/lang/IllegalAccessException;
        //  294    299    392    398    Ljava/lang/reflect/InvocationTargetException;
        //  294    299    356    362    Ljava/lang/NoSuchFieldException;
        //  294    299    344    350    Ljava/lang/InstantiationException;
        //  302    307    332    338    Ljava/lang/ClassNotFoundException;
        //  302    307    380    386    Ljava/lang/NoSuchMethodException;
        //  302    307    368    374    Ljava/lang/IllegalAccessException;
        //  302    307    392    398    Ljava/lang/reflect/InvocationTargetException;
        //  302    307    356    362    Ljava/lang/NoSuchFieldException;
        //  302    307    344    350    Ljava/lang/InstantiationException;
        //  310    315    332    338    Ljava/lang/ClassNotFoundException;
        //  310    315    380    386    Ljava/lang/NoSuchMethodException;
        //  310    315    368    374    Ljava/lang/IllegalAccessException;
        //  310    315    392    398    Ljava/lang/reflect/InvocationTargetException;
        //  310    315    356    362    Ljava/lang/NoSuchFieldException;
        //  310    315    344    350    Ljava/lang/InstantiationException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0106:
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
    
    private static String zza(@Nullable final aen aen, @NonNull final zzb zzb) {
        if (aen != null && !TextUtils.isEmpty((CharSequence)aen.zzcuu)) {
            return aen.zzcuu;
        }
        return zzb.zzEy();
    }
    
    private static List<Object> zza(@NonNull AppMeasurement obj, @NonNull final String s) {
        final ArrayList list = new ArrayList();
        try {
            final Method declaredMethod = AppMeasurement.class.getDeclaredMethod("getConditionalUserProperties", String.class, String.class);
            declaredMethod.setAccessible(true);
            obj = (NoSuchMethodException)declaredMethod.invoke(obj, s, "");
            if (Log.isLoggable("FirebaseAbtUtil", 2)) {
                Log.v("FirebaseAbtUtil", new StringBuilder(String.valueOf(s).length() + 55).append("Number of currently set _Es for origin: ").append(s).append(" is ").append(((List)obj).size()).toString());
            }
            return (List<Object>)obj;
        }
        catch (IllegalAccessException ex) {}
        catch (NoSuchMethodException obj) {
            goto Label_0123;
        }
        catch (InvocationTargetException obj) {
            goto Label_0123;
        }
    }
    
    private static void zza(@NonNull Context zzaQ, @NonNull String s, @NonNull final String s2, @NonNull final String s3, @NonNull final String s4) {
        if (Log.isLoggable("FirebaseAbtUtil", 2)) {
            s = String.valueOf(s);
            if (s.length() != 0) {
                s = "_CE(experimentId) called by ".concat(s);
            }
            else {
                s = new String("_CE(experimentId) called by ");
            }
            Log.v("FirebaseAbtUtil", s);
        }
        if (!zzbD((Context)zzaQ)) {
            return;
        }
        zzaQ = (IllegalAccessException)zzaQ((Context)zzaQ);
        try {
            final Method declaredMethod = AppMeasurement.class.getDeclaredMethod("clearConditionalUserProperty", String.class, String.class, Bundle.class);
            declaredMethod.setAccessible(true);
            if (Log.isLoggable("FirebaseAbtUtil", 2)) {
                Log.v("FirebaseAbtUtil", new StringBuilder(String.valueOf(s2).length() + 17 + String.valueOf(s3).length()).append("Clearing _E: [").append(s2).append(", ").append(s3).append("]").toString());
            }
            declaredMethod.invoke(zzaQ, s2, s4, zzX(s2, s3));
        }
        catch (NoSuchMethodException ex) {}
        catch (IllegalAccessException zzaQ) {
            goto Label_0192;
        }
        catch (InvocationTargetException zzaQ) {
            goto Label_0192;
        }
    }
    
    public static void zza(@NonNull final Context ex, @NonNull final String obj, @NonNull final byte[] array, @NonNull final zzb zzb, int n) {
        if (Log.isLoggable("FirebaseAbtUtil", 2)) {
            final String value = String.valueOf(obj);
            String concat;
            if (value.length() != 0) {
                concat = "_SE called by ".concat(value);
            }
            else {
                concat = new String("_SE called by ");
            }
            Log.v("FirebaseAbtUtil", concat);
        }
        if (zzbD((Context)ex)) {
            final AppMeasurement zzaQ = zzaQ((Context)ex);
            final aen zzA = zzA(array);
            if (zzA == null) {
                if (Log.isLoggable("FirebaseAbtUtil", 2)) {
                    Log.v("FirebaseAbtUtil", "_SE failed; either _P was not set, or we couldn't deserialize the _P.");
                }
            }
            else {
                try {
                    Class.forName("com.google.android.gms.measurement.AppMeasurement$ConditionalUserProperty");
                    final Iterator<Object> iterator = zza(zzaQ, obj).iterator();
                    n = 0;
                    String zzS = null;
                    String zzT = null;
                    aem[] zzcuy = null;
                    int n3 = 0;
                    Block_10: {
                        Block_8: {
                            while (iterator.hasNext()) {
                                final Object next = iterator.next();
                                zzS = zzS(next);
                                zzT = zzT(next);
                                final long longValue = (long)Class.forName("com.google.android.gms.measurement.AppMeasurement$ConditionalUserProperty").getField("mCreationTimestamp").get(next);
                                if (zzA.zzcun.equals(zzS) && zzA.zzcuo.equals(zzT)) {
                                    break Block_8;
                                }
                                final int n2 = 0;
                                zzcuy = zzA.zzcuy;
                                final int length = zzcuy.length;
                                n3 = 0;
                                final int n4 = n2;
                                if (n3 < length) {
                                    break Block_10;
                                }
                                if (n4 != 0) {
                                    continue;
                                }
                                if (zzA.zzcup <= longValue) {
                                    goto Label_0521;
                                }
                                if (Log.isLoggable("FirebaseAbtUtil", 2)) {
                                    Log.v("FirebaseAbtUtil", new StringBuilder(String.valueOf(zzS).length() + 115 + String.valueOf(zzT).length()).append("Clearing _E as it was not in the _OE list, andits start time is older than the start time of the _E to be set. [").append(zzS).append(", ").append(zzT).append("]").toString());
                                }
                                zza((Context)ex, obj, zzS, zzT, zza(zzA, zzb));
                            }
                            goto Label_0597;
                        }
                        if (Log.isLoggable("FirebaseAbtUtil", 2)) {
                            Log.v("FirebaseAbtUtil", new StringBuilder(String.valueOf(zzS).length() + 23 + String.valueOf(zzT).length()).append("_E is already set. [").append(zzS).append(", ").append(zzT).append("]").toString());
                            goto Label_0699;
                        }
                        goto Label_0699;
                    }
                    if (zzcuy[n3].zzcun.equals(zzS) && Log.isLoggable("FirebaseAbtUtil", 2)) {
                        Log.v("FirebaseAbtUtil", new StringBuilder(String.valueOf(zzS).length() + 33 + String.valueOf(zzT).length()).append("_E is found in the _OE list. [").append(zzS).append(", ").append(zzT).append("]").toString());
                        goto Label_0705;
                    }
                    goto Label_0512;
                }
                catch (ClassNotFoundException ex2) {}
                catch (IllegalAccessException ex) {
                    goto Label_0502;
                }
                catch (NoSuchFieldException ex) {
                    goto Label_0502;
                }
            }
        }
    }
    
    private static void zza(@NonNull final AppMeasurement obj, @NonNull final Context context, @NonNull final String s, @NonNull final aen aen, @NonNull final zzb zzb, int n) {
        Label_0085: {
            if (!Log.isLoggable("FirebaseAbtUtil", 2)) {
                break Label_0085;
            }
            final String value = String.valueOf(aen.zzcun);
            final String value2 = String.valueOf(aen.zzcuo);
            Log.v("FirebaseAbtUtil", new StringBuilder(String.valueOf(value).length() + 7 + String.valueOf(value2).length()).append("_SEI: ").append(value).append(" ").append(value2).toString());
            try {
                try {
                    Class.forName("com.google.android.gms.measurement.AppMeasurement$ConditionalUserProperty");
                    final List<Object> zza = zza((AppMeasurement)obj, s);
                    n = zzb((AppMeasurement)obj, s);
                    if (zza((AppMeasurement)obj, s).size() >= n) {
                        if (aen.zzcux == 0) {
                            goto Label_0399;
                        }
                        n = aen.zzcux;
                        if (n != 1) {
                            goto Label_0405;
                        }
                        final Object value3 = zza.get(0);
                        final String zzS = zzS(value3);
                        final String zzT = zzT(value3);
                        if (Log.isLoggable("FirebaseAbtUtil", 2)) {
                            Log.v("FirebaseAbtUtil", new StringBuilder(String.valueOf(zzS).length() + 38).append("Clearing _E due to overflow policy: [").append(zzS).append("]").toString());
                        }
                        zza(context, s, zzS, zzT, zza(aen, zzb));
                    }
                    for (final Object next : zza) {
                        final String zzS2 = zzS(next);
                        final String zzT2 = zzT(next);
                        if (zzS2.equals(aen.zzcun) && !zzT2.equals(aen.zzcuo) && Log.isLoggable("FirebaseAbtUtil", 2)) {
                            Log.v("FirebaseAbtUtil", new StringBuilder(String.valueOf(zzS2).length() + 77 + String.valueOf(zzT2).length()).append("Clearing _E, as only one _V of the same _E can be set atany given time: [").append(zzS2).append(", ").append(zzT2).append("].").toString());
                            zza(context, s, zzS2, zzT2, zza(aen, zzb));
                        }
                    }
                    goto Label_0491;
                }
                catch (ClassNotFoundException ex) {}
                catch (IllegalAccessException obj) {
                    goto Label_0389;
                }
                try {
                    final Method declaredMethod = AppMeasurement.class.getDeclaredMethod("setConditionalUserProperty", Class.forName("com.google.android.gms.measurement.AppMeasurement$ConditionalUserProperty"));
                    declaredMethod.setAccessible(true);
                    if (!TextUtils.isEmpty((CharSequence)aen.zzcus)) {
                        ((AppMeasurement)obj).logEventInternal(s, aen.zzcus, zza(aen));
                        final Object o;
                        declaredMethod.invoke(obj, o);
                        return;
                    }
                    goto Label_0789;
                }
                catch (ClassNotFoundException ex2) {}
                catch (IllegalAccessException ex3) {}
                catch (NoSuchMethodException ex4) {}
                catch (InvocationTargetException ex5) {}
            }
            catch (NoSuchFieldException obj) {
                goto Label_0389;
            }
        }
    }
    
    @Nullable
    private static AppMeasurement zzaQ(final Context context) {
        try {
            return AppMeasurement.getInstance(context);
        }
        catch (NoClassDefFoundError noClassDefFoundError) {
            return null;
        }
    }
    
    private static int zzb(@NonNull final AppMeasurement obj, @NonNull final String s) {
        try {
            final Method declaredMethod = AppMeasurement.class.getDeclaredMethod("getMaxUserProperties", String.class);
            declaredMethod.setAccessible(true);
            return (int)declaredMethod.invoke(obj, s);
        }
        catch (IllegalAccessException ex) {}
        catch (NoSuchMethodException obj) {
            goto Label_0046;
        }
        catch (InvocationTargetException obj) {
            goto Label_0046;
        }
    }
    
    private static boolean zzbD(final Context context) {
        if (zzaQ(context) == null) {
            if (Log.isLoggable("FirebaseAbtUtil", 2)) {
                Log.v("FirebaseAbtUtil", "Firebase Analytics not available");
            }
        }
        else {
            try {
                Class.forName("com.google.android.gms.measurement.AppMeasurement$ConditionalUserProperty");
                return true;
            }
            catch (ClassNotFoundException ex) {
                if (Log.isLoggable("FirebaseAbtUtil", 2)) {
                    Log.v("FirebaseAbtUtil", "Firebase Analytics library is missing support for abt. Please update to a more recent version.");
                    return false;
                }
            }
        }
        return false;
    }
}
