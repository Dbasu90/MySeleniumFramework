package com.deb.listeners;

import com.deb.constants.FrameworkConstants;
import com.deb.utils.ExcelReaderUtil;
import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MethodInterceptor implements IMethodInterceptor {
    @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> list, ITestContext iTestContext) {

        List<Map<String, String>> executionData = ExcelReaderUtil.getTestData(FrameworkConstants.getExecutionSheet());
        List<IMethodInstance> result = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < executionData.size(); j++) {

                if (list.get(i).getMethod().getMethodName().equals(executionData.get(j).get("testcasename")) &&
                        executionData.get(j).get("execute").equalsIgnoreCase("yes")) {
                    list.get(i).getMethod().setDescription(executionData.get(j).get("description"));
                    list.get(i).getMethod().setInvocationCount(Integer.parseInt(executionData.get(j).get("count")));
                    result.add(list.get(i));
                }
            }
        }

        return result;
    }
}
