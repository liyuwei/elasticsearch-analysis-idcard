package org.elasticsearch.idcard;

import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.elasticsearch.idcard.IDCardAnalyzer;
import org.junit.Test;

public class IDCardAnalyzerTest {
    @Test
    public void testAnalyzer() throws Exception {

        IDCardAnalyzer analyzer = new IDCardAnalyzer();
        TokenStream ts = analyzer.tokenStream("text", "2306211999");
        CharTermAttribute term = ts.addAttribute(CharTermAttribute.class);
        ts.reset();
        while (ts.incrementToken()) {
            System.out.println("R:" + term.toString() + "]");
        }
        ts.end();
        ts.close();

        System.out.println("----------------------------------——————————————————————————---------");
        TokenStream tss = analyzer.tokenStream("text", "220621");
        CharTermAttribute terms = tss.addAttribute(CharTermAttribute.class);
        tss.reset();
        while (tss.incrementToken()) {
            System.out.println("R:" + terms.toString() + "]");
        }
        tss.end();
        tss.close();






    }

}