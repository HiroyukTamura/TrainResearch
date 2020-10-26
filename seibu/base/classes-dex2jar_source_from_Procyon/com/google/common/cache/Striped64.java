// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.cache;

import java.security.PrivilegedActionException;
import java.security.AccessController;
import java.lang.reflect.Field;
import java.security.PrivilegedExceptionAction;
import java.util.Random;
import sun.misc.Unsafe;

abstract class Striped64 extends Number
{
    static final int NCPU;
    private static final Unsafe UNSAFE;
    private static final long baseOffset;
    private static final long busyOffset;
    static final Random rng;
    static final ThreadLocal<int[]> threadHashCode;
    transient volatile long base;
    transient volatile int busy;
    transient volatile Cell[] cells;
    
    static {
        threadHashCode = new ThreadLocal<int[]>();
        rng = new Random();
        NCPU = Runtime.getRuntime().availableProcessors();
        try {
            UNSAFE = getUnsafe();
            baseOffset = Striped64.UNSAFE.objectFieldOffset(Striped64.class.getDeclaredField("base"));
            busyOffset = Striped64.UNSAFE.objectFieldOffset(Striped64.class.getDeclaredField("busy"));
        }
        catch (Exception cause) {
            throw new Error(cause);
        }
    }
    
    private static Unsafe getUnsafe() {
        try {
            return Unsafe.getUnsafe();
        }
        catch (SecurityException ex2) {
            try {
                return AccessController.doPrivileged((PrivilegedExceptionAction<Unsafe>)new PrivilegedExceptionAction<Unsafe>() {
                    @Override
                    public Unsafe run() throws Exception {
                        final Field[] declaredFields = Unsafe.class.getDeclaredFields();
                        for (int length = declaredFields.length, i = 0; i < length; ++i) {
                            final Field field = declaredFields[i];
                            field.setAccessible(true);
                            final Object value = field.get(null);
                            if (Unsafe.class.isInstance(value)) {
                                return Unsafe.class.cast(value);
                            }
                        }
                        throw new NoSuchFieldError("the Unsafe");
                    }
                });
            }
            catch (PrivilegedActionException ex) {
                throw new RuntimeException("Could not initialize intrinsics", ex.getCause());
            }
        }
    }
    
    final boolean casBase(final long expected, final long x) {
        return Striped64.UNSAFE.compareAndSwapLong(this, Striped64.baseOffset, expected, x);
    }
    
    final boolean casBusy() {
        return Striped64.UNSAFE.compareAndSwapInt(this, Striped64.busyOffset, 0, 1);
    }
    
    abstract long fn(final long p0, final long p1);
    
    final void internalReset(final long n) {
        final Cell[] cells = this.cells;
        this.base = n;
        if (cells != null) {
            for (int length = cells.length, i = 0; i < length; ++i) {
                final Cell cell = cells[i];
                if (cell != null) {
                    cell.value = n;
                }
            }
        }
    }
    
    final void retryUpdate(final long n, int[] value, boolean b) {
    Label_0047:
        while (true) {
            int i = 0;
            int n2 = 0;
            boolean b2 = false;
            Label_0216: {
                Label_0193: {
                    if (value != null) {
                        break Label_0193;
                    }
                    final ThreadLocal<int[]> threadHashCode = Striped64.threadHashCode;
                    value = new int[] { 0 };
                    threadHashCode.set(value);
                    i = Striped64.rng.nextInt();
                Label_0040_Outer:
                    while (true) {
                        if (i == 0) {
                            i = 1;
                            break Label_0035;
                        }
                        Label_0190: {
                            break Label_0190;
                            while (true) {
                                Cell cell = null;
                                Block_8: {
                                    while (true) {
                                        final Cell[] cells = this.cells;
                                        if (cells != null) {
                                            final int length = cells.length;
                                            if (length > 0) {
                                                Object cells2 = cells[length - 1 & n2];
                                                if (cells2 == null) {
                                                    if (this.busy != 0) {
                                                        break Label_0193;
                                                    }
                                                    cell = new Cell(n);
                                                    if (this.busy == 0 && this.casBusy()) {
                                                        break Block_8;
                                                    }
                                                    break Label_0193;
                                                }
                                                else {
                                                    int n3 = 0;
                                                    if (!b) {
                                                        b2 = true;
                                                        i = n3;
                                                        break Label_0216;
                                                    }
                                                    final long value2 = ((Cell)cells2).value;
                                                    if (((Cell)cells2).cas(value2, this.fn(value2, n))) {
                                                        return;
                                                    }
                                                    if (length >= Striped64.NCPU || this.cells != cells) {
                                                        i = 0;
                                                        b2 = b;
                                                        break Label_0216;
                                                    }
                                                    if (n3 == 0) {
                                                        i = 1;
                                                        b2 = b;
                                                        break Label_0216;
                                                    }
                                                    i = n3;
                                                    b2 = b;
                                                    if (this.busy != 0) {
                                                        break Label_0216;
                                                    }
                                                    i = n3;
                                                    b2 = b;
                                                    if (!this.casBusy()) {
                                                        break Label_0216;
                                                    }
                                                Label_0396_Outer:
                                                    while (true) {
                                                        while (true) {
                                                            Label_0528: {
                                                                try {
                                                                    if (this.cells == cells) {
                                                                        cells2 = new Cell[length << 1];
                                                                        i = 0;
                                                                        break Label_0528;
                                                                    }
                                                                    while (true) {
                                                                        this.busy = 0;
                                                                        n3 = 0;
                                                                        continue Label_0047;
                                                                        this.cells = (Cell[])cells2;
                                                                        continue Label_0396_Outer;
                                                                    }
                                                                }
                                                                finally {
                                                                    this.busy = 0;
                                                                }
                                                                break;
                                                            }
                                                            while (i < length) {
                                                                cells2[i] = cells[i];
                                                                ++i;
                                                            }
                                                            continue Label_0040_Outer;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        if (this.busy == 0 && this.cells == cells && this.casBusy()) {
                                            i = 0;
                                            try {
                                                if (this.cells == cells) {
                                                    final Cell[] cells3 = new Cell[2];
                                                    cells3[n2 & 0x1] = new Cell(n);
                                                    this.cells = cells3;
                                                    i = 1;
                                                }
                                                this.busy = 0;
                                                if (i != 0) {
                                                    return;
                                                }
                                                continue Label_0040_Outer;
                                            }
                                            finally {
                                                this.busy = 0;
                                            }
                                        }
                                        final long base = this.base;
                                        if (this.casBase(base, this.fn(base, n))) {
                                            return;
                                        }
                                    }
                                    value[0] = i;
                                    int n3 = 0;
                                    n2 = i;
                                    continue Label_0047;
                                }
                                final int n4 = 0;
                                try {
                                    final Cell[] cells4 = this.cells;
                                    i = n4;
                                    if (cells4 != null) {
                                        final int length2 = cells4.length;
                                        i = n4;
                                        if (length2 > 0) {
                                            final int n5 = length2 - 1 & n2;
                                            i = n4;
                                            if (cells4[n5] == null) {
                                                cells4[n5] = cell;
                                                i = 1;
                                            }
                                        }
                                    }
                                    this.busy = 0;
                                    if (i != 0) {
                                        return;
                                    }
                                    continue Label_0047;
                                    i = value[0];
                                    continue;
                                    continue Label_0040_Outer;
                                }
                                finally {
                                    this.busy = 0;
                                }
                                break;
                            }
                        }
                        break;
                    }
                }
                i = 0;
                b2 = b;
            }
            final int n6 = n2 ^ n2 << 13;
            final int n7 = n6 ^ n6 >>> 17;
            n2 = (n7 ^ n7 << 5);
            value[0] = n2;
            int n3 = i;
            b = b2;
            continue Label_0047;
        }
    }
    
    static final class Cell
    {
        private static final Unsafe UNSAFE;
        private static final long valueOffset;
        volatile long p0;
        volatile long p1;
        volatile long p2;
        volatile long p3;
        volatile long p4;
        volatile long p5;
        volatile long p6;
        volatile long q0;
        volatile long q1;
        volatile long q2;
        volatile long q3;
        volatile long q4;
        volatile long q5;
        volatile long q6;
        volatile long value;
        
        static {
            try {
                UNSAFE = getUnsafe();
                valueOffset = Cell.UNSAFE.objectFieldOffset(Cell.class.getDeclaredField("value"));
            }
            catch (Exception cause) {
                throw new Error(cause);
            }
        }
        
        Cell(final long value) {
            this.value = value;
        }
        
        final boolean cas(final long expected, final long x) {
            return Cell.UNSAFE.compareAndSwapLong(this, Cell.valueOffset, expected, x);
        }
    }
}
