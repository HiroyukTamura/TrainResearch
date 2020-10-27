package p043jp.reifrontier.gym.domain.api;

import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.ads.formats.UnifiedNativeAdAssetNames;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\rHÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003Jo\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020*HÖ\u0001J\u0006\u0010+\u001a\u00020'J\u0006\u0010,\u001a\u00020\u0003J\u0006\u0010-\u001a\u00020\u0003J\u0006\u0010.\u001a\u00020/J\t\u00100\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0016\u0010\u000b\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0018\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0010¨\u00061"}, mo21739d2 = {"Ljp/reifrontier/gym/domain/api/RFGPoint;", "", "pointId", "", "challengeId", "acquisitionPoint", "consumptionPoint", "valid", "pointTypeId", "createdAt", "updatedAt", "expireAt", "ratio", "Ljp/reifrontier/gym/domain/api/RFGPointRatio;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljp/reifrontier/gym/domain/api/RFGPointRatio;)V", "getAcquisitionPoint", "()Ljava/lang/String;", "getChallengeId", "getConsumptionPoint", "getCreatedAt", "getExpireAt", "getPointId", "getPointTypeId", "getRatio", "()Ljp/reifrontier/gym/domain/api/RFGPointRatio;", "getUpdatedAt", "getValid", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "isUsePoint", "nameForType", "point", "pointValue", "", "toString", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.domain.api.RFGPoint */
public final class RFGPoint {
    @SerializedName("acquisition_point")
    private final String acquisitionPoint;
    @SerializedName("challenge_id")
    private final String challengeId;
    @SerializedName("consumption_point")
    private final String consumptionPoint;
    @SerializedName("created_at")
    private final String createdAt;
    @SerializedName("expire_date")
    private final String expireAt;
    @SerializedName("id")
    private final String pointId;
    @SerializedName("pointtype_id")
    private final String pointTypeId;
    @SerializedName("ratio_mets")
    private final RFGPointRatio ratio;
    @SerializedName("updated_at")
    private final String updatedAt;
    @SerializedName("valid_flag")
    private final String valid;

    public RFGPoint(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, RFGPointRatio rFGPointRatio) {
        Intrinsics.checkParameterIsNotNull(str, "pointId");
        Intrinsics.checkParameterIsNotNull(str2, "challengeId");
        Intrinsics.checkParameterIsNotNull(str3, "acquisitionPoint");
        Intrinsics.checkParameterIsNotNull(str4, "consumptionPoint");
        Intrinsics.checkParameterIsNotNull(str5, "valid");
        Intrinsics.checkParameterIsNotNull(str6, "pointTypeId");
        Intrinsics.checkParameterIsNotNull(str7, "createdAt");
        Intrinsics.checkParameterIsNotNull(str8, "updatedAt");
        Intrinsics.checkParameterIsNotNull(str9, "expireAt");
        this.pointId = str;
        this.challengeId = str2;
        this.acquisitionPoint = str3;
        this.consumptionPoint = str4;
        this.valid = str5;
        this.pointTypeId = str6;
        this.createdAt = str7;
        this.updatedAt = str8;
        this.expireAt = str9;
        this.ratio = rFGPointRatio;
    }

    public static /* synthetic */ RFGPoint copy$default(RFGPoint rFGPoint, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, RFGPointRatio rFGPointRatio, int i, Object obj) {
        RFGPoint rFGPoint2 = rFGPoint;
        int i2 = i;
        return rFGPoint.copy((i2 & 1) != 0 ? rFGPoint2.pointId : str, (i2 & 2) != 0 ? rFGPoint2.challengeId : str2, (i2 & 4) != 0 ? rFGPoint2.acquisitionPoint : str3, (i2 & 8) != 0 ? rFGPoint2.consumptionPoint : str4, (i2 & 16) != 0 ? rFGPoint2.valid : str5, (i2 & 32) != 0 ? rFGPoint2.pointTypeId : str6, (i2 & 64) != 0 ? rFGPoint2.createdAt : str7, (i2 & 128) != 0 ? rFGPoint2.updatedAt : str8, (i2 & 256) != 0 ? rFGPoint2.expireAt : str9, (i2 & 512) != 0 ? rFGPoint2.ratio : rFGPointRatio);
    }

    public final String component1() {
        return this.pointId;
    }

    public final RFGPointRatio component10() {
        return this.ratio;
    }

    public final String component2() {
        return this.challengeId;
    }

    public final String component3() {
        return this.acquisitionPoint;
    }

    public final String component4() {
        return this.consumptionPoint;
    }

    public final String component5() {
        return this.valid;
    }

    public final String component6() {
        return this.pointTypeId;
    }

    public final String component7() {
        return this.createdAt;
    }

    public final String component8() {
        return this.updatedAt;
    }

    public final String component9() {
        return this.expireAt;
    }

    public final RFGPoint copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, RFGPointRatio rFGPointRatio) {
        Intrinsics.checkParameterIsNotNull(str, "pointId");
        Intrinsics.checkParameterIsNotNull(str2, "challengeId");
        Intrinsics.checkParameterIsNotNull(str3, "acquisitionPoint");
        String str10 = str4;
        Intrinsics.checkParameterIsNotNull(str10, "consumptionPoint");
        String str11 = str5;
        Intrinsics.checkParameterIsNotNull(str11, "valid");
        String str12 = str6;
        Intrinsics.checkParameterIsNotNull(str12, "pointTypeId");
        String str13 = str7;
        Intrinsics.checkParameterIsNotNull(str13, "createdAt");
        String str14 = str8;
        Intrinsics.checkParameterIsNotNull(str14, "updatedAt");
        String str15 = str9;
        Intrinsics.checkParameterIsNotNull(str15, "expireAt");
        return new RFGPoint(str, str2, str3, str10, str11, str12, str13, str14, str15, rFGPointRatio);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RFGPoint)) {
            return false;
        }
        RFGPoint rFGPoint = (RFGPoint) obj;
        return Intrinsics.areEqual((Object) this.pointId, (Object) rFGPoint.pointId) && Intrinsics.areEqual((Object) this.challengeId, (Object) rFGPoint.challengeId) && Intrinsics.areEqual((Object) this.acquisitionPoint, (Object) rFGPoint.acquisitionPoint) && Intrinsics.areEqual((Object) this.consumptionPoint, (Object) rFGPoint.consumptionPoint) && Intrinsics.areEqual((Object) this.valid, (Object) rFGPoint.valid) && Intrinsics.areEqual((Object) this.pointTypeId, (Object) rFGPoint.pointTypeId) && Intrinsics.areEqual((Object) this.createdAt, (Object) rFGPoint.createdAt) && Intrinsics.areEqual((Object) this.updatedAt, (Object) rFGPoint.updatedAt) && Intrinsics.areEqual((Object) this.expireAt, (Object) rFGPoint.expireAt) && Intrinsics.areEqual((Object) this.ratio, (Object) rFGPoint.ratio);
    }

    public final String getAcquisitionPoint() {
        return this.acquisitionPoint;
    }

    public final String getChallengeId() {
        return this.challengeId;
    }

    public final String getConsumptionPoint() {
        return this.consumptionPoint;
    }

    public final String getCreatedAt() {
        return this.createdAt;
    }

    public final String getExpireAt() {
        return this.expireAt;
    }

    public final String getPointId() {
        return this.pointId;
    }

    public final String getPointTypeId() {
        return this.pointTypeId;
    }

    public final RFGPointRatio getRatio() {
        return this.ratio;
    }

    public final String getUpdatedAt() {
        return this.updatedAt;
    }

    public final String getValid() {
        return this.valid;
    }

    public int hashCode() {
        String str = this.pointId;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.challengeId;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.acquisitionPoint;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.consumptionPoint;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.valid;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.pointTypeId;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.createdAt;
        int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.updatedAt;
        int hashCode8 = (hashCode7 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.expireAt;
        int hashCode9 = (hashCode8 + (str9 != null ? str9.hashCode() : 0)) * 31;
        RFGPointRatio rFGPointRatio = this.ratio;
        if (rFGPointRatio != null) {
            i = rFGPointRatio.hashCode();
        }
        return hashCode9 + i;
    }

    public final boolean isUsePoint() {
        return this.acquisitionPoint.length() == 0;
    }

    public final String nameForType() {
        String str = this.pointTypeId;
        int hashCode = str.hashCode();
        if (hashCode != 1568) {
            if (hashCode != 1570) {
                if (hashCode != 49587) {
                    if (hashCode != 1567006) {
                        if (hashCode != 1572) {
                            if (hashCode != 1573) {
                                switch (hashCode) {
                                    case 49:
                                        if (str.equals("1")) {
                                            return "1日の活動量の達成度";
                                        }
                                        break;
                                    case 50:
                                        if (str.equals(ExifInterface.GPS_MEASUREMENT_2D)) {
                                            return "中強度運動の達成度";
                                        }
                                        break;
                                    case 51:
                                        if (str.equals(ExifInterface.GPS_MEASUREMENT_3D)) {
                                            return "目標歩数の達成度";
                                        }
                                        break;
                                    case 52:
                                        if (str.equals("4")) {
                                            return "3.5METs-h/日を達成";
                                        }
                                        break;
                                    case 53:
                                        if (str.equals("5")) {
                                            return "中強度運動30分を達成";
                                        }
                                        break;
                                    case 54:
                                        if (str.equals("6")) {
                                            return "8000歩を達成";
                                        }
                                        break;
                                    case 55:
                                        if (str.equals("7")) {
                                            return "連続30分以上の運動達成";
                                        }
                                        break;
                                    case 56:
                                        if (str.equals("8")) {
                                            return "個人目標を達成";
                                        }
                                        break;
                                    case 57:
                                        if (str.equals("9")) {
                                            return "体重の更新";
                                        }
                                        break;
                                    default:
                                        switch (hashCode) {
                                            case 56313:
                                                if (str.equals("900")) {
                                                    return "ボーナスポイント";
                                                }
                                                break;
                                            case 56314:
                                                if (str.equals("901")) {
                                                    return "アンケート回答ポイント";
                                                }
                                                break;
                                            default:
                                                switch (hashCode) {
                                                    case 1507459:
                                                        if (str.equals("1015")) {
                                                            return "10分の散歩";
                                                        }
                                                        break;
                                                    case 1507460:
                                                        if (str.equals("1016")) {
                                                            return "10分の散歩";
                                                        }
                                                        break;
                                                    case 1507461:
                                                        if (str.equals("1017")) {
                                                            return "自転車";
                                                        }
                                                        break;
                                                    default:
                                                        switch (hashCode) {
                                                            case 1567036:
                                                                if (str.equals(UnifiedNativeAdAssetNames.ASSET_MEDIA_VIDEO)) {
                                                                    return "ログインボーナス";
                                                                }
                                                                break;
                                                            case 1567037:
                                                                if (str.equals(UnifiedNativeAdAssetNames.ASSET_ADCHOICES_CONTAINER_VIEW)) {
                                                                    return "さんてつ乗車回数ポイント";
                                                                }
                                                                break;
                                                            case 1567038:
                                                                if (str.equals("3012")) {
                                                                    return "さんてつ乗車距離ポイント";
                                                                }
                                                                break;
                                                        }
                                                }
                                        }
                                }
                            } else if (str.equals("16")) {
                                return "健康診断受診を申告";
                            }
                        } else if (str.equals("15")) {
                            return "会員登録を完了";
                        }
                    } else if (str.equals(UnifiedNativeAdAssetNames.ASSET_HEADLINE)) {
                        return "さんてつ乗車ポイント";
                    }
                } else if (str.equals("201")) {
                    return "ウォークラリー特別ポイント";
                }
            } else if (str.equals("13")) {
                return "BMI維持を達成";
            }
        } else if (str.equals("11")) {
            return "1週間の目標活動量を達成";
        }
        return C0681a.m323a(C0681a.m330a("その他（"), this.pointTypeId, 65289);
    }

    public final String point() {
        return this.acquisitionPoint.length() == 0 ? this.consumptionPoint : this.acquisitionPoint;
    }

    public final float pointValue() {
        return Float.parseFloat(this.acquisitionPoint);
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("RFGPoint(pointId=");
        a.append(this.pointId);
        a.append(", challengeId=");
        a.append(this.challengeId);
        a.append(", acquisitionPoint=");
        a.append(this.acquisitionPoint);
        a.append(", consumptionPoint=");
        a.append(this.consumptionPoint);
        a.append(", valid=");
        a.append(this.valid);
        a.append(", pointTypeId=");
        a.append(this.pointTypeId);
        a.append(", createdAt=");
        a.append(this.createdAt);
        a.append(", updatedAt=");
        a.append(this.updatedAt);
        a.append(", expireAt=");
        a.append(this.expireAt);
        a.append(", ratio=");
        a.append(this.ratio);
        a.append(")");
        return a.toString();
    }
}
