// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import java.util.Iterator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzbo;
import android.os.Bundle;

public final class zzceu
{
    final String mAppId;
    final String mName;
    private String mOrigin;
    final long zzayS;
    final long zzbpE;
    final zzcew zzbpF;
    
    zzceu(final zzcgl zzcgl, final String s, final String mAppId, String s2, final long zzayS, final long zzbpE, final Bundle bundle) {
        zzbo.zzcF(mAppId);
        zzbo.zzcF(s2);
        this.mAppId = mAppId;
        this.mName = s2;
        s2 = s;
        if (TextUtils.isEmpty((CharSequence)s)) {
            s2 = null;
        }
        this.mOrigin = s2;
        this.zzayS = zzayS;
        this.zzbpE = zzbpE;
        if (this.zzbpE != 0L && this.zzbpE > this.zzayS) {
            zzcgl.zzwF().zzyz().zzj("Event created with reverse previous/current timestamps. appId", zzcfl.zzdZ(mAppId));
        }
        this.zzbpF = zza(zzcgl, bundle);
    }
    
    private zzceu(final zzcgl zzcgl, final String s, final String mAppId, String s2, final long zzayS, final long zzbpE, final zzcew zzbpF) {
        zzbo.zzcF(mAppId);
        zzbo.zzcF(s2);
        zzbo.zzu(zzbpF);
        this.mAppId = mAppId;
        this.mName = s2;
        s2 = s;
        if (TextUtils.isEmpty((CharSequence)s)) {
            s2 = null;
        }
        this.mOrigin = s2;
        this.zzayS = zzayS;
        this.zzbpE = zzbpE;
        if (this.zzbpE != 0L && this.zzbpE > this.zzayS) {
            zzcgl.zzwF().zzyz().zzj("Event created with reverse previous/current timestamps. appId", zzcfl.zzdZ(mAppId));
        }
        this.zzbpF = zzbpF;
    }
    
    private static zzcew zza(final zzcgl zzcgl, Bundle bundle) {
        if (bundle != null && !bundle.isEmpty()) {
            bundle = new Bundle(bundle);
            final Iterator<String> iterator = (Iterator<String>)bundle.keySet().iterator();
            while (iterator.hasNext()) {
                final String s = iterator.next();
                if (s == null) {
                    zzcgl.zzwF().zzyx().log("Param name can't be null");
                    iterator.remove();
                }
                else {
                    final Object zzk = zzcgl.zzwB().zzk(s, bundle.get(s));
                    if (zzk == null) {
                        zzcgl.zzwF().zzyz().zzj("Param value can't be null", zzcgl.zzwA().zzdX(s));
                        iterator.remove();
                    }
                    else {
                        zzcgl.zzwB().zza(bundle, s, zzk);
                    }
                }
            }
            return new zzcew(bundle);
        }
        return new zzcew(new Bundle());
    }
    
    @Override
    public final String toString() {
        final String mAppId = this.mAppId;
        final String mName = this.mName;
        final String value = String.valueOf(this.zzbpF);
        return new StringBuilder(String.valueOf(mAppId).length() + 33 + String.valueOf(mName).length() + String.valueOf(value).length()).append("Event{appId='").append(mAppId).append("', name='").append(mName).append("', params=").append(value).append("}").toString();
    }
    
    final zzceu zza(final zzcgl zzcgl, final long n) {
        return new zzceu(zzcgl, this.mOrigin, this.mAppId, this.mName, this.zzayS, n, this.zzbpF);
    }
}
