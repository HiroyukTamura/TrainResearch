/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package jp.co.jreast.jreastapp.commuter.selectsetting;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.v;
import jp.co.jreast.jreastapp.commuter.al;
import jp.co.jreast.jreastapp.commuter.l.a;
import jp.co.jreast.jreastapp.commuter.m.p;
import jp.co.jreast.jreastapp.commuter.m.s;
import jp.co.jreast.jreastapp.commuter.model.ExpressSettings;
import jp.co.jreast.jreastapp.commuter.model.FareSettings;
import jp.co.jreast.jreastapp.commuter.model.SettingTypes;
import jp.co.jreast.jreastapp.commuter.model.Settings;
import jp.co.jreast.jreastapp.commuter.model.TransferTimeSettings;
import jp.co.jreast.jreastapp.commuter.selectsetting.b;
import jp.co.jreast.jreastapp.commuter.selectsetting.e;
import kotlin.Metadata;
import kotlin.e.b.j;
import kotlin.m;
import kotlin.t;

@Metadata(bv={1, 0, 2}, d1={"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B#\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\bJ\u000e\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&J\u000e\u0010'\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020\u0014J\u0006\u0010)\u001a\u00020*J\u000e\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020-J\u0006\u0010.\u001a\u00020*R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u001aX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000b0 8F\u00a2\u0006\u0006\u001a\u0004\b!\u0010\"R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006/"}, d2={"Ljp/co/jreast/jreastapp/commuter/selectsetting/SelectSettingViewModel;", "Landroidx/lifecycle/ViewModel;", "userSettingsRepository", "Ljp/co/jreast/jreastapp/commuter/repository/UserSettingsRepository;", "translationRepository", "Ljp/co/jreast/jreastapp/commuter/repository/TranslationRepository;", "analyticsProvider", "Ljp/co/jreast/jreastapp/commuter/provider/AnalyticsProvider;", "(Ljp/co/jreast/jreastapp/commuter/repository/UserSettingsRepository;Ljp/co/jreast/jreastapp/commuter/repository/TranslationRepository;Ljp/co/jreast/jreastapp/commuter/provider/AnalyticsProvider;)V", "_titleTextProperty", "Landroidx/lifecycle/MutableLiveData;", "", "dismissSelectSettingEvent", "Ljp/co/jreast/jreastapp/commuter/SingleLiveEvent;", "Ljava/lang/Void;", "getDismissSelectSettingEvent$app_productRelease", "()Ljp/co/jreast/jreastapp/commuter/SingleLiveEvent;", "refreshScreenEvent", "getRefreshScreenEvent$app_productRelease", "selectedValue", "", "getSelectedValue", "()I", "setSelectedValue", "(I)V", "settingType", "Ljp/co/jreast/jreastapp/commuter/model/SettingTypes;", "getSettingType", "()Ljp/co/jreast/jreastapp/commuter/model/SettingTypes;", "setSettingType", "(Ljp/co/jreast/jreastapp/commuter/model/SettingTypes;)V", "titleTextProperty", "Landroidx/lifecycle/LiveData;", "getTitleTextProperty", "()Landroidx/lifecycle/LiveData;", "getAdapter", "Ljp/co/jreast/jreastapp/commuter/selectsetting/SelectSettingAdapter;", "context", "Landroid/content/Context;", "getText", "label", "setTitle", "", "tapCheckBox", "selectedSettings", "Ljp/co/jreast/jreastapp/commuter/model/Settings;", "tapCloseButton", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class d
extends v {
    private final androidx.lifecycle.p<String> a;
    private final al<Void> b;
    private final al<Void> c;
    private SettingTypes d;
    private int e;
    private final s f;
    private final p g;
    private final a h;

    public d(s s2, p p2, a a2) {
        j.b(s2, "userSettingsRepository");
        j.b(p2, "translationRepository");
        this.f = s2;
        this.g = p2;
        this.h = a2;
        this.a = new androidx.lifecycle.p();
        this.b = new al();
        this.c = new al();
        this.d = SettingTypes.FARE;
    }

    public final String a(int n2) {
        return this.g.a(n2);
    }

    public final b a(Context context) {
        j.b((Object)context, "context");
        Enum[] arrenum = this.d;
        switch (e.b[arrenum.ordinal()]) {
            default: {
                throw new m();
            }
            case 3: {
                this.e = this.f.c().getValue();
                arrenum = TransferTimeSettings.values();
                if (arrenum != null) {
                    return new b(context, this, (Settings[])arrenum);
                }
                throw new t("null cannot be cast to non-null type kotlin.Array<jp.co.jreast.jreastapp.commuter.model.Settings>");
            }
            case 2: {
                this.e = this.f.b().getValue();
                arrenum = FareSettings.values();
                if (arrenum != null) {
                    return new b(context, this, (Settings[])arrenum);
                }
                throw new t("null cannot be cast to non-null type kotlin.Array<jp.co.jreast.jreastapp.commuter.model.Settings>");
            }
            case 1: 
        }
        this.e = this.f.a().getValue();
        arrenum = ExpressSettings.values();
        if (arrenum != null) {
            return new b(context, this, (Settings[])arrenum);
        }
        throw new t("null cannot be cast to non-null type kotlin.Array<jp.co.jreast.jreastapp.commuter.model.Settings>");
    }

    public final void a(SettingTypes settingTypes) {
        j.b((Object)settingTypes, "<set-?>");
        this.d = settingTypes;
    }

    public final void a(Settings settings) {
        j.b(settings, "selectedSettings");
        if (this.e == settings.getValue()) {
            return;
        }
        this.e = settings.getValue();
        Object object = this.d;
        switch (e.c[((Enum)object).ordinal()]) {
            default: {
                break;
            }
            case 3: {
                settings = (TransferTimeSettings)settings;
                object = this.h;
                if (object != null) {
                    object.d(this.g.a(((TransferTimeSettings)settings).getLabel()));
                }
                this.f.a((TransferTimeSettings)settings);
                break;
            }
            case 2: {
                settings = (FareSettings)settings;
                object = this.h;
                if (object != null) {
                    object.b(this.g.a(((FareSettings)settings).getLabel()));
                }
                this.f.a((FareSettings)settings);
                break;
            }
            case 1: {
                settings = (ExpressSettings)settings;
                object = this.h;
                if (object != null) {
                    object.c(this.g.a(((ExpressSettings)settings).getLabel()));
                }
                this.f.a((ExpressSettings)settings);
            }
        }
        this.c.f();
    }

    public final LiveData<String> b() {
        return this.a;
    }

    public final al<Void> c() {
        return this.b;
    }

    public final al<Void> d() {
        return this.c;
    }

    public final int e() {
        return this.e;
    }

    public final void f() {
        int n2;
        p p2;
        Object object = this.d;
        switch (e.a[((Enum)object).ordinal()]) {
            default: {
                return;
            }
            case 3: {
                object = this.a;
                p2 = this.g;
                n2 = 2131558610;
                break;
            }
            case 2: {
                object = this.a;
                p2 = this.g;
                n2 = 2131558507;
                break;
            }
            case 1: {
                object = this.a;
                p2 = this.g;
                n2 = 2131558501;
            }
        }
        ((androidx.lifecycle.p)object).b(p2.a(n2));
    }

    public final void g() {
        this.b.f();
    }
}

