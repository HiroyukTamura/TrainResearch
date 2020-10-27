package p043jp.reifrontier.silentlogsdkandroid;

import android.util.Patterns;
import android.webkit.URLUtil;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p043jp.reifrontier.silentlogsdkandroid.daily.RFLLocationManager;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010$\n\u0002\b\r\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rJ\"\u0010\u000e\u001a\u00020\u000b2\u001a\u0010\u000f\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\u0011\u0018\u00010\u0010J\u0010\u0010\u0012\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u0013\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u0014\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u0015\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u001e\u0010\u0016\u001a\u00020\u000b2\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0011J\u0010\u0010\u0018\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u0019\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u001a\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u001b\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u001c\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u001d\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rR\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/RFLOperationValidator;", "", "()V", "PATTERNS_NUMBER", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "PATTERNS_PACKAGE_NAME", "PATTERNS_SILENT_LOG_CLIENT_ID", "PATTERNS_SILENT_LOG_CLIENT_SECRET", "PATTERNS_USER_NAME", "isCampaignId", "", "value", "", "isCustomGeofenceParams", "list", "", "", "isEmailAddress", "isGcmToken", "isPackageName", "isPointSystemKey", "isPrivateKey", "privateKeyMap", "isSilentLogClientId", "isSilentLogClientSecret", "isSl2Id", "isUrl", "isUserName", "isWriteLog", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.silentlogsdkandroid.RFLOperationValidator */
public final class RFLOperationValidator {
    public static final RFLOperationValidator INSTANCE = new RFLOperationValidator();

    /* renamed from: a */
    private static final Pattern f2975a = Pattern.compile("[a-zA-Z0-9]{34}");

    /* renamed from: b */
    private static final Pattern f2976b = Pattern.compile("[a-zA-Z0-9]{80,90}");

    /* renamed from: c */
    private static final Pattern f2977c = Pattern.compile("^[a-z]+(\\.[a-zA-Z_][a-zA-Z0-9_]*)*$");

    /* renamed from: d */
    private static final Pattern f2978d = Pattern.compile("[0-9]+");

    /* renamed from: e */
    private static final Pattern f2979e = Pattern.compile("[a-zA-Z0-9\\+\\.\\_\\%\\-\\@\\,\\:]+");

    private RFLOperationValidator() {
    }

    public final boolean isCampaignId(String str) {
        if (str != null) {
            return f2978d.matcher(str).matches();
        }
        return false;
    }

    public final boolean isCustomGeofenceParams(List<? extends Map<String, ? extends Object>> list) {
        String str;
        if (list == null || list.isEmpty()) {
            return false;
        }
        Iterator<? extends Map<String, ? extends Object>> it = list.iterator();
        do {
            boolean z = true;
            if (it.hasNext()) {
                Map map = (Map) it.next();
                if (!map.containsKey("lat") || !map.containsKey("lon") || !map.containsKey("id") || map.get("lat") == null || !(map.get("lat") instanceof Double) || map.get("lon") == null || !(map.get("lon") instanceof Double)) {
                    break;
                }
                Object obj = map.get("id");
                if (!(obj instanceof String)) {
                    obj = null;
                }
                str = (String) obj;
                if (!(str == null || str.length() == 0)) {
                    z = false;
                }
                if (z) {
                    break;
                } else if (Intrinsics.areEqual((Object) str, (Object) RFLLocationManager.GEOFENCE_ID_CENTER_1)) {
                    break;
                } else if (Intrinsics.areEqual((Object) str, (Object) RFLLocationManager.GEOFENCE_ID_CENTER_2)) {
                    break;
                } else if (Intrinsics.areEqual((Object) str, (Object) RFLLocationManager.GEOFENCE_ID_CENTER_3)) {
                    break;
                } else if (Intrinsics.areEqual((Object) str, (Object) RFLLocationManager.GEOFENCE_ID_NORTH)) {
                    break;
                } else if (Intrinsics.areEqual((Object) str, (Object) RFLLocationManager.GEOFENCE_ID_SOUTH)) {
                    break;
                } else if (Intrinsics.areEqual((Object) str, (Object) RFLLocationManager.GEOFENCE_ID_EAST)) {
                    break;
                }
            } else {
                return true;
            }
        } while (Intrinsics.areEqual((Object) str, (Object) RFLLocationManager.GEOFENCE_ID_WEST));
        return false;
    }

    public final boolean isEmailAddress(String str) {
        if (str != null) {
            return Patterns.EMAIL_ADDRESS.matcher(str).matches();
        }
        return false;
    }

    public final boolean isGcmToken(String str) {
        return !(str == null || StringsKt__StringsJVMKt.isBlank(str));
    }

    public final boolean isPackageName(String str) {
        if (str != null) {
            return f2977c.matcher(str).matches();
        }
        return false;
    }

    public final boolean isPointSystemKey(String str) {
        if ((str == null || str.length() == 0) || Intrinsics.areEqual((Object) str, (Object) "systemkey")) {
            return false;
        }
        return Intrinsics.areEqual((Object) str, (Object) "point-201911-SAN");
    }

    public final boolean isPrivateKey(Map<String, ? extends Object> map) {
        if (map != null) {
            if (map.isEmpty()) {
                return false;
            }
            for (Map.Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                Object value = entry.getValue();
                if (str == null || str.length() == 0) {
                    return false;
                }
                if (value == null) {
                    return false;
                }
            }
        }
        return true;
    }

    public final boolean isSilentLogClientId(String str) {
        if (str != null) {
            return f2975a.matcher(str).matches();
        }
        return false;
    }

    public final boolean isSilentLogClientSecret(String str) {
        if (str != null) {
            return f2976b.matcher(str).matches();
        }
        return false;
    }

    public final boolean isSl2Id(String str) {
        if (str != null) {
            return f2978d.matcher(str).matches();
        }
        return false;
    }

    public final boolean isUrl(String str) {
        return !(str == null || str.length() == 0) && Patterns.WEB_URL.matcher(str).matches() && URLUtil.isHttpsUrl(str);
    }

    public final boolean isUserName(String str) {
        if (str != null) {
            return f2979e.matcher(str).matches();
        }
        return true;
    }

    public final boolean isWriteLog(String str) {
        return !(str == null || StringsKt__StringsJVMKt.isBlank(str));
    }
}
