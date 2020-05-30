package com.example.user.personafren;

/**
 * Created by user on 2018/4/15.
 */

public class AbilityModel {
    private String title;//每一项的名称
    private float value;//属性的值范围0-10

    public AbilityModel(String title, float value) {
        this.title = title;
        this.value = value;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }
}
