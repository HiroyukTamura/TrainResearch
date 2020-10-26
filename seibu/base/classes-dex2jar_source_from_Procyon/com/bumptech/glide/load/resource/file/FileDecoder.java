// 
// Decompiled by Procyon v0.5.36
// 

package com.bumptech.glide.load.resource.file;

import java.io.IOException;
import com.bumptech.glide.load.engine.Resource;
import java.io.File;
import com.bumptech.glide.load.ResourceDecoder;

public class FileDecoder implements ResourceDecoder<File, File>
{
    @Override
    public Resource<File> decode(final File file, final int n, final int n2) {
        return new FileResource(file);
    }
    
    @Override
    public String getId() {
        return "";
    }
}
