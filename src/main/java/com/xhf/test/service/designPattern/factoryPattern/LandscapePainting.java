package com.xhf.test.service.designPattern.factoryPattern;

/**
 * @projectName: test
 * @package: com.xhf.test.service.designPattern.decoratorPattern
 * @className: LandscapePainting
 * @descriptions: 山水画
 * @author: xiahaifeng
 * @createDate: 2023/9/20 11:06
 * @updateUser: xiahaifeng
 * @updateDate: 2023/9/20 11:06
 * @updateRemark:
 */

public class LandscapePainting implements Painting {

        @Override
        public void make() {
            System.out.println("在画上画一些山水");
        }

        public void make2() {
            System.out.println("擦去画上的山水");
        }
}
