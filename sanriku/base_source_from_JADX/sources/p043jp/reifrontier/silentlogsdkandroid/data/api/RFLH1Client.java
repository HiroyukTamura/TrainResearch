package p043jp.reifrontier.silentlogsdkandroid.data.api;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.Scopes;
import com.google.gson.Gson;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.C1126c;
import p009e.p010a.p011a.p012a.C0681a;
import p009e.p069e.p070a.p071a.p072a.C1578g;
import p040i.C0980J;
import p040i.C1744A;
import p040i.C1752D;
import p040i.p116N.C1909a;
import p043jp.reifrontier.silentlogsdkandroid.bus.InvalidToken;
import p043jp.reifrontier.silentlogsdkandroid.data.api.RFLApiAccount;
import p043jp.reifrontier.silentlogsdkandroid.data.api.RFLApiDaily;
import p043jp.reifrontier.silentlogsdkandroid.data.shared.RFLSharedHolder;
import p043jp.reifrontier.silentlogsdkandroid.domain.api.RFLCommon;
import p043jp.reifrontier.silentlogsdkandroid.domain.api.RFLCreate;
import p043jp.reifrontier.silentlogsdkandroid.domain.api.RFLExtra;
import p043jp.reifrontier.silentlogsdkandroid.domain.api.RFLLogout;
import p043jp.reifrontier.silentlogsdkandroid.domain.api.RFLPrivate;
import p043jp.reifrontier.silentlogsdkandroid.domain.api.RFLProfile;
import p043jp.reifrontier.silentlogsdkandroid.domain.daily.RFLDaily;
import p043jp.reifrontier.silentlogsdkandroid.domain.p120ad.RFLAdCampaign;
import p043jp.reifrontier.silentlogsdkandroid.domain.p120ad.RFLAdResType;
import p043jp.reifrontier.silentlogsdkandroid.domain.p120ad.RFLAdResult;
import p043jp.reifrontier.silentlogsdkandroid.domain.p120ad.RFLAdTrackingType;
import p043jp.reifrontier.silentlogsdkandroid.domain.p120ad.RFLAdTrigger;
import p043jp.reifrontier.silentlogsdkandroid.p119di.RFLAppComponent;
import p043jp.reifrontier.silentlogsdkandroid.utils.LocaleEx;
import p043jp.reifrontier.silentlogsdkandroid.utils.RFLDailyUtilsKt;
import p048l.p049a.C1122a;
import p078g.p079a.C1714r;
import p078g.p079a.C1718v;
import p078g.p079a.p100z.C1742e;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0006\b\u0000\u0018\u0000 X2\u00020\u0001:\u0002WXB\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0012JX\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010 2\u0006\u0010\"\u001a\u00020 2\u0006\u0010#\u001a\u00020 2\u0006\u0010$\u001a\u00020 2\u0006\u0010%\u001a\u00020\u00122\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010'2\b\u0010(\u001a\u0004\u0018\u00010 J\u0014\u0010)\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\u0006\u0010*\u001a\u00020 J\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dJ\u001c\u0010,\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.J\b\u00100\u001a\u00020 H\u0002J\u0014\u00101\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\u0006\u00102\u001a\u000203J\u001c\u00104\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\u0006\u00105\u001a\u00020 2\u0006\u00106\u001a\u00020 J\u001a\u00107\u001a\u00020\u001e2\u0006\u00108\u001a\u00020 2\b\u00109\u001a\u0004\u0018\u00010 H\u0002J,\u0010:\u001a\u00020\u001e2\u0006\u00108\u001a\u00020 2\u0006\u0010;\u001a\u00020<2\b\u00109\u001a\u0004\u0018\u00010=2\b\u0010>\u001a\u0004\u0018\u00010\u0001H\u0002J\u001c\u0010?\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\"\u001a\u00020 J\u0012\u0010@\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020B0A0\u001dJ$\u0010C\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\u0006\u0010D\u001a\u00020<2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.J,\u0010E\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\u0006\u0010F\u001a\u00020<2\u0006\u0010G\u001a\u00020H2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.J$\u0010I\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\u0006\u0010J\u001a\u00020K2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.J\u001c\u0010L\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\u0006\u0010M\u001a\u00020 2\u0006\u0010N\u001a\u00020 J\u0014\u0010O\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\u0006\u00105\u001a\u00020PJ\"\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\u0014\u0010R\u001a\u0010\u0012\u0004\u0012\u00020 \u0012\u0006\u0012\u0004\u0018\u00010\u00010SJ\u0014\u0010T\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\u0006\u0010\"\u001a\u00020 J\u0014\u0010U\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\u0006\u0010$\u001a\u00020 J\u0014\u0010V\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\u0006\u0010#\u001a\u00020 R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006Y"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/data/api/RFLH1Client;", "", "()V", "apiAccount", "Ljp/reifrontier/silentlogsdkandroid/data/api/RFLApiAccount;", "apiAd", "Ljp/reifrontier/silentlogsdkandroid/data/api/RFLApiAd;", "apiDaily", "Ljp/reifrontier/silentlogsdkandroid/data/api/RFLApiDaily;", "eventBus", "Lorg/greenrobot/eventbus/EventBus;", "getEventBus", "()Lorg/greenrobot/eventbus/EventBus;", "setEventBus", "(Lorg/greenrobot/eventbus/EventBus;)V", "retrofit", "Lretrofit2/Retrofit;", "staging", "", "getStaging", "()Z", "setStaging", "(Z)V", "build", "", "context", "Landroid/content/Context;", "aStaging", "create", "Lio/reactivex/Single;", "Ljp/reifrontier/silentlogsdkandroid/data/api/RFLH1Client$APIResponse;", "username", "", "originalUserName", "password", "gender", "birthday", "regist", "advertisingIds", "", "pushToken", "forgetPassword", "email", "getAdCampaign", "getAdTrigger", "lat", "", "lon", "getBaseUrl", "getDaily", "date", "Ljava/util/Date;", "getProfile", "privateKey", "extraKey", "handleErrorResponse", "path", "error", "handleResponse", "code", "", "Lokhttp3/ResponseBody;", "response", "login", "logout", "Lretrofit2/Response;", "Ljp/reifrontier/silentlogsdkandroid/domain/api/RFLLogout;", "postAdCover", "coverId", "postAdResponse", "campId", "resType", "Ljp/reifrontier/silentlogsdkandroid/domain/ad/RFLAdResType;", "postAdTracking", "trackingType", "Ljp/reifrontier/silentlogsdkandroid/domain/ad/RFLAdTrackingType;", "postDaily", "dateString", "daily", "postPrivateKey", "Ljp/reifrontier/silentlogsdkandroid/domain/api/RFLPrivate;", "postPrivateKeyMap", "privateKeyMap", "", "postProfile", "updateBirthday", "updateGender", "APIResponse", "Companion", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.silentlogsdkandroid.data.api.RFLH1Client */
public final class RFLH1Client {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String STAGING_URL = "https://api.silentlogapp.com/api/v1/";

    /* renamed from: a */
    private Retrofit f3249a;

    /* renamed from: b */
    private RFLApiAccount f3250b;

    /* renamed from: c */
    private RFLApiDaily f3251c;

    /* renamed from: d */
    private RFLApiAd f3252d;

    /* renamed from: e */
    private boolean f3253e;
    public C1126c eventBus;

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0007J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÆ\u0003J+\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/data/api/RFLH1Client$APIResponse;", "", "code", "", "error", "", "data", "(ILjava/lang/String;Ljava/lang/Object;)V", "getCode", "()I", "getData", "()Ljava/lang/Object;", "getError", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.silentlogsdkandroid.data.api.RFLH1Client$APIResponse */
    public static final class APIResponse {

        /* renamed from: a */
        private final int f3254a;

        /* renamed from: b */
        private final String f3255b;

        /* renamed from: c */
        private final Object f3256c;

        public APIResponse(int i, String str, Object obj) {
            this.f3254a = i;
            this.f3255b = str;
            this.f3256c = obj;
        }

        public static /* synthetic */ APIResponse copy$default(APIResponse aPIResponse, int i, String str, Object obj, int i2, Object obj2) {
            if ((i2 & 1) != 0) {
                i = aPIResponse.f3254a;
            }
            if ((i2 & 2) != 0) {
                str = aPIResponse.f3255b;
            }
            if ((i2 & 4) != 0) {
                obj = aPIResponse.f3256c;
            }
            return aPIResponse.copy(i, str, obj);
        }

        public final int component1() {
            return this.f3254a;
        }

        public final String component2() {
            return this.f3255b;
        }

        public final Object component3() {
            return this.f3256c;
        }

        public final APIResponse copy(int i, String str, Object obj) {
            return new APIResponse(i, str, obj);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof APIResponse)) {
                return false;
            }
            APIResponse aPIResponse = (APIResponse) obj;
            return this.f3254a == aPIResponse.f3254a && Intrinsics.areEqual((Object) this.f3255b, (Object) aPIResponse.f3255b) && Intrinsics.areEqual(this.f3256c, aPIResponse.f3256c);
        }

        public final int getCode() {
            return this.f3254a;
        }

        public final Object getData() {
            return this.f3256c;
        }

        public final String getError() {
            return this.f3255b;
        }

        public int hashCode() {
            int i = this.f3254a * 31;
            String str = this.f3255b;
            int i2 = 0;
            int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
            Object obj = this.f3256c;
            if (obj != null) {
                i2 = obj.hashCode();
            }
            return hashCode + i2;
        }

        public String toString() {
            StringBuilder a = C0681a.m330a("APIResponse(code=");
            a.append(this.f3254a);
            a.append(", error=");
            a.append(this.f3255b);
            a.append(", data=");
            a.append(this.f3256c);
            a.append(")");
            return a.toString();
        }
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\b"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/data/api/RFLH1Client$Companion;", "", "()V", "API_SUBSCRIBE_ERROR_CODE", "", "PRODUCTION_URL", "", "STAGING_URL", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.silentlogsdkandroid.data.api.RFLH1Client$Companion */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\n¢\u0006\u0002\b\u0007"}, mo21739d2 = {"<anonymous>", "Lio/reactivex/Single;", "Ljp/reifrontier/silentlogsdkandroid/data/api/RFLH1Client$APIResponse;", "kotlin.jvm.PlatformType", "it", "Lretrofit2/Response;", "Ljp/reifrontier/silentlogsdkandroid/domain/api/RFLCreate;", "apply"}, mo21740k = 3, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.silentlogsdkandroid.data.api.RFLH1Client$a */
    static final class C2206a<T, R> implements C1742e<T, C1718v<? extends R>> {

        /* renamed from: a */
        final /* synthetic */ RFLH1Client f3257a;

        /* renamed from: jp.reifrontier.silentlogsdkandroid.data.api.RFLH1Client$a$a */
        static final class C2207a<V> implements Callable<T> {

            /* renamed from: a */
            final /* synthetic */ C2206a f3258a;

            /* renamed from: b */
            final /* synthetic */ Response f3259b;

            C2207a(C2206a aVar, Response response) {
                this.f3258a = aVar;
                this.f3259b = response;
            }

            public final APIResponse call() {
                return this.f3258a.f3257a.m3769a("authorise/create", this.f3259b.code(), this.f3259b.errorBody(), this.f3259b.body());
            }
        }

        C2206a(RFLH1Client rFLH1Client) {
            this.f3257a = rFLH1Client;
        }

        /* renamed from: a */
        public final C1714r<APIResponse> apply(Response<RFLCreate> response) {
            Intrinsics.checkParameterIsNotNull(response, "it");
            return C1714r.m2413a(new C2207a(this, response));
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.data.api.RFLH1Client$a0 */
    static final class C2208a0<T, R> implements C1742e<Throwable, APIResponse> {

        /* renamed from: a */
        final /* synthetic */ RFLH1Client f3260a;

        C2208a0(RFLH1Client rFLH1Client) {
            this.f3260a = rFLH1Client;
        }

        /* renamed from: a */
        public final APIResponse apply(Throwable th) {
            Intrinsics.checkParameterIsNotNull(th, "it");
            return this.f3260a.m3770a(Scopes.PROFILE, th.getLocalizedMessage());
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.data.api.RFLH1Client$b */
    static final class C2209b<T, R> implements C1742e<Throwable, APIResponse> {

        /* renamed from: a */
        final /* synthetic */ RFLH1Client f3261a;

        C2209b(RFLH1Client rFLH1Client) {
            this.f3261a = rFLH1Client;
        }

        /* renamed from: a */
        public final APIResponse apply(Throwable th) {
            Intrinsics.checkParameterIsNotNull(th, "it");
            return this.f3261a.m3770a("authorize/create", th.getLocalizedMessage());
        }
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\n¢\u0006\u0002\b\u0007"}, mo21739d2 = {"<anonymous>", "Lio/reactivex/Single;", "Ljp/reifrontier/silentlogsdkandroid/data/api/RFLH1Client$APIResponse;", "kotlin.jvm.PlatformType", "it", "Lretrofit2/Response;", "Ljp/reifrontier/silentlogsdkandroid/domain/api/RFLProfile;", "apply"}, mo21740k = 3, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.silentlogsdkandroid.data.api.RFLH1Client$b0 */
    static final class C2210b0<T, R> implements C1742e<T, C1718v<? extends R>> {

        /* renamed from: a */
        final /* synthetic */ RFLH1Client f3262a;

        /* renamed from: jp.reifrontier.silentlogsdkandroid.data.api.RFLH1Client$b0$a */
        static final class C2211a<V> implements Callable<T> {

            /* renamed from: a */
            final /* synthetic */ C2210b0 f3263a;

            /* renamed from: b */
            final /* synthetic */ Response f3264b;

            C2211a(C2210b0 b0Var, Response response) {
                this.f3263a = b0Var;
                this.f3264b = response;
            }

            public final APIResponse call() {
                return this.f3263a.f3262a.m3769a(Scopes.PROFILE, this.f3264b.code(), this.f3264b.errorBody(), this.f3264b.body());
            }
        }

        C2210b0(RFLH1Client rFLH1Client) {
            this.f3262a = rFLH1Client;
        }

        /* renamed from: a */
        public final C1714r<APIResponse> apply(Response<RFLProfile> response) {
            Intrinsics.checkParameterIsNotNull(response, "it");
            return C1714r.m2413a(new C2211a(this, response));
        }
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\n¢\u0006\u0002\b\u0007"}, mo21739d2 = {"<anonymous>", "Lio/reactivex/Single;", "Ljp/reifrontier/silentlogsdkandroid/data/api/RFLH1Client$APIResponse;", "kotlin.jvm.PlatformType", "it", "Lretrofit2/Response;", "Ljp/reifrontier/silentlogsdkandroid/domain/api/RFLCommon;", "apply"}, mo21740k = 3, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.silentlogsdkandroid.data.api.RFLH1Client$c */
    static final class C2212c<T, R> implements C1742e<T, C1718v<? extends R>> {

        /* renamed from: a */
        final /* synthetic */ RFLH1Client f3265a;

        /* renamed from: jp.reifrontier.silentlogsdkandroid.data.api.RFLH1Client$c$a */
        static final class C2213a<V> implements Callable<T> {

            /* renamed from: a */
            final /* synthetic */ C2212c f3266a;

            /* renamed from: b */
            final /* synthetic */ Response f3267b;

            C2213a(C2212c cVar, Response response) {
                this.f3266a = cVar;
                this.f3267b = response;
            }

            public final APIResponse call() {
                return this.f3266a.f3265a.m3769a("setting/forgotpass", this.f3267b.code(), this.f3267b.errorBody(), this.f3267b.body());
            }
        }

        C2212c(RFLH1Client rFLH1Client) {
            this.f3265a = rFLH1Client;
        }

        /* renamed from: a */
        public final C1714r<APIResponse> apply(Response<RFLCommon> response) {
            Intrinsics.checkParameterIsNotNull(response, "it");
            return C1714r.m2413a(new C2213a(this, response));
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.data.api.RFLH1Client$c0 */
    static final class C2214c0<T, R> implements C1742e<Throwable, APIResponse> {

        /* renamed from: a */
        final /* synthetic */ RFLH1Client f3268a;

        C2214c0(RFLH1Client rFLH1Client) {
            this.f3268a = rFLH1Client;
        }

        /* renamed from: a */
        public final APIResponse apply(Throwable th) {
            Intrinsics.checkParameterIsNotNull(th, "it");
            return this.f3268a.m3770a(Scopes.PROFILE, th.getLocalizedMessage());
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.data.api.RFLH1Client$d */
    static final class C2215d<T, R> implements C1742e<Throwable, APIResponse> {

        /* renamed from: a */
        final /* synthetic */ RFLH1Client f3269a;

        C2215d(RFLH1Client rFLH1Client) {
            this.f3269a = rFLH1Client;
        }

        /* renamed from: a */
        public final APIResponse apply(Throwable th) {
            Intrinsics.checkParameterIsNotNull(th, "it");
            return this.f3269a.m3770a("setting/forgotpass", th.getLocalizedMessage());
        }
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\n¢\u0006\u0002\b\u0007"}, mo21739d2 = {"<anonymous>", "Lio/reactivex/Single;", "Ljp/reifrontier/silentlogsdkandroid/data/api/RFLH1Client$APIResponse;", "kotlin.jvm.PlatformType", "it", "Lretrofit2/Response;", "Ljp/reifrontier/silentlogsdkandroid/domain/api/RFLProfile;", "apply"}, mo21740k = 3, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.silentlogsdkandroid.data.api.RFLH1Client$d0 */
    static final class C2216d0<T, R> implements C1742e<T, C1718v<? extends R>> {

        /* renamed from: a */
        final /* synthetic */ RFLH1Client f3270a;

        /* renamed from: jp.reifrontier.silentlogsdkandroid.data.api.RFLH1Client$d0$a */
        static final class C2217a<V> implements Callable<T> {

            /* renamed from: a */
            final /* synthetic */ C2216d0 f3271a;

            /* renamed from: b */
            final /* synthetic */ Response f3272b;

            C2217a(C2216d0 d0Var, Response response) {
                this.f3271a = d0Var;
                this.f3272b = response;
            }

            public final APIResponse call() {
                return this.f3271a.f3270a.m3769a(Scopes.PROFILE, this.f3272b.code(), this.f3272b.errorBody(), this.f3272b.body());
            }
        }

        C2216d0(RFLH1Client rFLH1Client) {
            this.f3270a = rFLH1Client;
        }

        /* renamed from: a */
        public final C1714r<APIResponse> apply(Response<RFLProfile> response) {
            Intrinsics.checkParameterIsNotNull(response, "it");
            return C1714r.m2413a(new C2217a(this, response));
        }
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u00012\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005H\n¢\u0006\u0002\b\b"}, mo21739d2 = {"<anonymous>", "Lio/reactivex/Single;", "Ljp/reifrontier/silentlogsdkandroid/data/api/RFLH1Client$APIResponse;", "kotlin.jvm.PlatformType", "it", "Lretrofit2/Response;", "", "Ljp/reifrontier/silentlogsdkandroid/domain/ad/RFLAdCampaign;", "apply"}, mo21740k = 3, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.silentlogsdkandroid.data.api.RFLH1Client$e */
    static final class C2218e<T, R> implements C1742e<T, C1718v<? extends R>> {

        /* renamed from: a */
        final /* synthetic */ RFLH1Client f3273a;

        /* renamed from: jp.reifrontier.silentlogsdkandroid.data.api.RFLH1Client$e$a */
        static final class C2219a<V> implements Callable<T> {

            /* renamed from: a */
            final /* synthetic */ C2218e f3274a;

            /* renamed from: b */
            final /* synthetic */ Response f3275b;

            C2219a(C2218e eVar, Response response) {
                this.f3274a = eVar;
                this.f3275b = response;
            }

            public final APIResponse call() {
                return this.f3274a.f3273a.m3769a("ad/campaign", this.f3275b.code(), this.f3275b.errorBody(), this.f3275b.body());
            }
        }

        C2218e(RFLH1Client rFLH1Client) {
            this.f3273a = rFLH1Client;
        }

        /* renamed from: a */
        public final C1714r<APIResponse> apply(Response<List<RFLAdCampaign>> response) {
            Intrinsics.checkParameterIsNotNull(response, "it");
            return C1714r.m2413a(new C2219a(this, response));
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.data.api.RFLH1Client$e0 */
    static final class C2220e0<T, R> implements C1742e<Throwable, APIResponse> {

        /* renamed from: a */
        final /* synthetic */ RFLH1Client f3276a;

        C2220e0(RFLH1Client rFLH1Client) {
            this.f3276a = rFLH1Client;
        }

        /* renamed from: a */
        public final APIResponse apply(Throwable th) {
            Intrinsics.checkParameterIsNotNull(th, "it");
            return this.f3276a.m3770a(Scopes.PROFILE, th.getLocalizedMessage());
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.data.api.RFLH1Client$f */
    static final class C2221f<T, R> implements C1742e<Throwable, APIResponse> {

        /* renamed from: a */
        final /* synthetic */ RFLH1Client f3277a;

        C2221f(RFLH1Client rFLH1Client) {
            this.f3277a = rFLH1Client;
        }

        /* renamed from: a */
        public final APIResponse apply(Throwable th) {
            Intrinsics.checkParameterIsNotNull(th, "it");
            return this.f3277a.m3770a("ad/campaign", th.getLocalizedMessage());
        }
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\n¢\u0006\u0002\b\u0007"}, mo21739d2 = {"<anonymous>", "Lio/reactivex/Single;", "Ljp/reifrontier/silentlogsdkandroid/data/api/RFLH1Client$APIResponse;", "kotlin.jvm.PlatformType", "it", "Lretrofit2/Response;", "Ljp/reifrontier/silentlogsdkandroid/domain/api/RFLProfile;", "apply"}, mo21740k = 3, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.silentlogsdkandroid.data.api.RFLH1Client$f0 */
    static final class C2222f0<T, R> implements C1742e<T, C1718v<? extends R>> {

        /* renamed from: a */
        final /* synthetic */ RFLH1Client f3278a;

        /* renamed from: jp.reifrontier.silentlogsdkandroid.data.api.RFLH1Client$f0$a */
        static final class C2223a<V> implements Callable<T> {

            /* renamed from: a */
            final /* synthetic */ C2222f0 f3279a;

            /* renamed from: b */
            final /* synthetic */ Response f3280b;

            C2223a(C2222f0 f0Var, Response response) {
                this.f3279a = f0Var;
                this.f3280b = response;
            }

            public final APIResponse call() {
                return this.f3279a.f3278a.m3769a(Scopes.PROFILE, this.f3280b.code(), this.f3280b.errorBody(), this.f3280b.body());
            }
        }

        C2222f0(RFLH1Client rFLH1Client) {
            this.f3278a = rFLH1Client;
        }

        /* renamed from: a */
        public final C1714r<APIResponse> apply(Response<RFLProfile> response) {
            Intrinsics.checkParameterIsNotNull(response, "it");
            return C1714r.m2413a(new C2223a(this, response));
        }
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u00012\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005H\n¢\u0006\u0002\b\b"}, mo21739d2 = {"<anonymous>", "Lio/reactivex/Single;", "Ljp/reifrontier/silentlogsdkandroid/data/api/RFLH1Client$APIResponse;", "kotlin.jvm.PlatformType", "it", "Lretrofit2/Response;", "", "Ljp/reifrontier/silentlogsdkandroid/domain/ad/RFLAdTrigger;", "apply"}, mo21740k = 3, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.silentlogsdkandroid.data.api.RFLH1Client$g */
    static final class C2224g<T, R> implements C1742e<T, C1718v<? extends R>> {

        /* renamed from: a */
        final /* synthetic */ RFLH1Client f3281a;

        /* renamed from: jp.reifrontier.silentlogsdkandroid.data.api.RFLH1Client$g$a */
        static final class C2225a<V> implements Callable<T> {

            /* renamed from: a */
            final /* synthetic */ C2224g f3282a;

            /* renamed from: b */
            final /* synthetic */ Response f3283b;

            C2225a(C2224g gVar, Response response) {
                this.f3282a = gVar;
                this.f3283b = response;
            }

            public final APIResponse call() {
                return this.f3282a.f3281a.m3769a("ad/trigger", this.f3283b.code(), this.f3283b.errorBody(), this.f3283b.body());
            }
        }

        C2224g(RFLH1Client rFLH1Client) {
            this.f3281a = rFLH1Client;
        }

        /* renamed from: a */
        public final C1714r<APIResponse> apply(Response<List<RFLAdTrigger>> response) {
            Intrinsics.checkParameterIsNotNull(response, "it");
            return C1714r.m2413a(new C2225a(this, response));
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.data.api.RFLH1Client$g0 */
    static final class C2226g0<T, R> implements C1742e<Throwable, APIResponse> {

        /* renamed from: a */
        final /* synthetic */ RFLH1Client f3284a;

        C2226g0(RFLH1Client rFLH1Client) {
            this.f3284a = rFLH1Client;
        }

        /* renamed from: a */
        public final APIResponse apply(Throwable th) {
            Intrinsics.checkParameterIsNotNull(th, "it");
            return this.f3284a.m3770a(Scopes.PROFILE, th.getLocalizedMessage());
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.data.api.RFLH1Client$h */
    static final class C2227h<T, R> implements C1742e<Throwable, APIResponse> {

        /* renamed from: a */
        final /* synthetic */ RFLH1Client f3285a;

        C2227h(RFLH1Client rFLH1Client) {
            this.f3285a = rFLH1Client;
        }

        /* renamed from: a */
        public final APIResponse apply(Throwable th) {
            Intrinsics.checkParameterIsNotNull(th, "it");
            return this.f3285a.m3770a("ad/trigger", th.getLocalizedMessage());
        }
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\n¢\u0006\u0002\b\u0007"}, mo21739d2 = {"<anonymous>", "Lio/reactivex/Single;", "Ljp/reifrontier/silentlogsdkandroid/data/api/RFLH1Client$APIResponse;", "kotlin.jvm.PlatformType", "it", "Lretrofit2/Response;", "Ljp/reifrontier/silentlogsdkandroid/domain/daily/RFLDaily;", "apply"}, mo21740k = 3, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.silentlogsdkandroid.data.api.RFLH1Client$i */
    static final class C2228i<T, R> implements C1742e<T, C1718v<? extends R>> {

        /* renamed from: a */
        final /* synthetic */ RFLH1Client f3286a;

        /* renamed from: jp.reifrontier.silentlogsdkandroid.data.api.RFLH1Client$i$a */
        static final class C2229a<V> implements Callable<T> {

            /* renamed from: a */
            final /* synthetic */ C2228i f3287a;

            /* renamed from: b */
            final /* synthetic */ Response f3288b;

            C2229a(C2228i iVar, Response response) {
                this.f3287a = iVar;
                this.f3288b = response;
            }

            public final APIResponse call() {
                return this.f3287a.f3286a.m3769a("user/storyline/daily/", this.f3288b.code(), this.f3288b.errorBody(), this.f3288b.body());
            }
        }

        C2228i(RFLH1Client rFLH1Client) {
            this.f3286a = rFLH1Client;
        }

        /* renamed from: a */
        public final C1714r<APIResponse> apply(Response<RFLDaily> response) {
            Intrinsics.checkParameterIsNotNull(response, "it");
            return C1714r.m2413a(new C2229a(this, response));
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.data.api.RFLH1Client$j */
    static final class C2230j<T, R> implements C1742e<Throwable, APIResponse> {

        /* renamed from: a */
        final /* synthetic */ RFLH1Client f3289a;

        C2230j(RFLH1Client rFLH1Client) {
            this.f3289a = rFLH1Client;
        }

        /* renamed from: a */
        public final APIResponse apply(Throwable th) {
            Intrinsics.checkParameterIsNotNull(th, "it");
            return this.f3289a.m3770a("user/storyline/daily/", th.getLocalizedMessage());
        }
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\n¢\u0006\u0002\b\u0007"}, mo21739d2 = {"<anonymous>", "Lio/reactivex/Single;", "Ljp/reifrontier/silentlogsdkandroid/data/api/RFLH1Client$APIResponse;", "kotlin.jvm.PlatformType", "it", "Lretrofit2/Response;", "Ljp/reifrontier/silentlogsdkandroid/domain/api/RFLProfile;", "apply"}, mo21740k = 3, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.silentlogsdkandroid.data.api.RFLH1Client$k */
    static final class C2231k<T, R> implements C1742e<T, C1718v<? extends R>> {

        /* renamed from: a */
        final /* synthetic */ RFLH1Client f3290a;

        /* renamed from: jp.reifrontier.silentlogsdkandroid.data.api.RFLH1Client$k$a */
        static final class C2232a<V> implements Callable<T> {

            /* renamed from: a */
            final /* synthetic */ C2231k f3291a;

            /* renamed from: b */
            final /* synthetic */ Response f3292b;

            C2232a(C2231k kVar, Response response) {
                this.f3291a = kVar;
                this.f3292b = response;
            }

            public final APIResponse call() {
                return this.f3291a.f3290a.m3769a(Scopes.PROFILE, this.f3292b.code(), this.f3292b.errorBody(), this.f3292b.body());
            }
        }

        C2231k(RFLH1Client rFLH1Client) {
            this.f3290a = rFLH1Client;
        }

        /* renamed from: a */
        public final C1714r<APIResponse> apply(Response<RFLProfile> response) {
            Intrinsics.checkParameterIsNotNull(response, "it");
            return C1714r.m2413a(new C2232a(this, response));
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.data.api.RFLH1Client$l */
    static final class C2233l<T, R> implements C1742e<Throwable, APIResponse> {

        /* renamed from: a */
        final /* synthetic */ RFLH1Client f3293a;

        C2233l(RFLH1Client rFLH1Client) {
            this.f3293a = rFLH1Client;
        }

        /* renamed from: a */
        public final APIResponse apply(Throwable th) {
            Intrinsics.checkParameterIsNotNull(th, "it");
            return this.f3293a.m3770a(Scopes.PROFILE, th.getLocalizedMessage());
        }
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\n¢\u0006\u0002\b\u0007"}, mo21739d2 = {"<anonymous>", "Lio/reactivex/Single;", "Ljp/reifrontier/silentlogsdkandroid/data/api/RFLH1Client$APIResponse;", "kotlin.jvm.PlatformType", "it", "Lretrofit2/Response;", "Ljp/reifrontier/silentlogsdkandroid/domain/api/RFLCreate;", "apply"}, mo21740k = 3, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.silentlogsdkandroid.data.api.RFLH1Client$m */
    static final class C2234m<T, R> implements C1742e<T, C1718v<? extends R>> {

        /* renamed from: a */
        final /* synthetic */ RFLH1Client f3294a;

        /* renamed from: jp.reifrontier.silentlogsdkandroid.data.api.RFLH1Client$m$a */
        static final class C2235a<V> implements Callable<T> {

            /* renamed from: a */
            final /* synthetic */ C2234m f3295a;

            /* renamed from: b */
            final /* synthetic */ Response f3296b;

            C2235a(C2234m mVar, Response response) {
                this.f3295a = mVar;
                this.f3296b = response;
            }

            public final APIResponse call() {
                return this.f3295a.f3294a.m3769a("authorize", this.f3296b.code(), this.f3296b.errorBody(), this.f3296b.body());
            }
        }

        C2234m(RFLH1Client rFLH1Client) {
            this.f3294a = rFLH1Client;
        }

        /* renamed from: a */
        public final C1714r<APIResponse> apply(Response<RFLCreate> response) {
            Intrinsics.checkParameterIsNotNull(response, "it");
            return C1714r.m2413a(new C2235a(this, response));
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.data.api.RFLH1Client$n */
    static final class C2236n<T, R> implements C1742e<Throwable, APIResponse> {

        /* renamed from: a */
        final /* synthetic */ RFLH1Client f3297a;

        C2236n(RFLH1Client rFLH1Client) {
            this.f3297a = rFLH1Client;
        }

        /* renamed from: a */
        public final APIResponse apply(Throwable th) {
            Intrinsics.checkParameterIsNotNull(th, "it");
            return this.f3297a.m3770a("authorize", th.getLocalizedMessage());
        }
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\n¢\u0006\u0002\b\u0007"}, mo21739d2 = {"<anonymous>", "Lio/reactivex/Single;", "Ljp/reifrontier/silentlogsdkandroid/data/api/RFLH1Client$APIResponse;", "kotlin.jvm.PlatformType", "it", "Lretrofit2/Response;", "Ljp/reifrontier/silentlogsdkandroid/domain/ad/RFLAdResult;", "apply"}, mo21740k = 3, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.silentlogsdkandroid.data.api.RFLH1Client$o */
    static final class C2237o<T, R> implements C1742e<T, C1718v<? extends R>> {

        /* renamed from: a */
        final /* synthetic */ RFLH1Client f3298a;

        /* renamed from: jp.reifrontier.silentlogsdkandroid.data.api.RFLH1Client$o$a */
        static final class C2238a<V> implements Callable<T> {

            /* renamed from: a */
            final /* synthetic */ C2237o f3299a;

            /* renamed from: b */
            final /* synthetic */ Response f3300b;

            C2238a(C2237o oVar, Response response) {
                this.f3299a = oVar;
                this.f3300b = response;
            }

            public final APIResponse call() {
                return this.f3299a.f3298a.m3769a("ad/cover", this.f3300b.code(), this.f3300b.errorBody(), this.f3300b.body());
            }
        }

        C2237o(RFLH1Client rFLH1Client) {
            this.f3298a = rFLH1Client;
        }

        /* renamed from: a */
        public final C1714r<APIResponse> apply(Response<RFLAdResult> response) {
            Intrinsics.checkParameterIsNotNull(response, "it");
            return C1714r.m2413a(new C2238a(this, response));
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.data.api.RFLH1Client$p */
    static final class C2239p<T, R> implements C1742e<Throwable, APIResponse> {

        /* renamed from: a */
        final /* synthetic */ RFLH1Client f3301a;

        C2239p(RFLH1Client rFLH1Client) {
            this.f3301a = rFLH1Client;
        }

        /* renamed from: a */
        public final APIResponse apply(Throwable th) {
            Intrinsics.checkParameterIsNotNull(th, "it");
            return this.f3301a.m3770a("ad/cover", th.getLocalizedMessage());
        }
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\n¢\u0006\u0002\b\u0007"}, mo21739d2 = {"<anonymous>", "Lio/reactivex/Single;", "Ljp/reifrontier/silentlogsdkandroid/data/api/RFLH1Client$APIResponse;", "kotlin.jvm.PlatformType", "it", "Lretrofit2/Response;", "Ljp/reifrontier/silentlogsdkandroid/domain/ad/RFLAdResult;", "apply"}, mo21740k = 3, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.silentlogsdkandroid.data.api.RFLH1Client$q */
    static final class C2240q<T, R> implements C1742e<T, C1718v<? extends R>> {

        /* renamed from: a */
        final /* synthetic */ RFLH1Client f3302a;

        /* renamed from: jp.reifrontier.silentlogsdkandroid.data.api.RFLH1Client$q$a */
        static final class C2241a<V> implements Callable<T> {

            /* renamed from: a */
            final /* synthetic */ C2240q f3303a;

            /* renamed from: b */
            final /* synthetic */ Response f3304b;

            C2241a(C2240q qVar, Response response) {
                this.f3303a = qVar;
                this.f3304b = response;
            }

            public final APIResponse call() {
                return this.f3303a.f3302a.m3769a("ad/response", this.f3304b.code(), this.f3304b.errorBody(), this.f3304b.body());
            }
        }

        C2240q(RFLH1Client rFLH1Client) {
            this.f3302a = rFLH1Client;
        }

        /* renamed from: a */
        public final C1714r<APIResponse> apply(Response<RFLAdResult> response) {
            Intrinsics.checkParameterIsNotNull(response, "it");
            return C1714r.m2413a(new C2241a(this, response));
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.data.api.RFLH1Client$r */
    static final class C2242r<T, R> implements C1742e<Throwable, APIResponse> {

        /* renamed from: a */
        final /* synthetic */ RFLH1Client f3305a;

        C2242r(RFLH1Client rFLH1Client) {
            this.f3305a = rFLH1Client;
        }

        /* renamed from: a */
        public final APIResponse apply(Throwable th) {
            Intrinsics.checkParameterIsNotNull(th, "it");
            return this.f3305a.m3770a("ad/response", th.getLocalizedMessage());
        }
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\n¢\u0006\u0002\b\u0007"}, mo21739d2 = {"<anonymous>", "Lio/reactivex/Single;", "Ljp/reifrontier/silentlogsdkandroid/data/api/RFLH1Client$APIResponse;", "kotlin.jvm.PlatformType", "it", "Lretrofit2/Response;", "Ljp/reifrontier/silentlogsdkandroid/domain/ad/RFLAdResult;", "apply"}, mo21740k = 3, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.silentlogsdkandroid.data.api.RFLH1Client$s */
    static final class C2243s<T, R> implements C1742e<T, C1718v<? extends R>> {

        /* renamed from: a */
        final /* synthetic */ RFLH1Client f3306a;

        /* renamed from: jp.reifrontier.silentlogsdkandroid.data.api.RFLH1Client$s$a */
        static final class C2244a<V> implements Callable<T> {

            /* renamed from: a */
            final /* synthetic */ C2243s f3307a;

            /* renamed from: b */
            final /* synthetic */ Response f3308b;

            C2244a(C2243s sVar, Response response) {
                this.f3307a = sVar;
                this.f3308b = response;
            }

            public final APIResponse call() {
                return this.f3307a.f3306a.m3769a("ad/tracking", this.f3308b.code(), this.f3308b.errorBody(), this.f3308b.body());
            }
        }

        C2243s(RFLH1Client rFLH1Client) {
            this.f3306a = rFLH1Client;
        }

        /* renamed from: a */
        public final C1714r<APIResponse> apply(Response<RFLAdResult> response) {
            Intrinsics.checkParameterIsNotNull(response, "it");
            return C1714r.m2413a(new C2244a(this, response));
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.data.api.RFLH1Client$t */
    static final class C2245t<T, R> implements C1742e<Throwable, APIResponse> {

        /* renamed from: a */
        final /* synthetic */ RFLH1Client f3309a;

        C2245t(RFLH1Client rFLH1Client) {
            this.f3309a = rFLH1Client;
        }

        /* renamed from: a */
        public final APIResponse apply(Throwable th) {
            Intrinsics.checkParameterIsNotNull(th, "it");
            return this.f3309a.m3770a("ad/tracking", th.getLocalizedMessage());
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.data.api.RFLH1Client$u */
    static final class C2246u<V> implements Callable<T> {

        /* renamed from: a */
        final /* synthetic */ RFLH1Client f3310a;

        C2246u(RFLH1Client rFLH1Client) {
            this.f3310a = rFLH1Client;
        }

        public final APIResponse call() {
            return this.f3310a.m3770a("user/storyline/daily/", "token is empty");
        }
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\n¢\u0006\u0002\b\u0007"}, mo21739d2 = {"<anonymous>", "Lio/reactivex/Single;", "Ljp/reifrontier/silentlogsdkandroid/data/api/RFLH1Client$APIResponse;", "kotlin.jvm.PlatformType", "it", "Lretrofit2/Response;", "Lokhttp3/ResponseBody;", "apply"}, mo21740k = 3, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.silentlogsdkandroid.data.api.RFLH1Client$v */
    static final class C2247v<T, R> implements C1742e<T, C1718v<? extends R>> {

        /* renamed from: a */
        final /* synthetic */ RFLH1Client f3311a;

        /* renamed from: jp.reifrontier.silentlogsdkandroid.data.api.RFLH1Client$v$a */
        static final class C2248a<V> implements Callable<T> {

            /* renamed from: a */
            final /* synthetic */ C2247v f3312a;

            /* renamed from: b */
            final /* synthetic */ Response f3313b;

            C2248a(C2247v vVar, Response response) {
                this.f3312a = vVar;
                this.f3313b = response;
            }

            public final APIResponse call() {
                return this.f3312a.f3311a.m3769a("user/storyline/daily/", this.f3313b.code(), this.f3313b.errorBody(), this.f3313b.body());
            }
        }

        C2247v(RFLH1Client rFLH1Client) {
            this.f3311a = rFLH1Client;
        }

        /* renamed from: a */
        public final C1714r<APIResponse> apply(Response<C0980J> response) {
            Intrinsics.checkParameterIsNotNull(response, "it");
            return C1714r.m2413a(new C2248a(this, response));
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.data.api.RFLH1Client$w */
    static final class C2249w<T, R> implements C1742e<Throwable, APIResponse> {

        /* renamed from: a */
        final /* synthetic */ RFLH1Client f3314a;

        C2249w(RFLH1Client rFLH1Client) {
            this.f3314a = rFLH1Client;
        }

        /* renamed from: a */
        public final APIResponse apply(Throwable th) {
            Intrinsics.checkParameterIsNotNull(th, "it");
            return this.f3314a.m3770a("user/storyline/daily/", th.getLocalizedMessage());
        }
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\n¢\u0006\u0002\b\u0007"}, mo21739d2 = {"<anonymous>", "Lio/reactivex/Single;", "Ljp/reifrontier/silentlogsdkandroid/data/api/RFLH1Client$APIResponse;", "kotlin.jvm.PlatformType", "it", "Lretrofit2/Response;", "Ljp/reifrontier/silentlogsdkandroid/domain/api/RFLProfile;", "apply"}, mo21740k = 3, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.silentlogsdkandroid.data.api.RFLH1Client$x */
    static final class C2250x<T, R> implements C1742e<T, C1718v<? extends R>> {

        /* renamed from: a */
        final /* synthetic */ RFLH1Client f3315a;

        /* renamed from: jp.reifrontier.silentlogsdkandroid.data.api.RFLH1Client$x$a */
        static final class C2251a<V> implements Callable<T> {

            /* renamed from: a */
            final /* synthetic */ C2250x f3316a;

            /* renamed from: b */
            final /* synthetic */ Response f3317b;

            C2251a(C2250x xVar, Response response) {
                this.f3316a = xVar;
                this.f3317b = response;
            }

            public final APIResponse call() {
                return this.f3316a.f3315a.m3769a(Scopes.PROFILE, this.f3317b.code(), this.f3317b.errorBody(), this.f3317b.body());
            }
        }

        C2250x(RFLH1Client rFLH1Client) {
            this.f3315a = rFLH1Client;
        }

        /* renamed from: a */
        public final C1714r<APIResponse> apply(Response<RFLProfile> response) {
            Intrinsics.checkParameterIsNotNull(response, "it");
            return C1714r.m2413a(new C2251a(this, response));
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.data.api.RFLH1Client$y */
    static final class C2252y<T, R> implements C1742e<Throwable, APIResponse> {

        /* renamed from: a */
        final /* synthetic */ RFLH1Client f3318a;

        C2252y(RFLH1Client rFLH1Client) {
            this.f3318a = rFLH1Client;
        }

        /* renamed from: a */
        public final APIResponse apply(Throwable th) {
            Intrinsics.checkParameterIsNotNull(th, "it");
            return this.f3318a.m3770a(Scopes.PROFILE, th.getLocalizedMessage());
        }
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\n¢\u0006\u0002\b\u0007"}, mo21739d2 = {"<anonymous>", "Lio/reactivex/Single;", "Ljp/reifrontier/silentlogsdkandroid/data/api/RFLH1Client$APIResponse;", "kotlin.jvm.PlatformType", "it", "Lretrofit2/Response;", "Ljp/reifrontier/silentlogsdkandroid/domain/api/RFLProfile;", "apply"}, mo21740k = 3, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.silentlogsdkandroid.data.api.RFLH1Client$z */
    static final class C2253z<T, R> implements C1742e<T, C1718v<? extends R>> {

        /* renamed from: a */
        final /* synthetic */ RFLH1Client f3319a;

        /* renamed from: jp.reifrontier.silentlogsdkandroid.data.api.RFLH1Client$z$a */
        static final class C2254a<V> implements Callable<T> {

            /* renamed from: a */
            final /* synthetic */ C2253z f3320a;

            /* renamed from: b */
            final /* synthetic */ Response f3321b;

            C2254a(C2253z zVar, Response response) {
                this.f3320a = zVar;
                this.f3321b = response;
            }

            public final APIResponse call() {
                return this.f3320a.f3319a.m3769a(Scopes.PROFILE, this.f3321b.code(), this.f3321b.errorBody(), this.f3321b.body());
            }
        }

        C2253z(RFLH1Client rFLH1Client) {
            this.f3319a = rFLH1Client;
        }

        /* renamed from: a */
        public final C1714r<APIResponse> apply(Response<RFLProfile> response) {
            Intrinsics.checkParameterIsNotNull(response, "it");
            return C1714r.m2413a(new C2254a(this, response));
        }
    }

    public RFLH1Client() {
        RFLAppComponent component$silentlogsdkandroid_release = RFLAppComponent.SdkComponent.INSTANCE.getComponent$silentlogsdkandroid_release();
        if (component$silentlogsdkandroid_release != null) {
            component$silentlogsdkandroid_release.inject(this);
        }
        this.f3253e = true;
    }

    /* renamed from: a */
    private final String m3768a() {
        String baseUrl = RFLSharedHolder.INSTANCE.baseUrl();
        if (TextUtils.isEmpty(baseUrl)) {
            return this.f3253e ? STAGING_URL : "https://api.silentlog.com/api/v1/";
        }
        if (baseUrl == null) {
            Intrinsics.throwNpe();
        }
        return baseUrl;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final APIResponse m3769a(String str, int i, C0980J j, Object obj) {
        String string = (i == 200 || i == 500 || j == null) ? null : j.string();
        if (i != 200) {
            C1122a.m1599b("[SilentLogSDK]::Error API requestPath: " + str + " statusCode: " + i, new Object[0]);
        }
        if (string != null) {
            C1122a.m1599b(C0681a.m320a("[SilentLogSDK]::Error API response: ", string), new Object[0]);
        }
        if (i == 401 && (string == null || string.length() != 2)) {
            C1122a.m1599b("[SilentLogSDK]::Error need to refresh token", new Object[0]);
            C1126c cVar = this.eventBus;
            if (cVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("eventBus");
            }
            cVar.mo21903a((Object) new InvalidToken());
        }
        return new APIResponse(i, string, obj);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final APIResponse m3770a(String str, String str2) {
        C1122a.m1599b("[SilentLogSDK]::Error API requestPath: %s statusCode: %s", str, Integer.valueOf(RFLAdResult.ERROR_FAILED));
        C1122a.m1599b("[SilentLogSDK]::Error API response: " + str2, new Object[0]);
        return new APIResponse(RFLAdResult.ERROR_FAILED, str2, (Object) null);
    }

    public final void build(Context context, boolean z) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.f3253e = z;
        C1909a aVar = new C1909a(new RFLH1Client$build$logger$1());
        aVar.mo28005a(this.f3253e ? C1909a.C1910a.BODY : C1909a.C1910a.NONE);
        C1752D.C1753a aVar2 = new C1752D.C1753a();
        aVar2.mo27508c(240, TimeUnit.SECONDS);
        aVar2.mo27505b(240, TimeUnit.SECONDS);
        aVar2.mo27509d(240, TimeUnit.SECONDS);
        aVar2.mo27503a(true);
        aVar2.mo27501a((C1744A) new RFLUserAgentInterceptor(context));
        aVar2.mo27501a((C1744A) aVar);
        Retrofit build = new Retrofit.Builder().client(new C1752D(aVar2)).baseUrl(m3768a()).addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(C1578g.m2208a()).build();
        Intrinsics.checkExpressionValueIsNotNull(build, "Retrofit.Builder()\n     …\n                .build()");
        this.f3249a = build;
        Object create = build.create(RFLApiAccount.class);
        Intrinsics.checkExpressionValueIsNotNull(create, "retrofit.create(RFLApiAccount::class.java)");
        this.f3250b = (RFLApiAccount) create;
        Retrofit retrofit = this.f3249a;
        if (retrofit == null) {
            Intrinsics.throwUninitializedPropertyAccessException("retrofit");
        }
        Object create2 = retrofit.create(RFLApiDaily.class);
        Intrinsics.checkExpressionValueIsNotNull(create2, "retrofit.create(RFLApiDaily::class.java)");
        this.f3251c = (RFLApiDaily) create2;
        Retrofit retrofit3 = this.f3249a;
        if (retrofit3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("retrofit");
        }
        Object create3 = retrofit3.create(RFLApiAd.class);
        Intrinsics.checkExpressionValueIsNotNull(create3, "retrofit.create(RFLApiAd::class.java)");
        this.f3252d = (RFLApiAd) create3;
    }

    public final C1714r<APIResponse> create(String str, String str2, String str3, String str4, String str5, boolean z, List<String> list, String str6) {
        String str7 = str2;
        Intrinsics.checkParameterIsNotNull(str, "username");
        Intrinsics.checkParameterIsNotNull(str3, "password");
        Intrinsics.checkParameterIsNotNull(str4, "gender");
        Intrinsics.checkParameterIsNotNull(str5, "birthday");
        Gson gson = new Gson();
        Date date = new Date();
        String format$default = RFLDailyUtilsKt.format$default(date, "yyyyMMdd'T'HHmmss'Z'", (String) null, 2, (Object) null);
        String format$default2 = RFLDailyUtilsKt.format$default(date, "yyyyMMdd'T'HHmmssZ", (String) null, 2, (Object) null);
        String format$default3 = RFLDailyUtilsKt.format$default(new Date(RFLSharedHolder.INSTANCE.installDate()), "yyyyMMdd'T'HHmmss'Z'", (String) null, 2, (Object) null);
        String json = gson.toJson((Object) new RFLPrivate(format$default, Boolean.valueOf(z), format$default2, list, str6, (Integer) null, (List) null, (Boolean) null, format$default3, Boolean.valueOf(RFLSharedHolder.INSTANCE.isEnableTwoWeekSetting()), 224, (DefaultConstructorMarker) null));
        String json2 = str7 != null ? gson.toJson((Object) new RFLExtra(str7)) : null;
        String clientId = RFLSharedHolder.INSTANCE.clientId();
        String clientSecret = RFLSharedHolder.INSTANCE.clientSecret();
        String uuid = RFLSharedHolder.INSTANCE.uuid();
        TimeZone timeZone = TimeZone.getDefault();
        Intrinsics.checkExpressionValueIsNotNull(timeZone, "TimeZone.getDefault()");
        String id = timeZone.getID();
        String defaultLang = LocaleEx.INSTANCE.getDefaultLang();
        RFLApiAccount rFLApiAccount = this.f3250b;
        if (rFLApiAccount == null) {
            Intrinsics.throwUninitializedPropertyAccessException("apiAccount");
        }
        Intrinsics.checkExpressionValueIsNotNull(id, "timezone");
        Intrinsics.checkExpressionValueIsNotNull(json, "privateKeyJson");
        C1714r<APIResponse> c = RFLApiAccount.DefaultImpls.create$default(rFLApiAccount, clientId, clientSecret, uuid, "and", id, defaultLang, str, str3, str4, str5, format$default3, json, json2, (Map) null, 8192, (Object) null).mo27430a(new C2206a(this)).mo27436c(new C2209b(this));
        Intrinsics.checkExpressionValueIsNotNull(c, "apiAccount.create(\n     …essage)\n                }");
        return c;
    }

    public final C1714r<APIResponse> forgetPassword(String str) {
        Intrinsics.checkParameterIsNotNull(str, "email");
        String defaultLang = LocaleEx.INSTANCE.getDefaultLang();
        RFLApiAccount rFLApiAccount = this.f3250b;
        if (rFLApiAccount == null) {
            Intrinsics.throwUninitializedPropertyAccessException("apiAccount");
        }
        C1714r<R> c = rFLApiAccount.forgetPassword(str, defaultLang).mo27430a(new C2212c(this)).mo27436c(new C2215d(this));
        Intrinsics.checkExpressionValueIsNotNull(c, "apiAccount.forgetPasswor…essage)\n                }");
        return c;
    }

    public final C1714r<APIResponse> getAdCampaign() {
        String accessToken = RFLSharedHolder.INSTANCE.accessToken();
        RFLApiAd rFLApiAd = this.f3252d;
        if (rFLApiAd == null) {
            Intrinsics.throwUninitializedPropertyAccessException("apiAd");
        }
        C1714r<R> c = rFLApiAd.getCampaign(accessToken).mo27430a(new C2218e(this)).mo27436c(new C2221f(this));
        Intrinsics.checkExpressionValueIsNotNull(c, "apiAd.getCampaign(access…essage)\n                }");
        return c;
    }

    public final C1714r<APIResponse> getAdTrigger(double d, double d2) {
        String accessToken = RFLSharedHolder.INSTANCE.accessToken();
        RFLApiAd rFLApiAd = this.f3252d;
        if (rFLApiAd == null) {
            Intrinsics.throwUninitializedPropertyAccessException("apiAd");
        }
        C1714r<R> c = rFLApiAd.getTrigger(accessToken, d, d2).mo27430a(new C2224g(this)).mo27436c(new C2227h(this));
        Intrinsics.checkExpressionValueIsNotNull(c, "apiAd.getTrigger(accessT…essage)\n                }");
        return c;
    }

    public final C1714r<APIResponse> getDaily(Date date) {
        Intrinsics.checkParameterIsNotNull(date, "date");
        String format = RFLDailyUtilsKt.format(RFLDailyUtilsKt.start(date), "yyyyMMdd", "GMT");
        String accessToken = RFLSharedHolder.INSTANCE.accessToken();
        RFLApiDaily rFLApiDaily = this.f3251c;
        if (rFLApiDaily == null) {
            Intrinsics.throwUninitializedPropertyAccessException("apiDaily");
        }
        C1714r<APIResponse> c = RFLApiDaily.DefaultImpls.get$default(rFLApiDaily, format, accessToken, (Map) null, 4, (Object) null).mo27430a(new C2228i(this)).mo27436c(new C2230j(this));
        Intrinsics.checkExpressionValueIsNotNull(c, "apiDaily.get(dateString,…essage)\n                }");
        return c;
    }

    public final C1126c getEventBus() {
        C1126c cVar = this.eventBus;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("eventBus");
        }
        return cVar;
    }

    public final C1714r<APIResponse> getProfile(String str, String str2) {
        Intrinsics.checkParameterIsNotNull(str, "privateKey");
        Intrinsics.checkParameterIsNotNull(str2, "extraKey");
        String accessToken = RFLSharedHolder.INSTANCE.accessToken();
        RFLApiAccount rFLApiAccount = this.f3250b;
        if (rFLApiAccount == null) {
            Intrinsics.throwUninitializedPropertyAccessException("apiAccount");
        }
        C1714r<APIResponse> c = RFLApiAccount.DefaultImpls.profile$default(rFLApiAccount, accessToken, str, str2, (Map) null, 8, (Object) null).mo27430a(new C2231k(this)).mo27436c(new C2233l(this));
        Intrinsics.checkExpressionValueIsNotNull(c, "apiAccount.profile(token…essage)\n                }");
        return c;
    }

    public final boolean getStaging() {
        return this.f3253e;
    }

    public final C1714r<APIResponse> login(String str, String str2) {
        Intrinsics.checkParameterIsNotNull(str, "username");
        Intrinsics.checkParameterIsNotNull(str2, "password");
        String uuid = RFLSharedHolder.INSTANCE.uuid();
        TimeZone timeZone = TimeZone.getDefault();
        Intrinsics.checkExpressionValueIsNotNull(timeZone, "TimeZone.getDefault()");
        String id = timeZone.getID();
        String defaultLang = LocaleEx.INSTANCE.getDefaultLang();
        String clientId = RFLSharedHolder.INSTANCE.clientId();
        String clientSecret = RFLSharedHolder.INSTANCE.clientSecret();
        RFLApiAccount rFLApiAccount = this.f3250b;
        if (rFLApiAccount == null) {
            Intrinsics.throwUninitializedPropertyAccessException("apiAccount");
        }
        Intrinsics.checkExpressionValueIsNotNull(id, "timezone");
        C1714r<APIResponse> c = RFLApiAccount.DefaultImpls.login$default(rFLApiAccount, clientId, clientSecret, uuid, "and", id, defaultLang, str, str2, (Map) null, 256, (Object) null).mo27430a(new C2234m(this)).mo27436c(new C2236n(this));
        Intrinsics.checkExpressionValueIsNotNull(c, "apiAccount.login(\n      …essage)\n                }");
        return c;
    }

    public final C1714r<Response<RFLLogout>> logout() {
        String accessToken = RFLSharedHolder.INSTANCE.accessToken();
        RFLApiAccount rFLApiAccount = this.f3250b;
        if (rFLApiAccount == null) {
            Intrinsics.throwUninitializedPropertyAccessException("apiAccount");
        }
        return rFLApiAccount.logout(accessToken);
    }

    public final C1714r<APIResponse> postAdCover(int i, double d, double d2) {
        String accessToken = RFLSharedHolder.INSTANCE.accessToken();
        RFLApiAd rFLApiAd = this.f3252d;
        if (rFLApiAd == null) {
            Intrinsics.throwUninitializedPropertyAccessException("apiAd");
        }
        C1714r<R> c = rFLApiAd.postCover(accessToken, i, d, d2).mo27430a(new C2237o(this)).mo27436c(new C2239p(this));
        Intrinsics.checkExpressionValueIsNotNull(c, "apiAd.postCover(accessTo…essage)\n                }");
        return c;
    }

    public final C1714r<APIResponse> postAdResponse(int i, RFLAdResType rFLAdResType, double d, double d2) {
        Intrinsics.checkParameterIsNotNull(rFLAdResType, "resType");
        String accessToken = RFLSharedHolder.INSTANCE.accessToken();
        RFLApiAd rFLApiAd = this.f3252d;
        if (rFLApiAd == null) {
            Intrinsics.throwUninitializedPropertyAccessException("apiAd");
        }
        C1714r<R> c = rFLApiAd.postResponse(accessToken, i, rFLAdResType.getType(), d, d2).mo27430a(new C2240q(this)).mo27436c(new C2242r(this));
        Intrinsics.checkExpressionValueIsNotNull(c, "apiAd.postResponse(acces…essage)\n                }");
        return c;
    }

    public final C1714r<APIResponse> postAdTracking(RFLAdTrackingType rFLAdTrackingType, double d, double d2) {
        Intrinsics.checkParameterIsNotNull(rFLAdTrackingType, "trackingType");
        String accessToken = RFLSharedHolder.INSTANCE.accessToken();
        String type = rFLAdTrackingType.getType();
        RFLApiAd rFLApiAd = this.f3252d;
        if (rFLApiAd == null) {
            Intrinsics.throwUninitializedPropertyAccessException("apiAd");
        }
        C1714r<R> c = rFLApiAd.postTracking(accessToken, type, d, d2).mo27430a(new C2243s(this)).mo27436c(new C2245t(this));
        Intrinsics.checkExpressionValueIsNotNull(c, "apiAd.postTracking(acces…essage)\n                }");
        return c;
    }

    public final C1714r<APIResponse> postDaily(String str, String str2) {
        C1714r<APIResponse> c;
        String str3;
        Intrinsics.checkParameterIsNotNull(str, "dateString");
        Intrinsics.checkParameterIsNotNull(str2, "daily");
        String accessToken = RFLSharedHolder.INSTANCE.accessToken();
        if (accessToken.length() == 0) {
            c = C1714r.m2413a(new C2246u(this));
            str3 = "Single.fromCallable {\n  … is empty\")\n            }";
        } else {
            RFLApiDaily rFLApiDaily = this.f3251c;
            if (rFLApiDaily == null) {
                Intrinsics.throwUninitializedPropertyAccessException("apiDaily");
            }
            c = RFLApiDaily.DefaultImpls.post$default(rFLApiDaily, str, accessToken, str2, (Map) null, 8, (Object) null).mo27430a(new C2247v(this)).mo27436c(new C2249w(this));
            str3 = "apiDaily.post(dateString…essage)\n                }";
        }
        Intrinsics.checkExpressionValueIsNotNull(c, str3);
        return c;
    }

    public final C1714r<APIResponse> postPrivateKey(RFLPrivate rFLPrivate) {
        Intrinsics.checkParameterIsNotNull(rFLPrivate, "privateKey");
        String accessToken = RFLSharedHolder.INSTANCE.accessToken();
        String json = new Gson().toJson((Object) rFLPrivate);
        RFLApiAccount rFLApiAccount = this.f3250b;
        if (rFLApiAccount == null) {
            Intrinsics.throwUninitializedPropertyAccessException("apiAccount");
        }
        Intrinsics.checkExpressionValueIsNotNull(json, "privateKeyJson");
        C1714r<R> c = rFLApiAccount.updatePrivateKey(accessToken, json).mo27430a(new C2250x(this)).mo27436c(new C2252y(this));
        Intrinsics.checkExpressionValueIsNotNull(c, "apiAccount.updatePrivate…essage)\n                }");
        return c;
    }

    public final C1714r<APIResponse> postPrivateKeyMap(Map<String, ? extends Object> map) {
        Intrinsics.checkParameterIsNotNull(map, "privateKeyMap");
        String accessToken = RFLSharedHolder.INSTANCE.accessToken();
        String json = new Gson().toJson((Object) map);
        RFLApiAccount rFLApiAccount = this.f3250b;
        if (rFLApiAccount == null) {
            Intrinsics.throwUninitializedPropertyAccessException("apiAccount");
        }
        Intrinsics.checkExpressionValueIsNotNull(json, "privateKeyJson");
        C1714r<R> c = rFLApiAccount.updatePrivateKey(accessToken, json).mo27430a(new C2253z(this)).mo27436c(new C2208a0(this));
        Intrinsics.checkExpressionValueIsNotNull(c, "apiAccount.updatePrivate…essage)\n                }");
        return c;
    }

    public final C1714r<APIResponse> postProfile(String str) {
        Intrinsics.checkParameterIsNotNull(str, "password");
        String accessToken = RFLSharedHolder.INSTANCE.accessToken();
        RFLApiAccount rFLApiAccount = this.f3250b;
        if (rFLApiAccount == null) {
            Intrinsics.throwUninitializedPropertyAccessException("apiAccount");
        }
        C1714r<APIResponse> c = RFLApiAccount.DefaultImpls.updatePassword$default(rFLApiAccount, accessToken, str, (Map) null, 4, (Object) null).mo27430a(new C2210b0(this)).mo27436c(new C2214c0(this));
        Intrinsics.checkExpressionValueIsNotNull(c, "apiAccount.updatePasswor…essage)\n                }");
        return c;
    }

    public final void setEventBus(C1126c cVar) {
        Intrinsics.checkParameterIsNotNull(cVar, "<set-?>");
        this.eventBus = cVar;
    }

    public final void setStaging(boolean z) {
        this.f3253e = z;
    }

    public final C1714r<APIResponse> updateBirthday(String str) {
        Intrinsics.checkParameterIsNotNull(str, "birthday");
        String accessToken = RFLSharedHolder.INSTANCE.accessToken();
        RFLApiAccount rFLApiAccount = this.f3250b;
        if (rFLApiAccount == null) {
            Intrinsics.throwUninitializedPropertyAccessException("apiAccount");
        }
        C1714r<R> c = rFLApiAccount.updateBirthday(accessToken, str).mo27430a(new C2216d0(this)).mo27436c(new C2220e0(this));
        Intrinsics.checkExpressionValueIsNotNull(c, "apiAccount.updateBirthda…essage)\n                }");
        return c;
    }

    public final C1714r<APIResponse> updateGender(String str) {
        Intrinsics.checkParameterIsNotNull(str, "gender");
        String accessToken = RFLSharedHolder.INSTANCE.accessToken();
        RFLApiAccount rFLApiAccount = this.f3250b;
        if (rFLApiAccount == null) {
            Intrinsics.throwUninitializedPropertyAccessException("apiAccount");
        }
        C1714r<R> c = rFLApiAccount.updateGender(accessToken, str).mo27430a(new C2222f0(this)).mo27436c(new C2226g0(this));
        Intrinsics.checkExpressionValueIsNotNull(c, "apiAccount.updateGender(…essage)\n                }");
        return c;
    }
}
