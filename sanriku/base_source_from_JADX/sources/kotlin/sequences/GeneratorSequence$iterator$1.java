package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000#\n\u0000\n\u0002\u0010(\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\t\u0010\u0010\u001a\u00020\u0011H\u0002J\u000e\u0010\u0012\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0004R\u001e\u0010\u0002\u001a\u0004\u0018\u00018\u0000X\u000e¢\u0006\u0010\n\u0002\u0010\u0007\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0013"}, mo21739d2 = {"kotlin/sequences/GeneratorSequence$iterator$1", "", "nextItem", "getNextItem", "()Ljava/lang/Object;", "setNextItem", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "nextState", "", "getNextState", "()I", "setNextState", "(I)V", "calcNext", "", "hasNext", "", "next", "kotlin-stdlib"}, mo21740k = 1, mo21741mv = {1, 1, 16})
public final class GeneratorSequence$iterator$1 implements Iterator<T>, KMappedMarker {
    private T nextItem;
    private int nextState = -2;
    final /* synthetic */ GeneratorSequence this$0;

    GeneratorSequence$iterator$1(GeneratorSequence generatorSequence) {
        this.this$0 = generatorSequence;
    }

    private final void calcNext() {
        T t;
        if (this.nextState == -2) {
            t = this.this$0.getInitialValue.invoke();
        } else {
            Function1 access$getGetNextValue$p = this.this$0.getNextValue;
            T t2 = this.nextItem;
            if (t2 == null) {
                Intrinsics.throwNpe();
            }
            t = access$getGetNextValue$p.invoke(t2);
        }
        this.nextItem = t;
        this.nextState = t == null ? 0 : 1;
    }

    public final T getNextItem() {
        return this.nextItem;
    }

    public final int getNextState() {
        return this.nextState;
    }

    public boolean hasNext() {
        if (this.nextState < 0) {
            calcNext();
        }
        return this.nextState == 1;
    }

    public T next() {
        if (this.nextState < 0) {
            calcNext();
        }
        if (this.nextState != 0) {
            T t = this.nextItem;
            if (t != null) {
                this.nextState = -1;
                return t;
            }
            throw new TypeCastException("null cannot be cast to non-null type T");
        }
        throw new NoSuchElementException();
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void setNextItem(T t) {
        this.nextItem = t;
    }

    public final void setNextState(int i) {
        this.nextState = i;
    }
}
