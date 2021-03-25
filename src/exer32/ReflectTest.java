/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package exer32;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 反射
 *
 * @author z00440867
 * @since 2021-02-25
 */
public class ReflectTest {
    /**
     * 获取Class类的实例的四种方式
     */
    @Test
    public void test1() throws ClassNotFoundException {
        // 方式一：调用运行时类的属性：.class
        Class<Person> personClass = Person.class;
        System.out.println(personClass);

        // 方式二：通过运行时类的对象，调用getClass()
        Person person = new Person();
        Class<? extends Person> personClass1 = person.getClass();
        System.out.println(personClass1);

        // 方式三：通过Class类的静态方法forName(String classPath)
        Class<?> personClass2 = Class.forName("exer32.Person");
        System.out.println(personClass2);

        // 方式四：通过类的加载器ClassLoader
        ClassLoader classLoader = ReflectTest.class.getClassLoader();
        Class<?> personClass3 = classLoader.loadClass("exer32.Person");
        System.out.println(personClass3);
    }

    /**
     * 通过反射创建运行时类的对象
     */
    @Test
    public void test2()
        throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<Person> personClass = Person.class;
        /*
         * newInstance()：调用此方法，创建对应的运行时类的对象。内部调用了运行时类的空参构造器
         * 要想此方法正确创建运行时类的对象，要求：
         * 1.运行时类必须提供空参构造器（InstantiationException）
         * 2.空参构造器的访问权限得够（IllegalAccessException）
         */
        // Person person = personClass.newInstance();
        Person person = personClass.getDeclaredConstructor().newInstance();
        System.out.println(person);
    }

    /**
     * 通过反射获取运行时类的属性
     */
    @Test
    public void test3() {
        Class<Person> personClass = Person.class;
        // getFields():获取Person类中属性声明为public的
        Field[] fields = personClass.getFields();
        for (Field f : fields) {
            System.out.println(f);
        }

        System.out.println();

        // getDeclaredFields():获取Person类（不包含父类）中声明的所有属性（public/private/默认属性）
        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field f : declaredFields) {
            System.out.println(f);
        }

        System.out.println();

        // getDeclaredFields():获取Person类（不包含父类）中声明的所有属性（public/private/默认属性）
        Field[] declaredFields2 = personClass.getDeclaredFields();
        for (Field f : declaredFields2) {
            // getModifiers():获取属性的权限修饰符
            int modifiers = f.getModifiers();
            System.out.print(Modifier.toString(modifiers) + "\t");

            // getType():获取属性的类型
            Class<?> type = f.getType();
            System.out.print(type.getName() + "\t");

            // getName():获取属性的名称
            String name = f.getName();
            System.out.print(name);

            System.out.println();
        }
    }

    /**
     * 通过反射获取运行时类的指定属性
     */
    @Test
    public void test9()
        throws NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InvocationTargetException,
               InstantiationException {
        Class<Person> personClass = Person.class;
        // getField()获取指定名称的属性（只能获取public类型的属性）
        Field describle = personClass.getField("describle");
        // 设置指定名称的属性 set(Object o, Object value) 需要先创建运行时类的对象
        Constructor<Person> declaredConstructor = personClass.getDeclaredConstructor();
        Person person = declaredConstructor.newInstance();
        describle.set(person, "hello");
        // 获取属性
        System.out.println(describle.get(person));

        // getDeclaredField()获取指定名称的属性（可以获取private类型的属性）
        Field age = personClass.getDeclaredField("age");
        // 保证当前属性是可访问的
        age.setAccessible(true);
        // 设置指定名称的属性 set(Object o, Object value) 需要先创建运行时类的对象
        age.set(person, 10);
        System.out.println(age.get(person));
    }

    /**
     * 通过反射获取运行时类的方法
     */
    @Test
    public void test4() {
        Class<Person> personClass = Person.class;
        // getMethods()：获取Person类（包括父类）中声明为Public的方法
        Method[] methods = personClass.getMethods();
        for (Method m : methods) {
            System.out.println(m);
        }

        System.out.println();

        // getDeclaredMethods()：获取Person类（不包括父类）中声明的方法
        Method[] declaredMethods = personClass.getDeclaredMethods();
        for (Method m : declaredMethods) {
            System.out.println(m);
        }
    }

    /**
     * 通过反射获取运行时类的指定方法
     */
    @Test
    public void test10()
        throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<Person> personClass = Person.class;
        Person person = personClass.getDeclaredConstructor().newInstance();
        // getMethod(String methodName, Class<?>... parameterTypes)：获取Person类中声明为Public的指定方法
        Method info = personClass.getMethod("info");
        // public Object invoke(Object obj, Object... args) 调用指定方法，invoke方法的返回值即为被调用方法的返回值
        // 如果被调用方法的返回值为void，则invoke方法的返回值为null
        Object invoke = info.invoke(person);
        System.out.println(invoke);

        // public reflect.Method getDeclaredMethod(@NonNls @NotNull String name, @Nullable Class<?>... parameterTypes)
        // 获取Person类中指定方法（包括private权限的方法）
        Method showNation = personClass.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        Object chn = showNation.invoke(person, "CHN");
        System.out.println(chn);

        // 如何获取并调用运行时类的静态方法
        Method sing = personClass.getDeclaredMethod("sing", String.class);
        sing.setAccessible(true);
        // Object songName = sing.invoke(null, "bird fly"); 这里填写为'null'也可以
        Object songName = sing.invoke(Person.class, "bird fly");
        System.out.println(songName);

    }

    /**
     * 通过反射获取运行时类的方法的内部结构（访问权限、返回值类型、方法名、形参列表、异常、注解）
     */
    @Test
    public void test5() {
        Class<Person> personClass = Person.class;
        // getDeclaredMethods()：获取Person类（不包括父类）中声明的方法
        Method[] declaredMethods = personClass.getDeclaredMethods();
        for (Method m : declaredMethods) {
            // 获取方法的访问权限getModifiers()
            System.out.print(Modifier.toString(m.getModifiers()) + "\t");

            // 获取方法的返回值类型getReturnType()
            Class<?> returnType = m.getReturnType();
            System.out.print(returnType.getName() + "\t");

            // 获取方法的方法名getName()
            String name = m.getName();
            System.out.print(name + "\t");

            // 获取方法的形参列表getParameterTypes()
            Class<?>[] parameterTypes = m.getParameterTypes();
            for (Class<?> parameterType : parameterTypes) {
                System.out.print(parameterType.getName() + "\t");
            }

            // 获取方法的异常getExceptionTypes()
            Class<?>[] exceptionTypes = m.getExceptionTypes();
            for (Class<?> exceptionType : exceptionTypes) {
                System.out.print(exceptionType.getName() + "\t");
            }

            System.out.println();
        }
    }

    /**
     * 获取运行时类的构造器
     */
    @Test
    public void test6() {
        Class<Person> personClass = Person.class;
        // 获取Person类（不包括父类）中所有声明为public的构造区 getConstructors()
        Constructor<?>[] constructors = personClass.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }
        System.out.println();

        // 获取Person类中所有的构造器(包括私有权限和默认权限的)
        Constructor<?>[] declaredConstructors = personClass.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor);
        }
    }

    /**
     * 通过反射获取运行时类的指定构造器
     */
    @Test
    public void test11()
        throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<Person> personClass = Person.class;
        // 获取声明为public的指定构造器public reflect.Constructor<T> getConstructor(@Nullable Class<?>... parameterTypes)
        Constructor<Person> constructor = personClass.getConstructor();
        Person person = constructor.newInstance();
        System.out.println(person);

        // 获取所有访问权限的指定构造器
        Constructor<Person> declaredConstructor = personClass.getDeclaredConstructor(String.class);
        declaredConstructor.setAccessible(true);
        Person person1 = declaredConstructor.newInstance("Tom");
        System.out.println(person1);
    }

    /**
     * 获取运行时类的父类及其相关结构
     */
    @Test
    public void test7() {
        // 获取运行时类的父类getSuperclass()
        Class<? super Person> superclass = Person.class.getSuperclass();
        System.out.println(superclass.getName());

        // 获取运行时类的带泛型的父类
        Type genericSuperclass = Person.class.getGenericSuperclass();
        System.out.println(genericSuperclass);

        // 获取运行时类的带泛型的父类的泛型
        ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        for (Type actualTypeArgument : actualTypeArguments) {
            System.out.println(actualTypeArgument.getTypeName());
        }
    }

    /**
     * 获取运行时类的接口、包和注解
     */
    @Test
    public void test8() {
        Class<Person> personClass = Person.class;
        // 获取运行时类的接口getInterfaces()
        Class<?>[] interfaces = personClass.getInterfaces();
        for (Class<?> anInterface : interfaces) {
            System.out.println(anInterface);
        }

        // 获取运行时类的包getPackage()
        Package aPackage = personClass.getPackage();
        System.out.println(aPackage);

        // 获取运行时类的注解getAnnotations()
        Annotation[] annotations = personClass.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
    }
}