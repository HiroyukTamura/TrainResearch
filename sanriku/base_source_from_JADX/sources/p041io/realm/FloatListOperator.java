package p041io.realm;

import java.util.Locale;
import p041io.realm.internal.OsList;

/* renamed from: io.realm.FloatListOperator */
final class FloatListOperator extends ManagedListOperator<Float> {
    FloatListOperator(BaseRealm baseRealm, OsList osList, Class<Float> cls) {
        super(baseRealm, osList, cls);
    }

    public void appendValue(Object obj) {
        this.osList.addFloat(((Number) obj).floatValue());
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

    public Float get(int i) {
        return (Float) this.osList.getValue((long) i);
    }

    public void insertValue(int i, Object obj) {
        this.osList.insertFloat((long) i, ((Number) obj).floatValue());
    }

    /* access modifiers changed from: protected */
    public void setValue(int i, Object obj) {
        this.osList.setFloat((long) i, ((Number) obj).floatValue());
    }
}
