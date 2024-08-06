package utilities;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBUtility {



    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;

    public static void createConnection() throws SQLException {



        switch (ConfigurationReader.getProperty("dbType")){

            case "PostgreSQL":
                //create connection for mySql

              /*  connection= DriverManager.getConnection(ConfigurationReader.getProperty("URL"),
                        ConfigurationReader.getProperty("Username"),
                        ConfigurationReader.getProperty("Password"));

               */

                break;
            case "mysql":
                //create connection for mySql


            default:
                connection=null;

        }
    }

    public static List<Map<Object, Object>> executeQuery (String query) throws SQLException {

        statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        resultSet = statement.executeQuery(query);

        ResultSetMetaData metaData = resultSet.getMetaData();


        int numberOfColumns = metaData.getColumnCount();




        List<Map<Object, Object>> data = new ArrayList<>();

        while(resultSet.next()){




            Map<Object, Object> map = new HashMap<>();


            for(int i = 1; i <= numberOfColumns; i++ ){
                map.put(metaData.getColumnName(i), resultSet.getObject(i));
            }
            data.add(map);
        }
        return data;


    }
    public static void close() throws SQLException {
        connection.close();
        statement.close();
        resultSet.close();
    }

}
