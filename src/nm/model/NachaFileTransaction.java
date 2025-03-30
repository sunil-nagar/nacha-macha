package src.nm.model;

import src.nm.data.DataGenerator;
import src.nm.parse.NachaFileLine;

public class NachaFileTransaction extends NachaFileLine {

    // 1-1 1 Record Type Code 6 Constant
    private String recordTypeCode = "6";

    // 2-3 2 Transaction Code 22, 32, 27, 37
    private String transactionCode;

    // 4-11 8 Receiving DFI ID Numeric
    // First 8 digits of the other party's ABA routing number
    private String receivingDFIId;

    // 12-12 1 Check Digit Numeric Last digit of the other party's ABA routing
    // number
    private String checkDigit;

    // 13-29 17 DFI Account Number Alphanumeric Other party's account number.
    // Note: This is an alphanumeric field and should be left justified.
    private String dfiAccountNumber;

    // 30-39 10 Amount Numeric
    // Transaction amount. No decimal.
    private String transactionAmount;

    // 40-54 15 Identification Number Alphanumeric Optional. Helps the receiver
    // (other party) identify themselves within your system, should they need to
    // contact you. Typically their account number.
    // PRINTED - This value may appear on the other party's bank statement
    private String identificationNumber = "               ";

    // 55-76 22 Receiving Company Name Alphanumeric
    // The other party's company name (in CCD) - or if a consumer transaction (in
    // PPC) such as payroll, the individual's name.
    private String receivingCompanyName;

    // 77-78 2 Discretionary Data Alphanumeric Typically blank, unless instructed
    // otherwise by your bank.
    private String discretionaryData = "  ";

    // 79-79 1 Addenda Record Indicator 0 or 1 0 - No addenda following 1 - Addenda
    // following
    private String addendaRecordIndicator = "0";

    // 80-94 15 Trace Number Numeric The first 8 digits of your Originating DFI
    // number, followed by the entry detail sequence number,
    private String traceNumber;

    public NachaFileTransaction() {
        DataGenerator dataGenerator = new DataGenerator();
        // recordTypeCode
        transactionCode = dataGenerator.transactionCode();
        receivingDFIId = "" + dataGenerator.number(8);
        checkDigit = "" + dataGenerator.number(1);
        dfiAccountNumber = dataGenerator.padright("" + dataGenerator.number(8), ' ', 17);
        transactionAmount = dataGenerator.padleft("" + dataGenerator.number(10, 9999), '0', 10);
        // identificationNumber
        receivingCompanyName = dataGenerator.companyName().substring(0, 22);
        // discretionaryData
        // addendaRecordIndicator
        traceNumber = "" + dataGenerator.number(8) + dataGenerator.number(7);
    }

    public String toString() {
        return "" + recordTypeCode + transactionCode + receivingDFIId +
                checkDigit + dfiAccountNumber + transactionAmount +
                identificationNumber + receivingCompanyName + discretionaryData + addendaRecordIndicator
                + traceNumber;
    }

    public String getRecordTypeCode() {
        return recordTypeCode;
    }

    public void setRecordTypeCode(String recordTypeCode) {
        this.recordTypeCode = recordTypeCode;
    }

    public String getTransactionCode() {
        return transactionCode;
    }

    public void setTransactionCode(String transactionCode) {
        this.transactionCode = transactionCode;
    }

    public String getReceivingDFIId() {
        return receivingDFIId;
    }

    public void setReceivingDFIId(String receivingDFIId) {
        this.receivingDFIId = receivingDFIId;
    }

    public String getCheckDigit() {
        return checkDigit;
    }

    public void setCheckDigit(String checkDigit) {
        this.checkDigit = checkDigit;
    }

    public String getDfiAccountNumber() {
        return dfiAccountNumber;
    }

    public void setDfiAccountNumber(String dfiAccountNumber) {
        this.dfiAccountNumber = dfiAccountNumber;
    }

    public String getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(String transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public String getReceivingCompanyName() {
        return receivingCompanyName;
    }

    public void setReceivingCompanyName(String receivingCompanyName) {
        this.receivingCompanyName = receivingCompanyName;
    }

    public String getDiscretionaryData() {
        return discretionaryData;
    }

    public void setDiscretionaryData(String discretionaryData) {
        this.discretionaryData = discretionaryData;
    }

    public String getAddendaRecordIndicator() {
        return addendaRecordIndicator;
    }

    public void setAddendaRecordIndicator(String addendaRecordIndicator) {
        this.addendaRecordIndicator = addendaRecordIndicator;
    }

    public String getTraceNumber() {
        return traceNumber;
    }

    public void setTraceNumber(String traceNumber) {
        this.traceNumber = traceNumber;
    }

}
