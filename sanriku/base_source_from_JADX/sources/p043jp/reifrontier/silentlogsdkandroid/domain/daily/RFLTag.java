package p043jp.reifrontier.silentlogsdkandroid.domain.daily;

import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u0000 !2\u00020\u0001:\u0001!B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\tHÆ\u0003JA\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u000b\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\rR\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013¨\u0006\""}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/domain/daily/RFLTag;", "", "tagName", "", "tagOwner", "tagType", "predict", "Ljp/reifrontier/silentlogsdkandroid/domain/daily/RFLPredict;", "poi", "Ljp/reifrontier/silentlogsdkandroid/domain/daily/RFLActivityPoi;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljp/reifrontier/silentlogsdkandroid/domain/daily/RFLPredict;Ljp/reifrontier/silentlogsdkandroid/domain/daily/RFLActivityPoi;)V", "isPredictRemoveTag", "", "()Z", "getPoi", "()Ljp/reifrontier/silentlogsdkandroid/domain/daily/RFLActivityPoi;", "getPredict", "()Ljp/reifrontier/silentlogsdkandroid/domain/daily/RFLPredict;", "getTagName", "()Ljava/lang/String;", "getTagOwner", "getTagType", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "Companion", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.daily.RFLTag */
public final class RFLTag {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @SerializedName("tagName")

    /* renamed from: a */
    private final String f3572a;
    @SerializedName("tagOwner")

    /* renamed from: b */
    private final String f3573b;
    @SerializedName("tagType")

    /* renamed from: c */
    private final String f3574c;
    @SerializedName("tagPredict")

    /* renamed from: d */
    private final RFLPredict f3575d;
    @SerializedName("tagPoi")

    /* renamed from: e */
    private final RFLActivityPoi f3576e;

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/domain/daily/RFLTag$Companion;", "", "()V", "createPredictRemoveTag", "Ljp/reifrontier/silentlogsdkandroid/domain/daily/RFLTag;", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.silentlogsdkandroid.domain.daily.RFLTag$Companion */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RFLTag createPredictRemoveTag() {
            return new RFLTag("predict", "", ProductAction.ACTION_REMOVE, (RFLPredict) null, (RFLActivityPoi) null);
        }
    }

    public RFLTag(String str, String str2, String str3, RFLPredict rFLPredict, RFLActivityPoi rFLActivityPoi) {
        Intrinsics.checkParameterIsNotNull(str, "tagName");
        Intrinsics.checkParameterIsNotNull(str2, "tagOwner");
        this.f3572a = str;
        this.f3573b = str2;
        this.f3574c = str3;
        this.f3575d = rFLPredict;
        this.f3576e = rFLActivityPoi;
    }

    public static /* synthetic */ RFLTag copy$default(RFLTag rFLTag, String str, String str2, String str3, RFLPredict rFLPredict, RFLActivityPoi rFLActivityPoi, int i, Object obj) {
        if ((i & 1) != 0) {
            str = rFLTag.f3572a;
        }
        if ((i & 2) != 0) {
            str2 = rFLTag.f3573b;
        }
        String str4 = str2;
        if ((i & 4) != 0) {
            str3 = rFLTag.f3574c;
        }
        String str5 = str3;
        if ((i & 8) != 0) {
            rFLPredict = rFLTag.f3575d;
        }
        RFLPredict rFLPredict2 = rFLPredict;
        if ((i & 16) != 0) {
            rFLActivityPoi = rFLTag.f3576e;
        }
        return rFLTag.copy(str, str4, str5, rFLPredict2, rFLActivityPoi);
    }

    public final String component1() {
        return this.f3572a;
    }

    public final String component2() {
        return this.f3573b;
    }

    public final String component3() {
        return this.f3574c;
    }

    public final RFLPredict component4() {
        return this.f3575d;
    }

    public final RFLActivityPoi component5() {
        return this.f3576e;
    }

    public final RFLTag copy(String str, String str2, String str3, RFLPredict rFLPredict, RFLActivityPoi rFLActivityPoi) {
        Intrinsics.checkParameterIsNotNull(str, "tagName");
        Intrinsics.checkParameterIsNotNull(str2, "tagOwner");
        return new RFLTag(str, str2, str3, rFLPredict, rFLActivityPoi);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RFLTag)) {
            return false;
        }
        RFLTag rFLTag = (RFLTag) obj;
        return Intrinsics.areEqual((Object) this.f3572a, (Object) rFLTag.f3572a) && Intrinsics.areEqual((Object) this.f3573b, (Object) rFLTag.f3573b) && Intrinsics.areEqual((Object) this.f3574c, (Object) rFLTag.f3574c) && Intrinsics.areEqual((Object) this.f3575d, (Object) rFLTag.f3575d) && Intrinsics.areEqual((Object) this.f3576e, (Object) rFLTag.f3576e);
    }

    public final RFLActivityPoi getPoi() {
        return this.f3576e;
    }

    public final RFLPredict getPredict() {
        return this.f3575d;
    }

    public final String getTagName() {
        return this.f3572a;
    }

    public final String getTagOwner() {
        return this.f3573b;
    }

    public final String getTagType() {
        return this.f3574c;
    }

    public int hashCode() {
        String str = this.f3572a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f3573b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f3574c;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        RFLPredict rFLPredict = this.f3575d;
        int hashCode4 = (hashCode3 + (rFLPredict != null ? rFLPredict.hashCode() : 0)) * 31;
        RFLActivityPoi rFLActivityPoi = this.f3576e;
        if (rFLActivityPoi != null) {
            i = rFLActivityPoi.hashCode();
        }
        return hashCode4 + i;
    }

    public final boolean isPredictRemoveTag() {
        return Intrinsics.areEqual((Object) this.f3572a, (Object) "predict") && Intrinsics.areEqual((Object) this.f3574c, (Object) ProductAction.ACTION_REMOVE);
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("RFLTag(tagName=");
        a.append(this.f3572a);
        a.append(", tagOwner=");
        a.append(this.f3573b);
        a.append(", tagType=");
        a.append(this.f3574c);
        a.append(", predict=");
        a.append(this.f3575d);
        a.append(", poi=");
        a.append(this.f3576e);
        a.append(")");
        return a.toString();
    }
}
