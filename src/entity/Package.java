package src.entity;

import src.constant.PackageStatus;
import java.util.Date;

/**
 * 包裹实体类
 */
public class Package {
    private Long id;
    private String trackingNumber;      // 快递单号
    private String pickupCode;          // 取件码
    private String receiverPhone;       // 收件人手机号
    private String receiverName;        // 收件人姓名
    private String courierCompany;       // 快递公司
    private PackageStatus status;       // 包裹状态
    private Date inboundTime;           // 入库时间
    private Date pickupTime;            // 取件时间
    private String storageLocation;     // 存放位置

    // 构造方法
    public Package() {}

    public Package(String trackingNumber, String receiverPhone, String courierCompany) {
        this.trackingNumber = trackingNumber;
        this.receiverPhone = receiverPhone;
        this.courierCompany = courierCompany;
        this.status = PackageStatus.IN_STOCK;
        this.inboundTime = new Date();
    }

    // getter和setter
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTrackingNumber() { return trackingNumber; }
    public void setTrackingNumber(String trackingNumber) { this.trackingNumber = trackingNumber; }

    public String getPickupCode() { return pickupCode; }
    public void setPickupCode(String pickupCode) { this.pickupCode = pickupCode; }

    public String getReceiverPhone() { return receiverPhone; }
    public void setReceiverPhone(String receiverPhone) { this.receiverPhone = receiverPhone; }

    public String getReceiverName() { return receiverName; }
    public void setReceiverName(String receiverName) { this.receiverName = receiverName; }

    public String getCourierCompany() { return courierCompany; }
    public void setCourierCompany(String courierCompany) { this.courierCompany = courierCompany; }

    public PackageStatus getStatus() { return status; }
    public void setStatus(PackageStatus status) { this.status = status; }

    public Date getInboundTime() { return inboundTime; }
    public void setInboundTime(Date inboundTime) { this.inboundTime = inboundTime; }

    public Date getPickupTime() { return pickupTime; }
    public void setPickupTime(Date pickupTime) { this.pickupTime = pickupTime; }

    public String getStorageLocation() { return storageLocation; }
    public void setStorageLocation(String storageLocation) { this.storageLocation = storageLocation; }

    @Override
    public String toString() {
        return "Package{" +
                "id=" + id +
                ", trackingNumber='" + trackingNumber + '\'' +
                ", pickupCode='" + pickupCode + '\'' +
                ", receiverPhone='" + receiverPhone + '\'' +
                ", status=" + status +
                '}';
    }
}

