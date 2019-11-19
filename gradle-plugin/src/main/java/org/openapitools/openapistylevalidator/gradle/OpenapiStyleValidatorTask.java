package org.openapitools.openapistylevalidator.gradle;

import io.swagger.parser.OpenAPIParser;
import io.swagger.v3.parser.core.models.ParseOptions;
import io.swagger.v3.parser.core.models.SwaggerParseResult;

import org.gradle.api.DefaultTask;
import org.gradle.api.GradleException;
import org.gradle.api.tasks.TaskAction;
import org.gradle.api.tasks.options.Option;
import org.openapitools.empoa.swagger.core.internal.SwAdapter;
import org.openapitools.openapistylevalidator.OpenApiSpecStyleValidator;
import org.openapitools.openapistylevalidator.ValidatorParameters;
import org.openapitools.openapistylevalidator.ValidatorParameters.NamingStrategy;
import org.openapitools.openapistylevalidator.styleerror.StyleError;

import java.util.List;

public class OpenapiStyleValidatorTask extends DefaultTask {

    public static final String INPUT_FILE = "inputFile";

    public static final String VALIDATE_INFO_LICENSE = "validateInfoLicense";
    public static final String VALIDATE_INFO_DESCRIPTION = "validateInfoDescription";
    public static final String VALIDATE_INFO_CONTACT = "validateInfoContact";

    public static final String VALIDATE_OPERATION_OPERATION_ID = "validateOperationOperationId";
    public static final String VALIDATE_OPERATION_DESCRIPTION = "validateOperationDescription";
    public static final String VALIDATE_OPERATION_TAG = "validateOperationTag";
    public static final String VALIDATE_OPERATION_SUMMARY = "validateOperationSummary";

    public static final String VALIDATE_MODEL_PROPERTIES_EXAMPLE = "validateModelPropertiesExample";
    public static final String VALIDATE_MODEL_NO_LOCAL_DEF = "validateModelNoLocalDef";

    public static final String VALIDATE_NAMING = "validateNaming";
    public static final String IGNORE_HEADER_X_NAMING = "ignoreHeaderXNaming";
    public static final String PATH_NAMING_STRATEGY = "pathNamingStrategy";
    public static final String PARAMETER_NAMING_STRATEGY = "parameterNamingStrategy";
    public static final String PROPERTY_NAMING_STRATEGY = "propertyNamingStrategy";

    
    private String inputFile;

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
        if(inputFile == null) {
            throw new GradleException("The input file is not defined");
        }
        getLogger().quiet("Validating spec: " + inputFile);

        OpenAPIParser openApiParser = new OpenAPIParser();
        ParseOptions parseOptions = new ParseOptions();
        parseOptions.setResolve(true);

        SwaggerParseResult parserResult = openApiParser.readLocation(inputFile, null, parseOptions);
        io.swagger.v3.oas.models.OpenAPI swaggerOpenAPI = parserResult.getOpenAPI();

        org.eclipse.microprofile.openapi.models.OpenAPI openAPI = SwAdapter.toOpenAPI(swaggerOpenAPI);
        OpenApiSpecStyleValidator openApiSpecStyleValidator = new OpenApiSpecStyleValidator(openAPI);

        ValidatorParameters parameters = createValidatorParameters();
        List<StyleError> result = openApiSpecStyleValidator.validate(parameters);
        if(!result.isEmpty()) {
            getLogger().error("OpenAPI Specification does not meet the requirements. Issues:\n");
            result.stream().map(StyleError::toString).forEach(m -> getLogger().error("\t" + m));
            throw new GradleException("OpenAPI Style validation failed");
        }
    }

    @Option(option = INPUT_FILE, description = "")
    public void setInputFile(String inputFile) {
        this.inputFile = inputFile;
    }

    @Option(option = VALIDATE_INFO_LICENSE, description = "")
    public void setValidateInfoLicense(boolean validateInfoLicense) {
        this.validateInfoLicense = validateInfoLicense;
    }

    @Option(option = VALIDATE_INFO_DESCRIPTION, description = "")
    public void setValidateInfoDescription(boolean validateInfoDescription) {
        this.validateInfoDescription = validateInfoDescription;
    }

    @Option(option = VALIDATE_INFO_CONTACT, description = "")
    public void setValidateInfoContact(boolean validateInfoContact) {
        this.validateInfoContact = validateInfoContact;
    }

    @Option(option = VALIDATE_OPERATION_OPERATION_ID, description = "")
    public void setValidateOperationOperationId(boolean validateOperationOperationId) {
        this.validateOperationOperationId = validateOperationOperationId;
    }

    @Option(option = VALIDATE_OPERATION_DESCRIPTION, description = "")
    public void setValidateOperationDescription(boolean validateOperationDescription) {
        this.validateOperationDescription = validateOperationDescription;
    }

    @Option(option = VALIDATE_OPERATION_TAG, description = "")
    public void setValidateOperationTag(boolean validateOperationTag) {
        this.validateOperationTag = validateOperationTag;
    }

    @Option(option = VALIDATE_OPERATION_SUMMARY, description = "")
    public void setValidateOperationSummary(boolean validateOperationSummary) {
        this.validateOperationSummary = validateOperationSummary;
    }

    @Option(option = VALIDATE_MODEL_PROPERTIES_EXAMPLE, description = "")
    public void setValidateModelPropertiesExample(boolean validateModelPropertiesExample) {
        this.validateModelPropertiesExample = validateModelPropertiesExample;
    }

    @Option(option = VALIDATE_MODEL_NO_LOCAL_DEF, description = "")
    public void setValidateModelNoLocalDef(boolean validateModelNoLocalDef) {
        this.validateModelNoLocalDef = validateModelNoLocalDef;
    }

    @Option(option = VALIDATE_NAMING, description = "")
    public void setValidateNaming(boolean validateNaming) {
        this.validateNaming = validateNaming;
    }

    @Option(option = IGNORE_HEADER_X_NAMING, description = "")
    public void setIgnoreHeaderXNaming(boolean ignoreHeaderXNaming) {
        this.ignoreHeaderXNaming = ignoreHeaderXNaming;
    }

    @Option(option = PATH_NAMING_STRATEGY, description = "")
    public void setPathNamingStrategy(NamingStrategy pathNamingStrategy) {
        this.pathNamingStrategy = pathNamingStrategy;
    }

    @Option(option = PARAMETER_NAMING_STRATEGY, description = "")
    public void setParameterNamingStrategy(NamingStrategy parameterNamingStrategy) {
        this.parameterNamingStrategy = parameterNamingStrategy;
    }

    @Option(option = PROPERTY_NAMING_STRATEGY, description = "")
    public void setPropertyNamingStrategy(NamingStrategy propertyNamingStrategy) {
        this.propertyNamingStrategy = propertyNamingStrategy;
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
