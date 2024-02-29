package com.xhf.study.service.designPattern.decoratorPattern;

/**
 * @projectName: test
 * @package: com.xhf.study.service.designPattern.decoratorPattern
 * @className: main
 * @descriptions:
 * @author: xiahaifeng
 * @createDate: 2023/9/20 11:24
 * @updateUser: xiahaifeng
 * @updateDate: 2023/9/20 11:24
 * @updateRemark:
 */

public class main {
    public static void main(String[] args) {
        Painting painting = new LandscapePainting();
        PictureFramePaintingColor pictureFramePaintingColor = new PictureFramePaintingColor(painting, "红色");
        PictureFramePaintingShape pictureFramePaintingShape = new PictureFramePaintingShape(pictureFramePaintingColor, "圆形");
        pictureFramePaintingShape.make();

    }
}
