// 
// Decompiled by Procyon v0.5.36
// 

package com.google.firebase.iid;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.KeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.security.KeyFactory;
import android.util.Base64;
import java.security.KeyPair;
import java.util.Iterator;
import android.content.SharedPreferences$Editor;
import java.io.IOException;
import android.util.Log;
import java.io.File;
import com.google.android.gms.common.util.zzu;
import android.content.Context;
import android.content.SharedPreferences;

final class zzr
{
    SharedPreferences zzbho;
    private Context zzqD;
    
    public zzr(final Context context) {
        this(context, "com.google.android.gms.appid");
    }
    
    private zzr(final Context zzqD, String value) {
        this.zzqD = zzqD;
        this.zzbho = zzqD.getSharedPreferences(value, 0);
        final String value2 = String.valueOf(value);
        value = String.valueOf("-no-backup");
        Label_0097: {
            if (value.length() == 0) {
                break Label_0097;
            }
            String concat = value2.concat(value);
            while (true) {
                final File file = new File(zzu.getNoBackupFilesDir(this.zzqD), concat);
                if (file.exists()) {
                    return;
                }
                try {
                    if (file.createNewFile() && !this.isEmpty()) {
                        Log.i("InstanceID/Store", "App restored, clearing state");
                        FirebaseInstanceId.zza(this.zzqD, this);
                    }
                    return;
                    concat = new String(value2);
                    continue;
                }
                catch (IOException ex) {
                    if (Log.isLoggable("InstanceID/Store", 3)) {
                        final String value3 = String.valueOf(ex.getMessage());
                        String concat2;
                        if (value3.length() != 0) {
                            concat2 = "Error creating file in no backup dir: ".concat(value3);
                        }
                        else {
                            concat2 = new String("Error creating file in no backup dir: ");
                        }
                        Log.d("InstanceID/Store", concat2);
                    }
                }
                break;
            }
        }
    }
    
    private static String zzai(final String s, final String s2) {
        final String value = String.valueOf("|S|");
        return new StringBuilder(String.valueOf(s).length() + String.valueOf(value).length() + String.valueOf(s2).length()).append(s).append(value).append(s2).toString();
    }
    
    private final void zzdq(final String prefix) {
        final SharedPreferences$Editor edit = this.zzbho.edit();
        for (final String s : this.zzbho.getAll().keySet()) {
            if (s.startsWith(prefix)) {
                edit.remove(s);
            }
        }
        edit.commit();
    }
    
    private static String zzo(final String s, final String s2, final String s3) {
        final String value = String.valueOf("|T|");
        return new StringBuilder(String.valueOf(s).length() + 1 + String.valueOf(value).length() + String.valueOf(s2).length() + String.valueOf(s3).length()).append(s).append(value).append(s2).append("|").append(s3).toString();
    }
    
    public final boolean isEmpty() {
        synchronized (this) {
            return this.zzbho.getAll().isEmpty();
        }
    }
    
    public final void zza(final String s, final String s2, final String s3, String zzc, final String s4) {
        synchronized (this) {
            zzc = zzs.zzc(zzc, s4, System.currentTimeMillis());
            if (zzc != null) {
                final SharedPreferences$Editor edit = this.zzbho.edit();
                edit.putString(zzo(s, s2, s3), zzc);
                edit.commit();
            }
        }
    }
    
    public final void zzdr(final String obj) {
        synchronized (this) {
            this.zzdq(String.valueOf(obj).concat("|T|"));
        }
    }
    
    public final void zzg(String zzo, final String s, final String s2) {
        synchronized (this) {
            zzo = zzo(zzo, s, s2);
            final SharedPreferences$Editor edit = this.zzbho.edit();
            edit.remove(zzo);
            edit.commit();
        }
    }
    
    public final long zzhk(String s) {
        synchronized (this) {
            s = zzai(s, "cre");
            s = this.zzbho.getString(s, (String)null);
            if (s == null) {
                return 0L;
            }
            try {
                return Long.parseLong(s);
            }
            catch (NumberFormatException ex) {}
            return 0L;
        }
    }
    
    final KeyPair zzhl(final String s) {
        synchronized (this) {
            final KeyPair zzvJ = zza.zzvJ();
            final long currentTimeMillis = System.currentTimeMillis();
            final SharedPreferences$Editor edit = this.zzbho.edit();
            edit.putString(zzai(s, "|P|"), FirebaseInstanceId.zzj(zzvJ.getPublic().getEncoded()));
            edit.putString(zzai(s, "|K|"), FirebaseInstanceId.zzj(zzvJ.getPrivate().getEncoded()));
            edit.putString(zzai(s, "cre"), Long.toString(currentTimeMillis));
            edit.commit();
            return zzvJ;
        }
    }
    
    final void zzhm(final String obj) {
        synchronized (this) {
            this.zzdq(String.valueOf(obj).concat("|"));
        }
    }
    
    public final KeyPair zzhn(String decode) {
        // monitorenter(this)
        try {
            final String string = this.zzbho.getString(zzai((String)decode, "|P|"), (String)null);
            final String string2 = this.zzbho.getString(zzai((String)decode, "|K|"), (String)null);
            if (string == null || string2 == null) {
                decode = null;
            }
            else {
                try {
                    decode = (NoSuchAlgorithmException)(Object)Base64.decode(string, 8);
                    final byte[] decode2 = Base64.decode(string2, 8);
                    final KeyFactory instance = KeyFactory.getInstance("RSA");
                    decode = (NoSuchAlgorithmException)new KeyPair(instance.generatePublic(new X509EncodedKeySpec((byte[])(Object)decode)), instance.generatePrivate(new PKCS8EncodedKeySpec(decode2)));
                }
                catch (InvalidKeySpecException ex) {}
                catch (NoSuchAlgorithmException decode) {}
            }
            return (KeyPair)decode;
        }
        finally {}
    }
    
    public final zzs zzp(final String s, final String s2, final String s3) {
        synchronized (this) {
            return zzs.zzho(this.zzbho.getString(zzo(s, s2, s3), (String)null));
        }
    }
    
    public final void zzvP() {
        synchronized (this) {
            this.zzbho.edit().clear().commit();
        }
    }
}
