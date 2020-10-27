package p041io.realm;

import java.util.Locale;

/* renamed from: io.realm.OrderedCollectionChangeSet */
public interface OrderedCollectionChangeSet {

    /* renamed from: io.realm.OrderedCollectionChangeSet$Range */
    public static class Range {
        public final int length;
        public final int startIndex;

        public Range(int i, int i2) {
            this.startIndex = i;
            this.length = i2;
        }

        public String toString() {
            return String.format(Locale.ENGLISH, "startIndex: %d, length: %d", new Object[]{Integer.valueOf(this.startIndex), Integer.valueOf(this.length)});
        }
    }

    /* renamed from: io.realm.OrderedCollectionChangeSet$State */
    public enum State {
        INITIAL,
        UPDATE,
        ERROR
    }

    Range[] getChangeRanges();

    int[] getChanges();

    Range[] getDeletionRanges();

    int[] getDeletions();

    Throwable getError();

    Range[] getInsertionRanges();

    int[] getInsertions();

    State getState();

    boolean isCompleteResult();
}
