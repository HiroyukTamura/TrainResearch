// 
// Decompiled by Procyon v0.5.36
// 

package com.google.firebase.iid;

import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import java.io.IOException;
import android.content.Intent;
import java.security.NoSuchAlgorithmException;
import android.util.Base64;
import java.security.MessageDigest;
import java.security.KeyPair;
import android.content.pm.PackageManager$NameNotFoundException;
import android.util.Log;
import android.content.Context;
import android.support.annotation.Keep;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.util.ArrayMap;
import com.google.firebase.FirebaseApp;
import java.util.Map;

public class FirebaseInstanceId
{
    private static Map<String, FirebaseInstanceId> zzbgQ;
    private static zzk zzckv;
    private final FirebaseApp zzckw;
    private final zzj zzckx;
    private final String zzcky;
    
    static {
        FirebaseInstanceId.zzbgQ = new ArrayMap<String, FirebaseInstanceId>();
    }
    
    private FirebaseInstanceId(final FirebaseApp zzckw, final zzj zzckx) {
        this.zzckw = zzckw;
        this.zzckx = zzckx;
        String zzcky = this.zzckw.getOptions().getGcmSenderId();
        if (zzcky == null) {
            final String s = zzcky = this.zzckw.getOptions().getApplicationId();
            if (s.startsWith("1:")) {
                final String[] split = s.split(":");
                if (split.length < 2) {
                    zzcky = null;
                }
                else if ((zzcky = split[1]).isEmpty()) {
                    zzcky = null;
                }
            }
        }
        this.zzcky = zzcky;
        if (this.zzcky == null) {
            throw new IllegalStateException("IID failing to initialize, FirebaseApp is missing project ID");
        }
        FirebaseInstanceIdService.zza(this.zzckw.getApplicationContext(), this);
    }
    
    public static FirebaseInstanceId getInstance() {
        return getInstance(FirebaseApp.getInstance());
    }
    
    @Keep
    public static FirebaseInstanceId getInstance(@NonNull final FirebaseApp firebaseApp) {
        synchronized (FirebaseInstanceId.class) {
            FirebaseInstanceId firebaseInstanceId;
            if ((firebaseInstanceId = FirebaseInstanceId.zzbgQ.get(firebaseApp.getOptions().getApplicationId())) == null) {
                final zzj zzb = zzj.zzb(firebaseApp.getApplicationContext(), null);
                if (FirebaseInstanceId.zzckv == null) {
                    FirebaseInstanceId.zzckv = new zzk(zzj.zzJT());
                }
                firebaseInstanceId = new FirebaseInstanceId(firebaseApp, zzb);
                FirebaseInstanceId.zzbgQ.put(firebaseApp.getOptions().getApplicationId(), firebaseInstanceId);
            }
            return firebaseInstanceId;
        }
    }
    
    private final void zzF(final Bundle bundle) {
        bundle.putString("gmp_app_id", this.zzckw.getOptions().getApplicationId());
    }
    
    static zzk zzJS() {
        return FirebaseInstanceId.zzckv;
    }
    
    static int zzO(final Context context, final String s) {
        try {
            return context.getPackageManager().getPackageInfo(s, 0).versionCode;
        }
        catch (PackageManager$NameNotFoundException obj) {
            final String value = String.valueOf(obj);
            Log.w("FirebaseInstanceId", new StringBuilder(String.valueOf(value).length() + 23).append("Failed to find package ").append(value).toString());
            return 0;
        }
    }
    
    static String zza(final KeyPair keyPair) {
        final byte[] encoded = keyPair.getPublic().getEncoded();
        try {
            final byte[] digest = MessageDigest.getInstance("SHA1").digest(encoded);
            digest[0] = (byte)((digest[0] & 0xF) + 112);
            return Base64.encodeToString(digest, 0, 8, 11);
        }
        catch (NoSuchAlgorithmException ex) {
            Log.w("FirebaseInstanceId", "Unexpected error, device missing required alghorithms");
            return null;
        }
    }
    
    static void zza(final Context context, final zzr zzr) {
        zzr.zzvP();
        final Intent intent = new Intent();
        intent.putExtra("CMD", "RST");
        zzq.zzJX().zze(context, intent);
    }
    
    static int zzbF(final Context context) {
        return zzO(context, context.getPackageName());
    }
    
    static void zzbG(final Context context) {
        final Intent intent = new Intent();
        intent.putExtra("CMD", "SYNC");
        zzq.zzJX().zze(context, intent);
    }
    
    static String zzbb(final Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        }
        catch (PackageManager$NameNotFoundException obj) {
            final String value = String.valueOf(obj);
            Log.w("FirebaseInstanceId", new StringBuilder(String.valueOf(value).length() + 38).append("Never happens: can't find own package ").append(value).toString());
            return null;
        }
    }
    
    static String zzj(final byte[] array) {
        return Base64.encodeToString(array, 11);
    }
    
    public void deleteInstanceId() throws IOException {
        this.zzckx.zzb("*", "*", null);
        this.zzckx.zzvL();
    }
    
    @WorkerThread
    public void deleteToken(final String s, final String s2) throws IOException {
        final Bundle bundle = new Bundle();
        this.zzF(bundle);
        this.zzckx.zzb(s, s2, bundle);
    }
    
    public long getCreationTime() {
        return this.zzckx.getCreationTime();
    }
    
    public String getId() {
        return zza(this.zzckx.zzvK());
    }
    
    @Nullable
    public String getToken() {
        final zzs zzJQ = this.zzJQ();
        if (zzJQ == null || zzJQ.zzhp(zzj.zzbgW)) {
            FirebaseInstanceIdService.zzbI(this.zzckw.getApplicationContext());
        }
        if (zzJQ != null) {
            return zzJQ.zzbPJ;
        }
        return null;
    }
    
    @WorkerThread
    public String getToken(final String s, final String s2) throws IOException {
        final Bundle bundle = new Bundle();
        this.zzF(bundle);
        return this.zzckx.getToken(s, s2, bundle);
    }
    
    @Nullable
    final zzs zzJQ() {
        return zzj.zzJT().zzp("", this.zzcky, "*");
    }
    
    final String zzJR() throws IOException {
        return this.getToken(this.zzcky, "*");
    }
    
    public final void zzhf(final String s) {
        FirebaseInstanceId.zzckv.zzhf(s);
        FirebaseInstanceIdService.zzbI(this.zzckw.getApplicationContext());
    }
    
    final void zzhg(String str) throws IOException {
        final zzs zzJQ = this.zzJQ();
        if (zzJQ == null || zzJQ.zzhp(zzj.zzbgW)) {
            throw new IOException("token not available");
        }
        final Bundle bundle = new Bundle();
        final String value = String.valueOf("/topics/");
        final String value2 = String.valueOf(str);
        String concat;
        if (value2.length() != 0) {
            concat = value.concat(value2);
        }
        else {
            concat = new String(value);
        }
        bundle.putString("gcm.topic", concat);
        final String zzbPJ = zzJQ.zzbPJ;
        final String value3 = String.valueOf("/topics/");
        str = String.valueOf(str);
        if (str.length() != 0) {
            str = value3.concat(str);
        }
        else {
            str = new String(value3);
        }
        this.zzF(bundle);
        this.zzckx.zzc(zzbPJ, str, bundle);
    }
    
    final void zzhh(String str) throws IOException {
        final zzs zzJQ = this.zzJQ();
        if (zzJQ == null || zzJQ.zzhp(zzj.zzbgW)) {
            throw new IOException("token not available");
        }
        final Bundle bundle = new Bundle();
        final String value = String.valueOf("/topics/");
        final String value2 = String.valueOf(str);
        String concat;
        if (value2.length() != 0) {
            concat = value.concat(value2);
        }
        else {
            concat = new String(value);
        }
        bundle.putString("gcm.topic", concat);
        final zzj zzckx = this.zzckx;
        final String zzbPJ = zzJQ.zzbPJ;
        final String value3 = String.valueOf("/topics/");
        str = String.valueOf(str);
        if (str.length() != 0) {
            str = value3.concat(str);
        }
        else {
            str = new String(value3);
        }
        zzckx.zzb(zzbPJ, str, bundle);
    }
}
