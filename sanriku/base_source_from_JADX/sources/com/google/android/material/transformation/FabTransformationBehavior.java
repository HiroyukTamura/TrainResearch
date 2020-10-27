package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.List;
import p009e.p028d.p030b.p054b.C1532a;
import p009e.p028d.p030b.p054b.p055c.C1534a;
import p009e.p028d.p030b.p054b.p055c.C1535b;
import p009e.p028d.p030b.p054b.p055c.C1536c;
import p009e.p028d.p030b.p054b.p055c.C1537d;
import p009e.p028d.p030b.p054b.p055c.C1540g;
import p009e.p028d.p030b.p054b.p055c.C1541h;
import p009e.p028d.p030b.p054b.p055c.C1542i;
import p009e.p028d.p030b.p054b.p056d.C1543a;
import p009e.p028d.p030b.p054b.p056d.C1545b;
import p009e.p028d.p030b.p054b.p056d.C1546c;
import p009e.p028d.p030b.p054b.p058f.C1554a;
import p043jp.reifrontier.sanriku.R;

public abstract class FabTransformationBehavior extends ExpandableTransformationBehavior {

    /* renamed from: c */
    private final Rect f1336c = new Rect();

    /* renamed from: d */
    private final RectF f1337d = new RectF();

    /* renamed from: e */
    private final RectF f1338e = new RectF();

    /* renamed from: f */
    private final int[] f1339f = new int[2];

    /* renamed from: com.google.android.material.transformation.FabTransformationBehavior$a */
    class C1221a extends AnimatorListenerAdapter {

        /* renamed from: a */
        final /* synthetic */ boolean f1340a;

        /* renamed from: b */
        final /* synthetic */ View f1341b;

        /* renamed from: c */
        final /* synthetic */ View f1342c;

        C1221a(FabTransformationBehavior fabTransformationBehavior, boolean z, View view, View view2) {
            this.f1340a = z;
            this.f1341b = view;
            this.f1342c = view2;
        }

        public void onAnimationEnd(Animator animator) {
            if (!this.f1340a) {
                this.f1341b.setVisibility(4);
                this.f1342c.setAlpha(1.0f);
                this.f1342c.setVisibility(0);
            }
        }

        public void onAnimationStart(Animator animator) {
            if (this.f1340a) {
                this.f1341b.setVisibility(0);
                this.f1342c.setAlpha(0.0f);
                this.f1342c.setVisibility(4);
            }
        }
    }

    /* renamed from: com.google.android.material.transformation.FabTransformationBehavior$b */
    protected static class C1222b {

        /* renamed from: a */
        public C1540g f1343a;

        /* renamed from: b */
        public C1542i f1344b;

        protected C1222b() {
        }
    }

    public FabTransformationBehavior() {
    }

    public FabTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* renamed from: a */
    private float m1888a(View view, View view2, C1542i iVar) {
        float f;
        float f2;
        float f3;
        RectF rectF = this.f1337d;
        RectF rectF2 = this.f1338e;
        m1892a(view, rectF);
        m1892a(view2, rectF2);
        int i = iVar.f1787a & 7;
        if (i == 1) {
            f3 = rectF2.centerX();
            f2 = rectF.centerX();
        } else if (i == 3) {
            f3 = rectF2.left;
            f2 = rectF.left;
        } else if (i != 5) {
            f = 0.0f;
            return f + iVar.f1788b;
        } else {
            f3 = rectF2.right;
            f2 = rectF.right;
        }
        f = f3 - f2;
        return f + iVar.f1788b;
    }

    /* renamed from: a */
    private float m1889a(C1222b bVar, C1541h hVar, float f, float f2) {
        long a = hVar.mo27303a();
        long b = hVar.mo27305b();
        C1541h a2 = bVar.f1343a.mo27299a("expansion");
        long a3 = a2.mo27303a();
        return C1534a.m2149a(f, f2, hVar.mo27306c().getInterpolation(((float) (((a2.mo27305b() + a3) + 17) - a)) / ((float) b)));
    }

    @Nullable
    /* renamed from: a */
    private ViewGroup m1890a(View view) {
        if (view instanceof ViewGroup) {
            return (ViewGroup) view;
        }
        return null;
    }

    /* renamed from: a */
    private void m1891a(View view, long j, int i, int i2, float f, List<Animator> list) {
        if (Build.VERSION.SDK_INT >= 21 && j > 0) {
            Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(view, i, i2, f, f);
            createCircularReveal.setStartDelay(0);
            createCircularReveal.setDuration(j);
            list.add(createCircularReveal);
        }
    }

    /* renamed from: a */
    private void m1892a(View view, RectF rectF) {
        rectF.set(0.0f, 0.0f, (float) view.getWidth(), (float) view.getHeight());
        int[] iArr = this.f1339f;
        view.getLocationInWindow(iArr);
        rectF.offsetTo((float) iArr[0], (float) iArr[1]);
        rectF.offset((float) ((int) (-view.getTranslationX())), (float) ((int) (-view.getTranslationY())));
    }

    /* renamed from: b */
    private float m1893b(View view, View view2, C1542i iVar) {
        float f;
        float f2;
        float f3;
        RectF rectF = this.f1337d;
        RectF rectF2 = this.f1338e;
        m1892a(view, rectF);
        m1892a(view2, rectF2);
        int i = iVar.f1787a & 112;
        if (i == 16) {
            f3 = rectF2.centerY();
            f2 = rectF.centerY();
        } else if (i == 48) {
            f3 = rectF2.top;
            f2 = rectF.top;
        } else if (i != 80) {
            f = 0.0f;
            return f + iVar.f1789c;
        } else {
            f3 = rectF2.bottom;
            f2 = rectF.bottom;
        }
        f = f3 - f2;
        return f + iVar.f1789c;
    }

    /* access modifiers changed from: protected */
    @NonNull
    /* renamed from: b */
    public AnimatorSet mo25565b(View view, View view2, boolean z, boolean z2) {
        String str;
        C1540g gVar;
        C1541h hVar;
        ObjectAnimator objectAnimator;
        ObjectAnimator objectAnimator2;
        FabTransformationBehavior fabTransformationBehavior;
        ObjectAnimator objectAnimator3;
        ObjectAnimator objectAnimator4;
        C1546c cVar;
        C1541h hVar2;
        Animator animator;
        ObjectAnimator objectAnimator5;
        ObjectAnimator objectAnimator6;
        View view3 = view;
        View view4 = view2;
        boolean z3 = z;
        Context context = view2.getContext();
        int i = z3 ? R.animator.mtrl_fab_transformation_sheet_expand_spec : R.animator.mtrl_fab_transformation_sheet_collapse_spec;
        C1222b bVar = new C1222b();
        bVar.f1343a = C1540g.m2152a(context, i);
        bVar.f1344b = new C1542i(17, 0.0f, 0.0f);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (Build.VERSION.SDK_INT >= 21) {
            float elevation = ViewCompat.getElevation(view2) - ViewCompat.getElevation(view);
            if (z3) {
                if (!z2) {
                    view4.setTranslationZ(-elevation);
                }
                objectAnimator6 = ObjectAnimator.ofFloat(view4, View.TRANSLATION_Z, new float[]{0.0f});
            } else {
                objectAnimator6 = ObjectAnimator.ofFloat(view4, View.TRANSLATION_Z, new float[]{-elevation});
            }
            bVar.f1343a.mo27299a("elevation").mo27304a((Animator) objectAnimator6);
            arrayList.add(objectAnimator6);
        }
        RectF rectF = this.f1337d;
        float a = m1888a(view3, view4, bVar.f1344b);
        float b = m1893b(view3, view4, bVar.f1344b);
        if (a == 0.0f || b == 0.0f) {
            hVar = bVar.f1343a.mo27299a("translationXLinear");
            gVar = bVar.f1343a;
            str = "translationYLinear";
        } else if ((!z3 || b >= 0.0f) && (z3 || b <= 0.0f)) {
            hVar = bVar.f1343a.mo27299a("translationXCurveDownwards");
            gVar = bVar.f1343a;
            str = "translationYCurveDownwards";
        } else {
            hVar = bVar.f1343a.mo27299a("translationXCurveUpwards");
            gVar = bVar.f1343a;
            str = "translationYCurveUpwards";
        }
        C1541h a2 = gVar.mo27299a(str);
        if (z3) {
            if (!z2) {
                view4.setTranslationX(-a);
                view4.setTranslationY(-b);
            }
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view4, View.TRANSLATION_X, new float[]{0.0f});
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view4, View.TRANSLATION_Y, new float[]{0.0f});
            float a3 = m1889a(bVar, hVar, -a, 0.0f);
            float a4 = m1889a(bVar, a2, -b, 0.0f);
            Rect rect = this.f1336c;
            view4.getWindowVisibleDisplayFrame(rect);
            RectF rectF2 = this.f1337d;
            rectF2.set(rect);
            RectF rectF3 = this.f1338e;
            m1892a(view4, rectF3);
            rectF3.offset(a3, a4);
            rectF3.intersect(rectF2);
            rectF.set(rectF3);
            objectAnimator2 = ofFloat2;
            objectAnimator = ofFloat;
        } else {
            objectAnimator = ObjectAnimator.ofFloat(view4, View.TRANSLATION_X, new float[]{-a});
            objectAnimator2 = ObjectAnimator.ofFloat(view4, View.TRANSLATION_Y, new float[]{-b});
        }
        hVar.mo27304a((Animator) objectAnimator);
        a2.mo27304a((Animator) objectAnimator2);
        arrayList.add(objectAnimator);
        arrayList.add(objectAnimator2);
        float width = rectF.width();
        float height = rectF.height();
        boolean z4 = view4 instanceof C1546c;
        if (z4 && (view3 instanceof ImageView)) {
            C1546c cVar2 = (C1546c) view4;
            Drawable drawable = ((ImageView) view3).getDrawable();
            if (drawable != null) {
                drawable.mutate();
                if (z3) {
                    if (!z2) {
                        drawable.setAlpha(255);
                    }
                    objectAnimator5 = ObjectAnimator.ofInt(drawable, C1537d.f1775b, new int[]{0});
                } else {
                    objectAnimator5 = ObjectAnimator.ofInt(drawable, C1537d.f1775b, new int[]{255});
                }
                objectAnimator5.addUpdateListener(new C1224a(this, view4));
                bVar.f1343a.mo27299a("iconFade").mo27304a((Animator) objectAnimator5);
                arrayList.add(objectAnimator5);
                arrayList2.add(new C1225b(this, cVar2, drawable));
            }
        }
        if (z4) {
            C1546c cVar3 = (C1546c) view4;
            C1542i iVar = bVar.f1344b;
            RectF rectF4 = this.f1337d;
            RectF rectF5 = this.f1338e;
            m1892a(view3, rectF4);
            m1892a(view4, rectF5);
            rectF5.offset(-m1888a(view3, view4, iVar), 0.0f);
            float centerX = rectF4.centerX() - rectF5.left;
            C1542i iVar2 = bVar.f1344b;
            RectF rectF6 = this.f1337d;
            RectF rectF7 = this.f1338e;
            m1892a(view3, rectF6);
            m1892a(view4, rectF7);
            rectF7.offset(0.0f, -m1893b(view3, view4, iVar2));
            float centerY = rectF6.centerY() - rectF7.top;
            ((FloatingActionButton) view3).mo25407a(this.f1336c);
            float width2 = ((float) this.f1336c.width()) / 2.0f;
            C1541h a5 = bVar.f1343a.mo27299a("expansion");
            if (z3) {
                if (!z2) {
                    cVar3.mo27315a(new C1546c.C1551e(centerX, centerY, width2));
                }
                if (z2) {
                    width2 = cVar3.mo27312a().f1798c;
                }
                float a6 = C1554a.m2172a(centerX, centerY, 0.0f, 0.0f);
                float a7 = C1554a.m2172a(centerX, centerY, width, 0.0f);
                float a8 = C1554a.m2172a(centerX, centerY, width, height);
                float a9 = C1554a.m2172a(centerX, centerY, 0.0f, height);
                if (a6 > a7 && a6 > a8 && a6 > a9) {
                    a9 = a6;
                } else if (a7 > a8 && a7 > a9) {
                    a9 = a7;
                } else if (a8 > a9) {
                    a9 = a8;
                }
                Animator a10 = C1543a.m2162a(cVar3, centerX, centerY, a9);
                a10.addListener(new C1226c(this, cVar3));
                hVar2 = a5;
                m1891a(view2, a5.mo27303a(), (int) centerX, (int) centerY, width2, arrayList);
                cVar = cVar3;
                animator = a10;
            } else {
                hVar2 = a5;
                C1546c cVar4 = cVar3;
                float f = cVar4.mo27312a().f1798c;
                C1546c cVar5 = cVar4;
                Animator a11 = C1543a.m2162a(cVar5, centerX, centerY, width2);
                int i2 = (int) centerX;
                int i3 = (int) centerY;
                int i4 = i2;
                cVar = cVar5;
                float f2 = width2;
                m1891a(view2, hVar2.mo27303a(), i2, i3, f, arrayList);
                long a12 = hVar2.mo27303a();
                long b2 = hVar2.mo27305b();
                long a13 = bVar.f1343a.mo27298a();
                if (Build.VERSION.SDK_INT >= 21) {
                    long j = a12 + b2;
                    if (j < a13) {
                        Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(view4, i4, i3, f2, f2);
                        createCircularReveal.setStartDelay(j);
                        createCircularReveal.setDuration(a13 - j);
                        arrayList.add(createCircularReveal);
                    }
                }
                animator = a11;
            }
            hVar2.mo27304a(animator);
            arrayList.add(animator);
            arrayList2.add(C1543a.m2161a(cVar));
        }
        if (z4) {
            C1546c cVar6 = (C1546c) view4;
            ColorStateList backgroundTintList = ViewCompat.getBackgroundTintList(view);
            int colorForState = backgroundTintList != null ? backgroundTintList.getColorForState(view.getDrawableState(), backgroundTintList.getDefaultColor()) : 0;
            int i5 = 16777215 & colorForState;
            if (z3) {
                if (!z2) {
                    cVar6.mo27313a(colorForState);
                }
                objectAnimator4 = ObjectAnimator.ofInt(cVar6, C1546c.C1550d.f1795a, new int[]{i5});
            } else {
                objectAnimator4 = ObjectAnimator.ofInt(cVar6, C1546c.C1550d.f1795a, new int[]{colorForState});
            }
            objectAnimator4.setEvaluator(C1535b.m2151a());
            bVar.f1343a.mo27299a("color").mo27304a((Animator) objectAnimator4);
            arrayList.add(objectAnimator4);
        }
        if ((view4 instanceof ViewGroup) && (!z4 || C1545b.f1791a != 0)) {
            View findViewById = view4.findViewById(R.id.mtrl_child_content_container);
            fabTransformationBehavior = this;
            ViewGroup a14 = findViewById != null ? fabTransformationBehavior.m1890a(findViewById) : fabTransformationBehavior.m1890a(view4);
            if (a14 != null) {
                if (z3) {
                    if (!z2) {
                        C1536c.f1774a.set(a14, Float.valueOf(0.0f));
                    }
                    objectAnimator3 = ObjectAnimator.ofFloat(a14, C1536c.f1774a, new float[]{1.0f});
                } else {
                    objectAnimator3 = ObjectAnimator.ofFloat(a14, C1536c.f1774a, new float[]{0.0f});
                }
                bVar.f1343a.mo27299a("contentFade").mo27304a((Animator) objectAnimator3);
                arrayList.add(objectAnimator3);
            }
        } else {
            fabTransformationBehavior = this;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        C1532a.m2136a(animatorSet, (List<Animator>) arrayList);
        animatorSet.addListener(new C1221a(fabTransformationBehavior, z3, view4, view));
        int size = arrayList2.size();
        for (int i6 = 0; i6 < size; i6++) {
            animatorSet.addListener((Animator.AnimatorListener) arrayList2.get(i6));
        }
        return animatorSet;
    }

    @CallSuper
    public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, View view, View view2) {
        if (view.getVisibility() == 8) {
            throw new IllegalStateException("This behavior cannot be attached to a GONE view. Set the view to INVISIBLE instead.");
        } else if (!(view2 instanceof FloatingActionButton)) {
            return false;
        } else {
            FloatingActionButton floatingActionButton = (FloatingActionButton) view2;
            throw null;
        }
    }

    @CallSuper
    public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
        if (layoutParams.dodgeInsetEdges == 0) {
            layoutParams.dodgeInsetEdges = 80;
        }
    }
}
