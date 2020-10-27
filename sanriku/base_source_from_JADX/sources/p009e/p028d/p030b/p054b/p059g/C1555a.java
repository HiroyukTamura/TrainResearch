package p009e.p028d.p030b.p054b.p059g;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.util.StateSet;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.ColorUtils;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* renamed from: e.d.b.b.g.a */
public class C1555a {

    /* renamed from: a */
    public static final boolean f1799a = (Build.VERSION.SDK_INT >= 21);

    /* renamed from: b */
    private static final int[] f1800b = {16842919};

    /* renamed from: c */
    private static final int[] f1801c = {16843623, 16842908};

    /* renamed from: d */
    private static final int[] f1802d = {16842908};

    /* renamed from: e */
    private static final int[] f1803e = {16843623};

    /* renamed from: f */
    private static final int[] f1804f = {16842913, 16842919};

    /* renamed from: g */
    private static final int[] f1805g = {16842913, 16843623, 16842908};

    /* renamed from: h */
    private static final int[] f1806h = {16842913, 16842908};

    /* renamed from: i */
    private static final int[] f1807i = {16842913, 16843623};

    /* renamed from: j */
    private static final int[] f1808j = {16842913};

    @ColorInt
    /* renamed from: a */
    private static int m2173a(@Nullable ColorStateList colorStateList, int[] iArr) {
        int colorForState = colorStateList != null ? colorStateList.getColorForState(iArr, colorStateList.getDefaultColor()) : 0;
        return f1799a ? ColorUtils.setAlphaComponent(colorForState, Math.min(Color.alpha(colorForState) * 2, 255)) : colorForState;
    }

    @NonNull
    /* renamed from: a */
    public static ColorStateList m2174a(@Nullable ColorStateList colorStateList) {
        if (f1799a) {
            return new ColorStateList(new int[][]{f1808j, StateSet.NOTHING}, new int[]{m2173a(colorStateList, f1804f), m2173a(colorStateList, f1800b)});
        }
        int[] iArr = f1804f;
        int[] iArr2 = f1805g;
        int[] iArr3 = f1806h;
        int[] iArr4 = f1807i;
        int[] iArr5 = f1800b;
        int[] iArr6 = f1801c;
        int[] iArr7 = f1802d;
        int[] iArr8 = f1803e;
        return new ColorStateList(new int[][]{iArr, iArr2, iArr3, iArr4, f1808j, iArr5, iArr6, iArr7, iArr8, StateSet.NOTHING}, new int[]{m2173a(colorStateList, iArr), m2173a(colorStateList, iArr2), m2173a(colorStateList, iArr3), m2173a(colorStateList, iArr4), 0, m2173a(colorStateList, iArr5), m2173a(colorStateList, iArr6), m2173a(colorStateList, iArr7), m2173a(colorStateList, iArr8), 0});
    }
}
