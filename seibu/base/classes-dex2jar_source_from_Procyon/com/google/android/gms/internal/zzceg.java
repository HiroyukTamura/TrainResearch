// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.text.TextUtils;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.internal.zzbo;

final class zzceg
{
    private final String mAppId;
    private String zzXB;
    private String zzaKE;
    private String zzaeI;
    private long zzboA;
    private String zzboB;
    private long zzboC;
    private long zzboD;
    private boolean zzboE;
    private long zzboF;
    private long zzboG;
    private long zzboH;
    private long zzboI;
    private long zzboJ;
    private long zzboK;
    private long zzboL;
    private String zzboM;
    private boolean zzboN;
    private long zzboO;
    private long zzboP;
    private final zzcgl zzboe;
    private String zzbov;
    private String zzbow;
    private long zzbox;
    private long zzboy;
    private long zzboz;
    
    @WorkerThread
    zzceg(final zzcgl zzboe, final String mAppId) {
        zzbo.zzu(zzboe);
        zzbo.zzcF(mAppId);
        this.zzboe = zzboe;
        this.mAppId = mAppId;
        this.zzboe.zzwE().zzjC();
    }
    
    @WorkerThread
    public final String getAppInstanceId() {
        this.zzboe.zzwE().zzjC();
        return this.zzaKE;
    }
    
    @WorkerThread
    public final String getGmpAppId() {
        this.zzboe.zzwE().zzjC();
        return this.zzXB;
    }
    
    @WorkerThread
    public final void setAppVersion(final String zzaeI) {
        this.zzboe.zzwE().zzjC();
        final boolean zzboN = this.zzboN;
        boolean b;
        if (!zzcjl.zzR(this.zzaeI, zzaeI)) {
            b = true;
        }
        else {
            b = false;
        }
        this.zzboN = (b | zzboN);
        this.zzaeI = zzaeI;
    }
    
    @WorkerThread
    public final void setMeasurementEnabled(final boolean zzboE) {
        this.zzboe.zzwE().zzjC();
        final boolean zzboN = this.zzboN;
        boolean b;
        if (this.zzboE != zzboE) {
            b = true;
        }
        else {
            b = false;
        }
        this.zzboN = (b | zzboN);
        this.zzboE = zzboE;
    }
    
    @WorkerThread
    public final void zzL(final long zzboy) {
        this.zzboe.zzwE().zzjC();
        final boolean zzboN = this.zzboN;
        boolean b;
        if (this.zzboy != zzboy) {
            b = true;
        }
        else {
            b = false;
        }
        this.zzboN = (b | zzboN);
        this.zzboy = zzboy;
    }
    
    @WorkerThread
    public final void zzM(final long zzboz) {
        this.zzboe.zzwE().zzjC();
        final boolean zzboN = this.zzboN;
        boolean b;
        if (this.zzboz != zzboz) {
            b = true;
        }
        else {
            b = false;
        }
        this.zzboN = (b | zzboN);
        this.zzboz = zzboz;
    }
    
    @WorkerThread
    public final void zzN(final long zzboA) {
        this.zzboe.zzwE().zzjC();
        final boolean zzboN = this.zzboN;
        boolean b;
        if (this.zzboA != zzboA) {
            b = true;
        }
        else {
            b = false;
        }
        this.zzboN = (b | zzboN);
        this.zzboA = zzboA;
    }
    
    @WorkerThread
    public final void zzO(final long zzboC) {
        this.zzboe.zzwE().zzjC();
        final boolean zzboN = this.zzboN;
        boolean b;
        if (this.zzboC != zzboC) {
            b = true;
        }
        else {
            b = false;
        }
        this.zzboN = (b | zzboN);
        this.zzboC = zzboC;
    }
    
    @WorkerThread
    public final void zzP(final long zzboD) {
        this.zzboe.zzwE().zzjC();
        final boolean zzboN = this.zzboN;
        boolean b;
        if (this.zzboD != zzboD) {
            b = true;
        }
        else {
            b = false;
        }
        this.zzboN = (b | zzboN);
        this.zzboD = zzboD;
    }
    
    @WorkerThread
    public final void zzQ(final long zzbox) {
        boolean b = true;
        zzbo.zzaf(zzbox >= 0L);
        this.zzboe.zzwE().zzjC();
        final boolean zzboN = this.zzboN;
        if (this.zzbox == zzbox) {
            b = false;
        }
        this.zzboN = (zzboN | b);
        this.zzbox = zzbox;
    }
    
    @WorkerThread
    public final void zzR(final long zzboO) {
        this.zzboe.zzwE().zzjC();
        final boolean zzboN = this.zzboN;
        boolean b;
        if (this.zzboO != zzboO) {
            b = true;
        }
        else {
            b = false;
        }
        this.zzboN = (b | zzboN);
        this.zzboO = zzboO;
    }
    
    @WorkerThread
    public final void zzS(final long zzboP) {
        this.zzboe.zzwE().zzjC();
        final boolean zzboN = this.zzboN;
        boolean b;
        if (this.zzboP != zzboP) {
            b = true;
        }
        else {
            b = false;
        }
        this.zzboN = (b | zzboN);
        this.zzboP = zzboP;
    }
    
    @WorkerThread
    public final void zzT(final long zzboG) {
        this.zzboe.zzwE().zzjC();
        final boolean zzboN = this.zzboN;
        boolean b;
        if (this.zzboG != zzboG) {
            b = true;
        }
        else {
            b = false;
        }
        this.zzboN = (b | zzboN);
        this.zzboG = zzboG;
    }
    
    @WorkerThread
    public final void zzU(final long zzboH) {
        this.zzboe.zzwE().zzjC();
        final boolean zzboN = this.zzboN;
        boolean b;
        if (this.zzboH != zzboH) {
            b = true;
        }
        else {
            b = false;
        }
        this.zzboN = (b | zzboN);
        this.zzboH = zzboH;
    }
    
    @WorkerThread
    public final void zzV(final long zzboI) {
        this.zzboe.zzwE().zzjC();
        final boolean zzboN = this.zzboN;
        boolean b;
        if (this.zzboI != zzboI) {
            b = true;
        }
        else {
            b = false;
        }
        this.zzboN = (b | zzboN);
        this.zzboI = zzboI;
    }
    
    @WorkerThread
    public final void zzW(final long zzboJ) {
        this.zzboe.zzwE().zzjC();
        final boolean zzboN = this.zzboN;
        boolean b;
        if (this.zzboJ != zzboJ) {
            b = true;
        }
        else {
            b = false;
        }
        this.zzboN = (b | zzboN);
        this.zzboJ = zzboJ;
    }
    
    @WorkerThread
    public final void zzX(final long zzboL) {
        this.zzboe.zzwE().zzjC();
        final boolean zzboN = this.zzboN;
        boolean b;
        if (this.zzboL != zzboL) {
            b = true;
        }
        else {
            b = false;
        }
        this.zzboN = (b | zzboN);
        this.zzboL = zzboL;
    }
    
    @WorkerThread
    public final void zzY(final long zzboK) {
        this.zzboe.zzwE().zzjC();
        final boolean zzboN = this.zzboN;
        boolean b;
        if (this.zzboK != zzboK) {
            b = true;
        }
        else {
            b = false;
        }
        this.zzboN = (b | zzboN);
        this.zzboK = zzboK;
    }
    
    @WorkerThread
    public final void zzZ(final long zzboF) {
        this.zzboe.zzwE().zzjC();
        final boolean zzboN = this.zzboN;
        boolean b;
        if (this.zzboF != zzboF) {
            b = true;
        }
        else {
            b = false;
        }
        this.zzboN = (b | zzboN);
        this.zzboF = zzboF;
    }
    
    @WorkerThread
    public final void zzdG(final String zzaKE) {
        this.zzboe.zzwE().zzjC();
        final boolean zzboN = this.zzboN;
        boolean b;
        if (!zzcjl.zzR(this.zzaKE, zzaKE)) {
            b = true;
        }
        else {
            b = false;
        }
        this.zzboN = (b | zzboN);
        this.zzaKE = zzaKE;
    }
    
    @WorkerThread
    public final void zzdH(final String s) {
        this.zzboe.zzwE().zzjC();
        String zzXB = s;
        if (TextUtils.isEmpty((CharSequence)s)) {
            zzXB = null;
        }
        final boolean zzboN = this.zzboN;
        boolean b;
        if (!zzcjl.zzR(this.zzXB, zzXB)) {
            b = true;
        }
        else {
            b = false;
        }
        this.zzboN = (b | zzboN);
        this.zzXB = zzXB;
    }
    
    @WorkerThread
    public final void zzdI(final String zzbov) {
        this.zzboe.zzwE().zzjC();
        final boolean zzboN = this.zzboN;
        boolean b;
        if (!zzcjl.zzR(this.zzbov, zzbov)) {
            b = true;
        }
        else {
            b = false;
        }
        this.zzboN = (b | zzboN);
        this.zzbov = zzbov;
    }
    
    @WorkerThread
    public final void zzdJ(final String zzbow) {
        this.zzboe.zzwE().zzjC();
        final boolean zzboN = this.zzboN;
        boolean b;
        if (!zzcjl.zzR(this.zzbow, zzbow)) {
            b = true;
        }
        else {
            b = false;
        }
        this.zzboN = (b | zzboN);
        this.zzbow = zzbow;
    }
    
    @WorkerThread
    public final void zzdK(final String zzboB) {
        this.zzboe.zzwE().zzjC();
        final boolean zzboN = this.zzboN;
        boolean b;
        if (!zzcjl.zzR(this.zzboB, zzboB)) {
            b = true;
        }
        else {
            b = false;
        }
        this.zzboN = (b | zzboN);
        this.zzboB = zzboB;
    }
    
    @WorkerThread
    public final void zzdL(final String zzboM) {
        this.zzboe.zzwE().zzjC();
        final boolean zzboN = this.zzboN;
        boolean b;
        if (!zzcjl.zzR(this.zzboM, zzboM)) {
            b = true;
        }
        else {
            b = false;
        }
        this.zzboN = (b | zzboN);
        this.zzboM = zzboM;
    }
    
    @WorkerThread
    public final String zzhl() {
        this.zzboe.zzwE().zzjC();
        return this.mAppId;
    }
    
    @WorkerThread
    public final String zzjH() {
        this.zzboe.zzwE().zzjC();
        return this.zzaeI;
    }
    
    @WorkerThread
    public final void zzwI() {
        this.zzboe.zzwE().zzjC();
        this.zzboN = false;
    }
    
    @WorkerThread
    public final String zzwJ() {
        this.zzboe.zzwE().zzjC();
        return this.zzbov;
    }
    
    @WorkerThread
    public final String zzwK() {
        this.zzboe.zzwE().zzjC();
        return this.zzbow;
    }
    
    @WorkerThread
    public final long zzwL() {
        this.zzboe.zzwE().zzjC();
        return this.zzboy;
    }
    
    @WorkerThread
    public final long zzwM() {
        this.zzboe.zzwE().zzjC();
        return this.zzboz;
    }
    
    @WorkerThread
    public final long zzwN() {
        this.zzboe.zzwE().zzjC();
        return this.zzboA;
    }
    
    @WorkerThread
    public final String zzwO() {
        this.zzboe.zzwE().zzjC();
        return this.zzboB;
    }
    
    @WorkerThread
    public final long zzwP() {
        this.zzboe.zzwE().zzjC();
        return this.zzboC;
    }
    
    @WorkerThread
    public final long zzwQ() {
        this.zzboe.zzwE().zzjC();
        return this.zzboD;
    }
    
    @WorkerThread
    public final boolean zzwR() {
        this.zzboe.zzwE().zzjC();
        return this.zzboE;
    }
    
    @WorkerThread
    public final long zzwS() {
        this.zzboe.zzwE().zzjC();
        return this.zzbox;
    }
    
    @WorkerThread
    public final long zzwT() {
        this.zzboe.zzwE().zzjC();
        return this.zzboO;
    }
    
    @WorkerThread
    public final long zzwU() {
        this.zzboe.zzwE().zzjC();
        return this.zzboP;
    }
    
    @WorkerThread
    public final void zzwV() {
        this.zzboe.zzwE().zzjC();
        long zzbox;
        if ((zzbox = this.zzbox + 1L) > 2147483647L) {
            this.zzboe.zzwF().zzyz().zzj("Bundle index overflow. appId", zzcfl.zzdZ(this.mAppId));
            zzbox = 0L;
        }
        this.zzboN = true;
        this.zzbox = zzbox;
    }
    
    @WorkerThread
    public final long zzwW() {
        this.zzboe.zzwE().zzjC();
        return this.zzboG;
    }
    
    @WorkerThread
    public final long zzwX() {
        this.zzboe.zzwE().zzjC();
        return this.zzboH;
    }
    
    @WorkerThread
    public final long zzwY() {
        this.zzboe.zzwE().zzjC();
        return this.zzboI;
    }
    
    @WorkerThread
    public final long zzwZ() {
        this.zzboe.zzwE().zzjC();
        return this.zzboJ;
    }
    
    @WorkerThread
    public final long zzxa() {
        this.zzboe.zzwE().zzjC();
        return this.zzboL;
    }
    
    @WorkerThread
    public final long zzxb() {
        this.zzboe.zzwE().zzjC();
        return this.zzboK;
    }
    
    @WorkerThread
    public final String zzxc() {
        this.zzboe.zzwE().zzjC();
        return this.zzboM;
    }
    
    @WorkerThread
    public final String zzxd() {
        this.zzboe.zzwE().zzjC();
        final String zzboM = this.zzboM;
        this.zzdL(null);
        return zzboM;
    }
    
    @WorkerThread
    public final long zzxe() {
        this.zzboe.zzwE().zzjC();
        return this.zzboF;
    }
}
