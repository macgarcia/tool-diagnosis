package com.github.macgarcia.ide.auditoria.utils;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *
 * @author macgarcia
 */
public class ArchiveTest {
    
    @Test
    public void shouldReadArchive() {
        List<String> info = Archive.readArchives();
        Assertions.assertThat(info).isNotEmpty();
    }
    
}
