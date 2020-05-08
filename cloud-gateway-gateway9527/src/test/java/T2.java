import java.time.ZonedDateTime;

/**
 * @author: zhanxg
 * @create: 2020/5/1 12:24
 */
public class T2 {
    public static void main(String[] args) {
        /**
         * java8 新特性
         */
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println(now);

        //2020-05-01T12:25:44.981+08:00[Asia/Shanghai]
    }
}
