import java.time.ZonedDateTime;

public class T2 {
    public static void main(String[] args) {
        ZonedDateTime dateTime = ZonedDateTime.now();  //默认时区
        System.out.println(dateTime);
        //2021-04-10T18:24:19.881+08:00[Asia/Shanghai]
    }
}
