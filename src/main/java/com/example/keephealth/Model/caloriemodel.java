package com.example.keephealth.Model;

import java.util.HashMap;
import java.util.Map;

public class caloriemodel {

        private int userId;      // 用户ID
        private double intakeToday; // 今日卡路里摄入

        // 构造方法
        public caloriemodel(int userId, double intakeToday) {
            this.userId = userId;
            this.intakeToday = intakeToday;
        }

        // Getter 和 Setter 方法
        public int getCurrentId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public double getIntakeToday() {
            return intakeToday;
        }

        public void setIntakeToday(double intakeToday) {
            this.intakeToday = intakeToday;
        }

        // 显示用户数据的方法
        @Override
        public String toString() {
            return "User ID: " + userId + " | Today's Calorie Intake: " + intakeToday + " cal";

    }




}
