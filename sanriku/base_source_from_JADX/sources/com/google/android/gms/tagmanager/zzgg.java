package com.google.android.gms.tagmanager;

import com.google.android.gms.analytics.Logger;

final class zzgg implements Logger {
    zzgg() {
    }

    public final void error(Exception exc) {
        zzdi.zza("", exc);
    }

    public final void error(String str) {
        zzdi.zzav(str);
    }

    public final int getLogLevel() {
        int i = zzdi.zzyr;
        if (i == 2) {
            return 0;
        }
        if (i == 3 || i == 4) {
            return 1;
        }
        return i != 5 ? 3 : 2;
    }

    public final void info(String str) {
        zzdi.zzaw(str);
    }

    public final void setLogLevel(int i) {
        zzdi.zzac("GA uses GTM logger. Please use TagManager.setLogLevel(int) instead.");
    }

    public final void verbose(String str) {
        zzdi.zzab(str);
    }

    public final void warn(String str) {
        zzdi.zzac(str);
    }
}
