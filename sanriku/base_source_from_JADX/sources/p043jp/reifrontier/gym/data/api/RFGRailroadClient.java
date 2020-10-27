package p043jp.reifrontier.gym.data.api;

import android.annotation.SuppressLint;
import android.content.Context;
import com.google.firebase.crashlytics.internal.common.AbstractSpiCall;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import p009e.p069e.p070a.p071a.p072a.C1578g;
import p040i.C0974E;
import p040i.C0980J;
import p040i.C1744A;
import p040i.C1746B;
import p040i.C1752D;
import p040i.C1755F;
import p040i.C1758I;
import p040i.p116N.C1909a;
import p043jp.reifrontier.gym.data.train.RFGStation;
import p043jp.reifrontier.gym.data.train.RFGTrain;
import p043jp.reifrontier.gym.domain.api.train.RFGApiAuthRequest;
import p043jp.reifrontier.gym.domain.api.train.RFGApiContent;
import p043jp.reifrontier.gym.domain.api.train.RFGApiOperation;
import p043jp.reifrontier.gym.domain.api.train.RFGApiRealtime;
import p043jp.reifrontier.gym.domain.api.train.RFGApiSpot;
import p043jp.reifrontier.sanriku.R;
import p078g.p079a.C1714r;
import p078g.p079a.p094C.C1683a;
import p078g.p079a.p096w.p097b.C1721a;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 22\u00020\u0001:\u0003234B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u0006J\u001e\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00160\u0015\"\u0004\b\u0000\u0010\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u0018H\u0002J\u0016\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u0004J\u001e\u0010\u001c\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001f0\u001d0\u0010J\u001e\u0010!\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0\u001f0\u001d0\u0010J \u0010#\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020$0\u001d0\u00102\u0006\u0010\u001a\u001a\u00020\u0018J_\u0010%\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0\u001f0\u001d0\u00102\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010*\u001a\u0004\u0018\u00010+2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010+¢\u0006\u0002\u0010-J\u001e\u0010.\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020/0\u001f0\u001d0\u0010J\u001e\u00100\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u0002010\u001f0\u001d0\u0010R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000¨\u00065"}, mo21739d2 = {"Ljp/reifrontier/gym/data/api/RFGRailroadClient;", "", "()V", "accessToken", "", "context", "Landroid/content/Context;", "oAuthInterceptor", "Ljp/reifrontier/gym/data/api/RFGOAuthInterceptor;", "password", "railroadApi", "Ljp/reifrontier/gym/data/api/RFGRailroadApi;", "retrofit", "Lretrofit2/Retrofit;", "username", "auth", "Lio/reactivex/Single;", "", "build", "", "getErrorResponse", "Lretrofit2/Response;", "T", "code", "", "getImageUrl", "spotId", "imagePath", "getOperation", "Lkotlin/Pair;", "Ljp/reifrontier/gym/data/api/RFGRailroadClient$RailroadApiResult;", "", "Ljp/reifrontier/gym/domain/api/train/RFGApiOperation;", "getRealtime", "Ljp/reifrontier/gym/domain/api/train/RFGApiRealtime;", "getSpotDetail", "Ljp/reifrontier/gym/domain/api/train/RFGApiContent;", "getSpotList", "Ljp/reifrontier/gym/domain/api/train/RFGApiSpot;", "page", "limit", "stationId", "lat", "", "lon", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Double;)Lio/reactivex/Single;", "getStations", "Ljp/reifrontier/gym/data/train/RFGStation;", "getTrains", "Ljp/reifrontier/gym/data/train/RFGTrain;", "Companion", "Holder", "RailroadApiResult", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.data.api.RFGRailroadClient */
public final class RFGRailroadClient {
    private static final int AUTH_ERROR_RESPONSE_CODE = -1;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Lazy INSTANCE$delegate = LazyKt__LazyJVMKt.lazy(RFGRailroadClient$Companion$INSTANCE$2.INSTANCE);
    private static final String PRODUCTION_IMAGE_URL = "https://images.railroad-track.com/";
    private static final String PRODUCTION_URL = "https://api.railroad-track.com";
    private static final String STAGING_IMAGE_URL = "https://images.railroad-track.com/";
    private static final String STAGING_URL = "https://api.railroad-track.com";
    /* access modifiers changed from: private */
    public String accessToken;
    private Context context;
    /* access modifiers changed from: private */
    public final RFGOAuthInterceptor oAuthInterceptor;
    private String password;
    /* access modifiers changed from: private */
    public RFGRailroadApi railroadApi;
    private Retrofit retrofit;
    private String username;

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068FX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u000b\u001a\u00020\fXT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fXT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, mo21739d2 = {"Ljp/reifrontier/gym/data/api/RFGRailroadClient$Companion;", "", "()V", "AUTH_ERROR_RESPONSE_CODE", "", "INSTANCE", "Ljp/reifrontier/gym/data/api/RFGRailroadClient;", "getINSTANCE", "()Ljp/reifrontier/gym/data/api/RFGRailroadClient;", "INSTANCE$delegate", "Lkotlin/Lazy;", "PRODUCTION_IMAGE_URL", "", "PRODUCTION_URL", "STAGING_IMAGE_URL", "STAGING_URL", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.data.api.RFGRailroadClient$Companion */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RFGRailroadClient getINSTANCE() {
            Lazy access$getINSTANCE$cp = RFGRailroadClient.INSTANCE$delegate;
            Companion companion = RFGRailroadClient.Companion;
            return (RFGRailroadClient) access$getINSTANCE$cp.getValue();
        }
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, mo21739d2 = {"Ljp/reifrontier/gym/data/api/RFGRailroadClient$Holder;", "", "()V", "INSTANCE", "Ljp/reifrontier/gym/data/api/RFGRailroadClient;", "getINSTANCE", "()Ljp/reifrontier/gym/data/api/RFGRailroadClient;", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.data.api.RFGRailroadClient$Holder */
    private static final class Holder {
        public static final Holder INSTANCE = new Holder();
        @SuppressLint({"StaticFieldLeak"})

        /* renamed from: INSTANCE  reason: collision with other field name */
        private static final RFGRailroadClient f4371INSTANCE = new RFGRailroadClient((DefaultConstructorMarker) null);

        private Holder() {
        }

        public final RFGRailroadClient getINSTANCE() {
            return f4371INSTANCE;
        }
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, mo21739d2 = {"Ljp/reifrontier/gym/data/api/RFGRailroadClient$RailroadApiResult;", "", "(Ljava/lang/String;I)V", "AUTH_ERROR", "RESPONSE_ERROR", "NOT_FOUND", "SUCCESS", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.data.api.RFGRailroadClient$RailroadApiResult */
    public enum RailroadApiResult {
        AUTH_ERROR,
        RESPONSE_ERROR,
        NOT_FOUND,
        SUCCESS
    }

    private RFGRailroadClient() {
        this.oAuthInterceptor = new RFGOAuthInterceptor("Bearer");
    }

    public /* synthetic */ RFGRailroadClient(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public static final /* synthetic */ RFGRailroadApi access$getRailroadApi$p(RFGRailroadClient rFGRailroadClient) {
        RFGRailroadApi rFGRailroadApi = rFGRailroadClient.railroadApi;
        if (rFGRailroadApi == null) {
            Intrinsics.throwUninitializedPropertyAccessException("railroadApi");
        }
        return rFGRailroadApi;
    }

    private final C1714r<Boolean> auth() {
        C1714r<R> b;
        String str;
        if (this.accessToken != null) {
            b = C1714r.m2410a(RFGRailroadClient$auth$1.INSTANCE);
            str = "Single.create<Boolean> {…ccess(true)\n            }";
        } else {
            String str2 = this.username;
            if (str2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("username");
            }
            String str3 = this.password;
            if (str3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("password");
            }
            RFGApiAuthRequest rFGApiAuthRequest = new RFGApiAuthRequest(str2, str3);
            RFGRailroadApi rFGRailroadApi = this.railroadApi;
            if (rFGRailroadApi == null) {
                Intrinsics.throwUninitializedPropertyAccessException("railroadApi");
            }
            b = rFGRailroadApi.auth(rFGApiAuthRequest).mo27434b(C1683a.m2378b()).mo27429a(C1721a.m2428a()).mo27435b(new RFGRailroadClient$auth$2(this));
            str = "railroadApi.auth(authDat…Empty()\n                }";
        }
        Intrinsics.checkExpressionValueIsNotNull(b, str);
        return b;
    }

    private final <T> Response<T> getErrorResponse(int i) {
        C0980J.C0981b bVar = C0980J.Companion;
        C1746B.C1747a aVar = C1746B.f2080f;
        C0980J a = bVar.mo20418a("[]", C1746B.C1747a.m2461b(AbstractSpiCall.ACCEPT_JSON_VALUE));
        C1758I.C1759a aVar2 = new C1758I.C1759a();
        aVar2.mo27571a(i);
        aVar2.mo27576a((C0980J) null);
        aVar2.mo27573a(C0974E.HTTP_1_0);
        aVar2.mo27579a("message");
        C1755F.C1756a aVar3 = new C1755F.C1756a();
        aVar3.mo27552b("https://api.railroad-track.com");
        aVar2.mo27574a(aVar3.mo27551a());
        Response<T> error = Response.error(a, aVar2.mo27581a());
        Intrinsics.checkExpressionValueIsNotNull(error, "Response.error(responseBody, rawResponse)");
        return error;
    }

    static /* synthetic */ Response getErrorResponse$default(RFGRailroadClient rFGRailroadClient, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = -1;
        }
        return rFGRailroadClient.getErrorResponse(i);
    }

    public static /* synthetic */ C1714r getSpotList$default(RFGRailroadClient rFGRailroadClient, Integer num, Integer num2, Integer num3, Double d, Double d2, int i, Object obj) {
        if ((i & 1) != 0) {
            num = null;
        }
        if ((i & 2) != 0) {
            num2 = null;
        }
        if ((i & 4) != 0) {
            num3 = null;
        }
        if ((i & 8) != 0) {
            d = null;
        }
        if ((i & 16) != 0) {
            d2 = null;
        }
        return rFGRailroadClient.getSpotList(num, num2, num3, d, d2);
    }

    public final void build(Context context2) {
        Intrinsics.checkParameterIsNotNull(context2, "context");
        this.context = context2;
        String string = context2.getString(R.string.sanriku_api_user_name);
        Intrinsics.checkExpressionValueIsNotNull(string, "context.getString(R.string.sanriku_api_user_name)");
        this.username = string;
        String string2 = context2.getString(R.string.sanriku_api_password);
        Intrinsics.checkExpressionValueIsNotNull(string2, "context.getString(R.string.sanriku_api_password)");
        this.password = string2;
        C1909a aVar = new C1909a(new RFGRailroadClient$build$logger$1());
        aVar.mo28005a(C1909a.C1910a.NONE);
        C1752D.C1753a aVar2 = new C1752D.C1753a();
        aVar2.mo27508c(120, TimeUnit.SECONDS);
        aVar2.mo27505b(120, TimeUnit.SECONDS);
        aVar2.mo27503a(true);
        aVar2.mo27501a((C1744A) new RFGUserAgentInterceptor(context2));
        aVar2.mo27501a((C1744A) aVar);
        aVar2.mo27501a((C1744A) this.oAuthInterceptor);
        Retrofit build = new Retrofit.Builder().client(new C1752D(aVar2)).baseUrl("https://api.railroad-track.com").addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(C1578g.m2208a()).build();
        Intrinsics.checkExpressionValueIsNotNull(build, "Retrofit.Builder()\n     …e())\n            .build()");
        this.retrofit = build;
        if (build == null) {
            Intrinsics.throwUninitializedPropertyAccessException("retrofit");
        }
        Object create = build.create(RFGRailroadApi.class);
        Intrinsics.checkExpressionValueIsNotNull(create, "retrofit.create(RFGRailroadApi::class.java)");
        this.railroadApi = (RFGRailroadApi) create;
    }

    public final String getImageUrl(int i, String str) {
        Intrinsics.checkParameterIsNotNull(str, "imagePath");
        return "https://images.railroad-track.com/" + i + '/' + str;
    }

    public final C1714r<Pair<RailroadApiResult, List<RFGApiOperation>>> getOperation() {
        C1714r<R> b = auth().mo27434b(C1683a.m2378b()).mo27430a(new RFGRailroadClient$getOperation$1(this)).mo27435b(RFGRailroadClient$getOperation$2.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(b, "auth()\n            .subs…lt, data!!)\n            }");
        return b;
    }

    public final C1714r<Pair<RailroadApiResult, List<RFGApiRealtime>>> getRealtime() {
        C1714r<R> b = auth().mo27434b(C1683a.m2378b()).mo27430a(new RFGRailroadClient$getRealtime$1(this)).mo27435b(RFGRailroadClient$getRealtime$2.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(b, "auth()\n            .subs…lt, data!!)\n            }");
        return b;
    }

    public final C1714r<Pair<RailroadApiResult, RFGApiContent>> getSpotDetail(int i) {
        C1714r<R> b = auth().mo27434b(C1683a.m2378b()).mo27430a(new RFGRailroadClient$getSpotDetail$1(this, i)).mo27435b(RFGRailroadClient$getSpotDetail$2.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(b, "auth()\n            .subs…lt, data!!)\n            }");
        return b;
    }

    public final C1714r<Pair<RailroadApiResult, List<RFGApiSpot>>> getSpotList(Integer num, Integer num2, Integer num3, Double d, Double d2) {
        C1714r<R> b = auth().mo27434b(C1683a.m2378b()).mo27430a(new RFGRailroadClient$getSpotList$1(this, num, num2, num3, d, d2)).mo27435b(RFGRailroadClient$getSpotList$2.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(b, "auth()\n            .subs…lt, data!!)\n            }");
        return b;
    }

    public final C1714r<Pair<RailroadApiResult, List<RFGStation>>> getStations() {
        C1714r<R> b = auth().mo27434b(C1683a.m2378b()).mo27430a(new RFGRailroadClient$getStations$1(this)).mo27435b(RFGRailroadClient$getStations$2.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(b, "auth()\n            .subs…lt, data!!)\n            }");
        return b;
    }

    public final C1714r<Pair<RailroadApiResult, List<RFGTrain>>> getTrains() {
        C1714r<R> b = auth().mo27434b(C1683a.m2378b()).mo27430a(new RFGRailroadClient$getTrains$1(this)).mo27435b(RFGRailroadClient$getTrains$2.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(b, "auth()\n            .subs…lt, data!!)\n            }");
        return b;
    }
}
