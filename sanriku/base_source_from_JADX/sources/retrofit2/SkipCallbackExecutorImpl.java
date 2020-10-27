package retrofit2;

import java.lang.annotation.Annotation;
import p009e.p010a.p011a.p012a.C0681a;

final class SkipCallbackExecutorImpl implements SkipCallbackExecutor {
    private static final SkipCallbackExecutor INSTANCE = new SkipCallbackExecutorImpl();

    SkipCallbackExecutorImpl() {
    }

    static Annotation[] ensurePresent(Annotation[] annotationArr) {
        if (Utils.isAnnotationPresent(annotationArr, SkipCallbackExecutor.class)) {
            return annotationArr;
        }
        Annotation[] annotationArr2 = new Annotation[(annotationArr.length + 1)];
        annotationArr2[0] = INSTANCE;
        System.arraycopy(annotationArr, 0, annotationArr2, 1, annotationArr.length);
        return annotationArr2;
    }

    public Class<? extends Annotation> annotationType() {
        return SkipCallbackExecutor.class;
    }

    public boolean equals(Object obj) {
        return obj instanceof SkipCallbackExecutor;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("@");
        a.append(SkipCallbackExecutor.class.getName());
        a.append("()");
        return a.toString();
    }
}
