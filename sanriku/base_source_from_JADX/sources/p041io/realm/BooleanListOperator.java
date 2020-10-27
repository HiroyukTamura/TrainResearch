package p041io.realm;

import java.util.Locale;
import p041io.realm.internal.OsList;

/* renamed from: io.realm.BooleanListOperator */
final class BooleanListOperator extends ManagedListOperator<Boolean> {
    BooleanListOperator(BaseRealm baseRealm, OsList osList, Class<Boolean> cls) {
        super(baseRealm, osList, cls);
    }

    public void appendValue(Object obj) {
        this.osList.addBoolean(((Boolean) obj).booleanValue());
    }

    /* access modifiers changed from: protected */
    public void checkValidValue(Object obj) {
        if (obj != null && !(obj instanceof Boolean)) {
            throw new IllegalArgumentException(String.format(Locale.ENGLISH, "Unacceptable value type. Acceptable: %1$s, actual: %2$s .", new Object[]{"java.lang.Boolean", obj.getClass().getName()}));
        }
    }

    public boolean forRealmModel() {
        return false;
    }

    public Boolean get(int i) {
        return (Boolean) this.osList.getValue((long) i);
    }

    public void insertValue(int i, Object obj) {
        this.osList.insertBoolean((long) i, ((Boolean) obj).booleanValue());
    }

    /* access modifiers changed from: protected */
    public void setValue(int i, Object obj) {
        this.osList.setBoolean((long) i, ((Boolean) obj).booleanValue());
    }
}
