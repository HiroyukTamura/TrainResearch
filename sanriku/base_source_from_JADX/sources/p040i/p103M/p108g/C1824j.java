package p040i.p103M.p108g;

import java.io.IOException;
import java.net.ProtocolException;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;
import p040i.C0974E;

/* renamed from: i.M.g.j */
public final class C1824j {
    @JvmField

    /* renamed from: a */
    public final C0974E f2439a;
    @JvmField

    /* renamed from: b */
    public final int f2440b;
    @JvmField

    /* renamed from: c */
    public final String f2441c;

    public C1824j(C0974E e, int i, String str) {
        Intrinsics.checkParameterIsNotNull(e, "protocol");
        Intrinsics.checkParameterIsNotNull(str, "message");
        this.f2439a = e;
        this.f2440b = i;
        this.f2441c = str;
    }

    /* renamed from: a */
    public static final C1824j m2889a(String str) throws IOException {
        C0974E e;
        String str2;
        Intrinsics.checkParameterIsNotNull(str, "statusLine");
        int i = 9;
        if (StringsKt__StringsJVMKt.startsWith$default(str, "HTTP/1.", false, 2, (Object) null)) {
            if (str.length() < 9 || str.charAt(8) != ' ') {
                throw new ProtocolException(C0681a.m320a("Unexpected status line: ", str));
            }
            int charAt = str.charAt(7) - '0';
            if (charAt == 0) {
                e = C0974E.HTTP_1_0;
            } else if (charAt == 1) {
                e = C0974E.HTTP_1_1;
            } else {
                throw new ProtocolException(C0681a.m320a("Unexpected status line: ", str));
            }
        } else if (StringsKt__StringsJVMKt.startsWith$default(str, "ICY ", false, 2, (Object) null)) {
            e = C0974E.HTTP_1_0;
            i = 4;
        } else {
            throw new ProtocolException(C0681a.m320a("Unexpected status line: ", str));
        }
        int i2 = i + 3;
        if (str.length() >= i2) {
            try {
                String substring = str.substring(i, i2);
                Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                int parseInt = Integer.parseInt(substring);
                if (str.length() <= i2) {
                    str2 = "";
                } else if (str.charAt(i2) == ' ') {
                    str2 = str.substring(i + 4);
                    Intrinsics.checkExpressionValueIsNotNull(str2, "(this as java.lang.String).substring(startIndex)");
                } else {
                    throw new ProtocolException(C0681a.m320a("Unexpected status line: ", str));
                }
                return new C1824j(e, parseInt, str2);
            } catch (NumberFormatException unused) {
                throw new ProtocolException(C0681a.m320a("Unexpected status line: ", str));
            }
        } else {
            throw new ProtocolException(C0681a.m320a("Unexpected status line: ", str));
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f2439a == C0974E.HTTP_1_0 ? "HTTP/1.0" : "HTTP/1.1");
        sb.append(' ');
        sb.append(this.f2440b);
        sb.append(' ');
        sb.append(this.f2441c);
        String sb2 = sb.toString();
        Intrinsics.checkExpressionValueIsNotNull(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}
