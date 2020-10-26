// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.oned;

import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.common.BitArray;
import com.google.zxing.BarcodeFormat;
import java.util.ArrayList;
import java.util.Collection;
import com.google.zxing.DecodeHintType;
import java.util.Map;

public final class MultiFormatUPCEANReader extends OneDReader
{
    private final UPCEANReader[] readers;
    
    public MultiFormatUPCEANReader(final Map<DecodeHintType, ?> map) {
        Collection collection;
        if (map == null) {
            collection = null;
        }
        else {
            collection = (Collection)map.get(DecodeHintType.POSSIBLE_FORMATS);
        }
        final ArrayList<EAN13Reader> list = new ArrayList<EAN13Reader>();
        if (collection != null) {
            if (collection.contains(BarcodeFormat.EAN_13)) {
                list.add(new EAN13Reader());
            }
            else if (collection.contains(BarcodeFormat.UPC_A)) {
                list.add((EAN13Reader)new UPCAReader());
            }
            if (collection.contains(BarcodeFormat.EAN_8)) {
                list.add((EAN13Reader)new EAN8Reader());
            }
            if (collection.contains(BarcodeFormat.UPC_E)) {
                list.add((EAN13Reader)new UPCEReader());
            }
        }
        if (list.isEmpty()) {
            list.add(new EAN13Reader());
            list.add((EAN13Reader)new EAN8Reader());
            list.add((EAN13Reader)new UPCEReader());
        }
        this.readers = list.toArray(new UPCEANReader[list.size()]);
    }
    
    @Override
    public Result decodeRow(final int n, final BitArray bitArray, final Map<DecodeHintType, ?> map) throws NotFoundException {
        final int[] startGuardPattern = UPCEANReader.findStartGuardPattern(bitArray);
        final UPCEANReader[] readers = this.readers;
    Label_0189:
        for (int length = readers.length, i = 0; i < length; ++i) {
            while (true) {
                final UPCEANReader upceanReader = readers[i];
            Label_0098_Outer:
                while (true) {
                Label_0152_Outer:
                    while (true) {
                    Label_0077_Outer:
                        while (true) {
                            while (true) {
                                try {
                                    final Result decodeRow = upceanReader.decodeRow(n, bitArray, startGuardPattern, map);
                                    if (decodeRow.getBarcodeFormat() == BarcodeFormat.EAN_13 && decodeRow.getText().charAt(0) == '0') {
                                        final int n2 = 1;
                                        break Label_0193;
                                    }
                                    break Label_0152_Outer;
                                    Label_0175: {
                                        return decodeRow;
                                    }
                                    // iftrue(Label_0175:, n2 == 0 || n3 == 0)
                                    while (true) {
                                        final Result result = new Result(decodeRow.getText().substring(1), decodeRow.getRawBytes(), decodeRow.getResultPoints(), BarcodeFormat.UPC_A);
                                        result.putAllMetadata(decodeRow.getResultMetadata());
                                        return result;
                                        continue Label_0098_Outer;
                                    }
                                    final Collection collection = (Collection)map.get(DecodeHintType.POSSIBLE_FORMATS);
                                    break Label_0077;
                                    while (true) {
                                        final int n3 = 0;
                                        continue Label_0152_Outer;
                                        continue;
                                    }
                                }
                                // iftrue(Label_0203:, collection == null || collection.contains((Object)BarcodeFormat.UPC_A))
                                catch (ReaderException ex) {
                                    break;
                                }
                                break Label_0189;
                                if (map == null) {
                                    final Collection collection = null;
                                    continue;
                                }
                                break;
                            }
                            continue Label_0077_Outer;
                        }
                        Label_0203: {
                            final int n3 = 1;
                        }
                        continue Label_0152_Outer;
                    }
                    final int n2 = 0;
                    continue;
                }
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }
    
    @Override
    public void reset() {
        final UPCEANReader[] readers = this.readers;
        for (int length = readers.length, i = 0; i < length; ++i) {
            readers[i].reset();
        }
    }
}
