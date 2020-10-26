// 
// Decompiled by Procyon v0.5.36
// 

package me.yokeyword.indexablerv;

import android.support.v4.view.ViewCompat;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.Collection;
import java.util.Collections;
import com.google.common.collect.Maps;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View$OnLongClickListener;
import android.view.View$OnClickListener;
import android.view.ViewGroup;
import android.content.res.ColorStateList;
import android.support.v7.widget.AppCompatTextView;
import android.view.View$OnTouchListener;
import android.content.res.TypedArray;
import android.view.ViewGroup$LayoutParams;
import android.widget.FrameLayout$LayoutParams;
import android.app.Activity;
import android.support.v4.content.ContextCompat;
import com.feilang.mvpproject.R;
import android.util.TypedValue;
import java.util.concurrent.Executors;
import android.os.Looper;
import java.util.ArrayList;
import java.util.List;
import android.util.AttributeSet;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import java.util.Comparator;
import me.yokeyword.indexablerv.database.IndexBarDataObserver;
import me.yokeyword.indexablerv.database.HeaderFooterDataObserver;
import android.os.Handler;
import java.util.concurrent.Future;
import java.util.concurrent.ExecutorService;
import me.yokeyword.indexablerv.database.DataObserver;
import android.content.Context;
import android.widget.TextView;
import android.graphics.drawable.Drawable;
import android.widget.FrameLayout;

public class IndexableLayout extends FrameLayout
{
    static final String INDEX_SIGN = "#";
    public static final int MODE_ALL_LETTERS = 1;
    public static final int MODE_FAST = 0;
    public static final int MODE_NONE = 2;
    private static int PADDING_RIGHT_OVERLAY;
    private Drawable mBarBg;
    private int mBarFocusTextColor;
    private int mBarTextColor;
    private float mBarTextSize;
    private float mBarTextSpace;
    private float mBarWidth;
    private TextView mCenterOverlay;
    private int mCompareMode;
    private Context mContext;
    private DataObserver mDataSetObserver;
    private ExecutorService mExecutorService;
    private Future mFuture;
    private Handler mHandler;
    private HeaderFooterDataObserver<EntityWrapper> mHeaderFooterDataSetObserver;
    private IndexBar mIndexBar;
    private IndexBarDataObserver mIndexBarDataSetObserver;
    private IndexableAdapter mIndexableAdapter;
    private Comparator mItemComparator;
    private View mLastInvisibleRecyclerViewItemView;
    private RecyclerView.LayoutManager mLayoutManager;
    public IndexableLayout.IndexableLayout$DataSetFinishListener mListener;
    private TextView mMDOverlay;
    private int mPositionTouching;
    private RealAdapter mRealAdapter;
    private RecyclerView mRecy;
    private boolean mShowAllLetter;
    private String mStickyTitle;
    private RecyclerView.ViewHolder mStickyViewHolder;
    private boolean mSticyEnable;
    private Comparator mTitleComparator;
    private IndexableLayout.IndexableLayout$TransformHandler mTransformer;
    
    public IndexableLayout(final Context context) {
        this(context, null);
    }
    
    public IndexableLayout(final Context context, final AttributeSet set) {
        this(context, set, 0);
    }
    
    public IndexableLayout(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
        this.mShowAllLetter = true;
        this.mPositionTouching = -1;
        this.mSticyEnable = true;
        this.mCompareMode = 2;
        this.mHeaderFooterDataSetObserver = (HeaderFooterDataObserver<EntityWrapper>)new IndexableLayout$1(this);
        this.mIndexBarDataSetObserver = (IndexBarDataObserver)new IndexableLayout$2(this);
        this.init(context, set);
    }
    
    public static int dpToPx(final Context context, final float n) {
        return (int)(n * context.getResources().getDisplayMetrics().density + 0.5f);
    }
    
    private Handler getSafeHandler() {
        if (this.mHandler == null) {
            this.mHandler = new Handler(Looper.getMainLooper());
        }
        return this.mHandler;
    }
    
    private void init(final Context mContext, final AttributeSet set) {
        this.mContext = mContext;
        this.mExecutorService = Executors.newSingleThreadExecutor();
        IndexableLayout.PADDING_RIGHT_OVERLAY = (int)TypedValue.applyDimension(1, 80.0f, this.getResources().getDisplayMetrics());
        int n = 0;
        int n2 = 0;
        int layoutDimension = 0;
        if (set != null) {
            final TypedArray obtainStyledAttributes = mContext.obtainStyledAttributes(set, R.styleable.IndexableRecyclerView);
            this.mBarTextColor = obtainStyledAttributes.getColor(R.styleable.IndexableRecyclerView_indexBar_textColor, ContextCompat.getColor(mContext, R.color.default_indexBar_textColor));
            this.mBarTextSize = obtainStyledAttributes.getDimension(R.styleable.IndexableRecyclerView_indexBar_textSize, this.getResources().getDimension(R.dimen.default_indexBar_textSize));
            this.mBarFocusTextColor = obtainStyledAttributes.getColor(R.styleable.IndexableRecyclerView_indexBar_selectedTextColor, ContextCompat.getColor(mContext, R.color.default_indexBar_selectedTextColor));
            this.mBarTextSpace = obtainStyledAttributes.getDimension(R.styleable.IndexableRecyclerView_indexBar_textSpace, this.getResources().getDimension(R.dimen.default_indexBar_textSpace));
            this.mBarBg = obtainStyledAttributes.getDrawable(R.styleable.IndexableRecyclerView_indexBar_background);
            this.mBarWidth = obtainStyledAttributes.getDimension(R.styleable.IndexableRecyclerView_indexBar_layoutWidth, this.getResources().getDimension(R.dimen.default_indexBar_layout_width));
            n = (int)obtainStyledAttributes.getDimension(R.styleable.IndexableRecyclerView_indexBar_marginEnd, this.getResources().getDimension(R.dimen.default_indexBar_margin_right));
            n2 = (int)obtainStyledAttributes.getDimension(R.styleable.IndexableRecyclerView_indexBar_marginTop, this.getResources().getDimension(R.dimen.default_indexBar_margin_top));
            layoutDimension = obtainStyledAttributes.getLayoutDimension(R.styleable.IndexableRecyclerView_indexBar_layoutHeight, -1);
            obtainStyledAttributes.recycle();
        }
        if (this.mContext instanceof Activity) {
            ((Activity)this.mContext).getWindow().setSoftInputMode(32);
        }
        (this.mRecy = new RecyclerView(mContext)).setVerticalScrollBarEnabled(false);
        this.mRecy.setOverScrollMode(0);
        this.addView((View)this.mRecy, (ViewGroup$LayoutParams)new FrameLayout$LayoutParams(-1, -1));
        this.mIndexBar = new IndexBar(mContext);
        final IndexBar mIndexBar = this.mIndexBar;
        final Drawable mBarBg = this.mBarBg;
        final int mBarTextColor = this.mBarTextColor;
        final int mBarFocusTextColor = this.mBarFocusTextColor;
        final float mBarTextSize = this.mBarTextSize;
        float mBarTextSpace;
        if (layoutDimension == -1) {
            mBarTextSpace = -999.0f;
        }
        else {
            mBarTextSpace = this.mBarTextSpace;
        }
        mIndexBar.init(mBarBg, mBarTextColor, mBarFocusTextColor, mBarTextSize, mBarTextSpace);
        final int n3 = (int)this.mBarWidth;
        int n4;
        if (layoutDimension == 1) {
            n4 = -1;
        }
        else {
            n4 = -2;
        }
        final FrameLayout$LayoutParams frameLayout$LayoutParams = new FrameLayout$LayoutParams(n3, n4);
        frameLayout$LayoutParams.setMargins(0, n2, n, n2);
        frameLayout$LayoutParams.gravity = 8388661;
        this.addView((View)this.mIndexBar, (ViewGroup$LayoutParams)frameLayout$LayoutParams);
        this.mRealAdapter = new RealAdapter();
        this.mRecy.setHasFixedSize(true);
        this.mRecy.setAdapter((RecyclerView.Adapter)this.mRealAdapter);
        this.initListener();
    }
    
    private void initCenterOverlay() {
        (this.mCenterOverlay = new TextView(this.mContext)).setBackgroundResource(R.drawable.indexable_bg_center_overlay);
        this.mCenterOverlay.setTextColor(-1);
        this.mCenterOverlay.setTextSize(40.0f);
        this.mCenterOverlay.setGravity(17);
        final int n = (int)TypedValue.applyDimension(1, 70.0f, this.getResources().getDisplayMetrics());
        final FrameLayout$LayoutParams layoutParams = new FrameLayout$LayoutParams(n, n);
        layoutParams.gravity = 17;
        this.mCenterOverlay.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
        this.mCenterOverlay.setVisibility(4);
        this.addView((View)this.mCenterOverlay);
    }
    
    private void initListener() {
        this.mRecy.addOnScrollListener((RecyclerView.OnScrollListener)new IndexableLayout$5(this));
        this.mIndexBar.setOnTouchListener((View$OnTouchListener)new IndexableLayout$6(this));
    }
    
    private void initMDOverlay(int n) {
        (this.mMDOverlay = new AppCompatTextView(this.mContext)).setBackgroundResource(R.drawable.indexable_bg_md_overlay);
        ((AppCompatTextView)this.mMDOverlay).setSupportBackgroundTintList(ColorStateList.valueOf(n));
        this.mMDOverlay.setSingleLine();
        this.mMDOverlay.setTextColor(-1);
        this.mMDOverlay.setTextSize(38.0f);
        this.mMDOverlay.setGravity(17);
        n = (int)TypedValue.applyDimension(1, 72.0f, this.getResources().getDisplayMetrics());
        final FrameLayout$LayoutParams layoutParams = new FrameLayout$LayoutParams(n, n);
        layoutParams.rightMargin = (int)TypedValue.applyDimension(1, 33.0f, this.getResources().getDisplayMetrics());
        layoutParams.gravity = 8388613;
        this.mMDOverlay.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
        this.mMDOverlay.setVisibility(4);
        this.addView((View)this.mMDOverlay);
    }
    
    private <T extends IndexableEntity> void initStickyView(final IndexableAdapter<T> indexableAdapter) {
        this.mStickyViewHolder = indexableAdapter.onCreateTitleViewHolder((ViewGroup)this.mRecy);
        this.mStickyViewHolder.itemView.setOnClickListener((View$OnClickListener)new IndexableLayout$7(this, (IndexableAdapter)indexableAdapter));
        this.mStickyViewHolder.itemView.setOnLongClickListener((View$OnLongClickListener)new IndexableLayout$8(this, (IndexableAdapter)indexableAdapter));
        for (int i = 0; i < this.getChildCount(); ++i) {
            if (this.getChildAt(i) == this.mRecy) {
                this.mStickyViewHolder.itemView.setVisibility(4);
                this.addView(this.mStickyViewHolder.itemView, i + 1);
                break;
            }
        }
    }
    
    private <T extends IndexableEntity> void pinyinIndexTransform(final EntityWrapper<T> entityWrapper, final T t) {
        final String fieldIndexBy = t.getFieldIndexBy();
        final String pingYin = PinyinUtil.getPingYin(fieldIndexBy);
        entityWrapper.setPinyin(pingYin);
        if (PinyinUtil.matchingLetter(pingYin)) {
            entityWrapper.setIndex(pingYin.substring(0, 1).toUpperCase());
            entityWrapper.setIndexByField(t.getFieldIndexBy());
        }
        else if (PinyinUtil.matchingPolyphone(pingYin)) {
            entityWrapper.setIndex(PinyinUtil.gePolyphoneInitial(pingYin).toUpperCase());
            entityWrapper.setPinyin(PinyinUtil.getPolyphoneRealPinyin(pingYin));
            final String polyphoneRealHanzi = PinyinUtil.getPolyphoneRealHanzi(fieldIndexBy);
            entityWrapper.setIndexByField(polyphoneRealHanzi);
            t.setFieldIndexBy(polyphoneRealHanzi);
        }
        else {
            entityWrapper.setIndex("#");
            entityWrapper.setIndexByField(t.getFieldIndexBy());
        }
        entityWrapper.setIndexTitle(entityWrapper.getIndex());
    }
    
    private void processScroll(final LinearLayoutManager linearLayoutManager, final ArrayList<EntityWrapper> list, final int index, final String s) {
        final EntityWrapper entityWrapper = list.get(index);
        final View viewByPosition = linearLayoutManager.findViewByPosition(index);
        if (viewByPosition != null) {
            if (entityWrapper.getItemType() == 2147483646) {
                if (viewByPosition.getTop() <= this.mStickyViewHolder.itemView.getHeight() && s != null) {
                    this.mStickyViewHolder.itemView.setTranslationY((float)(viewByPosition.getTop() - this.mStickyViewHolder.itemView.getHeight()));
                }
                if (4 == viewByPosition.getVisibility()) {
                    viewByPosition.setVisibility(0);
                }
            }
            else if (this.mStickyViewHolder.itemView.getTranslationY() != 0.0f) {
                this.mStickyViewHolder.itemView.setTranslationY(0.0f);
            }
        }
    }
    
    private void processScrollListener() {
        if (this.mLayoutManager instanceof LinearLayoutManager) {
            final LinearLayoutManager linearLayoutManager = (LinearLayoutManager)this.mLayoutManager;
            final int firstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
            if (firstVisibleItemPosition != -1) {
                if (this.mPositionTouching < 0) {
                    this.mIndexBar.setSelection(firstVisibleItemPosition);
                }
                else {
                    this.mPositionTouching = -1;
                }
                if (this.mSticyEnable) {
                    final ArrayList items = this.mRealAdapter.getItems();
                    if (this.mStickyViewHolder != null && items.size() > firstVisibleItemPosition) {
                        final EntityWrapper entityWrapper = items.get(firstVisibleItemPosition);
                        final String indexTitle = entityWrapper.getIndexTitle();
                        if (2147483646 == entityWrapper.getItemType()) {
                            if (this.mLastInvisibleRecyclerViewItemView != null && this.mLastInvisibleRecyclerViewItemView.getVisibility() == 4) {
                                this.mLastInvisibleRecyclerViewItemView.setVisibility(0);
                                this.mLastInvisibleRecyclerViewItemView = null;
                            }
                            this.mLastInvisibleRecyclerViewItemView = linearLayoutManager.findViewByPosition(firstVisibleItemPosition);
                            if (this.mLastInvisibleRecyclerViewItemView != null) {}
                        }
                        if (indexTitle == null && this.mStickyViewHolder.itemView.getVisibility() == 0) {
                            this.mStickyTitle = null;
                            this.mStickyViewHolder.itemView.setVisibility(4);
                        }
                        else {
                            this.stickyNewViewHolder(indexTitle);
                        }
                        if (this.mLayoutManager instanceof GridLayoutManager) {
                            final GridLayoutManager gridLayoutManager = (GridLayoutManager)this.mLayoutManager;
                            if (gridLayoutManager.getSpanCount() + firstVisibleItemPosition < items.size()) {
                                for (int i = firstVisibleItemPosition + 1; i <= gridLayoutManager.getSpanCount() + firstVisibleItemPosition; ++i) {
                                    this.processScroll(linearLayoutManager, items, i, indexTitle);
                                }
                            }
                        }
                        else if (firstVisibleItemPosition + 1 < items.size()) {
                            this.processScroll(linearLayoutManager, items, firstVisibleItemPosition + 1, indexTitle);
                        }
                    }
                }
            }
        }
    }
    
    private void showOverlayView(final float n, final int n2) {
        if (this.mIndexBar.getIndexList().size() > n2) {
            if (this.mMDOverlay != null) {
                if (this.mMDOverlay.getVisibility() != 0) {
                    this.mMDOverlay.setVisibility(0);
                }
                float n3;
                if (n < IndexableLayout.PADDING_RIGHT_OVERLAY - this.mIndexBar.getTop() && n >= 0.0f) {
                    n3 = (float)(IndexableLayout.PADDING_RIGHT_OVERLAY - this.mIndexBar.getTop());
                }
                else if (n < 0.0f) {
                    if (this.mIndexBar.getTop() > IndexableLayout.PADDING_RIGHT_OVERLAY) {
                        n3 = 0.0f;
                    }
                    else {
                        n3 = (float)(IndexableLayout.PADDING_RIGHT_OVERLAY - this.mIndexBar.getTop());
                    }
                }
                else {
                    n3 = n;
                    if (n > this.mIndexBar.getHeight()) {
                        n3 = (float)this.mIndexBar.getHeight();
                    }
                }
                this.mMDOverlay.setY(this.mIndexBar.getTop() + n3 - IndexableLayout.PADDING_RIGHT_OVERLAY);
                final String s = this.mIndexBar.getIndexList().get(n2);
                if (!this.mMDOverlay.getText().toString().equals(s)) {
                    if (s.length() > 1) {
                        this.mMDOverlay.setTextSize(30.0f);
                    }
                    this.mMDOverlay.setText((CharSequence)s);
                }
            }
            if (this.mCenterOverlay != null) {
                if (this.mCenterOverlay.getVisibility() != 0) {
                    this.mCenterOverlay.setVisibility(0);
                }
                final String s2 = this.mIndexBar.getIndexList().get(n2);
                if (!this.mCenterOverlay.getText().toString().equals(s2)) {
                    if (s2.length() > 1) {
                        this.mCenterOverlay.setTextSize(32.0f);
                    }
                    this.mCenterOverlay.setText((CharSequence)s2);
                }
            }
        }
    }
    
    private void stickyNewViewHolder(final String mStickyTitle) {
        if (mStickyTitle != null && !mStickyTitle.equals(this.mStickyTitle)) {
            if (this.mStickyViewHolder.itemView.getVisibility() != 0) {
                this.mStickyViewHolder.itemView.setVisibility(0);
            }
            this.mStickyTitle = mStickyTitle;
            this.mIndexableAdapter.onBindTitleViewHolder(this.mStickyViewHolder, mStickyTitle);
        }
    }
    
    private <T extends IndexableEntity> ArrayList<EntityWrapper<T>> transform(final List<T> list) {
        ArrayList<EntityWrapper<T>> list2;
        while (true) {
            TreeMap<String, List<EntityWrapper>> treeMap;
            int originalPosition;
            EntityWrapper entityWrapper;
            IndexableEntity data;
            String index;
            Object value;
            Label_0069_Outer:Label_0156_Outer:
            while (true) {
            Label_0156:
                while (true) {
                    try {
                        if (this.mTitleComparator != null) {
                            treeMap = (TreeMap<String, List<EntityWrapper>>)Maps.newTreeMap((Comparator<Object>)this.mTitleComparator);
                            break Label_0156;
                        }
                        treeMap = (TreeMap<String, List<EntityWrapper>>)Maps.newTreeMap((Comparator<Object>)new IndexableLayout$10(this));
                        break Label_0156;
                        // iftrue(Label_0222:, originalPosition >= list.size())
                        // iftrue(Label_0208:, treeMap.containsKey((Object)index))
                        while (true) {
                            while (true) {
                                Block_7: {
                                    break Block_7;
                                    entityWrapper.setData((Object)data);
                                    entityWrapper.setOriginalPosition(originalPosition);
                                    data.setFieldPinyinIndexBy(entityWrapper.getPinyin());
                                    index = entityWrapper.getIndex();
                                    value = new ArrayList<EntityWrapper<T>>();
                                    ((List<EntityWrapper<T>>)value).add((EntityWrapper<T>)new EntityWrapper(entityWrapper.getIndex(), entityWrapper.getIndexTitle(), 2147483646));
                                    treeMap.put(index, (List<EntityWrapper>)value);
                                    break Label_0156;
                                    this.mTransformer.updateIndex(entityWrapper, data);
                                    continue Label_0156_Outer;
                                }
                                entityWrapper = new EntityWrapper();
                                data = list.get(originalPosition);
                                continue;
                            }
                            ((List<EntityWrapper<T>>)value).add((EntityWrapper<T>)entityWrapper);
                            ++originalPosition;
                            continue Label_0069_Outer;
                            Label_0188: {
                                this.pinyinIndexTransform((me.yokeyword.indexablerv.EntityWrapper<IndexableEntity>)entityWrapper, data);
                            }
                            continue Label_0156_Outer;
                        }
                    }
                    // iftrue(Label_0188:, this.mTransformer == null)
                    catch (Exception ex) {
                        ex.printStackTrace();
                        list2 = null;
                    }
                    break;
                    Label_0208: {
                        value = treeMap.get(index);
                    }
                    continue Label_0156;
                }
                originalPosition = 0;
                continue;
            }
        }
        return list2;
        final ArrayList<EntityWrapper<T>> list3;
        Label_0222: {
            list3 = new ArrayList<EntityWrapper<T>>();
        }
        TreeMap<String, List<EntityWrapper>> treeMap = null;
        final Iterator<List<EntityWrapper>> iterator = treeMap.values().iterator();
        while (true) {
            list2 = list3;
            if (!iterator.hasNext()) {
                return list2;
            }
            final List<EntityWrapper> list4 = iterator.next();
            if (this.mItemComparator != null) {
                Collections.sort((List<Object>)list4, this.mItemComparator);
            }
            else if (this.mCompareMode == 0) {
                Collections.sort((List<Object>)list4, (Comparator<? super Object>)new InitialComparator());
            }
            else if (this.mCompareMode == 1) {
                Collections.sort((List<Object>)list4, (Comparator<? super Object>)new PinyinComparator());
            }
            list3.addAll((Collection<? extends EntityWrapper<T>>)list4);
        }
    }
    
    public <T> void addFooterAdapter(final IndexableFooterAdapter<T> indexableFooterAdapter) {
        indexableFooterAdapter.registerDataSetObserver((HeaderFooterDataObserver)this.mHeaderFooterDataSetObserver);
        indexableFooterAdapter.registerIndexBarDataSetObserver(this.mIndexBarDataSetObserver);
        this.mRealAdapter.addIndexableFooterAdapter((IndexableFooterAdapter)indexableFooterAdapter);
    }
    
    public <T> void addHeaderAdapter(final IndexableHeaderAdapter<T> indexableHeaderAdapter) {
        indexableHeaderAdapter.registerDataSetObserver((HeaderFooterDataObserver)this.mHeaderFooterDataSetObserver);
        indexableHeaderAdapter.registerIndexBarDataSetObserver(this.mIndexBarDataSetObserver);
        this.mRealAdapter.addIndexableHeaderAdapter((IndexableHeaderAdapter)indexableHeaderAdapter);
    }
    
    public List<String> getIndexList() {
        return (List<String>)this.mIndexBar.getIndexList();
    }
    
    public TextView getOverlayView() {
        if (this.mMDOverlay != null) {
            return this.mMDOverlay;
        }
        return this.mCenterOverlay;
    }
    
    public RecyclerView getRecyclerView() {
        return this.mRecy;
    }
    
    void onDataChanged() {
        if (this.mFuture != null) {
            this.mFuture.cancel(true);
        }
        this.mFuture = this.mExecutorService.submit((Runnable)new IndexableLayout$9(this));
    }
    
    public <T> void removeFooterAdapter(final IndexableFooterAdapter<T> indexableFooterAdapter) {
        try {
            indexableFooterAdapter.unregisterDataSetObserver((HeaderFooterDataObserver)this.mHeaderFooterDataSetObserver);
            indexableFooterAdapter.unregisterIndexBarDataSetObserver(this.mIndexBarDataSetObserver);
            this.mRealAdapter.removeIndexableFooterAdapter((IndexableFooterAdapter)indexableFooterAdapter);
        }
        catch (Exception ex) {}
    }
    
    public <T> void removeHeaderAdapter(final IndexableHeaderAdapter<T> indexableHeaderAdapter) {
        try {
            indexableHeaderAdapter.unregisterDataSetObserver((HeaderFooterDataObserver)this.mHeaderFooterDataSetObserver);
            indexableHeaderAdapter.unregisterIndexBarDataSetObserver(this.mIndexBarDataSetObserver);
            this.mRealAdapter.removeIndexableHeaderAdapter((IndexableHeaderAdapter)indexableHeaderAdapter);
        }
        catch (Exception ex) {}
    }
    
    public void scrollToIndex(final int selectionPosition) {
        if (selectionPosition < 0) {
            return;
        }
        final LinearLayoutManager linearLayoutManager = (LinearLayoutManager)this.mLayoutManager;
        if (selectionPosition == 0) {
            linearLayoutManager.scrollToPositionWithOffset(0, 0);
        }
        else {
            linearLayoutManager.scrollToPositionWithOffset(this.mIndexBar.getFirstRecyclerViewPosition(selectionPosition), 0);
        }
        this.mIndexBar.setSelectionPosition(selectionPosition);
    }
    
    public <T extends IndexableEntity> void setAdapter(final IndexableAdapter<T> indexableAdapter) {
        if (this.mLayoutManager == null) {
            throw new NullPointerException("You must set the LayoutManager first");
        }
        this.mIndexableAdapter = indexableAdapter;
        if (this.mDataSetObserver != null) {
            indexableAdapter.unregisterDataSetObserver(this.mDataSetObserver);
        }
        indexableAdapter.registerDataSetObserver(this.mDataSetObserver = (DataObserver)new IndexableLayout$3(this, (IndexableAdapter)indexableAdapter));
        this.mRealAdapter.setIndexableAdapter((IndexableAdapter)indexableAdapter);
        if (this.mSticyEnable) {
            this.initStickyView((me.yokeyword.indexablerv.IndexableAdapter<IndexableEntity>)indexableAdapter);
        }
    }
    
    public <T extends IndexableEntity> void setComparator(final Comparator<EntityWrapper<T>> mItemComparator) {
        this.mItemComparator = mItemComparator;
    }
    
    public void setCompareMode(final int mCompareMode) {
        this.mCompareMode = mCompareMode;
    }
    
    public void setDataSetFinishListener(final IndexableLayout.IndexableLayout$DataSetFinishListener mListener) {
        this.mListener = mListener;
    }
    
    @Deprecated
    public void setFastCompare(final boolean b) {
        int compareMode;
        if (b) {
            compareMode = 0;
        }
        else {
            compareMode = 1;
        }
        this.setCompareMode(compareMode);
    }
    
    public void setIndexBarVisibility(final boolean b) {
        final IndexBar mIndexBar = this.mIndexBar;
        int visibility;
        if (b) {
            visibility = 0;
        }
        else {
            visibility = 8;
        }
        mIndexBar.setVisibility(visibility);
    }
    
    public void setIndexHandler(final IndexBar$IndexHandler indexHandler) {
        this.mIndexBar.setIndexHandler(indexHandler);
    }
    
    public void setLayoutManager(final RecyclerView.LayoutManager mLayoutManager) {
        if (mLayoutManager == null) {
            throw new NullPointerException("LayoutManager == null");
        }
        this.mLayoutManager = mLayoutManager;
        if (mLayoutManager instanceof GridLayoutManager) {
            final GridLayoutManager gridLayoutManager = (GridLayoutManager)mLayoutManager;
            gridLayoutManager.setSpanSizeLookup((GridLayoutManager.SpanSizeLookup)new IndexableLayout$4(this, gridLayoutManager));
        }
        this.mRecy.setLayoutManager(this.mLayoutManager);
    }
    
    public void setOverlayStyle_Center() {
        if (this.mCenterOverlay == null) {
            this.initCenterOverlay();
        }
        this.mMDOverlay = null;
    }
    
    public void setOverlayStyle_MaterialDesign(final int n) {
        if (this.mMDOverlay == null) {
            this.initMDOverlay(n);
        }
        else {
            ViewCompat.setBackgroundTintList((View)this.mMDOverlay, ColorStateList.valueOf(n));
        }
        this.mCenterOverlay = null;
    }
    
    public void setStickyEnable(final boolean mSticyEnable) {
        this.mSticyEnable = mSticyEnable;
    }
    
    public <T> void setTitleComparator(final Comparator<T> mTitleComparator) {
        this.mTitleComparator = mTitleComparator;
    }
    
    public void setTransformer(final IndexableLayout.IndexableLayout$TransformHandler mTransformer) {
        this.mTransformer = mTransformer;
    }
    
    public void showAllLetter(final boolean mShowAllLetter) {
        this.mShowAllLetter = mShowAllLetter;
    }
}
