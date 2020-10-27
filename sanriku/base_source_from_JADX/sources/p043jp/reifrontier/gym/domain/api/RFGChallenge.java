package p043jp.reifrontier.gym.domain.api;

import com.google.gson.annotations.SerializedName;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;
import p043jp.reifrontier.gym.RFGDef;
import p043jp.reifrontier.gym.util.RFGUtilsKt;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\b\u0018\u00002\u00020\u0001Bg\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\u0011\u0010+\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jm\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00101\u001a\u000202HÖ\u0001J\u0006\u00103\u001a\u00020\u0003J\t\u00104\u001a\u00020\u0003HÖ\u0001J\f\u00105\u001a\b\u0012\u0004\u0012\u00020\f0\u000bJ\u0006\u00106\u001a\u00020/R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0010\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0013R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0010\"\u0004\b\u0017\u0010\u0013R\u001e\u0010\b\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0010\"\u0004\b\u0019\u0010\u0013R\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0010\"\u0004\b\u001b\u0010\u0013R\u001e\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0010\"\u0004\b\u001d\u0010\u0013R \u0010\r\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0010\"\u0004\b\u001f\u0010\u0013R&\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u00067"}, mo21739d2 = {"Ljp/reifrontier/gym/domain/api/RFGChallenge;", "", "challengeId", "", "challengeName", "challengeDetail", "challengeStart", "challengeEnd", "challengeImage", "cTemplateId", "parameters", "", "Ljp/reifrontier/gym/domain/api/RFGChallengeParameter;", "challengeUrl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getCTemplateId", "()Ljava/lang/String;", "getChallengeDetail", "setChallengeDetail", "(Ljava/lang/String;)V", "getChallengeEnd", "setChallengeEnd", "getChallengeId", "setChallengeId", "getChallengeImage", "setChallengeImage", "getChallengeName", "setChallengeName", "getChallengeStart", "setChallengeStart", "getChallengeUrl", "setChallengeUrl", "getParameters", "()Ljava/util/List;", "setParameters", "(Ljava/util/List;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "timeText", "toString", "validParameters", "validTime", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.domain.api.RFGChallenge */
public final class RFGChallenge {
    @SerializedName("c_template_id")
    private final String cTemplateId;
    @SerializedName("challenge_detail")
    private String challengeDetail;
    @SerializedName("challenge_end")
    private String challengeEnd;
    @SerializedName("challenge_id")
    private String challengeId;
    @SerializedName("challenge_image")
    private String challengeImage;
    @SerializedName("challenge_name")
    private String challengeName;
    @SerializedName("challenge_start")
    private String challengeStart;
    @SerializedName("challenge_url")
    private String challengeUrl;
    @SerializedName("parameters")
    private List<RFGChallengeParameter> parameters;

    public RFGChallenge(String str, String str2, String str3, String str4, String str5, String str6, String str7, List<RFGChallengeParameter> list, String str8) {
        Intrinsics.checkParameterIsNotNull(str, "challengeId");
        Intrinsics.checkParameterIsNotNull(str2, "challengeName");
        Intrinsics.checkParameterIsNotNull(str3, "challengeDetail");
        Intrinsics.checkParameterIsNotNull(str4, "challengeStart");
        Intrinsics.checkParameterIsNotNull(str5, "challengeEnd");
        Intrinsics.checkParameterIsNotNull(str6, "challengeImage");
        Intrinsics.checkParameterIsNotNull(str7, "cTemplateId");
        this.challengeId = str;
        this.challengeName = str2;
        this.challengeDetail = str3;
        this.challengeStart = str4;
        this.challengeEnd = str5;
        this.challengeImage = str6;
        this.cTemplateId = str7;
        this.parameters = list;
        this.challengeUrl = str8;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ RFGChallenge(java.lang.String r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, java.util.List r21, java.lang.String r22, int r23, kotlin.jvm.internal.DefaultConstructorMarker r24) {
        /*
            r13 = this;
            r0 = r23
            r1 = r0 & 1
            java.lang.String r2 = "0"
            if (r1 == 0) goto L_0x000a
            r4 = r2
            goto L_0x000b
        L_0x000a:
            r4 = r14
        L_0x000b:
            r1 = r0 & 2
            if (r1 == 0) goto L_0x0011
            r5 = r2
            goto L_0x0012
        L_0x0011:
            r5 = r15
        L_0x0012:
            r1 = r0 & 4
            if (r1 == 0) goto L_0x0018
            r6 = r2
            goto L_0x001a
        L_0x0018:
            r6 = r16
        L_0x001a:
            r1 = r0 & 8
            java.lang.String r2 = ""
            if (r1 == 0) goto L_0x0022
            r7 = r2
            goto L_0x0024
        L_0x0022:
            r7 = r17
        L_0x0024:
            r1 = r0 & 16
            if (r1 == 0) goto L_0x002a
            r8 = r2
            goto L_0x002c
        L_0x002a:
            r8 = r18
        L_0x002c:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x0032
            r9 = r2
            goto L_0x0034
        L_0x0032:
            r9 = r19
        L_0x0034:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x003a
            r10 = r2
            goto L_0x003c
        L_0x003a:
            r10 = r20
        L_0x003c:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0042
            r12 = r2
            goto L_0x0044
        L_0x0042:
            r12 = r22
        L_0x0044:
            r3 = r13
            r11 = r21
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p043jp.reifrontier.gym.domain.api.RFGChallenge.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.List, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public static /* synthetic */ RFGChallenge copy$default(RFGChallenge rFGChallenge, String str, String str2, String str3, String str4, String str5, String str6, String str7, List list, String str8, int i, Object obj) {
        RFGChallenge rFGChallenge2 = rFGChallenge;
        int i2 = i;
        return rFGChallenge.copy((i2 & 1) != 0 ? rFGChallenge2.challengeId : str, (i2 & 2) != 0 ? rFGChallenge2.challengeName : str2, (i2 & 4) != 0 ? rFGChallenge2.challengeDetail : str3, (i2 & 8) != 0 ? rFGChallenge2.challengeStart : str4, (i2 & 16) != 0 ? rFGChallenge2.challengeEnd : str5, (i2 & 32) != 0 ? rFGChallenge2.challengeImage : str6, (i2 & 64) != 0 ? rFGChallenge2.cTemplateId : str7, (i2 & 128) != 0 ? rFGChallenge2.parameters : list, (i2 & 256) != 0 ? rFGChallenge2.challengeUrl : str8);
    }

    public final String component1() {
        return this.challengeId;
    }

    public final String component2() {
        return this.challengeName;
    }

    public final String component3() {
        return this.challengeDetail;
    }

    public final String component4() {
        return this.challengeStart;
    }

    public final String component5() {
        return this.challengeEnd;
    }

    public final String component6() {
        return this.challengeImage;
    }

    public final String component7() {
        return this.cTemplateId;
    }

    public final List<RFGChallengeParameter> component8() {
        return this.parameters;
    }

    public final String component9() {
        return this.challengeUrl;
    }

    public final RFGChallenge copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, List<RFGChallengeParameter> list, String str8) {
        Intrinsics.checkParameterIsNotNull(str, "challengeId");
        Intrinsics.checkParameterIsNotNull(str2, "challengeName");
        Intrinsics.checkParameterIsNotNull(str3, "challengeDetail");
        Intrinsics.checkParameterIsNotNull(str4, "challengeStart");
        String str9 = str5;
        Intrinsics.checkParameterIsNotNull(str9, "challengeEnd");
        String str10 = str6;
        Intrinsics.checkParameterIsNotNull(str10, "challengeImage");
        String str11 = str7;
        Intrinsics.checkParameterIsNotNull(str11, "cTemplateId");
        return new RFGChallenge(str, str2, str3, str4, str9, str10, str11, list, str8);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RFGChallenge)) {
            return false;
        }
        RFGChallenge rFGChallenge = (RFGChallenge) obj;
        return Intrinsics.areEqual((Object) this.challengeId, (Object) rFGChallenge.challengeId) && Intrinsics.areEqual((Object) this.challengeName, (Object) rFGChallenge.challengeName) && Intrinsics.areEqual((Object) this.challengeDetail, (Object) rFGChallenge.challengeDetail) && Intrinsics.areEqual((Object) this.challengeStart, (Object) rFGChallenge.challengeStart) && Intrinsics.areEqual((Object) this.challengeEnd, (Object) rFGChallenge.challengeEnd) && Intrinsics.areEqual((Object) this.challengeImage, (Object) rFGChallenge.challengeImage) && Intrinsics.areEqual((Object) this.cTemplateId, (Object) rFGChallenge.cTemplateId) && Intrinsics.areEqual((Object) this.parameters, (Object) rFGChallenge.parameters) && Intrinsics.areEqual((Object) this.challengeUrl, (Object) rFGChallenge.challengeUrl);
    }

    public final String getCTemplateId() {
        return this.cTemplateId;
    }

    public final String getChallengeDetail() {
        return this.challengeDetail;
    }

    public final String getChallengeEnd() {
        return this.challengeEnd;
    }

    public final String getChallengeId() {
        return this.challengeId;
    }

    public final String getChallengeImage() {
        return this.challengeImage;
    }

    public final String getChallengeName() {
        return this.challengeName;
    }

    public final String getChallengeStart() {
        return this.challengeStart;
    }

    public final String getChallengeUrl() {
        return this.challengeUrl;
    }

    public final List<RFGChallengeParameter> getParameters() {
        return this.parameters;
    }

    public int hashCode() {
        String str = this.challengeId;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.challengeName;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.challengeDetail;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.challengeStart;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.challengeEnd;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.challengeImage;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.cTemplateId;
        int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        List<RFGChallengeParameter> list = this.parameters;
        int hashCode8 = (hashCode7 + (list != null ? list.hashCode() : 0)) * 31;
        String str8 = this.challengeUrl;
        if (str8 != null) {
            i = str8.hashCode();
        }
        return hashCode8 + i;
    }

    public final void setChallengeDetail(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.challengeDetail = str;
    }

    public final void setChallengeEnd(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.challengeEnd = str;
    }

    public final void setChallengeId(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.challengeId = str;
    }

    public final void setChallengeImage(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.challengeImage = str;
    }

    public final void setChallengeName(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.challengeName = str;
    }

    public final void setChallengeStart(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.challengeStart = str;
    }

    public final void setChallengeUrl(String str) {
        this.challengeUrl = str;
    }

    public final void setParameters(List<RFGChallengeParameter> list) {
        this.parameters = list;
    }

    public final String timeText() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.JAPANESE);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        Date parse = simpleDateFormat.parse(this.challengeStart);
        Date parse2 = simpleDateFormat.parse(this.challengeEnd);
        Intrinsics.checkExpressionValueIsNotNull(parse, "start");
        Intrinsics.checkExpressionValueIsNotNull(parse2, "end");
        if (RFGUtilsKt.isSame(parse, parse2)) {
            StringBuilder a = C0681a.m330a("開催期間: ");
            a.append(RFGUtilsKt.formaaat11(parse, "yyyy年M月d日", "Asia/Tokyo"));
            return a.toString();
        }
        StringBuilder a2 = C0681a.m330a("開催期間: ");
        a2.append(RFGUtilsKt.formaaat11(parse, "yyyy年M月d日", "Asia/Tokyo"));
        a2.append(" - ");
        a2.append(RFGUtilsKt.formaaat11(parse2, "M月d日", "Asia/Tokyo"));
        return a2.toString();
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("RFGChallenge(challengeId=");
        a.append(this.challengeId);
        a.append(", challengeName=");
        a.append(this.challengeName);
        a.append(", challengeDetail=");
        a.append(this.challengeDetail);
        a.append(", challengeStart=");
        a.append(this.challengeStart);
        a.append(", challengeEnd=");
        a.append(this.challengeEnd);
        a.append(", challengeImage=");
        a.append(this.challengeImage);
        a.append(", cTemplateId=");
        a.append(this.cTemplateId);
        a.append(", parameters=");
        a.append(this.parameters);
        a.append(", challengeUrl=");
        return C0681a.m324a(a, this.challengeUrl, ")");
    }

    public final List<RFGChallengeParameter> validParameters() {
        ArrayList arrayList = new ArrayList();
        List<RFGChallengeParameter> list = this.parameters;
        if (list != null) {
            if (list == null) {
                Intrinsics.throwNpe();
            }
            for (RFGChallengeParameter next : list) {
                next.setChallengeId(this.challengeId);
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public final boolean validTime() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.JAPANESE);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        if (RangesKt__RangesKt.rangeTo(simpleDateFormat.parse(this.challengeStart), simpleDateFormat.parse(this.challengeEnd)).contains(new Date())) {
            return RFGDef.C2097T.INSTANCE.walkTime();
        }
        return false;
    }
}
