package p043jp.reifrontier.silentlogsdkandroid.domain.weather;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001BA\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJV\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\r\u0010\u000bR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000e\u0010\u000bR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0010\u0010\u000bR\u001a\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0011\u0010\u000b¨\u0006!"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/domain/weather/RFLApiForecastTemperature;", "", "min", "", "max", "morning", "day", "evening", "night", "(Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;)V", "getDay", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getEvening", "getMax", "getMin", "getMorning", "getNight", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;)Ljp/reifrontier/silentlogsdkandroid/domain/weather/RFLApiForecastTemperature;", "equals", "", "other", "hashCode", "", "toString", "", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.weather.RFLApiForecastTemperature */
public final class RFLApiForecastTemperature {
    @SerializedName("min")

    /* renamed from: a */
    private final Float f3770a;
    @SerializedName("max")

    /* renamed from: b */
    private final Float f3771b;
    @SerializedName("morn")

    /* renamed from: c */
    private final Float f3772c;
    @SerializedName("day")

    /* renamed from: d */
    private final Float f3773d;
    @SerializedName("eve")

    /* renamed from: e */
    private final Float f3774e;
    @SerializedName("night")

    /* renamed from: f */
    private final Float f3775f;

    public RFLApiForecastTemperature(Float f, Float f2, Float f3, Float f4, Float f5, Float f6) {
        this.f3770a = f;
        this.f3771b = f2;
        this.f3772c = f3;
        this.f3773d = f4;
        this.f3774e = f5;
        this.f3775f = f6;
    }

    public static /* synthetic */ RFLApiForecastTemperature copy$default(RFLApiForecastTemperature rFLApiForecastTemperature, Float f, Float f2, Float f3, Float f4, Float f5, Float f6, int i, Object obj) {
        if ((i & 1) != 0) {
            f = rFLApiForecastTemperature.f3770a;
        }
        if ((i & 2) != 0) {
            f2 = rFLApiForecastTemperature.f3771b;
        }
        Float f7 = f2;
        if ((i & 4) != 0) {
            f3 = rFLApiForecastTemperature.f3772c;
        }
        Float f8 = f3;
        if ((i & 8) != 0) {
            f4 = rFLApiForecastTemperature.f3773d;
        }
        Float f9 = f4;
        if ((i & 16) != 0) {
            f5 = rFLApiForecastTemperature.f3774e;
        }
        Float f10 = f5;
        if ((i & 32) != 0) {
            f6 = rFLApiForecastTemperature.f3775f;
        }
        return rFLApiForecastTemperature.copy(f, f7, f8, f9, f10, f6);
    }

    public final Float component1() {
        return this.f3770a;
    }

    public final Float component2() {
        return this.f3771b;
    }

    public final Float component3() {
        return this.f3772c;
    }

    public final Float component4() {
        return this.f3773d;
    }

    public final Float component5() {
        return this.f3774e;
    }

    public final Float component6() {
        return this.f3775f;
    }

    public final RFLApiForecastTemperature copy(Float f, Float f2, Float f3, Float f4, Float f5, Float f6) {
        return new RFLApiForecastTemperature(f, f2, f3, f4, f5, f6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RFLApiForecastTemperature)) {
            return false;
        }
        RFLApiForecastTemperature rFLApiForecastTemperature = (RFLApiForecastTemperature) obj;
        return Intrinsics.areEqual((Object) this.f3770a, (Object) rFLApiForecastTemperature.f3770a) && Intrinsics.areEqual((Object) this.f3771b, (Object) rFLApiForecastTemperature.f3771b) && Intrinsics.areEqual((Object) this.f3772c, (Object) rFLApiForecastTemperature.f3772c) && Intrinsics.areEqual((Object) this.f3773d, (Object) rFLApiForecastTemperature.f3773d) && Intrinsics.areEqual((Object) this.f3774e, (Object) rFLApiForecastTemperature.f3774e) && Intrinsics.areEqual((Object) this.f3775f, (Object) rFLApiForecastTemperature.f3775f);
    }

    public final Float getDay() {
        return this.f3773d;
    }

    public final Float getEvening() {
        return this.f3774e;
    }

    public final Float getMax() {
        return this.f3771b;
    }

    public final Float getMin() {
        return this.f3770a;
    }

    public final Float getMorning() {
        return this.f3772c;
    }

    public final Float getNight() {
        return this.f3775f;
    }

    public int hashCode() {
        Float f = this.f3770a;
        int i = 0;
        int hashCode = (f != null ? f.hashCode() : 0) * 31;
        Float f2 = this.f3771b;
        int hashCode2 = (hashCode + (f2 != null ? f2.hashCode() : 0)) * 31;
        Float f3 = this.f3772c;
        int hashCode3 = (hashCode2 + (f3 != null ? f3.hashCode() : 0)) * 31;
        Float f4 = this.f3773d;
        int hashCode4 = (hashCode3 + (f4 != null ? f4.hashCode() : 0)) * 31;
        Float f5 = this.f3774e;
        int hashCode5 = (hashCode4 + (f5 != null ? f5.hashCode() : 0)) * 31;
        Float f6 = this.f3775f;
        if (f6 != null) {
            i = f6.hashCode();
        }
        return hashCode5 + i;
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("RFLApiForecastTemperature(min=");
        a.append(this.f3770a);
        a.append(", max=");
        a.append(this.f3771b);
        a.append(", morning=");
        a.append(this.f3772c);
        a.append(", day=");
        a.append(this.f3773d);
        a.append(", evening=");
        a.append(this.f3774e);
        a.append(", night=");
        a.append(this.f3775f);
        a.append(")");
        return a.toString();
    }
}
