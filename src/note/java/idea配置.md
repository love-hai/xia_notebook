##### 实时模版

###### 类方法注释

```
**
 * @Description: $description$
 $params$ 
 * @return: $returns$
 * @Author: xiahaifeng
 * @Date: $date$ $time$
 */
```

params:默认值

```
groovyScript("def result = ''\n def params = \"${_1}\".replaceAll('[\\\\[|\\\\]|\\\\s]', '').split(',').toList()\n def paramsType = \"${_2}\".replaceAll('[\\\\[|\\\\]|\\\\s]', '').split(',').toList()\n def maxParamLength = params.collect { it.length() }.max()\n def maxTypeLength = paramsType.collect { it.length() }.max()\n for (i = 0; i < params.size(); i++) {\n     def param = params[i]\n     def type = paramsType[i]\n     def paramPadding = ' ' * (maxParamLength - param.length())\n     def typePadding = ' ' * (maxTypeLength - type.length())\n     result += '* @param ' + param + paramPadding + ' ' + type + '  ' + typePadding + ':'+((i < params.size() - 1) ? '\\n ' : '')\n }\n return result", methodParameters(), methodParameterTypes()) 
```

##### 文件和代码模版

###### Class

```
#if (${PACKAGE_NAME} && ${PACKAGE_NAME} != "")package ${PACKAGE_NAME};#end
#parse("File Header.java")
/**
 * @projectName: ${PROJECT_NAME}
 * @package: ${PACKAGE_NAME}
 * @className: ${NAME}
 * @descriptions: ${description}
 * @author: xiahaifeng
 * @createDate: ${DATE} ${TIME} 
 * @updateUser: xiahaifeng 
 * @updateDate: ${DATE} ${TIME}
 * @updateRemark:  
 */

public class ${NAME} {
}

```
