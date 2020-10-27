package p041io.realm;

import java.util.Locale;
import p041io.realm.internal.OsList;

/* renamed from: io.realm.BinaryListOperator */
final class BinaryListOperator extends ManagedListOperator<byte[]> {
    BinaryListOperator(BaseRealm baseRealm, OsList osList, Class<byte[]> cls) {
        super(baseRealm, osList, cls);
    }

    public void appendValue(Object obj) {
        this.osList.addBinary((byte[]) obj);
    }

    /* access modifiers changed from: protected */
    public void checkValidValue(Object obj) {
        if (obj != null && !(obj instanceof byte[])) {
            throw new IllegalArgumentException(String.format(Locale.ENGLISH, "Unacceptable value type. Acceptable: %1$s, actual: %2$s .", new Object[]{"byte[]", obj.getClass().getName()}));
        }
    }

    public boolean forRealmModel() {
        return false;
    }

    public byte[] get(int i) {
        return (byte[]) this.osList.getValue((long) i);
    }

    public void insertValue(int i, Object obj) {
        this.osList.insertBinary((long) i, (byte[]) obj);
    }

    /* access modifiers changed from: protected */
    public void setValue(int i, Object obj) {
        this.osList.setBinary((long) i, (byte[]) obj);
    }
}
