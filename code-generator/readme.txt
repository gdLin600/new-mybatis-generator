����generator.bat������������.
������֮ǰ����������Ҫ�����Ĵ�������ݿ�ģ�ͣ�Ҳ���������Ĵ��������ĸ����ݿ��

������conf/generator.xml,��ϸ���ͣ�
1��<project:driver>�����ݿ��������û����������


2��<project:base>���õ��ǹ��̵Ļ�����Ϣ��
   ����������������Ŀ¼�����̶����������̸�������淶�����£�

	<project:base>
		<!-- ���ɴ�����·�� -->
		<property name="targetPath"  value="E:\temp"/>
		<!-- ���̵Ķ������ -->
		<property name="rootPackage" value="com.baidu.dpop.rmp"/>
		<property name="boPackage" value="${rootPackage}.${modulename}.bo"/>
		<property name="mapperPackage" value="${rootPackage}.${modulename}.dao.mapper"/>
		<property name="daoPackage" value="${rootPackage}.${modulename}.dao"/>
		<property name="daoImplPackage" value="${rootPackage}.${modulename}.dao.impl"/>
		<property name="servicePackage" value="${rootPackage}.${modulename}.service"/>
		<property name="serviceImplPackage" value="${rootPackage}.${modulename}.service.impl"/>
		<property name="controllerPackage" value="${rootPackage}.${modulename}.web.controller"/>
		<property name="validatorPackage" value="${rootPackage}.${modulename}.web.validator"/>
		
		<!-- �޸ı���ֶ�ʱ��<property name="generators" 	value="bo-base,mapperxml-base"></property> -->
		<!-- �½�����ʱ��     <property name="generators" 	value="bo,bo-base,mapper,mapperxml,mapperxml-base,dao,dao-ipml,service,service-impl,controller,form,validator"></property> -->
		<!--  <property name="generators" 	value="mapperxml-base"></property> -->
	</project:base>

��ʾ�����Ĵ�������E:\temp���棬���������С�com.baidu.dpop.rmp����
BO����������淶��${rootPackage}.${modulename}.bo��modulename�������ܣ�
ͬ�����������${rootPackage}.${modulename}.service"��



3��<project:table>��ʾ��������ģ�ͣ�ģ�͵Ļ������Դ�<project:base>�̳ж�������������Լ��趨�˰���������Ḳ��<project:base>�����á�
��ϸ����DEMO���£�

	<project:table>
		<!-- ���� -->
		<property name="tablename"  value="tb_material"></property>
		<!-- ģ�����ƣ�����java�����·����ʱ����Ҫ�滻�����ܴ�д -->
		<property name="modulename" value="material"></property>
		<!-- ģ�͵�BO���ƣ�����java����BO���ƣ�����д��ʱ���Ǳ����շ����ת������ -->
		<property name="boname" 	value="Material"></property>
	</project:table>

�������ñ�ʾ���ݱ���tb_material�������룬ģ������modulenameע������Ĺ�������ô˴�ȥ�滻������material ,BO������Material �����İ���������base�̳ж�����


<project:table>�������ö�������������������ģ��Ĵ��롣

