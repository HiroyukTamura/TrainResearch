// 
// Decompiled by Procyon v0.5.36
// 

package android.support.v4.os;

import android.os.AsyncTask;
import android.support.annotation.RequiresApi;
import android.annotation.TargetApi;

@TargetApi(11)
@RequiresApi(11)
class AsyncTaskCompatHoneycomb
{
    static <Params, Progress, Result> void executeParallel(final AsyncTask<Params, Progress, Result> asyncTask, final Params... array) {
        asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, (Object[])array);
    }
}
