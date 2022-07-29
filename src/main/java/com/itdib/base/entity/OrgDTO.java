package com.itdib.base.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author @dibyapp, Name : Dibyaprakash, Email : dibyapp@geekyants.com
 * @Project : mt-base-service
 */

@Getter
@Setter
@ToString
public class OrgDTO {

    private String email;

    private String orgName;

    private String firstName;
    
    private String lastName;
    
    private String instanceName;
    
}