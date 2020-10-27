package p043jp.reifrontier.silentlogsdkandroid.domain.api;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;
import p043jp.reifrontier.silentlogsdkandroid.utils.LocaleEx;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÂ\u0003J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÂ\u0003J!\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\u0010\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u0003J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0002X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0002X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/domain/api/RFLText;", "", "defaultText", "", "jaText", "(Ljava/lang/String;Ljava/lang/String;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "text", "lang", "toString", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.api.RFLText */
public final class RFLText {
    @SerializedName("default")

    /* renamed from: a */
    private final String f3508a;
    @SerializedName("ja")

    /* renamed from: b */
    private final String f3509b;

    public RFLText(String str, String str2) {
        this.f3508a = str;
        this.f3509b = str2;
    }

    public static /* synthetic */ RFLText copy$default(RFLText rFLText, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = rFLText.f3508a;
        }
        if ((i & 2) != 0) {
            str2 = rFLText.f3509b;
        }
        return rFLText.copy(str, str2);
    }

    public static /* synthetic */ String text$default(RFLText rFLText, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = LocaleEx.INSTANCE.getDefaultLang();
        }
        return rFLText.text(str);
    }

    public final RFLText copy(String str, String str2) {
        return new RFLText(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RFLText)) {
            return false;
        }
        RFLText rFLText = (RFLText) obj;
        return Intrinsics.areEqual((Object) this.f3508a, (Object) rFLText.f3508a) && Intrinsics.areEqual((Object) this.f3509b, (Object) rFLText.f3509b);
    }

    public int hashCode() {
        String str = this.f3508a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f3509b;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public final String text(String str) {
        Intrinsics.checkParameterIsNotNull(str, "lang");
        if (this.f3508a != null && this.f3509b != null) {
            return Intrinsics.areEqual((Object) str, (Object) LocaleEx.JAPANESE_LANGUAGE) ? this.f3509b : this.f3508a;
        }
        String str2 = this.f3508a;
        if (str2 != null) {
            return str2;
        }
        String str3 = this.f3509b;
        return str3 != null ? str3 : "";
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("RFLText(defaultText=");
        a.append(this.f3508a);
        a.append(", jaText=");
        return C0681a.m324a(a, this.f3509b, ")");
    }
}
