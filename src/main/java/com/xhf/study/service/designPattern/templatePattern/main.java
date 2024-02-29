package com.xhf.study.service.designPattern.templatePattern;

/**
 * @projectName: test
 * @package: com.xhf.study.service.designPattern.templatePattern
 * @className: main
 * @descriptions:
 * @author: xiahaifeng
 * @createDate: 2023/9/25 10:12
 * @updateUser: xiahaifeng
 * @updateDate: 2023/9/25 10:12
 * @updateRemark:
 */

public class main {
    public static void main(String[] args) {
        MakePaintingTemplate makePaintingTemplate = new MakeFigurePainting();
        makePaintingTemplate.makePainting();
        System.out.println("==================================");
        makePaintingTemplate = new MakeLandscapePainting();
        makePaintingTemplate.makePainting();
    }
}
