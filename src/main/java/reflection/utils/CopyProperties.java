package reflection.utils;

import reflection.domain.Location1;
import reflection.domain.Location2;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CopyProperties {
    public static <T>T copy(Object src, Class<T> to) {
        T ret = null;

        //instantiate
        try {
            ret = to.newInstance();

            //getting source class
            Class<?> aClass = src.getClass();

            //getting all fields from source(private, default, protected and public fields on the current class)
            Field[] fields = aClass.getDeclaredFields();

            //getting all fields from dest
            Field[] fieldsDest = to.getDeclaredFields();
            for (Field field : fields) {

                String fieldName = field.getName();
                try {
                    Field destField = to.getDeclaredField(fieldName);
                    field.setAccessible(true);
                    Object val = field.get(src);

                    destField.setAccessible(true);
                    destField.set(ret, val);

                } catch (NoSuchFieldException e1) {
                    continue;
                }
                //field name matching
//                for (Field fieldDest : fieldsDest) {
//                    if(fieldDest.getName().equals(fieldName)){
//                        //if we have a matching then we copy property
//
//
//                        //source value
//                        field.setAccessible(true);
//                        Object val=field.get(src);
//
//                        fieldDest.setAccessible(true);
//                        fieldDest.set(ret,val);
//
//                    }
//                }

            }


        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
            return ret;
        }

    public static <T>T copy2(Object src, Class<T> to) {
        T ret = null;

        try {
            ret = to.newInstance();

            //getting source class
            Class<?> aClass = src.getClass();

            //getting all fields from source(private, default, protected and public fields on the current class)
            Field[] fields = aClass.getDeclaredFields();

            for (Field field : fields) {
                String srcFieldName = field.getName();
                String shortMethodName = srcFieldName.substring(0, 1).toUpperCase() + srcFieldName.substring(1);
                String getter = "get" + shortMethodName;
                String setter = "set" + shortMethodName;

                try {
                    Method getterMethod = aClass.getMethod(getter);
                    Method setterMethod = to.getMethod(setter, field.getType());
                    Object val = getterMethod.invoke(src);
                    setterMethod.invoke(ret, val);
                }catch (NoSuchMethodException e) {
                    //e.printStackTrace();
                }


            }

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }  catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return ret;

    }

        public static void main (String[]args){
            Location1 location1 = new Location1();
            location1.setId(1L);
            location1.setName("Nume test1");
            location1.setOtherProperty1("Prop test 1");

            Location2 location2 = copy2(location1, Location2.class);
            System.out.println(location2);

        }
    }
