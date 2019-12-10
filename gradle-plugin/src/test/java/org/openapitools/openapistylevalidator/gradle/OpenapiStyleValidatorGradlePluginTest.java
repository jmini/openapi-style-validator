package org.openapitools.openapistylevalidator.gradle;

import org.gradle.testfixtures.ProjectBuilder;
import org.gradle.api.Project;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * A simple unit test for the 'org.openapitools.openapistylevalidator' plugin.
 */
public class OpenapiStyleValidatorGradlePluginTest {
    @Test public void pluginRegistersATask() {
        // Create a test project and apply the plugin
        Project project = ProjectBuilder.builder().build();
        project.getPlugins().apply("org.openapitools.openapistylevalidator");

        // Verify the result
        assertNotNull(project.getTasks().findByName("openAPIStyleValidator"));
    }
}
