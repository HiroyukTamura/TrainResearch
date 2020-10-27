package p043jp.reifrontier.gym.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.analytics.ecommerce.Promotion;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;
import p043jp.reifrontier.gym.C2092R;
import p043jp.reifrontier.gym.RFGDef;
import p043jp.reifrontier.gym.data.analytics.RFGAnalyticsManager;
import p043jp.reifrontier.gym.domain.api.RFGPoint;
import p043jp.reifrontier.gym.domain.api.RFGPointHistory;
import p043jp.reifrontier.gym.domain.app.RFGSetting;
import p043jp.reifrontier.gym.fragment.RFGFragmentBase;
import p043jp.reifrontier.gym.p044ui.adapter.RFGPointHistoryAdapter;
import p043jp.reifrontier.gym.p044ui.adapter.RFGSettingAdapter;
import p043jp.reifrontier.gym.util.RFGUtilsKt;
import p043jp.reifrontier.sanriku.R;
import p043jp.reifrontier.silentlogsdkandroid.utils.RFLDailyUtilsKt;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 (2\u00020\u0001:\u0002()B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0012\u0010\u0018\u001a\u00020\u00122\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J&\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010!\u001a\u00020\u0012H\u0016J\b\u0010\"\u001a\u00020\u0012H\u0016J\b\u0010#\u001a\u00020\u0012H\u0016J\b\u0010$\u001a\u00020\u0012H\u0016J\u001a\u0010%\u001a\u00020\u00122\u0006\u0010&\u001a\u00020\u001c2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010'\u001a\u00020\u0012H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, mo21739d2 = {"Ljp/reifrontier/gym/fragment/RFGPointFragment;", "Landroidx/fragment/app/Fragment;", "()V", "mAdapter", "Ljp/reifrontier/gym/ui/adapter/RFGPointHistoryAdapter;", "mLayoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "mListener", "Ljp/reifrontier/gym/fragment/RFGPointFragment$OnPointListener;", "mParam1", "", "mParam2", "mPointHistoryItem", "", "", "mRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "bind", "", "pointHistory", "Ljp/reifrontier/gym/domain/api/RFGPointHistory;", "onAttach", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroyView", "onDetach", "onResume", "onStart", "onViewCreated", "view", "setRecyclerViewLayoutManager", "Companion", "OnPointListener", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.fragment.RFGPointFragment */
public final class RFGPointFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private HashMap _$_findViewCache;
    private RFGPointHistoryAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private OnPointListener mListener;
    private String mParam1;
    private String mParam2;
    private List<? extends Object> mPointHistoryItem = CollectionsKt__CollectionsKt.emptyList();
    private RecyclerView mRecyclerView;

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, mo21739d2 = {"Ljp/reifrontier/gym/fragment/RFGPointFragment$OnPointListener;", "Ljp/reifrontier/gym/fragment/RFGFragmentBase$OnFragmentBaseListener;", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.fragment.RFGPointFragment$OnPointListener */
    public interface OnPointListener extends RFGFragmentBase.OnFragmentBaseListener {
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, mo21739d2 = {"Ljp/reifrontier/gym/fragment/RFGPointFragment$Companion;", "", "()V", "ARG_PARAM1", "", "ARG_PARAM2", "newInstance", "Ljp/reifrontier/gym/fragment/RFGPointFragment;", "param1", "param2", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.fragment.RFGPointFragment$Companion */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RFGPointFragment newInstance(String str, String str2) {
            Intrinsics.checkParameterIsNotNull(str, RFGPointFragment.ARG_PARAM1);
            Intrinsics.checkParameterIsNotNull(str2, RFGPointFragment.ARG_PARAM2);
            RFGPointFragment rFGPointFragment = new RFGPointFragment();
            Bundle bundle = new Bundle();
            bundle.putString(RFGPointFragment.ARG_PARAM1, str);
            bundle.putString(RFGPointFragment.ARG_PARAM2, str2);
            rFGPointFragment.setArguments(bundle);
            return rFGPointFragment;
        }
    }

    private final void setRecyclerViewLayoutManager() {
        int i;
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null) {
            Intrinsics.throwNpe();
        }
        if (recyclerView.getLayoutManager() != null) {
            RecyclerView recyclerView2 = this.mRecyclerView;
            if (recyclerView2 == null) {
                Intrinsics.throwNpe();
            }
            RecyclerView.LayoutManager layoutManager = recyclerView2.getLayoutManager();
            if (layoutManager != null) {
                i = ((LinearLayoutManager) layoutManager).findFirstCompletelyVisibleItemPosition();
            } else {
                throw new TypeCastException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            }
        } else {
            i = 0;
        }
        this.mLayoutManager = new LinearLayoutManager(getActivity());
        RecyclerView recyclerView3 = this.mRecyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwNpe();
        }
        recyclerView3.setLayoutManager(this.mLayoutManager);
        RecyclerView recyclerView4 = this.mRecyclerView;
        if (recyclerView4 == null) {
            Intrinsics.throwNpe();
        }
        recyclerView4.scrollToPosition(i);
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

    public final void bind(RFGPointHistory rFGPointHistory) {
        Intrinsics.checkParameterIsNotNull(rFGPointHistory, "pointHistory");
        ArrayList arrayList = new ArrayList();
        ArrayList<RFGPoint> arrayList2 = new ArrayList<>();
        if (!rFGPointHistory.getAcquisitionPoints().isEmpty()) {
            arrayList2.addAll(rFGPointHistory.getAcquisitionPoints());
        }
        if (!rFGPointHistory.getConsumptionPoints().isEmpty()) {
            arrayList2.addAll(rFGPointHistory.getConsumptionPoints());
        }
        HashMap hashMap = new HashMap();
        for (RFGPoint rFGPoint : arrayList2) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.JAPANESE);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            Date parse = simpleDateFormat.parse(rFGPoint.getCreatedAt());
            Intrinsics.checkExpressionValueIsNotNull(parse, "sdFormat.parse(result.createdAt)");
            String a = C0681a.m328a(new Object[]{Long.valueOf(RFLDailyUtilsKt.start(parse).getTime() / ((long) 1000))}, 1, "%s", "java.lang.String.format(this, *args)");
            ArrayList arrayList3 = new ArrayList();
            if (hashMap.get(a) != null) {
                List list = (List) hashMap.get(a);
                if (list == null) {
                    Intrinsics.throwNpe();
                }
                if (!list.isEmpty()) {
                    arrayList3.addAll(list);
                }
            }
            arrayList3.add(rFGPoint);
            hashMap.put(a, arrayList3);
        }
        Set keySet = hashMap.keySet();
        Intrinsics.checkExpressionValueIsNotNull(keySet, "data.keys");
        for (String str : CollectionsKt___CollectionsKt.sortedWith(CollectionsKt___CollectionsKt.toList(keySet), RFGPointFragment$bind$sortKey$1.INSTANCE)) {
            Intrinsics.checkExpressionValueIsNotNull(str, "key");
            arrayList.add(new RFGSetting(RFGSettingAdapter.SettingViewType.SECTION, RFGUtilsKt.formaaat11$default(new Date(((long) Integer.parseInt(str)) * 1000), "yyyy年M月d日", (String) null, 2, (Object) null), false, false, 0, ""));
            Object obj = hashMap.get(str);
            if (obj == null) {
                Intrinsics.throwNpe();
            }
            Intrinsics.checkExpressionValueIsNotNull(obj, "data[key]!!");
            arrayList.addAll(CollectionsKt___CollectionsKt.sortedWith((List) obj, RFGPointFragment$bind$sort$1.INSTANCE));
        }
        this.mPointHistoryItem = arrayList;
        RFGPointHistoryAdapter rFGPointHistoryAdapter = this.mAdapter;
        if (rFGPointHistoryAdapter == null) {
            Intrinsics.throwNpe();
        }
        rFGPointHistoryAdapter.setHistory(arrayList);
        RFGPointHistoryAdapter rFGPointHistoryAdapter2 = this.mAdapter;
        if (rFGPointHistoryAdapter2 == null) {
            Intrinsics.throwNpe();
        }
        rFGPointHistoryAdapter2.notifyDataSetChanged();
    }

    public void onAttach(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        super.onAttach(context);
        if (context instanceof OnPointListener) {
            this.mListener = (OnPointListener) context;
            return;
        }
        throw new RuntimeException(context + " must implement OnPointListener");
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            Bundle arguments = getArguments();
            if (arguments == null) {
                Intrinsics.throwNpe();
            }
            this.mParam1 = arguments.getString(ARG_PARAM1);
            Bundle arguments2 = getArguments();
            if (arguments2 == null) {
                Intrinsics.throwNpe();
            }
            this.mParam2 = arguments2.getString(ARG_PARAM2);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_point, viewGroup, false);
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.mRecyclerView = null;
        _$_clearFindViewByIdCache();
    }

    public void onDetach() {
        super.onDetach();
        this.mListener = null;
    }

    public void onResume() {
        super.onResume();
        RFGAnalyticsManager.INSTANCE.sendScreen("101");
    }

    public void onStart() {
        super.onStart();
        OnPointListener onPointListener = this.mListener;
        if (onPointListener == null) {
            Intrinsics.throwNpe();
        }
        onPointListener.onStart(RFGDef.FragType.Point, "ポイント履歴");
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(view, Promotion.ACTION_VIEW);
        this.mRecyclerView = (RecyclerView) _$_findCachedViewById(C2092R.C2094id.recyclerView);
        setRecyclerViewLayoutManager();
        this.mAdapter = new RFGPointHistoryAdapter();
        if (!this.mPointHistoryItem.isEmpty()) {
            RFGPointHistoryAdapter rFGPointHistoryAdapter = this.mAdapter;
            if (rFGPointHistoryAdapter == null) {
                Intrinsics.throwNpe();
            }
            rFGPointHistoryAdapter.setHistory(this.mPointHistoryItem);
        }
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null) {
            Intrinsics.throwNpe();
        }
        RFGPointHistoryAdapter rFGPointHistoryAdapter2 = this.mAdapter;
        if (rFGPointHistoryAdapter2 == null) {
            Intrinsics.throwNpe();
        }
        recyclerView.setAdapter(rFGPointHistoryAdapter2);
        super.onViewCreated(view, bundle);
    }
}
