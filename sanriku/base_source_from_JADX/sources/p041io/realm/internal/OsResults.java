package p041io.realm.internal;

import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Date;
import java.util.NoSuchElementException;
import p009e.p010a.p011a.p012a.C0681a;
import p041io.realm.OrderedRealmCollectionChangeListener;
import p041io.realm.RealmChangeListener;
import p041io.realm.RealmList;
import p041io.realm.RealmModel;
import p041io.realm.internal.ObservableCollection;
import p041io.realm.internal.core.DescriptorOrdering;
import p041io.realm.internal.core.QueryDescriptor;
import p041io.realm.internal.objectstore.OsObjectBuilder;
import p041io.realm.internal.sync.OsSubscription;

/* renamed from: io.realm.internal.OsResults */
public class OsResults implements NativeObject, ObservableCollection {
    public static final byte AGGREGATE_FUNCTION_AVERAGE = 3;
    public static final byte AGGREGATE_FUNCTION_MAXIMUM = 2;
    public static final byte AGGREGATE_FUNCTION_MINIMUM = 1;
    public static final byte AGGREGATE_FUNCTION_SUM = 4;
    private static final String CLOSED_REALM_MESSAGE = "This Realm instance has already been closed, making it unusable.";
    public static final byte MODE_EMPTY = 0;
    public static final byte MODE_LINKVIEW = 3;
    public static final byte MODE_QUERY = 2;
    public static final byte MODE_TABLE = 1;
    public static final byte MODE_TABLEVIEW = 4;
    private static final long nativeFinalizerPtr = nativeGetFinalizerPtr();
    private final NativeContext context;
    /* access modifiers changed from: private */
    public boolean isSnapshot = false;
    protected boolean loaded;
    private final long nativePtr;
    protected final ObserverPairList<ObservableCollection.CollectionObserverPair> observerPairs = new ObserverPairList<>();
    /* access modifiers changed from: private */
    public final OsSharedRealm sharedRealm;
    private final Table table;

    /* renamed from: io.realm.internal.OsResults$AddListTypeDelegate */
    private interface AddListTypeDelegate<T> {
        void addList(OsObjectBuilder osObjectBuilder, RealmList<T> realmList);
    }

    /* renamed from: io.realm.internal.OsResults$Aggregate */
    public enum Aggregate {
        MINIMUM((byte) 1),
        MAXIMUM((byte) 2),
        AVERAGE((byte) 3),
        SUM((byte) 4);
        
        private final byte value;

        private Aggregate(byte b) {
            this.value = b;
        }

        public byte getValue() {
            return this.value;
        }
    }

    /* renamed from: io.realm.internal.OsResults$Iterator */
    public static abstract class Iterator<T> implements java.util.Iterator<T> {
        OsResults iteratorOsResults;
        protected int pos = -1;

        public Iterator(OsResults osResults) {
            if (!osResults.sharedRealm.isClosed()) {
                this.iteratorOsResults = osResults;
                if (!osResults.isSnapshot) {
                    if (osResults.sharedRealm.isInTransaction()) {
                        detach();
                    } else {
                        this.iteratorOsResults.sharedRealm.addIterator(this);
                    }
                }
            } else {
                throw new IllegalStateException(OsResults.CLOSED_REALM_MESSAGE);
            }
        }

        /* access modifiers changed from: package-private */
        public void checkValid() {
            if (this.iteratorOsResults == null) {
                throw new ConcurrentModificationException("No outside changes to a Realm is allowed while iterating a living Realm collection.");
            }
        }

        /* access modifiers changed from: protected */
        public abstract T convertRowToObject(UncheckedRow uncheckedRow);

        /* access modifiers changed from: package-private */
        public void detach() {
            this.iteratorOsResults = this.iteratorOsResults.createSnapshot();
        }

        /* access modifiers changed from: package-private */
        public T get(int i) {
            return convertRowToObject(this.iteratorOsResults.getUncheckedRow(i));
        }

        public boolean hasNext() {
            checkValid();
            return ((long) (this.pos + 1)) < this.iteratorOsResults.size();
        }

        /* access modifiers changed from: package-private */
        public void invalidate() {
            this.iteratorOsResults = null;
        }

        public T next() {
            checkValid();
            int i = this.pos + 1;
            this.pos = i;
            if (((long) i) < this.iteratorOsResults.size()) {
                return get(this.pos);
            }
            StringBuilder a = C0681a.m330a("Cannot access index ");
            a.append(this.pos);
            a.append(" when size is ");
            a.append(this.iteratorOsResults.size());
            a.append(". Remember to check hasNext() before using next().");
            throw new NoSuchElementException(a.toString());
        }

        @Deprecated
        public void remove() {
            throw new UnsupportedOperationException("remove() is not supported by RealmResults iterators.");
        }
    }

    /* renamed from: io.realm.internal.OsResults$ListIterator */
    public static abstract class ListIterator<T> extends Iterator<T> implements java.util.ListIterator<T> {
        public ListIterator(OsResults osResults, int i) {
            super(osResults);
            if (i < 0 || ((long) i) > this.iteratorOsResults.size()) {
                StringBuilder a = C0681a.m330a("Starting location must be a valid index: [0, ");
                a.append(this.iteratorOsResults.size() - 1);
                a.append("]. Yours was ");
                a.append(i);
                throw new IndexOutOfBoundsException(a.toString());
            }
            this.pos = i - 1;
        }

        @Deprecated
        public void add(T t) {
            throw new UnsupportedOperationException("Adding an element is not supported. Use Realm.createObject() instead.");
        }

        public boolean hasPrevious() {
            checkValid();
            return this.pos >= 0;
        }

        public int nextIndex() {
            checkValid();
            return this.pos + 1;
        }

        public T previous() {
            checkValid();
            try {
                this.pos--;
                return get(this.pos);
            } catch (IndexOutOfBoundsException unused) {
                throw new NoSuchElementException(C0681a.m322a(C0681a.m330a("Cannot access index less than zero. This was "), this.pos, ". Remember to check hasPrevious() before using previous()."));
            }
        }

        public int previousIndex() {
            checkValid();
            return this.pos;
        }

        @Deprecated
        public void set(T t) {
            throw new UnsupportedOperationException("Replacing an element is not supported.");
        }
    }

    /* renamed from: io.realm.internal.OsResults$Mode */
    public enum Mode {
        EMPTY,
        TABLE,
        QUERY,
        LINKVIEW,
        TABLEVIEW;

        static Mode getByValue(byte b) {
            if (b == 0) {
                return EMPTY;
            }
            if (b == 1) {
                return TABLE;
            }
            if (b == 2) {
                return QUERY;
            }
            if (b == 3) {
                return LINKVIEW;
            }
            if (b == 4) {
                return TABLEVIEW;
            }
            throw new IllegalArgumentException(C0681a.m316a("Invalid value: ", (int) b));
        }
    }

    OsResults(OsSharedRealm osSharedRealm, Table table2, long j) {
        boolean z = false;
        this.sharedRealm = osSharedRealm;
        NativeContext nativeContext = osSharedRealm.context;
        this.context = nativeContext;
        this.table = table2;
        this.nativePtr = j;
        nativeContext.addReference(this);
        this.loaded = getMode() != Mode.QUERY ? true : z;
    }

    private <T> void addTypeSpecificList(String str, RealmList<T> realmList, AddListTypeDelegate<T> addListTypeDelegate) {
        OsObjectBuilder osObjectBuilder = new OsObjectBuilder(getTable(), 0, Collections.EMPTY_SET);
        addListTypeDelegate.addList(osObjectBuilder, realmList);
        try {
            nativeSetList(this.nativePtr, str, osObjectBuilder.getNativePtr());
        } finally {
            osObjectBuilder.close();
        }
    }

    public static OsResults createForBacklinks(OsSharedRealm osSharedRealm, UncheckedRow uncheckedRow, Table table2, String str) {
        return new OsResults(osSharedRealm, table2, nativeCreateResultsFromBacklinks(osSharedRealm.getNativePtr(), uncheckedRow.getNativePtr(), table2.getNativePtr(), table2.getColumnIndex(str)));
    }

    public static OsResults createFromQuery(OsSharedRealm osSharedRealm, TableQuery tableQuery) {
        return createFromQuery(osSharedRealm, tableQuery, new DescriptorOrdering());
    }

    public static OsResults createFromQuery(OsSharedRealm osSharedRealm, TableQuery tableQuery, DescriptorOrdering descriptorOrdering) {
        tableQuery.validateQuery();
        return new OsResults(osSharedRealm, tableQuery.getTable(), nativeCreateResults(osSharedRealm.getNativePtr(), tableQuery.getNativePtr(), descriptorOrdering.getNativePtr()));
    }

    private static native Object nativeAggregate(long j, long j2, byte b);

    private static native void nativeClear(long j);

    private static native boolean nativeContains(long j, long j2);

    protected static native long nativeCreateResults(long j, long j2, long j3);

    private static native long nativeCreateResultsFromBacklinks(long j, long j2, long j3, long j4);

    private static native long nativeCreateSnapshot(long j);

    private static native void nativeDelete(long j, long j2);

    private static native boolean nativeDeleteFirst(long j);

    private static native boolean nativeDeleteLast(long j);

    private static native long nativeDistinct(long j, QueryDescriptor queryDescriptor);

    private static native void nativeEvaluateQueryIfNeeded(long j, boolean z);

    private static native long nativeFirstRow(long j);

    private static native long nativeGetFinalizerPtr();

    private static native byte nativeGetMode(long j);

    private static native long nativeGetRow(long j, int i);

    private static native long nativeIndexOf(long j, long j2);

    private static native boolean nativeIsValid(long j);

    private static native long nativeLastRow(long j);

    private static native void nativeSetBinary(long j, String str, byte[] bArr);

    private static native void nativeSetBoolean(long j, String str, boolean z);

    private static native void nativeSetDouble(long j, String str, double d);

    private static native void nativeSetFloat(long j, String str, float f);

    private static native void nativeSetInt(long j, String str, long j2);

    private static native void nativeSetList(long j, String str, long j2);

    private static native void nativeSetNull(long j, String str);

    private static native void nativeSetObject(long j, String str, long j2);

    private static native void nativeSetString(long j, String str, String str2);

    private static native void nativeSetTimestamp(long j, String str, long j2);

    private static native long nativeSize(long j);

    private static native long nativeSort(long j, QueryDescriptor queryDescriptor);

    private native void nativeStartListening(long j);

    private native void nativeStopListening(long j);

    private static native long nativeWhere(long j);

    private static native String toJSON(long j, int i);

    public <T> void addListener(T t, OrderedRealmCollectionChangeListener<T> orderedRealmCollectionChangeListener) {
        if (this.observerPairs.isEmpty()) {
            nativeStartListening(this.nativePtr);
        }
        this.observerPairs.add(new ObservableCollection.CollectionObserverPair(t, orderedRealmCollectionChangeListener));
    }

    public <T> void addListener(T t, RealmChangeListener<T> realmChangeListener) {
        addListener(t, new ObservableCollection.RealmChangeListenerWrapper(realmChangeListener));
    }

    public Date aggregateDate(Aggregate aggregate, long j) {
        return (Date) nativeAggregate(this.nativePtr, j, aggregate.getValue());
    }

    public Number aggregateNumber(Aggregate aggregate, long j) {
        return (Number) nativeAggregate(this.nativePtr, j, aggregate.getValue());
    }

    public void clear() {
        nativeClear(this.nativePtr);
    }

    public boolean contains(UncheckedRow uncheckedRow) {
        return nativeContains(this.nativePtr, uncheckedRow.getNativePtr());
    }

    public OsResults createSnapshot() {
        if (this.isSnapshot) {
            return this;
        }
        OsResults osResults = new OsResults(this.sharedRealm, this.table, nativeCreateSnapshot(this.nativePtr));
        osResults.isSnapshot = true;
        return osResults;
    }

    public void delete(long j) {
        nativeDelete(this.nativePtr, j);
    }

    public boolean deleteFirst() {
        return nativeDeleteFirst(this.nativePtr);
    }

    public boolean deleteLast() {
        return nativeDeleteLast(this.nativePtr);
    }

    public OsResults distinct(QueryDescriptor queryDescriptor) {
        return new OsResults(this.sharedRealm, this.table, nativeDistinct(this.nativePtr, queryDescriptor));
    }

    public UncheckedRow firstUncheckedRow() {
        long nativeFirstRow = nativeFirstRow(this.nativePtr);
        if (nativeFirstRow != 0) {
            return this.table.getUncheckedRowByPointer(nativeFirstRow);
        }
        return null;
    }

    public Mode getMode() {
        return Mode.getByValue(nativeGetMode(this.nativePtr));
    }

    public long getNativeFinalizerPtr() {
        return nativeFinalizerPtr;
    }

    public long getNativePtr() {
        return this.nativePtr;
    }

    public Table getTable() {
        return this.table;
    }

    public UncheckedRow getUncheckedRow(int i) {
        return this.table.getUncheckedRowByPointer(nativeGetRow(this.nativePtr, i));
    }

    public int indexOf(UncheckedRow uncheckedRow) {
        long nativeIndexOf = nativeIndexOf(this.nativePtr, uncheckedRow.getNativePtr());
        if (nativeIndexOf > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) nativeIndexOf;
    }

    public boolean isLoaded() {
        return this.loaded;
    }

    public boolean isValid() {
        return nativeIsValid(this.nativePtr);
    }

    public UncheckedRow lastUncheckedRow() {
        long nativeLastRow = nativeLastRow(this.nativePtr);
        if (nativeLastRow != 0) {
            return this.table.getUncheckedRowByPointer(nativeLastRow);
        }
        return null;
    }

    public void load() {
        if (!this.loaded) {
            nativeEvaluateQueryIfNeeded(this.nativePtr, false);
            notifyChangeListeners(0);
        }
    }

    public void notifyChangeListeners(long j) {
        OsCollectionChangeSet osCollectionChangeSet;
        if (j == 0) {
            osCollectionChangeSet = new EmptyLoadChangeSet((OsSubscription) null, this.sharedRealm.isPartial());
        } else {
            osCollectionChangeSet = new OsCollectionChangeSet(j, !isLoaded(), (OsSubscription) null, this.sharedRealm.isPartial());
        }
        if (!osCollectionChangeSet.isEmpty() || !isLoaded()) {
            this.loaded = true;
            this.observerPairs.foreach(new ObservableCollection.Callback(osCollectionChangeSet));
        }
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

    public void setBlob(String str, byte[] bArr) {
        nativeSetBinary(this.nativePtr, str, bArr);
    }

    public void setBoolean(String str, boolean z) {
        nativeSetBoolean(this.nativePtr, str, z);
    }

    public void setBooleanList(String str, RealmList<Boolean> realmList) {
        addTypeSpecificList(str, realmList, new AddListTypeDelegate<Boolean>() {
            public void addList(OsObjectBuilder osObjectBuilder, RealmList<Boolean> realmList) {
                osObjectBuilder.addBooleanList(0, realmList);
            }
        });
    }

    public void setByteArrayList(String str, RealmList<byte[]> realmList) {
        addTypeSpecificList(str, realmList, new AddListTypeDelegate<byte[]>() {
            public void addList(OsObjectBuilder osObjectBuilder, RealmList<byte[]> realmList) {
                osObjectBuilder.addByteArrayList(0, realmList);
            }
        });
    }

    public void setByteList(String str, RealmList<Byte> realmList) {
        addTypeSpecificList(str, realmList, new AddListTypeDelegate<Byte>() {
            public void addList(OsObjectBuilder osObjectBuilder, RealmList<Byte> realmList) {
                osObjectBuilder.addByteList(0, realmList);
            }
        });
    }

    public void setDate(String str, Date date) {
        long j = this.nativePtr;
        if (date == null) {
            nativeSetNull(j, str);
        } else {
            nativeSetTimestamp(j, str, date.getTime());
        }
    }

    public void setDateList(String str, RealmList<Date> realmList) {
        addTypeSpecificList(str, realmList, new AddListTypeDelegate<Date>() {
            public void addList(OsObjectBuilder osObjectBuilder, RealmList<Date> realmList) {
                osObjectBuilder.addDateList(0, realmList);
            }
        });
    }

    public void setDouble(String str, double d) {
        nativeSetDouble(this.nativePtr, str, d);
    }

    public void setDoubleList(String str, RealmList<Double> realmList) {
        addTypeSpecificList(str, realmList, new AddListTypeDelegate<Double>() {
            public void addList(OsObjectBuilder osObjectBuilder, RealmList<Double> realmList) {
                osObjectBuilder.addDoubleList(0, realmList);
            }
        });
    }

    public void setFloat(String str, float f) {
        nativeSetFloat(this.nativePtr, str, f);
    }

    public void setFloatList(String str, RealmList<Float> realmList) {
        addTypeSpecificList(str, realmList, new AddListTypeDelegate<Float>() {
            public void addList(OsObjectBuilder osObjectBuilder, RealmList<Float> realmList) {
                osObjectBuilder.addFloatList(0, realmList);
            }
        });
    }

    public void setInt(String str, long j) {
        nativeSetInt(this.nativePtr, str, j);
    }

    public void setIntegerList(String str, RealmList<Integer> realmList) {
        addTypeSpecificList(str, realmList, new AddListTypeDelegate<Integer>() {
            public void addList(OsObjectBuilder osObjectBuilder, RealmList<Integer> realmList) {
                osObjectBuilder.addIntegerList(0, realmList);
            }
        });
    }

    public void setLongList(String str, RealmList<Long> realmList) {
        addTypeSpecificList(str, realmList, new AddListTypeDelegate<Long>() {
            public void addList(OsObjectBuilder osObjectBuilder, RealmList<Long> realmList) {
                osObjectBuilder.addLongList(0, realmList);
            }
        });
    }

    public void setModelList(String str, RealmList<RealmModel> realmList) {
        addTypeSpecificList(str, realmList, new AddListTypeDelegate<RealmModel>() {
            public void addList(OsObjectBuilder osObjectBuilder, RealmList<RealmModel> realmList) {
                osObjectBuilder.addObjectList(0, realmList);
            }
        });
    }

    public void setNull(String str) {
        nativeSetNull(this.nativePtr, str);
    }

    public void setObject(String str, Row row) {
        UncheckedRow uncheckedRow;
        if (row == null) {
            setNull(str);
            return;
        }
        if (row instanceof UncheckedRow) {
            uncheckedRow = (UncheckedRow) row;
        } else if (row instanceof CheckedRow) {
            uncheckedRow = (CheckedRow) row;
        } else {
            StringBuilder a = C0681a.m330a("Unsupported Row type: ");
            a.append(row.getClass().getCanonicalName());
            throw new UnsupportedOperationException(a.toString());
        }
        nativeSetObject(this.nativePtr, str, uncheckedRow.getNativePtr());
    }

    public void setShortList(String str, RealmList<Short> realmList) {
        addTypeSpecificList(str, realmList, new AddListTypeDelegate<Short>() {
            public void addList(OsObjectBuilder osObjectBuilder, RealmList<Short> realmList) {
                osObjectBuilder.addShortList(0, realmList);
            }
        });
    }

    public void setString(String str, String str2) {
        nativeSetString(this.nativePtr, str, str2);
    }

    public void setStringList(String str, RealmList<String> realmList) {
        addTypeSpecificList(str, realmList, new AddListTypeDelegate<String>() {
            public void addList(OsObjectBuilder osObjectBuilder, RealmList<String> realmList) {
                osObjectBuilder.addStringList(0, realmList);
            }
        });
    }

    public long size() {
        return nativeSize(this.nativePtr);
    }

    public OsResults sort(QueryDescriptor queryDescriptor) {
        return new OsResults(this.sharedRealm, this.table, nativeSort(this.nativePtr, queryDescriptor));
    }

    public String toJSON(int i) {
        return toJSON(this.nativePtr, i);
    }

    public TableQuery where() {
        return new TableQuery(this.context, this.table, nativeWhere(this.nativePtr));
    }
}
