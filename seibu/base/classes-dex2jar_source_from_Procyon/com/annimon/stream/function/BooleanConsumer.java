// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream.function;

@FunctionalInterface
public interface BooleanConsumer
{
    void accept(final boolean p0);
    
    public static class Util
    {
        private Util() {
        }
        
        public static BooleanConsumer andThen(final BooleanConsumer booleanConsumer, final BooleanConsumer booleanConsumer2) {
            return new BooleanConsumer() {
                @Override
                public void accept(final boolean b) {
                    booleanConsumer.accept(b);
                    booleanConsumer2.accept(b);
                }
            };
        }
    }
}
