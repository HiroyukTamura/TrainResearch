/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.f;

import androidx.lifecycle.v;
import androidx.lifecycle.w;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.a.a;
import kotlin.Metadata;
import kotlin.e.b.j;

@Metadata(bv={1, 0, 2}, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B.\b\u0007\u0012%\u0010\u0002\u001a!\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u00050\u0006\u00a2\u0006\u0002\b\u00070\u0003\u00a2\u0006\u0002\u0010\bJ%\u0010\t\u001a\u0002H\n\"\b\b\u0000\u0010\n*\u00020\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\u0004H\u0016\u00a2\u0006\u0002\u0010\fR-\u0010\u0002\u001a!\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u00050\u0006\u00a2\u0006\u0002\b\u00070\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2={"Ljp/co/jreast/jreastapp/commuter/di/ViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "creators", "", "Ljava/lang/Class;", "Landroidx/lifecycle/ViewModel;", "Ljavax/inject/Provider;", "Lkotlin/jvm/JvmSuppressWildcards;", "(Ljava/util/Map;)V", "create", "T", "modelClass", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class t
implements w.b {
    private final Map<Class<? extends v>, a<v>> a;

    public t(Map<Class<? extends v>, a<v>> map) {
        j.b(map, "creators");
        this.a = map;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public <T extends v> T a(Class<T> object) {
        j.b(object, "modelClass");
        a<v> a2 = this.a.get(object);
        Object object2 = a2;
        if (a2 == null) {
            Class class_;
            Iterator<Map.Entry<Class<? extends v>, a<v>>> iterator = this.a.entrySet().iterator();
            do {
                object2 = a2;
                if (!iterator.hasNext()) break;
                object2 = iterator.next();
                class_ = (Class)object2.getKey();
                object2 = (a)object2.getValue();
            } while (!((Class)object).isAssignableFrom(class_));
        }
        if (object2 != null) {
            try {
                object = object2.b();
                if (object == null) throw new kotlin.t("null cannot be cast to non-null type T");
            }
            catch (Exception exception) {
                throw (Throwable)new RuntimeException(exception);
            }
            return (T)((v)object);
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("unknown model class ");
        ((StringBuilder)object2).append(object);
        throw (Throwable)new IllegalArgumentException(((StringBuilder)object2).toString());
    }
}

