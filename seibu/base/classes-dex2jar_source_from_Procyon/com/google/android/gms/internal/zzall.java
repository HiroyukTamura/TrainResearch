// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.text.TextUtils;
import java.util.HashMap;
import com.google.android.gms.analytics.zzj;

public final class zzall extends zzj<zzall>
{
    private String mName;
    private String zzHg;
    private String zzIi;
    private String zzaeK;
    private String zzaeL;
    private String zzaeM;
    private String zzaeN;
    private String zzaeO;
    private String zzaeP;
    private String zzaeQ;
    
    public final String getContent() {
        return this.zzHg;
    }
    
    public final String getId() {
        return this.zzIi;
    }
    
    public final String getName() {
        return this.mName;
    }
    
    public final String getSource() {
        return this.zzaeK;
    }
    
    public final void setName(final String mName) {
        this.mName = mName;
    }
    
    @Override
    public final String toString() {
        final HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("name", this.mName);
        hashMap.put("source", this.zzaeK);
        hashMap.put("medium", this.zzaeL);
        hashMap.put("keyword", this.zzaeM);
        hashMap.put("content", this.zzHg);
        hashMap.put("id", this.zzIi);
        hashMap.put("adNetworkId", this.zzaeN);
        hashMap.put("gclid", this.zzaeO);
        hashMap.put("dclid", this.zzaeP);
        hashMap.put("aclid", this.zzaeQ);
        return zzj.zzh(hashMap);
    }
    
    public final void zzba(final String zzaeK) {
        this.zzaeK = zzaeK;
    }
    
    public final void zzbb(final String zzaeL) {
        this.zzaeL = zzaeL;
    }
    
    public final void zzbc(final String zzaeM) {
        this.zzaeM = zzaeM;
    }
    
    public final void zzbd(final String zzHg) {
        this.zzHg = zzHg;
    }
    
    public final void zzbe(final String zzIi) {
        this.zzIi = zzIi;
    }
    
    public final void zzbf(final String zzaeN) {
        this.zzaeN = zzaeN;
    }
    
    public final void zzbg(final String zzaeO) {
        this.zzaeO = zzaeO;
    }
    
    public final void zzbh(final String zzaeP) {
        this.zzaeP = zzaeP;
    }
    
    public final void zzbi(final String zzaeQ) {
        this.zzaeQ = zzaeQ;
    }
    
    public final String zzjJ() {
        return this.zzaeL;
    }
    
    public final String zzjK() {
        return this.zzaeM;
    }
    
    public final String zzjL() {
        return this.zzaeN;
    }
    
    public final String zzjM() {
        return this.zzaeO;
    }
    
    public final String zzjN() {
        return this.zzaeP;
    }
    
    public final String zzjO() {
        return this.zzaeQ;
    }
}
