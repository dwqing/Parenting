package com.example.education.Tuoguan;

public class DataMouth {
    private String Mouth;
    private int mFirstdayWeek;
    private int mMouthDayNumber;

    public DataMouth(String mouth, int mouthDayNumber , int firstdayWeek) {
        Mouth = mouth;
        mFirstdayWeek = firstdayWeek;
        mMouthDayNumber = mouthDayNumber;
    }

    public String getMouth() {
        return Mouth;
    }

    public void setMouth(String mouth) {
        Mouth = mouth;
    }

    public int getFirstdayWeek() {
        return mFirstdayWeek;
    }

    public void setFirstdayWeek(int firstdayWeek) {
        mFirstdayWeek = firstdayWeek;
    }

    public int getMouthDayNumber() {
        return mMouthDayNumber;
    }

    public void setMouthDayNumber(int mouthDayNumber) {
        mMouthDayNumber = mouthDayNumber;
    }
}
