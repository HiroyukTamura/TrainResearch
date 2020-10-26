// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import android.content.Context;
import java.util.Iterator;
import java.util.Collection;
import java.util.HashSet;
import java.util.Collections;
import android.accounts.Account;
import com.google.android.gms.internal.zzctl;
import com.google.android.gms.common.api.Api;
import java.util.Map;
import android.view.View;
import com.google.android.gms.common.api.Scope;
import java.util.Set;

public final class zzq
{
    private final Set<Scope> zzaAT;
    private final int zzaAV;
    private final View zzaAW;
    private final String zzaAX;
    private final Set<Scope> zzaHk;
    private final Map<Api<?>, zzr> zzaHl;
    private final zzctl zzaHm;
    private Integer zzaHn;
    private final Account zzajb;
    private final String zzake;
    
    public zzq(final Account zzajb, final Set<Scope> s, final Map<Api<?>, zzr> map, final int zzaAV, final View zzaAW, final String zzake, final String zzaAX, final zzctl zzaHm) {
        this.zzajb = zzajb;
        Set<Scope> zzaAT;
        if (s == null) {
            zzaAT = (Set<Scope>)Collections.EMPTY_SET;
        }
        else {
            zzaAT = Collections.unmodifiableSet((Set<? extends Scope>)s);
        }
        this.zzaAT = zzaAT;
        Map<Api<?>, zzr> empty_MAP = map;
        if (map == null) {
            empty_MAP = (Map<Api<?>, zzr>)Collections.EMPTY_MAP;
        }
        this.zzaHl = empty_MAP;
        this.zzaAW = zzaAW;
        this.zzaAV = zzaAV;
        this.zzake = zzake;
        this.zzaAX = zzaAX;
        this.zzaHm = zzaHm;
        final HashSet<Scope> s2 = new HashSet<Scope>(this.zzaAT);
        final Iterator<zzr> iterator = this.zzaHl.values().iterator();
        while (iterator.hasNext()) {
            s2.addAll((Collection<?>)iterator.next().zzame);
        }
        this.zzaHk = (Set<Scope>)Collections.unmodifiableSet((Set<?>)s2);
    }
    
    public static zzq zzaA(final Context context) {
        return new GoogleApiClient.Builder(context).zzpn();
    }
    
    public final Account getAccount() {
        return this.zzajb;
    }
    
    @Deprecated
    public final String getAccountName() {
        if (this.zzajb != null) {
            return this.zzajb.name;
        }
        return null;
    }
    
    public final Set<Scope> zzc(final Api<?> api) {
        final zzr zzr = this.zzaHl.get(api);
        if (zzr == null || zzr.zzame.isEmpty()) {
            return this.zzaAT;
        }
        final HashSet<Object> set = (HashSet<Object>)new HashSet<Scope>(this.zzaAT);
        set.addAll(zzr.zzame);
        return (Set<Scope>)set;
    }
    
    public final void zzc(final Integer zzaHn) {
        this.zzaHn = zzaHn;
    }
    
    public final Account zzrl() {
        if (this.zzajb != null) {
            return this.zzajb;
        }
        return new Account("<<default account>>", "com.google");
    }
    
    public final int zzrm() {
        return this.zzaAV;
    }
    
    public final Set<Scope> zzrn() {
        return this.zzaAT;
    }
    
    public final Set<Scope> zzro() {
        return this.zzaHk;
    }
    
    public final Map<Api<?>, zzr> zzrp() {
        return this.zzaHl;
    }
    
    public final String zzrq() {
        return this.zzake;
    }
    
    public final String zzrr() {
        return this.zzaAX;
    }
    
    public final View zzrs() {
        return this.zzaAW;
    }
    
    public final zzctl zzrt() {
        return this.zzaHm;
    }
    
    public final Integer zzru() {
        return this.zzaHn;
    }
}
