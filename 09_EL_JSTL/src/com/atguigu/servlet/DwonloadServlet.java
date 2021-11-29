package com.atguigu.servlet;

import org.apache.commons.io.IOUtils;
import sun.misc.BASE64Encoder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Set;

public class DwonloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1、获取要下载的文件名
        String downloadFileName = "aa.jpg";
        // 2、读取要下载的文件内容
        ServletContext servletContext = getServletContext();
        // 3、获取要下载的文件类型
        String mimeType = servletContext.getMimeType("/file/" + downloadFileName);
        System.out.println(mimeType);
        // 4、在回传的时候通过响应头告诉浏览器返回的类型
        resp.setContentType(mimeType);
        // 5、告诉浏览器收到的数据是用于下下载使用
        // 出现中文名称会出现下载不显示文件名
        // resp.setHeader("Content-Disposition", "attachment; fileName=美女.jpg");
        // 判断是否是火狐，设置不同content-disposition
        if (req.getHeader("User-Agent").contains("Firefox")) {
            // 如果是火狐浏览器使用base64
            resp.setHeader("Content-Disposition", "attachment; filename==?UTF-8?B?" + new BASE64Encoder().encode("美女.jpg".getBytes(StandardCharsets.UTF_8)) + "?=");
        } else {
            // 如果是谷歌或者IE使用urlEncode
            resp.setHeader("Content-Disposition", "attachment; fileName=" + URLEncoder.encode("美女.jpg", "UTF-8"));
        }
        InputStream resourceAsStream = servletContext.getResourceAsStream("/file/" + downloadFileName);
        // 6、获取输出流
        OutputStream outputStream = resp.getOutputStream();
        // 6、通过工具类将
//        IOUtils.copy(resourceAsStream, outputStream);
    }
}
