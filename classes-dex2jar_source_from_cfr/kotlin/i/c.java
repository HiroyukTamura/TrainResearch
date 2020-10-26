/*
 * Decompiled with CFR 0.139.
 */
package kotlin.i;

import kotlin.Metadata;
import kotlin.i.b;

@Metadata(bv={1, 0, 2}, d1={"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\f\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0001\u001a\n\u0010\u0005\u001a\u00020\u0001*\u00020\u0002\u001a\u0015\u0010\u0006\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0007H\u0087\n\u00a8\u0006\b"}, d2={"equals", "", "", "other", "ignoreCase", "isSurrogate", "plus", "", "kotlin-stdlib"}, k=5, mv={1, 1, 11}, xi=1, xs="kotlin/text/CharsKt")
class c
extends b {
    public static final boolean a(char c2, char c3, boolean bl2) {
        if (c2 == c3) {
            return true;
        }
        if (!bl2) {
            return false;
        }
        if (Character.toUpperCase(c2) == Character.toUpperCase(c3)) {
            return true;
        }
        return Character.toLowerCase(c2) == Character.toLowerCase(c3);
    }
}

