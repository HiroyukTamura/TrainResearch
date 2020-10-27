package com.google.android.gms.ads;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzapg;
import com.google.android.gms.internal.ads.zzazw;
import com.google.android.gms.internal.ads.zzvj;

@KeepForSdk
public final class AdActivity extends Activity {
    @KeepForSdk
    public static final String CLASS_NAME = "com.google.android.gms.ads.AdActivity";
    @KeepForSdk
    public static final String SIMPLE_CLASS_NAME = "AdActivity";
    private zzapg zzabx;

    private final void zzdp() {
        zzapg zzapg = this.zzabx;
        if (zzapg != null) {
            try {
                zzapg.zzdp();
            } catch (RemoteException e) {
                zzazw.zze("#007 Could not call remote method.", e);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void onActivityResult(int i, int i2, Intent intent) {
        try {
            this.zzabx.onActivityResult(i, i2, intent);
        } catch (Exception e) {
            zzazw.zze("#007 Could not call remote method.", e);
        }
        super.onActivityResult(i, i2, intent);
    }

    public final void onBackPressed() {
        boolean z = true;
        try {
            if (this.zzabx != null) {
                z = this.zzabx.zzuh();
            }
        } catch (RemoteException e) {
            zzazw.zze("#007 Could not call remote method.", e);
        }
        if (z) {
            super.onBackPressed();
        }
    }

    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        try {
            this.zzabx.zzad(ObjectWrapper.wrap(configuration));
        } catch (RemoteException e) {
            zzazw.zze("#007 Could not call remote method.", e);
        }
    }

    /* access modifiers changed from: protected */
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        zzapg zzb = zzvj.zzps().zzb((Activity) this);
        this.zzabx = zzb;
        if (zzb == null) {
            e = null;
        } else {
            try {
                zzb.onCreate(bundle);
                return;
            } catch (RemoteException e) {
                e = e;
            }
        }
        zzazw.zze("#007 Could not call remote method.", e);
        finish();
    }

    /* access modifiers changed from: protected */
    public final void onDestroy() {
        try {
            if (this.zzabx != null) {
                this.zzabx.onDestroy();
            }
        } catch (RemoteException e) {
            zzazw.zze("#007 Could not call remote method.", e);
        }
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public final void onPause() {
        try {
            if (this.zzabx != null) {
                this.zzabx.onPause();
            }
        } catch (RemoteException e) {
            zzazw.zze("#007 Could not call remote method.", e);
            finish();
        }
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public final void onRestart() {
        super.onRestart();
        try {
            if (this.zzabx != null) {
                this.zzabx.onRestart();
            }
        } catch (RemoteException e) {
            zzazw.zze("#007 Could not call remote method.", e);
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public final void onResume() {
        super.onResume();
        try {
            if (this.zzabx != null) {
                this.zzabx.onResume();
            }
        } catch (RemoteException e) {
            zzazw.zze("#007 Could not call remote method.", e);
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public final void onSaveInstanceState(Bundle bundle) {
        try {
            if (this.zzabx != null) {
                this.zzabx.onSaveInstanceState(bundle);
            }
        } catch (RemoteException e) {
            zzazw.zze("#007 Could not call remote method.", e);
            finish();
        }
        super.onSaveInstanceState(bundle);
    }

    /* access modifiers changed from: protected */
    public final void onStart() {
        super.onStart();
        try {
            if (this.zzabx != null) {
                this.zzabx.onStart();
            }
        } catch (RemoteException e) {
            zzazw.zze("#007 Could not call remote method.", e);
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public final void onStop() {
        try {
            if (this.zzabx != null) {
                this.zzabx.onStop();
            }
        } catch (RemoteException e) {
            zzazw.zze("#007 Could not call remote method.", e);
            finish();
        }
        super.onStop();
    }

    public final void setContentView(int i) {
        super.setContentView(i);
        zzdp();
    }

    public final void setContentView(View view) {
        super.setContentView(view);
        zzdp();
    }

    public final void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        zzdp();
    }
}
