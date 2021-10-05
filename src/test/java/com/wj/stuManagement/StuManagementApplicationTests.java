package com.wj.stuManagement;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
class StuManagementApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void testGenerator() {
//全局配置
		GlobalConfig config = new GlobalConfig();
		config.setActiveRecord(true) //是否支持AR模式
				.setAuthor("wangjin") //作者
				.setOutputDir("D:\\java_course\\code1\\src\\main\\java")
//生成路径
				.setFileOverride(true)//文件覆盖
				.setServiceName("%sService") //设置生成的service接口名首字母是否为I
				.setIdType(IdType.AUTO) //主键策略
		;
		//数据源配置
		DataSourceConfig dsConfig = new DataSourceConfig();
		dsConfig.setDbType(DbType.MYSQL)
				.setUrl("jdbc:mysql://localhost:3306/mp?useSSL=false&useUnicode=true&characterEncoding=utf-8&serverTimezone=GMT%2B8")
				.setDriverName("com.mysql.jdbc.Driver")
				.setUsername("root")
				.setPassword("123456");
//策略配置
		StrategyConfig stConfig = new StrategyConfig();
		stConfig.setCapitalMode(true) // 全局大写命名
				//.setDbColumnUnderline(true) //表名 字段名 是否使用下滑 线命名
				.setNaming(NamingStrategy.underline_to_camel) // 数据 库表映射到实体的命名策略
				.setInclude("tbl_employee","tbl_user") //生成的表
				.setTablePrefix("tbl_") // 表前缀
				.setEntityLombokModel(true);
//包名策略
		PackageConfig pkConfig = new PackageConfig();
		pkConfig.setParent("com.wj.mp")
				.setController("controller")
				.setEntity("beans")
				.setService("service");
		AutoGenerator ag = new
				AutoGenerator().setGlobalConfig(config)
				.setDataSource(dsConfig)
				.setStrategy(stConfig)
				.setPackageInfo(pkConfig);
		ag.execute();
	}

	@Test
	public void testCode(){
		// 需要构建一个 代码自动生成器 对象
		AutoGenerator mpg = new AutoGenerator();
// 配置策略
// 1、全局配置
		GlobalConfig gc = new GlobalConfig();
		gc.setOutputDir("D:\\java_course\\springbootStu\\stuManagement\\src\\main\\java");
		gc.setAuthor("WangJin");
		gc.setOpen(false);
		gc.setFileOverride(false); // 是否覆盖
		gc.setServiceName("%sService"); // 去Service的I前缀
		gc.setIdType(IdType.ID_WORKER);
		gc.setDateType(DateType.ONLY_DATE);
		gc.setSwagger2(true);
		mpg.setGlobalConfig(gc);
//2、设置数据源
		DataSourceConfig dsc = new DataSourceConfig();
		dsc.setUrl("jdbc:mysql://localhost:3306/stu? useSSL=false&useUnicode=true&characterEncoding=utf-8&serverTimezone=GMT%2B8");
		dsc.setDriverName("com.mysql.cj.jdbc.Driver");
		dsc.setUsername("root");
		dsc.setPassword("123456");
		dsc.setDbType(DbType.MYSQL);
		mpg.setDataSource(dsc);
//3、包的配置
		PackageConfig pc = new PackageConfig();
		//pc.setModuleName("blog");
		pc.setParent("com.wj.stuManagement");
		pc.setEntity("entity");
		pc.setMapper("mapper");
		pc.setService("service");
		pc.setController("controller");
		mpg.setPackageInfo(pc);
//4、策略配置
		StrategyConfig strategy = new StrategyConfig();
		strategy.setInclude("student"); // 设置要映射的表名
		strategy.setNaming(NamingStrategy.underline_to_camel);
		strategy.setColumnNaming(NamingStrategy.underline_to_camel);
		strategy.setEntityLombokModel(true); // 自动lombok；
		strategy.setLogicDeleteFieldName("deleted");
// 自动填充配置
		TableFill gmtCreate = new TableFill("gmt_create", FieldFill.INSERT);
		TableFill gmtModified = new TableFill("gmt_modified",
				FieldFill.INSERT_UPDATE);
		ArrayList<TableFill> tableFills = new ArrayList<>();
		tableFills.add(gmtCreate);
		tableFills.add(gmtModified);
		strategy.setTableFillList(tableFills);
		mpg.execute(); //执行
	}

}
