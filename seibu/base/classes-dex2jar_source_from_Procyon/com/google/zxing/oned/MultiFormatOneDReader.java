// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.oned;

import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.common.BitArray;
import com.google.zxing.oned.rss.expanded.RSSExpandedReader;
import com.google.zxing.oned.rss.RSS14Reader;
import com.google.zxing.BarcodeFormat;
import java.util.ArrayList;
import java.util.Collection;
import com.google.zxing.DecodeHintType;
import java.util.Map;

public final class MultiFormatOneDReader extends OneDReader
{
    private final OneDReader[] readers;
    
    public MultiFormatOneDReader(final Map<DecodeHintType, ?> map) {
        Collection collection;
        if (map == null) {
            collection = null;
        }
        else {
            collection = (Collection)map.get(DecodeHintType.POSSIBLE_FORMATS);
        }
        final boolean b = map != null && map.get(DecodeHintType.ASSUME_CODE_39_CHECK_DIGIT) != null;
        final ArrayList<MultiFormatUPCEANReader> list = new ArrayList<MultiFormatUPCEANReader>();
        if (collection != null) {
            if (collection.contains(BarcodeFormat.EAN_13) || collection.contains(BarcodeFormat.UPC_A) || collection.contains(BarcodeFormat.EAN_8) || collection.contains(BarcodeFormat.UPC_E)) {
                list.add(new MultiFormatUPCEANReader(map));
            }
            if (collection.contains(BarcodeFormat.CODE_39)) {
                list.add((MultiFormatUPCEANReader)new Code39Reader(b));
            }
            if (collection.contains(BarcodeFormat.CODE_93)) {
                list.add((MultiFormatUPCEANReader)new Code93Reader());
            }
            if (collection.contains(BarcodeFormat.CODE_128)) {
                list.add((MultiFormatUPCEANReader)new Code128Reader());
            }
            if (collection.contains(BarcodeFormat.ITF)) {
                list.add((MultiFormatUPCEANReader)new ITFReader());
            }
            if (collection.contains(BarcodeFormat.CODABAR)) {
                list.add((MultiFormatUPCEANReader)new CodaBarReader());
            }
            if (collection.contains(BarcodeFormat.RSS_14)) {
                list.add((MultiFormatUPCEANReader)new RSS14Reader());
            }
            if (collection.contains(BarcodeFormat.RSS_EXPANDED)) {
                list.add((MultiFormatUPCEANReader)new RSSExpandedReader());
            }
        }
        if (list.isEmpty()) {
            list.add(new MultiFormatUPCEANReader(map));
            list.add((MultiFormatUPCEANReader)new Code39Reader());
            list.add((MultiFormatUPCEANReader)new CodaBarReader());
            list.add((MultiFormatUPCEANReader)new Code93Reader());
            list.add((MultiFormatUPCEANReader)new Code128Reader());
            list.add((MultiFormatUPCEANReader)new ITFReader());
            list.add((MultiFormatUPCEANReader)new RSS14Reader());
            list.add((MultiFormatUPCEANReader)new RSSExpandedReader());
        }
        this.readers = list.toArray(new OneDReader[list.size()]);
    }
    
    @Override
    public Result decodeRow(final int n, final BitArray bitArray, final Map<DecodeHintType, ?> map) throws NotFoundException {
        final OneDReader[] readers = this.readers;
        final int length = readers.length;
        int i = 0;
        while (i < length) {
            final OneDReader oneDReader = readers[i];
            try {
                return oneDReader.decodeRow(n, bitArray, map);
            }
            catch (ReaderException ex) {
                ++i;
                continue;
            }
            break;
        }
        throw NotFoundException.getNotFoundInstance();
    }
    
    @Override
    public void reset() {
        final OneDReader[] readers = this.readers;
        for (int length = readers.length, i = 0; i < length; ++i) {
            readers[i].reset();
        }
    }
}
