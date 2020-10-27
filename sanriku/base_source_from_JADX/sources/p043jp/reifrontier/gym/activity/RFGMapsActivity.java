package p043jp.reifrontier.gym.activity;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.gson.Gson;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import p041io.realm.Realm;
import p043jp.reifrontier.gym.C2092R;
import p043jp.reifrontier.gym.data.analytics.RFGAnalyticsManager;
import p043jp.reifrontier.gym.data.shared.RFGShared;
import p043jp.reifrontier.gym.domain.api.RFGModActivity;
import p043jp.reifrontier.gym.domain.app.RFGAdapterActivity;
import p043jp.reifrontier.gym.p044ui.dialog.RFGEditActDialog;
import p043jp.reifrontier.sanriku.R;
import p043jp.reifrontier.silentlogsdkandroid.SilentLogOperation;
import p078g.p079a.p094C.C1683a;
import p078g.p079a.p096w.p097b.C1721a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\bH\u0002J\u0010\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\bH\u0016J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0015H\u0003J\b\u0010\u0016\u001a\u00020\u0010H\u0016J\u0012\u0010\u0017\u001a\u00020\u00102\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0014J\u0010\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\fH\u0016J\u0012\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010 \u001a\u00020\u0010H\u0014J\u0010\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u0015H\u0002J\b\u0010#\u001a\u00020\u0010H\u0002J\u0010\u0010$\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\bH\u0002J\u0010\u0010%\u001a\u00020\u00102\u0006\u0010&\u001a\u00020'H\u0003R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006("}, mo21739d2 = {"Ljp/reifrontier/gym/activity/RFGMapsActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/google/android/gms/maps/OnMapReadyCallback;", "Ljp/reifrontier/gym/ui/dialog/RFGEditActDialog$EditActDialogListener;", "()V", "currentPolyline", "Lcom/google/android/gms/maps/model/Polyline;", "currentType", "", "mAdapterActivity", "Ljp/reifrontier/gym/domain/app/RFGAdapterActivity;", "mMap", "Lcom/google/android/gms/maps/GoogleMap;", "mRealm", "Lio/realm/Realm;", "addTag", "", "type", "finishEdit", "loadDaily", "startTime", "", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onMapReady", "googleMap", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "onResume", "polyLine", "color", "setData", "updateData", "updateLocalDaily", "updateDate", "Ljava/util/Date;", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.activity.RFGMapsActivity */
public final class RFGMapsActivity extends AppCompatActivity implements OnMapReadyCallback, RFGEditActDialog.EditActDialogListener {
    private HashMap _$_findViewCache;
    private Polyline currentPolyline;
    /* access modifiers changed from: private */
    public String currentType;
    /* access modifiers changed from: private */
    public RFGAdapterActivity mAdapterActivity;
    private GoogleMap mMap;
    /* access modifiers changed from: private */
    public Realm mRealm;

    public static final /* synthetic */ String access$getCurrentType$p(RFGMapsActivity rFGMapsActivity) {
        String str = rFGMapsActivity.currentType;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentType");
        }
        return str;
    }

    public static final /* synthetic */ RFGAdapterActivity access$getMAdapterActivity$p(RFGMapsActivity rFGMapsActivity) {
        RFGAdapterActivity rFGAdapterActivity = rFGMapsActivity.mAdapterActivity;
        if (rFGAdapterActivity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapterActivity");
        }
        return rFGAdapterActivity;
    }

    private final void addTag(String str) {
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        RFGAdapterActivity rFGAdapterActivity = this.mAdapterActivity;
        if (rFGAdapterActivity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapterActivity");
        }
        int startTime = rFGAdapterActivity.getStartTime();
        RFGAdapterActivity rFGAdapterActivity2 = this.mAdapterActivity;
        if (rFGAdapterActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapterActivity");
        }
        int endTime = rFGAdapterActivity2.getEndTime();
        String encode = URLEncoder.encode(new Gson().toJson((Object) new RFGModActivity(str, currentTimeMillis)), "utf-8");
        SilentLogOperation instance = SilentLogOperation.Companion.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(encode, "encodeModSt");
        instance.saveActivityTag(encode, startTime, endTime);
        new Handler().postDelayed(new RFGMapsActivity$addTag$1(this, startTime), 600);
    }

    /* access modifiers changed from: private */
    @SuppressLint({"CheckResult"})
    public final void loadDaily(int i) {
        Date date = new Date(((long) i) * 1000);
        SilentLogOperation.Companion.getInstance().getDataWithTagFor(date).mo27434b(C1683a.m2378b()).mo27429a(C1721a.m2428a()).mo27432a(new RFGMapsActivity$loadDaily$1(this, date), RFGMapsActivity$loadDaily$2.INSTANCE);
    }

    private final void polyLine(int i) {
        PolylineOptions width = new PolylineOptions().color(i).geodesic(true).width(14.0f);
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        RFGAdapterActivity rFGAdapterActivity = this.mAdapterActivity;
        if (rFGAdapterActivity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapterActivity");
        }
        for (LatLng next : rFGAdapterActivity.getList()) {
            builder.include(next);
            width.add(next);
        }
        Resources resources = getResources();
        Intrinsics.checkExpressionValueIsNotNull(resources, "resources");
        int i2 = resources.getDisplayMetrics().widthPixels;
        Resources resources2 = getResources();
        Intrinsics.checkExpressionValueIsNotNull(resources2, "resources");
        int i3 = resources2.getDisplayMetrics().heightPixels;
        LatLngBounds build = builder.build();
        LatLng latLng = build.southwest;
        LatLng latLng2 = build.northeast;
        builder.include(new LatLng(latLng.latitude * 0.99995d, latLng.longitude * 0.99995d));
        builder.include(new LatLng(latLng2.latitude * 1.00005d, latLng2.longitude * 1.00005d));
        LatLngBounds build2 = builder.build();
        GoogleMap googleMap = this.mMap;
        if (googleMap == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMap");
        }
        this.currentPolyline = googleMap.addPolyline(width);
        CameraUpdate newLatLngBounds = CameraUpdateFactory.newLatLngBounds(build2, i2, i3, 0);
        GoogleMap googleMap2 = this.mMap;
        if (googleMap2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMap");
        }
        googleMap2.moveCamera(newLatLngBounds);
    }

    private final void setData() {
        RFGAdapterActivity rFGAdapterActivity = this.mAdapterActivity;
        if (rFGAdapterActivity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapterActivity");
        }
        this.currentType = rFGAdapterActivity.getActivity();
        ImageView imageView = (ImageView) _$_findCachedViewById(C2092R.C2094id.map_type);
        RFGAdapterActivity rFGAdapterActivity2 = this.mAdapterActivity;
        if (rFGAdapterActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapterActivity");
        }
        imageView.setImageResource(rFGAdapterActivity2.titleImage());
        TextView textView = (TextView) _$_findCachedViewById(C2092R.C2094id.map_title);
        Intrinsics.checkExpressionValueIsNotNull(textView, "map_title");
        RFGAdapterActivity rFGAdapterActivity3 = this.mAdapterActivity;
        if (rFGAdapterActivity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapterActivity");
        }
        textView.setText(rFGAdapterActivity3.title());
        TextView textView2 = (TextView) _$_findCachedViewById(C2092R.C2094id.map_time);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "map_time");
        RFGAdapterActivity rFGAdapterActivity4 = this.mAdapterActivity;
        if (rFGAdapterActivity4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapterActivity");
        }
        textView2.setText(rFGAdapterActivity4.time());
        TextView textView3 = (TextView) _$_findCachedViewById(C2092R.C2094id.map_step);
        Intrinsics.checkExpressionValueIsNotNull(textView3, "map_step");
        RFGAdapterActivity rFGAdapterActivity5 = this.mAdapterActivity;
        if (rFGAdapterActivity5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapterActivity");
        }
        textView3.setText(rFGAdapterActivity5.steps());
        TextView textView4 = (TextView) _$_findCachedViewById(C2092R.C2094id.map_distance);
        Intrinsics.checkExpressionValueIsNotNull(textView4, "map_distance");
        RFGAdapterActivity rFGAdapterActivity6 = this.mAdapterActivity;
        if (rFGAdapterActivity6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapterActivity");
        }
        textView4.setText(rFGAdapterActivity6.mo30460km());
        ((Button) _$_findCachedViewById(C2092R.C2094id.map_edit)).setOnClickListener(new RFGMapsActivity$setData$1(this));
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0095  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void updateData(java.lang.String r7) {
        /*
            r6 = this;
            java.lang.String r0 = "#221D35"
            int r0 = android.graphics.Color.parseColor(r0)
            int r1 = r7.hashCode()
            r2 = -117759745(0xfffffffff8fb20ff, float:-4.0747992E34)
            if (r1 == r2) goto L_0x0046
            r2 = 115122(0x1c1b2, float:1.6132E-40)
            if (r1 == r2) goto L_0x0030
            r2 = 117814(0x1cc36, float:1.65093E-40)
            if (r1 == r2) goto L_0x001a
            goto L_0x005b
        L_0x001a:
            java.lang.String r1 = "wlk"
            boolean r7 = r7.equals(r1)
            if (r7 == 0) goto L_0x005b
            r7 = 2131558404(0x7f0d0004, float:1.8742123E38)
            java.lang.String r0 = "#FFEF48"
            int r0 = android.graphics.Color.parseColor(r0)
            java.lang.String r1 = "徒歩"
            java.lang.String r2 = "111b"
            goto L_0x0062
        L_0x0030:
            java.lang.String r1 = "trp"
            boolean r7 = r7.equals(r1)
            if (r7 == 0) goto L_0x005b
            r7 = 2131558403(0x7f0d0003, float:1.874212E38)
            java.lang.String r0 = "#009EFD"
            int r0 = android.graphics.Color.parseColor(r0)
            java.lang.String r1 = "乗り物"
            java.lang.String r2 = "111d"
            goto L_0x0062
        L_0x0046:
            java.lang.String r1 = "bicycle"
            boolean r7 = r7.equals(r1)
            if (r7 == 0) goto L_0x005b
            r7 = 2131558400(0x7f0d0000, float:1.8742115E38)
            java.lang.String r0 = "#99ff66"
            int r0 = android.graphics.Color.parseColor(r0)
            java.lang.String r1 = "自転車"
            java.lang.String r2 = "111c"
            goto L_0x0062
        L_0x005b:
            java.lang.String r1 = "滞在"
            r7 = 2131558402(0x7f0d0002, float:1.8742119E38)
            java.lang.String r2 = "999"
        L_0x0062:
            jp.reifrontier.gym.data.analytics.RFGAnalyticsManager r3 = p043jp.reifrontier.gym.data.analytics.RFGAnalyticsManager.INSTANCE
            jp.reifrontier.gym.domain.app.RFGAdapterActivity r4 = r6.mAdapterActivity
            if (r4 != 0) goto L_0x006d
            java.lang.String r5 = "mAdapterActivity"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)
        L_0x006d:
            java.lang.String r4 = r4.analyticsTime()
            java.lang.String r5 = "111"
            r3.sendEvent(r5, r2, r4)
            int r2 = p043jp.reifrontier.gym.C2092R.C2094id.map_type
            android.view.View r2 = r6._$_findCachedViewById(r2)
            android.widget.ImageView r2 = (android.widget.ImageView) r2
            r2.setImageResource(r7)
            int r7 = p043jp.reifrontier.gym.C2092R.C2094id.map_title
            android.view.View r7 = r6._$_findCachedViewById(r7)
            android.widget.TextView r7 = (android.widget.TextView) r7
            java.lang.String r2 = "map_title"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r7, r2)
            r7.setText(r1)
            com.google.android.gms.maps.model.Polyline r7 = r6.currentPolyline
            if (r7 == 0) goto L_0x009d
            if (r7 != 0) goto L_0x009a
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x009a:
            r7.remove()
        L_0x009d:
            r6.polyLine(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p043jp.reifrontier.gym.activity.RFGMapsActivity.updateData(java.lang.String):void");
    }

    /* access modifiers changed from: private */
    @SuppressLint({"CheckResult"})
    public final void updateLocalDaily(Date date) {
        SilentLogOperation.Companion.getInstance().getDataFor(date).mo27434b(C1683a.m2378b()).mo27429a(C1721a.m2428a()).mo27432a(new RFGMapsActivity$updateLocalDaily$1(this), RFGMapsActivity$updateLocalDaily$2.INSTANCE);
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    public void finishEdit(String str) {
        Intrinsics.checkParameterIsNotNull(str, "type");
        RFGShared.INSTANCE.setModify(true);
        this.currentType = str;
        updateData(str);
        addTag(str);
    }

    public void onBackPressed() {
        RFGShared.INSTANCE.clearLocationData();
        RFGAnalyticsManager.sendEvent$default(RFGAnalyticsManager.INSTANCE, "111", "111e", (String) null, 4, (Object) null);
        super.onBackPressed();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_maps);
        setSupportActionBar((Toolbar) _$_findCachedViewById(C2092R.C2094id.toolbar));
        this.mRealm = Realm.getDefaultInstance();
        Object fromJson = new Gson().fromJson(RFGShared.INSTANCE.locationData(), new RFGMapsActivity$onCreate$turnsType$1().getType());
        Intrinsics.checkExpressionValueIsNotNull(fromJson, "gson.fromJson<RFGAdapterActivity>(data, turnsType)");
        this.mAdapterActivity = (RFGAdapterActivity) fromJson;
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar == null) {
            Intrinsics.throwNpe();
        }
        Intrinsics.checkExpressionValueIsNotNull(supportActionBar, "supportActionBar!!");
        supportActionBar.setTitle((CharSequence) "");
        ActionBar supportActionBar2 = getSupportActionBar();
        if (supportActionBar2 == null) {
            Intrinsics.throwNpe();
        }
        supportActionBar2.setDisplayHomeAsUpEnabled(true);
        ActionBar supportActionBar3 = getSupportActionBar();
        if (supportActionBar3 == null) {
            Intrinsics.throwNpe();
        }
        supportActionBar3.setDisplayShowHomeEnabled(true);
        ActionBar supportActionBar4 = getSupportActionBar();
        if (supportActionBar4 == null) {
            Intrinsics.throwNpe();
        }
        supportActionBar4.setHomeAsUpIndicator((int) R.mipmap.close);
        Fragment findFragmentById = getSupportFragmentManager().findFragmentById(R.id.map);
        if (findFragmentById != null) {
            ((SupportMapFragment) findFragmentById).getMapAsync(this);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.google.android.gms.maps.SupportMapFragment");
    }

    public void onMapReady(GoogleMap googleMap) {
        Intrinsics.checkParameterIsNotNull(googleMap, "googleMap");
        this.mMap = googleMap;
        RFGAdapterActivity rFGAdapterActivity = this.mAdapterActivity;
        if (rFGAdapterActivity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapterActivity");
        }
        if (rFGAdapterActivity.sty()) {
            RFGAdapterActivity rFGAdapterActivity2 = this.mAdapterActivity;
            if (rFGAdapterActivity2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAdapterActivity");
            }
            LatLng latLng = (LatLng) CollectionsKt___CollectionsKt.last(rFGAdapterActivity2.getList());
            BitmapDescriptor fromResource = BitmapDescriptorFactory.fromResource(R.mipmap.stay_pin);
            Intrinsics.checkExpressionValueIsNotNull(fromResource, "BitmapDescriptorFactory.…source(R.mipmap.stay_pin)");
            GoogleMap googleMap2 = this.mMap;
            if (googleMap2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMap");
            }
            googleMap2.addMarker(new MarkerOptions().position(latLng).icon(fromResource));
            CameraPosition build = new CameraPosition.Builder().target(latLng).zoom(18.0f).bearing(0.0f).tilt(0.0f).build();
            GoogleMap googleMap3 = this.mMap;
            if (googleMap3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMap");
            }
            googleMap3.moveCamera(CameraUpdateFactory.newCameraPosition(build));
            return;
        }
        RFGAdapterActivity rFGAdapterActivity3 = this.mAdapterActivity;
        if (rFGAdapterActivity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapterActivity");
        }
        polyLine(rFGAdapterActivity3.mapColor());
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem == null) {
            Intrinsics.throwNpe();
        }
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        setData();
        RFGAnalyticsManager.INSTANCE.sendScreen("111");
    }
}
