package org.elasticsearch.idcard;

import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.elasticsearch.idcard.IDCardAnalyzer;
import org.junit.Test;

public class IDCardAnalyzerTest {
    @Test
    public void testAnalyzer() throws Exception {

        IDCardAnalyzer analyzer = new IDCardAnalyzer();
        TokenStream ts = analyzer.tokenStream("text", "230621");
        CharTermAttribute term = ts.addAttribute(CharTermAttribute.class);
        ts.reset();
        while (ts.incrementToken()) {
            System.out.println("R:" + term.toString() + "]");
        }
        ts.end();
        ts.close();

        System.out.println("----------------------------------——————————————————————————---------");
        TokenStream tss = analyzer.tokenStream("text", "哈哈,哈哈");
        CharTermAttribute terms = tss.addAttribute(CharTermAttribute.class);
        tss.reset();
        while (tss.incrementToken()) {
            System.out.println("R:" + terms.toString() + "]");
        }
        tss.end();
        tss.close();



//        String substring = "我爱 北京 天安门".substring(0, 3);
//        System.out.println(substring + "=");
//        String substring1 = "我爱 北京 天安门".substring(3, 6);
//        System.out.println(substring1 + "=");
//        String substring2 = "我爱 北京 天安门".substring(6, 9);
//        System.out.println(substring2 + "=");


    }

}