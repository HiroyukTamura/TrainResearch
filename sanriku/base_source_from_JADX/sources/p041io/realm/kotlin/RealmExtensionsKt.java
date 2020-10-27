package p041io.realm.kotlin;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p041io.realm.Realm;
import p041io.realm.RealmModel;
import p041io.realm.RealmQuery;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001e\u0010\u0000\u001a\u0002H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u0003H\b¢\u0006\u0002\u0010\u0004\u001a(\u0010\u0000\u001a\u0002H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\b¢\u0006\u0002\u0010\u0007\u001a\u0019\u0010\b\u001a\u00020\t\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u0003H\b\u001a\u001f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00010\u000b\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u0003H\b¨\u0006\f"}, mo21739d2 = {"createObject", "T", "Lio/realm/RealmModel;", "Lio/realm/Realm;", "(Lio/realm/Realm;)Lio/realm/RealmModel;", "primaryKeyValue", "", "(Lio/realm/Realm;Ljava/lang/Object;)Lio/realm/RealmModel;", "delete", "", "where", "Lio/realm/RealmQuery;", "realm-kotlin-extensions_baseRelease"}, mo21740k = 2, mo21741mv = {1, 1, 15})
/* renamed from: io.realm.kotlin.RealmExtensionsKt */
public final class RealmExtensionsKt {
    private static final <T extends RealmModel> T createObject(Realm realm) {
        Intrinsics.reifiedOperationMarker(4, "T");
        T createObject = realm.createObject(RealmModel.class);
        Intrinsics.checkExpressionValueIsNotNull(createObject, "this.createObject(T::class.java)");
        return createObject;
    }

    private static final <T extends RealmModel> T createObject(Realm realm, Object obj) {
        Intrinsics.reifiedOperationMarker(4, "T");
        T createObject = realm.createObject(RealmModel.class, obj);
        Intrinsics.checkExpressionValueIsNotNull(createObject, "this.createObject(T::class.java, primaryKeyValue)");
        return createObject;
    }

    private static final <T extends RealmModel> void delete(Realm realm) {
        Intrinsics.reifiedOperationMarker(4, "T");
        realm.delete(RealmModel.class);
    }

    private static final <T extends RealmModel> RealmQuery<T> where(Realm realm) {
        Intrinsics.reifiedOperationMarker(4, "T");
        RealmQuery<T> where = realm.where(RealmModel.class);
        Intrinsics.checkExpressionValueIsNotNull(where, "this.where(T::class.java)");
        return where;
    }
}
