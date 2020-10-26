// 
// Decompiled by Procyon v0.5.36
// 

package com.bumptech.glide.load.data;

import java.io.IOException;
import android.content.res.AssetManager;
import java.io.InputStream;

public class StreamAssetPathFetcher extends AssetPathFetcher<InputStream>
{
    public StreamAssetPathFetcher(final AssetManager assetManager, final String s) {
        super(assetManager, s);
    }
    
    @Override
    protected void close(final InputStream inputStream) throws IOException {
        inputStream.close();
    }
    
    @Override
    protected InputStream loadResource(final AssetManager assetManager, final String s) throws IOException {
        return assetManager.open(s);
    }
}
