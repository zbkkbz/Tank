package com.zbk.test;/**
 * @author ZBK
 * @date 2020/5/29 - 14:21
 */
import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
/**
 * @program: Tank
 *
 * @description:
 *
 * @author: Zbk
 *
 * @create: 2020-05-29 14:21
 **/

public class ImageTest {

    @Test
    void test(){
        try {
            //从input文件读取图片,
            // 返回BufferedImage,就是将图片放在这个Buffer(内存)中
            /*BufferedImage image = ImageIO.read(new File("E:/workspace/idea-workspace/Tank/src/com/zbk/images/0.gif"));
            assertNotNull(image);*/

            BufferedImage image = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("images/0.gif"));
            assertNotNull(image);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
