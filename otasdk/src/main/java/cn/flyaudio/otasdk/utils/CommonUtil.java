package cn.flyaudio.otasdk.utils;

import cn.flyaudio.otasdk.FlyFotaApplicationInit;
import cn.flyaudio.otasdk.R;

/**
 * Created by SerryWang
 * on 2019/4/17
 * @author wydnn
 */
public final class CommonUtil {

    private CommonUtil(){}

    /**
     * 根据Flag判断相应的条件
     * @return
     */
    public static String judgeFlag(String flag){

        switch (flag){
            // 操作成功
            case "100":
                return FlyFotaApplicationInit.mContext.getString(R.string.successful_operation);
            // 操作失败
            case "101":
                return FlyFotaApplicationInit.mContext.getString(R.string.operation_failed);
            // 没有找到差分包
            case "102":
                return FlyFotaApplicationInit.mContext.getString(R.string.no_differential_packet_was_found);
             // 没有上传完整包
            case "103":
                return FlyFotaApplicationInit.mContext.getString(R.string.there_is_no_latest_update_package);
            // 系统中没有IMEI
            case "104":
                return FlyFotaApplicationInit.mContext.getString(R.string.there_is_no_IMEI_in_the_system);
            // 厂商平台或者默认策略不存在
            case "105":
                return FlyFotaApplicationInit.mContext.getString(R.string.vendor_platform_or_default_policy_does_not_exist);
            // 传入的新版本或者老版本没有找到相应的包
            case "106":
                return FlyFotaApplicationInit.mContext.getString(R.string.the_incoming_new_version_or_old_version_did_not_find_the_corresponding_package);
            case "107":
                return FlyFotaApplicationInit.mContext.getString(R.string.there_is_no_package_uploaded_from_the_manufacturer_in_the_system);
                default:
                    break;
        }

        return null;
    }
}
