package com.example.myapp.Retrofit.pratice;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public abstract class ApiResponse {
    @Expose
    @SerializedName("quota_remaining")
    private int quotaRemaining;
    @Expose
    @SerializedName("quota_max")
    private int quotaMax;
    @Expose
    @SerializedName("has_more")
    private boolean hasMore;
    @Expose
    @SerializedName("items")
    private List<Items> items;

    public int getQuotaRemaining() {
        return quotaRemaining;
    }

    public void setQuotaRemaining(int quotaRemaining) {
        this.quotaRemaining = quotaRemaining;
    }

    public int getQuotaMax() {
        return quotaMax;
    }

    public void setQuotaMax(int quotaMax) {
        this.quotaMax = quotaMax;
    }

    public boolean getHasMore() {
        return hasMore;
    }

    public void setHasMore(boolean hasMore) {
        this.hasMore = hasMore;
    }

    public List<Items> getItems() {
        return items;
    }

    public void setItems(List<Items> items) {
        this.items = items;
    }
}
