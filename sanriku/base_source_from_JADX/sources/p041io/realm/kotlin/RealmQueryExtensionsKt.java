package p041io.realm.kotlin;

import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p041io.realm.Case;
import p041io.realm.RealmModel;
import p041io.realm.RealmQuery;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000R\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a?\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0010\u0010\u0006\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\b0\u0007¢\u0006\u0002\u0010\t\u001a?\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0010\u0010\u0006\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\n0\u0007¢\u0006\u0002\u0010\u000b\u001a?\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0010\u0010\u0006\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\f0\u0007¢\u0006\u0002\u0010\r\u001a?\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0010\u0010\u0006\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000e0\u0007¢\u0006\u0002\u0010\u000f\u001a?\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0010\u0010\u0006\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00100\u0007¢\u0006\u0002\u0010\u0011\u001a?\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0010\u0010\u0006\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00120\u0007¢\u0006\u0002\u0010\u0013\u001a?\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0010\u0010\u0006\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00140\u0007¢\u0006\u0002\u0010\u0015\u001a?\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0010\u0010\u0006\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00160\u0007¢\u0006\u0002\u0010\u0017\u001aI\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0010\u0010\u0006\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00050\u00072\b\b\u0002\u0010\u0018\u001a\u00020\u0019¢\u0006\u0002\u0010\u001a¨\u0006\u001b"}, mo21739d2 = {"oneOf", "Lio/realm/RealmQuery;", "T", "Lio/realm/RealmModel;", "propertyName", "", "value", "", "Ljava/util/Date;", "(Lio/realm/RealmQuery;Ljava/lang/String;[Ljava/util/Date;)Lio/realm/RealmQuery;", "", "(Lio/realm/RealmQuery;Ljava/lang/String;[Ljava/lang/Boolean;)Lio/realm/RealmQuery;", "", "(Lio/realm/RealmQuery;Ljava/lang/String;[Ljava/lang/Byte;)Lio/realm/RealmQuery;", "", "(Lio/realm/RealmQuery;Ljava/lang/String;[Ljava/lang/Double;)Lio/realm/RealmQuery;", "", "(Lio/realm/RealmQuery;Ljava/lang/String;[Ljava/lang/Float;)Lio/realm/RealmQuery;", "", "(Lio/realm/RealmQuery;Ljava/lang/String;[Ljava/lang/Integer;)Lio/realm/RealmQuery;", "", "(Lio/realm/RealmQuery;Ljava/lang/String;[Ljava/lang/Long;)Lio/realm/RealmQuery;", "", "(Lio/realm/RealmQuery;Ljava/lang/String;[Ljava/lang/Short;)Lio/realm/RealmQuery;", "casing", "Lio/realm/Case;", "(Lio/realm/RealmQuery;Ljava/lang/String;[Ljava/lang/String;Lio/realm/Case;)Lio/realm/RealmQuery;", "realm-kotlin-extensions_baseRelease"}, mo21740k = 2, mo21741mv = {1, 1, 15})
/* renamed from: io.realm.kotlin.RealmQueryExtensionsKt */
public final class RealmQueryExtensionsKt {
    public static final <T extends RealmModel> RealmQuery<T> oneOf(RealmQuery<T> realmQuery, String str, Boolean[] boolArr) {
        Intrinsics.checkParameterIsNotNull(realmQuery, "$this$oneOf");
        Intrinsics.checkParameterIsNotNull(str, "propertyName");
        Intrinsics.checkParameterIsNotNull(boolArr, "value");
        RealmQuery<T> in = realmQuery.mo28438in(str, boolArr);
        Intrinsics.checkExpressionValueIsNotNull(in, "this.`in`(propertyName, value)");
        return in;
    }

    public static final <T extends RealmModel> RealmQuery<T> oneOf(RealmQuery<T> realmQuery, String str, Byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(realmQuery, "$this$oneOf");
        Intrinsics.checkParameterIsNotNull(str, "propertyName");
        Intrinsics.checkParameterIsNotNull(bArr, "value");
        RealmQuery<T> in = realmQuery.mo28439in(str, bArr);
        Intrinsics.checkExpressionValueIsNotNull(in, "this.`in`(propertyName, value)");
        return in;
    }

    public static final <T extends RealmModel> RealmQuery<T> oneOf(RealmQuery<T> realmQuery, String str, Double[] dArr) {
        Intrinsics.checkParameterIsNotNull(realmQuery, "$this$oneOf");
        Intrinsics.checkParameterIsNotNull(str, "propertyName");
        Intrinsics.checkParameterIsNotNull(dArr, "value");
        RealmQuery<T> in = realmQuery.mo28440in(str, dArr);
        Intrinsics.checkExpressionValueIsNotNull(in, "this.`in`(propertyName, value)");
        return in;
    }

    public static final <T extends RealmModel> RealmQuery<T> oneOf(RealmQuery<T> realmQuery, String str, Float[] fArr) {
        Intrinsics.checkParameterIsNotNull(realmQuery, "$this$oneOf");
        Intrinsics.checkParameterIsNotNull(str, "propertyName");
        Intrinsics.checkParameterIsNotNull(fArr, "value");
        RealmQuery<T> in = realmQuery.mo28441in(str, fArr);
        Intrinsics.checkExpressionValueIsNotNull(in, "this.`in`(propertyName, value)");
        return in;
    }

    public static final <T extends RealmModel> RealmQuery<T> oneOf(RealmQuery<T> realmQuery, String str, Integer[] numArr) {
        Intrinsics.checkParameterIsNotNull(realmQuery, "$this$oneOf");
        Intrinsics.checkParameterIsNotNull(str, "propertyName");
        Intrinsics.checkParameterIsNotNull(numArr, "value");
        RealmQuery<T> in = realmQuery.mo28442in(str, numArr);
        Intrinsics.checkExpressionValueIsNotNull(in, "this.`in`(propertyName, value)");
        return in;
    }

    public static final <T extends RealmModel> RealmQuery<T> oneOf(RealmQuery<T> realmQuery, String str, Long[] lArr) {
        Intrinsics.checkParameterIsNotNull(realmQuery, "$this$oneOf");
        Intrinsics.checkParameterIsNotNull(str, "propertyName");
        Intrinsics.checkParameterIsNotNull(lArr, "value");
        RealmQuery<T> in = realmQuery.mo28443in(str, lArr);
        Intrinsics.checkExpressionValueIsNotNull(in, "this.`in`(propertyName, value)");
        return in;
    }

    public static final <T extends RealmModel> RealmQuery<T> oneOf(RealmQuery<T> realmQuery, String str, Short[] shArr) {
        Intrinsics.checkParameterIsNotNull(realmQuery, "$this$oneOf");
        Intrinsics.checkParameterIsNotNull(str, "propertyName");
        Intrinsics.checkParameterIsNotNull(shArr, "value");
        RealmQuery<T> in = realmQuery.mo28444in(str, shArr);
        Intrinsics.checkExpressionValueIsNotNull(in, "this.`in`(propertyName, value)");
        return in;
    }

    public static final <T extends RealmModel> RealmQuery<T> oneOf(RealmQuery<T> realmQuery, String str, String[] strArr, Case caseR) {
        Intrinsics.checkParameterIsNotNull(realmQuery, "$this$oneOf");
        Intrinsics.checkParameterIsNotNull(str, "propertyName");
        Intrinsics.checkParameterIsNotNull(strArr, "value");
        Intrinsics.checkParameterIsNotNull(caseR, "casing");
        RealmQuery<T> in = realmQuery.mo28446in(str, strArr, caseR);
        Intrinsics.checkExpressionValueIsNotNull(in, "this.`in`(propertyName, value, casing)");
        return in;
    }

    public static final <T extends RealmModel> RealmQuery<T> oneOf(RealmQuery<T> realmQuery, String str, Date[] dateArr) {
        Intrinsics.checkParameterIsNotNull(realmQuery, "$this$oneOf");
        Intrinsics.checkParameterIsNotNull(str, "propertyName");
        Intrinsics.checkParameterIsNotNull(dateArr, "value");
        RealmQuery<T> in = realmQuery.mo28447in(str, dateArr);
        Intrinsics.checkExpressionValueIsNotNull(in, "this.`in`(propertyName, value)");
        return in;
    }

    public static /* synthetic */ RealmQuery oneOf$default(RealmQuery realmQuery, String str, String[] strArr, Case caseR, int i, Object obj) {
        if ((i & 4) != 0) {
            caseR = Case.SENSITIVE;
        }
        return oneOf(realmQuery, str, strArr, caseR);
    }
}
