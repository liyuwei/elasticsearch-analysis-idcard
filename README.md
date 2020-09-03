# -elasticsearch-analysis-idcard

```$xslt
    idcard 分词器
    以身份证为前6位城市码为基础进行分词
    
```

```$xslt
    GET _analyze
    {
      "analyzer": "idcard",
      "text": "230621198888888"
    }
```

# mvn clean package 
```$xslt
    mvn clean package 
    mv target/idcard-plugin-0.0.1.jar es/plugins/idcard/
```
