package p043jp.reifrontier.gym.domain.api;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J;\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\u001e\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR\u001e\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\n\"\u0004\b\u0014\u0010\f¨\u0006!"}, mo21739d2 = {"Ljp/reifrontier/gym/domain/api/RFGUserChallenge;", "", "challengeId", "", "challengeAppId", "challengeName", "challengeStatusId", "challengeValid", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getChallengeAppId", "()Ljava/lang/String;", "setChallengeAppId", "(Ljava/lang/String;)V", "getChallengeId", "setChallengeId", "getChallengeName", "setChallengeName", "getChallengeStatusId", "setChallengeStatusId", "getChallengeValid", "setChallengeValid", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.domain.api.RFGUserChallenge */
public final class RFGUserChallenge {
    @SerializedName("challenges_app_id")
    private String challengeAppId;
    @SerializedName("challenges_id")
    private String challengeId;
    @SerializedName("challenges_challenge_name")
    private String challengeName;
    @SerializedName("challenges_challenge_status_id")
    private String challengeStatusId;
    @SerializedName("challenges_valid_flag")
    private String challengeValid;

    public RFGUserChallenge() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, 31, (DefaultConstructorMarker) null);
    }

    public RFGUserChallenge(String str, String str2, String str3, String str4, String str5) {
        Intrinsics.checkParameterIsNotNull(str, "challengeId");
        Intrinsics.checkParameterIsNotNull(str2, "challengeAppId");
        Intrinsics.checkParameterIsNotNull(str3, "challengeName");
        Intrinsics.checkParameterIsNotNull(str4, "challengeStatusId");
        Intrinsics.checkParameterIsNotNull(str5, "challengeValid");
        this.challengeId = str;
        this.challengeAppId = str2;
        this.challengeName = str3;
        this.challengeStatusId = str4;
        this.challengeValid = str5;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ RFGUserChallenge(java.lang.String r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, int r10, kotlin.jvm.internal.DefaultConstructorMarker r11) {
        /*
            r4 = this;
            r11 = r10 & 1
            java.lang.String r0 = "0"
            if (r11 == 0) goto L_0x0008
            r11 = r0
            goto L_0x0009
        L_0x0008:
            r11 = r5
        L_0x0009:
            r5 = r10 & 2
            if (r5 == 0) goto L_0x000f
            r1 = r0
            goto L_0x0010
        L_0x000f:
            r1 = r6
        L_0x0010:
            r5 = r10 & 4
            if (r5 == 0) goto L_0x0016
            r2 = r0
            goto L_0x0017
        L_0x0016:
            r2 = r7
        L_0x0017:
            r5 = r10 & 8
            if (r5 == 0) goto L_0x001d
            r3 = r0
            goto L_0x001e
        L_0x001d:
            r3 = r8
        L_0x001e:
            r5 = r10 & 16
            if (r5 == 0) goto L_0x0024
            r10 = r0
            goto L_0x0025
        L_0x0024:
            r10 = r9
        L_0x0025:
            r5 = r4
            r6 = r11
            r7 = r1
            r8 = r2
            r9 = r3
            r5.<init>(r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p043jp.reifrontier.gym.domain.api.RFGUserChallenge.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public static /* synthetic */ RFGUserChallenge copy$default(RFGUserChallenge rFGUserChallenge, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = rFGUserChallenge.challengeId;
        }
        if ((i & 2) != 0) {
            str2 = rFGUserChallenge.challengeAppId;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = rFGUserChallenge.challengeName;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = rFGUserChallenge.challengeStatusId;
        }
        String str8 = str4;
        if ((i & 16) != 0) {
            str5 = rFGUserChallenge.challengeValid;
        }
        return rFGUserChallenge.copy(str, str6, str7, str8, str5);
    }

    public final String component1() {
        return this.challengeId;
    }

    public final String component2() {
        return this.challengeAppId;
    }

    public final String component3() {
        return this.challengeName;
    }

    public final String component4() {
        return this.challengeStatusId;
    }

    public final String component5() {
        return this.challengeValid;
    }

    public final RFGUserChallenge copy(String str, String str2, String str3, String str4, String str5) {
        Intrinsics.checkParameterIsNotNull(str, "challengeId");
        Intrinsics.checkParameterIsNotNull(str2, "challengeAppId");
        Intrinsics.checkParameterIsNotNull(str3, "challengeName");
        Intrinsics.checkParameterIsNotNull(str4, "challengeStatusId");
        Intrinsics.checkParameterIsNotNull(str5, "challengeValid");
        return new RFGUserChallenge(str, str2, str3, str4, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RFGUserChallenge)) {
            return false;
        }
        RFGUserChallenge rFGUserChallenge = (RFGUserChallenge) obj;
        return Intrinsics.areEqual((Object) this.challengeId, (Object) rFGUserChallenge.challengeId) && Intrinsics.areEqual((Object) this.challengeAppId, (Object) rFGUserChallenge.challengeAppId) && Intrinsics.areEqual((Object) this.challengeName, (Object) rFGUserChallenge.challengeName) && Intrinsics.areEqual((Object) this.challengeStatusId, (Object) rFGUserChallenge.challengeStatusId) && Intrinsics.areEqual((Object) this.challengeValid, (Object) rFGUserChallenge.challengeValid);
    }

    public final String getChallengeAppId() {
        return this.challengeAppId;
    }

    public final String getChallengeId() {
        return this.challengeId;
    }

    public final String getChallengeName() {
        return this.challengeName;
    }

    public final String getChallengeStatusId() {
        return this.challengeStatusId;
    }

    public final String getChallengeValid() {
        return this.challengeValid;
    }

    public int hashCode() {
        String str = this.challengeId;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.challengeAppId;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.challengeName;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.challengeStatusId;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.challengeValid;
        if (str5 != null) {
            i = str5.hashCode();
        }
        return hashCode4 + i;
    }

    public final void setChallengeAppId(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.challengeAppId = str;
    }

    public final void setChallengeId(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.challengeId = str;
    }

    public final void setChallengeName(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.challengeName = str;
    }

    public final void setChallengeStatusId(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.challengeStatusId = str;
    }

    public final void setChallengeValid(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.challengeValid = str;
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("RFGUserChallenge(challengeId=");
        a.append(this.challengeId);
        a.append(", challengeAppId=");
        a.append(this.challengeAppId);
        a.append(", challengeName=");
        a.append(this.challengeName);
        a.append(", challengeStatusId=");
        a.append(this.challengeStatusId);
        a.append(", challengeValid=");
        return C0681a.m324a(a, this.challengeValid, ")");
    }
}
