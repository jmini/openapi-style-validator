package org.openapitools.openapistylevalidator.gradle;

import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;
import org.openapitools.openapistylevalidator.ValidatorParameters;
import org.openapitools.openapistylevalidator.ValidatorParameters.NamingStrategy;

public class OpenapiStyleValidatorTask extends DefaultTask {

    private boolean validateInfoLicense = true;
    private boolean validateInfoDescription = true;
    private boolean validateInfoContact = true;

    private boolean validateOperationOperationId = true;
    private boolean validateOperationDescription = true;
    private boolean validateOperationTag = true;
    private boolean validateOperationSummary = true;

    private boolean validateModelPropertiesExample = true;
    private boolean validateModelNoLocalDef = true;

    private boolean validateNaming = true;
    private boolean ignoreHeaderXNaming = true;
    private NamingStrategy pathNamingStrategy = NamingStrategy.HyphenCase;
    private NamingStrategy parameterNamingStrategy = NamingStrategy.CamelCase;
    private NamingStrategy propertyNamingStrategy = NamingStrategy.CamelCase;
    
    public OpenapiStyleValidatorTask() {
        this.setGroup("Verification");
        this.setDescription("Validate that OpenAPI files against style rules");
    }

    @TaskAction
    public void execute() {
        System.out.println("Hello from plugin 'org.openapitools.openapistylevalidator'");

//         OpenAPIParser openApiParser = new OpenAPIParser();
//         ParseOptions parseOptions = new ParseOptions();
//         parseOptions.setResolve(true);
//
//         SwaggerParseResult parserResult = openApiParser.readLocation(optionManager.getSource(commandLine), null, parseOptions);
//         io.swagger.v3.oas.models.OpenAPI swaggerOpenAPI = parserResult.getOpenAPI();
//
//        // org.eclipse.microprofile.openapi.models.OpenAPI openAPI = SwAdapter.toOpenAPI(swaggerOpenAPI);
//         OpenApiSpecStyleValidator openApiSpecStyleValidator = new OpenApiSpecStyleValidator(openAPI);
//
//        // ValidatorParameters parameters = createValidatorParameters());
//
//        openApiSpecStyleValidator.validate(parameters)

    }

     public ValidatorParameters createValidatorParameters() {
        ValidatorParameters parameters = new ValidatorParameters();
        parameters.setValidateInfoLicense(validateInfoLicense);
        parameters.setValidateInfoDescription(validateInfoDescription);
        parameters.setValidateInfoContact(validateInfoContact);
        parameters.setValidateOperationOperationId(validateOperationOperationId);
        parameters.setValidateOperationDescription(validateOperationDescription);
        parameters.setValidateOperationTag(validateOperationTag);
        parameters.setValidateOperationSummary(validateOperationSummary);
        parameters.setValidateModelPropertiesExample(validateModelPropertiesExample);
        parameters.setValidateModelNoLocalDef(validateModelNoLocalDef);
        parameters.setValidateNaming(validateNaming);
        parameters.setIgnoreHeaderXNaming(ignoreHeaderXNaming);
        parameters.setPathNamingStrategy(pathNamingStrategy);
        parameters.setParameterNamingStrategy(parameterNamingStrategy);
        parameters.setPropertyNamingStrategy(propertyNamingStrategy);
        return parameters;
     }

}
