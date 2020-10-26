// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.client.result;

import com.google.zxing.oned.UPCEReader;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.Result;

public final class ProductResultParser extends ResultParser
{
    @Override
    public ProductParsedResult parse(final Result result) {
        final BarcodeFormat barcodeFormat = result.getBarcodeFormat();
        if (barcodeFormat == BarcodeFormat.UPC_A || barcodeFormat == BarcodeFormat.UPC_E || barcodeFormat == BarcodeFormat.EAN_8 || barcodeFormat == BarcodeFormat.EAN_13) {
            final String massagedText = ResultParser.getMassagedText(result);
            if (ResultParser.isStringOfDigits(massagedText, massagedText.length())) {
                String convertUPCEtoUPCA;
                if (barcodeFormat == BarcodeFormat.UPC_E && massagedText.length() == 8) {
                    convertUPCEtoUPCA = UPCEReader.convertUPCEtoUPCA(massagedText);
                }
                else {
                    convertUPCEtoUPCA = massagedText;
                }
                return new ProductParsedResult(massagedText, convertUPCEtoUPCA);
            }
        }
        return null;
    }
}
