package redis.redission;

import org.redisson.api.RedissonClient;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;



/**
 * @Description:
 * @author: takatsukiizumi
 * @date: 2023/3/16
 */

public class RBinaryStream {

        public static void main(String[] args) throws Exception {
            RedissionUtil redissionUtil = new RedissionUtil();
            // 初始化Redisson客户端连接
            RedissonClient redisson = redissionUtil.getRedissionObject();
            // 获取二进制流对象
            org.redisson.api.RBinaryStream stream = redisson.getBinaryStream("test_stream");

            // 写入对象到二进制流中
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(new User("Alice", 20, "Female"));
            byte[] bytes = baos.toByteArray();
            stream.set(bytes);

            // 从二进制流中读取对象
            byte[] bytes2 = stream.get();
            ByteArrayInputStream bais = new ByteArrayInputStream(bytes2);
            ObjectInputStream ois = new ObjectInputStream(bais);
            User user = (User) ois.readObject();
            System.out.println(user);

            // 关闭Redisson客户端连接
            redisson.shutdown();
        }

        // 定义一个简单的User类
        static class User implements java.io.Serializable {
            private static final long serialVersionUID = 1L;
            String name;
            int age;
            String gender;
            public User(String name, int age, String gender) {
                this.name = name;
                this.age = age;
                this.gender = gender;
            }
            public String toString() {
                return "User [name=" + name + ", age=" + age + ", gender=" + gender + "]";
            }
        }



}
