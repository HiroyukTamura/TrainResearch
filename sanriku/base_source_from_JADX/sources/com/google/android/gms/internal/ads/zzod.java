package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.fitness.FitnessStatusCodes;
import com.google.android.gms.internal.ads.zzog;
import java.io.IOException;

@SuppressLint({"HandlerLeak"})
final class zzod<T extends zzog> extends zzdns implements Runnable {
    private volatile boolean zzaez;
    private final T zzbgt;
    private final zzoe<T> zzbgu;
    public final int zzbgv;
    private final long zzbgw;
    private IOException zzbgx;
    private int zzbgy;
    private volatile Thread zzbgz;
    private final /* synthetic */ zzob zzbha;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzod(zzob zzob, Looper looper, T t, zzoe<T> zzoe, int i, long j) {
        super(looper);
        this.zzbha = zzob;
        this.zzbgt = t;
        this.zzbgu = zzoe;
        this.zzbgv = i;
        this.zzbgw = j;
    }

    private final void execute() {
        this.zzbgx = null;
        this.zzbha.zzbgo.execute(this.zzbha.zzbgp);
    }

    private final void finish() {
        zzod unused = this.zzbha.zzbgp = null;
    }

    public final void handleMessage(Message message) {
        if (!this.zzaez) {
            int i = message.what;
            if (i == 0) {
                execute();
            } else if (i != 4) {
                finish();
                long elapsedRealtime = SystemClock.elapsedRealtime();
                long j = elapsedRealtime - this.zzbgw;
                if (this.zzbgt.zzhw()) {
                    this.zzbgu.zza(this.zzbgt, elapsedRealtime, j, false);
                    return;
                }
                int i2 = message.what;
                if (i2 == 1) {
                    this.zzbgu.zza(this.zzbgt, elapsedRealtime, j, false);
                } else if (i2 == 2) {
                    this.zzbgu.zza(this.zzbgt, elapsedRealtime, j);
                } else if (i2 == 3) {
                    IOException iOException = (IOException) message.obj;
                    this.zzbgx = iOException;
                    int zza = this.zzbgu.zza(this.zzbgt, elapsedRealtime, j, iOException);
                    if (zza == 3) {
                        IOException unused = this.zzbha.zzbgq = this.zzbgx;
                    } else if (zza != 2) {
                        int i3 = zza == 1 ? 1 : this.zzbgy + 1;
                        this.zzbgy = i3;
                        zzek((long) Math.min((i3 - 1) * 1000, FitnessStatusCodes.NEEDS_OAUTH_PERMISSIONS));
                    }
                }
            } else {
                throw ((Error) message.obj);
            }
        }
    }

    public final void run() {
        try {
            this.zzbgz = Thread.currentThread();
            if (!this.zzbgt.zzhw()) {
                String simpleName = this.zzbgt.getClass().getSimpleName();
                zzow.beginSection(simpleName.length() != 0 ? "load:".concat(simpleName) : new String("load:"));
                this.zzbgt.zzhx();
                zzow.endSection();
            }
            if (!this.zzaez) {
                sendEmptyMessage(2);
            }
        } catch (IOException e) {
            if (!this.zzaez) {
                obtainMessage(3, e).sendToTarget();
            }
        } catch (InterruptedException unused) {
            zzoh.checkState(this.zzbgt.zzhw());
            if (!this.zzaez) {
                sendEmptyMessage(2);
            }
        } catch (Exception e2) {
            Log.e("LoadTask", "Unexpected exception loading stream", e2);
            if (!this.zzaez) {
                obtainMessage(3, new zzof(e2)).sendToTarget();
            }
        } catch (OutOfMemoryError e3) {
            Log.e("LoadTask", "OutOfMemory error loading stream", e3);
            if (!this.zzaez) {
                obtainMessage(3, new zzof(e3)).sendToTarget();
            }
        } catch (Error e4) {
            Log.e("LoadTask", "Unexpected error loading stream", e4);
            if (!this.zzaez) {
                obtainMessage(4, e4).sendToTarget();
            }
            throw e4;
        } catch (Throwable th) {
            zzow.endSection();
            throw th;
        }
    }

    public final void zzbd(int i) throws IOException {
        IOException iOException = this.zzbgx;
        if (iOException != null && this.zzbgy > i) {
            throw iOException;
        }
    }

    public final void zzek(long j) {
        zzoh.checkState(this.zzbha.zzbgp == null);
        zzod unused = this.zzbha.zzbgp = this;
        if (j > 0) {
            sendEmptyMessageDelayed(0, j);
        } else {
            execute();
        }
    }

    public final void zzl(boolean z) {
        this.zzaez = z;
        this.zzbgx = null;
        if (hasMessages(0)) {
            removeMessages(0);
            if (!z) {
                sendEmptyMessage(1);
            }
        } else {
            this.zzbgt.cancelLoad();
            if (this.zzbgz != null) {
                this.zzbgz.interrupt();
            }
        }
        if (z) {
            finish();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.zzbgu.zza(this.zzbgt, elapsedRealtime, elapsedRealtime - this.zzbgw, true);
        }
    }
}
