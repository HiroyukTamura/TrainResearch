package p041io.realm;

import java.util.Collection;
import java.util.Date;
import p041io.realm.internal.ManagableObject;

/* renamed from: io.realm.RealmCollection */
public interface RealmCollection<E> extends Collection<E>, ManagableObject {
    double average(String str);

    boolean contains(Object obj);

    boolean deleteAllFromRealm();

    boolean isLoaded();

    boolean isManaged();

    boolean isValid();

    boolean load();

    Number max(String str);

    Date maxDate(String str);

    Number min(String str);

    Date minDate(String str);

    Number sum(String str);

    RealmQuery<E> where();
}
