package org.openapitools.openapistylevalidator;

public class ValidatorParameters {

    public static enum NamingConvention {
        UnderscoreCase("underscore_case"),
        CamelCase("camelCase"),
        HyphenCase("hyphen-case");

        private final String appelation;

        NamingConvention(String appelation) {
            this.appelation = appelation;
        }

        public String getAppelation() {
            return appelation;
        }
    }
    
    /**
     * @deprecated Please use {@link ValidatorParameters.NamingConvention} instead.
     */
    @Deprecated
    public static enum NamingStrategy {
        UnderscoreCase,
        CamelCase,
        HyphenCase;

        public String getAppelation() {
            return toConvention(this).getAppelation();
        }

        public static NamingStrategy valueOf(NamingConvention pathNamingConvention) {
            if(pathNamingConvention == null) {
                return null;
            }
            return NamingStrategy.valueOf(pathNamingConvention.name());
        }

        public static NamingConvention toConvention(NamingStrategy pathNamingStrategy) {
            if(pathNamingStrategy == null) {
                return null;
            }
            return NamingConvention.valueOf(pathNamingStrategy.name());
        }
    }

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
    private NamingConvention pathNamingConvention = NamingConvention.HyphenCase;
    private NamingConvention parameterNamingConvention = NamingConvention.CamelCase;
    private NamingConvention propertyNamingConvention= NamingConvention.CamelCase;

    public ValidatorParameters() {
        //For Gson
    }

    public boolean isValidateInfoLicense() {
        return validateInfoLicense;
    }

    public boolean isValidateInfoDescription() {
        return validateInfoDescription;
    }

    public boolean isValidateInfoContact() {
        return validateInfoContact;
    }

    public boolean isValidateOperationOperationId() {
        return validateOperationOperationId;
    }

    public boolean isValidateOperationDescription() {
        return validateOperationDescription;
    }

    public boolean isValidateOperationTag() {
        return validateOperationTag;
    }

    public boolean isValidateOperationSummary() {
        return validateOperationSummary;
    }

    public boolean isValidateModelPropertiesExample() {
        return validateModelPropertiesExample;
    }

    public boolean isValidateModelNoLocalDef() {
        return validateModelNoLocalDef;
    }

    public NamingStrategy getPathNamingStrategy() {
        return NamingStrategy.valueOf(getParameterNamingConvention());
    }

    public NamingStrategy getParameterNamingStrategy() {
        return NamingStrategy.valueOf(getParameterNamingConvention());
    }

    public NamingStrategy getPropertyNamingStrategy() {
        return NamingStrategy.valueOf(getPropertyNamingConvention());
    }

    public NamingConvention getPathNamingConvention() {
        return pathNamingConvention;
    }

    public NamingConvention getParameterNamingConvention() {
        return parameterNamingConvention;
    }

    public NamingConvention getPropertyNamingConvention() {
        return propertyNamingConvention;
    }

    public void setPropertyNamingConvention(NamingConvention propertyNamingStrategy) {
        this.propertyNamingConvention = propertyNamingStrategy;
    }

    public void setValidateInfoLicense(boolean validateInfoLicense) {
        this.validateInfoLicense = validateInfoLicense;
    }

    public void setValidateInfoDescription(boolean validateInfoDescription) {
        this.validateInfoDescription = validateInfoDescription;
    }

    public void setValidateInfoContact(boolean validateInfoContact) {
        this.validateInfoContact = validateInfoContact;
    }

    public void setValidateOperationOperationId(boolean validateOperationOperationId) {
        this.validateOperationOperationId = validateOperationOperationId;
    }

    public void setValidateOperationDescription(boolean validateOperationDescription) {
        this.validateOperationDescription = validateOperationDescription;
    }

    public void setValidateOperationTag(boolean validateOperationTag) {
        this.validateOperationTag = validateOperationTag;
    }

    public void setValidateOperationSummary(boolean validateOperationSummary) {
        this.validateOperationSummary = validateOperationSummary;
    }

    public void setValidateModelPropertiesExample(boolean validateModelPropertiesExample) {
        this.validateModelPropertiesExample = validateModelPropertiesExample;
    }

    public void setValidateModelNoLocalDef(boolean validateModelNoLocalDef) {
        this.validateModelNoLocalDef = validateModelNoLocalDef;
    }

    public void setPathNamingConvension(NamingConvention pathNamingConvention) {
        this.pathNamingConvention = pathNamingConvention;
    }

    public void setParameterNamingConvension(NamingConvention parameterNamingConvention) {
        this.parameterNamingConvention = parameterNamingConvention;
    }

    public void setPropertyNamingConvension(NamingConvention propertyNamingConvention) {
        this.propertyNamingConvention = propertyNamingConvention;
    }
    
    public void setPathNamingConvension(NamingStrategy pathNamingStrategy) {
        setPathNamingConvension(NamingStrategy.toConvention(pathNamingStrategy));
    }
    
    public void setParameterNamingConvension(NamingStrategy parameterNamingStrategy) {
        setParameterNamingConvension(NamingStrategy.toConvention(parameterNamingStrategy));
    }
    
    public void setPropertyNamingConvension(NamingStrategy propertyNamingStrategy) {
        setPropertyNamingConvension(NamingStrategy.toConvention(propertyNamingStrategy));
    }

    public boolean isValidateNaming() {
        return validateNaming;
    }

    public void setValidateNaming(boolean validateNaming) {
        this.validateNaming = validateNaming;
    }

    public boolean isIgnoreHeaderXNaming() {
        return ignoreHeaderXNaming;
    }

    public void setIgnoreHeaderXNaming(boolean ignoreHeaderXNaming) {
        this.ignoreHeaderXNaming = ignoreHeaderXNaming;
    }
}
