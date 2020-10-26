/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.i;

import java.util.Timer;
import jp.co.jreast.jreastapp.commuter.webview.l;
import kotlin.Metadata;
import kotlin.e.b.j;

@Metadata(bv={1, 0, 2}, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\b\u00a8\u0006\n"}, d2={"Ljp/co/jreast/jreastapp/commuter/generator/TimerTaskGenerator;", "", "()V", "createCommonWebViewTimerTask", "Ljp/co/jreast/jreastapp/commuter/webview/CommonWebViewTimerTask;", "viewModel", "Ljp/co/jreast/jreastapp/commuter/webview/CommonWebViewModel;", "timer", "Ljava/util/Timer;", "createTimer", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class b {
    public final Timer a() {
        return new Timer();
    }

    public final l a(jp.co.jreast.jreastapp.commuter.webview.j j2, Timer timer) {
        j.b(j2, "viewModel");
        j.b(timer, "timer");
        return new l(j2, timer);
    }
}

