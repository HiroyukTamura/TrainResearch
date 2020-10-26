/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.g;

import java.util.Calendar;
import java.util.Date;
import kotlin.Metadata;
import kotlin.e.b.j;

@Metadata(bv={1, 0, 2}, d1={"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u00a8\u0006\u0003"}, d2={"startOfDay", "Ljava/util/Date;", "Ljava/util/Calendar;", "app_productRelease"}, k=2, mv={1, 1, 11})
public final class a {
    public static final Date a(Calendar comparable) {
        j.b(comparable, "$receiver");
        comparable.set(11, 0);
        comparable.set(12, 0);
        comparable.set(13, 0);
        comparable.set(14, 0);
        comparable = comparable.getTime();
        j.a((Object)comparable, "time");
        return comparable;
    }
}

