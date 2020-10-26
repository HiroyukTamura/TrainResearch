/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.commuterpager.settings;

import androidx.lifecycle.v;
import jp.co.jreast.jreastapp.commuter.al;
import jp.co.jreast.jreastapp.commuter.common.b;
import jp.co.jreast.jreastapp.commuter.commuterpager.a;
import jp.co.jreast.jreastapp.commuter.m.p;
import jp.co.jreast.jreastapp.commuter.m.s;
import jp.co.jreast.jreastapp.commuter.model.ExpressSettings;
import jp.co.jreast.jreastapp.commuter.model.FareSettings;
import jp.co.jreast.jreastapp.commuter.model.RailwayLineInformation;
import jp.co.jreast.jreastapp.commuter.model.SettingTypes;
import jp.co.jreast.jreastapp.commuter.model.TransferTimeSettings;
import jp.co.jreast.jreastapp.commuter.webview.o;
import kotlin.Metadata;
import kotlin.e.b.g;

@Metadata(bv={1, 0, 2}, d1={"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0013\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\bJ\u0016\u00103\u001a\u0002042\u0006\u00105\u001a\u00020+2\u0006\u00106\u001a\u000207J\u000e\u00108\u001a\u0002072\u0006\u00109\u001a\u00020+J\u0006\u0010:\u001a\u000204J\b\u0010;\u001a\u000204H\u0002J\u0006\u0010<\u001a\u000204J\u0006\u0010=\u001a\u000204J\b\u0010>\u001a\u000204H\u0002J\u0006\u0010?\u001a\u000204J\u0006\u0010@\u001a\u000204J\u0006\u0010A\u001a\u000204J\u0006\u0010B\u001a\u000204J\u0006\u0010C\u001a\u000204J\u0006\u0010D\u001a\u000204J\u0006\u0010E\u001a\u000204J\u0006\u0010F\u001a\u000204J\u0006\u0010G\u001a\u000204J\u0006\u0010H\u001a\u000204J\u0006\u0010I\u001a\u000204R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\r0\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R \u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000f\"\u0004\b\u001a\u0010\u0011R \u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u000f\"\u0004\b\u001e\u0010\u0011R \u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001c0\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u000f\"\u0004\b!\u0010\u0011R \u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u000f\"\u0004\b%\u0010\u0011R \u0010&\u001a\b\u0012\u0004\u0012\u00020'0\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u000f\"\u0004\b)\u0010\u0011R\u0017\u0010*\u001a\b\u0012\u0004\u0012\u00020+0\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010\u0015R\u0017\u0010-\u001a\b\u0012\u0004\u0012\u00020\r0\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010\u0015R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102\u00a8\u0006J"}, d2={"Ljp/co/jreast/jreastapp/commuter/commuterpager/settings/SettingsViewModel;", "Landroidx/lifecycle/ViewModel;", "userSettingsRepository", "Ljp/co/jreast/jreastapp/commuter/repository/UserSettingsRepository;", "translationRepository", "Ljp/co/jreast/jreastapp/commuter/repository/TranslationRepository;", "analyticsProvider", "Ljp/co/jreast/jreastapp/commuter/provider/AnalyticsProvider;", "(Ljp/co/jreast/jreastapp/commuter/repository/UserSettingsRepository;Ljp/co/jreast/jreastapp/commuter/repository/TranslationRepository;Ljp/co/jreast/jreastapp/commuter/provider/AnalyticsProvider;)V", "getAnalyticsProvider", "()Ljp/co/jreast/jreastapp/commuter/provider/AnalyticsProvider;", "callBrowserEvent", "Ljp/co/jreast/jreastapp/commuter/SingleLiveEvent;", "", "getCallBrowserEvent", "()Ljp/co/jreast/jreastapp/commuter/SingleLiveEvent;", "setCallBrowserEvent", "(Ljp/co/jreast/jreastapp/commuter/SingleLiveEvent;)V", "expressSettingTextProperty", "Landroidx/lifecycle/MutableLiveData;", "getExpressSettingTextProperty", "()Landroidx/lifecycle/MutableLiveData;", "fareSettingTextProperty", "getFareSettingTextProperty", "openAcknowledgementEvent", "getOpenAcknowledgementEvent", "setOpenAcknowledgementEvent", "openFavoriteRouteEditEvent", "Ljava/lang/Void;", "getOpenFavoriteRouteEditEvent", "setOpenFavoriteRouteEditEvent", "openResetSettingsDialogEvent", "getOpenResetSettingsDialogEvent", "setOpenResetSettingsDialogEvent", "openSelectSettingEvent", "Ljp/co/jreast/jreastapp/commuter/model/SettingTypes;", "getOpenSelectSettingEvent", "setOpenSelectSettingEvent", "openWebViewEvent", "Ljp/co/jreast/jreastapp/commuter/webview/Site;", "getOpenWebViewEvent", "setOpenWebViewEvent", "resetSettingsButtonEnabled", "", "getResetSettingsButtonEnabled", "transferTimeSettingTextProperty", "getTransferTimeSettingTextProperty", "getUserSettingsRepository", "()Ljp/co/jreast/jreastapp/commuter/repository/UserSettingsRepository;", "setUserSettingsRepository", "(Ljp/co/jreast/jreastapp/commuter/repository/UserSettingsRepository;)V", "changeUserVisibleHint", "", "isVisibleToUser", "viewPagerPosition", "", "getVisibility", "isEmpty", "resetSearchConditions", "sendViewSettingsEvent", "setExpressSettingText", "setFareSettingText", "setResetSettingsButtonEnabled", "setTransferTimeSettingText", "tapAcknowledgement", "tapExpressSettingButton", "tapFareSettingButton", "tapFeedback", "tapLicense", "tapMyRouteButton", "tapPrivacyPolicy", "tapResetSettings", "tapTermsOfServices", "tapTransferTimeSettingButton", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class j
extends v {
    private final androidx.lifecycle.p<String> a;
    private final androidx.lifecycle.p<String> b;
    private final androidx.lifecycle.p<String> c;
    private final androidx.lifecycle.p<Boolean> d;
    private al<SettingTypes> e;
    private al<o> f;
    private al<String> g;
    private al<String> h;
    private al<Void> i;
    private al<Void> j;
    private s k;
    private p l;
    private final jp.co.jreast.jreastapp.commuter.l.a m;

    public j(s object, p p2, jp.co.jreast.jreastapp.commuter.l.a a2) {
        kotlin.e.b.j.b(object, "userSettingsRepository");
        kotlin.e.b.j.b(p2, "translationRepository");
        this.k = object;
        this.l = p2;
        this.m = a2;
        this.a = new androidx.lifecycle.p();
        this.b = new androidx.lifecycle.p();
        this.c = new androidx.lifecycle.p();
        object = new androidx.lifecycle.p();
        ((androidx.lifecycle.p)object).b(true);
        this.d = object;
        this.e = new al();
        this.f = new al();
        this.g = new al();
        this.h = new al();
        this.i = new al();
        this.j = new al();
    }

    private final void A() {
        jp.co.jreast.jreastapp.commuter.l.a a2 = this.m;
        if (a2 != null) {
            a2.a(this.l.a(this.k.a().getLabel()), this.l.a(this.k.b().getLabel()), this.l.a(this.k.c().getLabel()));
        }
    }

    private final void z() {
        androidx.lifecycle.p<Boolean> p2 = this.d;
        boolean bl2 = this.k.a() != ExpressSettings.DEFAULT || this.k.b() != FareSettings.IC_CARD || this.k.c() != TransferTimeSettings.NORMAL;
        p2.b(bl2);
    }

    public final int a(boolean bl2) {
        if (bl2) {
            return 0;
        }
        return 8;
    }

    public final void a(boolean bl2, int n2) {
        if (bl2 && n2 == a.a.a.a()) {
            this.A();
        }
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

    public final androidx.lifecycle.p<Boolean> e() {
        return this.d;
    }

    public final al<SettingTypes> f() {
        return this.e;
    }

    public final al<o> g() {
        return this.f;
    }

    public final al<String> h() {
        return this.g;
    }

    public final al<String> i() {
        return this.h;
    }

    public final al<Void> j() {
        return this.i;
    }

    public final al<Void> k() {
        return this.j;
    }

    public final void l() {
        this.i.b(null);
    }

    public final void m() {
        this.e.b(SettingTypes.EXPRESS);
        jp.co.jreast.jreastapp.commuter.l.a a2 = this.m;
        if (a2 != null) {
            a2.d();
        }
    }

    public final void n() {
        this.e.b(SettingTypes.FARE);
        jp.co.jreast.jreastapp.commuter.l.a a2 = this.m;
        if (a2 != null) {
            a2.e();
        }
    }

    public final void o() {
        this.e.b(SettingTypes.TRANSFER_TIME);
        jp.co.jreast.jreastapp.commuter.l.a a2 = this.m;
        if (a2 != null) {
            a2.f();
        }
    }

    public final void p() {
        this.j.f();
    }

    public final void q() {
        jp.co.jreast.jreastapp.commuter.l.a a2 = this.m;
        if (a2 != null) {
            a2.k();
        }
        this.g.b("https://docs.google.com/forms/d/e/1FAIpQLSctobC6dkjJllwyJDkFWuf94sowCEVkY2gVpdPMbNL9XiGraA/viewform");
    }

    public final void r() {
        String string2 = this.l.a(2131558580);
        this.f.b(new o(string2, "file:///android_asset/agreement/index.html", 0, null, 0, null, 0, null, 0, null, 1020, null));
    }

    public final void s() {
        this.g.b("http://www.jreast.co.jp/site/privacy.html");
    }

    public final void t() {
        this.h.b(null);
    }

    public final void u() {
        String string2 = this.l.a(2131558522);
        this.f.b(new o(string2, "file:///android_asset/licenses.html", 0, null, 0, null, 0, null, 0, null, 1020, null));
    }

    public final void v() {
        Object object = this.k.a();
        object = this.l.a(((ExpressSettings)object).getLabel());
        this.a.b((String)object);
        this.z();
    }

    public final void w() {
        Object object = this.k.b();
        object = this.l.a(((FareSettings)object).getLabel());
        this.b.b((String)object);
        this.z();
    }

    public final void x() {
        Object object = this.k.c();
        object = this.l.a(((TransferTimeSettings)object).getLabel());
        this.c.b((String)object);
        this.z();
    }

    public final void y() {
        this.k.a(b.r.a());
        this.k.a(b.s.a());
        this.k.a(b.t.a());
        this.v();
        this.w();
        this.x();
    }
}

