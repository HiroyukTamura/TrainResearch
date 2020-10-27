package kotlin.jvm.internal;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.SinceKotlin;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.KVariance;
import p009e.p010a.p011a.p012a.C0681a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u001b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u0017\u001a\u00020\u0013H\u0002J\u0013\u0010\u0018\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u0013H\u0016J\f\u0010\u0017\u001a\u00020\u0013*\u00020\u0006H\u0002R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00058VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0011R\u001c\u0010\u0012\u001a\u00020\u0013*\u0006\u0012\u0002\b\u00030\u00148BX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001e"}, mo21739d2 = {"Lkotlin/jvm/internal/TypeReference;", "Lkotlin/reflect/KType;", "classifier", "Lkotlin/reflect/KClassifier;", "arguments", "", "Lkotlin/reflect/KTypeProjection;", "isMarkedNullable", "", "(Lkotlin/reflect/KClassifier;Ljava/util/List;Z)V", "annotations", "", "getAnnotations", "()Ljava/util/List;", "getArguments", "getClassifier", "()Lkotlin/reflect/KClassifier;", "()Z", "arrayClassName", "", "Ljava/lang/Class;", "getArrayClassName", "(Ljava/lang/Class;)Ljava/lang/String;", "asString", "equals", "other", "", "hashCode", "", "toString", "kotlin-stdlib"}, mo21740k = 1, mo21741mv = {1, 1, 16})
@SinceKotlin(version = "1.4")
public final class TypeReference implements KType {
    private final List<KTypeProjection> arguments;
    private final KClassifier classifier;
    private final boolean isMarkedNullable;

    @Metadata(mo21737bv = {1, 0, 3}, mo21740k = 3, mo21741mv = {1, 1, 16})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[KVariance.values().length];
            $EnumSwitchMapping$0 = iArr;
            KVariance kVariance = KVariance.INVARIANT;
            iArr[0] = 1;
            int[] iArr2 = $EnumSwitchMapping$0;
            KVariance kVariance2 = KVariance.IN;
            iArr2[1] = 2;
            int[] iArr3 = $EnumSwitchMapping$0;
            KVariance kVariance3 = KVariance.OUT;
            iArr3[2] = 3;
        }
    }

    public TypeReference(KClassifier kClassifier, List<KTypeProjection> list, boolean z) {
        Intrinsics.checkParameterIsNotNull(kClassifier, "classifier");
        Intrinsics.checkParameterIsNotNull(list, "arguments");
        this.classifier = kClassifier;
        this.arguments = list;
        this.isMarkedNullable = z;
    }

    private final String asString() {
        KClassifier classifier2 = getClassifier();
        Class cls = null;
        if (!(classifier2 instanceof KClass)) {
            classifier2 = null;
        }
        KClass kClass = (KClass) classifier2;
        if (kClass != null) {
            cls = JvmClassMappingKt.getJavaClass(kClass);
        }
        String obj = cls == null ? getClassifier().toString() : cls.isArray() ? getArrayClassName(cls) : cls.getName();
        String str = "";
        String joinToString$default = getArguments().isEmpty() ? str : CollectionsKt___CollectionsKt.joinToString$default(getArguments(), ", ", "<", ">", 0, (CharSequence) null, new TypeReference$asString$args$1(this), 24, (Object) null);
        if (isMarkedNullable()) {
            str = "?";
        }
        return C0681a.m321a(obj, joinToString$default, str);
    }

    /* access modifiers changed from: private */
    public final String asString(KTypeProjection kTypeProjection) {
        String str;
        StringBuilder sb;
        String str2;
        if (kTypeProjection.getVariance() == null) {
            return "*";
        }
        KType type = kTypeProjection.getType();
        if (!(type instanceof TypeReference)) {
            type = null;
        }
        TypeReference typeReference = (TypeReference) type;
        if (typeReference == null || (str = typeReference.asString()) == null) {
            str = String.valueOf(kTypeProjection.getType());
        }
        KVariance variance = kTypeProjection.getVariance();
        if (variance != null) {
            int ordinal = variance.ordinal();
            if (ordinal == 0) {
                return str;
            }
            if (ordinal == 1) {
                sb = new StringBuilder();
                str2 = "in ";
            } else if (ordinal == 2) {
                sb = new StringBuilder();
                str2 = "out ";
            }
            return C0681a.m324a(sb, str2, str);
        }
        throw new NoWhenBranchMatchedException();
    }

    private final String getArrayClassName(Class<?> cls) {
        return Intrinsics.areEqual((Object) cls, (Object) boolean[].class) ? "kotlin.BooleanArray" : Intrinsics.areEqual((Object) cls, (Object) char[].class) ? "kotlin.CharArray" : Intrinsics.areEqual((Object) cls, (Object) byte[].class) ? "kotlin.ByteArray" : Intrinsics.areEqual((Object) cls, (Object) short[].class) ? "kotlin.ShortArray" : Intrinsics.areEqual((Object) cls, (Object) int[].class) ? "kotlin.IntArray" : Intrinsics.areEqual((Object) cls, (Object) float[].class) ? "kotlin.FloatArray" : Intrinsics.areEqual((Object) cls, (Object) long[].class) ? "kotlin.LongArray" : Intrinsics.areEqual((Object) cls, (Object) double[].class) ? "kotlin.DoubleArray" : "kotlin.Array";
    }

    public boolean equals(Object obj) {
        if (obj instanceof TypeReference) {
            TypeReference typeReference = (TypeReference) obj;
            return Intrinsics.areEqual((Object) getClassifier(), (Object) typeReference.getClassifier()) && Intrinsics.areEqual((Object) getArguments(), (Object) typeReference.getArguments()) && isMarkedNullable() == typeReference.isMarkedNullable();
        }
    }

    public List<Annotation> getAnnotations() {
        return CollectionsKt__CollectionsKt.emptyList();
    }

    public List<KTypeProjection> getArguments() {
        return this.arguments;
    }

    public KClassifier getClassifier() {
        return this.classifier;
    }

    public int hashCode() {
        int hashCode = getArguments().hashCode();
        return Boolean.valueOf(isMarkedNullable()).hashCode() + ((hashCode + (getClassifier().hashCode() * 31)) * 31);
    }

    public boolean isMarkedNullable() {
        return this.isMarkedNullable;
    }

    public String toString() {
        return C0681a.m324a(new StringBuilder(), asString(), " (Kotlin reflection is not available)");
    }
}
