package kotlin.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;

@Target({ElementType.ANNOTATION_TYPE})
@Target(allowedTargets = {AnnotationTarget.ANNOTATION_CLASS})
@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, mo21739d2 = {"Lkotlin/annotation/Repeatable;", "", "kotlin-stdlib"}, mo21740k = 1, mo21741mv = {1, 1, 16})
@Retention(RetentionPolicy.RUNTIME)
public @interface Repeatable {
}
