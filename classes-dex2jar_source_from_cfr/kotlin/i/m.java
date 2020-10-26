/*
 * Decompiled with CFR 0.139.
 */
package kotlin.i;

import kotlin.Metadata;
import kotlin.i.k;

@Metadata(bv={1, 0, 2}, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c2\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2={"Lkotlin/text/ScreenFloatValueRegEx;", "", "()V", "value", "Lkotlin/text/Regex;", "kotlin-stdlib"}, k=1, mv={1, 1, 11})
final class m {
    public static final k a;
    public static final m b;

    static {
        b = new m();
        CharSequence charSequence = new StringBuilder();
        charSequence.append("[eE][+-]?");
        charSequence.append("(\\p{Digit}+)");
        charSequence = charSequence.toString();
        CharSequence charSequence2 = new StringBuilder();
        ((StringBuilder)charSequence2).append("(0[xX]");
        ((StringBuilder)charSequence2).append("(\\p{XDigit}+)");
        ((StringBuilder)charSequence2).append("(\\.)?)|");
        ((StringBuilder)charSequence2).append("(0[xX]");
        ((StringBuilder)charSequence2).append("(\\p{XDigit}+)");
        ((StringBuilder)charSequence2).append("?(\\.)");
        ((StringBuilder)charSequence2).append("(\\p{XDigit}+)");
        ((StringBuilder)charSequence2).append(')');
        charSequence2 = ((StringBuilder)charSequence2).toString();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('(');
        stringBuilder.append("(\\p{Digit}+)");
        stringBuilder.append("(\\.)?(");
        stringBuilder.append("(\\p{Digit}+)");
        stringBuilder.append("?)(");
        stringBuilder.append((String)charSequence);
        stringBuilder.append(")?)|");
        stringBuilder.append("(\\.(");
        stringBuilder.append("(\\p{Digit}+)");
        stringBuilder.append(")(");
        stringBuilder.append((String)charSequence);
        stringBuilder.append(")?)|");
        stringBuilder.append("((");
        stringBuilder.append((String)charSequence2);
        stringBuilder.append(")[pP][+-]?");
        stringBuilder.append("(\\p{Digit}+)");
        stringBuilder.append(')');
        charSequence = stringBuilder.toString();
        charSequence2 = new StringBuilder();
        ((StringBuilder)charSequence2).append("[\\x00-\\x20]*[+-]?(NaN|Infinity|((");
        ((StringBuilder)charSequence2).append((String)charSequence);
        ((StringBuilder)charSequence2).append(")[fFdD]?))[\\x00-\\x20]*");
        a = new k(((StringBuilder)charSequence2).toString());
    }

    private m() {
    }
}

