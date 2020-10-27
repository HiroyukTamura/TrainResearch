package com.google.android.gms.internal.ads;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.search.SearchAdRequest;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

public final class zzuk {
    public static final zzuk zzcev = new zzuk();

    @VisibleForTesting
    protected zzuk() {
    }

    public static zzast zza(Context context, zzxt zzxt, String str) {
        return new zzast(zza(context, zzxt), str);
    }

    public static zzuj zza(Context context, zzxt zzxt) {
        List list;
        Context context2;
        zzud zzud;
        String str;
        zzxt zzxt2 = zzxt;
        Date birthday = zzxt.getBirthday();
        long time = birthday != null ? birthday.getTime() : -1;
        String contentUrl = zzxt.getContentUrl();
        int gender = zzxt.getGender();
        Set<String> keywords = zzxt.getKeywords();
        if (!keywords.isEmpty()) {
            list = Collections.unmodifiableList(new ArrayList(keywords));
            context2 = context;
        } else {
            context2 = context;
            list = null;
        }
        boolean isTestDevice = zzxt2.isTestDevice(context2);
        Location location = zzxt.getLocation();
        Bundle networkExtrasBundle = zzxt2.getNetworkExtrasBundle(AdMobAdapter.class);
        if (zzxt.zzqo() != null) {
            zzud = new zzud(zzxt.zzqo().getAdString(), zzvj.zzpz().containsKey(zzxt.zzqo().getQueryInfo()) ? zzvj.zzpz().get(zzxt.zzqo().getQueryInfo()) : "");
        } else {
            zzud = null;
        }
        boolean manualImpressionsEnabled = zzxt.getManualImpressionsEnabled();
        String publisherProvidedId = zzxt.getPublisherProvidedId();
        SearchAdRequest zzqj = zzxt.zzqj();
        zzza zzza = zzqj != null ? new zzza(zzqj) : null;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            String packageName = applicationContext.getPackageName();
            zzvj.zzpr();
            str = zzazm.zza(Thread.currentThread().getStackTrace(), packageName);
        } else {
            str = null;
        }
        boolean isDesignedForFamilies = zzxt.isDesignedForFamilies();
        RequestConfiguration requestConfiguration = zzxw.zzqq().getRequestConfiguration();
        return new zzuj(8, time, networkExtrasBundle, gender, list, isTestDevice, Math.max(zzxt.zzqm(), requestConfiguration.getTagForChildDirectedTreatment()), manualImpressionsEnabled, publisherProvidedId, zzza, location, contentUrl, zzxt.zzql(), zzxt.getCustomTargeting(), Collections.unmodifiableList(new ArrayList(zzxt.zzqn())), zzxt.zzqi(), str, isDesignedForFamilies, zzud, Math.max(zzxt.zzqp(), requestConfiguration.getTagForUnderAgeOfConsent()), (String) Collections.max(Arrays.asList(new String[]{zzxt.getMaxAdContentRating(), requestConfiguration.getMaxAdContentRating()}), zzun.zzcfe), zzxt.zzqh());
    }

    static final /* synthetic */ int zzd(String str, String str2) {
        return RequestConfiguration.zzacu.indexOf(str) - RequestConfiguration.zzacu.indexOf(str2);
    }
}
