package com.google.android.gms.internal.ads;

import androidx.annotation.NonNull;
import java.util.concurrent.ThreadFactory;

final class zzoy implements ThreadFactory {
    private final /* synthetic */ String zzbia;

    zzoy(String str) {
        this.zzbia = str;
    }

    public final Thread newThread(@NonNull Runnable runnable) {
        return new Thread(runnable, this.zzbia);
    }
}
