package androidx.lifecycle;

import android.annotation.SuppressLint;
import androidx.annotation.AnyThread;
import androidx.annotation.MainThread;
import java.util.ArrayDeque;
import java.util.Queue;
import kotlin.Metadata;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.C2502K;
import kotlinx.coroutines.C2537i0;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\n\u001a\u00020\u0004H\u0003J\b\u0010\u000b\u001a\u00020\fH\u0007J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\tH\u0003J\b\u0010\u000f\u001a\u00020\fH\u0007J\b\u0010\u0010\u001a\u00020\fH\u0007J\b\u0010\u0011\u001a\u00020\fH\u0007J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\tH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, mo21739d2 = {"Landroidx/lifecycle/DispatchQueue;", "", "()V", "finished", "", "isDraining", "paused", "queue", "Ljava/util/Queue;", "Ljava/lang/Runnable;", "canRun", "drainQueue", "", "enqueue", "runnable", "finish", "pause", "resume", "runOrEnqueue", "lifecycle-runtime-ktx_release"}, mo21740k = 1, mo21741mv = {1, 1, 15})
public final class DispatchQueue {
    private boolean finished;
    private boolean isDraining;
    private boolean paused = true;
    private final Queue<Runnable> queue = new ArrayDeque();

    @MainThread
    private final boolean canRun() {
        return this.finished || !this.paused;
    }

    /* access modifiers changed from: private */
    @MainThread
    public final void enqueue(Runnable runnable) {
        if (this.queue.offer(runnable)) {
            drainQueue();
            return;
        }
        throw new IllegalStateException("cannot enqueue any more runnables".toString());
    }

    @MainThread
    public final void drainQueue() {
        if (!this.isDraining) {
            boolean z = false;
            z = true;
            try {
                while (true) {
                    if (!(this.queue.isEmpty() ^ z)) {
                        break;
                    } else if (!canRun()) {
                        break;
                    } else {
                        Runnable poll = this.queue.poll();
                        if (poll != null) {
                            poll.run();
                        }
                    }
                }
                this.isDraining = z;
            } finally {
                this.isDraining = z;
            }
        }
    }

    @MainThread
    public final void finish() {
        this.finished = true;
        drainQueue();
    }

    @MainThread
    public final void pause() {
        this.paused = true;
    }

    @MainThread
    public final void resume() {
        if (this.paused) {
            if (!this.finished) {
                this.paused = false;
                drainQueue();
                return;
            }
            throw new IllegalStateException("Cannot resume a finished dispatcher".toString());
        }
    }

    @SuppressLint({"WrongThread"})
    @AnyThread
    public final void runOrEnqueue(Runnable runnable) {
        Intrinsics.checkParameterIsNotNull(runnable, "runnable");
        C2537i0 o = C2502K.m4331b().mo35536o();
        if (o.isDispatchNeeded(EmptyCoroutineContext.INSTANCE)) {
            o.dispatch(EmptyCoroutineContext.INSTANCE, new DispatchQueue$runOrEnqueue$$inlined$with$lambda$1(this, runnable));
        } else {
            enqueue(runnable);
        }
    }
}
