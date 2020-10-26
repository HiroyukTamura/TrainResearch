// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.analytics;

import android.content.Intent;
import android.app.Activity;
import android.net.Uri;
import com.google.android.gms.internal.zzaos;
import java.util.Locale;
import android.text.TextUtils;
import com.google.android.gms.internal.zzaly;
import com.google.android.gms.internal.zzaoc;
import com.google.android.gms.internal.zzano;
import com.google.android.gms.internal.zzamu;
import java.util.Iterator;
import com.google.android.gms.common.internal.zzbo;
import com.google.android.gms.internal.zzalx;
import java.util.Random;
import java.util.HashMap;
import com.google.android.gms.internal.zzamj;
import com.google.android.gms.internal.zzaor;
import com.google.android.gms.internal.zzaoa;
import java.util.Map;
import com.google.android.gms.internal.zzamh;

public class Tracker extends zzamh
{
    private final Map<String, String> zzHa;
    private boolean zzaeo;
    private final Map<String, String> zzaep;
    private final zzaoa zzaeq;
    private final zza zzaer;
    private ExceptionReporter zzaes;
    private zzaor zzaet;
    
    Tracker(final zzamj zzamj, final String s, final zzaoa zzaoa) {
        super(zzamj);
        this.zzHa = new HashMap<String, String>();
        this.zzaep = new HashMap<String, String>();
        if (s != null) {
            this.zzHa.put("&tid", s);
        }
        this.zzHa.put("useSecure", "1");
        this.zzHa.put("&a", Integer.toString(new Random().nextInt(Integer.MAX_VALUE) + 1));
        this.zzaeq = new zzaoa("tracking", this.zzkq());
        this.zzaer = new zza(zzamj);
    }
    
    private static String zza(final Map.Entry<String, String> entry) {
        final String s = entry.getKey();
        entry.getValue();
        int n;
        if (!s.startsWith("&") || s.length() < 2) {
            n = 0;
        }
        else {
            n = 1;
        }
        if (n == 0) {
            return null;
        }
        return entry.getKey().substring(1);
    }
    
    private static void zzb(final Map<String, String> map, final Map<String, String> map2) {
        zzbo.zzu(map2);
        if (map != null) {
            for (final Map.Entry<String, String> entry : map.entrySet()) {
                final String zza = zza(entry);
                if (zza != null) {
                    map2.put(zza, entry.getValue());
                }
            }
        }
    }
    
    private static void zzc(final Map<String, String> map, final Map<String, String> map2) {
        zzbo.zzu(map2);
        if (map != null) {
            for (final Map.Entry<String, String> entry : map.entrySet()) {
                final String zza = zza(entry);
                if (zza != null && !map2.containsKey(zza)) {
                    map2.put(zza, entry.getValue());
                }
            }
        }
    }
    
    public void enableAdvertisingIdCollection(final boolean zzaeo) {
        this.zzaeo = zzaeo;
    }
    
    public void enableAutoActivityTracking(final boolean b) {
        this.zzaer.enableAutoActivityTracking(b);
    }
    
    public void enableExceptionReporting(final boolean b) {
        while (true) {
            while (true) {
                Label_0084: {
                    synchronized (this) {
                        if (this.zzaes == null) {
                            break Label_0084;
                        }
                        final boolean b2 = true;
                        if (b2 == b) {
                            return;
                        }
                        if (b) {
                            Thread.setDefaultUncaughtExceptionHandler((Thread.UncaughtExceptionHandler)(this.zzaes = new ExceptionReporter(this, Thread.getDefaultUncaughtExceptionHandler(), this.getContext())));
                            this.zzbo("Uncaught exceptions will be reported to Google Analytics");
                            return;
                        }
                    }
                    Thread.setDefaultUncaughtExceptionHandler(this.zzaes.zzjn());
                    this.zzbo("Uncaught exceptions will not be reported to Google Analytics");
                    return;
                }
                final boolean b2 = false;
                continue;
            }
        }
    }
    
    public String get(final String s) {
        this.zzkD();
        if (!TextUtils.isEmpty((CharSequence)s)) {
            if (this.zzHa.containsKey(s)) {
                return this.zzHa.get(s);
            }
            if (s.equals("&ul")) {
                return zzaos.zza(Locale.getDefault());
            }
            if (s.equals("&cid")) {
                return this.zzkz().zzli();
            }
            if (s.equals("&sr")) {
                return this.zzkC().zzlB();
            }
            if (s.equals("&aid")) {
                return this.zzkB().zzkW().zzhl();
            }
            if (s.equals("&an")) {
                return this.zzkB().zzkW().zzjG();
            }
            if (s.equals("&av")) {
                return this.zzkB().zzkW().zzjH();
            }
            if (s.equals("&aiid")) {
                return this.zzkB().zzkW().zzjI();
            }
        }
        return null;
    }
    
    public void send(final Map<String, String> map) {
        final long currentTimeMillis = this.zzkq().currentTimeMillis();
        if (this.zzku().getAppOptOut()) {
            this.zzbp("AppOptOut is set to true. Not sending Google Analytics hit");
            return;
        }
        final boolean dryRunEnabled = this.zzku().isDryRunEnabled();
        final HashMap<Object, String> hashMap = new HashMap<Object, String>();
        zzb(this.zzHa, (Map<String, String>)hashMap);
        zzb(map, (Map<String, String>)hashMap);
        final boolean zzf = zzaos.zzf(this.zzHa.get("useSecure"), true);
        zzc(this.zzaep, (Map<String, String>)hashMap);
        this.zzaep.clear();
        final String anotherString = hashMap.get("t");
        if (TextUtils.isEmpty((CharSequence)anotherString)) {
            this.zzkr().zze((Map<String, String>)hashMap, "Missing hit type parameter");
            return;
        }
        final String s = hashMap.get("tid");
        if (TextUtils.isEmpty((CharSequence)s)) {
            this.zzkr().zze((Map<String, String>)hashMap, "Missing tracking id parameter");
            return;
        }
        final boolean zzaeo = this.zzaeo;
        synchronized (this) {
            if ("screenview".equalsIgnoreCase(anotherString) || "pageview".equalsIgnoreCase(anotherString) || "appview".equalsIgnoreCase(anotherString) || TextUtils.isEmpty((CharSequence)anotherString)) {
                int i;
                if ((i = Integer.parseInt(this.zzHa.get("&a")) + 1) >= Integer.MAX_VALUE) {
                    i = 1;
                }
                this.zzHa.put("&a", Integer.toString(i));
            }
            // monitorexit(this)
            this.zzkt().zzf(new zzp(this, hashMap, zzaeo, anotherString, currentTimeMillis, dryRunEnabled, zzf, s));
        }
    }
    
    public void set(final String s, final String s2) {
        zzbo.zzb(s, "Key should be non-null");
        if (TextUtils.isEmpty((CharSequence)s)) {
            return;
        }
        this.zzHa.put(s, s2);
    }
    
    public void setAnonymizeIp(final boolean b) {
        this.set("&aip", zzaos.zzI(b));
    }
    
    public void setAppId(final String s) {
        this.set("&aid", s);
    }
    
    public void setAppInstallerId(final String s) {
        this.set("&aiid", s);
    }
    
    public void setAppName(final String s) {
        this.set("&an", s);
    }
    
    public void setAppVersion(final String s) {
        this.set("&av", s);
    }
    
    public void setCampaignParamsOnNextHit(Uri parse) {
        if (parse != null && !parse.isOpaque()) {
            final String queryParameter = parse.getQueryParameter("referrer");
            if (!TextUtils.isEmpty((CharSequence)queryParameter)) {
                final String value = String.valueOf(queryParameter);
                String concat;
                if (value.length() != 0) {
                    concat = "http://hostname/?".concat(value);
                }
                else {
                    concat = new String("http://hostname/?");
                }
                parse = Uri.parse(concat);
                final String queryParameter2 = parse.getQueryParameter("utm_id");
                if (queryParameter2 != null) {
                    this.zzaep.put("&ci", queryParameter2);
                }
                final String queryParameter3 = parse.getQueryParameter("anid");
                if (queryParameter3 != null) {
                    this.zzaep.put("&anid", queryParameter3);
                }
                final String queryParameter4 = parse.getQueryParameter("utm_campaign");
                if (queryParameter4 != null) {
                    this.zzaep.put("&cn", queryParameter4);
                }
                final String queryParameter5 = parse.getQueryParameter("utm_content");
                if (queryParameter5 != null) {
                    this.zzaep.put("&cc", queryParameter5);
                }
                final String queryParameter6 = parse.getQueryParameter("utm_medium");
                if (queryParameter6 != null) {
                    this.zzaep.put("&cm", queryParameter6);
                }
                final String queryParameter7 = parse.getQueryParameter("utm_source");
                if (queryParameter7 != null) {
                    this.zzaep.put("&cs", queryParameter7);
                }
                final String queryParameter8 = parse.getQueryParameter("utm_term");
                if (queryParameter8 != null) {
                    this.zzaep.put("&ck", queryParameter8);
                }
                final String queryParameter9 = parse.getQueryParameter("dclid");
                if (queryParameter9 != null) {
                    this.zzaep.put("&dclid", queryParameter9);
                }
                final String queryParameter10 = parse.getQueryParameter("gclid");
                if (queryParameter10 != null) {
                    this.zzaep.put("&gclid", queryParameter10);
                }
                final String queryParameter11 = parse.getQueryParameter("aclid");
                if (queryParameter11 != null) {
                    this.zzaep.put("&aclid", queryParameter11);
                }
            }
        }
    }
    
    public void setClientId(final String s) {
        this.set("&cid", s);
    }
    
    public void setEncoding(final String s) {
        this.set("&de", s);
    }
    
    public void setHostname(final String s) {
        this.set("&dh", s);
    }
    
    public void setLanguage(final String s) {
        this.set("&ul", s);
    }
    
    public void setLocation(final String s) {
        this.set("&dl", s);
    }
    
    public void setPage(final String s) {
        this.set("&dp", s);
    }
    
    public void setReferrer(final String s) {
        this.set("&dr", s);
    }
    
    public void setSampleRate(final double d) {
        this.set("&sf", Double.toString(d));
    }
    
    public void setScreenColors(final String s) {
        this.set("&sd", s);
    }
    
    public void setScreenName(final String s) {
        this.set("&cd", s);
    }
    
    public void setScreenResolution(final int i, final int j) {
        if (i < 0 && j < 0) {
            this.zzbr("Invalid width or height. The values should be non-negative.");
            return;
        }
        this.set("&sr", new StringBuilder(23).append(i).append("x").append(j).toString());
    }
    
    public void setSessionTimeout(final long n) {
        this.zzaer.setSessionTimeout(1000L * n);
    }
    
    public void setTitle(final String s) {
        this.set("&dt", s);
    }
    
    public void setUseSecure(final boolean b) {
        this.set("useSecure", zzaos.zzI(b));
    }
    
    public void setViewportSize(final String s) {
        this.set("&vp", s);
    }
    
    final void zza(final zzaor zzaet) {
        final boolean b = true;
        this.zzbo("Loading Tracker config values");
        this.zzaet = zzaet;
        int n;
        if (this.zzaet.zzado != null) {
            n = 1;
        }
        else {
            n = 0;
        }
        if (n != 0) {
            final String zzado = this.zzaet.zzado;
            this.set("&tid", zzado);
            this.zza("trackingId loaded", zzado);
        }
        int n2;
        if (this.zzaet.zzaiI >= 0.0) {
            n2 = 1;
        }
        else {
            n2 = 0;
        }
        if (n2 != 0) {
            final String string = Double.toString(this.zzaet.zzaiI);
            this.set("&sf", string);
            this.zza("Sample frequency loaded", string);
        }
        int n3;
        if (this.zzaet.zzaiJ >= 0) {
            n3 = 1;
        }
        else {
            n3 = 0;
        }
        if (n3 != 0) {
            final int zzaiJ = this.zzaet.zzaiJ;
            this.setSessionTimeout(zzaiJ);
            this.zza("Session timeout loaded", zzaiJ);
        }
        if (this.zzaet.zzaiK != -1) {
            final boolean b2 = this.zzaet.zzaiK == 1;
            this.enableAutoActivityTracking(b2);
            this.zza("Auto activity tracking loaded", b2);
        }
        if (this.zzaet.zzaiL != -1) {
            final boolean b3 = this.zzaet.zzaiL == 1;
            if (b3) {
                this.set("&aip", "1");
            }
            this.zza("Anonymize ip loaded", b3);
        }
        this.enableExceptionReporting(this.zzaet.zzaiM == 1 && b);
    }
    
    @Override
    protected final void zzjD() {
        this.zzaer.initialize();
        final String zzjG = this.zzkx().zzjG();
        if (zzjG != null) {
            this.set("&an", zzjG);
        }
        final String zzjH = this.zzkx().zzjH();
        if (zzjH != null) {
            this.set("&av", zzjH);
        }
    }
    
    final class zza extends zzamh implements GoogleAnalytics.zza
    {
        private boolean zzaeC;
        private int zzaeD;
        private long zzaeE;
        private boolean zzaeF;
        private long zzaeG;
        
        protected zza(final zzamj zzamj) {
            super(zzamj);
            this.zzaeE = -1L;
        }
        
        private final void zzjF() {
            if (this.zzaeE >= 0L || this.zzaeC) {
                this.zzku().zza((GoogleAnalytics.zza)Tracker.this.zzaer);
                return;
            }
            this.zzku().zzb((GoogleAnalytics.zza)Tracker.this.zzaer);
        }
        
        public final void enableAutoActivityTracking(final boolean zzaeC) {
            this.zzaeC = zzaeC;
            this.zzjF();
        }
        
        public final void setSessionTimeout(final long zzaeE) {
            this.zzaeE = zzaeE;
            this.zzjF();
        }
        
        @Override
        protected final void zzjD() {
        }
        
        public final boolean zzjE() {
            synchronized (this) {
                final boolean zzaeF = this.zzaeF;
                this.zzaeF = false;
                return zzaeF;
            }
        }
        
        @Override
        public final void zzl(final Activity activity) {
            if (this.zzaeD == 0) {
                int n;
                if (this.zzkq().elapsedRealtime() >= this.zzaeG + Math.max(1000L, this.zzaeE)) {
                    n = 1;
                }
                else {
                    n = 0;
                }
                if (n != 0) {
                    this.zzaeF = true;
                }
            }
            ++this.zzaeD;
            if (this.zzaeC) {
                final Intent intent = activity.getIntent();
                if (intent != null) {
                    Tracker.this.setCampaignParamsOnNextHit(intent.getData());
                }
                final HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
                hashMap.put("&t", "screenview");
                final Tracker zzaeB = Tracker.this;
                String s;
                if (Tracker.this.zzaet != null) {
                    final zzaor zzk = Tracker.this.zzaet;
                    s = activity.getClass().getCanonicalName();
                    final String s2 = zzk.zzaiN.get(s);
                    if (s2 != null) {
                        s = s2;
                    }
                }
                else {
                    s = activity.getClass().getCanonicalName();
                }
                zzaeB.set("&cd", s);
                if (TextUtils.isEmpty((CharSequence)hashMap.get("&dr"))) {
                    zzbo.zzu(activity);
                    final Intent intent2 = activity.getIntent();
                    String stringExtra;
                    if (intent2 == null) {
                        stringExtra = null;
                    }
                    else if (TextUtils.isEmpty((CharSequence)(stringExtra = intent2.getStringExtra("android.intent.extra.REFERRER_NAME")))) {
                        stringExtra = null;
                    }
                    if (!TextUtils.isEmpty((CharSequence)stringExtra)) {
                        hashMap.put("&dr", stringExtra);
                    }
                }
                Tracker.this.send((Map<String, String>)hashMap);
            }
        }
        
        @Override
        public final void zzm(final Activity activity) {
            --this.zzaeD;
            this.zzaeD = Math.max(0, this.zzaeD);
            if (this.zzaeD == 0) {
                this.zzaeG = this.zzkq().elapsedRealtime();
            }
        }
    }
}
