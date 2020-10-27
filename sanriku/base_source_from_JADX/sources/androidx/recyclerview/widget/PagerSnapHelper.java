package androidx.recyclerview.widget;

import android.util.DisplayMetrics;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

public class PagerSnapHelper extends SnapHelper {
    private static final int MAX_SCROLL_ON_FLING_DURATION = 100;
    @Nullable
    private OrientationHelper mHorizontalHelper;
    @Nullable
    private OrientationHelper mVerticalHelper;

    private int distanceToCenter(@NonNull RecyclerView.LayoutManager layoutManager, @NonNull View view, OrientationHelper orientationHelper) {
        int i;
        int decoratedMeasurement = (orientationHelper.getDecoratedMeasurement(view) / 2) + orientationHelper.getDecoratedStart(view);
        if (layoutManager.getClipToPadding()) {
            i = (orientationHelper.getTotalSpace() / 2) + orientationHelper.getStartAfterPadding();
        } else {
            i = orientationHelper.getEnd() / 2;
        }
        return decoratedMeasurement - i;
    }

    @Nullable
    private View findCenterView(RecyclerView.LayoutManager layoutManager, OrientationHelper orientationHelper) {
        int i;
        int childCount = layoutManager.getChildCount();
        View view = null;
        if (childCount == 0) {
            return null;
        }
        if (layoutManager.getClipToPadding()) {
            i = (orientationHelper.getTotalSpace() / 2) + orientationHelper.getStartAfterPadding();
        } else {
            i = orientationHelper.getEnd() / 2;
        }
        int i2 = Integer.MAX_VALUE;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = layoutManager.getChildAt(i3);
            int abs = Math.abs(((orientationHelper.getDecoratedMeasurement(childAt) / 2) + orientationHelper.getDecoratedStart(childAt)) - i);
            if (abs < i2) {
                view = childAt;
                i2 = abs;
            }
        }
        return view;
    }

    @Nullable
    private View findStartView(RecyclerView.LayoutManager layoutManager, OrientationHelper orientationHelper) {
        int childCount = layoutManager.getChildCount();
        View view = null;
        if (childCount == 0) {
            return null;
        }
        int i = Integer.MAX_VALUE;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = layoutManager.getChildAt(i2);
            int decoratedStart = orientationHelper.getDecoratedStart(childAt);
            if (decoratedStart < i) {
                view = childAt;
                i = decoratedStart;
            }
        }
        return view;
    }

    @NonNull
    private OrientationHelper getHorizontalHelper(@NonNull RecyclerView.LayoutManager layoutManager) {
        OrientationHelper orientationHelper = this.mHorizontalHelper;
        if (orientationHelper == null || orientationHelper.mLayoutManager != layoutManager) {
            this.mHorizontalHelper = OrientationHelper.createHorizontalHelper(layoutManager);
        }
        return this.mHorizontalHelper;
    }

    @NonNull
    private OrientationHelper getVerticalHelper(@NonNull RecyclerView.LayoutManager layoutManager) {
        OrientationHelper orientationHelper = this.mVerticalHelper;
        if (orientationHelper == null || orientationHelper.mLayoutManager != layoutManager) {
            this.mVerticalHelper = OrientationHelper.createVerticalHelper(layoutManager);
        }
        return this.mVerticalHelper;
    }

    @Nullable
    public int[] calculateDistanceToFinalSnap(@NonNull RecyclerView.LayoutManager layoutManager, @NonNull View view) {
        int[] iArr = new int[2];
        if (layoutManager.canScrollHorizontally()) {
            iArr[0] = distanceToCenter(layoutManager, view, getHorizontalHelper(layoutManager));
        } else {
            iArr[0] = 0;
        }
        if (layoutManager.canScrollVertically()) {
            iArr[1] = distanceToCenter(layoutManager, view, getVerticalHelper(layoutManager));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    /* access modifiers changed from: protected */
    public LinearSmoothScroller createSnapScroller(RecyclerView.LayoutManager layoutManager) {
        if (!(layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider)) {
            return null;
        }
        return new LinearSmoothScroller(this.mRecyclerView.getContext()) {
            /* access modifiers changed from: protected */
            public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                return 100.0f / ((float) displayMetrics.densityDpi);
            }

            /* access modifiers changed from: protected */
            public int calculateTimeForScrolling(int i) {
                return Math.min(100, super.calculateTimeForScrolling(i));
            }

            /* access modifiers changed from: protected */
            public void onTargetFound(View view, RecyclerView.State state, RecyclerView.SmoothScroller.Action action) {
                PagerSnapHelper pagerSnapHelper = PagerSnapHelper.this;
                int[] calculateDistanceToFinalSnap = pagerSnapHelper.calculateDistanceToFinalSnap(pagerSnapHelper.mRecyclerView.getLayoutManager(), view);
                int i = calculateDistanceToFinalSnap[0];
                int i2 = calculateDistanceToFinalSnap[1];
                int calculateTimeForDeceleration = calculateTimeForDeceleration(Math.max(Math.abs(i), Math.abs(i2)));
                if (calculateTimeForDeceleration > 0) {
                    action.update(i, i2, calculateTimeForDeceleration, this.mDecelerateInterpolator);
                }
            }
        };
    }

    @Nullable
    public View findSnapView(RecyclerView.LayoutManager layoutManager) {
        OrientationHelper horizontalHelper;
        if (layoutManager.canScrollVertically()) {
            horizontalHelper = getVerticalHelper(layoutManager);
        } else if (!layoutManager.canScrollHorizontally()) {
            return null;
        } else {
            horizontalHelper = getHorizontalHelper(layoutManager);
        }
        return findCenterView(layoutManager, horizontalHelper);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x002c A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x002d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int findTargetSnapPosition(androidx.recyclerview.widget.RecyclerView.LayoutManager r6, int r7, int r8) {
        /*
            r5 = this;
            int r0 = r6.getItemCount()
            r1 = -1
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            r2 = 0
            boolean r3 = r6.canScrollVertically()
            if (r3 == 0) goto L_0x0018
            androidx.recyclerview.widget.OrientationHelper r2 = r5.getVerticalHelper(r6)
        L_0x0013:
            android.view.View r2 = r5.findStartView(r6, r2)
            goto L_0x0023
        L_0x0018:
            boolean r3 = r6.canScrollHorizontally()
            if (r3 == 0) goto L_0x0023
            androidx.recyclerview.widget.OrientationHelper r2 = r5.getHorizontalHelper(r6)
            goto L_0x0013
        L_0x0023:
            if (r2 != 0) goto L_0x0026
            return r1
        L_0x0026:
            int r2 = r6.getPosition(r2)
            if (r2 != r1) goto L_0x002d
            return r1
        L_0x002d:
            boolean r1 = r6.canScrollHorizontally()
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L_0x003b
            if (r7 <= 0) goto L_0x0039
        L_0x0037:
            r7 = 1
            goto L_0x003e
        L_0x0039:
            r7 = 0
            goto L_0x003e
        L_0x003b:
            if (r8 <= 0) goto L_0x0039
            goto L_0x0037
        L_0x003e:
            boolean r8 = r6 instanceof androidx.recyclerview.widget.RecyclerView.SmoothScroller.ScrollVectorProvider
            if (r8 == 0) goto L_0x0059
            androidx.recyclerview.widget.RecyclerView$SmoothScroller$ScrollVectorProvider r6 = (androidx.recyclerview.widget.RecyclerView.SmoothScroller.ScrollVectorProvider) r6
            int r0 = r0 - r4
            android.graphics.PointF r6 = r6.computeScrollVectorForPosition(r0)
            if (r6 == 0) goto L_0x0059
            float r8 = r6.x
            r0 = 0
            int r8 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r8 < 0) goto L_0x0058
            float r6 = r6.y
            int r6 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r6 >= 0) goto L_0x0059
        L_0x0058:
            r3 = 1
        L_0x0059:
            if (r3 == 0) goto L_0x0060
            if (r7 == 0) goto L_0x0064
            int r2 = r2 + -1
            goto L_0x0064
        L_0x0060:
            if (r7 == 0) goto L_0x0064
            int r2 = r2 + 1
        L_0x0064:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.PagerSnapHelper.findTargetSnapPosition(androidx.recyclerview.widget.RecyclerView$LayoutManager, int, int):int");
    }
}
