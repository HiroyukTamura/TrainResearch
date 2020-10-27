package p040i.p103M.p110i;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import p042j.C2072h;

/* renamed from: i.M.i.l */
final class C1869l implements C1870m {
    /* renamed from: a */
    public void mo27941a(int i, C1834b bVar) {
        Intrinsics.checkParameterIsNotNull(bVar, "errorCode");
    }

    /* renamed from: a */
    public boolean mo27942a(int i, C2072h hVar, int i2, boolean z) throws IOException {
        Intrinsics.checkParameterIsNotNull(hVar, FirebaseAnalytics.Param.SOURCE);
        hVar.skip((long) i2);
        return true;
    }

    /* renamed from: a */
    public boolean mo27943a(int i, List<C1836c> list) {
        Intrinsics.checkParameterIsNotNull(list, "requestHeaders");
        return true;
    }

    /* renamed from: a */
    public boolean mo27944a(int i, List<C1836c> list, boolean z) {
        Intrinsics.checkParameterIsNotNull(list, "responseHeaders");
        return true;
    }
}
