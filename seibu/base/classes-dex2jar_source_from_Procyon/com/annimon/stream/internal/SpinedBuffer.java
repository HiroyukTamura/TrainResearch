// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.internal;

import java.util.Arrays;
import com.annimon.stream.function.LongConsumer;
import com.annimon.stream.function.IntConsumer;
import java.util.Iterator;
import com.annimon.stream.iterator.PrimitiveIterator;
import com.annimon.stream.function.DoubleConsumer;

final class SpinedBuffer
{
    private static final int MAX_CHUNK_POWER = 30;
    static final int MIN_CHUNK_POWER = 4;
    static final int MIN_CHUNK_SIZE = 16;
    static final int MIN_SPINE_SIZE = 8;
    
    private SpinedBuffer() {
    }
    
    static class OfDouble extends OfPrimitive<Double, double[], DoubleConsumer> implements DoubleConsumer
    {
        OfDouble() {
        }
        
        OfDouble(final int n) {
            super(n);
        }
        
        @Override
        public void accept(final double n) {
            ((OfPrimitive)this).preAccept();
            ((double[])(Object)this.curChunk)[this.elementIndex++] = n;
        }
        
        protected int arrayLength(final double[] array) {
            return array.length;
        }
        
        public double get(final long n) {
            final int chunk = ((OfPrimitive)this).chunkFor(n);
            if (this.spineIndex == 0 && chunk == 0) {
                return ((double[])(Object)this.curChunk)[(int)n];
            }
            return ((double[][])(Object)this.spine)[chunk][(int)(n - this.priorElementCount[chunk])];
        }
        
        @Override
        public PrimitiveIterator.OfDouble iterator() {
            return new PrimitiveIterator.OfDouble() {
                long index = 0L;
                
                @Override
                public boolean hasNext() {
                    return this.index < ((OfPrimitive)SpinedBuffer.OfDouble.this).count();
                }
                
                @Override
                public double nextDouble() {
                    final SpinedBuffer.OfDouble this$0 = SpinedBuffer.OfDouble.this;
                    final long index = this.index;
                    this.index = 1L + index;
                    return this$0.get(index);
                }
            };
        }
        
        public double[] newArray(final int n) {
            return new double[n];
        }
        
        protected double[][] newArrayArray(final int n) {
            return new double[n][];
        }
    }
    
    static class OfInt extends OfPrimitive<Integer, int[], IntConsumer> implements IntConsumer
    {
        OfInt() {
        }
        
        OfInt(final int n) {
            super(n);
        }
        
        @Override
        public void accept(final int n) {
            ((OfPrimitive)this).preAccept();
            ((int[])(Object)this.curChunk)[this.elementIndex++] = n;
        }
        
        protected int arrayLength(final int[] array) {
            return array.length;
        }
        
        public int get(final long n) {
            final int chunk = ((OfPrimitive)this).chunkFor(n);
            if (this.spineIndex == 0 && chunk == 0) {
                return ((int[])(Object)this.curChunk)[(int)n];
            }
            return ((int[][])(Object)this.spine)[chunk][(int)(n - this.priorElementCount[chunk])];
        }
        
        @Override
        public PrimitiveIterator.OfInt iterator() {
            return new PrimitiveIterator.OfInt() {
                long index = 0L;
                
                @Override
                public boolean hasNext() {
                    return this.index < ((OfPrimitive)SpinedBuffer.OfInt.this).count();
                }
                
                @Override
                public int nextInt() {
                    final SpinedBuffer.OfInt this$0 = SpinedBuffer.OfInt.this;
                    final long index = this.index;
                    this.index = 1L + index;
                    return this$0.get(index);
                }
            };
        }
        
        public int[] newArray(final int n) {
            return new int[n];
        }
        
        protected int[][] newArrayArray(final int n) {
            return new int[n][];
        }
    }
    
    static class OfLong extends OfPrimitive<Long, long[], LongConsumer> implements LongConsumer
    {
        OfLong() {
        }
        
        OfLong(final int n) {
            super(n);
        }
        
        @Override
        public void accept(final long n) {
            ((OfPrimitive)this).preAccept();
            ((long[])(Object)this.curChunk)[this.elementIndex++] = n;
        }
        
        protected int arrayLength(final long[] array) {
            return array.length;
        }
        
        public long get(final long n) {
            final int chunk = ((OfPrimitive)this).chunkFor(n);
            if (this.spineIndex == 0 && chunk == 0) {
                return ((long[])(Object)this.curChunk)[(int)n];
            }
            return ((long[][])(Object)this.spine)[chunk][(int)(n - this.priorElementCount[chunk])];
        }
        
        @Override
        public PrimitiveIterator.OfLong iterator() {
            return new PrimitiveIterator.OfLong() {
                long index = 0L;
                
                @Override
                public boolean hasNext() {
                    return this.index < ((OfPrimitive)SpinedBuffer.OfLong.this).count();
                }
                
                @Override
                public long nextLong() {
                    final SpinedBuffer.OfLong this$0 = SpinedBuffer.OfLong.this;
                    final long index = this.index;
                    this.index = 1L + index;
                    return this$0.get(index);
                }
            };
        }
        
        public long[] newArray(final int n) {
            return new long[n];
        }
        
        protected long[][] newArrayArray(final int n) {
            return new long[n][];
        }
    }
    
    abstract static class OfPrimitive<E, T_ARR, T_CONS> implements Iterable<E>
    {
        T_ARR curChunk;
        int elementIndex;
        final int initialChunkPower;
        long[] priorElementCount;
        T_ARR[] spine;
        int spineIndex;
        
        OfPrimitive() {
            this.initialChunkPower = 4;
            this.curChunk = this.newArray(1 << this.initialChunkPower);
        }
        
        OfPrimitive(final int i) {
            if (i < 0) {
                throw new IllegalArgumentException("Illegal Capacity: " + i);
            }
            this.initialChunkPower = Math.max(4, 32 - Integer.numberOfLeadingZeros(i - 1));
            this.curChunk = this.newArray(1 << this.initialChunkPower);
        }
        
        private void inflateSpine() {
            if (this.spine == null) {
                this.spine = this.newArrayArray(8);
                this.priorElementCount = new long[8];
                this.spine[0] = this.curChunk;
            }
        }
        
        protected abstract int arrayLength(final T_ARR p0);
        
        public T_ARR asPrimitiveArray() {
            final long count = this.count();
            Compat.checkMaxArraySize(count);
            final T_ARR array = this.newArray((int)count);
            this.copyInto(array, 0);
            return array;
        }
        
        long capacity() {
            if (this.spineIndex == 0) {
                return this.arrayLength(this.curChunk);
            }
            return this.priorElementCount[this.spineIndex] + this.arrayLength(this.spine[this.spineIndex]);
        }
        
        int chunkFor(final long i) {
            int n;
            if (this.spineIndex == 0) {
                if (i >= this.elementIndex) {
                    throw new IndexOutOfBoundsException(Long.toString(i));
                }
                n = 0;
            }
            else {
                if (i >= this.count()) {
                    throw new IndexOutOfBoundsException(Long.toString(i));
                }
                for (int j = 0; j <= this.spineIndex; ++j) {
                    n = j;
                    if (i < this.priorElementCount[j] + this.arrayLength(this.spine[j])) {
                        return n;
                    }
                }
                throw new IndexOutOfBoundsException(Long.toString(i));
            }
            return n;
        }
        
        int chunkSize(int n) {
            if (n == 0 || n == 1) {
                n = this.initialChunkPower;
            }
            else {
                n = Math.min(this.initialChunkPower + n - 1, 30);
            }
            return 1 << n;
        }
        
        public void clear() {
            if (this.spine != null) {
                this.curChunk = this.spine[0];
                this.spine = null;
                this.priorElementCount = null;
            }
            this.elementIndex = 0;
            this.spineIndex = 0;
        }
        
        void copyInto(final T_ARR t_ARR, int i) {
            final long n = i + this.count();
            if (n > this.arrayLength(t_ARR) || n < i) {
                throw new IndexOutOfBoundsException("does not fit");
            }
            if (this.spineIndex == 0) {
                System.arraycopy(this.curChunk, 0, t_ARR, i, this.elementIndex);
            }
            else {
                final int n2 = 0;
                int n3 = i;
                for (i = n2; i < this.spineIndex; ++i) {
                    System.arraycopy(this.spine[i], 0, t_ARR, n3, this.arrayLength(this.spine[i]));
                    n3 += this.arrayLength(this.spine[i]);
                }
                if (this.elementIndex > 0) {
                    System.arraycopy(this.curChunk, 0, t_ARR, n3, this.elementIndex);
                }
            }
        }
        
        public long count() {
            if (this.spineIndex == 0) {
                return this.elementIndex;
            }
            return this.priorElementCount[this.spineIndex] + this.elementIndex;
        }
        
        final void ensureCapacity(final long n) {
            long capacity = this.capacity();
            if (n > capacity) {
                this.inflateSpine();
                int chunkSize;
                for (int n2 = this.spineIndex + 1; n > capacity; capacity += chunkSize, ++n2) {
                    if (n2 >= this.spine.length) {
                        final int n3 = this.spine.length * 2;
                        this.spine = Arrays.copyOf(this.spine, n3);
                        this.priorElementCount = Arrays.copyOf(this.priorElementCount, n3);
                    }
                    chunkSize = this.chunkSize(n2);
                    this.spine[n2] = this.newArray(chunkSize);
                    this.priorElementCount[n2] = this.priorElementCount[n2 - 1] + this.arrayLength(this.spine[n2 - 1]);
                }
            }
        }
        
        void increaseCapacity() {
            this.ensureCapacity(this.capacity() + 1L);
        }
        
        public boolean isEmpty() {
            return this.spineIndex == 0 && this.elementIndex == 0;
        }
        
        @Override
        public abstract Iterator<E> iterator();
        
        protected abstract T_ARR newArray(final int p0);
        
        protected abstract T_ARR[] newArrayArray(final int p0);
        
        void preAccept() {
            if (this.elementIndex == this.arrayLength(this.curChunk)) {
                this.inflateSpine();
                if (this.spineIndex + 1 >= this.spine.length || this.spine[this.spineIndex + 1] == null) {
                    this.increaseCapacity();
                }
                this.elementIndex = 0;
                ++this.spineIndex;
                this.curChunk = this.spine[this.spineIndex];
            }
        }
    }
}
