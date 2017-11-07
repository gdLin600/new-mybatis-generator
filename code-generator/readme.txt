运行generator.bat即可生产代码.
但运行之前需配置你需要生产的代码的数据库模型，也就是生产的代码依据哪个数据库表。

配置在conf/generator.xml,详细解释：
1、<project:driver>是数据库驱动和用户密码等配置


2、<project:base>配置的是工程的基础信息，
   包括存放生产代码的目录、工程顶级包、工程各层包名规范，如下：

	<project:base>
		<!-- 生成代码存放路径 -->
		<property name="targetPath"  value="E:\temp"/>
		<!-- 工程的顶层包名 -->
		<property name="rootPackage" value="com.baidu.dpop.rmp"/>
		<property name="boPackage" value="${rootPackage}.${modulename}.bo"/>
		<property name="mapperPackage" value="${rootPackage}.${modulename}.dao.mapper"/>
		<property name="daoPackage" value="${rootPackage}.${modulename}.dao"/>
		<property name="daoImplPackage" value="${rootPackage}.${modulename}.dao.impl"/>
		<property name="servicePackage" value="${rootPackage}.${modulename}.service"/>
		<property name="serviceImplPackage" value="${rootPackage}.${modulename}.service.impl"/>
		<property name="controllerPackage" value="${rootPackage}.${modulename}.web.controller"/>
		<property name="validatorPackage" value="${rootPackage}.${modulename}.web.validator"/>
		
		<!-- 修改表格字段时候：<property name="generators" 	value="bo-base,mapperxml-base"></property> -->
		<!-- 新建表格的时候：     <property name="generators" 	value="bo,bo-base,mapper,mapperxml,mapperxml-base,dao,dao-ipml,service,service-impl,controller,form,validator"></property> -->
		<!--  <property name="generators" 	value="mapperxml-base"></property> -->
	</project:base>

表示生产的代码存放在E:\temp下面，顶级包名叫“com.baidu.dpop.rmp”；
BO层包名生产规范是${rootPackage}.${modulename}.bo，modulename后面会介绍；
同理服务层包名是${rootPackage}.${modulename}.service"。



3、<project:table>表示是生产的模型，模型的基本属性从<project:base>继承而来，如果本处自己设定了包名规则，则会覆盖<project:base>的设置。
详细设置DEMO如下：

	<project:table>
		<!-- 表名 -->
		<property name="tablename"  value="tb_material"></property>
		<!-- 模块名称，生成java代码包路径的时候需要替换，不能大写 -->
		<property name="modulename" value="material"></property>
		<!-- 模型的BO名称，生成java代码BO名称，不填写的时候是表名驼峰规则转化而来 -->
		<property name="boname" 	value="Material"></property>
	</project:table>

上述设置表示依据表名tb_material生产代码，模块名（modulename注：上面的规则就是用此处去替换）称是material ,BO名称是Material 其他的包名规则重base继承而来。


<project:table>可以设置多个，表明可以生产多个模块的代码。

