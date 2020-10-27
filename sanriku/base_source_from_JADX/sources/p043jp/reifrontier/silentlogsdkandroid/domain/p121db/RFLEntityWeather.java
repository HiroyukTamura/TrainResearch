package p043jp.reifrontier.silentlogsdkandroid.domain.p121db;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001BK\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\u0007\u0012\b\b\u0001\u0010\t\u001a\u00020\u0007\u0012\b\b\u0001\u0010\n\u001a\u00020\u0007¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003JO\u0010\u001c\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00032\b\b\u0003\u0010\u0006\u001a\u00020\u00072\b\b\u0003\u0010\b\u001a\u00020\u00072\b\b\u0003\u0010\t\u001a\u00020\u00072\b\b\u0003\u0010\n\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010 \u001a\u00020\u0003H\u0016J\t\u0010!\u001a\u00020\u0007HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\b\u001a\u00020\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0016\u0010\t\u001a\u00020\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0016\u0010\n\u001a\u00020\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000f¨\u0006\""}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/domain/db/RFLEntityWeather;", "", "date", "", "temperature", "timestamp", "pressure", "", "pressureIn", "trend", "type", "(IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDate", "()I", "getPressure", "()Ljava/lang/String;", "getPressureIn", "getTemperature", "getTimestamp", "getTrend", "getType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityWeather */
public final class RFLEntityWeather {

    /* renamed from: a */
    private final int f3726a;

    /* renamed from: b */
    private final int f3727b;

    /* renamed from: c */
    private final int f3728c;

    /* renamed from: d */
    private final String f3729d;

    /* renamed from: e */
    private final String f3730e;

    /* renamed from: f */
    private final String f3731f;

    /* renamed from: g */
    private final String f3732g;

    public RFLEntityWeather(int i, int i2, int i3, String str, String str2, String str3, String str4) {
        Intrinsics.checkParameterIsNotNull(str, "pressure");
        Intrinsics.checkParameterIsNotNull(str2, "pressureIn");
        Intrinsics.checkParameterIsNotNull(str3, "trend");
        Intrinsics.checkParameterIsNotNull(str4, "type");
        this.f3726a = i;
        this.f3727b = i2;
        this.f3728c = i3;
        this.f3729d = str;
        this.f3730e = str2;
        this.f3731f = str3;
        this.f3732g = str4;
    }

    public static /* synthetic */ RFLEntityWeather copy$default(RFLEntityWeather rFLEntityWeather, int i, int i2, int i3, String str, String str2, String str3, String str4, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = rFLEntityWeather.f3726a;
        }
        if ((i4 & 2) != 0) {
            i2 = rFLEntityWeather.f3727b;
        }
        int i5 = i2;
        if ((i4 & 4) != 0) {
            i3 = rFLEntityWeather.f3728c;
        }
        int i6 = i3;
        if ((i4 & 8) != 0) {
            str = rFLEntityWeather.f3729d;
        }
        String str5 = str;
        if ((i4 & 16) != 0) {
            str2 = rFLEntityWeather.f3730e;
        }
        String str6 = str2;
        if ((i4 & 32) != 0) {
            str3 = rFLEntityWeather.f3731f;
        }
        String str7 = str3;
        if ((i4 & 64) != 0) {
            str4 = rFLEntityWeather.f3732g;
        }
        return rFLEntityWeather.copy(i, i5, i6, str5, str6, str7, str4);
    }

    public final int component1() {
        return this.f3726a;
    }

    public final int component2() {
        return this.f3727b;
    }

    public final int component3() {
        return this.f3728c;
    }

    public final String component4() {
        return this.f3729d;
    }

    public final String component5() {
        return this.f3730e;
    }

    public final String component6() {
        return this.f3731f;
    }

    public final String component7() {
        return this.f3732g;
    }

    public final RFLEntityWeather copy(int i, int i2, int i3, String str, String str2, String str3, String str4) {
        Intrinsics.checkParameterIsNotNull(str, "pressure");
        Intrinsics.checkParameterIsNotNull(str2, "pressureIn");
        Intrinsics.checkParameterIsNotNull(str3, "trend");
        String str5 = str4;
        Intrinsics.checkParameterIsNotNull(str5, "type");
        return new RFLEntityWeather(i, i2, i3, str, str2, str3, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RFLEntityWeather)) {
            return false;
        }
        RFLEntityWeather rFLEntityWeather = (RFLEntityWeather) obj;
        return this.f3726a == rFLEntityWeather.f3726a && this.f3727b == rFLEntityWeather.f3727b && this.f3728c == rFLEntityWeather.f3728c && !(Intrinsics.areEqual((Object) this.f3729d, (Object) rFLEntityWeather.f3729d) ^ true) && !(Intrinsics.areEqual((Object) this.f3730e, (Object) rFLEntityWeather.f3730e) ^ true) && !(Intrinsics.areEqual((Object) this.f3731f, (Object) rFLEntityWeather.f3731f) ^ true) && !(Intrinsics.areEqual((Object) this.f3732g, (Object) rFLEntityWeather.f3732g) ^ true);
    }

    public final int getDate() {
        return this.f3726a;
    }

    public final String getPressure() {
        return this.f3729d;
    }

    public final String getPressureIn() {
        return this.f3730e;
    }

    public final int getTemperature() {
        return this.f3727b;
    }

    public final int getTimestamp() {
        return this.f3728c;
    }

    public final String getTrend() {
        return this.f3731f;
    }

    public final String getType() {
        return this.f3732g;
    }

    public int hashCode() {
        int hashCode = this.f3729d.hashCode();
        int hashCode2 = this.f3730e.hashCode();
        int hashCode3 = this.f3731f.hashCode();
        return this.f3732g.hashCode() + ((hashCode3 + ((hashCode2 + ((hashCode + (((((this.f3726a * 31) + this.f3727b) * 31) + this.f3728c) * 31)) * 31)) * 31)) * 31);
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("RFLEntityWeather(date=");
        a.append(this.f3726a);
        a.append(", temperature=");
        a.append(this.f3727b);
        a.append(", timestamp=");
        a.append(this.f3728c);
        a.append(", pressure=");
        a.append(this.f3729d);
        a.append(", pressureIn=");
        a.append(this.f3730e);
        a.append(", trend=");
        a.append(this.f3731f);
        a.append(", type=");
        return C0681a.m324a(a, this.f3732g, ")");
    }
}
