// 
// Decompiled by Procyon v0.5.36
// 

package com.bumptech.glide.load.resource.gifbitmap;

import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import com.bumptech.glide.util.ByteArrayPool;
import com.bumptech.glide.load.resource.bitmap.ImageHeaderParser;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import com.bumptech.glide.load.engine.Resource;
import java.io.IOException;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import java.io.InputStream;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import android.graphics.Bitmap;
import com.bumptech.glide.load.model.ImageVideoWrapper;
import com.bumptech.glide.load.ResourceDecoder;

public class GifBitmapWrapperResourceDecoder implements ResourceDecoder<ImageVideoWrapper, GifBitmapWrapper>
{
    private static final ImageTypeParser DEFAULT_PARSER;
    private static final BufferedStreamFactory DEFAULT_STREAM_FACTORY;
    static final int MARK_LIMIT_BYTES = 2048;
    private final ResourceDecoder<ImageVideoWrapper, Bitmap> bitmapDecoder;
    private final BitmapPool bitmapPool;
    private final ResourceDecoder<InputStream, GifDrawable> gifDecoder;
    private String id;
    private final ImageTypeParser parser;
    private final BufferedStreamFactory streamFactory;
    
    static {
        DEFAULT_PARSER = new ImageTypeParser();
        DEFAULT_STREAM_FACTORY = new BufferedStreamFactory();
    }
    
    public GifBitmapWrapperResourceDecoder(final ResourceDecoder<ImageVideoWrapper, Bitmap> resourceDecoder, final ResourceDecoder<InputStream, GifDrawable> resourceDecoder2, final BitmapPool bitmapPool) {
        this(resourceDecoder, resourceDecoder2, bitmapPool, GifBitmapWrapperResourceDecoder.DEFAULT_PARSER, GifBitmapWrapperResourceDecoder.DEFAULT_STREAM_FACTORY);
    }
    
    GifBitmapWrapperResourceDecoder(final ResourceDecoder<ImageVideoWrapper, Bitmap> bitmapDecoder, final ResourceDecoder<InputStream, GifDrawable> gifDecoder, final BitmapPool bitmapPool, final ImageTypeParser parser, final BufferedStreamFactory streamFactory) {
        this.bitmapDecoder = bitmapDecoder;
        this.gifDecoder = gifDecoder;
        this.bitmapPool = bitmapPool;
        this.parser = parser;
        this.streamFactory = streamFactory;
    }
    
    private GifBitmapWrapper decode(final ImageVideoWrapper imageVideoWrapper, final int n, final int n2, final byte[] array) throws IOException {
        if (imageVideoWrapper.getStream() != null) {
            return this.decodeStream(imageVideoWrapper, n, n2, array);
        }
        return this.decodeBitmapWrapper(imageVideoWrapper, n, n2);
    }
    
    private GifBitmapWrapper decodeBitmapWrapper(final ImageVideoWrapper imageVideoWrapper, final int n, final int n2) throws IOException {
        final GifBitmapWrapper gifBitmapWrapper = null;
        final Resource<Bitmap> decode = this.bitmapDecoder.decode(imageVideoWrapper, n, n2);
        GifBitmapWrapper gifBitmapWrapper2 = gifBitmapWrapper;
        if (decode != null) {
            gifBitmapWrapper2 = new GifBitmapWrapper(decode, null);
        }
        return gifBitmapWrapper2;
    }
    
    private GifBitmapWrapper decodeGifWrapper(final InputStream inputStream, final int n, final int n2) throws IOException {
        final GifBitmapWrapper gifBitmapWrapper = null;
        final Resource<GifDrawable> decode = this.gifDecoder.decode(inputStream, n, n2);
        GifBitmapWrapper gifBitmapWrapper2 = gifBitmapWrapper;
        if (decode != null) {
            final GifDrawable gifDrawable = decode.get();
            if (gifDrawable.getFrameCount() <= 1) {
                return new GifBitmapWrapper(new BitmapResource(gifDrawable.getFirstFrame(), this.bitmapPool), null);
            }
            gifBitmapWrapper2 = new GifBitmapWrapper(null, decode);
        }
        return gifBitmapWrapper2;
    }
    
    private GifBitmapWrapper decodeStream(final ImageVideoWrapper imageVideoWrapper, final int n, final int n2, final byte[] array) throws IOException {
        final InputStream build = this.streamFactory.build(imageVideoWrapper.getStream(), array);
        build.mark(2048);
        final ImageHeaderParser.ImageType parse = this.parser.parse(build);
        build.reset();
        GifBitmapWrapper decodeGifWrapper = null;
        if (parse == ImageHeaderParser.ImageType.GIF) {
            decodeGifWrapper = this.decodeGifWrapper(build, n, n2);
        }
        GifBitmapWrapper decodeBitmapWrapper;
        if ((decodeBitmapWrapper = decodeGifWrapper) == null) {
            decodeBitmapWrapper = this.decodeBitmapWrapper(new ImageVideoWrapper(build, imageVideoWrapper.getFileDescriptor()), n, n2);
        }
        return decodeBitmapWrapper;
    }
    
    @Override
    public Resource<GifBitmapWrapper> decode(final ImageVideoWrapper imageVideoWrapper, final int n, final int n2) throws IOException {
        final ByteArrayPool value = ByteArrayPool.get();
        final byte[] bytes = value.getBytes();
        try {
            final GifBitmapWrapper decode = this.decode(imageVideoWrapper, n, n2, bytes);
            value.releaseBytes(bytes);
            if (decode != null) {
                return new GifBitmapWrapperResource(decode);
            }
        }
        finally {
            value.releaseBytes(bytes);
        }
        return null;
    }
    
    @Override
    public String getId() {
        if (this.id == null) {
            this.id = this.gifDecoder.getId() + this.bitmapDecoder.getId();
        }
        return this.id;
    }
    
    static class BufferedStreamFactory
    {
        public InputStream build(final InputStream inputStream, final byte[] array) {
            return new RecyclableBufferedInputStream(inputStream, array);
        }
    }
    
    static class ImageTypeParser
    {
        public ImageHeaderParser.ImageType parse(final InputStream inputStream) throws IOException {
            return new ImageHeaderParser(inputStream).getType();
        }
    }
}
