package p043jp.reifrontier.silentlogsdkandroid.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006¨\u0006\b"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/utils/DateEx;", "", "()V", "parse", "Ljava/util/Date;", "dateString", "", "dateFormat", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.silentlogsdkandroid.utils.DateEx */
public final class DateEx {
    public static final DateEx INSTANCE = new DateEx();

    private DateEx() {
    }

    public final Date parse(String str, String str2) {
        Intrinsics.checkParameterIsNotNull(str, "dateString");
        Intrinsics.checkParameterIsNotNull(str2, "dateFormat");
        try {
            return new SimpleDateFormat(str2, Locale.US).parse(str);
        } catch (Exception unused) {
            return null;
        }
    }
}
