package p041io.realm.internal;

import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import p041io.realm.internal.ObserverPairList.ObserverPair;

/* renamed from: io.realm.internal.ObserverPairList */
public class ObserverPairList<T extends ObserverPair> {
    private boolean cleared = false;
    private List<T> pairs = new CopyOnWriteArrayList();

    /* renamed from: io.realm.internal.ObserverPairList$Callback */
    public interface Callback<T extends ObserverPair> {
        void onCalled(T t, Object obj);
    }

    /* renamed from: io.realm.internal.ObserverPairList$ObserverPair */
    public static abstract class ObserverPair<T, S> {
        protected final S listener;
        final WeakReference<T> observerRef;
        boolean removed = false;

        public ObserverPair(T t, S s) {
            this.listener = s;
            this.observerRef = new WeakReference<>(t);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ObserverPair)) {
                return false;
            }
            ObserverPair observerPair = (ObserverPair) obj;
            return this.listener.equals(observerPair.listener) && this.observerRef.get() == observerPair.observerRef.get();
        }

        public int hashCode() {
            Object obj = this.observerRef.get();
            int i = 0;
            int hashCode = (527 + (obj != null ? obj.hashCode() : 0)) * 31;
            S s = this.listener;
            if (s != null) {
                i = s.hashCode();
            }
            return hashCode + i;
        }
    }

    public void add(T t) {
        if (!this.pairs.contains(t)) {
            this.pairs.add(t);
            t.removed = false;
        }
        if (this.cleared) {
            this.cleared = false;
        }
    }

    public void clear() {
        this.cleared = true;
        this.pairs.clear();
    }

    public void foreach(Callback<T> callback) {
        for (T t : this.pairs) {
            if (!this.cleared) {
                Object obj = t.observerRef.get();
                if (obj == null) {
                    this.pairs.remove(t);
                } else if (!t.removed) {
                    callback.onCalled(t, obj);
                }
            } else {
                return;
            }
        }
    }

    public boolean isEmpty() {
        return this.pairs.isEmpty();
    }

    public <S, U> void remove(S s, U u) {
        for (T t : this.pairs) {
            if (s == t.observerRef.get() && u.equals(t.listener)) {
                t.removed = true;
                this.pairs.remove(t);
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void removeByObserver(Object obj) {
        for (T t : this.pairs) {
            Object obj2 = t.observerRef.get();
            if (obj2 == null || obj2 == obj) {
                t.removed = true;
                this.pairs.remove(t);
            }
        }
    }

    public int size() {
        return this.pairs.size();
    }
}
