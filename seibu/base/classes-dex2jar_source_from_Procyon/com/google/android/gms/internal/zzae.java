// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import java.util.Collections;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Comparator;

public final class zzae
{
    private static Comparator<byte[]> zzau;
    private List<byte[]> zzaq;
    private List<byte[]> zzar;
    private int zzas;
    private final int zzat;
    
    static {
        zzae.zzau = new zzaf();
    }
    
    public zzae(final int zzat) {
        this.zzaq = new LinkedList<byte[]>();
        this.zzar = new ArrayList<byte[]>(64);
        this.zzas = 0;
        this.zzat = zzat;
    }
    
    private final void zzm() {
        synchronized (this) {
            while (this.zzas > this.zzat) {
                final byte[] array = this.zzaq.remove(0);
                this.zzar.remove(array);
                this.zzas -= array.length;
            }
        }
    }
    // monitorexit(this)
    
    public final void zza(final byte[] key) {
        // monitorenter(this)
        if (key == null) {
            return;
        }
        try {
            if (key.length <= this.zzat) {
                this.zzaq.add(key);
                final int binarySearch = Collections.binarySearch(this.zzar, key, zzae.zzau);
                int n;
                if ((n = binarySearch) < 0) {
                    n = -binarySearch - 1;
                }
                this.zzar.add(n, key);
                this.zzas += key.length;
                this.zzm();
            }
        }
        finally {
        }
        // monitorexit(this)
    }
    
    public final byte[] zzb(final int n) {
        // monitorenter(this)
        int i = 0;
        try {
            while (i < this.zzar.size()) {
                final byte[] array = this.zzar.get(i);
                if (array.length >= n) {
                    this.zzas -= array.length;
                    this.zzar.remove(i);
                    this.zzaq.remove(array);
                    return array;
                }
                ++i;
            }
            return new byte[n];
        }
        finally {
        }
        // monitorexit(this)
    }
}
