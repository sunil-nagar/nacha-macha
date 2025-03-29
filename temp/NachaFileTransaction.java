package temp;

public class NachaFileTransaction {
    
    // 1-1	1	Record Type Code	6	Constant
    private String recordTypeCode = "6";

    // 2-3	2	Transaction Code	22, 32, 27, 37
    private String transactionCode;

    // 4-11	8	Receiving DFI ID	Numeric	
    // First 8 digits of the other party's ABA routing number
    private String receivingDFIId;

    // 12-12	1	Check Digit	Numeric	Last digit of the other party's ABA routing number
    private String checkDigit;

    // 13-29	17	DFI Account Number	Alphanumeric	Other party's account number.
    // Note: This is an alphanumeric field and should be left justified.
    
    // 30-39	10	Amount	Numeric	
    // Transaction amount. No decimal.
    
    // 40-54	15	Identification Number	Alphanumeric	Optional. Helps the receiver (other party) identify themselves within your system, should they need to contact you. Typically their account number.
    // PRINTED - This value may appear on the other party's bank statement
    
    // 55-76	22	Receiving Company Name	Alphanumeric	
    // The other party's company name (in CCD) - or if a consumer transaction (in PPC) such as payroll, the individual's name.
    
    // 77-78	2	Discretionary Data	Alphanumeric	Typically blank, unless instructed otherwise by your bank.
    
    // 79-79	1	Addenda Record Indicator	0 or 1	0 - No addenda following
    // 1 - Addenda following
    
    // 80-94	15	Trace Number	Numeric	The first 8 digits of your Originating DFI number, followed by the entry detail sequence number,
    
}
