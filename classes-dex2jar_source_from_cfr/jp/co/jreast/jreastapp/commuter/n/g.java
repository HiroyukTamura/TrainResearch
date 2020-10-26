/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package jp.co.jreast.jreastapp.commuter.n;

import android.content.Context;
import androidx.f.a.d;
import e.a.a;
import e.a.b;
import java.util.Arrays;
import jp.co.jreast.jreastapp.commuter.n.e;
import jp.co.jreast.jreastapp.commuter.n.f;
import kotlin.Metadata;
import kotlin.e.b.j;

@Metadata(bv={1, 0, 2}, d1={"\u0000&\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\u001a\n\u0010\u0006\u001a\u00020\u0007*\u00020\b\u001a\u001a\u0010\t\u001a\u00020\u0007*\u00020\b2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f\"\u0016\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0003\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2={"PERMISSION_CAPTURESCREEN", "", "", "[Ljava/lang/String;", "REQUEST_CAPTURESCREEN", "", "captureScreenWithPermissionCheck", "", "Ljp/co/jreast/jreastapp/commuter/routedetail/RouteDetailFragment;", "onRequestPermissionsResult", "requestCode", "grantResults", "", "app_productRelease"}, k=2, mv={1, 1, 11})
public final class g {
    private static final int a = 1;
    private static final String[] b = new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"};

    public static final void a(e e2) {
        j.b(e2, "$receiver");
        Object object = (Context)e2.p();
        String[] arrstring = b;
        if (b.a(object, Arrays.copyOf(arrstring, arrstring.length))) {
            e2.ai();
            return;
        }
        object = e2;
        arrstring = b;
        if (b.a((d)object, Arrays.copyOf(arrstring, arrstring.length))) {
            e2.a(new f(e2));
            return;
        }
        e2.a(b, a);
    }

    public static final void a(e e2, int n2, int[] object) {
        j.b(e2, "$receiver");
        j.b(object, "grantResults");
        if (n2 == a) {
            if (b.a(Arrays.copyOf(object, ((int[])object).length))) {
                e2.ai();
                return;
            }
            object = e2;
            String[] arrstring = b;
            if (!b.a((d)object, Arrays.copyOf(arrstring, arrstring.length))) {
                e2.ak();
                return;
            }
            e2.aj();
        }
    }

    public static final /* synthetic */ String[] a() {
        return b;
    }

    public static final /* synthetic */ int b() {
        return a;
    }
}

