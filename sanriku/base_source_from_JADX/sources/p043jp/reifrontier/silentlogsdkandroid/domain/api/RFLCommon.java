package p043jp.reifrontier.silentlogsdkandroid.domain.api;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007R\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u0015"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/domain/api/RFLCommon;", "", "result", "", "message", "(Ljava/lang/String;Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "getResult", "success", "", "getSuccess", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.api.RFLCommon */
public final class RFLCommon {
    @SerializedName("result")

    /* renamed from: a */
    private final String f3461a;
    @SerializedName("message")

    /* renamed from: b */
    private final String f3462b;

    public RFLCommon(String str, String str2) {
        Intrinsics.checkParameterIsNotNull(str, "result");
        this.f3461a = str;
        this.f3462b = str2;
    }

    public static /* synthetic */ RFLCommon copy$default(RFLCommon rFLCommon, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = rFLCommon.f3461a;
        }
        if ((i & 2) != 0) {
            str2 = rFLCommon.f3462b;
        }
        return rFLCommon.copy(str, str2);
    }

    public final String component1() {
        return this.f3461a;
    }

    public final String component2() {
        return this.f3462b;
    }

    public final RFLCommon copy(String str, String str2) {
        Intrinsics.checkParameterIsNotNull(str, "result");
        return new RFLCommon(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RFLCommon)) {
            return false;
        }
        RFLCommon rFLCommon = (RFLCommon) obj;
        return Intrinsics.areEqual((Object) this.f3461a, (Object) rFLCommon.f3461a) && Intrinsics.areEqual((Object) this.f3462b, (Object) rFLCommon.f3462b);
    }

    public final String getMessage() {
        return this.f3462b;
    }

    public final String getResult() {
        return this.f3461a;
    }

    public final boolean getSuccess() {
        return Intrinsics.areEqual((Object) this.f3461a, (Object) FirebaseAnalytics.Param.SUCCESS);
    }

    public int hashCode() {
        String str = this.f3461a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f3462b;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("RFLCommon(result=");
        a.append(this.f3461a);
        a.append(", message=");
        return C0681a.m324a(a, this.f3462b, ")");
    }
}
