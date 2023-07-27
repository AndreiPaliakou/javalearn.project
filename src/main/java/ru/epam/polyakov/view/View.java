package ru.epam.polyakov.view;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * Class for rendering html files with template pattern substitutions
 * 
 */
public abstract class View {
	
	private static final Logger logger = Logger.getLogger(View.class.getName());
	
	/**
	 * 
	 * Open and get html template text or empty String from template file
	 * 
	 * @param tmplPath path to html template file to open 
	 * @return String text of html template or empty String if file not opened
	 */
	public String openHtmlTemplate(String tmplPath) {
		
		byte[] tmplText = new byte[64 * 1024];
		String templateText;

		try (InputStream stream = getClass().getClassLoader().getResourceAsStream(tmplPath)) {
			stream.read(tmplText);
			templateText = new String(tmplText, StandardCharsets.UTF_8);
		} catch (IOException e) {
			logger.log(Level.SEVERE, "Error reading template file!");
			return "";
		}
		
		return templateText;
		
	}
	
	/**
	 * 
	 * Add formatted html text to character stream
	 * 
	 * @param html text for adding into output stream
	 * @throws IOException when error writing to character stream
	 */
	public abstract void render(String text) throws IOException;
	
	/**
	 * 
	 * Add giving objects to html list or return empty string
	 * 
	 * @param objects to add in html list
	 * @return html list of objects or empty string if non-objects
	 */
	String addObjectsToHTMLList(Object... objects) {
		StringBuilder htmlList = new StringBuilder();
		
		if (objects == null || objects.length == 0) {
			return "";
		}
		
		htmlList.append("<ol>")
				.append(System.lineSeparator());
			
		for (Object object : objects) {
			htmlList.append("<li>")
					.append(object)
					.append("</li>")
					.append(System.lineSeparator());
		}
			
		
		htmlList.append("</ol>")
				.append(System.lineSeparator());
		
		return htmlList.toString();		
	}
	
	/**
	 * 
	 * Add data objects to template and return filled template
	 * 
	 * @param templateText template text
	 * @param tmplPattern pattern in text template that should be changed
	 * @param data objects to insert in template
	 * @return text from filled template or empty String
	 */
	String setDataToTemplateText(String templateText, String tmplPattern, Object... data) {

		if (data != null && data.length > 0) {
			templateText = replaceHtmlTemplate(templateText, tmplPattern, data);
		}			

		return templateText;
	}
	
	
	/**
	 * 
	 * Replace html template text on pattern with given string representation of objects. If quantity of changes in
	 * html template text is more than given objects it'll change the other text pattern to empty string.
	 * 
	 * @param htmlTemplateText text representation of html file
	 * @param pattern to find in html template text to change
	 * @param data objects to insert in html template text instead pattern
	 * @return Changed string html template text from pattern to objects or empty string
	 */
	private String replaceHtmlTemplate(String htmlTemplateText, String pattern, Object... data) {

		Matcher matcher = Pattern.compile(pattern).matcher(htmlTemplateText);

		int i = 0;

		while (matcher.find()) {

			if (data.length - 1 >= i) {
				htmlTemplateText = matcher.replaceFirst(data[i].toString());
			} else {
				htmlTemplateText = matcher.replaceFirst("");
			}
			matcher.reset(htmlTemplateText);
			i++;
		}
		
		return htmlTemplateText;

	}
	
}
