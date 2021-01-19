import com.myself.v1.MyConfiguration;
import com.myself.v1.MyExecutor;
import com.myself.v1.MySqlSession;
import com.myself.v1.mapper.UserMapper;

public class MyTest {
    public static void main(String[] args) {
        MySqlSession sqlSession = new MySqlSession(new MyConfiguration(), new MyExecutor());
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.selectById(1);
    }
}
