typora-root-url: images

Java设计模式

==设计模式主要是提高程序的扩展性，可读性，可维护性、规范性。==

# 第 1 章 内容和授课方式

### ==具象用实体类，抽象用接口。==

### ==简单来说：形容词用接口，名词用抽象类==

##  Java设计模式内容介绍

先看几个经典的面试题

原型设计模式问题：

1、有请使用UML类图画出原型模式核心角色

2、原型设计模式的深拷贝和浅拷贝是什么，并写出深拷贝和浅拷贝的两种方式的源码(重写clone方法实现深拷贝、使用序列化来实现深拷贝)

3、在Spring框架中那里使用到了原型模式，并对源码进行分析

beans.xml

<bean id="id01" class="com.atguigu.spring.bean.Monster" scope="prototype" />



 ## 先看几个经典设计模式面试题

设计模式七大原则 要求1) 七大设计原则核心思想 2) 能够以类图说明设计原则 3)在项目实际开发中，你那里用了 ocp 原则

![](images/Snipaste_2020-09-28_09-05-13.png)

## 解释器设计模式

1、介绍解释器设计模式是什么？

2、画出解释器设计模式的 UML 类图，分析设计模式中各个角色是什么？

3、请说明 Spring 框架中，那里使用到了解释器设计模式，并作出源码级别的分析

4、Spring 框架中 SpelExpressionParser 就使用到了解释器模式

5、代码分析+Debug源码+模式角色分析说明

![](images/Snipaste_2020-09-28_09-09-42.png)



## 单例设计模式一共有几种实现方式？ 请分别用代码实现，并说明各个实现方式的优点和缺点?

单例设计模式一共有8中写法，后面会依次讲到

饿汉式 两种

懒汉式 两种

双重检查

静态内部类

枚举


 ## 设计模式的重要性

1、软件工程中，**设计模式 (design pattern)** 是对软件设计中**普通存在(反复出现)** 的各种问题，所提出的解决方案 这个术语是埃里希·伽玛 等人 在1990年代从建筑设计领域引入到计算机科学的

2、大厦 VS 简易房

3、拿实际工作经历来说，当一个项目开发完后，如果**客户提出增新功能**，怎么办？(可扩展性,使用了设计模式，软件具有很好的扩展性)

4、如果项目开发完后，原来程序员离职，你接手维护的项目怎么办?（**维护性**(可读性、规范性)）

5、目前程序员门槛越来越高，一线公司(大厂)，都会问你在实际项目中**使用过什么设计模式，怎么使用的，解决了什么问题**

6、**设计模式在软件那里**？面向对象(oo)=>功能设计模块(设计模式+算法(数据结构))=>框架[使用到多种设计模式]=>架构[服务i集群]

7、如果想要成为合格的软件**工程师**，那就花时间来研究下设计模式是非常必要的



# 第 2 章 设计模式七大原则

## 设计模式的目的

编写软件过程中，程序员面临着**耦合性，内聚性以及可维护性，可扩展性，重用性，灵活性**，等多方面的条件，设计模式是为了让程序(软件),具有更好

1、代码重用性(即：相同功能的代码，不用多次编写)
2、可读性(即：编程规范性，便于其他程序员的阅读和理解)

3、可扩展性(即：当需要增加新功能的时候，非常的方便，称为可维护)

4、可靠性(即：当我们增加新功能的时候，对原来的功能没有影响)

5、使程序程先高内聚，低耦合的特性

​	分享金句

6、设计模式包含了面向对象的精髓，“懂了设计模式，你就懂了面向对象分析和设计，(OOP/D)的精要”

7、Scott Myers 在其巨著《Effective C++》就曾经说过 C++的老手和 C++的新手区别是前者手背上有很多伤疤



##  设计模式七大原则

设计模式原则，其实就是程序员在编程时，应当遵守的原则，也是各种设计模式的基础(即：**设计模式为什么这样的依据**)

设计模式常用的七大原则是

1、单一职责原则

2、接口隔离原则

3、依赖倒转(倒置)原则

4、里式替换原则

5、开闭原则

6、迪米特原则

7、**合成复用原则**



### 单一职责原则

#### 	 基本介绍

对类来说的，**即一个类应该只负责一项职责**，如类A负责两个不同的职责，职责1，职责2，当职责1需求变更而改变A时，可能造成职责2 执行错误，所以需要将类A的粒度分解为A1 A2

####  应用实例

​	以交通工具案例讲解

1. 代码

   ```java
   public class SingleResponsibility1 {
       public static void main(String[] args) {
           Vehicle vehicle = new Vehicle();
           vehicle.run("摩托车");
           vehicle.run("汽车");
           vehicle.run("飞机");
       }
   }
   
   // 交通工具类
   // 方式1
   // 1、在方式1的run方法中，违反了单一职责原则
   // 2、解决的方案非常简单，根据交通工具的运行方法不同，分解成不同类即可
   class Vehicle {
       public void run(String vehicle) {
           System.out.println(vehicle + " 在公路上运行...");
       }
   }
   
   ```
   
   
   
2. 方案2

   ```java
   public class SingleResponsibility2 {
       public static void main(String[] args) {
           RoadVehicle roadVehicle = new RoadVehicle();
           roadVehicle.run("摩托车");
           roadVehicle.run("汽车");
           AirVehicle airVehicle = new AirVehicle();
           airVehicle.run("飞机");
       }
   }
   //方案2 分析
   // 1、遵守单一职责原则
   // 2、但是这样做的改动很大，即将类分解，同时修改客户端
   // 3、改进：直接修改Vehicle类，改动代码会比较少=>方案3
   class RoadVehicle {
       public void run(String vehicle) {
           System.out.println(vehicle + " 公路运行");
       }
   }
   class AirVehicle {
       public void run(String vehicle) {
           System.out.println(vehicle + " 天空运行");
       }
   }
   ```
   
3. 方案3

   ```java
   public class SingleResponsibility3 {
       public static void main(String[] args) {
           Vehicle2 vehicle2 = new Vehicle2();
           vehicle2.run("骑车");
           vehicle2.runAir("飞机");
           vehicle2.runWater("船");
       }
   }
   
   // 方式3的分析
   // 1、这种修改方法没有对原来的类做打的修改，只是增加方法
   // 2、这里虽然没有在类这个级别遵守单一职责原则，但是在方法级别上，任然是遵守单一职责
   class Vehicle2 {
       public void run(String vehicle) {
           System.out.println(vehicle +" 在公路上运行....");
       }
   
       public void runAir(String vehicle) {
           System.out.println(vehicle + " 在天空上运行....");
       }
   
       public void runWater(String vehicle) {
           System.out.println(vehicle + " 在水上运行");
       }
   }
   ```
   
   ####  单一职责原则注意事项和细节
   
   1、降低类的复杂度，一个类只负责一项职责

   2、提高类的可读性，可维护性

   3、降低变更引起的风险

   4、通常情况下，我们应当遵守单一职责原则，只有逻辑足够简单，才可以在代码违反单一职责原则，只有类中方法数量足够少，可以在方法级别保持单一职责原则



###  接口隔离原则(Interface Segregation Principle)

####  基本介绍

​	1、客户端不应该依赖它不需要的接口，即一个**类对另一个类的依赖应该建立在最小接口**上

​	2、先看一张图

![](images/Snipaste_2020-09-28_13-17-23.png)

​	3、类 A 通过接口 Interface1 依赖B ，类C 通过接口 Interface 依赖D，如果接口 Interface1 对于类 A 和类 C 说不是最小接口，那么类 B 和类 D必须去实现他们不需要的方法

​	4、按隔离原则应当这样处理

​	**将接口 Interface1** 拆分为独立的几个接口(**这里我们拆分成三个接口)**，类 A 和 类 C 分别与他们需要的接口建立依赖关系，也就是采用接口隔离原则

#### 	应用实例

​	1、类A通过接口 interface1 依赖B 类C通过接口 Interface1依赖类D 请编写代码完成此实例，

​	2、老师代码，没有用接口隔离原则代码

```java
public class Segregation1 {

}

interface Interface1 {
    void operation1();
    void operation2();
    void operation3();
    void operation4();
    void operation5();
}
class B implements Interface1 {
    @Override
    public void operation1() {
        System.out.println("B 实现了Operation1");
    }

    @Override
    public void operation2() {
        System.out.println("B 实现了Operation2");
    }

    @Override
    public void operation3() {
        System.out.println("B 实现了Operation3");
    }

    @Override
    public void operation4() {
        System.out.println("B 实现了Operation4");
    }

    @Override
    public void operation5() {
        System.out.println("B 实现了Operation5");
    }
}
class D implements Interface1 {
    @Override
    public void operation1() {
        System.out.println("D 实现了Operation1");
    }

    @Override
    public void operation2() {
        System.out.println("D 实现了Operation2");
    }

    @Override
    public void operation3() {
        System.out.println("D 实现了Operation3");
    }

    @Override
    public void operation4() {
        System.out.println("D 实现了Operation4");
    }

    @Override
    public void operation5() {
        System.out.println("D 实现了Operation5");
    }
}

class A { // A 类通过接口Interface1 依赖使用B类 但是只会用到1，2，3方饭
    public void depend1(Interface1 i){
        i.operation1();
    }
    public void depend(Interface1 i) {
        i.operation2();
    }
    public void depend3(Interface1 i) {
        i.operation3();
    }
}
class C { //C 类通过接口Interface1 依赖使用 D类 但是只会用到 1，4，5 方法
    public void depend1(Interface1 i) {
        i.operation1();
    }
    public void depend4(Interface1 i) {
        i.operation4();
    }
    public void depend5(Interface1 i) {
        i.operation5();
    }
}
```

#### 	 传统方法的问题和使用接口隔离原则改进

类 A 通过接口 Interface1 依赖类B 类C 通过接口 Interface1 依赖类D ，如果接口 Interface1对类A 和类C来说不是最小接口，那么类B和类D 必须去实现他们不需要的方法

将接口 Interface1 拆分成独立的几个接口，类A 和类C 分别与他们需要的接口建立依赖关系，也就是采用接口隔离原则

接口 interface1出现的方法，根据实际情况拆分为三个接口

![](images/Snipaste_2020-09-28_13-17-34.png)

代码实现

```java
package com.atguigu.principle.segregation.improve;

public class Segregation1 {
    public static void main(String[] args) {
        A a = new A();
        // A类通过接口去依赖B类
        a.depend1(new B());
        a.depend2(new B());
        a.depend3(new B());
        C c = new C();
        // C类通过接口去依赖(使用)D类
        c.depend1(new D());
        c.depend4(new D());
        c.depend5(new D());

    }

}

//接口1
interface Interface1 {
    void operation1();
}
// 接口2
interface Interface2 {
    void operation2();
    void operation3();
}
// 接口3
interface Interface3{
    void operation4();
    void operation5();
}

class B implements Interface1,Interface2 {
    @Override
    public void operation1() {
        System.out.println("B 实现了Operation1");
    }

    @Override
    public void operation2() {
        System.out.println("B 实现了Operation2");
    }

    @Override
    public void operation3() {
        System.out.println("B 实现了Operation3");
    }
}

class D implements Interface1,Interface3 {
    @Override
    public void operation1() {
        System.out.println("D 实现了Operation1");
    }
    @Override
    public void operation4() {
        System.out.println("D 实现了Operation4");
    }

    @Override
    public void operation5() {
        System.out.println("D 实现了Operation5");
    }
}

class A { // A 类通过接口Interface1,Interface2 依赖使用B类 但是只会用到1，2，3方法
    public void depend1(Interface1 i){ 
        i.operation1(); 
    }
    public void depend2(Interface2 i){
        i.operation2();
    }
    public void depend3(Interface2 i){
        i.operation3();
    }
}

class C { //C 类通过接口Interface1 Interface3 依赖使用 D类 但是只会用到 1，4，5 方法
    // 参数是接口
    public void depend1(Interface1 i) {
        i.operation1();
    }
    public void depend4(Interface3 i) {
        i.operation4();
    }
    public void depend5(Interface3 i) {
        i.operation5();
    }
}
```



### 依赖倒转原则

#### 基本介绍

1. 依赖倒转原则(Dependence Inversion Principle)是指

2. 高层模块不应该依赖底层模块，二者都应该实现其抽象

3. **抽象不应该依赖细节，细节应该依赖对象**

4. 依赖倒转(倒置)的中心思想是**面向接口编程**

5. 依赖倒转原则是基于这样的设计理念，相对于细节多变性，抽象的东西要稳定得多，以抽象为基础搭建的架构比细节为基础的架构要稳定的多，在Java中，重选ing指的是接口或抽象类，细节就是具体的实现类

6. 使用**接口或抽象类**目的是制**定好规范**，而不涉及任何具体的操作，把**展现细节的任务交给他们实现类**去完成

   

####  应用案例

请编程完成Person接收消息功能

1、实现方案1+分析说明

```java
package com.atguigu.principle.inversion;
public class DependecyInversion {
    public static void main(String[] args) {
        Person person = new Person();
        person.receive(new Email());
    }
}
class Email {
    public String getInfo() {
        return "电子邮件消息：hello world";
    }
}
// 完成Person接收消息功能
//方式1完成分析
// 1、简单，比较容易想到
// 2、如果我们获取的对象是微信，短信等等，则新增类，同时Persons也要增加相应的接收方法
// 3、解决思路 引入一个抽象的接口 IReceiver 表示接收者，这样Person类与接口IReceiver发送依赖
// 因为Email、WeXin,等等属于接收的范围，他们各自实现IReceiver 接口就ok，这样我们就符合依赖倒转原则
class Person {
    public void receive(Email email) {
        System.out.println(email.getInfo());
    }
}
```

2、实现方案2+分析说明

```java
package com.atguigu.principle.inversion.improve;
public class DependecyInversion {
    public static void main(String[] args) {
        // 客户端无需改变
        Person person = new Person();
        person.receive(new Email());
        person.receive(new WeiXin());
    }
}

interface IReceiver {
    public String getInfo();
}
class Email implements IReceiver {
    @Override
    public String getInfo() {
        return "电子邮件消息：hello world";
    }
}
// 增加微信
class WeiXin implements IReceiver {

    @Override
    public String getInfo() {
        return "微信消息: hello ok";
    }
}

class Person {
    public void receive(IReceiver receiver) {
        System.out.println(receiver.getInfo());
    }
}
```

####  依赖关系传递的三种方式和应用案例

1、接口传递

2、构造方法传递

3、setter方式传递

代码

```java
package com.atguigu.principle.inversion.improve;

public class DependencyPass {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ChangHong changHong = new ChangHong();
        // 接口
//        OpenAndClose openAndClose = new OpenAndClose();
//        openAndClose.open(changHong);
        // 通过构造器
//        OpenAndClose openAndClose = new OpenAndClose(changHong);
//        openAndClose.open();
        // 通过set
        OpenAndClose openAndClose = new OpenAndClose();
        openAndClose.setTv(changHong);
        openAndClose.open();

    }

}

// 方式1： 通过接口传递实现依赖
// 开关的接口
//interface IOpenAndClose {
//    public void open(ITV tv); //抽象方法,接收接口
//}
//
//interface ITV { //ITV接口
//    public void play();
//}
//
class ChangHong implements ITV {

    @Override
    public void play() {
        System.out.println("长虹电视机,打开");
    }
}
//// 实现接口
//class OpenAndClose implements IOpenAndClose {
//    public void open(ITV tv) {
//        tv.play();
//    }
//}

// 方式2: 通过构造方法依赖传递
/*interface IOpenAndClose {
    public void open(); //抽象方法
}

interface ITV { //ITV接口
    public void play();
}

class OpenAndClose implements IOpenAndClose {
    public ITV tv;

    public OpenAndClose(ITV tv) {
        this.tv = tv;
    }

    public void open() {
        this.tv.play();
    }
 }*/

    // 方式3 , 通过setter方法传递
    interface IOpenAndClose {
        public void open(); // 抽象方法

        public void setTv(ITV tv);
    }

    interface ITV { // ITV接口
        public void play();
    }

    class OpenAndClose implements IOpenAndClose {
        private ITV tv;

        public void setTv(ITV tv) {
            this.tv = tv;
        }

        public void open() {
            this.tv.play();
        }
    }
```

注意事项 

低层模块尽量都要有抽象类或接口，或者两者都有，程先稳定性更好

变量的**声明类型尽量是抽象类或接口**，这样我们变量引用和实际对象间，就存在一个**缓冲层**，利于程先扩展和优化

继承时遵守里氏替换原则



###  里氏替换原则

#### 	oo中的继承性思考和说明

1、继承包含这样一层含义，父类中凡是已经实现好的方法，实际上时在设定规划和契约，虽然他不强制要求所有的子类必须遵守这些契约，但是如果子类对这些已经实现的方法任意修改，就会对整个继承体系造成破坏



2、**继承在程序设计带来便利的同时，也带来了弊端**，比如使用继承会给程序带来**侵入性**，程序的可移植性降低，增加对象间的耦合性，如果一个类被其他类所继承，则当这个类需要修改时，必须考虑到所有的子类，并且父类修改后，所有涉及到子类的功能都有可能产生故障

3、问题提出，在编程中，如何正确使用继承=》里氏替换原则



**基本介绍**

1. 里氏替换原则 在 19988年 由麻省理工学院的一位姓里的女士提出的，
2. 如果对每个类型为T1的对象o1，都有类型为T2的对象 o2,时的以 T1定义的程序 P在所有对象o1都代换成o2时，程序P的行为没有发生变化，那么类型T2是类型T1的子类型，**换句话说，所有引用基类的地方必须能透明的使用其子类的对象**
3. 在使用继承时，遵循里氏替换原则，在**子类中尽量不要重写父类方法**
4. 里氏替换原则告诉我们，继承实际上让两个类耦合性增强了，在适当情况下，可以通过聚合，组合，依赖来解决问题



#### 一个程序引出的问题和思考

```java
package com.atguigu.principle.liskow;
public class Liskov {

    public static void main(String[] args) {
        A a = new A();
        System.out.println("11-3=" + a.func1(11,3));
        System.out.println("1-8=" +a.func1(1,8));

        System.out.println("---------------");
        B b = new B();
        System.out.println("11-3=" + b.func1(11,3));
        System.out.println("1-8=" + b.func1(1,8));
        System.out.println("11+3+9=" + b.func2(11,3));
    }
}

class A {
    // 返回连个数的差
    public int func1(int num1,int num2) {
        return num1 - num2;
    }
}
// B 继承了 A
// 增加一个新功能，完成两个数相加，然后和9求和
class B extends A {
    // 这里重写了A类的方法，可能时无意识
    @Override
    public int func1(int a, int b) {
        return a + b;
    }
    public int func2(int a, int b) {
        return func1(a,b) + 9;
    }

}
```

#### 解决方法

1. 我们发现原来运行正常的相减功能发生了错误，原因就是类B无意中重写了父类的方法，造成原有功能出现错误，在实际编程中，我们常常会通过重写父类的方法完成新的功能，这样写虽然简单，但整个继承体系的复用性比较差，特别是运行多态比较频繁的时候

2. 通用的做法是：原来的父类和子类都继承了一个更通俗的基类，原有的继承关系去掉，采用依赖、聚合、组合等关系替代

3. 解决方案

   ![](images/Snipaste_2020-09-28_15-29-14.png)

代码实现

```java
package com.atguigu.principle.liskow.improve;
public class Liskov {

    public static void main(String[] args) {
        A a = new A();
        System.out.println("11-3=" + a.func1(11,3));
        System.out.println("1-8=" +a.func1(1,8));

        System.out.println("---------------");
        B b = new B();
        System.out.println("11-3=" + b.func1(11,3));
        System.out.println("1-8=" + b.func1(1,8));
        System.out.println("11+3+9=" + b.func2(11,3));


        System.out.println("11+3+9=" + b.func3(11,3));
    }
}

// 创建一个更加基础的基类
class Base {
    // 把更加基础的方法和成员写到Base类

}
class A extends Base{
    // 返回连个数的差
    public int func1(int num1,int num2) {
        return num1 - num2;
    }
}

// B 继承了 A
// 增加一个新功能，完成两个数相加，然后和9求和
class B extends Base {
    // 如果B需要使用A类的方法，使用组合关系
    private A a = new A();
    // 这里重写了A类的方法，可能时无意识
    public int func1(int a, int b) {
        return a + b;
    }
    public int func2(int a, int b) {
        return func1(a,b) + 9;
    }
    public int func3(int a, int b) {
        return this.a.func1(a,b);
    }
}
```

 

### 开闭原则

#### 	基本介绍

1、开闭原则(Open Closed Principle)是编程中**最基础、最重要**的设计原则

2、一个软件实体如类，模块和函数应该对扩展开放**(对提供方)，对修改关闭(对使用**
**方。**用抽象构建框架，用实现扩展细节。

3、当软件需要变化时，尽量**通过扩展软件实体**的行为来实现变化，而不是**通过修改**已
有的代码来实现变化。

4、编程中遵循其它原则，以及使用设计模式的目的就是遵循开闭原则。

#### 	 看下面一段代码

看一个画图形的功能

![](images/Snipaste_2020-09-29_11-56-10.png)



##### 代码演示

```java
package com.atguigu.principle.ocp;
public class Ocp {

    public static void main(String[] args) {
        // 使用看看存在的问题
        GraphicEditor graphicEditor = new GraphicEditor();
        graphicEditor.drawShape(new Rectangle());
        graphicEditor.drawShape(new Circle());
        graphicEditor.drawShape(new Triangle());
        graphicEditor.drawShape(new A());
    }
}
// 这是一个用于绘图的类
class GraphicEditor {
    public void drawShape(Shape s) {
        if (s.m_type == 1) {
            drawRectangle(s);
        } else  if (s.m_type == 2) {
            drawCircle(s);
        } else if (s.m_type == 3) {
            drawTriangle(s);
        } else if (s.m_type == 4) {

        }
    }
    public void drawRectangle(Shape r) {
        System.out.println("绘制矩形");
    }
    public void drawCircle(Shape r) {
        System.out.println("绘制圆形");
    }
    public void drawTriangle(Shape r) {
        System.out.println("绘制三角形");
    }
    public void drawA(Shape r) {
        System.out.println("绘制A");
    }
}
// Shape类 基类
class Shape {
    int m_type;
}
class Rectangle extends Shape {
    Rectangle() {
        super.m_type = 1;
    }
}
class Circle extends Shape {
    Circle() {
        super.m_type = 2;
    }
}
//新增画三角形
class Triangle extends Shape {
    Triangle() {
        super.m_type = 3;
    }
}
class A extends Shape {
    A() {
        super.m_type = 4;
    }
}
```



####   方式1 的优缺点

1. 优点是比较好理解，简单易操作
2. 缺点是违反了设计模式的ocp原则，即对扩展开放(提供方)，对修改关闭(使用方)。即当我们给类增加新功能的时候，尽量不修改代码，或者尽可能少修改代码.
3. 比如我们这时要新增加一个图形种类三角形，我们需要做如下修改，修改的地方较多
4. 代码演示



方式 1改进思路分析

#### 	 改进思路分析

思路:把创建Shape类做成抽象类，并提供- -个抽象的draw方法，让子类去实现即可，这样我们有新的图形种类时，只需要让新的图形类继承Shape,并实现draw方法即可，使用方的代码就不需要修>满足了 开闭原则

改进后代码

```java
package com.atguigu.principle.ocp.improve;
public class Ocp {

    public static void main(String[] args) {
        // 使用看看存在的问题
        GraphicEditor graphicEditor = new GraphicEditor();
        graphicEditor.drawShape(new Rectangle());
        graphicEditor.drawShape(new Circle());
        graphicEditor.drawShape(new Triangle());
        graphicEditor.drawShape(new OtherGraphic());
    }
}

// 这是一个用于绘图的类
class GraphicEditor {
    // 接收Shape对象，然后根据type，来绘制不同的图形
    public void drawShape(Shape s) {
        s.draw();
    }

}

// Shape类 基类
abstract class Shape {
    int m_type;
    // 抽象方法
    public abstract void draw();
}

class Rectangle extends Shape {
    Rectangle() {
        super.m_type = 1;
    }

    @Override
    public void draw() {
        System.out.println("绘制矩形");
    }
}

class Circle extends Shape {
    Circle() {
        super.m_type = 2;
    }

    @Override
    public void draw() {
        System.out.println("绘制圆形");
    }
}

//新增画三角形
class Triangle extends Shape {
    Triangle() {
        super.m_type = 3;
    }

    @Override
    public void draw() {
        System.out.println("绘制三角形");
    }
}

//新增一个图形
class OtherGraphic extends Shape {
    OtherGraphic() {
        super.m_type = 4;
    }

    @Override
    public void draw() {
        System.out.println("七边形");
    }
}
```



###  迪米特法则

#### 	 基本介绍

1、一个对象应该对其他对象保持最少的了解

2、类与类关系越密切，耦合度越大

3、迪米特法则(Demeter Principle)又叫**最少知道原则**，即一个**类对自己依赖的类知道的越少越好**。也就是说，对于被依赖的类不管多么复杂，都尽量将逻辑封装在类的内部。对外除了提供的public方法，不对外泄露任何信息

4、迪米特法则还有个更简单的定义:只与直接的朋友通信

5、**直接的朋友**: 每个对象都会与其他对象有**耦合关系**，只要两个对象之间有耦合关系，我们就说这两个对象之间是朋友关系。耦合的方式很多，依赖，关联，组合，聚合等。其中，我们称出现**成员变量，方法参数，方法返回值**中的类为直接的朋友，而出现在**局部变量中的类不是直接的朋友**。也就是说，陌生的类最好不要以局部变量的形式出现在类的内部。

#### 	 应用实例

1、有一个学校，下属有各个学院和总部，现要求打印出学校总部员工ID和学院员工的id 
2、编程实现上面的功能，看代码演示

3、代码演示

```java
package com.atguigu.principle.demeter;

import java.util.ArrayList;
import java.util.List;
// 客户端
public class Demter {

    public static void main(String[] args) {
        SchoolManager schoolManager = new SchoolManager();
        schoolManager.printAllEmployee(new CollegeManager());
    }
}
// 学校总部员工类
class Employee {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

// 学院员工类
class CollegeEmployee {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
// 学院管理类
class CollegeManager {
    // 返回学院所有员工
    public List<CollegeEmployee> getAllEmployee() {
        List<CollegeEmployee> list = new ArrayList<CollegeEmployee>();
        // 增加了10个员工到list集合
        for(int i = 0; i < 10; i++) {
            CollegeEmployee emp = new CollegeEmployee();
            emp.setId("学院员工id=" + i);
            list.add(emp);
        }
        return list;
    }

}

// 分析 SchoolManager 类的直接朋友类有那些 Employee CollegeManager
// CollegeEmployee 不是直接朋友而是一个陌生类，违反了迪米特法则
// 学校管理类
class SchoolManager {
    // 返回学校总部的员工
    public List<Employee> getAllEmployee() {
        List<Employee> list = new ArrayList<Employee>();
        for(int i = 0; i < 5; i++) {
            Employee emp = new Employee();
            emp.setId("学校员工id=" + i);
            list.add(emp);
        }
        return list;
    }
    // 该方法完成输出学校总部和学院员工的信息id
    void printAllEmployee(CollegeManager sub) {
        // 分析问题
        // 1、这里的CollegeEmployee 不是 SchoolManager 直接朋友
        //  2、CollegeEmployee 是以局部变量的方式出现在 SchoolManager
        // 3、违反了迪米特法则

        // 将输出学院的员工方法，封装到 CollegeManager
        // 获取到学院员工
        List<CollegeEmployee> list1 = sub.getAllEmployee();
        System.out.println("---------------分公司员工----------------");
        for (CollegeEmployee e: list1) {
            System.out.println(e.getId());
        }

        // 获取到学校总部员工
        List<Employee> list2 = this.getAllEmployee();
        System.out.println("---------------学校总部员工---------------");
        for (Employee e : list2) {
            System.out.println(e.getId());
        }
    }
}
```



#### 	 应案例改进

1、前面设计的问题在于SchoolManager中，CollegeEmployee 类并不是SchoolManager类的直接朋(分析)

2、按照迪米特法则，应该避免类中出现这样非直接朋友关系的耦合

3、对代码按照迪米特法则进行改进. (看老师演示)

```java
package com.atguigu.principle.demeter.improve;

import java.util.ArrayList;
import java.util.List;
// 客户端
public class Demter {

    public static void main(String[] args) {
        System.out.println("使用迪米特法则改进");
        SchoolManager schoolManager = new SchoolManager();
        schoolManager.printAllEmployee(new CollegeManager());
    }
}

// 学校总部员工类
class Employee {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

// 学院员工类
class CollegeEmployee {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

// 学院管理类
class CollegeManager {
    // 返回学院所有员工
    public List<CollegeEmployee> getAllEmployee() {
        List<CollegeEmployee> list = new ArrayList<CollegeEmployee>();
        // 增加了10个员工到list集合
        for(int i = 0; i < 10; i++) {
            CollegeEmployee emp = new CollegeEmployee();
            emp.setId("学院员工id=" + i);
            list.add(emp);
        }
        return list;
    }
    // 输出学院员工信息
    public void printEmployee() {
        List<CollegeEmployee> list1 = getAllEmployee();
        System.out.println("---------------分公司员工----------------");
        for (CollegeEmployee e: list1) {
            System.out.println(e.getId());
        }
    }
}

// 分析 SchoolManager 类的直接朋友类有那些 Employee CollegeManager
// CollegeEmployee 不是直接朋友而是一个陌生类，违反了迪米特法则
// 学校管理类
class SchoolManager {
    // 返回学校总部的员工
    public List<Employee> getAllEmployee() {
        List<Employee> list = new ArrayList<Employee>();
        for(int i = 0; i < 5; i++) {
            Employee emp = new Employee();
            emp.setId("学校员工id=" + i);
            list.add(emp);
        }
        return list;
    }
    // 该方法完成输出学校总部和学院员工的信息id
    void printAllEmployee(CollegeManager sub) {
        // 分析问题
        // 1、这里的CollegeEmployee 不是 SchoolManager 直接朋友
        //  2、CollegeEmployee 是以局部变量的方式出现在 SchoolManager
        // 3、违反了迪米特法则

        // 将输出学院的员工方法，封装到 CollegeManager
        // 获取到学院员工
        sub.printEmployee();

        // 获取到学校总部员工
        List<Employee> list2 = this.getAllEmployee();
        System.out.println("---------------学校总部员工---------------");
        for (Employee e : list2) {
            System.out.println(e.getId());
        }
    }
}
```



#### 	迪米特法则注意事项和细节

1、迪米特法则核心是降低类之间的耦合

2、但是注意：由于每个类都减少了不必要的依赖因此迪米特法则只是要求降低类间(对象间)耦合关系，并不是要求完全没有依赖关系



### 合成复用原则(Composite Reuse Principle)

#### 	 基本介绍

原则尽量使用合成/聚合的方式，而不是使用继承

![](images/Snipaste_2020-09-29_12-15-38.png)

​	从左往右依次是 依赖  																									组合(实心)

​								聚合(空心)



#### 	 设计原则核心思想

1、找出应用中可能需要变化之处，把他们独立出来，不要和那些不需要变化的代码混在一起

2、针对接口编程，而不是针对实现编程

3、为了交互对象之间的松耦合设计而努力



# 第 3 章 UML 类图



## 	 UML 基本介绍

1、UML--Unified modeling language UML(统一建模语言)，是一种用于软件系统分析和设计的语言工具，它用于帮助软件开发人员进行思考和记录思路的结果

2、 UML本身是一套符号的规定，就像数学符号和化学符号一样，这些符号用于描述软件模型中的各个元素和他们之间的关系，比如类、接口、实现、泛化、依赖、组合、聚合等，如右图:

![](images/Snipaste_2020-09-29_12-56-43.png)

3、使用UML来建模，常用的工具有RationalRose ,也可以使用一些插件来建模

![](images/Snipaste_2020-09-29_12-53-30.png)



## 	UML 图

画UML图与写文章差不多，都是把自己的思想描述给别人看，关键在于思路和条理，UML图分类:

1、用例图(use case)
2、静态结构图:类图、对象图、包图、组件图、部署图
3、动态行为图:交互图(时序图与协作图)、状态图、活动图

说明：

1、类图是描述类与类之间的关系的，是UML图中最核心的
2、在讲解设计模式时，我们必然会使用类图，为了让学员们能够把设计模式学到位，需要先给大家讲解类图
3、温馨提示:如果已经掌握UML类图的学员，可以直接听设计模式的章节



## 	 UML 类图

1、用于描述系统中的**类(对象)本身的组成和类(对象)之间的各种静态关系。**
2、类之间的关系:依赖、泛化(继承)、实现、关联、聚合与组合。
3、类图简单举例

```java
public class Person { // 代码形式 ---> 类图

    private Integer id;
    private String name;


    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

}
```

![](images/Snipaste_2020-09-29_13-21-21.png)



## 	 类图--依赖关系(Dependence)

只要是在类中用到了对方，那么他们之间就存在依赖关系，如果没有对方，连编译都过不了

```java
public class PersonServiceBean{
    private PersonDao personDao;
    public void save(Person person){}
    public IDCard getIDCard(Integer personid) {}
    public void modify(){
        Department department = new Department();
    }
}
public class PersonDao{}
public class IDCard{}
public Person{}
public class Department{}
```

![](images/Snipaste_2020-09-29_16-16-53.png)

**小结**

1、类中用到了对方

2、如果是**类的成员属性**

3、如果是**方法的返回类型**

4、是方法的**接收参数类型**

5、**方法中使用到**



### 	 类图--泛化关系(generalization)

泛化关系实**际上就是继承关系**，他是依赖关系的特例

```java
public abstract class DaoSupport {
    public void save(Object entity) {
        
    }
    public void deelte(Object id) {
        
    }
}
public class PersonServiceBean extends DaoSupport {
    
}
```

对应的类图

![](images/Snipaste_2020-09-29_16-27-22.png)

**小结：**

1、泛型关系实际**上就是继承关系**

2、如果 A 类继承了 B 类，我们就说 A 和 B 存在泛化关系



### 	类图--实现关系(Implementation)

实现关系实际上就是**A类实现B接口**，他是依赖关系的特例

```java
public interface PersonService{
    public void deelte(Integer id);
}
public class PersonServiceBean implements PersonService{
    public void deletge(Integer id){}
}
```

类图

![](images/Snipaste_2020-09-29_16-29-36.png)



### 	 类图--关联关系(Association)

![](images/Snipaste_2020-09-29_16-32-19.png)



### 类图--聚合关系(Aggregation)

 	**3.8.1基本介绍**	 

​		聚合关系(Aggregation) 表示的是**整体和部分的关系**，**整体与部分可以分开**，聚合关系是**关联关系的特例**，所以他具有关联的**导航性与多重性**

​		如：一台电脑由键盘(keyboard)，显示器(monitor)，鼠标等组成电脑的各个配件可以从电脑上分离出来的，使用带空心菱形的实现来表示

![](images/Snipaste_2020-09-29_16-38-16.png)

​	**3.8.1 应用实例**

![](images/Snipaste_2020-09-29_16-38-05.png)

###  类图--组合关系(composition)

​		**3.9.1 基本介绍**

组合关系：也是整体与部分的关系，但是**整体与部分不可以分开**，

在看一个案例：在程序中我们定义实体，Person与IDCard 、Head,那么 Head 和 Person 就是 组合 IDCard和 Person就是聚合



但是如果在程序中 Person实体中定义了对IDCard进行**级联删除**，即删除 Person时连同IDCard 一起删除，那么 IDcard 和 Person就是组合



 	**3.9.2 应用案例**

```java
public class Person{
    private IDCard card;
    private Head head = new Head();
}
public class IDCard{}
public class Head{}
```

对应类图

![](images/Snipaste_2020-09-29_16-46-06.png)

案例二

```java
package com.atguigu.aggregation;
public class Computer {

    // 鼠标可以和computer不能分离
    private Moniter moniter = new Mouse();
    // 显示器可以和computer不能分离
    private Mouse mouse = new Mouse();

    public void setMoniter(Moniter moniter) {
        this.moniter = moniter;
    }

    public void setMouse(Mouse mouse) {
        this.mouse = mouse;
    }
}
```

```java
public class Moniter {

}
```

```java
public class Mouse {

}
```

![](images/Snipaste_2020-09-29_16-48-34.png)





# 第 4 章 设计模式概述 

## 		 掌握设计模式的层次

1、第一层：刚开始学编程不久，听说过什么是设计模式

2、第二层，有很长时间的编程经验，自己写了很多代码，其中用到了设计模式，但是自己却还不知道

3、第三层：学习过了设计模式，发现自己已经在使用了，并且发现了一些新的模式挺好用的

4、第四层：阅读了很多别人的源码和框架，在其中看到别人的设计模式，并且能够领会设计模式的精妙和带来的好处

5、第五层：代码写着写着，自己都没有意识到使用了设计模式，并且熟练的写了出来



## 	 设计模式介绍

1、设计模式是程序在面对同类得软件工程师设计问题所总结出来有用的经验，**模式不是代码，而是某类问题的通用解决方案**。设计模式(Design patten)代表了最佳实践，这些解决方案是众多软件开发人员经过相当长的一段时间的试验和错误总结出来的

2、设计模式本质是提高 **软件维护性，通用性和扩展性，并降低了软件的复杂度**

3、<<**设计模式**>>是经典的书，作者是Erich Gamma ,Richard Helm Ralph Johnson 和Vissides Design(俗称四人组GOF)

4、设计模式并不局限某种语言，java,php,c++ 都有设计模式



## 	设计模式分类

设计模式分为**三种类型**，共23种

1、**创建型模式**，单例模式，抽象工厂模式，原型模式，建造者模式，工厂模式

2、**结构型模式**：适配器模式，桥接模式，装饰模式，装饰模式，组合模式，外观模式，享元模式，代理模式

3、行为型模式：模板方法模式，命令模式，访问者模式，迭代器模式，观察者模式，中介者模式，备忘录模式，解释器模式(Interpreter模式)、状态模式，策略模式，职责链模式(责任链模式)

注意：不同的书籍对分类和名称略有差别





# 第 5 章 单例设计模式

## 	 单例设计模式介绍

所谓类的单例设计模式，就是采取一定的方法保证在整个的软件系统中，对某个类只能存在一个对象实例

并且该类只提供一个取得其对象实例的方法(静态方法)



比如 Hibernate 的 SessionFactory 它充当数据存储源的代理，并创建 Session 对象 SessionFactory 并不是轻量级的，一般情况下，一个项目通常只需要一个 SessionFactory 就够，这是就会使用到单例设计模式



## 	 单例设计模式八种方式

单例设计模式有八种方式：

1、**饿汉式(静态常量)**

2、**饿汉式(静态代码块)**

3、懒汉式(线程不安全)

4、懒汉式(线程安全，同步代码)

5、懒汉式(线程安全，同步代码块)

6、**双重检查**

7、**静态内部类**

8、**枚举**



 饿汉式(静态常量)

饿汉式(静态常量)应用实例

步骤如下：

构造器私有化

类的内部创建对象

向外暴露一个静态的公共方法，getInstance

代码实现:

```java
package com.atguigu.principle.singleton.type1;
public class SingletonTest01 {

    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        Singleton instance1 = Singleton.getInstance();
        System.out.println(instance == instance1);
        System.out.println(instance.hashCode() + "--" +instance1.hashCode());
    }

}
// 饿汉式(静态变量)
class Singleton {
    // 构造器私有化 外部不能new
    private Singleton() {}

    // 2、本类内部创建对象实例
    private final static Singleton instance = new Singleton();

    // 3、提供一个公有静态方法
    public static Singleton getInstance() {
        return instance;
    }

}
```



**优缺点说明**

1. 优点:这种写法比较简单，就是在类装载的时候就完成实例化。避免了线程同步问题
2. 缺点:在类装载的时候就完成实例化，没有达到Lazy Loading的效果。如果从始至终从未使用过这个实例，则会造成内存的浪费 
3. 这种方式基于classloder机制避免了多线程的同步问题，不过，instance在类装载时就实例化，在单例模式中大多数都是调用getlnstance方法，但 是导致类装载的原因有很多种，因此不能确定有其他的方式(或者其他的静态方法)导致类装载，这时候初始化instance就没有达到lazy loading的效果
4. 结论:这种单例模式可用，可能造成内存浪费



### 	饿汉式(静态代码块)

代码演示

```java
package com.atguigu.principle.singleton.type2;

/**
 * @author gcq
 * @Create 2020-09-30
 */
public class SingletonTest02 {

    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        Singleton instance1 = Singleton.getInstance();
        System.out.println(instance == instance1);
        System.out.println(instance.hashCode() + "--" +instance1.hashCode());
    }

}

// 饿汉式(静态变量)
class Singleton {
    // 构造器私有化 外部不能new
    private Singleton() {}

    // 2、本类内部创建对象实例
    private  static Singleton instance;

    // 静态代码块中创建单例对象
    static {
        instance = new Singleton();
    }

    // 3、提供一个公有静态方法
    public static Singleton getInstance() {
        return instance;
    }
}
```

**优缺点说明**

1. 这种方式和上面的方式其实类似，只不过将类实例化的过程放在了静态代码块中，也是在类装载的时候，就执行静态代码块中的代码，初始化类的实例。优缺点和上面是一样的。
2. 结论:这种单例模式可用，但是可能造成内存浪费



### 懒汉式(线程不安全)

代码演示

```java
package com.atguigu.principle.singleton.type3;
public class SingletonTest03 {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        Singleton instance1 = Singleton.getInstance();
        System.out.println(instance == instance1);
    }
}
class Singleton {
    private static Singleton instance;

    private Singleton() {};

    // 提供一个静态的公有方法，当使用到该方法时，才去创建
    public static Singleton getInstance() {
        if (instance == null ){
            instance = new Singleton();
        }
        return instance;
    }

}
```

优缺点说明：

1. 起到了**Lazy Loading**的效果，但是只能在单线程下使用。
2. 如果在多线程下，一个线程进入了if (singleton = nul1)判断语句块，还未来得及往下执行，另一个线程也通过了这
   个判断语句，这时便**会产生多个实例**。所以在多线程环境下不可使用这种方式
3. 结论:在实际开发中，**不要使用这种方式.**



### 	懒汉式(线程安全，同步方法)

代码演示：

```java
package com.atguigu.principle.singleton.type4;
public class SingletonTest04 {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        Singleton instance1 = Singleton.getInstance();
        System.out.println(instance == instance1);
    }
}

// 懒汉式 线程安全 同步方法
class Singleton {
    private static Singleton instance;

    private Singleton() {};

    // 提供一个静态的公有方法，当使用到该方法时，才去创建
    public static synchronized Singleton getInstance() {
        if (instance == null ){
            instance = new Singleton();
        }
        return instance;
    }

}
```



**优缺点说明**

1. 解决了**线程安全问题**
2. 效率太低了，每个线程在想获得类的实例时候，执行getInstance()方法都要进行同步。而其实这个方法只执行一次实例化代码就够了，后面的想获得该类实例，直接retum就行了。**方法进行同步效率太低**
3. 结论:在实际开发中，**不推荐**使用这种方式



### 	懒汉式(线程安全，同步代码块)

![](images/Snipaste_2020-09-30_12-05-53.png)

不推荐使用



### 	 双重检查

代码演示：

```java
package com.atguigu.principle.singleton.type6;
public class SingletonTest06 {
    public static void main(String[] args) {
        System.out.println("双重检查");
        Singleton instance = Singleton.getInstance();
        Singleton instance1 = Singleton.getInstance();
        System.out.println(instance == instance1);
    }
}

// 懒汉式 线程安全 同步方法
class Singleton {
    private static volatile Singleton instance;

    private Singleton() {};

    // 提供一个静态的公有方法，加入双重检查，解决线程安全问题，同时解决懒加载问题
    public static Singleton getInstance() {
        if (instance == null ){
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

}
```

**优缺点说明**:

1. Double-Check概念是多线程开发中常使用到的，如代码中所示，我们进行了两次if (singleton == nul)检查，这样就可以保证线程安全了。
2. 这样，实例化代码只用执行一次,后面再次访问时，判断if (singleton == null),直接return实例化对象，也避免的反复进行方法同步.
3. 线程安全;**延迟加载,效率较高**
4. 结论:在实际开发中，**推荐使用这种单例设计模式**



### 	 静态内部类

代码演示：

```java
package com.atguigu.principle.singleton.type7;
public class SingletonTest07 {
    public static void main(String[] args) {
        System.out.println("静态内部类");
        Singleton instance = Singleton.getInstance();
        Singleton instance1 = Singleton.getInstance();
        System.out.println(instance == instance1);
    }
}

// 静态内部类
class Singleton {
    private static volatile Singleton instance;

    private Singleton() {};
    // 写一个静态内部类 该类中有一个静态属性 Singleton
    private static class SingletonInstance {
        private static final Singleton INSTACE = new Singleton();
    }

    // 提供一个静态的公有方法，直接返回SingletonInstance.INSTANCE
    public static Singleton getInstance() {
        return SingletonInstance.INSTACE;
    }

}
```

**优缺点说明**：

1. 这种方式采用了类装载的机制来保证初始化实例时只有一个线程。
2. 静态内部类方式在Singleton类被装载时并不会立即实例化，而是在需要实例化时，调用getInstance方法， 才会装载SingletonInstance类，从而完成Singleton的实例化。
3. 类的静态属性只会在第一次加载类的时候初始化，所以在这里，JVM帮助我们保证了线程的安全性，在类进行初始化时，别的线程是无法进入的。
4. 优点:避免了线程不安全，利用静态内部类特点实现延迟加载，效率高
5. 结论:推荐使用.



### 	 枚举

代码演示:

```java
package com.atguigu.principle.singleton.type8;
public class SingletonTest08 {
    public static void main(String[] args) {
        Singleton s = Singleton.INSTANCE;
        Singleton s2 = Singleton.INSTANCE;
        System.out.println(s == s2);
        s.sayOk();
    }
}
enum Singleton {
    INSTANCE;
    public void sayOk() {
        System.out.println("ok~");
    }
}
```

**优缺点说明：**

1. 这借助JDK1.5中添加的枚举来实现单例模式。不仅能避免多线程同步问题，而且还能防止反序列化重新创建新的对象。
2. 这种方式是Effective Java作者Josh Bloch提倡的方式
3. 结论:推荐使用



## 	单例模式在 JDK 应用中源码分析

1. 我们JDK中，java.lang.Runtime就是经典的单例模式
2. 代码分析 + Debug源码+代码说明

![](images/Snipaste_2020-09-30_12-14-23.png)



## 	 单例模式注意事项和细节说明

1. 单例模式保证了系统内存中该类只存在一个对象，节省了系统资源，对于一些需要频繁创建销毁的对象，使用单例模式可以提高系统性能
2. 当想实例化一个单例类的时候，必须要记住使用相应的获取对象的方法，而不是使用new
3. 单例模式**使用的场景**:需要**频繁的进行创建和销毁的对象**、创建对象时耗时过多或耗费资源过多(即:**重量级对象**)，但又经常用到的对象、**工具类对象**、频繁访问数据库或文件的对象(比如**数据源、session**工厂等)





# 第 6 章 工厂模式

## 	 简单工厂模式

###  看一个具体的需求

看一个披萨项目，要便于披萨种类的扩展，要便于维护

1、披萨的种类很多，比如GreekPizz，CheesePiz 等

2、披萨的制作有 prepare准备，bake烤，cut 切 box 包装

3、完成披萨店订购功能



### 使用传统方式来完成

1、思路分析(类图)

![](images/Snipaste_2020-09-30_22-00-03.png)

编写 OrderPizza.java 去订购需要的各种 pizza

2、看老师代码演示

```java
/* public OrderPizza() {
     Pizza pizza = null;
     String orderType; //披萨订购的类型
     do{
         orderType = gettype();
         if (orderType.equals("greek")) {
             pizza = new GreekPizza();
             pizza.setName(" 希腊披萨 ");
         } else if (orderType.equals("cheese")) {
             pizza = new CheesePizza();
             pizza.setName(" 奶酪披萨 ");
         } else if(orderType.equals("pepper")) {
             pizza = new PepperPizza();
             pizza.setName("胡椒披萨");
         } else {
             break;
         }
         // 输出pizza制作过程
         pizza.prepare();
         pizza.bake();
         pizza.cut();
         pizza.box();
     }while (true);
 }*/
```



###  传统方式的优缺点

1. 优点是比较好理解，简单易操作
2. 缺点是违反了设计模式的**ocp原则**，即对扩展开放，对修改关闭。即当我们给类增加新功能的时候，尽量不修改代码，或者尽可能少修改代码.
3. **比如我们这时要新增加一个**Pizza的种类(Pepper披萨)，我们需要做如下修改.

如果我们增加一个Pizza类，只要是订购Pizza的代码都需要修改

![](images/Snipaste_2020-09-30_22-05-25.png)

 4. 改进思路分析

    分析:修改代码可以接受,但是如果我们在其它的地方也有创建Pizza的代码，就意味着，也需要修改,而创建Pizza的代码，往往有多处。.
    思路:**把创建Pizza 对象封装到一个类中,这样我们有新的Pizza种类时，只需要修改该类就可**,其它有创建到Pizza对象的代码就不需要修改了.->**简单工厂模式**



### 简单工厂模式基本介绍

1. 简单工厂模式是属于**创建型模式**，是工厂模式的一种。简单工厂模式是由一-个工厂对象决定创建出哪一种产品类的实例。简单工厂模式是**工厂模式家族中最简单实用的模式.**
2. 简单工厂模式:定义了一个创建对象的类，由这个类来**封装实例化对象的行为**(代码)
3. 在软件开发中，当我们会用到大量的创建某种、某类或者某批对象时，就会使用到工厂模式.



### 使用简单工厂模式

1. 简单工厂模式设计方案，定义一个实例化 Pizza对象的类，封装创建对象的代码

   ![](images/Snipaste_2020-09-30_22-09-08.png)

2. 看代码示例：

   ```java
   package com.atguigu.factory.simplefactory.pizzastore.order;
   
   import com.atguigu.factory.simplefactory.pizzastore.pizza.CheesePizza;
   import com.atguigu.factory.simplefactory.pizzastore.pizza.GreekPizza;
   import com.atguigu.factory.simplefactory.pizzastore.pizza.PepperPizza;
   import com.atguigu.factory.simplefactory.pizzastore.pizza.Pizza;
   
   public class SimpleFactory {
   
       /**
        * 根据orderType 返回对应的Pizza 对象
        * @param orderType
        * @return
        */
       public static Pizza createPizza(String orderType) {
   
           Pizza pizza = null;
           System.out.println("使用简单工厂模式");
           if (orderType.equals("greek")) {
               pizza = new GreekPizza();
               pizza.setName(" 希腊披萨 ");
           } else if (orderType.equals("cheese")) {
               pizza = new CheesePizza();
               pizza.setName(" 奶酪披萨 ");
           } else if(orderType.equals("pepper")) {
               pizza = new PepperPizza();
               pizza.setName("胡椒披萨");
           }
           return pizza;
       }
       // 简单工厂模式也叫静态工厂模式
   
   }
   ```

```java
package com.atguigu.factory.simplefactory.pizzastore.order;

import com.atguigu.factory.simplefactory.pizzastore.pizza.CheesePizza;
import com.atguigu.factory.simplefactory.pizzastore.pizza.GreekPizza;
import com.atguigu.factory.simplefactory.pizzastore.pizza.PepperPizza;
import com.atguigu.factory.simplefactory.pizzastore.pizza.Pizza;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class OrderPizza {

   /* public OrderPizza() {
        Pizza pizza = null;
        String orderType; //披萨订购的类型
        do{
            orderType = gettype();
            if (orderType.equals("greek")) {
                pizza = new GreekPizza();
                pizza.setName(" 希腊披萨 ");
            } else if (orderType.equals("cheese")) {
                pizza = new CheesePizza();
                pizza.setName(" 奶酪披萨 ");
            } else if(orderType.equals("pepper")) {
                pizza = new PepperPizza();
                pizza.setName("胡椒披萨");
            } else {
                break;
            }
            // 输出pizza制作过程
            pizza.prepare();
            pizza.bake();
            pizza.cut();
            pizza.box();
        }while (true);
    }*/

    //定义一个简单工厂对象
    SimpleFactory simpleFactory;

    Pizza pizza = null;

    //构造器
    public OrderPizza(SimpleFactory simpleFactory) {
        setFactory(simpleFactory);
    }
    public void setFactory(SimpleFactory simpleFactory) {
        // 用户输入的
        String orderType = "";

        // 设置简单工厂对象
        this.simpleFactory = simpleFactory;
        do{
            orderType = gettype();
            pizza = this.simpleFactory.createPizza(orderType);

            if (pizza != null) {
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.box();
            } else {
                System.out.println(" 订购披萨失败");
                break;
            }
        }while(true);
    }

    //写一个方法 可以获取客户希望订购的披萨类
    private String gettype() {
        try {
            BufferedReader strin = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("input pizza type:");
            String str = strin.readLine();
            return str;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
```



## 工厂方法模式

###  看一个新的需求

​	披萨项目新的需求:客户在点披萨时，可以点**不同口味的披萨**，比如北京的奶酪pizza、北京的胡椒pizza或者是伦敦的奶酪pizza、伦敦的胡椒pizza。

###  思路1

​	使用**简单工厂模式**，创建**不同的简单工厂类**，比如BJPizzaSimpleFactory、LDPizzaSimpleFactory等等从当前这个案例来说，也是可以的，但是考虑到项目的规模，以及软件的可维护性、可扩展性并不是特别好

### 思路2

​	使用工厂方法模式

###  工厂方法模式介绍

1、工厂方法模式设计方案:将披萨项目的实例化功能抽象成抽象方法，在不同的口味点餐子类中具体实现。

2、工厂方法模式**:定义了一个创建对象的抽象方法**，由**子类决定要实例化的类。**工厂方法模式将**对象的实例化推迟到子类。**

### 工厂方法模式应用案例

1、披萨项目新的需求:客户在点披萨时，可以点不同口味的披萨，比如北京的奶酪pizza、北京的胡椒pizza或者是伦敦的奶酪pizza、伦敦的胡椒pizza

2、思路分析

![](images/Snipaste_2020-09-30_22-15-33.png)



3、代码实现

```java
package com.atguigu.factory.factorymethod.pizzastore.order;


import com.atguigu.factory.factorymethod.pizzastore.pizza.Pizza;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public abstract class OrderPizza {

    // 定义一个抽象方法 createPizza 让各个工厂子类自己实现
    abstract Pizza createPizza(String orderType);

    public OrderPizza() {
        Pizza pizza = null;
        String orderType; //披萨订购的类型
        do{
            orderType = gettype();
            // 抽象方法 由工厂子类完成
          pizza = createPizza(orderType);
            // 输出pizza制作过程
            pizza.prepare();
            pizza.bake();
            pizza.cut();
            pizza.box();
        }while (true);
    }



    //写一个方法 可以获取客户希望订购的披萨类
    private String gettype() {
        try {
            BufferedReader strin = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("input pizza type:");
            String str = strin.readLine();
            return str;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
```

子类实现

```java
package com.atguigu.factory.factorymethod.pizzastore.order;

import com.atguigu.factory.factorymethod.pizzastore.pizza.BJCheesePizza;
import com.atguigu.factory.factorymethod.pizzastore.pizza.BJPepperPizza;
import com.atguigu.factory.factorymethod.pizzastore.pizza.Pizza;

public class BJOrderPizza extends OrderPizza{

    @Override
    Pizza createPizza(String orderType) {
        Pizza pizza = null;
        if (orderType.equals("cheese")) {
            pizza = new BJCheesePizza();
        } else if (orderType.equals("pepper")) {
            pizza = new BJPepperPizza();
        }
        return pizza;
    }
}
```



```java
package com.atguigu.factory.factorymethod.pizzastore.order;

import com.atguigu.factory.factorymethod.pizzastore.pizza.*;
import com.sun.org.apache.bcel.internal.generic.LDC;

public class LDOrderPizza extends OrderPizza{

    @Override
    Pizza createPizza(String orderType) {
        Pizza pizza = null;
        if (orderType.equals("cheese")) {
            pizza = new LDCheesePizza();
        } else if (orderType.equals("pepper")) {
            pizza = new LDPepperPizzza();
        }
        return pizza;
    }
}
```



## 抽象工厂模式

### 	基本介绍

1. 抽象工厂模式:定义了一个**interface用于创建相关或有依赖关系的对象簇**，而无需指明具体的类
2. 抽象工厂模式可以将简单工厂模式和工厂方法模式进行整合。
3. 从设计层面看，抽象工厂模式就是对简单工厂模式的改进(或者称为进一 步的抽象)。
4. 将工厂抽象成**两层**，**AbsFactory(抽象工厂 )**和**具体实现的工厂子类**。程序员可以根据创建对象类型使用对应的工厂子类。这样将单个的简单工厂类变成了工厂簇，更利于代码的维护和扩展。
5. 类图
6. ![](images/Snipaste_2020-09-30_22-18-43.png)

### 抽象工厂模式应用实例

使用抽象工厂模式来完成披萨项目

```java
package com.atguigu.factory.absfactory.pizzastore.order;

import com.atguigu.factory.absfactory.pizzastore.pizza.Pizza;

/*一个抽象工厂的抽象层(接口) */
public interface AbsFactory {

    // 让下main的工厂子类来具体实现
    public Pizza createPizza(String orderType);

}
```

OrderPizza.java

```java
package com.atguigu.factory.absfactory.pizzastore.order;

public class OrderPizza {

    AbsFactory factory;

    public OrderPizza(AbsFactory factory) {
        setFactory(factory);
    }

    private void setFactory(AbsFactory absFactory) {
        Pizza pizza = null;
        //    用户输入
        String orderType = "";
        this.factory = absFactory;

        do {
            orderType = gettype();
            // factory 可能是北京的工厂子类，也可能是伦敦的工厂子类
            pizza = factory.createPizza(orderType);
            if (pizza != null) {
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.box();
            } else {
                System.out.println("订购失败");
                break;
            }
        } while (true);
    }
    //写一个方法 可以获取客户希望订购的披萨类
    private String gettype() {
        try {
            BufferedReader strin = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("input pizza type:");
            String str = strin.readLine();
            return str;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
```



## 工厂模式在 JDK-Calendar 应用的源码分析

1、JDK 中 Calendar 类中，就使用到了简单工厂模式

2、源码+Debug源码+分析

```java
package com.atguigu.jdk;

import java.util.Calendar;

public class Factory {
    public static void main(String[] args) {
        //  getInstance 是 Calendar的静态方法
        Calendar instance = Calendar.getInstance();
        System.out.println("年:" + instance.get(Calendar.YEAR));
    }
}
```

```java
public static Calendar getInstance()
{
    return createCalendar(TimeZone.getDefault(), Locale.getDefault(Locale.Category.FORMAT));
}
```

```java
private static Calendar createCalendar(TimeZone zone,
                                       Locale aLocale) // 根据TimeZone Local 创建对应的实例
{
    CalendarProvider provider =
        LocaleProviderAdapter.getAdapter(CalendarProvider.class, aLocale)
                             .getCalendarProvider();
    if (provider != null) {
        try {
            return provider.getInstance(zone, aLocale);
        } catch (IllegalArgumentException iae) {
            // fall back to the default instantiation
        }
    }

    Calendar cal = null;

    if (aLocale.hasExtensions()) {
        String caltype = aLocale.getUnicodeLocaleType("ca");
        if (caltype != null) {
            switch (caltype) {
            case "buddhist":
            cal = new BuddhistCalendar(zone, aLocale);
                break;
            case "japanese":
                cal = new JapaneseImperialCalendar(zone, aLocale);
                break;
            case "gregory":
                cal = new GregorianCalendar(zone, aLocale);
                break;
            }
        }
    }
    if (cal == null) {
        // If no known calendar type is explicitly specified,
        // perform the traditional way to create a Calendar:
        // create a BuddhistCalendar for th_TH locale,
        // a JapaneseImperialCalendar for ja_JP_JP locale, or
        // a GregorianCalendar for any other locales.
        // NOTE: The language, country and variant strings are interned.
        if (aLocale.getLanguage() == "th" && aLocale.getCountry() == "TH") {
            cal = new BuddhistCalendar(zone, aLocale);
        } else if (aLocale.getVariant() == "JP" && aLocale.getLanguage() == "ja"
                   && aLocale.getCountry() == "JP") {
            cal = new JapaneseImperialCalendar(zone, aLocale);
        } else {
            cal = new GregorianCalendar(zone, aLocale);
        }
    }
    return cal;
}
```



# 第 7 章 原型模式

## 克隆羊问题

现在有一只羊tom,姓名为:tom,年龄为: 1， 颜色为:白色，请编写程序创建和tom羊属性完全相同的10
只羊。



7.2 传统方式解决克隆羊问题

1、思路分析(图解)

![](images/Snipaste_2020-10-02_16-29-07.png)

2、看老师代码演示

```java
package com.atguigu.prototype;
public class Client {
    public static void main(String[] args) {
        Sheep sheep = new Sheep("tom", 1, "白色");

        Sheep sheep1 = new Sheep(sheep.getName(), sheep.getAge(), sheep.getColor());
        Sheep sheep2 = new Sheep(sheep.getName(), sheep.getAge(), sheep.getColor());
        Sheep sheep3 = new Sheep(sheep.getName(), sheep.getAge(), sheep.getColor());
        Sheep sheep4 = new Sheep(sheep.getName(), sheep.getAge(), sheep.getColor());
        Sheep sheep5 = new Sheep(sheep.getName(), sheep.getAge(), sheep.getColor());
        ///....

        System.out.println(sheep1);
        System.out.println(sheep2);
    }
}
```



###  传统方式的优缺点

1. 有点是比较好理解，简单易操作

2. 在创建新的对象时，总是需要重新获取原始对象的属性，如果创建的对象比较复杂时，效率较低

3. 总是需要重新初始化对象，而不是动态地获得对象运行时的状态，不够灵活

4. 改进的思路分析

   **思路**: Java中Object类是所有类的根类，Object 类提供了一个clone0方法，该方法可以将-一个Java对象复制一份， 但是需要实现clone的Java类必须要实现-一个接口Cloneable,该接口表示该类能够复制且具有复制的能力=>

   **原型模式**

##  原型模式

### 基本介绍

1、原型模式(Prototype模式)是指: 用**原型实例指定创建对象的种类**，**并且通过拷贝这些原型，创建新的**对象
2、 原型模式是一种创建型设计模式，允许一个对象再创建另外一个可定制的对象，无需知道如何创建的细节
3、工作原理是:通过将一个原型对象传给那个要发动创建的对象，这个要发动创建的对象通过请求原型对象拷贝它们自己来实施创建，**即对象.clone()**
4、形象的理解:孙大圣拔出猴毛， 变出其它孙大圣



###  原型模式原理结构图 uml 类图

![](images/Snipaste_2020-10-02_16-32-58.png)

**原型结构图说明**

Prototype:原型类，声明一个克隆自己的接口

ConcretePrototype：具体的原型类，实现一个克隆自己的操作

Cient 让一个原型对象克隆自己，从而创建一个新的对象(属性一样)



###  原型模式解决克隆羊问题的应用实例

使用原型模式改进传统方式，让程序具有更高的效率和扩展性

代码实现

```java
public class Sheep implements Cloneable {

    private String name;
    private int age;
    private String color;
    public Sheep firend; // 是对象 克隆是会如何处理，默认是浅拷贝

    public Sheep(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Sheep{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }

    @Override
    protected  Object clone()  {
        Sheep sheep = null;
        try {
            sheep = (Sheep) super.clone();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sheep;
    }
}
```

```java
public class Client {
    public static void main(String[] args) throws CloneNotSupportedException {
        System.out.println("原型模式完成对象创建");
        Sheep sheep = new Sheep("tom",1,"白色");
        Sheep sheep1 = (Sheep) sheep.clone(); // 克隆
        Sheep sheep2 = (Sheep) sheep.clone();
        Sheep sheep3 = (Sheep) sheep.clone();
        Sheep sheep4 = (Sheep) sheep.clone();

        System.out.println("sheep2=" + sheep2);

    }
}
```



## 原型模式在 Spring 框架中源码分析

Spring 中原型 bean 的创建 ，就是原型模式的应用

代码分析+Debug源码

![](images/Snipaste_2020-10-02_16-38-31.png)



## 深入讨论-浅拷贝和深拷贝

### 	浅拷贝的介绍

1. 对于数据类型是基本数据类型的成员变量，浅拷贝会直接进行值传递，也就是将.
   该属性值复制一-份给新的对象。

2. 对于数据类型是引用数据类型的成员变量，比如说成员变量是某个数组、某个类的对象等，那么浅拷贝会进行引用传递，也就是只是将该成员变量的引用值(内存地址)复制一份给新的对象。因为实际上两个对象的该成员变量都指向同一个.
   实例。在这种情况下，在一个对象中修改该成员变量会影响到另一个对象的该成员变量值

3. 前面我们克隆羊就是浅拷贝

4. 浅拷贝是使用默认的clone()方法来实现

   **sheep = (Sheep) super.clone();**



###  深拷贝基本介绍

1. 复制对象的所有基本数据类型的成员变量值
2. 为所有引用数据类型的成员变量申请存储空间，并复制每个引用数据类型成员变量所引用的对象，直到该对象可达的所有对象。也就是说，**对象进行深拷贝要对整个对象进行拷贝(包括对象的引用类型进行拷贝)**
3. 深拷贝实现方式1:重写**clone**方法来实现深拷贝
4. 深拷贝实现方式2:通过**对象序列化实现深拷贝(推荐)**。



###  深拷贝应用分析

1. 使用重写 clone方法 实现深拷贝
2. 使用序列化实现深拷贝
3. 代码演示

转化为的类型

```java
package com.atguigu.prototype.deepclone;
import java.io.Serializable;
public class DeepCloneableTarget implements Serializable,Cloneable {

    private static final long serialVersionUID = 1L;

    private String cloneName;

    private String cloneClass;


    public DeepCloneableTarget(String cloneName, String cloneClass) {
        this.cloneName = cloneName;
        this.cloneClass = cloneClass;
    }

    // 该类属性都是String 默认clone方法 浅拷贝
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
```



```java
package com.atguigu.prototype.deepclone;

import java.io.*;
public class DeepProtoType implements Serializable,Cloneable {

    public String name;
    public DeepCloneableTarget deepCloneableTarget;

    public DeepProtoType() {
        super();
    }
    //深拷贝-- method1 使用clone方法
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object deep = null;
        // 这是完成对基本数据类型(属性)和String的克隆
        deep = super.clone();
        //对引用类型的属性,进行单独处理
        DeepProtoType deepProtoType = (DeepProtoType)deep;
        deepProtoType.deepCloneableTarget = (DeepCloneableTarget) deepCloneableTarget.clone();

        return deepProtoType;
    }

    // 深拷贝 method2 通过对象序列化实现(推荐)
    public Object deepClone() {

        // 创建流对象
        ByteArrayOutputStream bos = null;
        ObjectOutputStream oos = null;
        ByteArrayInputStream bis = null;
        ObjectInputStream ois = null;

        try {
            // 序列化
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            // 当前这个对象以对象流的方式输出
            oos.writeObject(this);

            // 反序列化
            bis = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bis);
            DeepProtoType copyObj = (DeepProtoType) ois.readObject();

            return copyObj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                bos.close();
                oos.close();
                bis.close();
                ois.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
```



```java
package com.atguigu.prototype.deepclone;
public class Client {

    public static void main(String[] args) throws CloneNotSupportedException {
        DeepProtoType p = new DeepProtoType();
        p.name = "宋江";
        p.deepCloneableTarget = new DeepCloneableTarget("大牛","大牛的类");

        // 方式1 完成深拷贝
//        DeepProtoType p2 = (DeepProtoType) p.clone();
//        System.out.println("p.name=" + p.name + "p.deepCloneableTraget=" + p.deepCloneableTarget.hashCode());
//        System.out.println("p2.name=" + p2.name + "p2.deepCloneableTraget=" + p2.deepCloneableTarget.hashCode());

        // 方式2 完成深拷贝
        DeepProtoType p2 = (DeepProtoType) p.deepClone();
        System.out.println("p.name=" + p.name + "p.deepCloneableTraget=" + p.deepCloneableTarget.hashCode());
        System.out.println("p2.name=" + p2.name + "p2.deepCloneableTraget=" + p2.deepCloneableTarget.hashCode());


    }
}
```

## 原型模式的注意事项和细节

1. 创建新的对象比较复杂时，可以利用原型模式**简化对象的创建过程，同时也能够提高**效率
2. 不用重新初始化对象，而是动态地获得对象运行时的状态
3. 如果原始对象发生变化(增加或者减少属性)，其它克隆对象的也会发生相应的变化，无需修改代码
4. 在实现深克隆的时候可能需要比较复杂的代码
5. **缺点**:需要为每一个类配备一个克隆方法，这对全新的类来说不是很难，但对已有
6. 的类进行改造时，需要修改其源代码，违背了ocp原则，这点请同学们注意.



# 第 8 章 建造者模式

### ==具象用实体类，抽象用接口。==

### ==简单来说：形容词用接口，名词用抽象类==

## 盖房项目需求

1、需要建房子:这一过程为打桩、砌墙、封顶

2、房子有各种各样的，比如普通房，高楼，别墅，各种房子的过程虽然一样，但是要求不要相同的.

3、请编写程序， 完成需求.

## 传统方式解决盖房需求

思路分析(图解)

![](images/Snipaste_2020-10-03_19-43-42.png)

### 代码

```java
package com.atguigu.builder;
public abstract class AbstrctHouse {

    // 打地基
    public abstract void buildBasic();
    // 砌墙
    public abstract void buildWalls();
    //封顶
    public abstract void roofed();

    public void build() {
        buildBasic();
        buildWalls();
        roofed();
    }

}
```

```java
package com.atguigu.builder;
public class CommonHouse extends AbstrctHouse {

    @Override
    public void buildBasic() {
        System.out.println(" 普通房子打地基");
    }

    @Override
    public void buildWalls() {
        System.out.println(" 普通方式砌墙");
    }

    @Override
    public void roofed() {
        System.out.println(" 普通房子封顶");
    }
}
```

```java
package com.atguigu.builder;
public class Client {
    public static void main(String[] args) {
        CommonHouse commonHouse = new CommonHouse();
        commonHouse.build();
    }

}
```

### 传统方式解决盖房子需求问题分析

1、优点是比较好理解，简单易操作。

2、设计的程序结构，过于简单，没有设计缓存层对象，程序的扩展和维护不好.也就是说，这种设计方案，把产品(即:房子)和创建产品的过程(即:建房子流程)封
装在一起，耦合性增强了。

3、解决方案:将产品和产品建造过程解耦=>**建造者模式**.

##  建造者模式

### 基本介绍

1、建造者模式(**Builder Pattern)** ]又叫**生成器模式**，是一种对象**构建模式**。它可以将复杂对象的建造过程抽象出来(抽象类别)，使这个抽象过程的不同实现方法可以构造出不同表现(属性)的对象。
2、建造者模式是一步--步创建一个复杂的对象，它允许用户只通过指定复杂对象的类型和内容就可以构建它们，
用户不需要知道内部的具体构建细节。



### 建造者模式的四个角色

#### Product (产品角色) 

一个具体的产品对象。

#### Builder (抽象建造者) 

创建个Product对 象的各 个部件指定的接口/抽象类。

#### ConcreteBuilder (具体建造者) 

实现接口， 构建和装配各个部件。

####  Director (指挥者) 

构建一个使用Builder接 口的对象。 它主要是用于创建一个复杂的对象。它主要有两个作用，一是:隔离了客户与对象的生产过程，二是:负责控制产品对象的生产过程。

![](images/Snipaste_2020-10-03_19-51-03.png)



##  建造者模式解决盖房需求应用实例

1、需要建房子:这一过程为打桩、砌墙、封顶。不管是普通房子也好，别墅也好都需要经历这些过程，下 面我们使用建造者模式(Builder Pattern)来完成

### 思路分析图解(类图)

![](images/Snipaste_2020-10-03_19-51-39.png)

### 代码实现

#### 抽象建造者

```java
package com.atguigu.builder.improve;
public abstract class HouseBuilder {

    protected House house = new House();

    // 建造流程写好，抽象的方法
    public abstract void buildBasic();
    public abstract void buildWalls();
    public abstract void roofed();

    // 建造房子好，将产品(房子) 返回
    public House buildHouse() {
        return house;
    }
}
```

#### 指挥者

```java
package com.atguigu.builder.improve;
/* 指挥者 这里指定制作流程*/
public class HouseDirector {
    HouseBuilder houseBuilder = null;

    // 构造器传入
    public HouseDirector(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }
    // set传入
    public void setHouseBuilder(HouseBuilder builder) {
        this.houseBuilder = builder;
    }

    // 如何处理建造房子的流程，交给指挥者
    public House constructHouse() {
        houseBuilder.buildBasic();
        houseBuilder.buildWalls();
        houseBuilder.roofed();
        return houseBuilder.buildHouse();
    }

}
```

#### 产品角色

```java
package com.atguigu.builder.improve;
public class House {
    private String baise;
    private String wall;
    private String rooed;

    public String getBaise() {
        return baise;
    }

    public void setBaise(String baise) {
        this.baise = baise;
    }

    public String getWall() {
        return wall;
    }

    public void setWall(String wall) {
        this.wall = wall;
    }

    public String getRooed() {
        return rooed;
    }

    public void setRooed(String rooed) {
        this.rooed = rooed;
    }
}
```

#### 具体建造者

```java
package com.atguigu.builder.improve;
public class HighBuilding extends HouseBuilder {

    @Override
    public void buildBasic() {
        System.out.println(" 高楼地基100米");
    }

    @Override
    public void buildWalls() {
        System.out.println(" 高楼砌墙20cm");
    }

    @Override
    public void roofed() {
        System.out.println(" 高楼透明房顶");
    }

}
```

```java
package com.atguigu.builder.improve;
public class CommonHouse extends HouseBuilder {

    @Override
    public void buildBasic() {
        System.out.println(" 普通房子打地基5米");
    }

    @Override
    public void buildWalls() {
        System.out.println(" 普通房子砌墙10cm");
    }

    @Override
    public void roofed() {
        System.out.println(" 普通房子封顶");
    }
}
```

#### 调用者

```java
package com.atguigu.builder.improve;
public class Client {
    public static void main(String[] args) {

        // 盖普通房子
        CommonHouse commonHouse = new CommonHouse();
        // 准备创建房子的指挥者
        HouseDirector houseDirector = new HouseDirector(commonHouse);

        // 完成盖房子，返回产品(房子)
        House house = houseDirector.constructHouse();

//        System.out.println("输出流程");

        System.out.println("--------------------------");
        // 盖高楼
        HighBuilding highBuilding = new HighBuilding();
        //  重置建造者
        houseDirector.setHouseBuilder(highBuilding);
        // 完成盖房子 返回产品
        houseDirector.constructHouse();

    }
}
```



## 建造者模式在JDK的应用和源码分析

1、java.lang.StringBuilder 中建造者模式

2、代码说明+Debug源码

![](images/Snipaste_2020-10-03_19-54-35.png)

3、源码中建造者模式角色分析

1、Appendable接口定义了多个append方法(抽象方法)，即Appendable为抽象建造者，定义了抽象方法
2、AbstractStringBuilder实现了Appendable 接口方法，这里的AbstractStringBuilder已经 是建造者，只是不能实例化
3、StringBuilder即充当了指挥者角色，同时充当了具体的建造者,建造方法的实现是由AbstractStringBuilder 完成，而
4、StringBuilder继承 了AbstractStringBuilder



## 建造者模式的注意事项和细节

1、客户端(使用程序)不必知道产品内部组成的细节，将产品本身与产品的创建过程解耦，使得相同的创建过程可以创建不同的产品对象

2、每一个具体建造者都相对独立，而与其他的具体建造者无关，因此可以很方便地替换具体建造者或增加新的具体建造者，用户使用不同的具体建造者即可得到不同的产品对象

3、可以更加精细地控制产品的创建过程。将复杂产品的创建步骤分解在不同的方法中，使得创建过程更加清晰，也更方便使用程序来控制创建过程

4、增加新的具体建造者无须修改原有类库的代码，指挥者类针对抽象建造者类编程，系统扩展方便，符合“开闭原则”

5、建造者模式所创建的产品一般具有较多的共同点，其组成部分相似，==**如果产品之间**
**的差异性很大，则不适合使用建造者模式**==，因此其使用范围受到一定的限制。

6、如果产品的内部变化复杂，可能会导致需要定义很多具体建造者类来实现这种变化，导致系统变得很庞大，因此在这种情况下，要考虑是否选择建造者模式.

7、抽象工厂模式VS建造者模式抽象工厂模式实现对产品家族的创建，- 一个产品家族是这样的一系列产品:具有不同分类维度的产品组合，采用抽象工厂模式不需要关心构建过程，只关心什么产品由什么工厂生产即可。而建造者模式则是要求按照指定的蓝图建造产品，它的主要目的是通过组装零配件而产生-一个新产品，==不同产品使用工厂模式，类似产品使用建造者模式==



# 第 9 章 适配器设计模式

## 现实生活中的适配器例子

泰国插座用的是两孔的(欧标)，可以买个多功能转换插头(适配器)，这样就可以使用了。

![Snipaste_2020-10-04_15-52-51](images/Snipaste_2020-10-04_15-52-51.png)

##  基本介绍

1. 适配器模式(Adapter Pttern)将某个类的接口转换成客户端期望的另一个接口表示，**主的目的是兼容性**，让原本因接口不匹配不能一起工作的两个类可以协同工作。其别名为包装器(Wrapper)
2. 适配器模式属于结构型模式
3. 主要分为三类**:类适配器模式、对象适配器模式、接口适配器模式**



## 工作原理

1. 适配器模式:**将一个类的接口转换成另一种接口**.让原本接口不兼容的类可以兼容
2. 从用户的角度看不到被适配者，是解耦的
3. 用户调用适配器转化出来的目标接口方法，适配器再调用被适配者的相关接口方法
4. 用户收到反馈结果，感觉只是和目标接口交互，如图

![](images/Snipaste_2020-10-04_15-54-45.png)



##  类适配器模式

### 类适配器模式介绍

基本介绍: Adapter类， 通	过继承src类，实现dst类接口，完成src->dst的适配。

### 类适配器模式应用实例

1. 应用实例说明

   ​	外以生活中充电器的例子来讲解适配器，充电器本身相当于Adapter，220V 交流电相当于sre (即被适配者)，我们的目dst(即目标)是5V直流电

2. 思路分析(类图)

   ![](images/Snipaste_2020-10-04_15-56-04.png)

### 代码实现

####  适配接口

```java
//适配接口 用于手机充电的接口
public interface IVoltage5V {
	public int output5V();
}
```

####    被适配的类

```java
//被适配的类  
public class Voltage220V {
   //输出220V的电压
   public int output220V() {
      int src = 220;
      System.out.println("电压=" + src + "伏");
      return src;
   }
}
```

#### 适配器类(继承被适配者 实现适配接口)

```java
//适配器类
public class VoltageAdapter extends Voltage220V implements IVoltage5V {
   @Override
   public int output5V() {
      //获取到220V电压
      int srcV = output220V();
      int dstV = srcV / 44 ; //转成 5v
      return dstV;
   }

}
```

####  用户

```java
public class Phone {
	//充电
	public void charging(IVoltage5V iVoltage5V) {
		if(iVoltage5V.output5V() == 5) {
			System.out.println("电压为5V, 可以充电~~");
		} else if (iVoltage5V.output5V() > 5) {
			System.out.println("电压大于5V, 不能充电~~");
		}
	}
}
```

#### 测试

```java
public class Client {

   public static void main(String[] args) {
      System.out.println(" === 类适配器模式 ====");
      Phone phone = new Phone();
      phone.charging(new VoltageAdapter());
   }

}
```



###  类适配器模式注意事项和细节

1、Java是单继承机制，所以类适配器需要继承src类这一点算是一个缺点，因为这要中求dst必须是接口，有一定局限性;

2、 src类的方法在Adapter中都会暴露出来，也增加了使用的成本。

3、由于其继承了src类，所以它可以根据需求重写src类的方法，使得Adapter的灵
活性增强了。

## 对象适配器

1. 基本思路和类的适配器模式相同，只是将Adapter类作修改，不是继承src类，而是持有src类的实例，以解决
   兼容性的问题。即: 持有src类，实现dst类接口，完成src->dst的适配
2. 根据“**合成复用原则**’，在系统中尽量使用**关联关系(聚合)来替代继承**关系。
3. 对象适配器模式是适配器模式常用的一-种

###  对象适配器模式应用实例

1、应用实例说明
	以生活中充电器的例子来讲解适配器，充电器本身相当于Adapter, 220V交流电相当于src (即被适配者)，我们的目dst(即目标)是5V直流电，使用对象适配器模式完成。

2、思路分析(类图): 只需修改适配器即可，如下:

![](images/Snipaste_2020-10-04_16-00-27.png)

3、代码实现

![](images/Snipaste_2020-10-04_16-02-21.png)

### 实例代码

#### 接口

```java
//适配接口
public interface IVoltage5V {
   public int output5V();
}
```

#### 被适配类

```java
//被适配的类
public class Voltage220V {
   //输出220V的电压，不变
   public int output220V() {
      int src = 220;
      System.out.println("电压=" + src + "伏");
      return src;
   }
}
```

#### 适配器类

```java
//适配器类
public class VoltageAdapter  implements IVoltage5V {

   private Voltage220V voltage220V; // 关联关系-聚合
   //通过构造器，传入一个 Voltage220V 实例
   public VoltageAdapter(Voltage220V voltage220v) {
      
      this.voltage220V = voltage220v;
   }

   @Override
   public int output5V() {
      
      int dst = 0;
      if(null != voltage220V) {
         int src = voltage220V.output220V();//获取220V 电压
         System.out.println("使用对象适配器，进行适配~~");
         dst = src / 44;
         System.out.println("适配完成，输出的电压为=" + dst);
      }
      
      return dst;
   }
}
```

#### 用户

```java
public class Phone {

   //充电
   public void charging(IVoltage5V iVoltage5V) {
      if(iVoltage5V.output5V() == 5) {
         System.out.println("电压为5V, 可以充电~~");
      } else if (iVoltage5V.output5V() > 5) {
         System.out.println("电压大于5V, 不能充电~~");
      }
   }
}
```

#### 测试

```java
public class Client {
   public static void main(String[] args) {
      System.out.println(" === 对象适配器模式 ====");
      Phone phone = new Phone();
      phone.charging(new VoltageAdapter(new Voltage220V()));
   }

}
```

###  对象适配器模式注意事项和细节

1. 对象适配器和类适配器其实算是同一种思想，只不过实现方式不同。根据合成复用原则，使用组合替代继承，所以它解决 了类适配器必须继承src的局限性问题，也不再要求dst必须是接口。
2. 使用成本更低，更灵活。



## ==接口适配器==

1. 一-些书籍称为:适配器模式(DefaultAdapterPattern)或**缺省适配器模式**。
2. 当**不需要全部实现接口提供的方法**时，可先**设计一个抽象类**实现**接口**，并为该接.口中每个方法提供-一个**默认实现(空方法)**，那么该**抽象类的子类可有选择地覆盖父类的某些方法**来实现需求
3. 适用于一个接口不想使用其所有的方法的情况。



###  接口适配器模式应用实例

1. Android中的属性动画ValueAnimator类可以通过addListener(AnimatorListener listener)方法添加监听器，那么
   常规写法如右:

   ![](images/Snipaste_2020-10-04_16-06-06.png)

2. 有时候我们不想实现lAnimator.AnimatorListener接口的全部方法，我们只想监听onAnimationStart,我们会如下写

![](images/Snipaste_2020-10-04_16-06-01.png)

​	3.AnimatorListenerAdapter类，就是一个接口适配器，代码如右图:它空实现了Animator.AnimatorListener类(src)的所有方法.

![](images/Snipaste_2020-10-04_16-07-22.png)

​	4.AnimatorListener是一个接口.

![](images/Snipaste_2020-10-04_16-07-14.png)

5、程序里的匿名内部类就是Listener，具体实现类

![](images/Snipaste_2020-10-04_16-08-23.png)

### 类图

![](images/Snipaste_2020-10-04_16-09-09.png)

### 代码实现

```java
package com.atguigu.adapter.interfaceadapter;
public interface Interface4 {
    public void m1();
    public void m2();
    public void m3();
    public void m4();

}
```

```java
package com.atguigu.adapter.interfaceadapter;
public class AbsAdapter implements Interface4 {

    @Override
    public void m1() {

    }

    @Override
    public void m2() {

    }

    @Override
    public void m3() {

    }

    @Override
    public void m4() {

    }
}
```

```java
package com.atguigu.adapter.interfaceadapter;
public class Client {
    public static void main(String[] args) {
        AbsAdapter absAdapter = new AbsAdapter() {
            // 只需要覆盖我们需要使用 接口方法
            @Override
            public void m1() {
                System.out.println("使用了m1的方法");
            }
        };
        absAdapter.m1();
    }

}
```

##  适配器在SpringMVC框架应用的源码分析

1、SpringMvc中 的**HandlerAdapter**,就使用了适配器模式

2、SpringMVC处理 请求的流程回顾

3、使用HandlerAdapter的原因分析:

​	可以看到处理器的类型不同，有多实现方式，那么调用方式就不是确定的，如果需要直接调用**Controller**方法，需要调用的时候就得不断是使用**if else来**进行判断是哪一种子类然后执行。那么如果后面要扩展**Controller**,就得修改原来的代码，这样违背了**OCP**原则。

4、源码+Debug+分析

![](images/Snipaste_2020-10-04_16-11-56.png)

5、动手写SpringMVC通过适配器设计模式获取到对应的Controller源码

![](images/Snipaste_2020-10-04_16-12-52.png)

类图

![](images/Snipaste_2020-10-04_16-13-03.png)

## 适配器模式注意事项和细节

1. 三种命名方式，是根据src是以怎样的形式给到Adapter (在Adapter里的形式)来命名的。

2. 类适配器:以类给到，在Adapter里， 就是将src当做类， 继承
   	对象适配器:以对象给到，在Adapter里， 将src作为一个对象， 持有
   	接口适配器:以接口给到，在Adapter里， 将src作为一个接口， 实现

3. Adapter模式最大的作用还是将原本不兼容的接口融合在一起工作。

4. 实际开发中，实现起来不拘泥于我们讲解的**三种经典形式**

   

#  第10章 桥接模式

## 手机操作问题

现在对不同手机类型的 不同品牌实现操作编程(比如: 开机、关机、上网，打电话等)， 如图:

<img src="images/image-20211215141905804.png" alt="image-20211215141905804" style="zoom: 67%;" />

### 传统方案解决手机操作问题

![image-20211215142147604](images/image-20211215142147604.png)

### 传统方案解决手机操作问题分析

-  扩展性问题(类爆炸)，如果我们再增加手机的样式(旋转式)，就需要增加各个品 牌手机的类，同样如果我们增加一个手机品牌，也要在   各个手机样式类下增加。 
-  违反了单一职责原则，当我们增加手机样式时，要同时增加所有品牌的手机，这 样增加了代码维护成本. 
-  解决方案-使用桥接模式



## 桥接模式(Bridge)

### 基本介绍

1) 桥接模式(Bridge模式)是指：将实现与抽象放在两个不同的类层次中，使两个层 次可以独立改变。

 2) 是一种结构型设计模式

 3) Bridge模式基于类的最小设计原则，通过使用封装、聚合及继承等行为让不同 的类承担不同的职责。它的主要特点是把抽象(Abstraction)与行为实现 (Implementation)分离开来，从而可以保持各部分的独立性以及应对他们的功能 扩展



###  原理类图

![image-20211215142858698](images/image-20211215142858698.png)

### **原理类图说明：**

1.  Client类：桥接模式的调用者 
2.  抽象类(Abstraction) :维护了 Implementor / 即它的实现类ConcreteImplementorA.., 二者是聚合关系, Abstraction 充当 桥接类
3.  RefinedAbstraction：是Abstraction抽象类的子类
4.  Implementor：行为实现类的接口
5.  ConcreteImplementorA/B:行为的具体实现类
6.  从UML图：这里的抽象类和接口是聚合的关系，其实是调用和被调用关系 

## 桥接模式解决手机操作问题

使用**桥接模式**改进传统方式，让程序具有搞好的扩展性，利用程序维护

### 应用实例说明

<img src="images/image-20211215141905804.png" alt="image-20211215141905804" style="zoom: 67%;" />

### 思路分析-类图

<img src="images/image-20211215144139744.png" alt="image-20211215144139744" style="zoom: 67%;" />

### 代码实现

#### 接口

```java
public interface Brand{
    void open();
    void call();
    void close();
}
```

#### 接口的实现类

```java
public class XiaoMi implements Brand {
	@Override
	public void open() {
		System.out.println(" 小米手机开机 ");
	}
	@Override
	public void close() {
		System.out.println(" 小米手机关机 ");
	}
	@Override
	public void call() {
		System.out.println(" 小米手机打电话 ");
	}
}
//两个类写在一块了  一个类下面只能有一个public的类
public class Vivo implements Brand {
	@Override
	public void open() {
		System.out.println(" Vivo手机开机 ");
	}
	@Override
	public void close() {
		System.out.println(" Vivo手机关机 ");
	}
	@Override
	public void call() {
		System.out.println(" Vivo手机打电话 ");
	}
}
```

#### 抽象类

```java
public abstract class Phone {
	//组合品牌
	private Brand brand;
	//构造器
	public Phone(Brand brand) {
		super();
		this.brand = brand;
	}
	protected void open() { //调用手机的open方法
		this.brand.open();
	}
	protected void close() {
		brand.close();
	}
	protected void call() {
		brand.call();
	}
}
```

#### 泛化类（继承类）

```java
//折叠式手机类，继承 抽象类 Phone
public class FoldedPhone extends Phone {
	//构造器
	public FoldedPhone(Brand brand) {
		super(brand);
	}
	public void open() {
		super.open();
		System.out.println(" 折叠样式手机 ");
	}
	public void close() {
		super.close();
		System.out.println(" 折叠样式手机 ");
	}
	public void call() {
		super.call();
		System.out.println(" 折叠样式手机 ");
	}
}

public class UpRightPhone extends Phone {
		//构造器
		public UpRightPhone(Brand brand) {
			super(brand);
		}
		public void open() {
			super.open();
			System.out.println(" 直立样式手机 ");
		}
		public void close() {
			super.close();
			System.out.println(" 直立样式手机 ");
		}
		public void call() {
			super.call();
			System.out.println(" 直立样式手机 ");
		}
}

```

#### 调用类（测试类）

```java
public class Client {

	public static void main(String[] args) {
		
		//获取折叠式手机 (样式 + 品牌 )
		
		Phone phone1 = new FoldedPhone(new XiaoMi());
		
		phone1.open();
		phone1.call();
		phone1.close();
		
		System.out.println("=======================");
		
		Phone phone2 = new FoldedPhone(new Vivo());
		
		phone2.open();
		phone2.call();
		phone2.close();
		
		System.out.println("==============");
		
		UpRightPhone phone3 = new UpRightPhone(new XiaoMi());
		
		phone3.open();
		phone3.call();
		phone3.close();
		
		System.out.println("==============");
		
		UpRightPhone phone4 = new UpRightPhone(new Vivo());
		
		phone4.open();
		phone4.call();
		phone4.close();
	}

}
```

## 注意事项和细节

1. 实现了抽象和实现部分的分离，从而极大的提供了系统的灵活性，让抽象部分和实 现部分独立开来，这有助于系统进行分层设计，从而产生更好的结构化系统。 
2. 对于系统的高层部分，只需要知道抽象部分和实现部分的接口就可以了，其它的部 分由具体业务来完成。
3. ==**桥接模式替代多层继承方案**==，可以减少**子类的个数**，降低系统的管理和维护成本。
4. 桥接模式的引入增加了系统的理解和设计难度，由于聚合关联关系建立在抽象层， 要求开发者针对抽象进行设计和编程 
5. 桥接模式要求**正确识别出系统中两个独立变化的维度(抽象和实现)**，因此其使用范围有一定的局 限性，即需要有这样的应用场景。



## 其它应用场景

- 对于那些不希望使用继承或因为多层次继承导致系统类的个数急剧增加的系统，桥 接模式尤为适用.
- 常见的应用场景: 
  - JDBC驱动程序
  - 银行转账系统 
    - 转账分类: 网上转账，柜台转账，AMT转账 
    - 转账用户类型：普通用户，银卡用户，金卡用户.. 
  - 消息管理 
    - 消息类型：即时消息，延时消息 
    - 消息分类：手机短信，邮件消息，QQ消息..

# 第11章 装饰者模式

## 星巴克咖啡订单项目

1) 咖啡种类/单品咖啡：Espresso(意大利浓咖啡)、ShortBlack、LongBlack(美式 咖啡)、Decaf(无因咖啡) 

2) 调料：Milk、Soy(豆浆)、Chocolate 

3) 要求在扩展==新的咖啡种类==时，具有良好的扩展性、改动方便、维护方便 

4) 使用OO的来计算不同种类咖啡的==费用==: 客户可以点==单品咖啡==，也可以==单品咖啡+调料组合==。

### 方案1-解决星巴克咖啡订单项目

![image-20211215153157418](images/image-20211215153157418.png)

### 方案一问题分析

1) Drink 是一个抽象类，表示饮料

2) description就是对咖啡的描述, 比如咖啡的名字 

3) cost() 方法就是计算费用，Drink 类中做成一个抽象方法

4) Decaf 就是单品咖啡， 继承Drink, 并实现cost 

5) Espress && Milk 就是单品咖啡+调料， 这个组合很多 

6) 问题：这样设计，会有很多类，当我们增加一个单品咖啡，或者一个新的调料， 类的数量就会倍增，就会出现类爆炸

### 方案2-解决星巴克咖啡订单

前面分析到方案1因为**咖啡单品+调料** 组合会造成类的倍增，因此可以做改 进，将调料内置到Drink类，这样就**不会造成类数量过多**。从而提高项目 的维护性(如图)

![image-20211219230915569](images/image-20211219230915569.png)



**说明: milk,soy,chocolate 可以设计为 Boolean,表示是否要添加相应的调料.**

### 方案2-的问题分析

1) 方案2可以控制类的数量，不至于造成很多的类 

2) 在**增加或者删除调料种类**时，代码的维护量很大

3) 考虑到用户可以添加多份 调料时，可以将**hasMilk** 返回一个对应**int**

4) 考虑使用 装饰者 模式



## 装饰者模式定义

1) 装饰者模式：**动态**的将新功能==附加到对象上==。在对象功能扩展方面，它比继承更 有弹性，装饰者模式也体现了开闭原则(ocp) 

2) 这里提到的==动态的将新功能附加到对象==和==ocp原则==，在后面的应用实例上会以代 码的形式体现，请同学们注意体会。

## 装饰者模式原理

1) 装饰者模式就像打包一个快递 

- 主体：比如：陶瓷、衣服 (Component) // 被装饰者 
- 包装：比如：报纸填充、塑料泡沫、纸板、木板 (Decorator) 

2) Component 主体：比如类似前面的Drink

3) ConcreteComponent和Decorator 

- ConcreteComponent：具体的主体， 比如前面的各个单品咖啡	

- Decorator: 装饰者，比如各调料.  

4) 在如图的==Component与ConcreteComponent之间==，如果 ConcreteComponent类很多,还可以设计一个缓冲层，将共有的部分提取出来， 抽象层一个类。

![image-20211219231414982](images/image-20211219231414982.png)

## 装饰者模式解决星巴克咖啡订单

![image-20211215155724371](Java设计模式.assets/image-20211215155738344.png)

**说明**

-  Drink 类就是前面说的抽象类，Component 
-  ShortBlack 就单品咖啡 
-  Decorator 是一个装饰类，含有一个被装饰的对象(Drink obj) 
-  Decorator 的cost 方法 进行一个费用的叠加计算，递归的计算价格

###  2份巧克力+一份牛奶的LongBlack

<img src="images/image-20211215160958436.png" alt="image-20211215160958436" style="zoom:80%;" />

说明 

- Milk包含了LongBlack
- 一份Chocolate包含了(Milk+LongBlack) 
- 一份Chocolate包含了(Chocolate+Milk+LongBlack) 
- 这样不管是什么形式的单品咖啡+调料组合，通过递归方式可以方便的组合和维护。

### 应用实例代码

#### 抽象类

```java
public abstract class Drink {

	public String des; // 描述
	private float price = 0.0f;
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	//计算费用的抽象方法
	//子类来实现
	public abstract float cost();
	
}
```

#### 被装饰者

##### 缓冲层

```java
public class Coffee  extends Drink {
	@Override
	public float cost() {
		return super.getPrice();
	}
}
```

##### 咖啡类

```java
public class Espresso extends Coffee {
	
	public Espresso() {
		setDes(" 意大利咖啡 ");
		setPrice(6.0f);
	}
}

public class LongBlack extends Coffee { //美式咖啡

	public LongBlack() {
		setDes(" longblack ");
		setPrice(5.0f);
	}
}

public class DeCaf extends Coffee {

	public DeCaf() {
		setDes(" 无因咖啡 ");
		setPrice(1.0f);
	}
}

public class ShortBlack extends Coffee{
	public ShortBlack() {
		setDes(" shortblack ");
		setPrice(4.0f);
	}
}
```

#### 装饰者

##### 装饰类

```java
public class Decorator extends Drink {
	private Drink obj;
	
	public Decorator(Drink obj) { //聚合
		this.obj = obj;
	}
	
	@Override
	public float cost() {
		// getPrice 自己价格
		return super.getPrice() + obj.cost();
	}
	
	@Override
	public String getDes() {
		// obj.getDes() 输出被装饰者的信息
		return des + " " + getPrice() + " && " + obj.getDes();
	}
}
```

##### 调味品

```java
//具体的Decorator， 这里就是调味品
public class Chocolate extends Decorator {

	public Chocolate(Drink obj) {
		super(obj);
		setDes(" 巧克力 ");
		setPrice(3.0f); // 调味品 的价格
	}
}

public class Milk extends Decorator {

	public Milk(Drink obj) {
		super(obj);
		// TODO Auto-generated constructor stub
		setDes(" 牛奶 ");
		setPrice(2.0f); 
	}
}

public class Soy extends Decorator{
	public Soy(Drink obj) {
		super(obj);
		// TODO Auto-generated constructor stub
		setDes(" 豆浆  ");
		setPrice(1.5f);
	}
}
```

#### 客户端调用

```java
public class CoffeeBar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 装饰者模式下的订单：2份巧克力+一份牛奶的LongBlack

		// 1. 点一份 LongBlack
		Drink order = new LongBlack();
		System.out.println("费用1=" + order.cost());
		System.out.println("描述=" + order.getDes());

		// 2. order 加入一份牛奶
		order = new Milk(order);

		System.out.println("order 加入一份牛奶 费用 =" + order.cost());
		System.out.println("order 加入一份牛奶 描述 = " + order.getDes());

		// 3. order 加入一份巧克力

		order = new Chocolate(order);

		System.out.println("order 加入一份牛奶 加入一份巧克力  费用 =" + order.cost());
		System.out.println("order 加入一份牛奶 加入一份巧克力 描述 = " + order.getDes());

		// 3. order 加入一份巧克力

		order = new Chocolate(order);

		System.out.println("order 加入一份牛奶 加入2份巧克力   费用 =" + order.cost());
		System.out.println("order 加入一份牛奶 加入2份巧克力 描述 = " + order.getDes());
	
		System.out.println("===========================");
		
		Drink order2 = new DeCaf();
		
		System.out.println("order2 无因咖啡  费用 =" + order2.cost());
		System.out.println("order2 无因咖啡 描述 = " + order2.getDes());
		
		order2 = new Milk(order2);
		
		System.out.println("order2 无因咖啡 加入一份牛奶  费用 =" + order2.cost());
		System.out.println("order2 无因咖啡 加入一份牛奶 描述 = " + order2.getDes());

	
	}

}
```

## 装饰者模式在JDK应用的源码分析

**Java的IO结构，FilterInputStream就是一个装饰者**

![image-20211215165145773](images/image-20211215165145773.png)

```java
public abstract class InputStream implements Closeable{} //是一个抽象类，即Component
public class FilterInputStream extends InputStream { //是一个装饰者类Decorator
protected volatile InputStream in //被装饰的对象 }
class DataInputStream extends FilterInputStream implements DataInput { //FilterInputStream 子类，也继承了被装饰的对象in
```

### 举个例子

```java
public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		//说明
		//1. InputStream 是抽象类, 类似我们前面讲的 Drink
		//2. FileInputStream 是  InputStream 子类，类似我们前面的 DeCaf, LongBlack
		//3. FilterInputStream  是  InputStream 子类：类似我们前面 的 Decorator 修饰者
		//4. DataInputStream 是 FilterInputStream 子类，具体的修饰者，类似前面的 Milk, Soy 等
		//5. FilterInputStream 类 有  protected volatile InputStream in; 即含被装饰者
		//6. 分析得出在jdk 的io体系中，就是使用装饰者模式
		
		DataInputStream dis = new DataInputStream(new FileInputStream("d:\\abc.txt"));
		System.out.println(dis.read());
		dis.close();
	}
```



# 第12章 组合模式

## 学校院系展示需求

编写程序展示一个学校院系结构：需求是这样，要在一个页面中展示出学校的院系 组成，一个学校有多个学院，一个学院有多个系。如图：

<img src="images/image-20211215190157753.png" alt="image-20211215190157753" style="zoom: 67%;" />

### 12.1.1传统方案解决学校院系展示(类图) 

<img src="images/image-20211215190426861.png" alt="image-20211215190426861" style="zoom:67%;" />

### 12.1.2传统方案解决学校院系展示存在的问题分析

- 将学院看做是学校的子类，系是学院的子类，这样实际上是站在组织大小来进行分 层次的
- **实际上我们的要求**是 ：在一个页面中展示出学校的院系组成，一个学校有多个 学院，一个学院有多个系， 因此这种方案，不能很好实现的**管理的**操作，比如 对学院、系的添加，删除，遍历等 
- 解决方案：把学校、院、系==都看做==是组织结构，他们之间没有继承的关系，而是 一个树形结构，可以更好的实现管理操作。 => 组合模式



## 组合模式

### 组合介绍

1. 组合模式（Composite Pattern），又叫部分整体模式，它创建了对象组的树形结 构，将对象组合成树状结构以表示**“整体-部分**”的层次关系。 
2. 组合模式依据树形结构来组合对象，用来表示部分以及整体层次。 
3. 这种类型的设计模式属于结构型模式。
4. 组合模式使得用户对单个对象和组合对象的访问具有一致性，即：==组合能让客户以一致的方式处理个别对象以及组合对象==

### 组合模式原理类图

<img src="images/image-20211216151706897.png" alt="image-20211216151706897" style="zoom:80%;" />

**说明**

1.  Component :这是组合中对象声明接口，在适当情况下，实现所有类共有的接口默认行为,用于访问和管理Component 子 部件, Component 可以是抽象类或者接口
2.  leaf：在组合中表示叶子结点，叶子结点没有子节点
3.  commposite：非叶子结点，用于存储子部件，在commponent接口中实现 子部件的相关操作，比如增加，删除

### 组合模式解决的问题

- 组合模式解决这样的问题，当我们的要处理的对象可以生成一颗树形结构，而 我们要对树上的节点和叶子进行操作时，它能够提供一致的方式，而不用考虑 它是节点还是叶子  
- 对应的示意图

<img src="images/image-20211215191226900.png" alt="image-20211215191226900" style="zoom: 67%;" />

### 代码实现

<img src="images/image-20211216155054600.png" alt="image-20211216155054600" style="zoom:80%;" /> 

####  抽象类（最顶级的可以使抽象类也可以是接口）

```java
public abstract class OrganizationComponent {

   private String name; // 名字
   private String des; // 说明
   
   protected  void add(OrganizationComponent organizationComponent) {
      //默认实现
      throw new UnsupportedOperationException();
   }
   
   protected  void remove(OrganizationComponent organizationComponent) {
      //默认实现
      throw new UnsupportedOperationException();
   }

   //构造器
   public OrganizationComponent(String name, String des) {
      super();
      this.name = name;
      this.des = des;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getDes() {
      return des;
   }

   public void setDes(String des) {
      this.des = des;
   }
   
   //方法print, 做成抽象的, 子类都需要实现
   protected abstract void print();
   
   
}
```

####  大学

```java
//University 就是 Composite , 可以管理College
public class University extends OrganizationComponent {

   List<OrganizationComponent> organizationComponents = new ArrayList<OrganizationComponent>();

   // 构造器
   public University(String name, String des) {
      super(name, des);
   }

   // 重写add
   @Override
   protected void add(OrganizationComponent organizationComponent) {
      organizationComponents.add(organizationComponent);
   }

   // 重写remove
   @Override
   protected void remove(OrganizationComponent organizationComponent) {
      organizationComponents.remove(organizationComponent);
   }

   @Override
   public String getName() {
      return super.getName();
   }

   @Override
   public String getDes() {
      return super.getDes();
   }

   // print方法，就是输出University 包含的学院
   @Override
   protected void print() {
      System.out.println("--------------" + getName() + "--------------");
      //遍历 organizationComponents 
      for (OrganizationComponent organizationComponent : organizationComponents) {
         organizationComponent.print();
      }
   }

}
```

####  学院

```java
public class College extends OrganizationComponent {

   //List 中 存放的Department
   List<OrganizationComponent> organizationComponents = new ArrayList<OrganizationComponent>();

   // 构造器
   public College(String name, String des) {
      super(name, des);
   }

   // 重写add
   @Override
   protected void add(OrganizationComponent organizationComponent) {
      //  将来实际业务中，Colleage 的 add 和  University add 不一定完全一样
      organizationComponents.add(organizationComponent);
   }

   // 重写remove
   @Override
   protected void remove(OrganizationComponent organizationComponent) {
      organizationComponents.remove(organizationComponent);
   }

   @Override
   public String getName() {
      return super.getName();
   }

   @Override
   public String getDes() {
      return super.getDes();
   }

   // print方法，就是输出University 包含的学院
   @Override
   protected void print() {
      System.out.println("--------------" + getName() + "--------------");
      //遍历 organizationComponents 
      for (OrganizationComponent organizationComponent : organizationComponents) {
         organizationComponent.print();
      }
   }
   }
```

####  系

```java
public class Department extends OrganizationComponent {
   //没有集合
   public Department(String name, String des) {
      super(name, des);
   }
   //add , remove 就不用写了，因为他是叶子节点
   @Override
   public String getName() {
      return super.getName();
   }
   
   @Override
   public String getDes() {
      return super.getDes();
   }
   
   @Override
   protected void print() {
      System.out.println(getName());
   }
}
```

#### 调用者

```java
public class Client {

   public static void main(String[] args) {
      // TODO Auto-generated method stub
      
      //从大到小创建对象 学校
      OrganizationComponent university = new University("清华大学", " 中国顶级大学 ");
      
      //创建 学院
      OrganizationComponent computerCollege = new College("计算机学院", " 计算机学院 ");
      OrganizationComponent infoEngineercollege = new College("信息工程学院", " 信息工程学院 ");
      
      
      //创建各个学院下面的系(专业)
      computerCollege.add(new Department("软件工程", " 软件工程不错 "));
      computerCollege.add(new Department("网络工程", " 网络工程不错 "));
      computerCollege.add(new Department("计算机科学与技术", " 计算机科学与技术是老牌的专业 "));
      
      //
      infoEngineercollege.add(new Department("通信工程", " 通信工程不好学 "));
      infoEngineercollege.add(new Department("信息工程", " 信息工程好学 "));
      
      //将学院加入到 学校
      university.add(computerCollege);
      university.add(infoEngineercollege);
      
      //university.print();
      infoEngineercollege.print();
   }

}
```



## 组合模式在JDK集合的源码分析

1) Java的集合类-HashMap就使用了组合模式 

2) 代码分析+Debug 源码

![image-20211215191436213](images/image-20211215191436213.png)

<img src="images/image-20211216160832424.png" alt="image-20211216160832424" style="zoom: 80%;" />

```java
	public static void main(String[] args) {
		
		//说明
		//1. Map 就是一个抽象的构建 (类似我们的Component)
		//2. HashMap是一个中间的构建(Composite), 实现/继承了相关方法
		//   put, putall 
		//3. Node 是 HashMap的静态内部类，类似Leaf叶子节点, 这里就没有put, putall
		//   static class Node<K,V> implements Map.Entry<K,V>
		
		Map<Integer,String> hashMap=new HashMap<Integer,String>();
		hashMap.put(0, "东游记");//直接存放叶子节点(Node)
		
		Map<Integer,String> map=new HashMap<Integer,String>();
		map.put(1, "西游记");
		map.put(2, "红楼梦"); //..
		hashMap.putAll(map);
		System.out.println(hashMap);

	}
```



## 组合模式的注意事项和细节

1. 简化客户端操作。客户端只需要面对一致的对象而不用考虑整体部分或者节点叶子 的问题。 
2. 具有较强的扩展性。当我们要更改组合对象时，我们只需要调整内部的层次关系， 客户端不用做出任何改动.
3. 方便创建出复杂的层次结构。客户端不用理会组合里面的组成细节，容易添加节点 或者叶子从而创建出复杂的树形结构 
4. 需要遍历组织机构，或者处理的对象具有树形结构时, 非常适合使用组合模式. 
5. 要求较高的抽象性，==**如果节点和叶子有很多差异性的话**==，比如很多方法和属性 都不一样，不适合使用组合模式



# 第13章 ==外观模式(最简单)==

## 影院管理项目

组建一个家庭影院：

 DVD播放器、投影仪、自动屏幕、环绕立体声、爆米花机,要求完成使用家庭影院的 功能，

其过程为： 

• 直接用遥控器：统筹各设备开关 

• 开爆米花机 

• 放下屏幕 

• 开投影仪 

• 开音响 

• 开DVD，选dvd 

• 去拿爆米花 

• 调暗灯光 

• 播放 

• 观影结束后，关闭各种设备

### 13.1.1 使用传统方式解决问题

![image-20211216165032718](images/image-20211216165032718.png)

### 13.1.2 传统方式解决影院管理问题分析

1. 在ClientTest 的main方法中，创建各个子系统的对象，并直接去调用子系统(对象) 相关方法，会造成调用过程混乱，没有清晰的过程 
2. 不利于在ClientTest 中，去维护对子系统的操作 
3. 解决思路：定义一个高层接口，给子系统中的一组接口提供一个==**一致的界面(比 如在高层接口提供四个方法 ready, play, pause, end** )==，用来访问子系统中的 一群接口 
4. 也就是说 就是通过定义一个一致的接口(界面类)，用以屏蔽内部子系统的细节， 使得调用端只需跟这个接口发生调用，而无需关心这个子系统的内部细节 => 外观 模式

## 外观模式(Facade)

### 基本介绍

1) ==外观模式（Facade）==，也叫“过程模式：外观模式为子系统中的一组接口提供 一个一致的界面，此模式定义了一个高层接口，这个接口使得这一子系统更加 容易使用 

2) 外观模式通过定义一个一致的接口，用以屏蔽内部子系统的细节，使得调用端 只需跟这个接口发生调用，而无需关心这个子系统的内部细节

### 原理类图

<img src="images/image-20211216165424146.png" alt="image-20211216165424146" style="zoom:80%;" />

**原理类图的说明(外观模式的角色)** 

1) **外观类(Facade)**: 为调用端提供统一的调用接口, 外观类知道哪些子系统负责处理请求,从而将调用端的请求代理给适当 子系统对象 

2) **调用者(Client)**: 外观接口的调用者 

3) **子系统的集合**：指模块或者子系统，处理Facade 对象指派的任务，他是功能的实际提供者



##  外观模式解决影院管理

###  传统方式解决影院管理说明

1) 外观模式可以理解为转换一群接口，客户只 要调用一个接口，而不用调用多个接口才能 达到目的。比如：在pc上安装软件的时候经 常有一键安装选项（省去选择安装目录、安 装的组件等等），还有就是手机的重启功能 （把关机和启动合为一个操作）。

2) **外观模式就是解决多个复杂接口带来的使用 困难，起到简化用户操作的作用** 

3) 示意图说明

<img src="images/image-20211216165743217.png" alt="image-20211216165743217" style="zoom:80%;" />

由子系统去处理复杂的模块

###  外观模式应用实例

<img src="images/image-20211216165826049.png" alt="image-20211216165826049" style="zoom:80%;" />

### 代码

#### 子系统

```java
package com.atguigu.facade;
//爆米花机
public class Popcorn {
	//构造器私有化
	private Popcorn(){
		
	}
	//使用单例模式创建对象
	private static Popcorn instance = new Popcorn();
	
	//获取实例
	public static Popcorn getInstance() {
		return instance;
	}
	
	public void on() {
		System.out.println(" popcorn on ");
	}
	
	public void off() {
		System.out.println(" popcorn ff ");
	}
	
	public void pop() {
		System.out.println(" popcorn is poping  ");
	}
}
```

```java
public class Screen {
	private Screen(){ }

	private static Screen instance = new Screen();
	
	public static Screen getInstance() {
		return instance;
	}
	

	public void up() {
		System.out.println(" Screen up ");
	}
	
	public void down() {
		System.out.println(" Screen down ");
	}
	
}

```

为了代码看起来少，只写了两个类



#### 外观类（通过此类来调用各个子系统）

```java
//外观类 通过此对象来调用各个子系统
public class HomeTheaterFacade {
   
   //定义各个子系统对象
   private Popcorn popcorn;
   private Screen screen;

   //构造器
   public HomeTheaterFacade() {
      super();
      this.popcorn = Popcorn.getInstance();
      this.screen = Screen.getInstance();
   }

   //操作分成几步就可以了
   
   public void ready() {
      popcorn.on();
      popcorn.pop();
      screen.down();
   }
   
   public void end() {
      popcorn.off();
      screen.up();
   }
}
```

##  外观模式在MyBatis框架应用的源码分析

![image-20211219150036840](images/image-20211219150036840.png)

<img src="images/image-20211219145432583.png" alt="image-20211219145432583" style="zoom:80%;" />

## 外观模式的注意事项和细节

1. 外观模式**对外屏蔽了子系统的细节**，因此外观模式降低了客户端对子系统使用的复 杂性 
2. 外观模式对客户端与子系统的耦合关系==（解耦）==，让子系统内部的模块更易维护和扩展 
3. 通过合理的使用外观模式，可以帮我们更好的**划分访问的层次** 
4. 当系统需要进行分层设计时，可以考虑使用**Facade**模式 
5. 在维护一个遗留的大型系统时，可能这个系统已经变得非常难以维护和扩展，此时 可以考虑为新系统开发一个**Facade**类，来提供遗留系统的比较清晰简单的接口， 让新系统与**Facade**类交互，提高复用性 
6. 不能过多的或者不合理的使用外观模式，使用外观模式好，还是直接调用模块好。 要以让系统有层次，利于维护为目的



# 第14章 享元模式

==常应用在string上和连接池==

## 展示网站项目需求

小型的外包项目，给客户A做一个产品展示网站，客户A的朋友感觉效果不错，也希 望做这样的产品展示网站，但是要求都有些不同： 

1) 有客户要求以**新闻**的形式发布 

2) 有客户人要求以**博客**的形式发布 

3) 有客户希望以**微信公众号**的形式发布

### 传统方案解决网站展现项目

1) 直接复制粘贴一份，然后根据客户不同要求，进行定制修改 

2) 给每个网站租用一个空间 

3) 方案设计示意图 

<img src="images/image-20211219151046876.png" alt="image-20211219151046876" style="zoom:67%;" />

### 14.1.2传统方案解决网站展现项目-问题分析

1) 需要的网站结构**相似度很高**，而且都不是高访问量网站，如果分成多个虚拟空间来 处理，相当于一个相同网站的实例对象很多，造成服务器的资源浪费 

2) 解决思路：整合到一个网站中，共享其相关的代码和数据，对于硬盘、内存、**CPU**、 数据库空间等服务器资源都可以达成共享，减少服务器资源 

3) 对于代码来说，由于是一份实例，维护和扩展都更加容易 

4) 上面的解决思路就可以使用**==享元模式==** 来解决



##  享元模式

###  基本介绍

1. 享元模式（Flyweight Pattern） 也叫 ==蝇量模式==: 运 用共享技术有效地支持大量细粒度的对象 
2. 常用于系统底层开发，解决系统的性能问题。像 **数据库连接池**，里面都是创建好的连接对象，在 这些连接对象中有我们需要的则直接拿来用，避 免重新创建，如果没有我们需要的，则创建一个 
3. 享元模式能够解决**重复对象的内存浪费的问题**， 当系统中有大量相似对象，需要缓冲池时。不需 总是创建新对象，可以从缓冲池里拿。这样可以 降低系统内存，同时提高效率 
4. 享元模式**经典的应用场景**就是池技术了，String常 量池、数据库连接池、缓冲池等等都是享元模式 的应用，享元模式是池技术的重要实现方式

<img src="images/image-20211219152046521.png" alt="image-20211219152046521" style="zoom:67%;" />

### 享元模式的原理类图

​	==单例模式是整个应用系统共用一个实例对象
​		享元模式是整个系统共用好几个同类型对象
连接池本身是单例模式,连接池里的多个连接对象是享元模式
而且享元模式的共享对象是按需分配的，如果不够还会再创建！
而单例模式绝对不会重复创建第二个对象，这是本质不同！==

<img src="images/image-20211219153437400.png" alt="image-20211219153437400" style="zoom:67%;" />

1. FlyWeight 是抽象的享元角色, 他是产品的抽象类, 同时定义出对象的**外部状态**和**内部状态**(后面介绍) 的接口或实现 
2. ConcreteFlyWeight 是具体的享元角色，是具体的产品类，实现抽象角色定义相关业务
3. UnshareConcreteFlyweight 是不可共享的角色，一般不会出现在享元工厂
4. FlyweightFactory 享元工厂类，用于构建一个池容器(集合)   同时提供从池中获取对象方法

###  内部状态和外部状态

比如围棋、五子棋、跳棋，它们都有大量的棋子对象，围棋和五子棋只有黑白两色，跳棋颜色多一 点，所以棋子颜色就是棋子的内部状态；而各个棋子之间的差别就是位置的不同，当我们落子后， 落子颜色是定的，但位置是变化的，所以棋子坐标就是棋子的外部状态 

1) 享元模式提出了两个要求：细粒度和共享对象。这里就涉及到内部状态和外部状态 了，即将对象的信息分为两个部分：内部状态和外部状态 

2) **内部状态**指==对象共享出来的信息==，存储在享元对象内部且不会随环境的改变而改变 

3) **外部状态**指对象得以依赖的一个标记，是随环境改变而改变的、==不可共享的状态==。 

4) 举个例子：围棋理论上有361个空位可以放棋子，每盘棋都有可能有两三百个棋子对 象产生，因为内存空间有限，一台服务器很难支持更多的玩家玩围棋游戏，如果用 享元模式来处理棋子，那么棋子对象就可以减少到只有两个实例，这样就很好的解 决了对象的开销问题



## 享元模式解决网站展现项目

### 类图

<img src="images/image-20211219155419013.png" alt="image-20211219155419013" style="zoom: 80%;" />

### 代码

#### 抽象类

```java
public abstract class WebSite {

   public abstract void use(User user);//抽象方法
}
```

#### 外部状态

```java
public class User {
   
   private String name;
   public User(String name) {
      this.name = name;
   }
   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }
}
```

#### 具体网站

```java
//具体网站
public class ConcreteWebSite extends WebSite {

   //共享的部分，内部状态
   private String type = ""; //网站发布的形式(类型)

   //构造器
   public ConcreteWebSite(String type) {
     this.type = type;
   }
   @Override
   public void use(User user) {
      System.out.println("网站的发布形式为:" + type + " 在使用中 .. 使用者是" + user.getName());
   }
}
```

#### 充当池的角色（起缓存的作用）

```java
// 网站工厂类，根据需要返回压一个网站
public class WebSiteFactory {
   //集合， 充当池的作用
   private HashMap<String, ConcreteWebSite> pool = new HashMap<>();
   
   //根据网站的类型，返回一个网站, 如果没有就创建一个网站，并放入到池中,并返回
   public WebSite getWebSiteCategory(String type) {
      if(!pool.containsKey(type)) {
         //就创建一个网站，并放入到池中
         pool.put(type, new ConcreteWebSite(type));
      }
      return (WebSite)pool.get(type);
   }
   
   //获取网站分类的总数 (池中有多少个网站类型)
   public int getWebSiteCount() {
      return pool.size();
   }
}
```

#### 使用者

```java
//享元模式
public class Client {

   public static void main(String[] args) {
      // 创建一个工厂类
      WebSiteFactory factory = new WebSiteFactory();

      // 客户要一个以新闻形式发布的网站
      WebSite webSite1 = factory.getWebSiteCategory("新闻");  
      webSite1.use(new User("tom"));

      // 客户要一个以博客形式发布的网站
      WebSite webSite2 = factory.getWebSiteCategory("博客");
      webSite2.use(new User("jack"));

      // 客户要一个以博客形式发布的网站
      WebSite webSite3 = factory.getWebSiteCategory("博客");
      webSite3.use(new User("smith"));

      // 客户要一个以博客形式发布的网站
      WebSite webSite4 = factory.getWebSiteCategory("博客");
	  webSite4.use(new User("king"));
      
      System.out.println("网站的分类共=" + factory.getWebSiteCount());//2
   }

}
```



## 享元模式在JDK-Interger的应用源码分析

![image-20211219160134481](images/image-20211219160134481.png)

```java
public static void main(String[] args) {
		//如果 Integer.valueOf(x) x 在  -128 --- 127 直接，就是使用享元模式返回,如果不在
		//范围类，则仍然 new 
		
		//小结:
		//1. 在valueOf 方法中，先判断值是否在 IntegerCache 中，如果不在，就创建新的Integer(new), 否则，就直接从 缓存池返回
		//2. valueOf 方法，就使用到享元模式
		//3. 如果使用valueOf 方法得到一个Integer 实例，范围在 -128 - 127 ，执行速度比 new 快
		
		Integer x = Integer.valueOf(127); // 得到 x实例，类型 Integer
		Integer y = new Integer(127); // 得到 y 实例，类型 Integer
		Integer z = Integer.valueOf(127);//..
		Integer w = new Integer(127);
		
		System.out.println(x.equals(y)); // 大小，true
		System.out.println(x == y ); //  false
		System.out.println(x == z ); // true
		System.out.println(w == x ); // false
		System.out.println(w == y ); // false
		
		Integer x1 = Integer.valueOf(200);//不在-128--127之间
		Integer x2 = Integer.valueOf(200);
		System.out.println("x1==x2是否相等:" + (x1 == x2)); // false
	}
```



##  享元模式的注意事项和细节

- 在享元模式这样理解，**“享”就表示共享，“元”表示对象** 
- 系统中有大量对象，这些对象消耗大量内存，并且对象的状态大部分可以外部化时， 我们就可以考虑选用享元模式 
- 用唯一标识码判断，如果在内存中有，则返回这个唯一标识码所标识的对象，用 HashMap/HashTable存储 
- 享元模式大大**减少了对象的创建，降低了程序内存的占用，提高效率** 
- 享元模式**提高了系统的复杂度**。需要**分离出内部状态和外部状态**，而外部状态具有 固化特性，不应该随着内部状态的改变而改变，这是我们使用享元模式需要注意的 地方. 
- 使用享元模式时，注意划分内部状态和外部状态，并且需要有一个工厂类加以控制。 
- 享元模式经典的**应用场景**是需要缓冲池的场景，比如 String常量池、数据库连接池

# 第15章 代理模式(Proxy)

## 代理模式基本介绍

- 代理模式：为一个对象提供一个替身，以控制对这个对象的访问。即通过代理 对象访问目标对象.这样做的好处是:可以在目标对象实现的基础上,增强额外的 功能操作,即扩展目标对象的功能。 
- 被代理的对象可以是远程对象、创建开销大的对象或需要安全控制的对象 
- 代理模式有不同的形式, 主要有三种 **静态代理、动态代理 (JDK代理/接口代 理)和 Cglib代理 (可以在内存动态的创建对象，而不需要实现接口， 他是属于 动态代理的范畴)** 。 
- <img src="images/image-20211220143855694.png" alt="image-20211220143855694" style="zoom:80%;" />

##  静态代理

### 基本介绍

静态代理在使用时,需要定义接口或者父类,被代理对象(即目标对象)与代理对象一 起实现相同的接口或者是继承相同父类

###  应用实例

具体要求 

1) 定义一个接口:ITeacherDao 

2) 目标对象TeacherDAO实现接口ITeacherDAO 

3) 使用静态代理方式,就需要在代理对象TeacherDAOProxy中也实现ITeacherDAO 

4) 调用的时候通过调用代理对象的方法来调用目标对象. 

5) 特别提醒：代理对象与目标对象要实现相同的接口,然后通过调用相同的方法来 调用目标对象的方法。

### 代码实现

#### 类图

<img src="images/image-20211220144253098.png" alt="image-20211220144253098" style="zoom:80%;" />

#### 接口

```java
//接口
public interface ITeacherDao {
   void teach(); // 授课的方法
}
```

#### 被代理类

```java
public class TeacherDao implements ITeacherDao {
   @Override
   public void teach() {
      System.out.println(" 老师授课中  。。。。。");
   }
}
```

#### 代理类

```java
//代理对象,静态代理
public class TeacherDaoProxy implements ITeacherDao{
   
   private ITeacherDao target; // 目标对象，通过接口来聚合

   //构造器
   public TeacherDaoProxy(ITeacherDao target) {
      this.target = target;
   }

   @Override
   public void teach() {
      System.out.println("开始代理  完成某些操作。。。。。 ");//方法
      target.teach();
      System.out.println("提交。。。。。");//方法
   }
}
```

#### 调用

```java
public class Client {

    public static void main(String[] args) {
        //创建目标对象(被代理对象)
        TeacherDao teacherDao = new TeacherDao();

        //创建代理对象, 同时将被代理对象传递给代理对象
        TeacherDaoProxy teacherDaoProxy = new TeacherDaoProxy(teacherDao);

        //通过代理对象，调用到被代理对象的方法
        //即：执行的是代理对象的方法，代理对象再去调用目标对象的方法 
        teacherDaoProxy.teach();
    }
}
```

###  静态代理优缺点

1) 优点：在不修改目标对象的功能前提下, 能通过代理对象对目标功能扩展 

2) 缺点：因为代理对象需要与目标对象实现一样的接口,所以会有很多代理类 

3) 一旦接口增加方法,目标对象与代理对象都要维护



##  动态代理

###  基本介绍

1) 代理对象,不需要实现接口，但是目标对象要实现接口，否则不能用动态代理 

2) 代理对象的生成，是利用JDK的API，动态的在内存中构建代理对象 

3) 动态代理也叫做：JDK代理、接口代理

###  JDK中生成代理对象的API

1) 代理类所在包:java.lang.reflect.Proxy 

2) JDK实现代理只需要使用newProxyInstance方法,但是该方法需要接收三个参数,完 整的写法是:  static Object newProxyInstance(ClassLoader loader, Class[]  interfaces,InvocationHandler h )

###  动态代理实例

#### 类图

<img src="images/image-20211220145456097.png" alt="image-20211220145456097" style="zoom:80%;" />

#### 接口

```java
//接口
public interface ITeacherDao {

   void teach(); // 授课方法
   void sayHello(String name);
}
```

#### 被代理类

```java
public class TeacherDao implements ITeacherDao {

   @Override
   public void teach() {
      System.out.println(" 老师授课中.... ");
   }

   @Override
   public void sayHello(String name) {
      System.out.println("hello " + name);
   }
   
}
```

#### 动态代理类

```java
public class ProxyFactory {

   //维护一个目标对象 , Object
   private Object target;

   //构造器  对target 进行初始化
   public ProxyFactory(Object target) {
      this.target = target;
   } 
   
   //给目标对象 生成一个代理对象
   public Object getProxyInstance() {
      //说明 JDK中的代理方法
      /*
       *  public static Object newProxyInstance(ClassLoader loader,
                                          Class<?>[] interfaces,
                                          InvocationHandler h)
                                          
            //1. ClassLoader loader ： 指定当前目标对象使用的类加载器, 获取加载器的方法固定
            //2. Class<?>[] interfaces: 目标对象实现的接口类型，使用泛型方法确认类型
            //3. InvocationHandler h : 事情处理，执行目标对象的方法时，会触发事情处理器方法, 会把当前执行的目标对象方法作为参数传入
       */
      return Proxy.newProxyInstance(target.getClass().getClassLoader(), 
            target.getClass().getInterfaces(), 
            new InvocationHandler() {
               
               @Override
               public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                  System.out.println("JDK代理开始~~");
                  //反射机制调用目标对象的方法
                  Object returnVal = method.invoke(target, args);
                  System.out.println("JDK代理提交");
                  return returnVal;
               }
            }); 
   }
   
}
```

#### 测试

```java
public class Client {
   public static void main(String[] args) {
      //创建目标对象
      ITeacherDao target = new TeacherDao();
      
      //给目标对象，创建代理对象, 可以转成 ITeacherDao
      ITeacherDao proxyInstance = (ITeacherDao)new ProxyFactory(target).getProxyInstance();
   
      // proxyInstance=class com.sun.proxy.$Proxy0 内存中动态生成了代理对象
      System.out.println("proxyInstance=" + proxyInstance.getClass());
      
      //通过代理对象，调用目标对象的方法
      //proxyInstance.teach();
      
      proxyInstance.sayHello(" tom ");
   }
}
```

##  Cglib代理

###  基本介绍

1. 静态代理和JDK代理模式都要求目标对象是实现一个接口,但是有时候目标对象只 是一个单独的对象,并没有实现任何的接口,这个时候可使用目标对象子类来实现 代理-这就是Cglib代理 

2. Cglib代理也叫作子类代理,它是在内存中构建一个子类对象从而实现对目标对象功 能扩展, 有些书也将Cglib代理归属到动态代理。 

3. Cglib是一个强大的高性能的代码生成包,它可以在运行期扩展java类与实现java接 口.它广泛的被许多AOP的框架使用,例如Spring AOP，实现方法拦截 

4. 在AOP编程中如何选择代理模式： 

   1. ==目标对象**需要实现接口**，用JDK代理==
   2. ==目标对象**不需要实现接口**，用Cglib代理== 
5. Cglib包的底层是通过使用字节码处理框架ASM来转换字节码并生成新的类

###  Cglib代理模式实现步骤

####  需要引入cglib的jar文件

<img src="images/image-20211219165456243.png" style="zoom: 80%;" />



#### 在内存中动态构建子类，

注意代理的类**不能为final**，否则报错 java.lang.IllegalArgumentException:  

#### 目标对象的方法

如果为final/static,那么就不会被拦截,即不会执行目标对象额外的 业务方法

### Cglib代理模式应用实例

#### 类图

<img src="images/image-20211220152611574.png" alt="image-20211220152611574" style="zoom: 80%;" />

#### 被代理类

```java
public class TeacherDao {

   public String teach() {
      System.out.println(" 老师授课中  ， 我是cglib代理，不需要实现接口 ");
      return "hello";
   }
}
```

#### cglib代理

```java
public class ProxyFactory implements MethodInterceptor {
   //维护一个目标对象
   private Object target;
   
   //构造器，传入一个被代理的对象
   public ProxyFactory(Object target) {
      this.target = target;
   }

   //返回一个代理对象:  是 target 对象的代理对象
   public Object getProxyInstance() {
      //1. 创建一个工具类
      Enhancer enhancer = new Enhancer();
      //2. 设置父类
      enhancer.setSuperclass(target.getClass());
      //3. 设置回调函数
      enhancer.setCallback(this);
      //4. 创建子类对象，即代理对象
      return enhancer.create();
      
   }

   //重写  intercept 方法，会调用目标对象的方法
   @Override
   public Object intercept(Object arg0, Method method, Object[] args, MethodProxy arg3) throws Throwable {
      System.out.println("Cglib代理模式 ~~ 开始");
      Object returnVal = method.invoke(target, args);
      System.out.println("Cglib代理模式 ~~ 提交");
      return returnVal;
   }

}
```

#### 测试

```java
public class Client {
   public static void main(String[] args) {
      //创建目标对象
      TeacherDao target = new TeacherDao();
      //获取到代理对象，并且将目标对象传递给代理对象
      TeacherDao proxyInstance = (TeacherDao)new ProxyFactory(target).getProxyInstance();

      //执行代理对象的方法，触发intecept 方法，从而实现 对目标对象的调用
      String res = proxyInstance.teach();
      System.out.println("res=" + res);
   }
}
```

##  代理模式(Proxy)的变体

###  防火墙代理 

内网通过代理穿透防火墙，实现对公网的访问。 

###  缓存代理 

比如：当请求图片文件等资源时，先到缓存代理取，如果取到资源则ok,如果取不到资源， 再到公网或者数据库取，然后缓存。 

###  远程代理 

远程对象的本地代表，通过它可以**把远程对象当本地对象来调用**。远程代理通过网络和 真正的远程对象沟通信息。 

<img src="images/image-20211219165757076.png" alt="image-20211219165757076" style="zoom:80%;" />

###  同步代理

主要使用在多线程编程中，完成多线程间同步工作



# 第16章  模板模式

##  豆浆制作问题

1. 制作豆浆的流程 选材--->添加配料--->浸泡--->放到豆浆机打碎 
2. 通过添加不同的配料，可以制作出不同口味的豆浆 
3. 选材、浸泡和放到豆浆机打碎这几个步骤对于制作每种口味的豆浆都是一样的 （红豆、花生豆浆。。。。）
4. 请使用 ==**模板方法模式**== 完成 (说明：因为模板方法模式，比较简单，很容易就 想到这个方案，因此就直接使用，不再使用传统的方案来引出模板方法模式 )



##  模板方法模式

###  基本介绍

- 模板方法模式（Template Method Pattern），又叫模板模式(Template Pattern)， 在一个抽象类公开定义了执行它的方法的模板。它的子类可以按需要重写方法 实现，但调用将以抽象类中定义的方式进行。 
- 简单说，模板方法模式 定义一个操作中的算法的骨架，而将一些步骤延迟到子 类中，使得子类可以不改变一个算法的结构，就可以重定义该算法的某些特定 步骤 
- 这种类型的设计模式属于**行为型模式**。

###  类图

<img src="images/image-20211220191323567.png" alt="image-20211220191323567" style="zoom:80%;" />

对原理类图的说明-即(模板方法模式的角色及职责) 

1. AbstractClass 抽象类， 类中实现了模板方法(template)，定义了算法的骨 架，具体子类需要去实现 其它的抽象方法operationr2,3,4 
2. ConcreteClass 实现抽象方法operationr2,3,4, 以完成算法中特点子类的步 骤

## 模板方法模式解决豆浆制作问题

### 类图

<img src="images/image-20211220192024974.png" alt="image-20211220192024974" style="zoom:80%;" />

### 抽象类

```java
//抽象类，表示豆浆
public abstract class SoyaMilk {

   //模板方法, make , 模板方法可以做成final , 不让子类去覆盖.
   final void make() {
      
      select(); 
      addCondiments();
      soak();
      beat();
      
   }
   
   //选材料
   void select() {
      System.out.println("第一步：选择好的新鲜黄豆  ");
   }
   
   //添加不同的配料， 抽象方法, 子类具体实现
   abstract void addCondiments();
   
   //浸泡
   void soak() {
      System.out.println("第三步， 黄豆和配料开始浸泡， 需要3小时 ");
   }
    
   void beat() {
      System.out.println("第四步：黄豆和配料放到豆浆机去打碎  ");
   }
}
```

### 实现类

```java
public class PeanutSoyaMilk extends SoyaMilk {
   @Override
   void addCondiments() {
      System.out.println(" 加入上好的花生 ");
   }
}

public class RedBeanSoyaMilk extends SoyaMilk {
	@Override
	void addCondiments() {
		System.out.println(" 加入上好的红豆 ");
	}
}

```

### 测试

```java
public class Client {
   public static void main(String[] args) {
      System.out.println("----制作红豆豆浆----");
      SoyaMilk redBeanSoyaMilk = new RedBeanSoyaMilk();
      redBeanSoyaMilk.make();
      
      System.out.println("----制作花生豆浆----");
      SoyaMilk peanutSoyaMilk = new PeanutSoyaMilk();
      peanutSoyaMilk.make();
   }
}
```

##  模板方法模式的钩子方法

1) 在模板方法模式的父类中，我们可以**定义一个方法，它默认不做任何事**，子类可以 ==视情况要不要覆盖它==，该方法称为“钩子”。 

2) 还是用上面做豆浆的例子来讲解，比如，我们还希望制作纯豆浆，不添加任何的配 料，请使用钩子方法对前面的模板方法进行改造

### 抽象类稍稍修改

```java
//抽象类，表示豆浆
public abstract class SoyaMilk {

   //模板方法, make , 模板方法可以做成final , 不让子类去覆盖.
   final void make() {
      
      select(); 
      if(customerWantCondiments()) {
         addCondiments();
      }
      soak();
      beat();
      
   }
   
   //选材料
   void select() {
      System.out.println("第一步：选择好的新鲜黄豆  ");
   }
   
   //添加不同的配料， 抽象方法, 子类具体实现
   abstract void addCondiments();
   
   //浸泡
   void soak() {
      System.out.println("第三步， 黄豆和配料开始浸泡， 需要3小时 ");
   }
    
   void beat() {
      System.out.println("第四步：黄豆和配料放到豆浆机去打碎  ");
   }
   
   //钩子方法，决定是否需要添加配料
   boolean customerWantCondiments() {
      return true;
   }
}
```

### 添加一个纯豆浆

```java
public class PureSoyaMilk extends SoyaMilk{
   @Override
   void addCondiments() {
      //空实现
   }
   
   @Override
   boolean customerWantCondiments() {
      return false;
   }
}
```

### 测试

```java
public class Client {
   public static void main(String[] args) {
      System.out.println("----制作红豆豆浆----");
      SoyaMilk redBeanSoyaMilk = new RedBeanSoyaMilk();
      redBeanSoyaMilk.make();
      
      System.out.println("----制作花生豆浆----");
      SoyaMilk peanutSoyaMilk = new PeanutSoyaMilk();
      peanutSoyaMilk.make();
      
      System.out.println("----制作纯豆浆----");
      SoyaMilk pureSoyaMilk = new PureSoyaMilk();
      pureSoyaMilk.make();
   }
}
```



##  模板方法模式在Spring框架应用的源码分析

<img src="images/image-20211220194544890.png" alt="image-20211220194544890" style="zoom:80%;" />

### 类图

<img src="images/image-20211220194303718.png" alt="image-20211220194303718" style="zoom:80%;" />

##  模板方法模式的注意事项和细节

- 基本思想是：**算法只存在于一个地方，也就是在父类中，容易修改**。需要修改算 法时，只要修改父类的模板方法或者已经实现的某些步骤，子类就会继承这些修改 
- **实现了最大化代码复用**。父类的模板方法和已实现的某些步骤会被子类继承而直接 使用。 
- **既统一了算法，也提供了很大的灵活性**。父类的模板方法确保了算法的结构保持不 变，同时由子类提供部分步骤的实现。  
- 该模式的不足之处：每一个不同的实现都需要一个子类实现，导致类的个数增加， 使得系统更加庞大 
- 一般模板方法都加上**final关键字**， 防止子类重写模板方法. 
- 模板方法模式使用场景：当要完成在某个过程，**该过程要执行一系列步骤** ，==这一 系列的步骤基本相同==，但其**个别步骤**在实现时 可能**不同**，通常考虑用模板方法模 式来处理



# 第17章 命令模式

## 智能生活项目需求

1.  我们买了一套智能家电，有照明灯、风扇、冰箱、洗衣机，我们只要在手机上安装app就 可以控制对这些家电工作。 
2.  这些智能家电来自不同的厂家，我们不想针对每一种家电都安装一个App，分别控制，我 们希望只要一个app就可以控制全部智能家电。 
3.  要实现一个app控制所有智能家电的需要，则每个智能家电厂家都要提供一个统一的接口 给app调用，这时 就可以考虑使用命令模式。 
4.  命令模式可将“动作的请求者”从“动作的执行者”对象中解耦出来. 
5.  在我们的例子中，动作的请求者是手机app，动作的执行者是每个厂商的一个家电产品

##  命令模式

### 基本介绍

1.  命令模式（Command Pattern）：在软件设计中，我们经常需要 向某些对象发送请求，但是并不知道请求的接收者是谁，也不知 道被请求的操作是哪个， 我们只需在程序运行时指定具体的请求接收者即可，此时，可以 使用命令模式来进行设计 
2.  命名模式使得请求发送者与请求接收者消除彼此之间的耦合，**让 对象之间的调用关系更加灵活，实现解耦。** 
3.  在命名模式中，会将一个请求封装为一个对象，以便使用不同参 数来表示不同的请求(即命名)，同时命令模式也**支持可撤销**的操作。 
4.  通俗易懂的理解：将军发布命令，士兵去执行。其中有几个角色： 将军（命令发布者）、士兵（命令的具体执行者）、命令(连接将 军和士兵)。 Invoker是调用者（将军），Receiver是被调用者（士兵）， MyCommand是命令，实现了Command接口，持有接收对象

### 类图

![image-20211220200449337](images/image-20211220200449337.png)

**对原理类图的说明-即(命名模式的角色及职责)** 

-  Invoker 是调用者角色 
-  Command: 是命令角色，需要执行的所有命令都在这里，可以是接口或抽象类 
-  Receiver: 接受者角色，知道如何实施和执行一个请求相关的操作 
-  ConcreteCommand: 将一个接受者对象与一个动作绑定，调用接受者相应的操作，实现execute

##  命令模式解决智能生活项目

<img src="images/image-20211220200602330.png" alt="image-20211220200602330" style="zoom:80%;" />

### 类图

<img src="images/image-20211222210646055.png" alt="image-20211222210646055" style="zoom:80%;" />

### 代码

#### 创建命令接口

```java
//创建命令接口
public interface Command {
   //执行动作(操作)
   public void execute();
   //撤销动作(操作)
   public void undo();
}
```

#### 接受者（添加新的接受者）

```java
public class LightReceiver {
   public void on() {
      System.out.println(" 电灯打开了.. ");
   }
   public void off() {
      System.out.println(" 电灯关闭了.. ");
   }
}
--------------------------------------------
public class TVReceiver {
	public void on() {
		System.out.println(" 电视机打开了.. ");
	}
	public void off() {
		System.out.println(" 电视机关闭了.. ");
	}
}

```

#### 打开按钮

```java
public class LightOnCommand implements Command {
    //聚合LightReceiver
    LightReceiver light;

    //构造器
    public LightOnCommand(LightReceiver light) {
        super();
        this.light = light;
    }

    @Override
    public void execute() {
        //调用接收者的方法
        light.on();
    }

    @Override
    public void undo() {
        //调用接收者的方法
        light.off();
    }
}
--------------------------------------------------------------
    public class TVOnCommand implements Command {
	// 聚合TVReceiver
	TVReceiver tv;

	// 构造器
	public TVOnCommand(TVReceiver tv) {
		super();
		this.tv = tv;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		// 调用接收者的方法
		tv.on();
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		// 调用接收者的方法
		tv.off();
	}
}

```

#### 关闭按钮

```java
public class LightOffCommand implements Command {
   // 聚合LightReceiver
   LightReceiver light;

   // 构造器
   public LightOffCommand(LightReceiver light) {
         super();
         this.light = light;
      }

   @Override
   public void execute() {
      // 调用接收者的方法
      light.off();
   }

   @Override
   public void undo() {
      // 调用接收者的方法
      light.on();
   }
}
---------------------------------------------------------
 public class TVOffCommand implements Command {
	// 聚合TVReceiver
	TVReceiver tv;

	// 构造器
	public TVOffCommand(TVReceiver tv) {
		super();
		this.tv = tv;
	}

	@Override
	public void execute() {
		// 调用接收者的方法
		tv.off();
	}

	@Override
	public void undo() {
		// 调用接收者的方法
		tv.on();
	}
}   
    
```

#### 远程遥控器

```java
public class RemoteController {
   // 开 按钮的命令数组
   Command[] onCommands;
   Command[] offCommands;

   // 执行撤销的命令
   Command undoCommand;

   // 构造器，完成对按钮初始化

   public RemoteController() {

      onCommands = new Command[5];
      offCommands = new Command[5];

      for (int i = 0; i < 5; i++) {
         onCommands[i] = new NoCommand();
         offCommands[i] = new NoCommand();
      }
   }

   // 给我们的按钮设置你需要的命令
   public void setCommand(int no, Command onCommand, Command offCommand) {
      onCommands[no] = onCommand;
      offCommands[no] = offCommand;
   }

   // 按下开按钮
   public void onButtonWasPushed(int no) { // no 0
      // 找到你按下的开的按钮， 并调用对应方法
      onCommands[no].execute();
      // 记录这次的操作，用于撤销
      undoCommand = onCommands[no];

   }

   // 按下开按钮
   public void offButtonWasPushed(int no) { // no 0
      // 找到你按下的关的按钮， 并调用对应方法
      offCommands[no].execute();
      // 记录这次的操作，用于撤销
      undoCommand = offCommands[no];

   }
   
   // 按下撤销按钮
   public void undoButtonWasPushed() {
      undoCommand.undo();
   }

}
```

#### 空命令

```java
/**
 * 没有任何命令，即空执行: 用于初始化每个按钮, 当调用空命令时，对象什么都不做
 * 其实，这样是一种设计模式, 可以省掉对空判断
 *
 */
public class NoCommand implements Command {
   @Override
   public void execute() { }

   @Override
   public void undo() { }

}
```

#### 测试

```java
public class Client {
   public static void main(String[] args) {
      //使用命令设计模式，完成通过遥控器，对电灯的操作
      
      //创建电灯的对象(接受者)
      LightReceiver lightReceiver = new LightReceiver();
      
      //创建电灯相关的开关命令
      LightOnCommand lightOnCommand = new LightOnCommand(lightReceiver);
      LightOffCommand lightOffCommand = new LightOffCommand(lightReceiver);
      
      //需要一个遥控器
      RemoteController remoteController = new RemoteController();
      
      //给我们的遥控器设置命令, 比如 no = 0 是电灯的开和关的操作
      remoteController.setCommand(0, lightOnCommand, lightOffCommand);
      
      System.out.println("--------按下灯的开按钮-----------");
      remoteController.onButtonWasPushed(0);
      System.out.println("--------按下灯的关按钮-----------");
      remoteController.offButtonWasPushed(0);
      System.out.println("--------按下撤销按钮-----------");
      remoteController.undoButtonWasPushed();
      
      
      System.out.println("=========使用遥控器操作电视机==========");
      
      TVReceiver tvReceiver = new TVReceiver();
      
      TVOffCommand tvOffCommand = new TVOffCommand(tvReceiver);
      TVOnCommand tvOnCommand = new TVOnCommand(tvReceiver);
      
      //给我们的遥控器设置命令, 比如 no = 1 是电视机的开和关的操作
      remoteController.setCommand(1, tvOnCommand, tvOffCommand);
      
      System.out.println("--------按下电视机的开按钮-----------");
      remoteController.onButtonWasPushed(1);
      System.out.println("--------按下电视机的关按钮-----------");
      remoteController.offButtonWasPushed(1);
      System.out.println("--------按下撤销按钮-----------");
      remoteController.undoButtonWasPushed();
   }

}
```



##  在JdbcTemplate应用的源码分析

Spring框架的JdbcTemplate就使用到了命令模式

<img src="images/image-20211222191057577.png" alt="image-20211222191057577" style="zoom:80%;" />

### 模式角色分析说明

1. **StatementCallback** 接口 ,类似命令接口(**Command**) 
2. class ==QueryStatementCallback== implements StatementCallback, SqlProvider , **匿名内 部类， 实现了命令接口**， **同时也充当命令接收者**
3. **命令调用者** 是 **JdbcTemplate** , 其中execute(StatementCallback action) 方法中，调 用action.doInStatement 方法. 不同的 实现 StatementCallback 接口的对象，对应不同 的doInStatemnt 实现逻辑 
4. 另外实现 StatementCallback 命令接口的子类还有 QueryStatementCallback

<img src="images/image-20211222191243344.png" alt="image-20211222191243344" style="zoom:80%;" />



##  命令模式的注意事项和细节

- 将发起请求的对象与执行请求的对象解耦。发起请求的对象是调用者，调用者只要 调用命令对象的**execute()方法**就可以让接收者工作，而不必知道具体的接收者对 象是谁、是如何实现的，命令对象会负责让接收者执行请求的动作，也就是说：” 请求发起者”和“请求执行者”之间的解耦是通过命令对象实现的，命令对象起到 了纽带桥梁的作用。 
- 容易设计一个命令队列。只要把命令对象放到列队，就可以多线程的执行命令
- **容易实现对请求的撤销和重做** 
- ==命令模式不足==：可能导致某些系统有过多的具体命令类，增加了系统的复杂度，这 点在在使用的时候要注意 
- 空命令也是一种设计模式，它为我们省去了判空的操作。在上面的实例中，如果没 有用空命令，我们每按下一个按键都要判空，这给我们编码带来一定的麻烦。 
- 命令模式经典的应用场景：界面的一个按钮都是一条命令、模拟CMD（DOS命令） 订单的撤销/恢复、触发-反馈机制



# 第18章 访问者模式

##   测评系统的需求

1. 将观众分为男人和女人，对歌手进行测评，当看完某个歌手表演后，得到他们对 该歌手不同的评价(评价 有不同的种类，比如 成功、失败 等)
2. 传统方案
3. <img src="images/image-20211222191715410.png" alt="image-20211222191715410" style="zoom:67%;" />



##  职员管理项目的需求

1.  如果系统比较小，还是ok的，但是考虑系统增加越来越多新的功能时，对代码改 动较大，违反了ocp原则， 不利于维护 
2.  扩展性不好，比如 增加了 新的人员类型，或者管理方法，都不好做 
3.  引出我们会使用新的设计模式 – 访问者模式

## 访问者模式

###  基本介绍

1. 访问者模式（** **），封装一些作用于某种数据结构的各元素的操作， 它可以在不改变数据结构的前提下定义作用于这些元素的新的操作。 
2. 主要将数据结构与数据操作分离，解决 ==数据结构和操作耦合性问题== 
3. 访问者模式的**基本工作原理**是：在被访问的类里面加一个对外提供接待访问者 的接口 
4. 访问者模式**主要应用场景**是：需要对一个对象结构中的对象进行很多不同操作 (这些操作彼此没有关联)，同时需要避免让这些操作"污染"这些对象的类，可以 选用访问者模式解决

### 类图

<img src="images/image-20211222192002930.png" alt="image-20211222192002930"  />

**对原理类图的说明  即(访问者模式的角色及职责)**

1.  Visitor 是抽象访问者，为该对象结构中的ConcreteElement的每一个类声明一个visit操作 
2.  ConcreteVisitor ：是一个具体的访问值 实现每个有Visitor 声明的操作，是每个操作实现的部分. 
3.  ObjectStructure 能枚举它的元素， 可以提供一个高层的接口，用来允许访问者访问元素 
4.  Element 定义一个accept 方法，接收一个访问者对象 
5.  ConcreteElement 为具体元素，实现了accept 方法



## 访问者模式应用实例

###  应用实例要求

 将人分为男人和女人，对歌手进行测评，当看完某个歌手表演后，得到他们对该歌手 不同的评价(评价 有不同的种类，比如 成功、失败 等)，请使用访问者模式来说实现 

### 思路分析和图解(类图) 

<img src="images/image-20211222222058400.png" alt="image-20211222222058400" style="zoom:80%;" />

### 代码实现

#### 抽象访问者

```java
public abstract class Action {
   //得到男性 的测评
   public abstract void getManResult(Man man);
   
   //得到女的 测评
   public abstract void getWomanResult(Woman woman);
}
```

#### 具体访问者

```java
public abstract class Person {
   //提供一个方法，让访问者可以访问
   public abstract void accept(Action action);
}
------------------------------------------------
   //说明
//1. 这里我们使用到了双分派, 即首先在客户端程序中，将具体状态作为参数传递Woman中(第一次分派)
//2. 然后Woman 类调用作为参数的 "具体方法" 中方法getWomanResult, 同时将自己(this)作为参数
//   传入，完成第二次的分派
public class Woman extends Person{
	@Override
	public void accept(Action action) {
		action.getWomanResult(this);
	}
}
--------------------------------------------------------
    public class Man extends Person {
	@Override
	public void accept(Action action) {
		action.getManResult(this);
	}
}
```

#### Element

```java
public class Fail extends Action {
   @Override
   public void getManResult(Man man) {
      System.out.println(" 男人给的评价该歌手失败 !");
   }

   @Override
   public void getWomanResult(Woman woman) {
      System.out.println(" 女人给的评价该歌手失败 !");
   }
}
-----------------------------------------------------------
public class Success extends Action {
	@Override
	public void getManResult(Man man) {
		System.out.println(" 男人给的评价该歌手很成功 !");
	}

	@Override
	public void getWomanResult(Woman woman) {
		System.out.println(" 女人给的评价该歌手很成功 !");
	}
}
===============================================================
public class Wait extends Action {
	@Override
	public void getManResult(Man man) {
		System.out.println(" 男人给的评价是该歌手待定 ..");
	}
	@Override
	public void getWomanResult(Woman woman) {
		System.out.println(" 女人给的评价是该歌手待定 ..");
	}
}    
```

#### 数据结构

```java
//数据结构，管理很多人（Man , Woman）
public class ObjectStructure {
   //维护了一个集合
   private List<Person> persons = new LinkedList<>();
   
   //增加到list
   public void attach(Person p) {
      persons.add(p);
   }
   //移除
   public void detach(Person p) {
      persons.remove(p);
   }
   
   //显示测评情况
   public void display(Action action) {
      for(Person p: persons) {
         p.accept(action);
      }
   }
}
```

#### 测试

```java
public class Client {
   public static void main(String[] args) {
      // TODO Auto-generated method stub
      //创建ObjectStructure
      ObjectStructure objectStructure = new ObjectStructure();
      
      objectStructure.attach(new Man());
      objectStructure.attach(new Woman());
      
      //成功
      Success success = new Success();
      objectStructure.display(success);
      
      System.out.println("===============");
      Fail fail = new Fail();
      objectStructure.display(fail);
      
      System.out.println("=======给的是待定的测评========");
      
      Wait wait = new Wait();
      objectStructure.display(wait);
   }
}
```

### 应用案例的小结 

- 上面提到了==双分派==，所谓双分派是指**不管类怎么变化，我们都能找到期望的方法运行**。 双分派意味着得到执行的操作取决于请求的种类和两个接收者的类型 
- 以上述实例为例，假设我们要添加一个Wait的状态类，考察Man类和Woman类的反 应，由于使用了双分派，**==只需增加一个Action子类即可在客户端调用即可，不 需要改动任何其他类的代码。==**



##  访问者模式的注意事项和细节

### 优点 

- 访问者模式符合单一职责原则、让程序具有优秀的扩展性、灵活性非常高 
- 访问者模式可以对功能进行统一，可以做报表、UI、拦截器与过滤器，适用于数据 结构相对稳定的系统 

### 缺点 

- 具体元素对访问者公布细节，也就是说访问者关注了其他类的内部细节，这是迪米 特法则所不建议的, 这样造成了具体元素变更比较困难  
- 违背了依赖倒转原则。访问者依赖的是具体元素，而不是抽象元素 
- 因此，**如果一个系统有比较稳定的数据结构**，又有经常变化的功能需求，那么**访问者模式就是比较合适的**.



# 第19章 迭代器模式

### ==迭代器注重的是遍历，组合模式注重的是各个组成部件==

##  看一个具体的需求

编写程序展示一个学校院系结构：需求是这样，要在一个页面中展示出学校的院系 组成，一个学校有多个学院，一个学院有多个系。如图

![image-20211223093131363](images/image-20211223093131363.png)



### 19.1.1 使用传统的设计方案

<img src="images/image-20211215190426861.png" alt="image-20211215190426861" style="zoom:67%;" />计算机学院 系=> 

计算机学院 系=> 放在数组中

信息工程学院 系=>放在集合中

### 19.1.2 传统的方式的问题分析

1) 将学院看做是学校的子类，系是学院的子类，这样实际上是站在组织大小来进行分 层次的 
2) 实际上我们的要求是 ：在一个页面中展示出学校的院系组成，一个学校有多个 学院，一个学院有多个系， 因此这种方案，不能很好实现的遍历的操作 
3) 解决方案：=> 迭代器模式

##  迭代器模式

### 基本介绍

1) 迭代器模式（Iterator Pattern）是常用的设计模式，属于**行为型模式** 
2) 如果我们的**集合元素是用不同的方式实现的**，有数组，还有java的集合类， 或者还有其他方式，当客户端要遍历这些集合元素的时候就要使用多种遍历 方式，而且还会暴露元素的内部结构，可以考虑使用迭代器模式解决。 
3) 迭代器模式，提供一种遍历集合元素的统一接口，用一致的方法遍历集合元素， 不需要知道集合对象的底层表示，即：**不暴露其内部的结构。**

### 类图

![image-20211223094413590](images/image-20211223094413590.png)

#### **对原理类图的说明-即(迭代器模式的角色及职责)** 

1) Iterator ： 迭代器接口，是系统提供，含义 hasNext, next, remove 
2) ConcreteIterator : 具体的迭代器类，管理迭代 
3) Aggregate :一个统一的聚合接口， 将客户端和具体聚合解耦
4) ConcteteAggregate： 具体的聚合持有对象集合，并提供一个方法，返回一个迭代器，该迭代器可以正确遍历集合 
5) Client ：客户端，通过Iterator和Aggregate依赖子类



## 迭代器模式应用实例

### 类图

<img src="images/image-20211223095718667.png" alt="image-20211223095718667" style="zoom:80%;" />



### 代码

#### 系（专业）

```java
//系（专业）
public class Department {
   private String name;
   private String desc;
   public Department(String name, String desc) {
      super();
      this.name = name;
      this.desc = desc;
   }
   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }
   public String getDesc() {
      return desc;
   }
   public void setDesc(String desc) {
      this.desc = desc;
   }
}
```

#### 学院接口

```java
public interface College {
   public String getName();
    
   //增加系的方法
   public void addDepartment(String name, String desc);
    
   //返回一个迭代器,遍历
   public Iterator  createIterator();
}
```

#### 具体学院

```java
public class ComputerCollege implements College {
   Department[] departments;
   int numOfDepartment = 0 ;// 保存当前数组的对象个数
   
   public ComputerCollege() {
      departments = new Department[5];
      addDepartment("Java专业", " Java专业 ");
      addDepartment("PHP专业", " PHP专业 ");
      addDepartment("大数据专业", " 大数据专业 ");
      
   }
   
   @Override
   public String getName() {
      return "计算机学院";
   }

   @Override
   public void addDepartment(String name, String desc) {
      Department department = new Department(name, desc);
      departments[numOfDepartment] = department;
      numOfDepartment += 1;
   }

   @Override
   public Iterator createIterator() {
      return new ComputerCollegeIterator(departments);
   }
}
------------------------------------------------------------------------------------
public class InfoCollege implements College {
	List<Department> departmentList;
	
	public InfoCollege() {
		departmentList = new ArrayList<Department>();
		addDepartment("信息安全专业", " 信息安全专业 ");
		addDepartment("网络安全专业", " 网络安全专业 ");
		addDepartment("服务器安全专业", " 服务器安全专业 ");
	}
	
	@Override
	public String getName() {
		return "信息工程学院";
	}

	@Override
	public void addDepartment(String name, String desc) {
		Department department = new Department(name, desc);
		departmentList.add(department);
	}

	@Override
	public Iterator createIterator() {
		return new InfoColleageIterator(departmentList);
	}
}    
```

#### 具体迭代器

```java
public class ComputerCollegeIterator implements Iterator {
   //这里我们需要Department 是以怎样的方式存放=>数组
   Department[] departments;
   int position = 0; //遍历的位置
   
   public ComputerCollegeIterator(Department[] departments) {
      this.departments = departments;
   }

   //判断是否还有下一个元素
   @Override
   public boolean hasNext() {
      // TODO Auto-generated method stub
      if(position >= departments.length || departments[position] == null) {
         return false;
      }else {
         return true;
      }
   }

   @Override
   public Object next() {
      // TODO Auto-generated method stub
      Department department = departments[position];
      position += 1;
      return department;
   }
   
   //删除的方法，默认空实现
   public void remove() {
}
}
---------------------------------------------------------------------------------------
 public class InfoColleageIterator implements Iterator {
	List<Department> departmentList; // 信息工程学院是以List方式存放系
	int index = -1;//索引
	
	public InfoColleageIterator(List<Department> departmentList) {
		this.departmentList = departmentList;
	}

	//判断list中还有没有下一个元素
	@Override
	public boolean hasNext() {
		if(index >= departmentList.size() - 1) {
			return false;
		} else {
			index += 1;
			return true;
		}
	}

	@Override
	public Object next() {
		return departmentList.get(index);
	}
	
	//空实现remove
	public void remove() {
	}
 }   
```

#### 学院集合

```java
public class OutPutImpl {
   //学院集合
   List<College> collegeList;

   public OutPutImpl(List<College> collegeList) {
      
      this.collegeList = collegeList;
   }
   //遍历所有学院,然后调用printDepartment 输出各个学院的系
   public void printCollege() {
      
      //从collegeList 取出所有学院, Java 中的 List 已经实现Iterator
      Iterator<College> iterator = collegeList.iterator();
      
      while(iterator.hasNext()) {
         //取出一个学院
         College college = iterator.next();
         System.out.println("=== "+college.getName() +"=====" );
         printDepartment(college.createIterator()); //得到对应迭代器
      }
   }
   
   //输出 学院输出 系
   public void printDepartment(Iterator iterator) {
      while(iterator.hasNext()) {
         Department d = (Department)iterator.next();
         System.out.println(d.getName());
      }
   }
}
```

#### 测试

```java
public class Client {
   public static void main(String[] args) {
      //创建学院
      List<College> collegeList = new ArrayList<College>();
      
      ComputerCollege computerCollege = new ComputerCollege();
      InfoCollege infoCollege = new InfoCollege();
      
      collegeList.add(computerCollege);
      //collegeList.add(infoCollege);
      
      OutPutImpl outPutImpl = new OutPutImpl(collegeList);
      outPutImpl.printCollege();
   }
}
```



## 迭代器模式在JDK-ArrayList集合应用的源码分析

![image-20211223103849821](images/image-20211223103849821.png)

### 类图

![image-20211223110332802](images/image-20211223110332802.png)

### 角色分析说明

- 内部类Itr 充当具体实现迭代器Iterator 的类， 作为ArrayList 内部类  
- List 就是充当了聚合接口，含有一个iterator() 方法，返回一个迭代器对象 
- ArrayList 是实现聚合接口List 的子类，实现了iterator() - Iterator 接口系统提供 
- 迭代器模式解决了 不同集合(ArrayList ,LinkedList) 统一遍历问题

##  迭代器模式的注意事项和细节

###  优点

1. 提供一个统一的方法遍历对象，客户不用再考虑聚合的类型，使用一种方法就可以 遍历对象了。 

2. 隐藏了聚合的内部结构，客户端要遍历聚合的时候只能取到迭代器，而不会知道聚 合的具体组成。 

3. 提供了一种设计思想，就是一个类应该只有一个引起变化的原因（叫做单一责任 原则）。在聚合类中，我们把迭代器分开，就是要把管理对象集合和遍历对象集 合的责任分开，这样一来集合改变的话，只影响到聚合对象。而如果遍历方式改变 的话，只影响到了迭代器。 

4. 当要展示一组相似对象，或者遍历一组相同对象时使用, 适合使用迭代器模式 

### 缺点

    每个聚合对象都要一个迭代器，会生成多个迭代器不好管理类



# 第20章 观察者模式

## 天气预报项目需求

1) 气象站可以将每天测量到的温度，湿度，气压等等以公告的形式发布出去(比如 发布到自己的网站或第三方)。 
2) 需要设计开放型API，便于其他第三方也能接入气象站获取数据。 
3) 提供温度、气压和湿度的接口 
4) 测量数据更新时，要能实时的通知给第三方

###  普通方案

通过对气象站项目的分析，我们可以初步设计出一个WeatherData类

<img src="images/image-20211223162848738.png" alt="image-20211223162848738" style="zoom:80%;" />

#### **说明:** 

1) 通过getXxx方法，可以让第三方接入，并得到相关信息.
2) 当数据有更新时，气象站通过调用dataChange() 去更新数据，当第三方再次获 取时，就能得到最新数据，当然也可以推送。

####  示意图

<img src="images/image-20211223163014426.png" alt="image-20211223163014426" style="zoom:80%;" />

CurrentConditions(当前的天气情况)

 可以理解成是我们气象局的网站  ==//推送==



#### 代码实现 

```java
/**
 * 显示当前天气情况（可以理解成是气象站自己的网站）
 */
public class CurrentConditions {
   // 温度，气压，湿度
   private float temperature;
   private float pressure;
   private float humidity;

   //更新 天气情况，是由 WeatherData 来调用，我使用推送模式
   public void update(float temperature, float pressure, float humidity) {
      this.temperature = temperature;
      this.pressure = pressure;
      this.humidity = humidity;
      display();
   }

   //显示
   public void display() {
      System.out.println("***Today mTemperature: " + temperature + "***");
      System.out.println("***Today mPressure: " + pressure + "***");
      System.out.println("***Today mHumidity: " + humidity + "***");
   }
}
```



```java
/**
 * 类是核心
 * 1. 包含最新的天气情况信息 
 * 2. 含有 CurrentConditions 对象
 * 3. 当数据有更新时，就主动的调用   CurrentConditions对象update方法(含 display), 这样他们（接入方）就看到最新的信息
 */
public class WeatherData {
   private float temperatrue;
   private float pressure;
   private float humidity;
   private CurrentConditions currentConditions;
   //加入新的第三方

   public WeatherData(CurrentConditions currentConditions) {
      this.currentConditions = currentConditions;
   }

   public float getTemperature() {
      return temperatrue;
   }

   public float getPressure() {
      return pressure;
   }

   public float getHumidity() {
      return humidity;
   }

   public void dataChange() {
      //调用 接入方的 update
      currentConditions.update(getTemperature(), getPressure(), getHumidity());
   }

   //当数据有更新时，就调用 setData
   public void setData(float temperature, float pressure, float humidity) {
      this.temperatrue = temperature;
      this.pressure = pressure;
      this.humidity = humidity;
      //调用dataChange， 将最新的信息 推送给 接入方 currentConditions
      dataChange();
   }
}
```



```java
public class Client {
   public static void main(String[] args) {
      //创建接入方 currentConditions
      CurrentConditions currentConditions = new CurrentConditions();
      //创建 WeatherData 并将 接入方 currentConditions 传递到 WeatherData中
      WeatherData weatherData = new WeatherData(currentConditions);
      
      //更新天气情况
      weatherData.setData(30, 150, 40);
      
      //天气情况变化
      System.out.println("============天气情况变化=============");
      weatherData.setData(40, 160, 20);
   }
}
```



### 2  问题分析

1) 其他第三方接入气象站获取数据的问题 
2) 无法在运行时动态的添加第三方 (新浪网站) 
3) 违反ocp原则=>观察者模式

```java
//在WeatherData中，当增加一个第三方，都需要创建一个对应的第三方的公告板
对象，并加入到dataChange, 不利于维护，也不是动态加入
public void dataChange() {
currentConditions.update(getTemperature(), getPressure(), getHumidity());
}
```



##  观察者模式

### 原理

观察者模式类似订牛奶业务 

1. 奶站/气象局：Subject 

2. 用户/第三方网站：Observer

   <img src="images/image-20211223165259072.png" alt="image-20211223165259072" style="zoom:67%;" />

Subject：登记注册、移除和通知

      1) registerObserver 注册 
      2) removeObserver 移除 
      3) notifyObservers() 通知所有的注册的用户，根据不同需求，可以是更新数据，让用 户来取，也可能是实施推送，看具体需求定



Observer：接收输入

<img src="images/image-20211223165339430.png" alt="image-20211223165339430" style="zoom:67%;" />

**观察者模式：**

对象之间**多对一依赖**的一种设计方案，被依赖的对象为Subject， 依赖的对象为Observer，Subject通知Observer变化,比如这里的奶站是 Subject，是1的一方。用户时Observer，是多的一方。

## 观察者模式解决天气预报需求

### 类图

<img src="images/image-20211223165521920.png" alt="image-20211223165521920" style="zoom:80%;" />

### 观察者模式的好处 

1) 观察者模式设计后，会以集合的方式来管理用户(Observer)，包括注册，移除 和通知。 
2) 这样，我们增加观察者(这里可以理解成一个新的公告板)，就不需要去修改核 心类WeatherData不会修改代码，遵守了ocp原则。



### 代码实现

#### subject

```java
//接口, 让WeatherData 来实现 
public interface Subject {
   public void registerObserver(Observer o);
   public void removeObserver(Observer o);
   public void notifyObservers();
}
```

#### observe

```java
//观察者接口，有观察者来实现
public interface Observer {
   public void update(float temperature, float pressure, float humidity);
}
```

#### 当前状态

```java
public class CurrentConditions implements Observer {
   // 温度，气压，湿度
   private float temperature;
   private float pressure;
   private float humidity;

   // 更新 天气情况，是由 WeatherData 来调用，我使用推送模式
   public void update(float temperature, float pressure, float humidity) {
      this.temperature = temperature;
      this.pressure = pressure;
      this.humidity = humidity;
      display();
   }

   // 显示
   public void display() {
      System.out.println("***Today mTemperature: " + temperature + "***");
      System.out.println("***Today mPressure: " + pressure + "***");
      System.out.println("***Today mHumidity: " + humidity + "***");
   }
}
```

#### weatherData

```java
/**
 * 类是核心
 * 1. 包含最新的天气情况信息 
 * 2. 含有 观察者集合，使用ArrayList管理
 * 3. 当数据有更新时，就主动的调用   ArrayList, 通知所有的（接入方）就看到最新的信息
 *
 */
public class WeatherData implements Subject {
   private float temperatrue;
   private float pressure;
   private float humidity;
   //观察者集合
   private ArrayList<Observer> observers;
   
   //加入新的第三方
   public WeatherData() {
      observers = new ArrayList<Observer>();
   }

   public float getTemperature() {
      return temperatrue;
   }

   public float getPressure() {
      return pressure;
   }

   public float getHumidity() {
      return humidity;
   }

   public void dataChange() {
      //调用 接入方的 update
      notifyObservers();
   }

   //当数据有更新时，就调用 setData
   public void setData(float temperature, float pressure, float humidity) {
      this.temperatrue = temperature;
      this.pressure = pressure;
      this.humidity = humidity;
      //调用dataChange， 将最新的信息 推送给 接入方 currentConditions
      dataChange();
   }

   //注册一个观察者
   @Override
   public void registerObserver(Observer o) {
      observers.add(o);
   }

   //移除一个观察者
   @Override
   public void removeObserver(Observer o) {
      if(observers.contains(o)) {
         observers.remove(o);
      }
   }

   //遍历所有的观察者，并通知
   @Override
   public void notifyObservers() {
      for(int i = 0; i < observers.size(); i++) {
         observers.get(i).update(this.temperatrue, this.pressure, this.humidity);
      }
   }
}
```

#### 添加新的网站

```java
public class BaiduSite implements Observer {
   // 温度，气压，湿度
   private float temperature;
   private float pressure;
   private float humidity;

   // 更新 天气情况，是由 WeatherData 来调用，我使用推送模式
   public void update(float temperature, float pressure, float humidity) {
      this.temperature = temperature;
      this.pressure = pressure;
      this.humidity = humidity;
      display();
   }

   // 显示
   public void display() {
      System.out.println("===百度网站====");
      System.out.println("***百度网站 气温 : " + temperature + "***");
      System.out.println("***百度网站 气压: " + pressure + "***");
      System.out.println("***百度网站 湿度: " + humidity + "***");
   }
}
```

#### 测试

```java
public class Client {
   public static void main(String[] args) {
      //创建一个WeatherData
      WeatherData weatherData = new WeatherData();
      
      //创建观察者
      CurrentConditions currentConditions = new CurrentConditions();
      BaiduSite baiduSite = new BaiduSite();
      
      //注册到weatherData
      weatherData.registerObserver(currentConditions);
      weatherData.registerObserver(baiduSite);
      
      //测试
      System.out.println("通知各个注册的观察者, 看看信息");
      weatherData.setData(10f, 100f, 30.3f);
      
      
      weatherData.removeObserver(currentConditions);
      //测试
      System.out.println();
      System.out.println("通知各个注册的观察者, 看看信息");
      weatherData.setData(10f, 100f, 30.3f);
   }
}
```

## 观察者模式在Jdk应用的源码分析

<img src="images/image-20211223224747144.png" alt="image-20211223224747144" style="zoom:80%;" />

### 模式角色分析

-  Observable 的作用和地位等价于 我们前面讲过Subject 
-  Observable 是类，不是接口，类中已经实现了核心的方法 ,即管理Observer 的方法 add.. delete .. notify...  
-  Observer 的作用和地位等价于我们前面讲过的 Observer, 有update 
-  Observable 和 Observer 的使用方法和前面讲过的一样，只是Observable 是 类，通过继承来实现观察者模式



# 第21章 中介者模式

##  智能家庭项目

1) 智能家庭包括各种设备，闹钟、咖啡机、电视机、窗帘 等 
2) 主人要看电视时，各个设备可以协同工作，自动完成看电视的准备工作，比如流 程为：闹铃响起->咖啡机开始做咖啡->窗帘自动落下->电视机开始播放



##   传统方案解决

### 类图

<img src="images/image-20211225142835555.png" alt="image-20211225142835555" style="zoom:80%;" />

### 问题分析

1) 当各电器对象有多种状态改变时，相互之间的调用关系会比较复杂 
2) 各个电器对象彼此联系**，你中有我，我中有你，不利于松耦合.** 
3) 各个电器对象之间所传递的消息(参数)，容易混乱 
4) 当系统增加一个新的电器对象时，或者执行流程改变时，代码的可维护性、扩展性 都不理想 》 考虑中介者模式



## 中介者模式

###  基本介绍

1) 中介者模式（Mediator Pattern），用一个中介对象来封装一系列的对象交互。 中介者使各个对象不需要显式地相互引用，从而使其耦合松散，而且可以独立 地改变它们之间的交互 
2) 中介者模式属于行为型模式，使代码易于维护 
3) 比如MVC模式，C（Controller控制器）是M（Model模型）和V（View视图）的中 介者，在前后端交互时起到了中间人的作用



###  原理类图

<img src="images/image-20211225144647140.png" alt="image-20211225144647140" style="zoom:80%;" />

**对原理类图的说明-即(中介者模式的角色及职责)** 

1) Mediator 就是抽象中介者,定义了同事对象到中介者对象的接口 
2) Colleague 是抽象同事类
3) ConcreteMediator具体的中介者对象,实现抽象方法,他需要知道所有的具体的同事类,即以一个集合来管理HashMap,并接受某个同事
   对象消息,完成相应的任务

4. ConcreteColleague具体的同事类,会有很多,每个同事只知道自己的行为,而不了解其他同事类的行为(方法),但是他们都依赖
   中介者对象



##  中介者模式应用实例-智能家庭管理

###   类图

<img src="images/image-20211225145958822.png" alt="image-20211225145958822" style="zoom:80%;" />

###  代码

#### 抽象中介者

```java
public abstract class Mediator {
   //将给中介者对象，加入到集合中
   public abstract void Register(String colleagueName, Colleague colleague);

   //接收消息, 具体的同事对象发出
   public abstract void GetMessage(int stateChange, String colleagueName);

   public abstract void SendMessage();
}
```

#### 同时抽象类

```java
//同事抽象类
public abstract class Colleague {
   private Mediator mediator;
   public String name;

   public Colleague(Mediator mediator, String name) {
      this.mediator = mediator;
      this.name = name;

   }

   public Mediator GetMediator() {
      return this.mediator;
   }

   public abstract void SendMessage(int stateChange);
}
```



#### 具体同事类

```java
//具体的同事类
public class Alarm extends Colleague {
   //构造器
   public Alarm(Mediator mediator, String name) {
      super(mediator, name);
      //在创建Alarm 同事对象时，将自己放入到ConcreteMediator 对象中[集合]
      mediator.Register(name, this);
   }

   public void SendAlarm(int stateChange) {
      SendMessage(stateChange);
   }

   @Override
   public void SendMessage(int stateChange) {
      //调用的中介者对象的getMessage
      this.GetMediator().GetMessage(stateChange, this.name);
   }
}
=======================================================================
 public class CoffeeMachine extends Colleague {

	public CoffeeMachine(Mediator mediator, String name) {
		super(mediator, name);
		mediator.Register(name, this);
	}

	@Override
	public void SendMessage(int stateChange) {
		this.GetMediator().GetMessage(stateChange, this.name);
	}

	public void StartCoffee() {
		System.out.println("It's time to startcoffee!");
	}

	public void FinishCoffee() {

		System.out.println("After 5 minutes!");
		System.out.println("Coffee is ok!");
		SendMessage(0);
	}
}
===========================================================================
public class Curtains extends Colleague {
	public Curtains(Mediator mediator, String name) {
		super(mediator, name);
		mediator.Register(name, this);
	}

	@Override
	public void SendMessage(int stateChange) {
		this.GetMediator().GetMessage(stateChange, this.name);
	}

	public void UpCurtains() {
		System.out.println("I am holding Up Curtains!");
	}
}
 ===========================================================================
public class TV extends Colleague {
	public TV(Mediator mediator, String name) {
		super(mediator, name);
		mediator.Register(name, this);
	}

	@Override
	public void SendMessage(int stateChange) {
		this.GetMediator().GetMessage(stateChange, this.name);
	}

	public void StartTv() {
		System.out.println("It's time to StartTv!");
	}

	public void StopTv() {
		System.out.println("StopTv!");
	}
}
     
```

#### 具体中介者

```java
//具体的中介者类
public class ConcreteMediator extends Mediator {
   //集合，放入所有的同事对象
   private HashMap<String, Colleague> colleagueMap;
   private HashMap<String, String> interMap;

   public ConcreteMediator() {
      colleagueMap = new HashMap<String, Colleague>();
      interMap = new HashMap<String, String>();
   }

   @Override
   public void Register(String colleagueName, Colleague colleague) {
      colleagueMap.put(colleagueName, colleague);

      if (colleague instanceof Alarm) {
         interMap.put("Alarm", colleagueName);
      } else if (colleague instanceof CoffeeMachine) {
         interMap.put("CoffeeMachine", colleagueName);
      } else if (colleague instanceof TV) {
         interMap.put("TV", colleagueName);
      } else if (colleague instanceof Curtains) {
         interMap.put("Curtains", colleagueName);
      }

   }

   //具体中介者的核心方法
   //1. 根据得到消息，完成对应任务
   //2. 中介者在这个方法，协调各个具体的同事对象，完成任务
   @Override
   public void GetMessage(int stateChange, String colleagueName) {
      //处理闹钟发出的消息
      if (colleagueMap.get(colleagueName) instanceof Alarm) {
         if (stateChange == 0) {
            ((CoffeeMachine) (colleagueMap.get(interMap
                  .get("CoffeeMachine")))).StartCoffee();
            ((TV) (colleagueMap.get(interMap.get("TV")))).StartTv();
         } else if (stateChange == 1) {
            ((TV) (colleagueMap.get(interMap.get("TV")))).StopTv();
         }

      } else if (colleagueMap.get(colleagueName) instanceof CoffeeMachine) {
         ((Curtains) (colleagueMap.get(interMap.get("Curtains"))))
               .UpCurtains();

      } else if (colleagueMap.get(colleagueName) instanceof TV) {//如果TV发现消息

      } else if (colleagueMap.get(colleagueName) instanceof Curtains) {
         //如果是以窗帘发出的消息，这里处理...
      }

   }

   @Override
   public void SendMessage() {
   }

}
```

#### 测试

```java
public class ClientTest {
   public static void main(String[] args) {
      //创建一个中介者对象
      Mediator mediator = new ConcreteMediator();
      
      //创建Alarm 并且加入到  ConcreteMediator 对象的HashMap
      Alarm alarm = new Alarm(mediator, "alarm");
      
      //创建了CoffeeMachine 对象，并  且加入到  ConcreteMediator 对象的HashMap
      CoffeeMachine coffeeMachine = new CoffeeMachine(mediator,
            "coffeeMachine");
      
      //创建 Curtains , 并  且加入到  ConcreteMediator 对象的HashMap
      Curtains curtains = new Curtains(mediator, "curtains");
      TV tV = new TV(mediator, "TV");
      
      //让闹钟发出消息
      alarm.SendAlarm(0);
      coffeeMachine.FinishCoffee();
      alarm.SendAlarm(1);
   }
}
```



##  中介者模式注意事项

1) 多个类相互耦合，会形成网状结构, 使用中介者模式将网状结构分离为星型结构， 进行解耦 
2) 减少类间依赖，降低了耦合，符合迪米特原则 
3) 中介者承担了较多的责任，一旦中介者出现了问题，整个系统就会受到影响 
4) 如果设计不当，中介者对象本身变得过于复杂，这点在实际使用时，要特别注意



# 第22章 备忘录模式

##  游戏角色状态恢复问题

**游戏角色有攻击力和防御力，在大战Boss前保存自身的状态(攻击力和防御力)，当大 战Boss后攻击力和防御力下降，从备忘录对象恢复到大战前的状态**



##  传统方案解决游戏角色恢复

###  类图

<img src="images/image-20211225152917281.png" alt="image-20211225152917281" style="zoom:80%;" />

###  问题分析

1) 一个对象，就对应一个保存对象状态的对象， 这样当我们游戏的对象很多时，不 利于管理，开销也很大. 
2) 传统的方式是简单地做备份，new出另外一个对象出来，再把需要备份的数据放到 这个新对象，但这就暴露了对象内部的细节 
3) 解决方案： => 备忘录模式



##  备忘录模式

### 基本介绍

1) 备忘录模式（Memento Pattern）在不破坏封装性的前提下，捕获一个对象的内 部状态，并在该对象之外保存这个状态。这样以后就可将该对象恢复到原先保 存的状态 
2) 可以这里理解备忘录模式：现实生活中的备忘录是用来记录某些要去做的事情， 或者是记录已经达成的共同意见的事情，以防忘记了。而在软件层面，备忘录 模式有着相同的含义，备忘录对象主要用来记录一个对象的某种状态，或者某 些数据，当要做回退时，可以从备忘录对象里获取原来的数据进行恢复操作 
3) 备忘录模式属于行为型模式



###  类图

<img src="images/image-20211225153139788.png" alt="image-20211225153139788" style="zoom:80%;" />

**对原理类图的说明-即 (备忘录模式的角色及职责)**

-   originator : 对象(需要保存 状态的对象) 
-   Memento ： 备忘录对象,负责 保存好记录，即Originator内部 状态
-   Caretaker: 守护者对象,负责保存多个备忘录对象， 使用集合管理，提高效 率 
-   说明：如果希望保存多个originator对象的不同时间的状态，也可以，只需要 要 HashMap  



### 3 代码实现

#### 原始对象

```java
public class Originator {

   private String state;//状态信息

   public String getState() {
      return state;
   }

   public void setState(String state) {
      this.state = state;
   }
   
   //编写一个方法，可以保存一个状态对象 Memento
   //因此编写一个方法，返回 Memento
   public Memento saveStateMemento() {
      return new Memento(state);
   }
   
   //通过备忘录对象，恢复状态
   public void getStateFromMemento(Memento memento) {
      state = memento.getState();
   }
}
```

#### 备忘录对象

```java	
public class Memento {
	private String state;

	//构造器
	public Memento(String state) {
		super();
		this.state = state;
	}

	public String getState() {
		return state;
	}

}
```

#### 守护者对象

```java
public class Caretaker {
   
   //在List 集合中会有很多的备忘录对象
   private List<Memento> mementoList = new ArrayList<Memento>();
   
   public void add(Memento memento) {
      mementoList.add(memento);
   }
   
   //获取到第index个Originator 的 备忘录对象(即保存状态)
   public Memento get(int index) {
      return mementoList.get(index);
   }
}
```

#### 测试

```java
public class Client {
   public static void main(String[] args) {
      Originator originator = new Originator();
      Caretaker caretaker = new Caretaker();
      
      originator.setState(" 状态#1 攻击力 100 ");
      
      //保存了当前的状态
      caretaker.add(originator.saveStateMemento());
      
      originator.setState(" 状态#2 攻击力 80 ");
      
      caretaker.add(originator.saveStateMemento());
      
      originator.setState(" 状态#3 攻击力 50 ");
      caretaker.add(originator.saveStateMemento());
      
      System.out.println("当前的状态是 =" + originator.getState());
      
      //希望得到状态 1, 将 originator 恢复到状态1
      originator.getStateFromMemento(caretaker.get(0));
      System.out.println("恢复到状态1 , 当前的状态是");
      System.out.println("当前的状态是 =" + originator.getState());
   }
}
```

##  游戏角色恢复状态实例

### 应用实例

游戏角色有攻击力和防御力，在大战Boss前保存自身的状态(攻击力和防御力)，当大战 Boss后攻击力和防御力下降，从备忘录对象恢复到大战前的状态

###  类图

<img src="images/image-20211225160428013.png" alt="image-20211225160428013" style="zoom:80%;" />

### 代码实现

#### 要保存的状态

```java
public class GameRole {
   private int vit;
   private int def;
   
   //创建Memento ,即根据当前的状态得到Memento
   public Memento createMemento() {
      return new Memento(vit, def);
   }
   
   //从备忘录对象，恢复GameRole的状态
   public void recoverGameRoleFromMemento(Memento memento) {
      this.vit = memento.getVit();
      this.def = memento.getDef();
   }
   
   //显示当前游戏角色的状态
   public void display() {
      System.out.println("游戏角色当前的攻击力：" + this.vit + " 防御力: " + this.def);
   }

   public int getVit() {
      return vit;
   }

   public void setVit(int vit) {
      this.vit = vit;
   }

   public int getDef() {
      return def;
   }

   public void setDef(int def) {
      this.def = def;
   }
}
```

#### 备忘录

```java
public class Memento {
   //攻击力
   private int vit;
   //防御力
   private int def;
   public Memento(int vit, int def) {
      super();
      this.vit = vit;
      this.def = def;
   }
   public int getVit() {
      return vit;
   }
   public void setVit(int vit) {
      this.vit = vit;
   }
   public int getDef() {
      return def;
   }
   public void setDef(int def) {
      this.def = def;
   }
}
```

#### 守护者对象

```java
//守护者对象, 保存游戏角色的状态
public class Caretaker {
   //如果只保存一次状态
   private Memento  memento;
   //对GameRole 保存多次状态
   //private ArrayList<Memento> mementos;
   //对多个游戏角色保存多个状态
   //private HashMap<String, ArrayList<Memento>> rolesMementos;

   public Memento getMemento() {
      return memento;
   }

   public void setMemento(Memento memento) {
      this.memento = memento;
   }
}
```

#### 测试

```java
public class Client {
   public static void main(String[] args) {
      //创建游戏角色
      GameRole gameRole = new GameRole();
      gameRole.setVit(100);
      gameRole.setDef(100);
      
      System.out.println("和boss大战前的状态");
      gameRole.display();
      
      //把当前状态保存caretaker
      Caretaker caretaker = new Caretaker();
      caretaker.setMemento(gameRole.createMemento());
      
      System.out.println("和boss大战~~~");
      gameRole.setDef(30);
      gameRole.setVit(30);
      
      gameRole.display();
      
      System.out.println("大战后，使用备忘录对象恢复到站前");
      
      gameRole.recoverGameRoleFromMemento(caretaker.getMemento());
      System.out.println("恢复后的状态");
      gameRole.display();
   }
}
```



##  备忘录模式的注意事项和细节

1. 给用户提供了一种可以恢复状态的机制，可以使用户能够比较方便地回到某个历史 的状态 

2. 实现了信息的封装，使得用户不需要关心状态的保存细节 

3. 如果类的成员变量过多，势必会占用比较大的资源，而且每一次保存都会消耗一定 的内存, 这个需要注意

4. 适用的应用场景：

   1. 后悔药。

   2. 打游戏时的存档。 

   3. Windows 里的 ctrl + z。 

   4. IE 中的后退。 

   5. 数据库的事务管理

5. 为了节约内存，备忘录模式可以和原型模式配合使用



# 第23章 解释器模式

##  四则运算问题

**通过解释器模式来实现四则运算，如计算a+b-c的值，具体要求** 

1.  先输入表达式的形式，比如 a+b+c-d+e, 要求表达式的字母不能重复 

2. 在分别输入a ,b, c, d, e 的值 

3. 最后求出结果：如图

   <img src="images/image-20211225161142955.png" alt="image-20211225161142955" style="zoom:80%;" />



##  传统方案解决四则运算问题分析

1) 编写一个方法，接收表达式的形式，然后根据用户输入的数值进行解析，得到结果 
2)  问题分析：如果加入新的运算符，比如 * / ( 等等，不利于扩展，另外让一个方法来 解析会造成程序结构混乱，不够清晰. 
3) 解决方案：可以考虑使用解释器模式， 即： 表达式 -> 解释器(可以有多种) -> 结 果

##  解释器模式

### 基本介绍

1) 在编译原理中，一个算术表达式通过**词法分析器**形成词法单元，而后这些词法 单元再通过**语法分析器**构建语法分析树，最终形成一颗抽象的语法分析树。这 里的词法分析器和语法分析器都可以看做是解释器 

2) 解释器模式（Interpreter Pattern）：**是指给定一个语言(表达式)，定义它的文法 的一种表示，并定义一个解释器**，使用该**解释器来解释语言中的句子(表达式)** 

3) 应用场景 

   • 应用可以将一个需要解释执行的语言中的句子表示为一个抽象语法树 

   • 一些重复出现的问题可以用一种简单的语言来表达 

   • 一个简单语法需要解释的场景 

4) 这样的例子还有，比如编译器、运算表达式计算、正则表达式、机器人等



###  类图

<img src="images/image-20211225163321861.png" alt="image-20211225163321861" style="zoom:80%;" />

**对原理类图的说明-即(解释器模式的角色及职责)** 

1) Context: 是环境角色,含有解释器之外的全局信息. 
2)  AbstractExpression: 抽象表达式， 声明一个抽象的解释操作,这个方法为抽象语法树中所有的节点所 共享 
3) TerminalExpression: 为终结符表达式, 实现与文法中的终结符相关的解释操作 
4)  NonTermialExpression: 为非终结符表达式，为文法中的非终结符实现解释操作. 
5) 说明： 输入Context 和 TerminalExpression 信息通过Client 输入即可



##  解释器模式来实现四则运算

### 类图

<img src="images/image-20211225164449717.png" alt="image-20211225164449717" style="zoom:80%;" />

### 代码

####  抽象表达式

```java
//抽象类表达式，通过HashMap 键值对, 可以获取到变量的值
public abstract class Expression {
   // a + b - c
   // 解释公式和数值, key 就是公式(表达式) 参数[a,b,c], value就是就是具体值
   // HashMap {a=10, b=20}
   public abstract int interpreter(HashMap<String, Integer> var);
}
```

#### 抽象运算符号解释器

```java
/**
 * 抽象运算符号解析器 这里，每个运算符号，都只和自己左右两个数字有关系，
 * 但左右两个数字有可能也是一个解析的结果，无论何种类型，都是Expression类的实现类
 */
public class SymbolExpression extends Expression {
   protected Expression left;
   protected Expression right;

   public SymbolExpression(Expression left, Expression right) {
      this.left = left;
      this.right = right;
   }

   //因为 SymbolExpression 是让其子类来实现，因此 interpreter 是一个默认实现
   @Override
   public int interpreter(HashMap<String, Integer> var) {
      return 0;
   }
}
```

#### 变量解释器

```java
//变量的解释器
public class VarExpression extends Expression {
   private String key; // key=a,key=b,key=c

   public VarExpression(String key) {
      this.key = key;
   }

   // var 就是{a=10, b=20}
   // interpreter 根据 变量名称，返回对应值
   @Override
   public int interpreter(HashMap<String, Integer> var) {
      return var.get(this.key);
   }
}
```

#### 具体解释器

```java
public class AddExpression extends SymbolExpression  {
   public AddExpression(Expression left, Expression right) {
      super(left, right);
   }

   //处理相加
   //var 仍然是 {a=10,b=20}..
   //一会我们debug 源码,就ok
   public int interpreter(HashMap<String, Integer> var) {
      //super.left.interpreter(var) ： 返回 left 表达式对应的值 a = 10
      //super.right.interpreter(var): 返回right 表达式对应值 b = 20
      return super.left.interpreter(var) + super.right.interpreter(var);
   }
}
================================================================
public class SubExpression extends SymbolExpression {
	public SubExpression(Expression left, Expression right) {
		super(left, right);
	}

	//求出left 和 right 表达式相减后的结果
	public int interpreter(HashMap<String, Integer> var) {
		return super.left.interpreter(var) - super.right.interpreter(var);
	}
}    
```

#### 计算

```java
public class Calculator {

   // 定义表达式
   private Expression expression;

   // 构造函数传参，并解析
   public Calculator(String expStr) { // expStr = a+b
      // 安排运算先后顺序
      Stack<Expression> stack = new Stack<>();
      // 表达式拆分成字符数组 
      char[] charArray = expStr.toCharArray();// [a, +, b]

      Expression left = null;
      Expression right = null;
      //遍历我们的字符数组， 即遍历  [a, +, b]
      //针对不同的情况，做处理
      for (int i = 0; i < charArray.length; i++) {
         switch (charArray[i]) {
         case '+': //
            left = stack.pop();// 从stack取出left => "a"
            right = new VarExpression(String.valueOf(charArray[++i]));// 取出右表达式 "b"
            stack.push(new AddExpression(left, right));// 然后根据得到left 和 right 构建 AddExpresson加入stack
            break;
         case '-': // 
            left = stack.pop();
            right = new VarExpression(String.valueOf(charArray[++i]));
            stack.push(new SubExpression(left, right));
            break;
         default: 
            //如果是一个 Var 就创建要给 VarExpression 对象，并push到 stack
            stack.push(new VarExpression(String.valueOf(charArray[i])));
            break;
         }
      }
      //当遍历完整个 charArray 数组后，stack 就得到最后Expression
      this.expression = stack.pop();
   }

   public int run(HashMap<String, Integer> var) {
      //最后将表达式a+b和 var = {a=10,b=20}
      //然后传递给expression的interpreter进行解释执行
      return this.expression.interpreter(var);
   }
}
```

#### 测试

```java
public class ClientTest {
   public static void main(String[] args) throws IOException {
      String expStr = getExpStr(); // a+b
      HashMap<String, Integer> var = getValue(expStr);// var {a=10, b=20}
      Calculator calculator = new Calculator(expStr);
      System.out.println("运算结果：" + expStr + "=" + calculator.run(var));
   }

   // 获得表达式
   public static String getExpStr() throws IOException {
      System.out.print("请输入表达式：");
      return (new BufferedReader(new InputStreamReader(System.in))).readLine();
   }

   // 获得值映射
   public static HashMap<String, Integer> getValue(String expStr) throws IOException {
      HashMap<String, Integer> map = new HashMap<>();

      for (char ch : expStr.toCharArray()) {
         if (ch != '+' && ch != '-') {
            if (!map.containsKey(String.valueOf(ch))) {
               System.out.print("请输入" + String.valueOf(ch) + "的值：");
               String in = (new BufferedReader(new InputStreamReader(System.in))).readLine();
               map.put(String.valueOf(ch), Integer.valueOf(in));
            }
         }
      }

      return map;
   }
}
```

##  解释器模式在Spring框架应用的源码剖析

<img src="images/image-20211225214431690.png" alt="image-20211225214431690" style="zoom:80%;" />

```java
public class Interpreter {
	public static void main(String[] args) {
		//创建一个 Parser 对象
		SpelExpressionParser parser = new SpelExpressionParser();
		
		//通过 Parser 对象 获取到一个Expression对象
		//会根据不同的  Parser 对象 ，返回不同的 Expression对象
		Expression expression = parser.parseExpression("10 * (2 + 1) * 1 + 66"); //96
		int result = (Integer) expression.getValue();
		System.out.println(result);
	}
}
```

 说明 

- Expression 接口 表达式接口 

-  下面有不同的实现类，比如SpelExpression, 或者CompositeStringExpression。 

- 使用时候，根据你创建的不同的Parser 对象，返回不同的 Expression 对象 

  ```java
  public Expression parseExpression(String expressionString, ParserContext context) throws ParseException { 
      if (context == null) { 
          context = NON_TEMPLATE_PARSER_CONTEXT; 
      } 
      if (context.isTemplate()) { 
          return parseTemplate(expressionString, context); //返回的就是 CompositeStringExpression 
      } else { 
          return doParseExpression(expressionString, context); //返回的就是 SpelExpression 
      } 
  } 
  ```

  

  使用得当 Expression对象，调用getValue 解释执行 表达式，最后得到结果

## 解释器模式的注意事项和细节

1) 当有一个语言需要解释执行，可将该语言中的句子表示为一个抽象语法树，就可以 考虑使用解释器模式，让程序具有良好的扩展性 
2)  应用场景：编译器、运算表达式计算、正则表达式、机器人等 
3) 使用解释器可能带来的问题：解释器模式会引起类膨胀、解释器模式采用递归调用 方法，将会导致调试非常复杂、效率可能降低.



# 第24章 状态模式

## APP抽奖活动问题

**请编写程序完成APP抽奖活动 具 体要求如下:** 

1. 假如每参加一次这个活动要 扣除用户50积分，中奖概率 是10% 

2. 奖品数量固定，抽完就不能 抽奖 

3. 活动有四个状态: 可以抽奖、 不能抽奖、发放奖品和奖品 领完 

4.  活动的四个状态转换关系图 

   <img src="images/image-20211225215810784.png" alt="image-20211225215810784" style="zoom:80%;" />



## 状态模式

### 基本介绍

1) 状态模式（State Pattern）：它主要用来解决对象在多种状态转换时，需要对外 输出不同的行为的问题。状态和行为是一一对应的，状态之间可以相互转换 
2) 当一个**对象的内在状态改变时，允许改变其行为**，这个对象看起来像是改变了 其类



### 类图

<img src="images/image-20211225220001776.png" alt="image-20211225220001776" style="zoom:80%;" />

**对原理类图的说明-即(状态模式的角色及职责)**

1. Context 类为环境角色, 用于维护State实例,这个实例定义当前状态 
2. State 是抽象状态角色,定义一个接口封装与Context 的一个特点接口相关行为 
3. ConcreteState 具体的状态角色，每个子类实现一个与Context 的一个状态相关行为



## 状态模式解决APP抽奖问

### 类图

<img src="images/image-20211226152825431.png" alt="image-20211226152825431" style="zoom:80%;" />

### 代码实现

#### 状态抽象类

```java
//状态抽象类
public abstract class State {
   // 扣除积分 - 50
    public abstract void deductMoney();

    // 是否抽中奖品
    public abstract boolean raffle();

    // 发放奖品
    public abstract  void dispensePrize();
}
```

#### 抽奖活动

```java
//抽奖活动
public class RaffleActivity {
   // state 表示活动当前的状态，是变化
    State state = null;
    // 奖品数量
    int count = 0;
    
    // 四个属性，表示四种状态
    State noRafflleState = new NoRaffleState(this);
    State canRaffleState = new CanRaffleState(this);
    
    State dispenseState =   new DispenseState(this);
    State dispensOutState = new DispenseOutState(this);

    //构造器
    //1. 初始化当前的状态为 noRafflleState（即不能抽奖的状态）
    //2. 初始化奖品的数量 
    public RaffleActivity( int count) {
        this.state = getNoRafflleState();
        this.count = count;
    }

    //扣分, 调用当前状态的 deductMoney
    public void debuctMoney(){
        state.deductMoney();
    }

    //抽奖 
    public void raffle(){
       // 如果当前的状态是抽奖成功
        if(state.raffle()){
           //领取奖品
            state.dispensePrize();
        }
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    //这里请大家注意，每领取一次奖品，count--
    public int getCount() {
       int curCount = count; 
       count--;
        return curCount;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public State getNoRafflleState() {
        return noRafflleState;
    }

    public void setNoRafflleState(State noRafflleState) {
        this.noRafflleState = noRafflleState;
    }

    public State getCanRaffleState() {
        return canRaffleState;
    }

    public void setCanRaffleState(State canRaffleState) {
        this.canRaffleState = canRaffleState;
    }

    public State getDispenseState() {
        return dispenseState;
    }

    public void setDispenseState(State dispenseState) {
        this.dispenseState = dispenseState;
    }

    public State getDispensOutState() {
        return dispensOutState;
    }

    public void setDispensOutState(State dispensOutState) {
        this.dispensOutState = dispensOutState;
    }
}
```

#### 不能抽奖的状态

```java
//不能抽奖状态
public class NoRaffleState extends State {
    // 初始化时传入活动引用，扣除积分后改变其状态
    RaffleActivity activity;

    public NoRaffleState(RaffleActivity activity) {
        this.activity = activity;
    }

    // 当前状态可以扣积分 , 扣除后，将状态设置成可以抽奖状态
    @Override
    public void deductMoney() {
        System.out.println("扣除50积分成功，您可以抽奖了");
        activity.setState(activity.getCanRaffleState());
    }

    // 当前状态不能抽奖
    @Override
    public boolean raffle() {
        System.out.println("扣了积分才能抽奖喔！");
        return false;
    }

    // 当前状态不能发奖品
    @Override
    public void dispensePrize() {
        System.out.println("不能发放奖品");
    }
}
```

#### 可以抽奖的状态

```java
 //可以抽奖的状态
public class CanRaffleState extends State {
    RaffleActivity activity;

    public CanRaffleState(RaffleActivity activity) {
        this.activity = activity;
    }

    //已经扣除了积分，不能再扣
    @Override
    public void deductMoney() {
        System.out.println("已经扣取过了积分");
    }

    //可以抽奖, 抽完奖后，根据实际情况，改成新的状态
    @Override
    public boolean raffle() {
        System.out.println("正在抽奖，请稍等！");
        Random r = new Random();
        int num = r.nextInt(10);
        // 10%中奖机会
        if(num == 0){
            // 改变活动状态为发放奖品 context
            activity.setState(activity.getDispenseState());
            return true;
        }else{
            System.out.println("很遗憾没有抽中奖品！");
            // 改变状态为不能抽奖
            activity.setState(activity.getNoRafflleState());
            return false;
        }
    }

    // 不能发放奖品
    @Override
    public void dispensePrize() {
        System.out.println("没中奖，不能发放奖品");
    }
}
```

#### 发放奖品的状态

```java
//发放奖品的状态
public class DispenseState extends State {
    // 初始化时传入活动引用，发放奖品后改变其状态
    RaffleActivity activity;

    public DispenseState(RaffleActivity activity) {
        this.activity = activity;
    }

    @Override
    public void deductMoney() {
        System.out.println("不能扣除积分");
    }

    @Override
    public boolean raffle() {
        System.out.println("不能抽奖");
        return false;
    }

    //发放奖品
    @Override
    public void dispensePrize() {
        if(activity.getCount() > 0){
            System.out.println("恭喜中奖了");
            // 改变状态为不能抽奖
            activity.setState(activity.getNoRafflleState());
        }else{
            System.out.println("很遗憾，奖品发送完了");
            // 改变状态为奖品发送完毕, 后面我们就不可以抽奖
            activity.setState(activity.getDispensOutState());
            //System.out.println("抽奖活动结束");
            //System.exit(0);退出程序
        }
    }
}
```

#### 奖品发放完毕

```java
/**
 * 奖品发放完毕状态
 * 说明，当我们activity 改变成 DispenseOutState， 抽奖活动结束
 */
public class DispenseOutState extends State {
   // 初始化时传入活动引用
    RaffleActivity activity;

    public DispenseOutState(RaffleActivity activity) {
        this.activity = activity;
    }
    @Override
    public void deductMoney() {
        System.out.println("奖品发送完了，请下次再参加");
    }

    @Override
    public boolean raffle() {
        System.out.println("奖品发送完了，请下次再参加");
        return false;
    }

    @Override
    public void dispensePrize() {
        System.out.println("奖品发送完了，请下次再参加");
    }
}
```

#### 测试

```java
//状态模式测试类
public class ClientTest {
   public static void main(String[] args) {
      // 创建活动对象，奖品有1个奖品
        RaffleActivity activity = new RaffleActivity(1);

        // 我们连续抽300次奖
        for (int i = 0; i < 30; i++) {
            System.out.println("--------第" + (i + 1) + "次抽奖----------");
            // 参加抽奖，第一步点击扣除积分
            activity.debuctMoney();

            // 第二步抽奖
            activity.raffle();
        }
   }
}
```



## 状态模式在实际项目-借贷平台

### 需求

1) 借贷平台的订单，有审核-发布-抢单 等等 步骤，随着操作的不同，会改变订单的 状态, 项目中的这个模块实现就会使用到状态模 

2) 通常通过if/else判断订单的状态，从而实现不同的逻辑，伪代码如下

   <img src="images/image-20211226145945190.png" alt="image-20211226145945190" style="zoom:80%;" />

3) 使用状态模式完成 借贷平台项目的审核模块 [设计+代码]

   - 普通模式<img src="images/image-20211226150235263.png" alt="image-20211226150235263" style="zoom:80%;" />
   - 通过状态图实现<img src="images/image-20211226150424134.png" alt="image-20211226150424134" style="zoom:80%;" />

   
### 类图

   <img src="images/image-20211226150919281.png" alt="image-20211226150919281" style="zoom:80%;" />



### 代码实现

#### 状态接口

```java
//状态接口
public interface State {

    //电审
    void checkEvent(Context context);

     //电审失败
    void checkFailEvent(Context context);

    //定价发布
    void makePriceEvent(Context context);

   //接单
    void acceptOrderEvent(Context context);

   //无人接单失效
    void notPeopleAcceptEvent(Context context);

   //付款
    void payOrderEvent(Context context);

    //接单有人支付失效
    void orderFailureEvent(Context context);

   //反馈
    void feedBackEvent(Context context);
    
    String getCurrentState();
}
```

####    抽象类，默认实现state

```java
public abstract class AbstractState implements State {
   protected static final RuntimeException EXCEPTION = new RuntimeException("操作流程不允许");

   //抽象类，默认实现了 State 接口的所有方法
   //该类的所有方法，其子类(具体的状态类)，可以有选择的进行重写
   
    @Override
    public void checkEvent(Context context) {
        throw EXCEPTION;
    }

    @Override
    public void checkFailEvent(Context context) {
        throw EXCEPTION;
    }

    @Override
    public void makePriceEvent(Context context) {
        throw EXCEPTION;
    }

    @Override
    public void acceptOrderEvent(Context context) {
        throw EXCEPTION;
    }

    @Override
    public void notPeopleAcceptEvent(Context context) {
        throw EXCEPTION;
    }

    @Override
    public void payOrderEvent(Context context) {
        throw EXCEPTION;
    }

    @Override
    public void orderFailureEvent(Context context) {
        throw EXCEPTION;
    }

    @Override
    public void feedBackEvent(Context context) {
        throw EXCEPTION;
    }
}
```

#### 各种具体状态类

```java
//各种具体状态类
class FeedBackState extends AbstractState {

   @Override
   public String getCurrentState() {
      return StateEnum.FEED_BACKED.getValue();
   }
}

class GenerateState extends AbstractState {

   @Override
   public void checkEvent(Context context) {
      context.setState(new ReviewState());
   }

   @Override
   public void checkFailEvent(Context context) {
      context.setState(new FeedBackState());
   }

   @Override
   public String getCurrentState() {
      return StateEnum.GENERATE.getValue();
   }
}

class NotPayState extends AbstractState {

   @Override
   public void payOrderEvent(Context context) {
      context.setState(new PaidState());
   }

   @Override
   public void feedBackEvent(Context context) {
      context.setState(new FeedBackState());
   }

   @Override
   public String getCurrentState() {
      return StateEnum.NOT_PAY.getValue();
   }
}

class PaidState extends AbstractState {

   @Override
   public void feedBackEvent(Context context) {
      context.setState(new FeedBackState());
   }

   @Override
   public String getCurrentState() {
      return StateEnum.PAID.getValue();
   }
}

class PublishState extends AbstractState {

   @Override
   public void acceptOrderEvent(Context context) {
      //把当前状态设置为  NotPayState。。。
      //至于应该变成哪个状态，有流程图来决定
      context.setState(new NotPayState());
   }

   @Override
   public void notPeopleAcceptEvent(Context context) {
      context.setState(new FeedBackState());
   }

   @Override
   public String getCurrentState() {
      return StateEnum.PUBLISHED.getValue();
   }
}

class ReviewState extends AbstractState {

   @Override
   public void makePriceEvent(Context context) {
      context.setState(new PublishState());
   }

   @Override
   public String getCurrentState() {
      return StateEnum.REVIEWED.getValue();
   }

}
```

#### 环境上下文

```java
//环境上下文
public class Context extends AbstractState{
   //当前的状态 state, 根据我们的业务流程处理，不停的变化
   private State state;

    @Override
    public void checkEvent(Context context) {
        state.checkEvent(this);
        getCurrentState();
    }

    @Override
    public void checkFailEvent(Context context) {
        state.checkFailEvent(this);
        getCurrentState();
    }

    @Override
    public void makePriceEvent(Context context) {
        state.makePriceEvent(this);
        getCurrentState();
    }

    @Override
    public void acceptOrderEvent(Context context) {
        state.acceptOrderEvent(this);
        getCurrentState();
    }

    @Override
    public void notPeopleAcceptEvent(Context context) {
        state.notPeopleAcceptEvent(this);
        getCurrentState();
    }

    @Override
    public void payOrderEvent(Context context) {
        state.payOrderEvent(this);
        getCurrentState();
    }

    @Override
    public void orderFailureEvent(Context context) {
        state.orderFailureEvent(this);
        getCurrentState();
    }

    @Override
    public void feedBackEvent(Context context) {
        state.feedBackEvent(this);
        getCurrentState();
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public String getCurrentState() {
        System.out.println("当前状态 : " + state.getCurrentState());
        return state.getCurrentState();
    }
}
```

#### 测试

```java
public class ClientTest {
   public static void main(String[] args) {
      //创建context 对象
      Context context = new Context();
        //将当前状态设置为 PublishState
      context.setState(new PublishState());
        System.out.println(context.getCurrentState());
        
//        //publish --> not pay
        context.acceptOrderEvent(context);
//        //not pay --> paid
        context.payOrderEvent(context);
//        // 失败, 检测失败时，会抛出异常
//        try {
//         context.checkFailEvent(context);
//         System.out.println("流程正常..");
//    } catch (Exception e) {
//       // TODO: handle exception
//       System.out.println(e.getMessage());
//    }
        
   }
}
```



## 状态模式的注意事项和细节

1) 代码有很强的**可读性**。状态模式将每个状态的行为封装到对应的一个类中 
2)  **方便维护**。将容易产生问题的if-else语句删除了，如果把每个状态的行为都放到一 个类中，每次调用方法时都要判断当前是什么状态，不但会产出很多if-else语句， 而且容易出错 
3)  符合“开闭原则”。容易增删状态 
4) 会产生很多类。每个状态都要一个对应的类，当状态过多时会产生很多类，加大维 护难度 
5)  应用场景：==当一个事件或者对象有很多种状态，状态之间会相互转换，对不同的状 态要求有不同的行为的时候，可以考虑使用状态模式==



# 第25章 策略模式

##  鸭子问题

编写鸭子项目，具体要求如下: 

1) 有各种鸭子(比如 野鸭、北京鸭、水鸭等， 鸭子有各种行为，比如 叫、飞行等) 
2) 显示鸭子的信息

<img src="images/image-20211225220523239.png" alt="image-20211225220523239" style="zoom:80%;" />

## 传统方案解决鸭子问题

### 类图

<img src="images/image-20211226154014347.png" alt="image-20211226154014347" style="zoom:80%;" />

### 代码实现

#### 抽象类

```java
public abstract class Duck {

   public Duck() {
   }

   public abstract void display();//显示鸭子信息
   
   public void quack() {
      System.out.println("鸭子嘎嘎叫~~");
   }
   
   public void swim() {
      System.out.println("鸭子会游泳~~");
   }
   
   public void fly() {
      System.out.println("鸭子会飞翔~~~");
   }
   
}
```

#### 具体实现类

```java
public class PekingDuck extends Duck {
   @Override
   public void display() {
      System.out.println("~~北京鸭~~~");
   }
   
   //因为北京鸭不能飞翔，因此需要重写fly
   @Override
   public void fly() {
      System.out.println("北京鸭不能飞翔");
   }
}
==============================================
public class ToyDuck extends Duck{
	@Override
	public void display() {
		System.out.println("玩具鸭");
	}

	//需要重写父类的所有方法
	public void quack() {
		System.out.println("玩具鸭不能叫~~");
	}
	
	public void swim() {
		System.out.println("玩具鸭不会游泳~~");
	}
	
	public void fly() {
		System.out.println("玩具鸭不会飞翔~~~");
	}
}
===================================================
public class WildDuck extends Duck {
	@Override
	public void display() {
		System.out.println(" 这是野鸭 ");
	}
}    
```



### 问题分析

1) 其它鸭子，都继承了Duck类，所以fly让所有子类都会飞了，这是不正确的 
2)  上面说的1 的问题，其实是继承带来的问题：对类的局部改动，尤其超类的局部改 动，会影响其他部分。会有溢出效应 
3) 为了改进1问题，我们可以通过覆盖fly 方法来解决 => 覆盖解决 
4)  问题又来了，如果我们有一个玩具鸭子ToyDuck, 这样就需要ToyDuck去覆盖Duck 的所有实现的方法 => 解决思路 **策略模式** (strategy pattern)



##  策略模式

### 基本介绍

1) 策略模式（Strategy Pattern）中，定义算法族，分别封装起来，让他们之间可以 互相替换，此模式**让算法的变化独立于使用算法的客户** 
2) 这算法体现了几个设计原则，**第一、把变化的代码从不变的代码中分离出来； 第二、针对接口编程而不是具体类（定义了策略接口）；第三、多用组合/聚合， 少用继承（客户通过组合方式使用策略）。**



### 类图

<img src="images/image-20211225220735294.png" alt="image-20211225220735294" style="zoom:80%;" />

**说明：**

从上图可以看到，客户context 有成员变量strategy或者其他的策略接口 ,至于需要使用到哪个策略，我们可以在构造器中指定.



##   策略模式解决鸭子问题

### 类图

​	![image-20211226155850372](images/image-20211226155850372.png)

### 代码实现

#### 行为接口

```java
public interface FlyBehavior {
   void fly(); // 子类具体实现
}
======================================================
public interface QuackBehavior {
	void quack();//子类实现
}    
```

#### 行为实现类

```java
public class BadFlyBehavior implements FlyBehavior {
   @Override
   public void fly() {
      System.out.println(" 飞翔技术一般 ");
   }
}
==========================================================
public class GoodFlyBehavior implements FlyBehavior {
	@Override
	public void fly() {
		System.out.println(" 飞翔技术高超 ~~~");
	}
}
==========================================================
public class NoFlyBehavior implements FlyBehavior{
	@Override
	public void fly() {
		System.out.println(" 不会飞翔  ");
	}
}
```

#### 抽象鸭子类

```java
public abstract class Duck {
   //属性, 策略接口
   FlyBehavior flyBehavior;
   //其它属性<->策略接口
   QuackBehavior quackBehavior;
   
   public Duck() {
   }

   public abstract void display();//显示鸭子信息
   
   public void quack() {
      System.out.println("鸭子嘎嘎叫~~");
   }
   
   public void swim() {
      System.out.println("鸭子会游泳~~");
   }
   
   public void fly() {
      //改进
      if(flyBehavior != null) {
         flyBehavior.fly();
      }
   }

   public void setFlyBehavior(FlyBehavior flyBehavior) {
      this.flyBehavior = flyBehavior;
   }

   public void setQuackBehavior(QuackBehavior quackBehavior) {
      this.quackBehavior = quackBehavior;
   }
}
```

#### 具体鸭子类

```java
public class PekingDuck extends Duck {
   //假如北京鸭可以飞翔，但是飞翔技术一般
   public PekingDuck() {
      flyBehavior = new BadFlyBehavior();
   }
   
   @Override
   public void display() {
      System.out.println("~~北京鸭~~~");
   }
}
==========================================================
public class ToyDuck extends Duck{
	public ToyDuck() {
		flyBehavior = new NoFlyBehavior();
	}
	
	@Override
	public void display() {
		System.out.println("玩具鸭");
	}

	//需要重写父类的所有方法
	
	public void quack() {
		System.out.println("玩具鸭不能叫~~");
	}
	
	public void swim() {
		System.out.println("玩具鸭不会游泳~~");
	}
}
==========================================================
public class WildDuck extends Duck {
	//构造器，传入FlyBehavor 的对象
	public  WildDuck() {
		flyBehavior = new GoodFlyBehavior();
	}

	@Override
	public void display() {
		System.out.println(" 这是野鸭 ");
	}
}    
```

#### 测试

```java
public class Client {
   public static void main(String[] args) {
      WildDuck wildDuck = new WildDuck();
      wildDuck.fly();//
      
      ToyDuck toyDuck = new ToyDuck();
      toyDuck.fly();
      
      PekingDuck pekingDuck = new PekingDuck();
      pekingDuck.fly();
      
      //动态改变某个对象的行为, 北京鸭 不能飞
      pekingDuck.setFlyBehavior(new NoFlyBehavior());
      System.out.println("北京鸭的实际飞翔能力");
      pekingDuck.fly();
   }
}
```



##  策略模式在JDK-Arrays 应用的源码分析

<img src="images/image-20211225220920806.png" alt="image-20211225220920806" style="zoom:80%;" />

### 代码实现

```java
public class Strategy {
   public static void main(String[] args) {
      //数组
      Integer[] data = { 9, 1, 2, 8, 4, 3 };
      // 实现降序排序，返回-1放左边，1放右边，0保持不变
      
      // 说明
      // 1. 实现了 Comparator 接口（策略接口） , 匿名类 对象 new Comparator<Integer>(){..}
      // 2. 对象 new Comparator<Integer>(){..} 就是实现了 策略接口 的对象
      // 3. public int compare(Integer o1, Integer o2){} 指定具体的处理方式
      Comparator<Integer> comparator = new Comparator<Integer>() {
         public int compare(Integer o1, Integer o2) {
            if (o1 > o2) {
               return -1;
            } else {
               return 1;
            }
         };
      };
      
      // 说明
      /*
       * public static <T> void sort(T[] a, Comparator<? super T> c) {
              if (c == null) {
                  sort(a); //默认方法
              } else { 
                  if (LegacyMergeSort.userRequested)
                      legacyMergeSort(a, c); //使用策略对象c
                  else
                     // 使用策略对象c
                      TimSort.sort(a, 0, a.length, c, null, 0, 0);
              }
          }
       */
      //方式1 
      Arrays.sort(data, comparator);
      System.out.println(Arrays.toString(data)); // 降序排序

      
      //方式2- 同时lambda 表达式实现 策略模式
      Integer[] data2 = { 19, 11, 12, 18, 14, 13 };
      
      Arrays.sort(data2, (var1, var2) -> {
         if(var1.compareTo(var2) > 0) {
            return -1;
         } else {
            return 1;
         }
      });
      
      System.out.println("data2=" + Arrays.toString(data2));
   }
}
```

## 策略模式注意事项和细节

1) 策略模式的关键是：分析项目中**变化部分与不变部分** 
2) 策略模式的核心思想是：**多用组合/聚合 少用继承**；用行为类组合，而不是行为的 继承。更有弹性 
3)  体现了“对修改关闭，对扩展开放”原则，客户端增加行为不用修改原有代码，只 要添加一种策略（或者行为）即可，避免了使用多重转移语句（if..else if..else） 
4) 提供了可以替换继承关系的办法： 策略模式将算法封装在独立的Strategy类中使得 你可以独立于其Context改变它，使它易于切换、易于理解、易于扩展 
5) 需要注意的是：==每添加一个策略就要增加一个类，当策略过多是会导致类数目庞大==



# 第26章 职责链模式

## OA系统采购审批需求

**学校OA系统的采购审批项目：需求是**

1) 采购员采购教学器材 
2) 如果金额 小于等于5000, 由教学主任审批 （0<=x<=5000） 
3)  如果金额 小于等于10000, 由院长审批 (5000<x<=10000)
4) 如果金额 小于等于30000, 由副校长审批 (10000<x<=30000)
5) 如果金额 超过30000以上，有校长审批 ( 30000<x)



## 传统方案解决OA系统审批

<img src="images/image-20211226190749675.png" alt="image-20211226190749675" style="zoom:80%;" />

### 问题分析

1) 传统方式是：接收到一个采购请求后，根据采购金额来调用对应的Approver (审批 人)完成审批。 
2)  传统方式的问题分析 : 客户端这里会使用到 分支判断(比如 switch) 来对不同的采 购请求处理， 这样就存在如下问题 
   -  如果各个级别的人员审批金额发生变化，在 客户端的也需要变化 
   -  客户端必须明确的知道 有多少个审批级别和访问 
3)  这样 对一个采购请求进行处理 和 Approver (审批人) 就存在强耦合关系，不利于代 码的扩展和维护 
4)  解决方案 =》 职责链模式



##  职责链模式

### 基本介绍

1. 职责链模式（Chain of Responsibility Pattern）,  又叫 责任链模式，为请求创建了一个==接收者 对象的链==(简单示意图)。这种模式对请求的 发送者和接收者进行解耦。 

   <img src="images/image-20211226191041219.png" alt="image-20211226191041219" style="zoom:80%;" />

2. 职责链模式通常每个接收者都包含对另一个接 收者的引用。如果一个对象不能处理该请求， 那么它会把相同的请求传给下一个接收者，依 此类推。 

3) 这种类型的设计模式属于==行为型模式==



### 类图

![image-20211225221556864](images/image-20211225221556864.png)

**职责链模式（Chain Of Responsibility）**， 使多个对象都有机会处理请求，从而避 免请求的发送者和接收者之间的耦合关 系。将这个对象连成一条链，并沿着这 条链传递该请求，直到有一个对象处理 它为止

**对原理类图的说明-即(职责链模式的角色及职责)** 

1) Handler : 抽象的处理者, 定义了一个处理请求的接口, 同时含义另外Handler 
2)  ConcreteHandlerA , B 是具体的处理者, 处理它自己负责的请求， 可以访问它的后继者(即下一个处 理者), 如果可以处理当前请求，则处理，否则就将该请求交个 后继者去处理，从而形成一个职责链 
3)  Request ， 含义很多属性，表示一个请求



##  职责链模式解决OA系统采购审批

### 类图

<img src="images/image-20211226192242868.png" alt="image-20211226192242868" style="zoom:80%;" />

### 代码

#### 请求类

```java
public class PurchaseRequest {
   private int type = 0; //请求类型
   private float price = 0.0f; //请求金额
   private int id = 0;
   //构造器
   public PurchaseRequest(int type, float price, int id) {
      this.type = type;
      this.price = price;
      this.id = id;
   }
   public int getType() {
      return type;
   }
   public float getPrice() {
      return price;
   }
   public int getId() {
      return id;
   }
}
```

#### 抽象类

```java
public abstract class Approver {
   Approver approver;  //下一个处理者
   String name; // 名字
   
   public Approver(String name) {
      this.name = name;
   }

   //下一个处理者
   public void setApprover(Approver approver) {
      this.approver = approver;
   }
   
   //处理审批请求的方法，得到一个请求, 处理是子类完成，因此该方法做成抽象
   public abstract void processRequest(PurchaseRequest purchaseRequest);
}
```

#### 具体处理者

```java
//系主任
public class DepartmentApprover extends Approver {
   public DepartmentApprover(String name) {
      super(name);
   }
   
   @Override
   public void processRequest(PurchaseRequest purchaseRequest) {
      if(purchaseRequest.getPrice() <= 5000) {
         System.out.println(" 请求编号 id= " + purchaseRequest.getId() + " 被 " + this.name + " 处理");
      }else {
         approver.processRequest(purchaseRequest);
      }
   }
}
===========================================================================
 //院长
 public class CollegeApprover extends Approver {
	public CollegeApprover(String name) {
		super(name);
	}
	
	@Override
	public void processRequest(PurchaseRequest purchaseRequest) {
		if(purchaseRequest.getPrice() < 5000 && purchaseRequest.getPrice() <= 10000) {
			System.out.println(" 请求编号 id= " + purchaseRequest.getId() + " 被 " + this.name + " 处理");
		}else {
			approver.processRequest(purchaseRequest);
		}
	}
}
===========================================================================
//副校长  
public class CollegeApprover extends Approver {
	public CollegeApprover(String name) {
		super(name);
	}
	
	@Override
	public void processRequest(PurchaseRequest purchaseRequest) {
		if(purchaseRequest.getPrice() < 5000 && purchaseRequest.getPrice() <= 10000) {
			System.out.println(" 请求编号 id= " + purchaseRequest.getId() + " 被 " + this.name + " 处理");
		}else {
			approver.processRequest(purchaseRequest);
		}
	}
}    
===========================================================================
//正校长
public class SchoolMasterApprover extends Approver {
	public SchoolMasterApprover(String name) {
		super(name);
	}
	
	@Override
	public void processRequest(PurchaseRequest purchaseRequest) {
		if(purchaseRequest.getPrice() > 30000) {
			System.out.println(" 请求编号 id= " + purchaseRequest.getId() + " 被 " + this.name + " 处理");
		}else {
			approver.processRequest(purchaseRequest);
		}
	}
}    
```

#### 测试

```java
public class Client {
   public static void main(String[] args) {
      //创建一个请求
      PurchaseRequest purchaseRequest = new PurchaseRequest(1, 31000, 1);
      
      //创建相关的审批人
      DepartmentApprover departmentApprover = new DepartmentApprover("张主任");
      CollegeApprover collegeApprover = new CollegeApprover("李院长");
      ViceSchoolMasterApprover viceSchoolMasterApprover = new ViceSchoolMasterApprover("王副校");
      SchoolMasterApprover schoolMasterApprover = new SchoolMasterApprover("佟校长");
   
      //需要将各个审批级别的下一个设置好 (处理人构成环形: )
      departmentApprover.setApprover(collegeApprover);
      collegeApprover.setApprover(viceSchoolMasterApprover);
      viceSchoolMasterApprover.setApprover(schoolMasterApprover);
      schoolMasterApprover.setApprover(departmentApprover);//链接到主任 形成环路
      
      departmentApprover.processRequest(purchaseRequest);
      viceSchoolMasterApprover.processRequest(purchaseRequest);
   }
}
```



## 职责链模式在SpringMVC框架应用的源

![image-20211226194301026](images/image-20211226194301026.png)

**说明** 

- springmvc 请求的流程图中，执行了 拦截器相关方法 interceptor.preHandler 等等 
- 在处理SpringMvc请求时，使用到职责链模式还使用到适配器模式 
- HandlerExecutionChain 主要负责的是请求拦截器的执行和请求处理,但是他本身不 处理请求，只是将请求分配给链上注册处理器执行，这是职责链实现方式,减少职责 链本身与处理逻辑之间的耦合,规范了处理流程 
-  HandlerExecutionChain 维护了 HandlerInterceptor 的集合， 可以向其中注册相应 的拦截器.

##  职责链模式的注意事项和细节

1) 将**请求**和**处理**分开，实现解耦，提高系统的灵活性 
2) 简化了对象，使对象不需要知道链的结构 
3) 性能会受到影响，特别是在**链比较长的时候**，因此需控制链中最大节点数量，一般 ==通过在Handler中设置一个最大节点数量==，在setNext()方法中判断是否已经超过阀值， 超过则不允许该链建立，避免出现超长链无意识地破坏系统性能 
4) 调试不方便。采用了类似递归的方式，调试时逻辑可能比较复杂 
5) 最佳应用场景：有多个对象可以处理同一个请求时，比如：多级请求、请假/加薪 等审批流程、Java Web中Tomcat对Encoding的处理、拦截器

## SpringMVC中dodispatch方法执行步骤

![image-20211226195659997](images/image-20211226195659997.png)









