package p043jp.reifrontier.gym.p044ui.adapter;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.google.android.gms.common.images.Size;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.squareup.picasso.C1473F;
import com.squareup.picasso.C1489e;
import com.squareup.picasso.C1513u;
import com.squareup.picasso.C1529y;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import p043jp.reifrontier.gym.RFGDef;
import p043jp.reifrontier.gym.domain.api.RFGFeed;
import p043jp.reifrontier.gym.domain.app.RFGAdapterOperation;
import p043jp.reifrontier.gym.domain.app.RFGAdapterPoint;
import p043jp.reifrontier.gym.domain.app.RFGAdapterWeight;
import p043jp.reifrontier.gym.p044ui.adapter.RFGPointAdapter;
import p043jp.reifrontier.gym.p044ui.widget.RFGRadiusTransform;
import p043jp.reifrontier.gym.util.RFGUtilsKt;
import p043jp.reifrontier.sanriku.R;
import p043jp.reifrontier.silentlogsdkandroid.data.shared.RFLSharedHolder;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0006HIJKLMB\u0005¢\u0006\u0002\u0010\u0004J\u0014\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\u0013J\u0014\u0010\u0014\u001a\u00020\u00112\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0013J\u000e\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u001fJ\"\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00062\b\b\u0001\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$H\u0002J\u0018\u0010&\u001a\u00020\u00112\u0006\u0010'\u001a\u00020\u00022\u0006\u0010(\u001a\u00020$H\u0002J\u0018\u0010)\u001a\u00020\u00112\u0006\u0010'\u001a\u00020\u00022\u0006\u0010(\u001a\u00020$H\u0002J\u0018\u0010*\u001a\u00020\u00112\u0006\u0010'\u001a\u00020\u00022\u0006\u0010(\u001a\u00020$H\u0002J\u0006\u0010+\u001a\u00020\u0011J\b\u0010,\u001a\u00020\u0011H\u0016J\b\u0010-\u001a\u00020$H\u0016J\u0010\u0010.\u001a\u00020$2\u0006\u0010(\u001a\u00020$H\u0016J\u0010\u0010/\u001a\u00020$2\u0006\u00100\u001a\u000201H\u0002J0\u00102\u001a\u00020\u00112\u0006\u0010%\u001a\u00020$2\u0006\u00103\u001a\u00020$2\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\u00162\u0006\u00107\u001a\u000201H\u0002J\u0018\u00108\u001a\u00020\u00112\u0006\u0010'\u001a\u00020\u00022\u0006\u0010(\u001a\u00020$H\u0016J\u0010\u00109\u001a\u00020\u00112\u0006\u00106\u001a\u00020\u0016H\u0002J\u0018\u0010:\u001a\u00020\u00022\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020$H\u0016J\u0018\u0010>\u001a\u00020\u00112\u0006\u00106\u001a\u00020\u00162\u0006\u00104\u001a\u000205H\u0002J \u0010?\u001a\u00020\u00112\u0006\u0010@\u001a\u0002012\u0006\u0010A\u001a\u00020$2\u0006\u00106\u001a\u000205H\u0002J\u000e\u0010B\u001a\u00020\u00112\u0006\u0010C\u001a\u00020\u000bJ\u0010\u0010D\u001a\u00020\u00112\u0006\u00106\u001a\u000205H\u0002J\u0018\u0010E\u001a\u00020\u00112\u0006\u0010@\u001a\u0002012\u0006\u00106\u001a\u000205H\u0002J\u0018\u0010F\u001a\u00020\u00112\u0006\u00106\u001a\u0002052\u0006\u0010G\u001a\u00020$H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006N"}, mo21739d2 = {"Ljp/reifrontier/gym/ui/adapter/RFGFeedAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Ljp/reifrontier/gym/ui/adapter/RFGFeedAdapter$Holder;", "Ljp/reifrontier/gym/ui/adapter/RFGPointAdapter$OnPointListener;", "()V", "mContext", "Landroid/content/Context;", "mData", "", "", "mListener", "Ljp/reifrontier/gym/ui/adapter/RFGFeedAdapter$OnFeedItemListener;", "getMListener", "()Ljp/reifrontier/gym/ui/adapter/RFGFeedAdapter$OnFeedItemListener;", "setMListener", "(Ljp/reifrontier/gym/ui/adapter/RFGFeedAdapter$OnFeedItemListener;)V", "addAll", "", "items", "", "addFeeds", "feeds", "Ljp/reifrontier/gym/domain/api/RFGFeed;", "addOperation", "operation", "Ljp/reifrontier/gym/domain/app/RFGAdapterOperation;", "addSummary", "summary", "Ljp/reifrontier/gym/domain/app/RFGAdapterPoint;", "addWeight", "weight", "Ljp/reifrontier/gym/domain/app/RFGAdapterWeight;", "adjustImageSize", "Lcom/google/android/gms/common/images/Size;", "context", "imageRes", "", "width", "bindFeed", "holder", "position", "bindOperation", "bindPoint", "clear", "didSelectPoint", "getItemCount", "getItemViewType", "imageForIndex", "stringIndex", "", "loadFeedImage", "height", "feedHolder", "Ljp/reifrontier/gym/ui/adapter/RFGFeedAdapter$Feed;", "feed", "token", "onBindViewHolder", "onClickMatomeRow", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setFeedArchive", "setImage", "string", "at", "setListener", "listener", "setMetsPoint", "setString", "setupViews", "stepCount", "Feed", "Holder", "OnFeedItemListener", "Operation", "Point", "ViewType", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.ui.adapter.RFGFeedAdapter */
public final class RFGFeedAdapter extends RecyclerView.Adapter<Holder> implements RFGPointAdapter.OnPointListener {
    private Context mContext;
    private final List<Object> mData = new ArrayList();
    private OnFeedItemListener mListener;

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u000f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\u0011\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\fR\u0011\u0010\u0013\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\bR\u0011\u0010\u0015\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\fR\u0011\u0010\u0017\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\fR\u0011\u0010\u0019\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\fR\u0011\u0010\u001b\u001a\u00020\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u001f\u001a\u00020 ¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010#\u001a\u00020 ¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\"R\u0011\u0010%\u001a\u00020 ¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\"R\u0011\u0010'\u001a\u00020(¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010+\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\fR\u0011\u0010-\u001a\u00020(¢\u0006\b\n\u0000\u001a\u0004\b.\u0010*R\u0011\u0010/\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\fR\u0011\u00101\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\fR\u0011\u00103\u001a\u00020 ¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\"R\u0011\u00105\u001a\u00020 ¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\"R\u0011\u00107\u001a\u00020 ¢\u0006\b\n\u0000\u001a\u0004\b8\u0010\"R\u0011\u00109\u001a\u00020 ¢\u0006\b\n\u0000\u001a\u0004\b:\u0010\"R\u0011\u0010;\u001a\u00020 ¢\u0006\b\n\u0000\u001a\u0004\b<\u0010\"¨\u0006="}, mo21739d2 = {"Ljp/reifrontier/gym/ui/adapter/RFGFeedAdapter$Feed;", "Ljp/reifrontier/gym/ui/adapter/RFGFeedAdapter$Holder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "archive", "Landroid/widget/LinearLayout;", "getArchive", "()Landroid/widget/LinearLayout;", "archiveFifth", "Landroid/widget/ImageView;", "getArchiveFifth", "()Landroid/widget/ImageView;", "archiveFirst", "getArchiveFirst", "archiveFourth", "getArchiveFourth", "archiveMessage", "getArchiveMessage", "archiveNumberBase", "getArchiveNumberBase", "archiveSecond", "getArchiveSecond", "archiveThird", "getArchiveThird", "archiveUnit", "getArchiveUnit", "mAction", "Landroid/widget/Button;", "getMAction", "()Landroid/widget/Button;", "mBody", "Landroid/widget/TextView;", "getMBody", "()Landroid/widget/TextView;", "mDate", "getMDate", "mDistance", "getMDistance", "mFeedImageView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getMFeedImageView", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "mIcon", "getMIcon", "mInfoView", "getMInfoView", "mMain", "getMMain", "mMatome", "getMMatome", "mMets", "getMMets", "mName", "getMName", "mPoints", "getMPoints", "mSteps", "getMSteps", "mTitle", "getMTitle", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.ui.adapter.RFGFeedAdapter$Feed */
    public static final class Feed extends Holder {
        private final LinearLayout archive;
        private final ImageView archiveFifth;
        private final ImageView archiveFirst;
        private final ImageView archiveFourth;
        private final ImageView archiveMessage;
        private final LinearLayout archiveNumberBase;
        private final ImageView archiveSecond;
        private final ImageView archiveThird;
        private final ImageView archiveUnit;
        private final Button mAction;
        private final TextView mBody;
        private final TextView mDate;
        private final TextView mDistance;
        private final ConstraintLayout mFeedImageView;
        private final ImageView mIcon;
        private final ConstraintLayout mInfoView;
        private final ImageView mMain;
        private final ImageView mMatome;
        private final TextView mMets;
        private final TextView mName;
        private final TextView mPoints;
        private final TextView mSteps;
        private final TextView mTitle;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Feed(View view) {
            super(view);
            Intrinsics.checkParameterIsNotNull(view, "itemView");
            View findViewById = view.findViewById(R.id.feed_view_image);
            Intrinsics.checkExpressionValueIsNotNull(findViewById, "itemView.findViewById(R.id.feed_view_image)");
            this.mFeedImageView = (ConstraintLayout) findViewById;
            View findViewById2 = view.findViewById(R.id.feed_title);
            Intrinsics.checkExpressionValueIsNotNull(findViewById2, "itemView.findViewById(R.id.feed_title)");
            this.mName = (TextView) findViewById2;
            View findViewById3 = view.findViewById(R.id.feed_subtitle);
            Intrinsics.checkExpressionValueIsNotNull(findViewById3, "itemView.findViewById(R.id.feed_subtitle)");
            this.mTitle = (TextView) findViewById3;
            View findViewById4 = view.findViewById(R.id.feed_image_matome);
            Intrinsics.checkExpressionValueIsNotNull(findViewById4, "itemView.findViewById(R.id.feed_image_matome)");
            this.mMatome = (ImageView) findViewById4;
            View findViewById5 = view.findViewById(R.id.feed_image_main);
            Intrinsics.checkExpressionValueIsNotNull(findViewById5, "itemView.findViewById(R.id.feed_image_main)");
            this.mMain = (ImageView) findViewById5;
            View findViewById6 = view.findViewById(R.id.feed_image_title);
            Intrinsics.checkExpressionValueIsNotNull(findViewById6, "itemView.findViewById(R.id.feed_image_title)");
            this.mIcon = (ImageView) findViewById6;
            View findViewById7 = view.findViewById(R.id.feed_body);
            Intrinsics.checkExpressionValueIsNotNull(findViewById7, "itemView.findViewById(R.id.feed_body)");
            this.mBody = (TextView) findViewById7;
            View findViewById8 = view.findViewById(R.id.feed_action);
            Intrinsics.checkExpressionValueIsNotNull(findViewById8, "itemView.findViewById(R.id.feed_action)");
            this.mAction = (Button) findViewById8;
            View findViewById9 = view.findViewById(R.id.feed_info_view);
            Intrinsics.checkExpressionValueIsNotNull(findViewById9, "itemView.findViewById(R.id.feed_info_view)");
            this.mInfoView = (ConstraintLayout) findViewById9;
            View findViewById10 = view.findViewById(R.id.feed_step);
            Intrinsics.checkExpressionValueIsNotNull(findViewById10, "itemView.findViewById(R.id.feed_step)");
            this.mSteps = (TextView) findViewById10;
            View findViewById11 = view.findViewById(R.id.feed_point);
            Intrinsics.checkExpressionValueIsNotNull(findViewById11, "itemView.findViewById(R.id.feed_point)");
            this.mPoints = (TextView) findViewById11;
            View findViewById12 = view.findViewById(R.id.feed_distance);
            Intrinsics.checkExpressionValueIsNotNull(findViewById12, "itemView.findViewById(R.id.feed_distance)");
            this.mDistance = (TextView) findViewById12;
            View findViewById13 = view.findViewById(R.id.feed_mets);
            Intrinsics.checkExpressionValueIsNotNull(findViewById13, "itemView.findViewById(R.id.feed_mets)");
            this.mMets = (TextView) findViewById13;
            View findViewById14 = view.findViewById(R.id.feed_date);
            Intrinsics.checkExpressionValueIsNotNull(findViewById14, "itemView.findViewById(R.id.feed_date)");
            this.mDate = (TextView) findViewById14;
            View findViewById15 = view.findViewById(R.id.layout_archive);
            Intrinsics.checkExpressionValueIsNotNull(findViewById15, "itemView.findViewById(R.id.layout_archive)");
            this.archive = (LinearLayout) findViewById15;
            View findViewById16 = view.findViewById(R.id.archive_view_number);
            Intrinsics.checkExpressionValueIsNotNull(findViewById16, "itemView.findViewById(R.id.archive_view_number)");
            this.archiveNumberBase = (LinearLayout) findViewById16;
            View findViewById17 = view.findViewById(R.id.archive_first);
            Intrinsics.checkExpressionValueIsNotNull(findViewById17, "itemView.findViewById(R.id.archive_first)");
            this.archiveFirst = (ImageView) findViewById17;
            View findViewById18 = view.findViewById(R.id.archive_second);
            Intrinsics.checkExpressionValueIsNotNull(findViewById18, "itemView.findViewById(R.id.archive_second)");
            this.archiveSecond = (ImageView) findViewById18;
            View findViewById19 = view.findViewById(R.id.archive_third);
            Intrinsics.checkExpressionValueIsNotNull(findViewById19, "itemView.findViewById(R.id.archive_third)");
            this.archiveThird = (ImageView) findViewById19;
            View findViewById20 = view.findViewById(R.id.archive_fourth);
            Intrinsics.checkExpressionValueIsNotNull(findViewById20, "itemView.findViewById(R.id.archive_fourth)");
            this.archiveFourth = (ImageView) findViewById20;
            View findViewById21 = view.findViewById(R.id.archive_fifth);
            Intrinsics.checkExpressionValueIsNotNull(findViewById21, "itemView.findViewById(R.id.archive_fifth)");
            this.archiveFifth = (ImageView) findViewById21;
            View findViewById22 = view.findViewById(R.id.archive_unit);
            Intrinsics.checkExpressionValueIsNotNull(findViewById22, "itemView.findViewById(R.id.archive_unit)");
            this.archiveUnit = (ImageView) findViewById22;
            View findViewById23 = view.findViewById(R.id.archive_message);
            Intrinsics.checkExpressionValueIsNotNull(findViewById23, "itemView.findViewById(R.id.archive_message)");
            this.archiveMessage = (ImageView) findViewById23;
        }

        public final LinearLayout getArchive() {
            return this.archive;
        }

        public final ImageView getArchiveFifth() {
            return this.archiveFifth;
        }

        public final ImageView getArchiveFirst() {
            return this.archiveFirst;
        }

        public final ImageView getArchiveFourth() {
            return this.archiveFourth;
        }

        public final ImageView getArchiveMessage() {
            return this.archiveMessage;
        }

        public final LinearLayout getArchiveNumberBase() {
            return this.archiveNumberBase;
        }

        public final ImageView getArchiveSecond() {
            return this.archiveSecond;
        }

        public final ImageView getArchiveThird() {
            return this.archiveThird;
        }

        public final ImageView getArchiveUnit() {
            return this.archiveUnit;
        }

        public final Button getMAction() {
            return this.mAction;
        }

        public final TextView getMBody() {
            return this.mBody;
        }

        public final TextView getMDate() {
            return this.mDate;
        }

        public final TextView getMDistance() {
            return this.mDistance;
        }

        public final ConstraintLayout getMFeedImageView() {
            return this.mFeedImageView;
        }

        public final ImageView getMIcon() {
            return this.mIcon;
        }

        public final ConstraintLayout getMInfoView() {
            return this.mInfoView;
        }

        public final ImageView getMMain() {
            return this.mMain;
        }

        public final ImageView getMMatome() {
            return this.mMatome;
        }

        public final TextView getMMets() {
            return this.mMets;
        }

        public final TextView getMName() {
            return this.mName;
        }

        public final TextView getMPoints() {
            return this.mPoints;
        }

        public final TextView getMSteps() {
            return this.mSteps;
        }

        public final TextView getMTitle() {
            return this.mTitle;
        }
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0006"}, mo21739d2 = {"Ljp/reifrontier/gym/ui/adapter/RFGFeedAdapter$Holder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "Factory", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.ui.adapter.RFGFeedAdapter$Holder */
    public static class Holder extends RecyclerView.ViewHolder {
        public static final Factory Factory = new Factory((DefaultConstructorMarker) null);

        @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, mo21739d2 = {"Ljp/reifrontier/gym/ui/adapter/RFGFeedAdapter$Holder$Factory;", "", "()V", "create", "Ljp/reifrontier/gym/ui/adapter/RFGFeedAdapter$Holder;", "v", "Landroid/widget/TextView;", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
        /* renamed from: jp.reifrontier.gym.ui.adapter.RFGFeedAdapter$Holder$Factory */
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

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007"}, mo21739d2 = {"Ljp/reifrontier/gym/ui/adapter/RFGFeedAdapter$OnFeedItemListener;", "", "touchPoint", "", "touchTimeline", "date", "Ljava/util/Date;", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.ui.adapter.RFGFeedAdapter$OnFeedItemListener */
    public interface OnFeedItemListener {
        void touchPoint();

        void touchTimeline(Date date);
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, mo21739d2 = {"Ljp/reifrontier/gym/ui/adapter/RFGFeedAdapter$Operation;", "Ljp/reifrontier/gym/ui/adapter/RFGFeedAdapter$Holder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "mOperationPager", "Landroidx/viewpager/widget/ViewPager;", "getMOperationPager", "()Landroidx/viewpager/widget/ViewPager;", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.ui.adapter.RFGFeedAdapter$Operation */
    public static final class Operation extends Holder {
        private final ViewPager mOperationPager;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Operation(View view) {
            super(view);
            Intrinsics.checkParameterIsNotNull(view, "itemView");
            View findViewById = view.findViewById(R.id.operationPager);
            Intrinsics.checkExpressionValueIsNotNull(findViewById, "itemView.findViewById(R.id.operationPager)");
            this.mOperationPager = (ViewPager) findViewById;
        }

        public final ViewPager getMOperationPager() {
            return this.mOperationPager;
        }
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, mo21739d2 = {"Ljp/reifrontier/gym/ui/adapter/RFGFeedAdapter$Point;", "Ljp/reifrontier/gym/ui/adapter/RFGFeedAdapter$Holder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "mPointPager", "Landroidx/viewpager/widget/ViewPager;", "getMPointPager", "()Landroidx/viewpager/widget/ViewPager;", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.ui.adapter.RFGFeedAdapter$Point */
    public static final class Point extends Holder {
        private final ViewPager mPointPager;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Point(View view) {
            super(view);
            Intrinsics.checkParameterIsNotNull(view, "itemView");
            View findViewById = view.findViewById(R.id.pointPager);
            Intrinsics.checkExpressionValueIsNotNull(findViewById, "itemView.findViewById(R.id.pointPager)");
            this.mPointPager = (ViewPager) findViewById;
        }

        public final ViewPager getMPointPager() {
            return this.mPointPager;
        }
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u0000 \u00062\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0007"}, mo21739d2 = {"Ljp/reifrontier/gym/ui/adapter/RFGFeedAdapter$ViewType;", "", "(Ljava/lang/String;I)V", "POINT", "FEED", "OPERATION", "Companion", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.ui.adapter.RFGFeedAdapter$ViewType */
    private enum ViewType {
        POINT,
        FEED,
        OPERATION;
        
        public static final Companion Companion = null;

        @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, mo21739d2 = {"Ljp/reifrontier/gym/ui/adapter/RFGFeedAdapter$ViewType$Companion;", "", "()V", "getType", "Ljp/reifrontier/gym/ui/adapter/RFGFeedAdapter$ViewType;", "ordinalValue", "", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
        /* renamed from: jp.reifrontier.gym.ui.adapter.RFGFeedAdapter$ViewType$Companion */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final ViewType getType(int i) {
                return ViewType.values()[i];
            }
        }

        static {
            Companion = new Companion((DefaultConstructorMarker) null);
        }
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21740k = 3, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.ui.adapter.RFGFeedAdapter$WhenMappings */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[ViewType.values().length];
            $EnumSwitchMapping$0 = iArr;
            ViewType viewType = ViewType.POINT;
            iArr[0] = 1;
            int[] iArr2 = $EnumSwitchMapping$0;
            ViewType viewType2 = ViewType.FEED;
            iArr2[1] = 2;
            int[] iArr3 = $EnumSwitchMapping$0;
            ViewType viewType3 = ViewType.OPERATION;
            iArr3[2] = 3;
            int[] iArr4 = new int[ViewType.values().length];
            $EnumSwitchMapping$1 = iArr4;
            ViewType viewType4 = ViewType.POINT;
            iArr4[0] = 1;
            int[] iArr5 = $EnumSwitchMapping$1;
            ViewType viewType5 = ViewType.FEED;
            iArr5[1] = 2;
            int[] iArr6 = $EnumSwitchMapping$1;
            ViewType viewType6 = ViewType.OPERATION;
            iArr6[2] = 3;
        }
    }

    private final Size adjustImageSize(Context context, @DrawableRes int i, int i2) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(context.getResources(), i, options);
        return new Size(i2, MathKt__MathJVMKt.roundToInt((((float) i2) / ((float) options.outWidth)) * ((float) options.outHeight)));
    }

    private final void bindFeed(Holder holder, int i) {
        Context context = this.mContext;
        if (context == null) {
            return;
        }
        if (holder != null) {
            Feed feed = (Feed) holder;
            Object obj = this.mData.get(i);
            if (obj != null) {
                RFGFeed rFGFeed = (RFGFeed) obj;
                feed.getMName().setText(rFGFeed.username(context));
                feed.getMTitle().setText(rFGFeed.isMatome() ? context.getResources().getString(R.string.summary_suffix, new Object[]{rFGFeed.getFeedTitle()}) : rFGFeed.getFeedTitle());
                feed.getMBody().setText(rFGFeed.isMatome() ? context.getResources().getString(R.string.matome) : rFGFeed.getFeedDetail());
                feed.getMMatome().setAlpha(rFGFeed.isMatome() ? 1.0f : 0.0f);
                String accessToken = RFLSharedHolder.INSTANCE.accessToken();
                if (rFGFeed.isUser()) {
                    C1529y b = C1513u.m2068b().mo27251b(RFGDef.URL.INSTANCE.baseUrl() + RFGDef.URL.USER_ICON_PATH + RFGDef.IMAGE_URL_SUFFIX + accessToken);
                    b.mo27279a((C1473F) new RFGRadiusTransform(-1.0f));
                    b.mo27281a(feed.getMIcon(), (C1489e) null);
                } else {
                    feed.getMIcon().setImageResource(R.mipmap.ic_launcher_round);
                }
                DisplayMetrics displayMetrics = new DisplayMetrics();
                Context context2 = this.mContext;
                if (context2 == null) {
                    Intrinsics.throwNpe();
                }
                Object systemService = context2.getSystemService("window");
                if (systemService != null) {
                    ((WindowManager) systemService).getDefaultDisplay().getMetrics(displayMetrics);
                    loadFeedImage(displayMetrics.widthPixels, (int) (((float) ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION) * displayMetrics.density), feed, rFGFeed, accessToken);
                    if (rFGFeed.isMatome()) {
                        feed.getArchive().setVisibility(8);
                    } else {
                        setFeedArchive(rFGFeed, feed);
                    }
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.JAPANESE);
                    simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
                    Date parse = simpleDateFormat.parse(rFGFeed.getFeedUpdateDate());
                    Intrinsics.checkExpressionValueIsNotNull(parse, "feedDateFormat.parse(feed.feedUpdateDate)");
                    feed.getMDate().setText(RFGUtilsKt.formaaat11(parse, "yyyy年M月d日 HH:mm", "Asia/Tokyo"));
                    if (rFGFeed.isMatome()) {
                        feed.getMTitle().setOnClickListener(new RFGFeedAdapter$bindFeed$1(this, rFGFeed));
                        feed.getMFeedImageView().setOnClickListener(new RFGFeedAdapter$bindFeed$2(this, rFGFeed));
                    }
                    if (rFGFeed.isMatome()) {
                        feed.getMInfoView().setVisibility(0);
                        feed.getMSteps().setText(rFGFeed.getSteps());
                        feed.getMPoints().setText(rFGFeed.getPoint());
                        feed.getMDistance().setText(rFGFeed.getDistance());
                        feed.getMMets().setText(rFGFeed.getMets());
                    } else {
                        feed.getMInfoView().setVisibility(8);
                    }
                    feed.getMAction().setVisibility(8);
                    return;
                }
                throw new TypeCastException("null cannot be cast to non-null type android.view.WindowManager");
            }
            throw new TypeCastException("null cannot be cast to non-null type jp.reifrontier.gym.domain.api.RFGFeed");
        }
        throw new TypeCastException("null cannot be cast to non-null type jp.reifrontier.gym.ui.adapter.RFGFeedAdapter.Feed");
    }

    private final void bindOperation(Holder holder, int i) {
        if (holder != null) {
            Operation operation = (Operation) holder;
            Object obj = this.mData.get(i);
            if (obj != null) {
                RFGAdapterOperation rFGAdapterOperation = (RFGAdapterOperation) obj;
                Context context = this.mContext;
                if (context == null) {
                    Intrinsics.throwNpe();
                }
                operation.getMOperationPager().setAdapter(new RFGOperationAdapter(context, rFGAdapterOperation.getOperationCount()));
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type jp.reifrontier.gym.domain.app.RFGAdapterOperation");
        }
        throw new TypeCastException("null cannot be cast to non-null type jp.reifrontier.gym.ui.adapter.RFGFeedAdapter.Operation");
    }

    private final void bindPoint(Holder holder, int i) {
        if (holder != null) {
            Point point = (Point) holder;
            Object obj = this.mData.get(i);
            if (obj != null) {
                RFGAdapterPoint rFGAdapterPoint = (RFGAdapterPoint) obj;
                Context context = this.mContext;
                if (context == null) {
                    Intrinsics.throwNpe();
                }
                RFGPointAdapter rFGPointAdapter = new RFGPointAdapter(context, rFGAdapterPoint.getList());
                rFGPointAdapter.setListener(this);
                point.getMPointPager().setAdapter(rFGPointAdapter);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type jp.reifrontier.gym.domain.app.RFGAdapterPoint");
        }
        throw new TypeCastException("null cannot be cast to non-null type jp.reifrontier.gym.ui.adapter.RFGFeedAdapter.Point");
    }

    private final int imageForIndex(String str) {
        int hashCode = str.hashCode();
        if (hashCode != 46) {
            switch (hashCode) {
                case 49:
                    if (str.equals("1")) {
                        return R.mipmap.one;
                    }
                    break;
                case 50:
                    if (str.equals(ExifInterface.GPS_MEASUREMENT_2D)) {
                        return R.mipmap.two;
                    }
                    break;
                case 51:
                    if (str.equals(ExifInterface.GPS_MEASUREMENT_3D)) {
                        return R.mipmap.three;
                    }
                    break;
                case 52:
                    if (str.equals("4")) {
                        return R.mipmap.four;
                    }
                    break;
                case 53:
                    if (str.equals("5")) {
                        return R.mipmap.five;
                    }
                    break;
                case 54:
                    if (str.equals("6")) {
                        return R.mipmap.six;
                    }
                    break;
                case 55:
                    if (str.equals("7")) {
                        return R.mipmap.seven;
                    }
                    break;
                case 56:
                    if (str.equals("8")) {
                        return R.mipmap.eight;
                    }
                    break;
                case 57:
                    if (str.equals("9")) {
                        return R.mipmap.nine;
                    }
                    break;
                default:
                    switch (hashCode) {
                        case 97:
                            if (str.equals("a")) {
                                return R.mipmap.bar1;
                            }
                            break;
                        case 98:
                            if (str.equals("b")) {
                                return R.mipmap.bar2;
                            }
                            break;
                        case 99:
                            if (str.equals("c")) {
                                return R.mipmap.bar3;
                            }
                            break;
                        case 100:
                            if (str.equals("d")) {
                                return R.mipmap.bar4;
                            }
                            break;
                    }
            }
        } else if (str.equals(".")) {
            return R.mipmap.dot;
        }
        return R.mipmap.zero;
    }

    private final void loadFeedImage(int i, int i2, Feed feed, RFGFeed rFGFeed, String str) {
        C1529y a;
        Integer feedImageResource = rFGFeed.getFeedImageResource();
        if (feedImageResource == null) {
            feed.getMFeedImageView().setLayoutParams(new LinearLayout.LayoutParams(i, i2));
            a = C1513u.m2068b().mo27251b(rFGFeed.getFeedImage() + RFGDef.IMAGE_URL_SUFFIX + str);
        } else {
            Context context = feed.getMMain().getContext();
            Intrinsics.checkExpressionValueIsNotNull(context, "feedHolder.mMain.context");
            Size adjustImageSize = adjustImageSize(context, feedImageResource.intValue(), i);
            feed.getMFeedImageView().setLayoutParams(new LinearLayout.LayoutParams(adjustImageSize.getWidth(), adjustImageSize.getHeight()));
            a = C1513u.m2068b().mo27244a(feedImageResource.intValue());
        }
        a.mo27277a((int) R.mipmap.archive);
        a.mo27281a(feed.getMMain(), (C1489e) null);
    }

    /* access modifiers changed from: private */
    public final void onClickMatomeRow(RFGFeed rFGFeed) {
        OnFeedItemListener onFeedItemListener = this.mListener;
        if (onFeedItemListener != null) {
            Date parse = new SimpleDateFormat("yyyy年M月dd日", Locale.JAPANESE).parse(rFGFeed.getFeedTitle());
            Intrinsics.checkExpressionValueIsNotNull(parse, "date");
            onFeedItemListener.touchTimeline(parse);
        }
    }

    private final void setFeedArchive(RFGFeed rFGFeed, Feed feed) {
        feed.getArchive().setVisibility(0);
        if (Intrinsics.areEqual((Object) rFGFeed.getSpecId(), (Object) RFGFeed.FeedType.REACH_METS.getSpecId())) {
            setMetsPoint(feed);
        } else {
            feed.getArchive().setVisibility(8);
        }
    }

    private final void setImage(String str, int i, Feed feed) {
        ImageView imageView;
        if (i != 0) {
            if (i == 1) {
                imageView = feed.getArchiveSecond();
            } else if (i == 2) {
                imageView = feed.getArchiveThird();
            } else if (i == 3) {
                imageView = feed.getArchiveFourth();
            } else if (i == 4) {
                imageView = feed.getArchiveFifth();
            }
            imageView.setImageResource(imageForIndex(str));
        }
        imageView = feed.getArchiveFirst();
        imageView.setImageResource(imageForIndex(str));
    }

    private final void setMetsPoint(Feed feed) {
        ConstraintLayout mFeedImageView = feed.getMFeedImageView();
        mFeedImageView.getViewTreeObserver().addOnGlobalLayoutListener(new RFGFeedAdapter$setMetsPoint$1(mFeedImageView, feed));
        feed.getArchiveUnit().setImageResource(R.mipmap.feed_archive_unit_point_san);
        feed.getArchiveMessage().setImageResource(R.mipmap.feed_archive_message_point_san);
        setString("10", feed);
    }

    private final void setString(String str, Feed feed) {
        int length = str.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            setImage(String.valueOf(str.charAt(i2)), i, feed);
            i++;
        }
        setupViews(feed, i);
    }

    private final void setupViews(Feed feed, int i) {
        if (i == 1) {
            feed.getArchiveFirst().setVisibility(0);
            feed.getArchiveSecond().setVisibility(8);
        } else if (i == 2) {
            feed.getArchiveFirst().setVisibility(0);
            feed.getArchiveSecond().setVisibility(0);
        } else if (i == 3) {
            feed.getArchiveFirst().setVisibility(0);
            feed.getArchiveSecond().setVisibility(0);
            feed.getArchiveThird().setVisibility(0);
            feed.getArchiveFourth().setVisibility(8);
            feed.getArchiveFifth().setVisibility(8);
        } else if (i == 4) {
            feed.getArchiveFirst().setVisibility(0);
            feed.getArchiveSecond().setVisibility(0);
            feed.getArchiveThird().setVisibility(0);
            feed.getArchiveFourth().setVisibility(0);
            feed.getArchiveFifth().setVisibility(8);
        } else if (i == 5) {
            feed.getArchiveFirst().setVisibility(0);
            feed.getArchiveSecond().setVisibility(0);
            feed.getArchiveThird().setVisibility(0);
            feed.getArchiveFourth().setVisibility(0);
            feed.getArchiveFifth().setVisibility(0);
            return;
        } else {
            return;
        }
        feed.getArchiveThird().setVisibility(8);
        feed.getArchiveFourth().setVisibility(8);
        feed.getArchiveFifth().setVisibility(8);
    }

    public final void addAll(List<? extends Object> list) {
        Intrinsics.checkParameterIsNotNull(list, FirebaseAnalytics.Param.ITEMS);
        this.mData.addAll(list);
    }

    public final void addFeeds(List<RFGFeed> list) {
        Intrinsics.checkParameterIsNotNull(list, "feeds");
        this.mData.addAll(list);
    }

    public final void addOperation(RFGAdapterOperation rFGAdapterOperation) {
        Intrinsics.checkParameterIsNotNull(rFGAdapterOperation, "operation");
        this.mData.add(rFGAdapterOperation);
    }

    public final void addSummary(RFGAdapterPoint rFGAdapterPoint) {
        Intrinsics.checkParameterIsNotNull(rFGAdapterPoint, "summary");
        this.mData.add(rFGAdapterPoint);
    }

    public final void addWeight(RFGAdapterWeight rFGAdapterWeight) {
        Intrinsics.checkParameterIsNotNull(rFGAdapterWeight, "weight");
        this.mData.add(rFGAdapterWeight);
    }

    public final void clear() {
        this.mData.clear();
    }

    public void didSelectPoint() {
        OnFeedItemListener onFeedItemListener = this.mListener;
        if (onFeedItemListener != null) {
            if (onFeedItemListener == null) {
                Intrinsics.throwNpe();
            }
            onFeedItemListener.touchPoint();
        }
    }

    public int getItemCount() {
        return this.mData.size();
    }

    public int getItemViewType(int i) {
        Object obj = this.mData.get(i);
        return (obj instanceof RFGAdapterPoint ? ViewType.POINT : obj instanceof RFGAdapterOperation ? ViewType.OPERATION : ViewType.FEED).ordinal();
    }

    public final OnFeedItemListener getMListener() {
        return this.mListener;
    }

    public void onBindViewHolder(Holder holder, int i) {
        Intrinsics.checkParameterIsNotNull(holder, "holder");
        int ordinal = ViewType.Companion.getType(getItemViewType(i)).ordinal();
        if (ordinal == 0) {
            bindPoint(holder, i);
        } else if (ordinal == 1) {
            bindFeed(holder, i);
        } else if (ordinal == 2) {
            bindOperation(holder, i);
        }
    }

    public Holder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        this.mContext = viewGroup.getContext();
        int ordinal = ViewType.Companion.getType(i).ordinal();
        if (ordinal == 0) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_feed_point, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate, "LayoutInflater.from(pare…eed_point, parent, false)");
            return new Point(inflate);
        } else if (ordinal == 1) {
            View inflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_feed_title, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate2, "LayoutInflater.from(pare…eed_title, parent, false)");
            return new Feed(inflate2);
        } else if (ordinal == 2) {
            View inflate3 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_feed_operation, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate3, "LayoutInflater.from(pare…operation, parent, false)");
            return new Operation(inflate3);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    public final void setListener(OnFeedItemListener onFeedItemListener) {
        Intrinsics.checkParameterIsNotNull(onFeedItemListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.mListener = onFeedItemListener;
    }

    public final void setMListener(OnFeedItemListener onFeedItemListener) {
        this.mListener = onFeedItemListener;
    }
}
