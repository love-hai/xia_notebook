##### 实时模版

###### 类方法注释

**

* MethodName: $method$ `<br>`
* Description: $END$`<br>`
  $params$
* @return {@link $returns$}
* @author xiahaifeng
* */

params:默认值

```
groovyScript("def result = ''\n def params = \"${_1}\".replaceAll('[\\\\[|\\\\]|\\\\s]', '').split(',').toList()\n def paramsType = \"${_2}\".replaceAll('[\\\\[|\\\\]|\\\\s]', '').split(',').toList()\n def maxParamLength = params.collect { it.length() }.max()\n def maxTypeLength = paramsType.collect { it.length() }.max()\n for (i = 0; i < params.size(); i++) {\n     def param = params[i]\n     def type = paramsType[i]\n     def paramPadding = ' ' * (maxParamLength - param.length())\n     def typePadding = ' ' * (maxTypeLength - type.length())\n     result += '* @param ' + param + paramPadding + ' {@link ' + type + '}  ' + typePadding + ':'+((i < params.size() - 1) ? '\\n ' : '')\n }\n return result", methodParameters(), methodParameterTypes())
```

##### 文件和代码模版

###### Class

```
#if (${PACKAGE_NAME} && ${PACKAGE_NAME} != "")package ${PACKAGE_NAME};#end
#parse("File Header.java")
/**
 * ${description}
 * @author xiahaifeng
 */

public class ${NAME} {
}
```
