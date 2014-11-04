CnJvmAttacher
===============

Jvm attach tool for load an agent into running Java Machine

This tool just help you load an java agent quickly.

use it as following maner :

```
  java -cp .:/usr/lib/jvm/jdk1.7.0_65.jdk/lib/tools.jar:CnJvmAttacher-1.0.jar   \
        com.cn.jvm.tool.CnJvmAttacher  1565 /root/CnAgent.jar \
        'com.yet.another.test.plain.ClassB::producer|data =$"world";'
```
