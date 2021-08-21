package com.learncamel.routes;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.apache.camel.builder.ProcessorBuilder.setBody;

@Component
public class MailRouteBuilder extends RouteBuilder {


    @Override
    public void configure() throws Exception {

      /*  from("file:C:/Users/prasa/mail?noop=true").doTry().setHeader("contentType", simple("text/html"
        ))
                .setHeader("subject", simple("testMy"))
                .setHeader("to", simple("prasaddusane1980@gmail.com"))
                .to("smtps://smtp.gmail.com:465?username=prasaddusane1980@gmail.com&password=pRASAD@1980");*/



        from("file:C:/Users/prasa/mail?fileName=bunder.txt&noop=true")
                     .routeId("sendReportEmailRoute")
                      .setProperty("originalBody", body())
                .process(new Processor() {

                    @Override
                    public void process(Exchange exchange) throws Exception {
                        Message in = exchange.getIn();
                      //  in.setHeader("contentType", "text/html");
                        byte[] bFile = Files.readAllBytes(Paths.get("C:\\Users\\prasa\\mail\\bunder.txt"));
                            String fileId = "test.xls";
                        in.addAttachment(fileId, new DataHandler(bFile,"plain/text"));
                        in.setBody("test attachments");

                    }

                })
                .setHeader("subject", simple("Motapanda"))
                .setHeader("to", simple("psd2980@gmail.com"))
                .to("smtps://smtp.gmail.com:465?username=psd2980@gmail.com&password=Prasad@1980");



    }


}
