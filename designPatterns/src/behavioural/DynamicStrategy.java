package behavioural;

import java.util.List;

enum OutputFormat {
    MARKDOWN, HTML;
}

/*
Markdown
* listItem1
* listItem2

HTML
<ul><li></li></ul>
 */
interface ListStrategy {
    default void start(StringBuilder sb) {
    }

    void addListItem(StringBuilder sb, String item);

    default void end(StringBuilder sb) {
    }
}

class MarkDownListStrategy implements ListStrategy {
    @Override
    public void addListItem(StringBuilder sb, String item) {
        sb.append(" * ").append(item).append(System.lineSeparator());
    }
}

class HtmlListStrategy implements ListStrategy {
    @Override
    public void start(StringBuilder sb) {
        sb.append("<ul>").append(System.lineSeparator());
    }

    @Override
    public void addListItem(StringBuilder sb, String item) {
        sb.append(" <li>").append(item).append("</li>").append(System.lineSeparator());
    }

    @Override
    public void end(StringBuilder sb) {
        sb.append("</ul>").append(System.lineSeparator());
    }
}

class TextProcessor {
    private StringBuilder sb = new StringBuilder();
    private ListStrategy listStrategy;

    public TextProcessor(OutputFormat format) {
        setOutputFormat(format);
    }

    public void setOutputFormat(OutputFormat format) {
        switch (format) {
            case HTML:
                listStrategy = new HtmlListStrategy();
                break;
            case MARKDOWN:
                listStrategy = new MarkDownListStrategy();
                break;
        }
    }

    public void appendList(List<String> items) {
        listStrategy.start(sb);
        for (String item : items) {
            listStrategy.addListItem(sb, item);
        }
        listStrategy.end(sb);
    }

    public void clear() {
        sb.setLength(0);
    }

    @Override
    public String toString() {
        return sb.toString();
    }
}

public class DynamicStrategy {
    public static void main(String[] args) {
        TextProcessor tp = new TextProcessor(OutputFormat.MARKDOWN);
        tp.appendList(List.of("a", "b", "c"));
        System.out.println(tp);
        tp.clear();
        tp.setOutputFormat(OutputFormat.HTML);
        tp.appendList(List.of("p", "q", "r"));
        System.out.println(tp);
    }
}
