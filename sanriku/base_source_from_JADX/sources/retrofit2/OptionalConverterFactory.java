package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Optional;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import p040i.C0980J;
import retrofit2.Converter;

@IgnoreJRERequirement
final class OptionalConverterFactory extends Converter.Factory {
    static final Converter.Factory INSTANCE = new OptionalConverterFactory();

    @IgnoreJRERequirement
    static final class OptionalConverter<T> implements Converter<C0980J, Optional<T>> {
        final Converter<C0980J, T> delegate;

        OptionalConverter(Converter<C0980J, T> converter) {
            this.delegate = converter;
        }

        public Optional<T> convert(C0980J j) throws IOException {
            return Optional.ofNullable(this.delegate.convert(j));
        }
    }

    OptionalConverterFactory() {
    }

    public Converter<C0980J, ?> responseBodyConverter(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        if (Converter.Factory.getRawType(type) != Optional.class) {
            return null;
        }
        return new OptionalConverter(retrofit.responseBodyConverter(Converter.Factory.getParameterUpperBound(0, (ParameterizedType) type), annotationArr));
    }
}
