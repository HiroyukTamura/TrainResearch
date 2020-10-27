package com.google.android.gms.common.api.internal;

final class zaai extends zabd {
    private final /* synthetic */ zaaf zafy;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zaai(zaaf zaaf, zabb zabb) {
        super(zabb);
        this.zafy = zaaf;
    }

    public final void zaal() {
        this.zafy.onConnectionSuspended(1);
    }
}
