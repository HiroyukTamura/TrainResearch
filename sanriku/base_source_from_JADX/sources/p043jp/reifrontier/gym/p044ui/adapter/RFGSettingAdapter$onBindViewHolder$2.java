package p043jp.reifrontier.gym.p044ui.adapter;

import android.widget.CompoundButton;
import kotlin.Metadata;
import p043jp.reifrontier.gym.domain.app.RFGSetting;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, mo21739d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/widget/CompoundButton;", "kotlin.jvm.PlatformType", "isChecked", "", "onCheckedChanged"}, mo21740k = 3, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.ui.adapter.RFGSettingAdapter$onBindViewHolder$2 */
final class RFGSettingAdapter$onBindViewHolder$2 implements CompoundButton.OnCheckedChangeListener {
    final /* synthetic */ RFGSetting $setting;
    final /* synthetic */ RFGSettingAdapter this$0;

    RFGSettingAdapter$onBindViewHolder$2(RFGSettingAdapter rFGSettingAdapter, RFGSetting rFGSetting) {
        this.this$0 = rFGSettingAdapter;
        this.$setting = rFGSetting;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        this.this$0.getMListener().m4601switch(this.$setting, z);
    }
}
