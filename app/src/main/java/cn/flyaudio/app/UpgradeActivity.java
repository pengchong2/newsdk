package cn.flyaudio.app;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import java.io.File;

import cn.flyaudio.otasdk.recovery.BaseRecoveryAdapter;
import cn.flyaudio.otasdk.recovery.RecoveryAdapter;
import cn.flyaudio.otasdk.upgrade.IUpgrade;

/**
 * FOTA升级界面Activity
 * @author weifule
 * @date 19-7-1
 */
public class UpgradeActivity extends Activity implements IUpgrade {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onStateChanged() {

    }

    @Override
    public void onDownloadProgress(int progress) {

    }

    @Override
    public void onDownloadFail(int code, String reason) {

    }

    @Override
    public void onDownloadPaused() {

    }

    @Override
    public void onDownloadSuccess() {

    }

    @Override
    public void onUpgradeProgress(int progress) {

    }

    @Override
    public void onUpgradeFail(int code, String reason) {

    }

    @Override
    public void onUpgradeWriteDone() {

    }

    @Override
    public void onUpgradeSuccess() {

    }

    @Override
    public RecoveryAdapter getRecoveryAdapter() {
        return new MyAdapter();
    }

    private class MyAdapter extends BaseRecoveryAdapter{

        @Override
        public void installSystemNow(Context context, File file) {
            //TODO 实现自定义的升级方式
        }
    }


}
