package com.jmp.sql.domain;

import java.util.Date;

public class UserPoint {
    private Long id;

    private String pointGroup;

    private String ponitLevel;

    private Integer point;

    private Long userId;

    private Date createdAt;

    private Date updatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPointGroup() {
        return pointGroup;
    }

    public void setPointGroup(String pointGroup) {
        this.pointGroup = pointGroup == null ? null : pointGroup.trim();
    }

    public String getPonitLevel() {
        return ponitLevel;
    }

    public void setPonitLevel(String ponitLevel) {
        this.ponitLevel = ponitLevel == null ? null : ponitLevel.trim();
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}