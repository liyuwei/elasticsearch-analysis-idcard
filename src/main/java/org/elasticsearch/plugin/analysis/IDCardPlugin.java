package org.elasticsearch.plugin.analysis;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.lucene.analysis.Analyzer;
import org.elasticsearch.idcard.IDCardAnalyzerProvider;
import org.elasticsearch.idcard.IDCardTokenizerFactory;
import org.elasticsearch.index.analysis.AnalyzerProvider;
import org.elasticsearch.index.analysis.TokenizerFactory;
import org.elasticsearch.indices.analysis.AnalysisModule;
import org.elasticsearch.plugins.AnalysisPlugin;
import org.elasticsearch.plugins.Plugin;

import java.util.Collections;
import java.util.Map;

public class IDCardPlugin extends Plugin implements AnalysisPlugin {
    public static String PLUGIN_NAME = "analysis-idcard"; // script name
    public static String ANALYZER_NAME = "idcard"; //  name
    private final static Logger LOGGER = LogManager.getLogger(IDCardPlugin.class);

    public IDCardPlugin() {
        super();
        LOGGER.info("---- {} installed into elasticsearch ----", PLUGIN_NAME);
    }

    @Override
    public Map<String, AnalysisModule.AnalysisProvider<TokenizerFactory>> getTokenizers() {
        return Collections.singletonMap(ANALYZER_NAME, IDCardTokenizerFactory::new);
    }

    @Override
    public Map<String, AnalysisModule.AnalysisProvider<AnalyzerProvider<? extends Analyzer>>> getAnalyzers() {
        return Collections.singletonMap(ANALYZER_NAME, IDCardAnalyzerProvider::new);
    }
}
