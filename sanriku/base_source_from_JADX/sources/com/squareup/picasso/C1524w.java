package com.squareup.picasso;

import com.squareup.picasso.C1474G;
import com.squareup.picasso.C1513u;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.squareup.picasso.w */
class C1524w extends ThreadPoolExecutor {

    /* renamed from: com.squareup.picasso.w$a */
    private static final class C1525a extends FutureTask<C1481c> implements Comparable<C1525a> {

        /* renamed from: a */
        private final C1481c f1712a;

        C1525a(C1481c cVar) {
            super(cVar, (Object) null);
            this.f1712a = cVar;
        }

        public int compareTo(Object obj) {
            C1481c cVar = this.f1712a;
            C1513u.C1520f fVar = cVar.f1609u;
            C1481c cVar2 = ((C1525a) obj).f1712a;
            C1513u.C1520f fVar2 = cVar2.f1609u;
            return fVar == fVar2 ? cVar.f1591a - cVar2.f1591a : fVar2.ordinal() - fVar.ordinal();
        }
    }

    C1524w() {
        super(3, 3, 0, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new C1474G.C1477c());
    }

    public Future<?> submit(Runnable runnable) {
        C1525a aVar = new C1525a((C1481c) runnable);
        execute(aVar);
        return aVar;
    }
}
