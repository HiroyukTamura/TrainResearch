// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing;

import java.util.List;

public enum DecodeHintType
{
    ALLOWED_EAN_EXTENSIONS((Class<?>)int[].class), 
    ALLOWED_LENGTHS((Class<?>)int[].class), 
    ASSUME_CODE_39_CHECK_DIGIT((Class<?>)Void.class), 
    ASSUME_GS1((Class<?>)Void.class), 
    CHARACTER_SET((Class<?>)String.class), 
    NEED_RESULT_POINT_CALLBACK((Class<?>)ResultPointCallback.class), 
    OTHER((Class<?>)Object.class), 
    POSSIBLE_FORMATS((Class<?>)List.class), 
    PURE_BARCODE((Class<?>)Void.class), 
    RETURN_CODABAR_START_END((Class<?>)Void.class), 
    TRY_HARDER((Class<?>)Void.class);
    
    private final Class<?> valueType;
    
    private DecodeHintType(final Class<?> valueType) {
        this.valueType = valueType;
    }
    
    public Class<?> getValueType() {
        return this.valueType;
    }
}
