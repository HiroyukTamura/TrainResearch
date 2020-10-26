// 
// Decompiled by Procyon v0.5.36
// 

package com.github.promeg.pinyinhelper;

import java.util.Collection;
import java.util.ArrayList;
import java.util.Collections;
import org.ahocorasick.trie.Trie;
import java.util.List;

public final class Pinyin
{
    static List<PinyinDict> mPinyinDicts;
    static SegmentationSelector mSelector;
    static Trie mTrieDict;
    
    static {
        Pinyin.mTrieDict = null;
        Pinyin.mSelector = null;
        Pinyin.mPinyinDicts = null;
    }
    
    private Pinyin() {
    }
    
    public static void add(final PinyinDict pinyinDict) {
        if (pinyinDict == null || pinyinDict.words() == null || pinyinDict.words().size() == 0) {
            return;
        }
        init(new Config((List)Pinyin.mPinyinDicts).with(pinyinDict));
    }
    
    private static short decodeIndex(final byte[] array, final byte[] array2, final int n) {
        final int n2 = n / 8;
        short n3 = (short)(array2[n] & 0xFF);
        if ((array[n2] & PinyinData.BIT_MASKS[n % 8]) != 0x0) {
            n3 |= 0x100;
        }
        return n3;
    }
    
    private static int getPinyinCode(final char c) {
        final int n = c - '\u4e00';
        if (n >= 0 && n < 7000) {
            return decodeIndex(PinyinCode1.PINYIN_CODE_PADDING, PinyinCode1.PINYIN_CODE, n);
        }
        if (7000 <= n && n < 14000) {
            return decodeIndex(PinyinCode2.PINYIN_CODE_PADDING, PinyinCode2.PINYIN_CODE, n - 7000);
        }
        return decodeIndex(PinyinCode3.PINYIN_CODE_PADDING, PinyinCode3.PINYIN_CODE, n - 14000);
    }
    
    public static void init(final Config config) {
        if (config == null) {
            Pinyin.mPinyinDicts = null;
            Pinyin.mTrieDict = null;
            Pinyin.mSelector = null;
        }
        else if (config.valid()) {
            Pinyin.mPinyinDicts = Collections.unmodifiableList((List<? extends PinyinDict>)config.getPinyinDicts());
            Pinyin.mTrieDict = Utils.dictsToTrie(config.getPinyinDicts());
            Pinyin.mSelector = config.getSelector();
        }
    }
    
    public static boolean isChinese(final char c) {
        return ('\u4e00' <= c && c <= '\u9fa5' && getPinyinCode(c) > 0) || '\u3007' == c;
    }
    
    public static Config newConfig() {
        return new Config((List)null);
    }
    
    public static String toPinyin(final char c) {
        if (!isChinese(c)) {
            return String.valueOf(c);
        }
        if (c == '\u3007') {
            return "LING";
        }
        return PinyinData.PINYIN_TABLE[getPinyinCode(c)];
    }
    
    public static String toPinyin(final String s, final String s2) {
        return Engine.toPinyin(s, Pinyin.mTrieDict, Pinyin.mPinyinDicts, s2, Pinyin.mSelector);
    }
    
    public static final class Config
    {
        List<PinyinDict> mPinyinDicts;
        SegmentationSelector mSelector;
        
        private Config(final List<PinyinDict> c) {
            if (c != null) {
                this.mPinyinDicts = new ArrayList<PinyinDict>(c);
            }
            this.mSelector = new ForwardLongestSelector();
        }
        
        List<PinyinDict> getPinyinDicts() {
            return this.mPinyinDicts;
        }
        
        SegmentationSelector getSelector() {
            return this.mSelector;
        }
        
        boolean valid() {
            return this.getPinyinDicts() != null && this.getSelector() != null;
        }
        
        public Config with(final PinyinDict pinyinDict) {
            if (pinyinDict != null) {
                if (this.mPinyinDicts == null) {
                    (this.mPinyinDicts = new ArrayList<PinyinDict>()).add(pinyinDict);
                }
                else if (!this.mPinyinDicts.contains(pinyinDict)) {
                    this.mPinyinDicts.add(pinyinDict);
                    return this;
                }
            }
            return this;
        }
    }
}
