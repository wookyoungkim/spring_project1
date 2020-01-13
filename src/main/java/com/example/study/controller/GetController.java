
//controller : 주소들의 묶
package com.example.study.controller;

import com.example.study.model.SearchParam;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api") //localhost:8080/api
@RestController
public class GetController {

    @RequestMapping(method = RequestMethod.GET, path = "/getMethod")        //localhost:8080/api/getMethod
    public String getRequest(){
        return "Hi getMethod";
    }

    @GetMapping("/getParameter") //parameter 지정없이 주소만 -> localhost:8080/api/getParameter
    public String getParameter(@RequestParam String id, @RequestParam(name = "password") String pwd){
        String password = "bbbb";
        System.out.println("id : "+id);
        System.out.println(("password : "+pwd));
        return id+pwd;
    }

    @GetMapping("/getMultiParameter")
    public SearchParam getMultiParameter(SearchParam searchParam){
        System.out.println(searchParam.getAccount());
        System.out.println(searchParam.getEmail());
        System.out.println(searchParam.getPage());

        return searchParam;

    }
}
