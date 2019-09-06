package cn.flyaudio.otasdk.interfacesimpel;

import cn.flyaudio.otasdk.check.CheckOtaVersion;
import cn.flyaudio.otasdk.interfaces.ICheckUpdateListener;
import cn.flyaudio.otasdk.interfaces.IDownloadListener;
import cn.flyaudio.otasdk.interfaces.IOtaAgent;
import cn.flyaudio.otasdk.interfaces.IUpgradeListener;

public class IOtaAgentImpel implements IOtaAgent {


    @Override
    public String getSdkInfo() {
        return null;
    }

    @Override
    public String getProductId() {
        return null;
    }

    @Override
    public void checkUpdate(ICheckUpdateListener listener) {
        CheckOtaVersion.getInstance().checkOtaDetails(listener);
    }

    @Override
    public void downLoad(IDownloadListener listener) {

    }

    @Override
    public void downLoadAbort() {

    }

    @Override
    public void upgrade(IUpgradeListener lsitener) {

    }



}
