// 
// Decompiled by Procyon v0.5.36
// 

package okhttp3.internal.cache;

import okhttp3.Request;
import javax.annotation.Nullable;
import okhttp3.Response;

public final class CacheStrategy
{
    @Nullable
    public final Response cacheResponse;
    @Nullable
    public final Request networkRequest;
    
    CacheStrategy(final Request networkRequest, final Response cacheResponse) {
        this.networkRequest = networkRequest;
        this.cacheResponse = cacheResponse;
    }
    
    public static boolean isCacheable(final Response response, final Request request) {
        Label_0162: {
            switch (response.code()) {
                case 302:
                case 307: {
                    if (response.header("Expires") != null || response.cacheControl().maxAgeSeconds() != -1 || response.cacheControl().isPublic() || response.cacheControl().isPrivate()) {
                        break Label_0162;
                    }
                    break;
                }
                case 200:
                case 203:
                case 204:
                case 300:
                case 301:
                case 308:
                case 404:
                case 405:
                case 410:
                case 414:
                case 501: {
                    if (!response.cacheControl().noStore() && !request.cacheControl().noStore()) {
                        return true;
                    }
                    break;
                }
            }
        }
        return false;
    }
}
