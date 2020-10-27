package p009e.p069e.p070a.p071a.p072a;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import p078g.p079a.C1696b;
import p078g.p079a.C1701g;
import p078g.p079a.C1704j;
import p078g.p079a.C1706l;
import p078g.p079a.C1711q;
import p078g.p079a.C1714r;
import retrofit2.CallAdapter;
import retrofit2.Response;
import retrofit2.Retrofit;

/* renamed from: e.e.a.a.a.g */
public final class C1578g extends CallAdapter.Factory {

    /* renamed from: a */
    private final C1711q f1849a;

    private C1578g(C1711q qVar) {
        this.f1849a = qVar;
    }

    /* renamed from: a */
    public static C1578g m2208a() {
        return new C1578g((C1711q) null);
    }

    public CallAdapter<?> get(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        boolean z;
        boolean z2;
        Type type2;
        Class<?> rawType = CallAdapter.Factory.getRawType(type);
        if (rawType == C1696b.class) {
            return new C1577f(Void.class, this.f1849a, false, true, false, false, false, true);
        }
        boolean z3 = rawType == C1701g.class;
        boolean z4 = rawType == C1714r.class;
        boolean z5 = rawType == C1704j.class;
        if (rawType != C1706l.class && !z3 && !z4 && !z5) {
            return null;
        }
        if (!(type instanceof ParameterizedType)) {
            String str = !z3 ? z4 ? "Single" : "Observable" : "Flowable";
            throw new IllegalStateException(str + " return type must be parameterized as " + str + "<Foo> or " + str + "<? extends Foo>");
        }
        Type parameterUpperBound = CallAdapter.Factory.getParameterUpperBound(0, (ParameterizedType) type);
        Class<?> rawType2 = CallAdapter.Factory.getRawType(parameterUpperBound);
        if (rawType2 == Response.class) {
            if (parameterUpperBound instanceof ParameterizedType) {
                type2 = CallAdapter.Factory.getParameterUpperBound(0, (ParameterizedType) parameterUpperBound);
                z2 = false;
            } else {
                throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
            }
        } else if (rawType2 != C1574d.class) {
            type2 = parameterUpperBound;
            z2 = false;
            z = true;
            return new C1577f(type2, this.f1849a, z2, z, z3, z4, z5, false);
        } else if (parameterUpperBound instanceof ParameterizedType) {
            type2 = CallAdapter.Factory.getParameterUpperBound(0, (ParameterizedType) parameterUpperBound);
            z2 = true;
        } else {
            throw new IllegalStateException("Result must be parameterized as Result<Foo> or Result<? extends Foo>");
        }
        z = false;
        return new C1577f(type2, this.f1849a, z2, z, z3, z4, z5, false);
    }
}
