# 1.项目名称

OtaSdk

代码仓库：
git@172.168.0.64:FlyaudioFOTAProject/OtaSdk.git

# 2.分支说明

目前只有master分支

# 3.功能说明

封装otasdk,主要功能有SDK初始化，升级包检测，升级包下载，升级包校验，升级，升级结果反馈，该工程的输出为OtaSdk_版本.aar

# 4.编译方式

将工程导入Android Studio,然后编译生成aar包

# 5.类说明

FlyFotaApplicationInit.java Application的初始化类，调用sdk的时候需要调用attachBaseContext()方法

ICheckUpdateListener.java 检查服务器升级包的回调接口

IUpgradeListener.java 升级包升级过程的回调

IDownloadListener.java 升级包下载过程中的回调接口

IOtaAgent.java 检测，下载，升级的代理接口

IOtaSdkHelper.java sdk初始信息接口

FlyFotaSdkHelperImpl.java sdk初始信息的实现

IOtaAgentImpel.java sdk检测，下载，升级的代理实现

RetrofitFactory.java retrofit网络的封装

# 6.项目进度

完成到升级包的检测，下载和升级还未完成









