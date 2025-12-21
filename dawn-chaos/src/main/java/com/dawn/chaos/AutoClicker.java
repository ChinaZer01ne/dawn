package com.dawn.chaos;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class AutoClicker {
    private Robot robot;
    private int retryCount = 0;
    private static final int MAX_RETRIES = 50; // 最大重试次数

    public AutoClicker() {
        try {
            this.robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    // 模拟鼠标点击
    public void clickAt(int x, int y) {
        robot.mouseMove(x, y);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(1000); // 按下持续时间
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(1000); // 按下持续时间
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        System.out.println("已在坐标(" + x + ", " + y + ")执行点击");
    }

    // 模拟按键（用于输入账号密码等）
    public void typeString(String text) {
        for (char c : text.toCharArray()) {
            int keyCode = getKeyCode(c);
            if (keyCode != -1) {
                robot.keyPress(keyCode);
                robot.keyRelease(keyCode);
                robot.delay(50);
            }
        }
        // 模拟回车键
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    // 字符到KeyEvent映射
    private int getKeyCode(char c) {
        if (c >= 'a' && c <= 'z') {
            return KeyEvent.VK_A + (c - 'a');
        } else if (c >= 'A' && c <= 'Z') {
            return KeyEvent.VK_A + (c - 'A'); // 需配合Shift键
        } else if (c >= '0' && c <= '9') {
            return KeyEvent.VK_0 + (c - '0');
        }
        return -1;
    }

    public static void main(String[] args) {
        AutoClicker clicker = new AutoClicker();
        
        // 示例：假设登录按钮在屏幕坐标(1000, 500)位置
        int loginButtonX = 1826;
        int loginButtonY = 602;

        // 循环尝试点击
        for (int i = 0; i < MAX_RETRIES; i++) {
            System.out.println("尝试第 " + (i + 1) + " 次登录");
            clicker.clickAt(loginButtonX, loginButtonY);
            try {
                Thread.sleep(100); // 每次点击后等待2秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clicker.clickAt(1513, 410);
            try {
                Thread.sleep(2000); // 每次点击后等待2秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}