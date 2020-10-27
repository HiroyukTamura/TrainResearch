package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;

public final class zzbga extends MutableContextWrapper {
    private Activity zzdys;
    private Context zzelj;
    private Context zzzo;

    public zzbga(Context context) {
        super(context);
        setBaseContext(context);
    }

    public final Object getSystemService(String str) {
        return this.zzelj.getSystemService(str);
    }

    public final void setBaseContext(Context context) {
        this.zzzo = context.getApplicationContext();
        this.zzdys = context instanceof Activity ? (Activity) context : null;
        this.zzelj = context;
        super.setBaseContext(this.zzzo);
    }

    public final void startActivity(Intent intent) {
        Activity activity = this.zzdys;
        if (activity != null) {
            activity.startActivity(intent);
            return;
        }
        intent.setFlags(268435456);
        this.zzzo.startActivity(intent);
    }

    public final Context zzabe() {
        return this.zzelj;
    }

    public final Activity zzzh() {
        return this.zzdys;
    }
}
