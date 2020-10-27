package p043jp.reifrontier.silentlogsdkandroid.domain.p120ad;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\b\b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/domain/ad/RFLAdResult;", "", "result", "", "message", "", "(ILjava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "getResult", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.ad.RFLAdResult */
public final class RFLAdResult {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int ERROR_DETECT_LIMIT = 900;
    public static final int ERROR_FAILED = 999;
    public static final int ERROR_NOT_FOUND = 901;
    public static final int ERROR_PUSH = 902;
    public static final int SUCCESS = 800;
    @SerializedName("result")

    /* renamed from: a */
    private final int f3445a;
    @SerializedName("message")

    /* renamed from: b */
    private final String f3446b;

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/domain/ad/RFLAdResult$Companion;", "", "()V", "ERROR_DETECT_LIMIT", "", "ERROR_FAILED", "ERROR_NOT_FOUND", "ERROR_PUSH", "SUCCESS", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.silentlogsdkandroid.domain.ad.RFLAdResult$Companion */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public RFLAdResult(int i, String str) {
        Intrinsics.checkParameterIsNotNull(str, "message");
        this.f3445a = i;
        this.f3446b = str;
    }

    public static /* synthetic */ RFLAdResult copy$default(RFLAdResult rFLAdResult, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = rFLAdResult.f3445a;
        }
        if ((i2 & 2) != 0) {
            str = rFLAdResult.f3446b;
        }
        return rFLAdResult.copy(i, str);
    }

    public final int component1() {
        return this.f3445a;
    }

    public final String component2() {
        return this.f3446b;
    }

    public final RFLAdResult copy(int i, String str) {
        Intrinsics.checkParameterIsNotNull(str, "message");
        return new RFLAdResult(i, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RFLAdResult)) {
            return false;
        }
        RFLAdResult rFLAdResult = (RFLAdResult) obj;
        return this.f3445a == rFLAdResult.f3445a && Intrinsics.areEqual((Object) this.f3446b, (Object) rFLAdResult.f3446b);
    }

    public final String getMessage() {
        return this.f3446b;
    }

    public final int getResult() {
        return this.f3445a;
    }

    public int hashCode() {
        int i = this.f3445a * 31;
        String str = this.f3446b;
        return i + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("RFLAdResult(result=");
        a.append(this.f3445a);
        a.append(", message=");
        return C0681a.m324a(a, this.f3446b, ")");
    }
}
