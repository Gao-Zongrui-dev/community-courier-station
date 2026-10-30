package src.service.impl;

import src.constant.PackageStatus;
import src.entity.Package;
import src.service.PackageService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * 包裹服务实现类
 */
public class PackageServiceImpl implements PackageService {

    // 模拟数据库存储
    private List<Package> packageDB = new ArrayList<>();
    private Long autoIncrementId = 1L;

    @Override
    public Package inbound(Package pkg) {
        // 设置ID
        pkg.setId(autoIncrementId++);
        // 生成取件码
        String pickupCode = generatePickupCode();
        pkg.setPickupCode(pickupCode);
        // 设置状态为在库
        pkg.setStatus(PackageStatus.IN_STOCK);
        pkg.setInboundTime(new Date());
        // 存入数据库
        packageDB.add(pkg);
        return pkg;
    }

    @Override
    public boolean outbound(String pickupCode) {
        Package pkg = getByPickupCode(pickupCode);
        if (pkg == null) {
            System.out.println("取件码不存在：" + pickupCode);
            return false;
        }
        if (pkg.getStatus() != PackageStatus.IN_STOCK) {
            System.out.println("包裹状态异常：" + pkg.getStatus().getDesc());
            return false;
        }
        // 更新状态为已取件
        pkg.setStatus(PackageStatus.PICKED_UP);
        pkg.setPickupTime(new Date());
        return true;
    }

    @Override
    public List<Package> listByPhone(String phone) {
        List<Package> result = new ArrayList<>();
        for (Package pkg : packageDB) {
            if (phone.equals(pkg.getReceiverPhone())) {
                result.add(pkg);
            }
        }
        return result;
    }

    @Override
    public Package getByPickupCode(String pickupCode) {
        for (Package pkg : packageDB) {
            if (pickupCode.equals(pkg.getPickupCode())) {
                return pkg;
            }
        }
        return null;
    }

    @Override
    public void updateStatus(Long packageId, String status) {
        for (Package pkg : packageDB) {
            if (pkg.getId().equals(packageId)) {
                pkg.setStatus(PackageStatus.valueOf(status));
                break;
            }
        }
    }

    @Override
    public String generatePickupCode() {
        // 生成6位随机数字取件码
        Random random = new Random();
        StringBuilder code = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            code.append(random.nextInt(10));
        }
        return code.toString();
    }

    // 测试方法
    public static void main(String[] args) {
        PackageService service = new PackageServiceImpl();

        // 测试入库
        Package pkg = new Package("SF1234567890", "13800138000", "顺丰速运");
        Package saved = service.inbound(pkg);
        System.out.println("入库成功：" + saved);

        // 测试查询
        List<Package> list = service.listByPhone("13800138000");
        System.out.println("查询到" + list.size() + "个包裹");

        // 测试出库
        boolean success = service.outbound(saved.getPickupCode());
        System.out.println("出库结果：" + success);
    }
}

