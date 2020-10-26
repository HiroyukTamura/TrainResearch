// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.view.traininfo;

import android.graphics.PorterDuff$Mode;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.ContentLoadingProgressBar;
import jp.seibugroup.seiburailway.seibuapp.client.view.checkin.CheckinActivity_;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.DestinationsInfo;
import org.androidannotations.annotations.AfterViews;
import jp.seibugroup.seiburailway.seibuapp.client.view.trainposition.StationPositionActivity_;
import android.content.Intent;
import org.androidannotations.annotations.Click;
import com.feilang.mvpproject.util.Exclusive;
import com.google.common.eventbus.Subscribe;
import jp.seibugroup.seiburailway.seibuapp.client.event.CTCEventBus;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.CheckInData;
import android.content.Context;
import java.util.List;
import android.widget.RelativeLayout$LayoutParams;
import com.feilang.mvpproject.util.LayoutUtils;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import com.annimon.stream.Optional;
import com.annimon.stream.function.Predicate;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.TrainTimeTable;
import com.annimon.stream.Stream;
import jp.seibugroup.seiburailway.seibuapp.client.util.CheckinUtils;
import android.text.TextUtils;
import android.support.v7.widget.RecyclerView;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.TrainInfo;
import java.util.ArrayList;
import android.app.Dialog;
import android.widget.RelativeLayout;
import org.androidannotations.annotations.FragmentArg;
import android.view.View;
import org.androidannotations.annotations.ViewById;
import android.widget.LinearLayout;
import org.androidannotations.annotations.EFragment;
import jp.seibugroup.seiburailway.seibuapp.client.view.base.CTCBaseFragment;

@EFragment(2130968689)
public class TrainInfoFragment extends CTCBaseFragment implements TrainInfoContract$View
{
    private String fromStationId;
    private TrainInfoAdapter mAdapter;
    @ViewById(2131689733)
    LinearLayout mFooterLayout;
    @ViewById(2131689940)
    View mFooterLine;
    private boolean mHasCheckinInWeb;
    @FragmentArg
    boolean mIsFromTrainPosition;
    @ViewById(2131689938)
    RelativeLayout mListLayout;
    TrainInfoContract$Presenter mPresenter;
    private Dialog mProgressDialog;
    @ViewById(2131689936)
    RelativeLayout mRootLayout;
    @FragmentArg
    String mStationId;
    @FragmentArg
    String mStationName;
    @FragmentArg
    ArrayList<TrainInfo> mTrainInfoList;
    @ViewById(2131689939)
    RecyclerView mTrainRecyclerView;
    private TrainInfo trainInfo;
    
    public TrainInfoFragment() {
        this.mHasCheckinInWeb = false;
    }
    
    private String getFromStationId(final TrainInfo trainInfo) {
        if (!TextUtils.isEmpty((CharSequence)this.mStationId)) {
            return this.mStationId;
        }
        if (!TextUtils.isEmpty((CharSequence)trainInfo.getFromStationId()) && TextUtils.isEmpty((CharSequence)trainInfo.getToStationId())) {
            final Optional<TrainTimeTable> first = Stream.of((Iterable<? extends TrainTimeTable>)CheckinUtils.getAllStopStation(trainInfo)).filter(TrainInfoFragment$$Lambda$4.lambdaFactory$(trainInfo)).findFirst();
            if (first.isPresent() && !first.get().isPast()) {
                return first.get().getStationId();
            }
        }
        final Optional<TrainTimeTable> last = Stream.of((Iterable<? extends TrainTimeTable>)CheckinUtils.getAllStopStation(trainInfo)).filter(TrainInfoFragment$$Lambda$5.lambdaFactory$()).findLast();
        if (last.isPresent()) {
            return last.get().getStationId();
        }
        return this.mStationId;
    }
    
    public static TrainInfoFragment newInstance(final ArrayList<TrainInfo> list, final boolean b, final String s, final String s2) {
        return TrainInfoFragment_.builder().mTrainInfoList((ArrayList)list).mIsFromTrainPosition(b).mStationId(s).mStationName(s2).build();
    }
    
    private void setUpLayout(final int n) {
        this.mFooterLayout.setVisibility(0);
        final RelativeLayout$LayoutParams relativeLayout$LayoutParams = (RelativeLayout$LayoutParams)this.mFooterLayout.getLayoutParams();
        final RelativeLayout$LayoutParams relativeLayout$LayoutParams2 = (RelativeLayout$LayoutParams)this.mListLayout.getLayoutParams();
        if (n == 1) {
            relativeLayout$LayoutParams.addRule(12, 0);
            relativeLayout$LayoutParams.addRule(3, 2131689938);
            relativeLayout$LayoutParams2.addRule(2, 0);
            return;
        }
        relativeLayout$LayoutParams.addRule(3, 0);
        relativeLayout$LayoutParams.addRule(12, 2131689733);
        relativeLayout$LayoutParams2.addRule(2, 2131689733);
    }
    
    private void updateViews(final List<TrainInfo> dataSource) {
        dataSource.size();
        this.mTrainRecyclerView.setLayoutManager((RecyclerView.LayoutManager)new TrainInfoFragment$1(this, (Context)this.mActivity));
        this.mAdapter.setDataSource((List)dataSource);
        this.mRootLayout.post(TrainInfoFragment$$Lambda$6.lambdaFactory$(this));
    }
    
    public void changeLayout(final boolean b) {
        int upLayout;
        if (b) {
            upLayout = 2;
        }
        else {
            upLayout = 1;
        }
        this.setUpLayout(upLayout);
    }
    
    @Subscribe
    public void checkInSuccess(final ArrayList<CheckInData> list) {
        CTCEventBus.post("check_in_info_changed");
        this.mAdapter.checkInSuccess((ArrayList)list);
    }
    
    public void checkOutDone(final boolean b) {
        if (b) {
            CTCEventBus.post("check_in_info_changed");
            this.mAdapter.checkOutSuccess();
            return;
        }
        this.showErrorMessage(this.getString(2131230853));
    }
    
    @Subscribe
    public void checkinByWeb(final String s) {
        if (TextUtils.equals((CharSequence)s, (CharSequence)"checkin_by_web")) {
            this.mHasCheckinInWeb = true;
        }
    }
    
    public void checkout(final String s) {
        Exclusive.Normal().tap(TrainInfoFragment$$Lambda$3.lambdaFactory$(this, s));
    }
    
    @Click({ 2131689713 })
    void closeActivity() {
        this.getActivity().finish();
    }
    
    public void findTrainSuccess(final String s, final String s2, final int n) {
        if (this.mIsFromTrainPosition) {
            final Intent intent = new Intent();
            intent.putExtra("routeId", s);
            intent.putExtra("trainId", s2);
            intent.putExtra("sectionNo", n);
            this.mActivity.setResult(2, intent);
            this.mActivity.finish();
            return;
        }
        this.mActivity.modelActivity(StationPositionActivity_.intent(this.getContext()).routeId(s).trainId(s2).sectionNo(n));
    }
    
    public void hideProgress() {
        if (this.mProgressDialog != null) {
            this.mProgressDialog.dismiss();
        }
    }
    
    @AfterViews
    void initViews() {
        CTCEventBus.register(this);
        this.mPresenter.getCheckinData((ArrayList)this.mTrainInfoList);
    }
    
    public void onApiFailed() {
        this.showErrorMessage(this.getString(2131230853));
    }
    
    public void onDestroy() {
        super.onDestroy();
        CTCEventBus.unregister(this);
    }
    
    public void onPause() {
        super.onPause();
        this.mPresenter.stopReceiveDataEvent();
        this.mPresenter.stop();
        this.hideProgress();
    }
    
    public void onResume() {
        super.onResume();
        this.mPresenter.startReceiveDataEvent();
        this.mPresenter.start();
        if (this.mHasCheckinInWeb) {
            this.mHasCheckinInWeb = false;
            this.mPresenter.getCheckinByApi();
        }
    }
    
    public void setPresenter(final TrainInfoContract$Presenter mPresenter) {
        this.mPresenter = mPresenter;
    }
    
    public void setupTrainRecyclerView(final ArrayList<TrainInfo> list, final List<CheckInData> checkInTrainDatas) {
        (this.mAdapter = new TrainInfoAdapter(this.getContext())).setFragment((TrainInfoFragment_)this);
        this.mAdapter.setCheckInTrainDatas((List)checkInTrainDatas);
        this.mTrainRecyclerView.setAdapter((RecyclerView.Adapter)this.mAdapter);
        if (this.mTrainInfoList == null) {
            this.mTrainInfoList = new ArrayList<TrainInfo>();
        }
        this.updateViews(this.mTrainInfoList);
    }
    
    public void showDestinations(final DestinationsInfo destinationsInfo) {
        this.mActivity.modelActivity(CheckinActivity_.intent((Context)this.mActivity).trainInfo(this.trainInfo).destinationsInfo(destinationsInfo).mFromStationId(this.fromStationId).mStationId(this.mStationId).mStationName(this.mStationName));
    }
    
    public void showProgress() {
        (this.mProgressDialog = new Dialog(this.getContext(), 2131362107)).setContentView(2130968644);
        final ContentLoadingProgressBar contentLoadingProgressBar = (ContentLoadingProgressBar)this.mProgressDialog.findViewById(2131689689);
        if (contentLoadingProgressBar != null) {
            contentLoadingProgressBar.getIndeterminateDrawable().setColorFilter(ContextCompat.getColor(this.getContext(), 2131558522), PorterDuff$Mode.SRC_IN);
        }
        this.mProgressDialog.setCancelable(false);
        this.mProgressDialog.show();
    }
    
    public void toChooseGetOff(final TrainInfo trainInfo) {
        Exclusive.Normal().tap(TrainInfoFragment$$Lambda$2.lambdaFactory$(this, trainInfo));
    }
    
    public void toTrainPosition(final TrainInfo trainInfo) {
        Exclusive.Normal().tap(TrainInfoFragment$$Lambda$1.lambdaFactory$(this, trainInfo));
    }
}
