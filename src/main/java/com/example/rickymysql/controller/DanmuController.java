package com.example.rickymysql.controller;

import com.example.rickymysql.bean.Danmu;
import com.example.rickymysql.bean.ResponseVO;
import com.example.rickymysql.server.DanmuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/danmu")
@RestController
public class DanmuController {
    @Autowired
    DanmuService danmuService;

    @PostMapping("/addDanmu")
    public ResponseVO createDanmu(Danmu danmu){
        danmuService.uplodeDanmu(danmu);
        return ResponseVO.buildSuccess(true);
    }

    @GetMapping("/getDanmuList")
    public List<Danmu> getDanmuList(Integer postid){
        return danmuService.getDanmuList(postid);
    }

    @GetMapping("/getMyDanmuList")
    public ResponseVO getMyDanmuList(Integer userid){
        return ResponseVO.buildSuccess(danmuService.getMyDanmuList(userid));
    }
}
