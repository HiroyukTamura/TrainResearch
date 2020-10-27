package p041io.realm;

import p041io.realm.internal.ManagableObject;
import p041io.realm.internal.Row;
import p041io.realm.internal.Table;

/* renamed from: io.realm.MutableRealmInteger */
public abstract class MutableRealmInteger implements Comparable<MutableRealmInteger>, ManagableObject {

    /* renamed from: io.realm.MutableRealmInteger$Managed */
    static abstract class Managed<T extends RealmModel> extends MutableRealmInteger {
        Managed() {
        }

        private BaseRealm getRealm() {
            return getProxyState().getRealm$realm();
        }

        private Row getRow() {
            return getProxyState().getRow$realm();
        }

        private void setValue(Long l, boolean z) {
            Row row = getRow();
            Table table = row.getTable();
            long index = row.getIndex();
            long columnIndex = getColumnIndex();
            if (l == null) {
                table.setNull(columnIndex, index, z);
            } else {
                table.setLong(columnIndex, index, l.longValue(), z);
            }
        }

        public /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return MutableRealmInteger.super.compareTo((MutableRealmInteger) obj);
        }

        public final void decrement(long j) {
            increment(-j);
        }

        public final Long get() {
            Row row = getRow();
            row.checkIfAttached();
            long columnIndex = getColumnIndex();
            if (row.isNull(columnIndex)) {
                return null;
            }
            return Long.valueOf(row.getLong(columnIndex));
        }

        /* access modifiers changed from: protected */
        public abstract long getColumnIndex();

        /* access modifiers changed from: protected */
        public abstract ProxyState<T> getProxyState();

        public final void increment(long j) {
            getRealm().checkIfValidAndInTransaction();
            Row row = getRow();
            row.getTable().incrementLong(getColumnIndex(), row.getIndex(), j);
        }

        public final boolean isManaged() {
            return true;
        }

        public final boolean isValid() {
            return !getRealm().isClosed() && getRow().isAttached();
        }

        public final void set(Long l) {
            boolean z;
            ProxyState proxyState = getProxyState();
            proxyState.getRealm$realm().checkIfValidAndInTransaction();
            if (!proxyState.isUnderConstruction()) {
                z = false;
            } else if (proxyState.getAcceptDefaultValue$realm()) {
                z = true;
            } else {
                return;
            }
            setValue(l, z);
        }
    }

    /* renamed from: io.realm.MutableRealmInteger$Unmanaged */
    private static final class Unmanaged extends MutableRealmInteger {
        private Long value;

        Unmanaged(Long l) {
            this.value = l;
        }

        public /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return MutableRealmInteger.super.compareTo((MutableRealmInteger) obj);
        }

        public void decrement(long j) {
            increment(-j);
        }

        public Long get() {
            return this.value;
        }

        public void increment(long j) {
            Long l = this.value;
            if (l != null) {
                this.value = Long.valueOf(l.longValue() + j);
                return;
            }
            throw new IllegalStateException("Cannot increment a MutableRealmInteger whose value is null. Set its value first.");
        }

        public boolean isManaged() {
            return false;
        }

        public boolean isValid() {
            return true;
        }

        public void set(Long l) {
            this.value = l;
        }
    }

    MutableRealmInteger() {
    }

    public static MutableRealmInteger ofNull() {
        return new Unmanaged((Long) null);
    }

    public static MutableRealmInteger valueOf(long j) {
        return valueOf(Long.valueOf(j));
    }

    public static MutableRealmInteger valueOf(Long l) {
        return new Unmanaged(l);
    }

    public static MutableRealmInteger valueOf(String str) {
        return valueOf(Long.parseLong(str));
    }

    public final int compareTo(MutableRealmInteger mutableRealmInteger) {
        Long l = get();
        Long l2 = mutableRealmInteger.get();
        if (l == null) {
            return l2 == null ? 0 : -1;
        }
        if (l2 == null) {
            return 1;
        }
        return l.compareTo(l2);
    }

    public abstract void decrement(long j);

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MutableRealmInteger)) {
            return false;
        }
        Long l = get();
        Long l2 = ((MutableRealmInteger) obj).get();
        return l == null ? l2 == null : l.equals(l2);
    }

    public abstract Long get();

    public final int hashCode() {
        Long l = get();
        if (l == null) {
            return 0;
        }
        return l.hashCode();
    }

    public abstract void increment(long j);

    public final boolean isNull() {
        return get() == null;
    }

    public final void set(long j) {
        set(Long.valueOf(j));
    }

    public abstract void set(Long l);
}
