package com.xhf.study.service.designPattern.templatePattern;

/**
 * @projectName: test
 * @package: com.xhf.study.service.designPattern.templatePattern
 * @className: MakeLandscapePainting
 * @descriptions:
 * @author: xiahaifeng
 * @createDate: 2023/9/25 10:11
 * @updateUser: xiahaifeng
 * @updateDate: 2023/9/25 10:11
 * @updateRemark:
 */

public class MakeLandscapePainting extends MakePaintingTemplate{

        @Override
        public void initialize(){
            System.out.println("初始化山水画");
        }
        @Override
        public void draw(){
            System.out.println("在画上画一些山水");
        }
}
