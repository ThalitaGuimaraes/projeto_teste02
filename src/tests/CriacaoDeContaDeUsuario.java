package tests;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CriacaoDeContaDeUsuario {

	@Test
	public void test() {

		System.setProperty("webdriver.chrome.driver", "c:\\drivers\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://testesoftware1-001-site1.etempurl.com/exercicios/tarefa02");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//*[@id=\"Nome\"]")).sendKeys("Ana Maria");
		driver.findElement(By.xpath("//*[@id=\"Email\"]")).sendKeys("anamaria@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"Senha\"]")).sendKeys("@Teste123");
		driver.findElement(By.xpath("//*[@id=\"SenhaConfirmacao\"]")).sendKeys("@Teste123");
		
		driver.findElement(By.xpath("//*[@id=\"btnCadastro\"]")).click();
		
		String mensagem = driver.findElement(By.xpath("//*[@id=\"mensagem\"]")).getText();
		assertEquals(mensagem, "Conta de usuário cadastrada com sucesso.");
		
		try {
			
			File arquivo = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(arquivo, new File("Evidência - Criação de conta de usuário.png"));	
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
