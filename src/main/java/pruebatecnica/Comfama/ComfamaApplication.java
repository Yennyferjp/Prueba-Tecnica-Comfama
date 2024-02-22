package pruebatecnica.Comfama;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

@SpringBootApplication(exclude =  {DataSourceAutoConfiguration.class })
public class ComfamaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComfamaApplication.class, args);
//		try{
//
//			URL url = new URL("https://api.jikan.moe/v4/anime?q=animes&sfw");
//			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//			connection.setRequestMethod("GET");
//			connection.connect();
//
//			int responseCode = connection.getResponseCode();
//			if(responseCode == 200) {
//				StringBuilder info = new StringBuilder();
//				Scanner scanner = new Scanner(url.openStream());
//
//				while(scanner.hasNextLine()) {
//                    info.append(scanner.nextLine());
//                }
//				scanner.close();
//				System.out.println(info);
//			} else {
//                throw new RuntimeException("Ha ocurrido un error: " + responseCode);
//            }
//
//		} catch(Exception e){
//			e.printStackTrace();
//		}
	}

}
