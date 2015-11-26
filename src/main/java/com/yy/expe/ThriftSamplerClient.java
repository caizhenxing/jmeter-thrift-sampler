package com.yy.expe;

import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;
import org.apache.jorphan.logging.LoggingManager;
import org.apache.log.Logger;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

import java.util.ArrayList;
import java.util.Map;

public class ThriftSamplerClient extends AbstractJavaSamplerClient {

    private static final Logger log = LoggingManager.getLoggerForClass();
    private TTransport transport = null;
    private TProtocol protocol = null;
    private String tableName = null;


    @Override
    public Arguments getDefaultParameters() {
        Arguments defaultParameters = new Arguments();
        defaultParameters.addArgument("Thrift�����ַ", "");
        defaultParameters.addArgument("Thrift����˿�", "");
        defaultParameters.addArgument("ThriftЭ������", "");
        return defaultParameters;
    }

    @Override
    public void setupTest(JavaSamplerContext context) {
        String host = context.getParameter("Thrift�����ַ");
        String port = context.getParameter("Thrift����˿�");

        tableName = context.getParameter("tablename");
        transport = new TSocket(host, Integer.parseInt(port));
        protocol = new TBinaryProtocol(transport, true, true);
        try {
            transport.open();
        } catch (TTransportException e) {
            e.printStackTrace();
        }

    }


    public SampleResult runTest(JavaSamplerContext context) {
        SampleResult result = new SampleResult();
        boolean success = true;
        result.sampleStart();

        String col1 = context.getParameter("table-col1");
        String col2 = context.getParameter("table-col2");
        String col3 = context.getParameter("table-col3");
        String col4 = context.getParameter("table-col4");
        String col5 = context.getParameter("table-col5");
        String col6 = context.getParameter("table-col6");
        String col7 = context.getParameter("table-col7");


        ArrayList mutations = new ArrayList();
        Map attributes = null;
        result.sampleEnd();
        result.setSuccessful(success);
        return result;
    }

    @Override
    public void teardownTest(JavaSamplerContext context) {
        super.teardownTest(context);
        transport.close();
    }
}