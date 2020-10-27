package p043jp.reifrontier.silentlogsdkandroid.utils;

import android.location.Location;
import com.fonfon.kgeohash.KTXKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, mo21739d2 = {"isJapan", "", "Landroid/location/Location;", "silentlogsdkandroid_release"}, mo21740k = 2, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.silentlogsdkandroid.utils.LocationExKt */
public final class LocationExKt {
    public static final boolean isJapan(Location location) {
        Intrinsics.checkParameterIsNotNull(location, "$this$isJapan");
        String geoHash = KTXKt.toGeoHash$default(location, 0, 1, (Object) null).toString();
        if (geoHash != null) {
            String substring = geoHash.substring(0, 2);
            Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            if (LocationEx.INSTANCE.getTwoDigitJapan().contains(substring)) {
                return true;
            }
            String substring2 = geoHash.substring(0, 3);
            Intrinsics.checkExpressionValueIsNotNull(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            if (LocationEx.INSTANCE.getThreeDigitJapan().contains(substring2)) {
                return true;
            }
            String substring3 = geoHash.substring(0, 4);
            Intrinsics.checkExpressionValueIsNotNull(substring3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return LocationEx.INSTANCE.getFourDigitJapan().contains(substring3);
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }
}
