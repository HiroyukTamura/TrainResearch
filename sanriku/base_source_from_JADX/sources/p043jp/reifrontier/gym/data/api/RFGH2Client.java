package p043jp.reifrontier.gym.data.api;

import android.content.Context;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.io.File;
import java.lang.annotation.Annotation;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.C1126c;
import p009e.p010a.p011a.p012a.C0681a;
import p009e.p069e.p070a.p071a.p072a.C1578g;
import p040i.C0976G;
import p040i.C0980J;
import p040i.C1744A;
import p040i.C1746B;
import p040i.C1748C;
import p040i.C1752D;
import p040i.p116N.C1909a;
import p043jp.reifrontier.gym.data.bus.RFGUnauthorize;
import p043jp.reifrontier.gym.domain.api.RFGCommonResponse;
import p043jp.reifrontier.gym.p044ui.dialog.RFGSheetDialog;
import p043jp.reifrontier.silentlogsdkandroid.data.shared.RFLSharedHolder;
import p043jp.reifrontier.silentlogsdkandroid.utils.LocaleEx;
import p048l.p049a.C1122a;
import p078g.p079a.C1714r;
import p078g.p079a.C1718v;
import p078g.p079a.p100z.C1742e;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u000e\u0018\u0000 Q2\u00020\u0001:\u0003QRSB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fJ\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010J\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0013\u001a\u00020\u0010J\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0010J\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0013\u001a\u00020\u0010J\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\r0\fJ6\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u00102\b\u0010\u001e\u001a\u0004\u0018\u00010\u0010J\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\r0\fJ\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0013\u001a\u00020\u0010J\u001c\u0010!\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\"\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0010J\u001c\u0010#\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0010J\u0010\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020'J\u0014\u0010(\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010)\u001a\u00020\u0010J\u0014\u0010*\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010+\u001a\u00020\u0010J\u001a\u0010,\u001a\u00020\r2\u0006\u0010-\u001a\u00020\u00102\b\u0010.\u001a\u0004\u0018\u00010\u0010H\u0002J,\u0010/\u001a\u00020\r2\u0006\u0010-\u001a\u00020\u00102\u0006\u00100\u001a\u0002012\b\u0010.\u001a\u0004\u0018\u00010'2\b\u00102\u001a\u0004\u0018\u00010\u0001H\u0002J\u001c\u00103\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010+\u001a\u00020\u0010J,\u00104\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u00105\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010+\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u000201J\u0014\u00106\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u00107\u001a\u00020\u0010J0\u00102\u001a\b\u0012\u0004\u0012\u00020\r0\f\"\u0004\b\u0000\u001082\u0012\u00109\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H80:0\f2\u0006\u0010-\u001a\u00020\u0010H\u0002J\u0014\u0010;\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010<\u001a\u00020\u0010J*\u0010=\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010>\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00100@J\u0014\u0010A\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010>\u001a\u00020\u0010J\u001c\u0010B\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010>\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0010JF\u0010C\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0013\u001a\u00020\u00102\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00102\b\u0010\u001c\u001a\u0004\u0018\u00010\u00102\b\u0010\u001d\u001a\u0004\u0018\u00010\u00102\b\u0010\u001e\u001a\u0004\u0018\u00010\u0010J \u0010D\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0012\u0010E\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100FJ\u0014\u0010G\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010H\u001a\u00020\u001aJ \u0010I\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0012\u0010E\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100FJ\u001c\u0010J\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0010J\u0014\u0010K\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0015\u001a\u00020\u0010J\f\u0010L\u001a\b\u0012\u0004\u0012\u00020\r0\fJ\f\u0010M\u001a\b\u0012\u0004\u0012\u00020\r0\fJ\f\u0010N\u001a\b\u0012\u0004\u0012\u00020\r0\fJ\f\u0010O\u001a\b\u0012\u0004\u0012\u00020\r0\fJ\u0014\u0010P\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010>\u001a\u00020\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000¨\u0006T"}, mo21739d2 = {"Ljp/reifrontier/gym/data/api/RFGH2Client;", "", "()V", "retrofit", "Lretrofit2/Retrofit;", "rfgApi", "Ljp/reifrontier/gym/data/api/RFGApi;", "build", "", "context", "Landroid/content/Context;", "challenge", "Lio/reactivex/Single;", "Ljp/reifrontier/gym/data/api/RFGH2Client$H2APIResponse;", "chart", "type", "", "count", "clubDetail", "clubId", "clubRefuse", "gymId", "clubUsers", "clubs", "createClub", "iconFile", "Ljava/io/File;", "name", "detail", "reset", "endTime", "currentYearPoint", "deleteClub", "entryClubByClubCode", "clubCode", "entryClubByClubId", "errorResponse", "Ljp/reifrontier/gym/domain/api/RFGCommonResponse;", "errorBody", "Lokhttp3/ResponseBody;", "exchangeReward", "rewardid", "feed", "date", "handleErrorResponse", "path", "error", "handleResponse", "code", "", "response", "history", "ranking", "kind", "resetPass", "mail", "T", "api", "Lretrofit2/Response;", "reward", "category", "rewardRequest", "year", "rewardIds", "", "rewardStatus", "rewardUserList", "updateClub", "updateUser", "param", "", "uploadPhoto", "file", "userAction", "userAuth", "userExist", "userHistory", "userInfo", "userPersonal", "userReward", "userYearPoint", "Companion", "H2APIResponse", "Holder", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.data.api.RFGH2Client */
public final class RFGH2Client {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Lazy INSTANCE$delegate = LazyKt__LazyJVMKt.lazy(RFGH2Client$Companion$INSTANCE$2.INSTANCE);
    private static final String PRODUCTION_URL = "https://api.gym.silentlog.com/api/v1/";
    private static final String STAGING_URL = "https://api.gym.silentlogapp.com/api/v1/";
    private Retrofit retrofit;
    private RFGApi rfgApi;

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nXT¢\u0006\u0002\n\u0000¨\u0006\f"}, mo21739d2 = {"Ljp/reifrontier/gym/data/api/RFGH2Client$Companion;", "", "()V", "INSTANCE", "Ljp/reifrontier/gym/data/api/RFGH2Client;", "getINSTANCE", "()Ljp/reifrontier/gym/data/api/RFGH2Client;", "INSTANCE$delegate", "Lkotlin/Lazy;", "PRODUCTION_URL", "", "STAGING_URL", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.data.api.RFGH2Client$Companion */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RFGH2Client getINSTANCE() {
            Lazy access$getINSTANCE$cp = RFGH2Client.INSTANCE$delegate;
            Companion companion = RFGH2Client.Companion;
            return (RFGH2Client) access$getINSTANCE$cp.getValue();
        }
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0007J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÆ\u0003J+\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, mo21739d2 = {"Ljp/reifrontier/gym/data/api/RFGH2Client$H2APIResponse;", "", "code", "", "error", "Lokhttp3/ResponseBody;", "data", "(ILokhttp3/ResponseBody;Ljava/lang/Object;)V", "getCode", "()I", "getData", "()Ljava/lang/Object;", "getError", "()Lokhttp3/ResponseBody;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.data.api.RFGH2Client$H2APIResponse */
    public static final class H2APIResponse {
        private final int code;
        private final Object data;
        private final C0980J error;

        public H2APIResponse(int i, C0980J j, Object obj) {
            this.code = i;
            this.error = j;
            this.data = obj;
        }

        public static /* synthetic */ H2APIResponse copy$default(H2APIResponse h2APIResponse, int i, C0980J j, Object obj, int i2, Object obj2) {
            if ((i2 & 1) != 0) {
                i = h2APIResponse.code;
            }
            if ((i2 & 2) != 0) {
                j = h2APIResponse.error;
            }
            if ((i2 & 4) != 0) {
                obj = h2APIResponse.data;
            }
            return h2APIResponse.copy(i, j, obj);
        }

        public final int component1() {
            return this.code;
        }

        public final C0980J component2() {
            return this.error;
        }

        public final Object component3() {
            return this.data;
        }

        public final H2APIResponse copy(int i, C0980J j, Object obj) {
            return new H2APIResponse(i, j, obj);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof H2APIResponse)) {
                return false;
            }
            H2APIResponse h2APIResponse = (H2APIResponse) obj;
            return this.code == h2APIResponse.code && Intrinsics.areEqual((Object) this.error, (Object) h2APIResponse.error) && Intrinsics.areEqual(this.data, h2APIResponse.data);
        }

        public final int getCode() {
            return this.code;
        }

        public final Object getData() {
            return this.data;
        }

        public final C0980J getError() {
            return this.error;
        }

        public int hashCode() {
            int i = this.code * 31;
            C0980J j = this.error;
            int i2 = 0;
            int hashCode = (i + (j != null ? j.hashCode() : 0)) * 31;
            Object obj = this.data;
            if (obj != null) {
                i2 = obj.hashCode();
            }
            return hashCode + i2;
        }

        public String toString() {
            StringBuilder a = C0681a.m330a("H2APIResponse(code=");
            a.append(this.code);
            a.append(", error=");
            a.append(this.error);
            a.append(", data=");
            a.append(this.data);
            a.append(")");
            return a.toString();
        }
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, mo21739d2 = {"Ljp/reifrontier/gym/data/api/RFGH2Client$Holder;", "", "()V", "INSTANCE", "Ljp/reifrontier/gym/data/api/RFGH2Client;", "getINSTANCE", "()Ljp/reifrontier/gym/data/api/RFGH2Client;", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.data.api.RFGH2Client$Holder */
    private static final class Holder {
        public static final Holder INSTANCE = new Holder();

        /* renamed from: INSTANCE  reason: collision with other field name */
        private static final RFGH2Client f4369INSTANCE = new RFGH2Client((DefaultConstructorMarker) null);

        private Holder() {
        }

        public final RFGH2Client getINSTANCE() {
            return f4369INSTANCE;
        }
    }

    private RFGH2Client() {
    }

    public /* synthetic */ RFGH2Client(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* access modifiers changed from: private */
    public final H2APIResponse handleErrorResponse(String str, String str2) {
        C1122a.m1599b("[Gym]::Error API requestPath: " + str + " statusCode: " + 888, new Object[0]);
        StringBuilder sb = new StringBuilder();
        sb.append("[Gym]::Error API response: ");
        sb.append(str2);
        C1122a.m1599b(sb.toString(), new Object[0]);
        return new H2APIResponse(888, (C0980J) null, (Object) null);
    }

    /* access modifiers changed from: private */
    public final H2APIResponse handleResponse(String str, int i, C0980J j, Object obj) {
        if (i != 200) {
            if (i != 204) {
                C1122a.m1599b("[Gym]::Error API requestPath: " + str + " statusCode: " + i, new Object[0]);
                StringBuilder sb = new StringBuilder();
                sb.append("[Gym]::Error API response: ");
                sb.append(j);
                C1122a.m1599b(sb.toString(), new Object[0]);
            } else if (!Intrinsics.areEqual((Object) str, (Object) "user/personal")) {
                C1122a.m1599b("[Gym]::Error API requestPath: " + str + " statusCode: " + i, new Object[0]);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("[Gym]::Error API response: ");
                sb2.append(j);
                C1122a.m1599b(sb2.toString(), new Object[0]);
            }
        }
        if (i == 401) {
            C1122a.m1599b("[Gym]::Error need to logout", new Object[0]);
            C1126c.m1638c().mo21903a((Object) new RFGUnauthorize());
        }
        return new H2APIResponse(i, j, obj);
    }

    private final <T> C1714r<H2APIResponse> response(C1714r<Response<T>> rVar, String str) {
        C1714r<R> c = rVar.mo27430a((C1742e<? super Response<T>, ? extends C1718v<? extends R>>) new RFGH2Client$response$1(this, str)).mo27436c(new RFGH2Client$response$2(this, str));
        Intrinsics.checkExpressionValueIsNotNull(c, "api\n            .flatMap…path, null)\n            }");
        return c;
    }

    public final void build(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        C1909a aVar = new C1909a(new RFGH2Client$build$logger$1());
        aVar.mo28005a(C1909a.C1910a.NONE);
        C1752D.C1753a aVar2 = new C1752D.C1753a();
        aVar2.mo27508c(120, TimeUnit.SECONDS);
        aVar2.mo27505b(120, TimeUnit.SECONDS);
        aVar2.mo27503a(true);
        aVar2.mo27501a((C1744A) new RFGUserAgentInterceptor(context));
        aVar2.mo27501a((C1744A) aVar);
        Retrofit build = new Retrofit.Builder().client(new C1752D(aVar2)).baseUrl(PRODUCTION_URL).addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(C1578g.m2208a()).build();
        Intrinsics.checkExpressionValueIsNotNull(build, "Retrofit.Builder()\n     …e())\n            .build()");
        this.retrofit = build;
        if (build == null) {
            Intrinsics.throwUninitializedPropertyAccessException("retrofit");
        }
        Object create = build.create(RFGApi.class);
        Intrinsics.checkExpressionValueIsNotNull(create, "retrofit.create(RFGApi::class.java)");
        this.rfgApi = (RFGApi) create;
    }

    public final C1714r<H2APIResponse> challenge() {
        String accessToken = RFLSharedHolder.INSTANCE.accessToken();
        RFGApi rFGApi = this.rfgApi;
        if (rFGApi == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rfgApi");
        }
        return response(rFGApi.challenge(accessToken), "challenge");
    }

    public final C1714r<H2APIResponse> chart(String str, String str2) {
        Intrinsics.checkParameterIsNotNull(str, "type");
        Intrinsics.checkParameterIsNotNull(str2, RFGSheetDialog.ARG_COUNT);
        String accessToken = RFLSharedHolder.INSTANCE.accessToken();
        RFGApi rFGApi = this.rfgApi;
        if (rFGApi == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rfgApi");
        }
        return response(rFGApi.chart(str, str2, accessToken), "chart");
    }

    public final C1714r<H2APIResponse> clubDetail(String str) {
        Intrinsics.checkParameterIsNotNull(str, "clubId");
        String accessToken = RFLSharedHolder.INSTANCE.accessToken();
        RFGApi rFGApi = this.rfgApi;
        if (rFGApi == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rfgApi");
        }
        return response(rFGApi.clubDetail(accessToken, str), "club/detail");
    }

    public final C1714r<H2APIResponse> clubRefuse(String str, String str2) {
        Intrinsics.checkParameterIsNotNull(str, "clubId");
        Intrinsics.checkParameterIsNotNull(str2, "gymId");
        String accessToken = RFLSharedHolder.INSTANCE.accessToken();
        RFGApi rFGApi = this.rfgApi;
        if (rFGApi == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rfgApi");
        }
        return response(rFGApi.clubRefuse(accessToken, str, str2), "club/refuse");
    }

    public final C1714r<H2APIResponse> clubUsers(String str) {
        Intrinsics.checkParameterIsNotNull(str, "clubId");
        String accessToken = RFLSharedHolder.INSTANCE.accessToken();
        RFGApi rFGApi = this.rfgApi;
        if (rFGApi == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rfgApi");
        }
        return response(rFGApi.clubUsers(accessToken, str), "club/users");
    }

    public final C1714r<H2APIResponse> clubs() {
        String accessToken = RFLSharedHolder.INSTANCE.accessToken();
        RFGApi rFGApi = this.rfgApi;
        if (rFGApi == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rfgApi");
        }
        return response(rFGApi.clubs(accessToken), "club/list");
    }

    public final C1714r<H2APIResponse> createClub(File file, String str, String str2, String str3, String str4) {
        Intrinsics.checkParameterIsNotNull(file, "iconFile");
        Intrinsics.checkParameterIsNotNull(str, AppMeasurementSdk.ConditionalUserProperty.NAME);
        Intrinsics.checkParameterIsNotNull(str2, ProductAction.ACTION_DETAIL);
        Intrinsics.checkParameterIsNotNull(str3, "reset");
        String accessToken = RFLSharedHolder.INSTANCE.accessToken();
        C0976G.C0977a aVar = C0976G.Companion;
        C1746B.C1747a aVar2 = C1746B.f2080f;
        C1748C.C1751c a = C1748C.C1751c.m2468a("club_icon", file.getName(), aVar.mo20404a(file, C1746B.C1747a.m2461b("multipart/form-data")));
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        C0976G.C0977a aVar3 = C0976G.Companion;
        C1746B.C1747a aVar4 = C1746B.f2080f;
        linkedHashMap.put("club_name", aVar3.mo20405a(str, C1746B.C1747a.m2461b("text/plain")));
        C0976G.C0977a aVar5 = C0976G.Companion;
        C1746B.C1747a aVar6 = C1746B.f2080f;
        linkedHashMap.put("club_desc", aVar5.mo20405a(str2, C1746B.C1747a.m2461b("text/plain")));
        C0976G.C0977a aVar7 = C0976G.Companion;
        C1746B.C1747a aVar8 = C1746B.f2080f;
        linkedHashMap.put("club_reset", aVar7.mo20405a(str3, C1746B.C1747a.m2461b("text/plain")));
        if (str4 != null) {
            C0976G.C0977a aVar9 = C0976G.Companion;
            C1746B.C1747a aVar10 = C1746B.f2080f;
            linkedHashMap.put("end_time", aVar9.mo20405a(str4, C1746B.C1747a.m2461b("text/plain")));
        }
        RFGApi rFGApi = this.rfgApi;
        if (rFGApi == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rfgApi");
        }
        return response(rFGApi.clubCreate(accessToken, a, linkedHashMap), "club/create");
    }

    public final C1714r<H2APIResponse> currentYearPoint() {
        String accessToken = RFLSharedHolder.INSTANCE.accessToken();
        RFGApi rFGApi = this.rfgApi;
        if (rFGApi == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rfgApi");
        }
        return response(rFGApi.userCurrentYearPoint(accessToken), "user/current_year_point");
    }

    public final C1714r<H2APIResponse> deleteClub(String str) {
        Intrinsics.checkParameterIsNotNull(str, "clubId");
        String accessToken = RFLSharedHolder.INSTANCE.accessToken();
        RFGApi rFGApi = this.rfgApi;
        if (rFGApi == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rfgApi");
        }
        return response(rFGApi.deleteClub(accessToken, str), "club/delete");
    }

    public final C1714r<H2APIResponse> entryClubByClubCode(String str, String str2) {
        Intrinsics.checkParameterIsNotNull(str, "clubCode");
        Intrinsics.checkParameterIsNotNull(str2, "gymId");
        String accessToken = RFLSharedHolder.INSTANCE.accessToken();
        Map mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.m4300to("club_code", str));
        RFGApi rFGApi = this.rfgApi;
        if (rFGApi == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rfgApi");
        }
        return response(rFGApi.entryClub(accessToken, mapOf, str2), "club/code");
    }

    public final C1714r<H2APIResponse> entryClubByClubId(String str, String str2) {
        Intrinsics.checkParameterIsNotNull(str, "clubId");
        Intrinsics.checkParameterIsNotNull(str2, "gymId");
        String accessToken = RFLSharedHolder.INSTANCE.accessToken();
        Map mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.m4300to("club_id", str));
        RFGApi rFGApi = this.rfgApi;
        if (rFGApi == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rfgApi");
        }
        return response(rFGApi.entryClub(accessToken, mapOf, str2), "club/entry");
    }

    public final RFGCommonResponse errorResponse(C0980J j) {
        Intrinsics.checkParameterIsNotNull(j, "errorBody");
        Retrofit retrofit3 = this.retrofit;
        if (retrofit3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("retrofit");
        }
        return retrofit3.responseBodyConverter(RFGCommonResponse.class, new Annotation[0]).convert(j);
    }

    public final C1714r<H2APIResponse> exchangeReward(String str) {
        Intrinsics.checkParameterIsNotNull(str, "rewardid");
        String accessToken = RFLSharedHolder.INSTANCE.accessToken();
        RFGApi rFGApi = this.rfgApi;
        if (rFGApi == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rfgApi");
        }
        return response(rFGApi.exchangeReward(accessToken, str), "exchangeReward");
    }

    public final C1714r<H2APIResponse> feed(String str) {
        Intrinsics.checkParameterIsNotNull(str, "date");
        String accessToken = RFLSharedHolder.INSTANCE.accessToken();
        RFGApi rFGApi = this.rfgApi;
        if (rFGApi == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rfgApi");
        }
        return response(rFGApi.feed(str, accessToken), "feed");
    }

    public final C1714r<H2APIResponse> history(String str, String str2) {
        Intrinsics.checkParameterIsNotNull(str, "type");
        Intrinsics.checkParameterIsNotNull(str2, "date");
        String accessToken = RFLSharedHolder.INSTANCE.accessToken();
        RFGApi rFGApi = this.rfgApi;
        if (rFGApi == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rfgApi");
        }
        return response(rFGApi.history(str, str2, accessToken), "history");
    }

    public final C1714r<H2APIResponse> ranking(String str, String str2, String str3, int i) {
        Intrinsics.checkParameterIsNotNull(str, "kind");
        Intrinsics.checkParameterIsNotNull(str2, "type");
        Intrinsics.checkParameterIsNotNull(str3, "date");
        String accessToken = RFLSharedHolder.INSTANCE.accessToken();
        RFGApi rFGApi = this.rfgApi;
        if (rFGApi == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rfgApi");
        }
        return response(rFGApi.ranking(accessToken, str, str2, str3, i), "ranking");
    }

    public final C1714r<H2APIResponse> resetPass(String str) {
        Intrinsics.checkParameterIsNotNull(str, "mail");
        RFGApi rFGApi = this.rfgApi;
        if (rFGApi == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rfgApi");
        }
        return response(rFGApi.userResetPass(str, LocaleEx.JAPANESE_LANGUAGE), "setting/forgotpass");
    }

    public final C1714r<H2APIResponse> reward(String str) {
        Intrinsics.checkParameterIsNotNull(str, "category");
        String accessToken = RFLSharedHolder.INSTANCE.accessToken();
        RFGApi rFGApi = this.rfgApi;
        if (rFGApi == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rfgApi");
        }
        return response(rFGApi.reward(accessToken, str), "reward");
    }

    public final C1714r<H2APIResponse> rewardRequest(String str, String str2, List<String> list) {
        Intrinsics.checkParameterIsNotNull(str, "year");
        Intrinsics.checkParameterIsNotNull(str2, "type");
        Intrinsics.checkParameterIsNotNull(list, "rewardIds");
        String accessToken = RFLSharedHolder.INSTANCE.accessToken();
        String joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(list, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        RFGApi rFGApi = this.rfgApi;
        if (rFGApi == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rfgApi");
        }
        return response(rFGApi.rewardRequest(accessToken, str, str2, joinToString$default), "reward/u_request");
    }

    public final C1714r<H2APIResponse> rewardStatus(String str) {
        Intrinsics.checkParameterIsNotNull(str, "year");
        String accessToken = RFLSharedHolder.INSTANCE.accessToken();
        RFGApi rFGApi = this.rfgApi;
        if (rFGApi == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rfgApi");
        }
        return response(rFGApi.rewardStatus(str, accessToken), "reward/u_status");
    }

    public final C1714r<H2APIResponse> rewardUserList(String str, String str2) {
        Intrinsics.checkParameterIsNotNull(str, "year");
        Intrinsics.checkParameterIsNotNull(str2, "type");
        String accessToken = RFLSharedHolder.INSTANCE.accessToken();
        RFGApi rFGApi = this.rfgApi;
        if (rFGApi == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rfgApi");
        }
        return response(rFGApi.rewardUserList(str, str2, accessToken), "reward/u_list");
    }

    public final C1714r<H2APIResponse> updateClub(String str, File file, String str2, String str3, String str4, String str5) {
        C1748C.C1751c cVar;
        Intrinsics.checkParameterIsNotNull(str, "clubId");
        String accessToken = RFLSharedHolder.INSTANCE.accessToken();
        if (file != null) {
            C0976G.C0977a aVar = C0976G.Companion;
            C1746B.C1747a aVar2 = C1746B.f2080f;
            cVar = C1748C.C1751c.m2468a("club_icon", file.getName(), aVar.mo20404a(file, C1746B.C1747a.m2461b("multipart/form-data")));
        } else {
            cVar = null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        C0976G.C0977a aVar3 = C0976G.Companion;
        C1746B.C1747a aVar4 = C1746B.f2080f;
        linkedHashMap.put("club_id", aVar3.mo20405a(str, C1746B.C1747a.m2461b("text/plain")));
        if (str2 != null) {
            C0976G.C0977a aVar5 = C0976G.Companion;
            C1746B.C1747a aVar6 = C1746B.f2080f;
            linkedHashMap.put("club_name", aVar5.mo20405a(str2, C1746B.C1747a.m2461b("text/plain")));
        }
        if (str3 != null) {
            C0976G.C0977a aVar7 = C0976G.Companion;
            C1746B.C1747a aVar8 = C1746B.f2080f;
            linkedHashMap.put("club_desc", aVar7.mo20405a(str3, C1746B.C1747a.m2461b("text/plain")));
        }
        if (str4 != null) {
            C0976G.C0977a aVar9 = C0976G.Companion;
            C1746B.C1747a aVar10 = C1746B.f2080f;
            linkedHashMap.put("club_reset", aVar9.mo20405a(str4, C1746B.C1747a.m2461b("text/plain")));
        }
        if (str5 != null) {
            C0976G.C0977a aVar11 = C0976G.Companion;
            C1746B.C1747a aVar12 = C1746B.f2080f;
            linkedHashMap.put("end_time", aVar11.mo20405a(str5, C1746B.C1747a.m2461b("text/plain")));
        }
        RFGApi rFGApi = this.rfgApi;
        if (rFGApi == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rfgApi");
        }
        return response(rFGApi.clubUpdate(accessToken, cVar, linkedHashMap), "club/update");
    }

    public final C1714r<H2APIResponse> updateUser(Map<String, String> map) {
        Intrinsics.checkParameterIsNotNull(map, "param");
        String accessToken = RFLSharedHolder.INSTANCE.accessToken();
        RFGApi rFGApi = this.rfgApi;
        if (rFGApi == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rfgApi");
        }
        return response(rFGApi.mo29439up(accessToken, map), "user/update");
    }

    public final C1714r<H2APIResponse> uploadPhoto(File file) {
        Intrinsics.checkParameterIsNotNull(file, "file");
        String accessToken = RFLSharedHolder.INSTANCE.accessToken();
        C0976G.C0977a aVar = C0976G.Companion;
        C1746B.C1747a aVar2 = C1746B.f2080f;
        C1748C.C1751c a = C1748C.C1751c.m2468a("image", file.getName(), aVar.mo20404a(file, C1746B.C1747a.m2461b("multipart/form-data")));
        RFGApi rFGApi = this.rfgApi;
        if (rFGApi == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rfgApi");
        }
        return response(rFGApi.upload(accessToken, a), "user/upload");
    }

    public final C1714r<H2APIResponse> userAction(Map<String, String> map) {
        Intrinsics.checkParameterIsNotNull(map, "param");
        String accessToken = RFLSharedHolder.INSTANCE.accessToken();
        RFGApi rFGApi = this.rfgApi;
        if (rFGApi == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rfgApi");
        }
        return response(rFGApi.userAction(accessToken, map), "user/action");
    }

    public final C1714r<H2APIResponse> userAuth(String str, String str2) {
        Intrinsics.checkParameterIsNotNull(str, "clubId");
        Intrinsics.checkParameterIsNotNull(str2, "gymId");
        String accessToken = RFLSharedHolder.INSTANCE.accessToken();
        RFGApi rFGApi = this.rfgApi;
        if (rFGApi == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rfgApi");
        }
        return response(rFGApi.userAuth(accessToken, str, str2), "club/auth");
    }

    public final C1714r<H2APIResponse> userExist(String str) {
        Intrinsics.checkParameterIsNotNull(str, "gymId");
        String accessToken = RFLSharedHolder.INSTANCE.accessToken();
        RFGApi rFGApi = this.rfgApi;
        if (rFGApi == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rfgApi");
        }
        return response(rFGApi.userExist(accessToken, str), "user/exist");
    }

    public final C1714r<H2APIResponse> userHistory() {
        String accessToken = RFLSharedHolder.INSTANCE.accessToken();
        RFGApi rFGApi = this.rfgApi;
        if (rFGApi == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rfgApi");
        }
        return response(rFGApi.getHistory(accessToken), "user/history");
    }

    public final C1714r<H2APIResponse> userInfo() {
        String accessToken = RFLSharedHolder.INSTANCE.accessToken();
        RFGApi rFGApi = this.rfgApi;
        if (rFGApi == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rfgApi");
        }
        return response(rFGApi.getUserInfo(accessToken), "user");
    }

    public final C1714r<H2APIResponse> userPersonal() {
        String accessToken = RFLSharedHolder.INSTANCE.accessToken();
        RFGApi rFGApi = this.rfgApi;
        if (rFGApi == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rfgApi");
        }
        return response(rFGApi.userPersonal(accessToken), "user/personal");
    }

    public final C1714r<H2APIResponse> userReward() {
        String accessToken = RFLSharedHolder.INSTANCE.accessToken();
        RFGApi rFGApi = this.rfgApi;
        if (rFGApi == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rfgApi");
        }
        return response(rFGApi.userValidRewards(accessToken), "user/reward");
    }

    public final C1714r<H2APIResponse> userYearPoint(String str) {
        Intrinsics.checkParameterIsNotNull(str, "year");
        String accessToken = RFLSharedHolder.INSTANCE.accessToken();
        RFGApi rFGApi = this.rfgApi;
        if (rFGApi == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rfgApi");
        }
        return response(rFGApi.userYearPoint(accessToken, str), "user/point");
    }
}
