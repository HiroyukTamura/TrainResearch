package p043jp.reifrontier.silentlogsdkandroid.domain.weather;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\bJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J>\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\n¨\u0006\u001b"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/domain/weather/RFLApiWeather;", "", "id", "", "main", "", "description", "icon", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDescription", "()Ljava/lang/String;", "getIcon", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMain", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljp/reifrontier/silentlogsdkandroid/domain/weather/RFLApiWeather;", "equals", "", "other", "hashCode", "toString", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.weather.RFLApiWeather */
public final class RFLApiWeather {
    @SerializedName("id")

    /* renamed from: a */
    private final Integer f3778a;
    @SerializedName("main")

    /* renamed from: b */
    private final String f3779b;
    @SerializedName("description")

    /* renamed from: c */
    private final String f3780c;
    @SerializedName("icon")

    /* renamed from: d */
    private final String f3781d;

    public RFLApiWeather(Integer num, String str, String str2, String str3) {
        this.f3778a = num;
        this.f3779b = str;
        this.f3780c = str2;
        this.f3781d = str3;
    }

    public static /* synthetic */ RFLApiWeather copy$default(RFLApiWeather rFLApiWeather, Integer num, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            num = rFLApiWeather.f3778a;
        }
        if ((i & 2) != 0) {
            str = rFLApiWeather.f3779b;
        }
        if ((i & 4) != 0) {
            str2 = rFLApiWeather.f3780c;
        }
        if ((i & 8) != 0) {
            str3 = rFLApiWeather.f3781d;
        }
        return rFLApiWeather.copy(num, str, str2, str3);
    }

    public final Integer component1() {
        return this.f3778a;
    }

    public final String component2() {
        return this.f3779b;
    }

    public final String component3() {
        return this.f3780c;
    }

    public final String component4() {
        return this.f3781d;
    }

    public final RFLApiWeather copy(Integer num, String str, String str2, String str3) {
        return new RFLApiWeather(num, str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RFLApiWeather)) {
            return false;
        }
        RFLApiWeather rFLApiWeather = (RFLApiWeather) obj;
        return Intrinsics.areEqual((Object) this.f3778a, (Object) rFLApiWeather.f3778a) && Intrinsics.areEqual((Object) this.f3779b, (Object) rFLApiWeather.f3779b) && Intrinsics.areEqual((Object) this.f3780c, (Object) rFLApiWeather.f3780c) && Intrinsics.areEqual((Object) this.f3781d, (Object) rFLApiWeather.f3781d);
    }

    public final String getDescription() {
        return this.f3780c;
    }

    public final String getIcon() {
        return this.f3781d;
    }

    public final Integer getId() {
        return this.f3778a;
    }

    public final String getMain() {
        return this.f3779b;
    }

    public int hashCode() {
        Integer num = this.f3778a;
        int i = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 31;
        String str = this.f3779b;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f3780c;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f3781d;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("RFLApiWeather(id=");
        a.append(this.f3778a);
        a.append(", main=");
        a.append(this.f3779b);
        a.append(", description=");
        a.append(this.f3780c);
        a.append(", icon=");
        return C0681a.m324a(a, this.f3781d, ")");
    }
}
