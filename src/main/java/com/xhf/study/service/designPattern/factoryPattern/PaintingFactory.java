package com.xhf.study.service.designPattern.factoryPattern;

/**
 * @projectName: test
 * @package: com.xhf.study.service.designPattern.factoryPattern
 * @className: PaintingFactory
 * @descriptions: 画的共工厂类
 * @author: xiahaifeng
 * @createDate: 2023/9/23 13:19
 * @updateUser: xiahaifeng
 * @updateDate: 2023/9/23 13:19
 * @updateRemark:
 */

public class PaintingFactory {
    public Painting getPainting(Byte type) {
        if (type == null) {
            return null;
        }
        if (type.equals(PaintingTypeEnum.FIGUREPAINTING.getCode())) {
            return new FigurePainting();
        } else if (type.equals(PaintingTypeEnum.LANDSCAPEPAINTING.getCode())) {
            return new LandscapePainting();
        }
        return null;
    }
}
