package contentManagementSystem.service.selectSchema;


import contentManagementSystem.dal.FaqCustomRepositoryImpl;
import contentManagementSystem.model.Faq;
import contentManagementSystem.model.request.BaseRequest;
import contentManagementSystem.model.request.CreateFaqSchemaRequest;
import contentManagementSystem.model.request.GetSchemaRequest;
import contentManagementSystem.model.request.UpdateSchemaRequest;
import contentManagementSystem.model.response.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class FaqCrudSchemaFactory implements CrudSchemaInterface<BaseRequest, BaseResponse>{

    @Autowired
    private FaqCustomRepositoryImpl faqCustomRepository;


    public FaqCrudSchemaFactory() {
    }


    @Override
    public BaseResponse getSchema(BaseRequest baseRequest) {
        GetSchemaRequest request = (GetSchemaRequest) baseRequest;

        Faq faq = null;

        try {
             faq = faqCustomRepository.getFaq(request.getSchemaId());
        }catch(Exception e) {
            e.printStackTrace();
        }

        GetSchemaResponse response = new GetSchemaResponse();

        response.setSchema(faq);

        return response;
    }

    @Override
    public BaseResponse createSchema(BaseRequest baseRequest) {
        String faqId = UUID.randomUUID().toString();
        CreateFaqSchemaRequest request = (CreateFaqSchemaRequest) baseRequest;
        Faq faq = new Faq(faqId, request.getTitle(), request.getDescription());

        try{
            faqCustomRepository.addFaq(faq);

        }catch(Exception e) {
            e.printStackTrace();
        }


        CreateSchemaResponse response = new CreateSchemaResponse();

        response.setSchemaId(faqId);

        return response;
    }


    @Override
    public BaseResponse updateSchema(BaseRequest baseRequest) {
        UpdateSchemaRequest request = (UpdateSchemaRequest) baseRequest;
        Faq updatedFaq = null;
        try{
            Faq faq = (Faq) request.getSchema();


            updatedFaq = faqCustomRepository.updateFaq(faq);

        }catch(Exception e) {
            e.printStackTrace();
        }

        UpdateSchemaResponse response = new UpdateSchemaResponse();

        response.setSchema(updatedFaq);

        return response;

    }

    @Override
    public BaseResponse getAllSchema(BaseRequest baseRequest) {
        List<Faq> faqList = new ArrayList<>();
        try {
             faqList = faqCustomRepository.getAllFaq();
        }catch (Exception e) {
            e.printStackTrace();
        }
        GetAllSchemaResponse getAllSchemaResponse = new GetAllSchemaResponse();
        getAllSchemaResponse.setSchemaList(faqList);
        return getAllSchemaResponse;
    }


}
