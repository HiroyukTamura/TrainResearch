package p041io.realm.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Inherited
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
/* renamed from: io.realm.annotations.RealmClass */
public @interface RealmClass {
    RealmNamingPolicy fieldNamingPolicy() default RealmNamingPolicy.NO_POLICY;

    String name() default "";

    String value() default "";
}
