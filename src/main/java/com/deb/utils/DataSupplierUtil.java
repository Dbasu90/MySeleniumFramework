package com.deb.utils;

import com.deb.testdataPojo.TestData;
import io.github.sskorol.core.DataSupplier;
import io.github.sskorol.data.XlsxReader;
import one.util.streamex.StreamEx;

import java.lang.reflect.Method;

import static io.github.sskorol.data.TestDataReader.use;

public class DataSupplierUtil {

    @DataSupplier(runInParallel = true)
    public StreamEx<TestData> getTestData(Method method) {
        return use(XlsxReader.class)
                .withTarget(TestData.class)
                .read()
                .filter(testdata -> testdata.isExecute == true)
                .filter(testData -> testData.testcaseName.equalsIgnoreCase(method.getName()));

    }

}
