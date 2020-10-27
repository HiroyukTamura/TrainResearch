package p043jp.reifrontier.silentlogsdkandroid.domain.p120ad;

import kotlin.Metadata;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/domain/ad/RFLAdResType;", "", "(Ljava/lang/String;I)V", "type", "", "getType", "()Ljava/lang/String;", "IMPRESSION", "CLICK", "CONVERSION", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.ad.RFLAdResType */
public enum RFLAdResType {
    ;

    /* renamed from: jp.reifrontier.silentlogsdkandroid.domain.ad.RFLAdResType$a */
    static final class C2286a extends RFLAdResType {
        C2286a(String str, int i) {
            super(str, i, (DefaultConstructorMarker) null);
        }

        public String getType() {
            return "clk";
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.domain.ad.RFLAdResType$b */
    static final class C2287b extends RFLAdResType {
        C2287b(String str, int i) {
            super(str, i, (DefaultConstructorMarker) null);
        }

        public String getType() {
            return "cv";
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.domain.ad.RFLAdResType$c */
    static final class C2288c extends RFLAdResType {
        C2288c(String str, int i) {
            super(str, i, (DefaultConstructorMarker) null);
        }

        public String getType() {
            return "imp";
        }
    }

    public abstract String getType();
}
