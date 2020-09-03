package org.elasticsearch.idcard;

import org.apache.lucene.analysis.FilteringTokenFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;

import java.io.IOException;

public class IDCardTokenFilter extends FilteringTokenFilter {

    private final CharTermAttribute termAtt = addAttribute(CharTermAttribute.class);

    public IDCardTokenFilter(TokenStream in) {
        super(in);
    }

    /**
     * Override this method and return if the current input token should be returned by {@link #incrementToken}.
     */
    @Override
    protected boolean accept() throws IOException {
        return termAtt.toString().equals("idcard");
    }
}
