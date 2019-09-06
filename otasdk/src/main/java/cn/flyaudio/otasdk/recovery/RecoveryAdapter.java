package cn.flyaudio.otasdk.recovery;

import android.content.Context;

import java.io.File;

/**
 * @author weifule
 * @date 19-7-3
 * Email: fulewei@foxmail.com
 * Description:
 */
public interface RecoveryAdapter {

    /**
     * 立即进入升级
     * @param context
     * @param file
     */
    void installSystemNow(Context context, File file);

}
