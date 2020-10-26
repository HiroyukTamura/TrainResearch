// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.oned;

import com.google.zxing.ChecksumException;
import com.google.zxing.common.BitArray;
import com.google.zxing.DecodeHintType;
import java.util.Map;
import com.google.zxing.NotFoundException;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.FormatException;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.Result;

public final class UPCAReader extends UPCEANReader
{
    private final UPCEANReader ean13Reader;
    
    public UPCAReader() {
        this.ean13Reader = new EAN13Reader();
    }
    
    private static Result maybeReturnResult(final Result result) throws FormatException {
        final String text = result.getText();
        if (text.charAt(0) == '0') {
            return new Result(text.substring(1), null, result.getResultPoints(), BarcodeFormat.UPC_A);
        }
        throw FormatException.getFormatInstance();
    }
    
    @Override
    public Result decode(final BinaryBitmap binaryBitmap) throws NotFoundException, FormatException {
        return maybeReturnResult(this.ean13Reader.decode(binaryBitmap));
    }
    
    @Override
    public Result decode(final BinaryBitmap binaryBitmap, final Map<DecodeHintType, ?> map) throws NotFoundException, FormatException {
        return maybeReturnResult(this.ean13Reader.decode(binaryBitmap, map));
    }
    
    @Override
    protected int decodeMiddle(final BitArray bitArray, final int[] array, final StringBuilder sb) throws NotFoundException {
        return this.ean13Reader.decodeMiddle(bitArray, array, sb);
    }
    
    @Override
    public Result decodeRow(final int n, final BitArray bitArray, final Map<DecodeHintType, ?> map) throws NotFoundException, FormatException, ChecksumException {
        return maybeReturnResult(this.ean13Reader.decodeRow(n, bitArray, map));
    }
    
    @Override
    public Result decodeRow(final int n, final BitArray bitArray, final int[] array, final Map<DecodeHintType, ?> map) throws NotFoundException, FormatException, ChecksumException {
        return maybeReturnResult(this.ean13Reader.decodeRow(n, bitArray, array, map));
    }
    
    @Override
    BarcodeFormat getBarcodeFormat() {
        return BarcodeFormat.UPC_A;
    }
}
