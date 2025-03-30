package temp;

public class NachaFileBatchHeader extends NachaFileLine {
    // 1-1 1 Record Type Code 5 Constant
    private String recordTypeCode = "5";

    // 2-4 3 Service Class Code 200, 220, 225
    // Represents whether the batch contains: 200 Both Debits and Credits, mixed,
    // 220 Credits, 225 Debits
    private String serviceClassCode;

    // 5-20 16 Company Name Alphanumeric Your company name.
    // Often the same as the Immediate Origin Name in the file header.
    // PRINTED - This value will appear on the other party's bank statement
    private String companyName;

    // 21-40 20 Company Discretionary Data Alphanumeric Optional. May be instructed
    // by your bank. Otherwise (typically), leave blank
    private String companyDiscretionaryData = "                    ";

    // 41-50 10 Company Identification Numeric Typically a "1" + your Federal ID
    // number. Determined by your bank. Often the same as the Immediate Origin ID in
    // the file header. No hyphen, numbers only.
    private String companyIdentification;

    // 51-53 3 Standard Entry Class Code (SEC) PPD, CCD
    // 3 letter mnemonic which identifies the batch and its' layout.
    // PPD - used if the other party is an individual (ie. payroll)
    // CCD - used if the other party is a corporate account (ie. vendor payments and
    // customer collections).
    // Other values (not part of this layout/sample) include ARC, BOC, CTX, IAT, TEL
    // and WEB.
    private String standardEntryClassCode;

    // 54-63 10 Company Entry Description Alphanumeric A description as to the
    // general nature of the transactions to help the other parties identify the
    // purpose. Examples: Payroll, Payables, etc...
    // PRINTED - This value will appear on the other party's bank statement
    private String companyEntryDescription;

    // 64-69 6 Company Descriptive Date Alphanumeric, often YYMMDD
    // Optional. Descriptive date - often in YYMMDD with the same value as the
    // effective date. Useful in recurring transaction scenarios, such as payroll.
    // PRINTED - This value may appear on the other party's bank statement
    private String companyDescriptiveDate;

    // 70-75 6 Effective Entry Date YYMMDD Effective / transaction date. Date the
    // other party is to be debited or credited.
    private String effectiveEntryDate;

    // 76-78 3 Reserved Blank Julian Settlement Date - left blank. Will be filled in
    // by your bank.
    private String reserved = "   ";

    // 79-79 1 Originator Status Code 1 Constant
    private String originStatusCode = "1";

    // 80-87 8 Originating DFI ID Numeric Enter the first 8 digits of your ABA
    // routing number
    private String originatingDFIId;

    // 88-94 7 Batch Number Numeric Start with 00000001 and increment by 1 for each
    // batch.
    private String batchNumber;

    public NachaFileBatchHeader() {
        DataGenerator dataGenerator = new DataGenerator();
        // recordTypeCode
        serviceClassCode = dataGenerator.serviceClassCode();
        companyName = dataGenerator.companyName().substring(0, 16);
        // companyDiscretionaryData
        companyIdentification = dataGenerator.federalId();
        standardEntryClassCode = dataGenerator.standardEntryClassCode();
        companyEntryDescription = dataGenerator.companyEntryDescription();
        companyDescriptiveDate = dataGenerator.date();
        effectiveEntryDate = dataGenerator.date();
        // reserved
        // originStatusCode
        originatingDFIId = "" + dataGenerator.number(8);
        batchNumber = dataGenerator.padleft("" + dataGenerator.number(3), '0', 7);
    }

    public String toString() {
        return "" + recordTypeCode + serviceClassCode + companyName + companyDiscretionaryData + companyIdentification +
                standardEntryClassCode + companyEntryDescription + companyDescriptiveDate + effectiveEntryDate
                + reserved
                + originStatusCode + originatingDFIId + batchNumber;
    }

    public String getRecordTypeCode() {
        return recordTypeCode;
    }

    public void setRecordTypeCode(String recordTypeCode) {
        this.recordTypeCode = recordTypeCode;
    }

    public String getServiceClassCode() {
        return serviceClassCode;
    }

    public void setServiceClassCode(String serviceClassCode) {
        this.serviceClassCode = serviceClassCode;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyDiscretionaryData() {
        return companyDiscretionaryData;
    }

    public void setCompanyDiscretionaryData(String companyDiscretionaryData) {
        this.companyDiscretionaryData = companyDiscretionaryData;
    }

    public String getCompanyIdentification() {
        return companyIdentification;
    }

    public void setCompanyIdentification(String companyIdentification) {
        this.companyIdentification = companyIdentification;
    }

    public String getStandardEntryClassCode() {
        return standardEntryClassCode;
    }

    public void setStandardEntryClassCode(String standardEntryClassCode) {
        this.standardEntryClassCode = standardEntryClassCode;
    }

    public String getCompanyEntryDescription() {
        return companyEntryDescription;
    }

    public void setCompanyEntryDescription(String companyEntryDescription) {
        this.companyEntryDescription = companyEntryDescription;
    }

    public String getCompanyDescriptiveDate() {
        return companyDescriptiveDate;
    }

    public void setCompanyDescriptiveDate(String companyDescriptiveDate) {
        this.companyDescriptiveDate = companyDescriptiveDate;
    }

    public String getEffectiveEntryDate() {
        return effectiveEntryDate;
    }

    public void setEffectiveEntryDate(String effectiveEntryDate) {
        this.effectiveEntryDate = effectiveEntryDate;
    }

    public String getReserved() {
        return reserved;
    }

    public void setReserved(String reserved) {
        this.reserved = reserved;
    }

    public String getOriginStatusCode() {
        return originStatusCode;
    }

    public void setOriginStatusCode(String originStatusCode) {
        this.originStatusCode = originStatusCode;
    }

    public String getOriginatingDFIId() {
        return originatingDFIId;
    }

    public void setOriginatingDFIId(String originatingDFIId) {
        this.originatingDFIId = originatingDFIId;
    }

    public String getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber;
    }

}
