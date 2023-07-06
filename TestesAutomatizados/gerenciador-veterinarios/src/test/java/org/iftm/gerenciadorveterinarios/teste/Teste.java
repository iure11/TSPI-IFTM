package org.iftm.gerenciadorveterinarios.teste;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class Teste {

    @Test
    @DisplayName("Testar se a cadastrar veterinário")
    public void testarCadastrarVeterinário() {
        WebDriver driver = new ChromeDriver();

        driver.get("http://localhost:8080/form");

        WebElement nome = driver.findElement(By.name("nome"));
        WebElement email = driver.findElement(By.name("email"));
        WebElement especialidade = driver.findElement(By.name("especialidade"));
        WebElement salario = driver.findElement(By.name("salario"));

        WebElement submitForm = driver.findElement(By.xpath("/html/body/div[2]/form/div[2]/button"));

        nome.sendKeys("Iure");
        email.sendKeys("iure@iftm.com");
        especialidade.sendKeys("pequenos portes");
        salario.sendKeys("2000");
        submitForm.submit();

    }

    @Test
    @DisplayName("Testar pesquisar veterinário")
    public void testarPequisarVeterinario() {
        WebDriver driver = new ChromeDriver();

        driver.get("http://localhost:8080/find");

        WebElement pesquisarNome = driver.findElement(By.name("nome"));

        pesquisarNome.sendKeys("Iure");

        WebElement submitConsultar = driver.findElement(By.xpath("/html/body/div[2]/form/div[2]/button"));

        submitConsultar.submit();

        WebElement tabela = driver.findElement(By.className("table"));

        List<WebElement> linhas = tabela.findElements(By.tagName("tr"));

        boolean encontrado = false;

        for (WebElement linha : linhas) {
            List<WebElement> colunas = linha.findElements(By.tagName("td"));

            if (colunas.size() > 0) {
                String nome = colunas.get(0).getText();
                String especialidade = colunas.get(1).getText();
                String email = colunas.get(2).getText();
                String salario = colunas.get(3).getText();

                if (nome.equals("Iure") && especialidade.equals("pequenos portes") &&
                        email.equals("iure@iftm.com") && salario.equals("R$2000.00")) {
                    encontrado = true;
                    break;
                }
            }
        }

        assertTrue(encontrado);


    }

    @Test
    @DisplayName("Testar se exclui veterinário")
    public void testarExcluirVeterinario() {
        WebDriver driver = new ChromeDriver();

        driver.get("http://localhost:8080/home");

        WebElement excluirButton = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr[3]/td[5]/a[2]"));

        excluirButton.click();
    }


}


