package kotlin.collections.unsigned;

import kotlin.Metadata;
import kotlin.UByteArray;
import kotlin.collections.UByteIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo21739d2 = {"<anonymous>", "Lkotlin/collections/UByteIterator;", "invoke"}, mo21740k = 3, mo21741mv = {1, 1, 16})
final class UArraysKt___UArraysKt$withIndex$3 extends Lambda implements Function0<UByteIterator> {
    final /* synthetic */ byte[] $this_withIndex;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UArraysKt___UArraysKt$withIndex$3(byte[] bArr) {
        super(0);
        this.$this_withIndex = bArr;
    }

    public final UByteIterator invoke() {
        return UByteArray.m4699iteratorimpl(this.$this_withIndex);
    }
}