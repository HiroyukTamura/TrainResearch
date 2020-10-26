// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.data;

import java.util.ArrayList;

public abstract class zzg<T> extends AbstractDataBuffer<T>
{
    private boolean zzaFO;
    private ArrayList<Integer> zzaFP;
    
    protected zzg(final DataHolder dataHolder) {
        super(dataHolder);
        this.zzaFO = false;
    }
    
    private final int zzaw(final int n) {
        if (n < 0 || n >= this.zzaFP.size()) {
            throw new IllegalArgumentException(new StringBuilder(53).append("Position ").append(n).append(" is out of bounds for this buffer").toString());
        }
        return this.zzaFP.get(n);
    }
    
    private final void zzqT() {
        while (true) {
            Label_0199: {
                while (true) {
                    int zzat;
                    final String zzd;
                    synchronized (this) {
                        if (this.zzaFO) {
                            break;
                        }
                        final int zzaFG = this.zzaCX.zzaFG;
                        this.zzaFP = new ArrayList<Integer>();
                        if (zzaFG <= 0) {
                            break Label_0199;
                        }
                        this.zzaFP.add(0);
                        final String zzqS = this.zzqS();
                        zzat = this.zzaCX.zzat(0);
                        this.zzaCX.zzd(zzqS, 0, zzat);
                        zzat = 1;
                        if (zzat >= zzaFG) {
                            break Label_0199;
                        }
                        final int zzat2 = this.zzaCX.zzat(zzat);
                        zzd = this.zzaCX.zzd(zzqS, zzat, zzat2);
                        if (zzd == null) {
                            throw new NullPointerException(new StringBuilder(String.valueOf(zzqS).length() + 78).append("Missing value for markerColumn: ").append(zzqS).append(", at row: ").append(zzat).append(", for window: ").append(zzat2).toString());
                        }
                    }
                    final Throwable anObject;
                    if (!zzd.equals(anObject)) {
                        this.zzaFP.add(zzat);
                    }
                    ++zzat;
                    continue;
                }
            }
            this.zzaFO = true;
            break;
        }
    }
    // monitorexit(this)
    
    @Override
    public final T get(int zzaw) {
        this.zzqT();
        final int zzaw2 = this.zzaw(zzaw);
        int n;
        if (zzaw < 0 || zzaw == this.zzaFP.size()) {
            n = 0;
        }
        else {
            int n2;
            if (zzaw == this.zzaFP.size() - 1) {
                n2 = this.zzaCX.zzaFG - this.zzaFP.get(zzaw);
            }
            else {
                n2 = this.zzaFP.get(zzaw + 1) - this.zzaFP.get(zzaw);
            }
            n = n2;
            if (n2 == 1) {
                zzaw = this.zzaw(zzaw);
                this.zzaCX.zzat(zzaw);
                n = n2;
            }
        }
        return this.zzi(zzaw2, n);
    }
    
    @Override
    public int getCount() {
        this.zzqT();
        return this.zzaFP.size();
    }
    
    protected abstract T zzi(final int p0, final int p1);
    
    protected abstract String zzqS();
}
