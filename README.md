# HeilJava 

#### 介绍
HeilJava核心类库

#### 基础框架
| 框架名 | 版本 | 相关连接 | 备注 |
| :-- | :-- | :-- | :-- |
|springboot| 2.1.6.README|[https://spring.io/projects/spring-boot/](https://spring.io/projects/spring-boot/)||
|lombok||||


### 核心目录结构
```
├─项目目录
│    ├─src              项目源代码
│    │    ├─main			
│    │    │    ├─java
│    │    │    │  └─com
│    │    │    │      └─heilcoder
│    │    │    │          └─base
│    │    │    │              │─controller            控制器目录
│    │    │    │              │    └─BaseController       基础控制器类，项目其他控制器需继承此类
│    │    │    │              │─pojo                  普通JAVA类
│    │    │    │              │    └─Response             响应结果类，RestApi返回数据均应返回此类的对象
│    │    │    │              └─VehicleApp.java       项目初始化
│    │    │    ├─resources
│    │    │    │    │─static                           静态资源目录,存放图片、CSS文件、JS文件等
│    │    │    │    │─templates                        themeleaf页面模板目录
│    │    │    │    └─application.properties           本地配置
│    │    │    └─webapp  
│    │    └─test                                       测试类库
│    │        └─heilcoder
│    │            └─base
│    │                └─BaseController.java                测试类
│    ├─target                                          编译类库
│    ├─pom.xml                 maven配置文件
```


#### 使用说明

##### RestApi响应数据类型
com.heilcoder.base.pojo.Response的对象转化后的json数据

##### RestApi响应数据结构

| 参数名 | 数据类型 | 用途 | 可选值 | 备注 |
| :-- | :-- | :-- | :-- | :-- |
|code|Integer|处理结果代码|0:成功 1+:失败|功成时code只能为0，1为通用失败代码，其他数字可对应不同失败情况|
|message|String|处理结果提示|处理成功、处理失败、其它自定义字符串|不能为空|
|data|泛型|处理结果数据|null、其他自定义数据|无需返回具体数据时为null，其它情况返回适当类型的数据|

##### RestApi响应数据返回方式
1. 控制器类继承com.heilcoder.base.controller.BaseController；
1. 控制器不直接返回com.heilcoder.base.pojo.Response的对象；
1. 处理成功时控制器返回 success() 处理后得到的com.heilcoder.base.pojo.Response的对象；
1. 处理失败时控制器返回 error() 处理后得到的com.heilcoder.base.pojo.Response的对象；

##### RestApi success()参数说明

|数据类型|对应Response返回参数|排序值|是否必填|默认值|备注|
|---|---|---|---|---|---|
|String|message|0|否|处理成功|传入空字符串时会被替换为默认值|
|泛型|data|1|否|null||

> success()传入的参数按上表中的排序值作升序排列(排序值小的在前)，只传入需要的参数即可；  

~~~
import com.heilcoder.base.pojo.Response;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("test")
public class TestController extends BaseController {

    @RequestMapping("success")
    public Response success1(){
        return success();
    }
    @RequestMapping("success2")
    public Response success2(){
        //字符串对应message参数
        return success("测试成功参数");
    }
    @RequestMapping("success3")
    public Response success3(){
        //这里new Response()可以替换为非String的任意类型数据以对应data参数
        return success(new Response());
    }
    @RequestMapping("success4")
    public Response success4(){
        //这里new Response()可以替换为Integer、String或其他任意类型数据以对应data参数
        return success("测试成功参数",new Response());
    }
}
~~~

##### RestApi error()参数说明

|数据类型|对应Response返回参数|排序值|是否必填|默认值|备注|
|---|---|---|---|---|---|
|Integer|code|0|否|1|1:通用处理失败代码，0:会被替换为1，其它数字:对应不同失败情况|
|String|message|1|否|处理失败|传入空字符串时会被替换为默认值|
|泛型|data|2|否|null||

> error()传入的参数按上表中的排序值作升序排列(排序值小的在前)，只传入需要的参数即可；  

~~~
import com.heilcoder.base.pojo.Response;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("test")
public class TestController extends BaseController {

    @RequestMapping("error")
    public Response error1(){
        return error();
    }
    @RequestMapping("error2")
    public Response error2(){
        //自定义处理失败错误代码并对应code参数
        return error(33);
    }
    @RequestMapping("error3")
    public Response error3(){
        //字符串对应message参数
        return error("测试");
    }
    @RequestMapping("error4")
    public Response error4(){
        //0会被替换为默认值1并对应code参数，字符串对应message参数
        return error(0,"测试双参数");
    }
    @RequestMapping("error5")
    public Response error5(){
        //这里new Response()可以替换为非Integer且非String的任意类型数据以对应data参数
        return error(new Response());
    }
}
~~~
