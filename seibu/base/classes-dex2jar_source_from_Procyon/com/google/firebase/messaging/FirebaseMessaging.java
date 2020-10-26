// 
// Decompiled by Procyon v0.5.36
// 

package com.google.firebase.messaging;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.google.firebase.iid.zzl;
import com.google.firebase.FirebaseApp;
import android.text.TextUtils;
import com.google.firebase.iid.FirebaseInstanceId;
import java.util.regex.Pattern;

public class FirebaseMessaging
{
    public static final String INSTANCE_ID_SCOPE = "FCM";
    private static final Pattern zzckW;
    private static FirebaseMessaging zzckX;
    private final FirebaseInstanceId zzcku;
    
    static {
        zzckW = Pattern.compile("[a-zA-Z0-9-_.~%]{1,900}");
    }
    
    private FirebaseMessaging(final FirebaseInstanceId zzcku) {
        this.zzcku = zzcku;
    }
    
    public static FirebaseMessaging getInstance() {
        synchronized (FirebaseMessaging.class) {
            if (FirebaseMessaging.zzckX == null) {
                FirebaseMessaging.zzckX = new FirebaseMessaging(FirebaseInstanceId.getInstance());
            }
            return FirebaseMessaging.zzckX;
        }
    }
    
    public void send(final RemoteMessage remoteMessage) {
        if (TextUtils.isEmpty((CharSequence)remoteMessage.getTo())) {
            throw new IllegalArgumentException("Missing 'to'");
        }
        final Context applicationContext = FirebaseApp.getInstance().getApplicationContext();
        final String zzbd = zzl.zzbd(applicationContext);
        if (zzbd == null) {
            Log.e("FirebaseMessaging", "Google Play services package is missing. Impossible to send message");
            return;
        }
        final Intent intent = new Intent("com.google.android.gcm.intent.SEND");
        zzl.zzd(applicationContext, intent);
        intent.setPackage(zzbd);
        intent.putExtras(remoteMessage.mBundle);
        applicationContext.sendOrderedBroadcast(intent, "com.google.android.gtalkservice.permission.GTALK_SERVICE");
    }
    
    public void subscribeToTopic(String original) {
        String substring = original;
        if (original != null) {
            substring = original;
            if (original.startsWith("/topics/")) {
                Log.w("FirebaseMessaging", "Format /topics/topic-name is deprecated. Only 'topic-name' should be used in subscribeToTopic.");
                substring = original.substring(8);
            }
        }
        if (substring == null || !FirebaseMessaging.zzckW.matcher(substring).matches()) {
            original = String.valueOf("[a-zA-Z0-9-_.~%]{1,900}");
            throw new IllegalArgumentException(new StringBuilder(String.valueOf(substring).length() + 55 + String.valueOf(original).length()).append("Invalid topic name: ").append(substring).append(" does not match the allowed format ").append(original).toString());
        }
        final FirebaseInstanceId zzcku = this.zzcku;
        original = String.valueOf("S!");
        final String value = String.valueOf(substring);
        if (value.length() != 0) {
            original = original.concat(value);
        }
        else {
            original = new String(original);
        }
        zzcku.zzhf(original);
    }
    
    public void unsubscribeFromTopic(String original) {
        String substring = original;
        if (original != null) {
            substring = original;
            if (original.startsWith("/topics/")) {
                Log.w("FirebaseMessaging", "Format /topics/topic-name is deprecated. Only 'topic-name' should be used in unsubscribeFromTopic.");
                substring = original.substring(8);
            }
        }
        if (substring == null || !FirebaseMessaging.zzckW.matcher(substring).matches()) {
            original = String.valueOf("[a-zA-Z0-9-_.~%]{1,900}");
            throw new IllegalArgumentException(new StringBuilder(String.valueOf(substring).length() + 55 + String.valueOf(original).length()).append("Invalid topic name: ").append(substring).append(" does not match the allowed format ").append(original).toString());
        }
        final FirebaseInstanceId zzcku = this.zzcku;
        original = String.valueOf("U!");
        final String value = String.valueOf(substring);
        if (value.length() != 0) {
            original = original.concat(value);
        }
        else {
            original = new String(original);
        }
        zzcku.zzhf(original);
    }
}
