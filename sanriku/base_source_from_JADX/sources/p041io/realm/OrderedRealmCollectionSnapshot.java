package p041io.realm;

import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Locale;
import p041io.realm.internal.OsResults;
import p041io.realm.internal.UncheckedRow;

/* renamed from: io.realm.OrderedRealmCollectionSnapshot */
public class OrderedRealmCollectionSnapshot<E> extends OrderedRealmCollectionImpl<E> {
    private int size = -1;

    OrderedRealmCollectionSnapshot(BaseRealm baseRealm, OsResults osResults, Class<E> cls) {
        super(baseRealm, osResults.createSnapshot(), cls);
    }

    OrderedRealmCollectionSnapshot(BaseRealm baseRealm, OsResults osResults, String str) {
        super(baseRealm, osResults.createSnapshot(), str);
    }

    private UnsupportedOperationException getUnsupportedException(String str) {
        return new UnsupportedOperationException(String.format(Locale.US, "'%s()' is not supported by OrderedRealmCollectionSnapshot. Call '%s()' on the original 'RealmCollection' instead.", new Object[]{str, str}));
    }

    @Deprecated
    public /* bridge */ /* synthetic */ void add(int i, Object obj) {
        super.add(i, obj);
    }

    @Deprecated
    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        return super.add(obj);
    }

    @Deprecated
    public /* bridge */ /* synthetic */ boolean addAll(int i, Collection collection) {
        return super.addAll(i, collection);
    }

    @Deprecated
    public /* bridge */ /* synthetic */ boolean addAll(Collection collection) {
        return super.addAll(collection);
    }

    public /* bridge */ /* synthetic */ double average(String str) {
        return super.average(str);
    }

    @Deprecated
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    public /* bridge */ /* synthetic */ boolean contains(Object obj) {
        return super.contains(obj);
    }

    public OrderedRealmCollectionSnapshot<E> createSnapshot() {
        this.realm.checkIfValid();
        return this;
    }

    public boolean deleteAllFromRealm() {
        return super.deleteAllFromRealm();
    }

    public boolean deleteFirstFromRealm() {
        this.realm.checkIfValidAndInTransaction();
        UncheckedRow firstUncheckedRow = this.osResults.firstUncheckedRow();
        return firstUncheckedRow != null && firstUncheckedRow.isAttached() && this.osResults.deleteFirst();
    }

    public void deleteFromRealm(int i) {
        this.realm.checkIfValidAndInTransaction();
        if (this.osResults.getUncheckedRow(i).isAttached()) {
            this.osResults.delete((long) i);
        }
    }

    public boolean deleteLastFromRealm() {
        this.realm.checkIfValidAndInTransaction();
        UncheckedRow lastUncheckedRow = this.osResults.lastUncheckedRow();
        return lastUncheckedRow != null && lastUncheckedRow.isAttached() && this.osResults.deleteLast();
    }

    public /* bridge */ /* synthetic */ Object first() {
        return super.first();
    }

    public /* bridge */ /* synthetic */ Object first(Object obj) {
        return super.first(obj);
    }

    public /* bridge */ /* synthetic */ Object get(int i) {
        return super.get(i);
    }

    public /* bridge */ /* synthetic */ Realm getRealm() {
        return super.getRealm();
    }

    public boolean isLoaded() {
        return true;
    }

    public /* bridge */ /* synthetic */ boolean isManaged() {
        return super.isManaged();
    }

    public /* bridge */ /* synthetic */ boolean isValid() {
        return super.isValid();
    }

    public /* bridge */ /* synthetic */ Iterator iterator() {
        return super.iterator();
    }

    public /* bridge */ /* synthetic */ Object last() {
        return super.last();
    }

    public /* bridge */ /* synthetic */ Object last(Object obj) {
        return super.last(obj);
    }

    public /* bridge */ /* synthetic */ ListIterator listIterator() {
        return super.listIterator();
    }

    public /* bridge */ /* synthetic */ ListIterator listIterator(int i) {
        return super.listIterator(i);
    }

    public boolean load() {
        return true;
    }

    public /* bridge */ /* synthetic */ Number max(String str) {
        return super.max(str);
    }

    public /* bridge */ /* synthetic */ Date maxDate(String str) {
        return super.maxDate(str);
    }

    public /* bridge */ /* synthetic */ Number min(String str) {
        return super.min(str);
    }

    public /* bridge */ /* synthetic */ Date minDate(String str) {
        return super.minDate(str);
    }

    @Deprecated
    public /* bridge */ /* synthetic */ Object remove(int i) {
        return super.remove(i);
    }

    @Deprecated
    public /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return super.remove(obj);
    }

    @Deprecated
    public /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    @Deprecated
    public /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    @Deprecated
    public /* bridge */ /* synthetic */ Object set(int i, Object obj) {
        return super.set(i, obj);
    }

    public int size() {
        if (this.size == -1) {
            this.size = super.size();
        }
        return this.size;
    }

    public RealmResults<E> sort(String str) {
        throw getUnsupportedException("sort");
    }

    public RealmResults<E> sort(String str, Sort sort) {
        throw getUnsupportedException("sort");
    }

    public RealmResults<E> sort(String str, Sort sort, String str2, Sort sort2) {
        throw getUnsupportedException("sort");
    }

    public RealmResults<E> sort(String[] strArr, Sort[] sortArr) {
        throw getUnsupportedException("sort");
    }

    public /* bridge */ /* synthetic */ Number sum(String str) {
        return super.sum(str);
    }

    @Deprecated
    public RealmQuery<E> where() {
        throw getUnsupportedException("where");
    }
}
