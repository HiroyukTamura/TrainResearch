package com.google.firebase.iid;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.CountDownLatch;

final /* synthetic */ class zzm implements OnCompleteListener {
    private final CountDownLatch zza;

    zzm(CountDownLatch countDownLatch) {
        this.zza = countDownLatch;
    }

    public final void onComplete(Task task) {
        this.zza.countDown();
    }
}
