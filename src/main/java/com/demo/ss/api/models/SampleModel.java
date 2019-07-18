package com.demo.ss.api.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@JsonInclude
@ApiModel(value = "Sample", description = "Sample")
public class SampleModel {

    @JsonProperty("id")
    @ApiModelProperty(name = "id", value = "Id")
    private Integer id;

    @JsonProperty("name")
    @ApiModelProperty(name = "name", value = "Name")
    private String name;
}