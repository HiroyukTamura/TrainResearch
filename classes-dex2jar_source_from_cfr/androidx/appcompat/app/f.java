/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Dialog
 *  android.app.UiModeManager
 *  android.content.BroadcastReceiver
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.content.pm.ActivityInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.content.res.Resources$NotFoundException
 *  android.content.res.Resources$Theme
 *  android.content.res.TypedArray
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.media.AudioManager
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.text.TextUtils
 *  android.util.AndroidRuntimeException
 *  android.util.AttributeSet
 *  android.util.DisplayMetrics
 *  android.util.Log
 *  android.util.TypedValue
 *  android.view.ActionMode
 *  android.view.ActionMode$Callback
 *  android.view.KeyCharacterMap
 *  android.view.KeyEvent
 *  android.view.KeyboardShortcutGroup
 *  android.view.LayoutInflater
 *  android.view.LayoutInflater$Factory
 *  android.view.LayoutInflater$Factory2
 *  android.view.Menu
 *  android.view.MenuInflater
 *  android.view.MenuItem
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.ViewConfiguration
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 *  android.view.ViewParent
 *  android.view.Window
 *  android.view.Window$Callback
 *  android.view.WindowManager
 *  android.view.WindowManager$LayoutParams
 *  android.widget.FrameLayout
 *  android.widget.ListAdapter
 *  android.widget.PopupWindow
 *  android.widget.TextView
 *  org.xmlpull.v1.XmlPullParser
 */
package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.a;
import androidx.appcompat.app.AppCompatViewInflater;
import androidx.appcompat.app.h;
import androidx.appcompat.app.i;
import androidx.appcompat.app.k;
import androidx.appcompat.app.l;
import androidx.appcompat.view.b;
import androidx.appcompat.view.f;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.view.menu.o;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ViewStubCompat;
import androidx.appcompat.widget.ao;
import androidx.appcompat.widget.at;
import androidx.appcompat.widget.au;
import androidx.appcompat.widget.v;
import androidx.appcompat.widget.z;
import androidx.core.h.ab;
import androidx.core.h.e;
import androidx.core.h.p;
import androidx.core.h.t;
import androidx.core.h.x;
import androidx.core.h.y;
import java.lang.reflect.Constructor;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

class f
extends androidx.appcompat.app.e
implements LayoutInflater.Factory2,
h.a {
    private static final boolean u;
    private static final int[] v;
    private static boolean w;
    private g A;
    private boolean B = true;
    private boolean C;
    private ViewGroup D;
    private TextView E;
    private View F;
    private boolean G;
    private boolean H;
    private boolean I;
    private f[] J;
    private f K;
    private boolean L;
    private int M = -100;
    private boolean N;
    private d O;
    private final Runnable P = new Runnable(){

        @Override
        public void run() {
            if ((f.this.t & 1) != 0) {
                f.this.g(0);
            }
            if ((f.this.t & 4096) != 0) {
                f.this.g(108);
            }
            f.this.s = false;
            f.this.t = 0;
        }
    };
    private boolean Q;
    private Rect R;
    private Rect S;
    private AppCompatViewInflater T;
    final Context a;
    final Window b;
    final Window.Callback c;
    final Window.Callback d;
    final androidx.appcompat.app.d e;
    androidx.appcompat.app.a f;
    MenuInflater g;
    androidx.appcompat.view.b h;
    ActionBarContextView i;
    PopupWindow j;
    Runnable k;
    x l = null;
    boolean m;
    boolean n;
    boolean o;
    boolean p;
    boolean q;
    boolean r;
    boolean s;
    int t;
    private CharSequence x;
    private v y;
    private a z;

    static {
        boolean bl2 = Build.VERSION.SDK_INT < 21;
        u = bl2;
        v = new int[]{16842836};
        if (u && !w) {
            Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler(Thread.getDefaultUncaughtExceptionHandler()){
                final /* synthetic */ Thread.UncaughtExceptionHandler a;
                {
                    this.a = uncaughtExceptionHandler;
                }

                private boolean a(Throwable object) {
                    boolean bl2;
                    block2 : {
                        block3 : {
                            boolean bl3;
                            boolean bl4 = object instanceof Resources.NotFoundException;
                            bl2 = bl3 = false;
                            if (!bl4) break block2;
                            object = ((Throwable)object).getMessage();
                            bl2 = bl3;
                            if (object == null) break block2;
                            if (((String)object).contains("drawable")) break block3;
                            bl2 = bl3;
                            if (!((String)object).contains("Drawable")) break block2;
                        }
                        bl2 = true;
                    }
                    return bl2;
                }

                @Override
                public void uncaughtException(Thread thread, Throwable throwable) {
                    if (this.a(throwable)) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(throwable.getMessage());
                        stringBuilder.append(". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.");
                        stringBuilder = new Resources.NotFoundException(stringBuilder.toString());
                        ((Throwable)((Object)stringBuilder)).initCause(throwable.getCause());
                        ((Throwable)((Object)stringBuilder)).setStackTrace(throwable.getStackTrace());
                        this.a.uncaughtException(thread, (Throwable)((Object)stringBuilder));
                        return;
                    }
                    this.a.uncaughtException(thread, throwable);
                }
            });
            w = true;
        }
    }

    f(Context object, Window window, androidx.appcompat.app.d d2) {
        this.a = object;
        this.b = window;
        this.e = d2;
        this.c = this.b.getCallback();
        if (!(this.c instanceof c)) {
            this.d = new c(this.c);
            this.b.setCallback(this.d);
            object = ao.a((Context)object, null, v);
            window = ((ao)object).b(0);
            if (window != null) {
                this.b.setBackgroundDrawable((Drawable)window);
            }
            ((ao)object).a();
            return;
        }
        throw new IllegalStateException("AppCompat has already installed itself into the Window");
    }

    private boolean A() {
        boolean bl2 = this.N;
        boolean bl3 = false;
        if (bl2 && this.a instanceof Activity) {
            PackageManager packageManager = this.a.getPackageManager();
            try {
                int n2 = packageManager.getActivityInfo((ComponentName)new ComponentName((Context)this.a, this.a.getClass()), (int)0).configChanges;
                if ((n2 & 512) == 0) {
                    bl3 = true;
                }
                return bl3;
            }
            catch (PackageManager.NameNotFoundException nameNotFoundException) {
                Log.d((String)"AppCompatDelegate", (String)"Exception while getting ActivityInfo", (Throwable)nameNotFoundException);
                return true;
            }
        }
        return false;
    }

    private void a(f f2, KeyEvent keyEvent) {
        block17 : {
            int n2;
            WindowManager windowManager;
            block20 : {
                block19 : {
                    Window.Callback callback;
                    block18 : {
                        if (f2.o) break block17;
                        if (this.r) {
                            return;
                        }
                        if (f2.a == 0 && (n2 = (this.a.getResources().getConfiguration().screenLayout & 15) == 4 ? 1 : 0) != 0) {
                            return;
                        }
                        callback = this.l();
                        if (callback != null && !callback.onMenuOpened(f2.a, (Menu)f2.j)) {
                            this.a(f2, true);
                            return;
                        }
                        windowManager = (WindowManager)this.a.getSystemService("window");
                        if (windowManager == null) {
                            return;
                        }
                        if (!this.b(f2, keyEvent)) {
                            return;
                        }
                        if (f2.g == null || f2.q) break block18;
                        if (f2.i == null || (keyEvent = f2.i.getLayoutParams()) == null || keyEvent.width != -1) break block19;
                        n2 = -1;
                        break block20;
                    }
                    if (f2.g == null) {
                        if (!this.a(f2) || f2.g == null) {
                            return;
                        }
                    } else if (f2.q && f2.g.getChildCount() > 0) {
                        f2.g.removeAllViews();
                    }
                    if (!this.c(f2)) break block17;
                    if (!f2.a()) {
                        return;
                    }
                    callback = f2.h.getLayoutParams();
                    keyEvent = callback;
                    if (callback == null) {
                        keyEvent = new ViewGroup.LayoutParams(-2, -2);
                    }
                    n2 = f2.b;
                    f2.g.setBackgroundResource(n2);
                    callback = f2.h.getParent();
                    if (callback != null && callback instanceof ViewGroup) {
                        ((ViewGroup)callback).removeView(f2.h);
                    }
                    f2.g.addView(f2.h, (ViewGroup.LayoutParams)keyEvent);
                    if (!f2.h.hasFocus()) {
                        f2.h.requestFocus();
                    }
                }
                n2 = -2;
            }
            f2.n = false;
            keyEvent = new WindowManager.LayoutParams(n2, -2, f2.d, f2.e, 1002, 8519680, -3);
            keyEvent.gravity = f2.c;
            keyEvent.windowAnimations = f2.f;
            windowManager.addView((View)f2.g, (ViewGroup.LayoutParams)keyEvent);
            f2.o = true;
        }
    }

    private void a(androidx.appcompat.view.menu.h object, boolean bl2) {
        if (this.y != null && this.y.e() && (!ViewConfiguration.get((Context)this.a).hasPermanentMenuKey() || this.y.g())) {
            object = this.l();
            if (this.y.f() && bl2) {
                this.y.i();
                if (!this.r) {
                    object.onPanelClosed(108, (Menu)this.a((int)0, (boolean)true).j);
                    return;
                }
            } else if (object != null && !this.r) {
                if (this.s && (this.t & 1) != 0) {
                    this.b.getDecorView().removeCallbacks(this.P);
                    this.P.run();
                }
                f f2 = this.a(0, true);
                if (f2.j != null && !f2.r && object.onPreparePanel(0, f2.i, (Menu)f2.j)) {
                    object.onMenuOpened(108, (Menu)f2.j);
                    this.y.h();
                }
            }
            return;
        }
        object = this.a(0, true);
        ((f)object).q = true;
        this.a((f)object, false);
        this.a((f)object, null);
    }

    private boolean a(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        View view = this.b.getDecorView();
        do {
            if (viewParent == null) {
                return true;
            }
            if (viewParent == view || !(viewParent instanceof View)) break;
            if (t.B((View)viewParent)) {
                return false;
            }
            viewParent = viewParent.getParent();
        } while (true);
        return false;
    }

    private boolean a(f f2) {
        f2.a(this.m());
        f2.g = new e(f2.l);
        f2.c = 81;
        return true;
    }

    private boolean a(f f2, int n2, KeyEvent keyEvent, int n3) {
        boolean bl2;
        block7 : {
            boolean bl3;
            block6 : {
                bl2 = keyEvent.isSystem();
                bl3 = false;
                if (bl2) {
                    return false;
                }
                if (f2.m) break block6;
                bl2 = bl3;
                if (!this.b(f2, keyEvent)) break block7;
            }
            bl2 = bl3;
            if (f2.j != null) {
                bl2 = f2.j.performShortcut(n2, keyEvent, n3);
            }
        }
        if (bl2 && (n3 & 1) == 0 && this.y == null) {
            this.a(f2, true);
        }
        return bl2;
    }

    private boolean b(f f2) {
        Object object;
        block10 : {
            Context context;
            block9 : {
                context = this.a;
                if (f2.a == 0) break block9;
                object = context;
                if (f2.a != 108) break block10;
            }
            object = context;
            if (this.y != null) {
                TypedValue typedValue = new TypedValue();
                Resources.Theme theme = context.getTheme();
                theme.resolveAttribute(a.a.actionBarTheme, typedValue, true);
                object = null;
                if (typedValue.resourceId != 0) {
                    object = context.getResources().newTheme();
                    object.setTo(theme);
                    object.applyStyle(typedValue.resourceId, true);
                    object.resolveAttribute(a.a.actionBarWidgetTheme, typedValue, true);
                } else {
                    theme.resolveAttribute(a.a.actionBarWidgetTheme, typedValue, true);
                }
                Object object2 = object;
                if (typedValue.resourceId != 0) {
                    object2 = object;
                    if (object == null) {
                        object2 = context.getResources().newTheme();
                        object2.setTo(theme);
                    }
                    object2.applyStyle(typedValue.resourceId, true);
                }
                object = context;
                if (object2 != null) {
                    object = new androidx.appcompat.view.d(context, 0);
                    object.getTheme().setTo((Resources.Theme)object2);
                }
            }
        }
        object = new androidx.appcompat.view.menu.h((Context)object);
        object.a(this);
        f2.a((androidx.appcompat.view.menu.h)object);
        return true;
    }

    private boolean b(f f2, KeyEvent keyEvent) {
        Window.Callback callback;
        if (this.r) {
            return false;
        }
        if (f2.m) {
            return true;
        }
        if (this.K != null && this.K != f2) {
            this.a(this.K, false);
        }
        if ((callback = this.l()) != null) {
            f2.i = callback.onCreatePanelView(f2.a);
        }
        int n2 = f2.a != 0 && f2.a != 108 ? 0 : 1;
        if (n2 != 0 && this.y != null) {
            this.y.j();
        }
        if (!(f2.i != null || n2 != 0 && this.k() instanceof i)) {
            if (f2.j == null || f2.r) {
                if (!(f2.j != null || this.b(f2) && f2.j != null)) {
                    return false;
                }
                if (n2 != 0 && this.y != null) {
                    if (this.z == null) {
                        this.z = new a();
                    }
                    this.y.a(f2.j, this.z);
                }
                f2.j.h();
                if (!callback.onCreatePanelMenu(f2.a, (Menu)f2.j)) {
                    f2.a((androidx.appcompat.view.menu.h)null);
                    if (n2 != 0 && this.y != null) {
                        this.y.a(null, this.z);
                    }
                    return false;
                }
                f2.r = false;
            }
            f2.j.h();
            if (f2.s != null) {
                f2.j.b(f2.s);
                f2.s = null;
            }
            if (!callback.onPreparePanel(0, f2.i, (Menu)f2.j)) {
                if (n2 != 0 && this.y != null) {
                    this.y.a(null, this.z);
                }
                f2.j.i();
                return false;
            }
            n2 = keyEvent != null ? keyEvent.getDeviceId() : -1;
            boolean bl2 = KeyCharacterMap.load((int)n2).getKeyboardType() != 1;
            f2.p = bl2;
            f2.j.setQwertyMode(f2.p);
            f2.j.i();
        }
        f2.m = true;
        f2.n = false;
        this.K = f2;
        return true;
    }

    private boolean c(f f2) {
        if (f2.i != null) {
            f2.h = f2.i;
            return true;
        }
        if (f2.j == null) {
            return false;
        }
        if (this.A == null) {
            this.A = new g();
        }
        f2.h = (View)f2.a(this.A);
        return f2.h != null;
    }

    private boolean d(int n2, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() == 0) {
            f f2 = this.a(n2, true);
            if (!f2.o) {
                return this.b(f2, keyEvent);
            }
        }
        return false;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean e(int n2, KeyEvent keyEvent) {
        boolean bl2;
        if (this.h != null) {
            return false;
        }
        f f2 = this.a(n2, true);
        if (n2 == 0 && this.y != null && this.y.e() && !ViewConfiguration.get((Context)this.a).hasPermanentMenuKey()) {
            if (!this.y.f()) {
                if (this.r) return false;
                if (!this.b(f2, keyEvent)) return false;
                bl2 = this.y.h();
            } else {
                bl2 = this.y.i();
            }
        } else if (!f2.o && !f2.n) {
            if (!f2.m) return false;
            if (f2.r) {
                f2.m = false;
                bl2 = this.b(f2, keyEvent);
            } else {
                bl2 = true;
            }
            if (!bl2) return false;
            this.a(f2, keyEvent);
            bl2 = true;
        } else {
            bl2 = f2.o;
            this.a(f2, true);
        }
        if (!bl2) return bl2;
        keyEvent = (AudioManager)this.a.getSystemService("audio");
        if (keyEvent != null) {
            keyEvent.playSoundEffect(0);
            return bl2;
        }
        Log.w((String)"AppCompatDelegate", (String)"Couldn't get audio manager");
        return bl2;
    }

    private void j(int n2) {
        this.t = 1 << n2 | this.t;
        if (!this.s) {
            t.a(this.b.getDecorView(), this.P);
            this.s = true;
        }
    }

    private int k(int n2) {
        if (n2 == 8) {
            Log.i((String)"AppCompatDelegate", (String)"You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            return 108;
        }
        int n3 = n2;
        if (n2 == 9) {
            Log.i((String)"AppCompatDelegate", (String)"You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            n3 = 109;
        }
        return n3;
    }

    private boolean l(int n2) {
        Resources resources = this.a.getResources();
        Configuration configuration = resources.getConfiguration();
        int n3 = configuration.uiMode;
        if ((n3 & 48) != (n2 = n2 == 2 ? 32 : 16)) {
            if (this.A()) {
                ((Activity)this.a).recreate();
            } else {
                configuration = new Configuration(configuration);
                DisplayMetrics displayMetrics = resources.getDisplayMetrics();
                configuration.uiMode = n2 | configuration.uiMode & -49;
                resources.updateConfiguration(configuration, displayMetrics);
                if (Build.VERSION.SDK_INT < 26) {
                    h.a(resources);
                }
            }
            return true;
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     */
    private void t() {
        block5 : {
            block8 : {
                l l2;
                block7 : {
                    block6 : {
                        this.u();
                        if (!this.m) break block5;
                        if (this.f != null) {
                            return;
                        }
                        if (!(this.c instanceof Activity)) break block6;
                        l2 = new l((Activity)this.c, this.n);
                        break block7;
                    }
                    if (!(this.c instanceof Dialog)) break block8;
                    l2 = new l((Dialog)this.c);
                }
                this.f = l2;
            }
            if (this.f != null) {
                this.f.d(this.Q);
            }
        }
    }

    private void u() {
        if (!this.C) {
            this.D = this.v();
            Object object = this.n();
            if (!TextUtils.isEmpty((CharSequence)object)) {
                if (this.y != null) {
                    this.y.setWindowTitle((CharSequence)object);
                } else if (this.k() != null) {
                    this.k().a((CharSequence)object);
                } else if (this.E != null) {
                    this.E.setText((CharSequence)object);
                }
            }
            this.w();
            this.a(this.D);
            this.C = true;
            object = this.a(0, false);
            if (!(this.r || object != null && ((f)object).j != null)) {
                this.j(108);
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private ViewGroup v() {
        void var2_12;
        ContentFrameLayout contentFrameLayout;
        TypedArray typedArray = this.a.obtainStyledAttributes(a.j.AppCompatTheme);
        if (!typedArray.hasValue(a.j.AppCompatTheme_windowActionBar)) {
            typedArray.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
        if (typedArray.getBoolean(a.j.AppCompatTheme_windowNoTitle, false)) {
            this.c(1);
        } else if (typedArray.getBoolean(a.j.AppCompatTheme_windowActionBar, false)) {
            this.c(108);
        }
        if (typedArray.getBoolean(a.j.AppCompatTheme_windowActionBarOverlay, false)) {
            this.c(109);
        }
        if (typedArray.getBoolean(a.j.AppCompatTheme_windowActionModeOverlay, false)) {
            this.c(10);
        }
        this.p = typedArray.getBoolean(a.j.AppCompatTheme_android_windowIsFloating, false);
        typedArray.recycle();
        this.b.getDecorView();
        LayoutInflater layoutInflater = LayoutInflater.from((Context)this.a);
        if (!this.q) {
            if (this.p) {
                ViewGroup viewGroup = (ViewGroup)layoutInflater.inflate(a.g.abc_dialog_title_material, null);
                this.n = false;
                this.m = false;
            } else if (this.m) {
                void var2_7;
                TypedValue typedValue = new TypedValue();
                this.a.getTheme().resolveAttribute(a.a.actionBarTheme, typedValue, true);
                if (typedValue.resourceId != 0) {
                    androidx.appcompat.view.d d2 = new androidx.appcompat.view.d(this.a, typedValue.resourceId);
                } else {
                    Context context = this.a;
                }
                contentFrameLayout = (ViewGroup)LayoutInflater.from((Context)var2_7).inflate(a.g.abc_screen_toolbar, null);
                this.y = (v)contentFrameLayout.findViewById(a.f.decor_content_parent);
                this.y.setWindowCallback(this.l());
                if (this.n) {
                    this.y.a(109);
                }
                if (this.G) {
                    this.y.a(2);
                }
                ContentFrameLayout contentFrameLayout2 = contentFrameLayout;
                if (this.H) {
                    this.y.a(5);
                    ContentFrameLayout contentFrameLayout3 = contentFrameLayout;
                }
            } else {
                Object var2_10 = null;
            }
        } else {
            int n2 = this.o ? a.g.abc_screen_simple_overlay_action_mode : a.g.abc_screen_simple;
            ViewGroup viewGroup = (ViewGroup)layoutInflater.inflate(n2, null);
            if (Build.VERSION.SDK_INT >= 21) {
                t.a((View)viewGroup, new p(){

                    @Override
                    public ab a(View view, ab ab2) {
                        int n2 = ab2.b();
                        int n3 = f.this.h(n2);
                        ab ab3 = ab2;
                        if (n2 != n3) {
                            ab3 = ab2.a(ab2.a(), n3, ab2.c(), ab2.d());
                        }
                        return t.a(view, ab3);
                    }
                });
            } else {
                ((z)viewGroup).setOnFitSystemWindowsListener(new z.a(){

                    @Override
                    public void a(Rect rect) {
                        rect.top = f.this.h(rect.top);
                    }
                });
            }
        }
        if (var2_12 == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("AppCompat does not support the current theme features: { windowActionBar: ");
            stringBuilder.append(this.m);
            stringBuilder.append(", windowActionBarOverlay: ");
            stringBuilder.append(this.n);
            stringBuilder.append(", android:windowIsFloating: ");
            stringBuilder.append(this.p);
            stringBuilder.append(", windowActionModeOverlay: ");
            stringBuilder.append(this.o);
            stringBuilder.append(", windowNoTitle: ");
            stringBuilder.append(this.q);
            stringBuilder.append(" }");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        if (this.y == null) {
            this.E = (TextView)var2_12.findViewById(a.f.title);
        }
        au.b((View)var2_12);
        contentFrameLayout = (ContentFrameLayout)var2_12.findViewById(a.f.action_bar_activity_content);
        ViewGroup viewGroup = (ViewGroup)this.b.findViewById(16908290);
        if (viewGroup != null) {
            while (viewGroup.getChildCount() > 0) {
                View view = viewGroup.getChildAt(0);
                viewGroup.removeViewAt(0);
                contentFrameLayout.addView(view);
            }
            viewGroup.setId(-1);
            contentFrameLayout.setId(16908290);
            if (viewGroup instanceof FrameLayout) {
                ((FrameLayout)viewGroup).setForeground(null);
            }
        }
        this.b.setContentView((View)var2_12);
        contentFrameLayout.setAttachListener(new ContentFrameLayout.a(){

            @Override
            public void a() {
            }

            @Override
            public void b() {
                f.this.s();
            }
        });
        return var2_12;
    }

    private void w() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout)this.D.findViewById(16908290);
        View view = this.b.getDecorView();
        contentFrameLayout.a(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom());
        view = this.a.obtainStyledAttributes(a.j.AppCompatTheme);
        view.getValue(a.j.AppCompatTheme_windowMinWidthMajor, contentFrameLayout.getMinWidthMajor());
        view.getValue(a.j.AppCompatTheme_windowMinWidthMinor, contentFrameLayout.getMinWidthMinor());
        if (view.hasValue(a.j.AppCompatTheme_windowFixedWidthMajor)) {
            view.getValue(a.j.AppCompatTheme_windowFixedWidthMajor, contentFrameLayout.getFixedWidthMajor());
        }
        if (view.hasValue(a.j.AppCompatTheme_windowFixedWidthMinor)) {
            view.getValue(a.j.AppCompatTheme_windowFixedWidthMinor, contentFrameLayout.getFixedWidthMinor());
        }
        if (view.hasValue(a.j.AppCompatTheme_windowFixedHeightMajor)) {
            view.getValue(a.j.AppCompatTheme_windowFixedHeightMajor, contentFrameLayout.getFixedHeightMajor());
        }
        if (view.hasValue(a.j.AppCompatTheme_windowFixedHeightMinor)) {
            view.getValue(a.j.AppCompatTheme_windowFixedHeightMinor, contentFrameLayout.getFixedHeightMinor());
        }
        view.recycle();
        contentFrameLayout.requestLayout();
    }

    private void x() {
        if (!this.C) {
            return;
        }
        throw new AndroidRuntimeException("Window feature must be requested before adding content");
    }

    private int y() {
        if (this.M != -100) {
            return this.M;
        }
        return f.j();
    }

    private void z() {
        if (this.O == null) {
            this.O = new d(k.a(this.a));
        }
    }

    @Override
    public <T extends View> T a(int n2) {
        this.u();
        return (T)this.b.findViewById(n2);
    }

    public View a(View view, String string2, Context context, AttributeSet attributeSet) {
        boolean bl2;
        block9 : {
            Object object = this.T;
            bl2 = false;
            if (object == null) {
                block10 : {
                    object = this.a.obtainStyledAttributes(a.j.AppCompatTheme).getString(a.j.AppCompatTheme_viewInflaterClass);
                    if (object != null && !AppCompatViewInflater.class.getName().equals(object)) {
                        try {
                            this.T = (AppCompatViewInflater)Class.forName((String)object).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                            break block9;
                        }
                        catch (Throwable throwable) {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("Failed to instantiate custom view inflater ");
                            stringBuilder.append((String)object);
                            stringBuilder.append(". Falling back to default.");
                            Log.i((String)"AppCompatDelegate", (String)stringBuilder.toString(), (Throwable)throwable);
                            object = new AppCompatViewInflater();
                            break block10;
                        }
                    }
                    object = new AppCompatViewInflater();
                }
                this.T = object;
            }
        }
        if (u) {
            if (attributeSet instanceof XmlPullParser) {
                if (((XmlPullParser)attributeSet).getDepth() > 1) {
                    bl2 = true;
                }
            } else {
                bl2 = this.a((ViewParent)view);
            }
        } else {
            bl2 = false;
        }
        return this.T.createView(view, string2, context, attributeSet, bl2, u, true, at.a());
    }

    @Override
    public androidx.appcompat.app.a a() {
        this.t();
        return this.f;
    }

    protected f a(int n2, boolean bl2) {
        Object object;
        f[] arrf;
        block6 : {
            block5 : {
                object = this.J;
                if (object == null) break block5;
                arrf = object;
                if (((f[])object).length > n2) break block6;
            }
            arrf = new f[n2 + 1];
            if (object != null) {
                System.arraycopy(object, 0, arrf, 0, ((f[])object).length);
            }
            this.J = arrf;
        }
        f f2 = arrf[n2];
        object = f2;
        if (f2 == null) {
            arrf[n2] = object = new f(n2);
        }
        return object;
    }

    f a(Menu menu) {
        f[] arrf = this.J;
        int n2 = arrf != null ? arrf.length : 0;
        for (int i2 = 0; i2 < n2; ++i2) {
            f f2 = arrf[i2];
            if (f2 == null || f2.j != menu) continue;
            return f2;
        }
        return null;
    }

    public androidx.appcompat.view.b a(b.a a2) {
        if (a2 != null) {
            if (this.h != null) {
                this.h.c();
            }
            a2 = new b(a2);
            androidx.appcompat.app.a a3 = this.a();
            if (a3 != null) {
                this.h = a3.a(a2);
                if (this.h != null && this.e != null) {
                    this.e.a(this.h);
                }
            }
            if (this.h == null) {
                this.h = this.b(a2);
            }
            return this.h;
        }
        throw new IllegalArgumentException("ActionMode callback can not be null.");
    }

    void a(int n2, f f2, Menu menu) {
        f f3 = f2;
        Menu menu2 = menu;
        if (menu == null) {
            f f4 = f2;
            if (f2 == null) {
                f4 = f2;
                if (n2 >= 0) {
                    f4 = f2;
                    if (n2 < this.J.length) {
                        f4 = this.J[n2];
                    }
                }
            }
            f3 = f4;
            menu2 = menu;
            if (f4 != null) {
                menu2 = f4.j;
                f3 = f4;
            }
        }
        if (f3 != null && !f3.o) {
            return;
        }
        if (!this.r) {
            this.c.onPanelClosed(n2, menu2);
        }
    }

    @Override
    public void a(Configuration configuration) {
        androidx.appcompat.app.a a2;
        if (this.m && this.C && (a2 = this.a()) != null) {
            a2.a(configuration);
        }
        androidx.appcompat.widget.i.a().a(this.a);
        this.i();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void a(Bundle bundle) {
        if (this.c instanceof Activity) {
            Object object;
            object = null;
            try {
                String string2 = androidx.core.app.e.b((Activity)this.c);
                object = string2;
            }
            catch (IllegalArgumentException illegalArgumentException) {}
            if (object != null) {
                object = this.k();
                if (object == null) {
                    this.Q = true;
                } else {
                    ((androidx.appcompat.app.a)object).d(true);
                }
            }
        }
        if (bundle != null && this.M == -100) {
            this.M = bundle.getInt("appcompat:local_night_mode", -100);
        }
    }

    @Override
    public void a(View view) {
        this.u();
        ViewGroup viewGroup = (ViewGroup)this.D.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.c.onContentChanged();
    }

    @Override
    public void a(View view, ViewGroup.LayoutParams layoutParams) {
        this.u();
        ViewGroup viewGroup = (ViewGroup)this.D.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.c.onContentChanged();
    }

    void a(ViewGroup viewGroup) {
    }

    void a(f f2, boolean bl2) {
        if (bl2 && f2.a == 0 && this.y != null && this.y.f()) {
            this.b(f2.j);
            return;
        }
        WindowManager windowManager = (WindowManager)this.a.getSystemService("window");
        if (windowManager != null && f2.o && f2.g != null) {
            windowManager.removeView((View)f2.g);
            if (bl2) {
                this.a(f2.a, f2, null);
            }
        }
        f2.m = false;
        f2.n = false;
        f2.o = false;
        f2.h = null;
        f2.q = true;
        if (this.K == f2) {
            this.K = null;
        }
    }

    @Override
    public void a(androidx.appcompat.view.menu.h h2) {
        this.a(h2, true);
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public void a(Toolbar object) {
        if (!(this.c instanceof Activity)) {
            return;
        }
        androidx.appcompat.app.a a2 = this.a();
        if (a2 instanceof l) {
            throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
        }
        this.g = null;
        if (a2 != null) {
            a2.g();
        }
        if (object != null) {
            this.f = object = new i((Toolbar)((Object)object), ((Activity)this.c).getTitle(), this.d);
            a2 = this.b;
            object = ((i)object).h();
        } else {
            this.f = null;
            a2 = this.b;
            object = this.d;
        }
        a2.setCallback((Window.Callback)object);
        this.f();
    }

    @Override
    public final void a(CharSequence charSequence) {
        this.x = charSequence;
        if (this.y != null) {
            this.y.setWindowTitle(charSequence);
            return;
        }
        if (this.k() != null) {
            this.k().a(charSequence);
            return;
        }
        if (this.E != null) {
            this.E.setText(charSequence);
        }
    }

    boolean a(int n2, KeyEvent keyEvent) {
        Object object = this.a();
        if (object != null && ((androidx.appcompat.app.a)object).a(n2, keyEvent)) {
            return true;
        }
        if (this.K != null && this.a(this.K, keyEvent.getKeyCode(), keyEvent, 1)) {
            if (this.K != null) {
                this.K.n = true;
            }
            return true;
        }
        if (this.K == null) {
            object = this.a(0, true);
            this.b((f)object, keyEvent);
            boolean bl2 = this.a((f)object, keyEvent.getKeyCode(), keyEvent, 1);
            ((f)object).m = false;
            if (bl2) {
                return true;
            }
        }
        return false;
    }

    boolean a(KeyEvent keyEvent) {
        View view;
        boolean bl2 = this.c instanceof e.a;
        boolean bl3 = true;
        if ((bl2 || this.c instanceof androidx.appcompat.app.g) && (view = this.b.getDecorView()) != null && androidx.core.h.e.a(view, keyEvent)) {
            return true;
        }
        if (keyEvent.getKeyCode() == 82 && this.c.dispatchKeyEvent(keyEvent)) {
            return true;
        }
        int n2 = keyEvent.getKeyCode();
        if (keyEvent.getAction() != 0) {
            bl3 = false;
        }
        if (bl3) {
            return this.c(n2, keyEvent);
        }
        return this.b(n2, keyEvent);
    }

    @Override
    public boolean a(androidx.appcompat.view.menu.h object, MenuItem menuItem) {
        Window.Callback callback = this.l();
        if (callback != null && !this.r && (object = this.a((Menu)((androidx.appcompat.view.menu.h)object).q())) != null) {
            return callback.onMenuItemSelected(((f)object).a, menuItem);
        }
        return false;
    }

    @Override
    public MenuInflater b() {
        if (this.g == null) {
            this.t();
            Context context = this.f != null ? this.f.b() : this.a;
            this.g = new androidx.appcompat.view.g(context);
        }
        return this.g;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    androidx.appcompat.view.b b(b.a object) {
        void var1_5;
        Object object2;
        block22 : {
            this.q();
            if (this.h != null) {
                this.h.c();
            }
            object2 = object;
            if (!(object instanceof b)) {
                object2 = new b((b.a)object);
            }
            if (this.e != null && !this.r) {
                try {
                    androidx.appcompat.view.b b2 = this.e.a((b.a)object2);
                    break block22;
                }
                catch (AbstractMethodError abstractMethodError) {}
            }
            Object var1_4 = null;
        }
        if (var1_5 != null) {
            this.h = var1_5;
        } else {
            ActionBarContextView actionBarContextView = this.i;
            boolean bl2 = true;
            if (actionBarContextView == null) {
                if (this.p) {
                    void var1_10;
                    TypedValue typedValue = new TypedValue();
                    Resources.Theme theme = this.a.getTheme();
                    theme.resolveAttribute(a.a.actionBarTheme, typedValue, true);
                    if (typedValue.resourceId != 0) {
                        Resources.Theme theme2 = this.a.getResources().newTheme();
                        theme2.setTo(theme);
                        theme2.applyStyle(typedValue.resourceId, true);
                        androidx.appcompat.view.d d2 = new androidx.appcompat.view.d(this.a, 0);
                        d2.getTheme().setTo(theme2);
                    } else {
                        Context context = this.a;
                    }
                    this.i = new ActionBarContextView((Context)var1_10);
                    this.j = new PopupWindow((Context)var1_10, null, a.a.actionModePopupWindowStyle);
                    androidx.core.widget.h.a(this.j, 2);
                    this.j.setContentView((View)this.i);
                    this.j.setWidth(-1);
                    var1_10.getTheme().resolveAttribute(a.a.actionBarSize, typedValue, true);
                    int n2 = TypedValue.complexToDimensionPixelSize((int)typedValue.data, (DisplayMetrics)var1_10.getResources().getDisplayMetrics());
                    this.i.setContentHeight(n2);
                    this.j.setHeight(-2);
                    this.k = new Runnable(){

                        @Override
                        public void run() {
                            f.this.j.showAtLocation((View)f.this.i, 55, 0, 0);
                            f.this.q();
                            if (f.this.o()) {
                                f.this.i.setAlpha(0.0f);
                                f.this.l = t.m((View)f.this.i).a(1.0f);
                                f.this.l.a(new androidx.core.h.z(){

                                    @Override
                                    public void a(View view) {
                                        f.this.i.setVisibility(0);
                                    }

                                    @Override
                                    public void b(View view) {
                                        f.this.i.setAlpha(1.0f);
                                        f.this.l.a((y)null);
                                        f.this.l = null;
                                    }
                                });
                                return;
                            }
                            f.this.i.setAlpha(1.0f);
                            f.this.i.setVisibility(0);
                        }

                    };
                } else {
                    ViewStubCompat viewStubCompat = (ViewStubCompat)this.D.findViewById(a.f.action_mode_bar_stub);
                    if (viewStubCompat != null) {
                        viewStubCompat.setLayoutInflater(LayoutInflater.from((Context)this.m()));
                        this.i = (ActionBarContextView)viewStubCompat.a();
                    }
                }
            }
            if (this.i != null) {
                this.q();
                this.i.c();
                Context context = this.i.getContext();
                ActionBarContextView actionBarContextView2 = this.i;
                if (this.j != null) {
                    bl2 = false;
                }
                androidx.appcompat.view.e e2 = new androidx.appcompat.view.e(context, actionBarContextView2, (b.a)object2, bl2);
                if (object2.a((androidx.appcompat.view.b)e2, ((androidx.appcompat.view.b)e2).b())) {
                    ((androidx.appcompat.view.b)e2).d();
                    this.i.a(e2);
                    this.h = e2;
                    if (this.o()) {
                        this.i.setAlpha(0.0f);
                        this.l = t.m((View)this.i).a(1.0f);
                        this.l.a(new androidx.core.h.z(){

                            @Override
                            public void a(View view) {
                                f.this.i.setVisibility(0);
                                f.this.i.sendAccessibilityEvent(32);
                                if (f.this.i.getParent() instanceof View) {
                                    t.q((View)f.this.i.getParent());
                                }
                            }

                            @Override
                            public void b(View view) {
                                f.this.i.setAlpha(1.0f);
                                f.this.l.a((y)null);
                                f.this.l = null;
                            }
                        });
                    } else {
                        this.i.setAlpha(1.0f);
                        this.i.setVisibility(0);
                        this.i.sendAccessibilityEvent(32);
                        if (this.i.getParent() instanceof View) {
                            t.q((View)this.i.getParent());
                        }
                    }
                    if (this.j != null) {
                        this.b.getDecorView().post(this.k);
                    }
                } else {
                    this.h = null;
                }
            }
        }
        if (this.h != null && this.e != null) {
            this.e.a(this.h);
        }
        return this.h;
    }

    @Override
    public void b(int n2) {
        this.u();
        ViewGroup viewGroup = (ViewGroup)this.D.findViewById(16908290);
        viewGroup.removeAllViews();
        LayoutInflater.from((Context)this.a).inflate(n2, viewGroup);
        this.c.onContentChanged();
    }

    @Override
    public void b(Bundle bundle) {
        this.u();
    }

    @Override
    public void b(View view, ViewGroup.LayoutParams layoutParams) {
        this.u();
        ((ViewGroup)this.D.findViewById(16908290)).addView(view, layoutParams);
        this.c.onContentChanged();
    }

    void b(androidx.appcompat.view.menu.h h2) {
        if (this.I) {
            return;
        }
        this.I = true;
        this.y.k();
        Window.Callback callback = this.l();
        if (callback != null && !this.r) {
            callback.onPanelClosed(108, (Menu)h2);
        }
        this.I = false;
    }

    boolean b(int n2, KeyEvent object) {
        if (n2 != 4) {
            if (n2 != 82) {
                return false;
            }
            this.e(0, (KeyEvent)object);
            return true;
        }
        boolean bl2 = this.L;
        this.L = false;
        object = this.a(0, false);
        if (object != null && object.o) {
            if (!bl2) {
                this.a((f)object, true);
            }
            return true;
        }
        return this.r();
    }

    @Override
    public void c() {
        this.i();
    }

    @Override
    public void c(Bundle bundle) {
        if (this.M != -100) {
            bundle.putInt("appcompat:local_night_mode", this.M);
        }
    }

    @Override
    public boolean c(int n2) {
        n2 = this.k(n2);
        if (this.q && n2 == 108) {
            return false;
        }
        if (this.m && n2 == 1) {
            this.m = false;
        }
        switch (n2) {
            default: {
                return this.b.requestFeature(n2);
            }
            case 109: {
                this.x();
                this.n = true;
                return true;
            }
            case 108: {
                this.x();
                this.m = true;
                return true;
            }
            case 10: {
                this.x();
                this.o = true;
                return true;
            }
            case 5: {
                this.x();
                this.H = true;
                return true;
            }
            case 2: {
                this.x();
                this.G = true;
                return true;
            }
            case 1: 
        }
        this.x();
        this.q = true;
        return true;
    }

    boolean c(int n2, KeyEvent keyEvent) {
        boolean bl2 = true;
        if (n2 != 4) {
            if (n2 != 82) {
                return false;
            }
            this.d(0, keyEvent);
            return true;
        }
        if ((keyEvent.getFlags() & 128) == 0) {
            bl2 = false;
        }
        this.L = bl2;
        return false;
    }

    @Override
    public void d() {
        androidx.appcompat.app.a a2 = this.a();
        if (a2 != null) {
            a2.e(false);
        }
        if (this.O != null) {
            this.O.d();
        }
    }

    void d(int n2) {
        if (n2 == 108) {
            androidx.appcompat.app.a a2 = this.a();
            if (a2 != null) {
                a2.f(false);
                return;
            }
        } else if (n2 == 0) {
            f f2 = this.a(n2, true);
            if (f2.o) {
                this.a(f2, false);
            }
        }
    }

    @Override
    public void e() {
        androidx.appcompat.app.a a2 = this.a();
        if (a2 != null) {
            a2.e(true);
        }
    }

    void e(int n2) {
        androidx.appcompat.app.a a2;
        if (n2 == 108 && (a2 = this.a()) != null) {
            a2.f(true);
        }
    }

    @Override
    public void f() {
        androidx.appcompat.app.a a2 = this.a();
        if (a2 != null && a2.e()) {
            return;
        }
        this.j(0);
    }

    void f(int n2) {
        this.a(this.a(n2, true), true);
    }

    @Override
    public void g() {
        if (this.s) {
            this.b.getDecorView().removeCallbacks(this.P);
        }
        this.r = true;
        if (this.f != null) {
            this.f.g();
        }
        if (this.O != null) {
            this.O.d();
        }
    }

    void g(int n2) {
        f f2 = this.a(n2, true);
        if (f2.j != null) {
            Bundle bundle = new Bundle();
            f2.j.a(bundle);
            if (bundle.size() > 0) {
                f2.s = bundle;
            }
            f2.j.h();
            f2.j.clear();
        }
        f2.r = true;
        f2.q = true;
        if ((n2 == 108 || n2 == 0) && this.y != null && (f2 = this.a(0, false)) != null) {
            f2.m = false;
            this.b(f2, null);
        }
    }

    int h(int n2) {
        int n3;
        int n4;
        ActionBarContextView actionBarContextView = this.i;
        int n5 = 0;
        if (actionBarContextView != null && this.i.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            int n6;
            int n7;
            actionBarContextView = (ViewGroup.MarginLayoutParams)this.i.getLayoutParams();
            boolean bl2 = this.i.isShown();
            int n8 = 1;
            if (bl2) {
                if (this.R == null) {
                    this.R = new Rect();
                    this.S = new Rect();
                }
                Rect rect = this.R;
                Rect rect2 = this.S;
                rect.set(0, n2, 0, 0);
                au.a((View)this.D, rect, rect2);
                n3 = rect2.top == 0 ? n2 : 0;
                if (((ViewGroup.MarginLayoutParams)actionBarContextView).topMargin != n3) {
                    ((ViewGroup.MarginLayoutParams)actionBarContextView).topMargin = n2;
                    if (this.F == null) {
                        this.F = new View(this.a);
                        this.F.setBackgroundColor(this.a.getResources().getColor(a.c.abc_input_method_navigation_guard));
                        this.D.addView(this.F, -1, new ViewGroup.LayoutParams(-1, n2));
                    } else {
                        rect = this.F.getLayoutParams();
                        if (rect.height != n2) {
                            rect.height = n2;
                            this.F.setLayoutParams((ViewGroup.LayoutParams)rect);
                        }
                    }
                    n4 = 1;
                } else {
                    n4 = 0;
                }
                if (this.F == null) {
                    n8 = 0;
                }
                n6 = n4;
                n3 = n8;
                n7 = n2;
                if (!this.o) {
                    n6 = n4;
                    n3 = n8;
                    n7 = n2;
                    if (n8 != 0) {
                        n7 = 0;
                        n6 = n4;
                        n3 = n8;
                    }
                }
            } else {
                if (((ViewGroup.MarginLayoutParams)actionBarContextView).topMargin != 0) {
                    ((ViewGroup.MarginLayoutParams)actionBarContextView).topMargin = 0;
                    n4 = 1;
                } else {
                    n4 = 0;
                }
                n3 = 0;
                n7 = n2;
                n6 = n4;
            }
            n4 = n3;
            n2 = n7;
            if (n6 != 0) {
                this.i.setLayoutParams((ViewGroup.LayoutParams)actionBarContextView);
                n4 = n3;
                n2 = n7;
            }
        } else {
            n4 = 0;
        }
        if (this.F != null) {
            actionBarContextView = this.F;
            n3 = n4 != 0 ? n5 : 8;
            actionBarContextView.setVisibility(n3);
        }
        return n2;
    }

    @Override
    public void h() {
        LayoutInflater layoutInflater = LayoutInflater.from((Context)this.a);
        if (layoutInflater.getFactory() == null) {
            androidx.core.h.f.a(layoutInflater, this);
            return;
        }
        if (!(layoutInflater.getFactory2() instanceof f)) {
            Log.i((String)"AppCompatDelegate", (String)"The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    int i(int n2) {
        if (n2 != -100) {
            if (n2 != 0) {
                return n2;
            }
            if (Build.VERSION.SDK_INT >= 23 && ((UiModeManager)this.a.getSystemService(UiModeManager.class)).getNightMode() == 0) {
                return -1;
            }
            this.z();
            return this.O.a();
        }
        return -1;
    }

    @Override
    public boolean i() {
        int n2 = this.y();
        int n3 = this.i(n2);
        boolean bl2 = n3 != -1 ? this.l(n3) : false;
        if (n2 == 0) {
            this.z();
            this.O.c();
        }
        this.N = true;
        return bl2;
    }

    final androidx.appcompat.app.a k() {
        return this.f;
    }

    final Window.Callback l() {
        return this.b.getCallback();
    }

    final Context m() {
        androidx.appcompat.app.a a2 = this.a();
        a2 = a2 != null ? a2.b() : null;
        androidx.appcompat.app.a a3 = a2;
        if (a2 == null) {
            a3 = this.a;
        }
        return a3;
    }

    final CharSequence n() {
        if (this.c instanceof Activity) {
            return ((Activity)this.c).getTitle();
        }
        return this.x;
    }

    final boolean o() {
        return this.C && this.D != null && t.y((View)this.D);
    }

    public final View onCreateView(View view, String string2, Context context, AttributeSet attributeSet) {
        return this.a(view, string2, context, attributeSet);
    }

    public View onCreateView(String string2, Context context, AttributeSet attributeSet) {
        return this.onCreateView(null, string2, context, attributeSet);
    }

    public boolean p() {
        return this.B;
    }

    void q() {
        if (this.l != null) {
            this.l.b();
        }
    }

    boolean r() {
        if (this.h != null) {
            this.h.c();
            return true;
        }
        androidx.appcompat.app.a a2 = this.a();
        return a2 != null && a2.f();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    void s() {
        if (this.y != null) {
            this.y.k();
        }
        if (this.j != null) {
            this.b.getDecorView().removeCallbacks(this.k);
            if (this.j.isShowing()) {
                try {
                    this.j.dismiss();
                }
                catch (IllegalArgumentException illegalArgumentException) {}
            }
            this.j = null;
        }
        this.q();
        f f2 = this.a(0, false);
        if (f2 != null && f2.j != null) {
            f2.j.close();
        }
    }

    private final class a
    implements o.a {
        a() {
        }

        @Override
        public void a(androidx.appcompat.view.menu.h h2, boolean bl2) {
            f.this.b(h2);
        }

        @Override
        public boolean a(androidx.appcompat.view.menu.h h2) {
            Window.Callback callback = f.this.l();
            if (callback != null) {
                callback.onMenuOpened(108, (Menu)h2);
            }
            return true;
        }
    }

    class b
    implements b.a {
        private b.a b;

        public b(b.a a2) {
            this.b = a2;
        }

        @Override
        public void a(androidx.appcompat.view.b b2) {
            this.b.a(b2);
            if (f.this.j != null) {
                f.this.b.getDecorView().removeCallbacks(f.this.k);
            }
            if (f.this.i != null) {
                f.this.q();
                f.this.l = t.m((View)f.this.i).a(0.0f);
                f.this.l.a(new androidx.core.h.z(){

                    @Override
                    public void b(View view) {
                        f.this.i.setVisibility(8);
                        if (f.this.j != null) {
                            f.this.j.dismiss();
                        } else if (f.this.i.getParent() instanceof View) {
                            t.q((View)f.this.i.getParent());
                        }
                        f.this.i.removeAllViews();
                        f.this.l.a((y)null);
                        f.this.l = null;
                    }
                });
            }
            if (f.this.e != null) {
                f.this.e.b(f.this.h);
            }
            f.this.h = null;
        }

        @Override
        public boolean a(androidx.appcompat.view.b b2, Menu menu) {
            return this.b.a(b2, menu);
        }

        @Override
        public boolean a(androidx.appcompat.view.b b2, MenuItem menuItem) {
            return this.b.a(b2, menuItem);
        }

        @Override
        public boolean b(androidx.appcompat.view.b b2, Menu menu) {
            return this.b.b(b2, menu);
        }

    }

    class c
    extends androidx.appcompat.view.i {
        c(Window.Callback callback) {
            super(callback);
        }

        final ActionMode a(ActionMode.Callback object) {
            androidx.appcompat.view.b b2 = f.this.a((b.a)(object = new f.a(f.this.a, (ActionMode.Callback)object)));
            if (b2 != null) {
                return ((f.a)object).b(b2);
            }
            return null;
        }

        @Override
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return f.this.a(keyEvent) || super.dispatchKeyEvent(keyEvent);
            {
            }
        }

        @Override
        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            return super.dispatchKeyShortcutEvent(keyEvent) || f.this.a(keyEvent.getKeyCode(), keyEvent);
            {
            }
        }

        @Override
        public void onContentChanged() {
        }

        @Override
        public boolean onCreatePanelMenu(int n2, Menu menu) {
            if (n2 == 0 && !(menu instanceof androidx.appcompat.view.menu.h)) {
                return false;
            }
            return super.onCreatePanelMenu(n2, menu);
        }

        @Override
        public boolean onMenuOpened(int n2, Menu menu) {
            super.onMenuOpened(n2, menu);
            f.this.e(n2);
            return true;
        }

        @Override
        public void onPanelClosed(int n2, Menu menu) {
            super.onPanelClosed(n2, menu);
            f.this.d(n2);
        }

        @Override
        public boolean onPreparePanel(int n2, View view, Menu menu) {
            androidx.appcompat.view.menu.h h2 = menu instanceof androidx.appcompat.view.menu.h ? (androidx.appcompat.view.menu.h)menu : null;
            if (n2 == 0 && h2 == null) {
                return false;
            }
            if (h2 != null) {
                h2.c(true);
            }
            boolean bl2 = super.onPreparePanel(n2, view, menu);
            if (h2 != null) {
                h2.c(false);
            }
            return bl2;
        }

        @Override
        public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int n2) {
            f f2 = f.this.a(0, true);
            Menu menu2 = menu;
            if (f2 != null) {
                menu2 = menu;
                if (f2.j != null) {
                    menu2 = f2.j;
                }
            }
            super.onProvideKeyboardShortcuts(list, menu2, n2);
        }

        @Override
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            if (Build.VERSION.SDK_INT >= 23) {
                return null;
            }
            if (f.this.p()) {
                return this.a(callback);
            }
            return super.onWindowStartingActionMode(callback);
        }

        @Override
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int n2) {
            if (f.this.p() && n2 == 0) {
                return this.a(callback);
            }
            return super.onWindowStartingActionMode(callback, n2);
        }
    }

    final class d {
        private k b;
        private boolean c;
        private BroadcastReceiver d;
        private IntentFilter e;

        d(k k2) {
            this.b = k2;
            this.c = k2.a();
        }

        int a() {
            this.c = this.b.a();
            if (this.c) {
                return 2;
            }
            return 1;
        }

        void b() {
            boolean bl2 = this.b.a();
            if (bl2 != this.c) {
                this.c = bl2;
                f.this.i();
            }
        }

        void c() {
            this.d();
            if (this.d == null) {
                this.d = new BroadcastReceiver(){

                    public void onReceive(Context context, Intent intent) {
                        d.this.b();
                    }
                };
            }
            if (this.e == null) {
                this.e = new IntentFilter();
                this.e.addAction("android.intent.action.TIME_SET");
                this.e.addAction("android.intent.action.TIMEZONE_CHANGED");
                this.e.addAction("android.intent.action.TIME_TICK");
            }
            f.this.a.registerReceiver(this.d, this.e);
        }

        void d() {
            if (this.d != null) {
                f.this.a.unregisterReceiver(this.d);
                this.d = null;
            }
        }

    }

    private class e
    extends ContentFrameLayout {
        public e(Context context) {
            super(context);
        }

        private boolean a(int n2, int n3) {
            return n2 < -5 || n3 < -5 || n2 > this.getWidth() + 5 || n3 > this.getHeight() + 5;
            {
            }
        }

        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return f.this.a(keyEvent) || super.dispatchKeyEvent(keyEvent);
            {
            }
        }

        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0 && this.a((int)motionEvent.getX(), (int)motionEvent.getY())) {
                f.this.f(0);
                return true;
            }
            return super.onInterceptTouchEvent(motionEvent);
        }

        public void setBackgroundResource(int n2) {
            this.setBackgroundDrawable(androidx.appcompat.a.a.a.b(this.getContext(), n2));
        }
    }

    protected static final class f {
        int a;
        int b;
        int c;
        int d;
        int e;
        int f;
        ViewGroup g;
        View h;
        View i;
        androidx.appcompat.view.menu.h j;
        androidx.appcompat.view.menu.f k;
        Context l;
        boolean m;
        boolean n;
        boolean o;
        public boolean p;
        boolean q;
        boolean r;
        Bundle s;

        f(int n2) {
            this.a = n2;
            this.q = false;
        }

        androidx.appcompat.view.menu.p a(o.a a2) {
            if (this.j == null) {
                return null;
            }
            if (this.k == null) {
                this.k = new androidx.appcompat.view.menu.f(this.l, a.g.abc_list_menu_item_layout);
                this.k.a(a2);
                this.j.a(this.k);
            }
            return this.k.a(this.g);
        }

        /*
         * Enabled aggressive block sorting
         */
        void a(Context object) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme theme = object.getResources().newTheme();
            theme.setTo(object.getTheme());
            theme.resolveAttribute(a.a.actionBarPopupTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                theme.applyStyle(typedValue.resourceId, true);
            }
            theme.resolveAttribute(a.a.panelMenuListTheme, typedValue, true);
            int n2 = typedValue.resourceId != 0 ? typedValue.resourceId : a.i.Theme_AppCompat_CompactMenu;
            theme.applyStyle(n2, true);
            androidx.appcompat.view.d d2 = new androidx.appcompat.view.d((Context)object, 0);
            d2.getTheme().setTo(theme);
            this.l = d2;
            TypedArray typedArray = d2.obtainStyledAttributes(a.j.AppCompatTheme);
            this.b = typedArray.getResourceId(a.j.AppCompatTheme_panelBackground, 0);
            this.f = typedArray.getResourceId(a.j.AppCompatTheme_android_windowAnimationStyle, 0);
            typedArray.recycle();
        }

        void a(androidx.appcompat.view.menu.h h2) {
            if (h2 == this.j) {
                return;
            }
            if (this.j != null) {
                this.j.b(this.k);
            }
            this.j = h2;
            if (h2 != null && this.k != null) {
                h2.a(this.k);
            }
        }

        public boolean a() {
            View view = this.h;
            boolean bl2 = false;
            if (view == null) {
                return false;
            }
            if (this.i != null) {
                return true;
            }
            if (this.k.a().getCount() > 0) {
                bl2 = true;
            }
            return bl2;
        }
    }

    private final class g
    implements o.a {
        g() {
        }

        @Override
        public void a(androidx.appcompat.view.menu.h object, boolean bl2) {
            androidx.appcompat.view.menu.h h2 = ((androidx.appcompat.view.menu.h)object).q();
            boolean bl3 = h2 != object;
            f f2 = f.this;
            if (bl3) {
                object = h2;
            }
            if ((object = f2.a((Menu)object)) != null) {
                if (bl3) {
                    f.this.a(((f)object).a, (f)object, h2);
                    f.this.a((f)object, true);
                    return;
                }
                f.this.a((f)object, bl2);
            }
        }

        @Override
        public boolean a(androidx.appcompat.view.menu.h h2) {
            Window.Callback callback;
            if (h2 == null && f.this.m && (callback = f.this.l()) != null && !f.this.r) {
                callback.onMenuOpened(108, (Menu)h2);
            }
            return true;
        }
    }

}

