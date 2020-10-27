package p043jp.reifrontier.silentlogsdkandroid.domain.api;

import android.location.Location;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;
import p043jp.reifrontier.silentlogsdkandroid.p119di.RFLAppComponent;
import p043jp.reifrontier.silentlogsdkandroid.utils.RFLDailyUtils;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0010J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0005HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\bHÆ\u0003J\t\u0010-\u001a\u00020\bHÆ\u0003J\t\u0010.\u001a\u00020\u000bHÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u000eHÆ\u0003J\u0010\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0018Jj\u00102\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u00103J\u0013\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00107\u001a\u00020\u0003HÖ\u0001J\b\u00108\u001a\u000209H\u0002J\u0006\u0010:\u001a\u00020;J\t\u0010<\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\u0011\u001a\u00020\u00128\u0000@\u0000X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\t\u001a\u00020\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u0016\u0010\r\u001a\u00020\u000e8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010$R\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010$¨\u0006="}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/domain/api/RFLNotificationPoi;", "", "poiId", "", "placeId", "", "poiType", "lat", "", "lon", "rangeRadius", "", "timingIndex", "name", "Ljp/reifrontier/silentlogsdkandroid/domain/api/RFLText;", "eventId", "(ILjava/lang/String;IDDFILjp/reifrontier/silentlogsdkandroid/domain/api/RFLText;Ljava/lang/Integer;)V", "dailyUtils", "Ljp/reifrontier/silentlogsdkandroid/utils/RFLDailyUtils;", "getDailyUtils$silentlogsdkandroid_release", "()Ljp/reifrontier/silentlogsdkandroid/utils/RFLDailyUtils;", "setDailyUtils$silentlogsdkandroid_release", "(Ljp/reifrontier/silentlogsdkandroid/utils/RFLDailyUtils;)V", "getEventId", "()Ljava/lang/Integer;", "setEventId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getLat", "()D", "getLon", "getName", "()Ljp/reifrontier/silentlogsdkandroid/domain/api/RFLText;", "getPlaceId", "()Ljava/lang/String;", "getPoiId", "()I", "getPoiType", "getRangeRadius", "()F", "getTimingIndex", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(ILjava/lang/String;IDDFILjp/reifrontier/silentlogsdkandroid/domain/api/RFLText;Ljava/lang/Integer;)Ljp/reifrontier/silentlogsdkandroid/domain/api/RFLNotificationPoi;", "equals", "", "other", "hashCode", "initComponent", "", "location", "Landroid/location/Location;", "toString", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.api.RFLNotificationPoi */
public final class RFLNotificationPoi {
    @SerializedName("poi_id")

    /* renamed from: a */
    private final int f3477a;
    @SerializedName("place_id")

    /* renamed from: b */
    private final String f3478b;
    @SerializedName("poi_type")

    /* renamed from: c */
    private final int f3479c;
    @SerializedName("lat")

    /* renamed from: d */
    private final double f3480d;
    public transient RFLDailyUtils dailyUtils;
    @SerializedName("lon")

    /* renamed from: e */
    private final double f3481e;
    @SerializedName("range_radius")

    /* renamed from: f */
    private final float f3482f;
    @SerializedName("timing_index")

    /* renamed from: g */
    private final int f3483g;
    @SerializedName("name")

    /* renamed from: h */
    private final RFLText f3484h;
    @SerializedName("eventId")

    /* renamed from: i */
    private Integer f3485i;

    public RFLNotificationPoi(int i, String str, int i2, double d, double d2, float f, int i3, RFLText rFLText, Integer num) {
        Intrinsics.checkParameterIsNotNull(str, "placeId");
        Intrinsics.checkParameterIsNotNull(rFLText, AppMeasurementSdk.ConditionalUserProperty.NAME);
        this.f3477a = i;
        this.f3478b = str;
        this.f3479c = i2;
        this.f3480d = d;
        this.f3481e = d2;
        this.f3482f = f;
        this.f3483g = i3;
        this.f3484h = rFLText;
        this.f3485i = num;
    }

    /* renamed from: a */
    private final void m3841a() {
        if (this.dailyUtils == null) {
            if (RFLAppComponent.SdkComponent.INSTANCE.getComponent$silentlogsdkandroid_release() == null) {
                this.dailyUtils = new RFLDailyUtils();
                return;
            }
            RFLAppComponent component$silentlogsdkandroid_release = RFLAppComponent.SdkComponent.INSTANCE.getComponent$silentlogsdkandroid_release();
            if (component$silentlogsdkandroid_release == null) {
                Intrinsics.throwNpe();
            }
            component$silentlogsdkandroid_release.inject(this);
        }
    }

    public static /* synthetic */ RFLNotificationPoi copy$default(RFLNotificationPoi rFLNotificationPoi, int i, String str, int i2, double d, double d2, float f, int i3, RFLText rFLText, Integer num, int i4, Object obj) {
        RFLNotificationPoi rFLNotificationPoi2 = rFLNotificationPoi;
        int i5 = i4;
        return rFLNotificationPoi.copy((i5 & 1) != 0 ? rFLNotificationPoi2.f3477a : i, (i5 & 2) != 0 ? rFLNotificationPoi2.f3478b : str, (i5 & 4) != 0 ? rFLNotificationPoi2.f3479c : i2, (i5 & 8) != 0 ? rFLNotificationPoi2.f3480d : d, (i5 & 16) != 0 ? rFLNotificationPoi2.f3481e : d2, (i5 & 32) != 0 ? rFLNotificationPoi2.f3482f : f, (i5 & 64) != 0 ? rFLNotificationPoi2.f3483g : i3, (i5 & 128) != 0 ? rFLNotificationPoi2.f3484h : rFLText, (i5 & 256) != 0 ? rFLNotificationPoi2.f3485i : num);
    }

    public final int component1() {
        return this.f3477a;
    }

    public final String component2() {
        return this.f3478b;
    }

    public final int component3() {
        return this.f3479c;
    }

    public final double component4() {
        return this.f3480d;
    }

    public final double component5() {
        return this.f3481e;
    }

    public final float component6() {
        return this.f3482f;
    }

    public final int component7() {
        return this.f3483g;
    }

    public final RFLText component8() {
        return this.f3484h;
    }

    public final Integer component9() {
        return this.f3485i;
    }

    public final RFLNotificationPoi copy(int i, String str, int i2, double d, double d2, float f, int i3, RFLText rFLText, Integer num) {
        Intrinsics.checkParameterIsNotNull(str, "placeId");
        RFLText rFLText2 = rFLText;
        Intrinsics.checkParameterIsNotNull(rFLText2, AppMeasurementSdk.ConditionalUserProperty.NAME);
        return new RFLNotificationPoi(i, str, i2, d, d2, f, i3, rFLText2, num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RFLNotificationPoi)) {
            return false;
        }
        RFLNotificationPoi rFLNotificationPoi = (RFLNotificationPoi) obj;
        return this.f3477a == rFLNotificationPoi.f3477a && Intrinsics.areEqual((Object) this.f3478b, (Object) rFLNotificationPoi.f3478b) && this.f3479c == rFLNotificationPoi.f3479c && Double.compare(this.f3480d, rFLNotificationPoi.f3480d) == 0 && Double.compare(this.f3481e, rFLNotificationPoi.f3481e) == 0 && Float.compare(this.f3482f, rFLNotificationPoi.f3482f) == 0 && this.f3483g == rFLNotificationPoi.f3483g && Intrinsics.areEqual((Object) this.f3484h, (Object) rFLNotificationPoi.f3484h) && Intrinsics.areEqual((Object) this.f3485i, (Object) rFLNotificationPoi.f3485i);
    }

    public final RFLDailyUtils getDailyUtils$silentlogsdkandroid_release() {
        RFLDailyUtils rFLDailyUtils = this.dailyUtils;
        if (rFLDailyUtils == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dailyUtils");
        }
        return rFLDailyUtils;
    }

    public final Integer getEventId() {
        return this.f3485i;
    }

    public final double getLat() {
        return this.f3480d;
    }

    public final double getLon() {
        return this.f3481e;
    }

    public final RFLText getName() {
        return this.f3484h;
    }

    public final String getPlaceId() {
        return this.f3478b;
    }

    public final int getPoiId() {
        return this.f3477a;
    }

    public final int getPoiType() {
        return this.f3479c;
    }

    public final float getRangeRadius() {
        return this.f3482f;
    }

    public final int getTimingIndex() {
        return this.f3483g;
    }

    public int hashCode() {
        int i = this.f3477a * 31;
        String str = this.f3478b;
        int i2 = 0;
        int floatToIntBits = (((Float.floatToIntBits(this.f3482f) + ((((((((i + (str != null ? str.hashCode() : 0)) * 31) + this.f3479c) * 31) + Double.doubleToLongBits(this.f3480d)) * 31) + Double.doubleToLongBits(this.f3481e)) * 31)) * 31) + this.f3483g) * 31;
        RFLText rFLText = this.f3484h;
        int hashCode = (floatToIntBits + (rFLText != null ? rFLText.hashCode() : 0)) * 31;
        Integer num = this.f3485i;
        if (num != null) {
            i2 = num.hashCode();
        }
        return hashCode + i2;
    }

    public final Location location() {
        m3841a();
        RFLDailyUtils rFLDailyUtils = this.dailyUtils;
        if (rFLDailyUtils == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dailyUtils");
        }
        return rFLDailyUtils.location(this.f3480d, this.f3481e);
    }

    public final void setDailyUtils$silentlogsdkandroid_release(RFLDailyUtils rFLDailyUtils) {
        Intrinsics.checkParameterIsNotNull(rFLDailyUtils, "<set-?>");
        this.dailyUtils = rFLDailyUtils;
    }

    public final void setEventId(Integer num) {
        this.f3485i = num;
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("RFLNotificationPoi(poiId=");
        a.append(this.f3477a);
        a.append(", placeId=");
        a.append(this.f3478b);
        a.append(", poiType=");
        a.append(this.f3479c);
        a.append(", lat=");
        a.append(this.f3480d);
        a.append(", lon=");
        a.append(this.f3481e);
        a.append(", rangeRadius=");
        a.append(this.f3482f);
        a.append(", timingIndex=");
        a.append(this.f3483g);
        a.append(", name=");
        a.append(this.f3484h);
        a.append(", eventId=");
        a.append(this.f3485i);
        a.append(")");
        return a.toString();
    }
}
