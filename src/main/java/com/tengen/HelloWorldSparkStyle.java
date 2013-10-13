package com.tengen;


import spark.Response;
import spark.Request;
import spark.Route;
import spark.Spark;



/**
 * Created with IntelliJ IDEA.
 * User: lucian
 * Date: 10/13/13
 * Time: 9:27 PM
 * To change this template use File | Settings | File Templates.
 */
public class HelloWorldSparkStyle {

    public static void main(String[] args){

        Spark.get(new Route("/") {
            @Override
            public Object handle(Request request, Response response) {
                return "hello world from spark !";
            }
        });
    }
}
