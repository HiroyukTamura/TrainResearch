package p043jp.reifrontier.silentlogsdkandroid.domain.p121db;

import com.google.gson.Gson;
import java.lang.reflect.Type;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import p009e.p010a.p011a.p012a.C0681a;
import p043jp.reifrontier.silentlogsdkandroid.domain.daily.RFLTrackPoint;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0014\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\n \u0011*\u0004\u0018\u00010\u00100\u0010X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/domain/db/RFLEntityTP;", "", "date", "", "data", "", "(Ljava/lang/String;[B)V", "getData", "()[B", "getDate", "()Ljava/lang/String;", "trackPoint", "Ljp/reifrontier/silentlogsdkandroid/domain/daily/RFLTrackPoint;", "getTrackPoint", "()Ljp/reifrontier/silentlogsdkandroid/domain/daily/RFLTrackPoint;", "trackPointType", "Ljava/lang/reflect/Type;", "kotlin.jvm.PlatformType", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityTP */
public final class RFLEntityTP {

    /* renamed from: a */
    private final Type f3694a = new RFLEntityTP$trackPointType$1().getType();

    /* renamed from: b */
    private final String f3695b;

    /* renamed from: c */
    private final byte[] f3696c;

    public RFLEntityTP(String str, byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(str, "date");
        Intrinsics.checkParameterIsNotNull(bArr, "data");
        this.f3695b = str;
        this.f3696c = bArr;
    }

    public static /* synthetic */ RFLEntityTP copy$default(RFLEntityTP rFLEntityTP, String str, byte[] bArr, int i, Object obj) {
        if ((i & 1) != 0) {
            str = rFLEntityTP.f3695b;
        }
        if ((i & 2) != 0) {
            bArr = rFLEntityTP.f3696c;
        }
        return rFLEntityTP.copy(str, bArr);
    }

    public final String component1() {
        return this.f3695b;
    }

    public final byte[] component2() {
        return this.f3696c;
    }

    public final RFLEntityTP copy(String str, byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(str, "date");
        Intrinsics.checkParameterIsNotNull(bArr, "data");
        return new RFLEntityTP(str, bArr);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual((Object) RFLEntityTP.class, (Object) obj != null ? obj.getClass() : null)) {
            return false;
        }
        if (obj != null) {
            RFLEntityTP rFLEntityTP = (RFLEntityTP) obj;
            return !(Intrinsics.areEqual((Object) this.f3695b, (Object) rFLEntityTP.f3695b) ^ true) && Arrays.equals(this.f3696c, rFLEntityTP.f3696c);
        }
        throw new TypeCastException("null cannot be cast to non-null type jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityTP");
    }

    public final byte[] getData() {
        return this.f3696c;
    }

    public final String getDate() {
        return this.f3695b;
    }

    public final RFLTrackPoint getTrackPoint() {
        Object fromJson = new Gson().fromJson(new String(this.f3696c, Charsets.UTF_8), this.f3694a);
        Intrinsics.checkExpressionValueIsNotNull(fromJson, "Gson().fromJson<RFLTrack…jsonData, trackPointType)");
        return (RFLTrackPoint) fromJson;
    }

    public int hashCode() {
        return Arrays.hashCode(this.f3696c) + (this.f3695b.hashCode() * 31);
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("RFLEntityTP(date=");
        a.append(this.f3695b);
        a.append(", data=");
        a.append(Arrays.toString(this.f3696c));
        a.append(")");
        return a.toString();
    }
}
