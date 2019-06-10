开发规范
获取当前登录用户
//在Controller层方法参数添加如下
@ApiIgnore @CurrentUser User user
取消页面授权
//用户登录接口,和非授权就可以访问的接口...
//在Controller层方法上加注解
@Permission(action = Action.Skip)
强制更新控制
//取消接口强制更新约束，用于回调函数接口...
//在Controller层方法上加注解
@ForceUpdate(required = false)
Bean校验
//1. Bean添加valid相关注解校验
//2. 在Service层方法上加注解验证
@Validated
使用时间类
LocalDate, LocalTime, LocalDateTime, Year
定义序列化/反序列化类
OssKeySerializer OssKey序列化
OssKeyListSerializer OssKey列表序列化
ArraySerializer 数组序列化(xx,xx -> 数组)
ArrayDeserializer 数组反序列化(数组 -> xx,xx)
编码规范
ORM的映射需要保证表字段的顺序与类属性的顺序一致
使用lombok简化开发(如简化set,get方法…)
@JsonView过滤序列化对象的字段属性
反馈机制
数据库的变动需要通知
java工程pom.xml, application-xxx.xml, config-xxx.conf的变动需要通知