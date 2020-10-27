package p043jp.reifrontier.silentlogsdkandroid.domain.p120ad;

import kotlin.Metadata;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/domain/ad/RFLAdTrackingType;", "", "type", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "START", "STOP", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.ad.RFLAdTrackingType */
public enum RFLAdTrackingType {
    START("start"),
    STOP("end");
    

    /* renamed from: a */
    private final String f3448a;

    private RFLAdTrackingType(String str) {
        this.f3448a = str;
    }

    public final String getType() {
        return this.f3448a;
    }
}
