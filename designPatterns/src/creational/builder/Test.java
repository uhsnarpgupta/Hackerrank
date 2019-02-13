package creational.builder;

import java.util.ArrayList;
import java.util.List;

/*
A creational.builder is a separate component for building an object
Can either give creational.builder a constructor or return it via a static function
To make creational.builder fluent, return this
Different facets of an object can be built with different builders working in tandem via a base class
 */
class Field {
    public String type, name;

    public Field(String name, String type) {
        this.type = type;
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("public %s %s;", type, name);
    }
}

class Class {
    public String name;
    public List<Field> fields = new ArrayList<>();

    public Class() {
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String nl = System.lineSeparator();
        sb.append("public class " + name).append(nl)
                .append("{").append(nl);
        for (Field f : fields)
            sb.append("  " + f).append(nl);
        sb.append("}").append(nl);
        return sb.toString();
    }
}

class CodeBuilder {
    private Class theClass = new Class();

    public CodeBuilder(String rootName) {
        theClass.name = rootName;
    }

    public CodeBuilder addField(String name, String type) {
        theClass.fields.add(new Field(name, type));
        return this;
    }

    @Override
    public String toString() {
        return theClass.toString();
    }
}


/*
OUTPUT:
public class Person
{
  public String name;
  public int age;
}
 */
public class Test {
    public static void main(String[] args) {
        CodeBuilder cb = new CodeBuilder("Person")
                .addField("name", "String")
                .addField("age", "int");
        System.out.println(cb);
    }
}
