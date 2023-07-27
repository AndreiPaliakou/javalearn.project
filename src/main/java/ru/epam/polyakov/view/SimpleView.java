package ru.epam.polyakov.view;

import java.io.IOException;
import java.io.Writer;

public class SimpleView extends View {
	
	/**
	 * 
	 * Default pattern value in template files for simple text adding
	 * 
	 */
	private static final String DEFAULT_TEMPLATE_TEXT_PATTERN = "\\$\\{value\\}";
	
	/**
	 * 
	 * Default pattern value in template files for html complex constructions adding
	 * 
	 */
	private static final String DEFAULT_TEMPLATE_COMPLEX_PATTERN = "\\$\\{complex_value\\}";

	private Writer writer;

	public SimpleView() {
	}

	@Override
	public void render(String text) throws IOException {
		writer.write(text);
	}

	/**
	 * 
	 * Add simple text to template
	 * 
	 * @param tmplText template text
	 * @param data objects to add to template
	 * @return Sting text of changed template or template without text patterns
	 */
	public String addSimpleTextToTemplate(String tmplText, Object... data) {

		return setDataToTemplateText(tmplText, DEFAULT_TEMPLATE_TEXT_PATTERN, data);

	}
	
	/**
	 * 
	 * Add simple list html text to template
	 * 
	 * @param tmplText template text
	 * @param data objects to add to template as html list
	 * @return Sting text of changed template or template without text patterns
	 */
	public String addListTextToTemplate(String tmplText, Object... data) {
		
		String templateText = addObjectsToHTMLList(data);

		return setDataToTemplateText(tmplText, DEFAULT_TEMPLATE_COMPLEX_PATTERN, templateText);

	}	

	public void setWriter(Writer writer) {
		this.writer = writer;
	}

}
