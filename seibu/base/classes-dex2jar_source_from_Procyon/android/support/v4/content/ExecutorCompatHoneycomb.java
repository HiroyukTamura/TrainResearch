// 
// Decompiled by Procyon v0.5.36
// 

package android.support.v4.content;

import android.os.AsyncTask;
import java.util.concurrent.Executor;
import android.support.annotation.RequiresApi;
import android.annotation.TargetApi;

@TargetApi(11)
@RequiresApi(11)
class ExecutorCompatHoneycomb
{
    public static Executor getParallelExecutor() {
        return AsyncTask.THREAD_POOL_EXECUTOR;
    }
}
