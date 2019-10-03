package org.openapitools.openapistylevalidator.gradle;

import org.gradle.api.DefaultTask;
import org.gradle.api.InvalidUserDataException;
import org.gradle.api.tasks.TaskAction;
import org.gradle.api.tasks.options.Option;

public class OpenapiStyleValidatorTask extends DefaultTask {

    public OpenapiStyleValidatorTask() {
        this.setGroup("Verification");
        this.setDescription("Validate that OpenAPI files against style rules");
    }

    @TaskAction
    public void execute() {
        // OpenAPIParser openApiParser = new OpenAPIParser();
        // ParseOptions parseOptions = new ParseOptions();
        // parseOptions.setResolve(true);

        // SwaggerParseResult parserResult = openApiParser.readLocation(optionManager.getSource(commandLine), null, parseOptions);
        // io.swagger.v3.oas.models.OpenAPI swaggerOpenAPI = parserResult.getOpenAPI();

        // org.eclipse.microprofile.openapi.models.OpenAPI openAPI = SwAdapter.toOpenAPI(swaggerOpenAPI);
        // OpenApiSpecStyleValidator openApiSpecStyleValidator = new OpenApiSpecStyleValidator(openAPI);

        // ValidatorParameters parameters = createValidatorParameters());

        // outputUtils.printResults(openApiSpecStyleValidator.validate(parameters));

        System.out.println("Hello from plugin 'org.openapitools.openapistylevalidator'");
    }

    // public ValidatorParameters createValidatorParameters() {
    // }

}
