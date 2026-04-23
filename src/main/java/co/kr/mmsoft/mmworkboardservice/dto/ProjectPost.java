package co.kr.mmsoft.mmworkboardservice.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

/** 워크보드 게시글 DTO */
@Getter
@Setter
@NoArgsConstructor
public class ProjectPost {
    private Long   workboardId;
    private Long   accountId;
    private String title;
    private String content;
    private String name;
    private String regDate;
    private String updateDate;
    private String passwd;
    private String url;
    private String  workboardRolename;
    private String  author;
    private String  category;
    private Integer views;
}
