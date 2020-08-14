# SyncDataSource
SpringBoot+JDBCtTemplate 做的动态数据源切换。
DateSourceConfig  里面有关于mybitas数据的配置，打开注释就可以换成SpringBoot+mybitas的动态数据源切换
数据源默认走的是slave,如果添加@Master 注解，才会走主库
