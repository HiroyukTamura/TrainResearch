package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.GmsClientEventManager;

final class zaav implements GmsClientEventManager.GmsClientEventState {
    private final /* synthetic */ zaaw zagv;

    zaav(zaaw zaaw) {
        this.zagv = zaaw;
    }

    public final Bundle getConnectionHint() {
        return null;
    }

    public final boolean isConnected() {
        return this.zagv.isConnected();
    }
}
