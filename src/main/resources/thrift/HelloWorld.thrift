namespace java service.netty


struct UserInfo {
    1: string username,
    2: string password,
    3: string remark,
}
service HelloWolrdService{
    UserInfo getUserInfo(1:string username, 2:string password),
    void saveUserInfo(1:UserInfo userInfo),
}
