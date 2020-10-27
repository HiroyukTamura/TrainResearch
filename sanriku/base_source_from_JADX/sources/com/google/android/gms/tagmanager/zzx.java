package com.google.android.gms.tagmanager;

import android.os.Looper;
import android.os.Message;
import com.google.android.gms.internal.gtm.zzdj;
import com.google.android.gms.tagmanager.ContainerHolder;

final class zzx extends zzdj {
    private final ContainerHolder.ContainerAvailableListener zzaes;
    private final /* synthetic */ zzv zzaet;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzx(zzv zzv, ContainerHolder.ContainerAvailableListener containerAvailableListener, Looper looper) {
        super(looper);
        this.zzaet = zzv;
        this.zzaes = containerAvailableListener;
    }

    public final void handleMessage(Message message) {
        if (message.what != 1) {
            zzdi.zzav("Don't know how to handle this message.");
            return;
        }
        this.zzaes.onContainerAvailable(this.zzaet, (String) message.obj);
    }
}
