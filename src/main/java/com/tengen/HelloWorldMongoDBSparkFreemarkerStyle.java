package com.tengen;

import com.mongodb.*;
import freemarker.template.Configuration;
import freemarker.template.Template;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

import java.io.StringWriter;

/**
 * Created with IntelliJ IDEA.
 * User: lucian
 * Date: 10/13/13
 * Time: 11:36 PM
 * To change this template use File | Settings | File Templates.
 */
public class HelloWorldMongoDBSparkFreemarkerStyle {

    public static void main(String[] args) {

        final Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(HelloWorldFreemarkerStyle.class, "/");

        Spark.get(new Route("/") {
            @Override
            public Object handle(Request request, Response response) {
                Template helloTemplate;
                StringWriter writer = new StringWriter();
                MongoClient client;


                try {
                    helloTemplate = configuration.getTemplate("hello.ftl");

                    client = new MongoClient(new ServerAddress("localhost", 27017));
                    DB database = client.getDB("course");
                    DBCollection collection = database.getCollection("hello");
                    DBObject document = collection.findOne();

                    //System.out.println(document);

                    helloTemplate.process(document, writer);

                    System.out.println(document);
                } catch (Exception e) {
                    halt(500);
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }

                return writer;

            }
        });
    }
}

