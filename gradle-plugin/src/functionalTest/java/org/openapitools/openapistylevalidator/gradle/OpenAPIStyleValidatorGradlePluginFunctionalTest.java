package org.openapitools.openapistylevalidator.gradle;

import org.gradle.testkit.runner.BuildResult;
import org.gradle.testkit.runner.GradleRunner;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;

/**
 * A simple functional test for the 'org.openapitools.openapistylevalidator' plugin.
 */
public class OpenAPIStyleValidatorGradlePluginFunctionalTest {
    @Test public void canRunTask() throws IOException {
        // Setup the test build
        File projectDir = new File("build/functionalTest");
        Files.createDirectories(projectDir.toPath());
        writeString(new File(projectDir, "openapi.yaml"), "" +
                "openapi: 3.0.1\n" + 
                "info:\n" + 
                "  title: ping test\n" + 
                "  version: '1.0'\n" + 
                "servers:\n" + 
                "  - url: 'http://localhost:9999/'\n" + 
                "paths:\n" + 
                "  /ping:\n" + 
                "    post:\n" + 
                "      operationId: pingGet\n" + 
                "      responses:\n" + 
                "        '201':\n" + 
                "          description: OK");
        writeString(new File(projectDir, "settings.gradle"), "");
        writeString(new File(projectDir, "build.gradle"),
            "plugins {\n" +
            "  id('org.openapitools.openapistylevalidator')\n" +
            "}\n");

        // Run the build
        GradleRunner runner = GradleRunner.create();
        runner.forwardOutput();
        runner.withPluginClasspath();
        runner.withArguments("openAPIStyleValidator");
        runner.withProjectDir(projectDir);
        BuildResult result = runner.build();

        // Verify the result
        // assertTrue(result.getOutput().contains("Hello from plugin 'org.openapitools.openapistylevalidator'"));
    }

    private void writeString(File file, String string) throws IOException {
        try (Writer writer = new FileWriter(file)) {
            writer.write(string);
        }
    }
}
