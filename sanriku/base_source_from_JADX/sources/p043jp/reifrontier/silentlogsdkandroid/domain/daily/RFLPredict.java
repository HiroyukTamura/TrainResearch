package p043jp.reifrontier.silentlogsdkandroid.domain.daily;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J)\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0017"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/domain/daily/RFLPredict;", "", "predict", "", "client", "confidence", "", "(Ljava/lang/String;Ljava/lang/String;F)V", "getClient", "()Ljava/lang/String;", "getConfidence", "()F", "getPredict", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.daily.RFLPredict */
public final class RFLPredict {
    @SerializedName("rfl_activity_predict_class")

    /* renamed from: a */
    private final String f3560a;
    @SerializedName("rfl_client")

    /* renamed from: b */
    private final String f3561b;
    @SerializedName("rfl_activity_predict_confidence")

    /* renamed from: c */
    private final float f3562c;

    public RFLPredict(String str, String str2, float f) {
        Intrinsics.checkParameterIsNotNull(str2, "client");
        this.f3560a = str;
        this.f3561b = str2;
        this.f3562c = f;
    }

    public static /* synthetic */ RFLPredict copy$default(RFLPredict rFLPredict, String str, String str2, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            str = rFLPredict.f3560a;
        }
        if ((i & 2) != 0) {
            str2 = rFLPredict.f3561b;
        }
        if ((i & 4) != 0) {
            f = rFLPredict.f3562c;
        }
        return rFLPredict.copy(str, str2, f);
    }

    public final String component1() {
        return this.f3560a;
    }

    public final String component2() {
        return this.f3561b;
    }

    public final float component3() {
        return this.f3562c;
    }

    public final RFLPredict copy(String str, String str2, float f) {
        Intrinsics.checkParameterIsNotNull(str2, "client");
        return new RFLPredict(str, str2, f);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RFLPredict)) {
            return false;
        }
        RFLPredict rFLPredict = (RFLPredict) obj;
        return Intrinsics.areEqual((Object) this.f3560a, (Object) rFLPredict.f3560a) && Intrinsics.areEqual((Object) this.f3561b, (Object) rFLPredict.f3561b) && Float.compare(this.f3562c, rFLPredict.f3562c) == 0;
    }

    public final String getClient() {
        return this.f3561b;
    }

    public final float getConfidence() {
        return this.f3562c;
    }

    public final String getPredict() {
        return this.f3560a;
    }

    public int hashCode() {
        String str = this.f3560a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f3561b;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return Float.floatToIntBits(this.f3562c) + ((hashCode + i) * 31);
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("RFLPredict(predict=");
        a.append(this.f3560a);
        a.append(", client=");
        a.append(this.f3561b);
        a.append(", confidence=");
        a.append(this.f3562c);
        a.append(")");
        return a.toString();
    }
}
