/**
 * meituan.com Inc.
 * Copyright (c) 2010-2022 All Rights Reserved.
 */
package com.example.myblog.common.utils;

import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.pdmodel.graphics.state.PDExtendedGraphicsState;
import java.io.File;
import java.io.IOException;
import java.util.Random;

/**
 * <p>
 * 水印
 * 暗水印 肉眼不可见
 * 明水印 肉眼可见
 * 明暗混合
 * </p>
 * @author wangweijie14
 * @version :WaterMarkUtil.java v1.0 2022/4/12 1:46 下午 wangweijie14 Exp $
 */
public class WaterMarkUtil {
    static final String DEFAULT_FILENAME = "/Users/mac/IdeaProjects/wwj/myBlog/src/main/java/com/example/myblog/TestDir/123.pdf"; // 源PDF
    static final String DEFAULT_FILENAME_TEMP = "/Users/mac/IdeaProjects/wwj/myBlog/src/main/java/com/example/myblog/TestDir/456.pdf"; // 生成新的PDF
    static final String DEFAULT_IMAGE = "/Users/mac/IdeaProjects/wwj/myBlog/src/main/java/com/example/myblog/TestDir/img.png";  // 水印


    public void addImageWatermarkToPDF(String srcPath, String destPath, String imagePath)
            throws IOException {
        File file = new File(DEFAULT_FILENAME);
        PDDocument doc = PDDocument.load(file);

        // TODO 这里的数据 计算水印个数(900 150 700 150) 首个水印位置(-200至-100)都是实验得到 没有理论依据
        for (int top = 0; top < 700; top += 150) {
            int beginLeft = new Random().ints(-200, -50).limit(1).findFirst().getAsInt();
            for (int left = beginLeft; left < 700; left += 150) {
                for(int i=0; i<doc.getNumberOfPages(); i++){
                    PDPage page = doc.getPage(i);
                    PDPageContentStream contentStream = new PDPageContentStream(doc, page, PDPageContentStream.AppendMode.APPEND, true,true);
                    PDImageXObject pdImage = PDImageXObject.createFromFile(DEFAULT_IMAGE, doc);

                    PDExtendedGraphicsState pdExtGfxState = new PDExtendedGraphicsState();

                    // 设置透明度
                    pdExtGfxState.setNonStrokingAlphaConstant(0.5f);
                    pdExtGfxState.setAlphaSourceFlag(true);
                    pdExtGfxState.getCOSObject().setItem(COSName.BM, COSName.MULTIPLY);
                    contentStream.setGraphicsStateParameters(pdExtGfxState);

                    float width = 100;
                    float height = 100;
                    contentStream.drawImage(pdImage, left, top, width, height);
                    contentStream.close();
                    doc.save(DEFAULT_FILENAME_TEMP);
                }
            }
        }
        doc.close();
    }

    public static void main(String[] args) throws IOException {
        WaterMarkUtil waterMarkUtil = new WaterMarkUtil();

        waterMarkUtil.addImageWatermarkToPDF(DEFAULT_FILENAME, DEFAULT_FILENAME_TEMP, DEFAULT_IMAGE);
    }
}