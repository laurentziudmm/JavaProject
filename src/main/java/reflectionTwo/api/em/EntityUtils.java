package reflectionTwo.api.em;

import reflectionTwo.api.annotation.Column;
import reflectionTwo.api.annotation.Id;
import reflectionTwo.api.annotation.Table;
import reflectionTwo.appl.domain.Location;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class EntityUtils {
    private EntityUtils() {
        throw new UnsupportedOperationException();
    }



    //new
    public static QueryBuilder getQueryBuilder(Class<?> entityClass){
        QueryBuilder ret=new QueryBuilder();
        ret.setTableName(getTableName(entityClass));
        ret.addQueryColumns(getColumns(entityClass));
        return ret;
    }

    public static String getTableName(Class<?> entityClass){
        Table table= entityClass.getDeclaredAnnotation(Table.class);
        if(table==null){
            throw new NoEntityException(entityClass);
        }
        return table.name();

    }

    public static List<ColumnInfo> getColumns(Class<?> entityClass, Object...instance){
        List<ColumnInfo> ret=new ArrayList<>();
        Field[] fields = entityClass.getDeclaredFields();
//        Object inst=instance!=null&&instance.length==1?instance[0]:null;
        for (Field field : fields) {
            field.setAccessible(true);


            Column columnAnnotation=field.getDeclaredAnnotation(Column.class);
            Id columnId=field.getDeclaredAnnotation(Id.class);
            if(columnAnnotation!=null){
                ColumnInfo columnInfo=new ColumnInfo();
                columnInfo.setColumnType(field.getType());
                columnInfo.setColumnName(field.getName());
                columnInfo.setDbColumnName(columnAnnotation.name());
                columnInfo.setId(columnId!=null);
                ret.add(columnInfo);

            }



        }
        return ret;
    }

    //new
    public static ColumnInfo getPkColumn(Class<?> entityClass){
        List<ColumnInfo> allColumns=getColumns(entityClass);
        for (ColumnInfo column : allColumns) {
            if(column.isId()){
                return column;
            }
        }
        throw new NoEntityIdException(entityClass);
    }


    public static List<Field> getFieldsByAnnotation(Class<?> entityClass, Class annotation){
        List<Field> ret=new ArrayList<>();
        Field[] fields=entityClass.getDeclaredFields();
        for (Field field : fields) {
            Annotation[] annotations=field.getDeclaredAnnotations();
            for (Annotation annotation1 : annotations) {
                if(annotation.equals(annotation1.annotationType())){
                    ret.add(field);
                    break;
                }
            }
        }
        return ret;
    }

    public static Object getPkValue(Object object) throws IllegalAccessException {
        if (object == null)
            return null;

        if (object.getClass().getAnnotation(Table.class) != null) {
            Field idField = getFieldsByAnnotation(object.getClass(), Id.class).get(0);
            idField.setAccessible(true);
            return idField.get(object);
        } else {
            return object;
        }
    }

    public static Object castFromSqlType(Object value, Class wantedType){
        if(value==null){
            return null;
        }
        if(value instanceof BigDecimal){
            if(wantedType.equals(Integer.class)){
                return ((BigDecimal) value).intValue();
            }else if(wantedType.equals(Long.class)){
                return ((BigDecimal) value).longValue();
            }else{
                return value;
            }
        }else{
            return value;
        }

    }






    public static void main(String[] args) {
        List<Field> fields=getFieldsByAnnotation(Location.class,Column.class);
        System.out.println(fields);

    }

}
