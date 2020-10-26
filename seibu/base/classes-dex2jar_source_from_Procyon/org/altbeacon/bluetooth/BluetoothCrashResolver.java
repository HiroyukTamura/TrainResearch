// 
// Decompiled by Procyon v0.5.36
// 

package org.altbeacon.bluetooth;

import android.content.IntentFilter;
import android.bluetooth.BluetoothAdapter$LeScanCallback;
import android.bluetooth.BluetoothDevice;
import android.os.Build$VERSION;
import android.annotation.TargetApi;
import android.os.SystemClock;
import android.bluetooth.BluetoothAdapter;
import org.altbeacon.beacon.logging.LogManager;
import java.util.HashSet;
import android.content.BroadcastReceiver;
import java.util.Set;
import android.content.Context;

public class BluetoothCrashResolver
{
    private static final int BLUEDROID_MAX_BLUETOOTH_MAC_COUNT = 1990;
    private static final int BLUEDROID_POST_DISCOVERY_ESTIMATED_BLUETOOTH_MAC_COUNT = 400;
    private static final String DISTINCT_BLUETOOTH_ADDRESSES_FILE = "BluetoothCrashResolverState.txt";
    private static final long MIN_TIME_BETWEEN_STATE_SAVES_MILLIS = 60000L;
    private static final boolean PREEMPTIVE_ACTION_ENABLED = true;
    private static final long SUSPICIOUSLY_SHORT_BLUETOOTH_OFF_INTERVAL_MILLIS = 600L;
    private static final String TAG = "BluetoothCrashResolver";
    private static final int TIME_TO_LET_DISCOVERY_RUN_MILLIS = 5000;
    private Context context;
    private int detectedCrashCount;
    private boolean discoveryStartConfirmed;
    private final Set<String> distinctBluetoothAddresses;
    private long lastBluetoothCrashDetectionTime;
    private long lastBluetoothOffTime;
    private long lastBluetoothTurningOnTime;
    private boolean lastRecoverySucceeded;
    private long lastStateSaveTime;
    private final BroadcastReceiver receiver;
    private int recoveryAttemptCount;
    private boolean recoveryInProgress;
    private BluetoothCrashResolver.BluetoothCrashResolver$UpdateNotifier updateNotifier;
    
    public BluetoothCrashResolver(final Context context) {
        this.recoveryInProgress = false;
        this.discoveryStartConfirmed = false;
        this.lastBluetoothOffTime = 0L;
        this.lastBluetoothTurningOnTime = 0L;
        this.lastBluetoothCrashDetectionTime = 0L;
        this.detectedCrashCount = 0;
        this.recoveryAttemptCount = 0;
        this.lastRecoverySucceeded = false;
        this.lastStateSaveTime = 0L;
        this.context = null;
        this.distinctBluetoothAddresses = new HashSet<String>();
        this.receiver = (BroadcastReceiver)new BluetoothCrashResolver$1(this);
        this.context = context.getApplicationContext();
        LogManager.d("BluetoothCrashResolver", "constructed", new Object[0]);
        this.loadState();
    }
    
    private void cancelDiscovery() {
        try {
            Thread.sleep(5000L);
            if (!this.discoveryStartConfirmed) {
                LogManager.w("BluetoothCrashResolver", "BluetoothAdapter.ACTION_DISCOVERY_STARTED never received.  Recovery may fail.", new Object[0]);
            }
            final BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            if (defaultAdapter.isDiscovering()) {
                LogManager.d("BluetoothCrashResolver", "Cancelling discovery", new Object[0]);
                defaultAdapter.cancelDiscovery();
                return;
            }
            LogManager.d("BluetoothCrashResolver", "Discovery not running.  Won't cancel it", new Object[0]);
        }
        catch (InterruptedException ex) {
            LogManager.d("BluetoothCrashResolver", "DiscoveryCanceller sleep interrupted.", new Object[0]);
        }
    }
    
    private void finishRecovery() {
        LogManager.w("BluetoothCrashResolver", "Recovery attempt finished", new Object[0]);
        synchronized (this.distinctBluetoothAddresses) {
            this.distinctBluetoothAddresses.clear();
            // monitorexit(this.distinctBluetoothAddresses)
            this.recoveryInProgress = false;
        }
    }
    
    private int getCrashRiskDeviceCount() {
        return 1590;
    }
    
    private void loadState() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: astore          4
        //     3: aconst_null    
        //     4: astore_1       
        //     5: aconst_null    
        //     6: astore_3       
        //     7: new             Ljava/io/BufferedReader;
        //    10: dup            
        //    11: new             Ljava/io/InputStreamReader;
        //    14: dup            
        //    15: aload_0        
        //    16: getfield        org/altbeacon/bluetooth/BluetoothCrashResolver.context:Landroid/content/Context;
        //    19: ldc             "BluetoothCrashResolverState.txt"
        //    21: invokevirtual   android/content/Context.openFileInput:(Ljava/lang/String;)Ljava/io/FileInputStream;
        //    24: invokespecial   java/io/InputStreamReader.<init>:(Ljava/io/InputStream;)V
        //    27: invokespecial   java/io/BufferedReader.<init>:(Ljava/io/Reader;)V
        //    30: astore_2       
        //    31: aload_2        
        //    32: invokevirtual   java/io/BufferedReader.readLine:()Ljava/lang/String;
        //    35: astore_1       
        //    36: aload_1        
        //    37: ifnull          48
        //    40: aload_0        
        //    41: aload_1        
        //    42: invokestatic    java/lang/Long.parseLong:(Ljava/lang/String;)J
        //    45: putfield        org/altbeacon/bluetooth/BluetoothCrashResolver.lastBluetoothCrashDetectionTime:J
        //    48: aload_2        
        //    49: invokevirtual   java/io/BufferedReader.readLine:()Ljava/lang/String;
        //    52: astore_1       
        //    53: aload_1        
        //    54: ifnull          65
        //    57: aload_0        
        //    58: aload_1        
        //    59: invokestatic    java/lang/Integer.parseInt:(Ljava/lang/String;)I
        //    62: putfield        org/altbeacon/bluetooth/BluetoothCrashResolver.detectedCrashCount:I
        //    65: aload_2        
        //    66: invokevirtual   java/io/BufferedReader.readLine:()Ljava/lang/String;
        //    69: astore_1       
        //    70: aload_1        
        //    71: ifnull          82
        //    74: aload_0        
        //    75: aload_1        
        //    76: invokestatic    java/lang/Integer.parseInt:(Ljava/lang/String;)I
        //    79: putfield        org/altbeacon/bluetooth/BluetoothCrashResolver.recoveryAttemptCount:I
        //    82: aload_2        
        //    83: invokevirtual   java/io/BufferedReader.readLine:()Ljava/lang/String;
        //    86: astore_1       
        //    87: aload_1        
        //    88: ifnull          110
        //    91: aload_0        
        //    92: iconst_0       
        //    93: putfield        org/altbeacon/bluetooth/BluetoothCrashResolver.lastRecoverySucceeded:Z
        //    96: aload_1        
        //    97: ldc             "1"
        //    99: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   102: ifeq            110
        //   105: aload_0        
        //   106: iconst_1       
        //   107: putfield        org/altbeacon/bluetooth/BluetoothCrashResolver.lastRecoverySucceeded:Z
        //   110: aload_2        
        //   111: invokevirtual   java/io/BufferedReader.readLine:()Ljava/lang/String;
        //   114: astore_1       
        //   115: aload_1        
        //   116: ifnull          187
        //   119: aload_0        
        //   120: getfield        org/altbeacon/bluetooth/BluetoothCrashResolver.distinctBluetoothAddresses:Ljava/util/Set;
        //   123: aload_1        
        //   124: invokeinterface java/util/Set.add:(Ljava/lang/Object;)Z
        //   129: pop            
        //   130: goto            110
        //   133: astore_1       
        //   134: aload_2        
        //   135: astore_1       
        //   136: ldc             "BluetoothCrashResolver"
        //   138: ldc             "Can't read macs from %s"
        //   140: iconst_1       
        //   141: anewarray       Ljava/lang/Object;
        //   144: dup            
        //   145: iconst_0       
        //   146: ldc             "BluetoothCrashResolverState.txt"
        //   148: aastore        
        //   149: invokestatic    org/altbeacon/beacon/logging/LogManager.w:(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   152: aload_2        
        //   153: ifnull          160
        //   156: aload_2        
        //   157: invokevirtual   java/io/BufferedReader.close:()V
        //   160: ldc             "BluetoothCrashResolver"
        //   162: ldc             "Read %s Bluetooth addresses"
        //   164: iconst_1       
        //   165: anewarray       Ljava/lang/Object;
        //   168: dup            
        //   169: iconst_0       
        //   170: aload_0        
        //   171: getfield        org/altbeacon/bluetooth/BluetoothCrashResolver.distinctBluetoothAddresses:Ljava/util/Set;
        //   174: invokeinterface java/util/Set.size:()I
        //   179: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   182: aastore        
        //   183: invokestatic    org/altbeacon/beacon/logging/LogManager.d:(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   186: return         
        //   187: aload_2        
        //   188: ifnull          276
        //   191: aload_2        
        //   192: invokevirtual   java/io/BufferedReader.close:()V
        //   195: goto            160
        //   198: astore_1       
        //   199: goto            160
        //   202: astore_1       
        //   203: aload           4
        //   205: astore_2       
        //   206: aload_2        
        //   207: astore_1       
        //   208: ldc             "BluetoothCrashResolver"
        //   210: ldc             "Can't parse file %s"
        //   212: iconst_1       
        //   213: anewarray       Ljava/lang/Object;
        //   216: dup            
        //   217: iconst_0       
        //   218: ldc             "BluetoothCrashResolverState.txt"
        //   220: aastore        
        //   221: invokestatic    org/altbeacon/beacon/logging/LogManager.w:(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   224: aload_2        
        //   225: ifnull          160
        //   228: aload_2        
        //   229: invokevirtual   java/io/BufferedReader.close:()V
        //   232: goto            160
        //   235: astore_1       
        //   236: goto            160
        //   239: astore_2       
        //   240: aload_1        
        //   241: ifnull          248
        //   244: aload_1        
        //   245: invokevirtual   java/io/BufferedReader.close:()V
        //   248: aload_2        
        //   249: athrow         
        //   250: astore_1       
        //   251: goto            160
        //   254: astore_1       
        //   255: goto            248
        //   258: astore_3       
        //   259: aload_2        
        //   260: astore_1       
        //   261: aload_3        
        //   262: astore_2       
        //   263: goto            240
        //   266: astore_1       
        //   267: goto            206
        //   270: astore_1       
        //   271: aload_3        
        //   272: astore_2       
        //   273: goto            134
        //   276: goto            160
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                             
        //  -----  -----  -----  -----  ---------------------------------
        //  7      31     270    276    Ljava/io/IOException;
        //  7      31     202    206    Ljava/lang/NumberFormatException;
        //  7      31     239    240    Any
        //  31     36     133    134    Ljava/io/IOException;
        //  31     36     266    270    Ljava/lang/NumberFormatException;
        //  31     36     258    266    Any
        //  40     48     133    134    Ljava/io/IOException;
        //  40     48     266    270    Ljava/lang/NumberFormatException;
        //  40     48     258    266    Any
        //  48     53     133    134    Ljava/io/IOException;
        //  48     53     266    270    Ljava/lang/NumberFormatException;
        //  48     53     258    266    Any
        //  57     65     133    134    Ljava/io/IOException;
        //  57     65     266    270    Ljava/lang/NumberFormatException;
        //  57     65     258    266    Any
        //  65     70     133    134    Ljava/io/IOException;
        //  65     70     266    270    Ljava/lang/NumberFormatException;
        //  65     70     258    266    Any
        //  74     82     133    134    Ljava/io/IOException;
        //  74     82     266    270    Ljava/lang/NumberFormatException;
        //  74     82     258    266    Any
        //  82     87     133    134    Ljava/io/IOException;
        //  82     87     266    270    Ljava/lang/NumberFormatException;
        //  82     87     258    266    Any
        //  91     110    133    134    Ljava/io/IOException;
        //  91     110    266    270    Ljava/lang/NumberFormatException;
        //  91     110    258    266    Any
        //  110    115    133    134    Ljava/io/IOException;
        //  110    115    266    270    Ljava/lang/NumberFormatException;
        //  110    115    258    266    Any
        //  119    130    133    134    Ljava/io/IOException;
        //  119    130    266    270    Ljava/lang/NumberFormatException;
        //  119    130    258    266    Any
        //  136    152    239    240    Any
        //  156    160    250    254    Ljava/io/IOException;
        //  191    195    198    202    Ljava/io/IOException;
        //  208    224    239    240    Any
        //  228    232    235    239    Ljava/io/IOException;
        //  244    248    254    258    Ljava/io/IOException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 151 out of bounds for length 151
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
    
    private void processStateChange() {
        if (this.updateNotifier != null) {
            this.updateNotifier.dataUpdated();
        }
        if (SystemClock.elapsedRealtime() - this.lastStateSaveTime > 60000L) {
            this.saveState();
        }
    }
    
    private void saveState() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: astore_1       
        //     2: aconst_null    
        //     3: astore_3       
        //     4: aload_0        
        //     5: invokestatic    android/os/SystemClock.elapsedRealtime:()J
        //     8: putfield        org/altbeacon/bluetooth/BluetoothCrashResolver.lastStateSaveTime:J
        //    11: new             Ljava/io/OutputStreamWriter;
        //    14: dup            
        //    15: aload_0        
        //    16: getfield        org/altbeacon/bluetooth/BluetoothCrashResolver.context:Landroid/content/Context;
        //    19: ldc             "BluetoothCrashResolverState.txt"
        //    21: iconst_0       
        //    22: invokevirtual   android/content/Context.openFileOutput:(Ljava/lang/String;I)Ljava/io/FileOutputStream;
        //    25: invokespecial   java/io/OutputStreamWriter.<init>:(Ljava/io/OutputStream;)V
        //    28: astore_2       
        //    29: aload_2        
        //    30: new             Ljava/lang/StringBuilder;
        //    33: dup            
        //    34: invokespecial   java/lang/StringBuilder.<init>:()V
        //    37: aload_0        
        //    38: getfield        org/altbeacon/bluetooth/BluetoothCrashResolver.lastBluetoothCrashDetectionTime:J
        //    41: invokevirtual   java/lang/StringBuilder.append:(J)Ljava/lang/StringBuilder;
        //    44: ldc             "\n"
        //    46: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    49: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //    52: invokevirtual   java/io/OutputStreamWriter.write:(Ljava/lang/String;)V
        //    55: aload_2        
        //    56: new             Ljava/lang/StringBuilder;
        //    59: dup            
        //    60: invokespecial   java/lang/StringBuilder.<init>:()V
        //    63: aload_0        
        //    64: getfield        org/altbeacon/bluetooth/BluetoothCrashResolver.detectedCrashCount:I
        //    67: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //    70: ldc             "\n"
        //    72: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    75: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //    78: invokevirtual   java/io/OutputStreamWriter.write:(Ljava/lang/String;)V
        //    81: aload_2        
        //    82: new             Ljava/lang/StringBuilder;
        //    85: dup            
        //    86: invokespecial   java/lang/StringBuilder.<init>:()V
        //    89: aload_0        
        //    90: getfield        org/altbeacon/bluetooth/BluetoothCrashResolver.recoveryAttemptCount:I
        //    93: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //    96: ldc             "\n"
        //    98: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   101: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   104: invokevirtual   java/io/OutputStreamWriter.write:(Ljava/lang/String;)V
        //   107: aload_0        
        //   108: getfield        org/altbeacon/bluetooth/BluetoothCrashResolver.lastRecoverySucceeded:Z
        //   111: ifeq            232
        //   114: ldc_w           "1\n"
        //   117: astore_1       
        //   118: aload_2        
        //   119: aload_1        
        //   120: invokevirtual   java/io/OutputStreamWriter.write:(Ljava/lang/String;)V
        //   123: aload_0        
        //   124: getfield        org/altbeacon/bluetooth/BluetoothCrashResolver.distinctBluetoothAddresses:Ljava/util/Set;
        //   127: astore_1       
        //   128: aload_1        
        //   129: monitorenter   
        //   130: aload_0        
        //   131: getfield        org/altbeacon/bluetooth/BluetoothCrashResolver.distinctBluetoothAddresses:Ljava/util/Set;
        //   134: invokeinterface java/util/Set.iterator:()Ljava/util/Iterator;
        //   139: astore_3       
        //   140: aload_3        
        //   141: invokeinterface java/util/Iterator.hasNext:()Z
        //   146: ifeq            239
        //   149: aload_2        
        //   150: aload_3        
        //   151: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   156: checkcast       Ljava/lang/String;
        //   159: invokevirtual   java/io/OutputStreamWriter.write:(Ljava/lang/String;)V
        //   162: aload_2        
        //   163: ldc             "\n"
        //   165: invokevirtual   java/io/OutputStreamWriter.write:(Ljava/lang/String;)V
        //   168: goto            140
        //   171: astore_3       
        //   172: aload_1        
        //   173: monitorexit    
        //   174: aload_3        
        //   175: athrow         
        //   176: astore_1       
        //   177: aload_2        
        //   178: astore_1       
        //   179: ldc             "BluetoothCrashResolver"
        //   181: ldc_w           "Can't write macs to %s"
        //   184: iconst_1       
        //   185: anewarray       Ljava/lang/Object;
        //   188: dup            
        //   189: iconst_0       
        //   190: ldc             "BluetoothCrashResolverState.txt"
        //   192: aastore        
        //   193: invokestatic    org/altbeacon/beacon/logging/LogManager.w:(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   196: aload_2        
        //   197: ifnull          204
        //   200: aload_2        
        //   201: invokevirtual   java/io/OutputStreamWriter.close:()V
        //   204: ldc             "BluetoothCrashResolver"
        //   206: ldc_w           "Wrote %s Bluetooth addresses"
        //   209: iconst_1       
        //   210: anewarray       Ljava/lang/Object;
        //   213: dup            
        //   214: iconst_0       
        //   215: aload_0        
        //   216: getfield        org/altbeacon/bluetooth/BluetoothCrashResolver.distinctBluetoothAddresses:Ljava/util/Set;
        //   219: invokeinterface java/util/Set.size:()I
        //   224: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   227: aastore        
        //   228: invokestatic    org/altbeacon/beacon/logging/LogManager.d:(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   231: return         
        //   232: ldc_w           "0\n"
        //   235: astore_1       
        //   236: goto            118
        //   239: aload_1        
        //   240: monitorexit    
        //   241: aload_2        
        //   242: ifnull          289
        //   245: aload_2        
        //   246: invokevirtual   java/io/OutputStreamWriter.close:()V
        //   249: goto            204
        //   252: astore_1       
        //   253: goto            204
        //   256: astore_2       
        //   257: aload_1        
        //   258: ifnull          265
        //   261: aload_1        
        //   262: invokevirtual   java/io/OutputStreamWriter.close:()V
        //   265: aload_2        
        //   266: athrow         
        //   267: astore_1       
        //   268: goto            204
        //   271: astore_1       
        //   272: goto            265
        //   275: astore_3       
        //   276: aload_2        
        //   277: astore_1       
        //   278: aload_3        
        //   279: astore_2       
        //   280: goto            257
        //   283: astore_1       
        //   284: aload_3        
        //   285: astore_2       
        //   286: goto            177
        //   289: goto            204
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  11     29     283    289    Ljava/io/IOException;
        //  11     29     256    257    Any
        //  29     114    176    177    Ljava/io/IOException;
        //  29     114    275    283    Any
        //  118    130    176    177    Ljava/io/IOException;
        //  118    130    275    283    Any
        //  130    140    171    176    Any
        //  140    168    171    176    Any
        //  172    174    171    176    Any
        //  174    176    176    177    Ljava/io/IOException;
        //  174    176    275    283    Any
        //  179    196    256    257    Any
        //  200    204    267    271    Ljava/io/IOException;
        //  239    241    171    176    Any
        //  245    249    252    256    Ljava/io/IOException;
        //  261    265    271    275    Ljava/io/IOException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 146 out of bounds for length 146
        //     at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        //     at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        //     at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
        //     at java.base/java.util.Objects.checkIndex(Objects.java:372)
        //     at java.base/java.util.ArrayList.get(ArrayList.java:458)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3321)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3435)
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
    
    @TargetApi(17)
    private void startRecovery() {
        ++this.recoveryAttemptCount;
        final BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        LogManager.d("BluetoothCrashResolver", "about to check if discovery is active", new Object[0]);
        if (!defaultAdapter.isDiscovering()) {
            LogManager.w("BluetoothCrashResolver", "Recovery attempt started", new Object[0]);
            this.recoveryInProgress = true;
            this.discoveryStartConfirmed = false;
            LogManager.d("BluetoothCrashResolver", "about to command discovery", new Object[0]);
            if (!defaultAdapter.startDiscovery()) {
                LogManager.w("BluetoothCrashResolver", "Can't start discovery.  Is Bluetooth turned on?", new Object[0]);
            }
            LogManager.d("BluetoothCrashResolver", "startDiscovery commanded.  isDiscovering()=%s", new Object[] { defaultAdapter.isDiscovering() });
            LogManager.d("BluetoothCrashResolver", "We will be cancelling this discovery in %s milliseconds.", new Object[] { 5000 });
            this.cancelDiscovery();
            return;
        }
        LogManager.w("BluetoothCrashResolver", "Already discovering.  Recovery attempt abandoned.", new Object[0]);
    }
    
    public void crashDetected() {
        if (Build$VERSION.SDK_INT < 18) {
            LogManager.d("BluetoothCrashResolver", "Ignoring crashes before API 18, because BLE is unsupported.", new Object[0]);
            return;
        }
        LogManager.w("BluetoothCrashResolver", "BluetoothService crash detected", new Object[0]);
        if (this.distinctBluetoothAddresses.size() > 0) {
            LogManager.d("BluetoothCrashResolver", "Distinct Bluetooth devices seen at crash: %s", new Object[] { this.distinctBluetoothAddresses.size() });
        }
        this.lastBluetoothCrashDetectionTime = SystemClock.elapsedRealtime();
        ++this.detectedCrashCount;
        if (this.recoveryInProgress) {
            LogManager.d("BluetoothCrashResolver", "Ignoring Bluetooth crash because recovery is already in progress.", new Object[0]);
        }
        else {
            this.startRecovery();
        }
        this.processStateChange();
    }
    
    @Deprecated
    public void disableDebug() {
    }
    
    @Deprecated
    public void enableDebug() {
    }
    
    public void forceFlush() {
        this.startRecovery();
        this.processStateChange();
    }
    
    public int getDetectedCrashCount() {
        return this.detectedCrashCount;
    }
    
    public long getLastBluetoothCrashDetectionTime() {
        return this.lastBluetoothCrashDetectionTime;
    }
    
    public int getRecoveryAttemptCount() {
        return this.recoveryAttemptCount;
    }
    
    public boolean isLastRecoverySucceeded() {
        return this.lastRecoverySucceeded;
    }
    
    public boolean isRecoveryInProgress() {
        return this.recoveryInProgress;
    }
    
    @TargetApi(18)
    public void notifyScannedDevice(final BluetoothDevice bluetoothDevice, final BluetoothAdapter$LeScanCallback bluetoothAdapter$LeScanCallback) {
        final int size = this.distinctBluetoothAddresses.size();
        synchronized (this.distinctBluetoothAddresses) {
            this.distinctBluetoothAddresses.add(bluetoothDevice.getAddress());
            // monitorexit(this.distinctBluetoothAddresses)
            final int size2 = this.distinctBluetoothAddresses.size();
            if (size != size2 && size2 % 100 == 0) {
                LogManager.d("BluetoothCrashResolver", "Distinct Bluetooth devices seen: %s", new Object[] { this.distinctBluetoothAddresses.size() });
            }
            if (this.distinctBluetoothAddresses.size() > this.getCrashRiskDeviceCount() && !this.recoveryInProgress) {
                LogManager.w("BluetoothCrashResolver", "Large number of Bluetooth devices detected: %s Proactively attempting to clear out address list to prevent a crash", new Object[] { this.distinctBluetoothAddresses.size() });
                LogManager.w("BluetoothCrashResolver", "Stopping LE Scan", new Object[0]);
                BluetoothAdapter.getDefaultAdapter().stopLeScan(bluetoothAdapter$LeScanCallback);
                this.startRecovery();
                this.processStateChange();
            }
        }
    }
    
    public void setUpdateNotifier(final BluetoothCrashResolver.BluetoothCrashResolver$UpdateNotifier updateNotifier) {
        this.updateNotifier = updateNotifier;
    }
    
    public void start() {
        final IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        intentFilter.addAction("android.bluetooth.adapter.action.DISCOVERY_STARTED");
        intentFilter.addAction("android.bluetooth.adapter.action.DISCOVERY_FINISHED");
        this.context.registerReceiver(this.receiver, intentFilter);
        LogManager.d("BluetoothCrashResolver", "started listening for BluetoothAdapter events", new Object[0]);
    }
    
    public void stop() {
        this.context.unregisterReceiver(this.receiver);
        LogManager.d("BluetoothCrashResolver", "stopped listening for BluetoothAdapter events", new Object[0]);
        this.saveState();
    }
}
