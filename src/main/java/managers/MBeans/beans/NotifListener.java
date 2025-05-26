package managers.MBeans.beans;

import managers.DebugTool;
import managers.MBeans.beans.HitCounter;
import javax.annotation.PostConstruct;
import javax.management.*;
import java.lang.management.ManagementFactory;

public class NotifListener implements NotificationListener {
    DebugTool log = new DebugTool();

    @Override
    public void handleNotification(Notification notification, Object handback) {
        System.out.println("Received notification: " + notification.getMessage());
    }

    @PostConstruct
    public void registerListener() {
        try {
            MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
            ObjectName hitCounterName = new ObjectName("com.papa.johns:type=HitCounter");

            mbs.addNotificationListener(hitCounterName, this, null, null);
            log.info("Listener registered successfully");

        } catch (Exception e) {
            log.error("Failed to register listener: " + e.getMessage());
        }
    }
}
