1.解决response在controller返回乱码的解决方式：
    A.在controller的请求头部的注解写上 produces = "text/plain;charset=utf-8" :
         @RequestMapping(value = {"/xxxMethod"},produces = "text/plain;charset=utf-8")
    B.在spring-mvc配置:
       
        <!-- 处理请求返回json字符串的中文乱码问题 -->
        <mvc:annotation-driven>
            <mvc:message-converters>
                <bean class="org.springframework.http.converter.StringHttpMessageConverter">
                    <property name="supportedMediaTypes">
                        <list>
                            <value>application/json;charset=UTF-8</value>
                        </list>
                    </property>
                </bean>
            </mvc:message-converters>
        </mvc:annotation-driven>





2.web.xml 配置过滤器  (spring resful 过滤器的设置)

        A.文件上传解析器的bean名称  作用于filter加载才有效  multipartResolver
        <!-- 配置文件上传解析器 -->
        <bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
                 <!-- 指定所上传文件的总大小不能超过20M。注意maxUploadSize属性的限制不是针对单个文件，而是所有文件的容量之和 -->
                 <property name="maxUploadSize" value="20000000"/>
                 <property name="defaultEncoding" value="utf-8"></property>
        </bean>

        B.引入的root-context.xml文件作用于filter内容
        <context-param>
        		<param-name>contextConfigLocation</param-name>
        		<param-value>classpath:spring/root-context.xml</param-value>
        </context-param>

        C.filter作用于multipartResolver名称
        <filter>
    		<filter-name>MultipartFilter</filter-name>
    		<filter-class>org.springframework.web.multipart.support.MultipartFilter</filter-class>
    		<init-param>
    			<param-name>multipartResolverBeanName</param-name>
    			<param-value>multipartResolver</param-value>
    		</init-param>
    	</filter>
    	<filter-mapping>
    		<filter-name>MultipartFilter</filter-name>
    		<url-pattern>/*</url-pattern>
    	</filter-mapping>

    	如果form表单的enctype为application/x-www-form-urlencoded（该值是默认值，不需显式声明），那么在过滤器或者Servlet中，我们可以直接通过request.getParameter()来获得相应的参数值；如果form表单的enctype为multipart/form-data时（上传图片需要声明该值），如果没有使用额外的代码去解析输入流，则在过滤器或者Servlet中，调用request.getParameter()将返回null！
        Spring MVC 的 HiddenHttpMethodFilter 类通过在doFilterInternal() 方法中调用request.getParameter("_method")，获得被增强的HTTP方法，例如Patch，Delete。然而，若提交的表单的enctype为multipart/form-data，则在 HiddenHttpMethodFilter 的 doFilterInternal() 方法中调用request.getParameter("_method")，将返回null，出现错误。
        两种解决方式：
        1、若表单的enctype为multipart/form-data，则表单不应包含<input type="hidden" name="_method" />，反之亦然。

        2、在请求到达HiddenHttpMethodFilter 之前，解析表单，并对请求进行包装，这样在HiddenHttpMethodFilter 的 doFilterInternal() 方法中调用request.getParameter("_method")将返回正确的值。




    	<filter>
    		<filter-name>hiddenHttpMethodFilter</filter-name>
    		<filter-class>org.springframework.web.filter.HiddenHttpMethodFilter</filter-class>
    	</filter>
    	<filter-mapping>
    		<filter-name>hiddenHttpMethodFilter</filter-name>
    		<url-pattern>/*</url-pattern>
    	</filter-mapping>

    	浏览器form表单只支持GET与POST请求，而DELETE、PUT等method并不支持，spring3.0添加了一个过滤器，可以将这些请求转换为标准的http方法，使得支持GET、POST、PUT与DELETE请求，该过滤器为HiddenHttpMethodFilter。

        HiddenHttpMethodFilter的父类是OncePerRequestFilter，它继承了父类的doFilterInternal方法，工作原理是将jsp页面的form表单的method属性值在doFilterInternal方法中转化为标准的Http方法，即GET,、POST、 HEAD、OPTIONS、PUT、DELETE、TRACE，
        然后到Controller中找到对应的方法。例如，在使用注解时我们可能会在Controller中用于@RequestMapping(value = "list", method = RequestMethod.PUT)，所以如果你的表单中使用的是<form method="put">，那么这个表单会被提交到标了Method="PUT"的方法中。
        
        
3.微信开发:
       1.https://natapp.cn/ 内网映射     
       
       
       2.站点的微信登录： 查看的文档是微信开放平台 (appId  secret不一样)
       
       
       
       3.（微信公众平台）微信模板信息提醒
             
       
       
       
       
       
4.标准会话管理:
      1.jwt   2.oauth2          
      
      
      
      
      
      
5.本地缓存：guava cache






6.登录一般校验方法：
    http://blog.jobbole.com/61872/
    加盐密码哈希：如何正确使用（http://blog.jobbole.com/61872/）      
      
      
      
7.websocket      
        1.前端写客户端的js代码
        2.后端要写websocket代码进行message的传输
        
        
8.缓存的注解：cacheable cacheConfig cacheput  +  序列化


9.项目部署
    tomcat war
    java -jar 【linux部署】
    
  
10.centos service    



11.容器编排打包



    
    

        
        
        
        
        
        