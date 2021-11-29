package com.atguigu.servlet;


import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class UploadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("接受到文件提交了");
//        ServletInputStream stream = req.getInputStream();
//        byte[] buffer = new byte[1024000];
//        int read = stream.read(buffer);
//        System.out.println(new String(buffer, 0, read));
        req.setCharacterEncoding("utf-8");
        // 1、先判断上传的数据是否是多段数据(只有多端数据才是文件上传)
        if (ServletFileUpload.isMultipartContent(req)) {
            // 2、创建FileItemFactory工厂实现类
            DiskFileItemFactory factory = new DiskFileItemFactory();
            // 3、创建用于解析上传数据工具类的servletFileUpload类
            ServletFileUpload servletFileUpload = new ServletFileUpload(factory);
            try {
                // 4、解析上传的数据，得到每一个表单项FileItem
                List<FileItem> list = servletFileUpload.parseRequest(req);
                for(FileItem fileItem : list) {
                    // fileItem.isFormField：true表示普通表单项, false表示文件表单项
                    if (fileItem.isFormField()) {
                        System.out.println("表单项的name属性值" + fileItem.getFieldName());
                        // 为了防止乱码，添加UTF-8的参数
                        System.out.println("表单项的value属性值" + fileItem.getString("UTF-8"));
                    } else {
                        System.out.println("表单项的photo属性值" + fileItem.getFieldName());
                        System.out.println("上传文件的名" + fileItem.getName());
                        // 将上传的文件写入磁盘中
                        fileItem.write(new File("D:\\java\\JavaWeb\\" + fileItem.getName()));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
