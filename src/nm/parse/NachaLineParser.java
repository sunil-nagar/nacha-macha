package nm.parse;

import nm.model.NachaFileBatchFooter;
import nm.model.NachaFileBatchHeader;
import nm.model.NachaFileFooter;
import nm.model.NachaFileHeader;
import nm.model.NachaFileTransaction;

public class NachaLineParser {

    public static NachaFileLine parse(String line) {
        LineChomper lineChomper = new LineChomper(line);
        String type = lineChomper.chomp(1);
        switch (type) {
            case NachaFileLine.HEADER:
                return parseHeader(type, lineChomper);
            case NachaFileLine.BATCH_HEADER:
                return parseBatchHeader(type, lineChomper);
            case NachaFileLine.TRANSACTION:
                return parseTransaction(type, lineChomper);
            case NachaFileLine.BATCH_FOOTER:
                return parseBatchFooter(type, lineChomper);
            case NachaFileLine.FOOTER:
                return parseFooter(type, lineChomper);
            default:
                return new NachaFileLine();
        }
    }

    private static NachaFileLine parseHeader(String type, LineChomper lineChomper) {
        NachaFileHeader header = new NachaFileHeader();
        header.setRecordTypeCode(type);
        header.setPriorityCode(lineChomper.chomp(2));
        header.setImmediateDestination(lineChomper.chomp(10));
        header.setImmediateOrigin(lineChomper.chomp(10));
        header.setFileCreationDate(lineChomper.chomp(6));
        header.setFileCreationTime(lineChomper.chomp(4));
        header.setFileIdModifier(lineChomper.chomp(1));
        header.setRecordSize(lineChomper.chomp(3));
        header.setBlockingFactor(lineChomper.chomp(2));
        header.setFormatCode(lineChomper.chomp(1));
        header.setImmediateDestinationName(lineChomper.chomp(23));
        header.setImmediateOriginName(lineChomper.chomp(23));
        header.setReferenceCode(lineChomper.chomp(8));
        return header;
    }

    private static NachaFileLine parseBatchHeader(String type, LineChomper lineChomper) {
        NachaFileBatchHeader batchHeader = new NachaFileBatchHeader();
        batchHeader.setRecordTypeCode(type);
        batchHeader.setServiceClassCode(lineChomper.chomp(3));
        batchHeader.setCompanyName(lineChomper.chomp(16));
        batchHeader.setCompanyDiscretionaryData(lineChomper.chomp(20));
        batchHeader.setCompanyIdentification(lineChomper.chomp(10));
        batchHeader.setStandardEntryClassCode(lineChomper.chomp(3));
        batchHeader.setCompanyEntryDescription(lineChomper.chomp(10));
        batchHeader.setCompanyDescriptiveDate(lineChomper.chomp(6));
        batchHeader.setEffectiveEntryDate(lineChomper.chomp(6));
        batchHeader.setReserved(lineChomper.chomp(3));
        batchHeader.setOriginStatusCode(lineChomper.chomp(1));
        batchHeader.setOriginatingDFIId(lineChomper.chomp(8));
        batchHeader.setBatchNumber(lineChomper.chomp(7));
        return batchHeader;
    }

    private static NachaFileLine parseTransaction(String type, LineChomper lineChomper) {
        NachaFileTransaction transaction = new NachaFileTransaction();
        transaction.setRecordTypeCode(type);
        transaction.setTransactionCode(lineChomper.chomp(2));
        transaction.setReceivingDFIId(lineChomper.chomp(8));
        transaction.setCheckDigit(lineChomper.chomp(1));
        transaction.setDfiAccountNumber(lineChomper.chomp(17));
        transaction.setTransactionAmount(lineChomper.chomp(10));
        transaction.setIdentificationNumber(lineChomper.chomp(15));
        transaction.setReceivingCompanyName(lineChomper.chomp(22));
        transaction.setDiscretionaryData(lineChomper.chomp(2));
        transaction.setAddendaRecordIndicator(lineChomper.chomp(1));
        transaction.setTraceNumber(lineChomper.chomp(15));
        return transaction;
    }

    private static NachaFileLine parseBatchFooter(String type, LineChomper lineChomper) {
        NachaFileBatchFooter batchFooter = new NachaFileBatchFooter();
        batchFooter.setRecordTypeCode(type);
        batchFooter.setServiceClassCode(lineChomper.chomp(3));
        batchFooter.setEntryAddendaCount(lineChomper.chomp(6));
        batchFooter.setEntryHash(lineChomper.chomp(10));
        batchFooter.setTotalDebitEntry(lineChomper.chomp(12));
        batchFooter.setTotalCreditEntry(lineChomper.chomp(12));
        batchFooter.setCompanyIdentification(lineChomper.chomp(10));
        batchFooter.setMessageAuthenticationCode(lineChomper.chomp(19));
        batchFooter.setReserved(lineChomper.chomp(6));
        batchFooter.setOriginatingDFIId(lineChomper.chomp(8));
        batchFooter.setBatchNumber(lineChomper.chomp(7));
        return batchFooter;
    }

    private static NachaFileLine parseFooter(String type, LineChomper lineChomper) {
        NachaFileFooter footer = new NachaFileFooter();
        footer.setRecordTypeCode(type);
        footer.setBatchCount(lineChomper.chomp(6));
        footer.setBlockCount(lineChomper.chomp(6));
        footer.setEntryAddendaCount(lineChomper.chomp(8));
        footer.setEntryHash(lineChomper.chomp(10));
        footer.setTotalDebitEntry(lineChomper.chomp(12));
        footer.setTotalCreditEntry(lineChomper.chomp(12));
        footer.setReserved(lineChomper.chomp(39));
        return footer;
    }

}
