package cn.flyaudio.otasdk.upgrade;

import android.content.Context;

import cn.flyaudio.otasdk.recovery.RecoveryAdapter;

/**
 * @author weifule
 * @date 19-7-3
 * Email: fulewei@foxmail.com
 * Description:
 */
public class UpgradePresenterImpl implements IUpgradePresenter {

    private final IUpgrade upgrade;
    private final IUpgradeModel model;

    UpgradePresenterImpl(IUpgrade upgrade, IUpgradeModel model){
        this.upgrade = upgrade;
        this.model = model;
    }

    @Override
    public void download() {
        model.download();
    }

    @Override
    public void cancelDownload() {
        model.cancelDownload();
    }

    @Override
    public void upgrade() {
        model.upgrade();
    }

    @Override
    public void installSystem(Context context) {
        RecoveryAdapter adapter = upgrade.getRecoveryAdapter();
        if (adapter != null){
            //TODO FlyFotaApplication.getPackageFile() 后期修改此获取方式
           // adapter.installSystemNow(context, FlyFotaApplication.getPackageFile());
        }
    }
}
