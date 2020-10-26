// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.aztec.encoder;

import java.util.Comparator;
import java.util.Collections;
import com.google.zxing.common.BitArray;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Collection;
import java.util.Arrays;
import java.lang.reflect.Array;

public final class HighLevelEncoder
{
    private static final int[][] CHAR_MAP;
    static final int[][] LATCH_TABLE;
    static final int MODE_DIGIT = 2;
    static final int MODE_LOWER = 1;
    static final int MODE_MIXED = 3;
    static final String[] MODE_NAMES;
    static final int MODE_PUNCT = 4;
    static final int MODE_UPPER = 0;
    static final int[][] SHIFT_TABLE;
    private final byte[] text;
    
    static {
        MODE_NAMES = new String[] { "UPPER", "LOWER", "DIGIT", "MIXED", "PUNCT" };
        LATCH_TABLE = new int[][] { { 0, 327708, 327710, 327709, 656318 }, { 590318, 0, 327710, 327709, 656318 }, { 262158, 590300, 0, 590301, 932798 }, { 327709, 327708, 656318, 0, 327710 }, { 327711, 656380, 656382, 656381, 0 } };
        (CHAR_MAP = (int[][])Array.newInstance(Integer.TYPE, 5, 256))[0][32] = 1;
        for (int i = 65; i <= 90; ++i) {
            HighLevelEncoder.CHAR_MAP[0][i] = i - 65 + 2;
        }
        HighLevelEncoder.CHAR_MAP[1][32] = 1;
        for (int j = 97; j <= 122; ++j) {
            HighLevelEncoder.CHAR_MAP[1][j] = j - 97 + 2;
        }
        HighLevelEncoder.CHAR_MAP[2][32] = 1;
        for (int k = 48; k <= 57; ++k) {
            HighLevelEncoder.CHAR_MAP[2][k] = k - 48 + 2;
        }
        HighLevelEncoder.CHAR_MAP[2][44] = 12;
        HighLevelEncoder.CHAR_MAP[2][46] = 13;
        for (int l = 0; l < 28; ++l) {
            HighLevelEncoder.CHAR_MAP[3][(new int[] { 0, 32, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 27, 28, 29, 30, 31, 64, 92, 94, 95, 96, 124, 126, 127 })[l]] = l;
        }
        final int[] array2;
        final int[] array = array2 = new int[31];
        array2[0] = 0;
        array2[1] = 13;
        array2[3] = (array2[2] = 0);
        array2[5] = (array2[4] = 0);
        array2[6] = 33;
        array2[7] = 39;
        array2[8] = 35;
        array2[9] = 36;
        array2[10] = 37;
        array2[11] = 38;
        array2[12] = 39;
        array2[13] = 40;
        array2[14] = 41;
        array2[15] = 42;
        array2[16] = 43;
        array2[17] = 44;
        array2[18] = 45;
        array2[19] = 46;
        array2[20] = 47;
        array2[21] = 58;
        array2[22] = 59;
        array2[23] = 60;
        array2[24] = 61;
        array2[25] = 62;
        array2[26] = 63;
        array2[27] = 91;
        array2[28] = 93;
        array2[29] = 123;
        array2[30] = 125;
        for (int n = 0; n < 31; ++n) {
            if (array[n] > 0) {
                HighLevelEncoder.CHAR_MAP[4][array[n]] = n;
            }
        }
        final int[][] array3 = SHIFT_TABLE = (int[][])Array.newInstance(Integer.TYPE, 6, 6);
        for (int length = array3.length, n2 = 0; n2 < length; ++n2) {
            Arrays.fill(array3[n2], -1);
        }
        HighLevelEncoder.SHIFT_TABLE[0][4] = 0;
        HighLevelEncoder.SHIFT_TABLE[1][4] = 0;
        HighLevelEncoder.SHIFT_TABLE[1][0] = 28;
        HighLevelEncoder.SHIFT_TABLE[3][4] = 0;
        HighLevelEncoder.SHIFT_TABLE[2][4] = 0;
        HighLevelEncoder.SHIFT_TABLE[2][0] = 15;
    }
    
    public HighLevelEncoder(final byte[] text) {
        this.text = text;
    }
    
    private static Collection<State> simplifyStates(final Iterable<State> iterable) {
        final LinkedList<State> list = new LinkedList<State>();
        for (final State state : iterable) {
            final int n = 1;
            final Iterator<Object> iterator2 = list.iterator();
            int n2;
            while (true) {
                n2 = n;
                if (!iterator2.hasNext()) {
                    break;
                }
                final State state2 = iterator2.next();
                if (state2.isBetterThanOrEqualTo(state)) {
                    n2 = 0;
                    break;
                }
                if (!state.isBetterThanOrEqualTo(state2)) {
                    continue;
                }
                iterator2.remove();
            }
            if (n2 != 0) {
                list.add(state);
            }
        }
        return list;
    }
    
    private void updateStateForChar(final State state, final int n, final Collection<State> collection) {
        final char c = (char)(this.text[n] & 0xFF);
        boolean b;
        if (HighLevelEncoder.CHAR_MAP[state.getMode()][c] > 0) {
            b = true;
        }
        else {
            b = false;
        }
        State state2 = null;
        State state3;
        for (int i = 0; i <= 4; ++i, state2 = state3) {
            final int n2 = HighLevelEncoder.CHAR_MAP[i][c];
            state3 = state2;
            if (n2 > 0) {
                State endBinaryShift;
                if ((endBinaryShift = state2) == null) {
                    endBinaryShift = state.endBinaryShift(n);
                }
                if (!b || i == state.getMode() || i == 2) {
                    collection.add(endBinaryShift.latchAndAppend(i, n2));
                }
                state3 = endBinaryShift;
                if (!b) {
                    state3 = endBinaryShift;
                    if (HighLevelEncoder.SHIFT_TABLE[state.getMode()][i] >= 0) {
                        collection.add(endBinaryShift.shiftAndAppend(i, n2));
                        state3 = endBinaryShift;
                    }
                }
            }
        }
        if (state.getBinaryShiftByteCount() > 0 || HighLevelEncoder.CHAR_MAP[state.getMode()][c] == 0) {
            collection.add(state.addBinaryShiftChar(n));
        }
    }
    
    private static void updateStateForPair(final State state, final int n, final int n2, final Collection<State> collection) {
        final State endBinaryShift = state.endBinaryShift(n);
        collection.add(endBinaryShift.latchAndAppend(4, n2));
        if (state.getMode() != 4) {
            collection.add(endBinaryShift.shiftAndAppend(4, n2));
        }
        if (n2 == 3 || n2 == 4) {
            collection.add(endBinaryShift.latchAndAppend(2, 16 - n2).latchAndAppend(2, 1));
        }
        if (state.getBinaryShiftByteCount() > 0) {
            collection.add(state.addBinaryShiftChar(n).addBinaryShiftChar(n + 1));
        }
    }
    
    private Collection<State> updateStateListForChar(final Iterable<State> iterable, final int n) {
        final LinkedList<State> list = new LinkedList<State>();
        final Iterator<State> iterator = iterable.iterator();
        while (iterator.hasNext()) {
            this.updateStateForChar(iterator.next(), n, list);
        }
        return simplifyStates(list);
    }
    
    private static Collection<State> updateStateListForPair(final Iterable<State> iterable, final int n, final int n2) {
        final LinkedList<State> list = new LinkedList<State>();
        final Iterator<State> iterator = iterable.iterator();
        while (iterator.hasNext()) {
            updateStateForPair(iterator.next(), n, n2, list);
        }
        return simplifyStates(list);
    }
    
    public BitArray encode() {
        Collection<State> coll = Collections.singletonList(State.INITIAL_STATE);
        for (int i = 0; i < this.text.length; ++i) {
            byte b;
            if (i + 1 < this.text.length) {
                b = this.text[i + 1];
            }
            else {
                b = 0;
            }
            int n = 0;
            switch (this.text[i]) {
                default: {
                    n = 0;
                    break;
                }
                case 13: {
                    if (b == 10) {
                        n = 2;
                    }
                    else {
                        n = 0;
                    }
                    break;
                }
                case 46: {
                    if (b == 32) {
                        n = 3;
                    }
                    else {
                        n = 0;
                    }
                    break;
                }
                case 44: {
                    if (b == 32) {
                        n = 4;
                    }
                    else {
                        n = 0;
                    }
                    break;
                }
                case 58: {
                    if (b == 32) {
                        n = 5;
                    }
                    else {
                        n = 0;
                    }
                    break;
                }
            }
            if (n > 0) {
                coll = updateStateListForPair(coll, i, n);
                ++i;
            }
            else {
                coll = this.updateStateListForChar(coll, i);
            }
        }
        return ((State)Collections.min((Collection<?>)coll, (Comparator<? super Object>)new Comparator<State>() {
            @Override
            public int compare(final State state, final State state2) {
                return state.getBitCount() - state2.getBitCount();
            }
        })).toBitArray(this.text);
    }
}
