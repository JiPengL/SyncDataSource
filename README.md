SpringBoot+JDBCtTemplate+Mybatis


SpringBoot+JDBCtTemplate 做的动态数据源切换。

DateSourceConfig  里面有关于mybitas数据的配置，打开注释就可以换成SpringBoot+mybitas的动态数据源切换

数据源默认走的是slave（在DateSourceConfig配置）, 在service上添加@Master 注解，才会走主库



SpringBoot+Mybatis 做的动态数据源切换。

修改了mybatis 配置，默认走的是 jdbc,需要讲mybatis的内容释放就可以执行
