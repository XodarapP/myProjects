import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class FileEventLogger implements EventLogger {
    private  String fileName;
    private final boolean append = true;
    private File file;

    public FileEventLogger(String fileName) {
        this.fileName = fileName;
        file = new File(fileName);
    }

    public FileEventLogger() {
    }

    @Override
    public void logEvent(Event event) {
        try {
            FileUtils.writeStringToFile(file, event.toString() + "\n", append);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void init() {
        this.file = new File(fileName);
        if (file.exists() && !file.canWrite()) {
            throw new IllegalArgumentException("Can't write to file " + fileName);
        } else if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Exception e) {
                throw new IllegalArgumentException("Can't create file", e);
            }
        }
    }
}
