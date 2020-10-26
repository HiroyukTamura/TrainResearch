// 
// Decompiled by Procyon v0.5.36
// 

package okhttp3;

import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.Locale;
import javax.annotation.Nullable;
import java.util.regex.Pattern;

public final class MediaType
{
    private static final Pattern PARAMETER;
    private static final String QUOTED = "\"([^\"]*)\"";
    private static final String TOKEN = "([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)";
    private static final Pattern TYPE_SUBTYPE;
    @Nullable
    private final String charset;
    private final String mediaType;
    private final String subtype;
    private final String type;
    
    static {
        TYPE_SUBTYPE = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
        PARAMETER = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");
    }
    
    private MediaType(final String mediaType, final String type, final String subtype, @Nullable final String charset) {
        this.mediaType = mediaType;
        this.type = type;
        this.subtype = subtype;
        this.charset = charset;
    }
    
    @Nullable
    public static MediaType parse(final String s) {
        final Matcher matcher = MediaType.TYPE_SUBTYPE.matcher(s);
        if (matcher.lookingAt()) {
            final String lowerCase = matcher.group(1).toLowerCase(Locale.US);
            final String lowerCase2 = matcher.group(2).toLowerCase(Locale.US);
            String anotherString = null;
            final Matcher matcher2 = MediaType.PARAMETER.matcher(s);
            String s2;
            for (int i = matcher.end(); i < s.length(); i = matcher2.end(), anotherString = s2) {
                matcher2.region(i, s.length());
                if (!matcher2.lookingAt()) {
                    return null;
                }
                final String group = matcher2.group(1);
                s2 = anotherString;
                if (group != null) {
                    if (!group.equalsIgnoreCase("charset")) {
                        s2 = anotherString;
                    }
                    else {
                        s2 = matcher2.group(2);
                        if (s2 != null) {
                            if (s2.startsWith("'") && s2.endsWith("'") && s2.length() > 2) {
                                s2 = s2.substring(1, s2.length() - 1);
                            }
                        }
                        else {
                            s2 = matcher2.group(3);
                        }
                        if (anotherString != null && !s2.equalsIgnoreCase(anotherString)) {
                            return null;
                        }
                    }
                }
            }
            return new MediaType(s, lowerCase, lowerCase2, anotherString);
        }
        return null;
    }
    
    @Nullable
    public Charset charset() {
        return this.charset(null);
    }
    
    @Nullable
    public Charset charset(@Nullable final Charset charset) {
        Charset forName = charset;
        try {
            if (this.charset != null) {
                forName = Charset.forName(this.charset);
            }
            return forName;
        }
        catch (IllegalArgumentException ex) {
            return charset;
        }
    }
    
    @Override
    public boolean equals(@Nullable final Object o) {
        return o instanceof MediaType && ((MediaType)o).mediaType.equals(this.mediaType);
    }
    
    @Override
    public int hashCode() {
        return this.mediaType.hashCode();
    }
    
    public String subtype() {
        return this.subtype;
    }
    
    @Override
    public String toString() {
        return this.mediaType;
    }
    
    public String type() {
        return this.type;
    }
}
