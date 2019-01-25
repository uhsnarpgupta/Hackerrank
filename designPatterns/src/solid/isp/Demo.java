package solid.isp;

interface Machine {
    void print(Document d);

    void fax(Document d) throws Exception;

    void scan(Document d);
}

interface Printer {
    public void print(Document d);
}

interface Scanner {
    public void scan(Document d);
}

interface Fax {
    public void fax(Document d);
}

interface MultiFunctionDevice extends Printer, Scanner {
}

/*
Interface Segregation Principle :
Don't put much into an interface split into separate interfaces
YAGNI = You Ain;t Going to Need It
 */
class Document {

}

class MultiFunctionPrinter implements Machine {
    @Override
    public void print(Document d) {
        //
    }

    @Override
    public void fax(Document d) {
        //
    }

    @Override
    public void scan(Document d) {
        //
    }
}

//YAGNI = You Ain't Going To Need It

class OldFashionedPrinter implements Machine {
    @Override
    public void print(Document d) {
        //
    }

    @Override
    public void fax(Document d) throws Exception {
        throw new Exception();
    }

    @Override
    public void scan(Document d) {

    }
}

class JustAPrinter implements Printer {
    @Override
    public void print(Document d) {
        //
    }
}

class Photocopier implements Printer, Scanner {
    @Override
    public void print(Document d) {
        //
    }

    @Override
    public void scan(Document d) {
        //
    }
}

class MultiFunctionMachine implements MultiFunctionDevice {
    private Printer printer;
    private Scanner scanner;

    public MultiFunctionMachine(Printer printer, Scanner scanner) {
        this.printer = printer;
        this.scanner = scanner;
    }

    @Override
    public void print(Document d) {
        printer.print(d);
    }

    @Override
    public void scan(Document d) {
        scanner.scan(d);
    }
}

public class Demo {
}
