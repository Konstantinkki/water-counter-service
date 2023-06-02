package com.konstantin.watercounter;

import com.konstantin.watercounter.apiClient.ConnectToPublicPage;
import java.io.IOException;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class WatercounterApplication {


	public static void main(String[] args) throws IOException {
		ConfigurableApplicationContext context = SpringApplication.run(WatercounterApplication.class, args);


		Connection.Response loginForm = Jsoup.connect("https://billing.vodokanal.kharkov.ua/login")
				.method(Connection.Method.GET)
				.execute();

		String username = "Kastey";
		String password = "ptHdDfb2j4";

		Document document = Jsoup.connect("https://billing.vodokanal.kharkov.ua/login")
				.ignoreHttpErrors(true)
				//.data("_csrf-frontend", "hCYXsRwzow9mnxMFjjnG6t0yi2AXaAVfeliCenTXQa3rQEPyLmLgfQvNIHXbD46vi3zZASc_dh4RLNAdGrJw9Q==")
				.data("_csrf-frontend", loginForm.parse().getElementsByAttributeValue("name","csrf-token").attr("content"))
				.data("LoginForm[_csrf-frontend]", loginForm.parse().getElementsByAttributeValue("name","csrf-token").attr("content"))
				.data("LoginForm[username]", username)
				.data("LoginForm[password]", password)
				.cookies(loginForm.cookies())
				.timeout(50000)
				//.headers(loginForm.headers())
				//.referrer("https://billing.vodokanal.kharkov.ua/login")
				//.data("origin", "https://billing.vodokanal.kharkov.ua")
				//.data("host", "billing.vodokanal.kharkov.ua")
				//.data("Cookie", "_ga=GA1.3.2080903486.1685372102; _gid=GA1.3.423174202.1685707917; _csrf-frontend=5311ce53a6f77c3e69aff7ad310bdccfba24e5c1279414629a746319724046d3a%3A2%3A%7Bi%3A0%3Bs%3A14%3A%22_csrf-frontend%22%3Bi%3A1%3Bs%3A32%3A%22ofTC2QCrmR3pU6HEVNRa0WsAktRgne1X%22%3B%7D; lang=ef6f1678fec327adb831551c6e941c0e3b95e34a541634dcaf4b89e591e78c58a%3A2%3A%7Bi%3A0%3Bs%3A4%3A%22lang%22%3Bi%3A1%3BO%3A14%3A%22yii%5Cweb%5CCookie%22%3A7%3A%7Bs%3A4%3A%22name%22%3Bs%3A4%3A%22lang%22%3Bs%3A5%3A%22value%22%3BO%3A14%3A%22yii%5Cweb%5CCookie%22%3A7%3A%7Bs%3A4%3A%22name%22%3Bs%3A4%3A%22lang%22%3Bs%3A5%3A%22value%22%3Bs%3A5%3A%22ru-RU%22%3Bs%3A6%3A%22domain%22%3Bs%3A0%3A%22%22%3Bs%3A6%3A%22expire%22%3BN%3Bs%3A4%3A%22path%22%3Bs%3A1%3A%22%2F%22%3Bs%3A6%3A%22secure%22%3Bb%3A0%3Bs%3A8%3A%22httpOnly%22%3Bb%3A1%3B%7Ds%3A6%3A%22domain%22%3Bs%3A0%3A%22%22%3Bs%3A6%3A%22expire%22%3BN%3Bs%3A4%3A%22path%22%3Bs%3A1%3A%22%2F%22%3Bs%3A6%3A%22secure%22%3Bb%3A0%3Bs%3A8%3A%22httpOnly%22%3Bb%3A1%3B%7D%7D; advanced-frontend=9com1l5gic8k4qt7k50t3hiu9t")
				.userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36")
				.followRedirects(true)
				.post();
		System.out.println(document);


	/*	Connection.Response response =
				Jsoup.connect("https://billing.vodokanal.kharkov.ua/login")
						.userAgent("Mozilla/5.0")
						.timeout(10 * 1000)
						.method(Connection.Method.POST)
						.data("txtloginid", "YOUR_LOGINID")
						.data("txtloginpassword", "YOUR_PASSWORD")
						.data("random", "123342343")
						.data("task", "login")
						.data("destination", "/welcome")
						.followRedirects(true)
						.execute();

		//parse the document from response
		Document doc = response.parse();*/


/*		ConnectToPublicPage connectToPublicPage = context.getBean(ConnectToPublicPage.class);

		connectToPublicPage.connect();
		//Document loginDocument = connectToPublicPage.login();
		connectToPublicPage.login2();*/









	/*	Document doc = null;
		try {*/

/*
		doc = Jsoup.connect("https://billing.vodokanal.kharkov.ua/login").get();


		doc.select("p").forEach(System.out::println);
		*/

		/*Connection.Response loginForm = Jsoup.connect("https://billing.vodokanal.kharkov.ua/login")
				.method(Connection.Method.GET)
				.execute();


		Document document = Jsoup.connect("https://www.desco.org.bd/ebill/authentication.php")
				.data("cookieexists", "false")
				.data("username", "32007702")
				.data("login", "Login")
				.cookies(loginForm.cookies())
				.post();
		System.out.println(document);

		} catch (IOException e) {
			throw new RuntimeException(e);
		}*/

	}

}
