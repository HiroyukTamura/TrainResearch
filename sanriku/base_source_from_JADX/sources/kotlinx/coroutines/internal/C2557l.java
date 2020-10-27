package kotlinx.coroutines.internal;

import java.util.Iterator;
import java.util.List;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.C2537i0;

/* renamed from: kotlinx.coroutines.internal.l */
public final class C2557l {

    /* renamed from: a */
    private static final boolean f4198a;
    @JvmField

    /* renamed from: b */
    public static final C2537i0 f4199b;

    static {
        C2558m mVar;
        Object obj;
        MainDispatcherFactory mainDispatcherFactory;
        String a = C2565t.m4471a("kotlinx.coroutines.fast.service.loader");
        f4198a = a != null ? Boolean.parseBoolean(a) : true;
        try {
            List list = SequencesKt___SequencesKt.toList(SequencesKt__SequencesKt.asSequence(C0000a.m1b()));
            Iterator it = list.iterator();
            if (!it.hasNext()) {
                obj = null;
            } else {
                obj = it.next();
                if (it.hasNext()) {
                    int b = ((MainDispatcherFactory) obj).mo35533b();
                    do {
                        Object next = it.next();
                        int b2 = ((MainDispatcherFactory) next).mo35533b();
                        if (b < b2) {
                            obj = next;
                            b = b2;
                        }
                    } while (it.hasNext());
                }
            }
            mainDispatcherFactory = (MainDispatcherFactory) obj;
            if (mainDispatcherFactory != null) {
                mVar = mainDispatcherFactory.mo35532a(list);
                if (mVar != null) {
                    f4199b = mVar;
                }
            }
        } catch (Throwable th) {
            mVar = new C2558m(th, (String) null);
        }
        mVar = new C2558m((Throwable) null, (String) null);
        f4199b = mVar;
    }
}
