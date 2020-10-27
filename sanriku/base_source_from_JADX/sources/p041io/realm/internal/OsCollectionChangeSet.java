package p041io.realm.internal;

import java.util.Arrays;
import p009e.p010a.p011a.p012a.C0681a;
import p041io.realm.OrderedCollectionChangeSet;
import p041io.realm.internal.sync.OsSubscription;

/* renamed from: io.realm.internal.OsCollectionChangeSet */
public class OsCollectionChangeSet implements OrderedCollectionChangeSet, NativeObject {
    public static final int MAX_ARRAY_LENGTH = 2147483639;
    public static final int TYPE_DELETION = 0;
    public static final int TYPE_INSERTION = 1;
    public static final int TYPE_MODIFICATION = 2;
    private static long finalizerPtr = nativeGetFinalizerPtr();
    private final boolean firstAsyncCallback;
    protected final boolean isPartialRealm;
    private final long nativePtr;
    protected final OsSubscription subscription;

    public OsCollectionChangeSet(long j, boolean z) {
        this(j, z, (OsSubscription) null, false);
    }

    public OsCollectionChangeSet(long j, boolean z, OsSubscription osSubscription, boolean z2) {
        this.nativePtr = j;
        this.firstAsyncCallback = z;
        this.subscription = osSubscription;
        this.isPartialRealm = z2;
        NativeContext.dummyContext.addReference(this);
    }

    private OrderedCollectionChangeSet.Range[] longArrayToRangeArray(int[] iArr) {
        if (iArr == null) {
            return new OrderedCollectionChangeSet.Range[0];
        }
        int length = iArr.length / 2;
        OrderedCollectionChangeSet.Range[] rangeArr = new OrderedCollectionChangeSet.Range[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            rangeArr[i] = new OrderedCollectionChangeSet.Range(iArr[i2], iArr[i2 + 1]);
        }
        return rangeArr;
    }

    private static native long nativeGetFinalizerPtr();

    private static native int[] nativeGetIndices(long j, int i);

    private static native int[] nativeGetRanges(long j, int i);

    public OrderedCollectionChangeSet.Range[] getChangeRanges() {
        return longArrayToRangeArray(nativeGetRanges(this.nativePtr, 2));
    }

    public int[] getChanges() {
        return nativeGetIndices(this.nativePtr, 2);
    }

    public OrderedCollectionChangeSet.Range[] getDeletionRanges() {
        return longArrayToRangeArray(nativeGetRanges(this.nativePtr, 0));
    }

    public int[] getDeletions() {
        return nativeGetIndices(this.nativePtr, 0);
    }

    public Throwable getError() {
        OsSubscription osSubscription = this.subscription;
        if (osSubscription == null || osSubscription.getState() != OsSubscription.SubscriptionState.ERROR) {
            return null;
        }
        return this.subscription.getError();
    }

    public OrderedCollectionChangeSet.Range[] getInsertionRanges() {
        return longArrayToRangeArray(nativeGetRanges(this.nativePtr, 1));
    }

    public int[] getInsertions() {
        return nativeGetIndices(this.nativePtr, 1);
    }

    public long getNativeFinalizerPtr() {
        return finalizerPtr;
    }

    public long getNativePtr() {
        return this.nativePtr;
    }

    public OrderedCollectionChangeSet.State getState() {
        throw new UnsupportedOperationException("This method should be overridden in a subclass");
    }

    public boolean isCompleteResult() {
        throw new UnsupportedOperationException("This method should be overridden in a subclass");
    }

    public boolean isEmpty() {
        return this.nativePtr == 0;
    }

    public boolean isFirstAsyncCallback() {
        return this.firstAsyncCallback;
    }

    public boolean isRemoteDataLoaded() {
        if (!this.isPartialRealm) {
            return true;
        }
        OsSubscription osSubscription = this.subscription;
        return osSubscription != null && osSubscription.getState() == OsSubscription.SubscriptionState.COMPLETE;
    }

    public String toString() {
        if (this.nativePtr == 0) {
            return "Change set is empty.";
        }
        StringBuilder a = C0681a.m330a("Deletion Ranges: ");
        a.append(Arrays.toString(getDeletionRanges()));
        a.append("\nInsertion Ranges: ");
        a.append(Arrays.toString(getInsertionRanges()));
        a.append("\nChange Ranges: ");
        a.append(Arrays.toString(getChangeRanges()));
        return a.toString();
    }
}
