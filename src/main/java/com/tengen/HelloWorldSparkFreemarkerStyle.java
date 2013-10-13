package com.tengen;

import freemarker.template.Configuration;
import freemarker.template.Template;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: lucian
 * Date: 10/13/13
 * Time: 11:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class HelloWorldSparkFreemarkerStyle {

    public static void main(String[] args) {

        final Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(HelloWorldFreemarkerStyle.class, "/");

        Spark.get(new Route("/") {
            @Override
            public Object handle(Request request, Response response) {
                Template helloTemplate = null;
                StringWriter writer = new StringWriter();

                try {
                    helloTemplate = configuration.getTemplate("hello.ftl");


                    Map<String, Object> helloMap = new HashMap<String, Object>();
                    helloMap.put("name", "Freemarker");

                    helloTemplate.process(helloMap, writer);
                    System.out.println(writer);
                } catch (Exception e) {
                    halt(500);
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }

                return writer;

            }
        });
    }
}
