/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 */
package jp.co.jreast.jreastapp.commuter.m;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import jp.co.jreast.jreastapp.commuter.common.b;
import jp.co.jreast.jreastapp.commuter.model.ExpressSettings;
import jp.co.jreast.jreastapp.commuter.model.FareSettings;
import jp.co.jreast.jreastapp.commuter.model.Station;
import jp.co.jreast.jreastapp.commuter.model.TransferTimeSettings;
import kotlin.Metadata;
import kotlin.e.b.j;

@Metadata(bv={1, 0, 2}, d1={"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\b\u001a\u00020\tJ\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0012J\u0006\u0010\u0014\u001a\u00020\u0012J\u0006\u0010\u0015\u001a\u00020\tJ\u0006\u0010\u0016\u001a\u00020\tJ\u0006\u0010\u0017\u001a\u00020\tJ\u0006\u0010\u0018\u001a\u00020\u0019J\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001bJ\u0006\u0010\u001c\u001a\u00020\u0012J\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020\tJ\u0006\u0010#\u001a\u00020\u001eJ\u000e\u0010$\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020\tJ\u000e\u0010&\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020\tJ\u0010\u0010(\u001a\u00020\u001e2\b\u0010)\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010*\u001a\u00020\u001e2\b\u0010)\u001a\u0004\u0018\u00010\u000bJ\u000e\u0010+\u001a\u00020\u001e2\u0006\u0010,\u001a\u00020\u000eJ\u000e\u0010-\u001a\u00020\u001e2\u0006\u0010.\u001a\u00020\u0010J\u0006\u0010/\u001a\u00020\u001eJ\u0006\u00100\u001a\u00020\u001eJ\u000e\u00101\u001a\u00020\u001e2\u0006\u00102\u001a\u00020\u0012J\u000e\u00103\u001a\u00020\u001e2\u0006\u00104\u001a\u00020\u0012J\u000e\u00105\u001a\u00020\u001e2\u0006\u00106\u001a\u00020\u0019J\u0014\u00107\u001a\u00020\u001e2\f\u00108\u001a\b\u0012\u0004\u0012\u00020\u000b09R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006:"}, d2={"Ljp/co/jreast/jreastapp/commuter/repository/UserSettingsRepository;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "preferences", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "getActiveTabItemTag", "", "getArrivalStation", "Ljp/co/jreast/jreastapp/commuter/model/Station;", "getDepartureStation", "getExpressSettings", "Ljp/co/jreast/jreastapp/commuter/model/ExpressSettings;", "getFareSettings", "Ljp/co/jreast/jreastapp/commuter/model/FareSettings;", "getHiddenMyRouteNotice", "", "getHiddenScreenCaptureNotice", "getMixPanelOptOut", "getSavedAppVersionCode", "getTrainLocationPage", "getTrainServiceArea", "getTransferTimeSettings", "Ljp/co/jreast/jreastapp/commuter/model/TransferTimeSettings;", "getViaStationList", "", "isUpdate", "remove", "", "key", "", "saveActiveTabItemTag", "tab", "saveCurrentVersion", "saveTrainLocationPage", "page", "saveTrainServiceArea", "areaCode", "setArrivalStation", "station", "setDepartureStation", "setExpressSettings", "expressSetting", "setFareSettings", "fareSetting", "setHiddenMyRouteNotice", "setHiddenScreenCaptureNotice", "setMixPanelOptOut", "flag", "setSavedTokenFlag", "savedTokenFlag", "setTransferTimeSettings", "transferTimeSetting", "setViaStationList", "stationList", "", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class s {
    private final SharedPreferences a;

    public s(Context context) {
        j.b((Object)context, "context");
        this.a = context.getSharedPreferences(b.C.a(), 0);
    }

    /*
     * Enabled aggressive block sorting
     */
    public final ExpressSettings a() {
        int n2 = this.a.getInt(b.r.a(), ExpressSettings.DEFAULT.getValue());
        if (n2 == ExpressSettings.USE.getValue()) {
            return ExpressSettings.USE;
        }
        if (n2 == ExpressSettings.DEFAULT.getValue() || n2 != ExpressSettings.UNUSE.getValue()) {
            return ExpressSettings.DEFAULT;
        }
        return ExpressSettings.UNUSE;
    }

    public final void a(int n2) {
        this.a.edit().putInt(b.K.a(), n2).apply();
    }

    public final void a(String string2) {
        j.b(string2, "key");
        string2 = this.a.edit().remove(string2);
        if (string2 != null) {
            string2.apply();
        }
    }

    public final void a(List<Station> editor) {
        block5 : {
            j.b(editor, "stationList");
            switch (((Collection)editor).size()) {
                default: {
                    return;
                }
                case 2: {
                    editor = this.a.edit().putString(b.n.a(), editor.get(0).getName()).putString(b.m.a(), ((Station)editor.get(0)).getCode()).putString(b.q.a(), ((Station)editor.get(1)).getName()).putString(b.p.a(), ((Station)editor.get(1)).getCode());
                    break block5;
                }
                case 1: {
                    editor = this.a.edit().putString(b.n.a(), editor.get(0).getName()).putString(b.m.a(), ((Station)editor.get(0)).getCode());
                    break;
                }
                case 0: {
                    editor = this.a.edit().putString(b.n.a(), "").putString(b.m.a(), "");
                }
            }
            editor = editor.putString(b.q.a(), "").putString(b.p.a(), "");
        }
        editor.apply();
    }

    public final void a(ExpressSettings expressSettings) {
        j.b(expressSettings, "expressSetting");
        this.a.edit().putInt(b.r.a(), expressSettings.getValue()).apply();
    }

    public final void a(FareSettings fareSettings) {
        j.b(fareSettings, "fareSetting");
        this.a.edit().putInt(b.s.a(), fareSettings.getValue()).apply();
    }

    public final void a(Station station) {
        String string2 = "";
        String string3 = "";
        if (station != null) {
            string2 = station.getCode();
            string3 = station.getName();
        }
        this.a.edit().putString(b.h.a(), string3).putString(b.g.a(), string2).apply();
    }

    public final void a(TransferTimeSettings transferTimeSettings) {
        j.b(transferTimeSettings, "transferTimeSetting");
        this.a.edit().putInt(b.t.a(), transferTimeSettings.getValue()).apply();
    }

    public final void a(boolean bl2) {
        this.a.edit().putBoolean(b.R.a(), bl2).apply();
    }

    /*
     * Enabled aggressive block sorting
     */
    public final FareSettings b() {
        int n2 = this.a.getInt(b.s.a(), FareSettings.IC_CARD.getValue());
        if (n2 == FareSettings.IC_CARD.getValue() || n2 != FareSettings.CASH.getValue()) {
            return FareSettings.IC_CARD;
        }
        return FareSettings.CASH;
    }

    public final void b(int n2) {
        this.a.edit().putInt(b.P.a(), n2).apply();
    }

    public final void b(Station station) {
        String string2 = "";
        String string3 = "";
        if (station != null) {
            string2 = station.getCode();
            string3 = station.getName();
        }
        this.a.edit().putString(b.k.a(), string3).putString(b.j.a(), string2).apply();
    }

    /*
     * Enabled aggressive block sorting
     */
    public final TransferTimeSettings c() {
        block6 : {
            block5 : {
                int n2 = this.a.getInt(b.t.a(), TransferTimeSettings.NORMAL.getValue());
                if (n2 == TransferTimeSettings.FAST.getValue()) {
                    return TransferTimeSettings.FAST;
                }
                if (n2 == TransferTimeSettings.NORMAL.getValue()) break block5;
                if (n2 == TransferTimeSettings.SLOW.getValue()) {
                    return TransferTimeSettings.SLOW;
                }
                if (n2 == TransferTimeSettings.MORE_SLOW.getValue()) break block6;
            }
            return TransferTimeSettings.NORMAL;
        }
        return TransferTimeSettings.MORE_SLOW;
    }

    public final Station d() {
        String string2 = this.a.getString(b.h.a(), "");
        String string3 = this.a.getString(b.g.a(), "");
        j.a((Object)string2, "name");
        int n2 = ((CharSequence)string2).length();
        int n3 = 0;
        n2 = n2 == 0 ? 1 : 0;
        if (n2 == 0) {
            j.a((Object)string3, "code");
            n2 = n3;
            if (((CharSequence)string3).length() == 0) {
                n2 = 1;
            }
            if (n2 == 0) {
                return new Station(string3, string2);
            }
        }
        return null;
    }

    public final Station e() {
        String string2 = this.a.getString(b.k.a(), "");
        String string3 = this.a.getString(b.j.a(), "");
        j.a((Object)string2, "name");
        int n2 = ((CharSequence)string2).length();
        int n3 = 0;
        n2 = n2 == 0 ? 1 : 0;
        if (n2 == 0) {
            j.a((Object)string3, "code");
            n2 = n3;
            if (((CharSequence)string3).length() == 0) {
                n2 = 1;
            }
            if (n2 == 0) {
                return new Station(string3, string2);
            }
        }
        return null;
    }

    public final List<Station> f() {
        List list = new ArrayList();
        String string2 = this.a.getString(b.n.a(), "");
        String string3 = this.a.getString(b.m.a(), "");
        j.a((Object)string2, "name1");
        int n2 = ((CharSequence)string2).length();
        int n3 = 0;
        n2 = n2 == 0 ? 1 : 0;
        if (n2 == 0) {
            j.a((Object)string3, "code1");
            n2 = ((CharSequence)string3).length() == 0 ? 1 : 0;
            if (n2 == 0) {
                list.add(new Station(string3, string2));
            }
        }
        string2 = this.a.getString(b.q.a(), "");
        string3 = this.a.getString(b.p.a(), "");
        j.a((Object)string2, "name2");
        n2 = ((CharSequence)string2).length() == 0 ? 1 : 0;
        if (n2 == 0) {
            j.a((Object)string3, "code2");
            n2 = n3;
            if (((CharSequence)string3).length() == 0) {
                n2 = 1;
            }
            if (n2 == 0) {
                list.add(new Station(string3, string2));
            }
        }
        return list;
    }

    public final boolean g() {
        SharedPreferences sharedPreferences = this.a;
        String string2 = b.F.a();
        boolean bl2 = false;
        if (sharedPreferences.getInt(string2, 0) < 268) {
            bl2 = true;
        }
        return bl2;
    }

    public final void h() {
        this.a.edit().putInt(b.F.a(), 268).apply();
    }

    public final int i() {
        return this.a.getInt(b.F.a(), 0);
    }

    public final void j() {
        this.a.edit().putBoolean(b.D.a(), true).apply();
    }

    public final boolean k() {
        return this.a.getBoolean(b.D.a(), false);
    }

    public final void l() {
        this.a.edit().putBoolean(b.E.a(), true).apply();
    }

    public final boolean m() {
        return this.a.getBoolean(b.E.a(), false);
    }

    public final int n() {
        return this.a.getInt(b.K.a(), 2);
    }

    public final int o() {
        return this.a.getInt(b.P.a(), 0);
    }

    public final boolean p() {
        return this.a.getBoolean(b.R.a(), false);
    }
}

