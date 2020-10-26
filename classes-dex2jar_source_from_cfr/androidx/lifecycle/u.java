/*
 * Decompiled with CFR 0.139.
 */
package androidx.lifecycle;

import androidx.a.a.c.a;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.n;
import androidx.lifecycle.q;

public class u {
    public static <X, Y> LiveData<Y> a(LiveData<X> liveData, final a<X, LiveData<Y>> a2) {
        final n n2 = new n();
        n2.a(liveData, new q<X>(){
            LiveData<Y> a;

            @Override
            public void a(X object) {
                if (this.a == (object = (LiveData)a2.a(object))) {
                    return;
                }
                if (this.a != null) {
                    n2.a(this.a);
                }
                this.a = object;
                if (this.a != null) {
                    n2.a(this.a, new q<Y>(){

                        @Override
                        public void a(Y y2) {
                            n2.b(y2);
                        }
                    });
                }
            }

        });
        return n2;
    }

}

