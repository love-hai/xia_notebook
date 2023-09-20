package com.xhf.test.service.designPattern.decoratorPattern;

/**
 * @projectName: test
 * @package: com.xhf.test.service.designPattern.decoratorPattern
 * @className: PictureFrame
 * @descriptions: 画框
 * @author: xiahaifeng
 * @createDate: 2023/9/20 11:15
 * @updateUser: xiahaifeng
 * @updateDate: 2023/9/20 11:15
 * @updateRemark:
 */

public abstract class PictureFramePainting implements Painting {

    private Painting painting;

    public PictureFramePainting(Painting painting) {
        this.painting = painting;
    }

    public void make() {
        painting.make();
    }
}
