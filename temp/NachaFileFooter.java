package temp;

public class NachaFileFooter {

    // 1-1 1 Record Type Code 9 Constant
    private String recordTypeCode = "9";

    // 2-7 6 Batch Count Numeric Number of batches in file
    private String batchCount;

    // 8-13 6 Block Count Numeric Number of blocks in file (10 records = 1 block)
    private String blockCount;

    // 14-21 8 Entry/Addenda Count Numeric Number of detail entry (transactions) and
    // addenda records within the file.
    private String entryAddendaCount;

    // 22-31 10 Entry Hash Numeric Sum of the receiving DFI ID (first 8 digits of
    // the other party's ABA routing number) for each entry/transaction within the
    // file. If the sum exceeds 10 places, use the rightmost 10 digits.
    private String entryHash;

    // 32-43 12 Total Debit Entry Dollar Amount Numeric Total debits for the file.
    // No decimal.
    private String totalDebitEntry;

    // 44-55 12 Total Credit Entry Dollar Amount Numeric Total credits for the file.
    // No decimal.
    private String totalCreditEntry;

    // 56-94 39 Reserved Blank Constant
    private String reserved = "                                       ";

    public NachaFileFooter() {
        DataGenerator dataGenerator = new DataGenerator();
        batchCount = dataGenerator.padleft("" + dataGenerator.number(1), '0', 6);
        blockCount = dataGenerator.padleft("" + dataGenerator.number(1), '0', 6);
        entryAddendaCount = dataGenerator.padleft("" + dataGenerator.number(3), '0', 8);
        entryHash = dataGenerator.padleft("" + dataGenerator.number(5), '0', 10);
        totalDebitEntry = dataGenerator.padleft("" + dataGenerator.number(7), '0', 12);
        totalCreditEntry = dataGenerator.padleft("" + dataGenerator.number(7), '0', 12);
    }

    public String toString() {
        return "" + recordTypeCode + batchCount + blockCount + entryAddendaCount + entryHash + totalDebitEntry
                + totalCreditEntry
                + reserved;
    }

    public String getRecordTypeCode() {
        return recordTypeCode;
    }

    public void setRecordTypeCode(String recordTypeCode) {
        this.recordTypeCode = recordTypeCode;
    }

    public String getBatchCount() {
        return batchCount;
    }

    public void setBatchCount(String batchCount) {
        this.batchCount = batchCount;
    }

    public String getBlockCount() {
        return blockCount;
    }

    public void setBlockCount(String blockCount) {
        this.blockCount = blockCount;
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

    public String getReserved() {
        return reserved;
    }

    public void setReserved(String reserved) {
        this.reserved = reserved;
    }

}
