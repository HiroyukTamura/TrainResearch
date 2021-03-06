/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.ActivityInfo
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.ResolveInfo
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.graphics.drawable.Drawable
 *  android.os.Bundle
 *  android.util.SparseArray
 *  android.view.ContextMenu
 *  android.view.ContextMenu$ContextMenuInfo
 *  android.view.KeyCharacterMap
 *  android.view.KeyCharacterMap$KeyData
 *  android.view.KeyEvent
 *  android.view.MenuItem
 *  android.view.SubMenu
 *  android.view.View
 *  android.view.ViewConfiguration
 */
package androidx.appcompat.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.o;
import androidx.appcompat.view.menu.u;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class h
implements androidx.core.b.a.a {
    private static final int[] d = new int[]{1, 4, 5, 3, 2, 0};
    private boolean A;
    CharSequence a;
    Drawable b;
    View c;
    private final Context e;
    private final Resources f;
    private boolean g;
    private boolean h;
    private a i;
    private ArrayList<j> j;
    private ArrayList<j> k;
    private boolean l;
    private ArrayList<j> m;
    private ArrayList<j> n;
    private boolean o;
    private int p = 0;
    private ContextMenu.ContextMenuInfo q;
    private boolean r = false;
    private boolean s = false;
    private boolean t = false;
    private boolean u = false;
    private boolean v = false;
    private ArrayList<j> w = new ArrayList();
    private CopyOnWriteArrayList<WeakReference<o>> x = new CopyOnWriteArrayList();
    private j y;
    private boolean z = false;

    public h(Context context) {
        this.e = context;
        this.f = context.getResources();
        this.j = new ArrayList();
        this.k = new ArrayList();
        this.l = true;
        this.m = new ArrayList();
        this.n = new ArrayList();
        this.o = true;
        this.e(true);
    }

    private static int a(ArrayList<j> arrayList, int n2) {
        for (int i2 = arrayList.size() - 1; i2 >= 0; --i2) {
            if (arrayList.get(i2).c() > n2) continue;
            return i2 + 1;
        }
        return 0;
    }

    private j a(int n2, int n3, int n4, int n5, CharSequence charSequence, int n6) {
        return new j(this, n2, n3, n4, n5, charSequence, n6);
    }

    private void a(int n2, CharSequence charSequence, int n3, Drawable drawable2, View view) {
        Resources resources = this.e();
        if (view != null) {
            this.c = view;
            this.a = null;
            this.b = null;
        } else {
            if (n2 > 0) {
                this.a = resources.getText(n2);
            } else if (charSequence != null) {
                this.a = charSequence;
            }
            if (n3 > 0) {
                this.b = androidx.core.a.a.a(this.f(), n3);
            } else if (drawable2 != null) {
                this.b = drawable2;
            }
            this.c = null;
        }
        this.b(false);
    }

    private void a(int n2, boolean bl2) {
        if (n2 >= 0) {
            if (n2 >= this.j.size()) {
                return;
            }
            this.j.remove(n2);
            if (bl2) {
                this.b(true);
            }
        }
    }

    private boolean a(u u2, o object) {
        boolean bl2 = this.x.isEmpty();
        boolean bl3 = false;
        if (bl2) {
            return false;
        }
        if (object != null) {
            bl3 = object.a(u2);
        }
        for (WeakReference<o> weakReference : this.x) {
            o o2 = (o)weakReference.get();
            if (o2 == null) {
                this.x.remove(weakReference);
                continue;
            }
            if (bl3) continue;
            bl3 = o2.a(u2);
        }
        return bl3;
    }

    private void d(boolean bl2) {
        if (this.x.isEmpty()) {
            return;
        }
        this.h();
        for (WeakReference<o> weakReference : this.x) {
            o o2 = (o)weakReference.get();
            if (o2 == null) {
                this.x.remove(weakReference);
                continue;
            }
            o2.a(bl2);
        }
        this.i();
    }

    private void e(boolean bl2) {
        boolean bl3 = true;
        bl2 = bl2 && this.f.getConfiguration().keyboard != 1 && androidx.core.h.u.c(ViewConfiguration.get((Context)this.e), this.e) ? bl3 : false;
        this.h = bl2;
    }

    private static int f(int n2) {
        int n3 = (-65536 & n2) >> 16;
        if (n3 >= 0 && n3 < d.length) {
            return n2 & 65535 | d[n3] << 16;
        }
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    public int a(int n2, int n3) {
        int n4 = this.size();
        int n5 = n3;
        if (n3 < 0) {
            n5 = 0;
        }
        while (n5 < n4) {
            if (this.j.get(n5).getGroupId() == n2) {
                return n5;
            }
            ++n5;
        }
        return -1;
    }

    protected MenuItem a(int n2, int n3, int n4, CharSequence object) {
        int n5 = h.f(n4);
        object = this.a(n2, n3, n4, n5, (CharSequence)object, this.p);
        if (this.q != null) {
            ((j)object).a(this.q);
        }
        this.j.add(h.a(this.j, n5), (j)object);
        this.b(true);
        return object;
    }

    public h a(int n2) {
        this.p = n2;
        return this;
    }

    protected h a(Drawable drawable2) {
        this.a(0, null, 0, drawable2, null);
        return this;
    }

    protected h a(View view) {
        this.a(0, null, 0, null, view);
        return this;
    }

    protected h a(CharSequence charSequence) {
        this.a(0, charSequence, 0, null, null);
        return this;
    }

    j a(int n2, KeyEvent object) {
        ArrayList<j> arrayList = this.w;
        arrayList.clear();
        this.a(arrayList, n2, (KeyEvent)object);
        if (arrayList.isEmpty()) {
            return null;
        }
        int n3 = object.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        object.getKeyData(keyData);
        int n4 = arrayList.size();
        if (n4 == 1) {
            return arrayList.get(0);
        }
        boolean bl2 = this.c();
        for (int i2 = 0; i2 < n4; ++i2) {
            object = arrayList.get(i2);
            char c2 = bl2 ? ((j)object).getAlphabeticShortcut() : ((j)object).getNumericShortcut();
            if (!(c2 == keyData.meta[0] && (n3 & 2) == 0 || c2 == keyData.meta[2] && (n3 & 2) != 0) && (!bl2 || c2 != '\b' || n2 != 67)) continue;
            return object;
        }
        return null;
    }

    protected String a() {
        return "android:menu:actionviewstates";
    }

    public void a(Bundle bundle) {
        int n2 = this.size();
        SparseArray sparseArray = null;
        for (int i2 = 0; i2 < n2; ++i2) {
            MenuItem menuItem = this.getItem(i2);
            View view = menuItem.getActionView();
            SparseArray sparseArray2 = sparseArray;
            if (view != null) {
                sparseArray2 = sparseArray;
                if (view.getId() != -1) {
                    SparseArray sparseArray3 = sparseArray;
                    if (sparseArray == null) {
                        sparseArray3 = new SparseArray();
                    }
                    view.saveHierarchyState(sparseArray3);
                    sparseArray2 = sparseArray3;
                    if (menuItem.isActionViewExpanded()) {
                        bundle.putInt("android:menu:expandedactionview", menuItem.getItemId());
                        sparseArray2 = sparseArray3;
                    }
                }
            }
            if (menuItem.hasSubMenu()) {
                ((u)menuItem.getSubMenu()).a(bundle);
            }
            sparseArray = sparseArray2;
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(this.a(), sparseArray);
        }
    }

    void a(MenuItem menuItem) {
        int n2 = menuItem.getGroupId();
        int n3 = this.j.size();
        this.h();
        for (int i2 = 0; i2 < n3; ++i2) {
            j j2 = this.j.get(i2);
            if (j2.getGroupId() != n2 || !j2.g() || !j2.isCheckable()) continue;
            boolean bl2 = j2 == menuItem;
            j2.b(bl2);
        }
        this.i();
    }

    public void a(a a2) {
        this.i = a2;
    }

    void a(j j2) {
        this.l = true;
        this.b(true);
    }

    public void a(o o2) {
        this.a(o2, this.e);
    }

    public void a(o o2, Context context) {
        this.x.add(new WeakReference<o>(o2));
        o2.a(context, this);
        this.o = true;
    }

    void a(List<j> list, int n2, KeyEvent keyEvent) {
        boolean bl2 = this.c();
        int n3 = keyEvent.getModifiers();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (!keyEvent.getKeyData(keyData) && n2 != 67) {
            return;
        }
        int n4 = this.j.size();
        for (int i2 = 0; i2 < n4; ++i2) {
            j j2 = this.j.get(i2);
            if (j2.hasSubMenu()) {
                ((h)j2.getSubMenu()).a(list, n2, keyEvent);
            }
            char c2 = bl2 ? j2.getAlphabeticShortcut() : j2.getNumericShortcut();
            int n5 = bl2 ? j2.getAlphabeticModifiers() : j2.getNumericModifiers();
            if ((n5 = (n3 & 69647) == (n5 & 69647) ? 1 : 0) == 0 || c2 == '\u0000' || c2 != keyData.meta[0] && c2 != keyData.meta[2] && (!bl2 || c2 != '\b' || n2 != 67) || !j2.isEnabled()) continue;
            list.add(j2);
        }
    }

    public final void a(boolean bl2) {
        if (this.v) {
            return;
        }
        this.v = true;
        for (WeakReference<o> weakReference : this.x) {
            o o2 = (o)weakReference.get();
            if (o2 == null) {
                this.x.remove(weakReference);
                continue;
            }
            o2.a(this, bl2);
        }
        this.v = false;
    }

    public boolean a(MenuItem menuItem, int n2) {
        return this.a(menuItem, null, n2);
    }

    /*
     * Enabled aggressive block sorting
     */
    public boolean a(MenuItem object, o o2, int n2) {
        boolean bl2;
        block9 : {
            block10 : {
                Object object2;
                boolean bl3;
                boolean bl4;
                block11 : {
                    block8 : {
                        object2 = (j)object;
                        if (object2 == null) {
                            return false;
                        }
                        if (!((j)object2).isEnabled()) {
                            return false;
                        }
                        bl3 = ((j)object2).b();
                        object = ((j)object2).a();
                        bl4 = object != null && ((androidx.core.h.b)object).c();
                        if (!((j)object2).n()) break block8;
                        bl2 = bl3 |= ((j)object2).expandActionView();
                        if (!bl3) break block9;
                        bl2 = bl3;
                        break block10;
                    }
                    if (((j)object2).hasSubMenu() || bl4) break block11;
                    bl2 = bl3;
                    if ((n2 & 1) != 0) break block9;
                    bl2 = bl3;
                    break block10;
                }
                if ((n2 & 4) == 0) {
                    this.a(false);
                }
                if (!((j)object2).hasSubMenu()) {
                    ((j)object2).a(new u(this.f(), this, (j)object2));
                }
                object2 = (u)((j)object2).getSubMenu();
                if (bl4) {
                    ((androidx.core.h.b)object).a((SubMenu)object2);
                }
                bl2 = bl3 |= this.a((u)object2, o2);
                if (bl3) break block9;
                bl2 = bl3;
            }
            this.a(true);
            return bl2;
        }
        return bl2;
    }

    boolean a(h h2, MenuItem menuItem) {
        return this.i != null && this.i.a(h2, menuItem);
    }

    public MenuItem add(int n2) {
        return this.a(0, 0, 0, this.f.getString(n2));
    }

    public MenuItem add(int n2, int n3, int n4, int n5) {
        return this.a(n2, n3, n4, this.f.getString(n5));
    }

    public MenuItem add(int n2, int n3, int n4, CharSequence charSequence) {
        return this.a(n2, n3, n4, charSequence);
    }

    public MenuItem add(CharSequence charSequence) {
        return this.a(0, 0, 0, charSequence);
    }

    public int addIntentOptions(int n2, int n3, int n4, ComponentName componentName, Intent[] arrintent, Intent intent, int n5, MenuItem[] arrmenuItem) {
        PackageManager packageManager = this.e.getPackageManager();
        int n6 = 0;
        List list = packageManager.queryIntentActivityOptions(componentName, arrintent, intent, 0);
        int n7 = list != null ? list.size() : 0;
        int n8 = n6;
        if ((n5 & 1) == 0) {
            this.removeGroup(n2);
            n8 = n6;
        }
        while (n8 < n7) {
            ResolveInfo resolveInfo = (ResolveInfo)list.get(n8);
            componentName = resolveInfo.specificIndex < 0 ? intent : arrintent[resolveInfo.specificIndex];
            componentName = new Intent((Intent)componentName);
            componentName.setComponent(new ComponentName(resolveInfo.activityInfo.applicationInfo.packageName, resolveInfo.activityInfo.name));
            componentName = this.add(n2, n3, n4, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent((Intent)componentName);
            if (arrmenuItem != null && resolveInfo.specificIndex >= 0) {
                arrmenuItem[resolveInfo.specificIndex] = componentName;
            }
            ++n8;
        }
        return n7;
    }

    public SubMenu addSubMenu(int n2) {
        return this.addSubMenu(0, 0, 0, this.f.getString(n2));
    }

    public SubMenu addSubMenu(int n2, int n3, int n4, int n5) {
        return this.addSubMenu(n2, n3, n4, this.f.getString(n5));
    }

    public SubMenu addSubMenu(int n2, int n3, int n4, CharSequence object) {
        object = (j)this.a(n2, n3, n4, (CharSequence)object);
        u u2 = new u(this.e, this, (j)object);
        ((j)object).a(u2);
        return u2;
    }

    public SubMenu addSubMenu(CharSequence charSequence) {
        return this.addSubMenu(0, 0, 0, charSequence);
    }

    public int b(int n2) {
        int n3 = this.size();
        for (int i2 = 0; i2 < n3; ++i2) {
            if (this.j.get(i2).getItemId() != n2) continue;
            return i2;
        }
        return -1;
    }

    public void b(Bundle bundle) {
        int n2;
        if (bundle == null) {
            return;
        }
        SparseArray sparseArray = bundle.getSparseParcelableArray(this.a());
        int n3 = this.size();
        for (n2 = 0; n2 < n3; ++n2) {
            MenuItem menuItem = this.getItem(n2);
            View view = menuItem.getActionView();
            if (view != null && view.getId() != -1) {
                view.restoreHierarchyState(sparseArray);
            }
            if (!menuItem.hasSubMenu()) continue;
            ((u)menuItem.getSubMenu()).b(bundle);
        }
        n2 = bundle.getInt("android:menu:expandedactionview");
        if (n2 > 0 && (bundle = this.findItem(n2)) != null) {
            bundle.expandActionView();
        }
    }

    void b(j j2) {
        this.o = true;
        this.b(true);
    }

    public void b(o o2) {
        for (WeakReference<o> weakReference : this.x) {
            o o3 = (o)weakReference.get();
            if (o3 != null && o3 != o2) continue;
            this.x.remove(weakReference);
        }
    }

    public void b(boolean bl2) {
        if (!this.r) {
            if (bl2) {
                this.l = true;
                this.o = true;
            }
            this.d(bl2);
            return;
        }
        this.s = true;
        if (bl2) {
            this.t = true;
        }
    }

    public boolean b() {
        return this.z;
    }

    public int c(int n2) {
        return this.a(n2, 0);
    }

    public void c(boolean bl2) {
        this.A = bl2;
    }

    boolean c() {
        return this.g;
    }

    public boolean c(j j2) {
        boolean bl2 = this.x.isEmpty();
        boolean bl3 = false;
        if (bl2) {
            return false;
        }
        this.h();
        Iterator<WeakReference<o>> iterator = this.x.iterator();
        do {
            bl2 = bl3;
            if (!iterator.hasNext()) break;
            WeakReference<o> weakReference = iterator.next();
            o o2 = (o)weakReference.get();
            if (o2 == null) {
                this.x.remove(weakReference);
                continue;
            }
            bl3 = bl2 = o2.a(this, j2);
            if (bl2) break;
        } while (true);
        this.i();
        if (bl2) {
            this.y = j2;
        }
        return bl2;
    }

    public void clear() {
        if (this.y != null) {
            this.d(this.y);
        }
        this.j.clear();
        this.b(true);
    }

    public void clearHeader() {
        this.b = null;
        this.a = null;
        this.c = null;
        this.b(false);
    }

    public void close() {
        this.a(true);
    }

    protected h d(int n2) {
        this.a(n2, null, 0, null, null);
        return this;
    }

    public boolean d() {
        return this.h;
    }

    public boolean d(j j2) {
        boolean bl2 = this.x.isEmpty();
        boolean bl3 = false;
        boolean bl4 = false;
        if (!bl2) {
            if (this.y != j2) {
                return false;
            }
            this.h();
            Iterator<WeakReference<o>> iterator = this.x.iterator();
            bl3 = bl4;
            do {
                bl4 = bl3;
                if (!iterator.hasNext()) break;
                WeakReference<o> weakReference = iterator.next();
                o o2 = (o)weakReference.get();
                if (o2 == null) {
                    this.x.remove(weakReference);
                    continue;
                }
                bl3 = bl4 = o2.b(this, j2);
                if (bl4) break;
            } while (true);
            this.i();
            bl3 = bl4;
            if (bl4) {
                this.y = null;
                bl3 = bl4;
            }
        }
        return bl3;
    }

    Resources e() {
        return this.f;
    }

    protected h e(int n2) {
        this.a(0, null, n2, null, null);
        return this;
    }

    public Context f() {
        return this.e;
    }

    public MenuItem findItem(int n2) {
        int n3 = this.size();
        for (int i2 = 0; i2 < n3; ++i2) {
            j j2 = this.j.get(i2);
            if (j2.getItemId() == n2) {
                return j2;
            }
            if (!j2.hasSubMenu() || (j2 = j2.getSubMenu().findItem(n2)) == null) continue;
            return j2;
        }
        return null;
    }

    public void g() {
        if (this.i != null) {
            this.i.a(this);
        }
    }

    public MenuItem getItem(int n2) {
        return this.j.get(n2);
    }

    public void h() {
        if (!this.r) {
            this.r = true;
            this.s = false;
            this.t = false;
        }
    }

    public boolean hasVisibleItems() {
        if (this.A) {
            return true;
        }
        int n2 = this.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            if (!this.j.get(i2).isVisible()) continue;
            return true;
        }
        return false;
    }

    public void i() {
        this.r = false;
        if (this.s) {
            this.s = false;
            this.b(this.t);
        }
    }

    public boolean isShortcutKey(int n2, KeyEvent keyEvent) {
        return this.a(n2, keyEvent) != null;
    }

    public ArrayList<j> j() {
        if (!this.l) {
            return this.k;
        }
        this.k.clear();
        int n2 = this.j.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            j j2 = this.j.get(i2);
            if (!j2.isVisible()) continue;
            this.k.add(j2);
        }
        this.l = false;
        this.o = true;
        return this.k;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void k() {
        Object object;
        ArrayList<j> arrayList = this.j();
        if (!this.o) {
            return;
        }
        ArrayList<j> arrayList2 = this.x.iterator();
        int n2 = 0;
        while (arrayList2.hasNext()) {
            object = arrayList2.next();
            o o2 = (o)((Reference)object).get();
            if (o2 == null) {
                this.x.remove(object);
                continue;
            }
            n2 |= o2.b();
        }
        if (n2 == 0) {
            this.m.clear();
            this.n.clear();
            this.n.addAll(this.j());
        } else {
            this.m.clear();
            this.n.clear();
            int n3 = arrayList.size();
            for (n2 = 0; n2 < n3; ++n2) {
                object = arrayList.get(n2);
                arrayList2 = ((j)object).j() ? this.m : this.n;
                arrayList2.add((j)object);
            }
        }
        this.o = false;
    }

    public ArrayList<j> l() {
        this.k();
        return this.m;
    }

    public ArrayList<j> m() {
        this.k();
        return this.n;
    }

    public CharSequence n() {
        return this.a;
    }

    public Drawable o() {
        return this.b;
    }

    public View p() {
        return this.c;
    }

    public boolean performIdentifierAction(int n2, int n3) {
        return this.a(this.findItem(n2), n3);
    }

    public boolean performShortcut(int n2, KeyEvent object, int n3) {
        boolean bl2 = (object = this.a(n2, (KeyEvent)object)) != null ? this.a((MenuItem)object, n3) : false;
        if ((n3 & 2) != 0) {
            this.a(true);
        }
        return bl2;
    }

    public h q() {
        return this;
    }

    boolean r() {
        return this.u;
    }

    public void removeGroup(int n2) {
        int n3 = this.c(n2);
        if (n3 >= 0) {
            int n4 = this.j.size();
            for (int i2 = 0; i2 < n4 - n3 && this.j.get(n3).getGroupId() == n2; ++i2) {
                this.a(n3, false);
            }
            this.b(true);
        }
    }

    public void removeItem(int n2) {
        this.a(this.b(n2), true);
    }

    public j s() {
        return this.y;
    }

    public void setGroupCheckable(int n2, boolean bl2, boolean bl3) {
        int n3 = this.j.size();
        for (int i2 = 0; i2 < n3; ++i2) {
            j j2 = this.j.get(i2);
            if (j2.getGroupId() != n2) continue;
            j2.a(bl3);
            j2.setCheckable(bl2);
        }
    }

    public void setGroupDividerEnabled(boolean bl2) {
        this.z = bl2;
    }

    public void setGroupEnabled(int n2, boolean bl2) {
        int n3 = this.j.size();
        for (int i2 = 0; i2 < n3; ++i2) {
            j j2 = this.j.get(i2);
            if (j2.getGroupId() != n2) continue;
            j2.setEnabled(bl2);
        }
    }

    public void setGroupVisible(int n2, boolean bl2) {
        int n3 = this.j.size();
        boolean bl3 = false;
        for (int i2 = 0; i2 < n3; ++i2) {
            j j2 = this.j.get(i2);
            boolean bl4 = bl3;
            if (j2.getGroupId() == n2) {
                bl4 = bl3;
                if (j2.c(bl2)) {
                    bl4 = true;
                }
            }
            bl3 = bl4;
        }
        if (bl3) {
            this.b(true);
        }
    }

    public void setQwertyMode(boolean bl2) {
        this.g = bl2;
        this.b(false);
    }

    public int size() {
        return this.j.size();
    }

    public static interface a {
        public void a(h var1);

        public boolean a(h var1, MenuItem var2);
    }

    public static interface b {
        public boolean a(j var1);
    }

}

