// 
// Decompiled by Procyon v0.5.36
// 

package com.google.firebase.messaging;

import android.app.PendingIntent$CanceledException;
import android.app.PendingIntent;
import com.google.firebase.iid.zzq;
import android.support.annotation.WorkerThread;
import android.content.Context;
import android.util.Log;
import android.content.Intent;
import java.util.Iterator;
import android.os.Bundle;
import com.google.firebase.iid.zzb;

public class FirebaseMessagingService extends zzb
{
    static boolean zzJ(final Bundle bundle) {
        return bundle != null && "1".equals(bundle.getString("google.c.a.e"));
    }
    
    static void zzt(final Bundle bundle) {
        final Iterator<String> iterator = (Iterator<String>)bundle.keySet().iterator();
        while (iterator.hasNext()) {
            final String s = iterator.next();
            if (s != null && s.startsWith("google.c.")) {
                iterator.remove();
            }
        }
    }
    
    @Override
    public void handleIntent(final Intent intent) {
        final int n = 0;
        String action;
        if ((action = intent.getAction()) == null) {
            action = "";
        }
        int n2 = 0;
        Label_0054: {
            switch (action.hashCode()) {
                case 366519424: {
                    if (action.equals("com.google.android.c2dm.intent.RECEIVE")) {
                        n2 = 0;
                        break Label_0054;
                    }
                    break;
                }
                case 75300319: {
                    if (action.equals("com.google.firebase.messaging.NOTIFICATION_DISMISS")) {
                        n2 = 1;
                        break Label_0054;
                    }
                    break;
                }
            }
            n2 = -1;
        }
        Label_0105: {
            switch (n2) {
                default: {
                    final String value = String.valueOf(intent.getAction());
                    String concat;
                    if (value.length() != 0) {
                        concat = "Unknown intent action: ".concat(value);
                    }
                    else {
                        concat = new String("Unknown intent action: ");
                    }
                    Log.d("FirebaseMessaging", concat);
                    break;
                }
                case 0: {
                    String stringExtra;
                    if ((stringExtra = intent.getStringExtra("message_type")) == null) {
                        stringExtra = "gcm";
                    }
                    int n3 = 0;
                    Label_0206: {
                        switch (stringExtra.hashCode()) {
                            case 102161: {
                                if (stringExtra.equals("gcm")) {
                                    n3 = n;
                                    break Label_0206;
                                }
                                break;
                            }
                            case -2062414158: {
                                if (stringExtra.equals("deleted_messages")) {
                                    n3 = 1;
                                    break Label_0206;
                                }
                                break;
                            }
                            case 814800675: {
                                if (stringExtra.equals("send_event")) {
                                    n3 = 2;
                                    break Label_0206;
                                }
                                break;
                            }
                            case 814694033: {
                                if (stringExtra.equals("send_error")) {
                                    n3 = 3;
                                    break Label_0206;
                                }
                                break;
                            }
                        }
                        n3 = -1;
                    }
                    switch (n3) {
                        default: {
                            final String value2 = String.valueOf(stringExtra);
                            String concat2;
                            if (value2.length() != 0) {
                                concat2 = "Received message with unknown type: ".concat(value2);
                            }
                            else {
                                concat2 = new String("Received message with unknown type: ");
                            }
                            Log.w("FirebaseMessaging", concat2);
                            return;
                        }
                        case 0: {
                            if (zzJ(intent.getExtras())) {
                                zzd.zzg((Context)this, intent);
                            }
                            Bundle extras;
                            if ((extras = intent.getExtras()) == null) {
                                extras = new Bundle();
                            }
                            extras.remove("android.support.content.wakelockid");
                            if (zza.zzG(extras)) {
                                if (zza.zzbM((Context)this).zzv(extras)) {
                                    break Label_0105;
                                }
                                if (zzJ(extras)) {
                                    zzd.zzj((Context)this, intent);
                                }
                            }
                            this.onMessageReceived(new RemoteMessage(extras));
                            return;
                        }
                        case 1: {
                            this.onDeletedMessages();
                            return;
                        }
                        case 2: {
                            this.onMessageSent(intent.getStringExtra("google.message_id"));
                            return;
                        }
                        case 3: {
                            String s;
                            if ((s = intent.getStringExtra("google.message_id")) == null) {
                                s = intent.getStringExtra("message_id");
                            }
                            this.onSendError(s, new SendException(intent.getStringExtra("error")));
                            return;
                        }
                    }
                    break;
                }
                case 1: {
                    if (zzJ(intent.getExtras())) {
                        zzd.zzi((Context)this, intent);
                        return;
                    }
                    break;
                }
            }
        }
    }
    
    @WorkerThread
    public void onDeletedMessages() {
    }
    
    @WorkerThread
    public void onMessageReceived(final RemoteMessage remoteMessage) {
    }
    
    @WorkerThread
    public void onMessageSent(final String s) {
    }
    
    @WorkerThread
    public void onSendError(final String s, final Exception ex) {
    }
    
    @Override
    protected final Intent zzn(final Intent intent) {
        return zzq.zzJX().zzJY();
    }
    
    @Override
    public final boolean zzo(final Intent intent) {
        if ("com.google.firebase.messaging.NOTIFICATION_OPEN".equals(intent.getAction())) {
            final PendingIntent pendingIntent = (PendingIntent)intent.getParcelableExtra("pending_intent");
            while (true) {
                if (pendingIntent == null) {
                    break Label_0030;
                }
                try {
                    pendingIntent.send();
                    if (zzJ(intent.getExtras())) {
                        zzd.zzh((Context)this, intent);
                    }
                    return true;
                }
                catch (PendingIntent$CanceledException ex) {
                    Log.e("FirebaseMessaging", "Notification pending intent canceled");
                    continue;
                }
                break;
            }
        }
        return false;
    }
}
