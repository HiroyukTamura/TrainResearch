package p041io.realm.exceptions;

import p041io.realm.internal.Keep;

@Keep
/* renamed from: io.realm.exceptions.RealmException */
public final class RealmException extends RuntimeException {
    public RealmException(String str) {
        super(str);
    }

    public RealmException(String str, Throwable th) {
        super(str, th);
    }
}
