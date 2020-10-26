// 
// Decompiled by Procyon v0.5.36
// 

package com.google.firebase.iid;

import android.content.Intent;
import android.util.Log;
import java.io.IOException;
import android.os.Looper;
import android.os.Bundle;
import android.support.v4.util.ArrayMap;
import java.security.KeyPair;
import android.content.Context;
import java.util.Map;

public final class zzj
{
    private static Map<String, zzj> zzbgQ;
    static String zzbgW;
    private static zzr zzckF;
    private static zzl zzckG;
    private Context mContext;
    private KeyPair zzbgT;
    private String zzbgU;
    
    static {
        zzj.zzbgQ = new ArrayMap<String, zzj>();
    }
    
    private zzj(final Context context, final String zzbgU, final Bundle bundle) {
        this.zzbgU = "";
        this.mContext = context.getApplicationContext();
        this.zzbgU = zzbgU;
    }
    
    public static zzr zzJT() {
        return zzj.zzckF;
    }
    
    public static zzl zzJU() {
        return zzj.zzckG;
    }
    
    public static zzj zzb(final Context context, final Bundle bundle) {
        // monitorenter(zzj.class)
        while (true) {
            String string = null;
            Label_0126: {
                if (bundle == null) {
                    string = "";
                    break Label_0126;
                }
                while (true) {
                    Label_0107: {
                        break Label_0107;
                        try {
                            final Context applicationContext = context.getApplicationContext();
                            if (zzj.zzckF == null) {
                                zzj.zzckF = new zzr(applicationContext);
                                zzj.zzckG = new zzl(applicationContext);
                            }
                            zzj.zzbgW = Integer.toString(FirebaseInstanceId.zzbF(applicationContext));
                            zzj zzj;
                            if ((zzj = com.google.firebase.iid.zzj.zzbgQ.get(string)) == null) {
                                zzj = new zzj(applicationContext, string, bundle);
                                com.google.firebase.iid.zzj.zzbgQ.put(string, zzj);
                            }
                            return zzj;
                            string = bundle.getString("subtype");
                            break Label_0126;
                        }
                        finally {
                        }
                        // monitorexit(zzj.class)
                    }
                    continue;
                }
            }
            if (string == null) {
                string = "";
            }
            continue;
        }
    }
    
    public final long getCreationTime() {
        return zzj.zzckF.zzhk(this.zzbgU);
    }
    
    public final String getToken(final String s, final String s2, final Bundle bundle) throws IOException {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IOException("MAIN_THREAD");
        }
        final int n = 1;
        int n2;
        if (bundle.getString("ttl") != null || "jwt".equals(bundle.getString("type"))) {
            n2 = 0;
        }
        else {
            final zzs zzp = zzj.zzckF.zzp(this.zzbgU, s, s2);
            n2 = n;
            if (zzp != null) {
                n2 = n;
                if (!zzp.zzhp(zzj.zzbgW)) {
                    return zzp.zzbPJ;
                }
            }
        }
        final String zzc = this.zzc(s, s2, bundle);
        if (zzc != null && n2 != 0) {
            zzj.zzckF.zza(this.zzbgU, s, s2, zzc, zzj.zzbgW);
        }
        return zzc;
    }
    
    public final void zzb(final String s, final String s2, final Bundle bundle) throws IOException {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IOException("MAIN_THREAD");
        }
        zzj.zzckF.zzg(this.zzbgU, s, s2);
        Bundle bundle2;
        if ((bundle2 = bundle) == null) {
            bundle2 = new Bundle();
        }
        bundle2.putString("delete", "1");
        this.zzc(s, s2, bundle2);
    }
    
    public final String zzc(String obj, String stringExtra, final Bundle bundle) throws IOException {
        if (stringExtra != null) {
            bundle.putString("scope", stringExtra);
        }
        bundle.putString("sender", obj);
        if (!"".equals(this.zzbgU)) {
            obj = this.zzbgU;
        }
        bundle.putString("subtype", obj);
        bundle.putString("X-subtype", obj);
        final Intent zza = zzj.zzckG.zza(bundle, this.zzvK());
        if (zza == null) {
            throw new IOException("SERVICE_NOT_AVAILABLE");
        }
        stringExtra = zza.getStringExtra("registration_id");
        if ((obj = stringExtra) == null) {
            obj = zza.getStringExtra("unregistered");
        }
        if (obj != null) {
            return obj;
        }
        obj = zza.getStringExtra("error");
        if (obj != null) {
            throw new IOException(obj);
        }
        obj = String.valueOf(zza.getExtras());
        Log.w("InstanceID/Rpc", new StringBuilder(String.valueOf(obj).length() + 29).append("Unexpected response from GCM ").append(obj).toString(), new Throwable());
        throw new IOException("SERVICE_NOT_AVAILABLE");
    }
    
    final KeyPair zzvK() {
        if (this.zzbgT == null) {
            this.zzbgT = zzj.zzckF.zzhn(this.zzbgU);
        }
        if (this.zzbgT == null) {
            this.zzbgT = zzj.zzckF.zzhl(this.zzbgU);
        }
        return this.zzbgT;
    }
    
    public final void zzvL() {
        zzj.zzckF.zzhm(this.zzbgU);
        this.zzbgT = null;
    }
}
