package com.example.weatherapp1;

public class MyFlag {
    String name;
    String image;
    String code;

    public MyFlag(String name, String image, String code) {
        this.name = name;
        this.image = image;
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


}
