package nm.parse;

public class NachaFileLine {

    public static final String HEADER = "1";
    public static final String BATCH_HEADER = "5";
    public static final String TRANSACTION = "6";
    public static final String BATCH_FOOTER = "8";
    public static final String FOOTER = "9";

    private String type;

    public NachaFileLine() {

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "NachaFileLine [type=" + type + "]";
    }

}
