package p041io.realm.kotlin;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p041io.realm.RealmChangeListener;
import p041io.realm.RealmModel;
import p041io.realm.RealmObject;
import p041io.realm.RealmObjectChangeListener;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\u001a'\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u0002H\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005¢\u0006\u0002\u0010\u0006\u001a'\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u0002H\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007¢\u0006\u0002\u0010\b\u001a\n\u0010\t\u001a\u00020\u0001*\u00020\u0003\u001a\n\u0010\n\u001a\u00020\u000b*\u00020\u0003\u001a\n\u0010\f\u001a\u00020\u000b*\u00020\u0003\u001a\n\u0010\r\u001a\u00020\u000b*\u00020\u0003\u001a\n\u0010\u000e\u001a\u00020\u000b*\u00020\u0003\u001a\n\u0010\u000f\u001a\u00020\u0001*\u00020\u0003\u001a'\u0010\u0010\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u0002H\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005¢\u0006\u0002\u0010\u0006\u001a'\u0010\u0010\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u0002H\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007¢\u0006\u0002\u0010\b¨\u0006\u0011"}, mo21739d2 = {"addChangeListener", "", "E", "Lio/realm/RealmModel;", "listener", "Lio/realm/RealmChangeListener;", "(Lio/realm/RealmModel;Lio/realm/RealmChangeListener;)V", "Lio/realm/RealmObjectChangeListener;", "(Lio/realm/RealmModel;Lio/realm/RealmObjectChangeListener;)V", "deleteFromRealm", "isLoaded", "", "isManaged", "isValid", "load", "removeAllChangeListeners", "removeChangeListener", "realm-kotlin-extensions_baseRelease"}, mo21740k = 2, mo21741mv = {1, 1, 15})
/* renamed from: io.realm.kotlin.RealmModelExtensionsKt */
public final class RealmModelExtensionsKt {
    public static final <E extends RealmModel> void addChangeListener(E e, RealmChangeListener<E> realmChangeListener) {
        Intrinsics.checkParameterIsNotNull(e, "$this$addChangeListener");
        Intrinsics.checkParameterIsNotNull(realmChangeListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        RealmObject.addChangeListener(e, realmChangeListener);
    }

    public static final <E extends RealmModel> void addChangeListener(E e, RealmObjectChangeListener<E> realmObjectChangeListener) {
        Intrinsics.checkParameterIsNotNull(e, "$this$addChangeListener");
        Intrinsics.checkParameterIsNotNull(realmObjectChangeListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        RealmObject.addChangeListener(e, realmObjectChangeListener);
    }

    public static final void deleteFromRealm(RealmModel realmModel) {
        Intrinsics.checkParameterIsNotNull(realmModel, "$this$deleteFromRealm");
        RealmObject.deleteFromRealm(realmModel);
    }

    public static final boolean isLoaded(RealmModel realmModel) {
        Intrinsics.checkParameterIsNotNull(realmModel, "$this$isLoaded");
        return RealmObject.isLoaded(realmModel);
    }

    public static final boolean isManaged(RealmModel realmModel) {
        Intrinsics.checkParameterIsNotNull(realmModel, "$this$isManaged");
        return RealmObject.isManaged(realmModel);
    }

    public static final boolean isValid(RealmModel realmModel) {
        Intrinsics.checkParameterIsNotNull(realmModel, "$this$isValid");
        return RealmObject.isValid(realmModel);
    }

    public static final boolean load(RealmModel realmModel) {
        Intrinsics.checkParameterIsNotNull(realmModel, "$this$load");
        return RealmObject.load(realmModel);
    }

    public static final void removeAllChangeListeners(RealmModel realmModel) {
        Intrinsics.checkParameterIsNotNull(realmModel, "$this$removeAllChangeListeners");
        RealmObject.removeAllChangeListeners(realmModel);
    }

    public static final <E extends RealmModel> void removeChangeListener(E e, RealmChangeListener<E> realmChangeListener) {
        Intrinsics.checkParameterIsNotNull(e, "$this$removeChangeListener");
        Intrinsics.checkParameterIsNotNull(realmChangeListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        RealmObject.removeChangeListener(e, realmChangeListener);
    }

    public static final <E extends RealmModel> void removeChangeListener(E e, RealmObjectChangeListener<E> realmObjectChangeListener) {
        Intrinsics.checkParameterIsNotNull(e, "$this$removeChangeListener");
        Intrinsics.checkParameterIsNotNull(realmObjectChangeListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        RealmObject.removeChangeListener(e, (RealmObjectChangeListener) realmObjectChangeListener);
    }
}
