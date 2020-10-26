/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Application
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentSender
 *  android.content.res.Configuration
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Message
 *  android.os.Parcelable
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.view.LayoutInflater
 *  android.view.Menu
 *  android.view.MenuInflater
 *  android.view.MenuItem
 *  android.view.View
 *  android.view.Window
 *  android.view.WindowManager
 *  android.view.WindowManager$LayoutParams
 */
package androidx.f.a;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.core.app.a;
import androidx.f.a.d;
import androidx.f.a.g;
import androidx.f.a.h;
import androidx.f.a.i;
import androidx.f.a.k;
import androidx.lifecycle.g;
import androidx.lifecycle.y;
import androidx.lifecycle.z;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

public class e
extends androidx.core.app.d
implements a.a,
a.c,
z {
    final Handler a = new Handler(){

        public void handleMessage(Message message) {
            if (message.what != 2) {
                super.handleMessage(message);
                return;
            }
            e.this.h();
            e.this.b.m();
        }
    };
    final g b = g.a(new a());
    boolean c;
    boolean d;
    boolean e = true;
    boolean f;
    boolean g;
    boolean h;
    int i;
    androidx.c.h<String> j;
    private y k;

    private void a() {
        while (e.a(this.k(), g.b.c)) {
        }
    }

    private static boolean a(i object, g.b b2) {
        object = ((i)object).e().iterator();
        boolean bl2 = false;
        while (object.hasNext()) {
            Object object2 = (d)object.next();
            if (object2 == null) continue;
            boolean bl3 = bl2;
            if (((d)object2).g().a().a(g.b.d)) {
                ((d)object2).ac.a(b2);
                bl3 = true;
            }
            object2 = ((d)object2).t();
            bl2 = bl3;
            if (object2 == null) continue;
            bl2 = bl3 | e.a((i)object2, b2);
        }
        return bl2;
    }

    private int b(d d2) {
        if (this.j.b() < 65534) {
            while (this.j.f(this.i) >= 0) {
                this.i = (this.i + 1) % 65534;
            }
            int n2 = this.i;
            this.j.b(n2, d2.p);
            this.i = (this.i + 1) % 65534;
            return n2;
        }
        throw new IllegalStateException("Too many pending Fragment activity results.");
    }

    static void b(int n2) {
        if ((n2 & -65536) == 0) {
            return;
        }
        throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
    }

    final View a(View view, String string2, Context context, AttributeSet attributeSet) {
        return this.b.a(view, string2, context, attributeSet);
    }

    @Override
    public final void a(int n2) {
        if (!this.f && n2 != -1) {
            e.b(n2);
        }
    }

    public void a(d d2) {
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public void a(d var1_1, Intent var2_3, int var3_4, Bundle var4_5) {
        this.h = true;
        if (var3_4 != -1) ** GOTO lbl7
        try {
            androidx.core.app.a.a(this, var2_3, -1, var4_5);
            this.h = false;
            return;
lbl7: // 1 sources:
            e.b(var3_4);
            androidx.core.app.a.a(this, var2_3, (this.b(var1_1) + 1 << 16) + (var3_4 & 65535), var4_5);
            this.h = false;
            return;
        }
        catch (Throwable var1_2) {}
        this.h = false;
        throw var1_2;
    }

    void a(d d2, String[] arrstring, int n2) {
        if (n2 == -1) {
            androidx.core.app.a.a(this, arrstring, n2);
            return;
        }
        e.b(n2);
        try {
            this.f = true;
            androidx.core.app.a.a(this, arrstring, (this.b(d2) + 1 << 16) + (n2 & 65535));
            return;
        }
        finally {
            this.f = false;
        }
    }

    protected boolean a(View view, Menu menu) {
        return super.onPreparePanel(0, view, menu);
    }

    @Deprecated
    public void b() {
        this.invalidateOptionsMenu();
    }

    public void dump(String string2, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] arrstring) {
        super.dump(string2, fileDescriptor, printWriter, arrstring);
        printWriter.print(string2);
        printWriter.print("Local FragmentActivity ");
        printWriter.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter.println(" State:");
        CharSequence charSequence = new StringBuilder();
        charSequence.append(string2);
        charSequence.append("  ");
        charSequence = charSequence.toString();
        printWriter.print((String)charSequence);
        printWriter.print("mCreated=");
        printWriter.print(this.c);
        printWriter.print(" mResumed=");
        printWriter.print(this.d);
        printWriter.print(" mStopped=");
        printWriter.print(this.e);
        if (this.getApplication() != null) {
            androidx.h.a.a.a(this).a((String)charSequence, fileDescriptor, printWriter, arrstring);
        }
        this.b.a().a(string2, fileDescriptor, printWriter, arrstring);
    }

    @Override
    public androidx.lifecycle.g g() {
        return super.g();
    }

    protected void h() {
        this.b.h();
    }

    @Override
    public y i() {
        if (this.getApplication() != null) {
            if (this.k == null) {
                b b2 = (b)this.getLastNonConfigurationInstance();
                if (b2 != null) {
                    this.k = b2.b;
                }
                if (this.k == null) {
                    this.k = new y();
                }
            }
            return this.k;
        }
        throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
    }

    public Object j() {
        return null;
    }

    public i k() {
        return this.b.a();
    }

    protected void onActivityResult(int n2, int n3, Intent object) {
        this.b.b();
        int n4 = n2 >> 16;
        if (n4 != 0) {
            String string2 = this.j.a(--n4);
            this.j.c(n4);
            if (string2 == null) {
                Log.w((String)"FragmentActivity", (String)"Activity result delivered for unknown Fragment.");
                return;
            }
            d d2 = this.b.a(string2);
            if (d2 == null) {
                object = new StringBuilder();
                ((StringBuilder)object).append("Activity result no fragment exists for who: ");
                ((StringBuilder)object).append(string2);
                Log.w((String)"FragmentActivity", (String)((StringBuilder)object).toString());
                return;
            }
            d2.a(n2 & 65535, n3, (Intent)object);
            return;
        }
        a.b b2 = androidx.core.app.a.a();
        if (b2 != null && b2.a(this, n2, n3, (Intent)object)) {
            return;
        }
        super.onActivityResult(n2, n3, (Intent)object);
    }

    public void onBackPressed() {
        i i2 = this.b.a();
        boolean bl2 = i2.f();
        if (bl2 && Build.VERSION.SDK_INT <= 25) {
            return;
        }
        if (bl2 || !i2.c()) {
            super.onBackPressed();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.b.b();
        this.b.a(configuration);
    }

    @Override
    protected void onCreate(Bundle arrstring) {
        g g2 = this.b;
        int[] arrn = null;
        g2.a((d)null);
        super.onCreate((Bundle)arrstring);
        b b2 = (b)this.getLastNonConfigurationInstance();
        if (b2 != null && b2.b != null && this.k == null) {
            this.k = b2.b;
        }
        if (arrstring != null) {
            g2 = arrstring.getParcelable("android:support:fragments");
            g g3 = this.b;
            if (b2 != null) {
                arrn = b2.c;
            }
            g3.a((Parcelable)g2, (k)arrn);
            if (arrstring.containsKey("android:support:next_request_index")) {
                this.i = arrstring.getInt("android:support:next_request_index");
                arrn = arrstring.getIntArray("android:support:request_indicies");
                arrstring = arrstring.getStringArray("android:support:request_fragment_who");
                if (arrn != null && arrstring != null && arrn.length == arrstring.length) {
                    this.j = new androidx.c.h(arrn.length);
                    for (int i2 = 0; i2 < arrn.length; ++i2) {
                        this.j.b(arrn[i2], arrstring[i2]);
                    }
                } else {
                    Log.w((String)"FragmentActivity", (String)"Invalid requestCode mapping in savedInstanceState.");
                }
            }
        }
        if (this.j == null) {
            this.j = new androidx.c.h();
            this.i = 0;
        }
        this.b.e();
    }

    public boolean onCreatePanelMenu(int n2, Menu menu) {
        if (n2 == 0) {
            return super.onCreatePanelMenu(n2, menu) | this.b.a(menu, this.getMenuInflater());
        }
        return super.onCreatePanelMenu(n2, menu);
    }

    public View onCreateView(View view, String string2, Context context, AttributeSet attributeSet) {
        View view2 = this.a(view, string2, context, attributeSet);
        if (view2 == null) {
            return super.onCreateView(view, string2, context, attributeSet);
        }
        return view2;
    }

    public View onCreateView(String string2, Context context, AttributeSet attributeSet) {
        View view = this.a(null, string2, context, attributeSet);
        if (view == null) {
            return super.onCreateView(string2, context, attributeSet);
        }
        return view;
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.k != null && !this.isChangingConfigurations()) {
            this.k.a();
        }
        this.b.k();
    }

    public void onLowMemory() {
        super.onLowMemory();
        this.b.l();
    }

    public boolean onMenuItemSelected(int n2, MenuItem menuItem) {
        if (super.onMenuItemSelected(n2, menuItem)) {
            return true;
        }
        if (n2 != 0) {
            if (n2 != 6) {
                return false;
            }
            return this.b.b(menuItem);
        }
        return this.b.a(menuItem);
    }

    public void onMultiWindowModeChanged(boolean bl2) {
        this.b.a(bl2);
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.b.b();
    }

    public void onPanelClosed(int n2, Menu menu) {
        if (n2 == 0) {
            this.b.b(menu);
        }
        super.onPanelClosed(n2, menu);
    }

    protected void onPause() {
        super.onPause();
        this.d = false;
        if (this.a.hasMessages(2)) {
            this.a.removeMessages(2);
            this.h();
        }
        this.b.i();
    }

    public void onPictureInPictureModeChanged(boolean bl2) {
        this.b.b(bl2);
    }

    protected void onPostResume() {
        super.onPostResume();
        this.a.removeMessages(2);
        this.h();
        this.b.m();
    }

    public boolean onPreparePanel(int n2, View view, Menu menu) {
        if (n2 == 0 && menu != null) {
            return this.a(view, menu) | this.b.a(menu);
        }
        return super.onPreparePanel(n2, view, menu);
    }

    @Override
    public void onRequestPermissionsResult(int n2, String[] object, int[] arrn) {
        this.b.b();
        int n3 = n2 >> 16 & 65535;
        if (n3 != 0) {
            String string2 = this.j.a(--n3);
            this.j.c(n3);
            if (string2 == null) {
                Log.w((String)"FragmentActivity", (String)"Activity result delivered for unknown Fragment.");
                return;
            }
            d d2 = this.b.a(string2);
            if (d2 == null) {
                object = new StringBuilder();
                ((StringBuilder)object).append("Activity result no fragment exists for who: ");
                ((StringBuilder)object).append(string2);
                Log.w((String)"FragmentActivity", (String)((StringBuilder)object).toString());
                return;
            }
            d2.a(n2 & 65535, (String[])object, arrn);
        }
    }

    protected void onResume() {
        super.onResume();
        this.a.sendEmptyMessage(2);
        this.d = true;
        this.b.m();
    }

    public final Object onRetainNonConfigurationInstance() {
        Object object = this.j();
        k k2 = this.b.d();
        if (k2 == null && this.k == null && object == null) {
            return null;
        }
        b b2 = new b();
        b2.a = object;
        b2.b = this.k;
        b2.c = k2;
        return b2;
    }

    @Override
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.a();
        int[] arrn = this.b.c();
        if (arrn != null) {
            bundle.putParcelable("android:support:fragments", (Parcelable)arrn);
        }
        if (this.j.b() > 0) {
            bundle.putInt("android:support:next_request_index", this.i);
            arrn = new int[this.j.b()];
            String[] arrstring = new String[this.j.b()];
            for (int i2 = 0; i2 < this.j.b(); ++i2) {
                arrn[i2] = this.j.d(i2);
                arrstring[i2] = this.j.e(i2);
            }
            bundle.putIntArray("android:support:request_indicies", arrn);
            bundle.putStringArray("android:support:request_fragment_who", arrstring);
        }
    }

    protected void onStart() {
        super.onStart();
        this.e = false;
        if (!this.c) {
            this.c = true;
            this.b.f();
        }
        this.b.b();
        this.b.m();
        this.b.g();
    }

    public void onStateNotSaved() {
        this.b.b();
    }

    protected void onStop() {
        super.onStop();
        this.e = true;
        this.a();
        this.b.j();
    }

    public void startActivityForResult(Intent intent, int n2) {
        if (!this.h && n2 != -1) {
            e.b(n2);
        }
        super.startActivityForResult(intent, n2);
    }

    public void startActivityForResult(Intent intent, int n2, Bundle bundle) {
        if (!this.h && n2 != -1) {
            e.b(n2);
        }
        super.startActivityForResult(intent, n2, bundle);
    }

    public void startIntentSenderForResult(IntentSender intentSender, int n2, Intent intent, int n3, int n4, int n5) {
        if (!this.g && n2 != -1) {
            e.b(n2);
        }
        super.startIntentSenderForResult(intentSender, n2, intent, n3, n4, n5);
    }

    public void startIntentSenderForResult(IntentSender intentSender, int n2, Intent intent, int n3, int n4, int n5, Bundle bundle) {
        if (!this.g && n2 != -1) {
            e.b(n2);
        }
        super.startIntentSenderForResult(intentSender, n2, intent, n3, n4, n5, bundle);
    }

    class a
    extends h<e> {
        public a() {
            super(e.this);
        }

        @Override
        public View a(int n2) {
            return e.this.findViewById(n2);
        }

        @Override
        public void a(d d2, Intent intent, int n2, Bundle bundle) {
            e.this.a(d2, intent, n2, bundle);
        }

        @Override
        public void a(d d2, String[] arrstring, int n2) {
            e.this.a(d2, arrstring, n2);
        }

        @Override
        public void a(String string2, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] arrstring) {
            e.this.dump(string2, fileDescriptor, printWriter, arrstring);
        }

        @Override
        public boolean a() {
            Window window = e.this.getWindow();
            return window != null && window.peekDecorView() != null;
        }

        @Override
        public boolean a(d d2) {
            return e.this.isFinishing() ^ true;
        }

        @Override
        public boolean a(String string2) {
            return androidx.core.app.a.a(e.this, string2);
        }

        @Override
        public LayoutInflater b() {
            return e.this.getLayoutInflater().cloneInContext((Context)e.this);
        }

        @Override
        public void b(d d2) {
            e.this.a(d2);
        }

        @Override
        public void c() {
            e.this.b();
        }

        @Override
        public boolean d() {
            return e.this.getWindow() != null;
        }

        @Override
        public int e() {
            Window window = e.this.getWindow();
            if (window == null) {
                return 0;
            }
            return window.getAttributes().windowAnimations;
        }
    }

    static final class b {
        Object a;
        y b;
        k c;

        b() {
        }
    }

}

