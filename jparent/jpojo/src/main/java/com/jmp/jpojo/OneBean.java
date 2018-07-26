package com.jmp.jpojo;


import lombok.Data;

@Data
public class OneBean {
    private Integer id;
    private String name;

    public OneBean() {
    }

    public OneBean(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public static void main(String[] args) {
        OneBean oneBean = new OneBean();
        oneBean.setId(111);
        oneBean.setName("Mr.LaiHaoda");
        System.err.println(oneBean.toString());
    }
}
