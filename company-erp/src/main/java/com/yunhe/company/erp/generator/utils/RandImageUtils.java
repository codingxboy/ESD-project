package com.yunhe.company.erp.generator.utils;

import org.checkerframework.checker.units.qual.C;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.Random;

/**
 * @ClassName RandImageUtils
 * @Description TODO 验证码图片工具类
 * @Author xiaozuqin
 * @Date 2022/7/25 11:12
 * @Version 1.0
 */
public class RandImageUtils {
    /**
     * 定义图形大小
     */
    private static final int WIDTH = 105;
    /**
     * 定义图形大小
     */
    private static final int HEIGHT = 35;

    /**
     * 定义干扰线数量
     */
    private static final int COUNT = 200;

    /**
     * 干扰线的长度=1.414*lineWidth
     */
    private static final int LINE_WIDTH = 2;

    /**
     * 图片格式
     */
    private static final String IMG_FORMAT = "JPEG";

    /**
     * base64 图片前缀
     */
    private static final String BASE64_PRE = "data:image/jpg;base64,";
    /**
     * 字体
     * @author xiaozuqin
     * @date: 2022/7/29 16:07
     */
    private static final String[] fontNames = {"Georgia", "Verdana", "Arial", "Tahoma",
            "Time News Roman", "Courier New", "Arial Black", "Quantzite"};

    public static void generate(HttpServletResponse httpServletResponse,String resultCode) throws IOException {
        BufferedImage imageBuffer = getImageBuffer(resultCode);
        //输出图像到页面
        ImageIO.write(imageBuffer, IMG_FORMAT, httpServletResponse.getOutputStream());
    }

    public static String generate(String resultCode) throws IOException {
        BufferedImage imageBuffer = getImageBuffer(resultCode);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        //写入流中
        ImageIO.write(imageBuffer, IMG_FORMAT, byteArrayOutputStream);
        //转换成字节
        byte[] bytes = byteArrayOutputStream.toByteArray();
        //转换成base64字符串
        String baseString = Base64.getEncoder().encodeToString(bytes);
        baseString = baseString.replaceAll("\n", "").replaceAll("\r", "");
        return BASE64_PRE+baseString;
    }

    private static BufferedImage getImageBuffer(String resultCode) {
        //在内存中创建图形
        BufferedImage bufferedImage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        //获取图形上下文
        Graphics2D graphics = (Graphics2D) bufferedImage.getGraphics();
        // 设定背景颜色
        // ---1
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, WIDTH, HEIGHT);
        // 设定边框颜色
//		graphics.setColor(getRandColor(100, 200)); // ---2
        graphics.drawRect(0, 0, WIDTH - 1, HEIGHT - 1);

        final Random random = new Random();
        // 随机产生干扰线，使图象中的认证码不易被其它程序探测到
        for (int i = 0; i < COUNT; i++) {
            // ---3
            graphics.setColor(getRandColor(150, 200));

            // 保证画在边框之内
            final int x = random.nextInt(WIDTH - LINE_WIDTH - 1) + 1;
            final int y = random.nextInt(HEIGHT - LINE_WIDTH - 1) + 1;
            final int xl = random.nextInt(LINE_WIDTH);
            final int yl = random.nextInt(LINE_WIDTH);
            graphics.drawLine(x, y, x + xl, y + yl);
        }
        // 取随机产生的认证码
        for (int i = 0; i < resultCode.length(); i++) {
            // 将认证码显示到图象中,调用函数出来的颜色相同，可能是因为种子太接近，所以只能直接生成
            // graphics.setColor(new Color(20 + random.nextInt(130), 20 + random
            // .nextInt(130), 20 + random.nextInt(130)));
            // 设置字体颜色
            graphics.setColor(Color.BLUE);
            // 设置字体样式
//			graphics.setFont(new Font("Arial Black", Font.ITALIC, 18));
//            graphics.setFont(new Font("Times New Roman", Font.BOLD, 24));
            graphics.setFont(randFont());
            // 设置字符，字符间距，上边距
            graphics.drawString(String.valueOf(resultCode.charAt(i)), (23 * i) + 8, 26);
        }
        // 图象生效
        graphics.dispose();
        return bufferedImage;
    }

    private static Color getRandColor(int fc, int bc) { // 取得给定范围随机颜色
        final Random random = new Random();
        int length = 255;
        if (fc > length) {
            fc = length;
        }
        if (bc > length) {
            bc = length;
        }

        final int r = fc + random.nextInt(bc - fc);
        final int g = fc + random.nextInt(bc - fc);
        final int b = fc + random.nextInt(bc - fc);

        return new Color(r, g, b);
    }

    //随机获取一种字体
    public static Font randFont() {
        Random rnd = new Random();
        int fontindex = rnd.nextInt(fontNames.length-1);  //随机索引
        String str = fontNames[fontindex];  //获得该字体
        int fontSize = (int) Math.round(Math.random() * 4 + 16);
        return new Font(str, Font.PLAIN, fontSize);
    }
}
