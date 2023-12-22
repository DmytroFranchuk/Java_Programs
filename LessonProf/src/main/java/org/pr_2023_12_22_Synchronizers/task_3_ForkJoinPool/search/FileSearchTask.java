package org.pr_2023_12_22_Synchronizers.task_3_ForkJoinPool.search;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class FileSearchTask extends RecursiveTask<List<String>> {
    private final String fileName;
    private final File directory;

    public FileSearchTask(String fileName, File directory) {
        this.fileName = fileName;
        this.directory = directory;
    }

    @Override
    protected List<String> compute() {
        List<String> files = new ArrayList<>();
        File[] inDirectory = directory.listFiles();
        if (inDirectory == null) {
            return new ArrayList<>();
        }
        else {
            List<FileSearchTask> tasks = new ArrayList<>();
            for (File f : inDirectory) {
                if (f.isFile()) {
                    if (f.getName().contains(fileName)) {
                        files.add(f.getAbsoluteFile().toString());
                    }
                } else {
                     FileSearchTask searchTask = new FileSearchTask(fileName, f);
                     tasks.add(searchTask);
                     searchTask.fork();
                }
            }
            files.addAll(tasks.stream()
                    .flatMap(t -> t.join().stream()).toList());
        }
        return files;
    }
}
