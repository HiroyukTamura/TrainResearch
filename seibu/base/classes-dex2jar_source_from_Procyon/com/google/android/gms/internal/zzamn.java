// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import java.util.List;
import android.os.RemoteException;
import java.util.Map;
import java.util.Collections;
import com.google.android.gms.common.internal.zzbo;
import android.content.ServiceConnection;
import com.google.android.gms.common.stats.zza;
import com.google.android.gms.analytics.zzl;
import android.content.ComponentName;

public final class zzamn extends zzamh
{
    private final zzamp zzagg;
    private zzany zzagh;
    private final zzanm zzagi;
    private zzaoo zzagj;
    
    protected zzamn(final zzamj zzamj) {
        super(zzamj);
        this.zzagj = new zzaoo(zzamj.zzkq());
        this.zzagg = new zzamp(this);
        this.zzagi = new zzamo(this, zzamj);
    }
    
    private final void onServiceDisconnected(final ComponentName componentName) {
        zzl.zzjC();
        if (this.zzagh != null) {
            this.zzagh = null;
            this.zza("Disconnected from device AnalyticsService", componentName);
            this.zzkv().zzkn();
        }
    }
    
    private final void zza(final zzany zzagh) {
        zzl.zzjC();
        this.zzagh = zzagh;
        this.zzkP();
        this.zzkv().onServiceConnected();
    }
    
    private final void zzkP() {
        this.zzagj.start();
        this.zzagi.zzs(zzans.zzahO.get());
    }
    
    private final void zzkQ() {
        zzl.zzjC();
        if (!this.isConnected()) {
            return;
        }
        this.zzbo("Inactivity, disconnecting from device AnalyticsService");
        this.disconnect();
    }
    
    public final boolean connect() {
        zzl.zzjC();
        this.zzkD();
        if (this.zzagh != null) {
            return true;
        }
        final zzany zzkR = this.zzagg.zzkR();
        if (zzkR != null) {
            this.zzagh = zzkR;
            this.zzkP();
            return true;
        }
        return false;
    }
    
    public final void disconnect() {
        zzl.zzjC();
        this.zzkD();
        while (true) {
            try {
                zza.zzrU();
                this.getContext().unbindService((ServiceConnection)this.zzagg);
                if (this.zzagh != null) {
                    this.zzagh = null;
                    this.zzkv().zzkn();
                }
            }
            catch (IllegalArgumentException ex) {
                continue;
            }
            catch (IllegalStateException ex2) {
                continue;
            }
            break;
        }
    }
    
    public final boolean isConnected() {
        zzl.zzjC();
        this.zzkD();
        return this.zzagh != null;
    }
    
    public final boolean zzb(final zzanx zzanx) {
        zzbo.zzu(zzanx);
        zzl.zzjC();
        this.zzkD();
        final zzany zzagh = this.zzagh;
        if (zzagh == null) {
            return false;
        }
        Label_0062: {
            if (!zzanx.zzlI()) {
                break Label_0062;
            }
            String s = zzank.zzlu();
            while (true) {
                final List<zzane> emptyList = Collections.emptyList();
                try {
                    zzagh.zza(zzanx.zzdV(), zzanx.zzlG(), s, emptyList);
                    this.zzkP();
                    return true;
                    s = zzank.zzlv();
                }
                catch (RemoteException ex) {
                    this.zzbo("Failed to send hits to AnalyticsService");
                    return false;
                }
            }
        }
    }
    
    @Override
    protected final void zzjD() {
    }
    
    public final boolean zzkO() {
        zzl.zzjC();
        this.zzkD();
        final zzany zzagh = this.zzagh;
        if (zzagh == null) {
            return false;
        }
        try {
            zzagh.zzkk();
            this.zzkP();
            return true;
        }
        catch (RemoteException ex) {
            this.zzbo("Failed to clear hits from AnalyticsService");
            return false;
        }
    }
}
