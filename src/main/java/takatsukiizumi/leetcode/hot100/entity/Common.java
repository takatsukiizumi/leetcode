package takatsukiizumi.leetcode.hot100.entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Common {

    String app_id = "6463182431ae0900082ea055";

    String entry_id;

    public Common() {
        super();
    };

    public Common(String entry_id) {
        this.entry_id = entry_id;
    };
}

