// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tagmanager;

import java.io.OutputStream;
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;
import java.util.concurrent.LinkedBlockingQueue;
import android.content.Context;

final class zzca extends Thread implements zzbz
{
    private static zzca zzbES;
    private volatile boolean mClosed;
    private final Context mContext;
    private volatile boolean zzOZ;
    private final LinkedBlockingQueue<Runnable> zzbER;
    private volatile zzcc zzbET;
    
    private zzca(final Context mContext) {
        super("GAThread");
        this.zzbER = new LinkedBlockingQueue<Runnable>();
        this.zzOZ = false;
        this.mClosed = false;
        if (mContext != null) {
            this.mContext = mContext.getApplicationContext();
        }
        else {
            this.mContext = mContext;
        }
        this.start();
    }
    
    static zzca zzbs(final Context context) {
        if (zzca.zzbES == null) {
            zzca.zzbES = new zzca(context);
        }
        return zzca.zzbES;
    }
    
    @Override
    public final void run() {
        while (true) {
            final boolean mClosed = this.mClosed;
            try {
                try {
                    final Runnable runnable = this.zzbER.take();
                    if (!this.zzOZ) {
                        runnable.run();
                        continue;
                    }
                    continue;
                }
                catch (InterruptedException ex) {
                    zzdj.zzaS(ex.toString());
                }
            }
            catch (Throwable t) {
                final ByteArrayOutputStream out = new ByteArrayOutputStream();
                final PrintStream s = new PrintStream(out);
                t.printStackTrace(s);
                s.flush();
                final String value = String.valueOf(new String(out.toByteArray()));
                String concat;
                if (value.length() != 0) {
                    concat = "Error on Google TagManager Thread: ".concat(value);
                }
                else {
                    concat = new String("Error on Google TagManager Thread: ");
                }
                zzdj.e(concat);
                zzdj.e("Google TagManager is shutting down.");
                this.zzOZ = true;
            }
        }
    }
    
    @Override
    public final void zzfm(final String s) {
        this.zzn(new zzcb(this, this, System.currentTimeMillis(), s));
    }
    
    @Override
    public final void zzn(final Runnable e) {
        this.zzbER.add(e);
    }
}
