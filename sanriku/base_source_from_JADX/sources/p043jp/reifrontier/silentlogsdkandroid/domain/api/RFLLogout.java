package p043jp.reifrontier.silentlogsdkandroid.domain.api;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/domain/api/RFLLogout;", "", "error", "", "errorDescription", "success", "", "(Ljava/lang/String;Ljava/lang/String;Z)V", "getError", "()Ljava/lang/String;", "getErrorDescription", "getSuccess", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.api.RFLLogout */
public final class RFLLogout {
    @SerializedName("error")

    /* renamed from: a */
    private final String f3474a;
    @SerializedName("error_description")

    /* renamed from: b */
    private final String f3475b;
    @SerializedName("success")

    /* renamed from: c */
    private final boolean f3476c;

    public RFLLogout(String str, String str2, boolean z) {
        Intrinsics.checkParameterIsNotNull(str, "error");
        Intrinsics.checkParameterIsNotNull(str2, "errorDescription");
        this.f3474a = str;
        this.f3475b = str2;
        this.f3476c = z;
    }

    public static /* synthetic */ RFLLogout copy$default(RFLLogout rFLLogout, String str, String str2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = rFLLogout.f3474a;
        }
        if ((i & 2) != 0) {
            str2 = rFLLogout.f3475b;
        }
        if ((i & 4) != 0) {
            z = rFLLogout.f3476c;
        }
        return rFLLogout.copy(str, str2, z);
    }

    public final String component1() {
        return this.f3474a;
    }

    public final String component2() {
        return this.f3475b;
    }

    public final boolean component3() {
        return this.f3476c;
    }

    public final RFLLogout copy(String str, String str2, boolean z) {
        Intrinsics.checkParameterIsNotNull(str, "error");
        Intrinsics.checkParameterIsNotNull(str2, "errorDescription");
        return new RFLLogout(str, str2, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RFLLogout)) {
            return false;
        }
        RFLLogout rFLLogout = (RFLLogout) obj;
        return Intrinsics.areEqual((Object) this.f3474a, (Object) rFLLogout.f3474a) && Intrinsics.areEqual((Object) this.f3475b, (Object) rFLLogout.f3475b) && this.f3476c == rFLLogout.f3476c;
    }

    public final String getError() {
        return this.f3474a;
    }

    public final String getErrorDescription() {
        return this.f3475b;
    }

    public final boolean getSuccess() {
        return this.f3476c;
    }

    public int hashCode() {
        String str = this.f3474a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f3475b;
        if (str2 != null) {
            i = str2.hashCode();
        }
        int i2 = (hashCode + i) * 31;
        boolean z = this.f3476c;
        if (z) {
            z = true;
        }
        return i2 + (z ? 1 : 0);
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("RFLLogout(error=");
        a.append(this.f3474a);
        a.append(", errorDescription=");
        a.append(this.f3475b);
        a.append(", success=");
        a.append(this.f3476c);
        a.append(")");
        return a.toString();
    }
}
