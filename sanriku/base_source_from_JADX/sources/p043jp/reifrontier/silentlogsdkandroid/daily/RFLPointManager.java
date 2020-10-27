package p043jp.reifrontier.silentlogsdkandroid.daily;

import android.annotation.SuppressLint;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;
import p043jp.reifrontier.silentlogsdkandroid.data.api.RFLPointClient;
import p043jp.reifrontier.silentlogsdkandroid.data.shared.RFLSharedHolder;
import p043jp.reifrontier.silentlogsdkandroid.domain.daily.RFLActivity;
import p043jp.reifrontier.silentlogsdkandroid.utils.RFL_ACTIVITY_TYPE;
import p048l.p049a.C1122a;
import p078g.p079a.p094C.C1683a;
import p078g.p079a.p096w.p097b.C1721a;
import p078g.p079a.p100z.C1741d;
import retrofit2.Response;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J-\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0007¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/daily/RFLPointManager;", "", "pointClient", "Ljp/reifrontier/silentlogsdkandroid/data/api/RFLPointClient;", "(Ljp/reifrontier/silentlogsdkandroid/data/api/RFLPointClient;)V", "calculation", "", "date", "Ljava/util/Date;", "previousUpdate", "", "activityFromSteps", "", "Ljp/reifrontier/silentlogsdkandroid/domain/daily/RFLActivity;", "(Ljava/util/Date;Ljava/lang/Integer;Ljava/util/List;)V", "Companion", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLPointManager */
public final class RFLPointManager {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String VALID_SYSTEM_KEY = "point-201911-SAN";

    /* renamed from: a */
    private final RFLPointClient f3226a;

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/daily/RFLPointManager$Companion;", "", "()V", "VALID_SYSTEM_KEY", "", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLPointManager$Companion */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLPointManager$a */
    static final class C2194a<T> implements C1741d<Response<Map<String, ? extends Object>>> {

        /* renamed from: a */
        public static final C2194a f3227a = new C2194a();

        C2194a() {
        }

        /* renamed from: a */
        public final void accept(Response<Map<String, Object>> response) {
            int code = response.code();
            if (code == 200) {
                StringBuilder a = C0681a.m330a("[SilentLogSDK] Info::requestPointCalculation ");
                a.append(response.body());
                C1122a.m1600c(a.toString(), new Object[0]);
            } else if (code != 500) {
                StringBuilder a2 = C0681a.m330a("[SilentLogSDK] Error::requestPointCalculation ");
                a2.append(response.body());
                C1122a.m1599b(a2.toString(), new Object[0]);
            } else {
                StringBuilder a3 = C0681a.m330a("[SilentLogSDK] Error::requestPointCalculation ");
                a3.append(response.code());
                C1122a.m1599b(a3.toString(), new Object[0]);
            }
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLPointManager$b */
    static final class C2195b<T> implements C1741d<Throwable> {

        /* renamed from: a */
        public static final C2195b f3228a = new C2195b();

        C2195b() {
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            C1122a.m1599b(C0681a.m326a(th, C0681a.m331a("[SilentLogSDK] Error::requestPointCalculation ", th, "it")), new Object[0]);
        }
    }

    public RFLPointManager(RFLPointClient rFLPointClient) {
        Intrinsics.checkParameterIsNotNull(rFLPointClient, "pointClient");
        this.f3226a = rFLPointClient;
    }

    @SuppressLint({"CheckResult"})
    public final void calculation(Date date, Integer num, List<RFLActivity> list) {
        Intrinsics.checkParameterIsNotNull(date, "date");
        Intrinsics.checkParameterIsNotNull(list, "activityFromSteps");
        String pointSystemKey = RFLSharedHolder.INSTANCE.pointSystemKey();
        boolean z = true;
        if (!Intrinsics.areEqual((Object) pointSystemKey, (Object) "point-201911-SAN")) {
            C1122a.m1596a(C0681a.m320a("[SilentLogSDK] Debug::invalid system key ", pointSystemKey), new Object[0]);
            return;
        }
        if (num != null) {
            Iterator<RFLActivity> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                RFLActivity next = it.next();
                if (num.intValue() < next.getToDate() && next.type() == RFL_ACTIVITY_TYPE.WALK) {
                    break;
                }
            }
        }
        if (z) {
            C1122a.m1600c("[SilentLogSDK] Info::requestPointCalculation", new Object[0]);
            Intrinsics.checkExpressionValueIsNotNull(this.f3226a.requestPointCalculation(date).mo27434b(C1683a.m2378b()).mo27429a(C1721a.m2428a()).mo27432a(C2194a.f3227a, C2195b.f3228a), "pointClient.requestPoint…  }\n                    )");
            return;
        }
        C1122a.m1596a("[SilentLogSDK] Info::requestPointCalculation no need", new Object[0]);
    }
}
