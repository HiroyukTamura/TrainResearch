/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  android.os.Bundle
 */
package jp.co.jreast.jreastapp.commuter.commuterpager.b;

import android.content.Intent;
import android.os.Bundle;
import androidx.lifecycle.v;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import jp.co.jreast.jreastapp.commuter.al;
import jp.co.jreast.jreastapp.commuter.common.r;
import jp.co.jreast.jreastapp.commuter.d.b;
import jp.co.jreast.jreastapp.commuter.m.a;
import jp.co.jreast.jreastapp.commuter.m.p;
import jp.co.jreast.jreastapp.commuter.m.s;
import jp.co.jreast.jreastapp.commuter.model.Station;
import kotlin.Metadata;
import kotlin.a.m;
import kotlin.e.b.j;
import kotlin.t;

@Metadata(bv={1, 0, 2}, d1={"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u001d\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0002\u0010\fJ\u000e\u0010i\u001a\u00020j2\u0006\u0010k\u001a\u00020\u001bJ\b\u0010l\u001a\u00020jH\u0002J\b\u0010m\u001a\u00020jH\u0002J \u0010n\u001a\u00020\u001b2\u0006\u0010o\u001a\u00020,2\u0006\u0010p\u001a\u00020,2\b\u0010q\u001a\u0004\u0018\u000105J\u0018\u0010r\u001a\u00020j2\u0006\u0010s\u001a\u00020\u00172\u0006\u0010t\u001a\u00020\u0017H\u0002J\b\u0010u\u001a\u00020jH\u0002J\u0010\u0010v\u001a\u00020j2\u0006\u0010w\u001a\u00020\u0010H\u0002J\u0006\u0010x\u001a\u00020jJ\u0010\u0010y\u001a\u00020j2\u0006\u0010w\u001a\u00020\u0010H\u0002J\u0018\u0010z\u001a\u00020j2\u0006\u0010w\u001a\u00020\u00102\u0006\u0010{\u001a\u00020,H\u0002J\u0006\u0010|\u001a\u00020jJ\u0006\u0010}\u001a\u00020jJ\u0006\u0010~\u001a\u00020jJ\u0006\u0010\u001a\u00020jJ\u0007\u0010\u0001\u001a\u00020jJ\u0007\u0010\u0081\u0001\u001a\u00020jJ\u0007\u0010\u0082\u0001\u001a\u00020jJ\u0010\u0010\u0083\u0001\u001a\u00020j2\u0007\u0010\u0084\u0001\u001a\u00020,J\u0007\u0010\u0085\u0001\u001a\u00020jJ\u0007\u0010\u0086\u0001\u001a\u00020jR\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0017\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0019R\u0017\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0019R\u001c\u0010%\u001a\u0004\u0018\u00010\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0012\"\u0004\b'\u0010\u0014R\u0017\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0019R \u0010*\u001a\b\u0012\u0004\u0012\u00020,0+X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R \u00101\u001a\b\u0012\u0004\u0012\u00020,0+X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b2\u0010.\"\u0004\b3\u00100R \u00104\u001a\b\u0012\u0004\u0012\u0002050+X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b6\u0010.\"\u0004\b7\u00100R \u00108\u001a\b\u0012\u0004\u0012\u0002090+X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b:\u0010.\"\u0004\b;\u00100R \u0010<\u001a\b\u0012\u0004\u0012\u00020,0+X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b=\u0010.\"\u0004\b>\u00100R\u0017\u0010?\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b@\u0010\u0019R\u001a\u0010A\u001a\u00020BX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u001a\u0010G\u001a\u00020,X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010L\u001a\u00020\u001bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\u0017\u0010U\u001a\b\u0012\u0004\u0012\u00020,0\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\bV\u0010\u0019R\u0017\u0010W\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\bX\u0010\u0019R\u0017\u0010Y\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\bZ\u0010\u0019R\u0017\u0010[\u001a\b\u0012\u0004\u0012\u00020,0\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b\\\u0010\u0019R\u0017\u0010]\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b^\u0010\u0019R\u0017\u0010_\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b`\u0010\u0019R\u0017\u0010a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\bb\u0010\u0019R \u0010c\u001a\b\u0012\u0004\u0012\u00020\u00100dX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\be\u0010f\"\u0004\bg\u0010h\u00a8\u0006\u0087\u0001"}, d2={"Ljp/co/jreast/jreastapp/commuter/commuterpager/routesearch/RouteSearchViewModel;", "Landroidx/lifecycle/ViewModel;", "dateTimeUtil", "Ljp/co/jreast/jreastapp/commuter/datetime/CommuterDateTimeUtil;", "translationRepository", "Ljp/co/jreast/jreastapp/commuter/repository/TranslationRepository;", "userSettingsRepository", "Ljp/co/jreast/jreastapp/commuter/repository/UserSettingsRepository;", "colorRepository", "Ljp/co/jreast/jreastapp/commuter/repository/ColorRepository;", "analyticsProvider", "Ljp/co/jreast/jreastapp/commuter/provider/AnalyticsProvider;", "(Ljp/co/jreast/jreastapp/commuter/datetime/CommuterDateTimeUtil;Ljp/co/jreast/jreastapp/commuter/repository/TranslationRepository;Ljp/co/jreast/jreastapp/commuter/repository/UserSettingsRepository;Ljp/co/jreast/jreastapp/commuter/repository/ColorRepository;Ljp/co/jreast/jreastapp/commuter/provider/AnalyticsProvider;)V", "getAnalyticsProvider", "()Ljp/co/jreast/jreastapp/commuter/provider/AnalyticsProvider;", "arrivalStation", "Ljp/co/jreast/jreastapp/commuter/model/Station;", "getArrivalStation", "()Ljp/co/jreast/jreastapp/commuter/model/Station;", "setArrivalStation", "(Ljp/co/jreast/jreastapp/commuter/model/Station;)V", "arrivalStationButtonTextProperty", "Landroidx/lifecycle/MutableLiveData;", "", "getArrivalStationButtonTextProperty", "()Landroidx/lifecycle/MutableLiveData;", "changeStationButtonEnabled", "", "getChangeStationButtonEnabled", "getColorRepository", "()Ljp/co/jreast/jreastapp/commuter/repository/ColorRepository;", "setColorRepository", "(Ljp/co/jreast/jreastapp/commuter/repository/ColorRepository;)V", "departureArrivalTimeTextProperty", "getDepartureArrivalTimeTextProperty", "departureOrArrivalTextProperty", "getDepartureOrArrivalTextProperty", "departureStation", "getDepartureStation", "setDepartureStation", "departureStationButtonTextProperty", "getDepartureStationButtonTextProperty", "openCandidateStationEvent", "Ljp/co/jreast/jreastapp/commuter/SingleLiveEvent;", "", "getOpenCandidateStationEvent", "()Ljp/co/jreast/jreastapp/commuter/SingleLiveEvent;", "setOpenCandidateStationEvent", "(Ljp/co/jreast/jreastapp/commuter/SingleLiveEvent;)V", "openCandidateStationWithAnimationEvent", "getOpenCandidateStationWithAnimationEvent", "setOpenCandidateStationWithAnimationEvent", "openDepartureArrivalTimeSelectEvent", "Landroid/content/Intent;", "getOpenDepartureArrivalTimeSelectEvent", "setOpenDepartureArrivalTimeSelectEvent", "openRouteSearchResultsEvent", "Landroid/os/Bundle;", "getOpenRouteSearchResultsEvent", "setOpenRouteSearchResultsEvent", "removeViaStationWithAnimationEvent", "getRemoveViaStationWithAnimationEvent", "setRemoveViaStationWithAnimationEvent", "searchButtonEnabled", "getSearchButtonEnabled", "selectedDate", "Ljava/util/Date;", "getSelectedDate", "()Ljava/util/Date;", "setSelectedDate", "(Ljava/util/Date;)V", "selectedDepartureOrArrival", "getSelectedDepartureOrArrival", "()I", "setSelectedDepartureOrArrival", "(I)V", "useCurrentDateTime", "getUseCurrentDateTime", "()Z", "setUseCurrentDateTime", "(Z)V", "getUserSettingsRepository", "()Ljp/co/jreast/jreastapp/commuter/repository/UserSettingsRepository;", "setUserSettingsRepository", "(Ljp/co/jreast/jreastapp/commuter/repository/UserSettingsRepository;)V", "viaStation1TextColor", "getViaStation1TextColor", "viaStation1TextProperty", "getViaStation1TextProperty", "viaStation1Visible", "getViaStation1Visible", "viaStation2TextColor", "getViaStation2TextColor", "viaStation2TextProperty", "getViaStation2TextProperty", "viaStation2Visible", "getViaStation2Visible", "viaStationButtonVisible", "getViaStationButtonVisible", "viaStations", "", "getViaStations", "()Ljava/util/List;", "setViaStations", "(Ljava/util/List;)V", "changeUserVisibleHint", "", "isVisibleToUser", "changeViaStation", "loadUserSettings", "onActivityResult", "requestCode", "resultCode", "data", "sendDidTapSearchButtonEventToAnalytics", "via1String", "via2String", "sendViewHomeEventToAnalytics", "setArrivalStationInfo", "station", "setDepartureArrivalTimeButtonText", "setDepartureStationInfo", "setViaStationInfo", "stationType", "setViaStationsView", "tapArrivalStationButton", "tapChangeStationButton", "tapDepartureStationButton", "tapSearchButton", "tapTimeSelectButton", "tapViaStationButton", "tapViaStationDeleteButton", "index", "tapViaStationName1Button", "tapViaStationName2Button", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class c
extends v {
    private s A;
    private a B;
    private final jp.co.jreast.jreastapp.commuter.l.a C;
    private final androidx.lifecycle.p<String> a;
    private final androidx.lifecycle.p<String> b;
    private final androidx.lifecycle.p<String> c;
    private final androidx.lifecycle.p<String> d;
    private final androidx.lifecycle.p<Boolean> e;
    private final androidx.lifecycle.p<Boolean> f;
    private final androidx.lifecycle.p<Boolean> g;
    private final androidx.lifecycle.p<String> h;
    private final androidx.lifecycle.p<Integer> i;
    private final androidx.lifecycle.p<Boolean> j;
    private final androidx.lifecycle.p<String> k;
    private final androidx.lifecycle.p<Integer> l;
    private final androidx.lifecycle.p<Boolean> m;
    private al<Integer> n;
    private al<Intent> o;
    private al<Bundle> p;
    private al<Integer> q;
    private al<Integer> r;
    private Station s;
    private Station t;
    private Date u;
    private int v;
    private boolean w;
    private List<Station> x;
    private jp.co.jreast.jreastapp.commuter.d.a y;
    private p z;

    public c(jp.co.jreast.jreastapp.commuter.d.a a2, p p2, s s2, a a3, jp.co.jreast.jreastapp.commuter.l.a a4) {
        j.b(a2, "dateTimeUtil");
        j.b(p2, "translationRepository");
        j.b(s2, "userSettingsRepository");
        j.b(a3, "colorRepository");
        this.y = a2;
        this.z = p2;
        this.A = s2;
        this.B = a3;
        this.C = a4;
        this.a = new androidx.lifecycle.p();
        this.b = new androidx.lifecycle.p();
        this.c = new androidx.lifecycle.p();
        this.d = new androidx.lifecycle.p();
        this.e = new androidx.lifecycle.p();
        this.f = new androidx.lifecycle.p();
        this.g = new androidx.lifecycle.p();
        this.h = new androidx.lifecycle.p();
        this.i = new androidx.lifecycle.p();
        this.j = new androidx.lifecycle.p();
        this.k = new androidx.lifecycle.p();
        this.l = new androidx.lifecycle.p();
        this.m = new androidx.lifecycle.p();
        this.n = new al();
        this.o = new al();
        this.p = new al();
        this.q = new al();
        this.r = new al();
        this.u = this.y.a();
        this.v = jp.co.jreast.jreastapp.commuter.common.c.e.a();
        this.w = true;
        this.x = new ArrayList();
        this.a.b(this.z.a(2131558485));
        this.b.b(this.z.a(2131558445));
        this.c.b(this.z.a(2131558474));
        this.d.b(this.z.a(2131558576));
        this.D();
    }

    private final void D() {
        androidx.lifecycle.p<Object> p2;
        Station station;
        this.s = this.A.d();
        if (this.s != null) {
            p2 = this.a;
            station = this.s;
            if (station == null) {
                j.a();
            }
            p2.b(station.getName());
        }
        this.t = this.A.e();
        if (this.t != null) {
            p2 = this.b;
            station = this.t;
            if (station == null) {
                j.a();
            }
            p2.b(station.getName());
        }
        p2 = this.e;
        station = this.s;
        boolean bl2 = true;
        boolean bl3 = station != null && this.t != null;
        p2.a(bl3);
        p2 = this.f;
        bl3 = bl2;
        if (this.s == null) {
            bl3 = this.t != null ? bl2 : false;
        }
        p2.a(bl3);
        this.x = this.A.f();
        this.C();
    }

    private final void E() {
        if (((Collection)this.x).size() < 2) {
            return;
        }
        m.e(this.x);
        this.a(this.x.get(0), r.c.a());
        this.a(this.x.get(1), r.d.a());
        this.A.a(this.x);
    }

    private final void F() {
        jp.co.jreast.jreastapp.commuter.l.a a2 = this.C;
        if (a2 != null) {
            a2.c();
        }
    }

    private final void a(String string2, String string3) {
        jp.co.jreast.jreastapp.commuter.l.a a2 = this.C;
        if (a2 != null) {
            Object object = this.s;
            if (object == null) {
                j.a();
            }
            object = ((Station)object).getName();
            Station station = this.t;
            if (station == null) {
                j.a();
            }
            a2.a((String)object, station.getName(), b.d(this.u), r.e.a(this.v), string2, string3);
        }
    }

    private final void a(Station station) {
        this.s = station;
        this.a.a(station.getName());
        this.A.a(station);
    }

    /*
     * Enabled aggressive block sorting
     */
    private final void a(Station station, int n2) {
        androidx.lifecycle.p<String> p2;
        if (n2 == r.c.a()) {
            this.g.a(true);
            p2 = this.h;
        } else {
            if (n2 != r.d.a()) {
                return;
            }
            this.j.a(true);
            p2 = this.k;
        }
        p2.a(station.getName());
    }

    private final void b(Station station) {
        this.t = station;
        this.b.a(station.getName());
        this.A.b(station);
    }

    public final void A() {
        this.n.b(r.d.a());
    }

    public final void B() {
        Object object;
        Object object2;
        int n2 = this.v;
        if (n2 == jp.co.jreast.jreastapp.commuter.common.c.d.a() || n2 == jp.co.jreast.jreastapp.commuter.common.c.c.a()) {
            object = b.a(this.u, "M\u6708d\u65e5(E)");
        } else if (this.w) {
            object = "\u73fe\u5728\u6642\u523b";
        } else {
            object2 = Calendar.getInstance();
            j.a(object2, "calendar");
            ((Calendar)object2).setTime(this.y.a());
            object = jp.co.jreast.jreastapp.commuter.g.a.a((Calendar)object2);
            ((Calendar)object2).add(5, 1);
            object2 = ((Calendar)object2).getTime();
            object = this.u.compareTo((Date)object) >= 0 && this.u.compareTo((Date)object2) < 0 ? "HH:mm" : "M\u6708d\u65e5(E) HH:mm";
            object = b.a(this.u, (String)object);
        }
        object2 = this.z.c(this.v);
        this.c.a((String)object);
        this.d.a((String)object2);
    }

    public final void C() {
        androidx.lifecycle.p<Boolean> p2;
        Boolean bl2;
        block5 : {
            switch (((Collection)this.x).size()) {
                default: {
                    return;
                }
                case 2: {
                    this.h.b(this.x.get(0).getName());
                    this.i.b(this.B.a(2131034226));
                    this.g.b(true);
                    this.k.b(this.x.get(1).getName());
                    this.l.b(this.B.a(2131034226));
                    this.j.b(true);
                    p2 = this.m;
                    bl2 = false;
                    break block5;
                }
                case 1: {
                    this.h.b(this.x.get(0).getName());
                    this.i.b(this.B.a(2131034226));
                    p2 = this.g;
                    bl2 = true;
                    break;
                }
                case 0: {
                    this.h.b(this.z.a(2131558631));
                    this.i.b(this.B.a(2131034209));
                    p2 = this.g;
                    bl2 = false;
                }
            }
            p2.b(bl2);
            this.k.b(this.z.a(2131558631));
            this.l.b(this.B.a(2131034209));
            this.j.b(false);
            p2 = this.m;
            bl2 = true;
        }
        p2.b(bl2);
    }

    public final void a(int n2) {
        if (((Collection)this.x).size() <= n2) {
            return;
        }
        this.x.remove(n2);
        this.r.b(((Collection)this.x).size());
        this.A.a(this.x);
    }

    public final void a(boolean bl2) {
        if (bl2) {
            this.F();
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public final boolean a(int var1_1, int var2_2, Intent var3_3) {
        block11 : {
            block18 : {
                block17 : {
                    block13 : {
                        block16 : {
                            block15 : {
                                block14 : {
                                    block12 : {
                                        var5_4 = false;
                                        if (var2_2 != -1 || var3_3 == null) break block11;
                                        switch (var1_1) {
                                            default: {
                                                return false;
                                            }
                                            case 2: {
                                                var6_5 = var3_3.getSerializableExtra(jp.co.jreast.jreastapp.commuter.common.b.e.a());
                                                if (var6_5 == null) throw new t("null cannot be cast to non-null type java.util.Date");
                                                this.u = (Date)var6_5;
                                                this.v = var3_3.getIntExtra(jp.co.jreast.jreastapp.commuter.common.b.c.a(), jp.co.jreast.jreastapp.commuter.common.c.e.a());
                                                this.w = var3_3.getBooleanExtra(jp.co.jreast.jreastapp.commuter.common.b.d.a(), false);
                                                this.B();
                                                return true;
                                            }
                                            case 1: 
                                        }
                                        var1_1 = var3_3.getIntExtra("STATION_TYPE", jp.co.jreast.jreastapp.commuter.common.c.e.a());
                                        var3_3 = var3_3.getSerializableExtra(jp.co.jreast.jreastapp.commuter.common.b.u.a());
                                        if (var3_3 == null) throw new t("null cannot be cast to non-null type jp.co.jreast.jreastapp.commuter.model.Station");
                                        var3_3 = (Station)var3_3;
                                        if (var1_1 != r.a.a()) break block12;
                                        this.a((Station)var3_3);
                                        break block13;
                                    }
                                    if (var1_1 != r.b.a()) break block14;
                                    this.b((Station)var3_3);
                                    break block13;
                                }
                                if (var1_1 != r.c.a()) break block15;
                                if (((Collection)this.x).size() <= 0) ** GOTO lbl-1000
                                this.x.set(0, (Station)var3_3);
                                break block16;
                            }
                            if (var1_1 == r.d.a()) {
                                ** if (((Collection)this.x).size() <= 1) goto lbl-1000
lbl-1000: // 1 sources:
                                {
                                    this.x.set((int)1, (Station)var3_3);
                                    ** GOTO lbl38
                                }
                            }
                            break block13;
lbl-1000: // 2 sources:
                            {
                                this.x.add((Station)var3_3);
                            }
                        }
                        this.a((Station)var3_3, var1_1);
                        this.A.a(this.x);
                        this.C();
                    }
                    var3_3 = this.e;
                    var4_6 = this.s != null && this.t != null;
                    var3_3.a(var4_6);
                    var3_3 = this.f;
                    if (this.s != null) break block17;
                    var4_6 = var5_4;
                    if (this.t == null) break block18;
                }
                var4_6 = true;
            }
            var3_3.a(var4_6);
            return true;
        }
        if (var1_1 != 1) return false;
        this.C();
        return false;
    }

    public final androidx.lifecycle.p<String> b() {
        return this.a;
    }

    public final androidx.lifecycle.p<String> c() {
        return this.b;
    }

    public final androidx.lifecycle.p<String> d() {
        return this.c;
    }

    public final androidx.lifecycle.p<String> e() {
        return this.d;
    }

    public final androidx.lifecycle.p<Boolean> f() {
        return this.e;
    }

    public final androidx.lifecycle.p<Boolean> g() {
        return this.f;
    }

    public final androidx.lifecycle.p<Boolean> h() {
        return this.g;
    }

    public final androidx.lifecycle.p<String> i() {
        return this.h;
    }

    public final androidx.lifecycle.p<Integer> j() {
        return this.i;
    }

    public final androidx.lifecycle.p<Boolean> k() {
        return this.j;
    }

    public final androidx.lifecycle.p<String> l() {
        return this.k;
    }

    public final androidx.lifecycle.p<Integer> m() {
        return this.l;
    }

    public final androidx.lifecycle.p<Boolean> n() {
        return this.m;
    }

    public final al<Integer> o() {
        return this.n;
    }

    public final al<Intent> p() {
        return this.o;
    }

    public final al<Bundle> q() {
        return this.p;
    }

    public final al<Integer> r() {
        return this.q;
    }

    public final al<Integer> s() {
        return this.r;
    }

    public final void t() {
        this.n.b(r.a.a());
    }

    public final void u() {
        this.n.b(r.b.a());
    }

    public final void v() {
        Intent intent = new Intent();
        intent.putExtra(jp.co.jreast.jreastapp.commuter.common.b.c.a(), this.v);
        intent.putExtra(jp.co.jreast.jreastapp.commuter.common.b.d.a(), this.w);
        intent.putExtra(jp.co.jreast.jreastapp.commuter.common.b.e.a(), (Serializable)this.u);
        this.o.b(intent);
    }

    public final void w() {
        if (this.w) {
            this.u = this.y.a();
        }
        if (this.v == jp.co.jreast.jreastapp.commuter.common.c.e.a()) {
            this.v = jp.co.jreast.jreastapp.commuter.common.c.a.a();
        }
        String string2 = "";
        String string3 = "";
        Bundle bundle = new Bundle();
        bundle.putSerializable(jp.co.jreast.jreastapp.commuter.common.b.f.a(), (Serializable)this.s);
        bundle.putSerializable(jp.co.jreast.jreastapp.commuter.common.b.i.a(), (Serializable)this.t);
        bundle.putSerializable(jp.co.jreast.jreastapp.commuter.common.b.e.a(), (Serializable)this.u);
        bundle.putSerializable(jp.co.jreast.jreastapp.commuter.common.b.c.a(), (Serializable)Integer.valueOf(this.v));
        switch (((Collection)this.x).size()) {
            default: {
                break;
            }
            case 2: {
                bundle.putSerializable(jp.co.jreast.jreastapp.commuter.common.b.l.a(), (Serializable)this.x.get(0));
                bundle.putSerializable(jp.co.jreast.jreastapp.commuter.common.b.o.a(), (Serializable)this.x.get(1));
                string2 = this.x.get(0).getName();
                string3 = this.x.get(1).getName();
                break;
            }
            case 1: {
                bundle.putSerializable(jp.co.jreast.jreastapp.commuter.common.b.l.a(), (Serializable)this.x.get(0));
                string2 = this.x.get(0).getName();
            }
        }
        this.a(string2, string3);
        this.p.b(bundle);
    }

    public final void x() {
        if (this.s != null && this.t != null) {
            Station station = this.s;
            Station station2 = this.t;
            if (station2 == null) {
                j.a();
            }
            this.a(station2);
            if (station == null) {
                j.a();
            }
            this.b(station);
            this.E();
            return;
        }
        if (this.s != null) {
            Station station = this.s;
            if (station == null) {
                j.a();
            }
            this.b(station);
            this.s = null;
            this.a.a(this.z.a(2131558485));
            this.A.a(this.s);
            return;
        }
        if (this.t != null) {
            Station station = this.t;
            if (station == null) {
                j.a();
            }
            this.a(station);
            this.t = null;
            this.b.a(this.z.a(2131558445));
            this.A.b(this.t);
        }
    }

    public final void y() {
        al<Integer> al2;
        r r2;
        switch (((Collection)this.x).size()) {
            default: {
                return;
            }
            case 1: {
                this.j.a(true);
                this.k.a(this.z.a(2131558631));
                this.m.a(false);
                al2 = this.q;
                r2 = r.d;
                break;
            }
            case 0: {
                this.h.a(this.z.a(2131558631));
                this.i.a(this.B.a(2131034209));
                this.g.a(true);
                al2 = this.q;
                r2 = r.c;
            }
        }
        al2.b(r2.a());
    }

    public final void z() {
        this.n.b(r.c.a());
    }
}

