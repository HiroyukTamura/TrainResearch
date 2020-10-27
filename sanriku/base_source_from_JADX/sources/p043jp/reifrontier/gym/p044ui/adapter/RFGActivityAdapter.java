package p043jp.reifrontier.gym.p044ui.adapter;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.squareup.picasso.C1489e;
import com.squareup.picasso.C1513u;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import p043jp.reifrontier.gym.domain.app.RFGAdapterActivity;
import p043jp.reifrontier.sanriku.R;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u001b\u001c\u001dB\u001b\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0012H\u0016J\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0012H\u0016R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, mo21739d2 = {"Ljp/reifrontier/gym/ui/adapter/RFGActivityAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Ljp/reifrontier/gym/ui/adapter/RFGActivityAdapter$Holder;", "data", "", "Ljp/reifrontier/gym/domain/app/RFGAdapterActivity;", "listener", "Ljp/reifrontier/gym/ui/adapter/RFGActivityAdapter$OnTodayListener;", "(Ljava/util/List;Ljp/reifrontier/gym/ui/adapter/RFGActivityAdapter$OnTodayListener;)V", "mContext", "Landroid/content/Context;", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "mData", "mListener", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Holder", "OnTodayListener", "Title", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.ui.adapter.RFGActivityAdapter */
public final class RFGActivityAdapter extends RecyclerView.Adapter<Holder> {
    private Context mContext;
    private final List<RFGAdapterActivity> mData;
    /* access modifiers changed from: private */
    public final OnTodayListener mListener;

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0006"}, mo21739d2 = {"Ljp/reifrontier/gym/ui/adapter/RFGActivityAdapter$Holder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "Factory", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.ui.adapter.RFGActivityAdapter$Holder */
    public static class Holder extends RecyclerView.ViewHolder {
        public static final Factory Factory = new Factory((DefaultConstructorMarker) null);

        @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, mo21739d2 = {"Ljp/reifrontier/gym/ui/adapter/RFGActivityAdapter$Holder$Factory;", "", "()V", "create", "Ljp/reifrontier/gym/ui/adapter/RFGActivityAdapter$Holder;", "v", "Landroid/widget/TextView;", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
        /* renamed from: jp.reifrontier.gym.ui.adapter.RFGActivityAdapter$Holder$Factory */
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

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, mo21739d2 = {"Ljp/reifrontier/gym/ui/adapter/RFGActivityAdapter$OnTodayListener;", "", "didSelectRowWith", "", "adapterActivity", "Ljp/reifrontier/gym/domain/app/RFGAdapterActivity;", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.ui.adapter.RFGActivityAdapter$OnTodayListener */
    public interface OnTodayListener {
        void didSelectRowWith(RFGAdapterActivity rFGAdapterActivity);
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000e\"\u0004\b\u0019\u0010\u0010R\u001a\u0010\u001a\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\b\"\u0004\b\u001c\u0010\nR\u001a\u0010\u001d\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\b\"\u0004\b\u001f\u0010\nR\u001a\u0010 \u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\b\"\u0004\b\"\u0010\nR\u001a\u0010#\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u000e\"\u0004\b%\u0010\u0010¨\u0006&"}, mo21739d2 = {"Ljp/reifrontier/gym/ui/adapter/RFGActivityAdapter$Title;", "Ljp/reifrontier/gym/ui/adapter/RFGActivityAdapter$Holder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "mDist", "Landroid/widget/TextView;", "getMDist", "()Landroid/widget/TextView;", "setMDist", "(Landroid/widget/TextView;)V", "mMapImage", "Landroid/widget/ImageView;", "getMMapImage", "()Landroid/widget/ImageView;", "setMMapImage", "(Landroid/widget/ImageView;)V", "mMapLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getMMapLayout", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "setMMapLayout", "(Landroidx/constraintlayout/widget/ConstraintLayout;)V", "mPin", "getMPin", "setMPin", "mStep", "getMStep", "setMStep", "mTime", "getMTime", "setMTime", "mTitle", "getMTitle", "setMTitle", "mTitleImage", "getMTitleImage", "setMTitleImage", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.ui.adapter.RFGActivityAdapter$Title */
    public static final class Title extends Holder {
        private TextView mDist;
        private ImageView mMapImage;
        private ConstraintLayout mMapLayout;
        private ImageView mPin;
        private TextView mStep;
        private TextView mTime;
        private TextView mTitle;
        private ImageView mTitleImage;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Title(View view) {
            super(view);
            Intrinsics.checkParameterIsNotNull(view, "itemView");
            View findViewById = view.findViewById(R.id.act_type);
            Intrinsics.checkExpressionValueIsNotNull(findViewById, "itemView.findViewById(R.id.act_type)");
            this.mTitleImage = (ImageView) findViewById;
            View findViewById2 = view.findViewById(R.id.act_title);
            Intrinsics.checkExpressionValueIsNotNull(findViewById2, "itemView.findViewById(R.id.act_title)");
            this.mTitle = (TextView) findViewById2;
            View findViewById3 = view.findViewById(R.id.act_time);
            Intrinsics.checkExpressionValueIsNotNull(findViewById3, "itemView.findViewById(R.id.act_time)");
            this.mTime = (TextView) findViewById3;
            View findViewById4 = view.findViewById(R.id.act_map_view);
            Intrinsics.checkExpressionValueIsNotNull(findViewById4, "itemView.findViewById(R.id.act_map_view)");
            this.mMapLayout = (ConstraintLayout) findViewById4;
            View findViewById5 = view.findViewById(R.id.act_map_image);
            Intrinsics.checkExpressionValueIsNotNull(findViewById5, "itemView.findViewById(R.id.act_map_image)");
            this.mMapImage = (ImageView) findViewById5;
            View findViewById6 = view.findViewById(R.id.act_map_pin);
            Intrinsics.checkExpressionValueIsNotNull(findViewById6, "itemView.findViewById(R.id.act_map_pin)");
            this.mPin = (ImageView) findViewById6;
            View findViewById7 = view.findViewById(R.id.act_step);
            Intrinsics.checkExpressionValueIsNotNull(findViewById7, "itemView.findViewById(R.id.act_step)");
            this.mStep = (TextView) findViewById7;
            View findViewById8 = view.findViewById(R.id.act_distance);
            Intrinsics.checkExpressionValueIsNotNull(findViewById8, "itemView.findViewById(R.id.act_distance)");
            this.mDist = (TextView) findViewById8;
        }

        public final TextView getMDist() {
            return this.mDist;
        }

        public final ImageView getMMapImage() {
            return this.mMapImage;
        }

        public final ConstraintLayout getMMapLayout() {
            return this.mMapLayout;
        }

        public final ImageView getMPin() {
            return this.mPin;
        }

        public final TextView getMStep() {
            return this.mStep;
        }

        public final TextView getMTime() {
            return this.mTime;
        }

        public final TextView getMTitle() {
            return this.mTitle;
        }

        public final ImageView getMTitleImage() {
            return this.mTitleImage;
        }

        public final void setMDist(TextView textView) {
            Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
            this.mDist = textView;
        }

        public final void setMMapImage(ImageView imageView) {
            Intrinsics.checkParameterIsNotNull(imageView, "<set-?>");
            this.mMapImage = imageView;
        }

        public final void setMMapLayout(ConstraintLayout constraintLayout) {
            Intrinsics.checkParameterIsNotNull(constraintLayout, "<set-?>");
            this.mMapLayout = constraintLayout;
        }

        public final void setMPin(ImageView imageView) {
            Intrinsics.checkParameterIsNotNull(imageView, "<set-?>");
            this.mPin = imageView;
        }

        public final void setMStep(TextView textView) {
            Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
            this.mStep = textView;
        }

        public final void setMTime(TextView textView) {
            Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
            this.mTime = textView;
        }

        public final void setMTitle(TextView textView) {
            Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
            this.mTitle = textView;
        }

        public final void setMTitleImage(ImageView imageView) {
            Intrinsics.checkParameterIsNotNull(imageView, "<set-?>");
            this.mTitleImage = imageView;
        }
    }

    public RFGActivityAdapter(List<RFGAdapterActivity> list, OnTodayListener onTodayListener) {
        Intrinsics.checkParameterIsNotNull(list, "data");
        Intrinsics.checkParameterIsNotNull(onTodayListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.mData = list;
        this.mListener = onTodayListener;
    }

    public int getItemCount() {
        return this.mData.size();
    }

    public final Context getMContext() {
        return this.mContext;
    }

    public void onBindViewHolder(Holder holder, int i) {
        Intrinsics.checkParameterIsNotNull(holder, "holder");
        Title title = (Title) holder;
        RFGAdapterActivity rFGAdapterActivity = this.mData.get(i);
        title.getMPin().setVisibility(rFGAdapterActivity.sty() ? 0 : 8);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Context context = this.mContext;
        if (context == null) {
            Intrinsics.throwNpe();
        }
        Object systemService = context.getSystemService("window");
        if (systemService != null) {
            ((WindowManager) systemService).getDefaultDisplay().getMetrics(displayMetrics);
            int i2 = displayMetrics.widthPixels / 2;
            title.getMMapLayout().setLayoutParams(new LinearLayout.LayoutParams(i2, i2));
            C1513u.m2068b().mo27251b(rFGAdapterActivity.mapURL()).mo27281a(title.getMMapImage(), (C1489e) new RFGActivityAdapter$onBindViewHolder$1());
            title.getMTitleImage().setImageResource(rFGAdapterActivity.titleImage());
            title.getMTitle().setText(rFGAdapterActivity.title());
            title.getMTime().setText(rFGAdapterActivity.time());
            title.getMStep().setText(rFGAdapterActivity.steps());
            title.getMDist().setText(rFGAdapterActivity.mo30460km());
            title.itemView.setOnClickListener(new RFGActivityAdapter$onBindViewHolder$2(this, rFGAdapterActivity));
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.view.WindowManager");
    }

    public Holder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        this.mContext = viewGroup.getContext();
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_act_square, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "LayoutInflater.from(pare…ct_square, parent, false)");
        return new Title(inflate);
    }

    public final void setMContext(Context context) {
        this.mContext = context;
    }
}
