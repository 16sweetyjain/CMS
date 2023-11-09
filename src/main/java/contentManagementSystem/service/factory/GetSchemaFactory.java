package contentManagementSystem.service.factory;

import contentManagementSystem.enums.SchemaEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
public class GetSchemaFactory {
    private Map<SchemaEnum, CrudSchemaInterface> strategiesMap;

    @Autowired
    public GetSchemaFactory(Set<CrudSchemaInterface> strategySet) {
        createStrategy(strategySet);
    }

    private void createStrategy(Set<CrudSchemaInterface> strategySet) {

        strategiesMap = new HashMap<>();
        strategySet.forEach(strategy -> strategiesMap.put(strategy.getStrategyName(), strategy));

    }

    public CrudSchemaInterface findStrategy(SchemaEnum strategyName) {
        return strategiesMap.get(strategyName);
    }

}
