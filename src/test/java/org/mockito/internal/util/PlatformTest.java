package org.mockito.internal.util;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlatformTest {

    @Test
    public void version_should_be_x_dot_y() throws Exception {
        assertThat(Platform.JAVA_VERSION).matches("(?:1|2)\\.\\d");
    }
}
