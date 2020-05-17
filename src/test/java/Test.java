import xyz.zjr.me.*;

/**
 * <p>
 * Description:
 * <p>
 *
 * @author zjr
 * @date 2020-05-16 21:51
 */
public class Test {
    public static void main(String[] args) {
        SqlSession sqlSession = new SqlSession(new Configuration(), new Executor());
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Blog blog = mapper.selectOne(1);
        System.out.println(blog);
    }
}
