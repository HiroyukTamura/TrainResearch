package com.google.android.gms.common.api.internal;

import androidx.annotation.WorkerThread;
import com.google.android.gms.common.api.Api;
import java.util.ArrayList;

final class zaaq extends zaau {
    private final /* synthetic */ zaak zafz;
    private final ArrayList<Api.Client> zags;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zaaq(zaak zaak, ArrayList<Api.Client> arrayList) {
        super(zaak, (zaaj) null);
        this.zafz = zaak;
        this.zags = arrayList;
    }

    @WorkerThread
    public final void zaal() {
        this.zafz.zafv.zaeh.zahe = this.zafz.zaar();
        ArrayList<Api.Client> arrayList = this.zags;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Api.Client client = arrayList.get(i);
            i++;
            client.getRemoteService(this.zafz.zagj, this.zafz.zafv.zaeh.zahe);
        }
    }
}
