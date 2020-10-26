/*
 * Decompiled with CFR 0.139.
 */
package kotlin;

import kotlin.Metadata;
import kotlin.e.b.g;
import kotlin.e.b.j;

@Metadata(bv={1, 0, 2}, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005\u00a8\u0006\u0006"}, d2={"Lkotlin/NotImplementedError;", "Ljava/lang/Error;", "Lkotlin/Error;", "message", "", "(Ljava/lang/String;)V", "kotlin-stdlib"}, k=1, mv={1, 1, 11})
public final class n
extends Error {
    public n() {
        this(null, 1, null);
    }

    public n(String string2) {
        j.b(string2, "message");
        super(string2);
    }

    public /* synthetic */ n(String string2, int n2, g g2) {
        if ((n2 & 1) != 0) {
            string2 = "An operation is not implemented.";
        }
        this(string2);
    }
}

