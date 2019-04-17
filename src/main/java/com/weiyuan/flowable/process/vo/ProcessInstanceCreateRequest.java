//package com.weiyuan.flowable.process.vo;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonTypeInfo;
//import io.swagger.annotations.ApiModelProperty;
//import org.apache.commons.lang3.StringUtils;
//
//public class ProcessInstanceCreateRequest {
//
//    protected String processDefinitionId;
//    protected String processDefinitionKey;
//    protected String message;
//    protected String name;
//    protected String businessKey;
//    protected List<RestVariable> variables;
//    protected List<RestVariable> transientVariables;
//    protected List<RestVariable> startFormVariables;
//    protected String outcome;
//    protected String tenantId;
//    protected String overrideDefinitionTenantId;
//
//    // Added by Ryan Johnston
//    private boolean returnVariables;
//
//    @ApiModelProperty(example = "oneTaskProcess:1:158")
//    public String getProcessDefinitionId() {
//        return processDefinitionId;
//    }
//
//    public void setProcessDefinitionId(String processDefinitionId) {
//        this.processDefinitionId = processDefinitionId;
//    }
//
//    @ApiModelProperty(example = "oneTaskProcess")
//    public String getProcessDefinitionKey() {
//        return processDefinitionKey;
//    }
//
//    public void setProcessDefinitionKey(String processDefinitionKey) {
//        this.processDefinitionKey = processDefinitionKey;
//    }
//
//    @ApiModelProperty(example = "myProcessInstanceName")
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    @ApiModelProperty(example = "myBusinessKey")
//    public String getBusinessKey() {
//        return businessKey;
//    }
//
//    public void setBusinessKey(String businessKey) {
//        this.businessKey = businessKey;
//    }
//
//    @ApiModelProperty(example = "newOrderMessage")
//    public String getMessage() {
//        return message;
//    }
//
//    public void setMessage(String message) {
//        this.message = message;
//    }
//
//    public void setTenantId(String tenantId) {
//        this.tenantId = tenantId;
//    }
//
//    @ApiModelProperty(example = "tenant1")
//    public String getTenantId() {
//        return tenantId;
//    }
//
//    @ApiModelProperty(example = "overrideTenant1")
//    public String getOverrideDefinitionTenantId() {
//        return overrideDefinitionTenantId;
//    }
//
//    public void setOverrideDefinitionTenantId(String overrideDefinitionTenantId) {
//        this.overrideDefinitionTenantId = overrideDefinitionTenantId;
//    }
//
//    @JsonTypeInfo(use = Id.CLASS, defaultImpl = RestVariable.class)
//    public List<RestVariable> getVariables() {
//        return variables;
//    }
//
//    public void setVariables(List<RestVariable> variables) {
//        this.variables = variables;
//    }
//
//    @JsonTypeInfo(use = Id.CLASS, defaultImpl = RestVariable.class)
//    public List<RestVariable> getTransientVariables() {
//        return transientVariables;
//    }
//
//    public void setTransientVariables(List<RestVariable> transientVariables) {
//        this.transientVariables = transientVariables;
//    }
//
//    @JsonTypeInfo(use = Id.CLASS, defaultImpl = RestVariable.class)
//    public List<RestVariable> getStartFormVariables() {
//        return startFormVariables;
//    }
//
//    public void setStartFormVariables(List<RestVariable> startFormVariables) {
//        this.startFormVariables = startFormVariables;
//    }
//
//    public String getOutcome() {
//        return outcome;
//    }
//
//    public void setOutcome(String outcome) {
//        this.outcome = outcome;
//    }
//
//    @JsonIgnore
//    public boolean isTenantSet() {
//        return tenantId != null && !StringUtils.isEmpty(tenantId);
//    }
//
//    // Added by Ryan Johnston
//    public boolean getReturnVariables() {
//        return returnVariables;
//    }
//
//    // Added by Ryan Johnston
//    public void setReturnVariables(boolean returnVariables) {
//        this.returnVariables = returnVariables;
//    }
//}
