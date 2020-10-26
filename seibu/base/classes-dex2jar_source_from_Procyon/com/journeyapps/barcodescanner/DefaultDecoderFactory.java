// 
// Decompiled by Procyon v0.5.36
// 

package com.journeyapps.barcodescanner;

import com.google.zxing.Reader;
import com.google.zxing.MultiFormatReader;
import java.util.EnumMap;
import com.google.zxing.DecodeHintType;
import java.util.Map;
import com.google.zxing.BarcodeFormat;
import java.util.Collection;

public class DefaultDecoderFactory implements DecoderFactory
{
    private String characterSet;
    private Collection<BarcodeFormat> decodeFormats;
    private Map<DecodeHintType, ?> hints;
    private int scanType;
    
    public DefaultDecoderFactory() {
    }
    
    public DefaultDecoderFactory(final Collection<BarcodeFormat> decodeFormats) {
        this.decodeFormats = decodeFormats;
    }
    
    public DefaultDecoderFactory(final Collection<BarcodeFormat> decodeFormats, final Map<DecodeHintType, ?> hints, final String characterSet, final int scanType) {
        this.decodeFormats = decodeFormats;
        this.hints = hints;
        this.characterSet = characterSet;
        this.scanType = scanType;
    }
    
    @Override
    public Decoder createDecoder(final Map<DecodeHintType, ?> map) {
        final EnumMap<DecodeHintType, String> hints = new EnumMap<DecodeHintType, String>(DecodeHintType.class);
        hints.putAll((Map<?, ?>)map);
        if (this.hints != null) {
            hints.putAll((Map<?, ?>)this.hints);
        }
        if (this.decodeFormats != null) {
            hints.put(DecodeHintType.POSSIBLE_FORMATS, (String)this.decodeFormats);
        }
        if (this.characterSet != null) {
            hints.put(DecodeHintType.CHARACTER_SET, this.characterSet);
        }
        final MultiFormatReader multiFormatReader = new MultiFormatReader();
        multiFormatReader.setHints(hints);
        switch (this.scanType) {
            default: {
                return new Decoder(multiFormatReader);
            }
            case 0: {
                return new Decoder(multiFormatReader);
            }
            case 1: {
                return new InvertedDecoder(multiFormatReader);
            }
            case 2: {
                return new MixedDecoder(multiFormatReader);
            }
        }
    }
}
