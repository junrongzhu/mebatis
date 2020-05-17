package xyz.zjr.me;

import java.lang.reflect.Proxy;
import java.util.ResourceBundle;

/**
 * <p>
 * Description:
 * <p>
 *
 * @author zjr
 * @date 2020-05-16 10:49
 */
public class Configuration {
    public static final ResourceBundle mappings;
    static {
        mappings = ResourceBundle.getBundle("mesql");
    }

    public <T> T getMapper(Class clazz, SqlSession sqlSession){
        return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(),
                new Class[]{clazz},
                new MapperProxy(sqlSession));
    }
}
