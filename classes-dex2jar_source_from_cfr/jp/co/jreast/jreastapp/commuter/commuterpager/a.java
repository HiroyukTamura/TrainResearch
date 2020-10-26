/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.view.ViewGroup
 */
package jp.co.jreast.jreastapp.commuter.commuterpager;

import android.os.Bundle;
import android.view.ViewGroup;
import androidx.f.a.d;
import androidx.f.a.i;
import androidx.f.a.o;
import java.io.Serializable;
import jp.co.jreast.jreastapp.commuter.common.b;
import jp.co.jreast.jreastapp.commuter.commuterpager.c.c;
import jp.co.jreast.jreastapp.commuter.commuterpager.settings.h;
import jp.co.jreast.jreastapp.commuter.m.p;
import jp.co.jreast.jreastapp.commuter.m.q;
import jp.co.jreast.jreastapp.commuter.model.FavoriteRoute;
import kotlin.Metadata;
import kotlin.e.b.j;
import kotlin.t;

@Metadata(bv={1, 0, 2}, d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u001aB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000eH\u0016J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0011\u001a\u00020\u000eH\u0016J \u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2={"Ljp/co/jreast/jreastapp/commuter/commuterpager/CommuterPagerAdapter;", "Landroidx/fragment/app/FragmentStatePagerAdapter;", "manager", "Landroidx/fragment/app/FragmentManager;", "favoriteRouteRepository", "Ljp/co/jreast/jreastapp/commuter/repository/UserFavoriteRouteRepository;", "translationRepository", "Ljp/co/jreast/jreastapp/commuter/repository/TranslationRepository;", "(Landroidx/fragment/app/FragmentManager;Ljp/co/jreast/jreastapp/commuter/repository/UserFavoriteRouteRepository;Ljp/co/jreast/jreastapp/commuter/repository/TranslationRepository;)V", "getFavoriteRouteRepository", "()Ljp/co/jreast/jreastapp/commuter/repository/UserFavoriteRouteRepository;", "setFavoriteRouteRepository", "(Ljp/co/jreast/jreastapp/commuter/repository/UserFavoriteRouteRepository;)V", "getCount", "", "getItem", "Landroidx/fragment/app/Fragment;", "position", "getPageTitle", "", "setPrimaryItem", "", "container", "Landroid/view/ViewGroup;", "object", "", "PermanentCommuterPagerType", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class a
extends o {
    private q a;
    private final p b;

    public a(i i2, q q2, p p2) {
        j.b(i2, "manager");
        j.b(q2, "favoriteRouteRepository");
        j.b(p2, "translationRepository");
        super(i2);
        this.a = q2;
        this.b = p2;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public d a(int n2) {
        void var2_3;
        if (n2 == a.a.a()) {
            h h2 = new h();
            do {
                return (d)var2_3;
                break;
            } while (true);
        }
        if (n2 == a.b.a()) {
            jp.co.jreast.jreastapp.commuter.commuterpager.b.a a2 = new jp.co.jreast.jreastapp.commuter.commuterpager.b.a();
            return (d)var2_3;
        }
        if (this.a.a() == 0) {
            c c2 = new c();
            return (d)var2_3;
        }
        jp.co.jreast.jreastapp.commuter.commuterpager.a.a a3 = new jp.co.jreast.jreastapp.commuter.commuterpager.a.a();
        Bundle bundle = new Bundle();
        bundle.putSerializable(b.B.a(), (Serializable)this.a.a(n2 - a.values().length));
        a3.g(bundle);
        return a3;
    }

    @Override
    public int b() {
        if (this.a.a() == 0) {
            return a.values().length + 1;
        }
        return a.values().length + this.a.a();
    }

    @Override
    public void b(ViewGroup viewGroup, int n2, Object object) {
        j.b((Object)viewGroup, "container");
        j.b(object, "object");
        this.b(viewGroup);
        super.b(viewGroup, n2, object);
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public CharSequence c(int n2) {
        Object object;
        if (n2 == a.a.a()) {
            object = this.b;
            n2 = 2131558573;
        } else if (n2 == a.b.a()) {
            object = this.b;
            n2 = 2131558567;
        } else {
            if (this.a.a() != 0) {
                object = this.a.a(n2 - a.values().length).getName();
                n2 = Math.min(((String)object).length(), 5);
                if (object == null) throw new t("null cannot be cast to non-null type java.lang.String");
                object = ((String)object).substring(0, n2);
                j.a(object, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
                return (CharSequence)object;
            }
            object = this.b;
            n2 = 2131558529;
        }
        object = ((p)object).a(n2);
        return (CharSequence)object;
    }

    @Metadata(bv={1, 0, 2}, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b\u00a8\u0006\t"}, d2={"Ljp/co/jreast/jreastapp/commuter/commuterpager/CommuterPagerAdapter$PermanentCommuterPagerType;", "", "code", "", "(Ljava/lang/String;II)V", "getCode", "()I", "SETTING", "HOME", "app_productRelease"}, k=1, mv={1, 1, 11})
    public static final class a
    extends Enum<a> {
        public static final /* enum */ a a;
        public static final /* enum */ a b;
        private static final /* synthetic */ a[] c;
        private final int d;

        static {
            a a2;
            a a3;
            a = a3 = new a(0);
            b = a2 = new a(1);
            c = new a[]{a3, a2};
        }

        protected a(int n3) {
            this.d = n3;
        }

        public static a valueOf(String string2) {
            return Enum.valueOf(a.class, string2);
        }

        public static a[] values() {
            return (a[])c.clone();
        }

        public final int a() {
            return this.d;
        }
    }

}

