package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.internal.C1193c;
import com.google.android.material.internal.C1197e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p009e.p028d.p030b.p054b.C1532a;
import p009e.p028d.p030b.p054b.p055c.C1534a;
import p009e.p028d.p030b.p054b.p055c.C1538e;
import p009e.p028d.p030b.p054b.p055c.C1539f;
import p009e.p028d.p030b.p054b.p055c.C1540g;
import p009e.p028d.p030b.p054b.p060h.C1557b;
import p043jp.reifrontier.sanriku.R;

/* renamed from: com.google.android.material.floatingactionbutton.b */
class C1178b {

    /* renamed from: t */
    static final TimeInterpolator f1161t = C1534a.f1770b;

    /* renamed from: u */
    static final int[] f1162u = {16842919, 16842910};

    /* renamed from: v */
    static final int[] f1163v = {16843623, 16842908, 16842910};

    /* renamed from: w */
    static final int[] f1164w = {16842908, 16842910};

    /* renamed from: x */
    static final int[] f1165x = {16843623, 16842910};

    /* renamed from: y */
    static final int[] f1166y = {16842910};

    /* renamed from: z */
    static final int[] f1167z = new int[0];

    /* renamed from: a */
    int f1168a = 0;
    @Nullable

    /* renamed from: b */
    Animator f1169b;
    @Nullable

    /* renamed from: c */
    private C1540g f1170c;
    @Nullable

    /* renamed from: d */
    private C1540g f1171d;

    /* renamed from: e */
    private final C1193c f1172e;

    /* renamed from: f */
    private float f1173f;

    /* renamed from: g */
    float f1174g;

    /* renamed from: h */
    float f1175h;

    /* renamed from: i */
    float f1176i;

    /* renamed from: j */
    float f1177j = 1.0f;

    /* renamed from: k */
    private ArrayList<Animator.AnimatorListener> f1178k;

    /* renamed from: l */
    private ArrayList<Animator.AnimatorListener> f1179l;

    /* renamed from: m */
    final C1197e f1180m;

    /* renamed from: n */
    final C1557b f1181n;

    /* renamed from: o */
    private final Rect f1182o = new Rect();

    /* renamed from: p */
    private final RectF f1183p = new RectF();

    /* renamed from: q */
    private final RectF f1184q = new RectF();

    /* renamed from: r */
    private final Matrix f1185r = new Matrix();

    /* renamed from: s */
    private ViewTreeObserver.OnPreDrawListener f1186s;

    /* renamed from: com.google.android.material.floatingactionbutton.b$a */
    class C1179a extends AnimatorListenerAdapter {

        /* renamed from: a */
        private boolean f1187a;

        /* renamed from: b */
        final /* synthetic */ boolean f1188b;

        /* renamed from: c */
        final /* synthetic */ C1184f f1189c;

        C1179a(boolean z, C1184f fVar) {
            this.f1188b = z;
            this.f1189c = fVar;
        }

        public void onAnimationCancel(Animator animator) {
            this.f1187a = true;
        }

        public void onAnimationEnd(Animator animator) {
            C1178b bVar = C1178b.this;
            bVar.f1168a = 0;
            bVar.f1169b = null;
            if (!this.f1187a) {
                bVar.f1180m.mo25480a(this.f1188b ? 8 : 4, this.f1188b);
                C1184f fVar = this.f1189c;
                if (fVar != null) {
                    C1177a aVar = (C1177a) fVar;
                    throw null;
                }
            }
        }

        public void onAnimationStart(Animator animator) {
            C1178b.this.f1180m.mo25480a(0, this.f1188b);
            C1178b bVar = C1178b.this;
            bVar.f1168a = 1;
            bVar.f1169b = animator;
            this.f1187a = false;
        }
    }

    /* renamed from: com.google.android.material.floatingactionbutton.b$b */
    class C1180b extends AnimatorListenerAdapter {

        /* renamed from: a */
        final /* synthetic */ boolean f1191a;

        /* renamed from: b */
        final /* synthetic */ C1184f f1192b;

        C1180b(boolean z, C1184f fVar) {
            this.f1191a = z;
            this.f1192b = fVar;
        }

        public void onAnimationEnd(Animator animator) {
            C1178b bVar = C1178b.this;
            bVar.f1168a = 0;
            bVar.f1169b = null;
            C1184f fVar = this.f1192b;
            if (fVar != null) {
                C1177a aVar = (C1177a) fVar;
                throw null;
            }
        }

        public void onAnimationStart(Animator animator) {
            C1178b.this.f1180m.mo25480a(0, this.f1191a);
            C1178b bVar = C1178b.this;
            bVar.f1168a = 2;
            bVar.f1169b = animator;
        }
    }

    /* renamed from: com.google.android.material.floatingactionbutton.b$c */
    private class C1181c extends C1186h {
        C1181c(C1178b bVar) {
            super((C1179a) null);
        }
    }

    /* renamed from: com.google.android.material.floatingactionbutton.b$d */
    private class C1182d extends C1186h {
        C1182d() {
            super((C1179a) null);
        }
    }

    /* renamed from: com.google.android.material.floatingactionbutton.b$e */
    private class C1183e extends C1186h {
        C1183e() {
            super((C1179a) null);
        }
    }

    /* renamed from: com.google.android.material.floatingactionbutton.b$f */
    interface C1184f {
    }

    /* renamed from: com.google.android.material.floatingactionbutton.b$g */
    private class C1185g extends C1186h {
        C1185g() {
            super((C1179a) null);
        }
    }

    /* renamed from: com.google.android.material.floatingactionbutton.b$h */
    private abstract class C1186h extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a */
        private boolean f1197a;

        /* synthetic */ C1186h(C1179a aVar) {
        }

        public void onAnimationEnd(Animator animator) {
            throw null;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (!this.f1197a) {
                throw null;
            }
            valueAnimator.getAnimatedFraction();
            throw null;
        }
    }

    C1178b(C1197e eVar, C1557b bVar) {
        this.f1180m = eVar;
        this.f1181n = bVar;
        C1193c cVar = new C1193c();
        this.f1172e = cVar;
        cVar.mo25478a(f1162u, m1791a((C1186h) new C1183e()));
        this.f1172e.mo25478a(f1163v, m1791a((C1186h) new C1182d()));
        this.f1172e.mo25478a(f1164w, m1791a((C1186h) new C1182d()));
        this.f1172e.mo25478a(f1165x, m1791a((C1186h) new C1182d()));
        this.f1172e.mo25478a(f1166y, m1791a((C1186h) new C1185g()));
        this.f1172e.mo25478a(f1167z, m1791a((C1186h) new C1181c(this)));
        this.f1173f = this.f1180m.getRotation();
    }

    @NonNull
    /* renamed from: a */
    private AnimatorSet m1790a(@NonNull C1540g gVar, float f, float f2, float f3) {
        ArrayList arrayList = new ArrayList();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f1180m, View.ALPHA, new float[]{f});
        gVar.mo27299a("opacity").mo27304a((Animator) ofFloat);
        arrayList.add(ofFloat);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f1180m, View.SCALE_X, new float[]{f2});
        gVar.mo27299a("scale").mo27304a((Animator) ofFloat2);
        arrayList.add(ofFloat2);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.f1180m, View.SCALE_Y, new float[]{f2});
        gVar.mo27299a("scale").mo27304a((Animator) ofFloat3);
        arrayList.add(ofFloat3);
        this.f1185r.reset();
        this.f1180m.getDrawable();
        ObjectAnimator ofObject = ObjectAnimator.ofObject(this.f1180m, new C1538e(), new C1539f(), new Matrix[]{new Matrix(this.f1185r)});
        gVar.mo27299a("iconScale").mo27304a((Animator) ofObject);
        arrayList.add(ofObject);
        AnimatorSet animatorSet = new AnimatorSet();
        C1532a.m2136a(animatorSet, (List<Animator>) arrayList);
        return animatorSet;
    }

    /* renamed from: a */
    private ValueAnimator m1791a(@NonNull C1186h hVar) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setInterpolator(f1161t);
        valueAnimator.setDuration(100);
        valueAnimator.addListener(hVar);
        valueAnimator.addUpdateListener(hVar);
        valueAnimator.setFloatValues(new float[]{0.0f, 1.0f});
        return valueAnimator;
    }

    /* renamed from: h */
    private boolean m1792h() {
        return ViewCompat.isLaidOut(this.f1180m) && !this.f1180m.isInEditMode();
    }

    /* renamed from: a */
    public void mo25434a(@NonNull Animator.AnimatorListener animatorListener) {
        if (this.f1179l == null) {
            this.f1179l = new ArrayList<>();
        }
        this.f1179l.add(animatorListener);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo25435a(Rect rect) {
        throw null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo25437a(int[] iArr) {
        this.f1172e.mo25477a(iArr);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo25438a() {
        return this.f1180m.getVisibility() != 0 ? this.f1168a == 2 : this.f1168a != 1;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo25439b() {
        this.f1172e.mo25476a();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo25440b(@NonNull Animator.AnimatorListener animatorListener) {
        if (this.f1178k == null) {
            this.f1178k = new ArrayList<>();
        }
        this.f1178k.add(animatorListener);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo25441b(Rect rect) {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo25442b(@Nullable C1184f fVar, boolean z) {
        if (!mo25438a()) {
            Animator animator = this.f1169b;
            if (animator != null) {
                animator.cancel();
            }
            if (m1792h()) {
                if (this.f1180m.getVisibility() != 0) {
                    this.f1180m.setAlpha(0.0f);
                    this.f1180m.setScaleY(0.0f);
                    this.f1180m.setScaleX(0.0f);
                    mo25433a(0.0f);
                }
                if (this.f1170c == null) {
                    this.f1170c = C1540g.m2152a(this.f1180m.getContext(), R.animator.design_fab_show_motion_spec);
                }
                AnimatorSet a = m1790a(this.f1170c, 1.0f, 1.0f, 1.0f);
                a.addListener(new C1180b(z, fVar));
                ArrayList<Animator.AnimatorListener> arrayList = this.f1178k;
                if (arrayList != null) {
                    Iterator<Animator.AnimatorListener> it = arrayList.iterator();
                    while (it.hasNext()) {
                        a.addListener(it.next());
                    }
                }
                a.start();
                return;
            }
            this.f1180m.mo25480a(0, z);
            this.f1180m.setAlpha(1.0f);
            this.f1180m.setScaleY(1.0f);
            this.f1180m.setScaleX(1.0f);
            mo25433a(1.0f);
            if (fVar != null) {
                throw null;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo25443c() {
        if (mo25448f()) {
            if (this.f1186s == null) {
                this.f1186s = new C1187c(this);
            }
            this.f1180m.getViewTreeObserver().addOnPreDrawListener(this.f1186s);
        }
    }

    /* renamed from: c */
    public void mo25444c(@NonNull Animator.AnimatorListener animatorListener) {
        ArrayList<Animator.AnimatorListener> arrayList = this.f1179l;
        if (arrayList != null) {
            arrayList.remove(animatorListener);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo25445d() {
        if (this.f1186s != null) {
            this.f1180m.getViewTreeObserver().removeOnPreDrawListener(this.f1186s);
            this.f1186s = null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo25446d(@NonNull Animator.AnimatorListener animatorListener) {
        ArrayList<Animator.AnimatorListener> arrayList = this.f1178k;
        if (arrayList != null) {
            arrayList.remove(animatorListener);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo25447e() {
        int i;
        C1197e eVar;
        float rotation = this.f1180m.getRotation();
        if (this.f1173f != rotation) {
            this.f1173f = rotation;
            if (Build.VERSION.SDK_INT == 19) {
                if (rotation % 90.0f != 0.0f) {
                    i = 1;
                    if (this.f1180m.getLayerType() != 1) {
                        eVar = this.f1180m;
                    } else {
                        return;
                    }
                } else if (this.f1180m.getLayerType() != 0) {
                    eVar = this.f1180m;
                    i = 0;
                } else {
                    return;
                }
                eVar.setLayerType(i, (Paint) null);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public boolean mo25448f() {
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public final void mo25449g() {
        Rect rect = this.f1182o;
        mo25435a(rect);
        mo25441b(rect);
        C1557b bVar = this.f1181n;
        int i = rect.left;
        int i2 = rect.top;
        int i3 = rect.right;
        int i4 = rect.bottom;
        FloatingActionButton.C1176b bVar2 = (FloatingActionButton.C1176b) bVar;
        FloatingActionButton.this.f1156h.set(i, i2, i3, i4);
        FloatingActionButton floatingActionButton = FloatingActionButton.this;
        floatingActionButton.setPadding(i + floatingActionButton.f1154f, i2 + FloatingActionButton.this.f1154f, i3 + FloatingActionButton.this.f1154f, i4 + FloatingActionButton.this.f1154f);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo25436a(@Nullable C1184f fVar, boolean z) {
        boolean z2 = true;
        if (this.f1180m.getVisibility() != 0 ? this.f1168a == 2 : this.f1168a != 1) {
            z2 = false;
        }
        if (!z2) {
            Animator animator = this.f1169b;
            if (animator != null) {
                animator.cancel();
            }
            if (m1792h()) {
                if (this.f1171d == null) {
                    this.f1171d = C1540g.m2152a(this.f1180m.getContext(), R.animator.design_fab_hide_motion_spec);
                }
                AnimatorSet a = m1790a(this.f1171d, 0.0f, 0.0f, 0.0f);
                a.addListener(new C1179a(z, fVar));
                ArrayList<Animator.AnimatorListener> arrayList = this.f1179l;
                if (arrayList != null) {
                    Iterator<Animator.AnimatorListener> it = arrayList.iterator();
                    while (it.hasNext()) {
                        a.addListener(it.next());
                    }
                }
                a.start();
                return;
            }
            this.f1180m.mo25480a(z ? 8 : 4, z);
            if (fVar != null) {
                throw null;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo25433a(float f) {
        this.f1177j = f;
        Matrix matrix = this.f1185r;
        matrix.reset();
        this.f1180m.getDrawable();
        this.f1180m.setImageMatrix(matrix);
    }
}
