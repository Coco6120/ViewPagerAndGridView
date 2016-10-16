package com.example.administrator.viewpagerandgridview;

/**
 * Created by Administrator on 2016/10/14 0014.
 */

public class Model {
    public Model(String name, int iconRes) {
        this.name = name;
        this.iconRes = iconRes;
    }

    public String name;
    public int iconRes;

    public int getIconRes() {
        return iconRes;
    }

    public Model setIconRes(int iconRes) {
        this.iconRes = iconRes;
        return this;
    }

    public String getName() {
        return name;
    }

    public Model setName(String name) {
        this.name = name;
        return this;
    }
}
