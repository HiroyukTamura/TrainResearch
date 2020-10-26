// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.view.checkin;

import jp.seibugroup.seiburailway.seibuapp.client.event.CTCEventBus;
import android.support.annotation.Nullable;
import android.os.Bundle;
import org.androidannotations.annotations.AfterViews;
import android.view.WindowManager$LayoutParams;
import android.view.Display;
import me.yokeyword.fragmentation.ISupportFragment;
import jp.seibugroup.seiburailway.seibuapp.client.view.checkin.setgetoff.ChooseGetOffFragment;
import com.google.common.eventbus.Subscribe;
import android.text.TextUtils;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.TrainInfo;
import org.androidannotations.annotations.Extra;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.DestinationsInfo;
import org.androidannotations.annotations.EActivity;
import jp.seibugroup.seiburailway.seibuapp.client.view.base.CTCBaseAppCompatActivity;

@EActivity(2130968606)
public class CheckinActivity extends CTCBaseAppCompatActivity
{
    @Extra
    DestinationsInfo destinationsInfo;
    @Extra
    String mFromStationId;
    @Extra
    String mStationId;
    @Extra
    String mStationName;
    @Extra
    TrainInfo trainInfo;
    
    @Subscribe
    public void checkinByWeb(final String s) {
        if (TextUtils.equals((CharSequence)s, (CharSequence)"checkin_by_web")) {
            this.finish();
        }
    }
    
    @AfterViews
    void initViews() {
        this.setFinishOnTouchOutside(false);
        final Display defaultDisplay = this.getWindowManager().getDefaultDisplay();
        final WindowManager$LayoutParams attributes = this.getWindow().getAttributes();
        attributes.width = defaultDisplay.getWidth();
        this.getWindow().setAttributes(attributes);
        if (this.getSupportFragmentManager().findFragmentById(2131689660) == null) {
            this.loadRootFragment(2131689660, (ISupportFragment)ChooseGetOffFragment.newInstance(this.destinationsInfo, this.trainInfo, this.mFromStationId, this.mStationId, this.mStationName));
        }
    }
    
    @Override
    protected void onCreate(@Nullable final Bundle bundle) {
        super.onCreate(bundle);
        CTCEventBus.register(this);
    }
    
    @Override
    protected void onDestroy() {
        super.onDestroy();
        CTCEventBus.unregister(this);
    }
}
