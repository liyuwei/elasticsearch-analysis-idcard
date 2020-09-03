package org.elasticsearch.idcard;

import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;

import java.io.IOException;

public class IDCardTokenizer extends Tokenizer {

    private int suffixOffset;
    private int tokenStart = 0, tokenEnd = 0;
    private final CharTermAttribute termAtt = addAttribute(CharTermAttribute.class);
    private final OffsetAttribute offsetAtt = addAttribute(OffsetAttribute.class);

    private char[] buffer1 = new char[256];
    private static int MAX_SIZE;
    private int termSize;
    private static String[] splitTup;
    int ci;
//


    /**
     * 分词程序
     *
     * @return
     * @throws IOException
     */
    @Override
    public final boolean incrementToken() throws IOException {
        clearAttributes();
        ci = input.read(buffer1);
        if (ci != -1) {
            if (ci >= 0) {
                getList(String.valueOf(buffer1, 0, ci));
                MAX_SIZE = splitTup.length;
            }
        }
        if (termSize >= MAX_SIZE) {
            return false;
        } else {
            termAtt.setEmpty().append(splitTup[termSize]);
            offsetAtt.setOffset(0, 2 + termSize * 2);
            termSize++;
            return true;
        }
    }


    @Override
    public final void end() {
        final int finalOffset = correctOffset(suffixOffset);
        this.offsetAtt.setOffset(finalOffset, finalOffset);
    }

    @Override
    public void reset() throws IOException {
        super.reset();
        tokenStart = tokenEnd = 0;
        /* 重置buffer1 不影响后续输入值 */
        buffer1 = new char[256];
        termSize = 0;
        MAX_SIZE = 0;

    }

    public static void getList(String source) {
        if (source.length() < 6) {
            System.out.println("idcard log 2-3. source == null");
            splitTup = new String[0];
            return;
        }
        String city1 = source.substring(0, 2);
        String city2 = source.substring(0, 4);
        String city3 = source.substring(0, 6);
        String cityName1 = IDCardDataUtil.getNameString(Integer.parseInt(city1));
        String cityName2 = IDCardDataUtil.getNameString(Integer.parseInt(city2));
        String cityName3 = IDCardDataUtil.getNameString(Integer.parseInt(city3));
        splitTup = new String[3];
        splitTup[0] = cityName1;
        splitTup[1] = cityName2;
        splitTup[2] = cityName3;
    }


}
