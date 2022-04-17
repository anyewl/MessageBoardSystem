package work.liziyun.web;

import org.springframework.web.multipart.MultipartFile;
import work.liziyun.pojo.Result;

import java.io.IOException;
import java.util.List;

public interface PictureController {
    public Result addPisture(MultipartFile[] multipartFile) throws IOException;
    public Result findByPage(int page);

    public Result deleteIds(List<Integer> ids);
}
