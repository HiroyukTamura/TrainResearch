/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package jp.co.jreast.jreastapp.commuter.trainlocation;

import android.os.Bundle;
import androidx.f.a.d;
import androidx.f.a.i;
import androidx.f.a.m;
import java.io.Serializable;
import jp.co.jreast.jreastapp.commuter.m.f;
import jp.co.jreast.jreastapp.commuter.trainlocation.h;
import jp.co.jreast.jreastapp.commuter.trainlocation.n;
import kotlin.Metadata;
import kotlin.e.b.j;

@Metadata(bv={1, 0, 2}, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\b\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2={"Ljp/co/jreast/jreastapp/commuter/trainlocation/TrainLocationPagerAdapter;", "Landroidx/fragment/app/FragmentPagerAdapter;", "manager", "Landroidx/fragment/app/FragmentManager;", "localRailwayRepository", "Ljp/co/jreast/jreastapp/commuter/repository/LocalRailwayRepository;", "(Landroidx/fragment/app/FragmentManager;Ljp/co/jreast/jreastapp/commuter/repository/LocalRailwayRepository;)V", "getAppTitle", "", "position", "", "getCount", "getItem", "Landroidx/fragment/app/Fragment;", "getPageTitle", "", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class v
extends m {
    private final f a;

    public v(i i2, f f2) {
        j.b(i2, "manager");
        j.b(f2, "localRailwayRepository");
        super(i2);
        this.a = f2;
    }

    @Override
    public d a(int n2) {
        if (n2 == 0) {
            return new h();
        }
        n n3 = new n();
        Bundle bundle = new Bundle();
        bundle.putSerializable("train_location_page_type", (Serializable)Integer.valueOf(this.a.b(n2)));
        n3.g(bundle);
        return n3;
    }

    @Override
    public int b() {
        return this.a.a();
    }

    @Override
    public CharSequence c(int n2) {
        return this.a.c(n2);
    }

    public final String e(int n2) {
        return this.a.d(n2);
    }
}

