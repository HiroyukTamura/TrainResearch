package p040i.p103M.p108g;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: i.M.g.f */
public final class C1820f {
    @JvmStatic
    /* renamed from: a */
    public static final boolean m2874a(String str) {
        Intrinsics.checkParameterIsNotNull(str, FirebaseAnalytics.Param.METHOD);
        return !Intrinsics.areEqual((Object) str, (Object) "GET") && !Intrinsics.areEqual((Object) str, (Object) "HEAD");
    }

    @JvmStatic
    /* renamed from: b */
    public static final boolean m2875b(String str) {
        Intrinsics.checkParameterIsNotNull(str, FirebaseAnalytics.Param.METHOD);
        return Intrinsics.areEqual((Object) str, (Object) "POST") || Intrinsics.areEqual((Object) str, (Object) "PUT") || Intrinsics.areEqual((Object) str, (Object) "PATCH") || Intrinsics.areEqual((Object) str, (Object) "PROPPATCH") || Intrinsics.areEqual((Object) str, (Object) "REPORT");
    }
}
