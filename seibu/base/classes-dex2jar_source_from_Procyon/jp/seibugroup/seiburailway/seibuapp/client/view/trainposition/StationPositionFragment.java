// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.view.trainposition;

import java.io.Serializable;
import jp.seibugroup.seiburailway.seibuapp.client.view.trainwrapping.TrainWrappingActivity_;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.TrainWrappingData;
import com.google.common.collect.Lists;
import jp.seibugroup.seiburailway.seibuapp.client.view.traininfo.TrainInfoActivity_;
import java.util.Iterator;
import android.app.Activity;
import jp.seibugroup.seiburailway.seibuapp.client.util.PopWindow;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.CheckInData;
import org.androidannotations.annotations.OnActivityResult;
import jp.seibugroup.seiburailway.seibuapp.client.util.Payload;
import android.support.v4.app.Fragment;
import jp.seibugroup.seiburailway.seibuapp.client.view.MainActivity_;
import org.androidannotations.api.builder.ActivityIntentBuilder;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.StationDetailInfo;
import org.androidannotations.annotations.AfterViews;
import jp.seibugroup.seiburailway.seibuapp.client.event.CTCEventBus;
import com.google.common.eventbus.Subscribe;
import com.annimon.stream.function.Consumer;
import com.annimon.stream.Stream;
import com.feilang.mvpproject.util.CalendarUtils;
import android.widget.TextView;
import java.util.Date;
import android.view.ViewGroup$LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.view.ViewGroup;
import java.util.List;
import android.content.Intent;
import android.net.Uri;
import android.content.Context;
import jp.seibugroup.seiburailway.seibuapp.client.util.AppUtils;
import android.text.TextUtils;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.TransferData;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.TrainInfo;
import java.util.ArrayList;
import android.view.View;
import android.widget.ScrollView;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.sharedpreferences.Pref;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.pref.PrefTrainPosition_;
import org.androidannotations.annotations.App;
import jp.seibugroup.seiburailway.seibuapp.client.CTCApplication;
import org.androidannotations.annotations.FragmentArg;
import org.androidannotations.annotations.EFragment;
import jp.seibugroup.seiburailway.seibuapp.client.view.base.CTCBaseFragment;

@EFragment(2130968679)
public class StationPositionFragment extends CTCBaseFragment implements StationPositionContract$View
{
    @FragmentArg
    boolean isTraintypeShowing;
    @App
    CTCApplication mApplication;
    private String mChosenLine;
    private boolean mIsCheckInfoChanged;
    private boolean mIsNeedFresh;
    @Pref
    PrefTrainPosition_ mPref;
    StationPositionContract$Presenter mPresenter;
    @ViewById(2131689910)
    ScrollTagView mRouteScrollView;
    @ViewById(2131689688)
    ScrollView mScrollContainer;
    private String mSelectedTrainId;
    @ViewById(2131689911)
    TrainPositionLayout mStationLinesLayout;
    View mView;
    @FragmentArg
    String routeId;
    @FragmentArg
    int sectionNo;
    @FragmentArg
    String stationId;
    @FragmentArg
    String trainId;
    @FragmentArg
    ArrayList<TrainInfo> trains;
    
    private void doWithTransformData(final TransferData transferData) {
        if (TextUtils.isEmpty((CharSequence)transferData.getTrainPosURL())) {
            this.openUrl(transferData.getUrl());
            return;
        }
        if (transferData.getTrainPosURL().startsWith("http")) {
            this.openUrl(transferData.getTrainPosURL());
            return;
        }
        if (AppUtils.isApkInstalled((Context)this.mActivity, transferData.getPackageName())) {
            this.openOtherApp(Uri.parse(transferData.getTrainPosURL()));
            return;
        }
        AppUtils.openAppRating((Context)this.mActivity, transferData.getStoreUrlForAndroid());
    }
    
    private void getDataFromIntent(final Intent intent) {
        if (intent != null) {
            final String stringExtra = intent.getStringExtra("routeId");
            final int intExtra = intent.getIntExtra("sectionNo", 0);
            this.mSelectedTrainId = intent.getStringExtra("trainId");
            this.getRealRoute(stringExtra, intExtra);
        }
    }
    
    private void getRealRoute(final String s, final int n) {
        String s2 = s;
        if (s != null) {
            s2 = s;
            if (n == 2) {
                s2 = s;
                if (TextUtils.equals((CharSequence)s, (CharSequence)"L001")) {
                    s2 = "L008";
                }
            }
        }
        this.onTrainSelected(s2);
    }
    
    private void loadStations(final String s) {
        if (s == null) {
            return;
        }
        ((PrefTrainPosition_.PrefTrainPositionEditor_)this.mPref.edit().lineId().put(s)).apply();
        this.mPresenter.startLoadData(s, false);
    }
    
    public static StationPositionFragment newInstance(final String s, final ArrayList<TrainInfo> list, final String s2, final String s3, final int n, final boolean b) {
        return StationPositionFragment_.builder().routeId(s).trains((ArrayList)list).stationId(s2).trainId(s3).sectionNo(n).isTraintypeShowing(b).build();
    }
    
    private void onTrainSelected(String s) {
        String routeId;
        if ((TextUtils.equals((CharSequence)this.routeId, (CharSequence)s) && this.trainId == null) || (TextUtils.equals((CharSequence)this.routeId, (CharSequence)"L009") && TextUtils.equals((CharSequence)s, (CharSequence)"L010")) || (TextUtils.equals((CharSequence)this.routeId, (CharSequence)"L001") && TextUtils.equals((CharSequence)s, (CharSequence)"L003"))) {
            this.mStationLinesLayout.onShowSelectedTrain(this.mSelectedTrainId);
            this.mSelectedTrainId = "";
            routeId = s;
        }
        else {
            this.trainId = null;
            this.mIsNeedFresh = true;
            if (TextUtils.equals((CharSequence)s, (CharSequence)"L010")) {
                routeId = "L009";
            }
            else {
                routeId = s;
                if (TextUtils.equals((CharSequence)s, (CharSequence)"L003")) {
                    routeId = "L001";
                }
            }
        }
        this.routeId = routeId;
        if (TextUtils.equals((CharSequence)(s = this.mPresenter.getRouteNameById(this.routeId)), (CharSequence)this.getContext().getString(2131231149))) {
            s = this.getContext().getString(2131231151);
        }
        this.mRouteScrollView.highLightTag(s);
    }
    
    private void openOtherApp(final Uri uri) {
        final Intent intent = new Intent("android.intent.action.VIEW", uri);
        intent.setFlags(268435456);
        this.startActivity(intent);
    }
    
    public static void setListViewFitHeight(final ListView listView, int height, final int height2) {
        final ListAdapter adapter = listView.getAdapter();
        if (adapter == null) {
            return;
        }
        height = adapter.getCount() * height + listView.getDividerHeight() * (adapter.getCount() - 1);
        final ViewGroup$LayoutParams layoutParams = listView.getLayoutParams();
        if (height < height2) {
            layoutParams.height = height;
        }
        else {
            layoutParams.height = height2;
        }
        listView.setLayoutParams(layoutParams);
    }
    
    private void setUpdateTime(final Date date) {
        ((TextView)this.mView.findViewById(2131689913)).setText((CharSequence)(this.getString(2131231145) + " " + CalendarUtils.toHHmmssString(date)));
    }
    
    private void showRouteNames() {
        final Stream<Object> of = Stream.of((Iterable<?>)this.mPresenter.getRouteNames());
        final ScrollTagView mRouteScrollView = this.mRouteScrollView;
        mRouteScrollView.getClass();
        of.forEach(StationPositionFragment$$Lambda$2.lambdaFactory$(mRouteScrollView));
        this.mRouteScrollView.setSelectListener(StationPositionFragment$$Lambda$3.lambdaFactory$(this));
        if (this.trainId != null && !TextUtils.isEmpty((CharSequence)this.trainId)) {
            this.mSelectedTrainId = this.trainId;
            this.getRealRoute(this.routeId, this.sectionNo);
            return;
        }
        String s;
        if (TextUtils.equals((CharSequence)(s = this.mPresenter.getRouteNameById(this.routeId)), (CharSequence)this.getContext().getString(2131231149))) {
            s = this.getContext().getString(2131231151);
        }
        this.mRouteScrollView.highLightTag(s);
    }
    
    private void showStations(final String s) {
        this.loadStations(s);
    }
    
    public void changeTrainIcon() {
        this.mStationLinesLayout.changeTrainIcon();
    }
    
    @Subscribe
    public void checkinInfoChanged(final String s) {
        if (TextUtils.equals((CharSequence)s, (CharSequence)"check_in_info_changed")) {
            this.mIsCheckInfoChanged = true;
        }
    }
    
    public void destroy() {
        if (this.mStationLinesLayout != null) {
            this.mStationLinesLayout.destroy();
        }
    }
    
    @AfterViews
    void initViews() {
        CTCEventBus.register(this);
        this.mPresenter.start();
        this.mView = this.getView();
        if (this.mView == null) {
            return;
        }
        this.mRouteScrollView = (ScrollTagView)this.mView.findViewById(2131689910);
        (this.mStationLinesLayout = (TrainPositionLayout)this.mView.findViewById(2131689911)).setIsShowTrainInfoIcon(this.isTraintypeShowing);
        if (this.sectionNo == 2 && TextUtils.equals((CharSequence)this.routeId, (CharSequence)"L001")) {
            this.routeId = "L008";
        }
        if (this.trains == null || this.trains.size() < 1) {
            this.showRouteNames();
        }
        this.mStationLinesLayout.setStationListener((TrainPositionLayout$OnStationListener)new StationPositionFragment$1(this));
    }
    
    public void migrateToStationInfo(final StationDetailInfo stationDetailInfo) {
        this.mActivity.entryActivity((ActivityIntentBuilder)MainActivity_.intent((Fragment)this).payload(Payload.make(1, stationDetailInfo)).flags(67108864));
    }
    
    public void onDestroy() {
        super.onDestroy();
        CTCEventBus.unregister(this);
        this.mPresenter.stop();
    }
    
    @OnActivityResult(2)
    void onResultTrainInfo(final Intent intent) {
        this.getDataFromIntent(intent);
    }
    
    @OnActivityResult(1)
    void onRouteIdChoose(final Intent intent) {
        this.getDataFromIntent(intent);
    }
    
    public void onSupportInvisible() {
        super.onSupportInvisible();
        this.mPresenter.stopReceiveDataEvent();
    }
    
    public void onSupportVisible() {
        super.onSupportVisible();
        this.mPresenter.startReceiveDataEvent();
        if (this.mIsCheckInfoChanged) {
            this.mIsCheckInfoChanged = false;
            this.updateTrains();
            return;
        }
        if (!this.mIsNeedFresh) {
            this.mPresenter.freshCurrentRouteData();
            return;
        }
        this.mIsNeedFresh = false;
    }
    
    @Subscribe
    public void scrollToNextOrPrevLine(final String s) {
        if (TextUtils.equals((CharSequence)s, (CharSequence)"train_position_scroll_to_next")) {
            this.mRouteScrollView.selectNextOrPrevTag(true);
        }
        if (TextUtils.equals((CharSequence)s, (CharSequence)"train_position_scroll_to_previous")) {
            this.mRouteScrollView.selectNextOrPrevTag(false);
        }
    }
    
    public void setCheckInTrainInfos(final List<CheckInData> checkInTrainInfos) {
        this.mStationLinesLayout.setCheckInTrainInfos((List)checkInTrainInfos);
    }
    
    public void setPresenter(final StationPositionContract$Presenter mPresenter) {
        this.mPresenter = mPresenter;
    }
    
    public void setSharedTrainInfos(final List<CheckInData> sharedTrainInfos) {
        this.mStationLinesLayout.setSharedTrainInfos((List)sharedTrainInfos);
    }
    
    public void showOtherLineDialog(final List<TransferData> list) {
        PopWindow.activity((Activity)this.mActivity).title(this.getResources().getString(2131231146)).adapter(StationPositionFragment$$Lambda$1.lambdaFactory$(this, (List)list)).show();
    }
    
    public boolean showRouteMap(final String route) {
        boolean b = false;
        if (this.mStationLinesLayout.setRoute(route)) {
            this.mScrollContainer.scrollTo(0, 0);
            b = true;
        }
        return b;
    }
    
    public void showTrainPosition(final String s, final List<TrainInfo> list) {
        this.mStationLinesLayout.updateTrainPosition((List)list, this.mSelectedTrainId);
        this.mSelectedTrainId = "";
        this.setUpdateTime(this.mPresenter.getUpdateDate());
    }
    
    public void toOtherApp(final List<TransferData> list) {
        for (final TransferData transferData : list) {
            if (TextUtils.equals((CharSequence)transferData.getLineId(), (CharSequence)this.mChosenLine)) {
                this.doWithTransformData(transferData);
            }
        }
    }
    
    public void toTrainInfo(final List<TrainInfo> list) {
        this.mActivity.modelActivityForResult(TrainInfoActivity_.intent((Fragment)this).mTrainInfoList((ArrayList)Lists.newArrayList((Iterable<?>)list)).mIsFromTrainPosition(true), 2);
    }
    
    public void toTrainWrapping(final List<TrainWrappingData> list) {
        final Intent intent = new Intent((Context)this.mActivity, (Class)TrainWrappingActivity_.class);
        intent.putExtra("mTrainWrappingData", (Serializable)Lists.newArrayList((Iterable<?>)list));
        this.startActivityForResult(intent, 1);
    }
    
    public void updateTrains() {
        this.mPresenter.startLoadData(this.routeId, true);
    }
}
