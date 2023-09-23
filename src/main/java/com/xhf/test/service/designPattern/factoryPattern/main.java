package com.xhf.test.service.designPattern.factoryPattern;

/**
 * @projectName: test
 * @package: com.xhf.test.service.designPattern.decoratorPattern
 * @className: main
 * @descriptions:
 * @author: xiahaifeng
 * @createDate: 2023/9/20 11:24
 * @updateUser: xiahaifeng
 * @updateDate: 2023/9/20 11:24
 * @updateRemark:
 */

public class main {
    private PaintingFactory paintingFactory=new PaintingFactory();
    public static void main(String[] args) {
        new main().test();
    }
    public void test(){
        Painting painting = paintingFactory.getPainting(PaintingTypeEnum.FIGUREPAINTING.getCode());
        painting.make();
        painting = paintingFactory.getPainting(PaintingTypeEnum.LANDSCAPEPAINTING.getCode());
        painting.make();
        if(painting instanceof LandscapePainting){
            ((LandscapePainting) painting).make2();
        }
    }
}
