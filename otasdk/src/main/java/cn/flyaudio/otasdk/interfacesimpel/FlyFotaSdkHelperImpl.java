package cn.flyaudio.otasdk.interfacesimpel;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;

import cn.flyaudio.otasdk.dataentity.DaoMaster;
import cn.flyaudio.otasdk.dataentity.DaoSession;
import cn.flyaudio.otasdk.dataentity.OtaPath;
import cn.flyaudio.otasdk.interfaces.IOtaAgent;
import cn.flyaudio.otasdk.interfaces.IOtaSdkHelper;
import cn.flyaudio.otasdk.interfaces.ISystemInfo;

/**
 * @author weifule
 * @date 19-7-1
 */
public class FlyFotaSdkHelperImpl implements IOtaSdkHelper {

    public static DaoSession mDaoSession;
    public Context mContext;
    public FlyFotaSdkHelperImpl(Context context){
        if(context != null){
            mContext = context;
            initGreenDao(context);
        }
    }

    public static DaoSession getmDaoSession(){
        return mDaoSession;
    }

    /**
     * 初始化greendao
     */
    public void initGreenDao(Context context){
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(context,"otasdk.db");
        SQLiteDatabase db = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        mDaoSession = daoMaster.newSession();

    }

    @Override
    public void init(String deviceid, ISystemInfo systeminfo) {

    }

    @Override
    public IOtaAgent getInt(String pid, String ps) {
        return new IOtaAgentImpel();
    }

    /**
     * 实现设置升级包升级路径
     * @param path 路径
     */
    @Override
    public void setUpgradePath(String path) {
        if(!TextUtils.isEmpty(path)){
            OtaPath mpath = new OtaPath();
            mpath.setPathname("upgradepath");
            mpath.setPath(path);
            mDaoSession.insertOrReplace(mpath);
        }else{
            //使用默认的升级包存储路径 /data/cache
            OtaPath mpath = new OtaPath();
            mpath.setPathname("upgradepath");
            mpath.setPath("/data/cache");
            mDaoSession.insertOrReplace(mpath);
        }

    }

    @Override
    public void setLogPath(String path) {
        if (!TextUtils.isEmpty(path)) {
            OtaPath mpath = new OtaPath();
            mpath.setPathname("logpath");
            mpath.setPath(path);
            mDaoSession.insertOrReplace(mpath);
        }else{
            //使用默认的升级包存储路径 /data/cache
            OtaPath mpath = new OtaPath();
            mpath.setPathname("logpath");
            String packagename = mContext.getPackageName();
            mpath.setPath("/data/data/"+packagename+"/files/otalog.txt");
            mDaoSession.insertOrReplace(mpath);
        }

    }

    @Override
    public void setLogLevel(int level) {

    }

    @Override
    public void setAutoCheck(boolean check) {

    }

    @Override
    public void setSlientUpgradeTime(String starttime, String endtime) {

    }

    @Override
    public void setExtOption(String key, String value) {

    }

}
