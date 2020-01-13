package com.example.study.controller;

import com.example.study.model.SearchParam;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PostController {

    //html 의 form태그, ajax의 검색에 사용

   //@RequestMapping(method = RequestMethod.POST, path = "/postMethod") 아래와 같은 의
    @PostMapping(value = "/postMethod")
    public SearchParam postMethod(@RequestBody SearchParam searchParam){
        // http post body에 data를 넣어서 보내기 -> 리퀘스트 바디에 해당값 매핑시켜서 달라고 요청
        //  -> json, xml, multipart-form, text-plain등 의 방식 지원
        return searchParam;
    }


    //http에서의 put, patch

//    @PutMapping(value = "/putMethod")   //어떤 주소에 매핑을?
//    public SearchParam putMethod(@RequestBody SearchParam searchParam){
//
//    }
//
//    @PatchMapping(value = "/patchMethod")
//    public void put(){

   // }

    //delete method : get과 마찬가지로 주소에 들어있는 파라미터에 대한 삭제

}
