// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.client.result;

public final class AddressBookParsedResult extends ParsedResult
{
    private final String[] addressTypes;
    private final String[] addresses;
    private final String birthday;
    private final String[] emailTypes;
    private final String[] emails;
    private final String[] geo;
    private final String instantMessenger;
    private final String[] names;
    private final String[] nicknames;
    private final String note;
    private final String org;
    private final String[] phoneNumbers;
    private final String[] phoneTypes;
    private final String pronunciation;
    private final String title;
    private final String[] urls;
    
    public AddressBookParsedResult(final String[] names, final String[] nicknames, final String pronunciation, final String[] phoneNumbers, final String[] phoneTypes, final String[] emails, final String[] emailTypes, final String instantMessenger, final String note, final String[] addresses, final String[] addressTypes, final String org, final String birthday, final String title, final String[] urls, final String[] geo) {
        super(ParsedResultType.ADDRESSBOOK);
        if (phoneNumbers != null && phoneTypes != null && phoneNumbers.length != phoneTypes.length) {
            throw new IllegalArgumentException("Phone numbers and types lengths differ");
        }
        if (emails != null && emailTypes != null && emails.length != emailTypes.length) {
            throw new IllegalArgumentException("Emails and types lengths differ");
        }
        if (addresses != null && addressTypes != null && addresses.length != addressTypes.length) {
            throw new IllegalArgumentException("Addresses and types lengths differ");
        }
        this.names = names;
        this.nicknames = nicknames;
        this.pronunciation = pronunciation;
        this.phoneNumbers = phoneNumbers;
        this.phoneTypes = phoneTypes;
        this.emails = emails;
        this.emailTypes = emailTypes;
        this.instantMessenger = instantMessenger;
        this.note = note;
        this.addresses = addresses;
        this.addressTypes = addressTypes;
        this.org = org;
        this.birthday = birthday;
        this.title = title;
        this.urls = urls;
        this.geo = geo;
    }
    
    public AddressBookParsedResult(final String[] array, final String[] array2, final String[] array3, final String[] array4, final String[] array5, final String[] array6, final String[] array7) {
        this(array, null, null, array2, array3, array4, array5, null, null, array6, array7, null, null, null, null, null);
    }
    
    public String[] getAddressTypes() {
        return this.addressTypes;
    }
    
    public String[] getAddresses() {
        return this.addresses;
    }
    
    public String getBirthday() {
        return this.birthday;
    }
    
    @Override
    public String getDisplayResult() {
        final StringBuilder sb = new StringBuilder(100);
        ParsedResult.maybeAppend(this.names, sb);
        ParsedResult.maybeAppend(this.nicknames, sb);
        ParsedResult.maybeAppend(this.pronunciation, sb);
        ParsedResult.maybeAppend(this.title, sb);
        ParsedResult.maybeAppend(this.org, sb);
        ParsedResult.maybeAppend(this.addresses, sb);
        ParsedResult.maybeAppend(this.phoneNumbers, sb);
        ParsedResult.maybeAppend(this.emails, sb);
        ParsedResult.maybeAppend(this.instantMessenger, sb);
        ParsedResult.maybeAppend(this.urls, sb);
        ParsedResult.maybeAppend(this.birthday, sb);
        ParsedResult.maybeAppend(this.geo, sb);
        ParsedResult.maybeAppend(this.note, sb);
        return sb.toString();
    }
    
    public String[] getEmailTypes() {
        return this.emailTypes;
    }
    
    public String[] getEmails() {
        return this.emails;
    }
    
    public String[] getGeo() {
        return this.geo;
    }
    
    public String getInstantMessenger() {
        return this.instantMessenger;
    }
    
    public String[] getNames() {
        return this.names;
    }
    
    public String[] getNicknames() {
        return this.nicknames;
    }
    
    public String getNote() {
        return this.note;
    }
    
    public String getOrg() {
        return this.org;
    }
    
    public String[] getPhoneNumbers() {
        return this.phoneNumbers;
    }
    
    public String[] getPhoneTypes() {
        return this.phoneTypes;
    }
    
    public String getPronunciation() {
        return this.pronunciation;
    }
    
    public String getTitle() {
        return this.title;
    }
    
    public String[] getURLs() {
        return this.urls;
    }
}
