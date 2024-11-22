package io.github.smart.cloud.mybatis.generator.adapter.plugin;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.config.TableConfiguration;

import java.util.List;

/**
 * 分库分表的表名移除后缀下标
 *
 * @author collin
 * @date 2023-08-03
 */
public class RenameSqlMapperTableNamePlugin extends PluginAdapter {

    public RenameSqlMapperTableNamePlugin() {
    }

    @Override
    public boolean validate(List<String> warnings) {
        return true;
    }

    @Override
    public void initialized(IntrospectedTable introspectedTable) {
        TableConfiguration tc = introspectedTable.getTableConfiguration();
        String oldTableName = tc.getTableName();
        if (!oldTableName.endsWith("_0")) {
            return;
        }

        String newTableName = oldTableName.substring(0, oldTableName.length() - 2);
        introspectedTable.setSqlMapFullyQualifiedRuntimeTableName(newTableName);
        introspectedTable.setSqlMapAliasedFullyQualifiedRuntimeTableName(newTableName);
    }

}