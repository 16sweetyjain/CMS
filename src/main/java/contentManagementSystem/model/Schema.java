package contentManagementSystem.model;

public class Schema {
    String schemaId;

    public Schema(String schemaId) {
        this.schemaId = schemaId;
    }

    public String getSchemaId() {
        return schemaId;
    }

    public void setSchemaId(String schemaId) {
        this.schemaId = schemaId;
    }

    @Override
    public String toString() {
        return "Schema{" +
                "schemaId='" + schemaId + '\'' +
                '}';
    }
}
