package contentManagementSystem.service.factory;

import contentManagementSystem.dal.helpX.HelpXCustomRepositoryImpl;
import contentManagementSystem.exception.BadRequestException;
import contentManagementSystem.exception.InternalServerError;
import contentManagementSystem.model.HelpX;
import contentManagementSystem.model.request.*;
import contentManagementSystem.model.request.createRequest.CreateHelpXSchemaRequest;
import contentManagementSystem.model.request.getRequest.GetSchemaRequest;
import contentManagementSystem.model.request.updateRequest.UpdateHelpXSchemaRequest;
import contentManagementSystem.model.response.*;
import contentManagementSystem.enums.SchemaEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class HelpXCrudFactory implements CrudInterface<BaseRequest, BaseResponse> {

    @Autowired
    HelpXCustomRepositoryImpl helpXCustomRepository;


    @Override
    public SchemaEnum getStrategyName() {
        return SchemaEnum.HELPXSCHEMA;
    }

    @Override
    public BaseResponse getSchema(BaseRequest baseRequest) throws InternalServerError, BadRequestException {

        GetSchemaRequest request = (GetSchemaRequest) baseRequest;

        if(request.getSchemaId() ==  null || request.getSchemaId().isEmpty()) {
            throw new BadRequestException("HelpX id is missing", HttpStatus.BAD_REQUEST.value(), request.getRequestId());
        }

        HelpX helpX  = null;

        try {
            helpX = helpXCustomRepository.getHelpXArticle(request.getSchemaId());
        }catch(Exception e) {
            throw new InternalServerError("Error while getting helpX", HttpStatus.INTERNAL_SERVER_ERROR.value(), request.getRequestId());

        }

        GetSchemaResponse response = new GetSchemaResponse();

        response.setSchema(helpX);

        return response;
    }

    @Override
    public BaseResponse createSchema(BaseRequest baseRequest) throws InternalServerError, BadRequestException {
        String helpXId = UUID.randomUUID().toString();
        CreateHelpXSchemaRequest request = (CreateHelpXSchemaRequest) baseRequest;

        if(request.getTitle() ==  null || request.getTitle().isEmpty()) {
            throw new BadRequestException("HelpX title is missing", HttpStatus.BAD_REQUEST.value(), request.getRequestId());
        }

        HelpX helpX = new HelpX(helpXId, request.getTitle(), request.getSubTitle(), request.getDescription(), request.getImage(), request.getParagraph(), request.getUserId());

        try{
            helpXCustomRepository.addHelpXArticle(helpX);

        }catch(Exception e) {
            throw new InternalServerError("Error while adding helpX", HttpStatus.INTERNAL_SERVER_ERROR.value(), request.getRequestId());

        }

        CreateSchemaResponse response = new CreateSchemaResponse();

        response.setSchemaId(helpXId);

        return response;
    }

    @Override
    public BaseResponse updateSchema(BaseRequest baseRequest) throws InternalServerError, BadRequestException {
        UpdateHelpXSchemaRequest request = (UpdateHelpXSchemaRequest) baseRequest;
        HelpX updatedHelpX = null;

        if(request.getSchemaId() ==  null || request.getSchemaId().isEmpty()) {
            throw new BadRequestException("HelpX id is missing", HttpStatus.BAD_REQUEST.value(), request.getRequestId());
        }
        try{

            HelpX helpX = new HelpX(request.getSchemaId(), request.getTitle(), request.getSubTitle(), request.getDescription(), request.getImage(), request.getParagraph(), request.getUserId());
            String helpXId = request.getSchemaId();

            updatedHelpX = helpXCustomRepository.updateHelpXArticle(helpX, helpXId);

        }catch(Exception e) {
            throw new InternalServerError("Error while updating helpX", HttpStatus.INTERNAL_SERVER_ERROR.value(), request.getRequestId());

        }

        UpdateSchemaResponse response = new UpdateSchemaResponse();

        response.setSchema(updatedHelpX);

        return response;

    }

    @Override
    public BaseResponse getAllSchema(BaseRequest baseRequest) throws InternalServerError {
        List<HelpX> helpXList = new ArrayList<>();
        try {
            helpXList = helpXCustomRepository.getAllHelpXArticle();
        }catch (Exception e) {
            throw new InternalServerError("Error while getting helpX list", HttpStatus.INTERNAL_SERVER_ERROR.value(), baseRequest.getRequestId());

        }
        GetAllSchemaResponse getAllSchemaResponse = new GetAllSchemaResponse();
        getAllSchemaResponse.setSchemaList(helpXList);
        return getAllSchemaResponse;
    }
}
