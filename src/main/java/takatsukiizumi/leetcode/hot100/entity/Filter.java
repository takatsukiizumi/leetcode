package takatsukiizumi.leetcode.hot100.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@ToString
public class Filter {
    // 筛选组合关系；“and”(满足所有过滤条件), “or”(满足任一过滤条件)
    private String rel = "and";
    // 过滤条件列表
    private List<Cond> cond;

    public Filter() {
        super();
    };
    public Filter(List<Cond> cond) {
        this.cond = cond;
    }

}