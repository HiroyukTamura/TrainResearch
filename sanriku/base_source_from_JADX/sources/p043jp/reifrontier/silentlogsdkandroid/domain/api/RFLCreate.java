package p043jp.reifrontier.silentlogsdkandroid.domain.api;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J]\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\u0005HÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000eR\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000e¨\u0006%"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/domain/api/RFLCreate;", "", "token", "", "expiresIn", "", "tokenType", "scope", "refreshToken", "userId", "error", "message", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getError", "()Ljava/lang/String;", "getExpiresIn", "()I", "getMessage", "getRefreshToken", "getScope", "getToken", "getTokenType", "getUserId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "toString", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.api.RFLCreate */
public final class RFLCreate {
    @SerializedName("access_token")

    /* renamed from: a */
    private final String f3463a;
    @SerializedName("expires_in")

    /* renamed from: b */
    private final int f3464b;
    @SerializedName("token_type")

    /* renamed from: c */
    private final String f3465c;
    @SerializedName("scope")

    /* renamed from: d */
    private final String f3466d;
    @SerializedName("refresh_token")

    /* renamed from: e */
    private final String f3467e;
    @SerializedName("user_id")

    /* renamed from: f */
    private final String f3468f;
    @SerializedName("error")

    /* renamed from: g */
    private final String f3469g;
    @SerializedName("message")

    /* renamed from: h */
    private final String f3470h;

    public RFLCreate(String str, int i, String str2, String str3, String str4, String str5, String str6, String str7) {
        Intrinsics.checkParameterIsNotNull(str, "token");
        Intrinsics.checkParameterIsNotNull(str2, "tokenType");
        Intrinsics.checkParameterIsNotNull(str3, "scope");
        Intrinsics.checkParameterIsNotNull(str4, "refreshToken");
        Intrinsics.checkParameterIsNotNull(str5, "userId");
        this.f3463a = str;
        this.f3464b = i;
        this.f3465c = str2;
        this.f3466d = str3;
        this.f3467e = str4;
        this.f3468f = str5;
        this.f3469g = str6;
        this.f3470h = str7;
    }

    public static /* synthetic */ RFLCreate copy$default(RFLCreate rFLCreate, String str, int i, String str2, String str3, String str4, String str5, String str6, String str7, int i2, Object obj) {
        RFLCreate rFLCreate2 = rFLCreate;
        int i3 = i2;
        return rFLCreate.copy((i3 & 1) != 0 ? rFLCreate2.f3463a : str, (i3 & 2) != 0 ? rFLCreate2.f3464b : i, (i3 & 4) != 0 ? rFLCreate2.f3465c : str2, (i3 & 8) != 0 ? rFLCreate2.f3466d : str3, (i3 & 16) != 0 ? rFLCreate2.f3467e : str4, (i3 & 32) != 0 ? rFLCreate2.f3468f : str5, (i3 & 64) != 0 ? rFLCreate2.f3469g : str6, (i3 & 128) != 0 ? rFLCreate2.f3470h : str7);
    }

    public final String component1() {
        return this.f3463a;
    }

    public final int component2() {
        return this.f3464b;
    }

    public final String component3() {
        return this.f3465c;
    }

    public final String component4() {
        return this.f3466d;
    }

    public final String component5() {
        return this.f3467e;
    }

    public final String component6() {
        return this.f3468f;
    }

    public final String component7() {
        return this.f3469g;
    }

    public final String component8() {
        return this.f3470h;
    }

    public final RFLCreate copy(String str, int i, String str2, String str3, String str4, String str5, String str6, String str7) {
        Intrinsics.checkParameterIsNotNull(str, "token");
        Intrinsics.checkParameterIsNotNull(str2, "tokenType");
        Intrinsics.checkParameterIsNotNull(str3, "scope");
        Intrinsics.checkParameterIsNotNull(str4, "refreshToken");
        String str8 = str5;
        Intrinsics.checkParameterIsNotNull(str8, "userId");
        return new RFLCreate(str, i, str2, str3, str4, str8, str6, str7);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RFLCreate)) {
            return false;
        }
        RFLCreate rFLCreate = (RFLCreate) obj;
        return Intrinsics.areEqual((Object) this.f3463a, (Object) rFLCreate.f3463a) && this.f3464b == rFLCreate.f3464b && Intrinsics.areEqual((Object) this.f3465c, (Object) rFLCreate.f3465c) && Intrinsics.areEqual((Object) this.f3466d, (Object) rFLCreate.f3466d) && Intrinsics.areEqual((Object) this.f3467e, (Object) rFLCreate.f3467e) && Intrinsics.areEqual((Object) this.f3468f, (Object) rFLCreate.f3468f) && Intrinsics.areEqual((Object) this.f3469g, (Object) rFLCreate.f3469g) && Intrinsics.areEqual((Object) this.f3470h, (Object) rFLCreate.f3470h);
    }

    public final String getError() {
        return this.f3469g;
    }

    public final int getExpiresIn() {
        return this.f3464b;
    }

    public final String getMessage() {
        return this.f3470h;
    }

    public final String getRefreshToken() {
        return this.f3467e;
    }

    public final String getScope() {
        return this.f3466d;
    }

    public final String getToken() {
        return this.f3463a;
    }

    public final String getTokenType() {
        return this.f3465c;
    }

    public final String getUserId() {
        return this.f3468f;
    }

    public int hashCode() {
        String str = this.f3463a;
        int i = 0;
        int hashCode = (((str != null ? str.hashCode() : 0) * 31) + this.f3464b) * 31;
        String str2 = this.f3465c;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f3466d;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.f3467e;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.f3468f;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.f3469g;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.f3470h;
        if (str7 != null) {
            i = str7.hashCode();
        }
        return hashCode6 + i;
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("RFLCreate(token=");
        a.append(this.f3463a);
        a.append(", expiresIn=");
        a.append(this.f3464b);
        a.append(", tokenType=");
        a.append(this.f3465c);
        a.append(", scope=");
        a.append(this.f3466d);
        a.append(", refreshToken=");
        a.append(this.f3467e);
        a.append(", userId=");
        a.append(this.f3468f);
        a.append(", error=");
        a.append(this.f3469g);
        a.append(", message=");
        return C0681a.m324a(a, this.f3470h, ")");
    }
}
