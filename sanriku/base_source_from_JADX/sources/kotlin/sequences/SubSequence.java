package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010(\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B#\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\r\u001a\u00020\u0006H\u0016J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fH\u0002J\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\r\u001a\u00020\u0006H\u0016R\u0014\u0010\t\u001a\u00020\u00068BX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0007\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, mo21739d2 = {"Lkotlin/sequences/SubSequence;", "T", "Lkotlin/sequences/Sequence;", "Lkotlin/sequences/DropTakeSequence;", "sequence", "startIndex", "", "endIndex", "(Lkotlin/sequences/Sequence;II)V", "count", "getCount", "()I", "drop", "n", "iterator", "", "take", "kotlin-stdlib"}, mo21740k = 1, mo21741mv = {1, 1, 16})
public final class SubSequence<T> implements Sequence<T>, DropTakeSequence<T> {
    /* access modifiers changed from: private */
    public final int endIndex;
    /* access modifiers changed from: private */
    public final Sequence<T> sequence;
    /* access modifiers changed from: private */
    public final int startIndex;

    public SubSequence(Sequence<? extends T> sequence2, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(sequence2, "sequence");
        this.sequence = sequence2;
        this.startIndex = i;
        this.endIndex = i2;
        boolean z = true;
        if (i >= 0) {
            if (this.endIndex >= 0) {
                if (!(this.endIndex < this.startIndex ? false : z)) {
                    StringBuilder a = C0681a.m330a("endIndex should be not less than startIndex, but was ");
                    a.append(this.endIndex);
                    a.append(" < ");
                    a.append(this.startIndex);
                    throw new IllegalArgumentException(a.toString().toString());
                }
                return;
            }
            StringBuilder a2 = C0681a.m330a("endIndex should be non-negative, but is ");
            a2.append(this.endIndex);
            throw new IllegalArgumentException(a2.toString().toString());
        }
        StringBuilder a3 = C0681a.m330a("startIndex should be non-negative, but is ");
        a3.append(this.startIndex);
        throw new IllegalArgumentException(a3.toString().toString());
    }

    private final int getCount() {
        return this.endIndex - this.startIndex;
    }

    public Sequence<T> drop(int i) {
        if (i >= getCount()) {
            return SequencesKt__SequencesKt.emptySequence();
        }
        return new SubSequence(this.sequence, this.startIndex + i, this.endIndex);
    }

    public Iterator<T> iterator() {
        return new SubSequence$iterator$1(this);
    }

    public Sequence<T> take(int i) {
        if (i >= getCount()) {
            return this;
        }
        Sequence<T> sequence2 = this.sequence;
        int i2 = this.startIndex;
        return new SubSequence(sequence2, i2, i + i2);
    }
}