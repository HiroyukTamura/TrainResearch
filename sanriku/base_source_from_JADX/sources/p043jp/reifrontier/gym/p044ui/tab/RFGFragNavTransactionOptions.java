package p043jp.reifrontier.gym.p044ui.tab;

import android.view.View;
import androidx.annotation.AnimRes;
import androidx.annotation.StyleRes;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001:\u0001.B\u0013\b\u0016\u0012\n\u0010\u0002\u001a\u00060\u0003R\u00020\u0000¢\u0006\u0002\u0010\u0004B\u0005¢\u0006\u0002\u0010\u0005J\n\u0010-\u001a\u00060\u0003R\u00020\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0007X.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\u00108\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u001e\u0010\u0018\u001a\u00020\u00108\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\u001e\u0010\u001b\u001a\u00020\u00108\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0012\"\u0004\b\u001d\u0010\u0014R,\u0010\u001e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00070 0\u001fX.¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R \u0010&\u001a\u00020\u0010X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b'\u0010\u0005\u001a\u0004\b(\u0010\u0012\"\u0004\b)\u0010\u0014R\u001e\u0010*\u001a\u00020\u00108\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0012\"\u0004\b,\u0010\u0014¨\u0006/"}, mo21739d2 = {"Ljp/reifrontier/gym/ui/tab/RFGFragNavTransactionOptions;", "", "builder", "Ljp/reifrontier/gym/ui/tab/RFGFragNavTransactionOptions$Builder;", "(Ljp/reifrontier/gym/ui/tab/RFGFragNavTransactionOptions$Builder;)V", "()V", "breadCrumbShortTitle", "", "getBreadCrumbShortTitle", "()Ljava/lang/String;", "setBreadCrumbShortTitle", "(Ljava/lang/String;)V", "breadCrumbTitle", "getBreadCrumbTitle", "setBreadCrumbTitle", "enterAnimation", "", "getEnterAnimation", "()I", "setEnterAnimation", "(I)V", "exitAnimation", "getExitAnimation", "setExitAnimation", "popEnterAnimation", "getPopEnterAnimation", "setPopEnterAnimation", "popExitAnimation", "getPopExitAnimation", "setPopExitAnimation", "sharedElements", "", "Lkotlin/Pair;", "Landroid/view/View;", "getSharedElements", "()Ljava/util/List;", "setSharedElements", "(Ljava/util/List;)V", "transition", "transition$annotations", "getTransition", "setTransition", "transitionStyle", "getTransitionStyle", "setTransitionStyle", "newBuilder", "Builder", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.ui.tab.RFGFragNavTransactionOptions */
public final class RFGFragNavTransactionOptions {
    public String breadCrumbShortTitle;
    public String breadCrumbTitle;
    @AnimRes
    private int enterAnimation;
    @AnimRes
    private int exitAnimation;
    @AnimRes
    private int popEnterAnimation;
    @AnimRes
    private int popExitAnimation;
    public List<? extends Pair<? extends View, String>> sharedElements;
    private int transition;
    @StyleRes
    private int transitionStyle;

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0004\u0018\u00002\u00020\u0001B\u0007\b\u0000¢\u0006\u0002\u0010\u0002J\u001e\u0010)\u001a\u00060\u0000R\u00020*2\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00040\u001dJ\u0012\u0010\u0003\u001a\u00060\u0000R\u00020*2\u0006\u0010+\u001a\u00020\u0004J\u0012\u0010\t\u001a\u00060\u0000R\u00020*2\u0006\u0010+\u001a\u00020\u0004J\u0006\u0010,\u001a\u00020*J \u0010-\u001a\u00060\u0000R\u00020*2\b\b\u0001\u0010\f\u001a\u00020\r2\b\b\u0001\u0010\u0012\u001a\u00020\rH\u0002J2\u0010-\u001a\u00060\u0000R\u00020*2\b\b\u0001\u0010\f\u001a\u00020\r2\b\b\u0001\u0010\u0012\u001a\u00020\r2\b\b\u0001\u0010\u0015\u001a\u00020\r2\b\b\u0001\u0010\u0018\u001a\u00020\rJ$\u0010\u001b\u001a\u00060\u0000R\u00020*2\u0018\u0010+\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00040\u001d0\u001cJ\u0012\u0010#\u001a\u00060\u0000R\u00020*2\u0006\u0010+\u001a\u00020\rJ\u0014\u0010&\u001a\u00060\u0000R\u00020*2\b\b\u0001\u0010+\u001a\u00020\rR\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001a\u0010\u0015\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\u001a\u0010\u0018\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000f\"\u0004\b\u001a\u0010\u0011R,\u0010\u001b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00040\u001d0\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u000f\"\u0004\b%\u0010\u0011R\u001a\u0010&\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u000f\"\u0004\b(\u0010\u0011¨\u0006."}, mo21739d2 = {"Ljp/reifrontier/gym/ui/tab/RFGFragNavTransactionOptions$Builder;", "", "(Ljp/reifrontier/gym/ui/tab/RFGFragNavTransactionOptions;)V", "breadCrumbShortTitle", "", "getBreadCrumbShortTitle", "()Ljava/lang/String;", "setBreadCrumbShortTitle", "(Ljava/lang/String;)V", "breadCrumbTitle", "getBreadCrumbTitle", "setBreadCrumbTitle", "enterAnimation", "", "getEnterAnimation", "()I", "setEnterAnimation", "(I)V", "exitAnimation", "getExitAnimation", "setExitAnimation", "popEnterAnimation", "getPopEnterAnimation", "setPopEnterAnimation", "popExitAnimation", "getPopExitAnimation", "setPopExitAnimation", "sharedElements", "", "Lkotlin/Pair;", "Landroid/view/View;", "getSharedElements", "()Ljava/util/List;", "setSharedElements", "(Ljava/util/List;)V", "transition", "getTransition", "setTransition", "transitionStyle", "getTransitionStyle", "setTransitionStyle", "addSharedElement", "Ljp/reifrontier/gym/ui/tab/RFGFragNavTransactionOptions;", "val", "build", "customAnimations", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.ui.tab.RFGFragNavTransactionOptions$Builder */
    public final class Builder {
        private String breadCrumbShortTitle = "";
        private String breadCrumbTitle = "";
        private int enterAnimation;
        private int exitAnimation;
        private int popEnterAnimation;
        private int popExitAnimation;
        private List<Pair<View, String>> sharedElements = new ArrayList();
        private int transition;
        private int transitionStyle;

        public Builder() {
        }

        private final Builder customAnimations(@AnimRes int i, @AnimRes int i2) {
            this.enterAnimation = i;
            this.exitAnimation = i2;
            return this;
        }

        public final Builder addSharedElement(Pair<? extends View, String> pair) {
            Intrinsics.checkParameterIsNotNull(pair, "val");
            this.sharedElements.add(pair);
            return this;
        }

        public final Builder breadCrumbShortTitle(String str) {
            Intrinsics.checkParameterIsNotNull(str, "val");
            this.breadCrumbShortTitle = str;
            return this;
        }

        public final Builder breadCrumbTitle(String str) {
            Intrinsics.checkParameterIsNotNull(str, "val");
            this.breadCrumbTitle = str;
            return this;
        }

        public final RFGFragNavTransactionOptions build() {
            return new RFGFragNavTransactionOptions(this);
        }

        public final Builder customAnimations(@AnimRes int i, @AnimRes int i2, @AnimRes int i3, @AnimRes int i4) {
            this.popEnterAnimation = i3;
            this.popExitAnimation = i4;
            return customAnimations(i, i2);
        }

        public final String getBreadCrumbShortTitle() {
            return this.breadCrumbShortTitle;
        }

        public final String getBreadCrumbTitle() {
            return this.breadCrumbTitle;
        }

        public final int getEnterAnimation() {
            return this.enterAnimation;
        }

        public final int getExitAnimation() {
            return this.exitAnimation;
        }

        public final int getPopEnterAnimation() {
            return this.popEnterAnimation;
        }

        public final int getPopExitAnimation() {
            return this.popExitAnimation;
        }

        public final List<Pair<View, String>> getSharedElements() {
            return this.sharedElements;
        }

        public final int getTransition() {
            return this.transition;
        }

        public final int getTransitionStyle() {
            return this.transitionStyle;
        }

        public final void setBreadCrumbShortTitle(String str) {
            Intrinsics.checkParameterIsNotNull(str, "<set-?>");
            this.breadCrumbShortTitle = str;
        }

        public final void setBreadCrumbTitle(String str) {
            Intrinsics.checkParameterIsNotNull(str, "<set-?>");
            this.breadCrumbTitle = str;
        }

        public final void setEnterAnimation(int i) {
            this.enterAnimation = i;
        }

        public final void setExitAnimation(int i) {
            this.exitAnimation = i;
        }

        public final void setPopEnterAnimation(int i) {
            this.popEnterAnimation = i;
        }

        public final void setPopExitAnimation(int i) {
            this.popExitAnimation = i;
        }

        public final void setSharedElements(List<Pair<View, String>> list) {
            Intrinsics.checkParameterIsNotNull(list, "<set-?>");
            this.sharedElements = list;
        }

        public final void setTransition(int i) {
            this.transition = i;
        }

        public final void setTransitionStyle(int i) {
            this.transitionStyle = i;
        }

        public final Builder sharedElements(List<Pair<View, String>> list) {
            Intrinsics.checkParameterIsNotNull(list, "val");
            this.sharedElements = list;
            return this;
        }

        public final Builder transition(int i) {
            this.transition = i;
            return this;
        }

        public final Builder transitionStyle(@StyleRes int i) {
            this.transitionStyle = i;
            return this;
        }
    }

    public RFGFragNavTransactionOptions() {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public RFGFragNavTransactionOptions(Builder builder) {
        this();
        Intrinsics.checkParameterIsNotNull(builder, "builder");
        this.sharedElements = builder.getSharedElements();
        this.transition = builder.getTransition();
        this.enterAnimation = builder.getEnterAnimation();
        this.exitAnimation = builder.getExitAnimation();
        this.transitionStyle = builder.getTransitionStyle();
        this.popEnterAnimation = builder.getPopEnterAnimation();
        this.popExitAnimation = builder.getPopExitAnimation();
        this.breadCrumbTitle = builder.getBreadCrumbTitle();
        this.breadCrumbShortTitle = builder.getBreadCrumbShortTitle();
    }

    public static /* synthetic */ void transition$annotations() {
    }

    public final String getBreadCrumbShortTitle() {
        String str = this.breadCrumbShortTitle;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("breadCrumbShortTitle");
        }
        return str;
    }

    public final String getBreadCrumbTitle() {
        String str = this.breadCrumbTitle;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("breadCrumbTitle");
        }
        return str;
    }

    public final int getEnterAnimation() {
        return this.enterAnimation;
    }

    public final int getExitAnimation() {
        return this.exitAnimation;
    }

    public final int getPopEnterAnimation() {
        return this.popEnterAnimation;
    }

    public final int getPopExitAnimation() {
        return this.popExitAnimation;
    }

    public final List<Pair<View, String>> getSharedElements() {
        List<? extends Pair<? extends View, String>> list = this.sharedElements;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sharedElements");
        }
        return list;
    }

    public final int getTransition() {
        return this.transition;
    }

    public final int getTransitionStyle() {
        return this.transitionStyle;
    }

    public final Builder newBuilder() {
        return new Builder();
    }

    public final void setBreadCrumbShortTitle(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.breadCrumbShortTitle = str;
    }

    public final void setBreadCrumbTitle(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.breadCrumbTitle = str;
    }

    public final void setEnterAnimation(int i) {
        this.enterAnimation = i;
    }

    public final void setExitAnimation(int i) {
        this.exitAnimation = i;
    }

    public final void setPopEnterAnimation(int i) {
        this.popEnterAnimation = i;
    }

    public final void setPopExitAnimation(int i) {
        this.popExitAnimation = i;
    }

    public final void setSharedElements(List<? extends Pair<? extends View, String>> list) {
        Intrinsics.checkParameterIsNotNull(list, "<set-?>");
        this.sharedElements = list;
    }

    public final void setTransition(int i) {
        this.transition = i;
    }

    public final void setTransitionStyle(int i) {
        this.transitionStyle = i;
    }
}
