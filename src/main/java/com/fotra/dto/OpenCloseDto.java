package com.fotra.dto;

public class OpenCloseDto {
    private Integer id_post;
    private boolean open_close;

    public OpenCloseDto() {}

    public OpenCloseDto(Integer id_post, boolean open_close) {
        this.id_post = id_post;
        this.open_close = open_close;
    }

    public Integer getId_post() {
        return id_post;
    }

    public void setId_post(Integer id_post) {
        this.id_post = id_post;
    }

    public boolean isOpen_close() {
        return open_close;
    }

    public void setOpen_close(boolean open_close) {
        this.open_close = open_close;
    }
}
