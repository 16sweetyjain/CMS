package contentManagementSystem.service.factory;


import contentManagementSystem.dal.faq.FaqCustomRepositoryImpl;
import contentManagementSystem.exception.BadRequestException;
import contentManagementSystem.exception.InternalServerError;
import contentManagementSystem.model.Faq;
import contentManagementSystem.model.request.BaseRequest;
import contentManagementSystem.model.request.createRequest.CreateFaqSchemaRequest;
import contentManagementSystem.model.request.getRequest.GetSchemaRequest;
import contentManagementSystem.model.request.updateRequest.UpdateFaqSchemaRequest;
import contentManagementSystem.model.response.*;
import contentManagementSystem.enums.SchemaEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class FaqCrudFactory implements CrudInterface<BaseRequest, BaseResponse> {

    @Autowired
    private FaqCustomRepositoryImpl faqCustomRepository;


    public FaqCrudFactory() {
    }

    public FaqCrudFactory(String faq) {
    }


    @Override
    public BaseResponse getSchema(BaseRequest baseRequest) throws InternalServerError, BadRequestException {
        GetSchemaRequest request = (GetSchemaRequest) baseRequest;

        if(request.getSchemaId() ==  null || request.getSchemaId().isEmpty()) {
            throw new BadRequestException("Faq id is missing", HttpStatus.BAD_REQUEST.value(), request.getRequestId());
        }

        Faq faq = new Faq();

        try {
             faq = faqCustomRepository.getFaq(request.getSchemaId());

        }catch(Exception e) {
            throw new InternalServerError("Error while getting faq", HttpStatus.INTERNAL_SERVER_ERROR.value(), request.getRequestId());
        }

        GetSchemaResponse response = new GetSchemaResponse();

        response.setSchema(faq);

        return response;
    }

    @Override
    public BaseResponse createSchema(BaseRequest baseRequest) throws InternalServerError, BadRequestException {
        String faqId = UUID.randomUUID().toString();
        CreateFaqSchemaRequest request = (CreateFaqSchemaRequest) baseRequest;

        if(request.getTitle() ==  null || request.getTitle().isEmpty()) {
            throw new BadRequestException("Faq title is missing", HttpStatus.BAD_REQUEST.value(), request.getRequestId());
        }

        Faq faq = new Faq(faqId, request.getTitle(), request.getDescription(), request.getUserId());

        try{
            faqCustomRepository.addFaq(faq);

        } catch(Exception e) {
            throw new InternalServerError("Error while adding faq", HttpStatus.INTERNAL_SERVER_ERROR.value(), request.getRequestId());
        }

        CreateSchemaResponse response = new CreateSchemaResponse();

        response.setSchemaId(faqId);

        return response;
    }


    @Override
    public BaseResponse updateSchema(BaseRequest baseRequest) throws InternalServerError {
        UpdateFaqSchemaRequest request = (UpdateFaqSchemaRequest) baseRequest;
        Faq updatedFaq = null;
        try{

            Faq faq = new Faq(request.getSchemaId(), request.getTitle(), request.getDescription(), request.getUserId());
            String faqId = request.getSchemaId();

            if(faqId ==  null || faqId.isEmpty()) {
                throw new BadRequestException("Faq id is missing", HttpStatus.BAD_REQUEST.value(), request.getRequestId());
            }

            updatedFaq = faqCustomRepository.updateFaq(faq, faqId);

        }catch(Exception e) {
            throw new InternalServerError("Error while updating faq", HttpStatus.INTERNAL_SERVER_ERROR.value(), request.getRequestId());

        }

        UpdateSchemaResponse response = new UpdateSchemaResponse();

        response.setSchema(updatedFaq);

        return response;

    }

    @Override
    public BaseResponse getAllSchema(BaseRequest baseRequest) throws InternalServerError {
        List<Faq> faqList = new ArrayList<>();
        try {
             faqList = faqCustomRepository.getAllFaq();
        }catch (Exception e) {
            throw new InternalServerError("Error while getting faq list", HttpStatus.INTERNAL_SERVER_ERROR.value(), baseRequest.getRequestId());
        }
        GetAllSchemaResponse getAllSchemaResponse = new GetAllSchemaResponse();
        getAllSchemaResponse.setSchemaList(faqList);


        return getAllSchemaResponse;
    }

    @Override
    public SchemaEnum getStrategyName() {
        return SchemaEnum.FAQSCHEMA;
    }


}
