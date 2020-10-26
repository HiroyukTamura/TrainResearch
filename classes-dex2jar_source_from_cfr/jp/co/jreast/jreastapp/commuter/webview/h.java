/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package jp.co.jreast.jreastapp.commuter.webview;

import android.content.Context;
import androidx.f.a.e;
import e.a.b;
import java.util.Arrays;
import jp.co.jreast.jreastapp.commuter.webview.g;
import kotlin.Metadata;
import kotlin.e.b.j;

@Metadata(bv={1, 0, 2}, d1={"\u0000&\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\u001a\n\u0010\u0006\u001a\u00020\u0007*\u00020\b\u001a\u001a\u0010\t\u001a\u00020\u0007*\u00020\b2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f\"\u0016\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0003\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2={"PERMISSION_CHECKBEACON", "", "", "[Ljava/lang/String;", "REQUEST_CHECKBEACON", "", "checkBeaconWithPermissionCheck", "", "Ljp/co/jreast/jreastapp/commuter/webview/CommonWebViewFragment;", "onRequestPermissionsResult", "requestCode", "grantResults", "", "app_productRelease"}, k=2, mv={1, 1, 11})
public final class h {
    private static final int a = 0;
    private static final String[] b = new String[]{"android.permission.RECORD_AUDIO"};

    public static final void a(g g2) {
        j.b(g2, "$receiver");
        Context context = (Context)g2.p();
        String[] arrstring = b;
        if (b.a(context, Arrays.copyOf(arrstring, arrstring.length))) {
            g2.ai();
            return;
        }
        g2.a(b, a);
    }

    public static final void a(g g2, int n2, int[] arrn) {
        j.b(g2, "$receiver");
        j.b(arrn, "grantResults");
        if (n2 == a && b.a(Arrays.copyOf(arrn, arrn.length))) {
            g2.ai();
        }
    }
}

