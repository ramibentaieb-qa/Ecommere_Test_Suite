package utilities;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class DownloadUtility {

    private static final Path DOWNLOAD_FOLDER = Paths.get("target", "downloads").toAbsolutePath();

    public static Path getDownloadFolder() {
        return DOWNLOAD_FOLDER;
    }

    public static String readDownloadFile(int seconds) throws Exception {
        long deadline = System.currentTimeMillis() + seconds * 1000L;

        while (System.currentTimeMillis() < deadline) {
            try (Stream<Path> files = Files.list(DOWNLOAD_FOLDER)) {
                Path file = files
                        .filter(Files::isRegularFile)
                        .filter(f -> !f.getFileName().toString().endsWith(".crdownload"))
                        .findFirst()
                        .orElse(null);
                if (file != null) {
                    return Files.readString(file);
                }
            }
            Thread.sleep(500);
        }
        throw new AssertionError("No file was downloaded in " + seconds + " seconds");
    }




}
