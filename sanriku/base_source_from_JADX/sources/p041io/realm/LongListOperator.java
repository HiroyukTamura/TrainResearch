package p041io.realm;

import java.util.Locale;
import p009e.p010a.p011a.p012a.C0681a;
import p041io.realm.internal.OsList;

/* renamed from: io.realm.LongListOperator */
final class LongListOperator<T> extends ManagedListOperator<T> {
    LongListOperator(BaseRealm baseRealm, OsList osList, Class<T> cls) {
        super(baseRealm, osList, cls);
    }

    public void appendValue(Object obj) {
        this.osList.addLong(((Number) obj).longValue());
    }

    /* access modifiers changed from: protected */
    public void checkValidValue(Object obj) {
        if (obj != null && !(obj instanceof Number)) {
            throw new IllegalArgumentException(String.format(Locale.ENGLISH, "Unacceptable value type. Acceptable: %1$s, actual: %2$s .", new Object[]{"java.lang.Long, java.lang.Integer, java.lang.Short, java.lang.Byte", obj.getClass().getName()}));
        }
    }

    public boolean forRealmModel() {
        return false;
    }

    public T get(int i) {
        Object obj;
        T t = (Long) this.osList.getValue((long) i);
        if (t == null) {
            return null;
        }
        Class<T> cls = this.clazz;
        if (cls == Long.class) {
            return t;
        }
        if (cls == Integer.class) {
            obj = Integer.valueOf(t.intValue());
        } else if (cls == Short.class) {
            obj = Short.valueOf(t.shortValue());
        } else if (cls == Byte.class) {
            obj = Byte.valueOf(t.byteValue());
        } else {
            StringBuilder a = C0681a.m330a("Unexpected element type: ");
            a.append(this.clazz.getName());
            throw new IllegalStateException(a.toString());
        }
        return cls.cast(obj);
    }

    public void insertValue(int i, Object obj) {
        this.osList.insertLong((long) i, ((Number) obj).longValue());
    }

    /* access modifiers changed from: protected */
    public void setValue(int i, Object obj) {
        this.osList.setLong((long) i, ((Number) obj).longValue());
    }
}
