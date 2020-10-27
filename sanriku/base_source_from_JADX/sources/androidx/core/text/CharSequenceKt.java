package androidx.core.text;

import android.text.TextUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0000\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\b\u001a\r\u0010\u0003\u001a\u00020\u0004*\u00020\u0002H\b¨\u0006\u0005"}, mo21739d2 = {"isDigitsOnly", "", "", "trimmedLength", "", "core-ktx_release"}, mo21740k = 2, mo21741mv = {1, 1, 16})
public final class CharSequenceKt {
    public static final boolean isDigitsOnly(CharSequence charSequence) {
        Intrinsics.checkParameterIsNotNull(charSequence, "$this$isDigitsOnly");
        return TextUtils.isDigitsOnly(charSequence);
    }

    public static final int trimmedLength(CharSequence charSequence) {
        Intrinsics.checkParameterIsNotNull(charSequence, "$this$trimmedLength");
        return TextUtils.getTrimmedLength(charSequence);
    }
}
