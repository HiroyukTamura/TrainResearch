// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing;

import com.google.zxing.maxicode.MaxiCodeReader;
import com.google.zxing.pdf417.PDF417Reader;
import com.google.zxing.aztec.AztecReader;
import com.google.zxing.datamatrix.DataMatrixReader;
import com.google.zxing.qrcode.QRCodeReader;
import com.google.zxing.oned.MultiFormatOneDReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public final class MultiFormatReader implements Reader
{
    private Map<DecodeHintType, ?> hints;
    private Reader[] readers;
    
    private Result decodeInternal(final BinaryBitmap binaryBitmap) throws NotFoundException {
        if (this.readers != null) {
            final Reader[] readers = this.readers;
            final int length = readers.length;
            int i = 0;
            while (i < length) {
                final Reader reader = readers[i];
                try {
                    return reader.decode(binaryBitmap, this.hints);
                }
                catch (ReaderException ex) {
                    ++i;
                    continue;
                }
                break;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }
    
    @Override
    public Result decode(final BinaryBitmap binaryBitmap) throws NotFoundException {
        this.setHints(null);
        return this.decodeInternal(binaryBitmap);
    }
    
    @Override
    public Result decode(final BinaryBitmap binaryBitmap, final Map<DecodeHintType, ?> hints) throws NotFoundException {
        this.setHints(hints);
        return this.decodeInternal(binaryBitmap);
    }
    
    public Result decodeWithState(final BinaryBitmap binaryBitmap) throws NotFoundException {
        if (this.readers == null) {
            this.setHints(null);
        }
        return this.decodeInternal(binaryBitmap);
    }
    
    @Override
    public void reset() {
        if (this.readers != null) {
            final Reader[] readers = this.readers;
            for (int length = readers.length, i = 0; i < length; ++i) {
                readers[i].reset();
            }
        }
    }
    
    public void setHints(final Map<DecodeHintType, ?> hints) {
        boolean b = false;
        this.hints = hints;
        boolean b2;
        if (hints != null && hints.containsKey(DecodeHintType.TRY_HARDER)) {
            b2 = true;
        }
        else {
            b2 = false;
        }
        Collection collection;
        if (hints == null) {
            collection = null;
        }
        else {
            collection = (Collection)hints.get(DecodeHintType.POSSIBLE_FORMATS);
        }
        final ArrayList<MultiFormatOneDReader> list = new ArrayList<MultiFormatOneDReader>();
        if (collection != null) {
            if (collection.contains(BarcodeFormat.UPC_A) || collection.contains(BarcodeFormat.UPC_E) || collection.contains(BarcodeFormat.EAN_13) || collection.contains(BarcodeFormat.EAN_8) || collection.contains(BarcodeFormat.CODABAR) || collection.contains(BarcodeFormat.CODE_39) || collection.contains(BarcodeFormat.CODE_93) || collection.contains(BarcodeFormat.CODE_128) || collection.contains(BarcodeFormat.ITF) || collection.contains(BarcodeFormat.RSS_14) || collection.contains(BarcodeFormat.RSS_EXPANDED)) {
                b = true;
            }
            if (b && !b2) {
                list.add(new MultiFormatOneDReader(hints));
            }
            if (collection.contains(BarcodeFormat.QR_CODE)) {
                list.add((MultiFormatOneDReader)new QRCodeReader());
            }
            if (collection.contains(BarcodeFormat.DATA_MATRIX)) {
                list.add((MultiFormatOneDReader)new DataMatrixReader());
            }
            if (collection.contains(BarcodeFormat.AZTEC)) {
                list.add((MultiFormatOneDReader)new AztecReader());
            }
            if (collection.contains(BarcodeFormat.PDF_417)) {
                list.add((MultiFormatOneDReader)new PDF417Reader());
            }
            if (collection.contains(BarcodeFormat.MAXICODE)) {
                list.add((MultiFormatOneDReader)new MaxiCodeReader());
            }
            if (b && b2) {
                list.add(new MultiFormatOneDReader(hints));
            }
        }
        if (list.isEmpty()) {
            if (!b2) {
                list.add(new MultiFormatOneDReader(hints));
            }
            list.add((MultiFormatOneDReader)new QRCodeReader());
            list.add((MultiFormatOneDReader)new DataMatrixReader());
            list.add((MultiFormatOneDReader)new AztecReader());
            list.add((MultiFormatOneDReader)new PDF417Reader());
            list.add((MultiFormatOneDReader)new MaxiCodeReader());
            if (b2) {
                list.add(new MultiFormatOneDReader(hints));
            }
        }
        this.readers = list.toArray(new Reader[list.size()]);
    }
}
