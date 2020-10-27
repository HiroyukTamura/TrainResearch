package com.google.android.material.button;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.drawable.DrawableCompat;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* renamed from: com.google.android.material.button.b */
class C1173b {

    /* renamed from: w */
    private static final boolean f1123w = (Build.VERSION.SDK_INT >= 21);

    /* renamed from: a */
    private final MaterialButton f1124a;

    /* renamed from: b */
    private int f1125b;

    /* renamed from: c */
    private int f1126c;

    /* renamed from: d */
    private int f1127d;

    /* renamed from: e */
    private int f1128e;

    /* renamed from: f */
    private int f1129f;

    /* renamed from: g */
    private int f1130g;
    @Nullable

    /* renamed from: h */
    private PorterDuff.Mode f1131h;
    @Nullable

    /* renamed from: i */
    private ColorStateList f1132i;
    @Nullable

    /* renamed from: j */
    private ColorStateList f1133j;
    @Nullable

    /* renamed from: k */
    private ColorStateList f1134k;

    /* renamed from: l */
    private final Paint f1135l = new Paint(1);

    /* renamed from: m */
    private final Rect f1136m = new Rect();

    /* renamed from: n */
    private final RectF f1137n = new RectF();
    @Nullable

    /* renamed from: o */
    private GradientDrawable f1138o;
    @Nullable

    /* renamed from: p */
    private Drawable f1139p;
    @Nullable

    /* renamed from: q */
    private GradientDrawable f1140q;
    @Nullable

    /* renamed from: r */
    private Drawable f1141r;
    @Nullable

    /* renamed from: s */
    private GradientDrawable f1142s;
    @Nullable

    /* renamed from: t */
    private GradientDrawable f1143t;
    @Nullable

    /* renamed from: u */
    private GradientDrawable f1144u;

    /* renamed from: v */
    private boolean f1145v = false;

    public C1173b(MaterialButton materialButton) {
        this.f1124a = materialButton;
    }

    /* renamed from: e */
    private void m1755e() {
        GradientDrawable gradientDrawable = this.f1142s;
        if (gradientDrawable != null) {
            DrawableCompat.setTintList(gradientDrawable, this.f1132i);
            PorterDuff.Mode mode = this.f1131h;
            if (mode != null) {
                DrawableCompat.setTintMode(this.f1142s, mode);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public ColorStateList mo25392a() {
        return this.f1132i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo25393a(int i) {
        GradientDrawable gradientDrawable;
        if ((f1123w && (gradientDrawable = this.f1142s) != null) || (!f1123w && (gradientDrawable = this.f1138o) != null)) {
            gradientDrawable.setColor(i);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo25394a(int i, int i2) {
        GradientDrawable gradientDrawable = this.f1144u;
        if (gradientDrawable != null) {
            gradientDrawable.setBounds(this.f1125b, this.f1127d, i2 - this.f1126c, i - this.f1128e);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo25395a(@Nullable ColorStateList colorStateList) {
        if (this.f1132i != colorStateList) {
            this.f1132i = colorStateList;
            if (f1123w) {
                m1755e();
                return;
            }
            Drawable drawable = this.f1139p;
            if (drawable != null) {
                DrawableCompat.setTintList(drawable, colorStateList);
            }
        }
    }

    /* JADX WARNING: type inference failed for: r3v11, types: [com.google.android.material.button.a] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo25396a(android.content.res.TypedArray r21) {
        /*
            r20 = this;
            r0 = r20
            r1 = r21
            r2 = 0
            int r3 = r1.getDimensionPixelOffset(r2, r2)
            r0.f1125b = r3
            r3 = 1
            int r4 = r1.getDimensionPixelOffset(r3, r2)
            r0.f1126c = r4
            r4 = 2
            int r5 = r1.getDimensionPixelOffset(r4, r2)
            r0.f1127d = r5
            r5 = 3
            int r5 = r1.getDimensionPixelOffset(r5, r2)
            r0.f1128e = r5
            r5 = 6
            int r5 = r1.getDimensionPixelSize(r5, r2)
            r0.f1129f = r5
            r5 = 15
            int r5 = r1.getDimensionPixelSize(r5, r2)
            r0.f1130g = r5
            r5 = -1
            r6 = 5
            int r6 = r1.getInt(r6, r5)
            android.graphics.PorterDuff$Mode r7 = android.graphics.PorterDuff.Mode.SRC_IN
            android.graphics.PorterDuff$Mode r6 = p009e.p028d.p030b.p054b.C1532a.m2124a((int) r6, (android.graphics.PorterDuff.Mode) r7)
            r0.f1131h = r6
            com.google.android.material.button.MaterialButton r6 = r0.f1124a
            android.content.Context r6 = r6.getContext()
            r7 = 4
            android.content.res.ColorStateList r6 = p009e.p028d.p030b.p054b.C1532a.m2123a((android.content.Context) r6, (android.content.res.TypedArray) r1, (int) r7)
            r0.f1132i = r6
            com.google.android.material.button.MaterialButton r6 = r0.f1124a
            android.content.Context r6 = r6.getContext()
            r7 = 14
            android.content.res.ColorStateList r6 = p009e.p028d.p030b.p054b.C1532a.m2123a((android.content.Context) r6, (android.content.res.TypedArray) r1, (int) r7)
            r0.f1133j = r6
            com.google.android.material.button.MaterialButton r6 = r0.f1124a
            android.content.Context r6 = r6.getContext()
            r7 = 13
            android.content.res.ColorStateList r1 = p009e.p028d.p030b.p054b.C1532a.m2123a((android.content.Context) r6, (android.content.res.TypedArray) r1, (int) r7)
            r0.f1134k = r1
            android.graphics.Paint r1 = r0.f1135l
            android.graphics.Paint$Style r6 = android.graphics.Paint.Style.STROKE
            r1.setStyle(r6)
            android.graphics.Paint r1 = r0.f1135l
            int r6 = r0.f1130g
            float r6 = (float) r6
            r1.setStrokeWidth(r6)
            android.graphics.Paint r1 = r0.f1135l
            android.content.res.ColorStateList r6 = r0.f1133j
            if (r6 == 0) goto L_0x0086
            com.google.android.material.button.MaterialButton r7 = r0.f1124a
            int[] r7 = r7.getDrawableState()
            int r6 = r6.getColorForState(r7, r2)
            goto L_0x0087
        L_0x0086:
            r6 = 0
        L_0x0087:
            r1.setColor(r6)
            com.google.android.material.button.MaterialButton r1 = r0.f1124a
            int r1 = androidx.core.view.ViewCompat.getPaddingStart(r1)
            com.google.android.material.button.MaterialButton r6 = r0.f1124a
            int r6 = r6.getPaddingTop()
            com.google.android.material.button.MaterialButton r7 = r0.f1124a
            int r7 = androidx.core.view.ViewCompat.getPaddingEnd(r7)
            com.google.android.material.button.MaterialButton r8 = r0.f1124a
            int r8 = r8.getPaddingBottom()
            com.google.android.material.button.MaterialButton r9 = r0.f1124a
            boolean r10 = f1123w
            r11 = 925353388(0x3727c5ac, float:1.0E-5)
            if (r10 == 0) goto L_0x0123
            android.graphics.drawable.GradientDrawable r10 = new android.graphics.drawable.GradientDrawable
            r10.<init>()
            r0.f1142s = r10
            int r12 = r0.f1129f
            float r12 = (float) r12
            float r12 = r12 + r11
            r10.setCornerRadius(r12)
            android.graphics.drawable.GradientDrawable r10 = r0.f1142s
            r10.setColor(r5)
            r20.m1755e()
            android.graphics.drawable.GradientDrawable r10 = new android.graphics.drawable.GradientDrawable
            r10.<init>()
            r0.f1143t = r10
            int r12 = r0.f1129f
            float r12 = (float) r12
            float r12 = r12 + r11
            r10.setCornerRadius(r12)
            android.graphics.drawable.GradientDrawable r10 = r0.f1143t
            r10.setColor(r2)
            android.graphics.drawable.GradientDrawable r10 = r0.f1143t
            int r12 = r0.f1130g
            android.content.res.ColorStateList r13 = r0.f1133j
            r10.setStroke(r12, r13)
            android.graphics.drawable.LayerDrawable r15 = new android.graphics.drawable.LayerDrawable
            android.graphics.drawable.Drawable[] r4 = new android.graphics.drawable.Drawable[r4]
            android.graphics.drawable.GradientDrawable r10 = r0.f1142s
            r4[r2] = r10
            android.graphics.drawable.GradientDrawable r2 = r0.f1143t
            r4[r3] = r2
            r15.<init>(r4)
            android.graphics.drawable.InsetDrawable r2 = new android.graphics.drawable.InsetDrawable
            int r3 = r0.f1125b
            int r4 = r0.f1127d
            int r10 = r0.f1126c
            int r12 = r0.f1128e
            r14 = r2
            r16 = r3
            r17 = r4
            r18 = r10
            r19 = r12
            r14.<init>(r15, r16, r17, r18, r19)
            android.graphics.drawable.GradientDrawable r3 = new android.graphics.drawable.GradientDrawable
            r3.<init>()
            r0.f1144u = r3
            int r4 = r0.f1129f
            float r4 = (float) r4
            float r4 = r4 + r11
            r3.setCornerRadius(r4)
            android.graphics.drawable.GradientDrawable r3 = r0.f1144u
            r3.setColor(r5)
            com.google.android.material.button.a r3 = new com.google.android.material.button.a
            android.content.res.ColorStateList r4 = r0.f1134k
            android.content.res.ColorStateList r4 = p009e.p028d.p030b.p054b.p059g.C1555a.m2174a(r4)
            android.graphics.drawable.GradientDrawable r5 = r0.f1144u
            r3.<init>(r4, r2, r5)
            goto L_0x018b
        L_0x0123:
            android.graphics.drawable.GradientDrawable r10 = new android.graphics.drawable.GradientDrawable
            r10.<init>()
            r0.f1138o = r10
            int r12 = r0.f1129f
            float r12 = (float) r12
            float r12 = r12 + r11
            r10.setCornerRadius(r12)
            android.graphics.drawable.GradientDrawable r10 = r0.f1138o
            r10.setColor(r5)
            android.graphics.drawable.GradientDrawable r10 = r0.f1138o
            android.graphics.drawable.Drawable r10 = androidx.core.graphics.drawable.DrawableCompat.wrap(r10)
            r0.f1139p = r10
            android.content.res.ColorStateList r12 = r0.f1132i
            androidx.core.graphics.drawable.DrawableCompat.setTintList(r10, r12)
            android.graphics.PorterDuff$Mode r10 = r0.f1131h
            if (r10 == 0) goto L_0x014c
            android.graphics.drawable.Drawable r12 = r0.f1139p
            androidx.core.graphics.drawable.DrawableCompat.setTintMode(r12, r10)
        L_0x014c:
            android.graphics.drawable.GradientDrawable r10 = new android.graphics.drawable.GradientDrawable
            r10.<init>()
            r0.f1140q = r10
            int r12 = r0.f1129f
            float r12 = (float) r12
            float r12 = r12 + r11
            r10.setCornerRadius(r12)
            android.graphics.drawable.GradientDrawable r10 = r0.f1140q
            r10.setColor(r5)
            android.graphics.drawable.GradientDrawable r5 = r0.f1140q
            android.graphics.drawable.Drawable r5 = androidx.core.graphics.drawable.DrawableCompat.wrap(r5)
            r0.f1141r = r5
            android.content.res.ColorStateList r10 = r0.f1134k
            androidx.core.graphics.drawable.DrawableCompat.setTintList(r5, r10)
            android.graphics.drawable.LayerDrawable r12 = new android.graphics.drawable.LayerDrawable
            android.graphics.drawable.Drawable[] r4 = new android.graphics.drawable.Drawable[r4]
            android.graphics.drawable.Drawable r5 = r0.f1139p
            r4[r2] = r5
            android.graphics.drawable.Drawable r2 = r0.f1141r
            r4[r3] = r2
            r12.<init>(r4)
            android.graphics.drawable.InsetDrawable r3 = new android.graphics.drawable.InsetDrawable
            int r13 = r0.f1125b
            int r14 = r0.f1127d
            int r15 = r0.f1126c
            int r2 = r0.f1128e
            r11 = r3
            r16 = r2
            r11.<init>(r12, r13, r14, r15, r16)
        L_0x018b:
            r9.mo25382a(r3)
            com.google.android.material.button.MaterialButton r2 = r0.f1124a
            int r3 = r0.f1125b
            int r1 = r1 + r3
            int r3 = r0.f1127d
            int r6 = r6 + r3
            int r3 = r0.f1126c
            int r7 = r7 + r3
            int r3 = r0.f1128e
            int r8 = r8 + r3
            androidx.core.view.ViewCompat.setPaddingRelative(r2, r1, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.button.C1173b.mo25396a(android.content.res.TypedArray):void");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo25397a(@Nullable Canvas canvas) {
        if (canvas != null && this.f1133j != null && this.f1130g > 0) {
            this.f1136m.set(this.f1124a.getBackground().getBounds());
            RectF rectF = this.f1137n;
            Rect rect = this.f1136m;
            int i = this.f1130g;
            rectF.set((((float) i) / 2.0f) + ((float) rect.left) + ((float) this.f1125b), (((float) i) / 2.0f) + ((float) rect.top) + ((float) this.f1127d), (((float) rect.right) - (((float) i) / 2.0f)) - ((float) this.f1126c), (((float) rect.bottom) - (((float) i) / 2.0f)) - ((float) this.f1128e));
            float f = ((float) this.f1129f) - (((float) this.f1130g) / 2.0f);
            canvas.drawRoundRect(this.f1137n, f, f, this.f1135l);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo25398a(@Nullable PorterDuff.Mode mode) {
        if (this.f1131h != mode) {
            this.f1131h = mode;
            if (f1123w) {
                m1755e();
                return;
            }
            Drawable drawable = this.f1139p;
            if (drawable != null && mode != null) {
                DrawableCompat.setTintMode(drawable, mode);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public PorterDuff.Mode mo25399b() {
        return this.f1131h;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo25400c() {
        return this.f1145v;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo25401d() {
        this.f1145v = true;
        this.f1124a.setSupportBackgroundTintList(this.f1132i);
        this.f1124a.setSupportBackgroundTintMode(this.f1131h);
    }
}
