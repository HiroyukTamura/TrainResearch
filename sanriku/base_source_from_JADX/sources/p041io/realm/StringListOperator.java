package p041io.realm;

import java.util.Locale;
import p041io.realm.internal.OsList;

/* renamed from: io.realm.StringListOperator */
final class StringListOperator extends ManagedListOperator<String> {
    StringListOperator(BaseRealm baseRealm, OsList osList, Class<String> cls) {
        super(baseRealm, osList, cls);
    }

    public void appendValue(Object obj) {
        this.osList.addString((String) obj);
    }

    /* access modifiers changed from: protected */
    public void checkValidValue(Object obj) {
        if (obj != null && !(obj instanceof String)) {
            throw new IllegalArgumentException(String.format(Locale.ENGLISH, "Unacceptable value type. Acceptable: %1$s, actual: %2$s .", new Object[]{"java.lang.String", obj.getClass().getName()}));
        }
    }

    public boolean forRealmModel() {
        return false;
    }

    public String get(int i) {
        return (String) this.osList.getValue((long) i);
    }

    public void insertValue(int i, Object obj) {
        this.osList.insertString((long) i, (String) obj);
    }

    /* access modifiers changed from: protected */
    public void setValue(int i, Object obj) {
        this.osList.setString((long) i, (String) obj);
    }
}
