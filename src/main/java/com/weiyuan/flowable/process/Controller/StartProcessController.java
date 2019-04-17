package com.weiyuan.flowable.process.Controller;

import com.weiyuan.flowable.process.Service.RunService;

import org.flowable.rest.service.api.runtime.process.ProcessInstanceCreateRequest;
import org.flowable.rest.service.api.runtime.process.ProcessInstanceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/process/runtime")
public class StartProcessController {
    @Autowired
    private RunService runService;

    @PostMapping("/process-instances")
        public ProcessInstanceResponse startProcess(@RequestBody ProcessInstanceCreateRequest request){
        ProcessInstanceResponse response = runService.startProcess(request);
        return response;
        }

}
