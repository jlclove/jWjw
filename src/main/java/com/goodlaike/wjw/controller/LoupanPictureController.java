package com.goodlaike.wjw.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.goodlaike.wjw.model.LoupanPicture;
import com.goodlaike.wjw.service.loupan.LoupanPictureService;
import com.goodlaike.wjw.service.loupan.LoupanService;


@RestController
public class LoupanPictureController extends BaseController {

  @Autowired
  private LoupanPictureService loupanPictureService;



  /**
   * 根据ID 获得楼盘
   *
   * @see LoupanService#findDetailById(long)
   */
  @RequestMapping(value = "/admin/loupan/{loupanId}/pic", method = RequestMethod.GET)
  public List<LoupanPicture> findById(@PathVariable(value = "loupanId") long loupanId) {
    return this.loupanPictureService.findByLoupanId(loupanId);
  }


  /**
   * 删除楼盘照片
   * 
   * @see LoupanPictureService#delete(List)
   */
  @RequestMapping(value = "/admin/loupan/pic", method = RequestMethod.DELETE)
  public boolean delete(@RequestParam(value = "ids") String ids, HttpServletRequest request) {
    return this.loupanPictureService.delete(Stream.of(ids.split(",")).map((id) -> Long.parseLong(id)).collect(Collectors.toList()));
  }

  /**
   * 新增图片
   * 
   * @see LoupanPictureService#insert(List, int)
   */
  @RequestMapping(value = "/admin/loupan/pic", method = RequestMethod.POST)
  public boolean insert(@RequestBody List<Map<String, Object>> picList, HttpServletRequest request) {
    return this.loupanPictureService.insert(picList, super.pollLogined(request).getId());
  }

  
  @RequestMapping(value = "/admin/loupan/pic/setMain", method = RequestMethod.POST)
  public void setMain(@RequestParam(value = "id") long id, HttpServletRequest request) {
    this.loupanPictureService.setMain(id);
  }


  @RequestMapping(value = "/admin/loupan/pic/upload", method = RequestMethod.POST)
  protected String upload(@RequestParam(value = "file", required = true) MultipartFile file, HttpServletRequest request) {
    Assert.isTrue(file.getSize() > 0, "未选择上传文件");
    Assert.isTrue(file.getSize() <= this.getMaxFileSize() * 1024 * 1024, "上传文件超过最大设置【" + this.getMaxFileSize() + "】MB");

    String newFileName;
    try {
      newFileName = this.saveFile(file);
    } catch (IOException e) {
      throw new RuntimeException("上传图片异常，错误：【" + e + "】");
    }
    return newFileName;
  }


  /**
   * 获得文件类型的16进制头
   * 
   * @param file
   * @return
   * @since 1.0.0
   * @author jail
   * @createTime 2015年8月25日下午10:39:09
   * @updator jail
   * @updateTime 2015年8月25日下午10:39:09
   */
  @SuppressWarnings("unused")
  private String getFileHexString(MultipartFile file) {
    try {
      InputStream is = file.getInputStream();
      ByteArrayOutputStream bytestream = new ByteArrayOutputStream();
      for (int i = 0; i < 10; i++) {
        int a = is.read();
        bytestream.write(a);
      }
      byte[] imgdata = bytestream.toByteArray();
      return this.getFileHexString(imgdata);
    } catch (IOException e) {
      throw new IllegalStateException("获得文件头失败");
    }
  }

  /**
   * 获得文件类型的 16进制头 <br>
   * 摘自网络
   * 
   * @param b
   * @return String
   * @since 1.0.0
   * @author jail
   * @createTime 2015年8月25日下午10:35:39
   * @updator jail
   * @updateTime 2015年8月25日下午10:35:39
   */
  private String getFileHexString(byte[] b) {
    Assert.notNull(b, "字节不能为Null");
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < b.length; i++) {
      int v = b[i] & 0xFF;
      String hv = Integer.toHexString(v);
      if (hv.length() < 2) {
        stringBuilder.append(0);
      }
      stringBuilder.append(hv);
    }
    return stringBuilder.toString();
  }

  private String saveFile(MultipartFile file) throws IOException {
    if (file.getOriginalFilename().lastIndexOf(".") == -1) {
      throw new IOException("文件名【" + file.getOriginalFilename() + "】不合法，没有后缀名");
    }
    String fileSuffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
    String newFileName = UUID.randomUUID().toString().replaceAll("-", "") + "-" + System.currentTimeMillis() + fileSuffix;
    FileOutputStream fs = new FileOutputStream(this.getFileSavePath() + File.separator + newFileName);
    InputStream is = file.getInputStream();
    byte[] bt = new byte[1024 * 1024];
    int byteRead = 0;
    while ((byteRead = is.read(bt)) != -1) {
      fs.write(bt, 0, byteRead);
    }
    fs.close();
    is.close();
    return newFileName;
  }

  /**
   * 获得图片保存路径
   * 
   * @return
   * @author Jail Hu
   */
  public String getFileSavePath() {
    String saveDirectory = "imgs";
    saveDirectory = saveDirectory.replaceAll("[\\/]", File.separator);
    if (!saveDirectory.contains(":")) {
      if (!saveDirectory.startsWith(File.separator)) {
        saveDirectory = File.separator + saveDirectory;
      }
      String classPath = this.getClass().getClassLoader().getResource("").getPath();
      saveDirectory = classPath.replace("/WEB-INF/classes/", "") + saveDirectory;
    }

    File d = new File(saveDirectory);
    if (!d.exists()) {
      d.mkdirs();
    }
    System.out.println("============" + saveDirectory);
    return saveDirectory;
  }

  private int getMaxFileSize() {
    return 10;
  }
}
