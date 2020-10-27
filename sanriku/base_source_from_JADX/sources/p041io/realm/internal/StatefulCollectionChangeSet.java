package p041io.realm.internal;

import p041io.realm.OrderedCollectionChangeSet;

/* renamed from: io.realm.internal.StatefulCollectionChangeSet */
public class StatefulCollectionChangeSet implements OrderedCollectionChangeSet {
    private final OrderedCollectionChangeSet changeset;
    private final Throwable error;
    private final boolean remoteDataSynchronized;
    private final OrderedCollectionChangeSet.State state;

    public StatefulCollectionChangeSet(OsCollectionChangeSet osCollectionChangeSet) {
        this.changeset = osCollectionChangeSet;
        boolean isFirstAsyncCallback = osCollectionChangeSet.isFirstAsyncCallback();
        this.remoteDataSynchronized = osCollectionChangeSet.isRemoteDataLoaded();
        Throwable error2 = osCollectionChangeSet.getError();
        this.error = error2;
        this.state = error2 != null ? OrderedCollectionChangeSet.State.ERROR : isFirstAsyncCallback ? OrderedCollectionChangeSet.State.INITIAL : OrderedCollectionChangeSet.State.UPDATE;
    }

    public OrderedCollectionChangeSet.Range[] getChangeRanges() {
        return this.changeset.getChangeRanges();
    }

    public int[] getChanges() {
        return this.changeset.getChanges();
    }

    public OrderedCollectionChangeSet.Range[] getDeletionRanges() {
        return this.changeset.getDeletionRanges();
    }

    public int[] getDeletions() {
        return this.changeset.getDeletions();
    }

    public Throwable getError() {
        return this.error;
    }

    public OrderedCollectionChangeSet.Range[] getInsertionRanges() {
        return this.changeset.getInsertionRanges();
    }

    public int[] getInsertions() {
        return this.changeset.getInsertions();
    }

    public OrderedCollectionChangeSet.State getState() {
        return this.state;
    }

    public boolean isCompleteResult() {
        return this.remoteDataSynchronized;
    }
}
