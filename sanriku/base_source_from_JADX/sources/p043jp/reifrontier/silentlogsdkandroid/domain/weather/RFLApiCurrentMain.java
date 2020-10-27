package p043jp.reifrontier.silentlogsdkandroid.domain.weather;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001BA\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\nJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u001a\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u000fJV\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\bHÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0011\u0010\u000fR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0012\u0010\fR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0013\u0010\fR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0014\u0010\f¨\u0006#"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/domain/weather/RFLApiCurrentMain;", "", "temperature", "", "feelsLike", "temperatureMin", "temperatureMax", "pressure", "", "humidity", "(Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getFeelsLike", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getHumidity", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPressure", "getTemperature", "getTemperatureMax", "getTemperatureMin", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Integer;)Ljp/reifrontier/silentlogsdkandroid/domain/weather/RFLApiCurrentMain;", "equals", "", "other", "hashCode", "toString", "", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.weather.RFLApiCurrentMain */
public final class RFLApiCurrentMain {
    @SerializedName("temp")

    /* renamed from: a */
    private final Float f3740a;
    @SerializedName("feels_like")

    /* renamed from: b */
    private final Float f3741b;
    @SerializedName("temp_min")

    /* renamed from: c */
    private final Float f3742c;
    @SerializedName("temp_max")

    /* renamed from: d */
    private final Float f3743d;
    @SerializedName("pressure")

    /* renamed from: e */
    private final Integer f3744e;
    @SerializedName("humidity")

    /* renamed from: f */
    private final Integer f3745f;

    public RFLApiCurrentMain(Float f, Float f2, Float f3, Float f4, Integer num, Integer num2) {
        this.f3740a = f;
        this.f3741b = f2;
        this.f3742c = f3;
        this.f3743d = f4;
        this.f3744e = num;
        this.f3745f = num2;
    }

    public static /* synthetic */ RFLApiCurrentMain copy$default(RFLApiCurrentMain rFLApiCurrentMain, Float f, Float f2, Float f3, Float f4, Integer num, Integer num2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = rFLApiCurrentMain.f3740a;
        }
        if ((i & 2) != 0) {
            f2 = rFLApiCurrentMain.f3741b;
        }
        Float f5 = f2;
        if ((i & 4) != 0) {
            f3 = rFLApiCurrentMain.f3742c;
        }
        Float f6 = f3;
        if ((i & 8) != 0) {
            f4 = rFLApiCurrentMain.f3743d;
        }
        Float f7 = f4;
        if ((i & 16) != 0) {
            num = rFLApiCurrentMain.f3744e;
        }
        Integer num3 = num;
        if ((i & 32) != 0) {
            num2 = rFLApiCurrentMain.f3745f;
        }
        return rFLApiCurrentMain.copy(f, f5, f6, f7, num3, num2);
    }

    public final Float component1() {
        return this.f3740a;
    }

    public final Float component2() {
        return this.f3741b;
    }

    public final Float component3() {
        return this.f3742c;
    }

    public final Float component4() {
        return this.f3743d;
    }

    public final Integer component5() {
        return this.f3744e;
    }

    public final Integer component6() {
        return this.f3745f;
    }

    public final RFLApiCurrentMain copy(Float f, Float f2, Float f3, Float f4, Integer num, Integer num2) {
        return new RFLApiCurrentMain(f, f2, f3, f4, num, num2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RFLApiCurrentMain)) {
            return false;
        }
        RFLApiCurrentMain rFLApiCurrentMain = (RFLApiCurrentMain) obj;
        return Intrinsics.areEqual((Object) this.f3740a, (Object) rFLApiCurrentMain.f3740a) && Intrinsics.areEqual((Object) this.f3741b, (Object) rFLApiCurrentMain.f3741b) && Intrinsics.areEqual((Object) this.f3742c, (Object) rFLApiCurrentMain.f3742c) && Intrinsics.areEqual((Object) this.f3743d, (Object) rFLApiCurrentMain.f3743d) && Intrinsics.areEqual((Object) this.f3744e, (Object) rFLApiCurrentMain.f3744e) && Intrinsics.areEqual((Object) this.f3745f, (Object) rFLApiCurrentMain.f3745f);
    }

    public final Float getFeelsLike() {
        return this.f3741b;
    }

    public final Integer getHumidity() {
        return this.f3745f;
    }

    public final Integer getPressure() {
        return this.f3744e;
    }

    public final Float getTemperature() {
        return this.f3740a;
    }

    public final Float getTemperatureMax() {
        return this.f3743d;
    }

    public final Float getTemperatureMin() {
        return this.f3742c;
    }

    public int hashCode() {
        Float f = this.f3740a;
        int i = 0;
        int hashCode = (f != null ? f.hashCode() : 0) * 31;
        Float f2 = this.f3741b;
        int hashCode2 = (hashCode + (f2 != null ? f2.hashCode() : 0)) * 31;
        Float f3 = this.f3742c;
        int hashCode3 = (hashCode2 + (f3 != null ? f3.hashCode() : 0)) * 31;
        Float f4 = this.f3743d;
        int hashCode4 = (hashCode3 + (f4 != null ? f4.hashCode() : 0)) * 31;
        Integer num = this.f3744e;
        int hashCode5 = (hashCode4 + (num != null ? num.hashCode() : 0)) * 31;
        Integer num2 = this.f3745f;
        if (num2 != null) {
            i = num2.hashCode();
        }
        return hashCode5 + i;
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("RFLApiCurrentMain(temperature=");
        a.append(this.f3740a);
        a.append(", feelsLike=");
        a.append(this.f3741b);
        a.append(", temperatureMin=");
        a.append(this.f3742c);
        a.append(", temperatureMax=");
        a.append(this.f3743d);
        a.append(", pressure=");
        a.append(this.f3744e);
        a.append(", humidity=");
        a.append(this.f3745f);
        a.append(")");
        return a.toString();
    }
}
