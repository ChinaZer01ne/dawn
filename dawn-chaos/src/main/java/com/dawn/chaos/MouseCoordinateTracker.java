package com.dawn.chaos;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;

public class MouseCoordinateTracker {
    private static volatile boolean running = true;
    
    public static void main(String[] args) {
        System.out.println("鼠标坐标跟踪器已启动，移动鼠标查看坐标（按Ctrl+C退出）");
        
        // 添加关闭钩子
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            running = false;
            System.out.println("\n程序已退出");
        }));
        
        // 实时获取并显示鼠标坐标
        while (running) {
            try {
                PointerInfo pointerInfo = MouseInfo.getPointerInfo();
                Point point = pointerInfo.getLocation();
                System.out.printf("当前坐标: X=%d, Y=%d\r", point.x, point.y);
                Thread.sleep(1000); // 每100毫秒更新一次
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            } catch (Exception e) {
                e.printStackTrace();
                break;
            }
        }
    }
}