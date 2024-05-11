package com.github.macgarcia.ide.auditoria.utils;

import com.github.macgarcia.ide.auditoria.configuration.FactoryLog;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author macgarcia
 */
public final class Archive {
    
    private static final Logger LOGGER = FactoryLog.getLog();
    private static final String PATH_DIR = "./config";

    private Archive() {}

    public static final List<String> readArchives() {
        List<String> archivesOfConnection = new ArrayList<>();
        try (DirectoryStream<Path> archives = Files.newDirectoryStream(Paths.get(PATH_DIR))) {
            for (Path arq : archives) {
                if (Files.isRegularFile(arq)) {
                    final StringBuilder arqJson = new StringBuilder();
                    List<String> lines = Files.readAllLines(arq);
                    lines.forEach(line -> arqJson.append(line));
                    archivesOfConnection.add(arqJson.toString());
                }
            }
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error while finded the archive.");
        }
        return archivesOfConnection;
    }
    
}
