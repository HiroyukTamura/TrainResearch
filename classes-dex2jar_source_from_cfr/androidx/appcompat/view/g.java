/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.ContextWrapper
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.content.res.TypedArray
 *  android.content.res.XmlResourceParser
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.util.Xml
 *  android.view.InflateException
 *  android.view.Menu
 *  android.view.MenuInflater
 *  android.view.MenuItem
 *  android.view.MenuItem$OnMenuItemClickListener
 *  android.view.SubMenu
 *  android.view.View
 *  org.xmlpull.v1.XmlPullParser
 *  org.xmlpull.v1.XmlPullParserException
 */
package androidx.appcompat.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.a;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.k;
import androidx.core.h.h;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class g
extends MenuInflater {
    static final Class<?>[] a = new Class[]{Context.class};
    static final Class<?>[] b = a;
    final Object[] c;
    final Object[] d;
    Context e;
    private Object f;

    public g(Context context) {
        super(context);
        this.e = context;
        this.c = new Object[]{context};
        this.d = this.c;
    }

    private Object a(Object object) {
        if (object instanceof Activity) {
            return object;
        }
        Object object2 = object;
        if (object instanceof ContextWrapper) {
            object2 = this.a((Object)((ContextWrapper)object).getBaseContext());
        }
        return object2;
    }

    private void a(XmlPullParser object, AttributeSet attributeSet, Menu object2) {
        int n2;
        b b2;
        int n3;
        block17 : {
            b2 = new b((Menu)object2);
            n2 = object.getEventType();
            do {
                if (n2 == 2) {
                    object2 = object.getName();
                    if (((String)object2).equals("menu")) {
                        n2 = object.next();
                        break block17;
                    }
                    object = new StringBuilder();
                    ((StringBuilder)object).append("Expecting menu, got ");
                    ((StringBuilder)object).append((String)object2);
                    throw new RuntimeException(((StringBuilder)object).toString());
                }
                n2 = n3 = object.next();
            } while (n3 != 1);
            n2 = n3;
        }
        Object object3 = null;
        n3 = 0;
        int n4 = 0;
        int n5 = n2;
        while (n3 == 0) {
            int n6;
            switch (n5) {
                default: {
                    n2 = n4;
                    object2 = object3;
                    n6 = n3;
                    break;
                }
                case 3: {
                    String string2 = object.getName();
                    if (n4 != 0 && string2.equals(object3)) {
                        object2 = null;
                        n2 = 0;
                        n6 = n3;
                        break;
                    }
                    if (string2.equals("group")) {
                        b2.a();
                        n2 = n4;
                        object2 = object3;
                        n6 = n3;
                        break;
                    }
                    if (string2.equals("item")) {
                        n2 = n4;
                        object2 = object3;
                        n6 = n3;
                        if (b2.d()) break;
                        if (b2.a != null && b2.a.c()) {
                            b2.c();
                            n2 = n4;
                            object2 = object3;
                            n6 = n3;
                            break;
                        }
                        b2.b();
                        n2 = n4;
                        object2 = object3;
                        n6 = n3;
                        break;
                    }
                    n2 = n4;
                    object2 = object3;
                    n6 = n3;
                    if (!string2.equals("menu")) break;
                    n6 = 1;
                    n2 = n4;
                    object2 = object3;
                    break;
                }
                case 2: {
                    if (n4 != 0) {
                        n2 = n4;
                        object2 = object3;
                        n6 = n3;
                        break;
                    }
                    object2 = object.getName();
                    if (((String)object2).equals("group")) {
                        b2.a(attributeSet);
                        n2 = n4;
                        object2 = object3;
                        n6 = n3;
                        break;
                    }
                    if (((String)object2).equals("item")) {
                        b2.b(attributeSet);
                        n2 = n4;
                        object2 = object3;
                        n6 = n3;
                        break;
                    }
                    if (((String)object2).equals("menu")) {
                        this.a((XmlPullParser)object, attributeSet, (Menu)b2.c());
                        n2 = n4;
                        object2 = object3;
                        n6 = n3;
                        break;
                    }
                    n2 = 1;
                    n6 = n3;
                    break;
                }
                case 1: {
                    throw new RuntimeException("Unexpected end of document");
                }
            }
            n5 = object.next();
            n4 = n2;
            object3 = object2;
            n3 = n6;
        }
    }

    Object a() {
        if (this.f == null) {
            this.f = this.a((Object)this.e);
        }
        return this.f;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public void inflate(int n2, Menu menu) {
        void var2_9;
        XmlResourceParser xmlResourceParser2;
        XmlResourceParser xmlResourceParser;
        void var2_8;
        block10 : {
            if (!(menu instanceof androidx.core.b.a.a)) {
                super.inflate(n2, menu);
                return;
            }
            XmlResourceParser xmlResourceParser3 = null;
            xmlResourceParser2 = null;
            xmlResourceParser = null;
            XmlResourceParser xmlResourceParser4 = this.e.getResources().getLayout(n2);
            try {
                this.a((XmlPullParser)xmlResourceParser4, Xml.asAttributeSet((XmlPullParser)xmlResourceParser4), menu);
                if (xmlResourceParser4 == null) return;
            }
            catch (Throwable throwable) {
                xmlResourceParser = xmlResourceParser4;
                break block10;
            }
            catch (IOException iOException) {
                xmlResourceParser = xmlResourceParser4;
                throw new InflateException("Error inflating menu XML", (Throwable)menu);
            }
            catch (XmlPullParserException xmlPullParserException) {
                xmlResourceParser = xmlResourceParser4;
                throw new InflateException("Error inflating menu XML", (Throwable)var2_8);
            }
            xmlResourceParser4.close();
            return;
            catch (Throwable throwable) {
                break block10;
            }
            catch (IOException iOException) {
                xmlResourceParser = xmlResourceParser3;
            }
            {
                throw new InflateException("Error inflating menu XML", (Throwable)menu);
            }
        }
        if (xmlResourceParser == null) throw var2_9;
        xmlResourceParser.close();
        throw var2_9;
        catch (XmlPullParserException xmlPullParserException) {
            xmlResourceParser = xmlResourceParser2;
            throw new InflateException("Error inflating menu XML", (Throwable)var2_8);
        }
    }

    private static class a
    implements MenuItem.OnMenuItemClickListener {
        private static final Class<?>[] a = new Class[]{MenuItem.class};
        private Object b;
        private Method c;

        public a(Object object, String string2) {
            this.b = object;
            Class<?> class_ = object.getClass();
            try {
                this.c = class_.getMethod(string2, a);
                return;
            }
            catch (Exception exception) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Couldn't resolve menu item onClick handler ");
                stringBuilder.append(string2);
                stringBuilder.append(" in class ");
                stringBuilder.append(class_.getName());
                string2 = new InflateException(stringBuilder.toString());
                string2.initCause((Throwable)exception);
                throw string2;
            }
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.c.getReturnType() == Boolean.TYPE) {
                    return (Boolean)this.c.invoke(this.b, new Object[]{menuItem});
                }
                this.c.invoke(this.b, new Object[]{menuItem});
                return true;
            }
            catch (Exception exception) {
                throw new RuntimeException(exception);
            }
        }
    }

    private class b {
        private String A;
        private String B;
        private CharSequence C;
        private CharSequence D;
        private ColorStateList E = null;
        private PorterDuff.Mode F = null;
        androidx.core.h.b a;
        private Menu c;
        private int d;
        private int e;
        private int f;
        private int g;
        private boolean h;
        private boolean i;
        private boolean j;
        private int k;
        private int l;
        private CharSequence m;
        private CharSequence n;
        private int o;
        private char p;
        private int q;
        private char r;
        private int s;
        private int t;
        private boolean u;
        private boolean v;
        private boolean w;
        private int x;
        private int y;
        private String z;

        public b(Menu menu) {
            this.c = menu;
            this.a();
        }

        private char a(String string2) {
            if (string2 == null) {
                return '\u0000';
            }
            return string2.charAt(0);
        }

        private <T> T a(String string2, Class<?>[] object, Object[] object2) {
            try {
                object = g.this.e.getClassLoader().loadClass(string2).getConstructor((Class<?>)object);
                object.setAccessible(true);
                object = object.newInstance((Object[])object2);
            }
            catch (Exception exception) {
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("Cannot instantiate class: ");
                ((StringBuilder)object2).append(string2);
                Log.w((String)"SupportMenuInflater", (String)((StringBuilder)object2).toString(), (Throwable)exception);
                return null;
            }
            return (T)object;
        }

        private void a(MenuItem menuItem) {
            MenuItem menuItem2 = menuItem.setChecked(this.u).setVisible(this.v).setEnabled(this.w);
            int n2 = this.t;
            boolean bl2 = false;
            boolean bl3 = n2 >= 1;
            menuItem2.setCheckable(bl3).setTitleCondensed(this.n).setIcon(this.o);
            if (this.x >= 0) {
                menuItem.setShowAsAction(this.x);
            }
            if (this.B != null) {
                if (!g.this.e.isRestricted()) {
                    menuItem.setOnMenuItemClickListener((MenuItem.OnMenuItemClickListener)new a(g.this.a(), this.B));
                } else {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
            }
            if (bl3 = menuItem instanceof j) {
                menuItem2 = (j)menuItem;
            }
            if (this.t >= 2) {
                if (bl3) {
                    ((j)menuItem).a(true);
                } else if (menuItem instanceof k) {
                    ((k)menuItem).a(true);
                }
            }
            if (this.z != null) {
                menuItem.setActionView((View)this.a(this.z, g.a, g.this.c));
                bl2 = true;
            }
            if (this.y > 0) {
                if (!bl2) {
                    menuItem.setActionView(this.y);
                } else {
                    Log.w((String)"SupportMenuInflater", (String)"Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                }
            }
            if (this.a != null) {
                h.a(menuItem, this.a);
            }
            h.a(menuItem, this.C);
            h.b(menuItem, this.D);
            h.b(menuItem, this.p, this.q);
            h.a(menuItem, this.r, this.s);
            if (this.F != null) {
                h.a(menuItem, this.F);
            }
            if (this.E != null) {
                h.a(menuItem, this.E);
            }
        }

        public void a() {
            this.d = 0;
            this.e = 0;
            this.f = 0;
            this.g = 0;
            this.h = true;
            this.i = true;
        }

        public void a(AttributeSet attributeSet) {
            attributeSet = g.this.e.obtainStyledAttributes(attributeSet, a.j.MenuGroup);
            this.d = attributeSet.getResourceId(a.j.MenuGroup_android_id, 0);
            this.e = attributeSet.getInt(a.j.MenuGroup_android_menuCategory, 0);
            this.f = attributeSet.getInt(a.j.MenuGroup_android_orderInCategory, 0);
            this.g = attributeSet.getInt(a.j.MenuGroup_android_checkableBehavior, 0);
            this.h = attributeSet.getBoolean(a.j.MenuGroup_android_visible, true);
            this.i = attributeSet.getBoolean(a.j.MenuGroup_android_enabled, true);
            attributeSet.recycle();
        }

        public void b() {
            this.j = true;
            this.a(this.c.add(this.d, this.k, this.l, this.m));
        }

        public void b(AttributeSet attributeSet) {
            RuntimeException runtimeException;
            super("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
            throw runtimeException;
        }

        public SubMenu c() {
            this.j = true;
            SubMenu subMenu = this.c.addSubMenu(this.d, this.k, this.l, this.m);
            this.a(subMenu.getItem());
            return subMenu;
        }

        public boolean d() {
            return this.j;
        }
    }

}

