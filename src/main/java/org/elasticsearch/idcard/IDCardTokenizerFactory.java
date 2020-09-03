package org.elasticsearch.idcard;

import org.apache.lucene.analysis.Tokenizer;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.env.Environment;
import org.elasticsearch.index.IndexSettings;
import org.elasticsearch.index.analysis.AbstractTokenizerFactory;

public class IDCardTokenizerFactory extends AbstractTokenizerFactory {


    public IDCardTokenizerFactory(IndexSettings indexSettings, Environment environment, String ignored, Settings settings) {
        super(indexSettings, settings, ignored);
    }

    /**
     * 返回自定义分词器
     * @return
     */
    @Override
    public Tokenizer create() {
        return new IDCardTokenizer();
    }
}
