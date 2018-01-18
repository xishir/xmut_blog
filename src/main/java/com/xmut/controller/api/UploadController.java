package com.xmut.controller.api;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.xmut.util.MD5Encoder;
@Controller
public class UploadController {

  @PostMapping(value="/api/admin/uploadfile")
  public void hello(HttpServletRequest request,HttpServletResponse response,@RequestParam(value = "editormd-image-file", required = false) MultipartFile attach){
      try {
          request.setCharacterEncoding( "utf-8" );
          response.setHeader( "Content-Type" , "text/html" );
          System.out.println("上传文件1");
          //String rootPath = request.getSession().getServletContext().getRealPath("/upload/");
          String rootPath = ClassUtils.getDefaultClassLoader().getResource("").getPath()+"/static/upload/";
          System.out.println("上传文件2"+" "+rootPath);
          /**
           * 文件路径不存在则需要创建文件路径
           */
          File filePath=new File(rootPath);
          if(!filePath.exists()){
              filePath.mkdirs();
          }

          //最终文件名
          long datename = new Date().getTime();
          String fileName = File.separator+attach.getOriginalFilename();
          String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
          fileName=rootPath+datename+"."+suffix;
          fileName=MD5Encoder.encode(fileName);
          File realFile=new File(rootPath+fileName+"."+suffix);
          FileUtils.copyInputStreamToFile(attach.getInputStream(), realFile);
          System.out.println("上传文件3"+"  "+realFile);
          //下面response返回的json格式是editor.md所限制的，规范输出就OK
          response.getWriter().write( "{\"success\": 1, \"message\":\"上传成功\",\"url\":\"/upload/" + fileName+"."+suffix + "\"}" );
      } catch (Exception e) {
          try {
              response.getWriter().write( "{\"success\":0}" );
          } catch (IOException e1) {
              e1.printStackTrace();
          }
      }
  }
}