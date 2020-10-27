package com.google.android.gms.tagmanager;

import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.gtm.zza;
import com.google.android.gms.internal.gtm.zzl;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

@ShowFirstParty
@VisibleForTesting
public final class zzdd extends zzbq {

    /* renamed from: ID */
    private static final String f973ID = zza.LANGUAGE.toString();

    public zzdd() {
        super(f973ID, new String[0]);
    }

    public final zzl zzb(Map<String, zzl> map) {
        Locale locale = Locale.getDefault();
        if (locale == null) {
            return zzgj.zzkc();
        }
        String language = locale.getLanguage();
        return language == null ? zzgj.zzkc() : zzgj.zzi(language.toLowerCase());
    }

    public final boolean zzgw() {
        return false;
    }

    public final /* bridge */ /* synthetic */ String zzif() {
        return super.zzif();
    }

    public final /* bridge */ /* synthetic */ Set zzig() {
        return super.zzig();
    }
}
