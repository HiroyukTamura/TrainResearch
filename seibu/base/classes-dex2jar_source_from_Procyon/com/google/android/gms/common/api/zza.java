// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.api;

import com.google.android.gms.common.internal.zzbo;
import java.util.Iterator;
import android.text.TextUtils;
import java.util.ArrayList;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.internal.zzbat;
import android.support.v4.util.ArrayMap;

public final class zza extends Exception
{
    private final ArrayMap<zzbat<?>, ConnectionResult> zzaAB;
    
    public zza(final ArrayMap<zzbat<?>, ConnectionResult> zzaAB) {
        this.zzaAB = zzaAB;
    }
    
    @Override
    public final String getMessage() {
        final ArrayList<String> list = new ArrayList<String>();
        final Iterator<zzbat<?>> iterator = this.zzaAB.keySet().iterator();
        boolean b = true;
        while (iterator.hasNext()) {
            final zzbat<?> zzbat = iterator.next();
            final ConnectionResult obj = this.zzaAB.get(zzbat);
            if (obj.isSuccess()) {
                b = false;
            }
            final String value = String.valueOf(zzbat.zzpr());
            final String value2 = String.valueOf(obj);
            list.add(new StringBuilder(String.valueOf(value).length() + 2 + String.valueOf(value2).length()).append(value).append(": ").append(value2).toString());
        }
        final StringBuilder sb = new StringBuilder();
        if (b) {
            sb.append("None of the queried APIs are available. ");
        }
        else {
            sb.append("Some of the queried APIs are unavailable. ");
        }
        sb.append(TextUtils.join((CharSequence)"; ", (Iterable)list));
        return sb.toString();
    }
    
    public final ConnectionResult zza(final GoogleApi<? extends Api.ApiOptions> googleApi) {
        final zzbat<? extends Api.ApiOptions> zzph = googleApi.zzph();
        zzbo.zzb(this.zzaAB.get(zzph) != null, (Object)"The given API was not part of the availability request.");
        return (ConnectionResult)this.zzaAB.get(zzph);
    }
    
    public final ArrayMap<zzbat<?>, ConnectionResult> zzpf() {
        return this.zzaAB;
    }
}
