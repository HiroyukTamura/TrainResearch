package p043jp.reifrontier.silentlogsdkandroid.domain.p120ad;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;
import p043jp.reifrontier.silentlogsdkandroid.utils.LocaleEx;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/domain/ad/RFLLocalizeData;", "", "ja", "", "default", "(Ljava/lang/String;Ljava/lang/String;)V", "getDefault", "()Ljava/lang/String;", "getJa", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.ad.RFLLocalizeData */
public final class RFLLocalizeData {
    @SerializedName("ja")

    /* renamed from: a */
    private final String f3459a;
    @SerializedName("default")

    /* renamed from: b */
    private final String f3460b;

    public RFLLocalizeData(String str, String str2) {
        Intrinsics.checkParameterIsNotNull(str, LocaleEx.JAPANESE_LANGUAGE);
        Intrinsics.checkParameterIsNotNull(str2, "default");
        this.f3459a = str;
        this.f3460b = str2;
    }

    public static /* synthetic */ RFLLocalizeData copy$default(RFLLocalizeData rFLLocalizeData, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = rFLLocalizeData.f3459a;
        }
        if ((i & 2) != 0) {
            str2 = rFLLocalizeData.f3460b;
        }
        return rFLLocalizeData.copy(str, str2);
    }

    public final String component1() {
        return this.f3459a;
    }

    public final String component2() {
        return this.f3460b;
    }

    public final RFLLocalizeData copy(String str, String str2) {
        Intrinsics.checkParameterIsNotNull(str, LocaleEx.JAPANESE_LANGUAGE);
        Intrinsics.checkParameterIsNotNull(str2, "default");
        return new RFLLocalizeData(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RFLLocalizeData)) {
            return false;
        }
        RFLLocalizeData rFLLocalizeData = (RFLLocalizeData) obj;
        return Intrinsics.areEqual((Object) this.f3459a, (Object) rFLLocalizeData.f3459a) && Intrinsics.areEqual((Object) this.f3460b, (Object) rFLLocalizeData.f3460b);
    }

    public final String getDefault() {
        return this.f3460b;
    }

    public final String getJa() {
        return this.f3459a;
    }

    public int hashCode() {
        String str = this.f3459a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f3460b;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("RFLLocalizeData(ja=");
        a.append(this.f3459a);
        a.append(", default=");
        return C0681a.m324a(a, this.f3460b, ")");
    }
}
