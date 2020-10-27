package p041io.realm;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.AbstractList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Locale;
import p009e.p010a.p011a.p012a.C0681a;
import p041io.realm.internal.InvalidRow;
import p041io.realm.internal.OsResults;
import p041io.realm.internal.RealmObjectProxy;
import p041io.realm.internal.Table;
import p041io.realm.internal.UncheckedRow;
import p041io.realm.internal.core.QueryDescriptor;
import p041io.realm.internal.fields.FieldDescriptor;

/* renamed from: io.realm.OrderedRealmCollectionImpl */
abstract class OrderedRealmCollectionImpl<E> extends AbstractList<E> implements OrderedRealmCollection<E> {
    private static final String NOT_SUPPORTED_MESSAGE = "This method is not supported by 'RealmResults' or 'OrderedRealmCollectionSnapshot'.";
    final String className;
    final Class<E> classSpec;
    @SuppressFBWarnings({"SS_SHOULD_BE_STATIC"})
    final boolean forValues;
    final OsResults osResults;
    final BaseRealm realm;

    /* renamed from: io.realm.OrderedRealmCollectionImpl$RealmCollectionIterator */
    private class RealmCollectionIterator extends OsResults.Iterator<E> {
        RealmCollectionIterator() {
            super(OrderedRealmCollectionImpl.this.osResults);
        }

        /* access modifiers changed from: protected */
        public E convertRowToObject(UncheckedRow uncheckedRow) {
            OrderedRealmCollectionImpl orderedRealmCollectionImpl = OrderedRealmCollectionImpl.this;
            return orderedRealmCollectionImpl.realm.get(orderedRealmCollectionImpl.classSpec, orderedRealmCollectionImpl.className, uncheckedRow);
        }
    }

    /* renamed from: io.realm.OrderedRealmCollectionImpl$RealmCollectionListIterator */
    private class RealmCollectionListIterator extends OsResults.ListIterator<E> {
        RealmCollectionListIterator(int i) {
            super(OrderedRealmCollectionImpl.this.osResults, i);
        }

        /* access modifiers changed from: protected */
        public E convertRowToObject(UncheckedRow uncheckedRow) {
            OrderedRealmCollectionImpl orderedRealmCollectionImpl = OrderedRealmCollectionImpl.this;
            return orderedRealmCollectionImpl.realm.get(orderedRealmCollectionImpl.classSpec, orderedRealmCollectionImpl.className, uncheckedRow);
        }
    }

    OrderedRealmCollectionImpl(BaseRealm baseRealm, OsResults osResults2, Class<E> cls) {
        this(baseRealm, osResults2, cls, (String) null);
    }

    private OrderedRealmCollectionImpl(BaseRealm baseRealm, OsResults osResults2, Class<E> cls, String str) {
        this.forValues = false;
        this.realm = baseRealm;
        this.osResults = osResults2;
        this.classSpec = cls;
        this.className = str;
    }

    OrderedRealmCollectionImpl(BaseRealm baseRealm, OsResults osResults2, String str) {
        this(baseRealm, osResults2, (Class) null, str);
    }

    private E firstImpl(boolean z, E e) {
        UncheckedRow firstUncheckedRow = this.osResults.firstUncheckedRow();
        if (firstUncheckedRow != null) {
            return this.realm.get(this.classSpec, this.className, firstUncheckedRow);
        }
        if (!z) {
            return e;
        }
        throw new IndexOutOfBoundsException("No results were found.");
    }

    private long getColumnIndexForSort(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Non-empty field name required.");
        } else if (!str.contains(".")) {
            long columnIndex = this.osResults.getTable().getColumnIndex(str);
            if (columnIndex >= 0) {
                return columnIndex;
            }
            throw new IllegalArgumentException(String.format(Locale.US, "Field '%s' does not exist.", new Object[]{str}));
        } else {
            throw new IllegalArgumentException(C0681a.m320a("Aggregates on child object fields are not supported: ", str));
        }
    }

    private SchemaConnector getSchemaConnector() {
        return new SchemaConnector(this.realm.getSchema());
    }

    private E lastImpl(boolean z, E e) {
        UncheckedRow lastUncheckedRow = this.osResults.lastUncheckedRow();
        if (lastUncheckedRow != null) {
            return this.realm.get(this.classSpec, this.className, lastUncheckedRow);
        }
        if (!z) {
            return e;
        }
        throw new IndexOutOfBoundsException("No results were found.");
    }

    @Deprecated
    public void add(int i, E e) {
        throw new UnsupportedOperationException(NOT_SUPPORTED_MESSAGE);
    }

    @Deprecated
    public boolean add(E e) {
        throw new UnsupportedOperationException(NOT_SUPPORTED_MESSAGE);
    }

    @Deprecated
    public boolean addAll(int i, Collection<? extends E> collection) {
        throw new UnsupportedOperationException(NOT_SUPPORTED_MESSAGE);
    }

    @Deprecated
    public boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException(NOT_SUPPORTED_MESSAGE);
    }

    public double average(String str) {
        this.realm.checkIfValid();
        return this.osResults.aggregateNumber(OsResults.Aggregate.AVERAGE, getColumnIndexForSort(str)).doubleValue();
    }

    @Deprecated
    public void clear() {
        throw new UnsupportedOperationException(NOT_SUPPORTED_MESSAGE);
    }

    public boolean contains(Object obj) {
        if (!isLoaded() || ((obj instanceof RealmObjectProxy) && ((RealmObjectProxy) obj).realmGet$proxyState().getRow$realm() == InvalidRow.INSTANCE)) {
            return false;
        }
        Iterator it = iterator();
        while (it.hasNext()) {
            if (it.next().equals(obj)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public RealmResults<E> createLoadedResults(OsResults osResults2) {
        RealmResults<E> realmResults;
        String str = this.className;
        if (str != null) {
            BaseRealm baseRealm = this.realm;
        } else {
            realmResults = new RealmResults<>(this.realm, osResults2, this.classSpec);
        }
        realmResults.load();
        return realmResults;
    }

    public OrderedRealmCollectionSnapshot<E> createSnapshot() {
        String str = this.className;
        return str != null ? new OrderedRealmCollectionSnapshot<>(this.realm, this.osResults, str) : new OrderedRealmCollectionSnapshot<>(this.realm, this.osResults, this.classSpec);
    }

    public boolean deleteAllFromRealm() {
        this.realm.checkIfValid();
        if (size() <= 0) {
            return false;
        }
        this.osResults.clear();
        return true;
    }

    public boolean deleteFirstFromRealm() {
        this.realm.checkIfValidAndInTransaction();
        return this.osResults.deleteFirst();
    }

    public void deleteFromRealm(int i) {
        this.realm.checkIfValidAndInTransaction();
        this.osResults.delete((long) i);
    }

    public boolean deleteLastFromRealm() {
        this.realm.checkIfValidAndInTransaction();
        return this.osResults.deleteLast();
    }

    public E first() {
        return firstImpl(true, (Object) null);
    }

    public E first(E e) {
        return firstImpl(false, e);
    }

    public E get(int i) {
        this.realm.checkIfValid();
        return this.realm.get(this.classSpec, this.className, this.osResults.getUncheckedRow(i));
    }

    /* access modifiers changed from: package-private */
    public OsResults getOsResults() {
        return this.osResults;
    }

    public Realm getRealm() {
        this.realm.checkIfValid();
        BaseRealm baseRealm = this.realm;
        if (baseRealm instanceof Realm) {
            return (Realm) baseRealm;
        }
        throw new IllegalStateException("This method is only available for typed Realms");
    }

    /* access modifiers changed from: package-private */
    public Table getTable() {
        return this.osResults.getTable();
    }

    public boolean isManaged() {
        return true;
    }

    public boolean isValid() {
        return this.osResults.isValid();
    }

    public Iterator<E> iterator() {
        return new RealmCollectionIterator();
    }

    public E last() {
        return lastImpl(true, (Object) null);
    }

    public E last(E e) {
        return lastImpl(false, e);
    }

    public ListIterator<E> listIterator() {
        return new RealmCollectionListIterator(0);
    }

    public ListIterator<E> listIterator(int i) {
        return new RealmCollectionListIterator(i);
    }

    public Number max(String str) {
        this.realm.checkIfValid();
        return this.osResults.aggregateNumber(OsResults.Aggregate.MAXIMUM, getColumnIndexForSort(str));
    }

    public Date maxDate(String str) {
        this.realm.checkIfValid();
        return this.osResults.aggregateDate(OsResults.Aggregate.MAXIMUM, getColumnIndexForSort(str));
    }

    public Number min(String str) {
        this.realm.checkIfValid();
        return this.osResults.aggregateNumber(OsResults.Aggregate.MINIMUM, getColumnIndexForSort(str));
    }

    public Date minDate(String str) {
        this.realm.checkIfValid();
        return this.osResults.aggregateDate(OsResults.Aggregate.MINIMUM, getColumnIndexForSort(str));
    }

    @Deprecated
    public E remove(int i) {
        throw new UnsupportedOperationException(NOT_SUPPORTED_MESSAGE);
    }

    @Deprecated
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException(NOT_SUPPORTED_MESSAGE);
    }

    @Deprecated
    public boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException(NOT_SUPPORTED_MESSAGE);
    }

    @Deprecated
    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException(NOT_SUPPORTED_MESSAGE);
    }

    @Deprecated
    public E set(int i, E e) {
        throw new UnsupportedOperationException(NOT_SUPPORTED_MESSAGE);
    }

    public int size() {
        if (!isLoaded()) {
            return 0;
        }
        long size = this.osResults.size();
        if (size > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) size;
    }

    public RealmResults<E> sort(String str) {
        return createLoadedResults(this.osResults.sort(QueryDescriptor.getInstanceForSort((FieldDescriptor.SchemaProxy) getSchemaConnector(), this.osResults.getTable(), str, Sort.ASCENDING)));
    }

    public RealmResults<E> sort(String str, Sort sort) {
        return createLoadedResults(this.osResults.sort(QueryDescriptor.getInstanceForSort((FieldDescriptor.SchemaProxy) getSchemaConnector(), this.osResults.getTable(), str, sort)));
    }

    public RealmResults<E> sort(String str, Sort sort, String str2, Sort sort2) {
        return sort(new String[]{str, str2}, new Sort[]{sort, sort2});
    }

    public RealmResults<E> sort(String[] strArr, Sort[] sortArr) {
        return createLoadedResults(this.osResults.sort(QueryDescriptor.getInstanceForSort((FieldDescriptor.SchemaProxy) getSchemaConnector(), this.osResults.getTable(), strArr, sortArr)));
    }

    public Number sum(String str) {
        this.realm.checkIfValid();
        return this.osResults.aggregateNumber(OsResults.Aggregate.SUM, getColumnIndexForSort(str));
    }
}
