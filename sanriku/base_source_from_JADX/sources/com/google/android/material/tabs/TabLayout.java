package com.google.android.material.tabs;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Dimension;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.C0043R;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.util.Pools;
import androidx.core.view.GravityCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.internal.C1196d;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import p009e.p028d.p030b.p054b.C1532a;
import p009e.p028d.p030b.p054b.C1533b;
import p009e.p028d.p030b.p054b.p055c.C1534a;
import p043jp.reifrontier.gym.C2092R;
import p043jp.reifrontier.sanriku.R;

@ViewPager.DecorView
public class TabLayout extends HorizontalScrollView {

    /* renamed from: P */
    private static final Pools.Pool<C1213f> f1245P = new Pools.SynchronizedPool(16);

    /* renamed from: A */
    int f1246A;

    /* renamed from: B */
    int f1247B;

    /* renamed from: C */
    boolean f1248C;

    /* renamed from: D */
    boolean f1249D;

    /* renamed from: E */
    boolean f1250E;

    /* renamed from: F */
    private final ArrayList<C1207b> f1251F;

    /* renamed from: G */
    private C1207b f1252G;

    /* renamed from: H */
    private ValueAnimator f1253H;

    /* renamed from: I */
    ViewPager f1254I;

    /* renamed from: J */
    private PagerAdapter f1255J;

    /* renamed from: K */
    private DataSetObserver f1256K;

    /* renamed from: L */
    private C1214g f1257L;

    /* renamed from: M */
    private C1206a f1258M;

    /* renamed from: N */
    private boolean f1259N;

    /* renamed from: O */
    private final Pools.Pool<C1215h> f1260O;

    /* renamed from: a */
    private final ArrayList<C1213f> f1261a;

    /* renamed from: b */
    private C1213f f1262b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final RectF f1263c;

    /* renamed from: d */
    private final C1210e f1264d;

    /* renamed from: e */
    int f1265e;

    /* renamed from: f */
    int f1266f;

    /* renamed from: g */
    int f1267g;

    /* renamed from: h */
    int f1268h;

    /* renamed from: i */
    int f1269i;

    /* renamed from: l */
    ColorStateList f1270l;

    /* renamed from: m */
    ColorStateList f1271m;

    /* renamed from: n */
    ColorStateList f1272n;
    @Nullable

    /* renamed from: o */
    Drawable f1273o;

    /* renamed from: p */
    PorterDuff.Mode f1274p;

    /* renamed from: q */
    float f1275q;

    /* renamed from: r */
    float f1276r;

    /* renamed from: s */
    final int f1277s;

    /* renamed from: t */
    int f1278t;

    /* renamed from: u */
    private final int f1279u;

    /* renamed from: v */
    private final int f1280v;

    /* renamed from: w */
    private final int f1281w;

    /* renamed from: x */
    private int f1282x;

    /* renamed from: y */
    int f1283y;

    /* renamed from: z */
    int f1284z;

    /* renamed from: com.google.android.material.tabs.TabLayout$a */
    private class C1206a implements ViewPager.OnAdapterChangeListener {

        /* renamed from: a */
        private boolean f1285a;

        C1206a() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo25521a(boolean z) {
            this.f1285a = z;
        }

        public void onAdapterChanged(@NonNull ViewPager viewPager, @Nullable PagerAdapter pagerAdapter, @Nullable PagerAdapter pagerAdapter2) {
            TabLayout tabLayout = TabLayout.this;
            if (tabLayout.f1254I == viewPager) {
                tabLayout.mo25501a(pagerAdapter2, this.f1285a);
            }
        }
    }

    /* renamed from: com.google.android.material.tabs.TabLayout$b */
    public interface C1207b<T extends C1213f> {
        void onTabReselected(T t);

        void onTabSelected(T t);

        void onTabUnselected(T t);
    }

    /* renamed from: com.google.android.material.tabs.TabLayout$c */
    public interface C1208c extends C1207b<C1213f> {
    }

    /* renamed from: com.google.android.material.tabs.TabLayout$d */
    private class C1209d extends DataSetObserver {
        C1209d() {
        }

        public void onChanged() {
            TabLayout.this.mo25514d();
        }

        public void onInvalidated() {
            TabLayout.this.mo25514d();
        }
    }

    /* renamed from: com.google.android.material.tabs.TabLayout$e */
    private class C1210e extends LinearLayout {

        /* renamed from: a */
        private int f1288a;

        /* renamed from: b */
        private final Paint f1289b;

        /* renamed from: c */
        private final GradientDrawable f1290c;

        /* renamed from: d */
        int f1291d = -1;

        /* renamed from: e */
        float f1292e;

        /* renamed from: f */
        private int f1293f = -1;

        /* renamed from: g */
        private int f1294g = -1;

        /* renamed from: h */
        private int f1295h = -1;

        /* renamed from: i */
        private ValueAnimator f1296i;

        /* renamed from: com.google.android.material.tabs.TabLayout$e$a */
        class C1211a implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: a */
            final /* synthetic */ int f1298a;

            /* renamed from: b */
            final /* synthetic */ int f1299b;

            /* renamed from: c */
            final /* synthetic */ int f1300c;

            /* renamed from: d */
            final /* synthetic */ int f1301d;

            C1211a(int i, int i2, int i3, int i4) {
                this.f1298a = i;
                this.f1299b = i2;
                this.f1300c = i3;
                this.f1301d = i4;
            }

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                C1210e eVar = C1210e.this;
                int a = C1534a.m2150a(this.f1298a, this.f1299b, animatedFraction);
                int i = this.f1300c;
                eVar.mo25531b(a, Math.round(animatedFraction * ((float) (this.f1301d - i))) + i);
            }
        }

        /* renamed from: com.google.android.material.tabs.TabLayout$e$b */
        class C1212b extends AnimatorListenerAdapter {

            /* renamed from: a */
            final /* synthetic */ int f1303a;

            C1212b(int i) {
                this.f1303a = i;
            }

            public void onAnimationEnd(Animator animator) {
                C1210e eVar = C1210e.this;
                eVar.f1291d = this.f1303a;
                eVar.f1292e = 0.0f;
            }
        }

        C1210e(Context context) {
            super(context);
            setWillNotDraw(false);
            this.f1289b = new Paint();
            this.f1290c = new GradientDrawable();
        }

        /* renamed from: a */
        private void m1852a() {
            int i;
            int i2;
            View childAt = getChildAt(this.f1291d);
            if (childAt == null || childAt.getWidth() <= 0) {
                i2 = -1;
                i = -1;
            } else {
                i2 = childAt.getLeft();
                i = childAt.getRight();
                TabLayout tabLayout = TabLayout.this;
                if (!tabLayout.f1249D && (childAt instanceof C1215h)) {
                    m1853a((C1215h) childAt, tabLayout.f1263c);
                    i2 = (int) TabLayout.this.f1263c.left;
                    i = (int) TabLayout.this.f1263c.right;
                }
                if (this.f1292e > 0.0f && this.f1291d < getChildCount() - 1) {
                    View childAt2 = getChildAt(this.f1291d + 1);
                    int left = childAt2.getLeft();
                    int right = childAt2.getRight();
                    TabLayout tabLayout2 = TabLayout.this;
                    if (!tabLayout2.f1249D && (childAt2 instanceof C1215h)) {
                        m1853a((C1215h) childAt2, tabLayout2.f1263c);
                        left = (int) TabLayout.this.f1263c.left;
                        right = (int) TabLayout.this.f1263c.right;
                    }
                    float f = this.f1292e;
                    i2 = (int) (((1.0f - f) * ((float) i2)) + (((float) left) * f));
                    i = (int) (((1.0f - f) * ((float) i)) + (((float) right) * f));
                }
            }
            if (i2 != this.f1294g || i != this.f1295h) {
                this.f1294g = i2;
                this.f1295h = i;
                ViewCompat.postInvalidateOnAnimation(this);
            }
        }

        /* renamed from: a */
        private void m1853a(C1215h hVar, RectF rectF) {
            int a = C1215h.m1876a(hVar);
            if (a < TabLayout.this.mo25499a(24)) {
                a = TabLayout.this.mo25499a(24);
            }
            int right = (hVar.getRight() + hVar.getLeft()) / 2;
            int i = a / 2;
            rectF.set((float) (right - i), 0.0f, (float) (right + i), 0.0f);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo25527a(int i) {
            if (this.f1289b.getColor() != i) {
                this.f1289b.setColor(i);
                ViewCompat.postInvalidateOnAnimation(this);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo25528a(int i, float f) {
            ValueAnimator valueAnimator = this.f1296i;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.f1296i.cancel();
            }
            this.f1291d = i;
            this.f1292e = f;
            m1852a();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo25529a(int i, int i2) {
            ValueAnimator valueAnimator = this.f1296i;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.f1296i.cancel();
            }
            View childAt = getChildAt(i);
            if (childAt == null) {
                m1852a();
                return;
            }
            int left = childAt.getLeft();
            int right = childAt.getRight();
            TabLayout tabLayout = TabLayout.this;
            if (!tabLayout.f1249D && (childAt instanceof C1215h)) {
                m1853a((C1215h) childAt, tabLayout.f1263c);
                left = (int) TabLayout.this.f1263c.left;
                right = (int) TabLayout.this.f1263c.right;
            }
            int i3 = left;
            int i4 = right;
            int i5 = this.f1294g;
            int i6 = this.f1295h;
            if (i5 != i3 || i6 != i4) {
                ValueAnimator valueAnimator2 = new ValueAnimator();
                this.f1296i = valueAnimator2;
                valueAnimator2.setInterpolator(C1534a.f1769a);
                valueAnimator2.setDuration((long) i2);
                valueAnimator2.setFloatValues(new float[]{0.0f, 1.0f});
                valueAnimator2.addUpdateListener(new C1211a(i5, i3, i6, i4));
                valueAnimator2.addListener(new C1212b(i));
                valueAnimator2.start();
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo25530b(int i) {
            if (this.f1288a != i) {
                this.f1288a = i;
                ViewCompat.postInvalidateOnAnimation(this);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo25531b(int i, int i2) {
            if (i != this.f1294g || i2 != this.f1295h) {
                this.f1294g = i;
                this.f1295h = i2;
                ViewCompat.postInvalidateOnAnimation(this);
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:24:0x0049  */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x005a  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void draw(android.graphics.Canvas r6) {
            /*
                r5 = this;
                com.google.android.material.tabs.TabLayout r0 = com.google.android.material.tabs.TabLayout.this
                android.graphics.drawable.Drawable r0 = r0.f1273o
                r1 = 0
                if (r0 == 0) goto L_0x000c
                int r0 = r0.getIntrinsicHeight()
                goto L_0x000d
            L_0x000c:
                r0 = 0
            L_0x000d:
                int r2 = r5.f1288a
                if (r2 < 0) goto L_0x0012
                r0 = r2
            L_0x0012:
                com.google.android.material.tabs.TabLayout r2 = com.google.android.material.tabs.TabLayout.this
                int r2 = r2.f1246A
                if (r2 == 0) goto L_0x0031
                r3 = 1
                r4 = 2
                if (r2 == r3) goto L_0x0023
                if (r2 == r4) goto L_0x003a
                r0 = 3
                if (r2 == r0) goto L_0x0036
                r0 = 0
                goto L_0x003a
            L_0x0023:
                int r1 = r5.getHeight()
                int r1 = r1 - r0
                int r1 = r1 / r4
                int r2 = r5.getHeight()
                int r2 = r2 + r0
                int r0 = r2 / 2
                goto L_0x003a
            L_0x0031:
                int r1 = r5.getHeight()
                int r1 = r1 - r0
            L_0x0036:
                int r0 = r5.getHeight()
            L_0x003a:
                int r2 = r5.f1294g
                if (r2 < 0) goto L_0x0070
                int r3 = r5.f1295h
                if (r3 <= r2) goto L_0x0070
                com.google.android.material.tabs.TabLayout r2 = com.google.android.material.tabs.TabLayout.this
                android.graphics.drawable.Drawable r2 = r2.f1273o
                if (r2 == 0) goto L_0x0049
                goto L_0x004b
            L_0x0049:
                android.graphics.drawable.GradientDrawable r2 = r5.f1290c
            L_0x004b:
                android.graphics.drawable.Drawable r2 = androidx.core.graphics.drawable.DrawableCompat.wrap(r2)
                int r3 = r5.f1294g
                int r4 = r5.f1295h
                r2.setBounds(r3, r1, r4, r0)
                android.graphics.Paint r0 = r5.f1289b
                if (r0 == 0) goto L_0x006d
                int r1 = android.os.Build.VERSION.SDK_INT
                r3 = 21
                int r0 = r0.getColor()
                if (r1 != r3) goto L_0x006a
                android.graphics.PorterDuff$Mode r1 = android.graphics.PorterDuff.Mode.SRC_IN
                r2.setColorFilter(r0, r1)
                goto L_0x006d
            L_0x006a:
                androidx.core.graphics.drawable.DrawableCompat.setTint(r2, r0)
            L_0x006d:
                r2.draw(r6)
            L_0x0070:
                super.draw(r6)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.tabs.TabLayout.C1210e.draw(android.graphics.Canvas):void");
        }

        /* access modifiers changed from: protected */
        public void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            ValueAnimator valueAnimator = this.f1296i;
            if (valueAnimator == null || !valueAnimator.isRunning()) {
                m1852a();
                return;
            }
            this.f1296i.cancel();
            mo25529a(this.f1291d, Math.round((1.0f - this.f1296i.getAnimatedFraction()) * ((float) this.f1296i.getDuration())));
        }

        /* access modifiers changed from: protected */
        public void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            if (View.MeasureSpec.getMode(i) == 1073741824) {
                TabLayout tabLayout = TabLayout.this;
                boolean z = true;
                if (tabLayout.f1247B == 1 && tabLayout.f1283y == 1) {
                    int childCount = getChildCount();
                    int i3 = 0;
                    for (int i4 = 0; i4 < childCount; i4++) {
                        View childAt = getChildAt(i4);
                        if (childAt.getVisibility() == 0) {
                            i3 = Math.max(i3, childAt.getMeasuredWidth());
                        }
                    }
                    if (i3 > 0) {
                        if (i3 * childCount <= getMeasuredWidth() - (TabLayout.this.mo25499a(16) * 2)) {
                            boolean z2 = false;
                            for (int i5 = 0; i5 < childCount; i5++) {
                                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getChildAt(i5).getLayoutParams();
                                if (layoutParams.width != i3 || layoutParams.weight != 0.0f) {
                                    layoutParams.width = i3;
                                    layoutParams.weight = 0.0f;
                                    z2 = true;
                                }
                            }
                            z = z2;
                        } else {
                            TabLayout tabLayout2 = TabLayout.this;
                            tabLayout2.f1283y = 0;
                            tabLayout2.mo25505a(false);
                        }
                        if (z) {
                            super.onMeasure(i, i2);
                        }
                    }
                }
            }
        }

        public void onRtlPropertiesChanged(int i) {
            super.onRtlPropertiesChanged(i);
            if (Build.VERSION.SDK_INT < 23 && this.f1293f != i) {
                requestLayout();
                this.f1293f = i;
            }
        }
    }

    /* renamed from: com.google.android.material.tabs.TabLayout$f */
    public static class C1213f {

        /* renamed from: a */
        private Drawable f1305a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public CharSequence f1306b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public CharSequence f1307c;

        /* renamed from: d */
        private int f1308d = -1;

        /* renamed from: e */
        private View f1309e;

        /* renamed from: f */
        public TabLayout f1310f;

        /* renamed from: g */
        public C1215h f1311g;

        @Nullable
        /* renamed from: a */
        public View mo25538a() {
            return this.f1309e;
        }

        @NonNull
        /* renamed from: a */
        public C1213f mo25539a(@LayoutRes int i) {
            this.f1309e = LayoutInflater.from(this.f1311g.getContext()).inflate(i, this.f1311g, false);
            mo25551h();
            return this;
        }

        @NonNull
        /* renamed from: a */
        public C1213f mo25540a(@Nullable Drawable drawable) {
            this.f1305a = drawable;
            mo25551h();
            return this;
        }

        @NonNull
        /* renamed from: a */
        public C1213f mo25541a(@Nullable View view) {
            this.f1309e = view;
            mo25551h();
            return this;
        }

        @NonNull
        /* renamed from: a */
        public C1213f mo25542a(@Nullable CharSequence charSequence) {
            this.f1307c = charSequence;
            mo25551h();
            return this;
        }

        @Nullable
        /* renamed from: b */
        public Drawable mo25543b() {
            return this.f1305a;
        }

        @NonNull
        /* renamed from: b */
        public C1213f mo25544b(@Nullable CharSequence charSequence) {
            if (TextUtils.isEmpty(this.f1307c) && !TextUtils.isEmpty(charSequence)) {
                this.f1311g.setContentDescription(charSequence);
            }
            this.f1306b = charSequence;
            mo25551h();
            return this;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo25545b(int i) {
            this.f1308d = i;
        }

        /* renamed from: c */
        public int mo25546c() {
            return this.f1308d;
        }

        @Nullable
        /* renamed from: d */
        public CharSequence mo25547d() {
            return this.f1306b;
        }

        /* renamed from: e */
        public boolean mo25548e() {
            TabLayout tabLayout = this.f1310f;
            if (tabLayout != null) {
                return tabLayout.mo25498a() == this.f1308d;
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        /* access modifiers changed from: package-private */
        /* renamed from: f */
        public void mo25549f() {
            this.f1310f = null;
            this.f1311g = null;
            this.f1305a = null;
            this.f1306b = null;
            this.f1307c = null;
            this.f1308d = -1;
            this.f1309e = null;
        }

        /* renamed from: g */
        public void mo25550g() {
            TabLayout tabLayout = this.f1310f;
            if (tabLayout != null) {
                tabLayout.mo25512b(this, true);
                return;
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        /* access modifiers changed from: package-private */
        /* renamed from: h */
        public void mo25551h() {
            C1215h hVar = this.f1311g;
            if (hVar != null) {
                hVar.mo25555b();
            }
        }
    }

    /* renamed from: com.google.android.material.tabs.TabLayout$g */
    public static class C1214g implements ViewPager.OnPageChangeListener {

        /* renamed from: a */
        private final WeakReference<TabLayout> f1312a;

        /* renamed from: b */
        private int f1313b;

        /* renamed from: c */
        private int f1314c;

        public C1214g(TabLayout tabLayout) {
            this.f1312a = new WeakReference<>(tabLayout);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo25552a() {
            this.f1314c = 0;
            this.f1313b = 0;
        }

        public void onPageScrollStateChanged(int i) {
            this.f1313b = this.f1314c;
            this.f1314c = i;
        }

        public void onPageScrolled(int i, float f, int i2) {
            TabLayout tabLayout = (TabLayout) this.f1312a.get();
            if (tabLayout != null) {
                boolean z = false;
                boolean z2 = this.f1314c != 2 || this.f1313b == 1;
                if (!(this.f1314c == 2 && this.f1313b == 0)) {
                    z = true;
                }
                tabLayout.mo25500a(i, f, z2, z);
            }
        }

        public void onPageSelected(int i) {
            TabLayout tabLayout = (TabLayout) this.f1312a.get();
            if (tabLayout != null && tabLayout.mo25498a() != i && i < tabLayout.mo25510b()) {
                int i2 = this.f1314c;
                tabLayout.mo25512b(tabLayout.mo25511b(i), i2 == 0 || (i2 == 2 && this.f1313b == 0));
            }
        }
    }

    /* renamed from: com.google.android.material.tabs.TabLayout$h */
    class C1215h extends LinearLayout {

        /* renamed from: a */
        private C1213f f1315a;

        /* renamed from: b */
        private TextView f1316b;

        /* renamed from: c */
        private ImageView f1317c;

        /* renamed from: d */
        private View f1318d;

        /* renamed from: e */
        private TextView f1319e;

        /* renamed from: f */
        private ImageView f1320f;
        @Nullable

        /* renamed from: g */
        private Drawable f1321g;

        /* renamed from: h */
        private int f1322h = 2;

        /* JADX WARNING: type inference failed for: r3v3, types: [android.graphics.drawable.LayerDrawable] */
        /* JADX WARNING: type inference failed for: r0v3, types: [android.graphics.drawable.RippleDrawable] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public C1215h(android.content.Context r10) {
            /*
                r8 = this;
                com.google.android.material.tabs.TabLayout.this = r9
                r8.<init>(r10)
                r0 = 2
                r8.f1322h = r0
                com.google.android.material.tabs.TabLayout r1 = com.google.android.material.tabs.TabLayout.this
                int r1 = r1.f1277s
                r2 = 0
                if (r1 == 0) goto L_0x0027
                android.graphics.drawable.Drawable r10 = androidx.appcompat.content.res.AppCompatResources.getDrawable(r10, r1)
                r8.f1321g = r10
                if (r10 == 0) goto L_0x0029
                boolean r10 = r10.isStateful()
                if (r10 == 0) goto L_0x0029
                android.graphics.drawable.Drawable r10 = r8.f1321g
                int[] r1 = r8.getDrawableState()
                r10.setState(r1)
                goto L_0x0029
            L_0x0027:
                r8.f1321g = r2
            L_0x0029:
                android.graphics.drawable.GradientDrawable r10 = new android.graphics.drawable.GradientDrawable
                r10.<init>()
                r1 = 0
                r10.setColor(r1)
                com.google.android.material.tabs.TabLayout r3 = com.google.android.material.tabs.TabLayout.this
                android.content.res.ColorStateList r3 = r3.f1272n
                r4 = 1
                if (r3 == 0) goto L_0x007f
                android.graphics.drawable.GradientDrawable r3 = new android.graphics.drawable.GradientDrawable
                r3.<init>()
                r5 = 925353388(0x3727c5ac, float:1.0E-5)
                r3.setCornerRadius(r5)
                r5 = -1
                r3.setColor(r5)
                com.google.android.material.tabs.TabLayout r5 = com.google.android.material.tabs.TabLayout.this
                android.content.res.ColorStateList r5 = r5.f1272n
                android.content.res.ColorStateList r5 = p009e.p028d.p030b.p054b.p059g.C1555a.m2174a(r5)
                int r6 = android.os.Build.VERSION.SDK_INT
                r7 = 21
                if (r6 < r7) goto L_0x006c
                android.graphics.drawable.RippleDrawable r0 = new android.graphics.drawable.RippleDrawable
                com.google.android.material.tabs.TabLayout r1 = com.google.android.material.tabs.TabLayout.this
                boolean r1 = r1.f1250E
                if (r1 == 0) goto L_0x005f
                r10 = r2
            L_0x005f:
                com.google.android.material.tabs.TabLayout r1 = com.google.android.material.tabs.TabLayout.this
                boolean r1 = r1.f1250E
                if (r1 == 0) goto L_0x0066
                goto L_0x0067
            L_0x0066:
                r2 = r3
            L_0x0067:
                r0.<init>(r5, r10, r2)
                r10 = r0
                goto L_0x007f
            L_0x006c:
                android.graphics.drawable.Drawable r2 = androidx.core.graphics.drawable.DrawableCompat.wrap(r3)
                androidx.core.graphics.drawable.DrawableCompat.setTintList(r2, r5)
                android.graphics.drawable.LayerDrawable r3 = new android.graphics.drawable.LayerDrawable
                android.graphics.drawable.Drawable[] r0 = new android.graphics.drawable.Drawable[r0]
                r0[r1] = r10
                r0[r4] = r2
                r3.<init>(r0)
                r10 = r3
            L_0x007f:
                androidx.core.view.ViewCompat.setBackground(r8, r10)
                com.google.android.material.tabs.TabLayout r10 = com.google.android.material.tabs.TabLayout.this
                r10.invalidate()
                int r10 = r9.f1265e
                int r0 = r9.f1266f
                int r1 = r9.f1267g
                int r2 = r9.f1268h
                androidx.core.view.ViewCompat.setPaddingRelative(r8, r10, r0, r1, r2)
                r10 = 17
                r8.setGravity(r10)
                boolean r9 = r9.f1248C
                r9 = r9 ^ r4
                r8.setOrientation(r9)
                r8.setClickable(r4)
                android.content.Context r9 = r8.getContext()
                r10 = 1002(0x3ea, float:1.404E-42)
                androidx.core.view.PointerIconCompat r9 = androidx.core.view.PointerIconCompat.getSystemIcon(r9, r10)
                androidx.core.view.ViewCompat.setPointerIcon(r8, r9)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.tabs.TabLayout.C1215h.<init>(com.google.android.material.tabs.TabLayout, android.content.Context):void");
        }

        /* renamed from: a */
        private void m1877a(@Nullable TextView textView, @Nullable ImageView imageView) {
            C1213f fVar = this.f1315a;
            CharSequence charSequence = null;
            Drawable mutate = (fVar == null || fVar.mo25543b() == null) ? null : DrawableCompat.wrap(this.f1315a.mo25543b()).mutate();
            C1213f fVar2 = this.f1315a;
            CharSequence d = fVar2 != null ? fVar2.mo25547d() : null;
            if (imageView != null) {
                if (mutate != null) {
                    imageView.setImageDrawable(mutate);
                    imageView.setVisibility(0);
                    setVisibility(0);
                } else {
                    imageView.setVisibility(8);
                    imageView.setImageDrawable((Drawable) null);
                }
            }
            boolean z = !TextUtils.isEmpty(d);
            if (textView != null) {
                if (z) {
                    textView.setText(d);
                    textView.setVisibility(0);
                    setVisibility(0);
                } else {
                    textView.setVisibility(8);
                    textView.setText((CharSequence) null);
                }
            }
            if (imageView != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                int a = (!z || imageView.getVisibility() != 0) ? 0 : TabLayout.this.mo25499a(8);
                if (TabLayout.this.f1248C) {
                    if (a != MarginLayoutParamsCompat.getMarginEnd(marginLayoutParams)) {
                        MarginLayoutParamsCompat.setMarginEnd(marginLayoutParams, a);
                        marginLayoutParams.bottomMargin = 0;
                    }
                } else if (a != marginLayoutParams.bottomMargin) {
                    marginLayoutParams.bottomMargin = a;
                    MarginLayoutParamsCompat.setMarginEnd(marginLayoutParams, 0);
                }
                imageView.setLayoutParams(marginLayoutParams);
                imageView.requestLayout();
            }
            C1213f fVar3 = this.f1315a;
            CharSequence a2 = fVar3 != null ? fVar3.f1307c : null;
            if (!z) {
                charSequence = a2;
            }
            TooltipCompat.setTooltipText(this, charSequence);
        }

        /* renamed from: a */
        static /* synthetic */ void m1878a(C1215h hVar, Canvas canvas) {
            Drawable drawable = hVar.f1321g;
            if (drawable != null) {
                drawable.setBounds(hVar.getLeft(), hVar.getTop(), hVar.getRight(), hVar.getBottom());
                hVar.f1321g.draw(canvas);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo25554a(@Nullable C1213f fVar) {
            if (fVar != this.f1315a) {
                this.f1315a = fVar;
                mo25555b();
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public final void mo25555b() {
            ImageView imageView;
            TextView textView;
            C1213f fVar = this.f1315a;
            Drawable drawable = null;
            View a = fVar != null ? fVar.mo25538a() : null;
            if (a != null) {
                ViewParent parent = a.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(a);
                    }
                    addView(a);
                }
                this.f1318d = a;
                TextView textView2 = this.f1316b;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                }
                ImageView imageView2 = this.f1317c;
                if (imageView2 != null) {
                    imageView2.setVisibility(8);
                    this.f1317c.setImageDrawable((Drawable) null);
                }
                TextView textView3 = (TextView) a.findViewById(16908308);
                this.f1319e = textView3;
                if (textView3 != null) {
                    this.f1322h = TextViewCompat.getMaxLines(textView3);
                }
                this.f1320f = (ImageView) a.findViewById(16908294);
            } else {
                View view = this.f1318d;
                if (view != null) {
                    removeView(view);
                    this.f1318d = null;
                }
                this.f1319e = null;
                this.f1320f = null;
            }
            boolean z = false;
            if (this.f1318d == null) {
                if (this.f1317c == null) {
                    ImageView imageView3 = (ImageView) LayoutInflater.from(getContext()).inflate(R.layout.design_layout_tab_icon, this, false);
                    addView(imageView3, 0);
                    this.f1317c = imageView3;
                }
                if (!(fVar == null || fVar.mo25543b() == null)) {
                    drawable = DrawableCompat.wrap(fVar.mo25543b()).mutate();
                }
                if (drawable != null) {
                    DrawableCompat.setTintList(drawable, TabLayout.this.f1271m);
                    PorterDuff.Mode mode = TabLayout.this.f1274p;
                    if (mode != null) {
                        DrawableCompat.setTintMode(drawable, mode);
                    }
                }
                if (this.f1316b == null) {
                    TextView textView4 = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.design_layout_tab_text, this, false);
                    addView(textView4);
                    this.f1316b = textView4;
                    this.f1322h = TextViewCompat.getMaxLines(textView4);
                }
                TextViewCompat.setTextAppearance(this.f1316b, TabLayout.this.f1269i);
                ColorStateList colorStateList = TabLayout.this.f1270l;
                if (colorStateList != null) {
                    this.f1316b.setTextColor(colorStateList);
                }
                textView = this.f1316b;
                imageView = this.f1317c;
            } else {
                if (!(this.f1319e == null && this.f1320f == null)) {
                    textView = this.f1319e;
                    imageView = this.f1320f;
                }
                if (fVar != null && !TextUtils.isEmpty(fVar.f1307c)) {
                    setContentDescription(fVar.f1307c);
                }
                if (fVar != null && fVar.mo25548e()) {
                    z = true;
                }
                setSelected(z);
            }
            m1877a(textView, imageView);
            setContentDescription(fVar.f1307c);
            z = true;
            setSelected(z);
        }

        /* access modifiers changed from: protected */
        public void drawableStateChanged() {
            super.drawableStateChanged();
            int[] drawableState = getDrawableState();
            Drawable drawable = this.f1321g;
            boolean z = false;
            if (drawable != null && drawable.isStateful()) {
                z = false | this.f1321g.setState(drawableState);
            }
            if (z) {
                invalidate();
                TabLayout.this.invalidate();
            }
        }

        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(ActionBar.Tab.class.getName());
        }

        @TargetApi(14)
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(ActionBar.Tab.class.getName());
        }

        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0094, code lost:
            if (((r0 / r2.getPaint().getTextSize()) * r2.getLineWidth(0)) > ((float) ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight()))) goto L_0x0096;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onMeasure(int r8, int r9) {
            /*
                r7 = this;
                int r0 = android.view.View.MeasureSpec.getSize(r8)
                int r1 = android.view.View.MeasureSpec.getMode(r8)
                com.google.android.material.tabs.TabLayout r2 = com.google.android.material.tabs.TabLayout.this
                int r2 = r2.f1278t
                if (r2 <= 0) goto L_0x001c
                if (r1 == 0) goto L_0x0012
                if (r0 <= r2) goto L_0x001c
            L_0x0012:
                com.google.android.material.tabs.TabLayout r8 = com.google.android.material.tabs.TabLayout.this
                int r8 = r8.f1278t
                r0 = -2147483648(0xffffffff80000000, float:-0.0)
                int r8 = android.view.View.MeasureSpec.makeMeasureSpec(r8, r0)
            L_0x001c:
                super.onMeasure(r8, r9)
                android.widget.TextView r0 = r7.f1316b
                if (r0 == 0) goto L_0x00a6
                com.google.android.material.tabs.TabLayout r0 = com.google.android.material.tabs.TabLayout.this
                float r0 = r0.f1275q
                int r1 = r7.f1322h
                android.widget.ImageView r2 = r7.f1317c
                r3 = 1
                if (r2 == 0) goto L_0x0036
                int r2 = r2.getVisibility()
                if (r2 != 0) goto L_0x0036
                r1 = 1
                goto L_0x0044
            L_0x0036:
                android.widget.TextView r2 = r7.f1316b
                if (r2 == 0) goto L_0x0044
                int r2 = r2.getLineCount()
                if (r2 <= r3) goto L_0x0044
                com.google.android.material.tabs.TabLayout r0 = com.google.android.material.tabs.TabLayout.this
                float r0 = r0.f1276r
            L_0x0044:
                android.widget.TextView r2 = r7.f1316b
                float r2 = r2.getTextSize()
                android.widget.TextView r4 = r7.f1316b
                int r4 = r4.getLineCount()
                android.widget.TextView r5 = r7.f1316b
                int r5 = androidx.core.widget.TextViewCompat.getMaxLines(r5)
                int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r6 != 0) goto L_0x005e
                if (r5 < 0) goto L_0x00a6
                if (r1 == r5) goto L_0x00a6
            L_0x005e:
                com.google.android.material.tabs.TabLayout r5 = com.google.android.material.tabs.TabLayout.this
                int r5 = r5.f1247B
                r6 = 0
                if (r5 != r3) goto L_0x0097
                int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r2 <= 0) goto L_0x0097
                if (r4 != r3) goto L_0x0097
                android.widget.TextView r2 = r7.f1316b
                android.text.Layout r2 = r2.getLayout()
                if (r2 == 0) goto L_0x0096
                float r4 = r2.getLineWidth(r6)
                android.text.TextPaint r2 = r2.getPaint()
                float r2 = r2.getTextSize()
                float r2 = r0 / r2
                float r2 = r2 * r4
                int r4 = r7.getMeasuredWidth()
                int r5 = r7.getPaddingLeft()
                int r4 = r4 - r5
                int r5 = r7.getPaddingRight()
                int r4 = r4 - r5
                float r4 = (float) r4
                int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r2 <= 0) goto L_0x0097
            L_0x0096:
                r3 = 0
            L_0x0097:
                if (r3 == 0) goto L_0x00a6
                android.widget.TextView r2 = r7.f1316b
                r2.setTextSize(r6, r0)
                android.widget.TextView r0 = r7.f1316b
                r0.setMaxLines(r1)
                super.onMeasure(r8, r9)
            L_0x00a6:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.tabs.TabLayout.C1215h.onMeasure(int, int):void");
        }

        public boolean performClick() {
            boolean performClick = super.performClick();
            if (this.f1315a == null) {
                return performClick;
            }
            if (!performClick) {
                playSoundEffect(0);
            }
            this.f1315a.mo25550g();
            return true;
        }

        public void setSelected(boolean z) {
            if (isSelected() != z) {
            }
            super.setSelected(z);
            TextView textView = this.f1316b;
            if (textView != null) {
                textView.setSelected(z);
            }
            ImageView imageView = this.f1317c;
            if (imageView != null) {
                imageView.setSelected(z);
            }
            View view = this.f1318d;
            if (view != null) {
                view.setSelected(z);
            }
        }

        /* renamed from: a */
        static /* synthetic */ int m1876a(C1215h hVar) {
            View[] viewArr = {hVar.f1316b, hVar.f1317c, hVar.f1318d};
            int i = 0;
            int i2 = 0;
            boolean z = false;
            for (int i3 = 0; i3 < 3; i3++) {
                View view = viewArr[i3];
                if (view != null && view.getVisibility() == 0) {
                    i2 = z ? Math.min(i2, view.getLeft()) : view.getLeft();
                    i = z ? Math.max(i, view.getRight()) : view.getRight();
                    z = true;
                }
            }
            return i - i2;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo25553a() {
            if (this.f1315a != null) {
                this.f1315a = null;
                mo25555b();
            }
            setSelected(false);
        }
    }

    /* renamed from: com.google.android.material.tabs.TabLayout$i */
    public static class C1216i implements C1208c {

        /* renamed from: a */
        private final ViewPager f1324a;

        public C1216i(ViewPager viewPager) {
            this.f1324a = viewPager;
        }

        public void onTabReselected(C1213f fVar) {
        }

        public void onTabSelected(C1213f fVar) {
            this.f1324a.setCurrentItem(fVar.mo25546c());
        }

        public void onTabUnselected(C1213f fVar) {
        }
    }

    public TabLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public TabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.tabStyle);
    }

    /* JADX INFO: finally extract failed */
    public TabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1261a = new ArrayList<>();
        this.f1263c = new RectF();
        this.f1278t = Integer.MAX_VALUE;
        this.f1251F = new ArrayList<>();
        this.f1260O = new Pools.SimplePool(12);
        setHorizontalScrollBarEnabled(false);
        C1210e eVar = new C1210e(context);
        this.f1264d = eVar;
        super.addView(eVar, 0, new FrameLayout.LayoutParams(-2, -1));
        TypedArray a = C1196d.m1820a(context, attributeSet, C1533b.f1767j, i, C2092R.style.Widget_Design_TabLayout, 22);
        this.f1264d.mo25530b(a.getDimensionPixelSize(10, -1));
        this.f1264d.mo25527a(a.getColor(7, 0));
        Drawable b = C1532a.m2146b(context, a, 5);
        if (this.f1273o != b) {
            this.f1273o = b;
            ViewCompat.postInvalidateOnAnimation(this.f1264d);
        }
        int i2 = a.getInt(9, 0);
        if (this.f1246A != i2) {
            this.f1246A = i2;
            ViewCompat.postInvalidateOnAnimation(this.f1264d);
        }
        this.f1249D = a.getBoolean(8, true);
        ViewCompat.postInvalidateOnAnimation(this.f1264d);
        int dimensionPixelSize = a.getDimensionPixelSize(15, 0);
        this.f1268h = dimensionPixelSize;
        this.f1267g = dimensionPixelSize;
        this.f1266f = dimensionPixelSize;
        this.f1265e = dimensionPixelSize;
        this.f1265e = a.getDimensionPixelSize(18, dimensionPixelSize);
        this.f1266f = a.getDimensionPixelSize(19, this.f1266f);
        this.f1267g = a.getDimensionPixelSize(17, this.f1267g);
        this.f1268h = a.getDimensionPixelSize(16, this.f1268h);
        int resourceId = a.getResourceId(22, C2092R.style.TextAppearance_Design_Tab);
        this.f1269i = resourceId;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(resourceId, C0043R.styleable.TextAppearance);
        try {
            this.f1275q = (float) obtainStyledAttributes.getDimensionPixelSize(C0043R.styleable.TextAppearance_android_textSize, 0);
            this.f1270l = C1532a.m2123a(context, obtainStyledAttributes, C0043R.styleable.TextAppearance_android_textColor);
            obtainStyledAttributes.recycle();
            if (a.hasValue(23)) {
                this.f1270l = C1532a.m2123a(context, a, 23);
            }
            if (a.hasValue(21)) {
                this.f1270l = new ColorStateList(new int[][]{HorizontalScrollView.SELECTED_STATE_SET, HorizontalScrollView.EMPTY_STATE_SET}, new int[]{a.getColor(21, 0), this.f1270l.getDefaultColor()});
            }
            this.f1271m = C1532a.m2123a(context, a, 3);
            this.f1274p = C1532a.m2124a(a.getInt(4, -1), (PorterDuff.Mode) null);
            this.f1272n = C1532a.m2123a(context, a, 20);
            this.f1284z = a.getInt(6, 300);
            this.f1279u = a.getDimensionPixelSize(13, -1);
            this.f1280v = a.getDimensionPixelSize(12, -1);
            this.f1277s = a.getResourceId(0, 0);
            this.f1282x = a.getDimensionPixelSize(1, 0);
            this.f1247B = a.getInt(14, 1);
            this.f1283y = a.getInt(2, 0);
            this.f1248C = a.getBoolean(11, false);
            this.f1250E = a.getBoolean(24, false);
            a.recycle();
            Resources resources = getResources();
            this.f1276r = (float) resources.getDimensionPixelSize(R.dimen.design_tab_text_size_2line);
            this.f1281w = resources.getDimensionPixelSize(R.dimen.design_tab_scrollable_min_width);
            ViewCompat.setPaddingRelative(this.f1264d, this.f1247B == 0 ? Math.max(0, this.f1282x - this.f1265e) : 0, 0, 0, 0);
            int i3 = this.f1247B;
            if (i3 == 0) {
                this.f1264d.setGravity(GravityCompat.START);
            } else if (i3 == 1) {
                this.f1264d.setGravity(1);
            }
            mo25505a(true);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    /* renamed from: a */
    private int m1831a(int i, float f) {
        int i2 = 0;
        if (this.f1247B != 0) {
            return 0;
        }
        View childAt = this.f1264d.getChildAt(i);
        int i3 = i + 1;
        View childAt2 = i3 < this.f1264d.getChildCount() ? this.f1264d.getChildAt(i3) : null;
        int width = childAt != null ? childAt.getWidth() : 0;
        if (childAt2 != null) {
            i2 = childAt2.getWidth();
        }
        int left = ((width / 2) + childAt.getLeft()) - (getWidth() / 2);
        int i4 = (int) (((float) (width + i2)) * 0.5f * f);
        return ViewCompat.getLayoutDirection(this) == 0 ? left + i4 : left - i4;
    }

    /* renamed from: a */
    private void m1834a(LinearLayout.LayoutParams layoutParams) {
        float f;
        if (this.f1247B == 1 && this.f1283y == 0) {
            layoutParams.width = 0;
            f = 1.0f;
        } else {
            layoutParams.width = -2;
            f = 0.0f;
        }
        layoutParams.weight = f;
    }

    /* renamed from: c */
    private void m1836c(int i) {
        boolean z;
        if (i != -1) {
            if (getWindowToken() != null && ViewCompat.isLaidOut(this)) {
                C1210e eVar = this.f1264d;
                int childCount = eVar.getChildCount();
                int i2 = 0;
                while (true) {
                    if (i2 >= childCount) {
                        z = false;
                        break;
                    } else if (eVar.getChildAt(i2).getWidth() <= 0) {
                        z = true;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (!z) {
                    int scrollX = getScrollX();
                    int a = m1831a(i, 0.0f);
                    if (scrollX != a) {
                        if (this.f1253H == null) {
                            ValueAnimator valueAnimator = new ValueAnimator();
                            this.f1253H = valueAnimator;
                            valueAnimator.setInterpolator(C1534a.f1769a);
                            this.f1253H.setDuration((long) this.f1284z);
                            this.f1253H.addUpdateListener(new C1218b(this));
                        }
                        this.f1253H.setIntValues(new int[]{scrollX, a});
                        this.f1253H.start();
                    }
                    this.f1264d.mo25529a(i, this.f1284z);
                    return;
                }
            }
            mo25500a(i, 0.0f, true, true);
        }
    }

    /* renamed from: d */
    private void m1837d(int i) {
        int childCount = this.f1264d.getChildCount();
        if (i < childCount) {
            int i2 = 0;
            while (i2 < childCount) {
                View childAt = this.f1264d.getChildAt(i2);
                boolean z = true;
                childAt.setSelected(i2 == i);
                if (i2 != i) {
                    z = false;
                }
                childAt.setActivated(z);
                i2++;
            }
        }
    }

    /* renamed from: a */
    public int mo25498a() {
        C1213f fVar = this.f1262b;
        if (fVar != null) {
            return fVar.mo25546c();
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    @Dimension(unit = 1)
    /* renamed from: a */
    public int mo25499a(@Dimension(unit = 0) int i) {
        return Math.round(getResources().getDisplayMetrics().density * ((float) i));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo25500a(int i, float f, boolean z, boolean z2) {
        int round = Math.round(((float) i) + f);
        if (round >= 0 && round < this.f1264d.getChildCount()) {
            if (z2) {
                this.f1264d.mo25528a(i, f);
            }
            ValueAnimator valueAnimator = this.f1253H;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.f1253H.cancel();
            }
            scrollTo(m1831a(i, f), 0);
            if (z) {
                m1837d(round);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo25501a(@Nullable PagerAdapter pagerAdapter, boolean z) {
        DataSetObserver dataSetObserver;
        PagerAdapter pagerAdapter2 = this.f1255J;
        if (!(pagerAdapter2 == null || (dataSetObserver = this.f1256K) == null)) {
            pagerAdapter2.unregisterDataSetObserver(dataSetObserver);
        }
        this.f1255J = pagerAdapter;
        if (z && pagerAdapter != null) {
            if (this.f1256K == null) {
                this.f1256K = new C1209d();
            }
            pagerAdapter.registerDataSetObserver(this.f1256K);
        }
        mo25514d();
    }

    /* renamed from: a */
    public void mo25502a(@NonNull C1207b bVar) {
        if (!this.f1251F.contains(bVar)) {
            this.f1251F.add(bVar);
        }
    }

    /* renamed from: a */
    public void mo25503a(@NonNull C1213f fVar) {
        mo25504a(fVar, this.f1261a.isEmpty());
    }

    /* renamed from: a */
    public void mo25504a(@NonNull C1213f fVar, boolean z) {
        int size = this.f1261a.size();
        if (fVar.f1310f == this) {
            fVar.mo25545b(size);
            this.f1261a.add(size, fVar);
            int size2 = this.f1261a.size();
            while (true) {
                size++;
                if (size >= size2) {
                    break;
                }
                this.f1261a.get(size).mo25545b(size);
            }
            C1215h hVar = fVar.f1311g;
            C1210e eVar = this.f1264d;
            int c = fVar.mo25546c();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            m1834a(layoutParams);
            eVar.addView(hVar, c, layoutParams);
            if (z) {
                fVar.mo25550g();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
    }

    public void addView(View view) {
        m1833a(view);
    }

    public void addView(View view, int i) {
        m1833a(view);
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        m1833a(view);
    }

    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        m1833a(view);
    }

    /* renamed from: b */
    public int mo25510b() {
        return this.f1261a.size();
    }

    @Nullable
    /* renamed from: b */
    public C1213f mo25511b(int i) {
        if (i < 0 || i >= mo25510b()) {
            return null;
        }
        return this.f1261a.get(i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo25512b(C1213f fVar, boolean z) {
        C1213f fVar2 = this.f1262b;
        if (fVar2 != fVar) {
            int c = fVar != null ? fVar.mo25546c() : -1;
            if (z) {
                if ((fVar2 == null || fVar2.mo25546c() == -1) && c != -1) {
                    mo25500a(c, 0.0f, true, true);
                } else {
                    m1836c(c);
                }
                if (c != -1) {
                    m1837d(c);
                }
            }
            this.f1262b = fVar;
            if (fVar2 != null) {
                for (int size = this.f1251F.size() - 1; size >= 0; size--) {
                    this.f1251F.get(size).onTabUnselected(fVar2);
                }
            }
            if (fVar != null) {
                for (int size2 = this.f1251F.size() - 1; size2 >= 0; size2--) {
                    this.f1251F.get(size2).onTabSelected(fVar);
                }
            }
        } else if (fVar2 != null) {
            for (int size3 = this.f1251F.size() - 1; size3 >= 0; size3--) {
                this.f1251F.get(size3).onTabReselected(fVar);
            }
            m1836c(fVar.mo25546c());
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo25514d() {
        int currentItem;
        int childCount = this.f1264d.getChildCount();
        while (true) {
            childCount--;
            if (childCount < 0) {
                break;
            }
            C1215h hVar = (C1215h) this.f1264d.getChildAt(childCount);
            this.f1264d.removeViewAt(childCount);
            if (hVar != null) {
                hVar.mo25553a();
                this.f1260O.release(hVar);
            }
            requestLayout();
        }
        Iterator<C1213f> it = this.f1261a.iterator();
        while (it.hasNext()) {
            C1213f next = it.next();
            it.remove();
            next.mo25549f();
            f1245P.release(next);
        }
        this.f1262b = null;
        PagerAdapter pagerAdapter = this.f1255J;
        if (pagerAdapter != null) {
            int count = pagerAdapter.getCount();
            for (int i = 0; i < count; i++) {
                C1213f c = mo25513c();
                c.mo25544b(this.f1255J.getPageTitle(i));
                mo25504a(c, false);
            }
            ViewPager viewPager = this.f1254I;
            if (viewPager != null && count > 0 && (currentItem = viewPager.getCurrentItem()) != mo25498a() && currentItem < mo25510b()) {
                mo25512b(mo25511b(currentItem), true);
            }
        }
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    /* renamed from: generateLayoutParams  reason: collision with other method in class */
    public FrameLayout.LayoutParams m4624generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f1254I == null) {
            ViewParent parent = getParent();
            if (parent instanceof ViewPager) {
                m1835a((ViewPager) parent, true, true);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f1259N) {
            m1835a((ViewPager) null, true, false);
            this.f1259N = false;
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        for (int i = 0; i < this.f1264d.getChildCount(); i++) {
            View childAt = this.f1264d.getChildAt(i);
            if (childAt instanceof C1215h) {
                C1215h.m1878a((C1215h) childAt, canvas);
            }
        }
        super.onDraw(canvas);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        boolean z;
        int size = this.f1261a.size();
        boolean z2 = false;
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                z = false;
                break;
            }
            C1213f fVar = this.f1261a.get(i3);
            if (fVar != null && fVar.mo25543b() != null && !TextUtils.isEmpty(fVar.mo25547d())) {
                z = true;
                break;
            }
            i3++;
        }
        int paddingBottom = getPaddingBottom() + getPaddingTop() + mo25499a((!z || this.f1248C) ? 48 : 72);
        int mode = View.MeasureSpec.getMode(i2);
        if (mode == Integer.MIN_VALUE) {
            i2 = View.MeasureSpec.makeMeasureSpec(Math.min(paddingBottom, View.MeasureSpec.getSize(i2)), 1073741824);
        } else if (mode == 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(paddingBottom, 1073741824);
        }
        int size2 = View.MeasureSpec.getSize(i);
        if (View.MeasureSpec.getMode(i) != 0) {
            int i4 = this.f1280v;
            if (i4 <= 0) {
                i4 = size2 - mo25499a(56);
            }
            this.f1278t = i4;
        }
        super.onMeasure(i, i2);
        if (getChildCount() == 1) {
            View childAt = getChildAt(0);
            int i5 = this.f1247B;
            if (i5 == 0 ? childAt.getMeasuredWidth() < getMeasuredWidth() : !(i5 != 1 || childAt.getMeasuredWidth() == getMeasuredWidth())) {
                z2 = true;
            }
            if (z2) {
                childAt.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), HorizontalScrollView.getChildMeasureSpec(i2, getPaddingBottom() + getPaddingTop(), childAt.getLayoutParams().height));
            }
        }
    }

    public boolean shouldDelayChildPressedState() {
        return Math.max(0, ((this.f1264d.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight()) > 0;
    }

    @NonNull
    /* renamed from: c */
    public C1213f mo25513c() {
        C1213f acquire = f1245P.acquire();
        if (acquire == null) {
            acquire = new C1213f();
        }
        acquire.f1310f = this;
        Pools.Pool<C1215h> pool = this.f1260O;
        C1215h acquire2 = pool != null ? pool.acquire() : null;
        if (acquire2 == null) {
            acquire2 = new C1215h(getContext());
        }
        acquire2.mo25554a(acquire);
        acquire2.setFocusable(true);
        int i = this.f1279u;
        if (i == -1) {
            i = this.f1247B == 0 ? this.f1281w : 0;
        }
        acquire2.setMinimumWidth(i);
        acquire2.setContentDescription(TextUtils.isEmpty(acquire.f1307c) ? acquire.f1306b : acquire.f1307c);
        acquire.f1311g = acquire2;
        return acquire;
    }

    /* renamed from: a */
    private void m1833a(View view) {
        if (view instanceof C1217a) {
            C1217a aVar = (C1217a) view;
            C1213f c = mo25513c();
            CharSequence charSequence = aVar.f1325a;
            if (charSequence != null) {
                c.mo25544b(charSequence);
            }
            Drawable drawable = aVar.f1326b;
            if (drawable != null) {
                c.mo25540a(drawable);
            }
            int i = aVar.f1327c;
            if (i != 0) {
                c.mo25539a(i);
            }
            if (!TextUtils.isEmpty(aVar.getContentDescription())) {
                c.mo25542a(aVar.getContentDescription());
            }
            mo25504a(c, this.f1261a.isEmpty());
            return;
        }
        throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
    }

    /* renamed from: a */
    private void m1835a(@Nullable ViewPager viewPager, boolean z, boolean z2) {
        ViewPager viewPager2 = this.f1254I;
        if (viewPager2 != null) {
            C1214g gVar = this.f1257L;
            if (gVar != null) {
                viewPager2.removeOnPageChangeListener(gVar);
            }
            C1206a aVar = this.f1258M;
            if (aVar != null) {
                this.f1254I.removeOnAdapterChangeListener(aVar);
            }
        }
        C1207b bVar = this.f1252G;
        if (bVar != null) {
            this.f1251F.remove(bVar);
            this.f1252G = null;
        }
        if (viewPager != null) {
            this.f1254I = viewPager;
            if (this.f1257L == null) {
                this.f1257L = new C1214g(this);
            }
            this.f1257L.mo25552a();
            viewPager.addOnPageChangeListener(this.f1257L);
            C1216i iVar = new C1216i(viewPager);
            this.f1252G = iVar;
            if (!this.f1251F.contains(iVar)) {
                this.f1251F.add(iVar);
            }
            PagerAdapter adapter = viewPager.getAdapter();
            if (adapter != null) {
                mo25501a(adapter, z);
            }
            if (this.f1258M == null) {
                this.f1258M = new C1206a();
            }
            this.f1258M.mo25521a(z);
            viewPager.addOnAdapterChangeListener(this.f1258M);
            mo25500a(viewPager.getCurrentItem(), 0.0f, true, true);
        } else {
            this.f1254I = null;
            mo25501a((PagerAdapter) null, false);
        }
        this.f1259N = z2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo25505a(boolean z) {
        for (int i = 0; i < this.f1264d.getChildCount(); i++) {
            View childAt = this.f1264d.getChildAt(i);
            int i2 = this.f1279u;
            if (i2 == -1) {
                i2 = this.f1247B == 0 ? this.f1281w : 0;
            }
            childAt.setMinimumWidth(i2);
            m1834a((LinearLayout.LayoutParams) childAt.getLayoutParams());
            if (z) {
                childAt.requestLayout();
            }
        }
    }
}
