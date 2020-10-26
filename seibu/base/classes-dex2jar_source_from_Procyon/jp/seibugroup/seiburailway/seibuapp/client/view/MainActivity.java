// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.view;

import jp.seibugroup.seiburailway.seibuapp.client.view.arrivalpush.ArrivalPushActivity_;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.TrainInfo;
import android.content.DialogInterface$OnClickListener;
import org.androidannotations.annotations.OnActivityResult;
import jp.seibugroup.seiburailway.seibuapp.client.view.home.anim.LocationCardViewAnim;
import jp.seibugroup.seiburailway.seibuapp.client.view.home.mystation.MyStationCardFragment;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import org.androidannotations.annotations.AfterViews;
import com.feilang.mvpproject.view.common.CommonBottomBar;
import me.yokeyword.fragmentation.SupportFragment;
import me.yokeyword.fragmentation.SupportActivity;
import android.content.Intent;
import jp.seibugroup.seiburailway.seibuapp.client.util.AppUtils;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.RunStatusDataWrapper;
import jp.seibugroup.seiburailway.seibuapp.client.view.runstatus.RunStatusActivity_;
import jp.seibugroup.seiburailway.seibuapp.client.view.notification.NotificationFragment;
import com.feilang.mvpproject.base.BaseFragment;
import java.util.List;
import jp.seibugroup.seiburailway.seibuapp.client.view.stationinfo.StationInfoFragment;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.StationDetailInfo;
import jp.seibugroup.seiburailway.seibuapp.client.remote.fcm.NotificationBroadcastReceiver;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.PushInfo;
import jp.seibugroup.seiburailway.seibuapp.client.util.PopWindow$ContentAdapter;
import com.feilang.mvpproject.base.BaseAppCompatActivity;
import jp.seibugroup.seiburailway.seibuapp.client.util.DebugShakeUtils$ChooseUserAdapter;
import android.app.Activity;
import jp.seibugroup.seiburailway.seibuapp.client.util.PopWindow;
import android.content.Context;
import jp.seibugroup.seiburailway.seibuapp.client.view.tab.TabFifthFragment_;
import jp.seibugroup.seiburailway.seibuapp.client.view.tab.TabFourthFragment_;
import jp.seibugroup.seiburailway.seibuapp.client.view.tab.TabThirdFragment_;
import jp.seibugroup.seiburailway.seibuapp.client.view.tab.TabSecondFragment_;
import jp.seibugroup.seiburailway.seibuapp.client.view.tab.TabFirstFragment_;
import me.yokeyword.fragmentation.ISupportFragment;
import jp.seibugroup.seiburailway.seibuapp.client.view.tab.TabFifthFragment;
import jp.seibugroup.seiburailway.seibuapp.client.view.tab.TabFourthFragment;
import jp.seibugroup.seiburailway.seibuapp.client.view.tab.TabThirdFragment;
import jp.seibugroup.seiburailway.seibuapp.client.view.tab.TabSecondFragment;
import jp.seibugroup.seiburailway.seibuapp.client.view.tab.TabFirstFragment;
import android.os.Bundle;
import jp.seibugroup.seiburailway.seibuapp.client.util.PermissionUtil;
import jp.seibugroup.seiburailway.seibuapp.client.util.Payload;
import org.androidannotations.annotations.sharedpreferences.Pref;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.pref.PrefAppData_;
import jp.seibugroup.seiburailway.seibuapp.client.view.base.CTCBaseMainFragment;
import jp.seibugroup.seiburailway.seibuapp.client.util.DebugShakeUtils;
import org.androidannotations.annotations.ViewById;
import jp.seibugroup.seiburailway.seibuapp.client.view.common.CommonBottomIconsBar;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.EActivity;
import jp.seibugroup.seiburailway.seibuapp.client.view.base.CTCBaseAppCompatActivity;

@EActivity(2130968608)
public class MainActivity extends CTCBaseAppCompatActivity implements View
{
    private static final int FIRST_HOME = 0;
    private static final int FIVE_MY = 4;
    private static final int FOUR_COUPON = 3;
    public static final int REQUEST_BLUETOOTH_ENABLE = 0;
    private static final int SECOND_RIDE = 1;
    private static final int THIRD_EVENT = 2;
    @Extra
    boolean isStartFromNotification;
    @ViewById(2131689661)
    CommonBottomIconsBar mBottomBar;
    private DebugShakeUtils mDebugShakeUtils;
    private CTCBaseMainFragment[] mFragments;
    @Pref
    PrefAppData_ mPrefAppData;
    private MainContract$Presenter mPresenter;
    private int[] mSelectDrawableIds;
    private int[] mUnSelectDrawableIds;
    @Extra
    Payload payload;
    
    public MainActivity() {
        this.mFragments = new CTCBaseMainFragment[5];
        this.mUnSelectDrawableIds = new int[] { 2130837934, 2130837938, 2130837932, 2130837930, 2130837936 };
        this.mSelectDrawableIds = new int[] { 2130837935, 2130837939, 2130837933, 2130837931, 2130837937 };
    }
    
    private void initAndStartBeacon() {
        if (PermissionUtil.isBluetoothSupported() && PermissionUtil.isBluetoothEnabled()) {
            this.mPresenter.startBeaconService();
        }
    }
    
    private void initBottomTab(final Bundle bundle) {
        if (bundle == null) {
            this.mFragments[0] = (CTCBaseMainFragment)TabFirstFragment.newInstance(this.isStartFromNotification);
            this.mFragments[1] = (CTCBaseMainFragment)TabSecondFragment.newInstance();
            this.mFragments[2] = (CTCBaseMainFragment)TabThirdFragment.newInstance();
            this.mFragments[3] = (CTCBaseMainFragment)TabFourthFragment.newInstance();
            this.mFragments[4] = (CTCBaseMainFragment)TabFifthFragment.newInstance();
            this.loadMultipleRootFragment(2131689662, 0, (ISupportFragment)this.mFragments[0], (ISupportFragment)this.mFragments[1], (ISupportFragment)this.mFragments[2], (ISupportFragment)this.mFragments[3], (ISupportFragment)this.mFragments[4]);
            return;
        }
        this.mFragments[0] = this.findFragment((Class<CTCBaseMainFragment>)TabFirstFragment_.class);
        this.mFragments[1] = this.findFragment((Class<CTCBaseMainFragment>)TabSecondFragment_.class);
        this.mFragments[2] = this.findFragment((Class<CTCBaseMainFragment>)TabThirdFragment_.class);
        this.mFragments[3] = this.findFragment((Class<CTCBaseMainFragment>)TabFourthFragment_.class);
        this.mFragments[4] = this.findFragment((Class<CTCBaseMainFragment>)TabFifthFragment_.class);
    }
    
    private void initShake() {
        if (this.mDebugShakeUtils == null) {
            this.mDebugShakeUtils = new DebugShakeUtils((Context)this);
        }
        this.mDebugShakeUtils.setOnShakeListener(MainActivity$$Lambda$2.lambdaFactory$(this));
    }
    
    private void migrateToStationInfoIfNeed() {
        if (Payload.isValid(this.payload)) {
            if (this.payload.getFrom() == 1 || this.payload.getFrom() == 2) {
                final StationDetailInfo stationDetailInfo = Payload.peek(this.payload);
                this.changeTab(1, (BaseFragment)StationInfoFragment.newInstance(stationDetailInfo.getStation().getStationId(), (List)stationDetailInfo.getDepartures()));
            }
            else {
                if (this.payload.getFrom() == 3) {
                    Payload.peek(this.payload);
                    this.changeTab(4, (BaseFragment)NotificationFragment.newInstance());
                    return;
                }
                if (this.payload.getFrom() == 4) {
                    this.modelActivity(RunStatusActivity_.intent((Context)this).statusInfo((RunStatusDataWrapper)Payload.peek(this.payload)));
                }
            }
        }
    }
    
    public void changeTab(final int currentItem, final BaseFragment baseFragment) {
        if (currentItem < this.mFragments.length) {
            this.mBottomBar.setCurrentItem(currentItem);
            this.mFragments[currentItem].pushFragmentOnRoot(baseFragment);
        }
    }
    
    public void checkBlueTooth() {
        if (AppUtils.isFirstOpenApp((Context)this)) {
            ((PrefAppData_.PrefAppDataEditor_)this.mPrefAppData.edit().appVersion().put(AppUtils.getApplicationVersion(this.getContext()))).apply();
            if (PermissionUtil.isBluetoothSupported() && !PermissionUtil.isBluetoothEnabled()) {
                this.startActivityForResult(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"), 0);
            }
        }
    }
    
    @Override
    public Context getContext() {
        return this.getApplicationContext();
    }
    
    public MainContract$Presenter getPresenter() {
        return this.mPresenter;
    }
    
    @AfterViews
    void initViews() {
        this.mBottomBar.post(MainActivity$$Lambda$1.lambdaFactory$(this));
        this.mBottomBar.setData((SupportActivity)this, (SupportFragment[])this.mFragments, this.mSelectDrawableIds, this.mUnSelectDrawableIds, this.getResources().getStringArray(2131623937));
        this.mBottomBar.setOnTabSelectedListener((CommonBottomBar.OnTabSelectedListener)new MainActivity$1(this));
        this.initAndStartBeacon();
    }
    
    @Override
    public void onBackPressedSupport() {
        if (this.getSupportFragmentManager().getBackStackEntryCount() > 1) {
            this.pop();
            return;
        }
        ActivityCompat.finishAfterTransition(this);
    }
    
    @Override
    protected void onCreate(@Nullable final Bundle bundle) {
        super.onCreate(bundle);
        MyStationCardFragment.setFooterStatus(false);
        LocationCardViewAnim.initFooterStatus(false);
        this.initBottomTab(bundle);
        new MainPresenterImpl(this);
        this.mPresenter.start();
        this.mPresenter.startReceiveDataEvent();
        this.checkBlueTooth();
    }
    
    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.mPresenter.stop();
        this.mPresenter.stopReceiveDataEvent();
    }
    
    @Override
    protected void onNewIntent(final Intent intent) {
        super.onNewIntent(intent);
        this.setIntent(intent);
    }
    
    @OnActivityResult(0)
    void onResult(final int n) {
        if (n == -1) {
            this.mPresenter.startBeaconService();
        }
    }
    
    @Override
    protected void onResume() {
        super.onResume();
        this.migrateToStationInfoIfNeed();
    }
    
    @Override
    public void setPresenter(final MainContract$Presenter mPresenter) {
        this.mPresenter = mPresenter;
    }
    
    @Override
    public void showErrorMessage() {
        this.showErrorMessage(this.getString(2131230853), null);
    }
    
    @Override
    public void toArrivalPush(final TrainInfo trainInfo) {
        this.modelActivity(ArrivalPushActivity_.intent((Context)this).mTrainInfo(trainInfo));
    }
}
