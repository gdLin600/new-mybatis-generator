package org.mybatis.generator.plugins.myplugins;

import org.mybatis.generator.codegen.mybatis3.IntrospectedTableMyBatis3Impl;

import java.text.MessageFormat;

import static org.mybatis.generator.internal.util.StringUtility.stringHasValue;

public class TkMyBatis3Impl extends IntrospectedTableMyBatis3Impl {
    @Override
    protected String calculateMyBatis3XmlMapperFileName() {
        StringBuilder sb = new StringBuilder();
        //  去掉false 则支持mapperName = "{0}Dao" 等用法 会使 mapper.xml 变为 dao.xml
        if (stringHasValue(tableConfiguration.getMapperName())) {
            String mapperName = tableConfiguration.getMapperName();
            int appearNumber = appearNumber(mapperName, "{");
            boolean flag = true;
            if (appearNumber>1) {
                 int indexOf = mapperName.indexOf("{", 3);
                 String showMapper = mapperName.substring(indexOf);
                 showMapper = showMapper.substring(1,2);
                 flag = showMapper.equals("1");
                 mapperName = mapperName.substring(0,indexOf);
            }
            int ind = mapperName.lastIndexOf('.');
            if (ind != -1) {
                mapperName = mapperName.substring(ind + 1);
            }
            if (flag) {
                sb.append(fullyQualifiedTable.getDomainObjectName());
                sb.append("Mapper.xml"); //$NON-NLS-1$
            }else {
                //支持mapperName = "{0}Dao" 等用法
                sb.append(MessageFormat.format(mapperName, fullyQualifiedTable.getDomainObjectName()));
                sb.append(".xml"); //$NON-NLS-1$
            }
        } else {
            sb.append(fullyQualifiedTable.getDomainObjectName());
            sb.append("Mapper.xml"); //$NON-NLS-1$
        }
        return sb.toString();
    }
    /**
     * public int indexOf(int ch, int fromIndex)
     * 返回在此字符串中第一次出现指定字符处的索引，从指定的索引开始搜索
     * 
     * @param srcText
     * @param findText
     * @return
     */
    private int appearNumber(String srcText, String findText) {
        int count = 0;
        int index = 0;
        while ((index = srcText.indexOf(findText, index)) != -1) {
            index = index + findText.length();
            count++;
        }
        return count;
    }

    @Override
    protected void calculateJavaClientAttributes() {
        if (context.getJavaClientGeneratorConfiguration() == null) {
            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(calculateJavaClientImplementationPackage());
        sb.append('.');
        sb.append(fullyQualifiedTable.getDomainObjectName());
        sb.append("DAOImpl"); //$NON-NLS-1$
        setDAOImplementationType(sb.toString());

        sb.setLength(0);
        sb.append(calculateJavaClientInterfacePackage());
        sb.append('.');
        sb.append(fullyQualifiedTable.getDomainObjectName());
        sb.append("DAO"); //$NON-NLS-1$
        setDAOInterfaceType(sb.toString());

        sb.setLength(0);
        sb.append(calculateJavaClientInterfacePackage());
        sb.append('.');
        String mapperName = tableConfiguration.getMapperName();
        if (stringHasValue(tableConfiguration.getMapperName())) {
            //支持mapperName = "{0}Dao" 等用法
            int appearNumber = appearNumber(mapperName, "{");
            if (appearNumber>1) {
                 int indexOf = mapperName.indexOf("{", 3);
                 mapperName = mapperName.substring(0,indexOf);
            }
            sb.append(MessageFormat.format(mapperName, fullyQualifiedTable.getDomainObjectName()));
        } else {
            sb.append(fullyQualifiedTable.getDomainObjectName());
            sb.append("Mapper"); //$NON-NLS-1$
        }
        setMyBatis3JavaMapperType(sb.toString());

        sb.setLength(0);
        sb.append(calculateJavaClientInterfacePackage());
        sb.append('.');
        if (stringHasValue(tableConfiguration.getSqlProviderName())) {
            //支持mapperName = "{0}SqlProvider" 等用法
            sb.append(MessageFormat.format(tableConfiguration.getSqlProviderName(), fullyQualifiedTable.getDomainObjectName()));
        } else {
            sb.append(fullyQualifiedTable.getDomainObjectName());
            sb.append("SqlProvider"); //$NON-NLS-1$
        }
        setMyBatis3SqlProviderType(sb.toString());
    }
}
