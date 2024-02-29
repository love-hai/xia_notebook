package com.xhf.study.service.designPattern.decoratorPattern;

/**
 * @projectName: test
 * @package: com.xhf.study.service.designPattern.decoratorPattern
 * @className: PictureFramePaintingShape
 * @descriptions: 画框形状
 * @author: xiahaifeng
 * @createDate: 2023/9/20 11:22
 * @updateUser: xiahaifeng
 * @updateDate: 2023/9/20 11:22
 * @updateRemark:
 */

public class PictureFramePaintingShape extends PictureFramePainting {

    private String shape;
    public PictureFramePaintingShape(Painting painting, String shape) {
        super(painting);
        if (shape == null || shape.equals("")) {
            shape = "方形";
        }
        this.shape = shape;
    }

    @Override
    public void make() {
        super.make();
        System.out.println("画框形状："+shape);
    }
}
