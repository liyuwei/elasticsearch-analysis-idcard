package org.elasticsearch.idcard;

import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.env.Environment;
import org.elasticsearch.index.IndexSettings;
import org.elasticsearch.index.analysis.AbstractIndexAnalyzerProvider;

public class IDCardAnalyzerProvider extends AbstractIndexAnalyzerProvider<IDCardAnalyzer> {

    private final IDCardAnalyzer idcardAnalyzer;

    public IDCardAnalyzerProvider(IndexSettings indexSettings, Environment environment, String name, Settings settings) {
        super(indexSettings, name, settings);
        idcardAnalyzer = new IDCardAnalyzer();
    }

    /**
     * 重写GET 方法返回自定义分词器
     * @return
     */
    @Override
    public IDCardAnalyzer get() {
        return idcardAnalyzer;
    }
}
