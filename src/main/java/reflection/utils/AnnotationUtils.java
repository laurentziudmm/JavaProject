package reflection.utils;

import reflectionTwo.api.annotation.Column;
import reflectionTwo.api.annotation.Table;
import reflection.domain.Location1;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class AnnotationUtils {

    public static Table getEntityTable(Object entity){

        return entity.getClass().getDeclaredAnnotation(Table.class);
    }


    public static List<Map<String,String>> getFieldsAnnotations(Object entity){
        Field[] fields=entity.getClass().getDeclaredFields();
        List<Map<String,String>> ret=new ArrayList<>();
        for (Field field : fields) {
            Column col=field.getDeclaredAnnotation(Column.class);
            if(col!=null){
                Map<String,String> property=new HashMap<>();
                property.put("fieldName",field.getName());
                property.put("columnName",col.name());
                ret.add(property);

            }


        }

        return ret;

    }


    public static void main(String[] args) {
        Location1 location1 = new Location1();
        location1.setId(1L);
        location1.setName("Nume test1");
        location1.setOtherProperty1("Prop test 1");

        Table table=getEntityTable(location1);
        System.out.println("Table name: "+table.name());

        List<Map<String,String>> columnsInfo=getFieldsAnnotations(location1);
        System.out.println(columnsInfo);

    }

}
