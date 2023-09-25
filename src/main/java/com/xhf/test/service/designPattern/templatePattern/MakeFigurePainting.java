package com.xhf.test.service.designPattern.templatePattern;

/**
 * @projectName: test
 * @package: com.xhf.test.service.designPattern.templatePattern
 * @className: MakeFigurePainting
 * @descriptions:
 * @author: xiahaifeng
 * @createDate: 2023/9/25 10:09
 * @updateUser: xiahaifeng
 * @updateDate: 2023/9/25 10:09
 * @updateRemark:
 */

public class MakeFigurePainting extends MakePaintingTemplate {

    @Override
    public void initialize(){
        System.out.println("初始化人物画");
    }
    @Override
    public void draw(){
        System.out.println("在画上画一些人物");
    }

}
