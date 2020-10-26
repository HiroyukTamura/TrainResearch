// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.view.tutorial;

import android.content.Context;
import jp.seibugroup.seiburailway.seibuapp.client.view.addstation.AddStationActivity_;
import com.google.common.eventbus.Subscribe;
import org.androidannotations.annotations.Click;
import com.feilang.mvpproject.base.BaseFragment;
import jp.seibugroup.seiburailway.seibuapp.client.data.repository.DeviceDataRepository;
import jp.seibugroup.seiburailway.seibuapp.client.data.repository.DeviceDataRepository_;
import android.content.DialogInterface$OnClickListener;
import org.androidannotations.annotations.OnActivityResult;
import android.content.Intent;
import org.androidannotations.annotations.AfterViews;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.graphics.drawable.GradientDrawable$Orientation;
import jp.seibugroup.seiburailway.seibuapp.client.event.CTCEventBus;
import android.widget.TextView;
import org.androidannotations.annotations.ViewById;
import android.widget.ScrollView;
import org.androidannotations.annotations.InstanceState;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.master.BaseStation;
import org.androidannotations.annotations.EFragment;
import jp.seibugroup.seiburailway.seibuapp.client.view.base.CTCBaseFragment;

@EFragment(2130968693)
public class TutorialStationSettingFragment extends CTCBaseFragment implements TutorialStationSettingContract$View
{
    @InstanceState
    BaseStation mChooseStation;
    TutorialStationSettingContract$Presenter mPresenter;
    @ViewById(2131689949)
    ScrollView mRootLayout;
    @ViewById(2131689962)
    TextView mStationText;
    
    public static TutorialStationSettingFragment newInstance() {
        return TutorialStationSettingFragment_.builder().build();
    }
    
    private void setStationName(final String s) {
        this.mStationText.setText((CharSequence)String.format(this.getString(2131231176), s));
    }
    
    @AfterViews
    void initViews() {
        CTCEventBus.register(this);
        this.mRootLayout.setBackground((Drawable)new GradientDrawable(GradientDrawable$Orientation.TOP_BOTTOM, new int[] { ContextCompat.getColor(this.getContext(), 2131558427), ContextCompat.getColor(this.getContext(), 2131558428) }));
        if (this.mChooseStation != null) {
            this.setStationName(this.mChooseStation.getKanjiName());
            return;
        }
        (this.mChooseStation = new BaseStation()).setId("S0440TZ");
    }
    
    public void onDestroy() {
        super.onDestroy();
        CTCEventBus.unregister(this);
    }
    
    public void onPause() {
        super.onPause();
        this.mPresenter.stop();
    }
    
    public void onResume() {
        super.onResume();
        this.mPresenter.start();
    }
    
    @OnActivityResult(1)
    public void onSetStationSuccess(final Intent intent) {
        if (intent != null) {
            this.mChooseStation = (BaseStation)intent.getSerializableExtra("station_name");
            if (this.mStationText != null && this.mChooseStation != null) {
                this.setStationName(this.mChooseStation.getKanjiName());
            }
        }
    }
    
    public void saveDataFailed() {
        this.mActivity.showNetworkErrorMessage(this.getString(2131231160), this.getString(2131231159), null);
    }
    
    public void saveStationSuccess() {
        final TutorialNoticeSettingFragment instance = TutorialNoticeSettingFragment.newInstance();
        new TutorialNoticeSettingPresenterImpl((DeviceDataRepository)DeviceDataRepository_.getInstance_(this.getContext()), (TutorialNoticeSettingContract$View)instance);
        this.startFragmentWithFade(2131689660, (BaseFragment)instance, false);
    }
    
    public void setPresenter(final TutorialStationSettingContract$Presenter mPresenter) {
        this.mPresenter = mPresenter;
    }
    
    @Click({ 2131689966 })
    void setStationFinish() {
        if (this.mChooseStation != null) {
            this.mPresenter.saveTutorialStation(this.mChooseStation);
            return;
        }
        this.saveStationSuccess();
    }
    
    @Subscribe
    public void stationSettingsChanged(final BaseStation mChooseStation) {
        this.mChooseStation = mChooseStation;
        if (this.mStationText != null && mChooseStation != null) {
            this.setStationName(this.mChooseStation.getKanjiName());
        }
    }
    
    @Click({ 2131689963 })
    void toStationList() {
        final Intent intent = new Intent((Context)this.mActivity, (Class)AddStationActivity_.class);
        intent.putExtra("isFirstOpenApp", true);
        this.startActivityForResult(intent, 1);
    }
}
