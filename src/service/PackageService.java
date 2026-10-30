package src.service;

import src.entity.Package;
import java.util.List;

/**
 * 包裹服务接口
 */
public interface PackageService {

    /**
     * 包裹入库
     * @param pkg 包裹信息
     * @return 入库后的包裹（含取件码）
     */
    Package inbound(Package pkg);

    /**
     * 包裹出库
     * @param pickupCode 取件码
     * @return 出库成功返回true，失败返回false
     */
    boolean outbound(String pickupCode);

    /**
     * 根据手机号查询包裹
     * @param phone 收件人手机号
     * @return 包裹列表
     */
    List<Package> listByPhone(String phone);

    /**
     * 根据取件码查询包裹
     * @param pickupCode 取件码
     * @return 包裹信息
     */
    Package getByPickupCode(String pickupCode);

    /**
     * 更新包裹状态
     * @param packageId 包裹ID
     * @param status 新状态
     */
    void updateStatus(Long packageId, String status);

    /**
     * 生成取件码
     * @return 6位数字取件码
     */
    String generatePickupCode();
}

