package contentManagementSystem.enums;

public enum SchemaEnum {

        FAQSCHEMA(SchemaConstants.FAQ),
        HELPXSCHEMA(SchemaConstants.HELPX);

        private String requestStrategy;

    SchemaEnum(String requestStrategy) {
            this.requestStrategy = requestStrategy;
        }


        public static SchemaEnum getStrategyEnum(String requestStrategy) {
            SchemaEnum[] enums = SchemaEnum.values();
            for (SchemaEnum searchEnum : enums) {
                if (searchEnum.requestStrategy.equalsIgnoreCase(requestStrategy)) {
                    return searchEnum;
                }
            }
            return null;
        }


        @Override
        public String toString() {
            return super.toString();
        }
}
