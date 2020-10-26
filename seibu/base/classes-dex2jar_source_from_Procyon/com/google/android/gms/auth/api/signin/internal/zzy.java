// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.auth.api.signin.internal;

import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import org.json.JSONException;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.zzbo;
import android.content.Context;
import java.util.concurrent.locks.ReentrantLock;
import android.content.SharedPreferences;
import java.util.concurrent.locks.Lock;

public final class zzy
{
    private static final Lock zzamD;
    private static zzy zzamE;
    private final Lock zzamF;
    private final SharedPreferences zzamG;
    
    static {
        zzamD = new ReentrantLock();
    }
    
    private zzy(final Context context) {
        this.zzamF = new ReentrantLock();
        this.zzamG = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }
    
    public static zzy zzaj(final Context context) {
        zzbo.zzu(context);
        zzy.zzamD.lock();
        try {
            if (zzy.zzamE == null) {
                zzy.zzamE = new zzy(context.getApplicationContext());
            }
            return zzy.zzamE;
        }
        finally {
            zzy.zzamD.unlock();
        }
    }
    
    private final GoogleSignInAccount zzbS(String zzbU) {
        if (!TextUtils.isEmpty((CharSequence)zzbU)) {
            zzbU = this.zzbU(zzs("googleSignInAccount", zzbU));
            if (zzbU != null) {
                try {
                    return GoogleSignInAccount.zzbP(zzbU);
                }
                catch (JSONException ex) {
                    return null;
                }
            }
        }
        return null;
    }
    
    private final GoogleSignInOptions zzbT(String zzbU) {
        if (!TextUtils.isEmpty((CharSequence)zzbU)) {
            zzbU = this.zzbU(zzs("googleSignInOptions", zzbU));
            if (zzbU != null) {
                try {
                    return GoogleSignInOptions.zzbQ(zzbU);
                }
                catch (JSONException ex) {
                    return null;
                }
            }
        }
        return null;
    }
    
    private final String zzbU(String string) {
        this.zzamF.lock();
        try {
            string = this.zzamG.getString(string, (String)null);
            return string;
        }
        finally {
            this.zzamF.unlock();
        }
    }
    
    private final void zzbV(final String s) {
        this.zzamF.lock();
        try {
            this.zzamG.edit().remove(s).apply();
        }
        finally {
            this.zzamF.unlock();
        }
    }
    
    private final void zzr(final String s, final String s2) {
        this.zzamF.lock();
        try {
            this.zzamG.edit().putString(s, s2).apply();
        }
        finally {
            this.zzamF.unlock();
        }
    }
    
    private static String zzs(final String s, final String s2) {
        final String value = String.valueOf(":");
        return new StringBuilder(String.valueOf(s).length() + String.valueOf(value).length() + String.valueOf(s2).length()).append(s).append(value).append(s2).toString();
    }
    
    public final void zza(final GoogleSignInAccount googleSignInAccount, final GoogleSignInOptions googleSignInOptions) {
        zzbo.zzu(googleSignInAccount);
        zzbo.zzu(googleSignInOptions);
        this.zzr("defaultGoogleSignInAccount", googleSignInAccount.zzmx());
        zzbo.zzu(googleSignInAccount);
        zzbo.zzu(googleSignInOptions);
        final String zzmx = googleSignInAccount.zzmx();
        this.zzr(zzs("googleSignInAccount", zzmx), googleSignInAccount.zzmy());
        this.zzr(zzs("googleSignInOptions", zzmx), googleSignInOptions.zzmC());
    }
    
    public final GoogleSignInAccount zzmN() {
        return this.zzbS(this.zzbU("defaultGoogleSignInAccount"));
    }
    
    public final GoogleSignInOptions zzmO() {
        return this.zzbT(this.zzbU("defaultGoogleSignInAccount"));
    }
    
    public final void zzmP() {
        final String zzbU = this.zzbU("defaultGoogleSignInAccount");
        this.zzbV("defaultGoogleSignInAccount");
        if (!TextUtils.isEmpty((CharSequence)zzbU)) {
            this.zzbV(zzs("googleSignInAccount", zzbU));
            this.zzbV(zzs("googleSignInOptions", zzbU));
        }
    }
}
