package p043jp.reifrontier.gym.fragment.train;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import com.google.android.gms.analytics.ecommerce.Promotion;
import java.util.Collection;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p043jp.reifrontier.gym.C2092R;
import p043jp.reifrontier.gym.RFGDef;
import p043jp.reifrontier.gym.data.train.RFGStation;
import p043jp.reifrontier.gym.data.train.RFGTrainData;
import p043jp.reifrontier.gym.fragment.RFGFragmentBase;
import p043jp.reifrontier.gym.p044ui.adapter.RFGStationAdapter;
import p043jp.reifrontier.sanriku.R;
import p043jp.reifrontier.silentlogsdkandroid.SilentLogOperation;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001c2\u00020\u0001:\u0002\u001c\u001dB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\b\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\n\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0012\u0010\u0013\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0010H\u0016J\u001a\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u001a\u001a\u00020\u0004H\u0016J\b\u0010\u001b\u001a\u00020\u0010H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, mo21739d2 = {"Ljp/reifrontier/gym/fragment/train/RFGStationFragment;", "Ljp/reifrontier/gym/fragment/RFGFragmentBase;", "()V", "param1", "", "param2", "stationFragmentListener", "Ljp/reifrontier/gym/fragment/train/RFGStationFragment$OnStationFragmentListener;", "actionBarTitle", "fragmentType", "Ljp/reifrontier/gym/RFGDef$FragType;", "getNearestStation", "Ljp/reifrontier/gym/data/train/RFGStation;", "layoutId", "", "onAttach", "", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDetach", "onViewCreated", "view", "Landroid/view/View;", "screenId", "setUpStation", "Companion", "OnStationFragmentListener", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.fragment.train.RFGStationFragment */
public final class RFGStationFragment extends RFGFragmentBase {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final float MAX_NEAREST_DISTANCE = 10000.0f;
    private HashMap _$_findViewCache;
    private String param1;
    private String param2;
    /* access modifiers changed from: private */
    public OnStationFragmentListener stationFragmentListener;

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, mo21739d2 = {"Ljp/reifrontier/gym/fragment/train/RFGStationFragment$OnStationFragmentListener;", "Ljp/reifrontier/gym/fragment/RFGFragmentBase$OnFragmentBaseListener;", "onSelectedStation", "", "station", "Ljp/reifrontier/gym/data/train/RFGStation;", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.fragment.train.RFGStationFragment$OnStationFragmentListener */
    public interface OnStationFragmentListener extends RFGFragmentBase.OnFragmentBaseListener {
        void onSelectedStation(RFGStation rFGStation);
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\f"}, mo21739d2 = {"Ljp/reifrontier/gym/fragment/train/RFGStationFragment$Companion;", "", "()V", "ARG_PARAM1", "", "ARG_PARAM2", "MAX_NEAREST_DISTANCE", "", "newInstance", "Ljp/reifrontier/gym/fragment/train/RFGStationFragment;", "param1", "param2", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.fragment.train.RFGStationFragment$Companion */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RFGStationFragment newInstance(String str, String str2) {
            Intrinsics.checkParameterIsNotNull(str, RFGStationFragment.ARG_PARAM1);
            Intrinsics.checkParameterIsNotNull(str2, RFGStationFragment.ARG_PARAM2);
            RFGStationFragment rFGStationFragment = new RFGStationFragment();
            Bundle bundle = new Bundle();
            bundle.putString(RFGStationFragment.ARG_PARAM1, str);
            bundle.putString(RFGStationFragment.ARG_PARAM2, str2);
            rFGStationFragment.setArguments(bundle);
            return rFGStationFragment;
        }
    }

    private final RFGStation getNearestStation() {
        Location loadLocation = SilentLogOperation.Companion.getInstance().loadLocation();
        if (loadLocation == null) {
            return null;
        }
        float f = -1.0f;
        Collection<RFGStation> values = RFGTrainData.INSTANCE.getStationMap().values();
        Intrinsics.checkExpressionValueIsNotNull(values, "RFGTrainData.stationMap.values");
        RFGStation rFGStation = null;
        for (RFGStation rFGStation2 : values) {
            Location location = new Location("gym");
            location.setLatitude(rFGStation2.getLat());
            location.setLongitude(rFGStation2.getLon());
            float distanceTo = loadLocation.distanceTo(location);
            if (f < 0.0f || distanceTo < f) {
                rFGStation = rFGStation2;
                f = distanceTo;
            }
        }
        if (f > MAX_NEAREST_DISTANCE) {
            return null;
        }
        return rFGStation;
    }

    private final void setUpStation() {
        Context context = getContext();
        if (context != null) {
            Intrinsics.checkExpressionValueIsNotNull(context, "context ?: return");
            RFGStationAdapter rFGStationAdapter = new RFGStationAdapter(context, getNearestStation(), 0, 4, (DefaultConstructorMarker) null);
            ListView listView = (ListView) _$_findCachedViewById(C2092R.C2094id.stationList);
            Intrinsics.checkExpressionValueIsNotNull(listView, "stationList");
            listView.setAdapter(rFGStationAdapter);
            ((ListView) _$_findCachedViewById(C2092R.C2094id.stationList)).setSelection(rFGStationAdapter.getNearestPosition());
            ((ListView) _$_findCachedViewById(C2092R.C2094id.stationList)).setOnItemClickListener(new RFGStationFragment$setUpStation$1(this, rFGStationAdapter));
        }
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
        return RFGDef.FragType.StationList;
    }

    public int layoutId() {
        return R.layout.fragment_sanriku_station;
    }

    public void onAttach(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        super.onAttach(context);
        if (context instanceof OnStationFragmentListener) {
            this.stationFragmentListener = (OnStationFragmentListener) context;
            return;
        }
        throw new RuntimeException(context + " must implement OnStationFragmentListener");
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
        this.stationFragmentListener = null;
        super.onDetach();
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(view, Promotion.ACTION_VIEW);
        super.onViewCreated(view, bundle);
        setUpStation();
    }

    public String screenId() {
        return "210";
    }
}
