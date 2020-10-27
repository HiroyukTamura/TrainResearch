package p043jp.reifrontier.gym.data.train;

import android.location.Location;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\u0002\u0010\u0010J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0006HÆ\u0003J\t\u0010%\u001a\u00020\u0006HÆ\u0003J\t\u0010&\u001a\u00020\u0006HÆ\u0003J\t\u0010'\u001a\u00020\u0006HÆ\u0003J\t\u0010(\u001a\u00020\u000bHÆ\u0003J\t\u0010)\u001a\u00020\u000bHÆ\u0003J\u000f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eHÆ\u0003Ji\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eHÆ\u0001J\u0013\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010/\u001a\u00020\u0003HÖ\u0001J\t\u00100\u001a\u00020\u0006HÖ\u0001R\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\f\u001a\u00020\u000b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\b\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0016\u0010\t\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001e¨\u00061"}, mo21739d2 = {"Ljp/reifrontier/gym/data/train/RFGStation;", "", "stationId", "", "positionId", "name", "", "nameKo", "nameEn", "nameKana", "lat", "", "lon", "schedules", "", "Ljp/reifrontier/gym/data/train/RFGStationSchedule;", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;DDLjava/util/List;)V", "getLat", "()D", "location", "Landroid/location/Location;", "getLocation", "()Landroid/location/Location;", "getLon", "getName", "()Ljava/lang/String;", "getNameEn", "getNameKana", "getNameKo", "getPositionId", "()I", "getSchedules", "()Ljava/util/List;", "getStationId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.data.train.RFGStation */
public final class RFGStation {
    @SerializedName("lat")
    private final double lat;
    @SerializedName("lon")
    private final double lon;
    @SerializedName("name")
    private final String name;
    @SerializedName("name-en")
    private final String nameEn;
    @SerializedName("name-kana")
    private final String nameKana;
    @SerializedName("name-ko")
    private final String nameKo;
    @SerializedName("position_id")
    private final int positionId;
    @SerializedName("schedules")
    private final List<RFGStationSchedule> schedules;
    @SerializedName("station_id")
    private final int stationId;

    public RFGStation(int i, int i2, String str, String str2, String str3, String str4, double d, double d2, List<RFGStationSchedule> list) {
        Intrinsics.checkParameterIsNotNull(str, AppMeasurementSdk.ConditionalUserProperty.NAME);
        Intrinsics.checkParameterIsNotNull(str2, "nameKo");
        Intrinsics.checkParameterIsNotNull(str3, "nameEn");
        Intrinsics.checkParameterIsNotNull(str4, "nameKana");
        Intrinsics.checkParameterIsNotNull(list, "schedules");
        this.stationId = i;
        this.positionId = i2;
        this.name = str;
        this.nameKo = str2;
        this.nameEn = str3;
        this.nameKana = str4;
        this.lat = d;
        this.lon = d2;
        this.schedules = list;
    }

    public static /* synthetic */ RFGStation copy$default(RFGStation rFGStation, int i, int i2, String str, String str2, String str3, String str4, double d, double d2, List list, int i3, Object obj) {
        RFGStation rFGStation2 = rFGStation;
        int i4 = i3;
        return rFGStation.copy((i4 & 1) != 0 ? rFGStation2.stationId : i, (i4 & 2) != 0 ? rFGStation2.positionId : i2, (i4 & 4) != 0 ? rFGStation2.name : str, (i4 & 8) != 0 ? rFGStation2.nameKo : str2, (i4 & 16) != 0 ? rFGStation2.nameEn : str3, (i4 & 32) != 0 ? rFGStation2.nameKana : str4, (i4 & 64) != 0 ? rFGStation2.lat : d, (i4 & 128) != 0 ? rFGStation2.lon : d2, (i4 & 256) != 0 ? rFGStation2.schedules : list);
    }

    public final int component1() {
        return this.stationId;
    }

    public final int component2() {
        return this.positionId;
    }

    public final String component3() {
        return this.name;
    }

    public final String component4() {
        return this.nameKo;
    }

    public final String component5() {
        return this.nameEn;
    }

    public final String component6() {
        return this.nameKana;
    }

    public final double component7() {
        return this.lat;
    }

    public final double component8() {
        return this.lon;
    }

    public final List<RFGStationSchedule> component9() {
        return this.schedules;
    }

    public final RFGStation copy(int i, int i2, String str, String str2, String str3, String str4, double d, double d2, List<RFGStationSchedule> list) {
        String str5 = str;
        Intrinsics.checkParameterIsNotNull(str5, AppMeasurementSdk.ConditionalUserProperty.NAME);
        String str6 = str2;
        Intrinsics.checkParameterIsNotNull(str6, "nameKo");
        String str7 = str3;
        Intrinsics.checkParameterIsNotNull(str7, "nameEn");
        String str8 = str4;
        Intrinsics.checkParameterIsNotNull(str8, "nameKana");
        List<RFGStationSchedule> list2 = list;
        Intrinsics.checkParameterIsNotNull(list2, "schedules");
        return new RFGStation(i, i2, str5, str6, str7, str8, d, d2, list2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RFGStation)) {
            return false;
        }
        RFGStation rFGStation = (RFGStation) obj;
        return this.stationId == rFGStation.stationId && this.positionId == rFGStation.positionId && Intrinsics.areEqual((Object) this.name, (Object) rFGStation.name) && Intrinsics.areEqual((Object) this.nameKo, (Object) rFGStation.nameKo) && Intrinsics.areEqual((Object) this.nameEn, (Object) rFGStation.nameEn) && Intrinsics.areEqual((Object) this.nameKana, (Object) rFGStation.nameKana) && Double.compare(this.lat, rFGStation.lat) == 0 && Double.compare(this.lon, rFGStation.lon) == 0 && Intrinsics.areEqual((Object) this.schedules, (Object) rFGStation.schedules);
    }

    public final double getLat() {
        return this.lat;
    }

    public final Location getLocation() {
        Location location = new Location("gym");
        location.setLatitude(this.lat);
        location.setLongitude(this.lon);
        return location;
    }

    public final double getLon() {
        return this.lon;
    }

    public final String getName() {
        return this.name;
    }

    public final String getNameEn() {
        return this.nameEn;
    }

    public final String getNameKana() {
        return this.nameKana;
    }

    public final String getNameKo() {
        return this.nameKo;
    }

    public final int getPositionId() {
        return this.positionId;
    }

    public final List<RFGStationSchedule> getSchedules() {
        return this.schedules;
    }

    public final int getStationId() {
        return this.stationId;
    }

    public int hashCode() {
        int i = ((this.stationId * 31) + this.positionId) * 31;
        String str = this.name;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.nameKo;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.nameEn;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.nameKana;
        int hashCode4 = (((((hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31) + Double.doubleToLongBits(this.lat)) * 31) + Double.doubleToLongBits(this.lon)) * 31;
        List<RFGStationSchedule> list = this.schedules;
        if (list != null) {
            i2 = list.hashCode();
        }
        return hashCode4 + i2;
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("RFGStation(stationId=");
        a.append(this.stationId);
        a.append(", positionId=");
        a.append(this.positionId);
        a.append(", name=");
        a.append(this.name);
        a.append(", nameKo=");
        a.append(this.nameKo);
        a.append(", nameEn=");
        a.append(this.nameEn);
        a.append(", nameKana=");
        a.append(this.nameKana);
        a.append(", lat=");
        a.append(this.lat);
        a.append(", lon=");
        a.append(this.lon);
        a.append(", schedules=");
        return C0681a.m325a(a, (List) this.schedules, ")");
    }
}
