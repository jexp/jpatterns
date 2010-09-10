package org.jpatterns.gof;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Alex Gout
 * @since 2010-09-10
 */
public class DecoratorTest {
  @DecoratorPattern.Component(participants = HTMLDecorator.class)
  private static interface HTMLContent {
    String getContent();
  }

  @DecoratorPattern.ConcreteComponent
  private static class SimpleHTMLContent implements HTMLContent {

    private String content;

    private SimpleHTMLContent(String _content) {
      this.content = _content;
    }

    public String getContent() {
      return this.content;
    }
  }

  @DecoratorPattern.Decorator(participants = HTMLContent.class)
  private static abstract class HTMLDecorator implements HTMLContent {
    protected HTMLContent htmlContent;


    protected HTMLDecorator(HTMLContent _content) {
      this.htmlContent = _content;
    }

    public String getContent() {
      return getStartTag() + this.htmlContent.getContent() + getEndTag();

    }

    protected final String getStartTag() {
      return "<" + getTag() + ">";
    }

    protected final String getEndTag() {
      return "</" + getTag() + ">";
    }

    protected abstract String getTag();


  }

  @DecoratorPattern.ConcreteDecorator
  private static class BoldDecorator extends HTMLDecorator {
    protected BoldDecorator(HTMLContent _content) {
      super(_content);
    }


    @Override
    protected String getTag() {
      return "strong";
    }
  }

  @DecoratorPattern.ConcreteDecorator
  private static class SpanDecorator extends HTMLDecorator {
    protected SpanDecorator(HTMLContent _content) {
      super(_content);
    }

    @Override
    protected String getTag() {
      return "span";
    }
  }

  @Test
  public void testBoldSpanText() {
    HTMLContent content = new SimpleHTMLContent("Hello JPatterns!!");
    content = new BoldDecorator(content);
    content = new SpanDecorator(content);

    assertEquals("<span><strong>Hello JPatterns!!</strong></span>", content.getContent());
    System.out.println(content.getContent());
  }

}
