package com.baomidou.ant.poem.entity;


import java.util.List;

public class Paper {
    private String decs;
    private Object meta;
    private String img_url;
    private List<String> tags;
    private List<String> category;
    private String _id;
    private int operate;
    private String title;
    private Data create_time;

    public Paper() {
    }

    public Paper(String decs, Object meta, String img_url, List<String> tags, List<String> category, String _id, int operate, String title, Data create_time) {
        this.decs = decs;
        this.meta = meta;
        this.img_url = img_url;
        this.tags = tags;
        this.category = category;
        this._id = _id;
        this.operate = operate;
        this.title = title;
        this.create_time = create_time;
    }

    public String getDecs() {
        return decs;
    }

    public void setDecs(String decs) {
        this.decs = decs;
    }

    public Object getMeta() {
        return meta;
    }

    public void setMeta(Object meta) {
        this.meta = meta;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public List<String> getCategory() {
        return category;
    }

    public void setCategory(List<String> category) {
        this.category = category;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public int getOperate() {
        return operate;
    }

    public void setOperate(int operate) {
        this.operate = operate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Data getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Data create_time) {
        this.create_time = create_time;
    }
}
