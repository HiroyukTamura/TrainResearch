package p040i;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;

/* renamed from: i.r */
final class C1941r implements C1942s {
    /* renamed from: a */
    public List<InetAddress> mo28100a(String str) {
        Intrinsics.checkParameterIsNotNull(str, "hostname");
        try {
            InetAddress[] allByName = InetAddress.getAllByName(str);
            Intrinsics.checkExpressionValueIsNotNull(allByName, "InetAddress.getAllByName(hostname)");
            return ArraysKt___ArraysKt.toList((T[]) allByName);
        } catch (NullPointerException e) {
            UnknownHostException unknownHostException = new UnknownHostException(C0681a.m320a("Broken system behaviour for dns lookup of ", str));
            unknownHostException.initCause(e);
            throw unknownHostException;
        }
    }
}
