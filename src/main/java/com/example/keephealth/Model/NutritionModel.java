package com.example.keephealth.Model;

import java.time.LocalDate;

public class NutritionModel {

        private int userId;      // 用户ID
        private int intakeToday;
        private LocalDate CheckinDate;// 今日卡路里摄入

        // 构造方法
        public NutritionModel(int userId, int intakeToday,LocalDate CheckinDate) {
            this.userId = userId;
            this.intakeToday = intakeToday;
        }

    public NutritionModel() {

    }

    public LocalDate getCheckinDate() {
        return CheckinDate;
    }

    public void setCheckinDate(LocalDate checkinDate) {
        CheckinDate = checkinDate;
    }
    public int getUserId() {
        return userId;
    }

    // Getter 和 Setter 方法
        public int getCurrentId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public int getIntakeToday() {
            return intakeToday;
        }

        public void setIntakeToday(int intakeToday) {
            this.intakeToday = intakeToday;
        }

        // 显示用户数据的方法
        @Override
        public String toString() {
            return userId + "/" + intakeToday +"/" + CheckinDate ;

    }


        public String toStringNodate() {
        return userId + "/" + intakeToday;

    }




}
