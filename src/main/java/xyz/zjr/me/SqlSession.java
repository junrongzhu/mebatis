package xyz.zjr.me;

/**
 * <p>
 * Description:
 * <p>
 *
 * @author zjr
 * @date 2020-05-16 10:51
 */
public class SqlSession {
    private Configuration configuration;
    private Executor executor;

    public SqlSession(Configuration configuration, Executor executor) {
        this.configuration = configuration;
        this.executor = executor;
    }

    public <T>T selectOne(String statementId, Object params){
        String sql = Configuration.mappings.getString(statementId);
        if (sql != null) {
            return executor.query(sql, params);
        }
        return null;
    }

    public <T>T getMapper(Class clazz){
        return configuration.getMapper(clazz, this);
    }
}
