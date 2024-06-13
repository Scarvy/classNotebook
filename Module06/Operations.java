package Module06;

public enum Operations {
    EQUALS("=="), CONTAINS("~=");

    private final String operator;

    Operations(String value) {
        this.operator = value;
    }

    public String getOperator() {
        return operator;
    }

    public static Operations getOperatorFromStr(String str) {
        if (str.contains("=="))
            return EQUALS;
        else if (str.contains("~="))
            return CONTAINS;
        else
            return null;
    }

}
