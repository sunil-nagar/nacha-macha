package nm.model;

import nm.data.DataGenerator;
import nm.parse.NachaFileLine;

public class NachaFileHeader extends NachaFileLine {

    public NachaFileHeader() {
    }

    // Length: 1
    // Name: Record Type Code
    // Contents: 1
    // Description: Constant
    // Example: 1
    private String recordTypeCode = "1";

    // Length: 2
    // Name: Priority Code
    // Contents: 01
    // Description: Constant
    // Example: 01
    private String priorityCode = "01";

    // Length: 10
    // Name: Immediate Destination
    // Contents: bNNNNNNNNNN
    // Description: Typically your bank's 9 digit ABA Routing number, preceding with
    // a blank space
    // Example: 202881066
    private String immediateDestination;

    // Length: 10
    // Name: Immediate Origin
    // Contents: Numeric
    // Description: Typically a "1" + your Federal ID number
    // Example: 1300097832
    private String immediateOrigin;

    // Length: 6
    // Name: File Creation Date
    // Contents: YYMMDD
    // Description: Must be in YYMMDD format
    // Example: 20250314
    private String fileCreationDate;

    // Length: 4
    // Name: File Creation Time
    // Contents: HHMM
    // Description: Must be in HHMM format (use 24 hour format)
    // Example: 2009
    private String fileCreationTime;

    // Length: 1
    // Name: File ID Modifier
    // Contents: Alphanumeric
    // Description: Alphanumeric field, upper-case A-Z and 0-9 allowed. Start with A
    // and increment for each file created during the calendar day.
    // Example: C
    private String fileIdModifier;

    // Length: 3
    // Name: Record Size
    // Contents: 094
    // Description: Constant
    // Example: 094
    private String recordSize = "094";

    // Length: 2
    // Name: Blocking Factor
    // Contents: 10
    // Description: Constant
    // Example: 10
    private String blockingFactor = "10";

    // Length: 1
    // Name: Format Code
    // Contents: 10
    // Description: Constant
    // Example: 10
    private String formatCode = "1";

    // Length: 23
    // Name: Immediate Destination Name
    // Contents: Alphanumeric
    // Description: Enter your bank's name, left justified
    // Example: Bank of Any Town
    private String immediateDestinationName;

    // Length: 23
    // Name: Immediate Origin Name
    // Contents: Alphanumeric
    // Description: Enter your company's name, left justified
    // Example: Ohio Bank
    private String immediateOriginName;

    // Length: 8
    // Name: Reference Code
    // Contents: Blank
    // Description: 8 blank spaces
    // Example:
    private String referenceCode = "        ";


    public NachaFileHeader(int run) {
        DataGenerator dataGenerator = new DataGenerator();
        immediateDestination = dataGenerator.routingNumber();
        immediateOrigin = dataGenerator.federalId();
        fileCreationDate = dataGenerator.date();
        fileCreationTime = dataGenerator.time();
        fileIdModifier = dataGenerator.letter(run);
        immediateDestinationName = dataGenerator.bankName();
        immediateOriginName = dataGenerator.companyName();
    }

    public String toString() {
        return "" + recordTypeCode +
                priorityCode +
                immediateDestination +
                immediateOrigin +
                fileCreationDate +
                fileCreationTime +
                fileIdModifier +
                recordSize +
                blockingFactor +
                formatCode +
                immediateDestinationName +
                immediateOriginName +
                referenceCode;
    }

    public String getRecordTypeCode() {
        return recordTypeCode;
    }

    public void setRecordTypeCode(String recordTypeCode) {
        this.recordTypeCode = recordTypeCode;
    }

    public String getPriorityCode() {
        return priorityCode;
    }

    public void setPriorityCode(String priorityCode) {
        this.priorityCode = priorityCode;
    }

    public String getImmediateDestination() {
        return immediateDestination;
    }

    public void setImmediateDestination(String immediateDestination) {
        this.immediateDestination = immediateDestination;
    }

    public String getImmediateOrigin() {
        return immediateOrigin;
    }

    public void setImmediateOrigin(String immediateOrigin) {
        this.immediateOrigin = immediateOrigin;
    }

    public String getFileCreationDate() {
        return fileCreationDate;
    }

    public void setFileCreationDate(String fileCreationDate) {
        this.fileCreationDate = fileCreationDate;
    }

    public String getFileCreationTime() {
        return fileCreationTime;
    }

    public void setFileCreationTime(String fileCreationTime) {
        this.fileCreationTime = fileCreationTime;
    }

    public String getFileIdModifier() {
        return fileIdModifier;
    }

    public void setFileIdModifier(String fileIdModifier) {
        this.fileIdModifier = fileIdModifier;
    }

    public String getRecordSize() {
        return recordSize;
    }

    public void setRecordSize(String recordSize) {
        this.recordSize = recordSize;
    }

    public String getBlockingFactor() {
        return blockingFactor;
    }

    public void setBlockingFactor(String blockingFactor) {
        this.blockingFactor = blockingFactor;
    }

    public String getFormatCode() {
        return formatCode;
    }

    public void setFormatCode(String formatCode) {
        this.formatCode = formatCode;
    }

    public String getImmediateDestinationName() {
        return immediateDestinationName;
    }

    public void setImmediateDestinationName(String immediateDestinationName) {
        this.immediateDestinationName = immediateDestinationName;
    }

    public String getImmediateOriginName() {
        return immediateOriginName;
    }

    public void setImmediateOriginName(String immediateOriginName) {
        this.immediateOriginName = immediateOriginName;
    }

    public String getReferenceCode() {
        return referenceCode;
    }

    public void setReferenceCode(String referenceCode) {
        this.referenceCode = referenceCode;
    }

}
