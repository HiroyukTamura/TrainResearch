// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;

public abstract class AbstractExpandedDecoder
{
    private final GeneralAppIdDecoder generalDecoder;
    private final BitArray information;
    
    AbstractExpandedDecoder(final BitArray information) {
        this.information = information;
        this.generalDecoder = new GeneralAppIdDecoder(information);
    }
    
    public static AbstractExpandedDecoder createDecoder(final BitArray obj) {
        if (obj.get(1)) {
            return new AI01AndOtherAIs(obj);
        }
        if (!obj.get(2)) {
            return new AnyAIDecoder(obj);
        }
        switch (GeneralAppIdDecoder.extractNumericValueFromBitArray(obj, 1, 4)) {
            default: {
                switch (GeneralAppIdDecoder.extractNumericValueFromBitArray(obj, 1, 5)) {
                    default: {
                        switch (GeneralAppIdDecoder.extractNumericValueFromBitArray(obj, 1, 7)) {
                            default: {
                                throw new IllegalStateException("unknown decoder: " + obj);
                            }
                            case 56: {
                                return new AI013x0x1xDecoder(obj, "310", "11");
                            }
                            case 57: {
                                return new AI013x0x1xDecoder(obj, "320", "11");
                            }
                            case 58: {
                                return new AI013x0x1xDecoder(obj, "310", "13");
                            }
                            case 59: {
                                return new AI013x0x1xDecoder(obj, "320", "13");
                            }
                            case 60: {
                                return new AI013x0x1xDecoder(obj, "310", "15");
                            }
                            case 61: {
                                return new AI013x0x1xDecoder(obj, "320", "15");
                            }
                            case 62: {
                                return new AI013x0x1xDecoder(obj, "310", "17");
                            }
                            case 63: {
                                return new AI013x0x1xDecoder(obj, "320", "17");
                            }
                        }
                        break;
                    }
                    case 12: {
                        return new AI01392xDecoder(obj);
                    }
                    case 13: {
                        return new AI01393xDecoder(obj);
                    }
                }
                break;
            }
            case 4: {
                return new AI013103decoder(obj);
            }
            case 5: {
                return new AI01320xDecoder(obj);
            }
        }
    }
    
    protected final GeneralAppIdDecoder getGeneralDecoder() {
        return this.generalDecoder;
    }
    
    protected final BitArray getInformation() {
        return this.information;
    }
    
    public abstract String parseInformation() throws NotFoundException, FormatException;
}
