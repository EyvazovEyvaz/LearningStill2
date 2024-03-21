package testannopacklevel;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    @SuppressWarnings({"deprecation","unused"})
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {

        Useranno useranno = new Useranno();

        for (Method method: useranno.getClass().getDeclaredMethods()){

            Metodannotation myannotation = method.getDeclaredAnnotation(Metodannotation.class);

            System.out.println(myannotation.name());

            if (myannotation != null){

                Object ivoke = method.invoke(useranno);

                if (ivoke==null){

                    throw new NullPointerException("null olabilmez");
                }
            }

        }

    }
}