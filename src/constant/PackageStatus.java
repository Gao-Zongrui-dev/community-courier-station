package src.constant;

/**
 * 包裹状态枚举
 */
public enum PackageStatus {
    IN_STOCK("在库", 1),
    PICKED_UP("已取件", 2),
    EXPIRED("已超期", 3),
    RETURNED("已退回", 4);

    private String desc;
    private int code;

    PackageStatus(String desc, int code) {
        this.desc = desc;
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public int getCode() {
        return code;
    }
}

