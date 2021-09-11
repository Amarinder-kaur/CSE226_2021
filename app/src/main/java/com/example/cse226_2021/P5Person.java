package com.example.cse226_2021;

public class P5Person {
    String name;
    int reg;
    int image;
    public P5Person(String name, int reg, int image)
    {
        this.name = name;
        this.reg = reg;
        this.image = image;
    }
    public void setReg(int reg) {
        this.reg = reg;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public int getReg() {
        return reg;
    }

    public int getImage()
    {
        return image;
    }
}
