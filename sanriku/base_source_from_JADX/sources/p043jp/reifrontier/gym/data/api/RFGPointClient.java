package p043jp.reifrontier.gym.data.api;

import android.annotation.SuppressLint;
import android.content.Context;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p009e.p069e.p070a.p071a.p072a.C1578g;
import p040i.C1744A;
import p040i.C1752D;
import p040i.p116N.C1909a;
import p043jp.reifrontier.gym.domain.api.train.RFGApiPointActionRequest;
import p043jp.reifrontier.gym.domain.api.train.RFGApiPointActionResponse;
import p043jp.reifrontier.silentlogsdkandroid.data.shared.RFLSharedHolder;
import p078g.p079a.C1714r;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00112\u00020\u0001:\u0002\u0011\u0012B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0004J\u0012\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000¨\u0006\u0013"}, mo21739d2 = {"Ljp/reifrontier/gym/data/api/RFGPointClient;", "", "()V", "context", "Landroid/content/Context;", "oAuthInterceptor", "Ljp/reifrontier/gym/data/api/RFGOAuthInterceptor;", "pointApi", "Ljp/reifrontier/gym/data/api/RFGPointApi;", "retrofit", "Lretrofit2/Retrofit;", "build", "", "pointAction", "Lio/reactivex/Single;", "Lretrofit2/Response;", "Ljp/reifrontier/gym/domain/api/train/RFGApiPointActionResponse;", "Companion", "Holder", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.data.api.RFGPointClient */
public final class RFGPointClient {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Lazy INSTANCE$delegate = LazyKt__LazyJVMKt.lazy(RFGPointClient$Companion$INSTANCE$2.INSTANCE);
    private static final String PRODUCTION_URL = "https://milepoint.silentlog.com/";
    private static final String STAGING_URL = "https://milepoint.silentlogapp.com/";
    private Context context;
    private final RFGOAuthInterceptor oAuthInterceptor = new RFGOAuthInterceptor("Bearer");
    private RFGPointApi pointApi;
    private Retrofit retrofit;

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nXT¢\u0006\u0002\n\u0000¨\u0006\f"}, mo21739d2 = {"Ljp/reifrontier/gym/data/api/RFGPointClient$Companion;", "", "()V", "INSTANCE", "Ljp/reifrontier/gym/data/api/RFGPointClient;", "getINSTANCE", "()Ljp/reifrontier/gym/data/api/RFGPointClient;", "INSTANCE$delegate", "Lkotlin/Lazy;", "PRODUCTION_URL", "", "STAGING_URL", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.data.api.RFGPointClient$Companion */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RFGPointClient getINSTANCE() {
            Lazy access$getINSTANCE$cp = RFGPointClient.INSTANCE$delegate;
            Companion companion = RFGPointClient.Companion;
            return (RFGPointClient) access$getINSTANCE$cp.getValue();
        }
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, mo21739d2 = {"Ljp/reifrontier/gym/data/api/RFGPointClient$Holder;", "", "()V", "INSTANCE", "Ljp/reifrontier/gym/data/api/RFGPointClient;", "getINSTANCE", "()Ljp/reifrontier/gym/data/api/RFGPointClient;", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.data.api.RFGPointClient$Holder */
    private static final class Holder {
        public static final Holder INSTANCE = new Holder();
        @SuppressLint({"StaticFieldLeak"})

        /* renamed from: INSTANCE  reason: collision with other field name */
        private static final RFGPointClient f4370INSTANCE = new RFGPointClient();

        private Holder() {
        }

        public final RFGPointClient getINSTANCE() {
            return f4370INSTANCE;
        }
    }

    public final void build(Context context2) {
        Intrinsics.checkParameterIsNotNull(context2, "context");
        this.context = context2;
        C1909a aVar = new C1909a(new RFGPointClient$build$logger$1());
        aVar.mo28005a(C1909a.C1910a.NONE);
        C1752D.C1753a aVar2 = new C1752D.C1753a();
        aVar2.mo27508c(120, TimeUnit.SECONDS);
        aVar2.mo27505b(120, TimeUnit.SECONDS);
        aVar2.mo27503a(true);
        aVar2.mo27501a((C1744A) new RFGUserAgentInterceptor(context2));
        aVar2.mo27501a((C1744A) aVar);
        aVar2.mo27501a((C1744A) this.oAuthInterceptor);
        Retrofit build = new Retrofit.Builder().client(new C1752D(aVar2)).baseUrl(PRODUCTION_URL).addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(C1578g.m2208a()).build();
        Intrinsics.checkExpressionValueIsNotNull(build, "Retrofit.Builder()\n     …e())\n            .build()");
        this.retrofit = build;
        if (build == null) {
            Intrinsics.throwUninitializedPropertyAccessException("retrofit");
        }
        Object create = build.create(RFGPointApi.class);
        Intrinsics.checkExpressionValueIsNotNull(create, "retrofit.create(RFGPointApi::class.java)");
        this.pointApi = (RFGPointApi) create;
    }

    public final C1714r<Response<RFGApiPointActionResponse>> pointAction() {
        this.oAuthInterceptor.setToken(RFLSharedHolder.INSTANCE.accessToken());
        RFGPointApi rFGPointApi = this.pointApi;
        if (rFGPointApi == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pointApi");
        }
        return rFGPointApi.pointAction(new RFGApiPointActionRequest(0, 0, 3, (DefaultConstructorMarker) null));
    }
}
