package com.igindex.queue.filewatch;

import com.igindex.queue.messaging.EventGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.nio.file.*;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.igindex.queue.util.FileOpsHelper.getOrderObject;
import static com.igindex.queue.util.FileOpsHelper.validateFile;

@Component
public class FileWatcher implements CommandLineRunner {

    @Autowired
    EventGateway eventGateway;

    @Value("${file.path}")
    private String filePath;

    //responsible for continuously monitoring the location for any new files
    @Override
    public void run(String... strings) throws Exception {
        Path path = Paths.get(filePath);
        WatchService watchService = FileSystems.getDefault().newWatchService();
        path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);
        ExecutorService service = Executors.newFixedThreadPool(2);
        boolean valid;
        do {
            WatchKey watchKey = watchService.take();
            for (WatchEvent event : watchKey.pollEvents()) {
                if (StandardWatchEventKinds.ENTRY_CREATE.equals(event.kind())) {
                    String filename = event.context().toString();
                    if (!validateFile(filename)) {
                        continue;
                    }
                    service.submit(() -> eventGateway.send(getOrderObject(filename)));
                }
            }
            valid = watchKey.reset();
        } while (valid);
        service.shutdown();
    }
}
