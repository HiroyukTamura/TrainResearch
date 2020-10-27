package p043jp.reifrontier.silentlogsdkandroid.data.api;

import android.content.Context;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p009e.p069e.p070a.p071a.p072a.C1578g;
import p040i.C1744A;
import p040i.C1752D;
import p040i.p116N.C1909a;
import p043jp.reifrontier.silentlogsdkandroid.data.shared.RFLSharedHolder;
import p043jp.reifrontier.silentlogsdkandroid.info.RFLPointCalcRequest;
import p043jp.reifrontier.silentlogsdkandroid.utils.RFLDailyUtilsKt;
import p078g.p079a.C1714r;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\nJ\b\u0010\u0014\u001a\u00020\u0015H\u0002J&\u0010\u0016\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00010\u00190\u00180\u00172\u0006\u0010\u001a\u001a\u00020\u001bR\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u001d"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/data/api/RFLPointClient;", "", "()V", "apiInfo", "Ljp/reifrontier/silentlogsdkandroid/data/api/RFLApiInfo;", "oAuthInterceptor", "Ljp/reifrontier/silentlogsdkandroid/data/api/RFLOAuthInterceptor;", "retrofit", "Lretrofit2/Retrofit;", "staging", "", "getStaging", "()Z", "setStaging", "(Z)V", "build", "", "context", "Landroid/content/Context;", "aStaging", "getBaseUrl", "", "requestPointCalculation", "Lio/reactivex/Single;", "Lretrofit2/Response;", "", "date", "Ljava/util/Date;", "Companion", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.silentlogsdkandroid.data.api.RFLPointClient */
public final class RFLPointClient {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private Retrofit f3324a;

    /* renamed from: b */
    private RFLApiInfo f3325b;

    /* renamed from: c */
    private boolean f3326c = true;

    /* renamed from: d */
    private final RFLOAuthInterceptor f3327d = new RFLOAuthInterceptor("Bearer");

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/data/api/RFLPointClient$Companion;", "", "()V", "PRODUCTION_URL", "", "STAGING_URL", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.silentlogsdkandroid.data.api.RFLPointClient$Companion */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* renamed from: a */
    private final String m3803a() {
        String pointUrl = RFLSharedHolder.INSTANCE.pointUrl();
        if (pointUrl == null || pointUrl.length() == 0) {
            return this.f3326c ? "https://milepoint.silentlogapp.com/" : "https://milepoint.silentlog.com/";
        }
        if (pointUrl == null) {
            Intrinsics.throwNpe();
        }
        return pointUrl;
    }

    public final void build(Context context, boolean z) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.f3326c = z;
        C1909a aVar = new C1909a(new RFLPointClient$build$logger$1());
        aVar.mo28005a(this.f3326c ? C1909a.C1910a.BODY : C1909a.C1910a.NONE);
        C1752D.C1753a aVar2 = new C1752D.C1753a();
        aVar2.mo27508c(240, TimeUnit.SECONDS);
        aVar2.mo27505b(240, TimeUnit.SECONDS);
        aVar2.mo27509d(240, TimeUnit.SECONDS);
        aVar2.mo27503a(true);
        aVar2.mo27501a((C1744A) new RFLUserAgentInterceptor(context));
        aVar2.mo27501a((C1744A) aVar);
        aVar2.mo27501a((C1744A) this.f3327d);
        Retrofit build = new Retrofit.Builder().client(new C1752D(aVar2)).baseUrl(m3803a()).addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(C1578g.m2208a()).build();
        Intrinsics.checkExpressionValueIsNotNull(build, "Retrofit.Builder()\n     …\n                .build()");
        this.f3324a = build;
        Object create = build.create(RFLApiInfo.class);
        Intrinsics.checkExpressionValueIsNotNull(create, "retrofit.create(RFLApiInfo::class.java)");
        this.f3325b = (RFLApiInfo) create;
    }

    public final boolean getStaging() {
        return this.f3326c;
    }

    public final C1714r<Response<Map<String, Object>>> requestPointCalculation(Date date) {
        Intrinsics.checkParameterIsNotNull(date, "date");
        Date start = RFLDailyUtilsKt.start(date);
        String format = RFLDailyUtilsKt.format(start, "yyyy", "GMT");
        String format2 = RFLDailyUtilsKt.format(start, "MM", "GMT");
        String format3 = RFLDailyUtilsKt.format(start, "dd", "GMT");
        RFLApiInfo rFLApiInfo = this.f3325b;
        if (rFLApiInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("apiInfo");
        }
        return rFLApiInfo.pointCalculation(format, format2, format3, new RFLPointCalcRequest(67));
    }

    public final void setStaging(boolean z) {
        this.f3326c = z;
    }
}
