package kotlin.text;

import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u00002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u001a5\u0010\u0000\u001a\u0002H\u0001\"\f\b\u0000\u0010\u0001*\u00060\u0002j\u0002`\u0003*\u0002H\u00012\u0016\u0010\u0004\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00060\u0005\"\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007\u001a9\u0010\b\u001a\u00020\t\"\u0004\b\u0000\u0010\u0001*\u00060\u0002j\u0002`\u00032\u0006\u0010\n\u001a\u0002H\u00012\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u0006\u0018\u00010\fH\u0000¢\u0006\u0002\u0010\r\u001a9\u0010\u000e\u001a\u0002H\u0001\"\f\b\u0000\u0010\u0001*\u00060\u0002j\u0002`\u0003*\u0002H\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0007¢\u0006\u0002\u0010\u0012¨\u0006\u0013"}, mo21739d2 = {"append", "T", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "value", "", "", "(Ljava/lang/Appendable;[Ljava/lang/CharSequence;)Ljava/lang/Appendable;", "appendElement", "", "element", "transform", "Lkotlin/Function1;", "(Ljava/lang/Appendable;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "appendRange", "startIndex", "", "endIndex", "(Ljava/lang/Appendable;Ljava/lang/CharSequence;II)Ljava/lang/Appendable;", "kotlin-stdlib"}, mo21740k = 5, mo21741mv = {1, 1, 16}, mo21743xi = 1, mo21744xs = "kotlin/text/StringsKt")
class StringsKt__AppendableKt {
    public static final <T extends Appendable> T append(T t, CharSequence... charSequenceArr) {
        Intrinsics.checkParameterIsNotNull(t, "$this$append");
        Intrinsics.checkParameterIsNotNull(charSequenceArr, "value");
        for (CharSequence append : charSequenceArr) {
            t.append(append);
        }
        return t;
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [kotlin.jvm.functions.Function1<? super T, ? extends java.lang.CharSequence>, kotlin.jvm.functions.Function1] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T> void appendElement(java.lang.Appendable r1, T r2, kotlin.jvm.functions.Function1<? super T, ? extends java.lang.CharSequence> r3) {
        /*
            java.lang.String r0 = "$this$appendElement"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r1, r0)
            if (r3 == 0) goto L_0x0011
            java.lang.Object r2 = r3.invoke(r2)
        L_0x000b:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
        L_0x000d:
            r1.append(r2)
            goto L_0x002d
        L_0x0011:
            if (r2 == 0) goto L_0x0016
            boolean r3 = r2 instanceof java.lang.CharSequence
            goto L_0x0017
        L_0x0016:
            r3 = 1
        L_0x0017:
            if (r3 == 0) goto L_0x001a
            goto L_0x000b
        L_0x001a:
            boolean r3 = r2 instanceof java.lang.Character
            if (r3 == 0) goto L_0x0028
            java.lang.Character r2 = (java.lang.Character) r2
            char r2 = r2.charValue()
            r1.append(r2)
            goto L_0x002d
        L_0x0028:
            java.lang.String r2 = java.lang.String.valueOf(r2)
            goto L_0x000d
        L_0x002d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.StringsKt__AppendableKt.appendElement(java.lang.Appendable, java.lang.Object, kotlin.jvm.functions.Function1):void");
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    public static final <T extends Appendable> T appendRange(T t, CharSequence charSequence, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(t, "$this$appendRange");
        T append = t.append(charSequence, i, i2);
        if (append != null) {
            return append;
        }
        throw new TypeCastException("null cannot be cast to non-null type T");
    }
}
