package p041io.realm.internal;

import p041io.realm.OrderedCollectionChangeSet;
import p041io.realm.internal.sync.OsSubscription;

/* renamed from: io.realm.internal.EmptyLoadChangeSet */
public class EmptyLoadChangeSet extends OsCollectionChangeSet {
    private static final int[] NO_INDEX_CHANGES = new int[0];
    private static final OrderedCollectionChangeSet.Range[] NO_RANGE_CHANGES = new OrderedCollectionChangeSet.Range[0];

    public EmptyLoadChangeSet(OsSubscription osSubscription, boolean z) {
        super(0, true, osSubscription, z);
    }

    public EmptyLoadChangeSet(OsSubscription osSubscription, boolean z, boolean z2) {
        super(0, z, osSubscription, z2);
    }

    public OrderedCollectionChangeSet.Range[] getChangeRanges() {
        return NO_RANGE_CHANGES;
    }

    public int[] getChanges() {
        return NO_INDEX_CHANGES;
    }

    public OrderedCollectionChangeSet.Range[] getDeletionRanges() {
        return NO_RANGE_CHANGES;
    }

    public int[] getDeletions() {
        return NO_INDEX_CHANGES;
    }

    public Throwable getError() {
        OsSubscription osSubscription = this.subscription;
        if (osSubscription == null || osSubscription.getState() != OsSubscription.SubscriptionState.ERROR) {
            return null;
        }
        return this.subscription.getError();
    }

    public OrderedCollectionChangeSet.Range[] getInsertionRanges() {
        return NO_RANGE_CHANGES;
    }

    public int[] getInsertions() {
        return NO_INDEX_CHANGES;
    }

    public long getNativeFinalizerPtr() {
        return super.getNativeFinalizerPtr();
    }

    public long getNativePtr() {
        return super.getNativePtr();
    }

    public OrderedCollectionChangeSet.State getState() {
        return OrderedCollectionChangeSet.State.INITIAL;
    }

    public boolean isCompleteResult() {
        return isRemoteDataLoaded();
    }

    public boolean isEmpty() {
        return this.subscription == null;
    }

    public boolean isFirstAsyncCallback() {
        return super.isFirstAsyncCallback();
    }

    public boolean isRemoteDataLoaded() {
        return super.isRemoteDataLoaded();
    }

    public String toString() {
        return super.toString();
    }
}
