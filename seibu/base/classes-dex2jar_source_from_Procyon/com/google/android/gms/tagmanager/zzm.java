// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tagmanager;

import java.util.Iterator;
import android.net.Uri$Builder;
import java.util.List;
import android.net.Uri;
import com.google.android.gms.internal.zzbr;
import java.util.Map;
import java.util.HashSet;
import com.google.android.gms.internal.zzbg;
import com.google.android.gms.internal.zzbf;
import android.content.Context;
import java.util.Set;

class zzm extends zzgi
{
    private static final String ID;
    private static final String URL;
    private static final String zzbDq;
    private static final String zzbDr;
    private static String zzbDs;
    private static final Set<String> zzbDt;
    private final Context mContext;
    private final zza zzbDu;
    
    static {
        ID = zzbf.zzeG.toString();
        URL = zzbg.zzkg.toString();
        zzbDq = zzbg.zzfE.toString();
        zzbDr = zzbg.zzkf.toString();
        final String id = zzm.ID;
        zzm.zzbDs = new StringBuilder(String.valueOf(id).length() + 17).append("gtm_").append(id).append("_unrepeatable").toString();
        zzbDt = new HashSet<String>();
    }
    
    public zzm(final Context context) {
        this(context, (zza)new zzn(context));
    }
    
    private zzm(final Context mContext, final zza zzbDu) {
        super(zzm.ID, new String[] { zzm.URL });
        this.zzbDu = zzbDu;
        this.mContext = mContext;
    }
    
    private final boolean zzeW(final String s) {
        while (true) {
            boolean b = true;
            synchronized (this) {
                if (!zzm.zzbDt.contains(s)) {
                    if (!this.mContext.getSharedPreferences(zzm.zzbDs, 0).contains(s)) {
                        return false;
                    }
                    zzm.zzbDt.add(s);
                }
                return b;
            }
            b = false;
            return b;
        }
    }
    
    @Override
    public final void zzq(final Map<String, com.google.android.gms.internal.zzbr> map) {
        String zzb;
        if (map.get(zzm.zzbDr) != null) {
            zzb = zzgk.zzb(map.get(zzm.zzbDr));
        }
        else {
            zzb = null;
        }
        if (zzb == null || !this.zzeW(zzb)) {
            final Uri$Builder buildUpon = Uri.parse(zzgk.zzb(map.get(zzm.URL))).buildUpon();
            final com.google.android.gms.internal.zzbr zzbr = map.get(zzm.zzbDq);
            if (zzbr != null) {
                final Object zzg = zzgk.zzg(zzbr);
                if (!(zzg instanceof List)) {
                    final String value = String.valueOf(buildUpon.build().toString());
                    String concat;
                    if (value.length() != 0) {
                        concat = "ArbitraryPixel: additional params not a list: not sending partial hit: ".concat(value);
                    }
                    else {
                        concat = new String("ArbitraryPixel: additional params not a list: not sending partial hit: ");
                    }
                    zzdj.e(concat);
                    return;
                }
                for (final Map<Object, V> next : (List<Object>)zzg) {
                    if (!(next instanceof Map)) {
                        final String value2 = String.valueOf(buildUpon.build().toString());
                        String concat2;
                        if (value2.length() != 0) {
                            concat2 = "ArbitraryPixel: additional params contains non-map: not sending partial hit: ".concat(value2);
                        }
                        else {
                            concat2 = new String("ArbitraryPixel: additional params contains non-map: not sending partial hit: ");
                        }
                        zzdj.e(concat2);
                        return;
                    }
                    for (final Map.Entry<Object, V> entry : next.entrySet()) {
                        buildUpon.appendQueryParameter(entry.getKey().toString(), entry.getValue().toString());
                    }
                }
            }
            final String string = buildUpon.build().toString();
            this.zzbDu.zzAF().zzfh(string);
            final String value3 = String.valueOf(string);
            while (true) {
                Label_0372: {
                    if (value3.length() == 0) {
                        break Label_0372;
                    }
                    final String concat3 = "ArbitraryPixel: url = ".concat(value3);
                    zzdj.v(concat3);
                    if (zzb == null) {
                        return;
                    }
                    synchronized (zzm.class) {
                        zzm.zzbDt.add(zzb);
                        zzfu.zzd(this.mContext, zzm.zzbDs, zzb, "true");
                        return;
                    }
                }
                final String concat3 = new String("ArbitraryPixel: url = ");
                continue;
            }
        }
    }
    
    public interface zza
    {
        zzby zzAF();
    }
}
