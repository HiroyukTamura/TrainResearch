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
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import p043jp.reifrontier.gym.C2092R;
import p043jp.reifrontier.gym.RFGDef;
import p043jp.reifrontier.gym.data.analytics.RFGAnalyticsManager;
import p043jp.reifrontier.gym.domain.app.RFGAdapterActivity;
import p043jp.reifrontier.gym.domain.app.RFGAdapterSummary;
import p043jp.reifrontier.gym.fragment.RFGFragmentBase;
import p043jp.reifrontier.gym.p044ui.adapter.RFGActivityAdapter;
import p043jp.reifrontier.gym.p044ui.adapter.RFGDayAdapter;
import p043jp.reifrontier.sanriku.R;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 (2\u00020\u00012\u00020\u0002:\u0002()B\u0005¢\u0006\u0002\u0010\u0003J\u0014\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012J\u0010\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0012\u0010\u001a\u001a\u00020\u00102\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J&\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010#\u001a\u00020\u0010H\u0016J\b\u0010$\u001a\u00020\u0010H\u0016J\u001a\u0010%\u001a\u00020\u00102\u0006\u0010&\u001a\u00020\u001e2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010'\u001a\u00020\u0010H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, mo21739d2 = {"Ljp/reifrontier/gym/fragment/RFGActFragment;", "Landroidx/fragment/app/Fragment;", "Ljp/reifrontier/gym/ui/adapter/RFGActivityAdapter$OnTodayListener;", "()V", "mAdapter", "Ljp/reifrontier/gym/ui/adapter/RFGDayAdapter;", "mLayoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "mListener", "Ljp/reifrontier/gym/fragment/RFGActFragment$OnActivitySingleListener;", "mParam1", "", "mParam2", "mRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "bindData", "", "list", "", "Ljp/reifrontier/gym/domain/app/RFGAdapterSummary;", "didSelectRowWith", "adapterActivity", "Ljp/reifrontier/gym/domain/app/RFGAdapterActivity;", "onAttach", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDetach", "onResume", "onViewCreated", "view", "setRecyclerViewLayoutManager", "Companion", "OnActivitySingleListener", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.fragment.RFGActFragment */
public final class RFGActFragment extends Fragment implements RFGActivityAdapter.OnTodayListener {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private HashMap _$_findViewCache;
    private RFGDayAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private OnActivitySingleListener mListener;
    private String mParam1;
    private String mParam2;
    private RecyclerView mRecyclerView;

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, mo21739d2 = {"Ljp/reifrontier/gym/fragment/RFGActFragment$OnActivitySingleListener;", "Ljp/reifrontier/gym/fragment/RFGFragmentBase$OnFragmentBaseListener;", "didSelectActFromSingle", "", "adapterActivity", "Ljp/reifrontier/gym/domain/app/RFGAdapterActivity;", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.fragment.RFGActFragment$OnActivitySingleListener */
    public interface OnActivitySingleListener extends RFGFragmentBase.OnFragmentBaseListener {
        void didSelectActFromSingle(RFGAdapterActivity rFGAdapterActivity);
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, mo21739d2 = {"Ljp/reifrontier/gym/fragment/RFGActFragment$Companion;", "", "()V", "ARG_PARAM1", "", "ARG_PARAM2", "newInstance", "Ljp/reifrontier/gym/fragment/RFGActFragment;", "param1", "param2", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.fragment.RFGActFragment$Companion */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RFGActFragment newInstance(String str, String str2) {
            Intrinsics.checkParameterIsNotNull(str, RFGActFragment.ARG_PARAM1);
            Intrinsics.checkParameterIsNotNull(str2, RFGActFragment.ARG_PARAM2);
            RFGActFragment rFGActFragment = new RFGActFragment();
            Bundle bundle = new Bundle();
            bundle.putString(RFGActFragment.ARG_PARAM1, str);
            bundle.putString(RFGActFragment.ARG_PARAM2, str2);
            rFGActFragment.setArguments(bundle);
            return rFGActFragment;
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

    public final void bindData(List<RFGAdapterSummary> list) {
        Intrinsics.checkParameterIsNotNull(list, "list");
        RFGDayAdapter rFGDayAdapter = this.mAdapter;
        if (rFGDayAdapter == null) {
            Intrinsics.throwNpe();
        }
        rFGDayAdapter.clear();
        RFGDayAdapter rFGDayAdapter2 = this.mAdapter;
        if (rFGDayAdapter2 == null) {
            Intrinsics.throwNpe();
        }
        rFGDayAdapter2.addItems(list);
        RFGDayAdapter rFGDayAdapter3 = this.mAdapter;
        if (rFGDayAdapter3 == null) {
            Intrinsics.throwNpe();
        }
        rFGDayAdapter3.notifyDataSetChanged();
    }

    public void didSelectRowWith(RFGAdapterActivity rFGAdapterActivity) {
        Intrinsics.checkParameterIsNotNull(rFGAdapterActivity, "adapterActivity");
        OnActivitySingleListener onActivitySingleListener = this.mListener;
        if (onActivitySingleListener == null) {
            Intrinsics.throwNpe();
        }
        onActivitySingleListener.didSelectActFromSingle(rFGAdapterActivity);
    }

    public void onAttach(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        super.onAttach(context);
        if (context instanceof OnActivitySingleListener) {
            this.mListener = (OnActivitySingleListener) context;
            return;
        }
        throw new RuntimeException(context + " must implement OnActivitySingleListener");
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
        return layoutInflater.inflate(R.layout.fragment_act, viewGroup, false);
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void onDetach() {
        super.onDetach();
        this.mListener = null;
    }

    public void onResume() {
        super.onResume();
        RFGAnalyticsManager.INSTANCE.sendScreen("110");
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(view, Promotion.ACTION_VIEW);
        OnActivitySingleListener onActivitySingleListener = this.mListener;
        if (onActivitySingleListener == null) {
            Intrinsics.throwNpe();
        }
        onActivitySingleListener.onStart(RFGDef.FragType.ActivitySingle, "この日の活動履歴");
        this.mRecyclerView = (RecyclerView) _$_findCachedViewById(C2092R.C2094id.recyclerViewAct);
        this.mLayoutManager = new LinearLayoutManager(getActivity());
        setRecyclerViewLayoutManager();
        this.mAdapter = new RFGDayAdapter(this);
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null) {
            Intrinsics.throwNpe();
        }
        RFGDayAdapter rFGDayAdapter = this.mAdapter;
        if (rFGDayAdapter == null) {
            Intrinsics.throwNpe();
        }
        recyclerView.setAdapter(rFGDayAdapter);
        super.onViewCreated(view, bundle);
    }
}
