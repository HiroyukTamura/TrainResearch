/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.push;

import androidx.lifecycle.v;
import jp.co.jreast.jreastapp.commuter.al;
import jp.co.jreast.jreastapp.commuter.m.p;
import jp.co.jreast.jreastapp.commuter.m.r;
import jp.co.jreast.jreastapp.commuter.model.RailwayLineInformation;
import jp.co.jreast.jreastapp.commuter.push.a;
import jp.co.jreast.jreastapp.commuter.webview.o;
import kotlin.Metadata;
import kotlin.e.b.g;
import kotlin.e.b.j;
import kotlin.i.n;

@Metadata(bv={1, 0, 2}, d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u000eJ\u0006\u0010\u001d\u001a\u00020\u001aJ\u0006\u0010\u001e\u001a\u00020\u001aR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000bR\u000e\u0010\u0014\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2={"Ljp/co/jreast/jreastapp/commuter/push/PushReceiveViewModel;", "Landroidx/lifecycle/ViewModel;", "userInformationRepository", "Ljp/co/jreast/jreastapp/commuter/repository/UserInformationRepository;", "translationRepository", "Ljp/co/jreast/jreastapp/commuter/repository/TranslationRepository;", "(Ljp/co/jreast/jreastapp/commuter/repository/UserInformationRepository;Ljp/co/jreast/jreastapp/commuter/repository/TranslationRepository;)V", "closeEvent", "Ljp/co/jreast/jreastapp/commuter/SingleLiveEvent;", "Ljava/lang/Void;", "getCloseEvent", "()Ljp/co/jreast/jreastapp/commuter/SingleLiveEvent;", "messageTextFieldProperty", "Landroidx/lifecycle/MutableLiveData;", "", "getMessageTextFieldProperty", "()Landroidx/lifecycle/MutableLiveData;", "openCommonWebViewEvent", "Ljp/co/jreast/jreastapp/commuter/webview/Site;", "getOpenCommonWebViewEvent", "paramV", "titleTextFieldProperty", "getTitleTextFieldProperty", "getTranslationRepository", "()Ljp/co/jreast/jreastapp/commuter/repository/TranslationRepository;", "set", "", "v", "message", "tapCloseButton", "tapOpenButton", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class c
extends v {
    private String a;
    private final al<o> b;
    private final al<Void> c;
    private final androidx.lifecycle.p<String> d;
    private final androidx.lifecycle.p<String> e;
    private final r f;
    private final p g;

    public c(r object, p p2) {
        j.b(object, "userInformationRepository");
        j.b(p2, "translationRepository");
        this.f = object;
        this.g = p2;
        this.a = "";
        this.b = new al();
        this.c = new al();
        object = new androidx.lifecycle.p();
        ((androidx.lifecycle.p)object).b("");
        this.d = object;
        object = new androidx.lifecycle.p();
        ((androidx.lifecycle.p)object).b("");
        this.e = object;
    }

    public final void a(String string2, String string3) {
        j.b(string2, "v");
        j.b(string3, "message");
        this.a = string2;
        string2 = "";
        if (j.a((Object)this.a, (Object)a.a.a())) {
            string2 = this.g.a(a.a.b());
        }
        this.d.b(string2);
        this.e.b(string3);
    }

    public final al<o> b() {
        return this.b;
    }

    public final al<Void> c() {
        return this.c;
    }

    public final androidx.lifecycle.p<String> d() {
        return this.d;
    }

    public final androidx.lifecycle.p<String> e() {
        return this.e;
    }

    public final void f() {
        boolean bl2;
        String string2 = "";
        CharSequence charSequence = "";
        if (j.a((Object)this.a, (Object)a.a.a())) {
            string2 = this.f.a();
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("https://rp.cloudrail.jp/");
            ((StringBuilder)charSequence).append(n.a(a.a.c(), "%uid%", string2, false, 4, null));
            charSequence = ((StringBuilder)charSequence).toString();
            string2 = this.g.a(a.a.b());
        }
        if (bl2 = ((CharSequence)charSequence).length() > 0) {
            this.b.b(new o(string2, (String)charSequence, 0, null, 0, null, 0, null, 0, null, 1020, null));
        }
    }

    public final void g() {
        this.c.b(null);
    }
}

