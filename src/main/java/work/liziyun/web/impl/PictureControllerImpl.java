package work.liziyun.web.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Encoder;
import work.liziyun.pojo.Article;
import work.liziyun.pojo.Picture;
import work.liziyun.pojo.Result;
import work.liziyun.service.PictureService;
import work.liziyun.web.PictureController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@RestController()
public class PictureControllerImpl implements PictureController {

    @Autowired
    PictureService pictureService;

    @Override
    @PostMapping("/admin/picture/add.do")
    public Result addPisture(@RequestParam(value = "file") MultipartFile[] file) throws IOException {
        List<String> datas = new ArrayList<>();
        for (MultipartFile f : file) {
            BASE64Encoder base64Encoder = new BASE64Encoder();
            String base64img = "data:"+f.getContentType()+";base64,"+base64Encoder.encode(f.getBytes());
            datas.add(base64img);
        }
        pictureService.addPictires(datas);
        return new Result(true,200,"上传成功");
    }

    @GetMapping("/admin/picture/findByPage.do")
    public Result findByPage(int page){
        List<Picture> pictures = pictureService.findByPage(page);
        return new Result(true,200,"成功",pictures);
    }

    @PostMapping("/admin/picture/deleteIds.do")
    public Result deleteIds( @RequestBody List<Integer> deleteIds){
        if (deleteIds != null && deleteIds.size() > 0){
            pictureService.deleteIds(deleteIds);
            return new Result(true,200,"删除成功");
        }else {
            return new Result(false,400,"未选择删除的图片");
        }
    }
}
