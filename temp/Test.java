package temp;

public class Test {

    public static void validate(NachaFileHeader header) {
        System.out.println(header.getRecordTypeCode() + " " + header.getRecordTypeCode().length());
        System.out.println(header.getPriorityCode() + " " + header.getPriorityCode().length());
        System.out.println(header.getImmediateDestination() + " " + header.getImmediateDestination().length());
        System.out.println(header.getImmediateOrigin() + " " + header.getImmediateOrigin().length());
        System.out.println(header.getFileCreationDate() + " " + header.getFileCreationDate().length());
        System.out.println(header.getFileCreationTime() + " " + header.getFileCreationTime().length());
        System.out.println(header.getFileIdModifier() + " " + header.getFileIdModifier().length());
        System.out.println(header.getRecordSize() + " " + header.getRecordSize().length());
        System.out.println(header.getBlockingFactor() + " " + header.getBlockingFactor().length());
        System.out.println(header.getFormatCode() + " " + header.getFormatCode().length());
        System.out.println(header.getImmediateDestinationName() + " " + header.getImmediateDestinationName().length());
        System.out.println(header.getImmediateOriginName() + " " + header.getImmediateOriginName().length());
        System.out.println(header.getReferenceCode() + " " + header.getReferenceCode().length());

    }

    public static void main(String[] args) {
        for (int i = 0; i < 26; i++) {
            NachaFileHeader header = new NachaFileHeader(i);
            System.out.println(header.toString() + "    " + header.toString().length());
            // validate(header);
            NachaFileFooter footer = new NachaFileFooter();
            System.out.println(footer.toString() + "    " + footer.toString().length());

            NachaFileBatchHeader batchHeader = new NachaFileBatchHeader();
            System.out.println(batchHeader.toString() + "    " + batchHeader.toString().length());

            NachaFileBatchFooter batchFooter = new NachaFileBatchFooter();
            System.out.println(batchFooter.toString() + "    " + batchFooter.toString().length());

        }
    }

}
