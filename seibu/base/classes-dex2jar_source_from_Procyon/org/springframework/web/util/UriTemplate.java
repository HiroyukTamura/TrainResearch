// 
// Decompiled by Procyon v0.5.36
// 

package org.springframework.web.util;

import java.util.regex.Matcher;
import java.util.LinkedHashMap;
import org.springframework.util.Assert;
import java.util.Map;
import java.net.URISyntaxException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.util.List;
import java.util.regex.Pattern;
import java.io.Serializable;

public class UriTemplate implements Serializable
{
    private static final String DEFAULT_VARIABLE_PATTERN = "(.*)";
    private static final Pattern NAMES_PATTERN;
    private static final long serialVersionUID = 1L;
    private final Pattern matchPattern;
    private final UriComponents uriComponents;
    private final String uriTemplate;
    private final List<String> variableNames;
    
    static {
        NAMES_PATTERN = Pattern.compile("\\{([^/]+?)\\}");
    }
    
    public UriTemplate(final String uriTemplate) {
        final UriTemplate.UriTemplate$Parser uriTemplate$Parser = new UriTemplate.UriTemplate$Parser(uriTemplate, (UriTemplate.UriTemplate$1)null);
        this.uriTemplate = uriTemplate;
        this.variableNames = (List<String>)UriTemplate.UriTemplate$Parser.access$100(uriTemplate$Parser);
        this.matchPattern = UriTemplate.UriTemplate$Parser.access$200(uriTemplate$Parser);
        this.uriComponents = UriComponentsBuilder.fromUriString(uriTemplate).build();
    }
    
    @Deprecated
    protected URI encodeUri(final String str) {
        try {
            return new URI(UriUtils.encodeUri(str, "UTF-8"));
        }
        catch (UnsupportedEncodingException cause) {
            throw new IllegalStateException(cause);
        }
        catch (URISyntaxException ex) {
            throw new IllegalArgumentException("Could not create URI from [" + str + "]: " + ex, ex);
        }
    }
    
    public URI expand(final Map<String, ?> map) {
        return this.uriComponents.expand((Map)map).encode().toUri();
    }
    
    public URI expand(final Object... array) {
        return this.uriComponents.expand(array).encode().toUri();
    }
    
    public List<String> getVariableNames() {
        return this.variableNames;
    }
    
    public Map<String, String> match(final String input) {
        Assert.notNull((Object)input, "'uri' must not be null");
        final LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<String, String>(this.variableNames.size());
        final Matcher matcher = this.matchPattern.matcher(input);
        if (matcher.find()) {
            for (int i = 1; i <= matcher.groupCount(); ++i) {
                linkedHashMap.put(this.variableNames.get(i - 1), matcher.group(i));
            }
        }
        return linkedHashMap;
    }
    
    public boolean matches(final String input) {
        return input != null && this.matchPattern.matcher(input).matches();
    }
    
    @Override
    public String toString() {
        return this.uriTemplate;
    }
}
