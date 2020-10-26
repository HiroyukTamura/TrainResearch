/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.acknowledgement;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.p;
import androidx.lifecycle.v;
import b.a.e;
import b.a.g;
import jp.co.jreast.jreastapp.commuter.al;
import jp.co.jreast.jreastapp.commuter.model.Acknowledgement;
import kotlin.Metadata;
import kotlin.e.b.j;

@Metadata(bv={1, 0, 2}, d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010\u001b\u001a\u00020\u001aR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t8F\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u0004R\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R \u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0016\"\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2={"Ljp/co/jreast/jreastapp/commuter/acknowledgement/AcknowledgementViewModel;", "Landroidx/lifecycle/ViewModel;", "acknowledgementRepository", "Ljp/co/jreast/jreastapp/commuter/repository/NetworkAcknowledgementRepository;", "(Ljp/co/jreast/jreastapp/commuter/repository/NetworkAcknowledgementRepository;)V", "_acknowledgement", "Landroidx/lifecycle/MutableLiveData;", "Ljp/co/jreast/jreastapp/commuter/model/Acknowledgement;", "acknowledgement", "Landroidx/lifecycle/LiveData;", "getAcknowledgement", "()Landroidx/lifecycle/LiveData;", "getAcknowledgementRepository", "()Ljp/co/jreast/jreastapp/commuter/repository/NetworkAcknowledgementRepository;", "setAcknowledgementRepository", "dismissAcknowledgementEvent", "Ljp/co/jreast/jreastapp/commuter/SingleLiveEvent;", "Ljava/lang/Void;", "getDismissAcknowledgementEvent$app_productRelease", "()Ljp/co/jreast/jreastapp/commuter/SingleLiveEvent;", "isSearching", "", "()Landroidx/lifecycle/MutableLiveData;", "setSearching", "(Landroidx/lifecycle/MutableLiveData;)V", "get", "", "tapCloseButton", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class b
extends v {
    private p<Acknowledgement> a;
    private p<Boolean> b;
    private final al<Void> c;
    private jp.co.jreast.jreastapp.commuter.m.g d;

    public b(jp.co.jreast.jreastapp.commuter.m.g g2) {
        j.b(g2, "acknowledgementRepository");
        this.d = g2;
        this.a = new p();
        this.b = new p();
        this.c = new al();
        this.b.b(false);
    }

    public final LiveData<Acknowledgement> b() {
        return this.a;
    }

    public final p<Boolean> c() {
        return this.b;
    }

    public final al<Void> d() {
        return this.c;
    }

    public final void e() {
        this.c.f();
    }

    public final void f() {
        this.b.b(true);
        this.d.a("https://rp.cloudrail.jp/com/api/").a(new g<Acknowledgement>(){

            @Override
            public void a(b.a.b.b b2) {
                j.b(b2, "d");
            }

            @Override
            public void a(Throwable throwable) {
                j.b(throwable, "e");
                this.c().b(false);
            }

            public void a(Acknowledgement acknowledgement) {
                j.b(acknowledgement, "obj");
                this.c().b(false);
                this.a.b(acknowledgement);
            }

            @Override
            public /* synthetic */ void a_(Object object) {
                this.a((Acknowledgement)object);
            }

            @Override
            public void b_() {
            }
        });
    }

}

