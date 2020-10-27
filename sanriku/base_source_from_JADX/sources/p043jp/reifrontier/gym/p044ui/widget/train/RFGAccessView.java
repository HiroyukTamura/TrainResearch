package p043jp.reifrontier.gym.p044ui.widget.train;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.gms.fitness.data.WorkoutExercises;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import p009e.p010a.p011a.p012a.C0681a;
import p043jp.reifrontier.gym.C2092R;
import p043jp.reifrontier.gym.data.train.spot.RFGContentAccess;
import p043jp.reifrontier.gym.data.train.spot.RFGSpotType;
import p043jp.reifrontier.gym.fragment.train.RFGGoogleMap;
import p043jp.reifrontier.sanriku.R;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0010\u0010#\u001a\u00020\u00182\u0006\u0010\u0006\u001a\u00020\u000bH\u0002J\u0010\u0010$\u001a\u00020\u00182\u0006\u0010%\u001a\u00020\u000bH\u0002J\u0018\u0010&\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0013H\u0002J \u0010'\u001a\u00020\u00182\u0006\u0010(\u001a\u00020)2\u0006\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0013H\u0002J \u0010*\u001a\u00020\u00182\u0006\u0010(\u001a\u00020)2\u0006\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0013H\u0002J \u0010+\u001a\u00020\u00182\u0006\u0010(\u001a\u00020,2\u0006\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0013H\u0002J\u0018\u0010-\u001a\u00020\u00182\u0006\u0010.\u001a\u00020/2\u0006\u0010\u0006\u001a\u00020\u000bH\u0002J\b\u00100\u001a\u00020\u0018H\u0002J\u0010\u00101\u001a\u00020\u00182\u0006\u0010(\u001a\u00020,H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000RL\u0010\u0011\u001a4\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000¨\u00062"}, mo21739d2 = {"Ljp/reifrontier/gym/ui/widget/train/RFGAccessView;", "Landroid/widget/TableLayout;", "context", "Landroid/content/Context;", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "access", "Ljp/reifrontier/gym/data/train/spot/RFGContentAccess;", "spotType", "Ljp/reifrontier/gym/data/train/spot/RFGSpotType;", "stationName", "", "(Landroid/content/Context;Landroidx/fragment/app/FragmentManager;Ljp/reifrontier/gym/data/train/spot/RFGContentAccess;Ljp/reifrontier/gym/data/train/spot/RFGSpotType;Ljava/lang/String;)V", "layoutInflater", "Landroid/view/LayoutInflater;", "mapFragment", "Lcom/google/android/gms/maps/SupportMapFragment;", "onClickShowMap", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "lat", "lon", "", "getOnClickShowMap", "()Lkotlin/jvm/functions/Function2;", "setOnClickShowMap", "(Lkotlin/jvm/functions/Function2;)V", "onClickStation", "Lkotlin/Function0;", "getOnClickStation", "()Lkotlin/jvm/functions/Function0;", "setOnClickStation", "(Lkotlin/jvm/functions/Function0;)V", "addAccess", "addAddress", "address", "addMap", "addMarkerOnMap", "googleMap", "Ljp/reifrontier/gym/fragment/train/RFGGoogleMap;", "moveCameraOnMap", "onMapReady", "Lcom/google/android/gms/maps/GoogleMap;", "setSpannableStationName", "view", "Landroid/widget/TextView;", "setUp", "settingForMap", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
@SuppressLint({"ViewConstructor"})
/* renamed from: jp.reifrontier.gym.ui.widget.train.RFGAccessView */
public final class RFGAccessView extends TableLayout {
    private HashMap _$_findViewCache;
    /* access modifiers changed from: private */
    public final RFGContentAccess access;
    /* access modifiers changed from: private */
    public final FragmentManager fragmentManager;
    private final LayoutInflater layoutInflater;
    /* access modifiers changed from: private */
    public SupportMapFragment mapFragment;
    private Function2<? super Double, ? super Double, Unit> onClickShowMap;
    private Function0<Unit> onClickStation;
    private final RFGSpotType spotType;
    private final String stationName;

    @Metadata(mo21737bv = {1, 0, 3}, mo21740k = 3, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.ui.widget.train.RFGAccessView$WhenMappings */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[RFGSpotType.values().length];
            $EnumSwitchMapping$0 = iArr;
            RFGSpotType rFGSpotType = RFGSpotType.NO_TYPE;
            iArr[0] = 1;
            int[] iArr2 = $EnumSwitchMapping$0;
            RFGSpotType rFGSpotType2 = RFGSpotType.SIGHT_SEE;
            iArr2[1] = 2;
            int[] iArr3 = $EnumSwitchMapping$0;
            RFGSpotType rFGSpotType3 = RFGSpotType.FOOD;
            iArr3[2] = 3;
            int[] iArr4 = $EnumSwitchMapping$0;
            RFGSpotType rFGSpotType4 = RFGSpotType.PLAY;
            iArr4[3] = 4;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RFGAccessView(Context context, FragmentManager fragmentManager2, RFGContentAccess rFGContentAccess, RFGSpotType rFGSpotType, String str) {
        super(context);
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(fragmentManager2, "fragmentManager");
        Intrinsics.checkParameterIsNotNull(rFGContentAccess, "access");
        Intrinsics.checkParameterIsNotNull(rFGSpotType, "spotType");
        Intrinsics.checkParameterIsNotNull(str, "stationName");
        this.fragmentManager = fragmentManager2;
        this.access = rFGContentAccess;
        this.spotType = rFGSpotType;
        this.stationName = str;
        LayoutInflater from = LayoutInflater.from(context);
        Intrinsics.checkExpressionValueIsNotNull(from, "LayoutInflater.from(context)");
        this.layoutInflater = from;
        View.inflate(context, R.layout.view_table, this);
        setUp();
    }

    private final void addAccess(String str) {
        View inflate = this.layoutInflater.inflate(R.layout.row_spot_text, (TableLayout) _$_findCachedViewById(C2092R.C2094id.tableLayout), false);
        ((TextView) inflate.findViewById(R.id.viewTitle)).setText(R.string.sanriku_access);
        TextView textView = (TextView) inflate.findViewById(R.id.viewValue);
        Intrinsics.checkExpressionValueIsNotNull(textView, "viewValue");
        setSpannableStationName(textView, str);
        Intrinsics.checkExpressionValueIsNotNull(inflate, WorkoutExercises.ROW);
        ((TableLayout) _$_findCachedViewById(C2092R.C2094id.tableLayout)).addView(inflate, inflate.getLayoutParams());
    }

    private final void addAddress(String str) {
        View inflate = this.layoutInflater.inflate(R.layout.row_spot_address, (TableLayout) _$_findCachedViewById(C2092R.C2094id.tableLayout), false);
        ((TextView) inflate.findViewById(R.id.viewTitle)).setText(R.string.sanriku_address);
        View findViewById = inflate.findViewById(R.id.viewValue);
        Intrinsics.checkExpressionValueIsNotNull(findViewById, "row.findViewById<TextView>(R.id.viewValue)");
        ((TextView) findViewById).setText(str);
        ((TextView) inflate.findViewById(R.id.viewShowMap)).setOnClickListener(new RFGAccessView$addAddress$1(this));
        Intrinsics.checkExpressionValueIsNotNull(inflate, WorkoutExercises.ROW);
        ((TableLayout) _$_findCachedViewById(C2092R.C2094id.tableLayout)).addView(inflate, inflate.getLayoutParams());
    }

    private final void addMap(double d, double d2) {
        View inflate = this.layoutInflater.inflate(R.layout.row_spot_map, (TableLayout) _$_findCachedViewById(C2092R.C2094id.tableLayout), false);
        View findViewById = inflate.findViewById(R.id.viewMapBase);
        Intrinsics.checkExpressionValueIsNotNull(findViewById, "row.findViewById(R.id.viewMapBase)");
        CardView cardView = (CardView) findViewById;
        Intrinsics.checkExpressionValueIsNotNull(inflate, WorkoutExercises.ROW);
        if (!ViewCompat.isLaidOut(inflate) || inflate.isLayoutRequested()) {
            inflate.addOnLayoutChangeListener(new RFGAccessView$addMap$$inlined$doOnLayout$1(cardView));
        } else {
            ViewGroup.LayoutParams layoutParams = cardView.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = cardView.getWidth();
                cardView.setLayoutParams(layoutParams);
            } else {
                throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            }
        }
        if (ViewCompat.isAttachedToWindow(cardView)) {
            SupportMapFragment supportMapFragment = new SupportMapFragment();
            this.mapFragment = supportMapFragment;
            FragmentTransaction beginTransaction = this.fragmentManager.beginTransaction();
            Intrinsics.checkExpressionValueIsNotNull(beginTransaction, "beginTransaction()");
            beginTransaction.add((int) R.id.viewMapBase, (Fragment) supportMapFragment, "spotMapFragmentTag");
            beginTransaction.commit();
            supportMapFragment.getMapAsync(new RFGAccessView$addMap$$inlined$doOnAttach$lambda$1(this, d, d2));
        } else {
            cardView.addOnAttachStateChangeListener(new RFGAccessView$addMap$$inlined$doOnAttach$1(cardView, this, d, d2));
        }
        if (!ViewCompat.isAttachedToWindow(cardView)) {
            FragmentTransaction beginTransaction2 = this.fragmentManager.beginTransaction();
            Intrinsics.checkExpressionValueIsNotNull(beginTransaction2, "beginTransaction()");
            SupportMapFragment access$getMapFragment$p = this.mapFragment;
            if (access$getMapFragment$p != null) {
                beginTransaction2.remove(access$getMapFragment$p);
            }
            beginTransaction2.commit();
        } else {
            cardView.addOnAttachStateChangeListener(new RFGAccessView$addMap$$inlined$doOnDetach$1(cardView, this));
        }
        ((TableLayout) _$_findCachedViewById(C2092R.C2094id.tableLayout)).addView(inflate);
    }

    private final void addMarkerOnMap(RFGGoogleMap rFGGoogleMap, double d, double d2) {
        int i;
        int ordinal = this.spotType.ordinal();
        if (ordinal == 0) {
            i = R.mipmap.ic_pin_no_type;
        } else if (ordinal == 1) {
            i = R.mipmap.ic_pin_sight_see;
        } else if (ordinal == 2) {
            i = R.mipmap.ic_pin_food;
        } else if (ordinal == 3) {
            i = R.mipmap.ic_pin_play;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        RFGGoogleMap.addMarker$default(rFGGoogleMap, d, d2, Integer.valueOf(i), (String) null, 8, (Object) null);
    }

    private final void moveCameraOnMap(RFGGoogleMap rFGGoogleMap, double d, double d2) {
        RFGGoogleMap.moveMapCamera$default(rFGGoogleMap, d, d2, false, 4, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void onMapReady(GoogleMap googleMap, double d, double d2) {
        RFGGoogleMap rFGGoogleMap = new RFGGoogleMap(googleMap);
        settingForMap(googleMap);
        RFGGoogleMap rFGGoogleMap2 = rFGGoogleMap;
        double d3 = d;
        double d4 = d2;
        moveCameraOnMap(rFGGoogleMap2, d3, d4);
        addMarkerOnMap(rFGGoogleMap2, d3, d4);
    }

    private final void setSpannableStationName(TextView textView, String str) {
        if (this.stationName.length() == 0) {
            textView.setText(str);
            return;
        }
        String a = C0681a.m324a(new StringBuilder(), this.stationName, "駅");
        int indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str, a, 0, false, 6, (Object) null);
        if (indexOf$default < 0) {
            textView.setText(str);
            return;
        }
        SpannableString valueOf = SpannableString.valueOf(str);
        Intrinsics.checkExpressionValueIsNotNull(valueOf, "SpannableString.valueOf(this)");
        IntRange intRange = new IntRange(indexOf$default, a.length() + indexOf$default);
        valueOf.setSpan(new RFGAccessView$setSpannableStationName$1(this), intRange.getStart().intValue(), intRange.getEndInclusive().intValue(), 17);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setText(valueOf);
    }

    private final void setUp() {
        ((TableLayout) _$_findCachedViewById(C2092R.C2094id.tableLayout)).removeAllViews();
        String address = this.access.getAddress();
        if (address != null) {
            addAddress(address);
        }
        String access2 = this.access.getAccess();
        if (access2 != null) {
            addAccess(access2);
        }
        addMap(this.access.getLat(), this.access.getLon());
    }

    private final void settingForMap(GoogleMap googleMap) {
        UiSettings uiSettings = googleMap.getUiSettings();
        Intrinsics.checkExpressionValueIsNotNull(uiSettings, "googleMap.uiSettings");
        uiSettings.setCompassEnabled(false);
        UiSettings uiSettings2 = googleMap.getUiSettings();
        Intrinsics.checkExpressionValueIsNotNull(uiSettings2, "googleMap.uiSettings");
        uiSettings2.setMapToolbarEnabled(false);
        UiSettings uiSettings3 = googleMap.getUiSettings();
        Intrinsics.checkExpressionValueIsNotNull(uiSettings3, "googleMap.uiSettings");
        uiSettings3.setZoomControlsEnabled(true);
        UiSettings uiSettings4 = googleMap.getUiSettings();
        Intrinsics.checkExpressionValueIsNotNull(uiSettings4, "googleMap.uiSettings");
        uiSettings4.setMyLocationButtonEnabled(false);
        UiSettings uiSettings5 = googleMap.getUiSettings();
        Intrinsics.checkExpressionValueIsNotNull(uiSettings5, "googleMap.uiSettings");
        uiSettings5.setZoomGesturesEnabled(false);
        UiSettings uiSettings6 = googleMap.getUiSettings();
        Intrinsics.checkExpressionValueIsNotNull(uiSettings6, "googleMap.uiSettings");
        uiSettings6.setRotateGesturesEnabled(false);
        UiSettings uiSettings7 = googleMap.getUiSettings();
        Intrinsics.checkExpressionValueIsNotNull(uiSettings7, "googleMap.uiSettings");
        uiSettings7.setScrollGesturesEnabled(false);
        UiSettings uiSettings8 = googleMap.getUiSettings();
        Intrinsics.checkExpressionValueIsNotNull(uiSettings8, "googleMap.uiSettings");
        uiSettings8.setTiltGesturesEnabled(false);
        UiSettings uiSettings9 = googleMap.getUiSettings();
        Intrinsics.checkExpressionValueIsNotNull(uiSettings9, "googleMap.uiSettings");
        uiSettings9.setScrollGesturesEnabledDuringRotateOrZoom(false);
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

    public final Function2<Double, Double, Unit> getOnClickShowMap() {
        return this.onClickShowMap;
    }

    public final Function0<Unit> getOnClickStation() {
        return this.onClickStation;
    }

    public final void setOnClickShowMap(Function2<? super Double, ? super Double, Unit> function2) {
        this.onClickShowMap = function2;
    }

    public final void setOnClickStation(Function0<Unit> function0) {
        this.onClickStation = function0;
    }
}
