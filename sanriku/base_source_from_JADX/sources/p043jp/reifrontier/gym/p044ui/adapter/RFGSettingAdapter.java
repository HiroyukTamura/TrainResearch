package p043jp.reifrontier.gym.p044ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import p043jp.reifrontier.gym.domain.app.RFGSetting;
import p043jp.reifrontier.sanriku.R;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0005\u001f !\"#B\u001b\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0016J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0014H\u0016J\u0018\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0014H\u0016J\u0014\u0010\u001e\u001a\u00020\u00182\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0010\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006$"}, mo21739d2 = {"Ljp/reifrontier/gym/ui/adapter/RFGSettingAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Ljp/reifrontier/gym/ui/adapter/RFGSettingAdapter$Holder;", "data", "", "Ljp/reifrontier/gym/domain/app/RFGSetting;", "listener", "Ljp/reifrontier/gym/ui/adapter/RFGSettingAdapter$OnTouchListener;", "(Ljava/util/List;Ljp/reifrontier/gym/ui/adapter/RFGSettingAdapter$OnTouchListener;)V", "mContext", "Landroid/content/Context;", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "mData", "mListener", "getMListener", "()Ljp/reifrontier/gym/ui/adapter/RFGSettingAdapter$OnTouchListener;", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setData", "Holder", "Item", "OnTouchListener", "Section", "SettingViewType", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.ui.adapter.RFGSettingAdapter */
public final class RFGSettingAdapter extends RecyclerView.Adapter<Holder> {
    private Context mContext;
    private List<RFGSetting> mData;
    private final OnTouchListener mListener;

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\t"}, mo21739d2 = {"Ljp/reifrontier/gym/ui/adapter/RFGSettingAdapter$OnTouchListener;", "", "switch", "", "setting", "Ljp/reifrontier/gym/domain/app/RFGSetting;", "on", "", "touch", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.ui.adapter.RFGSettingAdapter$OnTouchListener */
    public interface OnTouchListener {
        /* renamed from: switch  reason: not valid java name */
        void m4601switch(RFGSetting rFGSetting, boolean z);

        void touch(RFGSetting rFGSetting);
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0006"}, mo21739d2 = {"Ljp/reifrontier/gym/ui/adapter/RFGSettingAdapter$Holder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "Factory", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.ui.adapter.RFGSettingAdapter$Holder */
    public static class Holder extends RecyclerView.ViewHolder {
        public static final Factory Factory = new Factory((DefaultConstructorMarker) null);

        @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, mo21739d2 = {"Ljp/reifrontier/gym/ui/adapter/RFGSettingAdapter$Holder$Factory;", "", "()V", "create", "Ljp/reifrontier/gym/ui/adapter/RFGSettingAdapter$Holder;", "v", "Landroid/widget/TextView;", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
        /* renamed from: jp.reifrontier.gym.ui.adapter.RFGSettingAdapter$Holder$Factory */
        public static final class Factory {
            private Factory() {
            }

            public /* synthetic */ Factory(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final Holder create(TextView textView) {
                Intrinsics.checkParameterIsNotNull(textView, "v");
                return new Holder(textView);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Holder(View view) {
            super(view);
            Intrinsics.checkParameterIsNotNull(view, "itemView");
        }
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, mo21739d2 = {"Ljp/reifrontier/gym/ui/adapter/RFGSettingAdapter$Item;", "Ljp/reifrontier/gym/ui/adapter/RFGSettingAdapter$Holder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "switch", "Landroid/widget/Switch;", "getSwitch", "()Landroid/widget/Switch;", "title", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.ui.adapter.RFGSettingAdapter$Item */
    public static final class Item extends Holder {

        /* renamed from: switch  reason: not valid java name */
        private final Switch f4373switch;
        private final TextView title;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Item(View view) {
            super(view);
            Intrinsics.checkParameterIsNotNull(view, "itemView");
            View findViewById = view.findViewById(R.id.setting_title);
            Intrinsics.checkExpressionValueIsNotNull(findViewById, "itemView.findViewById(R.id.setting_title)");
            this.title = (TextView) findViewById;
            View findViewById2 = view.findViewById(R.id.setting_switch);
            Intrinsics.checkExpressionValueIsNotNull(findViewById2, "itemView.findViewById(R.id.setting_switch)");
            this.f4373switch = (Switch) findViewById2;
        }

        public final Switch getSwitch() {
            return this.f4373switch;
        }

        public final TextView getTitle() {
            return this.title;
        }
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, mo21739d2 = {"Ljp/reifrontier/gym/ui/adapter/RFGSettingAdapter$Section;", "Ljp/reifrontier/gym/ui/adapter/RFGSettingAdapter$Holder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "title", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.ui.adapter.RFGSettingAdapter$Section */
    public static final class Section extends Holder {
        private final TextView title;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Section(View view) {
            super(view);
            Intrinsics.checkParameterIsNotNull(view, "itemView");
            View findViewById = view.findViewById(R.id.setting_section_title);
            Intrinsics.checkExpressionValueIsNotNull(findViewById, "itemView.findViewById(R.id.setting_section_title)");
            this.title = (TextView) findViewById;
        }

        public final TextView getTitle() {
            return this.title;
        }
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0005B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0006"}, mo21739d2 = {"Ljp/reifrontier/gym/ui/adapter/RFGSettingAdapter$SettingViewType;", "", "(Ljava/lang/String;I)V", "SECTION", "ITEM", "Companion", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.ui.adapter.RFGSettingAdapter$SettingViewType */
    public enum SettingViewType {
        SECTION,
        ITEM;
        
        public static final Companion Companion = null;

        @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, mo21739d2 = {"Ljp/reifrontier/gym/ui/adapter/RFGSettingAdapter$SettingViewType$Companion;", "", "()V", "getType", "Ljp/reifrontier/gym/ui/adapter/RFGSettingAdapter$SettingViewType;", "ordinal", "", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
        /* renamed from: jp.reifrontier.gym.ui.adapter.RFGSettingAdapter$SettingViewType$Companion */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final SettingViewType getType(int i) {
                for (SettingViewType settingViewType : SettingViewType.values()) {
                    if (settingViewType.ordinal() == i) {
                        return settingViewType;
                    }
                }
                return SettingViewType.ITEM;
            }
        }

        static {
            Companion = new Companion((DefaultConstructorMarker) null);
        }
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21740k = 3, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.ui.adapter.RFGSettingAdapter$WhenMappings */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[SettingViewType.values().length];
            $EnumSwitchMapping$0 = iArr;
            SettingViewType settingViewType = SettingViewType.SECTION;
            iArr[0] = 1;
            int[] iArr2 = $EnumSwitchMapping$0;
            SettingViewType settingViewType2 = SettingViewType.ITEM;
            iArr2[1] = 2;
            int[] iArr3 = new int[SettingViewType.values().length];
            $EnumSwitchMapping$1 = iArr3;
            SettingViewType settingViewType3 = SettingViewType.SECTION;
            iArr3[0] = 1;
            int[] iArr4 = $EnumSwitchMapping$1;
            SettingViewType settingViewType4 = SettingViewType.ITEM;
            iArr4[1] = 2;
        }
    }

    public RFGSettingAdapter(List<RFGSetting> list, OnTouchListener onTouchListener) {
        Intrinsics.checkParameterIsNotNull(list, "data");
        Intrinsics.checkParameterIsNotNull(onTouchListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.mData = list;
        this.mListener = onTouchListener;
    }

    public int getItemCount() {
        return this.mData.size();
    }

    public int getItemViewType(int i) {
        return this.mData.get(i).getType().ordinal();
    }

    public final Context getMContext() {
        return this.mContext;
    }

    public final OnTouchListener getMListener() {
        return this.mListener;
    }

    public void onBindViewHolder(Holder holder, int i) {
        Intrinsics.checkParameterIsNotNull(holder, "holder");
        RFGSetting rFGSetting = this.mData.get(i);
        int ordinal = rFGSetting.getType().ordinal();
        if (ordinal == 0) {
            ((Section) holder).getTitle().setText(rFGSetting.getTitle());
        } else if (ordinal == 1) {
            Item item = (Item) holder;
            item.getTitle().setText(rFGSetting.getTitle());
            item.itemView.setOnClickListener(new RFGSettingAdapter$onBindViewHolder$1(this, rFGSetting));
            item.getSwitch().setVisibility(rFGSetting.getSwitch() ? 0 : 8);
            item.getSwitch().setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
            item.getSwitch().setChecked(rFGSetting.getOn());
            item.getSwitch().setOnCheckedChangeListener(new RFGSettingAdapter$onBindViewHolder$2(this, rFGSetting));
        }
    }

    public Holder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        this.mContext = viewGroup.getContext();
        int ordinal = SettingViewType.Companion.getType(i).ordinal();
        if (ordinal == 0) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_setting_section, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate, "LayoutInflater.from(pare…g_section, parent, false)");
            return new Section(inflate);
        } else if (ordinal == 1) {
            View inflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_setting_item, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate2, "LayoutInflater.from(pare…ting_item, parent, false)");
            return new Item(inflate2);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    public final void setData(List<RFGSetting> list) {
        Intrinsics.checkParameterIsNotNull(list, "data");
        this.mData = list;
        notifyDataSetChanged();
    }

    public final void setMContext(Context context) {
        this.mContext = context;
    }
}
