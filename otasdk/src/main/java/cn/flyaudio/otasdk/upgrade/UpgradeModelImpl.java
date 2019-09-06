package cn.flyaudio.otasdk.upgrade;

import cn.flyaudio.otasdk.IFlyFotaProxy;

/**
 * @author weifule
 * @date 19-7-3
 * Email: fulewei@foxmail.com
 * Description:
 */
public class UpgradeModelImpl implements IUpgradeModel {

    private IFlyFotaProxy proxy;

    public UpgradeModelImpl() {

    }

    @Override
    public void checkUpdate() {
        proxy.checkUpdate();
    }

    @Override
    public void download() {
        proxy.download();
    }

    @Override
    public void cancelDownload() {
        proxy.cancelDownload();
    }

    @Override
    public void upgrade() {

    }

}
