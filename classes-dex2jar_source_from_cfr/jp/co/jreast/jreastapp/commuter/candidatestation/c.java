/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  android.text.Editable
 */
package jp.co.jreast.jreastapp.commuter.candidatestation;

import android.content.Intent;
import android.text.Editable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.p;
import androidx.lifecycle.u;
import androidx.lifecycle.v;
import java.io.Serializable;
import java.util.List;
import jp.co.jreast.jreastapp.commuter.al;
import jp.co.jreast.jreastapp.commuter.candidatestation.e;
import jp.co.jreast.jreastapp.commuter.common.r;
import jp.co.jreast.jreastapp.commuter.m.t;
import jp.co.jreast.jreastapp.commuter.model.Station;
import kotlin.Metadata;
import kotlin.a.m;
import kotlin.e.b.j;
import kotlin.i.n;

@Metadata(bv={1, 0, 2}, d1={"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020AJ\b\u0010B\u001a\u00020?H\u0014J\u000e\u0010C\u001a\u00020?2\u0006\u0010D\u001a\u00020\u0010J\u000e\u0010E\u001a\u00020?2\u0006\u00107\u001a\u00020\u000bJ\u000e\u0010F\u001a\u00020?2\u0006\u0010D\u001a\u00020\u0010J\u0006\u0010G\u001a\u00020?J\u0006\u0010H\u001a\u00020?J\u000e\u0010I\u001a\u00020?2\u0006\u0010D\u001a\u00020\u0010J\u0006\u0010J\u001a\u00020?J\u0006\u0010K\u001a\u00020?J\b\u0010L\u001a\u00020?H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bX\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0015R\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bX\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001eR\u0017\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00138F\u00a2\u0006\u0006\u001a\u0004\b%\u0010\u0015R\u0017\u0010&\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00138F\u00a2\u0006\u0006\u001a\u0004\b'\u0010\u0015R\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bX\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00100\u001bX\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001eR\u0017\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00170\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010\u0015R\u0017\u0010.\u001a\b\u0012\u0004\u0012\u00020 0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u0010\u0019R\u0017\u00100\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00138F\u00a2\u0006\u0006\u001a\u0004\b1\u0010\u0015R\u001a\u00102\u001a\b\u0012\u0004\u0012\u0002030\u001bX\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b4\u0010\u001eR\u001d\u00105\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u00138F\u00a2\u0006\u0006\u001a\u0004\b6\u0010\u0015R\u001a\u00107\u001a\u00020\u000bX\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u0017\u0010<\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00138F\u00a2\u0006\u0006\u001a\u0004\b=\u0010\u0015\u00a8\u0006M"}, d2={"Ljp/co/jreast/jreastapp/commuter/candidatestation/CandidateStationViewModel;", "Landroidx/lifecycle/ViewModel;", "localStationRepository", "Ljp/co/jreast/jreastapp/commuter/candidatestation/LocalStationRepository;", "historyRepository", "Ljp/co/jreast/jreastapp/commuter/repository/UserStationHistoryRepository;", "(Ljp/co/jreast/jreastapp/commuter/candidatestation/LocalStationRepository;Ljp/co/jreast/jreastapp/commuter/repository/UserStationHistoryRepository;)V", "_disposables", "Lio/reactivex/disposables/CompositeDisposable;", "_emptyCandidateTextVisibility", "Landroidx/lifecycle/MutableLiveData;", "", "_emptyHistoryTextVisibility", "_stationHistoryTitleVisibility", "_stationListProperty", "", "Ljp/co/jreast/jreastapp/commuter/model/Station;", "_urgeInputTextProperty", "clearButtonVisibility", "Landroidx/lifecycle/LiveData;", "getClearButtonVisibility", "()Landroidx/lifecycle/LiveData;", "closeButtonVisibility", "", "getCloseButtonVisibility", "()Landroidx/lifecycle/MutableLiveData;", "dismissCandidateStationEvent", "Ljp/co/jreast/jreastapp/commuter/SingleLiveEvent;", "Ljava/lang/Void;", "getDismissCandidateStationEvent$app_productRelease", "()Ljp/co/jreast/jreastapp/commuter/SingleLiveEvent;", "editButtonTextProperty", "", "getEditButtonTextProperty", "editHistoryEvent", "getEditHistoryEvent$app_productRelease", "emptyCandidateTextVisibility", "getEmptyCandidateTextVisibility", "emptyHistoryTextVisibility", "getEmptyHistoryTextVisibility", "hideKeyboardEvent", "getHideKeyboardEvent$app_productRelease", "removeItemEvent", "getRemoveItemEvent$app_productRelease", "searchTextEnable", "getSearchTextEnable", "searchTextProperty", "getSearchTextProperty", "stationHistoryTitleVisibility", "getStationHistoryTitleVisibility", "stationListItemClickEvent", "Landroid/content/Intent;", "getStationListItemClickEvent$app_productRelease", "stationListProperty", "getStationListProperty", "stationType", "getStationType$app_productRelease", "()I", "setStationType$app_productRelease", "(I)V", "urgeInputTextProperty", "getUrgeInputTextProperty", "afterTextChanged", "", "s", "Landroid/text/Editable;", "onCleared", "removeItem", "station", "setUrgeInputText", "stationListItemClick", "switchEditMode", "tapCancelButton", "tapRemoveCell", "tapTextClearButton", "tapViewWithoutInputField", "viewStationHistoryIfNeeded", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class c
extends v {
    private final p<List<Station>> a;
    private final p<Integer> b;
    private final p<Integer> c;
    private final p<Integer> d;
    private final p<Integer> e;
    private final p<Boolean> f;
    private final LiveData<String> g;
    private final LiveData<Boolean> h;
    private int i;
    private final al<Void> j;
    private final al<Void> k;
    private final al<Intent> l;
    private final al<Void> m;
    private final al<Station> n;
    private final b.a.b.a o;
    private final p<String> p;
    private final LiveData<Integer> q;
    private final e r;
    private final t s;

    public c(e liveData, t t2) {
        j.b(liveData, "localStationRepository");
        j.b(t2, "historyRepository");
        this.r = liveData;
        this.s = t2;
        liveData = new p();
        m.a();
        this.a = liveData;
        this.b = new p();
        liveData = new p();
        liveData.b(8);
        this.c = liveData;
        this.d = new p();
        this.e = new p();
        liveData = new p();
        liveData.b(false);
        this.f = liveData;
        liveData = u.a((LiveData)this.f, b.a);
        j.a(liveData, "Transformations.switchMa\u2026          }\n            }");
        this.g = liveData;
        liveData = u.a((LiveData)this.f, c.a);
        j.a(liveData, "Transformations.switchMa\u2026          }\n            }");
        this.h = liveData;
        this.i = r.a.a();
        this.j = new al();
        this.k = new al();
        this.l = new al();
        this.m = new al();
        this.n = new al();
        this.o = new b.a.b.a();
        liveData = new p();
        liveData.b("");
        this.p = liveData;
        liveData = u.a((LiveData)this.p, a.a);
        j.a((Object)liveData, "Transformations.switchMa\u2026          }\n            }");
        this.q = liveData;
        this.u();
    }

    /*
     * Enabled aggressive block sorting
     */
    private final void u() {
        p<Integer> p2;
        Integer n2;
        if (this.s.a() == 0) {
            this.a.b(m.a());
            p2 = this.e;
            n2 = 0;
        } else {
            this.a.b(this.s.b());
            p2 = this.e;
            n2 = 8;
        }
        p2.b(n2);
        this.d.b(0);
    }

    @Override
    protected void a() {
        this.o.c();
        this.a.b(m.a());
        super.a();
    }

    public final void a(int n2) {
        this.i = n2;
        n2 = n2 == r.a.a() ? 2131558496 : (n2 == r.b.a() ? 2131558495 : (n2 == r.c.a() || n2 == r.d.a() ? 2131558499 : 0));
        this.b.b(n2);
    }

    public final void a(Editable object) {
        j.b(object, "s");
        if (n.a((CharSequence)object)) {
            this.c.b(8);
            this.u();
            return;
        }
        this.e.b(8);
        this.d.b(8);
        this.f.b(false);
        object = this.r.a(object.toString());
        this.a.b((List<Station>)object);
        p<Integer> p2 = this.c;
        object = object.isEmpty() ? Integer.valueOf(0) : Integer.valueOf(8);
        p2.b((Integer)object);
    }

    public final void a(Station station) {
        j.b(station, "station");
        this.n.b(station);
    }

    public final LiveData<List<Station>> b() {
        return this.a;
    }

    public final void b(Station station) {
        j.b(station, "station");
        Object object = this.f.a();
        if (object == null) {
            j.a();
        }
        j.a(object, "closeButtonVisibility.value!!");
        if (((Boolean)object).booleanValue()) {
            return;
        }
        this.s.a(station);
        object = new Intent();
        object.putExtra(jp.co.jreast.jreastapp.commuter.common.b.u.a(), (Serializable)station);
        object.putExtra("STATION_TYPE", this.i);
        this.l.b((Intent)object);
    }

    public final LiveData<Integer> c() {
        return this.b;
    }

    public final void c(Station station) {
        j.b(station, "station");
        this.s.c(station);
        this.u();
    }

    public final LiveData<Integer> d() {
        return this.c;
    }

    public final LiveData<Integer> e() {
        return this.d;
    }

    public final LiveData<Integer> f() {
        return this.e;
    }

    public final p<Boolean> g() {
        return this.f;
    }

    public final LiveData<String> h() {
        return this.g;
    }

    public final LiveData<Boolean> i() {
        return this.h;
    }

    public final al<Void> j() {
        return this.j;
    }

    public final al<Void> k() {
        return this.k;
    }

    public final al<Intent> l() {
        return this.l;
    }

    public final al<Void> m() {
        return this.m;
    }

    public final al<Station> n() {
        return this.n;
    }

    public final p<String> o() {
        return this.p;
    }

    public final LiveData<Integer> p() {
        return this.q;
    }

    public final void q() {
        this.j.f();
    }

    public final void r() {
        this.k.f();
    }

    public final void s() {
        p<Boolean> p2 = this.f;
        Object t2 = this.f.a();
        if (t2 == null) {
            j.a();
        }
        p2.b((Boolean)t2 ^ true);
        this.m.f();
    }

    public final void t() {
        this.p.b("");
    }

}

