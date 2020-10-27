package p043jp.reifrontier.silentlogsdkandroid.domain.daily;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010$\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B[\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\u0018\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\r0\f¢\u0006\u0002\u0010\u000eJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010!\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0010J\u001b\u0010\"\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\r0\fHÆ\u0003Jt\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\u001a\b\u0002\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\r0\fHÆ\u0001¢\u0006\u0002\u0010$J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020)HÖ\u0001J\t\u0010*\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0012\u0010\u0010R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R(\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\r0\f8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006+"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/domain/daily/RFLActivityPoi;", "", "poiId", "", "src", "nameEn", "nameJa", "name", "lon", "", "lat", "tags", "", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Ljava/util/List;)V", "getLat", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getLon", "getName", "()Ljava/lang/String;", "getNameEn", "getNameJa", "getPoiId", "getSrc", "getTags", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Ljava/util/List;)Ljp/reifrontier/silentlogsdkandroid/domain/daily/RFLActivityPoi;", "equals", "", "other", "hashCode", "", "toString", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.daily.RFLActivityPoi */
public final class RFLActivityPoi {
    @SerializedName("poiId")

    /* renamed from: a */
    private final String f3527a;
    @SerializedName("src")

    /* renamed from: b */
    private final String f3528b;
    @SerializedName("nameEn")

    /* renamed from: c */
    private final String f3529c;
    @SerializedName("nameJa")

    /* renamed from: d */
    private final String f3530d;
    @SerializedName("name")

    /* renamed from: e */
    private final String f3531e;
    @SerializedName("lon")

    /* renamed from: f */
    private final Double f3532f;
    @SerializedName("lat")

    /* renamed from: g */
    private final Double f3533g;
    @SerializedName("tags")

    /* renamed from: h */
    private final List<Map<String, String>> f3534h;

    public RFLActivityPoi(String str, String str2, String str3, String str4, String str5, Double d, Double d2, List<? extends Map<String, String>> list) {
        Intrinsics.checkParameterIsNotNull(str, "poiId");
        Intrinsics.checkParameterIsNotNull(str2, "src");
        Intrinsics.checkParameterIsNotNull(str3, "nameEn");
        Intrinsics.checkParameterIsNotNull(str4, "nameJa");
        Intrinsics.checkParameterIsNotNull(str5, AppMeasurementSdk.ConditionalUserProperty.NAME);
        Intrinsics.checkParameterIsNotNull(list, "tags");
        this.f3527a = str;
        this.f3528b = str2;
        this.f3529c = str3;
        this.f3530d = str4;
        this.f3531e = str5;
        this.f3532f = d;
        this.f3533g = d2;
        this.f3534h = list;
    }

    public static /* synthetic */ RFLActivityPoi copy$default(RFLActivityPoi rFLActivityPoi, String str, String str2, String str3, String str4, String str5, Double d, Double d2, List list, int i, Object obj) {
        RFLActivityPoi rFLActivityPoi2 = rFLActivityPoi;
        int i2 = i;
        return rFLActivityPoi.copy((i2 & 1) != 0 ? rFLActivityPoi2.f3527a : str, (i2 & 2) != 0 ? rFLActivityPoi2.f3528b : str2, (i2 & 4) != 0 ? rFLActivityPoi2.f3529c : str3, (i2 & 8) != 0 ? rFLActivityPoi2.f3530d : str4, (i2 & 16) != 0 ? rFLActivityPoi2.f3531e : str5, (i2 & 32) != 0 ? rFLActivityPoi2.f3532f : d, (i2 & 64) != 0 ? rFLActivityPoi2.f3533g : d2, (i2 & 128) != 0 ? rFLActivityPoi2.f3534h : list);
    }

    public final String component1() {
        return this.f3527a;
    }

    public final String component2() {
        return this.f3528b;
    }

    public final String component3() {
        return this.f3529c;
    }

    public final String component4() {
        return this.f3530d;
    }

    public final String component5() {
        return this.f3531e;
    }

    public final Double component6() {
        return this.f3532f;
    }

    public final Double component7() {
        return this.f3533g;
    }

    public final List<Map<String, String>> component8() {
        return this.f3534h;
    }

    public final RFLActivityPoi copy(String str, String str2, String str3, String str4, String str5, Double d, Double d2, List<? extends Map<String, String>> list) {
        Intrinsics.checkParameterIsNotNull(str, "poiId");
        Intrinsics.checkParameterIsNotNull(str2, "src");
        Intrinsics.checkParameterIsNotNull(str3, "nameEn");
        Intrinsics.checkParameterIsNotNull(str4, "nameJa");
        Intrinsics.checkParameterIsNotNull(str5, AppMeasurementSdk.ConditionalUserProperty.NAME);
        List<? extends Map<String, String>> list2 = list;
        Intrinsics.checkParameterIsNotNull(list2, "tags");
        return new RFLActivityPoi(str, str2, str3, str4, str5, d, d2, list2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RFLActivityPoi)) {
            return false;
        }
        RFLActivityPoi rFLActivityPoi = (RFLActivityPoi) obj;
        return Intrinsics.areEqual((Object) this.f3527a, (Object) rFLActivityPoi.f3527a) && Intrinsics.areEqual((Object) this.f3528b, (Object) rFLActivityPoi.f3528b) && Intrinsics.areEqual((Object) this.f3529c, (Object) rFLActivityPoi.f3529c) && Intrinsics.areEqual((Object) this.f3530d, (Object) rFLActivityPoi.f3530d) && Intrinsics.areEqual((Object) this.f3531e, (Object) rFLActivityPoi.f3531e) && Intrinsics.areEqual((Object) this.f3532f, (Object) rFLActivityPoi.f3532f) && Intrinsics.areEqual((Object) this.f3533g, (Object) rFLActivityPoi.f3533g) && Intrinsics.areEqual((Object) this.f3534h, (Object) rFLActivityPoi.f3534h);
    }

    public final Double getLat() {
        return this.f3533g;
    }

    public final Double getLon() {
        return this.f3532f;
    }

    public final String getName() {
        return this.f3531e;
    }

    public final String getNameEn() {
        return this.f3529c;
    }

    public final String getNameJa() {
        return this.f3530d;
    }

    public final String getPoiId() {
        return this.f3527a;
    }

    public final String getSrc() {
        return this.f3528b;
    }

    public final List<Map<String, String>> getTags() {
        return this.f3534h;
    }

    public int hashCode() {
        String str = this.f3527a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f3528b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f3529c;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.f3530d;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.f3531e;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        Double d = this.f3532f;
        int hashCode6 = (hashCode5 + (d != null ? d.hashCode() : 0)) * 31;
        Double d2 = this.f3533g;
        int hashCode7 = (hashCode6 + (d2 != null ? d2.hashCode() : 0)) * 31;
        List<Map<String, String>> list = this.f3534h;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode7 + i;
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("RFLActivityPoi(poiId=");
        a.append(this.f3527a);
        a.append(", src=");
        a.append(this.f3528b);
        a.append(", nameEn=");
        a.append(this.f3529c);
        a.append(", nameJa=");
        a.append(this.f3530d);
        a.append(", name=");
        a.append(this.f3531e);
        a.append(", lon=");
        a.append(this.f3532f);
        a.append(", lat=");
        a.append(this.f3533g);
        a.append(", tags=");
        return C0681a.m325a(a, (List) this.f3534h, ")");
    }
}
