/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.d;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.e.b.j;

@Metadata(bv={1, 0, 2}, d1={"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001\u001a\n\u0010\u0004\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0005\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0006\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0007\u001a\u00020\u0001*\u00020\u0002\u00a8\u0006\b"}, d2={"toFormatString", "", "Ljava/util/Date;", "pattern", "toHHmmString", "toHHmmStringWithColon", "toYmdHHmmString", "toYmdString", "app_productRelease"}, k=2, mv={1, 1, 11})
public final class b {
    public static final String a(Date object) {
        j.b(object, "$receiver");
        object = new SimpleDateFormat("yyyyMMdd", Locale.JAPAN).format((Date)object);
        j.a(object, "SimpleDateFormat(\"yyyyMM\u2026ocale.JAPAN).format(this)");
        return object;
    }

    public static final String a(Date object, String string2) {
        j.b(object, "$receiver");
        j.b(string2, "pattern");
        object = new SimpleDateFormat(string2, Locale.JAPAN).format((Date)object);
        j.a(object, "SimpleDateFormat(pattern\u2026ocale.JAPAN).format(this)");
        return object;
    }

    public static final String b(Date object) {
        j.b(object, "$receiver");
        object = new SimpleDateFormat("HHmm", Locale.JAPAN).format((Date)object);
        j.a(object, "SimpleDateFormat(\"HHmm\",\u2026ocale.JAPAN).format(this)");
        return object;
    }

    public static final String c(Date object) {
        j.b(object, "$receiver");
        object = new SimpleDateFormat("HH:mm", Locale.JAPAN).format((Date)object);
        j.a(object, "SimpleDateFormat(\"HH:mm\"\u2026ocale.JAPAN).format(this)");
        return object;
    }

    public static final String d(Date object) {
        j.b(object, "$receiver");
        object = new SimpleDateFormat("yyyyMMddHHmm", Locale.JAPAN).format((Date)object);
        j.a(object, "SimpleDateFormat(\"yyyyMM\u2026ocale.JAPAN).format(this)");
        return object;
    }
}

