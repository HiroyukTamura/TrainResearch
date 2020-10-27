package p040i.p103M.p110i;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import p042j.C2073i;

/* renamed from: i.M.i.c */
public final class C1836c {
    @JvmField

    /* renamed from: d */
    public static final C2073i f2476d = C2073i.f2895e.mo29221b(":");
    @JvmField

    /* renamed from: e */
    public static final C2073i f2477e = C2073i.f2895e.mo29221b(":status");
    @JvmField

    /* renamed from: f */
    public static final C2073i f2478f = C2073i.f2895e.mo29221b(":method");
    @JvmField

    /* renamed from: g */
    public static final C2073i f2479g = C2073i.f2895e.mo29221b(":path");
    @JvmField

    /* renamed from: h */
    public static final C2073i f2480h = C2073i.f2895e.mo29221b(":scheme");
    @JvmField

    /* renamed from: i */
    public static final C2073i f2481i = C2073i.f2895e.mo29221b(":authority");
    @JvmField

    /* renamed from: a */
    public final int f2482a;
    @JvmField

    /* renamed from: b */
    public final C2073i f2483b;
    @JvmField

    /* renamed from: c */
    public final C2073i f2484c;

    public C1836c(C2073i iVar, C2073i iVar2) {
        Intrinsics.checkParameterIsNotNull(iVar, AppMeasurementSdk.ConditionalUserProperty.NAME);
        Intrinsics.checkParameterIsNotNull(iVar2, "value");
        this.f2483b = iVar;
        this.f2484c = iVar2;
        this.f2482a = iVar.mo29212d() + 32 + this.f2484c.mo29212d();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public C1836c(C2073i iVar, String str) {
        this(iVar, C2073i.f2895e.mo29221b(str));
        Intrinsics.checkParameterIsNotNull(iVar, AppMeasurementSdk.ConditionalUserProperty.NAME);
        Intrinsics.checkParameterIsNotNull(str, "value");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public C1836c(String str, String str2) {
        this(C2073i.f2895e.mo29221b(str), C2073i.f2895e.mo29221b(str2));
        Intrinsics.checkParameterIsNotNull(str, AppMeasurementSdk.ConditionalUserProperty.NAME);
        Intrinsics.checkParameterIsNotNull(str2, "value");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1836c)) {
            return false;
        }
        C1836c cVar = (C1836c) obj;
        return Intrinsics.areEqual((Object) this.f2483b, (Object) cVar.f2483b) && Intrinsics.areEqual((Object) this.f2484c, (Object) cVar.f2484c);
    }

    public int hashCode() {
        C2073i iVar = this.f2483b;
        int i = 0;
        int hashCode = (iVar != null ? iVar.hashCode() : 0) * 31;
        C2073i iVar2 = this.f2484c;
        if (iVar2 != null) {
            i = iVar2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return this.f2483b.mo29217h() + ": " + this.f2484c.mo29217h();
    }
}
