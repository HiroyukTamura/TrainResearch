// 
// Decompiled by Procyon v0.5.36
// 

package com.bumptech.glide.load.model;

import android.net.Uri;

final class AssetUriParser
{
    private static final String ASSET_PATH_SEGMENT = "android_asset";
    private static final String ASSET_PREFIX = "file:///android_asset/";
    private static final int ASSET_PREFIX_LENGTH;
    
    static {
        ASSET_PREFIX_LENGTH = "file:///android_asset/".length();
    }
    
    private AssetUriParser() {
    }
    
    public static boolean isAssetUri(final Uri uri) {
        boolean b2;
        final boolean b = b2 = false;
        if ("file".equals(uri.getScheme())) {
            b2 = b;
            if (!uri.getPathSegments().isEmpty()) {
                b2 = b;
                if ("android_asset".equals(uri.getPathSegments().get(0))) {
                    b2 = true;
                }
            }
        }
        return b2;
    }
    
    public static String toAssetPath(final Uri uri) {
        return uri.toString().substring(AssetUriParser.ASSET_PREFIX_LENGTH);
    }
}
