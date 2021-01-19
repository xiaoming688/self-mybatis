package com.myself.v1;

public class MySqlSession {
    //配置类
    private MyConfiguration configuration;

    private MyExecutor executor;

    public MySqlSession(MyConfiguration configuration, MyExecutor executor) {
        this.configuration = configuration;
        this.executor = executor;
    }

    public <T> T selectOne(String statementId, Object param) {

        String sql = MyConfiguration.sqlMapping.getString(statementId);
        if (!"".equals(sql)) {
            return executor.query(sql, param);
        }
        return null;
    }

    public <T> T getMapper(Class clazz) {
        return configuration.getMapper(clazz, this);
    }

}
