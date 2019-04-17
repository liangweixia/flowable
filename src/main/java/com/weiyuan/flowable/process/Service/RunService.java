package com.weiyuan.flowable.process.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.flowable.common.engine.api.FlowableIllegalArgumentException;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.repository.ProcessDefinition;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.engine.runtime.ProcessInstanceBuilder;
import org.flowable.rest.service.api.RestResponseFactory;
import org.flowable.rest.service.api.engine.variable.RestVariable;
import org.flowable.rest.service.api.runtime.process.ProcessInstanceCreateRequest;
import org.flowable.rest.service.api.runtime.process.ProcessInstanceResponse;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
@Transactional
public class RunService implements InitializingBean{
    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private RepositoryService repositoryService;

    private  RestResponseFactory restResponseFactory;

    public ProcessInstanceResponse startProcess(ProcessInstanceCreateRequest request) {
        Map<String, Object> startVariables = new HashMap<>();
        for (RestVariable variable : request.getVariables()) {
            if (variable.getName() == null) {
                throw new FlowableIllegalArgumentException("Variable name is required.");
            }
            startVariables.put(variable.getName(), restResponseFactory.getVariableValue(variable));
        }
        ProcessInstanceBuilder processInstanceBuilder = runtimeService.createProcessInstanceBuilder();
        processInstanceBuilder.processDefinitionKey(request.getProcessDefinitionKey());
        processInstanceBuilder.transientVariables(startVariables);
        ProcessInstance instance = processInstanceBuilder.start();
        ProcessInstanceResponse processInstanceResponse = restResponseFactory.createProcessInstanceResponse(instance);
        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().processDefinitionId(processInstanceResponse.getProcessDefinitionId()).singleResult();
        if (processDefinition != null) {
            processInstanceResponse.setProcessDefinitionName(processDefinition.getName());
            processInstanceResponse.setProcessDefinitionDescription(processDefinition.getDescription());
        }
        return processInstanceResponse;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        this.restResponseFactory = new RestResponseFactory(objectMapper);
    }
}
