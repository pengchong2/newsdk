package cn.flyaudio.otasdk.dataentity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Unique;
import org.greenrobot.greendao.annotation.Generated;

/**
*@author pengchong
*@date 2019/8/21
*@function  保存升级路径(包括升级包保存路径和日志路径)
*
*/

@Entity
public class OtaPath {
    @Id(autoincrement = true)
    long id;
    //路径名称，升级包路径名称upgradepath ;日志路径名称logpath
    @Unique
    String pathname;
    //保存的绝对路径
    String path;
    @Generated(hash = 382898064)
    public OtaPath(long id, String pathname, String path) {
        this.id = id;
        this.pathname = pathname;
        this.path = path;
    }
    @Generated(hash = 1557017578)
    public OtaPath() {
    }
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getPathname() {
        return this.pathname;
    }
    public void setPathname(String pathname) {
        this.pathname = pathname;
    }
    public String getPath() {
        return this.path;
    }
    public void setPath(String path) {
        this.path = path;
    }
}
