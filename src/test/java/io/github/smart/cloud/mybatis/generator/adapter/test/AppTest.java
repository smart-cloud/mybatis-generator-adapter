package io.github.smart.cloud.mybatis.generator.adapter.test;

import org.junit.jupiter.api.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AppTest {

    @Test
    public void testGenerateCode() throws XMLParserException, IOException, InvalidConfigurationException, SQLException, InterruptedException {
        List<String> warnings = new ArrayList<>();
        boolean overwrite = true;
        ClassPathResource classPathResource = new ClassPathResource("10000.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration configuration = cp.parseConfiguration(classPathResource.getFile());
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator generator = new MyBatisGenerator(configuration, callback, warnings);
        generator.generate(null);

        warnings.forEach(System.out::println);
    }

}