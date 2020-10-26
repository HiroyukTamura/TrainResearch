/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.webview;

import java.util.Timer;
import java.util.TimerTask;
import jp.co.jreast.jreastapp.commuter.webview.f;
import jp.co.jreast.jreastapp.commuter.webview.j;
import kotlin.Metadata;

@Metadata(bv={1, 0, 2}, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2={"Ljp/co/jreast/jreastapp/commuter/webview/CommonWebViewTimerTask;", "Ljava/util/TimerTask;", "viewModel", "Ljp/co/jreast/jreastapp/commuter/webview/CommonWebViewModel;", "timer", "Ljava/util/Timer;", "(Ljp/co/jreast/jreastapp/commuter/webview/CommonWebViewModel;Ljava/util/Timer;)V", "getViewModel", "()Ljp/co/jreast/jreastapp/commuter/webview/CommonWebViewModel;", "run", "", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class l
extends TimerTask {
    private final j a;
    private final Timer b;

    public l(j j2, Timer timer) {
        kotlin.e.b.j.b(j2, "viewModel");
        kotlin.e.b.j.b(timer, "timer");
        this.a = j2;
        this.b = timer;
    }

    @Override
    public void run() {
        this.b.cancel();
        this.b.purge();
        this.a.b(f.b);
        this.a.G();
    }
}

