// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.net;

import com.google.common.collect.ListMultimap;
import com.google.common.collect.Multimaps;
import com.google.common.base.Objects;
import javax.annotation.Nullable;
import com.google.common.collect.Iterables;
import com.google.common.collect.ImmutableSet;
import java.nio.charset.Charset;
import com.google.common.base.Optional;
import java.util.Collection;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableMultiset;
import java.util.Iterator;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Multimap;
import com.google.common.collect.Maps;
import com.google.common.base.Ascii;
import com.google.common.base.Charsets;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.base.Joiner;
import com.google.common.base.CharMatcher;
import java.util.Map;
import javax.annotation.concurrent.Immutable;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.Beta;

@Beta
@GwtCompatible
@Immutable
public final class MediaType
{
    public static final MediaType ANY_APPLICATION_TYPE;
    public static final MediaType ANY_AUDIO_TYPE;
    public static final MediaType ANY_IMAGE_TYPE;
    public static final MediaType ANY_TEXT_TYPE;
    public static final MediaType ANY_TYPE;
    public static final MediaType ANY_VIDEO_TYPE;
    public static final MediaType APPLE_MOBILE_CONFIG;
    public static final MediaType APPLICATION_BINARY;
    private static final String APPLICATION_TYPE = "application";
    public static final MediaType APPLICATION_XML_UTF_8;
    public static final MediaType ATOM_UTF_8;
    private static final String AUDIO_TYPE = "audio";
    public static final MediaType BMP;
    public static final MediaType BZIP2;
    public static final MediaType CACHE_MANIFEST_UTF_8;
    private static final String CHARSET_ATTRIBUTE = "charset";
    public static final MediaType CRW;
    public static final MediaType CSS_UTF_8;
    public static final MediaType CSV_UTF_8;
    public static final MediaType EOT;
    public static final MediaType EPUB;
    public static final MediaType FORM_DATA;
    public static final MediaType GIF;
    public static final MediaType GZIP;
    public static final MediaType HTML_UTF_8;
    public static final MediaType ICO;
    private static final String IMAGE_TYPE = "image";
    public static final MediaType I_CALENDAR_UTF_8;
    public static final MediaType JAVASCRIPT_UTF_8;
    public static final MediaType JPEG;
    public static final MediaType JSON_UTF_8;
    public static final MediaType KEY_ARCHIVE;
    public static final MediaType KML;
    public static final MediaType KMZ;
    private static final Map<MediaType, MediaType> KNOWN_TYPES;
    private static final CharMatcher LINEAR_WHITE_SPACE;
    public static final MediaType MBOX;
    public static final MediaType MICROSOFT_EXCEL;
    public static final MediaType MICROSOFT_POWERPOINT;
    public static final MediaType MICROSOFT_WORD;
    public static final MediaType MP4_AUDIO;
    public static final MediaType MP4_VIDEO;
    public static final MediaType MPEG_AUDIO;
    public static final MediaType MPEG_VIDEO;
    public static final MediaType OCTET_STREAM;
    public static final MediaType OGG_AUDIO;
    public static final MediaType OGG_CONTAINER;
    public static final MediaType OGG_VIDEO;
    public static final MediaType OOXML_DOCUMENT;
    public static final MediaType OOXML_PRESENTATION;
    public static final MediaType OOXML_SHEET;
    public static final MediaType OPENDOCUMENT_GRAPHICS;
    public static final MediaType OPENDOCUMENT_PRESENTATION;
    public static final MediaType OPENDOCUMENT_SPREADSHEET;
    public static final MediaType OPENDOCUMENT_TEXT;
    private static final Joiner.MapJoiner PARAMETER_JOINER;
    public static final MediaType PDF;
    public static final MediaType PLAIN_TEXT_UTF_8;
    public static final MediaType PNG;
    public static final MediaType POSTSCRIPT;
    public static final MediaType PROTOBUF;
    public static final MediaType PSD;
    public static final MediaType QUICKTIME;
    private static final CharMatcher QUOTED_TEXT_MATCHER;
    public static final MediaType RDF_XML_UTF_8;
    public static final MediaType RTF_UTF_8;
    public static final MediaType SFNT;
    public static final MediaType SHOCKWAVE_FLASH;
    public static final MediaType SKETCHUP;
    public static final MediaType SVG_UTF_8;
    public static final MediaType TAR;
    public static final MediaType TEXT_JAVASCRIPT_UTF_8;
    private static final String TEXT_TYPE = "text";
    public static final MediaType TIFF;
    private static final CharMatcher TOKEN_MATCHER;
    public static final MediaType TSV_UTF_8;
    private static final ImmutableListMultimap<String, String> UTF_8_CONSTANT_PARAMETERS;
    public static final MediaType VCARD_UTF_8;
    private static final String VIDEO_TYPE = "video";
    public static final MediaType WEBM_AUDIO;
    public static final MediaType WEBM_VIDEO;
    public static final MediaType WEBP;
    private static final String WILDCARD = "*";
    public static final MediaType WML_UTF_8;
    public static final MediaType WMV;
    public static final MediaType WOFF;
    public static final MediaType XHTML_UTF_8;
    public static final MediaType XML_UTF_8;
    public static final MediaType XRD_UTF_8;
    public static final MediaType ZIP;
    private final ImmutableListMultimap<String, String> parameters;
    private final String subtype;
    private final String type;
    
    static {
        UTF_8_CONSTANT_PARAMETERS = ImmutableListMultimap.of("charset", Ascii.toLowerCase(Charsets.UTF_8.name()));
        TOKEN_MATCHER = CharMatcher.ASCII.and(CharMatcher.JAVA_ISO_CONTROL.negate()).and(CharMatcher.isNot(' ')).and(CharMatcher.noneOf("()<>@,;:\\\"/[]?="));
        QUOTED_TEXT_MATCHER = CharMatcher.ASCII.and(CharMatcher.noneOf("\"\\\r"));
        LINEAR_WHITE_SPACE = CharMatcher.anyOf(" \t\r\n");
        KNOWN_TYPES = Maps.newHashMap();
        ANY_TYPE = createConstant("*", "*");
        ANY_TEXT_TYPE = createConstant("text", "*");
        ANY_IMAGE_TYPE = createConstant("image", "*");
        ANY_AUDIO_TYPE = createConstant("audio", "*");
        ANY_VIDEO_TYPE = createConstant("video", "*");
        ANY_APPLICATION_TYPE = createConstant("application", "*");
        CACHE_MANIFEST_UTF_8 = createConstantUtf8("text", "cache-manifest");
        CSS_UTF_8 = createConstantUtf8("text", "css");
        CSV_UTF_8 = createConstantUtf8("text", "csv");
        HTML_UTF_8 = createConstantUtf8("text", "html");
        I_CALENDAR_UTF_8 = createConstantUtf8("text", "calendar");
        PLAIN_TEXT_UTF_8 = createConstantUtf8("text", "plain");
        TEXT_JAVASCRIPT_UTF_8 = createConstantUtf8("text", "javascript");
        TSV_UTF_8 = createConstantUtf8("text", "tab-separated-values");
        VCARD_UTF_8 = createConstantUtf8("text", "vcard");
        WML_UTF_8 = createConstantUtf8("text", "vnd.wap.wml");
        XML_UTF_8 = createConstantUtf8("text", "xml");
        BMP = createConstant("image", "bmp");
        CRW = createConstant("image", "x-canon-crw");
        GIF = createConstant("image", "gif");
        ICO = createConstant("image", "vnd.microsoft.icon");
        JPEG = createConstant("image", "jpeg");
        PNG = createConstant("image", "png");
        PSD = createConstant("image", "vnd.adobe.photoshop");
        SVG_UTF_8 = createConstantUtf8("image", "svg+xml");
        TIFF = createConstant("image", "tiff");
        WEBP = createConstant("image", "webp");
        MP4_AUDIO = createConstant("audio", "mp4");
        MPEG_AUDIO = createConstant("audio", "mpeg");
        OGG_AUDIO = createConstant("audio", "ogg");
        WEBM_AUDIO = createConstant("audio", "webm");
        MP4_VIDEO = createConstant("video", "mp4");
        MPEG_VIDEO = createConstant("video", "mpeg");
        OGG_VIDEO = createConstant("video", "ogg");
        QUICKTIME = createConstant("video", "quicktime");
        WEBM_VIDEO = createConstant("video", "webm");
        WMV = createConstant("video", "x-ms-wmv");
        APPLICATION_XML_UTF_8 = createConstantUtf8("application", "xml");
        ATOM_UTF_8 = createConstantUtf8("application", "atom+xml");
        BZIP2 = createConstant("application", "x-bzip2");
        EOT = createConstant("application", "vnd.ms-fontobject");
        EPUB = createConstant("application", "epub+zip");
        FORM_DATA = createConstant("application", "x-www-form-urlencoded");
        KEY_ARCHIVE = createConstant("application", "pkcs12");
        APPLICATION_BINARY = createConstant("application", "binary");
        GZIP = createConstant("application", "x-gzip");
        JAVASCRIPT_UTF_8 = createConstantUtf8("application", "javascript");
        JSON_UTF_8 = createConstantUtf8("application", "json");
        KML = createConstant("application", "vnd.google-earth.kml+xml");
        KMZ = createConstant("application", "vnd.google-earth.kmz");
        MBOX = createConstant("application", "mbox");
        APPLE_MOBILE_CONFIG = createConstant("application", "x-apple-aspen-config");
        MICROSOFT_EXCEL = createConstant("application", "vnd.ms-excel");
        MICROSOFT_POWERPOINT = createConstant("application", "vnd.ms-powerpoint");
        MICROSOFT_WORD = createConstant("application", "msword");
        OCTET_STREAM = createConstant("application", "octet-stream");
        OGG_CONTAINER = createConstant("application", "ogg");
        OOXML_DOCUMENT = createConstant("application", "vnd.openxmlformats-officedocument.wordprocessingml.document");
        OOXML_PRESENTATION = createConstant("application", "vnd.openxmlformats-officedocument.presentationml.presentation");
        OOXML_SHEET = createConstant("application", "vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        OPENDOCUMENT_GRAPHICS = createConstant("application", "vnd.oasis.opendocument.graphics");
        OPENDOCUMENT_PRESENTATION = createConstant("application", "vnd.oasis.opendocument.presentation");
        OPENDOCUMENT_SPREADSHEET = createConstant("application", "vnd.oasis.opendocument.spreadsheet");
        OPENDOCUMENT_TEXT = createConstant("application", "vnd.oasis.opendocument.text");
        PDF = createConstant("application", "pdf");
        POSTSCRIPT = createConstant("application", "postscript");
        PROTOBUF = createConstant("application", "protobuf");
        RDF_XML_UTF_8 = createConstantUtf8("application", "rdf+xml");
        RTF_UTF_8 = createConstantUtf8("application", "rtf");
        SFNT = createConstant("application", "font-sfnt");
        SHOCKWAVE_FLASH = createConstant("application", "x-shockwave-flash");
        SKETCHUP = createConstant("application", "vnd.sketchup.skp");
        TAR = createConstant("application", "x-tar");
        WOFF = createConstant("application", "font-woff");
        XHTML_UTF_8 = createConstantUtf8("application", "xhtml+xml");
        XRD_UTF_8 = createConstantUtf8("application", "xrd+xml");
        ZIP = createConstant("application", "zip");
        PARAMETER_JOINER = Joiner.on("; ").withKeyValueSeparator("=");
    }
    
    private MediaType(final String type, final String subtype, final ImmutableListMultimap<String, String> parameters) {
        this.type = type;
        this.subtype = subtype;
        this.parameters = parameters;
    }
    
    private static MediaType addKnownType(final MediaType mediaType) {
        MediaType.KNOWN_TYPES.put(mediaType, mediaType);
        return mediaType;
    }
    
    public static MediaType create(final String s, final String s2) {
        return create(s, s2, (Multimap<String, String>)ImmutableListMultimap.of());
    }
    
    private static MediaType create(String normalizeToken, String normalizeToken2, final Multimap<String, String> multimap) {
        Preconditions.checkNotNull(normalizeToken);
        Preconditions.checkNotNull(normalizeToken2);
        Preconditions.checkNotNull(multimap);
        normalizeToken = normalizeToken(normalizeToken);
        normalizeToken2 = normalizeToken(normalizeToken2);
        Preconditions.checkArgument(!"*".equals(normalizeToken) || "*".equals(normalizeToken2), (Object)"A wildcard type cannot be used with a non-wildcard subtype");
        final ImmutableListMultimap.Builder<String, String> builder = ImmutableListMultimap.builder();
        for (final Map.Entry<String, String> entry : multimap.entries()) {
            final String normalizeToken3 = normalizeToken(entry.getKey());
            builder.put(normalizeToken3, normalizeParameterValue(normalizeToken3, entry.getValue()));
        }
        final MediaType mediaType = new MediaType(normalizeToken, normalizeToken2, builder.build());
        return MoreObjects.firstNonNull(MediaType.KNOWN_TYPES.get(mediaType), mediaType);
    }
    
    static MediaType createApplicationType(final String s) {
        return create("application", s);
    }
    
    static MediaType createAudioType(final String s) {
        return create("audio", s);
    }
    
    private static MediaType createConstant(final String s, final String s2) {
        return addKnownType(new MediaType(s, s2, ImmutableListMultimap.of()));
    }
    
    private static MediaType createConstantUtf8(final String s, final String s2) {
        return addKnownType(new MediaType(s, s2, MediaType.UTF_8_CONSTANT_PARAMETERS));
    }
    
    static MediaType createImageType(final String s) {
        return create("image", s);
    }
    
    static MediaType createTextType(final String s) {
        return create("text", s);
    }
    
    static MediaType createVideoType(final String s) {
        return create("video", s);
    }
    
    private static String escapeAndQuote(final String s) {
        final StringBuilder append = new StringBuilder(s.length() + 16).append('\"');
        final char[] charArray = s.toCharArray();
        for (int length = charArray.length, i = 0; i < length; ++i) {
            final char c = charArray[i];
            if (c == '\r' || c == '\\' || c == '\"') {
                append.append('\\');
            }
            append.append(c);
        }
        return append.append('\"').toString();
    }
    
    private static String normalizeParameterValue(final String anObject, final String s) {
        String lowerCase = s;
        if ("charset".equals(anObject)) {
            lowerCase = Ascii.toLowerCase(s);
        }
        return lowerCase;
    }
    
    private static String normalizeToken(final String s) {
        Preconditions.checkArgument(MediaType.TOKEN_MATCHER.matchesAllOf(s));
        return Ascii.toLowerCase(s);
    }
    
    private Map<String, ImmutableMultiset<String>> parametersAsMap() {
        return Maps.transformValues((Map<String, Collection<Object>>)this.parameters.asMap(), (Function<? super Collection<Object>, ImmutableMultiset<String>>)new Function<Collection<String>, ImmutableMultiset<String>>() {
            @Override
            public ImmutableMultiset<String> apply(final Collection<String> collection) {
                return ImmutableMultiset.copyOf((Iterable<? extends String>)collection);
            }
        });
    }
    
    public static MediaType parse(String value) {
        String consumeToken = null;
        String consumeToken2 = null;
        ImmutableListMultimap.Builder<String, String> builder = null;
    Label_0223_Outer:
        while (true) {
            Preconditions.checkNotNull(value);
            final Tokenizer tokenizer = new Tokenizer(value);
            while (true) {
            Label_0105_Outer:
                while (true) {
                    String consumeToken3 = null;
                    StringBuilder sb = null;
                Label_0211:
                    while (true) {
                        Label_0196: {
                            try {
                                consumeToken = tokenizer.consumeToken(MediaType.TOKEN_MATCHER);
                                tokenizer.consumeCharacter('/');
                                consumeToken2 = tokenizer.consumeToken(MediaType.TOKEN_MATCHER);
                                builder = ImmutableListMultimap.builder();
                                if (!tokenizer.hasMore()) {
                                    break;
                                }
                                tokenizer.consumeCharacter(';');
                                tokenizer.consumeTokenIfPresent(MediaType.LINEAR_WHITE_SPACE);
                                consumeToken3 = tokenizer.consumeToken(MediaType.TOKEN_MATCHER);
                                tokenizer.consumeCharacter('=');
                                if ('\"' == tokenizer.previewChar()) {
                                    tokenizer.consumeCharacter('\"');
                                    sb = new StringBuilder();
                                    while ('\"' != tokenizer.previewChar()) {
                                        if ('\\' != tokenizer.previewChar()) {
                                            break Label_0196;
                                        }
                                        tokenizer.consumeCharacter('\\');
                                        sb.append(tokenizer.consumeCharacter(CharMatcher.ASCII));
                                    }
                                    break Label_0211;
                                }
                                break Label_0105_Outer;
                            }
                            catch (IllegalStateException cause) {
                                value = String.valueOf(String.valueOf(value));
                                throw new IllegalArgumentException(new StringBuilder(value.length() + 18).append("Could not parse '").append(value).append("'").toString(), cause);
                            }
                        }
                        sb.append(tokenizer.consumeToken(MediaType.QUOTED_TEXT_MATCHER));
                        continue Label_0223_Outer;
                    }
                    final String s = sb.toString();
                    tokenizer.consumeCharacter('\"');
                    builder.put(consumeToken3, s);
                    continue Label_0105_Outer;
                }
                final String s = tokenizer.consumeToken(MediaType.TOKEN_MATCHER);
                continue;
            }
        }
        return create(consumeToken, consumeToken2, builder.build());
    }
    
    public Optional<Charset> charset() {
        final ImmutableSet<String> copy = (ImmutableSet<String>)ImmutableSet.copyOf((Collection<?>)this.parameters.get("charset"));
        switch (copy.size()) {
            default: {
                final String value = String.valueOf(String.valueOf(copy));
                throw new IllegalStateException(new StringBuilder(value.length() + 33).append("Multiple charset values defined: ").append(value).toString());
            }
            case 0: {
                return Optional.absent();
            }
            case 1: {
                return Optional.of(Charset.forName(Iterables.getOnlyElement(copy)));
            }
        }
    }
    
    @Override
    public boolean equals(@Nullable final Object o) {
        if (o != this) {
            if (!(o instanceof MediaType)) {
                return false;
            }
            final MediaType mediaType = (MediaType)o;
            if (!this.type.equals(mediaType.type) || !this.subtype.equals(mediaType.subtype) || !this.parametersAsMap().equals(mediaType.parametersAsMap())) {
                return false;
            }
        }
        return true;
    }
    
    public boolean hasWildcard() {
        return "*".equals(this.type) || "*".equals(this.subtype);
    }
    
    @Override
    public int hashCode() {
        return Objects.hashCode(this.type, this.subtype, this.parametersAsMap());
    }
    
    public boolean is(final MediaType mediaType) {
        return (mediaType.type.equals("*") || mediaType.type.equals(this.type)) && (mediaType.subtype.equals("*") || mediaType.subtype.equals(this.subtype)) && this.parameters.entries().containsAll(mediaType.parameters.entries());
    }
    
    public ImmutableListMultimap<String, String> parameters() {
        return this.parameters;
    }
    
    public String subtype() {
        return this.subtype;
    }
    
    @Override
    public String toString() {
        final StringBuilder append = new StringBuilder().append(this.type).append('/').append(this.subtype);
        if (!this.parameters.isEmpty()) {
            append.append("; ");
            MediaType.PARAMETER_JOINER.appendTo(append, (Iterable<? extends Map.Entry<?, ?>>)Multimaps.transformValues(this.parameters, (Function<? super String, Object>)new Function<String, String>() {
                @Override
                public String apply(final String s) {
                    if (MediaType.TOKEN_MATCHER.matchesAllOf(s)) {
                        return s;
                    }
                    return escapeAndQuote(s);
                }
            }).entries());
        }
        return append.toString();
    }
    
    public String type() {
        return this.type;
    }
    
    public MediaType withCharset(final Charset charset) {
        Preconditions.checkNotNull(charset);
        return this.withParameter("charset", charset.name());
    }
    
    public MediaType withParameter(String normalizeToken, final String s) {
        Preconditions.checkNotNull(normalizeToken);
        Preconditions.checkNotNull(s);
        normalizeToken = normalizeToken(normalizeToken);
        final ImmutableListMultimap.Builder<String, V> builder = ImmutableListMultimap.builder();
        for (final Map.Entry<String, V> entry : this.parameters.entries()) {
            final String anObject = entry.getKey();
            if (!normalizeToken.equals(anObject)) {
                builder.put(anObject, entry.getValue());
            }
        }
        builder.put(normalizeToken, (V)normalizeParameterValue(normalizeToken, s));
        final MediaType mediaType = new MediaType(this.type, this.subtype, (ImmutableListMultimap<String, String>)builder.build());
        return MoreObjects.firstNonNull(MediaType.KNOWN_TYPES.get(mediaType), mediaType);
    }
    
    public MediaType withParameters(final Multimap<String, String> multimap) {
        return create(this.type, this.subtype, multimap);
    }
    
    public MediaType withoutParameters() {
        if (this.parameters.isEmpty()) {
            return this;
        }
        return create(this.type, this.subtype);
    }
    
    private static final class Tokenizer
    {
        final String input;
        int position;
        
        Tokenizer(final String input) {
            this.position = 0;
            this.input = input;
        }
        
        char consumeCharacter(final char c) {
            Preconditions.checkState(this.hasMore());
            Preconditions.checkState(this.previewChar() == c);
            ++this.position;
            return c;
        }
        
        char consumeCharacter(final CharMatcher charMatcher) {
            Preconditions.checkState(this.hasMore());
            final char previewChar = this.previewChar();
            Preconditions.checkState(charMatcher.matches(previewChar));
            ++this.position;
            return previewChar;
        }
        
        String consumeToken(final CharMatcher charMatcher) {
            final int position = this.position;
            final String consumeTokenIfPresent = this.consumeTokenIfPresent(charMatcher);
            Preconditions.checkState(this.position != position);
            return consumeTokenIfPresent;
        }
        
        String consumeTokenIfPresent(final CharMatcher charMatcher) {
            Preconditions.checkState(this.hasMore());
            final int position = this.position;
            this.position = charMatcher.negate().indexIn(this.input, position);
            if (this.hasMore()) {
                return this.input.substring(position, this.position);
            }
            return this.input.substring(position);
        }
        
        boolean hasMore() {
            return this.position >= 0 && this.position < this.input.length();
        }
        
        char previewChar() {
            Preconditions.checkState(this.hasMore());
            return this.input.charAt(this.position);
        }
    }
}
