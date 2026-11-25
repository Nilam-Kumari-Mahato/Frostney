package com.example.Frostney.DTO;

import java.util.List;

public class CategorySetupRequest {

    private Long user_id;

    private List<Long> selected_category_ids;

    private List<CategoryRequest> custom_categories;

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public List<Long> getSelected_category_ids() {
        return selected_category_ids;
    }

    public void setSelected_category_ids(List<Long> selected_category_ids) {
        this.selected_category_ids = selected_category_ids;
    }

    public List<CategoryRequest> getCustom_categories() {
        return custom_categories;
    }

    public void setCustom_categories(List<CategoryRequest> custom_categories) {
        this.custom_categories = custom_categories;
    }
}