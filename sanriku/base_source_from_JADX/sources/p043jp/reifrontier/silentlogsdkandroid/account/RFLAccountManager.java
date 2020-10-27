package p043jp.reifrontier.silentlogsdkandroid.account;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.core.view.PointerIconCompat;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import p009e.p010a.p011a.p012a.C0681a;
import p043jp.reifrontier.silentlogsdkandroid.data.api.RFLH1Client;
import p043jp.reifrontier.silentlogsdkandroid.data.shared.RFLSharedHolder;
import p043jp.reifrontier.silentlogsdkandroid.domain.api.RFLLogout;
import p043jp.reifrontier.silentlogsdkandroid.domain.api.RFLPrivate;
import p043jp.reifrontier.silentlogsdkandroid.domain.api.RFLProfile;
import p043jp.reifrontier.silentlogsdkandroid.domain.api.RFLUserProfile;
import p043jp.reifrontier.silentlogsdkandroid.p119di.RFLAppComponent;
import p043jp.reifrontier.silentlogsdkandroid.utils.RFLDailyUtils;
import p043jp.reifrontier.silentlogsdkandroid.utils.RFLDailyUtilsKt;
import p048l.p049a.C1122a;
import p078g.p079a.C1714r;
import p078g.p079a.C1715s;
import p078g.p079a.C1717u;
import p078g.p079a.C1718v;
import p078g.p079a.p094C.C1683a;
import p078g.p079a.p096w.p097b.C1721a;
import p078g.p079a.p100z.C1741d;
import p078g.p079a.p100z.C1742e;
import retrofit2.Response;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 _2\u00020\u0001:\u0001_B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J8\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\b2!\u0010!\u001a\u001d\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u001f0\"H\u0000¢\u0006\u0002\b&J\u000e\u0010'\u001a\u00020\u001f2\u0006\u0010\u0007\u001a\u00020\bJa\u0010(\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020\b2\b\u0010*\u001a\u0004\u0018\u00010\b2\u0006\u0010+\u001a\u00020\b2\u0006\u0010,\u001a\u00020\b2\u0006\u0010-\u001a\u00020\b2\u0006\u0010.\u001a\u00020\u00192'\u0010!\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u0002000/¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(1\u0012\u0004\u0012\u00020\u001f0\"JJ\u00102\u001a\u00020\u001f2\u0006\u00103\u001a\u00020\b28\u0010!\u001a4\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0015\u0012\u0013\u0018\u00010\b¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(5\u0012\u0004\u0012\u00020\u001f04H\u0007J-\u00106\u001a\u00020\u001f2#\u0010!\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\b¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(7\u0012\u0004\u0012\u00020\u001f0\"H\u0003J3\u00108\u001a\u00020\u001f2)\u0010!\u001a%\u0012\u001b\u0012\u0019\u0012\u0004\u0012\u00020\b\u0018\u000109¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(:\u0012\u0004\u0012\u00020\u001f0\"H\u0002J\b\u0010;\u001a\u0004\u0018\u00010<J\u0010\u0010=\u001a\u00020\b2\b\u0010-\u001a\u0004\u0018\u00010<J\u0006\u0010>\u001a\u00020?J\u0015\u0010@\u001a\u00020\b2\b\u0010,\u001a\u0004\u0018\u00010?¢\u0006\u0002\u0010AJ\u0013\u0010B\u001a\b\u0012\u0004\u0012\u00020\b09H\u0000¢\u0006\u0002\bCJ\n\u0010D\u001a\u0004\u0018\u00010\bH\u0002J\u0006\u0010E\u001a\u00020\u0019J\u0006\u0010F\u001a\u00020\u0019J+\u0010G\u001a\u00020\u001f2!\u0010!\u001a\u001d\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u001f0\"H\u0007J\u0014\u0010H\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020J0I0/H\u0007J\u0006\u0010K\u001a\u00020\u001fJ\u0016\u0010L\u001a\u00020\u001f2\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\b09H\u0003J\u0010\u0010M\u001a\u00020\u001f2\u0006\u0010N\u001a\u00020\bH\u0003J5\u0010O\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010P2\u0016\u0010Q\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010PH\u0000¢\u0006\u0002\bRJ\u0010\u0010S\u001a\u00020\u001f2\u0006\u0010T\u001a\u00020\u0001H\u0002J8\u0010U\u001a\u00020\u001f2\u0006\u0010V\u001a\u00020?2!\u0010!\u001a\u001d\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u001f0\"H\u0000¢\u0006\u0002\bWJ\u0006\u0010X\u001a\u00020\u001fJ\u0006\u0010Y\u001a\u00020\u001fJJ\u0010Z\u001a\u00020\u001f2\u0006\u0010-\u001a\u00020<28\u0010!\u001a4\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0015\u0012\u0013\u0018\u00010<¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020\u001f04H\u0007JH\u0010[\u001a\u00020\u001f2\u0006\u0010,\u001a\u00020?26\u0010!\u001a2\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0013\u0012\u00110?¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(,\u0012\u0004\u0012\u00020\u001f04H\u0007J;\u0010\\\u001a\u00020\u001f2\u0006\u0010]\u001a\u00020^2\u0006\u00105\u001a\u00020\b2!\u0010!\u001a\u001d\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u001f0\"H\u0003JA\u0010\\\u001a\u00020\u001f2\u0014\u0010Q\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010P2!\u0010!\u001a\u001d\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u001f0\"H\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00198@X\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0011¨\u0006`"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/account/RFLAccountManager;", "", "clientContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getClientContext", "()Landroid/content/Context;", "clientId", "", "dailyUtils", "Ljp/reifrontier/silentlogsdkandroid/utils/RFLDailyUtils;", "getDailyUtils", "()Ljp/reifrontier/silentlogsdkandroid/utils/RFLDailyUtils;", "setDailyUtils", "(Ljp/reifrontier/silentlogsdkandroid/utils/RFLDailyUtils;)V", "extraUserId", "getExtraUserId", "()Ljava/lang/String;", "h1Client", "Ljp/reifrontier/silentlogsdkandroid/data/api/RFLH1Client;", "getH1Client", "()Ljp/reifrontier/silentlogsdkandroid/data/api/RFLH1Client;", "setH1Client", "(Ljp/reifrontier/silentlogsdkandroid/data/api/RFLH1Client;)V", "isAdEntry", "", "isAdEntry$silentlogsdkandroid_release", "()Z", "silentLogUserId", "getSilentLogUserId", "addJrFormAsync", "", "jrForm", "listener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "success", "addJrFormAsync$silentlogsdkandroid_release", "build", "create", "username", "aOriginalUserName", "password", "gender", "birthday", "regist", "Lio/reactivex/Single;", "Ljp/reifrontier/silentlogsdkandroid/data/api/RFLH1Client$APIResponse;", "task", "forgetPassword", "email", "Lkotlin/Function2;", "message", "generateAdvertisingId", "advertisingId", "getAdvertisingIds", "", "advertisingIds", "getBirthDay", "Ljava/util/Date;", "getBirthdayString", "getGender", "", "getGenderString", "(Ljava/lang/Integer;)Ljava/lang/String;", "getJrForms", "getJrForms$silentlogsdkandroid_release", "getPushToken", "isLogin", "isRegistLogin", "loadUserProfile", "logout", "Lretrofit2/Response;", "Ljp/reifrontier/silentlogsdkandroid/domain/api/RFLLogout;", "logoutSDK", "postAdvertisingId", "postPushToken", "pushToken", "removeDefaultPrivateKey", "", "privateKeyMap", "removeDefaultPrivateKey$silentlogsdkandroid_release", "saveUserProfile", "data", "setEntryCampaign", "adEntryType", "setEntryCampaign$silentlogsdkandroid_release", "syncAdvertisingId", "syncPushToken", "updateBirthday", "updateGender", "updatePrivateKey", "private", "Ljp/reifrontier/silentlogsdkandroid/domain/api/RFLPrivate;", "Companion", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.silentlogsdkandroid.account.RFLAccountManager */
public final class RFLAccountManager {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String DEFAULT_ACCESS_TOKEN = "silentlog";
    public static final String DEFAULT_BIRTHDAY = "19900101";
    public static final String DEFAULT_GENDER = "male";

    /* renamed from: a */
    private String f2998a;

    /* renamed from: b */
    private final Context f2999b;
    public RFLDailyUtils dailyUtils;
    public RFLH1Client h1Client;

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\r"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/account/RFLAccountManager$Companion;", "", "()V", "BIRTHDAY_FORMAT", "", "DEFAULT_ACCESS_TOKEN", "DEFAULT_BIRTHDAY", "DEFAULT_GENDER", "GENDER_FEMALE", "GENDER_MALE", "PROFILE_EXTRA_KEY", "PROFILE_PRIVATE_KEY", "SILENTLOG_CLIENT_ID", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.silentlogsdkandroid.account.RFLAccountManager$Companion */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.account.RFLAccountManager$a */
    static final class C2113a extends Lambda implements Function1<List<? extends String>, Unit> {

        /* renamed from: a */
        final /* synthetic */ RFLAccountManager f3000a;

        /* renamed from: b */
        final /* synthetic */ String f3001b;

        /* renamed from: c */
        final /* synthetic */ String f3002c;

        /* renamed from: d */
        final /* synthetic */ String f3003d;

        /* renamed from: e */
        final /* synthetic */ String f3004e;

        /* renamed from: f */
        final /* synthetic */ String f3005f;

        /* renamed from: g */
        final /* synthetic */ boolean f3006g;

        /* renamed from: h */
        final /* synthetic */ String f3007h;

        /* renamed from: i */
        final /* synthetic */ Function1 f3008i;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C2113a(RFLAccountManager rFLAccountManager, String str, String str2, String str3, String str4, String str5, boolean z, String str6, Function1 function1) {
            super(1);
            this.f3000a = rFLAccountManager;
            this.f3001b = str;
            this.f3002c = str2;
            this.f3003d = str3;
            this.f3004e = str4;
            this.f3005f = str5;
            this.f3006g = z;
            this.f3007h = str6;
            this.f3008i = function1;
        }

        /* renamed from: a */
        public final void mo31171a(List<String> list) {
            this.f3008i.invoke(this.f3000a.getH1Client().create(this.f3001b, this.f3002c, this.f3003d, this.f3004e, this.f3005f, this.f3006g, list, this.f3007h));
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            mo31171a((List) obj);
            return Unit.INSTANCE;
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.account.RFLAccountManager$b */
    static final class C2114b<T> implements C1741d<RFLH1Client.APIResponse> {

        /* renamed from: a */
        final /* synthetic */ Function2 f3009a;

        C2114b(Function2 function2) {
            this.f3009a = function2;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0038, code lost:
            if (r0 != null) goto L_0x003a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x001f, code lost:
            if (r0 != null) goto L_0x003a;
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void accept(p043jp.reifrontier.silentlogsdkandroid.data.api.RFLH1Client.APIResponse r5) {
            /*
                r4 = this;
                java.lang.Object r0 = r5.getData()
                boolean r1 = r0 instanceof p043jp.reifrontier.silentlogsdkandroid.domain.api.RFLCommon
                r2 = 0
                if (r1 != 0) goto L_0x000a
                r0 = r2
            L_0x000a:
                jp.reifrontier.silentlogsdkandroid.domain.api.RFLCommon r0 = (p043jp.reifrontier.silentlogsdkandroid.domain.api.RFLCommon) r0
                int r5 = r5.getCode()
                r1 = 200(0xc8, float:2.8E-43)
                r3 = 0
                if (r5 == r1) goto L_0x002c
                r1 = 500(0x1f4, float:7.0E-43)
                if (r5 == r1) goto L_0x0022
                kotlin.jvm.functions.Function2 r5 = r4.f3009a
                java.lang.Boolean r1 = java.lang.Boolean.valueOf(r3)
                if (r0 == 0) goto L_0x003e
                goto L_0x003a
            L_0x0022:
                kotlin.jvm.functions.Function2 r5 = r4.f3009a
                java.lang.Boolean r0 = java.lang.Boolean.valueOf(r3)
                r5.invoke(r0, r2)
                goto L_0x0041
            L_0x002c:
                if (r0 == 0) goto L_0x0032
                boolean r3 = r0.getSuccess()
            L_0x0032:
                kotlin.jvm.functions.Function2 r5 = r4.f3009a
                java.lang.Boolean r1 = java.lang.Boolean.valueOf(r3)
                if (r0 == 0) goto L_0x003e
            L_0x003a:
                java.lang.String r2 = r0.getMessage()
            L_0x003e:
                r5.invoke(r1, r2)
            L_0x0041:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p043jp.reifrontier.silentlogsdkandroid.account.RFLAccountManager.C2114b.accept(jp.reifrontier.silentlogsdkandroid.data.api.RFLH1Client$APIResponse):void");
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.account.RFLAccountManager$c */
    static final class C2115c<T> implements C1741d<Throwable> {

        /* renamed from: a */
        final /* synthetic */ Function2 f3010a;

        C2115c(Function2 function2) {
            this.f3010a = function2;
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            this.f3010a.invoke(false, null);
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.account.RFLAccountManager$d */
    static final class C2116d<T> implements C1717u<T> {

        /* renamed from: a */
        final /* synthetic */ RFLAccountManager f3011a;

        C2116d(RFLAccountManager rFLAccountManager) {
            this.f3011a = rFLAccountManager;
        }

        public final void subscribe(C1715s<String> sVar) {
            Intrinsics.checkParameterIsNotNull(sVar, "emitter");
            try {
                AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(this.f3011a.getClientContext());
                Intrinsics.checkExpressionValueIsNotNull(advertisingIdInfo, "info");
                sVar.onSuccess(advertisingIdInfo.getId());
            } catch (Exception e) {
                sVar.onError(e);
            }
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.account.RFLAccountManager$e */
    static final class C2117e<T> implements C1741d<String> {

        /* renamed from: a */
        final /* synthetic */ Function1 f3012a;

        C2117e(Function1 function1) {
            this.f3012a = function1;
        }

        /* renamed from: a */
        public final void accept(String str) {
            this.f3012a.invoke(str);
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.account.RFLAccountManager$f */
    static final class C2118f<T> implements C1741d<Throwable> {

        /* renamed from: a */
        final /* synthetic */ Function1 f3013a;

        C2118f(Function1 function1) {
            this.f3013a = function1;
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            C1122a.m1597a(th);
            this.f3013a.invoke(null);
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.account.RFLAccountManager$g */
    static final class C2119g extends Lambda implements Function1<String, Unit> {

        /* renamed from: a */
        final /* synthetic */ Function1 f3014a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C2119g(Function1 function1) {
            super(1);
            this.f3014a = function1;
        }

        /* renamed from: a */
        public final void mo31176a(String str) {
            if (str == null) {
                this.f3014a.invoke(null);
                return;
            }
            RFLPrivate profilePrivateKey = RFLSharedHolder.INSTANCE.profilePrivateKey();
            List<String> advertisingIds = profilePrivateKey != null ? profilePrivateKey.getAdvertisingIds() : null;
            if (advertisingIds == null || advertisingIds.isEmpty()) {
                this.f3014a.invoke(CollectionsKt__CollectionsJVMKt.listOf(str));
            } else if (!Intrinsics.areEqual((Object) (String) CollectionsKt___CollectionsKt.last(advertisingIds), (Object) str)) {
                List<T> mutableList = CollectionsKt___CollectionsKt.toMutableList(advertisingIds);
                mutableList.add(str);
                this.f3014a.invoke(mutableList);
            } else {
                this.f3014a.invoke(null);
            }
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            mo31176a((String) obj);
            return Unit.INSTANCE;
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.account.RFLAccountManager$h */
    static final class C2120h<T> implements C1741d<RFLH1Client.APIResponse> {

        /* renamed from: a */
        final /* synthetic */ RFLAccountManager f3015a;

        /* renamed from: b */
        final /* synthetic */ Function1 f3016b;

        C2120h(RFLAccountManager rFLAccountManager, Function1 function1) {
            this.f3015a = rFLAccountManager;
            this.f3016b = function1;
        }

        /* renamed from: a */
        public final void accept(RFLH1Client.APIResponse aPIResponse) {
            Function1 function1;
            boolean z;
            if (aPIResponse.getCode() == 200) {
                Object data = aPIResponse.getData();
                if (data != null) {
                    this.f3015a.m3645a(data);
                }
                function1 = this.f3016b;
                z = true;
            } else {
                StringBuilder a = C0681a.m330a("Load user profile Error: code=");
                a.append(aPIResponse.getCode());
                String sb = a.toString();
                z = false;
                C1122a.m1599b(sb, new Object[0]);
                function1 = this.f3016b;
            }
            function1.invoke(Boolean.valueOf(z));
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.account.RFLAccountManager$i */
    static final class C2121i<T> implements C1741d<Throwable> {

        /* renamed from: a */
        final /* synthetic */ Function1 f3017a;

        C2121i(Function1 function1) {
            this.f3017a = function1;
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            C1122a.m1599b(C0681a.m326a(th, C0681a.m331a("Load user profile Error:", th, "error")), new Object[0]);
            this.f3017a.invoke(false);
        }
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo21739d2 = {"<anonymous>", "", "it", "Ljp/reifrontier/silentlogsdkandroid/data/api/RFLH1Client$APIResponse;", "kotlin.jvm.PlatformType", "accept"}, mo21740k = 3, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.silentlogsdkandroid.account.RFLAccountManager$j */
    static final class C2122j<T> implements C1741d<RFLH1Client.APIResponse> {

        /* renamed from: a */
        final /* synthetic */ RFLAccountManager f3018a;

        /* renamed from: jp.reifrontier.silentlogsdkandroid.account.RFLAccountManager$j$a */
        static final class C2123a extends Lambda implements Function1<Boolean, Unit> {

            /* renamed from: a */
            public static final C2123a f3019a = new C2123a();

            C2123a() {
                super(1);
            }

            /* renamed from: a */
            public final void mo31180a(boolean z) {
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                mo31180a(((Boolean) obj).booleanValue());
                return Unit.INSTANCE;
            }
        }

        C2122j(RFLAccountManager rFLAccountManager) {
            this.f3018a = rFLAccountManager;
        }

        /* renamed from: a */
        public final void accept(RFLH1Client.APIResponse aPIResponse) {
            if (aPIResponse.getCode() == 200) {
                this.f3018a.loadUserProfile(C2123a.f3019a);
                return;
            }
            StringBuilder a = C0681a.m330a("Post AdvertisingId Error: code=");
            a.append(aPIResponse.getCode());
            C1122a.m1599b(a.toString(), new Object[0]);
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.account.RFLAccountManager$k */
    static final class C2124k<T> implements C1741d<Throwable> {

        /* renamed from: a */
        public static final C2124k f3020a = new C2124k();

        C2124k() {
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            C1122a.m1599b(C0681a.m326a(th, C0681a.m331a("Post AdvertisingId Error:", th, "it")), new Object[0]);
        }
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo21739d2 = {"<anonymous>", "", "it", "Ljp/reifrontier/silentlogsdkandroid/data/api/RFLH1Client$APIResponse;", "kotlin.jvm.PlatformType", "accept"}, mo21740k = 3, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.silentlogsdkandroid.account.RFLAccountManager$l */
    static final class C2125l<T> implements C1741d<RFLH1Client.APIResponse> {

        /* renamed from: a */
        final /* synthetic */ RFLAccountManager f3021a;

        /* renamed from: jp.reifrontier.silentlogsdkandroid.account.RFLAccountManager$l$a */
        static final class C2126a extends Lambda implements Function1<Boolean, Unit> {

            /* renamed from: a */
            public static final C2126a f3022a = new C2126a();

            C2126a() {
                super(1);
            }

            /* renamed from: a */
            public final void mo31183a(boolean z) {
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                mo31183a(((Boolean) obj).booleanValue());
                return Unit.INSTANCE;
            }
        }

        C2125l(RFLAccountManager rFLAccountManager) {
            this.f3021a = rFLAccountManager;
        }

        /* renamed from: a */
        public final void accept(RFLH1Client.APIResponse aPIResponse) {
            if (aPIResponse.getCode() == 200) {
                this.f3021a.loadUserProfile(C2126a.f3022a);
                return;
            }
            StringBuilder a = C0681a.m330a("Post PushToken Error: code=");
            a.append(aPIResponse.getCode());
            C1122a.m1599b(a.toString(), new Object[0]);
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.account.RFLAccountManager$m */
    static final class C2127m<T> implements C1741d<Throwable> {

        /* renamed from: a */
        public static final C2127m f3023a = new C2127m();

        C2127m() {
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            C1122a.m1599b(C0681a.m326a(th, C0681a.m331a("Post PushToken Error:", th, "it")), new Object[0]);
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.account.RFLAccountManager$n */
    static final class C2128n extends Lambda implements Function1<List<? extends String>, Unit> {

        /* renamed from: a */
        final /* synthetic */ RFLAccountManager f3024a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C2128n(RFLAccountManager rFLAccountManager) {
            super(1);
            this.f3024a = rFLAccountManager;
        }

        /* renamed from: a */
        public final void mo31185a(List<String> list) {
            if (list != null) {
                this.f3024a.m3647a(list);
            }
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            mo31185a((List) obj);
            return Unit.INSTANCE;
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.account.RFLAccountManager$o */
    static final class C2129o<T> implements C1741d<RFLH1Client.APIResponse> {

        /* renamed from: a */
        final /* synthetic */ RFLAccountManager f3025a;

        /* renamed from: b */
        final /* synthetic */ Function2 f3026b;

        C2129o(RFLAccountManager rFLAccountManager, Function2 function2) {
            this.f3025a = rFLAccountManager;
            this.f3026b = function2;
        }

        /* renamed from: a */
        public final void accept(RFLH1Client.APIResponse aPIResponse) {
            Function2 function2;
            Date date;
            boolean z;
            if (aPIResponse.getCode() != 200 || aPIResponse.getData() == null) {
                StringBuilder a = C0681a.m330a("Update gender Error: code=");
                a.append(aPIResponse.getCode());
                C1122a.m1599b(a.toString(), new Object[0]);
                function2 = this.f3026b;
                z = false;
                date = null;
            } else {
                this.f3025a.m3645a(aPIResponse.getData());
                function2 = this.f3026b;
                z = true;
                date = this.f3025a.getBirthDay();
            }
            function2.invoke(z, date);
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.account.RFLAccountManager$p */
    static final class C2130p<T> implements C1741d<Throwable> {

        /* renamed from: a */
        final /* synthetic */ Function2 f3027a;

        C2130p(Function2 function2) {
            this.f3027a = function2;
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            C1122a.m1599b(C0681a.m326a(th, C0681a.m331a("Update gender Error:", th, "it")), new Object[0]);
            this.f3027a.invoke(false, null);
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.account.RFLAccountManager$q */
    static final class C2131q<T> implements C1741d<RFLH1Client.APIResponse> {

        /* renamed from: a */
        final /* synthetic */ RFLAccountManager f3028a;

        /* renamed from: b */
        final /* synthetic */ Function2 f3029b;

        C2131q(RFLAccountManager rFLAccountManager, Function2 function2) {
            this.f3028a = rFLAccountManager;
            this.f3029b = function2;
        }

        /* renamed from: a */
        public final void accept(RFLH1Client.APIResponse aPIResponse) {
            if (aPIResponse.getCode() != 200 || aPIResponse.getData() == null) {
                StringBuilder a = C0681a.m330a("Update gender Error: code=");
                a.append(aPIResponse.getCode());
                C1122a.m1599b(a.toString(), new Object[0]);
                this.f3029b.invoke(false, 0);
                return;
            }
            this.f3028a.m3645a(aPIResponse.getData());
            this.f3029b.invoke(true, Integer.valueOf(this.f3028a.getGender()));
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.account.RFLAccountManager$r */
    static final class C2132r<T> implements C1741d<Throwable> {

        /* renamed from: a */
        final /* synthetic */ Function2 f3030a;

        C2132r(Function2 function2) {
            this.f3030a = function2;
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            C1122a.m1599b(C0681a.m326a(th, C0681a.m331a("Update gender Error:", th, "it")), new Object[0]);
            this.f3030a.invoke(false, 0);
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.account.RFLAccountManager$s */
    static final class C2133s<T, R> implements C1742e<T, C1718v<? extends R>> {

        /* renamed from: a */
        final /* synthetic */ RFLAccountManager f3031a;

        C2133s(RFLAccountManager rFLAccountManager) {
            this.f3031a = rFLAccountManager;
        }

        /* renamed from: a */
        public final C1714r<RFLH1Client.APIResponse> apply(RFLH1Client.APIResponse aPIResponse) {
            Intrinsics.checkParameterIsNotNull(aPIResponse, "it");
            return this.f3031a.getH1Client().getProfile("premium_limit,regist_user,last_read_date,adids,push_token_and,ad_entry,jr_form,mp_auth,install_date,two_week_setting", "extra_user_id");
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.account.RFLAccountManager$t */
    static final class C2134t<T> implements C1741d<RFLH1Client.APIResponse> {

        /* renamed from: a */
        final /* synthetic */ RFLAccountManager f3032a;

        /* renamed from: b */
        final /* synthetic */ Function1 f3033b;

        C2134t(RFLAccountManager rFLAccountManager, Function1 function1) {
            this.f3032a = rFLAccountManager;
            this.f3033b = function1;
        }

        /* renamed from: a */
        public final void accept(RFLH1Client.APIResponse aPIResponse) {
            Function1 function1;
            boolean z;
            if (aPIResponse.getCode() == 200) {
                Object data = aPIResponse.getData();
                if (data != null) {
                    this.f3032a.m3645a(data);
                }
                function1 = this.f3033b;
                z = true;
            } else {
                StringBuilder a = C0681a.m330a("Load user profile Error: code=");
                a.append(aPIResponse.getCode());
                String sb = a.toString();
                z = false;
                C1122a.m1599b(sb, new Object[0]);
                function1 = this.f3033b;
            }
            function1.invoke(Boolean.valueOf(z));
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.account.RFLAccountManager$u */
    static final class C2135u<T> implements C1741d<Throwable> {

        /* renamed from: a */
        final /* synthetic */ Function1 f3034a;

        C2135u(Function1 function1) {
            this.f3034a = function1;
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            C1122a.m1599b(C0681a.m326a(th, C0681a.m331a("Load user profile Error:", th, "error")), new Object[0]);
            this.f3034a.invoke(false);
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.account.RFLAccountManager$v */
    static final class C2136v<T> implements C1741d<RFLH1Client.APIResponse> {

        /* renamed from: a */
        final /* synthetic */ RFLAccountManager f3035a;

        /* renamed from: b */
        final /* synthetic */ Function1 f3036b;

        /* renamed from: c */
        final /* synthetic */ String f3037c;

        C2136v(RFLAccountManager rFLAccountManager, Function1 function1, String str) {
            this.f3035a = rFLAccountManager;
            this.f3036b = function1;
            this.f3037c = str;
        }

        /* renamed from: a */
        public final void accept(RFLH1Client.APIResponse aPIResponse) {
            if (aPIResponse.getCode() == 200) {
                this.f3035a.loadUserProfile(this.f3036b);
                return;
            }
            C1122a.m1599b(this.f3037c + " Error: code=" + aPIResponse.getCode(), new Object[0]);
            this.f3036b.invoke(false);
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.account.RFLAccountManager$w */
    static final class C2137w<T> implements C1741d<Throwable> {

        /* renamed from: a */
        final /* synthetic */ String f3038a;

        /* renamed from: b */
        final /* synthetic */ Function1 f3039b;

        C2137w(String str, Function1 function1) {
            this.f3038a = str;
            this.f3039b = function1;
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f3038a);
            sb.append(" Error:");
            Intrinsics.checkExpressionValueIsNotNull(th, "it");
            sb.append(th.getLocalizedMessage());
            C1122a.m1599b(sb.toString(), new Object[0]);
            this.f3039b.invoke(false);
        }
    }

    public RFLAccountManager(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "clientContext");
        this.f2999b = context;
        RFLAppComponent component$silentlogsdkandroid_release = RFLAppComponent.SdkComponent.INSTANCE.getComponent$silentlogsdkandroid_release();
        if (component$silentlogsdkandroid_release != null) {
            component$silentlogsdkandroid_release.inject(this);
        }
    }

    /* renamed from: a */
    private final String m3644a() {
        if (!RFLSharedHolder.INSTANCE.sendPushToken()) {
            return null;
        }
        String tempPushToken = RFLSharedHolder.INSTANCE.tempPushToken();
        if (tempPushToken.length() == 0) {
            return null;
        }
        RFLPrivate profilePrivateKey = RFLSharedHolder.INSTANCE.profilePrivateKey();
        if (!Intrinsics.areEqual((Object) tempPushToken, (Object) profilePrivateKey != null ? profilePrivateKey.getPushTokenAnd() : null)) {
            return tempPushToken;
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m3645a(Object obj) {
        if (obj != null) {
            RFLProfile rFLProfile = (RFLProfile) obj;
            RFLSharedHolder.INSTANCE.setSilentLogUserId(rFLProfile.getUserId());
            RFLSharedHolder.INSTANCE.setUsername(rFLProfile.getUsername());
            RFLSharedHolder.INSTANCE.setUserProfile(rFLProfile.getProfile().getGender(), rFLProfile.getProfile().getBirthday(), rFLProfile.getProfile().getFirstDate());
            RFLSharedHolder.INSTANCE.setProfilePrivateKey(rFLProfile.getPrivate());
            RFLSharedHolder.INSTANCE.setProfileExtraKey(rFLProfile.getExtra());
            RFLSharedHolder rFLSharedHolder = RFLSharedHolder.INSTANCE;
            Integer adEntry = rFLProfile.getPrivate().getAdEntry();
            rFLSharedHolder.setAdEntryType(adEntry != null ? adEntry.intValue() : 0);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type jp.reifrontier.silentlogsdkandroid.domain.api.RFLProfile");
    }

    @SuppressLint({"CheckResult"})
    /* renamed from: a */
    private final void m3646a(String str) {
        RFLPrivate rFLPrivate = new RFLPrivate((String) null, (Boolean) null, (String) null, (List) null, str, (Integer) null, (List) null, (Boolean) null, (String) null, (Boolean) null, PointerIconCompat.TYPE_CROSSHAIR, (DefaultConstructorMarker) null);
        RFLH1Client rFLH1Client = this.h1Client;
        if (rFLH1Client == null) {
            Intrinsics.throwUninitializedPropertyAccessException("h1Client");
        }
        rFLH1Client.postPrivateKey(rFLPrivate).mo27434b(C1683a.m2378b()).mo27429a(C1683a.m2378b()).mo27432a(new C2125l(this), C2127m.f3023a);
    }

    /* access modifiers changed from: private */
    @SuppressLint({"CheckResult"})
    /* renamed from: a */
    public final void m3647a(List<String> list) {
        RFLPrivate rFLPrivate = new RFLPrivate((String) null, (Boolean) null, (String) null, list, (String) null, (Integer) null, (List) null, (Boolean) null, (String) null, (Boolean) null, PointerIconCompat.TYPE_VERTICAL_DOUBLE_ARROW, (DefaultConstructorMarker) null);
        RFLH1Client rFLH1Client = this.h1Client;
        if (rFLH1Client == null) {
            Intrinsics.throwUninitializedPropertyAccessException("h1Client");
        }
        rFLH1Client.postPrivateKey(rFLPrivate).mo27434b(C1683a.m2378b()).mo27429a(C1683a.m2378b()).mo27432a(new C2122j(this), C2124k.f3020a);
    }

    @SuppressLint({"CheckResult"})
    /* renamed from: a */
    private final void m3648a(RFLPrivate rFLPrivate, String str, Function1<? super Boolean, Unit> function1) {
        RFLH1Client rFLH1Client = this.h1Client;
        if (rFLH1Client == null) {
            Intrinsics.throwUninitializedPropertyAccessException("h1Client");
        }
        rFLH1Client.postPrivateKey(rFLPrivate).mo27434b(C1683a.m2378b()).mo27429a(C1683a.m2378b()).mo27432a(new C2136v(this, function1, str), new C2137w(str, function1));
    }

    @SuppressLint({"CheckResult"})
    /* renamed from: a */
    private final void m3649a(Function1<? super String, Unit> function1) {
        C1714r.m2410a(new C2116d(this)).mo27434b(C1683a.m2378b()).mo27429a(C1683a.m2378b()).mo27432a(new C2117e(function1), new C2118f(function1));
    }

    /* renamed from: b */
    private final void m3650b(Function1<? super List<String>, Unit> function1) {
        if (!RFLSharedHolder.INSTANCE.useAdvertisingId()) {
            function1.invoke(null);
        } else {
            m3649a((Function1<? super String, Unit>) new C2119g(function1));
        }
    }

    public final void addJrFormAsync$silentlogsdkandroid_release(String str, Function1<? super Boolean, Unit> function1) {
        List<String> list;
        String str2 = str;
        Function1<? super Boolean, Unit> function12 = function1;
        Intrinsics.checkParameterIsNotNull(str2, "jrForm");
        Intrinsics.checkParameterIsNotNull(function12, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        ArrayList arrayList = new ArrayList();
        RFLPrivate profilePrivateKey = RFLSharedHolder.INSTANCE.profilePrivateKey();
        if (profilePrivateKey == null || (list = profilePrivateKey.getJrForms()) == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        boolean unused = CollectionsKt__MutableCollectionsKt.addAll(arrayList, list);
        arrayList.add(str2);
        m3648a(new RFLPrivate((String) null, (Boolean) null, (String) null, (List) null, (String) null, (Integer) null, arrayList, (Boolean) null, (String) null, (Boolean) null, 959, (DefaultConstructorMarker) null), "Post jr_form", function12);
    }

    public final void build(String str) {
        Intrinsics.checkParameterIsNotNull(str, "clientId");
        this.f2998a = str;
    }

    public final void create(String str, String str2, String str3, String str4, String str5, boolean z, Function1<? super C1714r<RFLH1Client.APIResponse>, Unit> function1) {
        String str6 = str;
        Intrinsics.checkParameterIsNotNull(str, "username");
        String str7 = str3;
        Intrinsics.checkParameterIsNotNull(str3, "password");
        Intrinsics.checkParameterIsNotNull(str4, "gender");
        Intrinsics.checkParameterIsNotNull(str5, "birthday");
        Intrinsics.checkParameterIsNotNull(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        m3650b(new C2113a(this, str, Intrinsics.areEqual((Object) this.f2998a, (Object) "9Y6w9dOeSg9gvJd7zS7QqBamzgXpdhEyYa") ? null : str2, str3, str4, str5, z, m3644a(), function1));
    }

    @SuppressLint({"CheckResult"})
    public final void forgetPassword(String str, Function2<? super Boolean, ? super String, Unit> function2) {
        Intrinsics.checkParameterIsNotNull(str, "email");
        Intrinsics.checkParameterIsNotNull(function2, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        RFLH1Client rFLH1Client = this.h1Client;
        if (rFLH1Client == null) {
            Intrinsics.throwUninitializedPropertyAccessException("h1Client");
        }
        rFLH1Client.forgetPassword(str).mo27434b(C1683a.m2378b()).mo27429a(C1721a.m2428a()).mo27432a(new C2114b(function2), new C2115c(function2));
    }

    public final Date getBirthDay() {
        RFLUserProfile userProfile;
        String birthday;
        if (!isRegistLogin() || (userProfile = RFLSharedHolder.INSTANCE.userProfile()) == null || (birthday = userProfile.getBirthday()) == null) {
            return null;
        }
        try {
            return new SimpleDateFormat("yyyy-MM-dd", Locale.US).parse(birthday);
        } catch (Exception unused) {
            return null;
        }
    }

    public final String getBirthdayString(Date date) {
        if (date == null) {
            return DEFAULT_BIRTHDAY;
        }
        RFLDailyUtils rFLDailyUtils = this.dailyUtils;
        if (rFLDailyUtils == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dailyUtils");
        }
        return (!date.after(rFLDailyUtils.dateWith(1900, 0, 1)) || !date.before(RFLDailyUtilsKt.minus(new Date(), 10))) ? DEFAULT_BIRTHDAY : RFLDailyUtilsKt.format$default(date, "yyyyMMdd", (String) null, 2, (Object) null);
    }

    public final Context getClientContext() {
        return this.f2999b;
    }

    public final RFLDailyUtils getDailyUtils() {
        RFLDailyUtils rFLDailyUtils = this.dailyUtils;
        if (rFLDailyUtils == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dailyUtils");
        }
        return rFLDailyUtils;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
        r0 = r0.getExtraUserId();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String getExtraUserId() {
        /*
            r1 = this;
            jp.reifrontier.silentlogsdkandroid.data.shared.RFLSharedHolder r0 = p043jp.reifrontier.silentlogsdkandroid.data.shared.RFLSharedHolder.INSTANCE
            jp.reifrontier.silentlogsdkandroid.domain.api.RFLExtra r0 = r0.profileExtraKey()
            if (r0 == 0) goto L_0x000f
            java.lang.String r0 = r0.getExtraUserId()
            if (r0 == 0) goto L_0x000f
            goto L_0x0011
        L_0x000f:
            java.lang.String r0 = ""
        L_0x0011:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p043jp.reifrontier.silentlogsdkandroid.account.RFLAccountManager.getExtraUserId():java.lang.String");
    }

    public final int getGender() {
        RFLUserProfile userProfile;
        String gender;
        if (!isRegistLogin() || (userProfile = RFLSharedHolder.INSTANCE.userProfile()) == null || (gender = userProfile.getGender()) == null) {
            return 0;
        }
        return Intrinsics.areEqual((Object) gender, (Object) "female") ? 1 : 2;
    }

    public final String getGenderString(Integer num) {
        return (num != null && num.intValue() == 1) ? "female" : DEFAULT_GENDER;
    }

    public final RFLH1Client getH1Client() {
        RFLH1Client rFLH1Client = this.h1Client;
        if (rFLH1Client == null) {
            Intrinsics.throwUninitializedPropertyAccessException("h1Client");
        }
        return rFLH1Client;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
        r0 = r0.getJrForms();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<java.lang.String> getJrForms$silentlogsdkandroid_release() {
        /*
            r1 = this;
            jp.reifrontier.silentlogsdkandroid.data.shared.RFLSharedHolder r0 = p043jp.reifrontier.silentlogsdkandroid.data.shared.RFLSharedHolder.INSTANCE
            jp.reifrontier.silentlogsdkandroid.domain.api.RFLPrivate r0 = r0.profilePrivateKey()
            if (r0 == 0) goto L_0x000f
            java.util.List r0 = r0.getJrForms()
            if (r0 == 0) goto L_0x000f
            goto L_0x0013
        L_0x000f:
            java.util.List r0 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
        L_0x0013:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p043jp.reifrontier.silentlogsdkandroid.account.RFLAccountManager.getJrForms$silentlogsdkandroid_release():java.util.List");
    }

    public final String getSilentLogUserId() {
        return RFLSharedHolder.INSTANCE.silentLogUserId();
    }

    public final boolean isAdEntry$silentlogsdkandroid_release() {
        RFLPrivate profilePrivateKey = RFLSharedHolder.INSTANCE.profilePrivateKey();
        Integer adEntry = profilePrivateKey != null ? profilePrivateKey.getAdEntry() : null;
        return adEntry != null && adEntry.intValue() == 1;
    }

    public final boolean isLogin() {
        return !Intrinsics.areEqual((Object) RFLSharedHolder.INSTANCE.accessToken(), (Object) DEFAULT_ACCESS_TOKEN);
    }

    public final boolean isRegistLogin() {
        RFLPrivate profilePrivateKey = RFLSharedHolder.INSTANCE.profilePrivateKey();
        return (Intrinsics.areEqual((Object) RFLSharedHolder.INSTANCE.accessToken(), (Object) DEFAULT_ACCESS_TOKEN) ^ true) && Intrinsics.areEqual((Object) profilePrivateKey != null ? profilePrivateKey.getRegistUser() : null, (Object) true);
    }

    @SuppressLint({"CheckResult"})
    public final void loadUserProfile(Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        if (!isLogin()) {
            function1.invoke(false);
            return;
        }
        RFLH1Client rFLH1Client = this.h1Client;
        if (rFLH1Client == null) {
            Intrinsics.throwUninitializedPropertyAccessException("h1Client");
        }
        rFLH1Client.getProfile("premium_limit,regist_user,last_read_date,adids,push_token_and,ad_entry,jr_form,mp_auth,install_date,two_week_setting", "extra_user_id").mo27434b(C1683a.m2378b()).mo27429a(C1683a.m2378b()).mo27432a(new C2120h(this, function1), new C2121i(function1));
    }

    @SuppressLint({"CheckResult"})
    public final C1714r<Response<RFLLogout>> logout() {
        RFLH1Client rFLH1Client = this.h1Client;
        if (rFLH1Client == null) {
            Intrinsics.throwUninitializedPropertyAccessException("h1Client");
        }
        C1714r<Response<RFLLogout>> b = rFLH1Client.logout().mo27434b(C1683a.m2378b());
        Intrinsics.checkExpressionValueIsNotNull(b, "h1Client.logout()\n      …scribeOn(Schedulers.io())");
        return b;
    }

    public final void logoutSDK() {
        RFLSharedHolder.INSTANCE.setAccessToken(DEFAULT_ACCESS_TOKEN);
    }

    public final Map<String, Object> removeDefaultPrivateKey$silentlogsdkandroid_release(Map<String, ? extends Object> map) {
        Object obj;
        if (map == null) {
            return null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Locale locale = Locale.getDefault();
        List<String> list = CollectionsKt___CollectionsKt.toList(StringsKt__StringsKt.split$default((CharSequence) "premium_limit,regist_user,last_read_date,adids,push_token_and,ad_entry,jr_form,mp_auth,install_date,two_week_setting", new String[]{","}, false, 0, 6, (Object) null));
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        for (String str : list) {
            if (str != null) {
                String obj2 = StringsKt__StringsKt.trim((CharSequence) str).toString();
                Intrinsics.checkExpressionValueIsNotNull(locale, "locale");
                if (obj2 != null) {
                    String lowerCase = obj2.toLowerCase(locale);
                    Intrinsics.checkExpressionValueIsNotNull(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                    arrayList.add(lowerCase);
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
            }
        }
        for (Map.Entry entry : map.entrySet()) {
            String str2 = (String) entry.getKey();
            Object value = entry.getValue();
            Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                String str3 = (String) obj;
                if (str2 != null) {
                    String obj3 = StringsKt__StringsKt.trim((CharSequence) str2).toString();
                    Locale locale2 = Locale.getDefault();
                    Intrinsics.checkExpressionValueIsNotNull(locale2, "Locale.getDefault()");
                    if (obj3 != null) {
                        String lowerCase2 = obj3.toLowerCase(locale2);
                        Intrinsics.checkExpressionValueIsNotNull(lowerCase2, "(this as java.lang.String).toLowerCase(locale)");
                        if (Intrinsics.areEqual((Object) str3, (Object) lowerCase2)) {
                            break;
                        }
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                    }
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
                }
            }
            if (((String) obj) == null) {
                linkedHashMap.put(str2, value);
            }
        }
        return linkedHashMap;
    }

    public final void setDailyUtils(RFLDailyUtils rFLDailyUtils) {
        Intrinsics.checkParameterIsNotNull(rFLDailyUtils, "<set-?>");
        this.dailyUtils = rFLDailyUtils;
    }

    public final void setEntryCampaign$silentlogsdkandroid_release(int i, Function1<? super Boolean, Unit> function1) {
        Function1<? super Boolean, Unit> function12 = function1;
        Intrinsics.checkParameterIsNotNull(function12, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        m3648a(new RFLPrivate((String) null, (Boolean) null, (String) null, (List) null, (String) null, Integer.valueOf(i), (List) null, (Boolean) null, (String) null, (Boolean) null, 991, (DefaultConstructorMarker) null), "Post ad_entry", function12);
    }

    public final void setH1Client(RFLH1Client rFLH1Client) {
        Intrinsics.checkParameterIsNotNull(rFLH1Client, "<set-?>");
        this.h1Client = rFLH1Client;
    }

    public final void syncAdvertisingId() {
        if (isLogin()) {
            m3650b(new C2128n(this));
        }
    }

    public final void syncPushToken() {
        String a;
        if (isLogin() && (a = m3644a()) != null) {
            m3646a(a);
        }
    }

    @SuppressLint({"CheckResult"})
    public final void updateBirthday(Date date, Function2<? super Boolean, ? super Date, Unit> function2) {
        Intrinsics.checkParameterIsNotNull(date, "birthday");
        Intrinsics.checkParameterIsNotNull(function2, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        String birthdayString = getBirthdayString(date);
        RFLH1Client rFLH1Client = this.h1Client;
        if (rFLH1Client == null) {
            Intrinsics.throwUninitializedPropertyAccessException("h1Client");
        }
        rFLH1Client.updateBirthday(birthdayString).mo27434b(C1683a.m2378b()).mo27429a(C1683a.m2378b()).mo27432a(new C2129o(this, function2), new C2130p(function2));
    }

    @SuppressLint({"CheckResult"})
    public final void updateGender(int i, Function2<? super Boolean, ? super Integer, Unit> function2) {
        Intrinsics.checkParameterIsNotNull(function2, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        String genderString = getGenderString(Integer.valueOf(i));
        RFLH1Client rFLH1Client = this.h1Client;
        if (rFLH1Client == null) {
            Intrinsics.throwUninitializedPropertyAccessException("h1Client");
        }
        rFLH1Client.updateGender(genderString).mo27434b(C1683a.m2378b()).mo27429a(C1683a.m2378b()).mo27432a(new C2131q(this, function2), new C2132r(function2));
    }

    @SuppressLint({"CheckResult"})
    public final void updatePrivateKey(Map<String, ? extends Object> map, Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(map, "privateKeyMap");
        Intrinsics.checkParameterIsNotNull(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        if (!isLogin()) {
            function1.invoke(false);
            return;
        }
        RFLH1Client rFLH1Client = this.h1Client;
        if (rFLH1Client == null) {
            Intrinsics.throwUninitializedPropertyAccessException("h1Client");
        }
        rFLH1Client.postPrivateKeyMap(map).mo27430a(new C2133s(this)).mo27434b(C1683a.m2378b()).mo27429a(C1683a.m2378b()).mo27432a(new C2134t(this, function1), new C2135u(function1));
    }
}
