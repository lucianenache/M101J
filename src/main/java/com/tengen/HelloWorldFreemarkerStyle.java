package com.tengen;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: lucian
 * Date: 10/13/13
 * Time: 11:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class HelloWorldFreemarkerStyle {
    public static void main(String[] args){

        Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(HelloWorldFreemarkerStyle.class,"/");

        try {
            Template helloTemplate = configuration.getTemplate("hello.ftl");
            StringWriter writer = new StringWriter();
            Map<String,Object> helloMap  = new HashMap<>();
            helloMap.put("name","Freemarker");

            helloTemplate.process(helloMap,writer);
            System.out.println(writer);

        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
