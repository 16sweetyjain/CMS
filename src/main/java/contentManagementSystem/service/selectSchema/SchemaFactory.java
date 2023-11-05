package contentManagementSystem.service.selectSchema;

import contentManagementSystem.schemaEnum.SchemaEnum;

public class SchemaFactory {

    public CrudSchemaInterface createSchemaFactory(String selectedSchema) {
        switch(selectedSchema) {
            case SchemaEnum.FAQ:
                return new FaqCrudSchemaFactory();
            case SchemaEnum.HELPX:
                return new HelpXCrudSchemaFactory();
            default:
                throw new IllegalArgumentException("Selected schema does not exist");

        }
    }
}
