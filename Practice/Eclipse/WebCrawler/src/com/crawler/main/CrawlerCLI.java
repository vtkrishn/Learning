package src.com.crawler.main;

//import com.gargoylesoftware.htmlunit.WebClient;
//import com.gargoylesoftware.htmlunit.html.HtmlPage;
//
//public class CrawlerCLI {
//	
//	/**
//	 * Usage
//	 * java com.crawler.main.CrawlerCLI [site address] [search query - label]
//	 * @param args
//	 */
//	public static void main(String[] args) {
//		String query = "v2mibosc";
//		String URL_String = "http://prctools.oraclecorp.com/farmjango/details/?farm_id=&dte_id=&topology=All&env_type=All&job_type=SMC&release=rel13&alive=All&run_status=COMPLETED&dep_label="+ query +"&base_label=&job_alias=";
//		
//			WebClient client = new WebClient();  
//			client.getOptions().setCssEnabled(true);  
//			client.getOptions().setJavaScriptEnabled(true);  
//			try {  
//				  HtmlPage page = client.getPage(URL_String);
//				  System.out.println(page.asText());
//				  
//				}catch(Exception e){
//				  e.printStackTrace();
//				}	
//			
//			
//		
//	}
}
