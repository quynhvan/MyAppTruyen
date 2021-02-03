package com.example.myapp.Retrofit.ApiResponse.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Items {
    @Expose
    @SerializedName("content_license")
    private String contentLicense;
    @Expose
    @SerializedName("question_id")
    private int questionId;
    @Expose
    @SerializedName("answer_id")
    private int answerId;
    @Expose
    @SerializedName("creation_date")
    private int creationDate;
    @Expose
    @SerializedName("last_edit_date")
    private int lastEditDate;
    @Expose
    @SerializedName("last_activity_date")
    private int lastActivityDate;
    @Expose
    @SerializedName("score")
    private int score;
    @Expose
    @SerializedName("is_accepted")
    private boolean isAccepted;
    @Expose
    @SerializedName("owner")
    private Owner owner;

    public String getContentLicense() {
        return contentLicense;
    }

    public void setContentLicense(String contentLicense) {
        this.contentLicense = contentLicense;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public int getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(int creationDate) {
        this.creationDate = creationDate;
    }

    public int getLastEditDate() {
        return lastEditDate;
    }

    public void setLastEditDate(int lastEditDate) {
        this.lastEditDate = lastEditDate;
    }

    public int getLastActivityDate() {
        return lastActivityDate;
    }

    public void setLastActivityDate(int lastActivityDate) {
        this.lastActivityDate = lastActivityDate;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean getIsAccepted() {
        return isAccepted;
    }

    public void setIsAccepted(boolean isAccepted) {
        this.isAccepted = isAccepted;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
