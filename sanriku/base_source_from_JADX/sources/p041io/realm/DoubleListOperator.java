package p041io.realm;

import java.util.Locale;
import p041io.realm.internal.OsList;

/* renamed from: io.realm.DoubleListOperator */
final class DoubleListOperator extends ManagedListOperator<Double> {
    DoubleListOperator(BaseRealm baseRealm, OsList osList, Class<Double> cls) {
        super(baseRealm, osList, cls);
    }

    public void appendValue(Object obj) {
        this.osList.addDouble(((Number) obj).doubleValue());
    }

    /* access modifiers changed from: protected */
    public void checkValidValue(Object obj) {
        if (obj != null && !(obj instanceof Number)) {
            throw new IllegalArgumentException(String.format(Locale.ENGLISH, "Unacceptable value type. Acceptable: %1$s, actual: %2$s .", new Object[]{"java.lang.Number", obj.getClass().getName()}));
        }
    }

    public boolean forRealmModel() {
        return false;
    }

    public Double get(int i) {
        return (Double) this.osList.getValue((long) i);
    }

    public void insertValue(int i, Object obj) {
        this.osList.insertDouble((long) i, ((Number) obj).doubleValue());
    }

    /* access modifiers changed from: protected */
    public void setValue(int i, Object obj) {
        this.osList.setDouble((long) i, ((Number) obj).doubleValue());
    }
}
