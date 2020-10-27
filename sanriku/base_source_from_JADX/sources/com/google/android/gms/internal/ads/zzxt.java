package com.google.android.gms.internal.ads;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.mediation.MediationExtrasReceiver;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.ads.query.AdInfo;
import com.google.android.gms.ads.search.SearchAdRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class zzxt {
    private final int zzacq;
    private final int zzacr;
    private final String zzacs;
    private final boolean zzbli;
    private final int zzceh;
    private final String zzcek;
    private final String zzcem;
    private final Bundle zzceo;
    private final String zzceq;
    private final boolean zzces;
    private final List<String> zzcet;
    private final Bundle zzcgn;
    private final AdInfo zzcgr;
    private final Map<Class<? extends NetworkExtras>, NetworkExtras> zzcgs;
    private final SearchAdRequest zzcgt;
    private final Set<String> zzcgu;
    private final Set<String> zzcgv;
    private final Date zzml;
    private final Set<String> zzmn;
    private final Location zzmp;

    public zzxt(zzxs zzxs) {
        this(zzxs, (SearchAdRequest) null);
    }

    public zzxt(zzxs zzxs, SearchAdRequest searchAdRequest) {
        this.zzml = zzxs.zzml;
        this.zzcem = zzxs.zzcem;
        this.zzcet = zzxs.zzcet;
        this.zzceh = zzxs.zzceh;
        this.zzmn = Collections.unmodifiableSet(zzxs.zzcgm);
        this.zzmp = zzxs.zzmp;
        this.zzbli = zzxs.zzbli;
        this.zzcgn = zzxs.zzcgn;
        this.zzcgs = Collections.unmodifiableMap(zzxs.zzcgo);
        this.zzcek = zzxs.zzcek;
        this.zzceq = zzxs.zzceq;
        this.zzcgt = searchAdRequest;
        this.zzacq = zzxs.zzacq;
        this.zzcgu = Collections.unmodifiableSet(zzxs.zzcgp);
        this.zzceo = zzxs.zzceo;
        this.zzcgv = Collections.unmodifiableSet(zzxs.zzcgq);
        this.zzces = zzxs.zzces;
        this.zzcgr = zzxs.zzcgr;
        this.zzacr = zzxs.zzacr;
        this.zzacs = zzxs.zzacs;
    }

    @Deprecated
    public final Date getBirthday() {
        return this.zzml;
    }

    public final String getContentUrl() {
        return this.zzcem;
    }

    public final Bundle getCustomEventExtrasBundle(Class<? extends CustomEvent> cls) {
        Bundle bundle = this.zzcgn.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter");
        if (bundle != null) {
            return bundle.getBundle(cls.getName());
        }
        return null;
    }

    public final Bundle getCustomTargeting() {
        return this.zzceo;
    }

    @Deprecated
    public final int getGender() {
        return this.zzceh;
    }

    public final Set<String> getKeywords() {
        return this.zzmn;
    }

    public final Location getLocation() {
        return this.zzmp;
    }

    public final boolean getManualImpressionsEnabled() {
        return this.zzbli;
    }

    @Nullable
    public final String getMaxAdContentRating() {
        return this.zzacs;
    }

    @Deprecated
    public final <T extends NetworkExtras> T getNetworkExtras(Class<T> cls) {
        return (NetworkExtras) this.zzcgs.get(cls);
    }

    public final Bundle getNetworkExtrasBundle(Class<? extends MediationExtrasReceiver> cls) {
        return this.zzcgn.getBundle(cls.getName());
    }

    public final String getPublisherProvidedId() {
        return this.zzcek;
    }

    @Deprecated
    public final boolean isDesignedForFamilies() {
        return this.zzces;
    }

    public final boolean isTestDevice(Context context) {
        RequestConfiguration requestConfiguration = zzxw.zzqq().getRequestConfiguration();
        zzvj.zzpr();
        String zzbk = zzazm.zzbk(context);
        return this.zzcgu.contains(zzbk) || requestConfiguration.getTestDeviceIds().contains(zzbk);
    }

    public final List<String> zzqh() {
        return new ArrayList(this.zzcet);
    }

    public final String zzqi() {
        return this.zzceq;
    }

    public final SearchAdRequest zzqj() {
        return this.zzcgt;
    }

    public final Map<Class<? extends NetworkExtras>, NetworkExtras> zzqk() {
        return this.zzcgs;
    }

    public final Bundle zzql() {
        return this.zzcgn;
    }

    public final int zzqm() {
        return this.zzacq;
    }

    public final Set<String> zzqn() {
        return this.zzcgv;
    }

    @Nullable
    public final AdInfo zzqo() {
        return this.zzcgr;
    }

    public final int zzqp() {
        return this.zzacr;
    }
}
