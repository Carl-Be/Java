// Carl Bechie
// CIS 279
// HW 7

package filters;

import java.io.FileWriter; 

import java.util.Date;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestFilter implements Filter{

	
	public void init(FilterConfig filterConfig) throws ServletException {

	}


	public void doFilter(ServletRequest request, ServletResponse response,
	    FilterChain chain) throws IOException, ServletException {

		HttpServletRequest  httpRequest  = (HttpServletRequest)  request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		Date date = new Date(); // get the date and time 
		String page = httpRequest.getRequestURI();// Get the request URI
		String logRequest = String.format("%tc %s\n", date, page); // format date and time
		
		FileWriter writeFile = null; // create FileWriter object
		
		try { // try to write to file
			
			writeFile = new FileWriter("request_log.txt", true); // Open the log file to addend the new log to the file
			writeFile.write(logRequest); // write to the file
			writeFile.close(); // close the file 
			
		}catch(IOException e) { // Catch any IOException the try throws 
			
			e.printStackTrace(); // Print the error
		}
			
		
		chain.doFilter(request, response); // go to next filter
		
	} // public void doFilter(ServletRequest request, ServletResponse response,
		
	public void destroy() {
	
	}
}
