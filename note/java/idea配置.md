##### 实时模版

###### 类方法注释

**

**
 * MethodName: $method$ <br>
 * Description: $END$<br>
 $params$ 
 $returns$
 * @author xiahaifeng
 */

params:默认值

```
groovyScript("def result = '' 
def params = \"${_1}\".replaceAll('[\\\\[|\\\\]|\\\\s]', '').split(',').toList()
def paramsType = \"${_2}\".replaceAll('[\\\\[|\\\\]|\\\\s]', '').split(',').toList()
def maxParamLength = params.collect { it.length() }.max()
for (i = 0; i < params.size(); i++) {
     def param = params[i]
     def type = paramsType[i].replace('?', '')
     def paramPadding = ' ' * (maxParamLength - param.length())
     result += '* @param ' + param + paramPadding + ' {@link ' + type + '} '+((i < params.size() - 1) ? '\\n ' : '') 
     }
return result", methodParameters(), methodParameterTypes())
```

returns:默认值

```
groovyScript("
def params=\"${_1}\"; 
if(params=='void')
{return '';} 
else{
    return '* @return {@link ' + params.replace('?', '') + '}'
}
", methodReturnType()) 
```

###### 类方法注释2 不带参数类型
**

**
 * MethodName: $method$ <br>
 * Description: $END$<br>
 $params$ 
 * @return
 * @author xiahaifeng
 */

params:默认值

```
groovyScript("def result = ''\n def params = \"${_1}\".replaceAll('[\\\\[|\\\\]|\\\\s]', '').split(',').toList()\n  def maxParamLength = params.collect { it.length() }.max()\n for (i = 0; i < params.size(); i++) {\n     def param = params[i]\n def paramPadding = ' ' * (maxParamLength - param.length())\n result += '* @param ' + param +((i < params.size() - 1) ? '\\n ' : '') }\n return result", methodParameters())
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
