package com.google.android.gms.ads.mediation;

import android.os.Bundle;

public interface MediationAdapter extends MediationExtrasReceiver {

    public static class zza {
        private int zzema;

        public final Bundle zzact() {
            Bundle bundle = new Bundle();
            bundle.putInt("capabilities", this.zzema);
            return bundle;
        }

        public final zza zzdo(int i) {
            this.zzema = 1;
            return this;
        }
    }

    void onDestroy();

    void onPause();

    void onResume();
}
