package p043jp.reifrontier.gym.domain.api;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b \n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BK\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003JO\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\u0006\u0010(\u001a\u00020)J\t\u0010*\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\b\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u001e\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\u001e\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001e\u0010\t\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000eR\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\f\"\u0004\b\u0018\u0010\u000eR\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000e¨\u0006+"}, mo21739d2 = {"Ljp/reifrontier/gym/domain/api/RFGChallengeParameter;", "", "challengeId", "", "parameterId", "point", "lat", "lon", "iconType", "name", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getChallengeId", "()Ljava/lang/String;", "setChallengeId", "(Ljava/lang/String;)V", "getIconType", "setIconType", "getLat", "setLat", "getLon", "setLon", "getName", "setName", "getParameterId", "setParameterId", "getPoint", "setPoint", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "latlng", "Lcom/google/android/gms/maps/model/LatLng;", "toString", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.domain.api.RFGChallengeParameter */
public final class RFGChallengeParameter {
    @SerializedName("challenge_id")
    private String challengeId;
    @SerializedName("icon_type")
    private String iconType;
    @SerializedName("lat")
    private String lat;
    @SerializedName("lon")
    private String lon;
    @SerializedName("name")
    private String name;
    @SerializedName("parameter_id")
    private String parameterId;
    @SerializedName("point")
    private String point;

    public RFGChallengeParameter() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 127, (DefaultConstructorMarker) null);
    }

    public RFGChallengeParameter(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        Intrinsics.checkParameterIsNotNull(str, "challengeId");
        Intrinsics.checkParameterIsNotNull(str2, "parameterId");
        Intrinsics.checkParameterIsNotNull(str3, "point");
        Intrinsics.checkParameterIsNotNull(str4, "lat");
        Intrinsics.checkParameterIsNotNull(str5, "lon");
        Intrinsics.checkParameterIsNotNull(str6, "iconType");
        Intrinsics.checkParameterIsNotNull(str7, AppMeasurementSdk.ConditionalUserProperty.NAME);
        this.challengeId = str;
        this.parameterId = str2;
        this.point = str3;
        this.lat = str4;
        this.lon = str5;
        this.iconType = str6;
        this.name = str7;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ RFGChallengeParameter(java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, java.lang.String r12, int r13, kotlin.jvm.internal.DefaultConstructorMarker r14) {
        /*
            r5 = this;
            r14 = r13 & 1
            java.lang.String r0 = "0"
            if (r14 == 0) goto L_0x0008
            r14 = r0
            goto L_0x0009
        L_0x0008:
            r14 = r6
        L_0x0009:
            r6 = r13 & 2
            if (r6 == 0) goto L_0x000f
            r1 = r0
            goto L_0x0010
        L_0x000f:
            r1 = r7
        L_0x0010:
            r6 = r13 & 4
            if (r6 == 0) goto L_0x0015
            goto L_0x0016
        L_0x0015:
            r0 = r8
        L_0x0016:
            r6 = r13 & 8
            java.lang.String r7 = "0.0"
            if (r6 == 0) goto L_0x001e
            r2 = r7
            goto L_0x001f
        L_0x001e:
            r2 = r9
        L_0x001f:
            r6 = r13 & 16
            if (r6 == 0) goto L_0x0025
            r3 = r7
            goto L_0x0026
        L_0x0025:
            r3 = r10
        L_0x0026:
            r6 = r13 & 32
            java.lang.String r7 = ""
            if (r6 == 0) goto L_0x002e
            r4 = r7
            goto L_0x002f
        L_0x002e:
            r4 = r11
        L_0x002f:
            r6 = r13 & 64
            if (r6 == 0) goto L_0x0035
            r13 = r7
            goto L_0x0036
        L_0x0035:
            r13 = r12
        L_0x0036:
            r6 = r5
            r7 = r14
            r8 = r1
            r9 = r0
            r10 = r2
            r11 = r3
            r12 = r4
            r6.<init>(r7, r8, r9, r10, r11, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p043jp.reifrontier.gym.domain.api.RFGChallengeParameter.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public static /* synthetic */ RFGChallengeParameter copy$default(RFGChallengeParameter rFGChallengeParameter, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, Object obj) {
        if ((i & 1) != 0) {
            str = rFGChallengeParameter.challengeId;
        }
        if ((i & 2) != 0) {
            str2 = rFGChallengeParameter.parameterId;
        }
        String str8 = str2;
        if ((i & 4) != 0) {
            str3 = rFGChallengeParameter.point;
        }
        String str9 = str3;
        if ((i & 8) != 0) {
            str4 = rFGChallengeParameter.lat;
        }
        String str10 = str4;
        if ((i & 16) != 0) {
            str5 = rFGChallengeParameter.lon;
        }
        String str11 = str5;
        if ((i & 32) != 0) {
            str6 = rFGChallengeParameter.iconType;
        }
        String str12 = str6;
        if ((i & 64) != 0) {
            str7 = rFGChallengeParameter.name;
        }
        return rFGChallengeParameter.copy(str, str8, str9, str10, str11, str12, str7);
    }

    public final String component1() {
        return this.challengeId;
    }

    public final String component2() {
        return this.parameterId;
    }

    public final String component3() {
        return this.point;
    }

    public final String component4() {
        return this.lat;
    }

    public final String component5() {
        return this.lon;
    }

    public final String component6() {
        return this.iconType;
    }

    public final String component7() {
        return this.name;
    }

    public final RFGChallengeParameter copy(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        Intrinsics.checkParameterIsNotNull(str, "challengeId");
        Intrinsics.checkParameterIsNotNull(str2, "parameterId");
        Intrinsics.checkParameterIsNotNull(str3, "point");
        Intrinsics.checkParameterIsNotNull(str4, "lat");
        Intrinsics.checkParameterIsNotNull(str5, "lon");
        Intrinsics.checkParameterIsNotNull(str6, "iconType");
        String str8 = str7;
        Intrinsics.checkParameterIsNotNull(str8, AppMeasurementSdk.ConditionalUserProperty.NAME);
        return new RFGChallengeParameter(str, str2, str3, str4, str5, str6, str8);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RFGChallengeParameter)) {
            return false;
        }
        RFGChallengeParameter rFGChallengeParameter = (RFGChallengeParameter) obj;
        return Intrinsics.areEqual((Object) this.challengeId, (Object) rFGChallengeParameter.challengeId) && Intrinsics.areEqual((Object) this.parameterId, (Object) rFGChallengeParameter.parameterId) && Intrinsics.areEqual((Object) this.point, (Object) rFGChallengeParameter.point) && Intrinsics.areEqual((Object) this.lat, (Object) rFGChallengeParameter.lat) && Intrinsics.areEqual((Object) this.lon, (Object) rFGChallengeParameter.lon) && Intrinsics.areEqual((Object) this.iconType, (Object) rFGChallengeParameter.iconType) && Intrinsics.areEqual((Object) this.name, (Object) rFGChallengeParameter.name);
    }

    public final String getChallengeId() {
        return this.challengeId;
    }

    public final String getIconType() {
        return this.iconType;
    }

    public final String getLat() {
        return this.lat;
    }

    public final String getLon() {
        return this.lon;
    }

    public final String getName() {
        return this.name;
    }

    public final String getParameterId() {
        return this.parameterId;
    }

    public final String getPoint() {
        return this.point;
    }

    public int hashCode() {
        String str = this.challengeId;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.parameterId;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.point;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.lat;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.lon;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.iconType;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.name;
        if (str7 != null) {
            i = str7.hashCode();
        }
        return hashCode6 + i;
    }

    public final LatLng latlng() {
        return new LatLng(Double.parseDouble(this.lat), Double.parseDouble(this.lon));
    }

    public final void setChallengeId(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.challengeId = str;
    }

    public final void setIconType(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.iconType = str;
    }

    public final void setLat(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.lat = str;
    }

    public final void setLon(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.lon = str;
    }

    public final void setName(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.name = str;
    }

    public final void setParameterId(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.parameterId = str;
    }

    public final void setPoint(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.point = str;
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("RFGChallengeParameter(challengeId=");
        a.append(this.challengeId);
        a.append(", parameterId=");
        a.append(this.parameterId);
        a.append(", point=");
        a.append(this.point);
        a.append(", lat=");
        a.append(this.lat);
        a.append(", lon=");
        a.append(this.lon);
        a.append(", iconType=");
        a.append(this.iconType);
        a.append(", name=");
        return C0681a.m324a(a, this.name, ")");
    }
}
