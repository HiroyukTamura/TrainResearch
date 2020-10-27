package p043jp.reifrontier.gym.domain.api;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J;\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001b"}, mo21739d2 = {"Ljp/reifrontier/gym/domain/api/RFGUserPersonal;", "", "name", "", "add1", "add2", "post_number", "phone_number", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAdd1", "()Ljava/lang/String;", "getAdd2", "getName", "getPhone_number", "getPost_number", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.domain.api.RFGUserPersonal */
public final class RFGUserPersonal {
    @SerializedName("add1")
    private final String add1;
    @SerializedName("add2")
    private final String add2;
    @SerializedName("name")
    private final String name;
    @SerializedName("phone_number")
    private final String phone_number;
    @SerializedName("post_number")
    private final String post_number;

    public RFGUserPersonal(String str, String str2, String str3, String str4, String str5) {
        Intrinsics.checkParameterIsNotNull(str, AppMeasurementSdk.ConditionalUserProperty.NAME);
        Intrinsics.checkParameterIsNotNull(str2, "add1");
        Intrinsics.checkParameterIsNotNull(str3, "add2");
        Intrinsics.checkParameterIsNotNull(str4, "post_number");
        Intrinsics.checkParameterIsNotNull(str5, "phone_number");
        this.name = str;
        this.add1 = str2;
        this.add2 = str3;
        this.post_number = str4;
        this.phone_number = str5;
    }

    public static /* synthetic */ RFGUserPersonal copy$default(RFGUserPersonal rFGUserPersonal, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = rFGUserPersonal.name;
        }
        if ((i & 2) != 0) {
            str2 = rFGUserPersonal.add1;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = rFGUserPersonal.add2;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = rFGUserPersonal.post_number;
        }
        String str8 = str4;
        if ((i & 16) != 0) {
            str5 = rFGUserPersonal.phone_number;
        }
        return rFGUserPersonal.copy(str, str6, str7, str8, str5);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.add1;
    }

    public final String component3() {
        return this.add2;
    }

    public final String component4() {
        return this.post_number;
    }

    public final String component5() {
        return this.phone_number;
    }

    public final RFGUserPersonal copy(String str, String str2, String str3, String str4, String str5) {
        Intrinsics.checkParameterIsNotNull(str, AppMeasurementSdk.ConditionalUserProperty.NAME);
        Intrinsics.checkParameterIsNotNull(str2, "add1");
        Intrinsics.checkParameterIsNotNull(str3, "add2");
        Intrinsics.checkParameterIsNotNull(str4, "post_number");
        Intrinsics.checkParameterIsNotNull(str5, "phone_number");
        return new RFGUserPersonal(str, str2, str3, str4, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RFGUserPersonal)) {
            return false;
        }
        RFGUserPersonal rFGUserPersonal = (RFGUserPersonal) obj;
        return Intrinsics.areEqual((Object) this.name, (Object) rFGUserPersonal.name) && Intrinsics.areEqual((Object) this.add1, (Object) rFGUserPersonal.add1) && Intrinsics.areEqual((Object) this.add2, (Object) rFGUserPersonal.add2) && Intrinsics.areEqual((Object) this.post_number, (Object) rFGUserPersonal.post_number) && Intrinsics.areEqual((Object) this.phone_number, (Object) rFGUserPersonal.phone_number);
    }

    public final String getAdd1() {
        return this.add1;
    }

    public final String getAdd2() {
        return this.add2;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPhone_number() {
        return this.phone_number;
    }

    public final String getPost_number() {
        return this.post_number;
    }

    public int hashCode() {
        String str = this.name;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.add1;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.add2;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.post_number;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.phone_number;
        if (str5 != null) {
            i = str5.hashCode();
        }
        return hashCode4 + i;
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("RFGUserPersonal(name=");
        a.append(this.name);
        a.append(", add1=");
        a.append(this.add1);
        a.append(", add2=");
        a.append(this.add2);
        a.append(", post_number=");
        a.append(this.post_number);
        a.append(", phone_number=");
        return C0681a.m324a(a, this.phone_number, ")");
    }
}
