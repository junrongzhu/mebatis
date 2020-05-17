package xyz.zjr.me;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * <p>
 * Description:
 * <p>
 *
 * @author zjr
 * @date 2020-05-16 10:53
 */
public class MapperProxy implements InvocationHandler {
    private SqlSession sqlSession;

    public MapperProxy(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String mapperInteface = method.getDeclaringClass().getName();
        String methodName = method.getName();
        String statementId = mapperInteface+"."+methodName;
        return sqlSession.selectOne(statementId, args[0]);
    }
}
