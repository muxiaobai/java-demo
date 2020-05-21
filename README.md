
# demo
研究

- test.java.demo java jvm joo jmm验证
    [说明文档](test.java.demo/README/md)    
- test.tool.demo 第三方工具使用介绍
    [说明文档](test.tool.demo/README/md)    
    - tika 
    - hanlp
    - javassist
    - hutool
    - guava
#### 打包到maven 仓库

mvn javadoc:jar source:jar deploy -P release -Darguments="gpg.passphrase="password"
