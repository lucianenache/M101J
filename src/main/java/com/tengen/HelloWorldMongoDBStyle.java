package com.tengen;

import com.mongodb.*;

import java.net.UnknownHostException;

/**
 * Created with IntelliJ IDEA.
 * User: lucian
 * Date: 10/11/13
 * Time: 12:30 AM
 * To change this template use File | Settings | File Templates.
 */
public class HelloWorldMongoDBStyle {
    public static void mainDB(String[] args) throws UnknownHostException {

        MongoClient client= new MongoClient(new ServerAddress("localhost", 27017));

        DB database = client.getDB("local");
        DBCollection collection = database.getCollection("startup_log");

        DBObject document = collection.findOne();
        System.out.println(document);
    }

}
