package org.elasticsearch.idcard;


import org.apache.lucene.analysis.Analyzer;

public class IDCardAnalyzer extends Analyzer {

    /**
     * 需要塞一个分词器
     * @param fieldName
     * @return
     */
    @Override
    protected TokenStreamComponents createComponents(String fieldName) {
        return new TokenStreamComponents(new IDCardTokenizer());
    }
}
