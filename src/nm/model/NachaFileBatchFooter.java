package nm.model;

import nm.data.DataGenerator;
import nm.parse.NachaFileLine;

public class NachaFileBatchFooter extends NachaFileLine {
    // 1-1 1 Record Type Code 8 Constant
    private String recordTypeCode = "8";

    // 2-4 3 Service Class Code 200, 220, 225
    // Represents whether the batch contains: 200 Both Debits and Credits, mixed,
    // 220 Credits, 225 Debits
    private String serviceClassCode;

    // 5-10 6 Entry/Addenda Count Numeric
    // Number of detail entry (transactions) and addenda records within the batch.
    private String entryAddendaCount;

    // 11-20 10 Entry Hash Numeric Sum of the receiving DFI ID (first 8 digits of
    // the other party's ABA routing number) for each entry/transaction within the
    // batch. If the sum exceeds 10 places, use the rightmost 10 digits.
    private String entryHash;

    // 21-32 12 Total Debit Entry Dollar Amount Numeric Total debits for the batch.
    // No decimal.
    private String totalDebitEntry;

    // 33-44 12 Total Credit Entry Dollar Amount Numeric
    // Total credit for the batch. No decimal.
    private String totalCreditEntry;

    // 45-54 10 Company Identification Numeric Typically a "1" + your Federal ID
    // number. Determined by your bank.
    // Must match the entry in the batch header.
    private String companyIdentification;

    // 55-73 19 Message Authentication Code Blank
    // Blank
    private String messageAuthenticationCode = "                   ";

    // 74-79 6 Reserved Blank Blank
    private String reserved = "      ";

    // 80-87 8 Originating DFI ID Numeric Enter the first 8 digits of your ABA
    // routing number
    // Must match the entry in the batch header.
    private String originatingDFIId;

    // 88-94 7 Batch Number Numeric Start with 00000001 and increment by 1 for each
    // batch.
    // Must match the entry in the batch header.
    private String batchNumber;

    public NachaFileBatchFooter() {
        DataGenerator dataGenerator = new DataGenerator();
        // recordTypeCode
        serviceClassCode = dataGenerator.serviceClassCode();
        entryAddendaCount = dataGenerator.padleft("" + dataGenerator.number(3), '0', 6);
        entryHash = dataGenerator.padleft("" + dataGenerator.number(5), '0', 10);
        totalDebitEntry = dataGenerator.padleft("" + dataGenerator.number(7), '0', 12);
        totalCreditEntry = dataGenerator.padleft("" + dataGenerator.number(7), '0', 12);
        companyIdentification = dataGenerator.federalId();
        // messageAuthenticationCode
        // reserved
        originatingDFIId = "" + dataGenerator.number(8);
        batchNumber = dataGenerator.padleft("" + dataGenerator.number(3), '0', 7);
    }

    public String toString() {
        return "" + recordTypeCode + serviceClassCode + entryAddendaCount + entryHash + totalDebitEntry +
                totalCreditEntry + companyIdentification + messageAuthenticationCode + reserved + originatingDFIId
                + batchNumber;
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

    public String getEntryAddendaCount() {
        return entryAddendaCount;
    }

    public void setEntryAddendaCount(String entryAddendaCount) {
        this.entryAddendaCount = entryAddendaCount;
    }

    public String getEntryHash() {
        return entryHash;
    }

    public void setEntryHash(String entryHash) {
        this.entryHash = entryHash;
    }

    public String getTotalDebitEntry() {
        return totalDebitEntry;
    }

    public void setTotalDebitEntry(String totalDebitEntry) {
        this.totalDebitEntry = totalDebitEntry;
    }

    public String getTotalCreditEntry() {
        return totalCreditEntry;
    }

    public void setTotalCreditEntry(String totalCreditEntry) {
        this.totalCreditEntry = totalCreditEntry;
    }

    public String getCompanyIdentification() {
        return companyIdentification;
    }

    public void setCompanyIdentification(String companyIdentification) {
        this.companyIdentification = companyIdentification;
    }

    public String getMessageAuthenticationCode() {
        return messageAuthenticationCode;
    }

    public void setMessageAuthenticationCode(String messageAuthenticationCode) {
        this.messageAuthenticationCode = messageAuthenticationCode;
    }

    public String getReserved() {
        return reserved;
    }

    public void setReserved(String reserved) {
        this.reserved = reserved;
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
