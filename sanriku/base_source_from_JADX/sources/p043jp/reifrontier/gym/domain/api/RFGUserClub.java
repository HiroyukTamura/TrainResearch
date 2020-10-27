package p043jp.reifrontier.gym.domain.api;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;
import p043jp.reifrontier.gym.RFGDef;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B+\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J1\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001f"}, mo21739d2 = {"Ljp/reifrontier/gym/domain/api/RFGUserClub;", "", "clubId", "", "clubName", "clubIcon", "updateTime", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getClubIcon", "()Ljava/lang/String;", "setClubIcon", "(Ljava/lang/String;)V", "getClubId", "setClubId", "getClubName", "setClubName", "getUpdateTime", "()I", "setUpdateTime", "(I)V", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.domain.api.RFGUserClub */
public final class RFGUserClub {
    @SerializedName("club_icon")
    private String clubIcon;
    @SerializedName("club_id")
    private String clubId;
    @SerializedName("club_name")
    private String clubName;
    @SerializedName("update_time")
    private int updateTime;

    public RFGUserClub(String str, String str2, String str3, int i) {
        Intrinsics.checkParameterIsNotNull(str, "clubId");
        Intrinsics.checkParameterIsNotNull(str2, "clubName");
        Intrinsics.checkParameterIsNotNull(str3, "clubIcon");
        this.clubId = str;
        this.clubName = str2;
        this.clubIcon = str3;
        this.updateTime = i;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RFGUserClub(String str, String str2, String str3, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? RFGDef.DEFAULT_GYM_ID : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3, i);
    }

    public static /* synthetic */ RFGUserClub copy$default(RFGUserClub rFGUserClub, String str, String str2, String str3, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = rFGUserClub.clubId;
        }
        if ((i2 & 2) != 0) {
            str2 = rFGUserClub.clubName;
        }
        if ((i2 & 4) != 0) {
            str3 = rFGUserClub.clubIcon;
        }
        if ((i2 & 8) != 0) {
            i = rFGUserClub.updateTime;
        }
        return rFGUserClub.copy(str, str2, str3, i);
    }

    public final String component1() {
        return this.clubId;
    }

    public final String component2() {
        return this.clubName;
    }

    public final String component3() {
        return this.clubIcon;
    }

    public final int component4() {
        return this.updateTime;
    }

    public final RFGUserClub copy(String str, String str2, String str3, int i) {
        Intrinsics.checkParameterIsNotNull(str, "clubId");
        Intrinsics.checkParameterIsNotNull(str2, "clubName");
        Intrinsics.checkParameterIsNotNull(str3, "clubIcon");
        return new RFGUserClub(str, str2, str3, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RFGUserClub)) {
            return false;
        }
        RFGUserClub rFGUserClub = (RFGUserClub) obj;
        return Intrinsics.areEqual((Object) this.clubId, (Object) rFGUserClub.clubId) && Intrinsics.areEqual((Object) this.clubName, (Object) rFGUserClub.clubName) && Intrinsics.areEqual((Object) this.clubIcon, (Object) rFGUserClub.clubIcon) && this.updateTime == rFGUserClub.updateTime;
    }

    public final String getClubIcon() {
        return this.clubIcon;
    }

    public final String getClubId() {
        return this.clubId;
    }

    public final String getClubName() {
        return this.clubName;
    }

    public final int getUpdateTime() {
        return this.updateTime;
    }

    public int hashCode() {
        String str = this.clubId;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.clubName;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.clubIcon;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return ((hashCode2 + i) * 31) + this.updateTime;
    }

    public final void setClubIcon(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.clubIcon = str;
    }

    public final void setClubId(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.clubId = str;
    }

    public final void setClubName(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.clubName = str;
    }

    public final void setUpdateTime(int i) {
        this.updateTime = i;
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("RFGUserClub(clubId=");
        a.append(this.clubId);
        a.append(", clubName=");
        a.append(this.clubName);
        a.append(", clubIcon=");
        a.append(this.clubIcon);
        a.append(", updateTime=");
        return C0681a.m322a(a, this.updateTime, ")");
    }
}
