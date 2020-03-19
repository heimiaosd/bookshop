package com.example.bookshop_admin.dto;

import com.fasterxml.jackson.annotation.JsonView;

import javax.validation.constraints.NotBlank;
import java.util.Date;

public class BookInfo {
    public interface GetListView{};
    public interface GetInfoView extends GetListView{};

    private Long id;
    private String name;
    @NotBlank
    private String content;
    private Date publishDate;

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @JsonView(GetListView.class)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonView(GetInfoView.class)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
