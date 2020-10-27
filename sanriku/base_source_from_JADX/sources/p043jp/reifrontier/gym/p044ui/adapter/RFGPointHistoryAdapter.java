package p043jp.reifrontier.gym.p044ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p043jp.reifrontier.gym.domain.api.RFGPoint;
import p043jp.reifrontier.gym.domain.app.RFGSetting;
import p043jp.reifrontier.sanriku.R;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u001b\u001c\u001dB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000eH\u0016J\u0014\u0010\u0018\u001a\u00020\u00122\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\f0\u001aR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, mo21739d2 = {"Ljp/reifrontier/gym/ui/adapter/RFGPointHistoryAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Ljp/reifrontier/gym/ui/adapter/RFGPointHistoryAdapter$Holder;", "()V", "mContext", "Landroid/content/Context;", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "mData", "", "", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setHistory", "list", "", "Holder", "Item", "Section", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.ui.adapter.RFGPointHistoryAdapter */
public final class RFGPointHistoryAdapter extends RecyclerView.Adapter<Holder> {
    private Context mContext;
    private final List<Object> mData = new ArrayList();

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0006"}, mo21739d2 = {"Ljp/reifrontier/gym/ui/adapter/RFGPointHistoryAdapter$Holder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "Factory", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.ui.adapter.RFGPointHistoryAdapter$Holder */
    public static class Holder extends RecyclerView.ViewHolder {
        public static final Factory Factory = new Factory((DefaultConstructorMarker) null);

        @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, mo21739d2 = {"Ljp/reifrontier/gym/ui/adapter/RFGPointHistoryAdapter$Holder$Factory;", "", "()V", "create", "Ljp/reifrontier/gym/ui/adapter/RFGPointHistoryAdapter$Holder;", "v", "Landroid/widget/TextView;", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
        /* renamed from: jp.reifrontier.gym.ui.adapter.RFGPointHistoryAdapter$Holder$Factory */
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

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u000b"}, mo21739d2 = {"Ljp/reifrontier/gym/ui/adapter/RFGPointHistoryAdapter$Item;", "Ljp/reifrontier/gym/ui/adapter/RFGPointHistoryAdapter$Holder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "body", "Landroid/widget/TextView;", "getBody", "()Landroid/widget/TextView;", "title", "getTitle", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.ui.adapter.RFGPointHistoryAdapter$Item */
    public static final class Item extends Holder {
        private final TextView body;
        private final TextView title;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Item(View view) {
            super(view);
            Intrinsics.checkParameterIsNotNull(view, "itemView");
            View findViewById = view.findViewById(R.id.setting_title);
            Intrinsics.checkExpressionValueIsNotNull(findViewById, "itemView.findViewById(R.id.setting_title)");
            this.title = (TextView) findViewById;
            View findViewById2 = view.findViewById(R.id.setting_body);
            Intrinsics.checkExpressionValueIsNotNull(findViewById2, "itemView.findViewById(R.id.setting_body)");
            this.body = (TextView) findViewById2;
        }

        public final TextView getBody() {
            return this.body;
        }

        public final TextView getTitle() {
            return this.title;
        }
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, mo21739d2 = {"Ljp/reifrontier/gym/ui/adapter/RFGPointHistoryAdapter$Section;", "Ljp/reifrontier/gym/ui/adapter/RFGPointHistoryAdapter$Holder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "title", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.ui.adapter.RFGPointHistoryAdapter$Section */
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

    public int getItemCount() {
        return this.mData.size();
    }

    public int getItemViewType(int i) {
        return Intrinsics.areEqual((Object) this.mData.get(i).getClass(), (Object) RFGSetting.class) ? 0 : 1;
    }

    public final Context getMContext() {
        return this.mContext;
    }

    public void onBindViewHolder(Holder holder, int i) {
        int i2;
        Context context;
        Intrinsics.checkParameterIsNotNull(holder, "holder");
        Object obj = this.mData.get(i);
        if (Intrinsics.areEqual((Object) obj.getClass(), (Object) RFGSetting.class)) {
            ((Section) holder).getTitle().setText(((RFGSetting) obj).getTitle());
            return;
        }
        RFGPoint rFGPoint = (RFGPoint) obj;
        Item item = (Item) holder;
        item.getTitle().setText(rFGPoint.nameForType());
        item.getBody().setVisibility(0);
        if (rFGPoint.isUsePoint()) {
            context = this.mContext;
            if (context == null) {
                Intrinsics.throwNpe();
            }
            i2 = R.color.red;
        } else {
            context = this.mContext;
            if (context == null) {
                Intrinsics.throwNpe();
            }
            i2 = R.color.black;
        }
        int color = ContextCompat.getColor(context, i2);
        item.getBody().setText(rFGPoint.point());
        item.getBody().setTextColor(color);
    }

    public Holder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        this.mContext = viewGroup.getContext();
        if (i == 0) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_setting_section, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate, "LayoutInflater.from(pare…g_section, parent, false)");
            return new Section(inflate);
        }
        View inflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_setting_item_body, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(inflate2, "LayoutInflater.from(pare…item_body, parent, false)");
        return new Item(inflate2);
    }

    public final void setHistory(List<? extends Object> list) {
        Intrinsics.checkParameterIsNotNull(list, "list");
        this.mData.clear();
        this.mData.addAll(list);
    }

    public final void setMContext(Context context) {
        this.mContext = context;
    }
}
