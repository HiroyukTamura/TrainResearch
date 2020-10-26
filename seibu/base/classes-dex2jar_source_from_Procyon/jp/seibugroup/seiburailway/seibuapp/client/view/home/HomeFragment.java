// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.view.home;

import jp.seibugroup.seiburailway.seibuapp.client.data.models.view.HomeData;
import jp.seibugroup.seiburailway.seibuapp.client.util.HomeCheckinDataUtils;
import jp.seibugroup.seiburailway.seibuapp.client.view.runstatus.RunStatusActivity_;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.RunStatusDataWrapper;
import jp.seibugroup.seiburailway.seibuapp.client.view.arrivalpush.ArrivalPushActivity_;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.TrainInfo;
import android.animation.Animator$AnimatorListener;
import jp.seibugroup.seiburailway.seibuapp.client.view.timetabletop.TimeTableTopActivity_;
import jp.seibugroup.seiburailway.seibuapp.client.util.PopWindow;
import jp.seibugroup.seiburailway.seibuapp.client.view.noticeList.NoticeListFragment;
import me.yokeyword.fragmentation.ISupportFragment;
import jp.seibugroup.seiburailway.seibuapp.client.view.noticeList.NoticeListContract$View;
import jp.seibugroup.seiburailway.seibuapp.client.view.noticeList.NoticeListPresenterImpl;
import jp.seibugroup.seiburailway.seibuapp.client.view.noticeList.NoticeListFragment_;
import android.content.Intent;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.RunStatusData;
import jp.seibugroup.seiburailway.seibuapp.client.data.db.AppPotManager;
import android.net.Uri;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.master.BaseConfig;
import com.annimon.stream.function.Function;
import jp.seibugroup.seiburailway.seibuapp.client.util.AppStatusManager_;
import com.google.common.eventbus.Subscribe;
import android.webkit.WebViewClient;
import jp.seibugroup.seiburailway.seibuapp.client.event.CTCEventBus;
import android.support.annotation.Nullable;
import android.os.Bundle;
import org.androidannotations.annotations.AfterViews;
import jp.seibugroup.seiburailway.seibuapp.client.data.repository.StationsRepository_;
import android.graphics.drawable.GradientDrawable;
import jp.seibugroup.seiburailway.seibuapp.client.util.Constants;
import android.graphics.drawable.GradientDrawable$Orientation;
import android.annotation.SuppressLint;
import com.annimon.stream.Optional;
import jp.seibugroup.seiburailway.seibuapp.client.util.CheckinUtils;
import com.annimon.stream.function.Predicate;
import com.annimon.stream.function.Consumer;
import com.annimon.stream.Stream;
import com.google.common.collect.Maps;
import java.util.Collection;
import java.util.Arrays;
import jp.seibugroup.seiburailway.seibuapp.client.view.trainposition.StationPositionActivity_;
import jp.seibugroup.seiburailway.seibuapp.client.view.webview.WebViewActivity_;
import org.androidannotations.api.builder.ActivityIntentBuilder;
import com.feilang.mvpproject.util.Exclusive;
import org.androidannotations.annotations.Click;
import android.content.DialogInterface$OnClickListener;
import android.widget.ListAdapter;
import android.view.ViewGroup;
import java.util.Iterator;
import jp.seibugroup.seiburailway.seibuapp.client.view.home.addcard.MyStationCardAddContract$View;
import jp.seibugroup.seiburailway.seibuapp.client.data.repository.MasterDataRepository;
import jp.seibugroup.seiburailway.seibuapp.client.data.repository.DeviceDataRepository;
import jp.seibugroup.seiburailway.seibuapp.client.data.repository.MasterDataRepository_;
import jp.seibugroup.seiburailway.seibuapp.client.data.repository.DeviceDataRepository_;
import jp.seibugroup.seiburailway.seibuapp.client.view.home.addcard.MyStationCardAddPresenterImpl;
import jp.seibugroup.seiburailway.seibuapp.client.view.home.addcard.MyStationCardAddFragment;
import jp.seibugroup.seiburailway.seibuapp.client.view.home.mystation.MyStationCardContract$View;
import jp.seibugroup.seiburailway.seibuapp.client.view.home.mystation.MyStationCardFragment_;
import java.util.Map;
import jp.seibugroup.seiburailway.seibuapp.client.view.home.mystation.MyStationCardLocationRootFragment;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.view.StationDeparture;
import android.widget.PopupWindow$OnDismissListener;
import jp.seibugroup.seiburailway.seibuapp.client.remote.fcm.NotificationBroadcastReceiver;
import org.androidannotations.api.UiThreadExecutor;
import android.util.Patterns;
import android.support.v4.content.ContextCompat;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.RunStatusSpecific;
import jp.seibugroup.seiburailway.seibuapp.client.view.traininfo.TrainInfoActivity_;
import android.view.ViewGroup$LayoutParams;
import android.widget.RelativeLayout$LayoutParams;
import android.animation.ValueAnimator;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.PushInfo;
import com.feilang.mvpproject.util.AppEventBus;
import android.text.style.ImageSpan;
import android.text.SpannableString;
import android.text.TextUtils$TruncateAt;
import com.bumptech.glide.Glide;
import android.view.MotionEvent;
import java.util.HashMap;
import android.support.v7.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Context;
import jp.seibugroup.seiburailway.seibuapp.client.util.TimeUtils;
import android.support.v7.widget.LinearLayoutManager;
import com.feilang.mvpproject.util.LayoutUtils;
import android.support.v4.view.PagerAdapter;
import android.text.TextUtils;
import com.google.common.collect.Lists;
import com.google.gson.Gson;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.CheckInData;
import java.util.ArrayList;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.pref.PrefWallPaperData_;
import android.widget.FrameLayout;
import jp.seibugroup.seiburailway.seibuapp.client.view.home.anim.TrainRunningAnim;
import android.support.constraint.ConstraintLayout;
import jp.seibugroup.seiburailway.seibuapp.client.data.repository.StationsRepository;
import android.support.v4.view.ViewPager;
import jp.seibugroup.seiburailway.seibuapp.client.view.home.mystation.MyStationCardPresenterImpl;
import jp.seibugroup.seiburailway.seibuapp.client.view.home.mystation.MyStationCardFragment;
import android.widget.ScrollView;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.pref.PrefSharedData_;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.pref.PrefAppPotAccount_;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.pref.PrefAppData_;
import jp.seibugroup.seiburailway.seibuapp.client.view.home.mystation.MyStationsPagerAdapter;
import android.widget.ImageButton;
import android.support.v7.widget.RecyclerView;
import org.androidannotations.annotations.sharedpreferences.Pref;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.pref.PrefMyLineData_;
import android.widget.LinearLayout;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.NoticeMessageData;
import org.androidannotations.annotations.InstanceState;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.TrainTimeTable;
import jp.seibugroup.seiburailway.seibuapp.client.view.common.stationicon.StationIconView;
import android.widget.RelativeLayout;
import android.graphics.drawable.Drawable;
import android.widget.TextView;
import android.widget.CheckBox;
import android.view.View;
import org.androidannotations.annotations.ViewById;
import android.widget.ImageView;
import java.util.List;
import org.androidannotations.annotations.FragmentArg;
import org.androidannotations.annotations.EFragment;
import jp.seibugroup.seiburailway.seibuapp.client.view.home.mystation.MyStationCardFragment$LauncherStatusListener;
import jp.seibugroup.seiburailway.seibuapp.client.view.base.CTCBaseFragment;

@EFragment(2130968655)
public class HomeFragment extends CTCBaseFragment implements HomeContract$View, MyStationCardFragment$LauncherStatusListener
{
    private static final int CHECK_IN_ANIMATION_TIME = 300;
    public static final String GET_CHECK_IN = "get_check_in";
    private static final String RUN_STATUS = "run_status";
    public static final int STOP_STATION_HEIGHT = 46;
    private static final int WALL_PAPER_MIN_HEIGHT = 75;
    private int endHeight;
    private int height;
    @FragmentArg
    boolean isFromNotification;
    private List<String> mAllSharedIds;
    @ViewById(2131689757)
    ImageView mBaseballIcon;
    @ViewById(2131689740)
    ImageView mBeaconIcon;
    @ViewById(2131690229)
    View mCheckinClickView;
    @ViewById(2131690234)
    ImageView mChevronIV;
    private int mChosenGetOffIndex;
    @ViewById(2131689741)
    View mEmergBackground;
    @ViewById(2131689760)
    CheckBox mEmergCheckBox;
    @ViewById(2131689763)
    TextView mEmergContent;
    private Drawable mEmergContentBg;
    @ViewById(2131689762)
    View mEmergContentWidthView;
    @ViewById(2131689758)
    RelativeLayout mEmergView;
    @ViewById(2131690221)
    TextView mEndStationTV;
    @ViewById(2131690220)
    StationIconView mEndStationView;
    @InstanceState
    public TrainTimeTable mGetOffStation;
    @ViewById(2131690226)
    TextView mGetOffStationTV;
    private List<NoticeMessageData> mHavereadEmergData;
    @ViewById(2131689737)
    ImageView mImageTop;
    private boolean mIsBeaconVisible;
    private boolean mIsFirstOpen;
    private boolean mIsFromLink;
    private boolean mIsGameIconVisible;
    private boolean mIsHomeStartFirst;
    private boolean mIsMyStationChanged;
    private int mLastCardSum;
    @ViewById(2131689749)
    ImageView mLineIcon_1;
    @ViewById(2131689752)
    ImageView mLineIcon_2;
    @ViewById(2131689755)
    ImageView mLineIcon_3;
    @ViewById(2131689750)
    TextView mLineName_1;
    @ViewById(2131689753)
    TextView mLineName_2;
    @ViewById(2131689756)
    TextView mLineName_3;
    private int mMarkPosition;
    @ViewById(2131689747)
    LinearLayout mMyLineLayout;
    @ViewById(2131689748)
    LinearLayout mMyLineLayout_1;
    @ViewById(2131689751)
    LinearLayout mMyLineLayout_2;
    @ViewById(2131689754)
    LinearLayout mMyLineLayout_3;
    @Pref
    PrefMyLineData_ mMyLinePref;
    @ViewById(2131690233)
    TextView mNextStationAfterTV;
    @ViewById(2131690231)
    TextView mNextStationBeforeTV;
    @ViewById(2131690222)
    RecyclerView mNextStationRV;
    @ViewById(2131690232)
    TextView mNextStationTV;
    @ViewById(2131689743)
    ImageButton mNoticeBtn;
    MyStationsPagerAdapter mPagerAdapter;
    @Pref
    PrefAppData_ mPrefAppData;
    @Pref
    PrefAppPotAccount_ mPrefAppPotAccount;
    @Pref
    PrefSharedData_ mPrefSharedData;
    private HomeContract$Presenter mPresenter;
    @ViewById(2131689770)
    CustomSwipeRefreshLayout mRefreshLayout;
    @ViewById(2131689766)
    RelativeLayout mReservationLayout;
    @ViewById(2131689746)
    TextView mRunStatusView;
    @ViewById(2131689771)
    ScrollView mScrollView;
    private String mSharedId;
    List<MyStationCardFragment> mStationCardList;
    List<MyStationCardPresenterImpl> mStationCardPresenterList;
    private String mStationId;
    @ViewById(2131689773)
    ViewPager mStationsContainer;
    StationsRepository mStationsRepository;
    @ViewById(2131689776)
    ScrollView mStopStationDetailView;
    @ViewById(2131689765)
    ConstraintLayout mStopStationView;
    @ViewById(2131689769)
    View mSupportLine;
    @ViewById(2131689744)
    RelativeLayout mTopLayout;
    @ViewById(2131689738)
    RelativeLayout mTrainAndBeacon;
    TrainRunningAnim mTrainRunningAnim;
    @ViewById(2131690225)
    TextView mTrainStatus;
    @ViewById(2131690230)
    ImageView mTrainTypeBtn;
    @ViewById(2131689739)
    ImageView mTrainView;
    private List<NoticeMessageData> mUnreadEmergData;
    @ViewById(2131689772)
    FrameLayout mViewpagerContainer;
    @ViewById(2131689775)
    ImageView mWallPaper;
    @Pref
    PrefWallPaperData_ mWallPaperPref;
    @ViewById(2131689774)
    RoundedWebView mWallPaperWebview;
    private int startHeight;
    
    public HomeFragment() {
        this.mStationCardList = new ArrayList<MyStationCardFragment>();
        this.mStationCardPresenterList = new ArrayList<MyStationCardPresenterImpl>();
        this.mIsHomeStartFirst = true;
        this.mIsFromLink = false;
        this.mLastCardSum = 8;
        this.mIsFirstOpen = true;
        this.mUnreadEmergData = new ArrayList<NoticeMessageData>();
        this.mHavereadEmergData = new ArrayList<NoticeMessageData>();
        this.startHeight = 0;
        this.endHeight = 0;
    }
    
    private void enableDisableSwipeRefresh(final boolean canRefresh) {
        if (this.mRefreshLayout != null) {
            this.mRefreshLayout.setCanRefresh(canRefresh);
        }
    }
    
    private List<CheckInData> getSharedDatas() {
        final Gson gson = new Gson();
        final String s = (String)this.mPrefSharedData.sharedCheckInData().get();
        List<CheckInData> arrayList = (List<CheckInData>)Lists.newArrayList();
        if (!TextUtils.isEmpty((CharSequence)s)) {
            arrayList = gson.fromJson(s, new HomeFragment$7(this).getType());
        }
        return arrayList;
    }
    
    private void hideEmergView() {
        int visibility = 8;
        this.mEmergView.setVisibility(8);
        this.mEmergBackground.setVisibility(8);
        final ImageView mBaseballIcon = this.mBaseballIcon;
        if (this.mIsGameIconVisible) {
            visibility = 0;
        }
        mBaseballIcon.setVisibility(visibility);
    }
    
    private void initMyLine() {
        this.mLineIcon_1.setImageResource(0);
        this.mLineName_1.setText((CharSequence)"");
        this.mLineIcon_2.setImageResource(0);
        this.mLineName_2.setText((CharSequence)"");
        this.mLineIcon_3.setImageResource(0);
        this.mLineName_3.setText((CharSequence)"");
        this.mMyLineLayout_1.setVisibility(4);
        this.mMyLineLayout_2.setVisibility(4);
        this.mMyLineLayout_3.setVisibility(4);
    }
    
    private void initMyStationCardPager() {
        this.mPagerAdapter = new MyStationsPagerAdapter(this.getChildFragmentManager());
        this.mStationsContainer.setAdapter((PagerAdapter)this.mPagerAdapter);
        this.mStationsContainer.setOffscreenPageLimit(10);
        this.mStationsContainer.setPageMargin(LayoutUtils.dpToPx(this.getContext(), 8.0f));
        this.mStationsContainer.addOnPageChangeListener((ViewPager.OnPageChangeListener)new HomeFragment$4(this));
    }
    
    private void initNextStationRecyclerView() {
        this.mNextStationRV.setAdapter((RecyclerView.Adapter)this.mPresenter.getNextStationListAdapter());
        this.mNextStationRV.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(this.getContext(), 0, false));
    }
    
    private void initTopImage() {
        if (TimeUtils.isDaytime((Context)this.mActivity)) {
            this.mImageTop.setImageResource(2130837589);
            return;
        }
        this.mImageTop.setImageResource(2130837588);
    }
    
    public static HomeFragment newInstance(final boolean b) {
        return HomeFragment_.builder().isFromNotification(b).build();
    }
    
    private void resetTrainAndBeaconPosition() {
        this.mTrainAndBeacon.setTranslationX(0.0f);
    }
    
    private void saveEmeryId(final String s) {
        List<String> list;
        if ((list = new Gson().fromJson((String)this.mPrefAppData.emergIdJson().get(), new HomeFragment$6(this).getType())) == null) {
            list = new ArrayList<String>();
        }
        if (!list.contains(s)) {
            list.add(s);
            ((PrefAppData_.PrefAppDataEditor_)this.mPrefAppData.edit().emergIdJson().put(new Gson().toJson(list))).apply();
        }
    }
    
    private void saveSharedData(final List<CheckInData> list) {
        ((PrefSharedData_.PrefSharedDataEditor_)this.mPrefSharedData.edit().sharedCheckInData().put(new Gson().toJson(list))).apply();
    }
    
    private void scrollCheckinListToMark() {
        this.mNextStationRV.post(HomeFragment$$Lambda$24.lambdaFactory$(this));
    }
    
    private void setEmergContent() {
        this.mEmergContentWidthView.post(HomeFragment$$Lambda$22.lambdaFactory$(this));
    }
    
    private void setMarkPosition(final int mMarkPosition) {
        if (this.mMarkPosition == mMarkPosition) {
            return;
        }
        this.mMarkPosition = mMarkPosition;
    }
    
    private void setupMyLineStatus(final RunStatusSpecific runStatusSpecific, final ImageView imageView, final TextView textView) {
        if (TextUtils.equals((CharSequence)runStatusSpecific.getStatus(), (CharSequence)"200")) {
            imageView.setImageResource(2130837943);
        }
        else if (TextUtils.equals((CharSequence)runStatusSpecific.getStatus(), (CharSequence)"400") || TextUtils.equals((CharSequence)runStatusSpecific.getStatus(), (CharSequence)"401")) {
            imageView.setImageResource(2130837942);
        }
        else {
            imageView.setImageResource(2130837944);
        }
        textView.setTextColor(ContextCompat.getColor(this.getContext(), 2131558405));
        textView.setText((CharSequence)runStatusSpecific.getLineName());
    }
    
    private void setupNewEmerg() {
        this.mBaseballIcon.setVisibility(8);
        this.mEmergView.setVisibility(0);
        this.mEmergBackground.setVisibility(0);
        this.mEmergCheckBox.setChecked(false);
        if (this.mUnreadEmergData.get(0).getToUrlList() == null || this.mUnreadEmergData.get(0).getToUrlList().isEmpty() || !Patterns.WEB_URL.matcher(this.mUnreadEmergData.get(0).getToUrlList().get(0)).matches()) {
            this.mEmergContent.setClickable(false);
            this.mEmergContent.setBackground((Drawable)null);
            if (this.mUnreadEmergData.get(0).getContentList() != null && !this.mUnreadEmergData.get(0).getContentList().isEmpty()) {
                this.mEmergContent.setText((CharSequence)this.mUnreadEmergData.get(0).getContentList().get(0));
            }
            return;
        }
        this.mEmergContent.setClickable(true);
        this.mEmergContent.setBackground(this.mEmergContentBg);
        this.setEmergContent();
    }
    
    private void setupRefreshLayout() {
        this.mRefreshLayout.setOnRefreshListener(HomeFragment$$Lambda$23.lambdaFactory$(this));
    }
    
    private void setupRunStatusText() {
        if (this.mRunStatusView != null) {
            UiThreadExecutor.cancelAll("run_status");
            this.mRunStatusView.setEllipsize(TextUtils$TruncateAt.MARQUEE);
            this.mRunStatusView.setSingleLine(true);
            this.mRunStatusView.setSelected(false);
            this.mRunStatusView.setFocusable(false);
            this.mRunStatusView.setFocusableInTouchMode(false);
            UiThreadExecutor.runTask("run_status", HomeFragment$$Lambda$20.lambdaFactory$(this), 2000L);
        }
    }
    
    private void showPushDialog(final List<PushInfo> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        final PushInfo pushInfo = list.get(0);
        if (list.size() == 1) {
            NotificationBroadcastReceiver.showNormal(pushInfo, (PopupWindow$OnDismissListener)null);
            return;
        }
        NotificationBroadcastReceiver.showNormal(pushInfo, HomeFragment$$Lambda$21.lambdaFactory$(this, (List)list, pushInfo));
    }
    
    private void startTrainRunningAnimation() {
        if (this.mTrainRunningAnim != null) {
            this.mTrainRunningAnim.startTrainAnim();
        }
    }
    
    private void updateMyStation(final List<StationDeparture> fragmentData) {
        final ArrayList<MyStationCardLocationRootFragment> list = new ArrayList<MyStationCardLocationRootFragment>();
        final Map<String, V> map = new Gson().fromJson((String)this.mPrefAppData.directionNameJson().get(), new HomeFragment$5(this).getType());
        final Iterator<Map.Entry<String, V>> iterator = map.entrySet().iterator();
    Label_0141_Outer:
        while (iterator.hasNext()) {
            final String anObject = iterator.next().getKey();
            final int n = 0;
            final Iterator<StationDeparture> iterator2 = fragmentData.iterator();
            while (true) {
                do {
                    final int n2 = n;
                    if (iterator2.hasNext()) {
                        continue Label_0141_Outer;
                    }
                    if (n2 == 0) {
                        iterator.remove();
                        continue Label_0141_Outer;
                    }
                    continue Label_0141_Outer;
                } while (!iterator2.next().getStationId().equals(anObject));
                final int n2 = 1;
                continue;
            }
        }
        ((PrefAppData_.PrefAppDataEditor_)this.mPrefAppData.edit().directionNameJson().put(new Gson().toJson(map))).apply();
        list.add(MyStationCardLocationRootFragment.newInstance((MyStationCardFragment$LauncherStatusListener)this));
        final Iterator<StationDeparture> iterator3 = fragmentData.iterator();
        while (iterator3.hasNext()) {
            final MyStationCardFragment build = MyStationCardFragment_.builder().stationDeparture((StationDeparture)iterator3.next()).build();
            new MyStationCardPresenterImpl((MyStationCardContract$View)build);
            list.add((MyStationCardLocationRootFragment)build);
        }
        if (fragmentData.size() < 10) {
            final MyStationCardAddFragment instance = MyStationCardAddFragment.newInstance();
            new MyStationCardAddPresenterImpl((DeviceDataRepository)DeviceDataRepository_.getInstance_(this.getContext()), (MasterDataRepository)MasterDataRepository_.getInstance_(this.getContext()), (MyStationCardAddContract$View)instance);
            list.add((MyStationCardLocationRootFragment)instance);
        }
        this.mPagerAdapter.setLauncherListener((MyStationCardFragment$LauncherStatusListener)this);
        this.mPagerAdapter.updateDataSource((List)list);
        this.mPagerAdapter.setFragmentData((List)fragmentData);
        this.mPagerAdapter.notifyDataSetChanged();
        final int currentItem = this.mStationsContainer.getCurrentItem();
        if (this.mIsFirstOpen) {
            this.mIsFirstOpen = false;
            this.mStationsContainer.setCurrentItem(1);
            this.mLastCardSum = fragmentData.size();
        }
        else if (fragmentData.size() < this.mLastCardSum) {
            this.mLastCardSum = fragmentData.size();
            if (this.mStationsContainer.getCurrentItem() > this.mLastCardSum + 1) {
                this.mStationsContainer.setCurrentItem(this.mLastCardSum + 1);
            }
        }
        if (currentItem == this.mStationsContainer.getCurrentItem()) {
            this.mStationsContainer.setCurrentItem(0);
            this.mStationsContainer.setCurrentItem(currentItem);
        }
    }
    
    @Click({ 2131690223 })
    void chooseGetOffStationClick() {
        final List nextStationList = this.mPresenter.getNextStationList();
        if (this.mGetOffStation == null) {
            this.mChosenGetOffIndex = 0;
        }
        else {
            this.mChosenGetOffIndex = nextStationList.indexOf(this.mGetOffStation);
        }
        final int mChosenGetOffIndex = this.mChosenGetOffIndex;
        final View inflate = View.inflate(this.getContext(), 2130968625, (ViewGroup)null);
        ((TextView)inflate.findViewById(2131689669)).setText((CharSequence)this.getString(2131230834));
        new AlertDialog.Builder((Context)this.mActivity, 2131362018).setCustomTitle(inflate).setAdapter((ListAdapter)new HomeFragment$3(this, nextStationList), null).setPositiveButton(this.getString(2131231038), HomeFragment$$Lambda$15.lambdaFactory$(this, mChosenGetOffIndex, nextStationList)).setNegativeButton(this.getString(2131231100), HomeFragment$$Lambda$16.lambdaFactory$()).setCancelable(true).create().show();
    }
    
    @Click({ 2131689761 })
    void closeNotify() {
        this.mHavereadEmergData.add(this.mUnreadEmergData.get(0));
        if (this.mEmergCheckBox.isChecked()) {
            this.saveEmeryId(this.mUnreadEmergData.get(0).getNoticeId());
        }
        this.mUnreadEmergData.remove(0);
        if (this.mUnreadEmergData.size() != 0) {
            this.setupNewEmerg();
            return;
        }
        this.hideEmergView();
    }
    
    @Click({ 2131690227 })
    void deleteCheckInClick() {
        Exclusive.Normal().tap(HomeFragment$$Lambda$17.lambdaFactory$(this));
    }
    
    public void deleteCheckInView() {
        this.mReservationLayout.setVisibility(8);
        this.mStopStationView.setVisibility(8);
        final RelativeLayout$LayoutParams layoutParams = (RelativeLayout$LayoutParams)this.mStopStationDetailView.getLayoutParams();
        layoutParams.height = 0;
        this.mStopStationDetailView.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
        this.endHeight = 0;
        this.mChevronIV.setImageResource(2130837663);
        this.mGetOffStation = null;
        this.mMarkPosition = 0;
    }
    
    @Click({ 2131689763 })
    void emergContentClick() {
        final List<Boolean> viaBrowserList = this.mUnreadEmergData.get(0).getViaBrowserList();
        if (viaBrowserList != null && !viaBrowserList.isEmpty()) {
            if (!viaBrowserList.get(0)) {
                this.mActivity.modelActivity((ActivityIntentBuilder)WebViewActivity_.intent((Context)this.mActivity).extra("web_view_url", (String)this.mUnreadEmergData.get(0).getToUrlList().get(0)));
                return;
            }
            this.openUrl((String)this.mUnreadEmergData.get(0).getToUrlList().get(0));
        }
    }
    
    @Click({ 2131689758 })
    void emergViewClick() {
    }
    
    public void findTrainSuccess(final String s, final String s2, final int n) {
        this.mIsFromLink = true;
        this.mActivity.modelActivity(StationPositionActivity_.intent(this.getContext()).routeId(s).trainId(s2).sectionNo(n));
    }
    
    public void getBaseBallStatus() {
        this.mPresenter.getBaseBallStatus();
    }
    
    public void getCheckin() {
        this.mPresenter.getCheckin();
    }
    
    public void getEmerg() {
        this.mPresenter.getEmerg();
    }
    
    @SuppressLint({ "StringFormatInvalid" })
    public void getSharedCheckinDatas(final List<CheckInData> list) {
        final ArrayList list2 = new ArrayList((Collection<? extends E>)Arrays.asList(this.mSharedId.split("\\.")));
        final HashMap<Object, Object> hashMap = Maps.newHashMap();
        Stream.of((Iterable<?>)list).forEach(HomeFragment$$Lambda$10.lambdaFactory$((HashMap)hashMap));
        final ArrayList<Object> arrayList = Lists.newArrayList((Iterable<?>)hashMap.values());
        final Optional<CheckInData> first = Stream.of((Iterable<? extends CheckInData>)arrayList).filter(HomeFragment$$Lambda$11.lambdaFactory$(list2)).findFirst();
        if (arrayList.size() <= 5) {
            this.saveSharedData(CheckinUtils.insertShareUrlIdToResponse((List)arrayList, (List)this.mAllSharedIds));
            if (first.isPresent()) {
                if (!TextUtils.equals((CharSequence)first.get().getStatus(), (CharSequence)"210") && !TextUtils.equals((CharSequence)first.get().getStatus(), (CharSequence)"120")) {
                    this.mPresenter.getHeadlines();
                    return;
                }
                this.mPresenter.findSelectedTrain(first.get().getLineId(), first.get().getTrainNo());
            }
            return;
        }
        this.mPresenter.getHeadlines();
        new AlertDialog.Builder(this.getContext()).setTitle(this.getString(2131230849)).setMessage(String.format(this.getString(2131230825), String.valueOf(5))).setPositiveButton(this.getString(2131231038), HomeFragment$$Lambda$12.lambdaFactory$()).show();
    }
    
    public void initScrollViewBackground() {
        this.mScrollView.setBackground((Drawable)new GradientDrawable(GradientDrawable$Orientation.BOTTOM_TOP, new int[] { Constants.HomeBgColorType.getStartColorById((int)this.mWallPaperPref.wallPaperColor().get()).getStartColor(), Constants.HomeBgColorType.getStartColorById((int)this.mWallPaperPref.wallPaperColor().get()).getEndColor() }));
    }
    
    @AfterViews
    void initViews() {
        if (this.mPresenter == null) {
            new HomePresenterImpl(StationsRepository_.getInstance_((Context)this.mActivity), DeviceDataRepository_.getInstance_((Context)this.mActivity), MasterDataRepository_.getInstance_((Context)this.mActivity), (HomeContract$View)this, this.isFromNotification);
        }
        this.initMyStationCardPager();
        this.initScrollViewBackground();
        this.initNextStationRecyclerView();
        this.mStationsRepository = StationsRepository_.getInstance_((Context)this.mActivity);
        this.mTrainView.setImageResource(Constants.HomeTrain.getHomeTrainRes());
        this.mEmergContentBg = this.mEmergContent.getBackground();
        this.mViewpagerContainer.setOnTouchListener(HomeFragment$$Lambda$1.lambdaFactory$(this));
        this.mSupportLine.post(HomeFragment$$Lambda$2.lambdaFactory$(this));
        this.setupRefreshLayout();
    }
    
    public boolean isDestroyed() {
        return !this.isSupportVisible();
    }
    
    @Click({ 2131689759 })
    void notShowNotify() {
        this.mEmergCheckBox.setChecked(!this.mEmergCheckBox.isChecked());
    }
    
    public void onCreate(@Nullable final Bundle bundle) {
        super.onCreate(bundle);
        CTCEventBus.register(this);
        this.mIsFirstOpen = true;
    }
    
    public void onDestroy() {
        super.onDestroy();
        CTCEventBus.unregister(this);
    }
    
    public void onFooterStatusChange(final boolean b) {
        final String s = (String)this.mWallPaperPref.wallPaperUrl().get();
        if (!b || TextUtils.isEmpty((CharSequence)s)) {
            this.mWallPaper.setVisibility(8);
            this.mWallPaperWebview.setVisibility(8);
            return;
        }
        if (s.startsWith("http") && !s.endsWith(".png") && !s.endsWith(".jpg") && !s.endsWith(".gif")) {
            this.mWallPaperWebview.setVisibility(0);
            this.mWallPaper.setVisibility(8);
            this.mWallPaperWebview.getSettings().setUseWideViewPort(true);
            this.mWallPaperWebview.getSettings().setLoadWithOverviewMode(true);
            this.mWallPaperWebview.getSettings().setJavaScriptEnabled(true);
            this.mWallPaperWebview.loadUrl(s);
            this.mWallPaperWebview.setWebViewClient((WebViewClient)new HomeFragment$1(this));
            return;
        }
        this.mWallPaperWebview.setVisibility(8);
        this.mWallPaper.setVisibility(0);
        this.mWallPaper.postDelayed(HomeFragment$$Lambda$13.lambdaFactory$(this, s), 300L);
    }
    
    public void onPause() {
        super.onPause();
        this.mPresenter.stop();
    }
    
    @Subscribe
    public void onReceiveEventBus(final String s) {
        switch (s) {
            case "my_station_changed": {
                if (!this.isSupportVisible()) {
                    this.mIsMyStationChanged = true;
                    return;
                }
                this.mPresenter.getMyStationDepartures(true);
            }
            case "background_receive_push": {
                this.isFromNotification = true;
                if (this.mPresenter != null) {
                    this.mPresenter.setIsFromNotification(true);
                    return;
                }
                break;
            }
            case "background_open_push": {
                this.isFromNotification = false;
                this.mPresenter.setIsFromNotification(false);
            }
        }
    }
    
    public void onResume() {
        super.onResume();
        UiThreadExecutor.cancelAll("run_status");
    }
    
    public void onSupportInvisible() {
        super.onSupportInvisible();
        UiThreadExecutor.cancelAll("get_check_in");
        this.mPresenter.stop();
        this.mPresenter.stopReceiveDataEvent();
        if (this.mTrainRunningAnim != null) {
            this.mTrainRunningAnim.stop();
        }
    }
    
    public void onSupportVisible() {
        super.onSupportVisible();
        this.mRefreshLayout.setRefreshing(false);
        this.mPresenter.startReceiveDataEvent();
        this.mPresenter.start();
        if (this.mIsMyStationChanged) {
            this.mPresenter.getMyStationDepartures(true);
        }
        if (this.mIsFromLink) {
            this.mIsFromLink = false;
            this.mPresenter.getHeadlines();
        }
        this.initTopImage();
        this.setupRunStatusText();
        this.resetTrainAndBeaconPosition();
        final Uri appSource = AppStatusManager_.getInstance_((Context)this.mActivity).getAppSource();
        if (appSource != null) {
            this.mSharedId = appSource.getQueryParameter("c");
            if (!TextUtils.isEmpty((CharSequence)this.mSharedId)) {
                final List<String> list = Stream.of((Iterable<?>)this.getSharedDatas()).map((Function<? super Object, ? extends String>)HomeFragment$$Lambda$3.lambdaFactory$()).toList();
                if (!list.contains(this.mSharedId)) {
                    list.add(this.mSharedId);
                }
                this.mAllSharedIds = list;
                this.mPresenter.getSharedDatas((List)list);
            }
            else {
                final String queryParameter = appSource.getQueryParameter("f");
                if (TextUtils.equals((CharSequence)queryParameter, (CharSequence)"position")) {
                    final String queryParameter2 = appSource.getQueryParameter("l");
                    final String queryParameter3 = appSource.getQueryParameter("s");
                    final int n = 1;
                    if (!TextUtils.isEmpty((CharSequence)queryParameter2)) {
                        int n2 = n;
                        if (TextUtils.equals((CharSequence)queryParameter2, (CharSequence)"L001")) {
                            n2 = n;
                            if (BaseConfig.IKEBUKURO_CHICHIBULINE_STATION_IDS.contains(queryParameter3)) {
                                n2 = 2;
                            }
                        }
                        this.mIsFromLink = true;
                        this.mActivity.modelActivity(StationPositionActivity_.intent(this.getContext()).routeId(queryParameter2).stationId(queryParameter3).sectionNo(n2));
                    }
                }
                else if (TextUtils.equals((CharSequence)queryParameter, (CharSequence)"timetable")) {
                    final String queryParameter4 = appSource.getQueryParameter("s");
                    if (!TextUtils.isEmpty((CharSequence)queryParameter4)) {
                        this.mStationId = queryParameter4;
                        this.mPresenter.requestStationLines(queryParameter4);
                    }
                }
            }
        }
        if (this.mIsHomeStartFirst && Constants.IS_FROM_RUNSTATUS && Constants.IS_FIRST_START_FROM_RUNSTATUS_NOTIFICATION) {
            this.mPresenter.getThreeNoticeMessages();
            Constants.IS_FROM_RUNSTATUS = false;
            Constants.IS_FIRST_START_FROM_RUNSTATUS_NOTIFICATION = false;
            this.mIsHomeStartFirst = false;
        }
        else if (this.mIsHomeStartFirst && !this.isFromNotification && !this.mIsFromLink) {
            this.mPresenter.getThreeNoticeMessages();
            this.mIsHomeStartFirst = false;
        }
    }
    
    @Click({ 2131689767 })
    void reserveClick() {
        this.mActivity.modelActivity((ActivityIntentBuilder)WebViewActivity_.intent(this.getContext()).extra("web_view_url", "https://events.seibuapp.jp/cp/Train/checkin?" + "userId=" + (String)this.mPrefAppPotAccount.apppotUserId().get() + "&appPotToken=" + AppPotManager.getToken()));
    }
    
    public void setPresenter(final HomeContract$Presenter mPresenter) {
        this.mPresenter = mPresenter;
    }
    
    public void setupBaseballIcon(final String s) {
        this.mIsGameIconVisible = (s != null);
        if (this.mEmergBackground.isShown()) {
            if (s != null) {
                this.mBaseballIcon.setOnClickListener(HomeFragment$$Lambda$4.lambdaFactory$(this, s));
            }
            return;
        }
        if (s == null) {
            this.mBaseballIcon.setVisibility(8);
            return;
        }
        this.mBaseballIcon.setVisibility(0);
        this.mBaseballIcon.setOnClickListener(HomeFragment$$Lambda$5.lambdaFactory$(this, s));
    }
    
    public void setupMyLine(final List<RunStatusSpecific> list) {
        final String s = (String)this.mMyLinePref.myLineIds().get();
        if (TextUtils.isEmpty((CharSequence)s)) {
            this.mMyLineLayout.setVisibility(4);
            return;
        }
        this.initMyLine();
        final ArrayList<String> arrayList = Lists.newArrayList(s.split(","));
        int n = 0;
        for (final RunStatusSpecific runStatusSpecific : list) {
            if (arrayList.contains(runStatusSpecific.getLineId())) {
                if (n == 0) {
                    this.mMyLineLayout_1.setVisibility(0);
                    this.setupMyLineStatus(runStatusSpecific, this.mLineIcon_1, this.mLineName_1);
                }
                else if (n == 1) {
                    this.mMyLineLayout_2.setVisibility(0);
                    this.setupMyLineStatus(runStatusSpecific, this.mLineIcon_2, this.mLineName_2);
                }
                else if (n == 2) {
                    this.mMyLineLayout_3.setVisibility(0);
                    this.setupMyLineStatus(runStatusSpecific, this.mLineIcon_3, this.mLineName_3);
                }
                ++n;
            }
        }
        if (n > 0) {
            this.mMyLineLayout.setVisibility(0);
            return;
        }
        this.mMyLineLayout.setVisibility(4);
    }
    
    public void setupNoticeCount(final long n) {
        if (n > 0L) {
            this.mNoticeBtn.setBackgroundResource(2130837858);
            return;
        }
        this.mNoticeBtn.setBackgroundResource(2130837857);
    }
    
    public void setupRunStatus(final RunStatusData runStatusData) {
        if (runStatusData != null) {
            this.mRunStatusView.setText((CharSequence)runStatusData.getOperationDetail());
            if (TextUtils.equals((CharSequence)runStatusData.getStatus(), (CharSequence)"200")) {
                this.mRunStatusView.setTextColor(ContextCompat.getColor(this.getContext(), 2131558408));
            }
            else {
                this.mRunStatusView.setTextColor(ContextCompat.getColor(this.getContext(), 2131558477));
            }
        }
        else {
            this.mRunStatusView.setText((CharSequence)"");
        }
        this.setupRunStatusText();
    }
    
    @Click({ 2131690228 })
    void shareClick() {
        Exclusive.Activity().start(HomeFragment$$Lambda$19.lambdaFactory$(this));
    }
    
    public void shareUrl(final String str) {
        final Intent intent = new Intent("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.SUBJECT", this.getString(2131230983));
        intent.putExtra("android.intent.extra.TEXT", str + "\n" + this.getString(2131230982));
        intent.setType("text/plain");
        this.startActivity(Intent.createChooser(intent, (CharSequence)this.getString(2131230837)));
    }
    
    public void showEmergInfo(final List<NoticeMessageData> list) {
        Stream.of((Iterable<?>)list).forEach(HomeFragment$$Lambda$9.lambdaFactory$(this, (List)Stream.of((Iterable<?>)this.mUnreadEmergData).map((Function<? super Object, ?>)HomeFragment$$Lambda$7.lambdaFactory$()).toList(), (List)Stream.of((Iterable<?>)this.mHavereadEmergData).map((Function<? super Object, ?>)HomeFragment$$Lambda$8.lambdaFactory$()).toList()));
        if (!this.mEmergBackground.isShown() && !this.mUnreadEmergData.isEmpty()) {
            this.setupNewEmerg();
        }
    }
    
    public void showErrorMessage() {
        this.showErrorMessage(this.getString(2131230853));
    }
    
    @Click({ 2131689743 })
    void showNoticeList() {
        this.mPresenter.getNoticeMessages();
    }
    
    public void showNoticeMessagePage(final ArrayList<NoticeMessageData> list) {
        final NoticeListFragment build = NoticeListFragment_.builder().messageList((ArrayList)list).build();
        new NoticeListPresenterImpl((DeviceDataRepository)DeviceDataRepository_.getInstance_(this.getContext()), (NoticeListContract$View)build);
        this.start((ISupportFragment)build);
    }
    
    public void showPushNotification(final List<PushInfo> list) {
        if (PopWindow.getWindow() == null) {
            this.showPushDialog(list);
            return;
        }
        PopWindow.addEndDismissListener(HomeFragment$$Lambda$6.lambdaFactory$(this, (List)list));
    }
    
    @Click({ 2131689745 })
    void showRunningInfo() {
        this.mPresenter.getRunStatusData();
    }
    
    public void showStationTimeTableTop() {
        if (!TextUtils.isEmpty((CharSequence)this.mPresenter.getStationName(this.mStationId))) {
            this.mIsFromLink = true;
            this.mActivity.modelActivity(TimeTableTopActivity_.intent((Context)this.mActivity).romajiName(this.mPresenter.getStationRomajiName(this.mStationId)).kanjiName(this.mPresenter.getStationName(this.mStationId)).stationId(this.mStationId));
        }
    }
    
    @Click({ 2131689739 })
    void startAnimation() {
        this.startTrainRunningAnimation();
    }
    
    @Click({ 2131690229 })
    void stopStationClick() {
        if (this.endHeight == 0) {
            this.startHeight = 0;
            this.endHeight = this.height;
            this.mChevronIV.setImageResource(2130837664);
            this.mStopStationDetailView.scrollTo(0, 0);
            this.scrollCheckinListToMark();
        }
        else {
            this.startHeight = this.height;
            this.endHeight = 0;
            this.mChevronIV.setImageResource(2130837663);
        }
        final ValueAnimator setDuration = ValueAnimator.ofInt(new int[] { this.startHeight, this.endHeight }).setDuration(300L);
        setDuration.addUpdateListener(HomeFragment$$Lambda$14.lambdaFactory$(this));
        setDuration.addListener((Animator$AnimatorListener)new HomeFragment$2(this));
        setDuration.start();
    }
    
    public void toArrivalPush(final TrainInfo trainInfo) {
        this.mActivity.modelActivity(ArrivalPushActivity_.intent(this.getContext()).mTrainInfo(trainInfo));
    }
    
    public void toRunningInfo(final RunStatusDataWrapper runStatusDataWrapper) {
        if (runStatusDataWrapper != null) {
            this.mActivity.modelActivity(RunStatusActivity_.intent((Context)this.mActivity).statusInfo(runStatusDataWrapper));
            return;
        }
        this.showErrorMessage(this.getString(2131230853));
    }
    
    @Click({ 2131689740 })
    void toSettingArrival() {
        this.mPresenter.getCurrentTrainInfo();
    }
    
    @Click({ 2131690120 })
    void trainDetailClick() {
        Exclusive.Activity().start(HomeFragment$$Lambda$18.lambdaFactory$(this));
    }
    
    public void updateStopStationDetailView(final TrainInfo trainInfo, final TrainTimeTable mGetOffStation, final HomeCheckinDataUtils homeCheckinDataUtils, final boolean b) {
        this.mGetOffStationTV.setText((CharSequence)mGetOffStation.getStationName());
        this.mGetOffStation = mGetOffStation;
        this.setMarkPosition(homeCheckinDataUtils.getMarkStationIndex());
        if (trainInfo.getTimetable().size() <= 1) {
            this.deleteCheckInView();
            return;
        }
        final String nextStopStationName = homeCheckinDataUtils.getNextStopStationName();
        if (!trainInfo.isOnRail() || TextUtils.isEmpty((CharSequence)nextStopStationName)) {
            this.mNextStationTV.setVisibility(8);
            this.mNextStationBeforeTV.setVisibility(8);
            this.mNextStationAfterTV.setVisibility(8);
        }
        else {
            this.mNextStationTV.setVisibility(0);
            this.mNextStationBeforeTV.setVisibility(0);
            this.mNextStationAfterTV.setVisibility(0);
            this.mNextStationTV.setText((CharSequence)nextStopStationName);
        }
        this.mTrainTypeBtn.setImageResource(BaseConfig.TrainType.get(trainInfo.getTrainType()).getBgDrawable());
        this.mEndStationTV.setText((CharSequence)trainInfo.getEndStationName());
        if (!TextUtils.isEmpty((CharSequence)trainInfo.getEndStationNo()) && trainInfo.getEndStationNo().length() >= 4) {
            this.mEndStationView.setVisibility(0);
            this.mEndStationView.setStationNumber(trainInfo.getEndStationNo());
            return;
        }
        this.mEndStationView.setVisibility(4);
    }
    
    public void updateStopStationView(final CheckInData checkInData) {
        if (checkInData == null) {
            this.deleteCheckInView();
        }
        else if (TextUtils.equals((CharSequence)"210", (CharSequence)checkInData.getStatus())) {
            this.mReservationLayout.setVisibility(8);
            this.mStopStationView.setVisibility(0);
            this.mStopStationDetailView.setVisibility(0);
            final String carNo = checkInData.getCarNo();
            if (TextUtils.isEmpty((CharSequence)carNo)) {
                this.mTrainStatus.setVisibility(8);
                return;
            }
            this.mTrainStatus.setVisibility(0);
            this.mTrainStatus.setText((CharSequence)String.format(this.getString(2131230833), carNo));
        }
        else if (TextUtils.equals((CharSequence)"120", (CharSequence)checkInData.getStatus())) {
            this.deleteCheckInView();
            this.mReservationLayout.setVisibility(0);
        }
    }
    
    public void updateViews(final HomeData homeData, final boolean b) {
        AppEventBus.hideProgress();
        if (this.mTrainRunningAnim == null) {
            this.mTrainRunningAnim = new TrainRunningAnim(this.getContext(), this.mTrainView, (View)this.mTrainAndBeacon);
        }
        this.mIsMyStationChanged = !b;
        this.updateMyStation(homeData.getMyStationInfoList());
    }
}
