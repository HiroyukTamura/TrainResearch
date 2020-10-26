// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.view.home.locationcard;

import me.yokeyword.fragmentation.ISupportFragment;
import jp.seibugroup.seiburailway.seibuapp.client.view.home.mystation.MyStationCardContract$View;
import jp.seibugroup.seiburailway.seibuapp.client.view.home.mystation.MyStationCardPresenterImpl;
import jp.seibugroup.seiburailway.seibuapp.client.view.home.mystation.MyStationCardFragment$Model;
import jp.seibugroup.seiburailway.seibuapp.client.util.Constants;
import jp.seibugroup.seiburailway.seibuapp.client.view.home.mystation.MyStationCardFragment;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.view.StationDeparture;
import org.androidannotations.annotations.UiThread;
import android.widget.ListAdapter;
import java.util.List;
import jp.seibugroup.seiburailway.seibuapp.client.event.CTCEventBus;
import android.support.annotation.Nullable;
import android.os.Bundle;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import android.content.Context;
import java.util.Iterator;
import jp.seibugroup.seiburailway.seibuapp.client.view.common.stationicon.StationIconView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.google.common.eventbus.Subscribe;
import com.feilang.mvpproject.base.listview.BaseListView;
import android.widget.TextView;
import com.feilang.mvpproject.base.listview.BaseListAdapter;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.StationInfo;
import java.util.ArrayList;
import jp.seibugroup.seiburailway.seibuapp.client.view.home.anim.LocationCardViewAnim;
import jp.seibugroup.seiburailway.seibuapp.client.view.home.mystation.MyStationCardFragment$LauncherStatusListener;
import android.widget.ListView;
import org.androidannotations.annotations.InstanceState;
import org.androidannotations.annotations.ViewById;
import android.view.View;
import org.androidannotations.annotations.EFragment;
import jp.seibugroup.seiburailway.seibuapp.client.view.base.CTCBaseFragment;

@EFragment(2130968661)
public class MyStationCardLocationFragment extends CTCBaseFragment implements MyStationCardLocationContract$View
{
    public static final String RESULT_KEY_NEARBY_STATIONS = "nearby_stations";
    @ViewById(2131689814)
    View mBtnUpdateLocation;
    @ViewById(2131689785)
    View mCardView;
    @InstanceState
    boolean mIsEmptyState;
    @ViewById(2131689812)
    View mLayoutMyStationList;
    @ViewById(2131689810)
    View mLayoutMyStationLocation;
    @ViewById(2131689815)
    ListView mListNearbyStations;
    private MyStationCardFragment$LauncherStatusListener mListener;
    private LocationCardViewAnim mLocationCardViewAnim;
    @InstanceState
    ArrayList<StationInfo> mNearbyStations;
    private BaseListAdapter<StationInfo> mNearbyStationsAdapter;
    MyStationCardLocationContract$Presenter mPresenter;
    @ViewById(2131689816)
    TextView mTvStationsNearbyNoResult;
    
    public MyStationCardLocationFragment() {
        this.mNearbyStationsAdapter = new BaseListAdapter<StationInfo>((BaseListView)this);
    }
    
    private void changeFooter(final boolean b) {
        if (this.mCardView != null) {
            this.getLocationCardViewAnim().toggle(b);
        }
    }
    
    public static MyStationCardLocationFragment newInstance() {
        return MyStationCardLocationFragment_.builder().build();
    }
    
    private void resetViews() {
        if (this.mNearbyStationsAdapter.getCount() >= 0) {
            return;
        }
        this.mLayoutMyStationList.setVisibility(8);
        this.mLayoutMyStationLocation.setVisibility(0);
        this.mBtnUpdateLocation.setVisibility(8);
        this.mLayoutMyStationList.setVisibility(8);
        this.mTvStationsNearbyNoResult.setVisibility(8);
    }
    
    @Subscribe
    public void changeBoolean(final Boolean b) {
        this.changeFooter(b);
    }
    
    public View generateListItem(final StationInfo stationInfo, int size, View inflate, final ViewGroup viewGroup) {
        if ((inflate = inflate) == null) {
            inflate = LayoutInflater.from(viewGroup.getContext()).inflate(2130968721, viewGroup, false);
        }
        final StationIconView stationIconView = (StationIconView)inflate.findViewById(2131690010);
        final StationIconView stationIconView2 = (StationIconView)inflate.findViewById(2131690011);
        final TextView textView = (TextView)inflate.findViewById(2131689706);
        final TextView textView2 = (TextView)inflate.findViewById(2131690013);
        final ArrayList<String> list = new ArrayList<String>();
        for (final String s : stationInfo.getStationNo()) {
            if (!list.contains(s)) {
                list.add(s);
            }
        }
        size = list.size();
        if (size > 0 && ((String)list.get(0)).length() > 3) {
            stationIconView.setStationNumber((String)list.get(0));
            stationIconView.setVisibility(0);
        }
        else {
            stationIconView.setVisibility(8);
        }
        if (size > 1 && ((String)list.get(1)).length() > 3) {
            stationIconView2.setStationNumber((String)list.get(1));
            stationIconView2.setVisibility(0);
        }
        else {
            stationIconView2.setVisibility(8);
        }
        if (stationInfo.getStationName() != null) {
            textView.setText((CharSequence)stationInfo.getStationName());
        }
        if (stationInfo.getStationNameRomaji() != null) {
            textView2.setText((CharSequence)stationInfo.getStationNameRomaji());
        }
        inflate.setOnClickListener(MyStationCardLocationFragment$$Lambda$1.lambdaFactory$(this, stationInfo));
        return inflate;
    }
    
    public LocationCardViewAnim getLocationCardViewAnim() {
        if (this.mLocationCardViewAnim == null) {
            this.mLocationCardViewAnim = LocationCardViewAnim.newInstance(this.getContext(), this.mCardView);
        }
        return this.mLocationCardViewAnim;
    }
    
    @Click({ 2131689811 })
    void getNearbyStations() {
        this.mPresenter.getNearbyStation((Context)this.mActivity);
    }
    
    @AfterViews
    void initViews() {
        if (this.mPresenter == null) {
            new MyStationCardLocationPresenterImpl((MyStationCardLocationContract$View)this);
        }
    }
    
    public void onCreate(@Nullable final Bundle bundle) {
        super.onCreate(bundle);
        CTCEventBus.register(this);
    }
    
    public void onDestroy() {
        super.onDestroy();
        CTCEventBus.unregister(this);
    }
    
    public void onFragmentResult(final int n, final int n2, final Bundle bundle) {
        super.onFragmentResult(n, n2, bundle);
        if (n == 3) {
            this.showNearbyStations((List<StationInfo>)bundle.get("nearby_stations"));
        }
    }
    
    public void onPause() {
        super.onPause();
        this.mPresenter.stop();
        this.mLocationCardViewAnim = null;
    }
    
    public void onResume() {
        super.onResume();
        this.mPresenter.start();
        this.getLocationCardViewAnim().initFooterView(this.mCardView);
        if (this.mIsEmptyState) {
            this.showNearbyStations(new ArrayList<StationInfo>());
        }
        else if (this.mNearbyStations != null) {
            this.showNearbyStations(this.mNearbyStations);
        }
    }
    
    public void onSupportInvisible() {
        super.onSupportInvisible();
        this.mPresenter.stopReceiveDataEvent();
        this.resetViews();
    }
    
    public void onSupportVisible() {
        super.onSupportVisible();
        this.mPresenter.startReceiveDataEvent();
    }
    
    public void setLauncherStatusListener(final MyStationCardFragment$LauncherStatusListener mListener) {
        this.mListener = mListener;
    }
    
    public void setPresenter(final MyStationCardLocationContract$Presenter mPresenter) {
        this.mPresenter = mPresenter;
    }
    
    @UiThread
    public void showNearbyStations(final List<StationInfo> dataSource) {
        if (dataSource != null) {
            this.mNearbyStations = (ArrayList<StationInfo>)dataSource;
        }
        this.mLayoutMyStationLocation.setVisibility(8);
        this.mBtnUpdateLocation.setVisibility(0);
        this.mLayoutMyStationList.setVisibility(0);
        if (dataSource == null || dataSource.size() == 0) {
            this.mIsEmptyState = true;
            this.mTvStationsNearbyNoResult.setVisibility(0);
            this.mListNearbyStations.setVisibility(8);
            return;
        }
        this.mIsEmptyState = false;
        this.mTvStationsNearbyNoResult.setVisibility(8);
        this.mListNearbyStations.setVisibility(0);
        this.mNearbyStationsAdapter.setDataSource(dataSource);
        this.mListNearbyStations.setAdapter((ListAdapter)this.mNearbyStationsAdapter);
    }
    
    public void updateMyStaiton(final StationDeparture stationDeparture) {
        if (stationDeparture == null) {
            return;
        }
        final MyStationCardFragment instance = MyStationCardFragment.newInstance(stationDeparture);
        Constants.LOCATION_STATION_ID = stationDeparture.getStationId();
        instance.setFragmentModel(MyStationCardFragment$Model.LOCATION);
        instance.setLauncherStatusListener(this.mListener);
        new MyStationCardPresenterImpl((MyStationCardContract$View)instance);
        this.startForResult((ISupportFragment)instance, 3);
    }
    
    @Click({ 2131689814 })
    void updateNearbyStation() {
        this.getNearbyStations();
    }
}
