package p041io.realm.internal;

import java.util.Date;
import p041io.realm.OrderedRealmCollectionChangeListener;
import p041io.realm.RealmChangeListener;
import p041io.realm.internal.ObservableCollection;

/* renamed from: io.realm.internal.OsList */
public class OsList implements NativeObject, ObservableCollection {
    private static final long nativeFinalizerPtr = nativeGetFinalizerPtr();
    private final NativeContext context;
    private final long nativePtr;
    private final ObserverPairList<ObservableCollection.CollectionObserverPair> observerPairs = new ObserverPairList<>();
    private final Table targetTable;

    public OsList(UncheckedRow uncheckedRow, long j) {
        OsSharedRealm sharedRealm = uncheckedRow.getTable().getSharedRealm();
        long[] nativeCreate = nativeCreate(sharedRealm.getNativePtr(), uncheckedRow.getNativePtr(), j);
        this.nativePtr = nativeCreate[0];
        NativeContext nativeContext = sharedRealm.context;
        this.context = nativeContext;
        nativeContext.addReference(this);
        if (nativeCreate[1] != 0) {
            this.targetTable = new Table(sharedRealm, nativeCreate[1]);
        } else {
            this.targetTable = null;
        }
    }

    private static native void nativeAddBinary(long j, byte[] bArr);

    private static native void nativeAddBoolean(long j, boolean z);

    private static native void nativeAddDate(long j, long j2);

    private static native void nativeAddDouble(long j, double d);

    private static native void nativeAddFloat(long j, float f);

    private static native void nativeAddLong(long j, long j2);

    private static native void nativeAddNull(long j);

    private static native void nativeAddRow(long j, long j2);

    private static native void nativeAddString(long j, String str);

    private static native long[] nativeCreate(long j, long j2, long j3);

    private static native void nativeDelete(long j, long j2);

    private static native void nativeDeleteAll(long j);

    private static native long nativeGetFinalizerPtr();

    private static native long nativeGetQuery(long j);

    private static native long nativeGetRow(long j, long j2);

    private static native Object nativeGetValue(long j, long j2);

    private static native void nativeInsertBinary(long j, long j2, byte[] bArr);

    private static native void nativeInsertBoolean(long j, long j2, boolean z);

    private static native void nativeInsertDate(long j, long j2, long j3);

    private static native void nativeInsertDouble(long j, long j2, double d);

    private static native void nativeInsertFloat(long j, long j2, float f);

    private static native void nativeInsertLong(long j, long j2, long j3);

    private static native void nativeInsertNull(long j, long j2);

    private static native void nativeInsertRow(long j, long j2, long j3);

    private static native void nativeInsertString(long j, long j2, String str);

    private static native boolean nativeIsValid(long j);

    private static native void nativeMove(long j, long j2, long j3);

    private static native void nativeRemove(long j, long j2);

    private static native void nativeRemoveAll(long j);

    private static native void nativeSetBinary(long j, long j2, byte[] bArr);

    private static native void nativeSetBoolean(long j, long j2, boolean z);

    private static native void nativeSetDate(long j, long j2, long j3);

    private static native void nativeSetDouble(long j, long j2, double d);

    private static native void nativeSetFloat(long j, long j2, float f);

    private static native void nativeSetLong(long j, long j2, long j3);

    private static native void nativeSetNull(long j, long j2);

    private static native void nativeSetRow(long j, long j2, long j3);

    private static native void nativeSetString(long j, long j2, String str);

    private static native long nativeSize(long j);

    private native void nativeStartListening(long j);

    private native void nativeStopListening(long j);

    public void addBinary(byte[] bArr) {
        nativeAddBinary(this.nativePtr, bArr);
    }

    public void addBoolean(boolean z) {
        nativeAddBoolean(this.nativePtr, z);
    }

    public void addDate(Date date) {
        long j = this.nativePtr;
        if (date == null) {
            nativeAddNull(j);
        } else {
            nativeAddDate(j, date.getTime());
        }
    }

    public void addDouble(double d) {
        nativeAddDouble(this.nativePtr, d);
    }

    public void addFloat(float f) {
        nativeAddFloat(this.nativePtr, f);
    }

    public <T> void addListener(T t, OrderedRealmCollectionChangeListener<T> orderedRealmCollectionChangeListener) {
        if (this.observerPairs.isEmpty()) {
            nativeStartListening(this.nativePtr);
        }
        this.observerPairs.add(new ObservableCollection.CollectionObserverPair(t, orderedRealmCollectionChangeListener));
    }

    public <T> void addListener(T t, RealmChangeListener<T> realmChangeListener) {
        addListener(t, new ObservableCollection.RealmChangeListenerWrapper(realmChangeListener));
    }

    public void addLong(long j) {
        nativeAddLong(this.nativePtr, j);
    }

    public void addNull() {
        nativeAddNull(this.nativePtr);
    }

    public void addRow(long j) {
        nativeAddRow(this.nativePtr, j);
    }

    public void addString(String str) {
        nativeAddString(this.nativePtr, str);
    }

    public void delete(long j) {
        nativeDelete(this.nativePtr, j);
    }

    public void deleteAll() {
        nativeDeleteAll(this.nativePtr);
    }

    public long getNativeFinalizerPtr() {
        return nativeFinalizerPtr;
    }

    public long getNativePtr() {
        return this.nativePtr;
    }

    public TableQuery getQuery() {
        return new TableQuery(this.context, this.targetTable, nativeGetQuery(this.nativePtr));
    }

    public Table getTargetTable() {
        return this.targetTable;
    }

    public UncheckedRow getUncheckedRow(long j) {
        return this.targetTable.getUncheckedRowByPointer(nativeGetRow(this.nativePtr, j));
    }

    public Object getValue(long j) {
        return nativeGetValue(this.nativePtr, j);
    }

    public void insertBinary(long j, byte[] bArr) {
        nativeInsertBinary(this.nativePtr, j, bArr);
    }

    public void insertBoolean(long j, boolean z) {
        nativeInsertBoolean(this.nativePtr, j, z);
    }

    public void insertDate(long j, Date date) {
        if (date == null) {
            nativeInsertNull(this.nativePtr, j);
            return;
        }
        nativeInsertDate(this.nativePtr, j, date.getTime());
    }

    public void insertDouble(long j, double d) {
        nativeInsertDouble(this.nativePtr, j, d);
    }

    public void insertFloat(long j, float f) {
        nativeInsertFloat(this.nativePtr, j, f);
    }

    public void insertLong(long j, long j2) {
        nativeInsertLong(this.nativePtr, j, j2);
    }

    public void insertNull(long j) {
        nativeInsertNull(this.nativePtr, j);
    }

    public void insertRow(long j, long j2) {
        nativeInsertRow(this.nativePtr, j, j2);
    }

    public void insertString(long j, String str) {
        nativeInsertString(this.nativePtr, j, str);
    }

    public boolean isEmpty() {
        return nativeSize(this.nativePtr) <= 0;
    }

    public boolean isValid() {
        return nativeIsValid(this.nativePtr);
    }

    public void move(long j, long j2) {
        nativeMove(this.nativePtr, j, j2);
    }

    public void notifyChangeListeners(long j) {
        OsCollectionChangeSet osCollectionChangeSet = new OsCollectionChangeSet(j, false);
        if (!osCollectionChangeSet.isEmpty()) {
            this.observerPairs.foreach(new ObservableCollection.Callback(osCollectionChangeSet));
        }
    }

    public void remove(long j) {
        nativeRemove(this.nativePtr, j);
    }

    public void removeAll() {
        nativeRemoveAll(this.nativePtr);
    }

    public void removeAllListeners() {
        this.observerPairs.clear();
        nativeStopListening(this.nativePtr);
    }

    public <T> void removeListener(T t, OrderedRealmCollectionChangeListener<T> orderedRealmCollectionChangeListener) {
        this.observerPairs.remove(t, orderedRealmCollectionChangeListener);
        if (this.observerPairs.isEmpty()) {
            nativeStopListening(this.nativePtr);
        }
    }

    public <T> void removeListener(T t, RealmChangeListener<T> realmChangeListener) {
        removeListener(t, new ObservableCollection.RealmChangeListenerWrapper(realmChangeListener));
    }

    public void setBinary(long j, byte[] bArr) {
        nativeSetBinary(this.nativePtr, j, bArr);
    }

    public void setBoolean(long j, boolean z) {
        nativeSetBoolean(this.nativePtr, j, z);
    }

    public void setDate(long j, Date date) {
        if (date == null) {
            nativeSetNull(this.nativePtr, j);
            return;
        }
        nativeSetDate(this.nativePtr, j, date.getTime());
    }

    public void setDouble(long j, double d) {
        nativeSetDouble(this.nativePtr, j, d);
    }

    public void setFloat(long j, float f) {
        nativeSetFloat(this.nativePtr, j, f);
    }

    public void setLong(long j, long j2) {
        nativeSetLong(this.nativePtr, j, j2);
    }

    public void setNull(long j) {
        nativeSetNull(this.nativePtr, j);
    }

    public void setRow(long j, long j2) {
        nativeSetRow(this.nativePtr, j, j2);
    }

    public void setString(long j, String str) {
        nativeSetString(this.nativePtr, j, str);
    }

    public long size() {
        return nativeSize(this.nativePtr);
    }
}
