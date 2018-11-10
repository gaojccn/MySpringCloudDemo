package generator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.AbstractTemplateEngine;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import freemarker.cache.TemplateConfigurationFactory;

/**
 * MybatisPlus AutoGenerateCode util class
 * @author gaojc
 * @date 2018/11/10
 */
public class MybatisAutoGenerator {
    public static void main(String[] args) {
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir("E:\\IdeaProjects\\MySpringCloudDemo\\service-provider\\src\\main");
        gc.setFileOverride(true);
        gc.setActiveRecord(true);
//        gc.setEnableCache(true);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(true);// XML columList
        gc.setAuthor("gaojc");
        gc.setDateType(DateType.ONLY_DATE);
        gc.setEnableCache(false);

// 自定义文件命名，注意 %s 会自动填充表实体属性！
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        gc.setSwagger2(true);
//        gc.setServiceName("%sService");
//        gc.setServiceImplName("%sServiceImpl");
        gc.setControllerName("%sController");
        mpg.setGlobalConfig(gc);

// 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
/*dsc.setTypeConvert(new MySqlTypeConvert(){
    // 自定义数据库表字段类型转换【可选】
    @Override
    public DbColumnType processTypeConvert(String fieldType) {
        System.out.println("转换类型：" + fieldType);
        return super.processTypeConvert(fieldType);
    }
});*/

        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUrl("jdbc:mysql://localhost:3306/bank?useUnicode=true&amp;characterEncoding=UTF-8&amp;generateSimpleParameterMetadata=true");
        dsc.setUsername("gaojc");
        dsc.setPassword("gaojc");
        mpg.setDataSource(dsc);

// 策略配置
        StrategyConfig strategy = new StrategyConfig();
// strategy.setCapitalMode(true);// 全局大写命名 ORACLE 注意
// strategy.setTablePrefix(new String[] { "tlog_", "tsys_" });// 此处可以修改为您的表前缀
        strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
// strategy.setInclude(new String[] { "user" }); // 需要生成的表
// strategy.setExclude(new String[]{"test"}); // 排除生成的表
        strategy.setExclude("user");
        strategy.setEntityLombokModel(true);
        strategy.setEntityBuilderModel(true);
        strategy.setRestControllerStyle(true);
//        strategy.setSuperControllerClass("BaseController");
//        strategy.setSuperServiceImplClass(ServiceImpl.class.getName());
        mpg.setStrategy(strategy);

// 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com");
//        pc.setModuleName("model");
//        pc.setMapper("mapper");
//        pc.setEntity("entity");
//        pc.setController("controller");
        mpg.setPackageInfo(pc);

        mpg.setTemplateEngine(new FreemarkerTemplateEngine());

// 执行生成
        mpg.execute();
    }
}
