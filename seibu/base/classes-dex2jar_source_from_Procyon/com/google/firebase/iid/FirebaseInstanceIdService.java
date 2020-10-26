// 
// Decompiled by Procyon v0.5.36
// 

package com.google.firebase.iid;

import android.content.IntentFilter;
import android.support.annotation.Nullable;
import android.content.BroadcastReceiver;
import android.support.annotation.WorkerThread;
import android.os.Bundle;
import android.net.NetworkInfo;
import android.net.ConnectivityManager;
import java.io.IOException;
import android.os.SystemClock;
import android.app.AlarmManager;
import android.util.Log;
import android.content.Intent;
import android.content.Context;
import android.support.annotation.VisibleForTesting;

public class FirebaseInstanceIdService extends zzb
{
    @VisibleForTesting
    private static Object zzckB;
    @VisibleForTesting
    private static boolean zzckC;
    private boolean zzckD;
    
    static {
        FirebaseInstanceIdService.zzckB = new Object();
        FirebaseInstanceIdService.zzckC = false;
    }
    
    public FirebaseInstanceIdService() {
        this.zzckD = false;
    }
    
    static void zza(final Context context, final FirebaseInstanceId firebaseInstanceId) {
        synchronized (FirebaseInstanceIdService.zzckB) {
            if (FirebaseInstanceIdService.zzckC) {
                return;
            }
            // monitorexit(FirebaseInstanceIdService.zzckB)
            final zzs zzJQ = firebaseInstanceId.zzJQ();
            if (zzJQ == null || zzJQ.zzhp(zzj.zzbgW) || FirebaseInstanceId.zzJS().zzJV() != null) {
                zzbI(context);
            }
        }
    }
    
    private final void zza(Intent zzckB, final String s) {
        int i = 28800;
        final boolean zzbJ = zzbJ((Context)this);
        while (true) {
            while (true) {
                int intExtra = 0;
                Label_0018: {
                    if (zzckB == null) {
                        intExtra = 10;
                        break Label_0018;
                    }
                    Label_0162: {
                        break Label_0162;
                    Block_9_Outer:
                        while (true) {
                            Log.d("FirebaseInstanceId", new StringBuilder(String.valueOf(s).length() + 47).append("background sync failed: ").append(s).append(", retry in ").append(i).append("s").toString());
                            zzckB = (Intent)FirebaseInstanceIdService.zzckB;
                            synchronized (zzckB) {
                                ((AlarmManager)this.getSystemService("alarm")).set(3, SystemClock.elapsedRealtime() + i * 1000, zzq.zza((Context)this, 0, zzbZ(i << 1), 134217728));
                                FirebaseInstanceIdService.zzckC = true;
                                // monitorexit(zzckB)
                                if (!zzbJ) {
                                    if (this.zzckD) {
                                        Log.d("FirebaseInstanceId", "device not connected. Connectivity change received registered");
                                    }
                                    zza.zzl((Context)this, i);
                                }
                                return;
                                // iftrue(Label_0187:, intExtra >= 10)
                                // iftrue(Label_0033:, intExtra > 28800)
                                Block_8: {
                                    break Block_8;
                                    while (true) {
                                        i = intExtra;
                                        continue Block_9_Outer;
                                        Label_0187: {
                                            continue;
                                        }
                                    }
                                }
                                i = 10;
                                continue;
                                intExtra = zzckB.getIntExtra("next_retry_delay_in_seconds", 0);
                                break;
                            }
                        }
                    }
                }
                if (intExtra < 10 && !zzbJ) {
                    i = 30;
                    continue;
                }
                break;
            }
            continue;
        }
    }
    
    private final void zza(final Intent intent, final boolean b, final boolean b2) {
        while (true) {
            synchronized (FirebaseInstanceIdService.zzckB) {
                FirebaseInstanceIdService.zzckC = false;
                // monitorexit(FirebaseInstanceIdService.zzckB)
                if (zzl.zzbd((Context)this) == null) {
                    return;
                }
            }
            final FirebaseInstanceId instance = FirebaseInstanceId.getInstance();
            final zzs zzJQ = instance.zzJQ();
            if (zzJQ != null) {
                if (!zzJQ.zzhp(zzj.zzbgW)) {
                    break;
                }
            }
            try {
                final String zzJR = instance.zzJR();
                if (zzJR == null) {
                    goto Label_0135;
                }
                if (this.zzckD) {
                    Log.d("FirebaseInstanceId", "get master token succeeded");
                }
                zza((Context)this, instance);
                if (b2 || zzJQ == null || (zzJQ != null && !zzJR.equals(zzJQ.zzbPJ))) {
                    this.onTokenRefresh();
                }
                return;
            }
            catch (IOException ex) {
                this.zza(intent, ex.getMessage());
                return;
            }
            catch (SecurityException ex2) {
                Log.e("FirebaseInstanceId", "Unable to get master token", (Throwable)ex2);
                return;
            }
            break;
        }
        final zzk zzJS = FirebaseInstanceId.zzJS();
        String s = zzJS.zzJV();
    Label_0166:
        while (true) {
            while (s != null) {
                final String[] split = s.split("!");
            Label_0268:
                while (true) {
                    if (split.length != 2) {
                        break Label_0268;
                    }
                    while (true) {
                        final String s2 = split[0];
                        final String s3 = split[1];
                        final int n = -1;
                        Label_0365: {
                            try {
                                final int hashCode = s2.hashCode();
                                int n2 = n;
                                while (true) {
                                    switch (hashCode) {
                                        default: {
                                            n2 = n;
                                        }
                                        case 84: {
                                            switch (n2) {
                                                case 0: {
                                                    FirebaseInstanceId.getInstance().zzhg(s3);
                                                    if (this.zzckD) {
                                                        Log.d("FirebaseInstanceId", "subscribe operation succeeded");
                                                        break;
                                                    }
                                                    break;
                                                }
                                                case 1: {
                                                    break Label_0365;
                                                }
                                            }
                                            zzJS.zzhj(s);
                                            s = zzJS.zzJV();
                                            continue Label_0166;
                                        }
                                        case 83: {
                                            n2 = n;
                                            if (s2.equals("S")) {
                                                n2 = 0;
                                            }
                                            continue;
                                        }
                                        case 85: {
                                            n2 = n;
                                            if (s2.equals("U")) {
                                                n2 = 1;
                                            }
                                            continue;
                                        }
                                    }
                                    break;
                                }
                            }
                            catch (IOException ex3) {
                                this.zza(intent, ex3.getMessage());
                                return;
                            }
                        }
                        FirebaseInstanceId.getInstance().zzhh(s3);
                        if (this.zzckD) {
                            Log.d("FirebaseInstanceId", "unsubscribe operation succeeded");
                            continue Label_0268;
                        }
                        continue Label_0268;
                    }
                    break;
                }
            }
            break;
        }
        Log.d("FirebaseInstanceId", "topic sync succeeded");
    }
    
    static void zzbI(final Context context) {
        if (zzl.zzbd(context) == null) {
            return;
        }
        synchronized (FirebaseInstanceIdService.zzckB) {
            if (!FirebaseInstanceIdService.zzckC) {
                zzq.zzJX().zze(context, zzbZ(0));
                FirebaseInstanceIdService.zzckC = true;
            }
        }
    }
    
    private static boolean zzbJ(final Context context) {
        final NetworkInfo activeNetworkInfo = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
    
    private static Intent zzbZ(final int n) {
        final Intent intent = new Intent("ACTION_TOKEN_REFRESH_RETRY");
        intent.putExtra("next_retry_delay_in_seconds", n);
        return intent;
    }
    
    private final zzj zzhi(final String s) {
        if (s == null) {
            return zzj.zzb((Context)this, null);
        }
        final Bundle bundle = new Bundle();
        bundle.putString("subtype", s);
        return zzj.zzb((Context)this, bundle);
    }
    
    private static String zzp(final Intent intent) {
        String stringExtra;
        if ((stringExtra = intent.getStringExtra("subtype")) == null) {
            stringExtra = "";
        }
        return stringExtra;
    }
    
    @Override
    public void handleIntent(final Intent intent) {
        String action;
        if ((action = intent.getAction()) == null) {
            action = "";
        }
        int n = 0;
        Label_0042: {
            switch (action.hashCode()) {
                case -1737547627: {
                    if (action.equals("ACTION_TOKEN_REFRESH_RETRY")) {
                        n = 0;
                        break Label_0042;
                    }
                    break;
                }
            }
            n = -1;
        }
        switch (n) {
            default: {
                final String zzp = zzp(intent);
                final zzj zzhi = this.zzhi(zzp);
                final String stringExtra = intent.getStringExtra("CMD");
                if (this.zzckD) {
                    final String value = String.valueOf(intent.getExtras());
                    Log.d("FirebaseInstanceId", new StringBuilder(String.valueOf(zzp).length() + 18 + String.valueOf(stringExtra).length() + String.valueOf(value).length()).append("Service command ").append(zzp).append(" ").append(stringExtra).append(" ").append(value).toString());
                }
                if (intent.getStringExtra("unregistered") != null) {
                    final zzr zzJT = zzj.zzJT();
                    String s;
                    if ((s = zzp) == null) {
                        s = "";
                    }
                    zzJT.zzdr(s);
                    zzj.zzJU().zzi(intent);
                }
                else {
                    if ("gcm.googleapis.com/refresh".equals(intent.getStringExtra("from"))) {
                        zzj.zzJT().zzdr(zzp);
                        this.zza(intent, false, true);
                        return;
                    }
                    if ("RST".equals(stringExtra)) {
                        zzhi.zzvL();
                        this.zza(intent, true, true);
                        return;
                    }
                    if ("RST_FULL".equals(stringExtra)) {
                        if (!zzj.zzJT().isEmpty()) {
                            zzhi.zzvL();
                            zzj.zzJT().zzvP();
                            this.zza(intent, true, true);
                        }
                    }
                    else {
                        if ("SYNC".equals(stringExtra)) {
                            zzj.zzJT().zzdr(zzp);
                            this.zza(intent, false, true);
                            return;
                        }
                        if ("PING".equals(stringExtra)) {
                            final Bundle extras = intent.getExtras();
                            final String zzbd = zzl.zzbd((Context)this);
                            if (zzbd == null) {
                                Log.w("FirebaseInstanceId", "Unable to respond to ping due to missing target package");
                                return;
                            }
                            final Intent intent2 = new Intent("com.google.android.gcm.intent.SEND");
                            intent2.setPackage(zzbd);
                            intent2.putExtras(extras);
                            zzl.zzd((Context)this, intent2);
                            intent2.putExtra("google.to", "google.com/iid");
                            intent2.putExtra("google.message_id", zzl.zzvO());
                            this.sendOrderedBroadcast(intent2, "com.google.android.gtalkservice.permission.GTALK_SERVICE");
                        }
                    }
                }
            }
            case 0: {
                this.zza(intent, false, false);
            }
        }
    }
    
    @WorkerThread
    public void onTokenRefresh() {
    }
    
    @Override
    protected final Intent zzn(final Intent intent) {
        return zzq.zzJX().zzckP.poll();
    }
    
    @Override
    public final boolean zzo(final Intent intent) {
        this.zzckD = Log.isLoggable("FirebaseInstanceId", 3);
        if (intent.getStringExtra("error") != null || intent.getStringExtra("registration_id") != null) {
            final String zzp = zzp(intent);
            if (this.zzckD) {
                final String value = String.valueOf(zzp);
                String concat;
                if (value.length() != 0) {
                    concat = "Register result in service ".concat(value);
                }
                else {
                    concat = new String("Register result in service ");
                }
                Log.d("FirebaseInstanceId", concat);
            }
            this.zzhi(zzp);
            zzj.zzJU().zzi(intent);
            return true;
        }
        return false;
    }
    
    static class zza extends BroadcastReceiver
    {
        @Nullable
        private static BroadcastReceiver receiver;
        private int zzckE;
        
        private zza(final int zzckE) {
            this.zzckE = zzckE;
        }
        
        static void zzl(final Context context, final int n) {
            synchronized (zza.class) {
                if (zza.receiver == null) {
                    zza.receiver = new zza(n);
                    context.getApplicationContext().registerReceiver(zza.receiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                }
            }
        }
        
        public void onReceive(final Context context, final Intent intent) {
            synchronized (zza.class) {
                if (zza.receiver != this) {
                    return;
                }
                if (!zzbJ(context)) {
                    return;
                }
            }
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                Log.d("FirebaseInstanceId", "connectivity changed. starting background sync.");
            }
            final Context context2;
            context2.getApplicationContext().unregisterReceiver((BroadcastReceiver)this);
            zza.receiver = null;
            // monitorexit(zza.class)
            zzq.zzJX().zze(context2, zzbZ(this.zzckE));
        }
    }
}
