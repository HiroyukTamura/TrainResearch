// 
// Decompiled by Procyon v0.5.36
// 

package com.bumptech.glide;

import com.bumptech.glide.request.target.Target;
import java.io.File;
import com.bumptech.glide.request.FutureTarget;

interface DownloadOptions
{
    FutureTarget<File> downloadOnly(final int p0, final int p1);
    
     <Y extends Target<File>> Y downloadOnly(final Y p0);
}
