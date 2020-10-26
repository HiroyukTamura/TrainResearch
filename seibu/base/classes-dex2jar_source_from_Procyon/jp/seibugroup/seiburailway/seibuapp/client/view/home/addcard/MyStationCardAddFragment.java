// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.view.home.addcard;

import jp.seibugroup.seiburailway.seibuapp.client.view.addstation.AddStationFragment$FragmentType;
import jp.seibugroup.seiburailway.seibuapp.client.view.addstation.AddStationActivity_;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.master.BaseStation;
import java.util.ArrayList;
import jp.seibugroup.seiburailway.seibuapp.client.event.CTCEventBus;
import android.support.annotation.Nullable;
import android.os.Bundle;
import org.androidannotations.annotations.AfterViews;
import jp.seibugroup.seiburailway.seibuapp.client.data.repository.MasterDataRepository;
import jp.seibugroup.seiburailway.seibuapp.client.data.repository.DeviceDataRepository;
import jp.seibugroup.seiburailway.seibuapp.client.data.repository.MasterDataRepository_;
import jp.seibugroup.seiburailway.seibuapp.client.data.repository.DeviceDataRepository_;
import com.google.common.eventbus.Subscribe;
import org.androidannotations.annotations.Click;
import com.feilang.mvpproject.util.Exclusive;
import android.view.View;
import jp.seibugroup.seiburailway.seibuapp.client.view.home.anim.LocationCardViewAnim;
import org.androidannotations.annotations.ViewById;
import android.widget.Button;
import org.androidannotations.annotations.EFragment;
import jp.seibugroup.seiburailway.seibuapp.client.view.base.CTCBaseFragment;

@EFragment(2130968660)
public class MyStationCardAddFragment extends CTCBaseFragment implements MyStationCardAddContract$View
{
    @ViewById(2131689808)
    Button mAddBtn;
    private LocationCardViewAnim mAddStaitonCardViewAnim;
    @ViewById(2131689785)
    View mCardView;
    MyStationCardAddContract$Presenter mPresenter;
    
    private void changeFooter(final Boolean b) {
        if (this.mCardView != null) {
            this.getAddStaitonCardViewAnim().toggle((boolean)b);
        }
    }
    
    public static MyStationCardAddFragment newInstance() {
        return MyStationCardAddFragment_.builder().build();
    }
    
    private void setupBtnStatus() {
        this.mAddBtn.setClickable(false);
        this.mPresenter.getMyStationCount();
    }
    
    @Click({ 2131689808 })
    void addMyStation() {
        Exclusive.Normal().tap(MyStationCardAddFragment$$Lambda$1.lambdaFactory$(this));
    }
    
    @Subscribe
    public void changeBoolean(final Boolean b) {
        this.changeFooter(b);
    }
    
    public LocationCardViewAnim getAddStaitonCardViewAnim() {
        if (this.mAddStaitonCardViewAnim == null) {
            this.mAddStaitonCardViewAnim = LocationCardViewAnim.newInstance(this.getContext(), this.mCardView);
        }
        return this.mAddStaitonCardViewAnim;
    }
    
    @AfterViews
    void initViews() {
        if (this.mPresenter == null) {
            new MyStationCardAddPresenterImpl((DeviceDataRepository)DeviceDataRepository_.getInstance_(this.getContext()), (MasterDataRepository)MasterDataRepository_.getInstance_(this.getContext()), (MyStationCardAddContract$View)this);
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
    
    public void onPause() {
        super.onPause();
        this.mPresenter.stop();
        this.mAddStaitonCardViewAnim = null;
    }
    
    public void onResume() {
        super.onResume();
        this.mPresenter.start();
        this.getAddStaitonCardViewAnim().initFooterView(this.mCardView);
        this.setupBtnStatus();
    }
    
    public void onSupportInvisible() {
        super.onSupportInvisible();
        this.mPresenter.stopReceiveDataEvent();
    }
    
    public void onSupportVisible() {
        super.onSupportVisible();
        this.mPresenter.startReceiveDataEvent();
    }
    
    public void setPresenter(final MyStationCardAddContract$Presenter mPresenter) {
        this.mPresenter = mPresenter;
    }
    
    public void setupAddBtn(final boolean enabled) {
        if (this.mAddBtn != null) {
            this.mAddBtn.setClickable(true);
            this.mAddBtn.setEnabled(enabled);
        }
    }
    
    public void toAddStation(final ArrayList<BaseStation> list) {
        this.mActivity.modelActivity(AddStationActivity_.intent(this.getContext()).mType(AddStationFragment$FragmentType.BACK_LAST_PAGE).mSavedStation((ArrayList)list));
    }
}
