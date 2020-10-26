// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.internal;

import android.content.Intent;
import java.util.Arrays;
import android.content.ComponentName;

public final class zzaf
{
    private final String zzaHN;
    private final ComponentName zzaHO;
    private final String zzaeX;
    
    public zzaf(final ComponentName componentName) {
        this.zzaeX = null;
        this.zzaHN = null;
        this.zzaHO = zzbo.zzu(componentName);
    }
    
    public zzaf(final String s, final String s2) {
        this.zzaeX = zzbo.zzcF(s);
        this.zzaHN = zzbo.zzcF(s2);
        this.zzaHO = null;
    }
    
    @Override
    public final boolean equals(final Object o) {
        if (this != o) {
            if (!(o instanceof zzaf)) {
                return false;
            }
            final zzaf zzaf = (zzaf)o;
            if (!zzbe.equal(this.zzaeX, zzaf.zzaeX) || !zzbe.equal(this.zzaHN, zzaf.zzaHN) || !zzbe.equal(this.zzaHO, zzaf.zzaHO)) {
                return false;
            }
        }
        return true;
    }
    
    public final ComponentName getComponentName() {
        return this.zzaHO;
    }
    
    public final String getPackage() {
        return this.zzaHN;
    }
    
    @Override
    public final int hashCode() {
        return Arrays.hashCode(new Object[] { this.zzaeX, this.zzaHN, this.zzaHO });
    }
    
    @Override
    public final String toString() {
        if (this.zzaeX == null) {
            return this.zzaHO.flattenToString();
        }
        return this.zzaeX;
    }
    
    public final Intent zzrB() {
        if (this.zzaeX != null) {
            return new Intent(this.zzaeX).setPackage(this.zzaHN);
        }
        return new Intent().setComponent(this.zzaHO);
    }
}
