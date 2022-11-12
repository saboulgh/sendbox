package org.example;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.*;

import static java.nio.file.StandardWatchEventKinds.*;

/**
 * Hello world!
 */
@Slf4j
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        manageWatchService();
    }

    private static void manageWatchService() {
        try {
            WatchService watchService = FileSystems.getDefault().newWatchService();

            Path path = Paths.get("c:\\test");
            path.register(watchService, ENTRY_CREATE, ENTRY_MODIFY, ENTRY_DELETE);
            boolean poll = true;
            while (poll) {
                WatchKey key = watchService.take();
                for (WatchEvent<?> event : key.pollEvents()) {
                    System.out.println("Event kind : " + event.kind() + " - File : " + event.context());
                }
                poll = key.reset();
            }
        } catch (IOException|InterruptedException e) {
            e.printStackTrace();
        }
    }
}
