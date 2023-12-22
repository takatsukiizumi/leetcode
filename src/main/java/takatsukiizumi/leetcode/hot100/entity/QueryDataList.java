package takatsukiizumi.leetcode.hot100.entity;

import java.util.List;

public class QueryDataList extends Common{

    // 上一次查询数据结果的最后一条数据的ID，没有则留空
    private String data_id;
    // 需要查询的数据字段
    private List<String> fields;
    // 数据筛选器
    private Filter filter;
    // 查询的数据条数，1~100，默认10
    private Integer limit = 100;

    public QueryDataList() {
        super();
    };
    public QueryDataList(String entry_id,String data_id,List<String> fields,List<Cond> condlist) {
        super(entry_id);
        this.data_id = data_id;
        this.fields = fields;
        Filter filter = new Filter(condlist);
        this.filter = filter;
    };

    public QueryDataList(String entry_id,String data_id,List<String> fields,List<Cond> condlist,Integer limit) {
        super(entry_id);
        this.data_id = data_id;
        this.fields = fields;
        Filter filter = new Filter(condlist);
        this.filter = filter;
        this.limit = limit;
    };


}
