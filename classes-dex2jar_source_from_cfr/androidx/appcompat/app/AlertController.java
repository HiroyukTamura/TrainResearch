/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnCancelListener
 *  android.content.DialogInterface$OnClickListener
 *  android.content.DialogInterface$OnDismissListener
 *  android.content.DialogInterface$OnKeyListener
 *  android.content.DialogInterface$OnMultiChoiceClickListener
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.content.res.TypedArray
 *  android.database.Cursor
 *  android.graphics.drawable.Drawable
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.os.Message
 *  android.text.TextUtils
 *  android.util.AttributeSet
 *  android.util.TypedValue
 *  android.view.KeyEvent
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewParent
 *  android.view.ViewStub
 *  android.view.Window
 *  android.widget.AbsListView
 *  android.widget.AbsListView$OnScrollListener
 *  android.widget.AdapterView
 *  android.widget.AdapterView$OnItemClickListener
 *  android.widget.AdapterView$OnItemSelectedListener
 *  android.widget.ArrayAdapter
 *  android.widget.Button
 *  android.widget.CheckedTextView
 *  android.widget.CursorAdapter
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.LinearLayout$LayoutParams
 *  android.widget.ListAdapter
 *  android.widget.ListView
 *  android.widget.SimpleCursorAdapter
 *  android.widget.TextView
 */
package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import androidx.appcompat.a;
import androidx.appcompat.app.g;
import androidx.appcompat.widget.ab;
import androidx.core.h.t;
import androidx.core.widget.NestedScrollView;
import java.lang.ref.WeakReference;

class AlertController {
    private int A;
    private boolean B = false;
    private CharSequence C;
    private Drawable D;
    private CharSequence E;
    private Drawable F;
    private CharSequence G;
    private Drawable H;
    private int I = 0;
    private Drawable J;
    private ImageView K;
    private TextView L;
    private TextView M;
    private View N;
    private int O;
    private int P;
    private boolean Q;
    private int R = 0;
    private final View.OnClickListener S = new View.OnClickListener(){

        /*
         * Unable to fully structure code
         * Enabled aggressive block sorting
         * Lifted jumps to return sites
         */
        public void onClick(View var1_1) {
            block4 : {
                block3 : {
                    if (var1_1 != AlertController.this.c || AlertController.this.d == null) break block3;
                    var1_1 = AlertController.this.d;
                    ** GOTO lbl11
                }
                if (var1_1 != AlertController.this.e || AlertController.this.f == null) break block4;
                var1_1 = AlertController.this.f;
                ** GOTO lbl11
            }
            if (var1_1 == AlertController.this.g && AlertController.this.h != null) {
                var1_1 = AlertController.this.h;
lbl11: // 3 sources:
                var1_1 = Message.obtain((Message)var1_1);
            } else {
                var1_1 = null;
            }
            if (var1_1 != null) {
                var1_1.sendToTarget();
            }
            AlertController.this.p.obtainMessage(1, (Object)AlertController.this.a).sendToTarget();
        }
    };
    final g a;
    ListView b;
    Button c;
    Message d;
    Button e;
    Message f;
    Button g;
    Message h;
    NestedScrollView i;
    ListAdapter j;
    int k = -1;
    int l;
    int m;
    int n;
    int o;
    Handler p;
    private final Context q;
    private final Window r;
    private final int s;
    private CharSequence t;
    private CharSequence u;
    private View v;
    private int w;
    private int x;
    private int y;
    private int z;

    public AlertController(Context context, g g2, Window window) {
        this.q = context;
        this.a = g2;
        this.r = window;
        this.p = new b((DialogInterface)g2);
        context = context.obtainStyledAttributes(null, a.j.AlertDialog, a.a.alertDialogStyle, 0);
        this.O = context.getResourceId(a.j.AlertDialog_android_layout, 0);
        this.P = context.getResourceId(a.j.AlertDialog_buttonPanelSideLayout, 0);
        this.l = context.getResourceId(a.j.AlertDialog_listLayout, 0);
        this.m = context.getResourceId(a.j.AlertDialog_multiChoiceItemLayout, 0);
        this.n = context.getResourceId(a.j.AlertDialog_singleChoiceItemLayout, 0);
        this.o = context.getResourceId(a.j.AlertDialog_listItemLayout, 0);
        this.Q = context.getBoolean(a.j.AlertDialog_showTitle, true);
        this.s = context.getDimensionPixelSize(a.j.AlertDialog_buttonIconDimen, 0);
        context.recycle();
        g2.b(1);
    }

    private ViewGroup a(View view, View view2) {
        ViewParent viewParent;
        if (view == null) {
            view = view2;
            if (view2 instanceof ViewStub) {
                view = ((ViewStub)view2).inflate();
            }
            return (ViewGroup)view;
        }
        if (view2 != null && (viewParent = view2.getParent()) instanceof ViewGroup) {
            ((ViewGroup)viewParent).removeView(view2);
        }
        view2 = view;
        if (view instanceof ViewStub) {
            view2 = ((ViewStub)view).inflate();
        }
        return (ViewGroup)view2;
    }

    static void a(View view, View view2, View view3) {
        int n2;
        int n3 = 4;
        if (view2 != null) {
            n2 = view.canScrollVertically(-1) ? 0 : 4;
            view2.setVisibility(n2);
        }
        if (view3 != null) {
            n2 = n3;
            if (view.canScrollVertically(1)) {
                n2 = 0;
            }
            view3.setVisibility(n2);
        }
    }

    private void a(ViewGroup viewGroup) {
        Object object = this.v;
        boolean bl2 = false;
        if ((object = object != null ? this.v : (this.w != 0 ? LayoutInflater.from((Context)this.q).inflate(this.w, viewGroup, false) : null)) != null) {
            bl2 = true;
        }
        if (!bl2 || !AlertController.a(object)) {
            this.r.setFlags(131072, 131072);
        }
        if (bl2) {
            FrameLayout frameLayout = (FrameLayout)this.r.findViewById(a.f.custom);
            frameLayout.addView(object, new ViewGroup.LayoutParams(-1, -1));
            if (this.B) {
                frameLayout.setPadding(this.x, this.y, this.z, this.A);
            }
            if (this.b != null) {
                ((ab.a)viewGroup.getLayoutParams()).g = 0.0f;
                return;
            }
        } else {
            viewGroup.setVisibility(8);
        }
    }

    private void a(ViewGroup viewGroup, final View view, int n2, int n3) {
        View view2 = this.r.findViewById(a.f.scrollIndicatorUp);
        final View view3 = this.r.findViewById(a.f.scrollIndicatorDown);
        if (Build.VERSION.SDK_INT >= 23) {
            t.a(view, n2, n3);
            if (view2 != null) {
                viewGroup.removeView(view2);
            }
            if (view3 != null) {
                viewGroup.removeView(view3);
                return;
            }
        } else {
            Object var7_7 = null;
            view = view2;
            if (view2 != null) {
                view = view2;
                if ((n2 & 1) == 0) {
                    viewGroup.removeView(view2);
                    view = null;
                }
            }
            if (view3 != null && (n2 & 2) == 0) {
                viewGroup.removeView(view3);
                view3 = var7_7;
            }
            if (view != null || view3 != null) {
                if (this.u != null) {
                    this.i.setOnScrollChangeListener(new NestedScrollView.b(){

                        @Override
                        public void a(NestedScrollView nestedScrollView, int n2, int n3, int n4, int n5) {
                            AlertController.a((View)nestedScrollView, view, view3);
                        }
                    });
                    this.i.post(new Runnable(){

                        @Override
                        public void run() {
                            AlertController.a((View)AlertController.this.i, view, view3);
                        }
                    });
                    return;
                }
                if (this.b != null) {
                    this.b.setOnScrollListener(new AbsListView.OnScrollListener(){

                        public void onScroll(AbsListView absListView, int n2, int n3, int n4) {
                            AlertController.a((View)absListView, view, view3);
                        }

                        public void onScrollStateChanged(AbsListView absListView, int n2) {
                        }
                    });
                    this.b.post(new Runnable(){

                        @Override
                        public void run() {
                            AlertController.a((View)AlertController.this.b, view, view3);
                        }
                    });
                    return;
                }
                if (view != null) {
                    viewGroup.removeView(view);
                }
                if (view3 != null) {
                    viewGroup.removeView(view3);
                }
            }
        }
    }

    private void a(Button button) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)button.getLayoutParams();
        layoutParams.gravity = 1;
        layoutParams.weight = 0.5f;
        button.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    }

    private static boolean a(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(a.a.alertDialogCenterButtons, typedValue, true);
        return typedValue.data != 0;
    }

    static boolean a(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        view = (ViewGroup)view;
        int n2 = view.getChildCount();
        while (n2 > 0) {
            int n3;
            n2 = n3 = n2 - 1;
            if (!AlertController.a(view.getChildAt(n3))) continue;
            return true;
        }
        return false;
    }

    private int b() {
        if (this.P == 0) {
            return this.O;
        }
        if (this.R == 1) {
            return this.P;
        }
        return this.O;
    }

    private void b(ViewGroup viewGroup) {
        if (this.N != null) {
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -2);
            viewGroup.addView(this.N, 0, layoutParams);
            this.r.findViewById(a.f.title_template).setVisibility(8);
            return;
        }
        this.K = (ImageView)this.r.findViewById(16908294);
        if (TextUtils.isEmpty((CharSequence)this.t) ^ true && this.Q) {
            this.L = (TextView)this.r.findViewById(a.f.alertTitle);
            this.L.setText(this.t);
            if (this.I != 0) {
                this.K.setImageResource(this.I);
                return;
            }
            if (this.J != null) {
                this.K.setImageDrawable(this.J);
                return;
            }
            this.L.setPadding(this.K.getPaddingLeft(), this.K.getPaddingTop(), this.K.getPaddingRight(), this.K.getPaddingBottom());
            this.K.setVisibility(8);
            return;
        }
        this.r.findViewById(a.f.title_template).setVisibility(8);
        this.K.setVisibility(8);
        viewGroup.setVisibility(8);
    }

    private void c() {
        View view = this.r.findViewById(a.f.parentPanel);
        View view2 = view.findViewById(a.f.topPanel);
        View view3 = view.findViewById(a.f.contentPanel);
        Object object = view.findViewById(a.f.buttonPanel);
        view = (ViewGroup)view.findViewById(a.f.customPanel);
        this.a((ViewGroup)view);
        View view4 = view.findViewById(a.f.topPanel);
        View view5 = view.findViewById(a.f.contentPanel);
        View view6 = view.findViewById(a.f.buttonPanel);
        view2 = this.a(view4, view2);
        view3 = this.a(view5, view3);
        object = this.a(view6, (View)object);
        this.c((ViewGroup)view3);
        this.d((ViewGroup)object);
        this.b((ViewGroup)view2);
        int n2 = 0;
        int n3 = view != null && view.getVisibility() != 8 ? 1 : 0;
        int n4 = view2 != null && view2.getVisibility() != 8 ? 1 : 0;
        boolean bl2 = object != null && object.getVisibility() != 8;
        if (!bl2 && view3 != null && (object = view3.findViewById(a.f.textSpacerNoButtons)) != null) {
            object.setVisibility(0);
        }
        if (n4 != 0) {
            if (this.i != null) {
                this.i.setClipToPadding(true);
            }
            object = null;
            if (this.u != null || this.b != null) {
                object = view2.findViewById(a.f.titleDividerNoCustom);
            }
            if (object != null) {
                object.setVisibility(0);
            }
        } else if (view3 != null && (object = view3.findViewById(a.f.textSpacerNoTitle)) != null) {
            object.setVisibility(0);
        }
        if (this.b instanceof RecycleListView) {
            ((RecycleListView)this.b).a((boolean)n4, bl2);
        }
        if (n3 == 0 && (object = this.b != null ? this.b : this.i) != null) {
            n3 = n2;
            if (bl2) {
                n3 = 2;
            }
            this.a((ViewGroup)view3, (View)object, n4 | n3, 3);
        }
        if ((object = this.b) != null && this.j != null) {
            object.setAdapter(this.j);
            n3 = this.k;
            if (n3 > -1) {
                object.setItemChecked(n3, true);
                object.setSelection(n3);
            }
        }
    }

    private void c(ViewGroup viewGroup) {
        this.i = (NestedScrollView)this.r.findViewById(a.f.scrollView);
        this.i.setFocusable(false);
        this.i.setNestedScrollingEnabled(false);
        this.M = (TextView)viewGroup.findViewById(16908299);
        if (this.M == null) {
            return;
        }
        if (this.u != null) {
            this.M.setText(this.u);
            return;
        }
        this.M.setVisibility(8);
        this.i.removeView((View)this.M);
        if (this.b != null) {
            viewGroup = (ViewGroup)this.i.getParent();
            int n2 = viewGroup.indexOfChild((View)this.i);
            viewGroup.removeViewAt(n2);
            viewGroup.addView((View)this.b, n2, new ViewGroup.LayoutParams(-1, -1));
            return;
        }
        viewGroup.setVisibility(8);
    }

    /*
     * Enabled aggressive block sorting
     */
    private void d(ViewGroup viewGroup) {
        int n2;
        int n3;
        block13 : {
            Button button;
            block15 : {
                block16 : {
                    block14 : {
                        this.c = (Button)viewGroup.findViewById(16908313);
                        this.c.setOnClickListener(this.S);
                        boolean bl2 = TextUtils.isEmpty((CharSequence)this.C);
                        n2 = 1;
                        if (bl2 && this.D == null) {
                            this.c.setVisibility(8);
                            n3 = 0;
                        } else {
                            this.c.setText(this.C);
                            if (this.D != null) {
                                this.D.setBounds(0, 0, this.s, this.s);
                                this.c.setCompoundDrawables(this.D, null, null, null);
                            }
                            this.c.setVisibility(0);
                            n3 = 1;
                        }
                        this.e = (Button)viewGroup.findViewById(16908314);
                        this.e.setOnClickListener(this.S);
                        if (TextUtils.isEmpty((CharSequence)this.E) && this.F == null) {
                            this.e.setVisibility(8);
                        } else {
                            this.e.setText(this.E);
                            if (this.F != null) {
                                this.F.setBounds(0, 0, this.s, this.s);
                                this.e.setCompoundDrawables(this.F, null, null, null);
                            }
                            this.e.setVisibility(0);
                            n3 |= 2;
                        }
                        this.g = (Button)viewGroup.findViewById(16908315);
                        this.g.setOnClickListener(this.S);
                        if (TextUtils.isEmpty((CharSequence)this.G) && this.H == null) {
                            this.g.setVisibility(8);
                        } else {
                            this.g.setText(this.G);
                            if (this.D != null) {
                                this.D.setBounds(0, 0, this.s, this.s);
                                this.c.setCompoundDrawables(this.D, null, null, null);
                            }
                            this.g.setVisibility(0);
                            n3 |= 4;
                        }
                        if (!AlertController.a(this.q)) break block13;
                        if (n3 != 1) break block14;
                        button = this.c;
                        break block15;
                    }
                    if (n3 != 2) break block16;
                    button = this.e;
                    break block15;
                }
                if (n3 != 4) break block13;
                button = this.g;
            }
            this.a(button);
        }
        if ((n3 = n3 != 0 ? n2 : 0) == 0) {
            viewGroup.setVisibility(8);
        }
    }

    public void a() {
        int n2 = this.b();
        this.a.setContentView(n2);
        this.c();
    }

    public void a(int n2) {
        this.v = null;
        this.w = n2;
        this.B = false;
    }

    public void a(int n2, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message, Drawable drawable2) {
        Message message2 = message;
        if (message == null) {
            message2 = message;
            if (onClickListener != null) {
                message2 = this.p.obtainMessage(n2, (Object)onClickListener);
            }
        }
        switch (n2) {
            default: {
                throw new IllegalArgumentException("Button does not exist");
            }
            case -1: {
                this.C = charSequence;
                this.d = message2;
                this.D = drawable2;
                return;
            }
            case -2: {
                this.E = charSequence;
                this.f = message2;
                this.F = drawable2;
                return;
            }
            case -3: 
        }
        this.G = charSequence;
        this.h = message2;
        this.H = drawable2;
    }

    public void a(Drawable drawable2) {
        this.J = drawable2;
        this.I = 0;
        if (this.K != null) {
            if (drawable2 != null) {
                this.K.setVisibility(0);
                this.K.setImageDrawable(drawable2);
                return;
            }
            this.K.setVisibility(8);
        }
    }

    public void a(View view, int n2, int n3, int n4, int n5) {
        this.v = view;
        this.w = 0;
        this.B = true;
        this.x = n2;
        this.y = n3;
        this.z = n4;
        this.A = n5;
    }

    public void a(CharSequence charSequence) {
        this.t = charSequence;
        if (this.L != null) {
            this.L.setText(charSequence);
        }
    }

    public boolean a(int n2, KeyEvent keyEvent) {
        return this.i != null && this.i.a(keyEvent);
    }

    public void b(int n2) {
        this.J = null;
        this.I = n2;
        if (this.K != null) {
            if (n2 != 0) {
                this.K.setVisibility(0);
                this.K.setImageResource(this.I);
                return;
            }
            this.K.setVisibility(8);
        }
    }

    public void b(View view) {
        this.N = view;
    }

    public void b(CharSequence charSequence) {
        this.u = charSequence;
        if (this.M != null) {
            this.M.setText(charSequence);
        }
    }

    public boolean b(int n2, KeyEvent keyEvent) {
        return this.i != null && this.i.a(keyEvent);
    }

    public int c(int n2) {
        TypedValue typedValue = new TypedValue();
        this.q.getTheme().resolveAttribute(n2, typedValue, true);
        return typedValue.resourceId;
    }

    public void c(View view) {
        this.v = view;
        this.w = 0;
        this.B = false;
    }

    public Button d(int n2) {
        switch (n2) {
            default: {
                return null;
            }
            case -1: {
                return this.c;
            }
            case -2: {
                return this.e;
            }
            case -3: 
        }
        return this.g;
    }

    public static class RecycleListView
    extends ListView {
        private final int a;
        private final int b;

        public RecycleListView(Context context) {
            this(context, null);
        }

        public RecycleListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            context = context.obtainStyledAttributes(attributeSet, a.j.RecycleListView);
            this.b = context.getDimensionPixelOffset(a.j.RecycleListView_paddingBottomNoButtons, -1);
            this.a = context.getDimensionPixelOffset(a.j.RecycleListView_paddingTopNoTitle, -1);
        }

        public void a(boolean bl2, boolean bl3) {
            if (!bl3 || !bl2) {
                int n2 = this.getPaddingLeft();
                int n3 = bl2 ? this.getPaddingTop() : this.a;
                int n4 = this.getPaddingRight();
                int n5 = bl3 ? this.getPaddingBottom() : this.b;
                this.setPadding(n2, n3, n4, n5);
            }
        }
    }

    public static class androidx.appcompat.app.AlertController$a {
        public int A;
        public int B;
        public int C;
        public int D;
        public boolean E = false;
        public boolean[] F;
        public boolean G;
        public boolean H;
        public int I = -1;
        public DialogInterface.OnMultiChoiceClickListener J;
        public Cursor K;
        public String L;
        public String M;
        public AdapterView.OnItemSelectedListener N;
        public a O;
        public boolean P = true;
        public final Context a;
        public final LayoutInflater b;
        public int c = 0;
        public Drawable d;
        public int e = 0;
        public CharSequence f;
        public View g;
        public CharSequence h;
        public CharSequence i;
        public Drawable j;
        public DialogInterface.OnClickListener k;
        public CharSequence l;
        public Drawable m;
        public DialogInterface.OnClickListener n;
        public CharSequence o;
        public Drawable p;
        public DialogInterface.OnClickListener q;
        public boolean r;
        public DialogInterface.OnCancelListener s;
        public DialogInterface.OnDismissListener t;
        public DialogInterface.OnKeyListener u;
        public CharSequence[] v;
        public ListAdapter w;
        public DialogInterface.OnClickListener x;
        public int y;
        public View z;

        public androidx.appcompat.app.AlertController$a(Context context) {
            this.a = context;
            this.r = true;
            this.b = (LayoutInflater)context.getSystemService("layout_inflater");
        }

        /*
         * Enabled aggressive block sorting
         */
        private void b(final AlertController alertController) {
            RecycleListView recycleListView;
            block18 : {
                void var3_10;
                block17 : {
                    block16 : {
                        void var3_8;
                        recycleListView = (RecycleListView)this.b.inflate(alertController.l, null);
                        if (this.G) {
                            if (this.K == null) {
                                ArrayAdapter<CharSequence> arrayAdapter = new ArrayAdapter<CharSequence>(this.a, alertController.m, 16908308, this.v){

                                    public View getView(int n2, View view, ViewGroup viewGroup) {
                                        view = super.getView(n2, view, viewGroup);
                                        if (a.this.F != null && a.this.F[n2]) {
                                            recycleListView.setItemChecked(n2, true);
                                        }
                                        return view;
                                    }
                                };
                            } else {
                                CursorAdapter cursorAdapter = new CursorAdapter(this.a, this.K, false){
                                    private final int d;
                                    private final int e;
                                    {
                                        super(context, cursor, bl2);
                                        a.this = this.getCursor();
                                        this.d = a.this.getColumnIndexOrThrow(a.this.L);
                                        this.e = a.this.getColumnIndexOrThrow(a.this.M);
                                    }

                                    public void bindView(View object, Context context, Cursor cursor) {
                                        ((CheckedTextView)object.findViewById(16908308)).setText((CharSequence)cursor.getString(this.d));
                                        object = recycleListView;
                                        int n2 = cursor.getPosition();
                                        int n3 = cursor.getInt(this.e);
                                        boolean bl2 = true;
                                        if (n3 != 1) {
                                            bl2 = false;
                                        }
                                        object.setItemChecked(n2, bl2);
                                    }

                                    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
                                        return a.this.b.inflate(alertController.m, viewGroup, false);
                                    }
                                };
                            }
                        } else {
                            int n2 = this.H ? alertController.n : alertController.o;
                            if (this.K != null) {
                                SimpleCursorAdapter simpleCursorAdapter = new SimpleCursorAdapter(this.a, n2, this.K, new String[]{this.L}, new int[]{16908308});
                            } else if (this.w != null) {
                                ListAdapter listAdapter = this.w;
                            } else {
                                c c2 = new c(this.a, n2, 16908308, this.v);
                            }
                        }
                        if (this.O != null) {
                            this.O.a(recycleListView);
                        }
                        alertController.j = var3_8;
                        alertController.k = this.I;
                        if (this.x == null) break block16;
                        AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener(){

                            public void onItemClick(AdapterView<?> adapterView, View view, int n2, long l2) {
                                a.this.x.onClick((DialogInterface)alertController.a, n2);
                                if (!a.this.H) {
                                    alertController.a.dismiss();
                                }
                            }
                        };
                        break block17;
                    }
                    if (this.J == null) break block18;
                    AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener(){

                        public void onItemClick(AdapterView<?> adapterView, View view, int n2, long l2) {
                            if (a.this.F != null) {
                                a.this.F[n2] = recycleListView.isItemChecked(n2);
                            }
                            a.this.J.onClick((DialogInterface)alertController.a, n2, recycleListView.isItemChecked(n2));
                        }
                    };
                }
                recycleListView.setOnItemClickListener((AdapterView.OnItemClickListener)var3_10);
            }
            if (this.N != null) {
                recycleListView.setOnItemSelectedListener(this.N);
            }
            if (this.H) {
                recycleListView.setChoiceMode(1);
            } else if (this.G) {
                recycleListView.setChoiceMode(2);
            }
            alertController.b = recycleListView;
        }

        public void a(AlertController alertController) {
            if (this.g != null) {
                alertController.b(this.g);
            } else {
                if (this.f != null) {
                    alertController.a(this.f);
                }
                if (this.d != null) {
                    alertController.a(this.d);
                }
                if (this.c != 0) {
                    alertController.b(this.c);
                }
                if (this.e != 0) {
                    alertController.b(alertController.c(this.e));
                }
            }
            if (this.h != null) {
                alertController.b(this.h);
            }
            if (this.i != null || this.j != null) {
                alertController.a(-1, this.i, this.k, null, this.j);
            }
            if (this.l != null || this.m != null) {
                alertController.a(-2, this.l, this.n, null, this.m);
            }
            if (this.o != null || this.p != null) {
                alertController.a(-3, this.o, this.q, null, this.p);
            }
            if (this.v != null || this.K != null || this.w != null) {
                this.b(alertController);
            }
            if (this.z != null) {
                if (this.E) {
                    alertController.a(this.z, this.A, this.B, this.C, this.D);
                    return;
                }
                alertController.c(this.z);
                return;
            }
            if (this.y != 0) {
                alertController.a(this.y);
            }
        }

        public static interface a {
            public void a(ListView var1);
        }

    }

    private static final class b
    extends Handler {
        private WeakReference<DialogInterface> a;

        public b(DialogInterface dialogInterface) {
            this.a = new WeakReference<DialogInterface>(dialogInterface);
        }

        public void handleMessage(Message message) {
            int n2 = message.what;
            if (n2 != 1) {
                switch (n2) {
                    default: {
                        return;
                    }
                    case -3: 
                    case -2: 
                    case -1: 
                }
                ((DialogInterface.OnClickListener)message.obj).onClick((DialogInterface)this.a.get(), message.what);
                return;
            }
            ((DialogInterface)message.obj).dismiss();
        }
    }

    private static class c
    extends ArrayAdapter<CharSequence> {
        public c(Context context, int n2, int n3, CharSequence[] arrcharSequence) {
            super(context, n2, n3, (Object[])arrcharSequence);
        }

        public long getItemId(int n2) {
            return n2;
        }

        public boolean hasStableIds() {
            return true;
        }
    }

}

