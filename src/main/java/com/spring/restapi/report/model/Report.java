package com.spring.restapi.report.model;

import lombok.*;

@Builder @AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class Report {

    String userId;
    boolean isAddUrl;
}
