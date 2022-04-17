package work.liziyun.web;

import org.springframework.web.multipart.MultipartFile;
import work.liziyun.pojo.Article;
import work.liziyun.pojo.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface ArticleController {

    public Result findByPage(Integer id);

    public Result findByPage(Integer page,Integer tagId);

    public Result addArticle(MultipartFile multipartFile, Article article, String code, HttpServletRequest request, HttpServletResponse response) throws IOException;

}
