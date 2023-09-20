package com.xhf.test.service.designPattern.decoratorPattern;

/**
 * @projectName: test
 * @package: com.xhf.test.service.designPattern.decoratorPattern
 * @className: FigurePainting
 * @descriptions: 人物画
 * @author: xiahaifeng
 * @createDate: 2023/9/20 11:08
 * @updateUser: xiahaifeng
 * @updateDate: 2023/9/20 11:08
 * @updateRemark:
 */

public class FigurePainting implements Painting {
    @Override
    public void make() {
        System.out.println("在画上化一些人物");
    }
}
