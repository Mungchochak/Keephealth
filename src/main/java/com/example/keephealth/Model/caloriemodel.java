package com.example.keephealth.Model;

import java.util.HashMap;
import java.util.Map;

public class caloriemodel {
    // 用于模拟存储用户卡路里数据的 Map，key 为用户ID，value 为卡路里数据
    private static final Map<Integer, Double> calorieDataMap = new HashMap<>();

    // 保存卡路里数据
    public static void saveCalorieData(int userId, double calorieIntake) {
        calorieDataMap.put(userId, calorieIntake);
        System.out.println("User ID: " + userId + " | Calorie Data Saved: " + calorieIntake + " cal");
    }

    // 获取用户卡路里数据
    public static double getCalorieData(int userId) {
        return calorieDataMap.getOrDefault(userId, 0.0);  // 如果没有该用户数据，则返回 0.0
    }


}
