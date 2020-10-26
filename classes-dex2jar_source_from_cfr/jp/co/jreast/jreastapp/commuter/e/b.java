/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.e;

import g.a.a;
import jp.a.a;
import jp.co.jreast.jreastapp.commuter.e.a;
import jp.co.jreast.jreastapp.commuter.webview.j;
import kotlin.Metadata;

@Metadata(bv={1, 0, 2}, d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J.\u0010\t\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0011\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J$\u0010\u0014\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2={"Ljp/co/jreast/jreastapp/commuter/device/CommuterSSTouchManagerListener;", "Ljp/sstouch/SSTouchManager$SSTouchManagerListener;", "viewModel", "Ljp/co/jreast/jreastapp/commuter/webview/CommonWebViewModel;", "(Ljp/co/jreast/jreastapp/commuter/webview/CommonWebViewModel;)V", "onChangeState", "", "state", "Ljp/sstouch/SSTouchManager$SSTouchState;", "onEndFetching", "formatType", "Ljp/sstouch/SSTouchManager$SSTouchFormatType;", "serviceId", "", "urlString", "", "message", "onErrorAudio", "error", "Ljp/sstouch/SSTouchManager$SSTouchError;", "onErrorFetching", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class b
implements a.g {
    private final j a;

    public b(j j2) {
        kotlin.e.b.j.b(j2, "viewModel");
        this.a = j2;
    }

    @Override
    public void a(a.b b2) {
        a.b b3 = g.a.a.a("SSTouch");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[onErrorAudio] error:");
        stringBuilder.append(b2);
        b3.a(stringBuilder.toString(), new Object[0]);
    }

    @Override
    public void a(a.f f2, int n2, String string2, String string3) {
        this.a.f(a.a.a(n2));
        a.b b2 = g.a.a.a("SSTouch");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[onEndFetching] SSTouchFormatType:");
        stringBuilder.append((Object)f2);
        stringBuilder.append(", serviceId:");
        stringBuilder.append(n2);
        stringBuilder.append(", urlString:");
        stringBuilder.append(string2);
        stringBuilder.append(", message:");
        stringBuilder.append(string3);
        b2.a(stringBuilder.toString(), new Object[0]);
    }

    @Override
    public void a(a.h h2) {
        a.b b2 = g.a.a.a("SSTouch");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[onChangeState] SSTouchState:");
        stringBuilder.append((Object)h2);
        b2.a(stringBuilder.toString(), new Object[0]);
    }
}

