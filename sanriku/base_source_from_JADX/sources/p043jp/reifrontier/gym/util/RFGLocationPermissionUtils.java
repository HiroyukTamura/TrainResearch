package p043jp.reifrontier.gym.util;

import android.content.Context;
import android.os.Build;
import androidx.core.content.ContextCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0018\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0005H\u0002R\u0019\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, mo21739d2 = {"Ljp/reifrontier/gym/util/RFGLocationPermissionUtils;", "", "()V", "PERMISSION_ARRAY", "", "", "getPERMISSION_ARRAY", "()[Ljava/lang/String;", "[Ljava/lang/String;", "checkSelfPermission", "", "context", "Landroid/content/Context;", "isGrantedPermission", "permission", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.util.RFGLocationPermissionUtils */
public final class RFGLocationPermissionUtils {
    public static final RFGLocationPermissionUtils INSTANCE = new RFGLocationPermissionUtils();
    private static final String[] PERMISSION_ARRAY = (Build.VERSION.SDK_INT >= 29 ? new String[]{"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_BACKGROUND_LOCATION"} : new String[]{"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"});

    private RFGLocationPermissionUtils() {
    }

    private final boolean isGrantedPermission(Context context, String str) {
        return ContextCompat.checkSelfPermission(context, str) == 0;
    }

    public final boolean checkSelfPermission(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        boolean z = true;
        for (String isGrantedPermission : PERMISSION_ARRAY) {
            if (!INSTANCE.isGrantedPermission(context, isGrantedPermission)) {
                z = false;
            }
        }
        return z;
    }

    public final String[] getPERMISSION_ARRAY() {
        return PERMISSION_ARRAY;
    }
}
