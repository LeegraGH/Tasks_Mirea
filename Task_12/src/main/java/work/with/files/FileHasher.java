package work.with.files;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Component
public class FileHasher {
    @Value("${inputFile}")
    private String inputFile;

    @Value("${outputFile}")
    private String outputFile;

    private String hashedData;

    @PostConstruct
    public void hashFile() throws NoSuchAlgorithmException, IOException {
        File file = new File(inputFile);

        if (!file.exists()) {
            Files.write(Paths.get(outputFile), "".getBytes());
            return;
        }

        byte[] fileBytes = Files.readAllBytes(Paths.get(inputFile));

        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(fileBytes);

        hashedData = bytesToHex(md.digest());
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder result = new StringBuilder();

        for (byte b : bytes) {
            result.append(String.format("%02X", b));
        }
        return result.toString();
    }

    @PreDestroy
    public void removeFile() throws IOException {
        File file = new File(inputFile);

        if (file.exists()) {
            file.delete();
        }

        Files.write(Paths.get(outputFile), hashedData.getBytes());

    }

}
