package eql.kkl.HotelDatabase;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class PageHotel {

	@FindBy(xpath = "//select[@name='ville']")
	WebElement liste_ville;

	@FindBy(xpath = "//select[@name='ville']/option[$a]")
	WebElement villes_options;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement button_submit;

	@FindBy(xpath = "//table")
	WebElement tableau;

	public List<String> parcourirListe() {

        Select listeVilles = new Select(liste_ville);
        List <WebElement> op = listeVilles.getOptions();
        int size = op.size();
    List<String> options = new ArrayList<String>();
        for(int i =1; i<size ; i++){
           options.add(op.get(i).getText());
           
          }
//    System.out.println(options);
        return options;
    }

//	public void listeVilles() {
//		
//	
//		final Collection<String> mainList = Arrays.asList("Paris", "Londres", "New York", "Tokyo");
//        final AtomicInteger idx = new AtomicInteger(0);
//        final int size = 1;
//
//        // Partition a list into list of lists size 3
//        final Collection<List<String>> rows = mainList.stream()
//                .collect(Collectors.groupingBy(
//                        it -> idx.getAndIncrement() / size
//                ))
//                .values();
//
//        // Write each row in the new line as a string
//        final String result = rows.stream()
//                .map(row -> String.join(",", row))
//                .collect(Collectors.joining("\n"));
//
//        System.out.println(result);
//};

	public void selectVille(int a) {

		Select selVille = new Select(liste_ville);

		selVille.selectByIndex(a);
		button_submit.click();

	}

//	public void parcourirTableau(WebDriver driver) {
//
//		List<WebElement> rows = tableau.findElements(By.tagName("tr"));
//		ArrayList<String> list = new ArrayList<>();
//				
//		for (WebElement row : rows) {
//			if (row.getText().toString() != null) {
//				System.out.println(row.getText().trim());
//				list.add(row.getText().trim());
//			}
//		}
//	}
	
	public List<String> parcourirTableau1(WebDriver driver) {
		
        List<WebElement> allRows = tableau.findElements(By.tagName("tr"));
        List<String> result = new ArrayList<>();
        // And iterate over them, getting the cells
        for (WebElement row : allRows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            // Print the contents of each cell
            for (WebElement cell : cells) {
                result.add(cell.getText());
            }
        }
        System.out.println(result);
        return result;
	}
	public List<String> csvLire(String a) throws Exception {
    Scanner sc = new Scanner(new File(a));
    List<String> fileCSV = new ArrayList<>();
    while (sc.hasNext())// returns a boolean value
    {
        fileCSV.add(sc.nextLine());
        }
    return fileCSV;
	}
	
	
}
