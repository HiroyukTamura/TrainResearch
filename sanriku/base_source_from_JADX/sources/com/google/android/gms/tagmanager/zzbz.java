package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.gtm.zzpf;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.concurrent.LinkedBlockingQueue;

final class zzbz extends Thread implements zzby {
    private static zzbz zzahd;
    private volatile boolean closed = false;
    private final LinkedBlockingQueue<Runnable> zzahb = new LinkedBlockingQueue<>();
    private volatile boolean zzahc = false;
    /* access modifiers changed from: private */
    public volatile zzcb zzahe;
    /* access modifiers changed from: private */
    public final Context zzrm;

    private zzbz(Context context) {
        super("GAThread");
        this.zzrm = context != null ? context.getApplicationContext() : context;
        start();
    }

    static zzbz zzm(Context context) {
        if (zzahd == null) {
            zzahd = new zzbz(context);
        }
        return zzahd;
    }

    public final void run() {
        while (true) {
            try {
                Runnable take = this.zzahb.take();
                if (!this.zzahc) {
                    take.run();
                }
            } catch (InterruptedException e) {
                try {
                    zzdi.zzaw(e.toString());
                } catch (Exception e2) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    PrintStream printStream = new PrintStream(byteArrayOutputStream);
                    zzpf.zza(e2, printStream);
                    printStream.flush();
                    String str = new String(byteArrayOutputStream.toByteArray());
                    zzdi.zzav(str.length() != 0 ? "Error on Google TagManager Thread: ".concat(str) : new String("Error on Google TagManager Thread: "));
                    zzdi.zzav("Google TagManager is shutting down.");
                    this.zzahc = true;
                }
            }
        }
    }

    public final void zzbd(String str) {
        zzc(new zzca(this, this, System.currentTimeMillis(), str));
    }

    public final void zzc(Runnable runnable) {
        this.zzahb.add(runnable);
    }
}
