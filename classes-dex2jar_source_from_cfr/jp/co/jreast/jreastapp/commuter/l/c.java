/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  org.json.JSONObject
 */
package jp.co.jreast.jreastapp.commuter.l;

import android.content.Context;
import com.mixpanel.android.b.n;
import g.a.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import jp.co.jreast.jreastapp.commuter.m.s;
import jp.co.jreast.jreastapp.commuter.model.BoardingStation;
import jp.co.jreast.jreastapp.commuter.model.FavoriteRoute;
import jp.co.jreast.jreastapp.commuter.model.RailwayLine;
import jp.co.jreast.jreastapp.commuter.model.Route;
import kotlin.Metadata;
import kotlin.a.af;
import kotlin.a.m;
import kotlin.e.b.g;
import kotlin.e.b.j;
import kotlin.e.b.y;
import org.json.JSONObject;

@Metadata(bv={1, 0, 2}, d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 H2\u00020\u0001:\u0001HB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\r\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0011H\u0016J\b\u0010\u0016\u001a\u00020\u0011H\u0016J\b\u0010\u0017\u001a\u00020\u0011H\u0016J8\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u0005H\u0016J\b\u0010\u001f\u001a\u00020\u0011H\u0016J\b\u0010 \u001a\u00020\u0011H\u0016J\"\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00050#H\u0002J\u001c\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00050#2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00050#H\u0002J\b\u0010%\u001a\u00020\u0005H\u0016J\u0010\u0010&\u001a\u00020\u00112\u0006\u0010'\u001a\u00020\u0005H\u0016J\u0018\u0010(\u001a\u00020\u00112\u0006\u0010)\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u0005H\u0016J\b\u0010+\u001a\u00020\u0011H\u0016J\b\u0010,\u001a\u00020\u0011H\u0016J\u0010\u0010-\u001a\u00020\u00112\u0006\u0010)\u001a\u00020\u0005H\u0016J\u0010\u0010.\u001a\u00020\u00112\u0006\u0010/\u001a\u00020\u0005H\u0016J\u0010\u00100\u001a\u00020\u00112\u0006\u00101\u001a\u00020\u0005H\u0016J\u0010\u00102\u001a\u00020\u00112\u0006\u00103\u001a\u00020\u0014H\u0016J\u0016\u00104\u001a\u00020\u00112\f\u00105\u001a\b\u0012\u0004\u0012\u0002060#H\u0016J\u0010\u00107\u001a\u00020\u00112\u0006\u00108\u001a\u00020\u0005H\u0016J\u0010\u00109\u001a\u00020\u00112\u0006\u0010:\u001a\u00020\u0014H\u0016J\b\u0010;\u001a\u00020\u0011H\u0016J\u0018\u0010<\u001a\u00020\u00112\u0006\u0010:\u001a\u00020\u00142\u0006\u0010=\u001a\u00020\u0005H\u0016J\u0010\u0010>\u001a\u00020\u00112\u0006\u0010?\u001a\u00020\u0014H\u0016J\u0010\u0010@\u001a\u00020\u00112\u0006\u0010=\u001a\u00020\u0005H\u0016J \u0010A\u001a\u00020\u00112\u0006\u0010/\u001a\u00020\u00052\u0006\u00101\u001a\u00020\u00052\u0006\u00108\u001a\u00020\u0005H\u0016J\b\u0010B\u001a\u00020\u0011H\u0016J\u0010\u0010C\u001a\u00020\u00112\u0006\u0010D\u001a\u00020\u0005H\u0016J\u0010\u0010E\u001a\u00020\u00112\u0006\u0010D\u001a\u00020\u0005H\u0016J\u0010\u0010F\u001a\u00020\u00112\u0006\u0010G\u001a\u00020\u0014H\u0016R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006I"}, d2={"Ljp/co/jreast/jreastapp/commuter/provider/MixpanelAnalyticsProvider;", "Ljp/co/jreast/jreastapp/commuter/provider/AnalyticsProvider;", "()V", "events", "", "", "mixpanelInstance", "Lcom/mixpanel/android/mpmetrics/MixpanelAPI;", "getMixpanelInstance", "()Lcom/mixpanel/android/mpmetrics/MixpanelAPI;", "setMixpanelInstance", "(Lcom/mixpanel/android/mpmetrics/MixpanelAPI;)V", "properties", "create", "context", "Landroid/content/Context;", "deletedRoute", "", "didTapBottomTab", "position", "", "didTapExpressSettingButton", "didTapFareSettingButton", "didTapFeedbackButton", "didTapSearchButton", "departureStation", "arrivalStation", "selectedDateTime", "departureOrArrival", "firstViaStation", "secondViaStation", "didTapTimetableButton", "didTapTransferTimeSettingButton", "generateSetList", "departureAndArrivalList", "", "generateUnsetList", "getDistinctId", "identify", "uuid", "logError", "name", "message", "optOutTracking", "registeredRoute", "setNickname", "updateExpressSettings", "expressSetting", "updateFareSettings", "fareSetting", "updateFavoriteRouteCount", "count", "updateMyRouteSettings", "favRouteList", "Ljp/co/jreast/jreastapp/commuter/model/FavoriteRoute;", "updateTransferTimeSettings", "transferTimeSetting", "viewFavoriteRouteDetail", "numberOfDelayedLines", "viewHome", "viewRouteDetail", "viewTypeName", "viewSearchResults", "numberOfRoutes", "viewServiceStatus", "viewSettings", "viewTimetables", "viewTrainLocationDetail", "title", "viewTrainLocationDetailOfSearch", "viewTrainServiceArea", "areaCode", "Companion", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class c
implements jp.co.jreast.jreastapp.commuter.l.a {
    public static final a b = new a(null);
    public n a;
    private final Map<String, String> c = af.a(kotlin.s.a(a.a.a.a(), "Home\u753b\u9762\u306b\u3044\u308b"), kotlin.s.a(a.a.b.a(), "\u30eb\u30fc\u30c8\u691c\u7d22\u7d50\u679c\u3092\u8868\u793a\u3057\u305f"), kotlin.s.a(a.a.c.a(), "\u30eb\u30fc\u30c8\u8a73\u7d30\u753b\u9762\u306b\u3044\u308b"), kotlin.s.a(a.a.d.a(), "\u904b\u884c\u60c5\u5831\u30e2\u30fc\u30c0\u30eb\u753b\u9762\u306b\u3044\u308b"), kotlin.s.a(a.a.e.a(), "Favorite\u753b\u9762\u306b\u3044\u308b"), kotlin.s.a(a.a.f.a(), "\u518d\u767b\u9332\u3092\u4fc3\u3059\u5439\u304d\u51fa\u3057\u304c\u8868\u793a\u3055\u308c\u305f"), kotlin.s.a(a.a.g.a(), "\u3053\u306e\u30eb\u30fc\u30c8\u3092\u524a\u9664\u3057\u3066\u518d\u767b\u9332\u30dc\u30bf\u30f3\u3092\u62bc\u3057\u305f"), kotlin.s.a(a.a.h.a(), "\u8a2d\u5b9a\u753b\u9762\u306b\u3044\u308b"), kotlin.s.a(a.a.i.a(), "\u691c\u7d22\u30dc\u30bf\u30f3\u3092\u62bc\u3057\u305f"), kotlin.s.a(a.a.j.a(), "\u767b\u9332\u30dc\u30bf\u30f3\u3092\u62bc\u3057\u305f"), kotlin.s.a(a.a.k.a(), "\u524a\u9664\u30dc\u30bf\u30f3\u3092\u62bc\u3057\u305f"), kotlin.s.a(a.a.l.a(), "\u6642\u523b\u8868\u3092\u898b\u308b\u30dc\u30bf\u30f3\u3092\u62bc\u3057\u305f"), kotlin.s.a(a.a.m.a(), "\u6642\u523b\u8868\u753b\u9762\u306b\u3044\u308b"), kotlin.s.a(a.a.n.a(), "\u6709\u6599\u7279\u6025\u30dc\u30bf\u30f3\u3092\u62bc\u3057\u305f"), kotlin.s.a(a.a.o.a(), "\u904b\u8cc3\u8a2d\u5b9a\u30dc\u30bf\u30f3\u3092\u62bc\u3057\u305f"), kotlin.s.a(a.a.p.a(), "\u4e57\u63db\u901f\u5ea6\u30dc\u30bf\u30f3\u3092\u62bc\u3057\u305f"), kotlin.s.a(a.a.q.a(), "\u30d5\u30a3\u30fc\u30c9\u30d0\u30c3\u30af\u3092\u9001\u308b\u3092\u62bc\u3057\u305f"), kotlin.s.a(a.a.G.a(), "\u904b\u884c\u60c5\u5831\uff08\u6771\u5317\u30a8\u30ea\u30a2\uff09\u3092\u8868\u793a\u3057\u305f"), kotlin.s.a(a.a.H.a(), "\u904b\u884c\u60c5\u5831\uff08\u95a2\u6771\u30a8\u30ea\u30a2\uff09\u3092\u8868\u793a\u3057\u305f"), kotlin.s.a(a.a.I.a(), "\u904b\u884c\u60c5\u5831\uff08\u4fe1\u8d8a\u30a8\u30ea\u30a2\uff09\u3092\u8868\u793a\u3057\u305f"), kotlin.s.a(a.a.J.a(), "\u904b\u884c\u60c5\u5831\uff08\u65b0\u5e79\u7dda\uff09\u3092\u8868\u793a\u3057\u305f"), kotlin.s.a(a.a.K.a(), "\u7d4c\u8def\u691c\u7d22\u30bf\u30d6\u3092\u62bc\u3057\u305f"), kotlin.s.a(a.a.L.a(), "\u904b\u884c\u60c5\u5831\u30bf\u30d6\u3092\u62bc\u3057\u305f"), kotlin.s.a(a.a.M.a(), "\u5217\u8eca\u8d70\u884c\u4f4d\u7f6e\u30bf\u30d6\u3092\u62bc\u3057\u305f"), kotlin.s.a(a.a.N.a(), "\u8d70\u884c\u4f4d\u7f6e\uff08%s\uff09\u3092\u8868\u793a\u3057\u305f"), kotlin.s.a(a.a.O.a(), "\u6587\u5b57\u691c\u7d22\u3067\u8d70\u884c\u4f4d\u7f6e\uff08%s\uff09\u3092\u8868\u793a\u3057\u305f"));
    private final Map<String, String> d = af.a(kotlin.s.a(a.a.r.a(), "\u691c\u7d22\u7d50\u679c\u4ef6\u6570"), kotlin.s.a(a.a.s.a(), "\u9045\u5ef6\u8def\u7dda\u6570"), kotlin.s.a(a.a.t.a(), "\u51fa\u767a\u99c5"), kotlin.s.a(a.a.u.a(), "\u5230\u7740\u99c5"), kotlin.s.a(a.a.v.a(), "\u6642\u9593"), kotlin.s.a(a.a.w.a(), "\u767a\u7740"), kotlin.s.a(a.a.x.a(), "\u30e1\u30c3\u30bb\u30fc\u30b8"), kotlin.s.a(a.a.y.a(), "\u304a\u6c17\u306b\u5165\u308a\u767b\u9332\u4ef6\u6570"), kotlin.s.a(a.a.z.a(), "\u904b\u8cc3\u8a2d\u5b9a"), kotlin.s.a(a.a.A.a(), "\u6709\u6599\u7279\u6025"), kotlin.s.a(a.a.B.a(), "\u4e57\u63db\u901f\u5ea6"), kotlin.s.a(a.a.C.a(), "\u9077\u79fb\u5143"), kotlin.s.a(a.a.D.a(), "\u7d4c\u7531\u99c51"), kotlin.s.a(a.a.E.a(), "\u7d4c\u7531\u99c52"), kotlin.s.a(a.a.F.a(), "\u51fa\u767a\u99c5\u2192\u5230\u7740\u99c5"));

    private final Map<String, String> b(List<String> list) {
        Map map = new LinkedHashMap();
        int n2 = ((Collection)list).size();
        int n3 = 0;
        while (n3 < n2) {
            String string2 = this.d.get(a.a.F.a());
            Object object = y.a;
            object = new Object[1];
            int n4 = n3 + 1;
            object[0] = n4;
            object = String.format("%02d", Arrays.copyOf(object, ((Object[])object).length));
            j.a(object, "java.lang.String.format(format, *args)");
            map.put(j.a(string2, object), list.get(n3));
            n3 = n4;
        }
        return map;
    }

    private final List<String> c(List<String> list) {
        List list2 = new ArrayList();
        for (int i2 = 0; i2 < 20; ++i2) {
            if (i2 < ((Collection)list).size()) continue;
            String string2 = this.d.get(a.a.F.a());
            Object object = y.a;
            object = new Object[]{i2 + 1};
            object = String.format("%02d", Arrays.copyOf(object, ((Object[])object).length));
            j.a(object, "java.lang.String.format(format, *args)");
            list2.add(j.a(string2, object));
        }
        return list2;
    }

    public jp.co.jreast.jreastapp.commuter.l.a a(Context object) {
        j.b(object, "context");
        if (!j.a((Object)"release", (Object)"release") && !j.a((Object)"release", (Object)"alpha")) {
            return null;
        }
        Object object2 = n.a((Context)object, "8e37a7b71c73590a15326acc7c9e82d0");
        j.a(object2, "MixpanelAPI.getInstance(\u2026ildConfig.MIXPANEL_TOKEN)");
        this.a = object2;
        if (new s((Context)object).p()) {
            this.a();
        }
        if ((object = this.a) == null) {
            j.b("mixpanelInstance");
        }
        if ((object2 = this.a) == null) {
            j.b("mixpanelInstance");
        }
        ((n)object).a(((n)object2).b());
        object = this.a;
        if (object == null) {
            j.b("mixpanelInstance");
        }
        object = ((n)object).c();
        object2 = this.a;
        if (object2 == null) {
            j.b("mixpanelInstance");
        }
        object.a(((n)object2).b());
        object = this.a;
        if (object == null) {
            j.b("mixpanelInstance");
        }
        object = ((n)object).c();
        object2 = this.a;
        if (object2 == null) {
            j.b("mixpanelInstance");
        }
        object.a("Distinct ID", ((n)object2).b());
        object = g.a.a.a("MixpanelEvent");
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("id:");
        n n2 = this.a;
        if (n2 == null) {
            j.b("mixpanelInstance");
        }
        ((StringBuilder)object2).append(n2.b());
        ((a.b)object).a(((StringBuilder)object2).toString(), new Object[0]);
        return this;
    }

    @Override
    public void a() {
        n n2 = this.a;
        if (n2 == null) {
            j.b("mixpanelInstance");
        }
        n2.e();
    }

    @Override
    public void a(int n2) {
        g.a.a.a("MixpanelEvent").a("\u30eb\u30fc\u30c8\u691c\u7d22\u7d50\u679c\u3092\u8868\u793a\u3057\u305f,\u691c\u7d22\u7d50\u679c\u4ef6\u6570:%d", new Object[]{n2});
        n n3 = this.a;
        if (n3 == null) {
            j.b("mixpanelInstance");
        }
        String string2 = this.c.get(a.a.b.a());
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(this.d.get(a.a.r.a()), n2);
        n3.a(string2, jSONObject);
    }

    @Override
    public void a(int n2, String string2) {
        j.b(string2, "viewTypeName");
        g.a.a.a("MixpanelEvent").a("\u30eb\u30fc\u30c8\u8a73\u7d30\u753b\u9762\u306b\u3044\u308b(%s),\u9045\u5ef6\u8def\u7dda\u6570:%d", string2, n2);
        n n3 = this.a;
        if (n3 == null) {
            j.b("mixpanelInstance");
        }
        String string3 = this.c.get(a.a.c.a());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('\uff08');
        stringBuilder.append(string2);
        stringBuilder.append('\uff09');
        string2 = j.a(string3, (Object)stringBuilder.toString());
        string3 = new JSONObject();
        string3.put(this.d.get(a.a.s.a()), n2);
        n3.a(string2, (JSONObject)string3);
    }

    @Override
    public void a(String string2) {
        j.b(string2, "viewTypeName");
        g.a.a.a("MixpanelEvent").a("\u904b\u884c\u60c5\u5831\u30e2\u30fc\u30c0\u30eb\u753b\u9762\u306b\u3044\u308b(%s)", string2);
        n n2 = this.a;
        if (n2 == null) {
            j.b("mixpanelInstance");
        }
        String string3 = this.c.get(a.a.d.a());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('\uff08');
        stringBuilder.append(string2);
        stringBuilder.append('\uff09');
        n2.b(j.a(string3, (Object)stringBuilder.toString()));
    }

    @Override
    public void a(String string2, String string3) {
        j.b(string2, "name");
        j.b(string3, "message");
        n n2 = this.a;
        if (n2 == null) {
            j.b("mixpanelInstance");
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(this.d.get(a.a.x.a()), (Object)string3);
        n2.a(string2, jSONObject);
    }

    @Override
    public void a(String string2, String string3, String string4) {
        j.b(string2, "expressSetting");
        j.b(string3, "fareSetting");
        j.b(string4, "transferTimeSetting");
        g.a.a.a("MixpanelEvent").a("\u8a2d\u5b9a\u753b\u9762\u306b\u3044\u308b,\u6709\u6599\u7279\u6025:%s,\u904b\u8cc3\u8a2d\u5b9a:%s,\u4e57\u63db\u901f\u5ea6:%s", string2, string3, string4);
        g.a.a.a("MixpanelEvent").a("People\u5c5e\u6027,\u6709\u6599\u7279\u6025:%s,\u904b\u8cc3\u8a2d\u5b9a:%s,\u4e57\u63db\u901f\u5ea6:%s", string2, string3, string4);
        Object object = this.a;
        if (object == null) {
            j.b("mixpanelInstance");
        }
        String string5 = this.c.get(a.a.h.a());
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(this.d.get(a.a.A.a()), (Object)string2);
        jSONObject.put(this.d.get(a.a.z.a()), (Object)string3);
        jSONObject.put(this.d.get(a.a.B.a()), (Object)string4);
        ((n)object).a(string5, jSONObject);
        object = this.a;
        if (object == null) {
            j.b("mixpanelInstance");
        }
        object = ((n)object).c();
        string5 = new JSONObject();
        string5.put(this.d.get(a.a.A.a()), (Object)string2);
        string5.put(this.d.get(a.a.z.a()), (Object)string3);
        string5.put(this.d.get(a.a.B.a()), (Object)string4);
        object.a((JSONObject)string5);
    }

    @Override
    public void a(String string2, String string3, String string4, String string5, String string6, String string7) {
        j.b(string2, "departureStation");
        j.b(string3, "arrivalStation");
        j.b(string4, "selectedDateTime");
        j.b(string5, "departureOrArrival");
        j.b(string6, "firstViaStation");
        j.b(string7, "secondViaStation");
        g.a.a.a("MixpanelEvent").a("\u691c\u7d22\u30dc\u30bf\u30f3\u3092\u62bc\u3057\u305f,\u51fa\u767a\u99c5:%s,\u5230\u7740\u99c5:%s,\u6642\u9593:%s,\u767a\u7740:%s,\u7d4c\u7531\u99c51:%s,\u7d4c\u7531\u99c52:%s", string2, string3, string4, string5, string6, string7);
        n n2 = this.a;
        if (n2 == null) {
            j.b("mixpanelInstance");
        }
        String string8 = this.c.get(a.a.i.a());
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(this.d.get(a.a.t.a()), (Object)string2);
        jSONObject.put(this.d.get(a.a.u.a()), (Object)string3);
        jSONObject.put(this.d.get(a.a.v.a()), (Object)string4);
        jSONObject.put(this.d.get(a.a.w.a()), (Object)string5);
        jSONObject.put(this.d.get(a.a.D.a()), (Object)string6);
        jSONObject.put(this.d.get(a.a.E.a()), (Object)string7);
        n2.a(string8, jSONObject);
    }

    @Override
    public void a(List<FavoriteRoute> iterator) {
        block9 : {
            List list;
            Object object2;
            block8 : {
                j.b(iterator, "favRouteList");
                g.a.a.a("MixpanelEvent").a("updateMyRouteSettings", new Object[0]);
                object2 = new ArrayList();
                List object32 = new ArrayList();
                list = new ArrayList();
                if (((Collection)((Object)iterator)).size() <= 0) break block8;
                iterator = iterator.iterator();
                while (iterator.hasNext()) {
                    Object object = (FavoriteRoute)((Object)iterator.next());
                    String string2 = ((FavoriteRoute)object).getRoute().getLines().get(0).getFrom().getName();
                    object = ((FavoriteRoute)object).getRoute().getLines().get(((Collection)((FavoriteRoute)object).getRoute().getLines()).size() - 1).getTo().getName();
                    object2.add(string2);
                    object32.add(object);
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(string2);
                    stringBuilder.append("\u2192");
                    stringBuilder.append((String)object);
                    list.add(stringBuilder.toString());
                }
                iterator = new JSONObject();
                iterator.put(this.d.get(a.a.t.a()), object2);
                iterator.put(this.d.get(a.a.u.a()), (Object)object32);
                iterator.put(this.d.get(a.a.F.a()), (Object)list);
                for (Map.Entry<String, String> entry : this.b(list).entrySet()) {
                    iterator.put(entry.getKey(), (Object)entry.getValue());
                }
                object2 = this.a;
                if (object2 == null) {
                    j.b("mixpanelInstance");
                }
                ((n)object2).c().a((JSONObject)iterator);
                if (((Collection)list).size() >= 20) break block9;
                for (String string3 : this.c(list)) {
                    object2 = this.a;
                    if (object2 == null) {
                        j.b("mixpanelInstance");
                    }
                    ((n)object2).c().b(string3);
                }
                break block9;
            }
            iterator = m.c(a.a.t.a(), a.a.u.a(), a.a.F.a());
            Iterator<String> iterator2 = this.c(list).iterator();
            while (iterator2.hasNext()) {
                iterator.add(iterator2.next());
            }
            iterator = iterator.iterator();
            while (iterator.hasNext()) {
                String string4 = (String)iterator.next();
                object2 = this.a;
                if (object2 == null) {
                    j.b("mixpanelInstance");
                }
                ((n)object2).c().b(string4);
            }
        }
    }

    @Override
    public String b() {
        Object object = this.a;
        if (object == null) {
            j.b("mixpanelInstance");
        }
        object = ((n)object).b();
        j.a(object, "mixpanelInstance.distinctId");
        return object;
    }

    @Override
    public void b(int n2) {
        g.a.a.a("MixpanelEvent").a("Favorite\u753b\u9762\u306b\u3044\u308b,\u9045\u5ef6\u8def\u7dda\u6570:%d", new Object[]{n2});
        n n3 = this.a;
        if (n3 == null) {
            j.b("mixpanelInstance");
        }
        String string2 = this.c.get(a.a.e.a());
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(this.d.get(a.a.s.a()), n2);
        n3.a(string2, jSONObject);
    }

    @Override
    public void b(String string2) {
        j.b(string2, "fareSetting");
        g.a.a.a("MixpanelEvent").a("People\u5c5e\u6027,\u904b\u8cc3\u8a2d\u5b9a:%s", string2);
        Object object = this.a;
        if (object == null) {
            j.b("mixpanelInstance");
        }
        object = ((n)object).c();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(this.d.get(a.a.z.a()), (Object)string2);
        object.a(jSONObject);
    }

    @Override
    public void c() {
        g.a.a.a("MixpanelEvent").a("Home\u753b\u9762\u306b\u3044\u308b", new Object[0]);
        n n2 = this.a;
        if (n2 == null) {
            j.b("mixpanelInstance");
        }
        n2.b(this.c.get(a.a.a.a()));
    }

    @Override
    public void c(int n2) {
        g.a.a.a("MixpanelEvent").a("People\u5c5e\u6027,\u304a\u6c17\u306b\u5165\u308a\u767b\u9332\u4ef6\u6570:%d", new Object[]{n2});
        Object object = this.a;
        if (object == null) {
            j.b("mixpanelInstance");
        }
        object = ((n)object).c();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(this.d.get(a.a.y.a()), n2);
        object.a(jSONObject);
    }

    @Override
    public void c(String string2) {
        j.b(string2, "expressSetting");
        g.a.a.a("MixpanelEvent").a("People\u5c5e\u6027,\u6709\u6599\u7279\u6025:%s", string2);
        Object object = this.a;
        if (object == null) {
            j.b("mixpanelInstance");
        }
        object = ((n)object).c();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(this.d.get(a.a.A.a()), (Object)string2);
        object.a(jSONObject);
    }

    @Override
    public void d() {
        g.a.a.a("MixpanelEvent").a("\u6709\u6599\u7279\u6025\u30dc\u30bf\u30f3\u3092\u62bc\u3057\u305f", new Object[0]);
        n n2 = this.a;
        if (n2 == null) {
            j.b("mixpanelInstance");
        }
        n2.b(this.c.get(a.a.n.a()));
    }

    @Override
    public void d(int n2) {
        Map<String, String> map;
        n n3;
        a.a a2;
        g.a.a.a("MixpanelEvent").a("\u904b\u884c\u60c5\u5831\u3092\u8868\u793a\u3057\u305f,AreaCode:%d", new Object[]{n2});
        switch (n2) {
            default: {
                return;
            }
            case 4: {
                n3 = this.a;
                if (n3 == null) {
                    j.b("mixpanelInstance");
                }
                map = this.c;
                a2 = a.a.J;
                break;
            }
            case 3: {
                n3 = this.a;
                if (n3 == null) {
                    j.b("mixpanelInstance");
                }
                map = this.c;
                a2 = a.a.I;
                break;
            }
            case 2: {
                n3 = this.a;
                if (n3 == null) {
                    j.b("mixpanelInstance");
                }
                map = this.c;
                a2 = a.a.H;
                break;
            }
            case 1: {
                n3 = this.a;
                if (n3 == null) {
                    j.b("mixpanelInstance");
                }
                map = this.c;
                a2 = a.a.G;
            }
        }
        n3.b(map.get(a2.a()));
    }

    @Override
    public void d(String string2) {
        j.b(string2, "transferTimeSetting");
        g.a.a.a("MixpanelEvent").a("People\u5c5e\u6027,\u4e57\u63db\u901f\u5ea6:%s", string2);
        Object object = this.a;
        if (object == null) {
            j.b("mixpanelInstance");
        }
        object = ((n)object).c();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(this.d.get(a.a.B.a()), (Object)string2);
        object.a(jSONObject);
    }

    @Override
    public void e() {
        g.a.a.a("MixpanelEvent").a("\u904b\u8cc3\u8a2d\u5b9a\u30dc\u30bf\u30f3\u3092\u62bc\u3057\u305f", new Object[0]);
        n n2 = this.a;
        if (n2 == null) {
            j.b("mixpanelInstance");
        }
        n2.b(this.c.get(a.a.o.a()));
    }

    @Override
    public void e(int n2) {
        Map<String, String> map;
        n n3;
        a.a a2;
        g.a.a.a("MixpanelEvent").a("\u30bf\u30d6\u3092\u62bc\u3057\u305f,position:%d", new Object[]{n2});
        switch (n2) {
            default: {
                return;
            }
            case 2: {
                n3 = this.a;
                if (n3 == null) {
                    j.b("mixpanelInstance");
                }
                map = this.c;
                a2 = a.a.M;
                break;
            }
            case 1: {
                n3 = this.a;
                if (n3 == null) {
                    j.b("mixpanelInstance");
                }
                map = this.c;
                a2 = a.a.L;
                break;
            }
            case 0: {
                n3 = this.a;
                if (n3 == null) {
                    j.b("mixpanelInstance");
                }
                map = this.c;
                a2 = a.a.K;
            }
        }
        n3.b(map.get(a2.a()));
    }

    @Override
    public void e(String string2) {
        String string3;
        j.b(string2, "title");
        g.a.a.a("MixpanelEvent").a("\u8d70\u884c\u4f4d\u7f6e\uff08%s\uff09\u3092\u8868\u793a\u3057\u305f", string2);
        n n2 = this.a;
        if (n2 == null) {
            j.b("mixpanelInstance");
        }
        if ((string3 = this.c.get(a.a.N.a())) != null) {
            Object[] arrobject = new Object[]{string2};
            string2 = String.format(string3, Arrays.copyOf(arrobject, arrobject.length));
            j.a((Object)string2, "java.lang.String.format(this, *args)");
        } else {
            string2 = null;
        }
        n2.b(string2);
    }

    @Override
    public void f() {
        g.a.a.a("MixpanelEvent").a("\u4e57\u63db\u901f\u5ea6\u30dc\u30bf\u30f3\u3092\u62bc\u3057\u305f", new Object[0]);
        n n2 = this.a;
        if (n2 == null) {
            j.b("mixpanelInstance");
        }
        n2.b(this.c.get(a.a.p.a()));
    }

    @Override
    public void f(String string2) {
        String string3;
        j.b(string2, "title");
        g.a.a.a("MixpanelEvent").a("\u6587\u5b57\u691c\u7d22\u3067\u8d70\u884c\u4f4d\u7f6e\uff08%s\uff09\u3092\u8868\u793a\u3057\u305f", string2);
        n n2 = this.a;
        if (n2 == null) {
            j.b("mixpanelInstance");
        }
        if ((string3 = this.c.get(a.a.O.a())) != null) {
            Object[] arrobject = new Object[]{string2};
            string2 = String.format(string3, Arrays.copyOf(arrobject, arrobject.length));
            j.a((Object)string2, "java.lang.String.format(this, *args)");
        } else {
            string2 = null;
        }
        n2.b(string2);
    }

    @Override
    public void g() {
        g.a.a.a("MixpanelEvent").a("\u767b\u9332\u30dc\u30bf\u30f3\u3092\u62bc\u3057\u305f", new Object[0]);
        n n2 = this.a;
        if (n2 == null) {
            j.b("mixpanelInstance");
        }
        n2.b(this.c.get(a.a.j.a()));
    }

    @Override
    public void h() {
        g.a.a.a("MixpanelEvent").a("\u524a\u9664\u30dc\u30bf\u30f3\u3092\u62bc\u3057\u305f", new Object[0]);
        n n2 = this.a;
        if (n2 == null) {
            j.b("mixpanelInstance");
        }
        n2.b(this.c.get(a.a.k.a()));
    }

    @Override
    public void i() {
        g.a.a.a("MixpanelEvent").a("\u6642\u523b\u8868\u3092\u898b\u308b\u30dc\u30bf\u30f3\u3092\u62bc\u3057\u305f", new Object[0]);
        n n2 = this.a;
        if (n2 == null) {
            j.b("mixpanelInstance");
        }
        n2.b(this.c.get(a.a.l.a()));
    }

    @Override
    public void j() {
        g.a.a.a("MixpanelEvent").a("\u6642\u523b\u8868\u753b\u9762\u306b\u3044\u308b", new Object[0]);
        n n2 = this.a;
        if (n2 == null) {
            j.b("mixpanelInstance");
        }
        n2.b(this.c.get(a.a.m.a()));
    }

    @Override
    public void k() {
        g.a.a.a("MixpanelEvent").a("\u30d5\u30a3\u30fc\u30c9\u30d0\u30c3\u30af\u3092\u9001\u308b\u3092\u62bc\u3057\u305f", new Object[0]);
        n n2 = this.a;
        if (n2 == null) {
            j.b("mixpanelInstance");
        }
        n2.b(this.c.get(a.a.q.a()));
    }

    @Metadata(bv={1, 0, 2}, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2={"Ljp/co/jreast/jreastapp/commuter/provider/MixpanelAnalyticsProvider$Companion;", "", "()V", "ArgsKeys", "app_productRelease"}, k=1, mv={1, 1, 11})
    public static final class jp.co.jreast.jreastapp.commuter.l.c$a {
        private jp.co.jreast.jreastapp.commuter.l.c$a() {
        }

        public /* synthetic */ jp.co.jreast.jreastapp.commuter.l.c$a(g g2) {
            this();
        }

        @Metadata(bv={1, 0, 2}, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b-\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/\u00a8\u00060"}, d2={"Ljp/co/jreast/jreastapp/commuter/provider/MixpanelAnalyticsProvider$Companion$ArgsKeys;", "", "key", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getKey", "()Ljava/lang/String;", "SEND_VIEW_HOME_EVENT_TO_ANALYTICS", "VIEW_SEARCH_RESULTS", "VIEW_ROUTE_DETAIL", "VIEW_SERVICE_STATUS", "VIEW_FAVORITE_ROUTE_DETAIL", "VIEW_REGISTER_POPUP", "DID_TAP_DELETE_AND_REGISTER_BUTTON", "VIEW_SETTINGS", "DID_TAP_SEARCH_BUTTON", "DID_TAP_REGISTER_ROUTE_BUTTON", "DID_TAP_DELETED_MY_ROUTE_BUTTON", "DID_TAP_TIMETABLE_BUTTON", "VIEW_TIMETABLES", "DID_TAP_EXPRESS_SETTING_BUTTON", "DID_TAP_FARE_SETTING_BUTTON", "DID_TAP_TRANSFER_TIME_SETTING_BUTTON", "DID_TAP_FEEDBACK_BUTTON", "NUMBER_OF_RESULTS", "NUMBER_OF_DELAYED_LINES", "DEPARTURE_STATION", "ARRIVAL_STATION", "SELECTED_TIME", "DEPARTURE_OR_ARRIVAL", "ERROR_MESSAGE", "FAVORITE_ROUTE_COUNT", "FARE_SETTING", "EXPRESS_SETTING", "TRANSFER_TIME_SETTING", "REFERRER", "FIRST_VIA_STATION", "SECOND_VIA_STATION", "DEPARTURE_AND_ARRIVAL_LIST", "VIEW_TRAIN_SERVICE_AREA_TOHOKU", "VIEW_TRAIN_SERVICE_AREA_KANTO", "VIEW_TRAIN_SERVICE_AREA_SHINETSU", "VIEW_TRAIN_SERVICE_AREA_SHINKANSEN", "DID_TAP_BOTTOM_TAB_ROUTE_SEARCH", "DID_TAP_BOTTOM_TAB_TRAIN_SERVICE", "DID_TAP_BOTTOM_TAB_TRAIN_LOCATION", "VIEW_TRAIN_LOCATION_DETAIL", "VIEW_TRAIN_LOCATION_DETAIL_OF_SEARCH", "app_productRelease"}, k=1, mv={1, 1, 11})
        private static final class a
        extends Enum<a> {
            public static final /* enum */ a A;
            public static final /* enum */ a B;
            public static final /* enum */ a C;
            public static final /* enum */ a D;
            public static final /* enum */ a E;
            public static final /* enum */ a F;
            public static final /* enum */ a G;
            public static final /* enum */ a H;
            public static final /* enum */ a I;
            public static final /* enum */ a J;
            public static final /* enum */ a K;
            public static final /* enum */ a L;
            public static final /* enum */ a M;
            public static final /* enum */ a N;
            public static final /* enum */ a O;
            private static final /* synthetic */ a[] P;
            public static final /* enum */ a a;
            public static final /* enum */ a b;
            public static final /* enum */ a c;
            public static final /* enum */ a d;
            public static final /* enum */ a e;
            public static final /* enum */ a f;
            public static final /* enum */ a g;
            public static final /* enum */ a h;
            public static final /* enum */ a i;
            public static final /* enum */ a j;
            public static final /* enum */ a k;
            public static final /* enum */ a l;
            public static final /* enum */ a m;
            public static final /* enum */ a n;
            public static final /* enum */ a o;
            public static final /* enum */ a p;
            public static final /* enum */ a q;
            public static final /* enum */ a r;
            public static final /* enum */ a s;
            public static final /* enum */ a t;
            public static final /* enum */ a u;
            public static final /* enum */ a v;
            public static final /* enum */ a w;
            public static final /* enum */ a x;
            public static final /* enum */ a y;
            public static final /* enum */ a z;
            private final String Q;

            static {
                a a2;
                a a3;
                a a4;
                a a5;
                a a6;
                a a7;
                a a8;
                a a9;
                a a10;
                a a11;
                a a12;
                a a13;
                a a14;
                a a15;
                a a16;
                a a17;
                a a18;
                a a19;
                a a20;
                a a21;
                a a22;
                a a23;
                a a24;
                a a25;
                a a26;
                a a27;
                a a28;
                a a29;
                a a30;
                a a31;
                a a32;
                a a33;
                a a34;
                a a35;
                a a36;
                a a37;
                a a38;
                a a39;
                a a40;
                a a41;
                a a42;
                a = a39 = new a("sendViewHomeEventToAnalytics");
                b = a40 = new a("viewSearchResults");
                c = a16 = new a("viewRouteDetail");
                d = a2 = new a("viewServiceStatus");
                e = a35 = new a("viewFavoriteRouteDetail");
                f = a17 = new a("viewRegisterPopup");
                g = a11 = new a("didTapDeleteAndRegisterButton");
                h = a31 = new a("viewSettings");
                i = a18 = new a("didTapSearchButton");
                j = a9 = new a("didTapRegisterRouteButton");
                k = a33 = new a("didTapDeletedMyRouteButton");
                l = a23 = new a("didTapTimetableButton");
                m = a12 = new a("viewTimetables");
                n = a26 = new a("didTapExpressSettingButton");
                o = a13 = new a("didTapFareSettingButton");
                p = a42 = new a("didTapTransferTimeSettingButton");
                q = a21 = new a("didTapFeedbackButton");
                r = a7 = new a("numberOfResults");
                s = a30 = new a("numberOfDelayedLines");
                t = a24 = new a("departureStation");
                u = a37 = new a("arrivalStation");
                v = a10 = new a("selectedTime");
                w = a25 = new a("departureOrArrival");
                x = a6 = new a("errorMessage");
                y = a20 = new a("favoriteRouteCount");
                z = a32 = new a("fareSetting");
                A = a8 = new a("expressSetting");
                B = a29 = new a("transferTimeSetting");
                C = a38 = new a("referrer");
                D = a14 = new a("firstViaStation");
                E = a28 = new a("secondViaStation");
                F = a34 = new a("departureAndArrivalList");
                G = a15 = new a("viewTrainServiceAreaTohoku");
                H = a41 = new a("viewTrainServiceAreaKanto");
                I = a4 = new a("viewTrainServiceAreaShinetsu");
                J = a36 = new a("viewTrainServiceAreaShinkansen");
                K = a27 = new a("didTapRouteSearchTab");
                L = a5 = new a("didTapTrainServiceTab");
                M = a22 = new a("didTapTrainLocationTab");
                N = a19 = new a("didTapTrainLocationDetail");
                O = a3 = new a("didTapTrainLocationDetailOfSearch");
                P = new a[]{a39, a40, a16, a2, a35, a17, a11, a31, a18, a9, a33, a23, a12, a26, a13, a42, a21, a7, a30, a24, a37, a10, a25, a6, a20, a32, a8, a29, a38, a14, a28, a34, a15, a41, a4, a36, a27, a5, a22, a19, a3};
            }

            protected a(String string3) {
                j.b(string3, "key");
                this.Q = string3;
            }

            public static a valueOf(String string2) {
                return Enum.valueOf(a.class, string2);
            }

            public static a[] values() {
                return (a[])P.clone();
            }

            public final String a() {
                return this.Q;
            }
        }

    }

}

