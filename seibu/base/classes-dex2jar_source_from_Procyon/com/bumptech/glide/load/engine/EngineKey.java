// 
// Decompiled by Procyon v0.5.36
// 

package com.bumptech.glide.load.engine;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.Key;

class EngineKey implements Key
{
    private static final String EMPTY_LOG_STRING = "";
    private final ResourceDecoder cacheDecoder;
    private final ResourceDecoder decoder;
    private final ResourceEncoder encoder;
    private int hashCode;
    private final int height;
    private final String id;
    private Key originalKey;
    private final Key signature;
    private final Encoder sourceEncoder;
    private String stringKey;
    private final ResourceTranscoder transcoder;
    private final Transformation transformation;
    private final int width;
    
    public EngineKey(final String id, final Key signature, final int width, final int height, final ResourceDecoder cacheDecoder, final ResourceDecoder decoder, final Transformation transformation, final ResourceEncoder encoder, final ResourceTranscoder transcoder, final Encoder sourceEncoder) {
        this.id = id;
        this.signature = signature;
        this.width = width;
        this.height = height;
        this.cacheDecoder = cacheDecoder;
        this.decoder = decoder;
        this.transformation = transformation;
        this.encoder = encoder;
        this.transcoder = transcoder;
        this.sourceEncoder = sourceEncoder;
    }
    
    @Override
    public boolean equals(final Object o) {
        final boolean b = false;
        boolean b2;
        if (this == o) {
            b2 = true;
        }
        else {
            b2 = b;
            if (o != null) {
                b2 = b;
                if (this.getClass() == o.getClass()) {
                    final EngineKey engineKey = (EngineKey)o;
                    b2 = b;
                    if (this.id.equals(engineKey.id)) {
                        b2 = b;
                        if (this.signature.equals(engineKey.signature)) {
                            b2 = b;
                            if (this.height == engineKey.height) {
                                b2 = b;
                                if (this.width == engineKey.width) {
                                    boolean b3;
                                    if (this.transformation == null) {
                                        b3 = true;
                                    }
                                    else {
                                        b3 = false;
                                    }
                                    boolean b4;
                                    if (engineKey.transformation == null) {
                                        b4 = true;
                                    }
                                    else {
                                        b4 = false;
                                    }
                                    b2 = b;
                                    if (!(b3 ^ b4)) {
                                        if (this.transformation != null) {
                                            b2 = b;
                                            if (!this.transformation.getId().equals(engineKey.transformation.getId())) {
                                                return b2;
                                            }
                                        }
                                        boolean b5;
                                        if (this.decoder == null) {
                                            b5 = true;
                                        }
                                        else {
                                            b5 = false;
                                        }
                                        boolean b6;
                                        if (engineKey.decoder == null) {
                                            b6 = true;
                                        }
                                        else {
                                            b6 = false;
                                        }
                                        b2 = b;
                                        if (!(b5 ^ b6)) {
                                            if (this.decoder != null) {
                                                b2 = b;
                                                if (!this.decoder.getId().equals(engineKey.decoder.getId())) {
                                                    return b2;
                                                }
                                            }
                                            boolean b7;
                                            if (this.cacheDecoder == null) {
                                                b7 = true;
                                            }
                                            else {
                                                b7 = false;
                                            }
                                            boolean b8;
                                            if (engineKey.cacheDecoder == null) {
                                                b8 = true;
                                            }
                                            else {
                                                b8 = false;
                                            }
                                            b2 = b;
                                            if (!(b7 ^ b8)) {
                                                if (this.cacheDecoder != null) {
                                                    b2 = b;
                                                    if (!this.cacheDecoder.getId().equals(engineKey.cacheDecoder.getId())) {
                                                        return b2;
                                                    }
                                                }
                                                boolean b9;
                                                if (this.encoder == null) {
                                                    b9 = true;
                                                }
                                                else {
                                                    b9 = false;
                                                }
                                                boolean b10;
                                                if (engineKey.encoder == null) {
                                                    b10 = true;
                                                }
                                                else {
                                                    b10 = false;
                                                }
                                                b2 = b;
                                                if (!(b9 ^ b10)) {
                                                    if (this.encoder != null) {
                                                        b2 = b;
                                                        if (!this.encoder.getId().equals(engineKey.encoder.getId())) {
                                                            return b2;
                                                        }
                                                    }
                                                    boolean b11;
                                                    if (this.transcoder == null) {
                                                        b11 = true;
                                                    }
                                                    else {
                                                        b11 = false;
                                                    }
                                                    boolean b12;
                                                    if (engineKey.transcoder == null) {
                                                        b12 = true;
                                                    }
                                                    else {
                                                        b12 = false;
                                                    }
                                                    b2 = b;
                                                    if (!(b11 ^ b12)) {
                                                        if (this.transcoder != null) {
                                                            b2 = b;
                                                            if (!this.transcoder.getId().equals(engineKey.transcoder.getId())) {
                                                                return b2;
                                                            }
                                                        }
                                                        boolean b13;
                                                        if (this.sourceEncoder == null) {
                                                            b13 = true;
                                                        }
                                                        else {
                                                            b13 = false;
                                                        }
                                                        boolean b14;
                                                        if (engineKey.sourceEncoder == null) {
                                                            b14 = true;
                                                        }
                                                        else {
                                                            b14 = false;
                                                        }
                                                        b2 = b;
                                                        if (!(b13 ^ b14)) {
                                                            if (this.sourceEncoder != null) {
                                                                b2 = b;
                                                                if (!this.sourceEncoder.getId().equals(engineKey.sourceEncoder.getId())) {
                                                                    return b2;
                                                                }
                                                            }
                                                            return true;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return b2;
    }
    
    public Key getOriginalKey() {
        if (this.originalKey == null) {
            this.originalKey = new OriginalKey(this.id, this.signature);
        }
        return this.originalKey;
    }
    
    @Override
    public int hashCode() {
        final int n = 0;
        if (this.hashCode == 0) {
            this.hashCode = this.id.hashCode();
            this.hashCode = this.hashCode * 31 + this.signature.hashCode();
            this.hashCode = this.hashCode * 31 + this.width;
            this.hashCode = this.hashCode * 31 + this.height;
            final int hashCode = this.hashCode;
            int hashCode2;
            if (this.cacheDecoder != null) {
                hashCode2 = this.cacheDecoder.getId().hashCode();
            }
            else {
                hashCode2 = 0;
            }
            this.hashCode = hashCode2 + hashCode * 31;
            final int hashCode3 = this.hashCode;
            int hashCode4;
            if (this.decoder != null) {
                hashCode4 = this.decoder.getId().hashCode();
            }
            else {
                hashCode4 = 0;
            }
            this.hashCode = hashCode4 + hashCode3 * 31;
            final int hashCode5 = this.hashCode;
            int hashCode6;
            if (this.transformation != null) {
                hashCode6 = this.transformation.getId().hashCode();
            }
            else {
                hashCode6 = 0;
            }
            this.hashCode = hashCode6 + hashCode5 * 31;
            final int hashCode7 = this.hashCode;
            int hashCode8;
            if (this.encoder != null) {
                hashCode8 = this.encoder.getId().hashCode();
            }
            else {
                hashCode8 = 0;
            }
            this.hashCode = hashCode8 + hashCode7 * 31;
            final int hashCode9 = this.hashCode;
            int hashCode10;
            if (this.transcoder != null) {
                hashCode10 = this.transcoder.getId().hashCode();
            }
            else {
                hashCode10 = 0;
            }
            this.hashCode = hashCode10 + hashCode9 * 31;
            final int hashCode11 = this.hashCode;
            int hashCode12 = n;
            if (this.sourceEncoder != null) {
                hashCode12 = this.sourceEncoder.getId().hashCode();
            }
            this.hashCode = hashCode11 * 31 + hashCode12;
        }
        return this.hashCode;
    }
    
    @Override
    public String toString() {
        if (this.stringKey == null) {
            final StringBuilder append = new StringBuilder().append("EngineKey{").append(this.id).append('+').append(this.signature).append("+[").append(this.width).append('x').append(this.height).append("]+").append('\'');
            String id;
            if (this.cacheDecoder != null) {
                id = this.cacheDecoder.getId();
            }
            else {
                id = "";
            }
            final StringBuilder append2 = append.append(id).append('\'').append('+').append('\'');
            String id2;
            if (this.decoder != null) {
                id2 = this.decoder.getId();
            }
            else {
                id2 = "";
            }
            final StringBuilder append3 = append2.append(id2).append('\'').append('+').append('\'');
            String id3;
            if (this.transformation != null) {
                id3 = this.transformation.getId();
            }
            else {
                id3 = "";
            }
            final StringBuilder append4 = append3.append(id3).append('\'').append('+').append('\'');
            String id4;
            if (this.encoder != null) {
                id4 = this.encoder.getId();
            }
            else {
                id4 = "";
            }
            final StringBuilder append5 = append4.append(id4).append('\'').append('+').append('\'');
            String id5;
            if (this.transcoder != null) {
                id5 = this.transcoder.getId();
            }
            else {
                id5 = "";
            }
            final StringBuilder append6 = append5.append(id5).append('\'').append('+').append('\'');
            String id6;
            if (this.sourceEncoder != null) {
                id6 = this.sourceEncoder.getId();
            }
            else {
                id6 = "";
            }
            this.stringKey = append6.append(id6).append('\'').append('}').toString();
        }
        return this.stringKey;
    }
    
    @Override
    public void updateDiskCacheKey(final MessageDigest messageDigest) throws UnsupportedEncodingException {
        final byte[] array = ByteBuffer.allocate(8).putInt(this.width).putInt(this.height).array();
        this.signature.updateDiskCacheKey(messageDigest);
        messageDigest.update(this.id.getBytes("UTF-8"));
        messageDigest.update(array);
        String id;
        if (this.cacheDecoder != null) {
            id = this.cacheDecoder.getId();
        }
        else {
            id = "";
        }
        messageDigest.update(id.getBytes("UTF-8"));
        String id2;
        if (this.decoder != null) {
            id2 = this.decoder.getId();
        }
        else {
            id2 = "";
        }
        messageDigest.update(id2.getBytes("UTF-8"));
        String id3;
        if (this.transformation != null) {
            id3 = this.transformation.getId();
        }
        else {
            id3 = "";
        }
        messageDigest.update(id3.getBytes("UTF-8"));
        String id4;
        if (this.encoder != null) {
            id4 = this.encoder.getId();
        }
        else {
            id4 = "";
        }
        messageDigest.update(id4.getBytes("UTF-8"));
        String id5;
        if (this.sourceEncoder != null) {
            id5 = this.sourceEncoder.getId();
        }
        else {
            id5 = "";
        }
        messageDigest.update(id5.getBytes("UTF-8"));
    }
}
