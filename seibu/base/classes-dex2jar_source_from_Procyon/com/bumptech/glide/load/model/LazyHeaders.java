// 
// Decompiled by Procyon v0.5.36
// 

package com.bumptech.glide.load.model;

import java.util.Collection;
import java.util.ArrayList;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class LazyHeaders implements Headers
{
    private volatile Map<String, String> combinedHeaders;
    private final Map<String, List<LazyHeaderFactory>> headers;
    
    LazyHeaders(final Map<String, List<LazyHeaderFactory>> m) {
        this.headers = Collections.unmodifiableMap((Map<? extends String, ? extends List<LazyHeaderFactory>>)m);
    }
    
    private Map<String, String> generateHeaders() {
        final HashMap<Object, String> hashMap = new HashMap<Object, String>();
        for (final Map.Entry<String, List<LazyHeaderFactory>> entry : this.headers.entrySet()) {
            final StringBuilder sb = new StringBuilder();
            final List<LazyHeaderFactory> list = entry.getValue();
            for (int i = 0; i < list.size(); ++i) {
                sb.append(list.get(i).buildHeader());
                if (i != list.size() - 1) {
                    sb.append(',');
                }
            }
            hashMap.put(entry.getKey(), sb.toString());
        }
        return (Map<String, String>)hashMap;
    }
    
    @Override
    public boolean equals(final Object o) {
        return o instanceof LazyHeaders && this.headers.equals(((LazyHeaders)o).headers);
    }
    
    @Override
    public Map<String, String> getHeaders() {
        Label_0029: {
            if (this.combinedHeaders != null) {
                break Label_0029;
            }
            synchronized (this) {
                if (this.combinedHeaders == null) {
                    this.combinedHeaders = Collections.unmodifiableMap((Map<? extends String, ? extends String>)this.generateHeaders());
                }
                // monitorexit(this)
                return this.combinedHeaders;
            }
        }
    }
    
    @Override
    public int hashCode() {
        return this.headers.hashCode();
    }
    
    @Override
    public String toString() {
        return "LazyHeaders{headers=" + this.headers + '}';
    }
    
    public static final class Builder
    {
        private static final String DEFAULT_ENCODING = "identity";
        private static final Map<String, List<LazyHeaderFactory>> DEFAULT_HEADERS;
        private static final String DEFAULT_USER_AGENT;
        private static final String ENCODING_HEADER = "Accept-Encoding";
        private static final String USER_AGENT_HEADER = "User-Agent";
        private boolean copyOnModify;
        private Map<String, List<LazyHeaderFactory>> headers;
        private boolean isEncodingDefault;
        private boolean isUserAgentDefault;
        
        static {
            DEFAULT_USER_AGENT = System.getProperty("http.agent");
            final HashMap<String, List<LazyHeaderFactory>> m = new HashMap<String, List<LazyHeaderFactory>>(2);
            if (!TextUtils.isEmpty((CharSequence)Builder.DEFAULT_USER_AGENT)) {
                m.put("User-Agent", Collections.singletonList(new StringHeaderFactory(Builder.DEFAULT_USER_AGENT)));
            }
            m.put("Accept-Encoding", Collections.singletonList(new StringHeaderFactory("identity")));
            DEFAULT_HEADERS = Collections.unmodifiableMap((Map<?, ?>)m);
        }
        
        public Builder() {
            this.copyOnModify = true;
            this.headers = Builder.DEFAULT_HEADERS;
            this.isEncodingDefault = true;
            this.isUserAgentDefault = true;
        }
        
        private Map<String, List<LazyHeaderFactory>> copyHeaders() {
            final HashMap<String, ArrayList> hashMap = (HashMap<String, ArrayList>)new HashMap<String, ArrayList<LazyHeaderFactory>>(this.headers.size());
            for (final Map.Entry<String, List<LazyHeaderFactory>> entry : this.headers.entrySet()) {
                hashMap.put(entry.getKey(), new ArrayList<LazyHeaderFactory>(entry.getValue()));
            }
            return (Map<String, List<LazyHeaderFactory>>)hashMap;
        }
        
        private void copyIfNecessary() {
            if (this.copyOnModify) {
                this.copyOnModify = false;
                this.headers = this.copyHeaders();
            }
        }
        
        private List<LazyHeaderFactory> getFactories(final String s) {
            List<LazyHeaderFactory> list;
            if ((list = this.headers.get(s)) == null) {
                list = new ArrayList<LazyHeaderFactory>();
                this.headers.put(s, list);
            }
            return list;
        }
        
        public Builder addHeader(final String s, final LazyHeaderFactory lazyHeaderFactory) {
            if ((this.isEncodingDefault && "Accept-Encoding".equalsIgnoreCase(s)) || (this.isUserAgentDefault && "User-Agent".equalsIgnoreCase(s))) {
                return this.setHeader(s, lazyHeaderFactory);
            }
            this.copyIfNecessary();
            this.getFactories(s).add(lazyHeaderFactory);
            return this;
        }
        
        public Builder addHeader(final String s, final String s2) {
            return this.addHeader(s, new StringHeaderFactory(s2));
        }
        
        public LazyHeaders build() {
            this.copyOnModify = true;
            return new LazyHeaders(this.headers);
        }
        
        public Builder setHeader(final String s, final LazyHeaderFactory lazyHeaderFactory) {
            this.copyIfNecessary();
            if (lazyHeaderFactory == null) {
                this.headers.remove(s);
            }
            else {
                final List<LazyHeaderFactory> factories = this.getFactories(s);
                factories.clear();
                factories.add(lazyHeaderFactory);
            }
            if (this.isEncodingDefault && "Accept-Encoding".equalsIgnoreCase(s)) {
                this.isEncodingDefault = false;
            }
            if (this.isUserAgentDefault && "User-Agent".equalsIgnoreCase(s)) {
                this.isUserAgentDefault = false;
            }
            return this;
        }
        
        public Builder setHeader(final String s, final String s2) {
            LazyHeaderFactory lazyHeaderFactory;
            if (s2 == null) {
                lazyHeaderFactory = null;
            }
            else {
                lazyHeaderFactory = new StringHeaderFactory(s2);
            }
            return this.setHeader(s, lazyHeaderFactory);
        }
    }
    
    static final class StringHeaderFactory implements LazyHeaderFactory
    {
        private final String value;
        
        StringHeaderFactory(final String value) {
            this.value = value;
        }
        
        @Override
        public String buildHeader() {
            return this.value;
        }
        
        @Override
        public boolean equals(final Object o) {
            return o instanceof StringHeaderFactory && this.value.equals(((StringHeaderFactory)o).value);
        }
        
        @Override
        public int hashCode() {
            return this.value.hashCode();
        }
        
        @Override
        public String toString() {
            return "StringHeaderFactory{value='" + this.value + '\'' + '}';
        }
    }
}
