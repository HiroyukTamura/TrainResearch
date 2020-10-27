package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import p009e.p010a.p011a.p012a.C0681a;

class LayoutState {
    static final int INVALID_LAYOUT = Integer.MIN_VALUE;
    static final int ITEM_DIRECTION_HEAD = -1;
    static final int ITEM_DIRECTION_TAIL = 1;
    static final int LAYOUT_END = 1;
    static final int LAYOUT_START = -1;
    static final String TAG = "LayoutState";
    int mAvailable;
    int mCurrentPosition;
    int mEndLine = 0;
    boolean mInfinite;
    int mItemDirection;
    int mLayoutDirection;
    boolean mRecycle = true;
    int mStartLine = 0;
    boolean mStopInFocusable;

    LayoutState() {
    }

    /* access modifiers changed from: package-private */
    public boolean hasMore(RecyclerView.State state) {
        int i = this.mCurrentPosition;
        return i >= 0 && i < state.getItemCount();
    }

    /* access modifiers changed from: package-private */
    public View next(RecyclerView.Recycler recycler) {
        View viewForPosition = recycler.getViewForPosition(this.mCurrentPosition);
        this.mCurrentPosition += this.mItemDirection;
        return viewForPosition;
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("LayoutState{mAvailable=");
        a.append(this.mAvailable);
        a.append(", mCurrentPosition=");
        a.append(this.mCurrentPosition);
        a.append(", mItemDirection=");
        a.append(this.mItemDirection);
        a.append(", mLayoutDirection=");
        a.append(this.mLayoutDirection);
        a.append(", mStartLine=");
        a.append(this.mStartLine);
        a.append(", mEndLine=");
        a.append(this.mEndLine);
        a.append('}');
        return a.toString();
    }
}
