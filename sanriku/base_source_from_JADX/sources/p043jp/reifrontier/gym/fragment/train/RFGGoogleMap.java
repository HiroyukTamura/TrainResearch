package p043jp.reifrontier.gym.fragment.train;

import android.location.Location;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J/\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0002\u0010\rJ5\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0018\u0010\u0012\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J \u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0017\u001a\u00020\u0018J\u0014\u0010\u0019\u001a\u00020\u00162\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\u001bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, mo21739d2 = {"Ljp/reifrontier/gym/fragment/train/RFGGoogleMap;", "", "googleMap", "Lcom/google/android/gms/maps/GoogleMap;", "(Lcom/google/android/gms/maps/GoogleMap;)V", "addMarker", "Lcom/google/android/gms/maps/model/Marker;", "latLng", "Lcom/google/android/gms/maps/model/LatLng;", "iconResource", "", "title", "", "(Lcom/google/android/gms/maps/model/LatLng;Ljava/lang/Integer;Ljava/lang/String;)Lcom/google/android/gms/maps/model/Marker;", "lat", "", "lon", "(DDLjava/lang/Integer;Ljava/lang/String;)Lcom/google/android/gms/maps/model/Marker;", "getLatLng", "location", "Landroid/location/Location;", "moveMapCamera", "", "animate", "", "removeMarker", "markerList", "", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.fragment.train.RFGGoogleMap */
public final class RFGGoogleMap {
    private final GoogleMap googleMap;

    public RFGGoogleMap(GoogleMap googleMap2) {
        Intrinsics.checkParameterIsNotNull(googleMap2, "googleMap");
        this.googleMap = googleMap2;
    }

    private final Marker addMarker(LatLng latLng, Integer num, String str) {
        MarkerOptions position = new MarkerOptions().position(latLng);
        if (num != null) {
            position = position.icon(BitmapDescriptorFactory.fromResource(num.intValue()));
        }
        if (str != null) {
            position = position.title(str);
        }
        return this.googleMap.addMarker(position);
    }

    public static /* synthetic */ Marker addMarker$default(RFGGoogleMap rFGGoogleMap, double d, double d2, Integer num, String str, int i, Object obj) {
        return rFGGoogleMap.addMarker(d, d2, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : str);
    }

    static /* synthetic */ Marker addMarker$default(RFGGoogleMap rFGGoogleMap, LatLng latLng, Integer num, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            num = null;
        }
        if ((i & 4) != 0) {
            str = null;
        }
        return rFGGoogleMap.addMarker(latLng, num, str);
    }

    private final LatLng getLatLng(double d, double d2) {
        return new LatLng(d, d2);
    }

    private final LatLng getLatLng(Location location) {
        return new LatLng(location.getLatitude(), location.getLongitude());
    }

    public static /* synthetic */ void moveMapCamera$default(RFGGoogleMap rFGGoogleMap, double d, double d2, boolean z, int i, Object obj) {
        rFGGoogleMap.moveMapCamera(d, d2, (i & 4) != 0 ? true : z);
    }

    public final Marker addMarker(double d, double d2, Integer num, String str) {
        return addMarker(getLatLng(d, d2), num, str);
    }

    public final void moveMapCamera(double d, double d2, boolean z) {
        CameraUpdate newLatLngZoom = CameraUpdateFactory.newLatLngZoom(new LatLng(d, d2), 18.0f);
        GoogleMap googleMap2 = this.googleMap;
        if (z) {
            googleMap2.animateCamera(newLatLngZoom);
        } else {
            googleMap2.moveCamera(newLatLngZoom);
        }
    }

    public final void removeMarker(List<Marker> list) {
        Intrinsics.checkParameterIsNotNull(list, "markerList");
        for (Marker remove : list) {
            remove.remove();
        }
    }
}
