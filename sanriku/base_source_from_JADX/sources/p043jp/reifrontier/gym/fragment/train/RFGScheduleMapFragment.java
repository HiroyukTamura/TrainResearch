package p043jp.reifrontier.gym.fragment.train;

import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.Marker;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.C1126c;
import org.greenrobot.eventbus.C1129m;
import p009e.p010a.p011a.p012a.C0681a;
import p043jp.reifrontier.gym.C2092R;
import p043jp.reifrontier.gym.RFGDef;
import p043jp.reifrontier.gym.data.analytics.RFGAnalyticsManager;
import p043jp.reifrontier.gym.data.api.RFGRailroadClient;
import p043jp.reifrontier.gym.data.api.RFGRealtime;
import p043jp.reifrontier.gym.data.train.RFGStation;
import p043jp.reifrontier.gym.data.train.RFGTrain;
import p043jp.reifrontier.gym.data.train.RFGTrainData;
import p043jp.reifrontier.gym.domain.api.train.RFGApiOperation;
import p043jp.reifrontier.gym.domain.api.train.RFGApiRealtime;
import p043jp.reifrontier.gym.fragment.RFGFragmentBase;
import p043jp.reifrontier.gym.p044ui.adapter.RFGStationScheduleAdapter;
import p043jp.reifrontier.gym.p044ui.dialog.RFGTrainScheduleDialog;
import p043jp.reifrontier.gym.p044ui.viewModel.RFGStationDetail;
import p043jp.reifrontier.gym.p044ui.viewModel.RFGTrainDetail;
import p043jp.reifrontier.gym.p044ui.widget.autocompleted.RFGAutoCompletedAdapter;
import p043jp.reifrontier.gym.p044ui.widget.autocompleted.RFGAutoCompletedEditText;
import p043jp.reifrontier.gym.p044ui.widget.train.RFGRealtimeInfoWindow;
import p043jp.reifrontier.sanriku.R;
import p043jp.reifrontier.silentlogsdkandroid.SilentLogOperation;
import p048l.p049a.C1122a;
import p078g.p079a.C1714r;
import p078g.p079a.p094C.C1683a;
import p078g.p079a.p096w.p097b.C1721a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000Æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 y2\u00020\u00012\u00020\u0002:\u0003yz{B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010-\u001a\u00020\rH\u0016J\u0016\u0010.\u001a\u00020/2\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u000f01H\u0002J\b\u00102\u001a\u00020/H\u0002J$\u00103\u001a\u00020/2\f\u00104\u001a\b\u0012\u0004\u0012\u000205012\f\u00106\u001a\b\u0012\u0004\u0012\u00020/07H\u0002J\u001a\u00108\u001a\u00020/2\u0010\b\u0002\u00109\u001a\n\u0012\u0004\u0012\u00020/\u0018\u000107H\u0002J1\u0010:\u001a\u00020/2\u0006\u0010;\u001a\u00020\u00052\b\u0010<\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u00109\u001a\n\u0012\u0004\u0012\u00020/\u0018\u000107H\u0002¢\u0006\u0002\u0010=J\u0010\u0010>\u001a\u00020/2\u0006\u0010?\u001a\u00020\"H\u0002J\b\u0010@\u001a\u00020/H\u0002J\b\u0010A\u001a\u00020/H\u0002J\b\u0010B\u001a\u00020/H\u0002J\b\u0010C\u001a\u00020DH\u0002J\u0012\u0010E\u001a\u0004\u0018\u00010\u000f2\u0006\u0010F\u001a\u00020GH\u0002J\b\u0010H\u001a\u00020IH\u0016J\b\u0010J\u001a\u00020\tH\u0002J\b\u0010K\u001a\u00020/H\u0002J\b\u0010L\u001a\u00020\u0005H\u0016J\b\u0010M\u001a\u00020/H\u0002J\u0010\u0010N\u001a\u00020/2\u0006\u0010O\u001a\u00020PH\u0016J\u0010\u0010Q\u001a\u00020/2\u0006\u0010R\u001a\u00020SH\u0007J\u0012\u0010T\u001a\u00020/2\b\u0010U\u001a\u0004\u0018\u00010VH\u0016J\b\u0010W\u001a\u00020/H\u0016J\u0010\u0010X\u001a\u00020\"2\u0006\u0010Y\u001a\u00020ZH\u0002J\u0012\u0010[\u001a\u00020/2\b\u0010\\\u001a\u0004\u0018\u00010]H\u0016J\u0010\u0010^\u001a\u00020\"2\u0006\u0010_\u001a\u00020\u0013H\u0002J\b\u0010`\u001a\u00020/H\u0016J\b\u0010a\u001a\u00020/H\u0016J\b\u0010b\u001a\u00020/H\u0002J\u0012\u0010c\u001a\u00020/2\b\u0010U\u001a\u0004\u0018\u00010VH\u0016J\u0012\u0010d\u001a\u00020/2\b\b\u0002\u0010e\u001a\u00020\"H\u0002J\b\u0010f\u001a\u00020\rH\u0016J\u0010\u0010g\u001a\u00020/2\u0006\u0010h\u001a\u00020\u000fH\u0002J\u000e\u0010g\u001a\u00020/2\u0006\u0010i\u001a\u00020\rJ\u001a\u0010j\u001a\u00020/2\u0006\u0010h\u001a\u00020\u000f2\b\b\u0002\u0010k\u001a\u00020\"H\u0002J\b\u0010l\u001a\u00020/H\u0002J\b\u0010m\u001a\u00020/H\u0002J\b\u0010n\u001a\u00020/H\u0002J\b\u0010o\u001a\u00020/H\u0002J\u0010\u0010p\u001a\u00020/2\u0006\u0010q\u001a\u00020rH\u0002J\b\u0010s\u001a\u00020/H\u0002J\u0018\u0010t\u001a\u00020/2\u0006\u0010u\u001a\u00020\r2\u0006\u0010v\u001a\u00020\u0005H\u0002J\b\u0010w\u001a\u00020/H\u0003J\b\u0010x\u001a\u00020/H\u0002R\u0014\u0010\u0004\u001a\u00020\u00058BX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R$\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00058B@BX\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u0007\"\u0004\b\u0017\u0010\u0018R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050$X.¢\u0006\u0002\n\u0000R$\u0010%\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00058B@BX\u000e¢\u0006\f\u001a\u0004\b&\u0010\u0007\"\u0004\b'\u0010\u0018R\u0014\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00130\u001dX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00130\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\tX.¢\u0006\u0002\n\u0000¨\u0006|"}, mo21739d2 = {"Ljp/reifrontier/gym/fragment/train/RFGScheduleMapFragment;", "Ljp/reifrontier/gym/fragment/RFGFragmentBase;", "Lcom/google/android/gms/maps/OnMapReadyCallback;", "()V", "defaultMapBottomMargin", "", "getDefaultMapBottomMargin", "()I", "displaySize", "Landroid/graphics/Point;", "googleMapWrapper", "Ljp/reifrontier/gym/fragment/train/RFGGoogleMap;", "infoWindowShownTrain", "", "initStation", "Ljp/reifrontier/gym/data/train/RFGStation;", "initStationLoadingHandler", "Landroid/os/Handler;", "initStationMarker", "Lcom/google/android/gms/maps/model/Marker;", "value", "mapBottomMargin", "getMapBottomMargin", "setMapBottomMargin", "(I)V", "param1", "param2", "realTimeRequestHandler", "realtimeTrainList", "", "Ljp/reifrontier/gym/data/api/RFGRealtime;", "scheduleMapFragmentListener", "Ljp/reifrontier/gym/fragment/train/RFGScheduleMapFragment$OnScheduleMapFragmentListener;", "scheduleViewDragStart", "", "scheduleViewDraggableMinMaxHeight", "Lkotlin/Pair;", "scheduleViewHeight", "getScheduleViewHeight", "setScheduleViewHeight", "searchResultMarkerList", "trainMarkerList", "upDownToggleDegrees", "", "viewSize", "actionBarTitle", "addSearchResultMarker", "", "searchResults", "", "asyncGoogleMap", "changeSchedule", "trainScheduleList", "Ljp/reifrontier/gym/ui/viewModel/RFGTrainDetail;", "onChanged", "Lkotlin/Function0;", "changeScheduleViewHeightHalfWithAnimation", "onCompleted", "changeScheduleViewHeightWithAnimation", "targetResultHeight", "targetMapBottom", "(ILjava/lang/Integer;Lkotlin/jvm/functions/Function0;)V", "changeUpDownToggleWithAnimation", "toUp", "clearInitStationMarker", "clearSearchResultMarker", "clearTrainMarker", "createInfoWindowClickListener", "Lcom/google/android/gms/maps/GoogleMap$OnInfoWindowClickListener;", "findNearestStation", "location", "Landroid/location/Location;", "fragmentType", "Ljp/reifrontier/gym/RFGDef$FragType;", "getDisplaySize", "getViewSize", "layoutId", "loadInitStation", "onAttach", "context", "Landroid/content/Context;", "onCompletedRealtimeRequest", "event", "Ljp/reifrontier/gym/fragment/train/RFGScheduleMapFragment$OnCompletedRealtimeRequest;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDetach", "onDraggableHandleTouchListener", "motionEvent", "Landroid/view/MotionEvent;", "onMapReady", "aGoogleMap", "Lcom/google/android/gms/maps/GoogleMap;", "onMarkerClick", "marker", "onPause", "onResume", "onTapUpDownToggle", "onViewStateRestored", "resetScheduleViewHeight", "animation", "screenId", "search", "station", "searchText", "selectStation", "enterFilterWord", "setUpAutoCompleted", "setUpScheduleView", "showErrorFailedGoogleMap", "showInitStation", "showStationSchedule", "stationDetail", "Ljp/reifrontier/gym/ui/viewModel/RFGStationDetail;", "showTrainMarker", "showTrainScheduleDialog", "trainNo", "currentStationId", "startRequestRealtime", "stopRequestRealtime", "Companion", "OnCompletedRealtimeRequest", "OnScheduleMapFragmentListener", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.fragment.train.RFGScheduleMapFragment */
public final class RFGScheduleMapFragment extends RFGFragmentBase implements OnMapReadyCallback {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long INIT_STATION_LOADING_INTERVAL = 1800000;
    private static final long REALTIME_UPDATE_INTERVAL = 5000;
    private HashMap _$_findViewCache;
    /* access modifiers changed from: private */
    public Point displaySize;
    private RFGGoogleMap googleMapWrapper;
    private String infoWindowShownTrain;
    private RFGStation initStation;
    private final Handler initStationLoadingHandler = new Handler();
    private Marker initStationMarker;
    private String param1;
    private String param2;
    private final Handler realTimeRequestHandler = new Handler();
    private List<RFGRealtime> realtimeTrainList = new ArrayList();
    /* access modifiers changed from: private */
    public OnScheduleMapFragmentListener scheduleMapFragmentListener;
    private boolean scheduleViewDragStart;
    /* access modifiers changed from: private */
    public Pair<Integer, Integer> scheduleViewDraggableMinMaxHeight;
    private final List<Marker> searchResultMarkerList = new ArrayList();
    private List<Marker> trainMarkerList = new ArrayList();
    private float upDownToggleDegrees;
    /* access modifiers changed from: private */
    public Point viewSize;

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, mo21739d2 = {"Ljp/reifrontier/gym/fragment/train/RFGScheduleMapFragment$OnScheduleMapFragmentListener;", "Ljp/reifrontier/gym/fragment/RFGFragmentBase$OnFragmentBaseListener;", "showStationFragment", "", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.fragment.train.RFGScheduleMapFragment$OnScheduleMapFragmentListener */
    public interface OnScheduleMapFragmentListener extends RFGFragmentBase.OnFragmentBaseListener {
        void showStationFragment();
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\r"}, mo21739d2 = {"Ljp/reifrontier/gym/fragment/train/RFGScheduleMapFragment$Companion;", "", "()V", "ARG_PARAM1", "", "ARG_PARAM2", "INIT_STATION_LOADING_INTERVAL", "", "REALTIME_UPDATE_INTERVAL", "newInstance", "Ljp/reifrontier/gym/fragment/train/RFGScheduleMapFragment;", "param1", "param2", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.fragment.train.RFGScheduleMapFragment$Companion */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RFGScheduleMapFragment newInstance(String str, String str2) {
            Intrinsics.checkParameterIsNotNull(str, RFGScheduleMapFragment.ARG_PARAM1);
            Intrinsics.checkParameterIsNotNull(str2, RFGScheduleMapFragment.ARG_PARAM2);
            RFGScheduleMapFragment rFGScheduleMapFragment = new RFGScheduleMapFragment();
            Bundle bundle = new Bundle();
            bundle.putString(RFGScheduleMapFragment.ARG_PARAM1, str);
            bundle.putString(RFGScheduleMapFragment.ARG_PARAM2, str2);
            rFGScheduleMapFragment.setArguments(bundle);
            return rFGScheduleMapFragment;
        }
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0005¢\u0006\u0002\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\u0005HÆ\u0003J=\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0005HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u001d"}, mo21739d2 = {"Ljp/reifrontier/gym/fragment/train/RFGScheduleMapFragment$OnCompletedRealtimeRequest;", "", "realtimeResult", "Ljp/reifrontier/gym/data/api/RFGRailroadClient$RailroadApiResult;", "realtimeList", "", "Ljp/reifrontier/gym/domain/api/train/RFGApiRealtime;", "operationResult", "operationList", "Ljp/reifrontier/gym/domain/api/train/RFGApiOperation;", "(Ljp/reifrontier/gym/data/api/RFGRailroadClient$RailroadApiResult;Ljava/util/List;Ljp/reifrontier/gym/data/api/RFGRailroadClient$RailroadApiResult;Ljava/util/List;)V", "getOperationList", "()Ljava/util/List;", "getOperationResult", "()Ljp/reifrontier/gym/data/api/RFGRailroadClient$RailroadApiResult;", "getRealtimeList", "getRealtimeResult", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.fragment.train.RFGScheduleMapFragment$OnCompletedRealtimeRequest */
    public static final class OnCompletedRealtimeRequest {
        private final List<RFGApiOperation> operationList;
        private final RFGRailroadClient.RailroadApiResult operationResult;
        private final List<RFGApiRealtime> realtimeList;
        private final RFGRailroadClient.RailroadApiResult realtimeResult;

        public OnCompletedRealtimeRequest(RFGRailroadClient.RailroadApiResult railroadApiResult, List<RFGApiRealtime> list, RFGRailroadClient.RailroadApiResult railroadApiResult2, List<RFGApiOperation> list2) {
            Intrinsics.checkParameterIsNotNull(railroadApiResult, "realtimeResult");
            Intrinsics.checkParameterIsNotNull(list, "realtimeList");
            Intrinsics.checkParameterIsNotNull(railroadApiResult2, "operationResult");
            Intrinsics.checkParameterIsNotNull(list2, "operationList");
            this.realtimeResult = railroadApiResult;
            this.realtimeList = list;
            this.operationResult = railroadApiResult2;
            this.operationList = list2;
        }

        public static /* synthetic */ OnCompletedRealtimeRequest copy$default(OnCompletedRealtimeRequest onCompletedRealtimeRequest, RFGRailroadClient.RailroadApiResult railroadApiResult, List<RFGApiRealtime> list, RFGRailroadClient.RailroadApiResult railroadApiResult2, List<RFGApiOperation> list2, int i, Object obj) {
            if ((i & 1) != 0) {
                railroadApiResult = onCompletedRealtimeRequest.realtimeResult;
            }
            if ((i & 2) != 0) {
                list = onCompletedRealtimeRequest.realtimeList;
            }
            if ((i & 4) != 0) {
                railroadApiResult2 = onCompletedRealtimeRequest.operationResult;
            }
            if ((i & 8) != 0) {
                list2 = onCompletedRealtimeRequest.operationList;
            }
            return onCompletedRealtimeRequest.copy(railroadApiResult, list, railroadApiResult2, list2);
        }

        public final RFGRailroadClient.RailroadApiResult component1() {
            return this.realtimeResult;
        }

        public final List<RFGApiRealtime> component2() {
            return this.realtimeList;
        }

        public final RFGRailroadClient.RailroadApiResult component3() {
            return this.operationResult;
        }

        public final List<RFGApiOperation> component4() {
            return this.operationList;
        }

        public final OnCompletedRealtimeRequest copy(RFGRailroadClient.RailroadApiResult railroadApiResult, List<RFGApiRealtime> list, RFGRailroadClient.RailroadApiResult railroadApiResult2, List<RFGApiOperation> list2) {
            Intrinsics.checkParameterIsNotNull(railroadApiResult, "realtimeResult");
            Intrinsics.checkParameterIsNotNull(list, "realtimeList");
            Intrinsics.checkParameterIsNotNull(railroadApiResult2, "operationResult");
            Intrinsics.checkParameterIsNotNull(list2, "operationList");
            return new OnCompletedRealtimeRequest(railroadApiResult, list, railroadApiResult2, list2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof OnCompletedRealtimeRequest)) {
                return false;
            }
            OnCompletedRealtimeRequest onCompletedRealtimeRequest = (OnCompletedRealtimeRequest) obj;
            return Intrinsics.areEqual((Object) this.realtimeResult, (Object) onCompletedRealtimeRequest.realtimeResult) && Intrinsics.areEqual((Object) this.realtimeList, (Object) onCompletedRealtimeRequest.realtimeList) && Intrinsics.areEqual((Object) this.operationResult, (Object) onCompletedRealtimeRequest.operationResult) && Intrinsics.areEqual((Object) this.operationList, (Object) onCompletedRealtimeRequest.operationList);
        }

        public final List<RFGApiOperation> getOperationList() {
            return this.operationList;
        }

        public final RFGRailroadClient.RailroadApiResult getOperationResult() {
            return this.operationResult;
        }

        public final List<RFGApiRealtime> getRealtimeList() {
            return this.realtimeList;
        }

        public final RFGRailroadClient.RailroadApiResult getRealtimeResult() {
            return this.realtimeResult;
        }

        public int hashCode() {
            RFGRailroadClient.RailroadApiResult railroadApiResult = this.realtimeResult;
            int i = 0;
            int hashCode = (railroadApiResult != null ? railroadApiResult.hashCode() : 0) * 31;
            List<RFGApiRealtime> list = this.realtimeList;
            int hashCode2 = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
            RFGRailroadClient.RailroadApiResult railroadApiResult2 = this.operationResult;
            int hashCode3 = (hashCode2 + (railroadApiResult2 != null ? railroadApiResult2.hashCode() : 0)) * 31;
            List<RFGApiOperation> list2 = this.operationList;
            if (list2 != null) {
                i = list2.hashCode();
            }
            return hashCode3 + i;
        }

        public String toString() {
            StringBuilder a = C0681a.m330a("OnCompletedRealtimeRequest(realtimeResult=");
            a.append(this.realtimeResult);
            a.append(", realtimeList=");
            a.append(this.realtimeList);
            a.append(", operationResult=");
            a.append(this.operationResult);
            a.append(", operationList=");
            return C0681a.m325a(a, (List) this.operationList, ")");
        }
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21740k = 3, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.fragment.train.RFGScheduleMapFragment$WhenMappings */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[RFGDef.TrainType.values().length];
            $EnumSwitchMapping$0 = iArr;
            RFGDef.TrainType trainType = RFGDef.TrainType.UP;
            iArr[0] = 1;
            int[] iArr2 = $EnumSwitchMapping$0;
            RFGDef.TrainType trainType2 = RFGDef.TrainType.DOWN;
            iArr2[1] = 2;
        }
    }

    public static final /* synthetic */ Point access$getDisplaySize$p(RFGScheduleMapFragment rFGScheduleMapFragment) {
        Point point = rFGScheduleMapFragment.displaySize;
        if (point == null) {
            Intrinsics.throwUninitializedPropertyAccessException("displaySize");
        }
        return point;
    }

    public static final /* synthetic */ Pair access$getScheduleViewDraggableMinMaxHeight$p(RFGScheduleMapFragment rFGScheduleMapFragment) {
        Pair<Integer, Integer> pair = rFGScheduleMapFragment.scheduleViewDraggableMinMaxHeight;
        if (pair == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scheduleViewDraggableMinMaxHeight");
        }
        return pair;
    }

    public static final /* synthetic */ Point access$getViewSize$p(RFGScheduleMapFragment rFGScheduleMapFragment) {
        Point point = rFGScheduleMapFragment.viewSize;
        if (point == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewSize");
        }
        return point;
    }

    /* access modifiers changed from: private */
    public final void addSearchResultMarker(List<RFGStation> list) {
        RFGGoogleMap rFGGoogleMap;
        Marker addMarker$default;
        clearSearchResultMarker();
        for (RFGStation rFGStation : list) {
            RFGStation rFGStation2 = this.initStation;
            if (!((rFGStation2 != null && rFGStation2.getStationId() == rFGStation.getStationId()) || (rFGGoogleMap = this.googleMapWrapper) == null || (addMarker$default = RFGGoogleMap.addMarker$default(rFGGoogleMap, rFGStation.getLat(), rFGStation.getLon(), Integer.valueOf(R.mipmap.ic_station_red), (String) null, 8, (Object) null)) == null)) {
                addMarker$default.setTag(rFGStation);
                this.searchResultMarkerList.add(addMarker$default);
            }
        }
    }

    private final void asyncGoogleMap() {
        Fragment findFragmentById = getChildFragmentManager().findFragmentById(R.id.mapFragment);
        if (!(findFragmentById instanceof SupportMapFragment)) {
            findFragmentById = null;
        }
        SupportMapFragment supportMapFragment = (SupportMapFragment) findFragmentById;
        if (supportMapFragment != null) {
            supportMapFragment.getMapAsync(this);
            return;
        }
        C1122a.m1599b("[Gym]::Error googleMap is null when called getMapAsync", new Object[0]);
        showErrorFailedGoogleMap();
    }

    private final void changeSchedule(List<RFGTrainDetail> list, Function0<Unit> function0) {
        ListView listView = (ListView) _$_findCachedViewById(C2092R.C2094id.scheduleList);
        Intrinsics.checkExpressionValueIsNotNull(listView, "scheduleList");
        ListAdapter adapter = listView.getAdapter();
        RFGStationScheduleAdapter rFGStationScheduleAdapter = null;
        if (!(adapter instanceof RFGStationScheduleAdapter)) {
            adapter = null;
        }
        RFGStationScheduleAdapter rFGStationScheduleAdapter2 = (RFGStationScheduleAdapter) adapter;
        if (rFGStationScheduleAdapter2 != null) {
            rFGStationScheduleAdapter2.setOnDataSetChangedListener(function0);
        }
        ListView listView2 = (ListView) _$_findCachedViewById(C2092R.C2094id.scheduleList);
        Intrinsics.checkExpressionValueIsNotNull(listView2, "scheduleList");
        ListAdapter adapter2 = listView2.getAdapter();
        if (adapter2 instanceof RFGStationScheduleAdapter) {
            rFGStationScheduleAdapter = adapter2;
        }
        RFGStationScheduleAdapter rFGStationScheduleAdapter3 = rFGStationScheduleAdapter;
        if (rFGStationScheduleAdapter3 != null) {
            rFGStationScheduleAdapter3.updateData(list);
        }
    }

    private final void changeScheduleViewHeightHalfWithAnimation(Function0<Unit> function0) {
        double d = (double) getDisplaySize().y;
        Double.isNaN(d);
        changeScheduleViewHeightWithAnimation(MathKt__MathJVMKt.roundToInt(d * 0.5d), Integer.valueOf(getDefaultMapBottomMargin()), function0);
    }

    static /* synthetic */ void changeScheduleViewHeightHalfWithAnimation$default(RFGScheduleMapFragment rFGScheduleMapFragment, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = null;
        }
        rFGScheduleMapFragment.changeScheduleViewHeightHalfWithAnimation(function0);
    }

    private final void changeScheduleViewHeightWithAnimation(int i, Integer num, Function0<Unit> function0) {
        ValueAnimator valueAnimator;
        boolean z = false;
        PropertyValuesHolder ofInt = PropertyValuesHolder.ofInt("result", new int[]{getScheduleViewHeight(), i});
        if (num == null) {
            valueAnimator = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[]{ofInt});
        } else {
            valueAnimator = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[]{ofInt, PropertyValuesHolder.ofInt("map", new int[]{getMapBottomMargin(), num.intValue()})});
        }
        valueAnimator.addUpdateListener(new RFGScheduleMapFragment$changeScheduleViewHeightWithAnimation$1(this, num));
        valueAnimator.addListener(new RFGScheduleMapFragment$changeScheduleViewHeightWithAnimation$2(function0));
        Intrinsics.checkExpressionValueIsNotNull(valueAnimator, "animator");
        valueAnimator.setDuration(300);
        valueAnimator.start();
        Pair<Integer, Integer> pair = this.scheduleViewDraggableMinMaxHeight;
        if (pair == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scheduleViewDraggableMinMaxHeight");
        }
        if (i <= pair.getFirst().intValue()) {
            z = true;
        }
        changeUpDownToggleWithAnimation(z);
    }

    static /* synthetic */ void changeScheduleViewHeightWithAnimation$default(RFGScheduleMapFragment rFGScheduleMapFragment, int i, Integer num, Function0 function0, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            function0 = null;
        }
        rFGScheduleMapFragment.changeScheduleViewHeightWithAnimation(i, num, function0);
    }

    private final void changeUpDownToggleWithAnimation(boolean z) {
        float f = 180.0f;
        if (z && this.upDownToggleDegrees == 180.0f) {
            return;
        }
        if (z || this.upDownToggleDegrees != 0.0f) {
            float f2 = this.upDownToggleDegrees;
            float f3 = z ? 180.0f : 360.0f;
            if (!z) {
                f = 0.0f;
            }
            this.upDownToggleDegrees = f;
            RotateAnimation rotateAnimation = new RotateAnimation(f2, f3, 1, 0.5f, 1, 0.5f);
            rotateAnimation.setDuration(100);
            rotateAnimation.setFillAfter(true);
            ((ImageView) _$_findCachedViewById(C2092R.C2094id.buttonUpDown)).startAnimation(rotateAnimation);
        }
    }

    /* access modifiers changed from: private */
    public final void clearInitStationMarker() {
        Marker marker = this.initStationMarker;
        if (marker != null) {
            RFGGoogleMap rFGGoogleMap = this.googleMapWrapper;
            if (rFGGoogleMap != null) {
                rFGGoogleMap.removeMarker(CollectionsKt__CollectionsJVMKt.listOf(marker));
            }
            this.initStationMarker = null;
        }
    }

    /* access modifiers changed from: private */
    public final void clearSearchResultMarker() {
        RFGGoogleMap rFGGoogleMap = this.googleMapWrapper;
        if (rFGGoogleMap != null) {
            rFGGoogleMap.removeMarker(this.searchResultMarkerList);
        }
        this.searchResultMarkerList.clear();
    }

    private final void clearTrainMarker() {
        RFGGoogleMap rFGGoogleMap = this.googleMapWrapper;
        if (rFGGoogleMap != null) {
            rFGGoogleMap.removeMarker(this.trainMarkerList);
        }
        this.trainMarkerList.clear();
    }

    private final GoogleMap.OnInfoWindowClickListener createInfoWindowClickListener() {
        return new RFGScheduleMapFragment$createInfoWindowClickListener$1(this);
    }

    private final RFGStation findNearestStation(Location location) {
        Collection<RFGStation> values = RFGTrainData.INSTANCE.getStationMap().values();
        Intrinsics.checkExpressionValueIsNotNull(values, "RFGTrainData.stationMap.values");
        RFGStation rFGStation = null;
        float f = 0.0f;
        for (RFGStation rFGStation2 : values) {
            float distanceTo = location.distanceTo(rFGStation2.getLocation());
            if (distanceTo < f || f == 0.0f) {
                rFGStation = rFGStation2;
                f = distanceTo;
            }
        }
        return rFGStation;
    }

    private final int getDefaultMapBottomMargin() {
        Resources resources;
        Context context = getContext();
        if (context == null || (resources = context.getResources()) == null) {
            return 0;
        }
        return resources.getDimensionPixelSize(R.dimen.map_bottom_margin);
    }

    private final Point getDisplaySize() {
        Point point = this.displaySize;
        if (point != null) {
            if (point == null) {
                Intrinsics.throwUninitializedPropertyAccessException("displaySize");
            }
            return point;
        }
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return new Point(0, 0);
        }
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity ?: return Point(0, 0)");
        WindowManager windowManager = activity.getWindowManager();
        Intrinsics.checkExpressionValueIsNotNull(windowManager, "activity.windowManager");
        Display defaultDisplay = windowManager.getDefaultDisplay();
        Point point2 = new Point();
        defaultDisplay.getSize(point2);
        return point2;
    }

    /* access modifiers changed from: private */
    public final int getMapBottomMargin() {
        FrameLayout frameLayout = (FrameLayout) _$_findCachedViewById(C2092R.C2094id.mapBase);
        Intrinsics.checkExpressionValueIsNotNull(frameLayout, "mapBase");
        ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
        if (layoutParams != null) {
            return ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    /* access modifiers changed from: private */
    public final int getScheduleViewHeight() {
        LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(C2092R.C2094id.searchResult);
        Intrinsics.checkExpressionValueIsNotNull(linearLayout, "searchResult");
        return linearLayout.getLayoutParams().height;
    }

    private final void getViewSize() {
        RelativeLayout relativeLayout = (RelativeLayout) _$_findCachedViewById(C2092R.C2094id.viewBase);
        Intrinsics.checkExpressionValueIsNotNull(relativeLayout, "viewBase");
        if (relativeLayout.getHeight() > 0) {
            RelativeLayout relativeLayout2 = (RelativeLayout) _$_findCachedViewById(C2092R.C2094id.viewBase);
            Intrinsics.checkExpressionValueIsNotNull(relativeLayout2, "viewBase");
            if (relativeLayout2.getWidth() > 0) {
                RelativeLayout relativeLayout3 = (RelativeLayout) _$_findCachedViewById(C2092R.C2094id.viewBase);
                Intrinsics.checkExpressionValueIsNotNull(relativeLayout3, "viewBase");
                int width = relativeLayout3.getWidth();
                RelativeLayout relativeLayout4 = (RelativeLayout) _$_findCachedViewById(C2092R.C2094id.viewBase);
                Intrinsics.checkExpressionValueIsNotNull(relativeLayout4, "viewBase");
                this.viewSize = new Point(width, relativeLayout4.getHeight());
                return;
            }
        }
        RelativeLayout relativeLayout5 = (RelativeLayout) _$_findCachedViewById(C2092R.C2094id.viewBase);
        Intrinsics.checkExpressionValueIsNotNull(relativeLayout5, "viewBase");
        relativeLayout5.getViewTreeObserver().addOnGlobalLayoutListener(new RFGScheduleMapFragment$getViewSize$1(this));
    }

    /* access modifiers changed from: private */
    public final void loadInitStation() {
        RFGStation findNearestStation;
        this.initStationLoadingHandler.removeCallbacksAndMessages((Object) null);
        Location loadLocation = SilentLogOperation.Companion.getInstance().loadLocation();
        if (!(loadLocation == null || (findNearestStation = findNearestStation(loadLocation)) == null)) {
            this.initStation = findNearestStation;
            if (this.googleMapWrapper != null && this.searchResultMarkerList.isEmpty()) {
                showInitStation();
            }
        }
        this.initStationLoadingHandler.postDelayed(new RFGScheduleMapFragment$loadInitStation$2(this), INIT_STATION_LOADING_INTERVAL);
    }

    /* access modifiers changed from: private */
    public final boolean onDraggableHandleTouchListener(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.scheduleViewDragStart = true;
            return true;
        } else if (actionMasked == 1) {
            this.scheduleViewDragStart = false;
            return true;
        } else if (actionMasked != 2) {
            return false;
        } else {
            if (this.scheduleViewDragStart) {
                int roundToInt = MathKt__MathJVMKt.roundToInt(((float) getDisplaySize().y) - motionEvent.getRawY());
                Pair<Integer, Integer> pair = this.scheduleViewDraggableMinMaxHeight;
                if (pair == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("scheduleViewDraggableMinMaxHeight");
                }
                int intValue = pair.component1().intValue();
                int intValue2 = pair.component2().intValue();
                if (roundToInt > intValue && roundToInt < intValue2) {
                    setScheduleViewHeight(roundToInt);
                } else if (roundToInt < intValue && getScheduleViewHeight() > intValue) {
                    setScheduleViewHeight(intValue);
                    changeUpDownToggleWithAnimation(true);
                } else if (roundToInt > intValue2 && getScheduleViewHeight() < intValue2) {
                    setScheduleViewHeight(intValue2);
                }
                changeUpDownToggleWithAnimation(false);
            }
            return true;
        }
    }

    /* access modifiers changed from: private */
    public final boolean onMarkerClick(Marker marker) {
        Object tag = marker.getTag();
        RFGRealtime rFGRealtime = null;
        if (!(tag instanceof RFGStation)) {
            tag = null;
        }
        RFGStation rFGStation = (RFGStation) tag;
        if (rFGStation != null) {
            RFGAnalyticsManager.INSTANCE.sendEvent("200", "200f", String.valueOf(rFGStation.getStationId()));
            selectStation(rFGStation, true);
            return true;
        }
        Object tag2 = marker.getTag();
        if (tag2 instanceof RFGRealtime) {
            rFGRealtime = tag2;
        }
        RFGRealtime rFGRealtime2 = rFGRealtime;
        if (rFGRealtime2 == null) {
            return false;
        }
        this.infoWindowShownTrain = rFGRealtime2.getTrainNo();
        return false;
    }

    /* access modifiers changed from: private */
    public final void onTapUpDownToggle() {
        int scheduleViewHeight = getScheduleViewHeight();
        Pair<Integer, Integer> pair = this.scheduleViewDraggableMinMaxHeight;
        if (pair == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scheduleViewDraggableMinMaxHeight");
        }
        if (scheduleViewHeight == pair.getFirst().intValue()) {
            changeScheduleViewHeightHalfWithAnimation((Function0<Unit>) null);
            return;
        }
        Pair<Integer, Integer> pair2 = this.scheduleViewDraggableMinMaxHeight;
        if (pair2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scheduleViewDraggableMinMaxHeight");
        }
        changeScheduleViewHeightWithAnimation(pair2.getFirst().intValue(), (Integer) null, (Function0<Unit>) null);
    }

    /* access modifiers changed from: private */
    public final void resetScheduleViewHeight(boolean z) {
        if (z) {
            changeScheduleViewHeightWithAnimation(0, 0, (Function0<Unit>) null);
            return;
        }
        setScheduleViewHeight(0);
        setMapBottomMargin(0);
        View view = getView();
        if (view != null) {
            view.invalidate();
        }
    }

    static /* synthetic */ void resetScheduleViewHeight$default(RFGScheduleMapFragment rFGScheduleMapFragment, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        rFGScheduleMapFragment.resetScheduleViewHeight(z);
    }

    /* access modifiers changed from: private */
    public final void search(RFGStation rFGStation) {
        clearInitStationMarker();
        clearSearchResultMarker();
        addSearchResultMarker(CollectionsKt__CollectionsJVMKt.listOf(rFGStation));
        selectStation(rFGStation, true);
    }

    private final void selectStation(RFGStation rFGStation, boolean z) {
        if ((!Intrinsics.areEqual((Object) ((RFGAutoCompletedEditText) _$_findCachedViewById(C2092R.C2094id.stationName)).getText(), (Object) rFGStation.getName())) && z) {
            ((RFGAutoCompletedEditText) _$_findCachedViewById(C2092R.C2094id.stationName)).setText(rFGStation.getName());
        }
        showStationSchedule(new RFGStationDetail.Builder(rFGStation).build());
        changeScheduleViewHeightHalfWithAnimation$default(this, (Function0) null, 1, (Object) null);
        C1122a.m1596a("selectStation-moveMapCamera", new Object[0]);
        RFGGoogleMap rFGGoogleMap = this.googleMapWrapper;
        if (rFGGoogleMap != null) {
            rFGGoogleMap.moveMapCamera(rFGStation.getLat(), rFGStation.getLon(), true);
        }
    }

    static /* synthetic */ void selectStation$default(RFGScheduleMapFragment rFGScheduleMapFragment, RFGStation rFGStation, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        rFGScheduleMapFragment.selectStation(rFGStation, z);
    }

    /* access modifiers changed from: private */
    public final void setMapBottomMargin(int i) {
        if (((FrameLayout) _$_findCachedViewById(C2092R.C2094id.mapBase)) != null) {
            FrameLayout frameLayout = (FrameLayout) _$_findCachedViewById(C2092R.C2094id.mapBase);
            Intrinsics.checkExpressionValueIsNotNull(frameLayout, "mapBase");
            ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
            if (layoutParams != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.bottomMargin = i;
                FrameLayout frameLayout2 = (FrameLayout) _$_findCachedViewById(C2092R.C2094id.mapBase);
                Intrinsics.checkExpressionValueIsNotNull(frameLayout2, "mapBase");
                frameLayout2.setLayoutParams(marginLayoutParams);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        }
    }

    /* access modifiers changed from: private */
    public final void setScheduleViewHeight(int i) {
        if (((LinearLayout) _$_findCachedViewById(C2092R.C2094id.searchResult)) != null) {
            LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(C2092R.C2094id.searchResult);
            Intrinsics.checkExpressionValueIsNotNull(linearLayout, "searchResult");
            ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
            layoutParams.height = i;
            LinearLayout linearLayout2 = (LinearLayout) _$_findCachedViewById(C2092R.C2094id.searchResult);
            Intrinsics.checkExpressionValueIsNotNull(linearLayout2, "searchResult");
            linearLayout2.setLayoutParams(layoutParams);
        }
    }

    private final void setUpAutoCompleted() {
        Context context = getContext();
        if (context != null) {
            Intrinsics.checkExpressionValueIsNotNull(context, "context ?: return");
            Collection<RFGStation> values = RFGTrainData.INSTANCE.getStationMap().values();
            Intrinsics.checkExpressionValueIsNotNull(values, "RFGTrainData.stationMap.values");
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(values, 10));
            for (RFGStation rFGStation : values) {
                arrayList.add(new RFGAutoCompletedAdapter.RFGHintData(rFGStation.getName(), CollectionsKt__CollectionsKt.listOf(rFGStation.getName(), rFGStation.getNameEn(), rFGStation.getNameKana())));
            }
            ((RFGAutoCompletedEditText) _$_findCachedViewById(C2092R.C2094id.stationName)).setHintList(arrayList, CollectionsKt__CollectionsJVMKt.listOf(context.getString(R.string.sanriku_see_station_list)));
            ((RFGAutoCompletedEditText) _$_findCachedViewById(C2092R.C2094id.stationName)).setText("");
            ((RFGAutoCompletedEditText) _$_findCachedViewById(C2092R.C2094id.stationName)).setOnDoneListener(new RFGScheduleMapFragment$setUpAutoCompleted$1(this));
        }
    }

    private final void setUpScheduleView() {
        Context context = getContext();
        if (context != null) {
            Intrinsics.checkExpressionValueIsNotNull(context, "context ?: return");
            ListView listView = (ListView) _$_findCachedViewById(C2092R.C2094id.scheduleList);
            Intrinsics.checkExpressionValueIsNotNull(listView, "scheduleList");
            listView.setAdapter(new RFGStationScheduleAdapter(context, new ArrayList(), 0, 4, (DefaultConstructorMarker) null));
            ((FrameLayout) _$_findCachedViewById(C2092R.C2094id.draggableHandle)).setOnTouchListener(new RFGScheduleMapFragment$setUpScheduleView$1(this));
            ((ImageView) _$_findCachedViewById(C2092R.C2094id.buttonUpDown)).setOnClickListener(new RFGScheduleMapFragment$setUpScheduleView$2(this));
            ((ImageView) _$_findCachedViewById(C2092R.C2094id.buttonClose)).setOnClickListener(new RFGScheduleMapFragment$setUpScheduleView$3(this));
        }
    }

    private final void showErrorFailedGoogleMap() {
        showErrorDialog(R.string.sanriku_cannot_ready_google_map, new RFGScheduleMapFragment$showErrorFailedGoogleMap$1(this));
    }

    private final void showInitStation() {
        RFGStation rFGStation = this.initStation;
        if (rFGStation != null) {
            clearInitStationMarker();
            RFGGoogleMap rFGGoogleMap = this.googleMapWrapper;
            Marker addMarker$default = rFGGoogleMap != null ? RFGGoogleMap.addMarker$default(rFGGoogleMap, rFGStation.getLat(), rFGStation.getLon(), Integer.valueOf(R.mipmap.ic_station_blue), (String) null, 8, (Object) null) : null;
            this.initStationMarker = addMarker$default;
            if (addMarker$default != null) {
                addMarker$default.setTag(rFGStation);
            }
            selectStation(rFGStation, false);
        }
    }

    private final void showStationSchedule(RFGStationDetail rFGStationDetail) {
        changeSchedule(rFGStationDetail.getScheduleList(), new RFGScheduleMapFragment$showStationSchedule$1(this, rFGStationDetail));
    }

    private final void showTrainMarker() {
        int i;
        Marker addMarker$default;
        if (!(!this.trainMarkerList.isEmpty()) && !this.realtimeTrainList.isEmpty()) {
            for (RFGRealtime rFGRealtime : this.realtimeTrainList) {
                String trainNo = rFGRealtime.getTrainNo();
                RFGTrain rFGTrain = RFGTrainData.INSTANCE.getTrainMap().get(trainNo);
                if (rFGTrain != null) {
                    Intrinsics.checkExpressionValueIsNotNull(rFGTrain, "RFGTrainData.trainMap[trainId] ?: return@forEach");
                    double lat = rFGRealtime.getLat();
                    double lon = rFGRealtime.getLon();
                    int ordinal = rFGTrain.getTrainType().ordinal();
                    if (ordinal == 0) {
                        i = R.mipmap.ic_train_up;
                    } else if (ordinal == 1) {
                        i = R.mipmap.ic_train_down;
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                    RFGGoogleMap rFGGoogleMap = this.googleMapWrapper;
                    if (!(rFGGoogleMap == null || (addMarker$default = RFGGoogleMap.addMarker$default(rFGGoogleMap, lat, lon, Integer.valueOf(i), (String) null, 8, (Object) null)) == null)) {
                        this.trainMarkerList.add(addMarker$default);
                        addMarker$default.setTag(rFGRealtime);
                        if (Intrinsics.areEqual((Object) trainNo, (Object) this.infoWindowShownTrain)) {
                            addMarker$default.showInfoWindow();
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public final void showTrainScheduleDialog(String str, int i) {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null) {
            Intrinsics.checkExpressionValueIsNotNull(fragmentManager, "fragmentManager ?: return");
            RFGTrainScheduleDialog.Companion.newInstance(str, i).show(fragmentManager, "RFGTrainScheduleDialog");
        }
    }

    /* access modifiers changed from: private */
    @SuppressLint({"CheckResult"})
    public final void startRequestRealtime() {
        C1126c.m1638c().mo21908c(this);
        C1126c.m1638c().mo21907b(this);
        C1714r.m2411a(RFGRailroadClient.Companion.getINSTANCE().getRealtime(), RFGRailroadClient.Companion.getINSTANCE().getOperation(), RFGScheduleMapFragment$startRequestRealtime$1.INSTANCE).mo27434b(C1683a.m2378b()).mo27429a(C1721a.m2428a()).mo27432a(RFGScheduleMapFragment$startRequestRealtime$2.INSTANCE, RFGScheduleMapFragment$startRequestRealtime$3.INSTANCE);
    }

    private final void stopRequestRealtime() {
        C1126c.m1638c().mo21908c(this);
        this.realTimeRequestHandler.removeCallbacksAndMessages((Object) null);
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
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    public String actionBarTitle() {
        String string = getString(R.string.sanriku_schedule_map_title);
        Intrinsics.checkExpressionValueIsNotNull(string, "getString(R.string.sanriku_schedule_map_title)");
        return string;
    }

    public RFGDef.FragType fragmentType() {
        return RFGDef.FragType.ScheduleMap;
    }

    public int layoutId() {
        return R.layout.fragment_sanriku_schedule_map;
    }

    public void onAttach(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        super.onAttach(context);
        if (context instanceof OnScheduleMapFragmentListener) {
            this.scheduleMapFragmentListener = (OnScheduleMapFragmentListener) context;
            return;
        }
        throw new RuntimeException(context + " must implement OnScheduleMapFragmentListener");
    }

    @C1129m
    public final void onCompletedRealtimeRequest(OnCompletedRealtimeRequest onCompletedRealtimeRequest) {
        Intrinsics.checkParameterIsNotNull(onCompletedRealtimeRequest, "event");
        C1122a.m1596a("[Gym]::Debug recv onCompletedRealtimeRequest. " + onCompletedRealtimeRequest, new Object[0]);
        if (onCompletedRealtimeRequest.getRealtimeResult() == RFGRailroadClient.RailroadApiResult.SUCCESS) {
            List<RFGApiRealtime> realtimeList = onCompletedRealtimeRequest.getRealtimeList();
            ArrayList arrayList = new ArrayList();
            for (RFGApiRealtime builder : realtimeList) {
                RFGRealtime build = new RFGRealtime.Builder(builder, onCompletedRealtimeRequest.getOperationList()).build();
                if (build != null) {
                    arrayList.add(build);
                }
            }
            this.realtimeTrainList.clear();
            this.realtimeTrainList.addAll(arrayList);
            clearTrainMarker();
            showTrainMarker();
        } else {
            StringBuilder a = C0681a.m330a("[Gym]::Error Railroad realtime failed. ");
            a.append(onCompletedRealtimeRequest.getRealtimeResult());
            a.append(", ");
            a.append(onCompletedRealtimeRequest.getOperationResult());
            C1122a.m1599b(a.toString(), new Object[0]);
        }
        C1126c.m1638c().mo21908c(this);
        this.realTimeRequestHandler.removeCallbacksAndMessages((Object) null);
        this.realTimeRequestHandler.postDelayed(new RFGScheduleMapFragment$onCompletedRealtimeRequest$1(this), REALTIME_UPDATE_INTERVAL);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.param1 = arguments.getString(ARG_PARAM1);
            this.param2 = arguments.getString(ARG_PARAM2);
        }
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void onDetach() {
        stopRequestRealtime();
        this.scheduleMapFragmentListener = null;
        this.infoWindowShownTrain = null;
        this.initStationLoadingHandler.removeCallbacksAndMessages((Object) null);
        super.onDetach();
    }

    public void onMapReady(GoogleMap googleMap) {
        C1122a.m1596a("onMapReady", new Object[0]);
        if (googleMap != null) {
            this.googleMapWrapper = new RFGGoogleMap(googleMap);
            Context requireContext = requireContext();
            Intrinsics.checkExpressionValueIsNotNull(requireContext, "requireContext()");
            googleMap.setInfoWindowAdapter(new RFGRealtimeInfoWindow(requireContext));
            googleMap.setOnInfoWindowClickListener(createInfoWindowClickListener());
            if (((RFGAutoCompletedEditText) _$_findCachedViewById(C2092R.C2094id.stationName)).getText().length() == 0) {
                loadInitStation();
            } else {
                RFGStation findStation = RFGTrainData.INSTANCE.findStation(((RFGAutoCompletedEditText) _$_findCachedViewById(C2092R.C2094id.stationName)).getText());
                if (findStation != null) {
                    StringBuilder a = C0681a.m330a("loadLocation-moveMapCamera(");
                    a.append(findStation.getName());
                    a.append(')');
                    C1122a.m1596a(a.toString(), new Object[0]);
                    RFGGoogleMap rFGGoogleMap = this.googleMapWrapper;
                    if (rFGGoogleMap != null) {
                        RFGGoogleMap.moveMapCamera$default(rFGGoogleMap, findStation.getLat(), findStation.getLon(), false, 4, (Object) null);
                    }
                }
            }
            showTrainMarker();
            googleMap.setOnMarkerClickListener(new RFGScheduleMapFragment$onMapReady$2(this));
            googleMap.setPadding(0, getResources().getDimensionPixelSize(R.dimen.google_map_top_padding), 0, 0);
            googleMap.setMyLocationEnabled(true);
            UiSettings uiSettings = googleMap.getUiSettings();
            Intrinsics.checkExpressionValueIsNotNull(uiSettings, "googleMap.uiSettings");
            uiSettings.setMyLocationButtonEnabled(true);
            UiSettings uiSettings2 = googleMap.getUiSettings();
            Intrinsics.checkExpressionValueIsNotNull(uiSettings2, "googleMap.uiSettings");
            uiSettings2.setZoomControlsEnabled(true);
            UiSettings uiSettings3 = googleMap.getUiSettings();
            Intrinsics.checkExpressionValueIsNotNull(uiSettings3, "googleMap.uiSettings");
            uiSettings3.setZoomGesturesEnabled(true);
            UiSettings uiSettings4 = googleMap.getUiSettings();
            Intrinsics.checkExpressionValueIsNotNull(uiSettings4, "googleMap.uiSettings");
            uiSettings4.setCompassEnabled(true);
            UiSettings uiSettings5 = googleMap.getUiSettings();
            Intrinsics.checkExpressionValueIsNotNull(uiSettings5, "googleMap.uiSettings");
            uiSettings5.setMapToolbarEnabled(false);
            UiSettings uiSettings6 = googleMap.getUiSettings();
            Intrinsics.checkExpressionValueIsNotNull(uiSettings6, "googleMap.uiSettings");
            uiSettings6.setTiltGesturesEnabled(true);
            return;
        }
        C1122a.m1599b("[Gym]::Error googleMap is null in onMapReady", new Object[0]);
        showErrorFailedGoogleMap();
    }

    public void onPause() {
        super.onPause();
        stopRequestRealtime();
    }

    public void onResume() {
        super.onResume();
        startRequestRealtime();
    }

    public void onViewStateRestored(Bundle bundle) {
        super.onViewStateRestored(bundle);
        loadInitStation();
        getViewSize();
        asyncGoogleMap();
        setUpAutoCompleted();
        setUpScheduleView();
        boolean z = true;
        resetScheduleViewHeight$default(this, false, 1, (Object) null);
        String str = this.param2;
        if (str == null) {
            str = "";
        }
        if (str.length() <= 0) {
            z = false;
        }
        if (z) {
            search(str);
            this.param2 = "";
            Bundle arguments = getArguments();
            if (arguments != null) {
                arguments.putString(ARG_PARAM2, "");
            }
        }
    }

    public String screenId() {
        return "200";
    }

    public final void search(String str) {
        Intrinsics.checkParameterIsNotNull(str, "searchText");
        RFGStation findStation = RFGTrainData.INSTANCE.findStation(str);
        if (findStation != null) {
            search(findStation);
        }
    }
}
