package test.task.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.task.dao.ValuesDao;
import test.task.model.Values;
import test.task.service.ValuesService;

@Service
public class ValuesServiceImpl implements ValuesService {
    private final ValuesDao valuesDao;

    @Autowired
    public ValuesServiceImpl(ValuesDao valuesDao) {
        this.valuesDao = valuesDao;
    }

    @Override
    public void add(Values values) {
        valuesDao.add(values);
    }
}
