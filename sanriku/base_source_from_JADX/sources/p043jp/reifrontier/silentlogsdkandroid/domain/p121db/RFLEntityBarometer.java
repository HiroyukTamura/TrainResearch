package p043jp.reifrontier.silentlogsdkandroid.domain.p121db;

import com.google.gson.Gson;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import p009e.p010a.p011a.p012a.C0681a;
import p043jp.reifrontier.silentlogsdkandroid.domain.daily.RFLBarometer;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0015\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\r0\rX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001c"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/domain/db/RFLEntityBarometer;", "", "date", "", "data", "", "(Ljava/lang/String;[B)V", "barometers", "", "Ljp/reifrontier/silentlogsdkandroid/domain/daily/RFLBarometer;", "getBarometers", "()Ljava/util/List;", "barometersType", "Ljava/lang/reflect/Type;", "kotlin.jvm.PlatformType", "getData", "()[B", "getDate", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityBarometer */
public final class RFLEntityBarometer {

    /* renamed from: a */
    private final Type f3641a = new RFLEntityBarometer$barometersType$1().getType();

    /* renamed from: b */
    private final String f3642b;

    /* renamed from: c */
    private final byte[] f3643c;

    public RFLEntityBarometer(String str, byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(str, "date");
        Intrinsics.checkParameterIsNotNull(bArr, "data");
        this.f3642b = str;
        this.f3643c = bArr;
    }

    public static /* synthetic */ RFLEntityBarometer copy$default(RFLEntityBarometer rFLEntityBarometer, String str, byte[] bArr, int i, Object obj) {
        if ((i & 1) != 0) {
            str = rFLEntityBarometer.f3642b;
        }
        if ((i & 2) != 0) {
            bArr = rFLEntityBarometer.f3643c;
        }
        return rFLEntityBarometer.copy(str, bArr);
    }

    public final String component1() {
        return this.f3642b;
    }

    public final byte[] component2() {
        return this.f3643c;
    }

    public final RFLEntityBarometer copy(String str, byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(str, "date");
        Intrinsics.checkParameterIsNotNull(bArr, "data");
        return new RFLEntityBarometer(str, bArr);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual((Object) RFLEntityBarometer.class, (Object) obj != null ? obj.getClass() : null)) {
            return false;
        }
        if (obj != null) {
            RFLEntityBarometer rFLEntityBarometer = (RFLEntityBarometer) obj;
            return !(Intrinsics.areEqual((Object) this.f3642b, (Object) rFLEntityBarometer.f3642b) ^ true) && Arrays.equals(this.f3643c, rFLEntityBarometer.f3643c);
        }
        throw new TypeCastException("null cannot be cast to non-null type jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityBarometer");
    }

    public final List<RFLBarometer> getBarometers() {
        Object fromJson = new Gson().fromJson(new String(this.f3643c, Charsets.UTF_8), this.f3641a);
        Intrinsics.checkExpressionValueIsNotNull(fromJson, "Gson().fromJson<List<RFL…jsonData, barometersType)");
        return (List) fromJson;
    }

    public final byte[] getData() {
        return this.f3643c;
    }

    public final String getDate() {
        return this.f3642b;
    }

    public int hashCode() {
        return Arrays.hashCode(this.f3643c) + (this.f3642b.hashCode() * 31);
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("RFLEntityBarometer(date=");
        a.append(this.f3642b);
        a.append(", data=");
        a.append(Arrays.toString(this.f3643c));
        a.append(")");
        return a.toString();
    }
}
