package p040i.p103M.p107f;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import p040i.C1950x;

/* renamed from: i.M.f.h */
final class C1805h extends Lambda implements Function0<List<? extends X509Certificate>> {

    /* renamed from: a */
    final /* synthetic */ C1806i f2379a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1805h(C1806i iVar) {
        super(0);
        this.f2379a = iVar;
    }

    public Object invoke() {
        C1950x a = this.f2379a.f2382d;
        if (a == null) {
            Intrinsics.throwNpe();
        }
        List<Certificate> c = a.mo28107c();
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(c, 10));
        for (Certificate certificate : c) {
            if (certificate != null) {
                arrayList.add((X509Certificate) certificate);
            } else {
                throw new TypeCastException("null cannot be cast to non-null type java.security.cert.X509Certificate");
            }
        }
        return arrayList;
    }
}
