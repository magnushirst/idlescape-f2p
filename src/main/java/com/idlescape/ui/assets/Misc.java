package com.idlescape.ui.assets;

import com.idlescape.framework.log.StyledLogger;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Misc {
    // Auto generated via script. Do not change
    MOUSEDATA(
            "mousedata.json",
            "https://res.cloudinary.com/dadgivilj/raw/upload/v1777502051/mousedata.json",
            "sha256:404fb73b0e3cf3572c5f162a2d49f7e8e7f3b475e2e9ad9b84abf4112ce2a9b4"),
    NOTIFY(
            "notify.wav",
            "https://res.cloudinary.com/dadgivilj/video/upload/v1777502053/notify.wav",
            "sha256:7323c6ced9605a9b8a406cd088550d06d1a39dc8d37c9abfe52b536482468ad5"),
    RUNESCAPE_UF(
            "runescape_uf.ttf",
            "https://res.cloudinary.com/dadgivilj/raw/upload/v1777502054/runescape_uf.ttf",
            "sha256:4fd8115952dac02eb3b32a340e7c47c6388b1017669442ed80f9c4aae2dbf25c");
    // End

    private final String name;
    private final String url;
    private final String hash;
    private static final StyledLogger LOGGER = new StyledLogger(Misc.class);

    public InputStream get() {
        Path cacheDirectory = Paths.get(System.getProperty("scripts.path"), ".cache", "misc", "idlescape");
        Path cachedFile = cacheDirectory.resolve(name);

        try {
            Files.createDirectories(cacheDirectory);

            if (Files.notExists(cachedFile) || !hashMatches(cachedFile)) {
                downloadToCache(cachedFile);
            }

            return Files.newInputStream(cachedFile);
        } catch (IOException e) {
            LOGGER.error("Failed to access misc asset: " + name, e);
            throw new IllegalStateException("Failed to load misc asset: " + name, e);
        }
    }

    private boolean hashMatches(Path file) {
        String expectedHex = hash.startsWith("sha256:") ? hash.substring(7) : hash;
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] bytes = Files.readAllBytes(file);
            byte[] actual = digest.digest(bytes);
            StringBuilder sb = new StringBuilder();
            for (byte b : actual) {
                sb.append(String.format("%02x", b));
            }
            boolean matches = sb.toString().equals(expectedHex);
            if (!matches) {
                LOGGER.log("Hash mismatch for cached asset: " + name + " — redownloading");
            }
            return matches;
        } catch (NoSuchAlgorithmException | IOException e) {
            LOGGER.error("Failed to verify hash for: " + name, e);
            return false;
        }
    }

    private void downloadToCache(Path cachedFile) throws IOException {
        LOGGER.log("Downloading misc asset: " + name);
        Path tempFile = Files.createTempFile(cachedFile.getParent(), name + ".", ".tmp");

        try (InputStream remoteStream = new URL(url).openStream()) {
            Files.copy(remoteStream, tempFile, StandardCopyOption.REPLACE_EXISTING);
            Files.move(tempFile, cachedFile, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            Files.deleteIfExists(tempFile);
            throw e;
        }
    }
}
