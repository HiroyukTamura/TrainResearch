package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import androidx.annotation.RestrictTo;
import p009e.p010a.p011a.p012a.C0681a;
import p043jp.reifrontier.sanriku.R;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* renamed from: com.google.android.material.internal.d */
public final class C1196d {

    /* renamed from: a */
    private static final int[] f1228a = {R.attr.colorPrimary};

    /* renamed from: b */
    private static final int[] f1229b = {R.attr.colorSecondary};

    /* renamed from: a */
    private static void m1821a(Context context, int[] iArr, String str) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(iArr);
        boolean hasValue = obtainStyledAttributes.hasValue(0);
        obtainStyledAttributes.recycle();
        if (!hasValue) {
            throw new IllegalArgumentException(C0681a.m321a("The style on this component requires your app theme to be ", str, " (or a descendant)."));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0056, code lost:
        if (r0.getResourceId(0, -1) != -1) goto L_0x0058;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.content.res.TypedArray m1820a(android.content.Context r8, android.util.AttributeSet r9, @androidx.annotation.StyleableRes int[] r10, @androidx.annotation.AttrRes int r11, @androidx.annotation.StyleRes int r12, @androidx.annotation.StyleableRes int... r13) {
        /*
            int[] r0 = p009e.p028d.p030b.p054b.C1533b.f1768k
            android.content.res.TypedArray r0 = r8.obtainStyledAttributes(r9, r0, r11, r12)
            r1 = 0
            r2 = 1
            boolean r3 = r0.getBoolean(r2, r1)
            r0.recycle()
            if (r3 == 0) goto L_0x0018
            int[] r0 = f1229b
            java.lang.String r3 = "Theme.MaterialComponents"
            m1821a(r8, r0, r3)
        L_0x0018:
            int[] r0 = f1228a
            java.lang.String r3 = "Theme.AppCompat"
            m1821a(r8, r0, r3)
            int[] r0 = p009e.p028d.p030b.p054b.C1533b.f1768k
            android.content.res.TypedArray r0 = r8.obtainStyledAttributes(r9, r0, r11, r12)
            r3 = 2
            boolean r3 = r0.getBoolean(r3, r1)
            if (r3 != 0) goto L_0x0030
            r0.recycle()
            goto L_0x005e
        L_0x0030:
            r3 = -1
            if (r13 == 0) goto L_0x0052
            int r4 = r13.length
            if (r4 != 0) goto L_0x0037
            goto L_0x0052
        L_0x0037:
            android.content.res.TypedArray r4 = r8.obtainStyledAttributes(r9, r10, r11, r12)
            int r5 = r13.length
            r6 = 0
        L_0x003d:
            if (r6 >= r5) goto L_0x004e
            r7 = r13[r6]
            int r7 = r4.getResourceId(r7, r3)
            if (r7 != r3) goto L_0x004b
            r4.recycle()
            goto L_0x0059
        L_0x004b:
            int r6 = r6 + 1
            goto L_0x003d
        L_0x004e:
            r4.recycle()
            goto L_0x0058
        L_0x0052:
            int r13 = r0.getResourceId(r1, r3)
            if (r13 == r3) goto L_0x0059
        L_0x0058:
            r1 = 1
        L_0x0059:
            r0.recycle()
            if (r1 == 0) goto L_0x0063
        L_0x005e:
            android.content.res.TypedArray r8 = r8.obtainStyledAttributes(r9, r10, r11, r12)
            return r8
        L_0x0063:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r9 = "This component requires that you specify a valid TextAppearance attribute. Update your app theme to inherit from Theme.MaterialComponents (or a descendant)."
            r8.<init>(r9)
            goto L_0x006c
        L_0x006b:
            throw r8
        L_0x006c:
            goto L_0x006b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.internal.C1196d.m1820a(android.content.Context, android.util.AttributeSet, int[], int, int, int[]):android.content.res.TypedArray");
    }
}
