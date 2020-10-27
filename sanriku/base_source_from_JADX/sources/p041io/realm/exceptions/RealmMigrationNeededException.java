package p041io.realm.exceptions;

import p041io.realm.internal.Keep;

@Keep
/* renamed from: io.realm.exceptions.RealmMigrationNeededException */
public final class RealmMigrationNeededException extends RuntimeException {
    private final String canonicalRealmPath;

    public RealmMigrationNeededException(String str, String str2) {
        super(str2);
        this.canonicalRealmPath = str;
    }

    public String getPath() {
        return this.canonicalRealmPath;
    }
}
