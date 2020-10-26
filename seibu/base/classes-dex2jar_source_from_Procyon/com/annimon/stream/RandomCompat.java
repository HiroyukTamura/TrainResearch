// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream;

import com.annimon.stream.function.LongSupplier;
import com.annimon.stream.function.IntSupplier;
import com.annimon.stream.function.DoubleSupplier;
import java.util.Random;

public final class RandomCompat
{
    private final Random random;
    
    public RandomCompat() {
        this.random = new Random();
    }
    
    public RandomCompat(final long seed) {
        this.random = new Random(seed);
    }
    
    public RandomCompat(final Random random) {
        this.random = random;
    }
    
    public DoubleStream doubles() {
        return DoubleStream.generate(new DoubleSupplier() {
            @Override
            public double getAsDouble() {
                return RandomCompat.this.random.nextDouble();
            }
        });
    }
    
    public DoubleStream doubles(final double n, final double n2) {
        if (n >= n2) {
            throw new IllegalArgumentException();
        }
        return DoubleStream.generate(new DoubleSupplier() {
            private final double bound = n2 - n;
            
            @Override
            public double getAsDouble() {
                double longBitsToDouble;
                if ((longBitsToDouble = RandomCompat.this.random.nextDouble() * this.bound + n) >= n2) {
                    longBitsToDouble = Double.longBitsToDouble(Double.doubleToLongBits(n2) - 1L);
                }
                return longBitsToDouble;
            }
        });
    }
    
    public DoubleStream doubles(final long n) {
        if (n < 0L) {
            throw new IllegalArgumentException();
        }
        if (n == 0L) {
            return DoubleStream.empty();
        }
        return this.doubles().limit(n);
    }
    
    public DoubleStream doubles(final long n, final double n2, final double n3) {
        if (n < 0L) {
            throw new IllegalArgumentException();
        }
        if (n == 0L) {
            return DoubleStream.empty();
        }
        return this.doubles(n2, n3).limit(n);
    }
    
    public Random getRandom() {
        return this.random;
    }
    
    public IntStream ints() {
        return IntStream.generate(new IntSupplier() {
            @Override
            public int getAsInt() {
                return RandomCompat.this.random.nextInt();
            }
        });
    }
    
    public IntStream ints(final int n, final int n2) {
        if (n >= n2) {
            throw new IllegalArgumentException();
        }
        return IntStream.generate(new IntSupplier() {
            private final int bound = n2 - n;
            
            @Override
            public int getAsInt() {
                if (this.bound < 0) {
                    int nextInt;
                    do {
                        nextInt = RandomCompat.this.random.nextInt();
                    } while (n >= nextInt || nextInt >= n2);
                    return nextInt;
                }
                return n + RandomCompat.this.random.nextInt(this.bound);
            }
        });
    }
    
    public IntStream ints(final long n) {
        if (n < 0L) {
            throw new IllegalArgumentException();
        }
        if (n == 0L) {
            return IntStream.empty();
        }
        return this.ints().limit(n);
    }
    
    public IntStream ints(final long n, final int n2, final int n3) {
        if (n < 0L) {
            throw new IllegalArgumentException();
        }
        if (n == 0L) {
            return IntStream.empty();
        }
        return this.ints(n2, n3).limit(n);
    }
    
    public LongStream longs() {
        return LongStream.generate(new LongSupplier() {
            @Override
            public long getAsLong() {
                return RandomCompat.this.random.nextLong();
            }
        });
    }
    
    public LongStream longs(final long n) {
        if (n < 0L) {
            throw new IllegalArgumentException();
        }
        if (n == 0L) {
            return LongStream.empty();
        }
        return this.longs().limit(n);
    }
    
    public LongStream longs(final long n, final long n2) {
        if (n >= n2) {
            throw new IllegalArgumentException();
        }
        return LongStream.generate(new LongSupplier() {
            private final long bound = n2 - n;
            private final long boundMinus1 = this.bound - 1L;
            
            @Override
            public long getAsLong() {
                final long nextLong = RandomCompat.this.random.nextLong();
                long n;
                if ((this.bound & this.boundMinus1) == 0x0L) {
                    n += (this.boundMinus1 & nextLong);
                }
                else {
                    long nextLong2 = nextLong;
                    if (this.bound > 0L) {
                        long n2 = nextLong >>> 1;
                        long n3;
                        while (true) {
                            final long boundMinus1 = this.boundMinus1;
                            n3 = n2 % this.bound;
                            if (boundMinus1 + n2 - n3 >= 0L) {
                                break;
                            }
                            n2 = RandomCompat.this.random.nextLong() >>> 1;
                        }
                        return n3 + n;
                    }
                    while (true) {
                        if (n < nextLong2) {
                            n = nextLong2;
                            if (nextLong2 < n2) {
                                break;
                            }
                        }
                        nextLong2 = RandomCompat.this.random.nextLong();
                    }
                }
                return n;
            }
        });
    }
    
    public LongStream longs(final long n, final long n2, final long n3) {
        if (n < 0L) {
            throw new IllegalArgumentException();
        }
        if (n == 0L) {
            return LongStream.empty();
        }
        return this.longs(n2, n3).limit(n);
    }
}
