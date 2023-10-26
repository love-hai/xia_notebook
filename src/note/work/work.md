# 任务


| 任务                                                      | 是否完成 |
| ----------------------------------------------------------- | ---------- |
| 判断erp的版本是否符合要求                                 |          |
| 浏览器的通知时间显示修改                                  | 完成     |
| 没选文件不要报发生异常,错误信息要说明是没有选择文件导致的 | 完成     |
| 浏览器的订阅通知不要每次都弹出来                          |          |
| 那个上新生命周期的筛选项，有勾选的全部都取消              |          |
| 浏览器更新后删除历史残留版本                              | 完成     |

# shopee店铺上下架分表

## 新增的api


| Method | 方法名             | 注释               | url                               | Controller         | service |
| -------- | -------------------- | -------------------- | ----------------------------------- | -------------------- | --------- |
| Post   | getShopProductList | shopee店铺商品查询 | /shopee-discount/get-product-list | DiscountController | base    |
|        |                    |                    |                                   |                    |         |

# 系统升级通知

## 新增的api

/notice/recieve/get-version-upgrade-notice NoticeRecieveController get getVersionUpgradeNotice 获取版本升级通知

/monitor/subscribe/delete-by-acId  NoticeSubscribeController  delete  deleteVersionUpgradeSubscribe  notice

/monitor/subscribe/add-version-upgrade-Subscribe NoticeSubscribeController get addVersionUpgradeSubscribe  notice

## 操作

添加三个主题
