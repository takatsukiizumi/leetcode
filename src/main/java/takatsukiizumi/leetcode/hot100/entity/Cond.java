package takatsukiizumi.leetcode.hot100.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Cond {
    // 字段名
    private String field;
    // 字段类型
    private String type;
    //		过滤方法：
    //
    //“not_empty”(不为空)，
    //
    //“empty”(为空)，
    //
    //“eq”(等于)，
    //
    //“in”(等于任意一个)，最多可传递 200 个
    //
    //“range”(在x与y之间，并且包含x和y本身)，
    //
    //“nin”(不等于任意一个)，最多可传递 200 个
    //
    //“ne”(不等于),
    //
    //“like”(文本包含)
    //
    //“verified“(表示填写了手机号且已验证的值)
    //
    //“unverified“(表示填写了手机号但未验证值)
    private String method;
    private Object value;

    public Cond() {};
    public Cond(String field,String method,Object value) {
        this.field = field;
        this.method = method;
        this.value = value;
    }
}