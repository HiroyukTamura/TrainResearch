package com.google.firebase.iid;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.ScheduledFuture;

final /* synthetic */ class zzbi implements OnCompleteListener {
    private final ScheduledFuture zza;

    zzbi(ScheduledFuture scheduledFuture) {
        this.zza = scheduledFuture;
    }

    public final void onComplete(Task task) {
        this.zza.cancel(false);
    }
}
