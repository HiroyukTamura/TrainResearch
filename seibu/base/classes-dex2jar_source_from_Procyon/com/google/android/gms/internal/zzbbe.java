// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.support.annotation.NonNull;
import com.google.android.gms.common.api.TransformedResult;
import com.google.android.gms.common.api.ResultTransform;
import java.util.concurrent.TimeUnit;
import android.util.Log;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.internal.zzbo;
import android.os.Looper;
import java.util.concurrent.CountDownLatch;
import com.google.android.gms.common.internal.zzao;
import java.util.concurrent.atomic.AtomicReference;
import com.google.android.gms.common.api.ResultCallback;
import java.util.ArrayList;
import com.google.android.gms.common.api.GoogleApiClient;
import java.lang.ref.WeakReference;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;

public abstract class zzbbe<R extends Result> extends PendingResult<R>
{
    static final ThreadLocal<Boolean> zzaBV;
    private Status mStatus;
    private boolean zzJ;
    private final Object zzaBW;
    private zzbbg<R> zzaBX;
    private WeakReference<GoogleApiClient> zzaBY;
    private final ArrayList<zza> zzaBZ;
    private R zzaBj;
    private ResultCallback<? super R> zzaCa;
    private final AtomicReference<zzbex> zzaCb;
    private zzbbh zzaCc;
    private volatile boolean zzaCd;
    private boolean zzaCe;
    private zzao zzaCf;
    private volatile zzbes<R> zzaCg;
    private boolean zzaCh;
    private final CountDownLatch zztJ;
    
    static {
        zzaBV = new zzbbf();
    }
    
    @Deprecated
    zzbbe() {
        this.zzaBW = new Object();
        this.zztJ = new CountDownLatch(1);
        this.zzaBZ = new ArrayList<zza>();
        this.zzaCb = new AtomicReference<zzbex>();
        this.zzaCh = false;
        this.zzaBX = new zzbbg<R>(Looper.getMainLooper());
        this.zzaBY = new WeakReference<GoogleApiClient>(null);
    }
    
    @Deprecated
    protected zzbbe(final Looper looper) {
        this.zzaBW = new Object();
        this.zztJ = new CountDownLatch(1);
        this.zzaBZ = new ArrayList<zza>();
        this.zzaCb = new AtomicReference<zzbex>();
        this.zzaCh = false;
        this.zzaBX = new zzbbg<R>(looper);
        this.zzaBY = new WeakReference<GoogleApiClient>(null);
    }
    
    protected zzbbe(final GoogleApiClient referent) {
        this.zzaBW = new Object();
        this.zztJ = new CountDownLatch(1);
        this.zzaBZ = new ArrayList<zza>();
        this.zzaCb = new AtomicReference<zzbex>();
        this.zzaCh = false;
        Looper looper;
        if (referent != null) {
            looper = referent.getLooper();
        }
        else {
            looper = Looper.getMainLooper();
        }
        this.zzaBX = new zzbbg<R>(looper);
        this.zzaBY = new WeakReference<GoogleApiClient>(referent);
    }
    
    private final R get() {
        boolean b = true;
        Object zzaBW = this.zzaBW;
        synchronized (zzaBW) {
            if (this.zzaCd) {
                b = false;
            }
            zzbo.zza(b, (Object)"Result has already been consumed.");
            zzbo.zza(this.isReady(), (Object)"Result is not ready.");
            final Result zzaBj = this.zzaBj;
            this.zzaBj = null;
            this.zzaCa = null;
            this.zzaCd = true;
            // monitorexit(zzaBW)
            zzaBW = this.zzaCb.getAndSet(null);
            if (zzaBW != null) {
                ((zzbex)zzaBW).zzc(this);
            }
            return (R)zzaBj;
        }
    }
    
    private final void zzb(final R zzaBj) {
        this.zzaBj = zzaBj;
        this.zzaCf = null;
        this.zztJ.countDown();
        this.mStatus = this.zzaBj.getStatus();
        if (this.zzJ) {
            this.zzaCa = null;
        }
        else if (this.zzaCa == null) {
            if (this.zzaBj instanceof Releasable) {
                this.zzaCc = new zzbbh(this, null);
            }
        }
        else {
            this.zzaBX.removeMessages(2);
            this.zzaBX.zza(this.zzaCa, this.get());
        }
        final ArrayList<zza> list = this.zzaBZ;
        final int size = list.size();
        int i = 0;
        while (i < size) {
            final zza value = list.get(i);
            ++i;
            value.zzo(this.mStatus);
        }
        this.zzaBZ.clear();
    }
    
    public static void zzc(final Result obj) {
        if (!(obj instanceof Releasable)) {
            return;
        }
        try {
            ((Releasable)obj).release();
        }
        catch (RuntimeException ex) {
            final String value = String.valueOf(obj);
            Log.w("BasePendingResult", new StringBuilder(String.valueOf(value).length() + 18).append("Unable to release ").append(value).toString(), (Throwable)ex);
        }
    }
    
    @Override
    public final R await() {
        final boolean b = true;
        while (true) {
        Label_0075_Outer:
            while (true) {
                boolean b4 = false;
                Label_0028: {
                    while (true) {
                        boolean b2 = false;
                        Label_0013: {
                            if (Looper.myLooper() != Looper.getMainLooper()) {
                                b2 = true;
                                break Label_0013;
                            }
                            Label_0070: {
                                break Label_0070;
                            Label_0056_Outer:
                                while (true) {
                                    boolean b3 = false;
                                    zzbo.zza(b3, (Object)"Cannot await if then() has been called.");
                                    while (true) {
                                        try {
                                            this.zztJ.await();
                                            zzbo.zza(this.isReady(), (Object)"Result is not ready.");
                                            return this.get();
                                            b3 = false;
                                            continue Label_0056_Outer;
                                            b4 = false;
                                            break Label_0028;
                                            b2 = false;
                                            break;
                                        }
                                        catch (InterruptedException ex) {
                                            this.zzs(Status.zzaBn);
                                            continue Label_0075_Outer;
                                        }
                                        break;
                                    }
                                }
                            }
                        }
                        zzbo.zza(b2, (Object)"await must not be called on the UI thread");
                        if (this.zzaCd) {
                            continue;
                        }
                        break;
                    }
                    b4 = true;
                }
                zzbo.zza(b4, (Object)"Result has already been consumed");
                if (this.zzaCg == null) {
                    final boolean b3 = b;
                    continue Label_0075_Outer;
                }
                break;
            }
            continue;
        }
    }
    
    @Override
    public final R await(final long timeout, final TimeUnit unit) {
        final boolean b = true;
        while (true) {
        Label_0102_Outer:
            while (true) {
                boolean b4 = false;
                Label_0038: {
                    while (true) {
                        boolean b2 = false;
                        Label_0021: {
                            if (timeout <= 0L || Looper.myLooper() != Looper.getMainLooper()) {
                                b2 = true;
                                break Label_0021;
                            }
                            Label_0096: {
                                break Label_0096;
                                while (true) {
                                    boolean b3 = false;
                                    zzbo.zza(b3, (Object)"Cannot await if then() has been called.");
                                    while (true) {
                                        try {
                                            if (!this.zztJ.await(timeout, unit)) {
                                                this.zzs(Status.zzaBp);
                                            }
                                            zzbo.zza(this.isReady(), (Object)"Result is not ready.");
                                            return this.get();
                                            b2 = false;
                                            break;
                                            b4 = false;
                                            break Label_0038;
                                            b3 = false;
                                        }
                                        catch (InterruptedException ex) {
                                            this.zzs(Status.zzaBn);
                                            continue Label_0102_Outer;
                                        }
                                        break;
                                    }
                                }
                            }
                        }
                        zzbo.zza(b2, (Object)"await must not be called on the UI thread when time is greater than zero.");
                        if (this.zzaCd) {
                            continue;
                        }
                        break;
                    }
                    b4 = true;
                }
                zzbo.zza(b4, (Object)"Result has already been consumed.");
                if (this.zzaCg == null) {
                    final boolean b3 = b;
                    continue Label_0102_Outer;
                }
                break;
            }
            continue;
        }
    }
    
    @Override
    public void cancel() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        com/google/android/gms/internal/zzbbe.zzaBW:Ljava/lang/Object;
        //     4: astore_1       
        //     5: aload_1        
        //     6: monitorenter   
        //     7: aload_0        
        //     8: getfield        com/google/android/gms/internal/zzbbe.zzJ:Z
        //    11: ifne            21
        //    14: aload_0        
        //    15: getfield        com/google/android/gms/internal/zzbbe.zzaCd:Z
        //    18: ifeq            24
        //    21: aload_1        
        //    22: monitorexit    
        //    23: return         
        //    24: aload_0        
        //    25: getfield        com/google/android/gms/internal/zzbbe.zzaCf:Lcom/google/android/gms/common/internal/zzao;
        //    28: astore_2       
        //    29: aload_2        
        //    30: ifnull          42
        //    33: aload_0        
        //    34: getfield        com/google/android/gms/internal/zzbbe.zzaCf:Lcom/google/android/gms/common/internal/zzao;
        //    37: invokeinterface com/google/android/gms/common/internal/zzao.cancel:()V
        //    42: aload_0        
        //    43: getfield        com/google/android/gms/internal/zzbbe.zzaBj:Lcom/google/android/gms/common/api/Result;
        //    46: invokestatic    com/google/android/gms/internal/zzbbe.zzc:(Lcom/google/android/gms/common/api/Result;)V
        //    49: aload_0        
        //    50: iconst_1       
        //    51: putfield        com/google/android/gms/internal/zzbbe.zzJ:Z
        //    54: aload_0        
        //    55: aload_0        
        //    56: getstatic       com/google/android/gms/common/api/Status.zzaBq:Lcom/google/android/gms/common/api/Status;
        //    59: invokevirtual   com/google/android/gms/internal/zzbbe.zzb:(Lcom/google/android/gms/common/api/Status;)Lcom/google/android/gms/common/api/Result;
        //    62: invokespecial   com/google/android/gms/internal/zzbbe.zzb:(Lcom/google/android/gms/common/api/Result;)V
        //    65: aload_1        
        //    66: monitorexit    
        //    67: return         
        //    68: astore_2       
        //    69: aload_1        
        //    70: monitorexit    
        //    71: aload_2        
        //    72: athrow         
        //    73: astore_2       
        //    74: goto            42
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                        
        //  -----  -----  -----  -----  ----------------------------
        //  7      21     68     73     Any
        //  21     23     68     73     Any
        //  24     29     68     73     Any
        //  33     42     73     77     Landroid/os/RemoteException;
        //  33     42     68     73     Any
        //  42     67     68     73     Any
        //  69     71     68     73     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0042:
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
    
    @Override
    public boolean isCanceled() {
        synchronized (this.zzaBW) {
            return this.zzJ;
        }
    }
    
    public final boolean isReady() {
        return this.zztJ.getCount() == 0L;
    }
    
    public final void setResult(final R r) {
    Label_0057_Outer:
        while (true) {
            final boolean b = true;
            while (true) {
            Label_0091:
                while (true) {
                    synchronized (this.zzaBW) {
                        if (this.zzaCe || this.zzJ) {
                            zzc(r);
                            return;
                        }
                        if (this.isReady()) {}
                        if (!this.isReady()) {
                            final boolean b2 = true;
                            zzbo.zza(b2, (Object)"Results have already been set");
                            if (!this.zzaCd) {
                                final boolean b3 = b;
                                zzbo.zza(b3, (Object)"Result has already been consumed");
                                this.zzb(r);
                                return;
                            }
                            break Label_0091;
                        }
                    }
                    final boolean b2 = false;
                    continue Label_0057_Outer;
                }
                final boolean b3 = false;
                continue;
            }
        }
    }
    
    @Override
    public final void setResultCallback(final ResultCallback<? super R> resultCallback) {
        final boolean b = true;
        final Object zzaBW = this.zzaBW;
        // monitorenter(zzaBW)
        while (true) {
            if (resultCallback == null) {
            Label_0048_Outer:
                while (true) {
                    boolean b2;
                    boolean b3;
                    Label_0048:Label_0033_Outer:
                    while (true) {
                    Label_0033:
                        while (true) {
                            try {
                                this.zzaCa = null;
                                return;
                                while (true) {
                                    b2 = b;
                                    break Label_0048;
                                    while (true) {
                                        b3 = true;
                                        break Label_0033;
                                        zzbo.zza(b2, (Object)"Cannot set callbacks if then() has been called.");
                                        return;
                                        continue Label_0033_Outer;
                                    }
                                    zzbo.zza(b3, (Object)"Result has already been consumed.");
                                    continue Label_0048_Outer;
                                }
                            }
                            // iftrue(Label_0082:, !this.isCanceled())
                            // iftrue(Label_0072:, this.zzaCd)
                            // iftrue(Label_0077:, this.zzaCg != null)
                            finally {
                            }
                            // monitorexit(zzaBW)
                            Label_0072: {
                                b3 = false;
                            }
                            continue Label_0033;
                        }
                        Label_0077: {
                            b2 = false;
                        }
                        continue Label_0048;
                    }
                }
                Label_0082: {
                    if (this.isReady()) {
                        final ResultCallback<? super R> zzaCa;
                        this.zzaBX.zza(zzaCa, this.get());
                    }
                    else {
                        final ResultCallback<? super R> zzaCa;
                        this.zzaCa = zzaCa;
                    }
                }
                // monitorexit(zzaBW)
                return;
            }
            continue;
        }
    }
    
    @Override
    public final void setResultCallback(final ResultCallback<? super R> resultCallback, long millis, final TimeUnit timeUnit) {
        final boolean b = true;
        final Object zzaBW = this.zzaBW;
        // monitorenter(zzaBW)
        while (true) {
            if (resultCallback == null) {
                while (true) {
                    boolean b2;
                    boolean b3;
                    Block_4_Outer:Label_0035_Outer:
                    while (true) {
                    Label_0035:
                        while (true) {
                            try {
                                this.zzaCa = null;
                                return;
                                zzbo.zza(b2, (Object)"Cannot set callbacks if then() has been called.");
                                // iftrue(Label_0090:, !this.isCanceled())
                                return;
                                // iftrue(Label_0078:, this.zzaCd)
                                while (true) {
                                    b3 = true;
                                    break Label_0035;
                                    continue Label_0035_Outer;
                                }
                                while (true) {
                                    b2 = b;
                                    continue Block_4_Outer;
                                    zzbo.zza(b3, (Object)"Result has already been consumed.");
                                    continue;
                                }
                            }
                            // iftrue(Label_0084:, this.zzaCg != null)
                            finally {
                            }
                            // monitorexit(zzaBW)
                            Label_0078: {
                                b3 = false;
                            }
                            continue Label_0035;
                        }
                        Label_0084: {
                            b2 = false;
                        }
                        continue Label_0035_Outer;
                    }
                }
                Label_0090: {
                    if (this.isReady()) {
                        final ResultCallback<? super R> zzaCa;
                        this.zzaBX.zza(zzaCa, this.get());
                    }
                    else {
                        final ResultCallback<? super R> zzaCa;
                        this.zzaCa = zzaCa;
                        final zzbbg<R> zzaBX = this.zzaBX;
                        millis = timeUnit.toMillis(millis);
                        zzaBX.sendMessageDelayed(zzaBX.obtainMessage(2, (Object)this), millis);
                    }
                }
                // monitorexit(zzaBW)
                return;
            }
            continue;
        }
    }
    
    @Override
    public <S extends Result> TransformedResult<S> then(final ResultTransform<? super R, ? extends S> resultTransform) {
        final boolean b = true;
        while (true) {
            Label_0147: {
                if (this.zzaCd) {
                    break Label_0147;
                }
                final boolean b2 = true;
                boolean b3;
                boolean b4;
                boolean b5;
                TransformedResult<S> then;
                Label_0051_Outer:Label_0067_Outer:
                while (true) {
                    zzbo.zza(b2, (Object)"Result has already been consumed.");
                    while (true) {
                    Label_0162:
                        while (true) {
                        Label_0157:
                            while (true) {
                                Label_0152: {
                                    synchronized (this.zzaBW) {
                                        if (this.zzaCg != null) {
                                            break Label_0152;
                                        }
                                        b3 = true;
                                        zzbo.zza(b3, (Object)"Cannot call then() twice.");
                                        if (this.zzaCa != null) {
                                            break Label_0157;
                                        }
                                        b4 = true;
                                        zzbo.zza(b4, (Object)"Cannot call then() if callbacks are set.");
                                        if (!this.zzJ) {
                                            b5 = b;
                                            zzbo.zza(b5, (Object)"Cannot call then() if result was canceled.");
                                            this.zzaCh = true;
                                            this.zzaCg = new zzbes<R>(this.zzaBY);
                                            then = this.zzaCg.then(resultTransform);
                                            if (this.isReady()) {
                                                this.zzaBX.zza(this.zzaCg, this.get());
                                            }
                                            else {
                                                this.zzaCa = this.zzaCg;
                                            }
                                            return then;
                                        }
                                        break Label_0162;
                                    }
                                    break;
                                }
                                b3 = false;
                                continue Label_0051_Outer;
                            }
                            b4 = false;
                            continue Label_0067_Outer;
                        }
                        b5 = false;
                        continue;
                    }
                }
            }
            final boolean b2 = false;
            continue;
        }
    }
    
    @Override
    public final void zza(final zza e) {
        while (true) {
            Label_0057: {
                if (e == null) {
                    break Label_0057;
                }
                final boolean b = true;
                zzbo.zzb(b, (Object)"Callback cannot be null.");
                synchronized (this.zzaBW) {
                    if (this.isReady()) {
                        e.zzo(this.mStatus);
                    }
                    else {
                        this.zzaBZ.add(e);
                    }
                    return;
                }
            }
            final boolean b = false;
            continue;
        }
    }
    
    protected final void zza(final zzao zzaCf) {
        synchronized (this.zzaBW) {
            this.zzaCf = zzaCf;
        }
    }
    
    public final void zza(final zzbex newValue) {
        this.zzaCb.set(newValue);
    }
    
    @NonNull
    protected abstract R zzb(final Status p0);
    
    public final boolean zzpB() {
        synchronized (this.zzaBW) {
            if (this.zzaBY.get() == null || !this.zzaCh) {
                this.cancel();
            }
            return this.isCanceled();
        }
    }
    
    public final void zzpC() {
        this.zzaCh = (this.zzaCh || zzbbe.zzaBV.get());
    }
    
    @Override
    public final Integer zzpo() {
        return null;
    }
    
    public final void zzs(final Status status) {
        synchronized (this.zzaBW) {
            if (!this.isReady()) {
                this.setResult(this.zzb(status));
                this.zzaCe = true;
            }
        }
    }
}
