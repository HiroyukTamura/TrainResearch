package p041io.realm;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import p009e.p010a.p011a.p012a.C0681a;
import p041io.realm.internal.InvalidRow;
import p041io.realm.internal.OsList;
import p041io.realm.internal.OsResults;
import p041io.realm.internal.RealmObjectProxy;
import p041io.realm.p117rx.CollectionChange;
import p078g.p079a.C1701g;
import p078g.p079a.C1706l;

/* renamed from: io.realm.RealmList */
public class RealmList<E> extends AbstractList<E> implements OrderedRealmCollection<E> {
    static final String ALLOWED_ONLY_FOR_REALM_MODEL_ELEMENT_MESSAGE = "This feature is available only when the element type is implementing RealmModel.";
    private static final String ONLY_IN_MANAGED_MODE_MESSAGE = "This method is only available in managed mode.";
    private static final String REMOVE_OUTSIDE_TRANSACTION_ERROR = "Objects can only be removed from inside a write transaction.";
    protected String className;
    protected Class<E> clazz;
    private final ManagedListOperator<E> osListOperator;
    protected final BaseRealm realm;
    private List<E> unmanagedList;

    /* renamed from: io.realm.RealmList$RealmItr */
    private class RealmItr implements Iterator<E> {
        int cursor;
        int expectedModCount;
        int lastRet;

        private RealmItr() {
            this.cursor = 0;
            this.lastRet = -1;
            this.expectedModCount = RealmList.this.modCount;
        }

        /* access modifiers changed from: package-private */
        public final void checkConcurrentModification() {
            if (RealmList.this.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }

        public boolean hasNext() {
            RealmList.this.checkValidRealm();
            checkConcurrentModification();
            return this.cursor != RealmList.this.size();
        }

        public E next() {
            RealmList.this.checkValidRealm();
            checkConcurrentModification();
            int i = this.cursor;
            try {
                E e = RealmList.this.get(i);
                this.lastRet = i;
                this.cursor = i + 1;
                return e;
            } catch (IndexOutOfBoundsException unused) {
                checkConcurrentModification();
                StringBuilder b = C0681a.m338b("Cannot access index ", i, " when size is ");
                b.append(RealmList.this.size());
                b.append(". Remember to check hasNext() before using next().");
                throw new NoSuchElementException(b.toString());
            }
        }

        public void remove() {
            RealmList.this.checkValidRealm();
            if (this.lastRet >= 0) {
                checkConcurrentModification();
                try {
                    RealmList.this.remove(this.lastRet);
                    if (this.lastRet < this.cursor) {
                        this.cursor--;
                    }
                    this.lastRet = -1;
                    this.expectedModCount = RealmList.this.modCount;
                } catch (IndexOutOfBoundsException unused) {
                    throw new ConcurrentModificationException();
                }
            } else {
                throw new IllegalStateException("Cannot call remove() twice. Must call next() in between.");
            }
        }
    }

    /* renamed from: io.realm.RealmList$RealmListItr */
    private class RealmListItr extends RealmList<E>.RealmItr implements ListIterator<E> {
        RealmListItr(int i) {
            super();
            if (i < 0 || i > RealmList.this.size()) {
                StringBuilder a = C0681a.m330a("Starting location must be a valid index: [0, ");
                a.append(RealmList.this.size() - 1);
                a.append("]. Index was ");
                a.append(i);
                throw new IndexOutOfBoundsException(a.toString());
            }
            this.cursor = i;
        }

        public void add(E e) {
            RealmList.this.realm.checkIfValid();
            checkConcurrentModification();
            try {
                int i = this.cursor;
                RealmList.this.add(i, e);
                this.lastRet = -1;
                this.cursor = i + 1;
                this.expectedModCount = RealmList.this.modCount;
            } catch (IndexOutOfBoundsException unused) {
                throw new ConcurrentModificationException();
            }
        }

        public boolean hasPrevious() {
            return this.cursor != 0;
        }

        public int nextIndex() {
            return this.cursor;
        }

        public E previous() {
            checkConcurrentModification();
            int i = this.cursor - 1;
            try {
                E e = RealmList.this.get(i);
                this.cursor = i;
                this.lastRet = i;
                return e;
            } catch (IndexOutOfBoundsException unused) {
                checkConcurrentModification();
                throw new NoSuchElementException(C0681a.m317a("Cannot access index less than zero. This was ", i, ". Remember to check hasPrevious() before using previous()."));
            }
        }

        public int previousIndex() {
            return this.cursor - 1;
        }

        public void set(E e) {
            RealmList.this.realm.checkIfValid();
            if (this.lastRet >= 0) {
                checkConcurrentModification();
                try {
                    RealmList.this.set(this.lastRet, e);
                    this.expectedModCount = RealmList.this.modCount;
                } catch (IndexOutOfBoundsException unused) {
                    throw new ConcurrentModificationException();
                }
            } else {
                throw new IllegalStateException();
            }
        }
    }

    public RealmList() {
        this.realm = null;
        this.osListOperator = null;
        this.unmanagedList = new ArrayList();
    }

    RealmList(Class<E> cls, OsList osList, BaseRealm baseRealm) {
        this.clazz = cls;
        this.osListOperator = getOperator(baseRealm, osList, cls, (String) null);
        this.realm = baseRealm;
    }

    RealmList(String str, OsList osList, BaseRealm baseRealm) {
        this.realm = baseRealm;
        this.className = str;
        this.osListOperator = getOperator(baseRealm, osList, (Class) null, str);
    }

    public RealmList(E... eArr) {
        if (eArr != null) {
            this.realm = null;
            this.osListOperator = null;
            ArrayList arrayList = new ArrayList(eArr.length);
            this.unmanagedList = arrayList;
            Collections.addAll(arrayList, eArr);
            return;
        }
        throw new IllegalArgumentException("The objects argument cannot be null");
    }

    private void checkForAddRemoveListener(Object obj, boolean z) {
        if (!z || obj != null) {
            this.realm.checkIfValid();
            this.realm.sharedRealm.capabilities.checkCanDeliverNotification("Listeners cannot be used on current thread.");
            return;
        }
        throw new IllegalArgumentException("Listener should not be null");
    }

    /* access modifiers changed from: private */
    public void checkValidRealm() {
        this.realm.checkIfValid();
    }

    private E firstImpl(boolean z, E e) {
        if (isManaged()) {
            checkValidRealm();
            if (!this.osListOperator.isEmpty()) {
                return get(0);
            }
        } else {
            List<E> list = this.unmanagedList;
            if (list != null && !list.isEmpty()) {
                return this.unmanagedList.get(0);
            }
        }
        if (!z) {
            return e;
        }
        throw new IndexOutOfBoundsException("The list is empty.");
    }

    private ManagedListOperator<E> getOperator(BaseRealm baseRealm, OsList osList, Class<E> cls, String str) {
        if (cls == null || isClassForRealmModel(cls)) {
            return new RealmModelListOperator(baseRealm, osList, cls, str);
        }
        if (cls == String.class) {
            return new StringListOperator(baseRealm, osList, cls);
        }
        if (cls == Long.class || cls == Integer.class || cls == Short.class || cls == Byte.class) {
            return new LongListOperator(baseRealm, osList, cls);
        }
        if (cls == Boolean.class) {
            return new BooleanListOperator(baseRealm, osList, cls);
        }
        if (cls == byte[].class) {
            return new BinaryListOperator(baseRealm, osList, cls);
        }
        if (cls == Double.class) {
            return new DoubleListOperator(baseRealm, osList, cls);
        }
        if (cls == Float.class) {
            return new FloatListOperator(baseRealm, osList, cls);
        }
        if (cls == Date.class) {
            return new DateListOperator(baseRealm, osList, cls);
        }
        StringBuilder a = C0681a.m330a("Unexpected value class: ");
        a.append(cls.getName());
        throw new IllegalArgumentException(a.toString());
    }

    private boolean isAttached() {
        ManagedListOperator<E> managedListOperator = this.osListOperator;
        return managedListOperator != null && managedListOperator.isValid();
    }

    private static boolean isClassForRealmModel(Class<?> cls) {
        return RealmModel.class.isAssignableFrom(cls);
    }

    private E lastImpl(boolean z, E e) {
        if (isManaged()) {
            checkValidRealm();
            if (!this.osListOperator.isEmpty()) {
                return get(this.osListOperator.size() - 1);
            }
        } else {
            List<E> list = this.unmanagedList;
            if (list != null && !list.isEmpty()) {
                List<E> list2 = this.unmanagedList;
                return list2.get(list2.size() - 1);
            }
        }
        if (!z) {
            return e;
        }
        throw new IndexOutOfBoundsException("The list is empty.");
    }

    public void add(int i, E e) {
        if (isManaged()) {
            checkValidRealm();
            this.osListOperator.insert(i, e);
        } else {
            this.unmanagedList.add(i, e);
        }
        this.modCount++;
    }

    public boolean add(E e) {
        if (isManaged()) {
            checkValidRealm();
            this.osListOperator.append(e);
        } else {
            this.unmanagedList.add(e);
        }
        this.modCount++;
        return true;
    }

    public void addChangeListener(OrderedRealmCollectionChangeListener<RealmList<E>> orderedRealmCollectionChangeListener) {
        checkForAddRemoveListener(orderedRealmCollectionChangeListener, true);
        this.osListOperator.getOsList().addListener(this, orderedRealmCollectionChangeListener);
    }

    public void addChangeListener(RealmChangeListener<RealmList<E>> realmChangeListener) {
        checkForAddRemoveListener(realmChangeListener, true);
        this.osListOperator.getOsList().addListener(this, realmChangeListener);
    }

    public C1706l<CollectionChange<RealmList<E>>> asChangesetObservable() {
        BaseRealm baseRealm = this.realm;
        if (baseRealm instanceof Realm) {
            return baseRealm.configuration.getRxFactory().changesetsFrom((Realm) this.realm, this);
        }
        if (baseRealm instanceof DynamicRealm) {
            return baseRealm.configuration.getRxFactory().changesetsFrom((DynamicRealm) baseRealm, this);
        }
        throw new UnsupportedOperationException(this.realm.getClass() + " does not support RxJava2.");
    }

    public C1701g<RealmList<E>> asFlowable() {
        BaseRealm baseRealm = this.realm;
        if (baseRealm instanceof Realm) {
            return baseRealm.configuration.getRxFactory().from((Realm) this.realm, this);
        }
        if (baseRealm instanceof DynamicRealm) {
            return baseRealm.configuration.getRxFactory().from((DynamicRealm) this.realm, this);
        }
        throw new UnsupportedOperationException(this.realm.getClass() + " does not support RxJava2.");
    }

    public double average(String str) {
        return where().average(str);
    }

    public void clear() {
        if (isManaged()) {
            checkValidRealm();
            this.osListOperator.removeAll();
        } else {
            this.unmanagedList.clear();
        }
        this.modCount++;
    }

    public boolean contains(Object obj) {
        if (!isManaged()) {
            return this.unmanagedList.contains(obj);
        }
        this.realm.checkIfValid();
        if (!(obj instanceof RealmObjectProxy) || ((RealmObjectProxy) obj).realmGet$proxyState().getRow$realm() != InvalidRow.INSTANCE) {
            return super.contains(obj);
        }
        return false;
    }

    public OrderedRealmCollectionSnapshot<E> createSnapshot() {
        if (isManaged()) {
            checkValidRealm();
            if (!this.osListOperator.forRealmModel()) {
                throw new UnsupportedOperationException(ALLOWED_ONLY_FOR_REALM_MODEL_ELEMENT_MESSAGE);
            } else if (this.className != null) {
                BaseRealm baseRealm = this.realm;
                return new OrderedRealmCollectionSnapshot<>(baseRealm, OsResults.createFromQuery(baseRealm.sharedRealm, this.osListOperator.getOsList().getQuery()), this.className);
            } else {
                BaseRealm baseRealm2 = this.realm;
                return new OrderedRealmCollectionSnapshot<>(baseRealm2, OsResults.createFromQuery(baseRealm2.sharedRealm, this.osListOperator.getOsList().getQuery()), this.clazz);
            }
        } else {
            throw new UnsupportedOperationException(ONLY_IN_MANAGED_MODE_MESSAGE);
        }
    }

    public boolean deleteAllFromRealm() {
        if (isManaged()) {
            checkValidRealm();
            if (this.osListOperator.isEmpty()) {
                return false;
            }
            this.osListOperator.deleteAll();
            this.modCount++;
            return true;
        }
        throw new UnsupportedOperationException(ONLY_IN_MANAGED_MODE_MESSAGE);
    }

    public boolean deleteFirstFromRealm() {
        if (!isManaged()) {
            throw new UnsupportedOperationException(ONLY_IN_MANAGED_MODE_MESSAGE);
        } else if (this.osListOperator.isEmpty()) {
            return false;
        } else {
            deleteFromRealm(0);
            this.modCount++;
            return true;
        }
    }

    public void deleteFromRealm(int i) {
        if (isManaged()) {
            checkValidRealm();
            this.osListOperator.delete(i);
            this.modCount++;
            return;
        }
        throw new UnsupportedOperationException(ONLY_IN_MANAGED_MODE_MESSAGE);
    }

    public boolean deleteLastFromRealm() {
        if (!isManaged()) {
            throw new UnsupportedOperationException(ONLY_IN_MANAGED_MODE_MESSAGE);
        } else if (this.osListOperator.isEmpty()) {
            return false;
        } else {
            this.osListOperator.deleteLast();
            this.modCount++;
            return true;
        }
    }

    public E first() {
        return firstImpl(true, (Object) null);
    }

    public E first(E e) {
        return firstImpl(false, e);
    }

    public E get(int i) {
        if (!isManaged()) {
            return this.unmanagedList.get(i);
        }
        checkValidRealm();
        return this.osListOperator.get(i);
    }

    /* access modifiers changed from: package-private */
    public OsList getOsList() {
        return this.osListOperator.getOsList();
    }

    public Realm getRealm() {
        BaseRealm baseRealm = this.realm;
        if (baseRealm == null) {
            return null;
        }
        baseRealm.checkIfValid();
        BaseRealm baseRealm2 = this.realm;
        if (baseRealm2 instanceof Realm) {
            return (Realm) baseRealm2;
        }
        throw new IllegalStateException("This method is only available for typed Realms");
    }

    public boolean isLoaded() {
        return true;
    }

    public boolean isManaged() {
        return this.realm != null;
    }

    public boolean isValid() {
        BaseRealm baseRealm = this.realm;
        if (baseRealm == null) {
            return true;
        }
        if (baseRealm.isClosed()) {
            return false;
        }
        return isAttached();
    }

    public Iterator<E> iterator() {
        return isManaged() ? new RealmItr() : super.iterator();
    }

    public E last() {
        return lastImpl(true, (Object) null);
    }

    public E last(E e) {
        return lastImpl(false, e);
    }

    public ListIterator<E> listIterator() {
        return listIterator(0);
    }

    public ListIterator<E> listIterator(int i) {
        return isManaged() ? new RealmListItr(i) : super.listIterator(i);
    }

    public boolean load() {
        return true;
    }

    public Number max(String str) {
        return where().max(str);
    }

    public Date maxDate(String str) {
        return where().maximumDate(str);
    }

    public Number min(String str) {
        return where().min(str);
    }

    public Date minDate(String str) {
        return where().minimumDate(str);
    }

    public void move(int i, int i2) {
        if (isManaged()) {
            checkValidRealm();
            this.osListOperator.move(i, i2);
            return;
        }
        int size = this.unmanagedList.size();
        if (i < 0 || size <= i) {
            throw new IndexOutOfBoundsException("Invalid index " + i + ", size is " + size);
        } else if (i2 < 0 || size <= i2) {
            throw new IndexOutOfBoundsException("Invalid index " + i2 + ", size is " + size);
        } else {
            this.unmanagedList.add(i2, this.unmanagedList.remove(i));
        }
    }

    public E remove(int i) {
        E e;
        if (isManaged()) {
            checkValidRealm();
            e = get(i);
            this.osListOperator.remove(i);
        } else {
            e = this.unmanagedList.remove(i);
        }
        this.modCount++;
        return e;
    }

    public boolean remove(Object obj) {
        if (!isManaged() || this.realm.isInTransaction()) {
            return super.remove(obj);
        }
        throw new IllegalStateException(REMOVE_OUTSIDE_TRANSACTION_ERROR);
    }

    public boolean removeAll(Collection<?> collection) {
        if (!isManaged() || this.realm.isInTransaction()) {
            return super.removeAll(collection);
        }
        throw new IllegalStateException(REMOVE_OUTSIDE_TRANSACTION_ERROR);
    }

    public void removeAllChangeListeners() {
        checkForAddRemoveListener((Object) null, false);
        this.osListOperator.getOsList().removeAllListeners();
    }

    public void removeChangeListener(OrderedRealmCollectionChangeListener<RealmList<E>> orderedRealmCollectionChangeListener) {
        checkForAddRemoveListener(orderedRealmCollectionChangeListener, true);
        this.osListOperator.getOsList().removeListener(this, orderedRealmCollectionChangeListener);
    }

    public void removeChangeListener(RealmChangeListener<RealmList<E>> realmChangeListener) {
        checkForAddRemoveListener(realmChangeListener, true);
        this.osListOperator.getOsList().removeListener(this, realmChangeListener);
    }

    public E set(int i, E e) {
        if (!isManaged()) {
            return this.unmanagedList.set(i, e);
        }
        checkValidRealm();
        return this.osListOperator.set(i, e);
    }

    public int size() {
        if (!isManaged()) {
            return this.unmanagedList.size();
        }
        checkValidRealm();
        return this.osListOperator.size();
    }

    public RealmResults<E> sort(String str) {
        return sort(str, Sort.ASCENDING);
    }

    public RealmResults<E> sort(String str, Sort sort) {
        if (isManaged()) {
            return where().sort(str, sort).findAll();
        }
        throw new UnsupportedOperationException(ONLY_IN_MANAGED_MODE_MESSAGE);
    }

    public RealmResults<E> sort(String str, Sort sort, String str2, Sort sort2) {
        return sort(new String[]{str, str2}, new Sort[]{sort, sort2});
    }

    public RealmResults<E> sort(String[] strArr, Sort[] sortArr) {
        if (isManaged()) {
            return where().sort(strArr, sortArr).findAll();
        }
        throw new UnsupportedOperationException(ONLY_IN_MANAGED_MODE_MESSAGE);
    }

    public Number sum(String str) {
        return where().sum(str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x004b, code lost:
        if (size() > 0) goto L_0x004d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00cf, code lost:
        if (size() > 0) goto L_0x004d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00fa, code lost:
        if (size() > 0) goto L_0x004d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String toString() {
        /*
            r8 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            boolean r1 = r8.isManaged()
            java.lang.String r2 = "byte["
            java.lang.String r3 = ","
            r4 = 0
            java.lang.String r5 = "]"
            if (r1 != 0) goto L_0x005b
            java.lang.String r1 = "RealmList<?>@["
            r0.append(r1)
            int r1 = r8.size()
        L_0x001b:
            if (r4 >= r1) goto L_0x0047
            java.lang.Object r6 = r8.get(r4)
            boolean r7 = r6 instanceof p041io.realm.RealmModel
            if (r7 == 0) goto L_0x002d
            int r6 = java.lang.System.identityHashCode(r6)
            r0.append(r6)
            goto L_0x0041
        L_0x002d:
            boolean r7 = r6 instanceof byte[]
            if (r7 == 0) goto L_0x003e
            r0.append(r2)
            byte[] r6 = (byte[]) r6
            int r6 = r6.length
            r0.append(r6)
            r0.append(r5)
            goto L_0x0041
        L_0x003e:
            r0.append(r6)
        L_0x0041:
            r0.append(r3)
            int r4 = r4 + 1
            goto L_0x001b
        L_0x0047:
            int r1 = r8.size()
            if (r1 <= 0) goto L_0x0056
        L_0x004d:
            int r1 = r0.length()
            int r1 = r1 + -1
            r0.setLength(r1)
        L_0x0056:
            r0.append(r5)
            goto L_0x00fe
        L_0x005b:
            java.lang.String r1 = "RealmList<"
            r0.append(r1)
            java.lang.String r1 = r8.className
            if (r1 == 0) goto L_0x0068
        L_0x0064:
            r0.append(r1)
            goto L_0x0091
        L_0x0068:
            java.lang.Class<E> r1 = r8.clazz
            boolean r1 = isClassForRealmModel(r1)
            if (r1 == 0) goto L_0x0081
            io.realm.BaseRealm r1 = r8.realm
            io.realm.RealmSchema r1 = r1.getSchema()
            java.lang.Class<E> r6 = r8.clazz
            io.realm.RealmObjectSchema r1 = r1.getSchemaForClass((java.lang.Class<? extends p041io.realm.RealmModel>) r6)
            java.lang.String r1 = r1.getClassName()
            goto L_0x0064
        L_0x0081:
            java.lang.Class<E> r1 = r8.clazz
            java.lang.Class<byte[]> r6 = byte[].class
            if (r1 != r6) goto L_0x008c
            java.lang.String r1 = r1.getSimpleName()
            goto L_0x0064
        L_0x008c:
            java.lang.String r1 = r1.getName()
            goto L_0x0064
        L_0x0091:
            java.lang.String r1 = ">@["
            r0.append(r1)
            boolean r1 = r8.isAttached()
            if (r1 != 0) goto L_0x00a2
            java.lang.String r1 = "invalid"
            r0.append(r1)
            goto L_0x0056
        L_0x00a2:
            java.lang.Class<E> r1 = r8.clazz
            boolean r1 = isClassForRealmModel(r1)
            if (r1 == 0) goto L_0x00d2
        L_0x00aa:
            int r1 = r8.size()
            if (r4 >= r1) goto L_0x00cb
            java.lang.Object r1 = r8.get(r4)
            io.realm.internal.RealmObjectProxy r1 = (p041io.realm.internal.RealmObjectProxy) r1
            io.realm.ProxyState r1 = r1.realmGet$proxyState()
            io.realm.internal.Row r1 = r1.getRow$realm()
            long r1 = r1.getIndex()
            r0.append(r1)
            r0.append(r3)
            int r4 = r4 + 1
            goto L_0x00aa
        L_0x00cb:
            int r1 = r8.size()
            if (r1 <= 0) goto L_0x0056
            goto L_0x00fc
        L_0x00d2:
            int r1 = r8.size()
            if (r4 >= r1) goto L_0x00f6
            java.lang.Object r1 = r8.get(r4)
            boolean r6 = r1 instanceof byte[]
            if (r6 == 0) goto L_0x00ed
            r0.append(r2)
            byte[] r1 = (byte[]) r1
            int r1 = r1.length
            r0.append(r1)
            r0.append(r5)
            goto L_0x00f0
        L_0x00ed:
            r0.append(r1)
        L_0x00f0:
            r0.append(r3)
            int r4 = r4 + 1
            goto L_0x00d2
        L_0x00f6:
            int r1 = r8.size()
            if (r1 <= 0) goto L_0x0056
        L_0x00fc:
            goto L_0x004d
        L_0x00fe:
            java.lang.String r0 = r0.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p041io.realm.RealmList.toString():java.lang.String");
    }

    public RealmQuery<E> where() {
        if (isManaged()) {
            checkValidRealm();
            if (this.osListOperator.forRealmModel()) {
                return RealmQuery.createQueryFromList(this);
            }
            throw new UnsupportedOperationException(ALLOWED_ONLY_FOR_REALM_MODEL_ELEMENT_MESSAGE);
        }
        throw new UnsupportedOperationException(ONLY_IN_MANAGED_MODE_MESSAGE);
    }
}
