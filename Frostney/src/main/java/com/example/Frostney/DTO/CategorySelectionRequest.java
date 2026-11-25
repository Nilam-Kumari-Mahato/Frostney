package com.example.Frostney.DTO;

import java.util.List;

public class CategorySelectionRequest {
	private Long user_id;
    private List<Long> category_ids;

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public List<Long> getCategory_ids() {
        return category_ids;
    }

    public void setCategory_ids(List<Long> category_ids) {
        this.category_ids = category_ids;
    }
}
