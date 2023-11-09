package contentManagementSystem.service.factory;

import contentManagementSystem.dal.HelpXCustomRepositoryImpl;
import contentManagementSystem.model.HelpX;
import contentManagementSystem.model.request.*;
import contentManagementSystem.model.response.*;
import contentManagementSystem.enums.SchemaEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class HelpXCrudSchemaFactory implements CrudSchemaInterface<BaseRequest, BaseResponse> {

    @Autowired
    HelpXCustomRepositoryImpl helpXCustomRepository;


    @Override
    public SchemaEnum getStrategyName() {
        return SchemaEnum.HELPXSCHEMA;
    }

    @Override
    public BaseResponse getSchema(BaseRequest baseRequest) {

        GetSchemaRequest request = (GetSchemaRequest) baseRequest;

        HelpX helpX  = null;

        try {
            helpX = helpXCustomRepository.getHelpXArticle(request.getSchemaId());
        }catch(Exception e) {
            e.printStackTrace();
        }

        GetSchemaResponse response = new GetSchemaResponse();

        response.setSchema(helpX);

        return response;
    }

    @Override
    public BaseResponse createSchema(BaseRequest baseRequest) {
        String helpXId = UUID.randomUUID().toString();
        CreateHelpXSchemaRequest request = (CreateHelpXSchemaRequest) baseRequest;

            HelpX helpX = new HelpX(helpXId, request.getTitle(), request.getSubTitle(), request.getDescription(), request.getImage(), request.getParagraph());

        try{
            helpXCustomRepository.addHelpXArticle(helpX);

        }catch(Exception e) {
            e.printStackTrace();
        }


        CreateSchemaResponse response = new CreateSchemaResponse();

        response.setSchemaId(helpXId);

        return response;
    }

    @Override
    public BaseResponse updateSchema(BaseRequest baseRequest) {
        UpdateSchemaRequest request = (UpdateSchemaRequest) baseRequest;
        HelpX updatedHelpX = null;
        try{
            HelpX helpX = (HelpX) request.getSchema();


            updatedHelpX = helpXCustomRepository.updateHelpXArticle(helpX);

        }catch(Exception e) {
            e.printStackTrace();
        }

        UpdateSchemaResponse response = new UpdateSchemaResponse();

        response.setSchema(updatedHelpX);

        return response;

    }

    @Override
    public BaseResponse getAllSchema(BaseRequest baseRequest) {
        List<HelpX> helpXList = new ArrayList<>();
        try {
            helpXList = helpXCustomRepository.getAllHelpXArticle();
        }catch (Exception e) {
            e.printStackTrace();
        }
        GetAllSchemaResponse getAllSchemaResponse = new GetAllSchemaResponse();
        getAllSchemaResponse.setSchemaList(helpXList);
        return getAllSchemaResponse;
    }
}
