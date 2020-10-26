// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.view.home.mystation;

import android.widget.RelativeLayout$LayoutParams;
import jp.seibugroup.seiburailway.seibuapp.client.view.trainposition.StationPositionActivity_;
import jp.seibugroup.seiburailway.seibuapp.client.view.traininfo.TrainInfoActivity_;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.TrainInfo;
import jp.seibugroup.seiburailway.seibuapp.client.view.timetabletop.TimeTableTopActivity_;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.xml.LineStationInfoWrapper;
import jp.seibugroup.seiburailway.seibuapp.client.view.stationmap.StationMapActivity_;
import jp.seibugroup.seiburailway.seibuapp.client.data.db.AppPotManager;
import org.androidannotations.annotations.UiThread;
import java.io.Serializable;
import android.os.Bundle;
import jp.seibugroup.seiburailway.seibuapp.client.util.Constants;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.StationInfo;
import jp.seibugroup.seiburailway.seibuapp.client.view.addstation.AddStationFragment$FragmentType;
import jp.seibugroup.seiburailway.seibuapp.client.view.routemap.RouteMapActivity_;
import jp.seibugroup.seiburailway.seibuapp.client.view.webview.WebViewActivity_;
import jp.seibugroup.seiburailway.seibuapp.client.view.webview.WebViewActivity_$IntentBuilder_;
import com.feilang.mvpproject.util.LogUtils;
import jp.seibugroup.seiburailway.seibuapp.client.view.home.HomeFragment;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.api.UiThreadExecutor;
import jp.seibugroup.seiburailway.seibuapp.client.util.Payload;
import android.support.v4.app.Fragment;
import jp.seibugroup.seiburailway.seibuapp.client.view.MainActivity_;
import org.androidannotations.api.builder.ActivityIntentBuilder;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.StationDetailInfo;
import org.androidannotations.annotations.Click;
import com.google.common.eventbus.Subscribe;
import android.widget.Toast;
import java.util.Iterator;
import android.graphics.drawable.ColorDrawable;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import java.util.ArrayList;
import android.graphics.drawable.Drawable;
import com.google.common.collect.Lists;
import com.google.gson.Gson;
import java.util.Map;
import android.text.TextUtils;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.HomeDialogOptionData;
import java.util.List;
import android.support.v7.app.AlertDialog;
import com.feilang.mvpproject.util.LayoutUtils;
import jp.seibugroup.seiburailway.seibuapp.client.util.LanguageUtils;
import android.widget.FrameLayout$LayoutParams;
import android.view.ViewGroup$LayoutParams;
import jp.seibugroup.seiburailway.seibuapp.client.event.CTCEventBus;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.TrainDetail;
import org.androidannotations.annotations.FragmentArg;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.view.StationDeparture;
import jp.seibugroup.seiburailway.seibuapp.client.view.common.WeatherView;
import jp.seibugroup.seiburailway.seibuapp.client.view.common.trainboard.TrainBoard;
import jp.seibugroup.seiburailway.seibuapp.client.view.home.anim.StationCardLauncherAnim;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.pref.PrefAppPotAccount_;
import org.androidannotations.annotations.sharedpreferences.Pref;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.pref.PrefAppData_;
import jp.seibugroup.seiburailway.seibuapp.client.view.common.stationicon.StationIconView;
import android.widget.TextView;
import android.view.View;
import org.androidannotations.annotations.ViewById;
import android.support.v7.widget.AppCompatButton;
import org.androidannotations.annotations.EFragment;
import jp.seibugroup.seiburailway.seibuapp.client.view.base.CTCBaseFragment;

@EFragment(2130968659)
public class MyStationCardFragment extends CTCBaseFragment implements MyStationCardContract$View
{
    private static final int STATION_NAME_LEFT_MARGIN = 74;
    private static boolean mIsFooterHidden;
    @ViewById(2131690003)
    AppCompatButton mBtnBusInfo;
    @ViewById(2131689804)
    View mBtnHideLauncher;
    @ViewById(2131689803)
    View mBtnHideText;
    @ViewById(2131690004)
    AppCompatButton mBtnNearbyInfo;
    @ViewById(2131689801)
    View mBtnShowLauncher;
    @ViewById(2131689802)
    View mBtnShowText;
    @ViewById(2131690005)
    AppCompatButton mBtnTransferInfo;
    @ViewById(2131689785)
    View mCardView;
    @ViewById(2131689796)
    TextView mDirectionLeftText;
    private String mDirectionName;
    @ViewById(2131689798)
    TextView mDirectionRightText;
    @ViewById(2131689793)
    StationIconView mFirstStationIcon;
    private MyStationCardFragment.MyStationCardFragment$Model mFragmentModel;
    @ViewById(2131689800)
    View mLauncherContainer;
    @ViewById(2131689805)
    View mLayoutNormalLocation;
    private MyStationCardFragment.MyStationCardFragment$LauncherStatusListener mListener;
    @ViewById(2131689791)
    TextView mMyStationName;
    @ViewById(2131689792)
    TextView mMyStationNameRoma;
    @ViewById(2131689797)
    TextView mMyStationTrainDirection;
    @Pref
    PrefAppData_ mPrefAppData;
    @Pref
    PrefAppPotAccount_ mPrefAppPotAccount;
    MyStationCardContract$Presenter mPresenter;
    @ViewById(2131689794)
    StationIconView mSecondStationIcon;
    private StationCardLauncherAnim mStationCardLauncherAnim;
    @ViewById(2131689799)
    TrainBoard mTrainBoard;
    @ViewById(2131689789)
    WeatherView mWeatherView;
    @FragmentArg
    StationDeparture stationDeparture;
    
    static {
        MyStationCardFragment.mIsFooterHidden = false;
    }
    
    public MyStationCardFragment() {
        this.mFragmentModel = MyStationCardFragment.MyStationCardFragment$Model.NORMAL;
    }
    
    private void changeData() {
        MyStationCardFragment.mIsFooterHidden = !MyStationCardFragment.mIsFooterHidden;
        CTCEventBus.post(MyStationCardFragment.mIsFooterHidden);
        this.mListener.onFooterStatusChange(MyStationCardFragment.mIsFooterHidden);
    }
    
    private void changeFooter() {
        final int n = 0;
        View view;
        if (MyStationCardFragment.mIsFooterHidden) {
            view = this.mBtnShowLauncher;
        }
        else {
            view = this.mBtnHideLauncher;
        }
        StationCardLauncherAnim.showSwichBtn(view);
        View view2;
        if (MyStationCardFragment.mIsFooterHidden) {
            view2 = this.mBtnShowText;
        }
        else {
            view2 = this.mBtnHideText;
        }
        StationCardLauncherAnim.showSwichBtn(view2);
        View view3;
        if (MyStationCardFragment.mIsFooterHidden) {
            view3 = this.mBtnHideLauncher;
        }
        else {
            view3 = this.mBtnShowLauncher;
        }
        StationCardLauncherAnim.hideSwichBtn(view3);
        View view4;
        if (MyStationCardFragment.mIsFooterHidden) {
            view4 = this.mBtnHideText;
        }
        else {
            view4 = this.mBtnShowText;
        }
        StationCardLauncherAnim.hideSwichBtn(view4);
        final View mBtnHideLauncher = this.mBtnHideLauncher;
        int visibility;
        if (MyStationCardFragment.mIsFooterHidden) {
            visibility = 8;
        }
        else {
            visibility = 0;
        }
        mBtnHideLauncher.setVisibility(visibility);
        final View mBtnHideText = this.mBtnHideText;
        int visibility2;
        if (MyStationCardFragment.mIsFooterHidden) {
            visibility2 = 8;
        }
        else {
            visibility2 = 0;
        }
        mBtnHideText.setVisibility(visibility2);
        final View mBtnShowLauncher = this.mBtnShowLauncher;
        int visibility3;
        if (MyStationCardFragment.mIsFooterHidden) {
            visibility3 = 0;
        }
        else {
            visibility3 = 8;
        }
        mBtnShowLauncher.setVisibility(visibility3);
        final View mBtnShowText = this.mBtnShowText;
        int visibility4;
        if (MyStationCardFragment.mIsFooterHidden) {
            visibility4 = n;
        }
        else {
            visibility4 = 8;
        }
        mBtnShowText.setVisibility(visibility4);
        switch (MyStationCardFragment$3.$SwitchMap$jp$seibugroup$seiburailway$seibuapp$client$view$home$mystation$MyStationCardFragment$Model[this.mFragmentModel.ordinal()]) {
            default: {}
            case 1: {
                this.getStationCardLauncherAnim().toggle(MyStationCardFragment.mIsFooterHidden);
            }
            case 2: {
                this.getStationCardLauncherAnim().toggle(MyStationCardFragment.mIsFooterHidden);
            }
        }
    }
    
    private void foldLauncher() {
        final int n = 0;
        final View mBtnHideLauncher = this.mBtnHideLauncher;
        int visibility;
        if (MyStationCardFragment.mIsFooterHidden) {
            visibility = 8;
        }
        else {
            visibility = 0;
        }
        mBtnHideLauncher.setVisibility(visibility);
        final View mBtnHideText = this.mBtnHideText;
        int visibility2;
        if (MyStationCardFragment.mIsFooterHidden) {
            visibility2 = 8;
        }
        else {
            visibility2 = 0;
        }
        mBtnHideText.setVisibility(visibility2);
        final View mLauncherContainer = this.mLauncherContainer;
        int visibility3;
        if (MyStationCardFragment.mIsFooterHidden) {
            visibility3 = 8;
        }
        else {
            visibility3 = 0;
        }
        mLauncherContainer.setVisibility(visibility3);
        final View mBtnShowLauncher = this.mBtnShowLauncher;
        int visibility4;
        if (MyStationCardFragment.mIsFooterHidden) {
            visibility4 = 0;
        }
        else {
            visibility4 = 8;
        }
        mBtnShowLauncher.setVisibility(visibility4);
        final View mBtnShowText = this.mBtnShowText;
        int visibility5;
        if (MyStationCardFragment.mIsFooterHidden) {
            visibility5 = n;
        }
        else {
            visibility5 = 8;
        }
        mBtnShowText.setVisibility(visibility5);
        if (MyStationCardFragment.mIsFooterHidden) {
            final ViewGroup$LayoutParams layoutParams = this.mCardView.getLayoutParams();
            layoutParams.height = this.getResources().getDimensionPixelSize(2131296283);
            this.mCardView.setLayoutParams(layoutParams);
        }
    }
    
    private void initDirectionLayout() {
        final FrameLayout$LayoutParams frameLayout$LayoutParams = (FrameLayout$LayoutParams)this.mMyStationTrainDirection.getLayoutParams();
        if (LanguageUtils.isPhoneLanguageEnglish()) {
            this.mDirectionRightText.setVisibility(8);
            this.mDirectionLeftText.setVisibility(0);
            this.mMyStationTrainDirection.setPadding(LayoutUtils.dpToPx(this.getContext(), 5.0f), 0, LayoutUtils.dpToPx(this.getContext(), 15.0f), 0);
            frameLayout$LayoutParams.setMarginStart(LayoutUtils.dpToPx(this.getContext(), 73.0f));
            frameLayout$LayoutParams.setMarginEnd(0);
            return;
        }
        this.mDirectionLeftText.setVisibility(8);
        this.mDirectionRightText.setVisibility(0);
        this.mMyStationTrainDirection.setPadding(LayoutUtils.dpToPx(this.getContext(), 15.0f), 0, LayoutUtils.dpToPx(this.getContext(), 5.0f), 0);
        frameLayout$LayoutParams.setMarginStart(0);
        frameLayout$LayoutParams.setMarginEnd(LayoutUtils.dpToPx(this.getContext(), 47.0f));
    }
    
    public static MyStationCardFragment newInstance() {
        return MyStationCardFragment_.builder().build();
    }
    
    public static MyStationCardFragment newInstance(final StationDeparture stationDeparture) {
        return MyStationCardFragment_.builder().stationDeparture(stationDeparture).build();
    }
    
    private void onSelectedTrain(final TrainDetail trainDetail) {
        if (this.isSupportVisible()) {
            this.mPresenter.requestTrains(this.stationDeparture.getLineId(), (List)Lists.newArrayList(trainDetail.getTrainNo()));
        }
    }
    
    public static void setFooterStatus(final boolean mIsFooterHidden) {
        MyStationCardFragment.mIsFooterHidden = mIsFooterHidden;
    }
    
    private void setLauncherStatus(final AppCompatButton appCompatButton, final boolean b) {
        appCompatButton.setClickable(b);
        appCompatButton.setEnabled(b);
        if (!b) {
            appCompatButton.setBackgroundDrawable(null);
        }
    }
    
    private void showChooseDirectionsDialog() {
        final ArrayList<HomeDialogOptionData> dataSource = new ArrayList<HomeDialogOptionData>();
        for (final String s : this.stationDeparture.getDirectionNames()) {
            dataSource.add(new HomeDialogOptionData(TextUtils.equals((CharSequence)s, (CharSequence)this.stationDeparture.getSelectedDirectionName()), s));
        }
        final MyStationDialogAdapter adapter = new MyStationDialogAdapter(this.getContext());
        final View inflate = View.inflate(this.getContext(), 2130968642, (ViewGroup)null);
        final RecyclerView recyclerView = (RecyclerView)inflate.findViewById(2131689683);
        final TextView textView = (TextView)inflate.findViewById(2131689684);
        recyclerView.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager((Context)this.mActivity));
        adapter.setDataSource((List)dataSource);
        recyclerView.setAdapter((RecyclerView.Adapter)adapter);
        final AlertDialog create = new AlertDialog.Builder((Context)this.mActivity).setView(inflate).setCancelable(false).create();
        create.getWindow().setBackgroundDrawable((Drawable)new ColorDrawable(0));
        create.show();
        textView.setOnClickListener(MyStationCardFragment$$Lambda$5.lambdaFactory$(create));
        adapter.setOnItemClickListener(MyStationCardFragment$$Lambda$6.lambdaFactory$(this, (List)dataSource, create));
    }
    
    private void toastMessage(final String s) {
        Toast.makeText((Context)this.mActivity, (CharSequence)s, 1).show();
    }
    
    @Subscribe
    public void changeBoolean(final Boolean b) {
        this.changeFooter();
    }
    
    @Click({ 2131689795 })
    void editTrainDirection() {
        this.showChooseDirectionsDialog();
    }
    
    public boolean getFooterStatus() {
        return MyStationCardFragment.mIsFooterHidden;
    }
    
    @Click({ 2131689805 })
    void getNearbyStations() {
        this.mPresenter.getNearbyStation((Context)this.mActivity);
    }
    
    public StationCardLauncherAnim getStationCardLauncherAnim() {
        if (this.mStationCardLauncherAnim == null) {
            this.mStationCardLauncherAnim = StationCardLauncherAnim.newInstance(this.getContext(), this.mCardView, this.mLauncherContainer);
        }
        return this.mStationCardLauncherAnim;
    }
    
    @Click({ 2131689791 })
    void getStationInfo() {
        if (this.stationDeparture != null && !TextUtils.isEmpty((CharSequence)this.stationDeparture.getStationId())) {
            this.mPresenter.getStationInfoDetail(this.stationDeparture.getStationId());
        }
    }
    
    public void goStationInfoPage(final StationDetailInfo stationDetailInfo) {
        this.mActivity.entryActivity((ActivityIntentBuilder)MainActivity_.intent((Fragment)this).payload(Payload.make(1, stationDetailInfo)).flags(67108864));
    }
    
    @Click({ 2131689801 })
    void hideLaunchController() {
        this.mBtnHideLauncher.setClickable(false);
        UiThreadExecutor.runTask("launcher_anim", MyStationCardFragment$$Lambda$4.lambdaFactory$(this), 500L);
        this.changeData();
    }
    
    @AfterViews
    void initViews() {
        this.initDirectionLayout();
        if (this.mPresenter == null) {
            new MyStationCardPresenterImpl((MyStationCardContract$View)this);
        }
        if (this.stationDeparture != null) {
            this.updateMyStaiton(this.stationDeparture);
        }
        this.mCardView.post(MyStationCardFragment$$Lambda$1.lambdaFactory$(this));
    }
    
    public boolean onBackPressedSupport() {
        this.mActivity.onBackPressedSupport();
        return true;
    }
    
    public void onPause() {
        super.onPause();
        this.mPresenter.stop();
        CTCEventBus.unregister(this);
        this.mStationCardLauncherAnim = null;
    }
    
    public void onResume() {
        super.onResume();
        this.mPresenter.start();
        CTCEventBus.register(this);
        this.foldLauncher();
    }
    
    public void onSupportInvisible() {
        super.onSupportInvisible();
        this.mPresenter.stopReceiveDataEvent();
        UiThreadExecutor.cancelAll("launcher_anim");
        this.mBtnHideLauncher.setClickable(true);
        this.mBtnShowLauncher.setClickable(true);
        this.mTrainBoard.pauseItemNameAnimation();
    }
    
    public void onSupportVisible() {
        super.onSupportVisible();
        this.mPresenter.startReceiveDataEvent();
        this.mTrainBoard.startItemNameAnimation();
    }
    
    @Subscribe
    public void refresh(final List<StationDeparture> list) {
        if (this.stationDeparture != null) {
            for (final StationDeparture stationDeparture : list) {
                if (stationDeparture.getStationId().equals(this.stationDeparture.getStationId()) && stationDeparture.getModelType() == this.mFragmentModel) {
                    this.updateMyStaiton(stationDeparture);
                    if (this.isSupportVisible()) {
                        this.mTrainBoard.startItemNameAnimation();
                        return;
                    }
                    break;
                }
            }
        }
    }
    
    @Click({ 2131689787 })
    void refreshMyStation() {
        if (this.getParentFragment() instanceof HomeFragment) {
            ((HomeFragment)this.getParentFragment()).getBaseBallStatus();
            ((HomeFragment)this.getParentFragment()).getEmerg();
            ((HomeFragment)this.getParentFragment()).getCheckin();
        }
        if (this.stationDeparture != null) {
            this.mPresenter.getAllStationDepartures();
        }
    }
    
    public void setFragmentModel(final MyStationCardFragment.MyStationCardFragment$Model mFragmentModel) {
        this.mFragmentModel = mFragmentModel;
    }
    
    public void setLauncherStatusListener(final MyStationCardFragment.MyStationCardFragment$LauncherStatusListener mListener) {
        this.mListener = mListener;
    }
    
    public void setPresenter(final MyStationCardContract$Presenter mPresenter) {
        this.mPresenter = mPresenter;
    }
    
    @Click({ 2131690003 })
    void showBusInfo() {
        LogUtils.trace(this);
        this.mActivity.modelActivity((ActivityIntentBuilder)((WebViewActivity_$IntentBuilder_)WebViewActivity_.intent(this.getContext()).extra("web_view_title", this.getString(2131231213))).extra("web_view_url", this.stationDeparture.getBusSiteUrl()));
    }
    
    public void showErrorMessage() {
        this.showErrorMessage(this.getString(2131230853));
    }
    
    @Click({ 2131689804 })
    void showLaunchController() {
        this.mBtnShowLauncher.setClickable(false);
        UiThreadExecutor.runTask("launcher_anim", MyStationCardFragment$$Lambda$3.lambdaFactory$(this), 500L);
        this.changeData();
    }
    
    @Click({ 2131690001 })
    void showLineMap() {
        this.mActivity.modelActivity(RouteMapActivity_.intent((Context)this.mActivity).type(AddStationFragment$FragmentType.GOTO_STATION_INFO_TO_SEARCH_TOP));
    }
    
    @Click({ 2131690004 })
    void showNearbyInfo() {
        this.openUrl(this.stationDeparture.getAreaInfoUrl());
    }
    
    @UiThread
    public void showNearbyStations(final List<StationInfo> list) {
        this.mDirectionName = null;
        Constants.LOCATION_STATION_ID = null;
        final Bundle bundle = new Bundle();
        bundle.putSerializable("nearby_stations", (Serializable)list);
        this.setFragmentResult(3, bundle);
        this.pop();
    }
    
    @Click({ 2131690005 })
    void showRestaurantInfo() {
        this.mActivity.modelActivity((ActivityIntentBuilder)WebViewActivity_.intent(this.getContext()).extra("web_view_url", this.stationDeparture.getStationInfo().getTransitUrl().replace("{:appPotUserId}", (CharSequence)this.mPrefAppPotAccount.apppotUserId().get()).replace("{:appPotToken}", AppPotManager.getToken())));
    }
    
    @Click({ 2131689999 })
    void showStationStructure() {
        this.mActivity.modelActivity(StationMapActivity_.intent(this.getContext()).stationInfo(this.stationDeparture.getStationInfo()));
    }
    
    @Click({ 2131689998 })
    void showStationTimeTable() {
        this.mPresenter.requestStationLines(this.stationDeparture.getStationId());
    }
    
    public void showStationTimeTableTop(final List<LineStationInfoWrapper> list) {
        this.mActivity.modelActivity(TimeTableTopActivity_.intent((Context)this.mActivity).romajiName(this.stationDeparture.getStationNameRoma()).kanjiName(this.stationDeparture.getStationName()).stationId(this.stationDeparture.getStationId()));
    }
    
    public void showTrainInfo(final ArrayList<TrainInfo> list) {
        if (list == null || list.size() == 0) {
            this.showErrorMessage(this.getString(2131230853));
            return;
        }
        this.mActivity.modelActivity(TrainInfoActivity_.intent((Fragment)this).mTrainInfoList((ArrayList)list).mStationId(this.stationDeparture.getStationId()).mStationName(this.stationDeparture.getStationName()));
    }
    
    @Click({ 2131690000 })
    void showTrainPosition() {
        final String lineId = this.stationDeparture.getLineId();
        final int sectionNo = this.stationDeparture.getDepartureData(this.stationDeparture.getSelectedDirectionName()).getSectionNo();
        String s = lineId;
        if (TextUtils.equals((CharSequence)"L001", (CharSequence)lineId)) {
            s = lineId;
            if (sectionNo == 2) {
                s = "L008";
            }
        }
        this.mActivity.modelActivity(StationPositionActivity_.intent(this.getContext()).routeId(s).stationId(this.stationDeparture.getStationId()));
    }
    
    public void updateMyStaiton(final StationDeparture stationDeparture) {
        if (stationDeparture == null) {
            return;
        }
        this.stationDeparture = stationDeparture;
        if (MyStationCardFragment.MyStationCardFragment$Model.NORMAL == this.mFragmentModel) {
            final Map<K, String> map = new Gson().fromJson((String)this.mPrefAppData.directionNameJson().get(), new MyStationCardFragment$1(this).getType());
            final String stationId = stationDeparture.getStationId();
            if (map.containsKey(stationId)) {
                stationDeparture.setSelectedDirectionName(map.get(stationId));
            }
        }
        else if (!TextUtils.isEmpty((CharSequence)this.mDirectionName) && stationDeparture.getDirectionNames().contains(this.mDirectionName)) {
            stationDeparture.setSelectedDirectionName(this.mDirectionName);
        }
        if (this.mFragmentModel == MyStationCardFragment.MyStationCardFragment$Model.LOCATION) {
            this.mLayoutNormalLocation.setVisibility(0);
        }
        else {
            this.mLayoutNormalLocation.setVisibility(8);
        }
        this.mMyStationName.setText((CharSequence)stationDeparture.getStationName());
        this.mMyStationNameRoma.setText((CharSequence)stationDeparture.getStationNameRoma());
        if (stationDeparture.getStationInfo().getWeather() != null) {
            this.mWeatherView.setMaxWeather(stationDeparture.getStationInfo().getWeather().getHighestTemperature());
            this.mWeatherView.setMinWeather(stationDeparture.getStationInfo().getWeather().getLowestTemperature());
            this.mWeatherView.setImageId(stationDeparture.getStationInfo().getWeather().getWeatherCode());
        }
        final ArrayList<String> list = new ArrayList<String>();
        for (final String s : stationDeparture.getStationInfo().getStationNo()) {
            if (!list.contains(s)) {
                list.add(s);
            }
        }
        final int size = list.size();
        if (size > 0 && list.get(0).length() > 3) {
            this.mFirstStationIcon.setStationNumber((String)list.get(0));
            this.mFirstStationIcon.setVisibility(0);
            final RelativeLayout$LayoutParams relativeLayout$LayoutParams = (RelativeLayout$LayoutParams)this.mFirstStationIcon.getLayoutParams();
            final Context context = this.getContext();
            float n;
            if (size == 1) {
                n = 23.0f;
            }
            else {
                n = 21.0f;
            }
            relativeLayout$LayoutParams.setMargins(0, LayoutUtils.dpToPx(context, n), LayoutUtils.dpToPx(this.getContext(), 6.0f), 0);
        }
        else {
            this.mFirstStationIcon.setVisibility(8);
        }
        if (size > 1 && list.get(1).length() > 3) {
            this.mSecondStationIcon.setStationNumber((String)list.get(1));
            this.mSecondStationIcon.setVisibility(0);
        }
        else {
            this.mSecondStationIcon.setVisibility(8);
        }
        this.mMyStationTrainDirection.setText((CharSequence)stationDeparture.getSelectedDirectionName());
        this.mTrainBoard.setData(stationDeparture.getDepartureData(stationDeparture.getSelectedDirectionName()));
        this.mTrainBoard.setHandler(MyStationCardFragment$$Lambda$2.lambdaFactory$(this));
        this.setLauncherStatus(this.mBtnBusInfo, !TextUtils.isEmpty((CharSequence)stationDeparture.getBusSiteUrl()));
        this.setLauncherStatus(this.mBtnNearbyInfo, !TextUtils.isEmpty((CharSequence)stationDeparture.getAreaInfoUrl()));
        this.setLauncherStatus(this.mBtnTransferInfo, !TextUtils.isEmpty((CharSequence)stationDeparture.getStationInfo().getTransitUrl()));
    }
}
