/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.l;

import java.util.List;
import jp.co.jreast.jreastapp.commuter.model.FavoriteRoute;
import kotlin.Metadata;

@Metadata(bv={1, 0, 2}, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0012\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u0006H&J\b\u0010\u000b\u001a\u00020\u0006H&J\b\u0010\f\u001a\u00020\u0006H&J8\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000fH&J\b\u0010\u0015\u001a\u00020\u0006H&J\b\u0010\u0016\u001a\u00020\u0006H&J\b\u0010\u0017\u001a\u00020\u000fH&J\u0010\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u000fH&J\u0018\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u000fH&J\b\u0010\u001d\u001a\u00020\u0006H&J\b\u0010\u001e\u001a\u00020\u0006H&J\u0010\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u000fH&J\u0010\u0010 \u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u000fH&J\u0010\u0010\"\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u000fH&J\u0010\u0010$\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\tH&J\u0016\u0010&\u001a\u00020\u00062\f\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(H&J\u0010\u0010*\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\u000fH&J\u0010\u0010,\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\tH&J\b\u0010.\u001a\u00020\u0006H&J\u0018\u0010/\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\t2\u0006\u00100\u001a\u00020\u000fH&J\u0010\u00101\u001a\u00020\u00062\u0006\u00102\u001a\u00020\tH&J\u0010\u00103\u001a\u00020\u00062\u0006\u00100\u001a\u00020\u000fH&J \u00104\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\u000f2\u0006\u0010+\u001a\u00020\u000fH&J\b\u00105\u001a\u00020\u0006H&J\u0010\u00106\u001a\u00020\u00062\u0006\u00107\u001a\u00020\u000fH&J\u0010\u00108\u001a\u00020\u00062\u0006\u00107\u001a\u00020\u000fH&J\u0010\u00109\u001a\u00020\u00062\u0006\u0010:\u001a\u00020\tH&\u00a8\u0006;"}, d2={"Ljp/co/jreast/jreastapp/commuter/provider/AnalyticsProvider;", "", "create", "context", "Landroid/content/Context;", "deletedRoute", "", "didTapBottomTab", "position", "", "didTapExpressSettingButton", "didTapFareSettingButton", "didTapFeedbackButton", "didTapSearchButton", "departureStation", "", "arrivalStation", "selectedDateTime", "departureOrArrival", "firstViaStation", "secondViaStation", "didTapTimetableButton", "didTapTransferTimeSettingButton", "getDistinctId", "identify", "uuid", "logError", "name", "message", "optOutTracking", "registeredRoute", "setNickname", "updateExpressSettings", "expressSetting", "updateFareSettings", "fareSetting", "updateFavoriteRouteCount", "count", "updateMyRouteSettings", "favRouteList", "", "Ljp/co/jreast/jreastapp/commuter/model/FavoriteRoute;", "updateTransferTimeSettings", "transferTimeSetting", "viewFavoriteRouteDetail", "numberOfDelayedLines", "viewHome", "viewRouteDetail", "viewTypeName", "viewSearchResults", "numberOfRoutes", "viewServiceStatus", "viewSettings", "viewTimetables", "viewTrainLocationDetail", "title", "viewTrainLocationDetailOfSearch", "viewTrainServiceArea", "areaCode", "app_productRelease"}, k=1, mv={1, 1, 11})
public interface a {
    public void a();

    public void a(int var1);

    public void a(int var1, String var2);

    public void a(String var1);

    public void a(String var1, String var2);

    public void a(String var1, String var2, String var3);

    public void a(String var1, String var2, String var3, String var4, String var5, String var6);

    public void a(List<FavoriteRoute> var1);

    public String b();

    public void b(int var1);

    public void b(String var1);

    public void c();

    public void c(int var1);

    public void c(String var1);

    public void d();

    public void d(int var1);

    public void d(String var1);

    public void e();

    public void e(int var1);

    public void e(String var1);

    public void f();

    public void f(String var1);

    public void g();

    public void h();

    public void i();

    public void j();

    public void k();
}

