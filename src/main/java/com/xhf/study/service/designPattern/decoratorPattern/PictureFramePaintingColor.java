package com.xhf.study.service.designPattern.decoratorPattern;

/**
 * @projectName: test
 * @package: com.xhf.study.service.designPattern.decoratorPattern
 * @className: PictureFramePaintingColor
 * @descriptions: 有颜色的画框
 * @author: xiahaifeng
 * @createDate: 2023/9/20 11:19
 * @updateUser: xiahaifeng
 * @updateDate: 2023/9/20 11:19
 * @updateRemark:
 */

public class PictureFramePaintingColor extends PictureFramePainting {

    private String Color;

    public PictureFramePaintingColor(Painting painting, String color) {
        super(painting);
        if (color == null || color.equals("")) {
            color = "白色";
        }
        this.Color = color;

    }

    @Override
    public void make() {
        super.make();
        System.out.println("画框颜色："+Color);
    }
}
