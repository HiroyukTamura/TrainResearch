package p041io.realm;

import java.util.Date;
import java.util.Locale;
import p041io.realm.internal.OsList;

/* renamed from: io.realm.DateListOperator */
final class DateListOperator extends ManagedListOperator<Date> {
    DateListOperator(BaseRealm baseRealm, OsList osList, Class<Date> cls) {
        super(baseRealm, osList, cls);
    }

    public void appendValue(Object obj) {
        this.osList.addDate((Date) obj);
    }

    /* access modifiers changed from: protected */
    public void checkValidValue(Object obj) {
        if (obj != null && !(obj instanceof Date)) {
            throw new IllegalArgumentException(String.format(Locale.ENGLISH, "Unacceptable value type. Acceptable: %1$s, actual: %2$s .", new Object[]{"java.util.Date", obj.getClass().getName()}));
        }
    }

    public boolean forRealmModel() {
        return false;
    }

    public Date get(int i) {
        return (Date) this.osList.getValue((long) i);
    }

    public void insertValue(int i, Object obj) {
        this.osList.insertDate((long) i, (Date) obj);
    }

    /* access modifiers changed from: protected */
    public void setValue(int i, Object obj) {
        this.osList.setDate((long) i, (Date) obj);
    }
}
