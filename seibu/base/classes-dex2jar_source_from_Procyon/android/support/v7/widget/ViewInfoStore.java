// 
// Decompiled by Procyon v0.5.36
// 

package android.support.v7.widget;

import android.support.annotation.NonNull;
import android.support.v4.util.Pools;
import android.support.annotation.Nullable;
import android.support.v4.util.LongSparseArray;
import android.support.annotation.VisibleForTesting;
import android.support.v4.util.ArrayMap;

class ViewInfoStore
{
    private static final boolean DEBUG = false;
    @VisibleForTesting
    final ArrayMap<RecyclerView.ViewHolder, InfoRecord> mLayoutHolderMap;
    @VisibleForTesting
    final LongSparseArray<RecyclerView.ViewHolder> mOldChangedHolders;
    
    ViewInfoStore() {
        this.mLayoutHolderMap = new ArrayMap<RecyclerView.ViewHolder, InfoRecord>();
        this.mOldChangedHolders = new LongSparseArray<RecyclerView.ViewHolder>();
    }
    
    private RecyclerView.ItemAnimator.ItemHolderInfo popFromLayoutStep(final RecyclerView.ViewHolder viewHolder, final int n) {
        final RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo = null;
        final int indexOfKey = this.mLayoutHolderMap.indexOfKey(viewHolder);
        RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2;
        if (indexOfKey < 0) {
            itemHolderInfo2 = itemHolderInfo;
        }
        else {
            final InfoRecord infoRecord = this.mLayoutHolderMap.valueAt(indexOfKey);
            itemHolderInfo2 = itemHolderInfo;
            if (infoRecord != null) {
                itemHolderInfo2 = itemHolderInfo;
                if ((infoRecord.flags & n) != 0x0) {
                    infoRecord.flags &= ~n;
                    RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo3;
                    if (n == 4) {
                        itemHolderInfo3 = infoRecord.preInfo;
                    }
                    else {
                        if (n != 8) {
                            throw new IllegalArgumentException("Must provide flag PRE or POST");
                        }
                        itemHolderInfo3 = infoRecord.postInfo;
                    }
                    itemHolderInfo2 = itemHolderInfo3;
                    if ((infoRecord.flags & 0xC) == 0x0) {
                        this.mLayoutHolderMap.removeAt(indexOfKey);
                        InfoRecord.recycle(infoRecord);
                        return itemHolderInfo3;
                    }
                }
            }
        }
        return itemHolderInfo2;
    }
    
    void addToAppearedInPreLayoutHolders(final RecyclerView.ViewHolder viewHolder, final RecyclerView.ItemAnimator.ItemHolderInfo preInfo) {
        InfoRecord obtain;
        if ((obtain = this.mLayoutHolderMap.get(viewHolder)) == null) {
            obtain = InfoRecord.obtain();
            this.mLayoutHolderMap.put(viewHolder, obtain);
        }
        obtain.flags |= 0x2;
        obtain.preInfo = preInfo;
    }
    
    void addToDisappearedInLayout(final RecyclerView.ViewHolder viewHolder) {
        InfoRecord obtain;
        if ((obtain = this.mLayoutHolderMap.get(viewHolder)) == null) {
            obtain = InfoRecord.obtain();
            this.mLayoutHolderMap.put(viewHolder, obtain);
        }
        obtain.flags |= 0x1;
    }
    
    void addToOldChangeHolders(final long n, final RecyclerView.ViewHolder viewHolder) {
        this.mOldChangedHolders.put(n, viewHolder);
    }
    
    void addToPostLayout(final RecyclerView.ViewHolder viewHolder, final RecyclerView.ItemAnimator.ItemHolderInfo postInfo) {
        InfoRecord obtain;
        if ((obtain = this.mLayoutHolderMap.get(viewHolder)) == null) {
            obtain = InfoRecord.obtain();
            this.mLayoutHolderMap.put(viewHolder, obtain);
        }
        obtain.postInfo = postInfo;
        obtain.flags |= 0x8;
    }
    
    void addToPreLayout(final RecyclerView.ViewHolder viewHolder, final RecyclerView.ItemAnimator.ItemHolderInfo preInfo) {
        InfoRecord obtain;
        if ((obtain = this.mLayoutHolderMap.get(viewHolder)) == null) {
            obtain = InfoRecord.obtain();
            this.mLayoutHolderMap.put(viewHolder, obtain);
        }
        obtain.preInfo = preInfo;
        obtain.flags |= 0x4;
    }
    
    void clear() {
        this.mLayoutHolderMap.clear();
        this.mOldChangedHolders.clear();
    }
    
    RecyclerView.ViewHolder getFromOldChangeHolders(final long n) {
        return this.mOldChangedHolders.get(n);
    }
    
    boolean isDisappearing(final RecyclerView.ViewHolder viewHolder) {
        final InfoRecord infoRecord = this.mLayoutHolderMap.get(viewHolder);
        return infoRecord != null && (infoRecord.flags & 0x1) != 0x0;
    }
    
    boolean isInPreLayout(final RecyclerView.ViewHolder viewHolder) {
        final InfoRecord infoRecord = this.mLayoutHolderMap.get(viewHolder);
        return infoRecord != null && (infoRecord.flags & 0x4) != 0x0;
    }
    
    void onDetach() {
        InfoRecord.drainCache();
    }
    
    public void onViewDetached(final RecyclerView.ViewHolder viewHolder) {
        this.removeFromDisappearedInLayout(viewHolder);
    }
    
    @Nullable
    RecyclerView.ItemAnimator.ItemHolderInfo popFromPostLayout(final RecyclerView.ViewHolder viewHolder) {
        return this.popFromLayoutStep(viewHolder, 8);
    }
    
    @Nullable
    RecyclerView.ItemAnimator.ItemHolderInfo popFromPreLayout(final RecyclerView.ViewHolder viewHolder) {
        return this.popFromLayoutStep(viewHolder, 4);
    }
    
    void process(final ProcessCallback processCallback) {
        for (int i = this.mLayoutHolderMap.size() - 1; i >= 0; --i) {
            final RecyclerView.ViewHolder viewHolder = this.mLayoutHolderMap.keyAt(i);
            final InfoRecord infoRecord = this.mLayoutHolderMap.removeAt(i);
            if ((infoRecord.flags & 0x3) == 0x3) {
                processCallback.unused(viewHolder);
            }
            else if ((infoRecord.flags & 0x1) != 0x0) {
                if (infoRecord.preInfo == null) {
                    processCallback.unused(viewHolder);
                }
                else {
                    processCallback.processDisappeared(viewHolder, infoRecord.preInfo, infoRecord.postInfo);
                }
            }
            else if ((infoRecord.flags & 0xE) == 0xE) {
                processCallback.processAppeared(viewHolder, infoRecord.preInfo, infoRecord.postInfo);
            }
            else if ((infoRecord.flags & 0xC) == 0xC) {
                processCallback.processPersistent(viewHolder, infoRecord.preInfo, infoRecord.postInfo);
            }
            else if ((infoRecord.flags & 0x4) != 0x0) {
                processCallback.processDisappeared(viewHolder, infoRecord.preInfo, null);
            }
            else if ((infoRecord.flags & 0x8) != 0x0) {
                processCallback.processAppeared(viewHolder, infoRecord.preInfo, infoRecord.postInfo);
            }
            else if ((infoRecord.flags & 0x2) != 0x0) {}
            InfoRecord.recycle(infoRecord);
        }
    }
    
    void removeFromDisappearedInLayout(final RecyclerView.ViewHolder viewHolder) {
        final InfoRecord infoRecord = this.mLayoutHolderMap.get(viewHolder);
        if (infoRecord == null) {
            return;
        }
        infoRecord.flags &= 0xFFFFFFFE;
    }
    
    void removeViewHolder(final RecyclerView.ViewHolder viewHolder) {
        for (int i = this.mOldChangedHolders.size() - 1; i >= 0; --i) {
            if (viewHolder == this.mOldChangedHolders.valueAt(i)) {
                this.mOldChangedHolders.removeAt(i);
                break;
            }
        }
        final InfoRecord infoRecord = this.mLayoutHolderMap.remove(viewHolder);
        if (infoRecord != null) {
            InfoRecord.recycle(infoRecord);
        }
    }
    
    static class InfoRecord
    {
        static final int FLAG_APPEAR = 2;
        static final int FLAG_APPEAR_AND_DISAPPEAR = 3;
        static final int FLAG_APPEAR_PRE_AND_POST = 14;
        static final int FLAG_DISAPPEARED = 1;
        static final int FLAG_POST = 8;
        static final int FLAG_PRE = 4;
        static final int FLAG_PRE_AND_POST = 12;
        static Pools.Pool<InfoRecord> sPool;
        int flags;
        @Nullable
        RecyclerView.ItemAnimator.ItemHolderInfo postInfo;
        @Nullable
        RecyclerView.ItemAnimator.ItemHolderInfo preInfo;
        
        static {
            InfoRecord.sPool = new Pools.SimplePool<InfoRecord>(20);
        }
        
        private InfoRecord() {
        }
        
        static void drainCache() {
            while (InfoRecord.sPool.acquire() != null) {}
        }
        
        static InfoRecord obtain() {
            InfoRecord infoRecord;
            if ((infoRecord = InfoRecord.sPool.acquire()) == null) {
                infoRecord = new InfoRecord();
            }
            return infoRecord;
        }
        
        static void recycle(final InfoRecord infoRecord) {
            infoRecord.flags = 0;
            infoRecord.preInfo = null;
            infoRecord.postInfo = null;
            InfoRecord.sPool.release(infoRecord);
        }
    }
    
    interface ProcessCallback
    {
        void processAppeared(final RecyclerView.ViewHolder p0, @Nullable final RecyclerView.ItemAnimator.ItemHolderInfo p1, final RecyclerView.ItemAnimator.ItemHolderInfo p2);
        
        void processDisappeared(final RecyclerView.ViewHolder p0, @NonNull final RecyclerView.ItemAnimator.ItemHolderInfo p1, @Nullable final RecyclerView.ItemAnimator.ItemHolderInfo p2);
        
        void processPersistent(final RecyclerView.ViewHolder p0, @NonNull final RecyclerView.ItemAnimator.ItemHolderInfo p1, @NonNull final RecyclerView.ItemAnimator.ItemHolderInfo p2);
        
        void unused(final RecyclerView.ViewHolder p0);
    }
}
