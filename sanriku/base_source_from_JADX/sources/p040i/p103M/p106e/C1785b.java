package p040i.p103M.p106e;

import java.util.Arrays;
import java.util.logging.Logger;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import p009e.p010a.p011a.p012a.C0681a;

/* renamed from: i.M.e.b */
public final class C1785b {
    /* renamed from: a */
    public static final String m2719a(long j) {
        StringBuilder sb;
        long j2;
        long j3;
        long j4;
        StringBuilder sb2;
        if (j <= ((long) -999500000)) {
            sb2 = new StringBuilder();
            j2 = j - ((long) 500000000);
        } else {
            if (j <= ((long) -999500)) {
                sb2 = new StringBuilder();
                j3 = j - ((long) 500000);
            } else {
                if (j <= 0) {
                    sb = new StringBuilder();
                    j4 = j - ((long) 500);
                } else if (j < ((long) 999500)) {
                    sb = new StringBuilder();
                    j4 = j + ((long) 500);
                } else {
                    int i = (j > ((long) 999500000) ? 1 : (j == ((long) 999500000) ? 0 : -1));
                    sb2 = new StringBuilder();
                    if (i < 0) {
                        j3 = j + ((long) 500000);
                    } else {
                        j2 = j + ((long) 500000000);
                    }
                }
                sb.append(j4 / ((long) 1000));
                sb.append(" µs");
                String sb3 = sb.toString();
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                return C0681a.m328a(new Object[]{sb3}, 1, "%6s", "java.lang.String.format(format, *args)");
            }
            sb.append(j3 / ((long) 1000000));
            sb.append(" ms");
            String sb32 = sb.toString();
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            return C0681a.m328a(new Object[]{sb32}, 1, "%6s", "java.lang.String.format(format, *args)");
        }
        sb.append(j2 / ((long) 1000000000));
        sb.append(" s ");
        String sb322 = sb.toString();
        StringCompanionObject stringCompanionObject22 = StringCompanionObject.INSTANCE;
        return C0681a.m328a(new Object[]{sb322}, 1, "%6s", "java.lang.String.format(format, *args)");
    }

    /* renamed from: a */
    public static final /* synthetic */ void m2720a(C1784a aVar, C1787d dVar, String str) {
        if (C1788e.f2310j != null) {
            Logger e = C1788e.f2309i;
            StringBuilder sb = new StringBuilder();
            sb.append(dVar.mo27666f());
            sb.append(' ');
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("%-22s", Arrays.copyOf(new Object[]{str}, 1));
            Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(format, *args)");
            sb.append(format);
            sb.append(": ");
            sb.append(aVar.mo27653b());
            e.fine(sb.toString());
            return;
        }
        throw null;
    }
}
