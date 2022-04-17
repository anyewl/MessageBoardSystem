package work.liziyun.web.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import work.liziyun.pojo.Result;
import work.liziyun.service.TagService;
import work.liziyun.web.TagController;

@RestController()
public class TagControllerImpl implements TagController {
    @Autowired
    TagService tagServer;

    @Override
    @GetMapping("/tag/findAll.do")
    public Result findAll() {
        return new Result(true,200,"成功",tagServer.allTags());
    }
}
